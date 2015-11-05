package types;

/**
 * Created by FreeQinC on 10/23/15.
 */
public class NullPointerType extends PointerType {
    public NullPointerType() { super("nullptr", 0); }

    public String getName() {
        return "nullptr";
    }
}
