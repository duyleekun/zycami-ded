/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.i1;

import android.content.Context;
import d.v.e.d;
import d.v.e.f;

public class j2
extends d {
    private static final String a = "editor_preference";
    private static final String b = "key_app_crash";
    private static final String c = "key_show_media_remove_guide";
    private static final String d = "key_show_editor_main_guide";
    private static final String e = "key_show_compose_guide";
    private static final String f = "key_show_media_remove_and_sort_guide";
    private static final String g = "key_show_alter_template_guide";
    private static final String h = "key_show_swipe_video_guide";

    public static boolean A() {
        return d.v.e.d.d(j2.C(), a, b, false);
    }

    public static boolean B() {
        return d.v.e.d.c(j2.C(), a, e);
    }

    private static Context C() {
        return d.v.e.f.a().c();
    }

    public static boolean D() {
        return d.v.e.d.c(j2.C(), a, d);
    }

    public static boolean E() {
        return d.v.e.d.c(j2.C(), a, f);
    }

    public static boolean F() {
        return d.v.e.d.c(j2.C(), a, c);
    }

    public static boolean G() {
        return d.v.e.d.c(j2.C(), a, h);
    }

    public static void H(boolean bl2) {
        d.v.e.d.s(j2.C(), a, g, bl2);
    }

    public static void I(boolean bl2) {
        d.v.e.d.s(j2.C(), a, b, bl2);
    }

    public static void J(boolean bl2) {
        d.v.e.d.s(j2.C(), a, e, bl2);
    }

    public static void K(boolean bl2) {
        d.v.e.d.s(j2.C(), a, d, bl2);
    }

    public static void L(boolean bl2) {
        d.v.e.d.s(j2.C(), a, f, bl2);
    }

    public static void M(boolean bl2) {
        d.v.e.d.s(j2.C(), a, c, bl2);
    }

    public static void N(boolean bl2) {
        d.v.e.d.s(j2.C(), a, h, bl2);
    }

    public static boolean z() {
        return d.v.e.d.c(j2.C(), a, g);
    }
}

