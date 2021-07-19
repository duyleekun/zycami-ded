/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.util;

import java.io.PrintWriter;

public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync;

    static {
        Object object;
        sFormatSync = object = new Object();
        sFormatStr = new char[24];
    }

    private TimeUtils() {
    }

    private static int accumField(int n10, int n11, boolean bl2, int n12) {
        int n13 = 3;
        int n14 = 99;
        if (!(n10 > n14 || bl2 && n12 >= n13)) {
            n13 = 9;
            n14 = 2;
            if (!(n10 > n13 || bl2 && n12 >= n14)) {
                if (!bl2 && n10 <= 0) {
                    return 0;
                }
                return n11 + 1;
            }
            return n11 + n14;
        }
        return n11 + n13;
    }

    public static void formatDuration(long l10, long l11, PrintWriter printWriter) {
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            printWriter.print("--");
            return;
        }
        TimeUtils.formatDuration(l10 - l11, printWriter, 0);
    }

    public static void formatDuration(long l10, PrintWriter printWriter) {
        TimeUtils.formatDuration(l10, printWriter, 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void formatDuration(long l10, PrintWriter printWriter, int n10) {
        Object object = sFormatSync;
        synchronized (object) {
            int n11 = TimeUtils.formatDurationLocked(l10, n10);
            char[] cArray = sFormatStr;
            String string2 = new String(cArray, 0, n11);
            printWriter.print(string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void formatDuration(long l10, StringBuilder stringBuilder) {
        Object object = sFormatSync;
        synchronized (object) {
            int n10 = TimeUtils.formatDurationLocked(l10, 0);
            char[] cArray = sFormatStr;
            stringBuilder.append(cArray, 0, n10);
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static int formatDurationLocked(long l10, int n10) {
        void var25_71;
        void var25_68;
        void var25_65;
        void var5_6;
        void var25_61;
        void var22_25;
        int n11;
        int n12;
        long l11 = l10;
        int c14 = n10;
        char[] cArray = sFormatStr;
        int n13 = cArray.length;
        if (n13 < n10) {
            sFormatStr = cArray = new char[n10];
        }
        cArray = sFormatStr;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        int n14 = 32;
        int n15 = 1;
        int n16 = 0;
        if (l13 == false) {
            int n17 = c14 + -1;
            while (n17 > 0) {
                cArray[0] = n14;
            }
            cArray[0] = 48;
            return n15;
        }
        if (l13 > 0) {
            l13 = 43;
        } else {
            l13 = 45;
            l11 = -l11;
        }
        long l14 = 1000L;
        long l15 = l11 % l14;
        int n18 = (int)l15;
        double d10 = Math.floor(l11 /= l14);
        int n19 = (int)d10;
        int n20 = 86400;
        if (n19 > n20) {
            n12 = n19 / n20;
            int n21 = n20 * n12;
            n19 -= n21;
        } else {
            n12 = 0;
        }
        int n22 = 3600;
        if (n19 > n22) {
            int n23 = n19 / 3600;
            int n24 = n23 * 3600;
            n19 -= n24;
        } else {
            boolean bl2 = false;
        }
        int n25 = 60;
        if (n19 > n25) {
            int n26 = n19 / 60;
            int n27 = n26 * 60;
            n11 = n19 - n27;
            n19 = n26;
        } else {
            n11 = n19;
            n19 = 0;
        }
        int n28 = 3;
        int n29 = 2;
        if (c14 != 0) {
            void var24_35;
            void var25_56;
            void var25_52;
            void var25_48;
            void var25_44;
            int n30 = TimeUtils.accumField(n12, n15, false, 0);
            if (n30 > 0) {
                int n31 = n15;
            } else {
                boolean bl3 = false;
            }
            int n32 = TimeUtils.accumField((int)var22_25, n15, (boolean)var25_44, n29);
            int n33 = n30 + n32;
            if (n33 > 0) {
                int n34 = n15;
            } else {
                boolean bl4 = false;
            }
            int n35 = TimeUtils.accumField(n19, n15, (boolean)var25_48, n29);
            int n36 = n33 + n35;
            if (n36 > 0) {
                int n37 = n15;
            } else {
                boolean bl5 = false;
            }
            int n38 = TimeUtils.accumField(n11, n15, (boolean)var25_52, n29);
            int n39 = n36 + n38;
            if (n39 > 0) {
                int n40 = n28;
            } else {
                boolean bl6 = false;
            }
            int n41 = TimeUtils.accumField(n18, n29, n15 != 0, (int)var25_56) + n15;
            int n42 = n39 + n41;
            boolean bl7 = false;
            while (++var24_35 < c14) {
                void var25_59;
                cArray[var25_59] = n14;
                ++var25_59;
            }
        } else {
            boolean bl8 = false;
        }
        cArray[var25_61] = (char)l13;
        int n43 = var25_61 + true;
        if (c14 != 0) {
            int n44 = n15;
        } else {
            boolean bl9 = false;
        }
        boolean bl10 = false;
        n14 = n12;
        n12 = 100;
        void var24_36 = n43;
        n16 = n43;
        n43 = 0;
        int n45 = TimeUtils.printField(cArray, n14, (char)n12, (int)var24_36, false, 0);
        n12 = 104;
        if (n45 != n16) {
            int n46 = n15;
        } else {
            boolean bl11 = false;
        }
        n43 = var5_6 != false ? n29 : 0;
        n14 = var22_25;
        int n47 = TimeUtils.printField(cArray, (int)var22_25, (char)n12, n45, (boolean)var25_65, n43);
        n12 = 109;
        if (n47 != n16) {
            int n48 = n15;
        } else {
            boolean bl12 = false;
        }
        n43 = var5_6 != false ? n29 : 0;
        n14 = n19;
        int n49 = TimeUtils.printField(cArray, n19, (char)n12, n47, (boolean)var25_68, n43);
        n12 = 115;
        if (n49 != n16) {
            int n50 = n15;
        } else {
            boolean bl13 = false;
        }
        n43 = var5_6 != false ? n29 : 0;
        n14 = n11;
        int n51 = TimeUtils.printField(cArray, n11, (char)n12, n49, (boolean)var25_71, n43);
        n12 = 109;
        boolean bl14 = true;
        n43 = var5_6 != false && n51 != n16 ? n28 : 0;
        n14 = n18;
        n19 = TimeUtils.printField(cArray, n18, (char)n12, n51, bl14, n43);
        cArray[n19] = 115;
        return n19 + n15;
    }

    private static int printField(char[] cArray, int n10, char c10, int n11, boolean n12, int n13) {
        if (n12 != 0 || n10 > 0) {
            int n14;
            int n15;
            if (n12 != 0 && n13 >= (n15 = 3) || n10 > (n15 = 99)) {
                n15 = n10 / 100;
                cArray[n11] = n14 = (int)((char)(n15 + 48));
                n14 = n11 + 1;
                n10 -= (n15 *= 100);
            } else {
                n14 = n11;
            }
            if (n12 != 0 && n13 >= (n12 = 2) || n10 > (n12 = 9) || n11 != n14) {
                n11 = n10 / 10;
                cArray[n14] = n12 = (int)((char)(n11 + 48));
                ++n14;
                n10 -= (n11 *= 10);
            }
            cArray[n14] = n10 = (int)((char)(n10 + 48));
            cArray[++n14] = c10;
            n11 = n14 + 1;
        }
        return n11;
    }
}

