package operators;

import STO.*;
import types.*;

/**
 * Created by FreeQinC on 10/10/15.
 */
public class AndOp extends BooleanOp {

    public AndOp() { super("&&"); }

    public STO checkOperands(STO a, STO b) {
        Type aType = a.getType();
        Type bType = b.getType();

        STO retSTO;
        boolean operableConsts = (a instanceof ConstSTO) && ((ConstSTO) a).hasValue() && (b instanceof ConstSTO) && ((ConstSTO) b).hasValue();

        if (!(aType instanceof BoolType) || !(bType instanceof BoolType)) {
            if (!(aType instanceof BoolType))
                return new ErrorSTO("error1w_Expr_left_boolean");
            else
                return new ErrorSTO("error1w_Expr_right_boolean");
        } else {
            if (operableConsts) {
                retSTO = new ConstSTO("and_result", new BoolType(), ((ConstSTO) a).getBoolValue() && ((ConstSTO) b).getBoolValue());
            } else {
                retSTO = new ExprSTO("and_result", new BoolType());
            }
        }

        retSTO.setRValue();
        return retSTO;
    }
}
