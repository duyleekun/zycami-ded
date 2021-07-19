/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.format.f;
import j$.time.format.v;

final class n
extends Enum
implements f {
    public static final /* enum */ n a;
    public static final /* enum */ n b;
    public static final /* enum */ n c;
    private static final /* synthetic */ n[] d;

    static {
        n n10;
        n n11;
        n n12;
        a = n12 = new n("SENSITIVE", 0);
        int n13 = 1;
        b = n11 = new n("INSENSITIVE", n13);
        int n14 = 2;
        n n15 = new n("STRICT", n14);
        int n16 = 3;
        c = n10 = new n("LENIENT", n16);
        n[] nArray = new n[4];
        nArray[0] = n12;
        nArray[n13] = n11;
        nArray[n14] = n15;
        nArray[n16] = n10;
        d = nArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private n() {
        void var2_-1;
        void var1_-1;
    }

    public static n valueOf(String string2) {
        return Enum.valueOf(n.class, string2);
    }

    public static n[] values() {
        return (n[])d.clone();
    }

    public boolean m(v v10, StringBuilder stringBuilder) {
        return true;
    }

    public String toString() {
        int n10 = this.ordinal();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 == n11) {
                        return "ParseStrict(false)";
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("Unreachable");
                    throw illegalStateException;
                }
                return "ParseStrict(true)";
            }
            return "ParseCaseSensitive(false)";
        }
        return "ParseCaseSensitive(true)";
    }
}

