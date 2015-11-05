package operators;

import STO.STO;

/**
 * Created by FreeQinC on 10/3/15.
 */
public abstract class BinaryOp extends Operator{

    public BinaryOp(String name) { super(name); }

    public abstract STO checkOperands(STO a, STO b);
}
