package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class TCmplt extends Token
{
    public TCmplt()
    {
        super.setText("<");
    }

    public TCmplt(int line, int pos)
    {
        super.setText("<");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TCmplt(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTCmplt(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TCmplt text.");
    }
}
