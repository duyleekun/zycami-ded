/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.q2.u;
import g.h0.d;
import okio.ByteString;

public final class c {
    public static final ByteString a;
    public static final int b = 16384;
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = 7;
    public static final int k = 8;
    public static final int l = 9;
    public static final int m = 0;
    public static final int n = 1;
    public static final int o = 1;
    public static final int p = 4;
    public static final int q = 4;
    public static final int r = 8;
    public static final int s = 32;
    public static final int t = 32;
    private static final String[] u;
    private static final String[] v;
    private static final String[] w;
    public static final c x;

    static {
        Object object;
        String[] stringArray;
        Object object2;
        int n10;
        Object object3;
        int n11;
        int n12;
        String[] stringArray2 = new c();
        x = stringArray2;
        a = ByteString.Companion.l("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        Object object4 = "RST_STREAM";
        String string2 = "SETTINGS";
        Object object5 = "PUSH_PROMISE";
        String[] stringArray3 = "PING";
        String string3 = "GOAWAY";
        String string4 = "WINDOW_UPDATE";
        String string5 = "CONTINUATION";
        u = new String[]{"DATA", "HEADERS", "PRIORITY", object4, string2, object5, stringArray3, string3, string4, string5};
        stringArray2 = new String[64];
        v = stringArray2;
        int n13 = 256;
        Object[] objectArray = new String[n13];
        int n14 = 0;
        int n15 = 0;
        String string6 = null;
        while (true) {
            n12 = 1;
            if (n15 >= n13) break;
            object4 = new Object[n12];
            string2 = Integer.toBinaryString(n15);
            f0.o(string2, "Integer.toBinaryString(it)");
            object4[0] = string2;
            string2 = "%8s";
            object5 = g.h0.d.v(string2, object4);
            n11 = 32;
            object3 = 48;
            n10 = 0;
            string4 = null;
            object2 = 4;
            stringArray = null;
            objectArray[n15] = object4 = f.q2.u.f2((String)object5, (char)n11, (char)object3, false, object2, null);
            ++n15;
        }
        w = objectArray;
        stringArray2 = v;
        stringArray2[0] = "";
        stringArray2[n12] = "END_STREAM";
        objectArray = new int[n12];
        objectArray[0] = (String)n12;
        string6 = "PADDED";
        int n16 = 8;
        stringArray2[n16] = string6;
        n13 = 0;
        stringArray2 = null;
        while (true) {
            string6 = "|PADDED";
            if (n13 >= n12) break;
            object = objectArray[n13];
            stringArray3 = v;
            object3 = object | 8;
            object5 = stringArray3[object];
            stringArray3[object3] = string6 = f0.C((String)object5, string6);
            ++n13;
        }
        stringArray2 = v;
        stringArray2[4] = "END_HEADERS";
        stringArray2[32] = "PRIORITY";
        object = 36;
        stringArray2[object] = "END_HEADERS|PRIORITY";
        n13 = 3;
        Object object6 = object5 = (Object)new int[n13];
        object6[0] = 4;
        object6[1] = 32;
        object6[2] = 36;
        stringArray3 = null;
        for (n11 = 0; n11 < n13; ++n11) {
            object3 = object5[n11];
            string4 = null;
            for (n10 = 0; n10 < n12; ++n10) {
                object2 = objectArray[n10];
                stringArray = v;
                int n17 = object2 | object3;
                CharSequence charSequence = new StringBuilder();
                String string7 = stringArray[object2];
                ((StringBuilder)charSequence).append(string7);
                string7 = "|";
                ((StringBuilder)charSequence).append(string7);
                String string8 = stringArray[object3];
                ((StringBuilder)charSequence).append(string8);
                charSequence = ((StringBuilder)charSequence).toString();
                stringArray[n17] = charSequence;
                charSequence = new StringBuilder();
                string5 = stringArray[object2];
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append(string7);
                string5 = stringArray[object3];
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append(string6);
                stringArray[n17 |= n16] = string5 = ((StringBuilder)charSequence).toString();
            }
        }
        stringArray2 = v;
        n13 = stringArray2.length;
        while (n14 < n13) {
            objectArray = v;
            string6 = objectArray[n14];
            if (string6 == null) {
                objectArray[n14] = string6 = w[n14];
            }
            ++n14;
        }
    }

    private c() {
    }

    public final String a(int n10, int n11) {
        if (n11 == 0) {
            return "";
        }
        int n12 = 2;
        if (n10 != n12 && n10 != (n12 = 3)) {
            n12 = 4;
            if (n10 != n12 && n10 != (n12 = 6)) {
                n12 = 7;
                if (n10 != n12 && n10 != (n12 = 8)) {
                    Object object = v;
                    int n13 = ((String[])object).length;
                    if (n11 < n13) {
                        object = object[n11];
                        f0.m(object);
                    } else {
                        object = w[n11];
                    }
                    Object object2 = object;
                    n12 = 5;
                    if (n10 == n12 && (n12 = n11 & 4) != 0) {
                        int n14 = 4;
                        String string2 = "HEADERS";
                        String string3 = "PUSH_PROMISE";
                        object2 = f.q2.u.g2((String)object, string2, string3, false, n14, null);
                    } else if (n10 == 0 && (n10 = n11 & 0x20) != 0) {
                        int n15 = 4;
                        String string4 = "PRIORITY";
                        String string5 = "COMPRESSED";
                        object2 = f.q2.u.g2((String)object2, string4, string5, false, n15, null);
                    }
                    return object2;
                }
            } else {
                n10 = 1;
                String string6 = n11 == n10 ? "ACK" : w[n11];
                return string6;
            }
        }
        return w[n11];
    }

    public final String b(int n10) {
        Object object;
        Object[] objectArray = u;
        int n11 = objectArray.length;
        if (n10 < n11) {
            object = objectArray[n10];
        } else {
            int n12 = 1;
            objectArray = new Object[n12];
            n11 = 0;
            objectArray[0] = object = Integer.valueOf(n10);
            object = g.h0.d.v("0x%02x", objectArray);
        }
        return object;
    }

    public final String c(boolean bl2, int n10, int n11, int n12, int n13) {
        String string2 = this.b(n12);
        String string3 = this.a(n12, n13);
        String string4 = bl2 ? "<<" : ">>";
        Object[] objectArray = new Object[5];
        objectArray[0] = string4;
        Integer n14 = n10;
        objectArray[1] = n14;
        n14 = n11;
        objectArray[2] = n14;
        objectArray[3] = string2;
        objectArray[4] = string3;
        return g.h0.d.v("%s 0x%08x %5d %-13s %s", objectArray);
    }
}

