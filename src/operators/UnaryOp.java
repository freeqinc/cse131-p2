package operators;

import STO.STO;

/**
 * Created by FreeQinC on 10/10/15.
 */
public abstract class UnaryOp extends Operator {

    public UnaryOp(String name) { super(name); }

    public abstract STO checkOperand(STO a);
}
