package types;
import STO.*;
import scope.*;

import java.util.Vector;


/**
 * Created by FreeQinC on 10/21/15.
 */
public class StructType extends CompositeType {

    private Scope m_scope;
    private String m_id;

    public StructType() {
        super("struct", 0);
        m_scope = new Scope();
    }

    public void setId(String id) { m_id = id; }
    public String getId() { return m_id; }
    public String getName() { return getId(); }
    public String getStructName() { return m_id; }
    public void setScope(Scope scope) {
        m_scope = scope;
    }

    public Scope getScope() {
        return m_scope;
    }


    public int getSize() {
        return getScope().getSize();
    }

    public Vector<STO> getConstructors() {
        Vector<STO> list;

        list = m_scope.accessLocalList(m_id);

        return list;
    }

    public void printConstructors() {
        Vector<STO> list = getConstructors();

        System.out.print("Constructors for " + m_id + ": ");
        for (int i = 0; i < list.size(); i += 1) {
            System.out.print(list.elementAt(i).getClass() + " " + list.elementAt(i).getType().getName() + ": "  + list.elementAt(i).getName() + ", ");
        }
        System.out.println();
    }

//    public FuncSTO getFunc() { return m_func; }
//    public void setFunc(FuncSTO sto) { m_func = sto; }

//    public void printScope() {
//        System.out.print("STRUCT SCOPE: ");
//        for (int i = 0; i < m_scope.size(); i += 1) {
//            System.out.print(m_scope.elementAt(i).getType().getName() + ": "  + m_scope.elementAt(i).getName() + ", ");
//        }
//        System.out.println();
//    }
//
//    public STO access(String id) {
//        return accessLocal(id);
//    }
//
//    public STO accessLocal(String id) {
//        STO sto;
//
//        for (int i = 0; i < m_scope.size(); i++) {
//            sto = m_scope.elementAt(i);
//
//            if (sto.getName().equals(id)) {
//                return sto;
//            }
//        }
//        return null;
//    }
//
//    public Vector<STO> accessLocalList(String id) {
//        Vector <STO> res = new Vector<STO>();
//        STO sto;
//
//        for (int i = 0; i < m_scope.size(); i++) {
//            sto = m_scope.elementAt(i);
//
//            if (sto.getName().equals(id))
//                res.addElement(sto);
//        }
//
//        return res;
//    }
//
//    public void insert(STO sto) {
//        m_scope.addElement(sto);
//    }
//
//    public void pop() {
//        m_scope.remove(m_scope.size() - 1);
//    }

}
