package operators;

import STO.*;
import types.*;

/**
 * Created by FreeQinC on 10/5/15.
 */
public class LTOp extends ComparisonOp {

    public LTOp() { super("<"); }

    public STO checkOperands(STO a, STO b) {
        Type aType = a.getType();
        Type bType = b.getType();

        STO retSTO;
        boolean operableConsts = (a instanceof ConstSTO) && ((ConstSTO) a).hasValue() && (b instanceof ConstSTO) && ((ConstSTO) b).hasValue();

        if (!(aType instanceof NumericType) || !(bType instanceof NumericType)) {
            if (!(aType instanceof NumericType))
                return new ErrorSTO("error1n_Expr_left");
            else
                return new ErrorSTO("error1n_Expr_right");
        } else {
            if (operableConsts) {
                retSTO = new ConstSTO("LT_result", new BoolType(), ((ConstSTO) a).getFloatValue() < ((ConstSTO) b).getFloatValue());
            } else {
                retSTO = new ExprSTO("LT_result", new BoolType());
            }
        }

        retSTO.setRValue();
        return retSTO;
    }

}
