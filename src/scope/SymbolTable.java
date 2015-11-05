package scope;//---------------------------------------------------------------------
// CSE 131 Reduced-C Compiler Project
// Copyright (C) 2008-2015 Garo Bournoutian and Rick Ord
// University of California, San Diego
//---------------------------------------------------------------------

import STO.FuncSTO;
import STO.STO;

import java.util.*;

public class SymbolTable
{
	private Stack<Scope> m_stkScopes;
	private int m_nLevel;
	private Scope m_scopeGlobal;
	private FuncSTO m_func = null;
    
	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public SymbolTable()
	{
		m_nLevel = 0;
		m_stkScopes = new Stack<Scope>();
		m_scopeGlobal = null;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public void insert(STO sto)
	{
        Scope scope = m_stkScopes.peek();
		scope.InsertLocal(sto);
	}

	public void pop() {
		Scope scope = m_stkScopes.peek();
		scope.PopLocal();
	}

	public STO peek() {
		Scope scope = m_stkScopes.peek();
		return scope.PeekLocal();
	}

	public void popFront() {
		Scope scope = m_stkScopes.peek();
		scope.PopFront();
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public STO accessGlobal(String strName)
	{
		return m_scopeGlobal.access(strName);
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public STO accessLocal(String strName)
	{
		Scope scope = m_stkScopes.peek();
		return scope.accessLocal(strName);
	}

	public Vector<STO> accessLocalList(String strName) {
		Scope scope = m_stkScopes.peek();
		return scope.accessLocalList(strName);
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public STO access(String strName)
	{
		Stack stk = new Stack();
		Scope scope;
		STO stoReturn = null;

		for (Enumeration<Scope> e = m_stkScopes.elements(); e.hasMoreElements();)
		{
			scope = e.nextElement();
			if (scope.access(strName) != null)
				stoReturn = scope.access(strName);
		}

		return stoReturn;
	}

	public Vector<STO> accessList(String strName) {
		Stack stk = new Stack();
		Scope scope;
		Vector<STO> stoList = null;
		Vector<STO> res = new Vector<STO>();

		for (Enumeration<Scope> e = m_stkScopes.elements(); e.hasMoreElements();)
		{
			scope = e.nextElement();
			if (scope.accessLocalList(strName).size() > 0) {
				stoList = scope.accessLocalList(strName);
				res.addAll(0, stoList);
			}
		}

		return res;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public void openScope()
	{
		Scope scope = new Scope();

		// The first scope created will be the global scope.
		if (m_scopeGlobal == null)
			m_scopeGlobal = scope;

		m_stkScopes.push(scope);
		m_nLevel++;
	}

	public void pushScope(Scope s) {
		m_stkScopes.push(s);
		m_nLevel++;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public void closeScope()
	{
		m_stkScopes.pop();
		m_nLevel--;
	}

	public Scope popScope() {
		m_nLevel--;
		return m_stkScopes.pop();
	}

	public Scope peekScope() {
		return m_stkScopes.peek();
	}


	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public int getLevel()
	{
		return m_nLevel;
	}


	//----------------------------------------------------------------
	//	This is the function currently being parsed.
	//----------------------------------------------------------------
	public FuncSTO getFunc() { return m_func; }
	public void setFunc(FuncSTO sto) { m_func = sto; }
}
