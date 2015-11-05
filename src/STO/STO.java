package STO;//---------------------------------------------------------------------
// CSE 131 Reduced-C Compiler Project
// Copyright (C) 2008-2015 Garo Bournoutian and Rick Ord
// University of California, San Diego
//---------------------------------------------------------------------

import types.Type;

public abstract class STO
{
	private String m_strName;
	private Type m_type;
	private boolean m_isAddressable;
	private boolean m_isModifiable;
	private boolean m_isReference = false;
	private boolean m_isThis = false;


	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public STO(String strName)
	{
		this(strName, null);
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public STO(String strName, Type typ)
	{
		setName(strName);
		setType(typ);
		setIsAddressable(false);
		setIsModifiable(false);
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public String getName()
	{
		return m_strName;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	private void setName(String str)
	{
		m_strName = str;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public Type getType()
	{
		return m_type;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public void setType(Type type)
	{
		m_type = type;
	}

	//----------------------------------------------------------------
	// Addressable refers to if the object has an address. Variables
	// and declared constants have an address, whereas results from 
	// expression like (x + y) and literal constants like 77 do not 
	// have an address.
	//----------------------------------------------------------------
	public boolean getIsAddressable()
	{
		return m_isAddressable;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public void setIsAddressable(boolean addressable)
	{
		m_isAddressable = addressable;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public boolean getIsModifiable()
	{
		return m_isModifiable;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public void setIsModifiable(boolean modifiable)
	{
		m_isModifiable = modifiable;
	}


	public void setModLValue() {
		setIsAddressable(true);
		setIsModifiable(true);
	}

	public void setNonModLValue() {
		setIsAddressable(true);
		setIsModifiable(false);
	}

	public void setRValue() {
		setIsAddressable(false);
		setIsModifiable(false);
	}


	public void setIsThis() { m_isThis = true; }
	public boolean isThis() { return m_isThis; }

	public void setReference() {
		m_isReference = true;
	}

	public boolean isReference() {
		return m_isReference;
	}
	//----------------------------------------------------------------
	// A modifiable L-value is an object that is both addressable and
	// modifiable. Objects like constants are not modifiable, so they 
	// are not modifiable L-values.
	//----------------------------------------------------------------
	public boolean isModLValue()
	{
		return getIsModifiable() && getIsAddressable();
	}
	public boolean isNonModLValue() { return !getIsModifiable() && getIsAddressable(); }
	public boolean isRValue() { return !getIsModifiable() && !getIsAddressable(); }
	//----------------------------------------------------------------
	//	It will be helpful to ask a STO what specific STO it is.
	//	The Java operator instanceof will do this, but these methods 
	//	will allow more flexibility (ErrorSTO is an example of the
	//	flexibility needed).
	//----------------------------------------------------------------
	public boolean isVar() { return false; }
	public boolean isConst() { return false; }
	public boolean isExpr() { return false; }
	public boolean isFunc() { return false; }
	public boolean isStructdef() { return false; }
	public boolean isError() { return false; }
	public void setNegative() {
		if (this instanceof ConstSTO && ((ConstSTO) this).hasValue()) {
			((ConstSTO) this).makeValueNegative();
		}
	}
}
