/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ae;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ab {
    private static int a;
    public static final String a;
    public static final boolean a;
    public static final boolean b;
    public static final boolean c;
    public static final boolean d;
    public static boolean e;
    public static final boolean f;
    public static final boolean g;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl2;
        int n10 = ae.a;
        String string2 = "ONEBOX";
        String string3 = n10 != 0 ? string2 : "@SHIP.TO.2A2FE0D7@";
        a = string3;
        String string4 = "2A2FE0D7";
        a = bl2 = string3.contains(string4);
        boolean bl3 = false;
        boolean bl4 = true;
        if (!bl2 && !(bl2 = (string4 = "DEBUG").equalsIgnoreCase(string3))) {
            bl2 = false;
            string4 = null;
        } else {
            bl2 = bl4;
        }
        b = bl2;
        c = "LOGABLE".equalsIgnoreCase(string3);
        d = string3.contains("YY");
        e = string3.equalsIgnoreCase("TEST");
        string4 = "BETA";
        f = bl2 = string4.equalsIgnoreCase(string3);
        if (string3 != null && (bl2 = string3.startsWith(string4 = "RC"))) {
            bl3 = bl4;
        }
        g = bl3;
        a = (int)(bl4 ? 1 : 0);
        string4 = "SANDBOX";
        bl2 = string3.equalsIgnoreCase(string4);
        if (bl2) {
            n10 = 2;
        } else {
            n10 = (int)(string3.equalsIgnoreCase(string2) ? 1 : 0);
            if (n10 == 0) {
                a = (int)(bl4 ? 1 : 0);
                return;
            }
            n10 = 3;
        }
        a = n10;
    }

    public static int a() {
        return a;
    }

    public static void a(int n10) {
        a = n10;
    }

    public static boolean a() {
        int n10 = a;
        int n11 = 2;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public static boolean b() {
        int n10 = a;
        int n11 = 3;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }
}

