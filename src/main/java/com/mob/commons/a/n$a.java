/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.a;

import com.mob.commons.a.n$1;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.Comparator;
import java.util.HashMap;

public class n$a
implements Comparator {
    private n$a() {
    }

    public /* synthetic */ n$a(n$1 n$1) {
        this();
    }

    public int a(HashMap object, HashMap object2) {
        int n10;
        Object object3 = "\\.";
        Object object4 = "";
        String string2 = "ip";
        if (object != null && (n10 = ((HashMap)object).isEmpty()) == 0 || object2 != null && (n10 = ((HashMap)object2).isEmpty()) == 0) {
            block28: {
                int n11;
                block29: {
                    boolean bl2;
                    n10 = -1;
                    if ((object == null || (n11 = ((HashMap)object).isEmpty()) != 0) && object2 != null && (n11 = ((HashMap)object2).isEmpty()) == 0) {
                        return n10;
                    }
                    n11 = 1;
                    if (object != null && !(bl2 = ((HashMap)object).isEmpty()) && (object2 == null || (bl2 = ((HashMap)object2).isEmpty()))) {
                        return n11;
                    }
                    object = ((HashMap)object).get(string2);
                    object = (String)object;
                    object2 = ((HashMap)object2).get(string2);
                    object2 = (String)object2;
                    if (object == null) break block28;
                    boolean bl3 = ((String)object4).equals(object);
                    if (bl3 || object2 == null) break block28;
                    boolean n12 = ((String)object4).equals(object2);
                    if (n12) break block28;
                    object = ((String)object).split((String)object3);
                    object2 = ((String)object2).split((String)object3);
                    if (object == null) break block28;
                    int n13 = ((Object)object).length;
                    int n14 = 4;
                    if (n13 != n14 || object2 == null) break block28;
                    n13 = ((Object)object2).length;
                    if (n13 != n14) break block28;
                    n13 = 2;
                    object4 = object[n13];
                    object4 = Integer.valueOf((String)object4);
                    int n15 = (Integer)object4;
                    object3 = object2[n13];
                    object3 = Integer.valueOf((String)object3);
                    n13 = (Integer)object3;
                    if (n15 < n13) {
                        return n10;
                    }
                    if (n15 != n13) break block29;
                    n13 = 3;
                    object = object[n13];
                    object = Integer.valueOf((String)object);
                    int n16 = (Integer)object;
                    object2 = object2[n13];
                    object2 = Integer.valueOf((String)object2);
                    try {
                        int n17 = (Integer)object2;
                        if (n16 < n17) {
                            return n10;
                        }
                        if (n16 != n17) break block29;
                        return 0;
                    }
                    catch (Throwable throwable) {
                        object2 = MobLog.getInstance();
                        ((NLog)object2).w(throwable);
                    }
                }
                return n11;
            }
            return 0;
        }
        return 0;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        object = (HashMap)object;
        object2 = (HashMap)object2;
        return this.a((HashMap)object, (HashMap)object2);
    }
}

