package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class AInterfaceFileType extends PFileType
{
    private TInterface _interface_;

    public AInterfaceFileType()
    {
    }

    public AInterfaceFileType(
        TInterface _interface_)
    {
        setInterface(_interface_);

    }
    public Object clone()
    {
        return new AInterfaceFileType(
            (TInterface) cloneNode(_interface_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInterfaceFileType(this);
    }

    public TInterface getInterface()
    {
        return _interface_;
    }

    public void setInterface(TInterface node)
    {
        if(_interface_ != null)
        {
            _interface_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _interface_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_interface_);
    }

    void removeChild(Node child)
    {
        if(_interface_ == child)
        {
            _interface_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_interface_ == oldChild)
        {
            setInterface((TInterface) newChild);
            return;
        }

    }
}
