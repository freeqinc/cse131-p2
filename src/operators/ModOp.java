package operators;

import STO.*;
import types.*;

/**
 * Created by FreeQinC on 10/4/15.
 */
public class ModOp extends ArithmeticOp {

    public ModOp() { super("%"); }

    public STO checkOperands(STO a, STO b) {
        Type aType = a.getType();
        Type bType = b.getType();

        STO retSTO;
        boolean operableConsts = (a instanceof ConstSTO) && ((ConstSTO) a).hasValue() && (b instanceof ConstSTO) && ((ConstSTO) b).hasValue();

        if (!(aType instanceof IntType) || !(bType instanceof IntType)) {
            if (!(aType instanceof IntType))
                return new ErrorSTO("error1w_Expr_left_mod");
            else
                return new ErrorSTO("error1w_Expr_right_mod");
        } else if (b instanceof ConstSTO && ((ConstSTO) b).getIntValue() == 0) {
            return new ErrorSTO("error8_Arithmetic");
        } else {
            if (operableConsts) {
                retSTO = new ConstSTO("mod_result", new IntType(), ((ConstSTO) a).getIntValue() % ((ConstSTO) b).getIntValue());
            } else {
                retSTO = new ExprSTO("mod_result", new IntType());
            }
        }

        retSTO.setRValue();
        return retSTO;
    }
}
