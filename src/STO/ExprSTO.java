package STO;//---------------------------------------------------------------------
// CSE 131 Reduced-C Compiler Project
// Copyright (C) 2008-2015 Garo Bournoutian and Rick Ord
// University of California, San Diego
//---------------------------------------------------------------------

import types.Type;

public class ExprSTO extends STO
{
	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public ExprSTO(String strName)
	{
		super(strName);
        // You may want to change the isModifiable and isAddressable
        // fields as necessary
		setModLValue();
	}

	public ExprSTO(String strName, Type typ)
	{
		super(strName, typ);
        // You may want to change the isModifiable and isAddressable
        // fields as necessary
		setModLValue();
	}

	public ExprSTO(String strName, Type typ, boolean address, boolean mod)
	{
		super(strName, typ);
		// You may want to change the isModifiable and isAddressable
		// fields as necessary
		setIsAddressable(address);
		setIsModifiable(mod);
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public boolean isExpr()
	{
		return true;
	}
}
