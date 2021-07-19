/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.network.grs.d;

import com.huawei.hms.framework.common.Logger;

public class e {
    private static final String a = "e";

    public static boolean a(Long object) {
        String string2;
        boolean bl2;
        block8: {
            bl2 = true;
            if (object == null) {
                Logger.v(a, "Method isTimeExpire input param expireTime is null.");
                return bl2;
            }
            long l10 = System.currentTimeMillis();
            long l11 = (Long)object - l10;
            l10 = 0L;
            long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (l12 < 0) break block8;
            object = a;
            string2 = "isSpExpire false.";
            Logger.v((String)object, string2);
            return false;
        }
        object = a;
        string2 = "isSpExpire true.";
        try {
            Logger.v((String)object, string2);
        }
        catch (NumberFormatException numberFormatException) {
            object = a;
            string2 = "isSpExpire spValue NumberFormatException.";
            Logger.v((String)object, string2);
        }
        return bl2;
    }

    public static boolean a(Long object, long l10) {
        boolean bl2;
        block6: {
            bl2 = true;
            if (object == null) {
                Logger.v(a, "Method isTimeWillExpire input param expireTime is null.");
                return bl2;
            }
            long l11 = System.currentTimeMillis();
            long l12 = (Long)object;
            long l13 = 0L;
            long l14 = (l12 -= (l11 += l10)) - l13;
            long l15 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (l15 < 0) break block6;
            object = a;
            String string2 = "isSpExpire false.";
            try {
                Logger.v((String)object, string2);
                return false;
            }
            catch (NumberFormatException numberFormatException) {
                object = a;
                string2 = "isSpExpire spValue NumberFormatException.";
                Logger.v((String)object, string2);
            }
        }
        return bl2;
    }
}

