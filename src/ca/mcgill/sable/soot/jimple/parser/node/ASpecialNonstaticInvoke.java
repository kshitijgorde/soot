package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class ASpecialNonstaticInvoke extends PNonstaticInvoke
{
    private TSpecialinvoke _specialinvoke_;

    public ASpecialNonstaticInvoke()
    {
    }

    public ASpecialNonstaticInvoke(
        TSpecialinvoke _specialinvoke_)
    {
        setSpecialinvoke(_specialinvoke_);

    }
    public Object clone()
    {
        return new ASpecialNonstaticInvoke(
            (TSpecialinvoke) cloneNode(_specialinvoke_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASpecialNonstaticInvoke(this);
    }

    public TSpecialinvoke getSpecialinvoke()
    {
        return _specialinvoke_;
    }

    public void setSpecialinvoke(TSpecialinvoke node)
    {
        if(_specialinvoke_ != null)
        {
            _specialinvoke_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _specialinvoke_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_specialinvoke_);
    }

    void removeChild(Node child)
    {
        if(_specialinvoke_ == child)
        {
            _specialinvoke_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_specialinvoke_ == oldChild)
        {
            setSpecialinvoke((TSpecialinvoke) newChild);
            return;
        }

    }
}
