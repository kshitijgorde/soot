/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Jimple, a 3-address code Java(TM) bytecode representation.        *
 * Copyright (C) 1997, 1998 Raja Vallee-Rai (kor@sable.mcgill.ca)    *
 * All rights reserved.                                              *
 *                                                                   *
 * Modifications by Patrick Lam (plam@sable.mcgill.ca) are           *
 * Copyright (C) 1999 Patrick Lam.  All rights reserved.             *
 *                                                                   *
 * This work was done as a project of the Sable Research Group,      *
 * School of Computer Science, McGill University, Canada             *
 * (http://www.sable.mcgill.ca/).  It is understood that any         *
 * modification not identified as such is not covered by the         *
 * preceding statement.                                              *
 *                                                                   *
 * This work is free software; you can redistribute it and/or        *
 * modify it under the terms of the GNU Library General Public       *
 * License as published by the Free Software Foundation; either      *
 * version 2 of the License, or (at your option) any later version.  *
 *                                                                   *
 * This work is distributed in the hope that it will be useful,      *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of    *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU *
 * Library General Public License for more details.                  *
 *                                                                   *
 * You should have received a copy of the GNU Library General Public *
 * License along with this library; if not, write to the             *
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,      *
 * Boston, MA  02111-1307, USA.                                      *
 *                                                                   *
 * Java is a trademark of Sun Microsystems, Inc.                     *
 *                                                                   *
 * To submit a bug report, send a comment, or get the latest news on *
 * this project and other Sable Research Group projects, please      *
 * visit the web site: http://www.sable.mcgill.ca/                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

/*
 Reference Version
 -----------------
 This is the latest official version on which this file is based.

 Change History
 --------------
 A) Notes:

 Please use the following template.  Most recent changes should
 appear at the top of the list.

 - Modified on [date (March 1, 1900)] by [name]. [(*) if appropriate]
   [description of modification].

 Any Modification flagged with "(*)" was done as a project of the
 Sable Research Group, School of Computer Science,
 McGill University, Canada (http://www.sable.mcgill.ca/).

 You should add your copyright, using the following template, at
 the top of this file, along with other copyrights.

 *                                                                   *
 * Modifications by [name] are                                       *
 * Copyright (C) [year(s)] [your name (or company)].  All rights     *
 * reserved.                                                         *
 *                                                                   *

 B) Changes:

 - Modified on February 3, 1999 by Patrick Lam (plam@sable.mcgill.ca) (*)
   Added changes in support of the Grimp intermediate
   representation (with aggregated-expressions).

 - Modified on November 2, 1998 by Raja Vallee-Rai (kor@sable.mcgill.ca) (*)
   Repackaged all source files and performed extensive modifications.
   First initial release of Soot.

 - Modified on 15-Jun-1998 by Raja Vallee-Rai (kor@sable.mcgill.ca). (*)
   First internal release (Version 0.1).
*/

package ca.mcgill.sable.soot.jimple;

import ca.mcgill.sable.soot.*;
import ca.mcgill.sable.util.*;
import java.util.*;

public class JTableSwitchStmt extends AbstractStmt implements TableSwitchStmt
{
    UnitBox defaultTargetBox;
    ValueBox keyBox;
    int lowIndex;
    int highIndex;
    UnitBox[] targetBoxes;

    List stmtBoxes;

    // This method is necessary to deal with constructor-must-be-first-ism.
    private static UnitBox[] getTargetBoxesArray(List targets)
    {
        UnitBox[] targetBoxes = new UnitBox[targets.size()];

        for(int i = 0; i < targetBoxes.length; i++)
            targetBoxes[i] = Jimple.v().newStmtBox((Stmt) targets.get(i));

        return targetBoxes;
    }

    JTableSwitchStmt(Value key, int lowIndex, int highIndex, List targets, Unit defaultTarget)
    {
        this(Jimple.v().newImmediateBox(key), lowIndex, highIndex, 
             getTargetBoxesArray(targets), 
             Jimple.v().newStmtBox(defaultTarget));
    }

    protected JTableSwitchStmt(ValueBox keyBox, int lowIndex, int highIndex, 
                               UnitBox[] targetBoxes, UnitBox defaultTargetBox)
    {
        this.keyBox = keyBox;
        this.defaultTargetBox = defaultTargetBox;

        this.lowIndex = lowIndex;
        this.highIndex = highIndex;

        this.targetBoxes = targetBoxes;

        // Build up stmtBoxes
        {
            stmtBoxes = new ArrayList();

            for(int i = 0; i < targetBoxes.length; i++)
                stmtBoxes.add(targetBoxes[i]);

            stmtBoxes.add(defaultTargetBox);
            stmtBoxes = Collections.unmodifiableList(stmtBoxes);
        }
    }

    protected String toString(boolean isBrief, Map stmtToName, String indentation)
    {
        StringBuffer buffer = new StringBuffer();
        String endOfLine = (indentation.equals("")) ? " " : "\n";
        
        buffer.append(indentation + "tableswitch(" + ((isBrief) ? ((ToBriefString) keyBox.getValue()).toBriefString() :
            keyBox.getValue().toString()) + ")" + endOfLine);
            
        buffer.append(indentation + "{" + endOfLine);
        
        for(int i = lowIndex; i <= highIndex; i++)
        {
            buffer.append(indentation + "    case " + i + ": goto " + (String) stmtToName.get(getTarget(i - lowIndex)) + ";" + endOfLine);
        }

        buffer.append(indentation + "    default: goto " + (String) stmtToName.get(getDefaultTarget()) + ";" + endOfLine);
        buffer.append(indentation + "}");

        return buffer.toString();
    }

    public Unit getDefaultTarget()
    {
        return defaultTargetBox.getUnit();
    }

    public void setDefaultTarget(Unit defaultTarget)
    {
        defaultTargetBox.setUnit(defaultTarget);
    }

    public UnitBox getDefaultTargetBox()
    {
        return defaultTargetBox;
    }

    public Value getKey()
    {
        return keyBox.getValue();
    }

    public void setKey(Value key)
    {
        keyBox.setValue(key);
    }

    public ValueBox getKeyBox()
    {
        return keyBox;
    }

    public void setLowIndex(int lowIndex)
    {
        this.lowIndex = lowIndex;
    }

    public void setHighIndex(int highIndex)
    {
        this.highIndex = highIndex;
    }

    public int getLowIndex()
    {
        return lowIndex;
    }

    public int getHighIndex()
    {
        return highIndex;
    }

    public List getTargets()
    {
        List targets = new ArrayList();

        for(int i = 0; i < targetBoxes.length; i++)
            targets.add(targetBoxes[i].getUnit());

        return targets;
    }

    public Unit getTarget(int index)
    {
        return targetBoxes[index].getUnit();
    }

    public void setTarget(int index, Unit target)
    {
        targetBoxes[index].setUnit(target);
    }

    public void setTargets(List targets)
    {
        for(int i = 0; i < targets.size(); i++)
            targetBoxes[i].setUnit((Stmt) targets.get(i));
    }

    public UnitBox getTargetBox(int index)
    {
        return targetBoxes[index];
    }

    public List getUseBoxes()
    {
        List list = new ArrayList();

        list.addAll(keyBox.getValue().getUseBoxes());
        list.add(keyBox);

        return list;
    }

    public List getUnitBoxes()
    {
        return stmtBoxes;
    }

    public void apply(Switch sw)
    {
        ((StmtSwitch) sw).caseTableSwitchStmt(this);
    }
    
    public void convertToBaf(JimpleToBafContext context, List out)
    {
    }
}


