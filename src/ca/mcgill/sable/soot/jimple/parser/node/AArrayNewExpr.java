package ca.mcgill.sable.soot.jimple.parser.node;

import java.util.*;
import ca.mcgill.sable.util.*;
import java.util.*;
import ca.mcgill.sable.soot.jimple.parser.analysis.*;

public final class AArrayNewExpr extends PNewExpr
{
    private TNewarray _newarray_;
    private TLParen _lParen_;
    private PNonvoidType _nonvoidType_;
    private TRParen _rParen_;
    private PFixedArrayDescriptor _fixedArrayDescriptor_;

    public AArrayNewExpr()
    {
    }

    public AArrayNewExpr(
        TNewarray _newarray_,
        TLParen _lParen_,
        PNonvoidType _nonvoidType_,
        TRParen _rParen_,
        PFixedArrayDescriptor _fixedArrayDescriptor_)
    {
        setNewarray(_newarray_);

        setLParen(_lParen_);

        setNonvoidType(_nonvoidType_);

        setRParen(_rParen_);

        setFixedArrayDescriptor(_fixedArrayDescriptor_);

    }
    public Object clone()
    {
        return new AArrayNewExpr(
            (TNewarray) cloneNode(_newarray_),
            (TLParen) cloneNode(_lParen_),
            (PNonvoidType) cloneNode(_nonvoidType_),
            (TRParen) cloneNode(_rParen_),
            (PFixedArrayDescriptor) cloneNode(_fixedArrayDescriptor_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAArrayNewExpr(this);
    }

    public TNewarray getNewarray()
    {
        return _newarray_;
    }

    public void setNewarray(TNewarray node)
    {
        if(_newarray_ != null)
        {
            _newarray_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _newarray_ = node;
    }

    public TLParen getLParen()
    {
        return _lParen_;
    }

    public void setLParen(TLParen node)
    {
        if(_lParen_ != null)
        {
            _lParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lParen_ = node;
    }

    public PNonvoidType getNonvoidType()
    {
        return _nonvoidType_;
    }

    public void setNonvoidType(PNonvoidType node)
    {
        if(_nonvoidType_ != null)
        {
            _nonvoidType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _nonvoidType_ = node;
    }

    public TRParen getRParen()
    {
        return _rParen_;
    }

    public void setRParen(TRParen node)
    {
        if(_rParen_ != null)
        {
            _rParen_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rParen_ = node;
    }

    public PFixedArrayDescriptor getFixedArrayDescriptor()
    {
        return _fixedArrayDescriptor_;
    }

    public void setFixedArrayDescriptor(PFixedArrayDescriptor node)
    {
        if(_fixedArrayDescriptor_ != null)
        {
            _fixedArrayDescriptor_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _fixedArrayDescriptor_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_newarray_)
            + toString(_lParen_)
            + toString(_nonvoidType_)
            + toString(_rParen_)
            + toString(_fixedArrayDescriptor_);
    }

    void removeChild(Node child)
    {
        if(_newarray_ == child)
        {
            _newarray_ = null;
            return;
        }

        if(_lParen_ == child)
        {
            _lParen_ = null;
            return;
        }

        if(_nonvoidType_ == child)
        {
            _nonvoidType_ = null;
            return;
        }

        if(_rParen_ == child)
        {
            _rParen_ = null;
            return;
        }

        if(_fixedArrayDescriptor_ == child)
        {
            _fixedArrayDescriptor_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_newarray_ == oldChild)
        {
            setNewarray((TNewarray) newChild);
            return;
        }

        if(_lParen_ == oldChild)
        {
            setLParen((TLParen) newChild);
            return;
        }

        if(_nonvoidType_ == oldChild)
        {
            setNonvoidType((PNonvoidType) newChild);
            return;
        }

        if(_rParen_ == oldChild)
        {
            setRParen((TRParen) newChild);
            return;
        }

        if(_fixedArrayDescriptor_ == oldChild)
        {
            setFixedArrayDescriptor((PFixedArrayDescriptor) newChild);
            return;
        }

    }
}
