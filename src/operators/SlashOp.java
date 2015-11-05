package operators;

import STO.*;
import types.*;

/**
 * Created by FreeQinC on 10/4/15.
 */
public class SlashOp extends ArithmeticOp {

    public SlashOp() { super("/"); }

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
        } else if (b instanceof ConstSTO && ((ConstSTO) b).getIntValue() == 0) {
            return new ErrorSTO("error8_Arithmetic");
        } else if (aType instanceof IntType && bType instanceof IntType) {
            if (operableConsts) {
                retSTO = new ConstSTO("slash_result", new IntType(), ((ConstSTO) a).getIntValue() / ((ConstSTO) b).getIntValue());
            } else {
                retSTO = new ExprSTO("slash_result", new IntType());
            }
        } else {
            if (operableConsts) {
                retSTO = new ConstSTO("slash_result", new FloatType(), ((ConstSTO) a).getFloatValue() / ((ConstSTO) b).getFloatValue());
            } else {
                retSTO = new ExprSTO("slash_result", new FloatType());
            }
        }

        retSTO.setRValue();
        return retSTO;
    }
}
