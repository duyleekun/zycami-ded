/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import java.util.Comparator;
import java.util.Map;

class w
implements Comparator {
    w() {
    }

    public int compare(Object object, Object object2) {
        object = (Map.Entry)object;
        int n10 = ((String)((Map.Entry)object2).getKey()).length();
        int n11 = ((String)object.getKey()).length();
        return n10 - n11;
    }
}

