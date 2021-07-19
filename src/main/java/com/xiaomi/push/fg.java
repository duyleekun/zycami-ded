/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.fa;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class fg
extends Enum {
    public static final /* enum */ fg a;
    private static final /* synthetic */ fg[] a;
    public static final /* enum */ fg b;
    public static final /* enum */ fg c;
    public static final /* enum */ fg d;
    public static final /* enum */ fg e;
    public static final /* enum */ fg f;
    public static final /* enum */ fg g;
    public static final /* enum */ fg h;
    public static final /* enum */ fg i;
    public static final /* enum */ fg j;
    public final String a;

    static {
        fg fg2;
        fg fg3;
        fg fg4;
        fg fg5;
        fg fg6;
        fg fg7;
        fg fg8;
        fg fg9;
        fg fg10;
        fg fg11;
        a = fg11 = new fg("COMMAND_REGISTER", 0, "register");
        int n10 = 1;
        b = fg10 = new fg("COMMAND_UNREGISTER", n10, "unregister");
        int n11 = 2;
        c = fg9 = new fg("COMMAND_SET_ALIAS", n11, "set-alias");
        d = fg8 = new fg("COMMAND_UNSET_ALIAS", 3, "unset-alias");
        e = fg7 = new fg("COMMAND_SET_ACCOUNT", 4, "set-account");
        f = fg6 = new fg("COMMAND_UNSET_ACCOUNT", 5, "unset-account");
        g = fg5 = new fg("COMMAND_SUBSCRIBE_TOPIC", 6, "subscribe-topic");
        h = fg4 = new fg("COMMAND_UNSUBSCRIBE_TOPIC", 7, "unsubscibe-topic");
        i = fg3 = new fg("COMMAND_SET_ACCEPT_TIME", 8, "accept-time");
        int n12 = 9;
        j = fg2 = new fg("COMMAND_CHK_VDEVID", n12, "check-vdeviceid");
        fg[] fgArray = new fg[10];
        fgArray[0] = fg11;
        fgArray[n10] = fg10;
        fgArray[n11] = fg9;
        fgArray[3] = fg8;
        fgArray[4] = fg7;
        fgArray[5] = fg6;
        fgArray[6] = fg5;
        fgArray[7] = fg4;
        fgArray[8] = fg3;
        fgArray[n12] = fg2;
        a = fgArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private fg() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static int a(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        int n10 = -1;
        if (bl2) {
            return n10;
        }
        for (fg fg2 : fg.values()) {
            String string3 = fg2.a;
            boolean bl3 = string3.equals(string2);
            if (!bl3) continue;
            n10 = fa.a(fg2);
        }
        return n10;
    }

    public static fg valueOf(String string2) {
        return Enum.valueOf(fg.class, string2);
    }

    public static fg[] values() {
        return (fg[])a.clone();
    }
}

