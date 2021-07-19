/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

public final class HexDumpUtils {
    public static String dump(byte[] byArray, int n10, int n11, boolean bl2) {
        int n12;
        int n13;
        if (byArray != null && (n13 = byArray.length) != 0 && n10 >= 0 && n11 > 0 && (n13 = n10 + n11) <= (n12 = byArray.length)) {
            n13 = 57;
            if (bl2) {
                n13 = 75;
            }
            n12 = n11 + 16;
            int n14 = 1;
            n12 -= n14;
            int n15 = 16;
            StringBuilder stringBuilder = new StringBuilder(n13 *= (n12 /= n15));
            n13 = 0;
            int n16 = n11;
            int n17 = 0;
            int n18 = 0;
            Object object = null;
            while (n16 > 0) {
                Object object2;
                Object object3;
                int n19 = 8;
                if (n17 == 0) {
                    n18 = 65536;
                    if (n11 < n18) {
                        object = new Object[n14];
                        object[0] = object3 = Integer.valueOf(n10);
                        object3 = "%04X:";
                        object = String.format((String)object3, object);
                        stringBuilder.append((String)object);
                    } else {
                        object = new Object[n14];
                        object[0] = object3 = Integer.valueOf(n10);
                        object3 = "%08X:";
                        object = String.format((String)object3, object);
                        stringBuilder.append((String)object);
                    }
                    n18 = n10;
                } else if (n17 == n19) {
                    object3 = " -";
                    stringBuilder.append((String)object3);
                }
                object3 = new Object[n14];
                int n20 = byArray[n10] & 0xFF;
                object3[0] = object2 = Integer.valueOf(n20);
                object2 = " %02X";
                object3 = String.format((String)object2, object3);
                stringBuilder.append((String)object3);
                if (bl2 && (++n17 == n15 || (n16 += -1) == 0)) {
                    int n21 = 16 - n17;
                    if (n21 > 0) {
                        object2 = null;
                        for (n20 = 0; n20 < n21; ++n20) {
                            String string2 = "   ";
                            stringBuilder.append(string2);
                        }
                    }
                    object2 = "  ";
                    if (n21 >= n19) {
                        stringBuilder.append((String)object2);
                    }
                    stringBuilder.append((String)object2);
                    for (n19 = 0; n19 < n17; ++n19) {
                        n21 = n18 + n19;
                        n20 = 32;
                        if ((n21 = (int)((char)byArray[n21])) < n20 || n21 > (n20 = 126)) {
                            n21 = 46;
                        }
                        stringBuilder.append((char)n21);
                    }
                }
                if (n17 == n15 || n16 == 0) {
                    stringBuilder.append('\n');
                    n17 = 0;
                }
                ++n10;
            }
            return stringBuilder.toString();
        }
        return null;
    }
}

