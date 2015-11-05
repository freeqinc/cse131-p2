package operators;
import STO.*;

/**
 * Created by FreeQinC on 10/3/15.
 */
public abstract class Operator {

    private String m_opName;

    public Operator(String opName) {
        setName(opName);
    }

    public String getName() {
        return m_opName;
    }

    public void setName(String opName) {
        m_opName = opName;
    }
}
