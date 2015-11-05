package types;
// create sub-classes (since this one is abstract) that handle specific
// types, such as IntType, FloatType, ArrayType, etc.
//---------------------------------------------------------------------

public abstract class Type
{
	// Name of the Type (e.g., int, bool, some structdef, etc.)
	private String m_typeName;
	private int m_size;

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public Type(String strName, int size)
	{
		setName(strName);
		setSize(size);
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public String getName()
	{
		return m_typeName;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	private void setName(String str)
	{
		m_typeName = str;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	public int getSize()
	{
		return m_size;
	}

	//----------------------------------------------------------------
	//
	//----------------------------------------------------------------
	private void setSize(int size)
	{
		m_size = size;
	}

	//----------------------------------------------------------------
	//	It will be helpful to ask a Type what specific Type it is.
	//	The Java operator instanceof will do this, but you may
	//	also want to implement methods like isNumeric(), isInt(),
	//	etc. Below is an example of isInt(). Feel free to
	//	change this around.
	//----------------------------------------------------------------
	public boolean  isError()   { return false; }
	public boolean  isInt()	    { return false; }
}
