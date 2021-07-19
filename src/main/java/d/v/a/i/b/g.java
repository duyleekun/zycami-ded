/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.b;

import d.v.a.i.b.e;
import java.util.Comparator;

public class g
implements Comparator {
    public int a(e object, e object2) {
        String string2;
        String string3 = ((e)object2).d();
        boolean bl2 = string3.equals(string2 = "#");
        if (bl2) {
            return -1;
        }
        string3 = ((e)object).d();
        bl2 = string3.equals(string2);
        if (bl2) {
            return 1;
        }
        object = ((e)object).d();
        object2 = ((e)object2).d();
        return ((String)object).compareTo((String)object2);
    }
}

