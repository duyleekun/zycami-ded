/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;

public class MethodCallsLogger {
    private Map mCalledMethods;

    public MethodCallsLogger() {
        HashMap hashMap;
        this.mCalledMethods = hashMap = new HashMap();
    }

    public boolean approveCall(String string2, int n10) {
        int n11;
        Integer n12 = (Integer)this.mCalledMethods.get(string2);
        boolean bl2 = false;
        if (n12 != null) {
            n11 = n12;
        } else {
            n11 = 0;
            n12 = null;
        }
        int n13 = n11 & n10;
        boolean bl3 = true;
        if (n13 != 0) {
            bl2 = bl3;
        }
        Map map = this.mCalledMethods;
        Integer n14 = n10 | n11;
        map.put(string2, n14);
        return bl2 ^ true;
    }
}

