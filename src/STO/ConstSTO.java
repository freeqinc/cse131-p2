package STO;//---------------------------------------------------------------------
// CSE 131 Reduced-C Compiler Project
// Copyright (C) 2008-2015 Garo Bournoutian and Rick Ord
// University of California, San Diego
//---------------------------------------------------------------------

import types.Type;

import java.math.BigDecimal;

public class ConstSTO extends STO
{
    //----------------------------------------------------------------
    //	Constants have a value, so you should store them here.
    //	Note: We suggest using Java's BigDecimal class, which can hold
    //	floats and ints. You can then do .floatValue() or 
    //	.intValue() to get the corresponding value based on the
    //	type. Booleans/Ptrs can easily be handled by ints.
    //	Feel free to change this if you don't like it!
    //----------------------------------------------------------------
    private BigDecimal	m_value;

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public ConstSTO(String strName)
	{
		super(strName);
		m_value = null; // fix this
		// You may want to change the isModifiable and isAddressable
		// fields as necessary
		setNonModLValue();
	}

	public ConstSTO(String strName, Type typ)
	{
		super(strName, typ);
		m_value = null; // fix this
		// You may want to change the isModifiable and isAddressable
		// fields as necessary
		setNonModLValue();
	}

	public ConstSTO(String strName, Type typ, BigDecimal val)
	{
		super(strName, typ);
		m_value = val;
		// You may want to change the isModifiable and isAddressable
		// fields as necessary
		setNonModLValue();
	}

	public ConstSTO(String strName, Type typ, int val)
	{
		super(strName, typ);
		m_value = new BigDecimal(val);
		// You may want to change the isModifiable and isAddressable
		// fields as necessary
		setNonModLValue();
	}

	public ConstSTO(String strName, Type typ, double val)
	{
		super(strName, typ);
		m_value = new BigDecimal(val);
		// You may want to change the isModifiable and isAddressable
		// fields as necessary
		setNonModLValue();
	}

	public ConstSTO(String strName, Type typ, boolean val)
	{
		super(strName, typ);
		if (val) {
			m_value = new BigDecimal(1);
		} else {
			m_value = new BigDecimal(0);
		}
		// You may want to change the isModifiable and isAddressable
		// fields as necessary
		setNonModLValue();
	}



	public void setLiteral() {
		setRValue();
	}
	public void makeValueNegative() {
		if (hasValue()) {
			m_value = m_value.multiply(new BigDecimal(-1));
		}
	}
	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public boolean isConst() 
	{
		return true;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public BigDecimal getValue() 
	{
		return m_value;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public int getIntValue() 
	{
		return m_value.intValue();
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public float getFloatValue() 
	{
		return m_value.floatValue();
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public boolean getBoolValue() 
	{
		return !BigDecimal.ZERO.equals(m_value);
	}

	public boolean hasValue() { return m_value != null; }
}
