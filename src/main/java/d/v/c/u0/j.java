/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.u0;

import android.content.Context;
import d.v.e.d;
import d.v.e.f;

public final class j
extends d {
    private static final String a = "compose_setting_preferences";
    private static final String b = "key_resolution";
    private static final String c = "key_frame_rate";
    private static final String d = "key_show_comfirm";

    public static String A() {
        return d.v.e.d.m(j.z(), a, c, null);
    }

    public static boolean B() {
        return d.v.e.d.d(j.z(), a, d, false);
    }

    public static String C() {
        return d.v.e.d.m(j.z(), a, b, null);
    }

    public static void D(String string2) {
        d.v.e.d.x(j.z(), a, c, string2);
    }

    public static void E(boolean bl2) {
        d.v.e.d.s(j.z(), a, d, bl2);
    }

    public static void F(String string2) {
        d.v.e.d.x(j.z(), a, b, string2);
    }

    private static Context z() {
        return f.a().c();
    }
}

