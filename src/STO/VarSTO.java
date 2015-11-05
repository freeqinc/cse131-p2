package STO;//---------------------------------------------------------------------
// CSE 131 Reduced-C Compiler Project
// Copyright (C) 2008-2015 Garo Bournoutian and Rick Ord
// University of California, San Diego
//---------------------------------------------------------------------

import types.Type;

public class VarSTO extends STO
{
	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public VarSTO(String strName)
	{
		super(strName);
		// You may want to change the isModifiable and isAddressable 
		// fields as necessary
		setModLValue();
	}

	public VarSTO(String strName, Type typ)
	{
		super(strName, typ);
		// You may want to change the isModifiable and isAddressable 
		// fields as necessary
		setModLValue();
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public boolean isVar() 
	{
		return true;
	}
}
