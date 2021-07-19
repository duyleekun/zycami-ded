/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.v0.u.b0;

import android.content.Context;
import com.zhiyun.cama.data.api.entity.ServerEntity;
import d.v.e.d;
import d.v.e.f;

public class c
extends d {
    private static final String A = "KEY_STORY_CUSTOM_GUIDE_PLAYED";
    private static final String a = "setting_preference";
    private static final String b = "key_agree_private_played";
    private static final String c = "key_welcome_to_camera_played";
    private static final String d = "key_init_set_dialog_played";
    private static final String e = "key_use_panorama_clone_first";
    private static final String f = "key_connected_device_name";
    private static final String g = "key_use_mobile_net";
    private static final String h = "key_use_mobile_net_editor";
    private static final String i = "key_use_mobile_net_video_play";
    private static final String j = "key_use_mobile_net_publish";
    private static final String k = "key_use_gps_location";
    private static final String l = "key_guide_played";
    private static final String m = "key_new_guide_played";
    private static final String n = "key_publish_guide_played";
    private static final String o = "key_camera_guide_played";
    private static final String p = "key_hitchcock_guide_played";
    private static final String q = "key_camera_guide_theme_played";
    private static final String r = "key_wifi_auto_download_firmware";
    private static final String s = "key_activate_device";
    private static final String t = "key_prime_direct_publish_warn";
    private static final String u = "key_local_server";
    private static final String v = "key_live_screen_capture_open_guide";
    private static final String w = "prime_web_prime_notify";
    private static final String x = "update_get_develop_version";
    private static final String y = "key_support_ball";
    private static final String z = "KEY_STORY_MORE_GUIDE_PLAYED";

    public static boolean A() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, b, false);
    }

    public static void A0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, x, bl2);
    }

    public static boolean B() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, o, false);
    }

    private static void B0() {
        boolean bl2 = d.v.c.v0.u.b0.c.S();
        d.v.c.v0.u.b0.c.u0(bl2);
        if (bl2) {
            d.v.c.v0.u.b0.c.g0(bl2);
            d.v.c.v0.u.b0.c.w0(bl2);
        } else {
            Context context = d.v.c.v0.u.b0.c.E();
            String string2 = a;
            d.v.e.d.q(context, string2, h);
            context = d.v.c.v0.u.b0.c.E();
            String string3 = i;
            d.v.e.d.q(context, string2, string3);
        }
    }

    public static boolean C() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, q, false);
    }

    public static String D() {
        return d.v.e.d.m(d.v.c.v0.u.b0.c.E(), a, f, "");
    }

    private static Context E() {
        return d.v.e.f.a().c();
    }

    public static boolean F() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, x, true);
    }

    public static boolean G() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, l, false);
    }

    public static boolean H() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, p, false);
    }

    public static boolean I() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, d, false);
    }

    public static boolean J() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, v, true);
    }

    public static ServerEntity K() {
        String string2 = d.v.e.d.l(d.v.c.v0.u.b0.c.E(), a, u);
        return (ServerEntity)d.v.e.l.q2.c.a(ServerEntity.class, string2);
    }

    public static boolean L() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, m, false);
    }

    public static boolean M() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, t, true);
    }

    public static boolean N() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, n, false);
    }

    public static boolean O() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, A, false);
    }

    public static boolean P() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, z, false);
    }

    public static boolean Q() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, y, true);
    }

    public static boolean R() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, k, true);
    }

    public static boolean S() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, g, true);
    }

    public static boolean T() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, j, false);
    }

    public static boolean U() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, e, true);
    }

    public static boolean V() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, i, false);
    }

    public static boolean W() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, w, true);
    }

    public static boolean X() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, c, false);
    }

    public static boolean Y() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, r, true);
    }

    public static void Z() {
        d.v.c.v0.u.b0.c.B0();
        d.v.c.v0.u.b0.c.a0();
    }

    private static void a0() {
        d.v.c.v0.u.b0.c.x0(true);
    }

    public static void b0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, s, bl2);
    }

    public static void c0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, b, bl2);
    }

    public static void d0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, o, bl2);
    }

    public static void e0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, q, bl2);
    }

    public static void f0(String string2) {
        d.v.e.d.x(d.v.c.v0.u.b0.c.E(), a, f, string2);
    }

    public static void g0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, h, bl2);
    }

    public static void h0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, l, bl2);
    }

    public static void i0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, p, bl2);
    }

    public static void j0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, d, bl2);
    }

    public static void k0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, v, bl2);
    }

    public static void l0(ServerEntity object) {
        Context context = d.v.c.v0.u.b0.c.E();
        object = d.v.e.l.q2.c.h(ServerEntity.class, object);
        d.v.e.d.x(context, a, u, (String)object);
    }

    public static void m0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, m, bl2);
    }

    public static void n0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, t, bl2);
    }

    public static void o0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, n, bl2);
    }

    public static void p0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, A, bl2);
    }

    public static void q0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, z, bl2);
    }

    public static void r0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, y, bl2);
    }

    public static void s0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, k, bl2);
    }

    public static void t0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, g, bl2);
        d.v.c.v0.u.b0.c.B0();
    }

    public static void u0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, j, bl2);
    }

    public static void v0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, e, bl2);
    }

    public static void w0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, i, bl2);
    }

    public static void x0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, w, bl2);
    }

    public static void y0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, c, bl2);
    }

    public static boolean z() {
        return d.v.e.d.d(d.v.c.v0.u.b0.c.E(), a, s, true);
    }

    public static void z0(boolean bl2) {
        d.v.e.d.s(d.v.c.v0.u.b0.c.E(), a, r, bl2);
    }
}

