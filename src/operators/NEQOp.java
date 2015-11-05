package operators;

import STO.*;
import types.*;

/**
 * Created by FreeQinC on 10/9/15.
 */
public class NEQOp extends ComparisonOp {

    public NEQOp() { super("!="); }

    public STO checkOperands(STO a, STO b) {
        Type aType = a.getType();
        Type bType = b.getType();

        STO retSTO;
        boolean operableConsts = (a instanceof ConstSTO) && ((ConstSTO) a).hasValue() && (b instanceof ConstSTO) && ((ConstSTO) b).hasValue();

        if ((aType instanceof NumericType) && (bType instanceof NumericType)) {
            if (operableConsts) {
                retSTO = new ConstSTO("NEQ_result", new BoolType(), ((ConstSTO) a).getFloatValue() != ((ConstSTO) b).getFloatValue());
            } else {
                retSTO =  new ExprSTO("NEQ_result", new BoolType());
            }
        } else if ((aType instanceof BoolType) && (bType instanceof BoolType)) {
            if (operableConsts) {
                retSTO = new ConstSTO("NEQ_result", new BoolType(), ((ConstSTO) a).getBoolValue() != ((ConstSTO) b).getBoolValue());
            } else {
                retSTO =  new ExprSTO("NEQ_result", new BoolType());
            }
        } else if ((aType instanceof PointerType) && (bType instanceof PointerType)) {
            if (aType instanceof NullPointerType || bType instanceof NullPointerType) {
                retSTO = new ExprSTO("EQU_result", new BoolType());
            } else if (((PointerType) aType).isEqualToPointer(bType)) {
                retSTO = new ExprSTO("EQU_result", new BoolType());
            } else {
                return new ErrorSTO("error17_Expr");
            }
        } else if ((aType instanceof PointerType) || (bType instanceof PointerType)) {
            return new ErrorSTO("error17_Expr");
        } else {
            return new ErrorSTO("error1b_Expr");
        }

        retSTO.setRValue();
        return retSTO;
    }
}
