package types;

/**
 * Created by FreeQinC on 10/18/15.
 */
public class ArrayType extends CompositeType {

    private int m_dimensionSize = 0;
    private Type m_nextType = null;

    public ArrayType() { super("array", 0); }
    public ArrayType(int size) { super("array", size); }

    public void setNext(Type t) { m_nextType = t; }
    public Type next() { return m_nextType; }

    public void setDimSize(int size) { m_dimensionSize = size; }
    public int getDimSize() { return m_dimensionSize; }

    public int getSize() {
        int dimensions = m_dimensionSize;
        Type next = m_nextType;

        while(next instanceof ArrayType) {
            dimensions *= ((ArrayType) next).getDimSize();
            next = ((ArrayType) next).next();
        }

        return (dimensions * next.getSize());
    }

    public String getName() {
        String name = "[" + m_dimensionSize + "]";
        Type next = m_nextType;

        while (next instanceof ArrayType) {
            name += "[" + ((ArrayType) next).getDimSize() + "]";
            next = ((ArrayType) next).next();
        }

        name = next.getName() + name;
        return name;
    }

    public Type getBaseType() {
        Type next = m_nextType;

        while (next instanceof ArrayType) next = ((ArrayType) next).next();

        return next;
    }
}
