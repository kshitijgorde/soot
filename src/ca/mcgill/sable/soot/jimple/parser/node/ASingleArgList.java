package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class ASingleArgList extends PArgList
{
    private PImmediate _immediate_;

    public ASingleArgList()
    {
    }

    public ASingleArgList(
        PImmediate _immediate_)
    {
        setImmediate(_immediate_);

    }
    public Object clone()
    {
        return new ASingleArgList(
            (PImmediate) cloneNode(_immediate_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASingleArgList(this);
    }

    public PImmediate getImmediate()
    {
        return _immediate_;
    }

    public void setImmediate(PImmediate node)
    {
        if(_immediate_ != null)
        {
            _immediate_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _immediate_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_immediate_);
    }

    void removeChild(Node child)
    {
        if(_immediate_ == child)
        {
            _immediate_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_immediate_ == oldChild)
        {
            setImmediate((PImmediate) newChild);
            return;
        }

    }
}
