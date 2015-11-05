package types;

/**
 * Created by FreeQinC on 10/18/15.
 */
public class PointerType extends CompositeType {

    Type m_pointsTo = null;

    public Type deReference() {
        return m_pointsTo;
    }

    public void setPointsTo(Type type) {
        m_pointsTo = type;
    }

    public String getFullString() {
        String name = "*";
        Type next = deReference();

        while (next instanceof PointerType) {
            name += "*";
            next = ((PointerType) next).deReference();
        }

        name = next.getName() + name;
        return name;
    }

    public String getName() {
        return getFullString();
    }

    public boolean isEqualToPointer(Type type) {
        return getName().equals(type.getName());
    }


    public PointerType() { super("pointer", 4); }
    public PointerType(String name, int size) { super(name, size); }
}
