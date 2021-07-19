/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c;

import android.content.Context;
import d.v.e.d;
import d.v.e.f;

public class j0
extends d {
    private static final String a = "setting_preference";
    private static final String b = "key_editor_use_watermark";
    private static final String c = "key_store_use_watermark2";
    private static final String d = "key_story_default_watermark";
    private static final String e = "key_store_use_watermark_path";
    private static final String f = "key_store_use_ending_info";

    public static boolean A() {
        return d.v.e.d.d(j0.z(), a, b, true);
    }

    public static boolean B() {
        return d.v.e.d.d(j0.z(), a, d, true);
    }

    public static long C() {
        return d.v.e.d.j(j0.z(), a, f, Long.MIN_VALUE);
    }

    public static boolean D() {
        return d.v.e.d.d(j0.z(), a, c, true);
    }

    public static String E() {
        return d.v.e.d.m(j0.z(), a, e, "");
    }

    public static void F(boolean bl2) {
        d.v.e.d.s(j0.z(), a, b, bl2);
    }

    public static void G(boolean bl2) {
        d.v.e.d.s(j0.z(), a, d, bl2);
    }

    public static void H(long l10) {
        d.v.e.d.v(j0.z(), a, f, l10);
    }

    public static void I(boolean bl2) {
        d.v.e.d.s(j0.z(), a, c, bl2);
    }

    public static void J(String string2) {
        d.v.e.d.x(j0.z(), a, e, string2);
    }

    private static Context z() {
        return d.v.e.f.a().c();
    }
}

