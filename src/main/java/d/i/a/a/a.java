/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONObject
 */
package d.i.a.a;

import android.content.Context;
import d.i.a.a.c.d;
import java.util.List;
import org.json.JSONObject;

public class a {
    public static final String a = "push_show";
    public static final String b = "push_no_show";
    public static final String c = "push_read_message";
    public static final String d = "push_click";
    public static final String e = "app_black_list";
    public static final String f = "push_exception";
    public static final String g = "push_delete";
    public static final String h = "push_revoke";
    public static final String i = "push_revoke_delete";
    public static final String j = "add_message_top";
    public static final String k = "add_message_no_disturbing";
    public static final String l = "imsi_not_exist";
    public static final String m = "message_repeat";

    public static void A(JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().h(jSONObject);
    }

    public static void B(String string2, String string3) {
        com.heytap.mcssdk.d.k().a(string2, string3);
    }

    public static void C(int n10) {
        d.i.a.a.a.D(n10, null);
    }

    public static void D(int n10, JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().a(n10, jSONObject);
    }

    public static void E(d.i.a.a.b.a a10) {
        com.heytap.mcssdk.d.k().a(a10);
    }

    public static void F(List list, int n10, int n11, int n12, int n13) {
        d.i.a.a.a.G(list, n10, n11, n12, n13, null);
    }

    public static void G(List list, int n10, int n11, int n12, int n13, JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().a(list, n10, n11, n12, n13, jSONObject);
    }

    public static void H(String string2) {
        com.heytap.mcssdk.d.k().a(string2);
    }

    public static void I(Context context, d d10) {
        com.heytap.mcssdk.d.a(context, d10);
    }

    public static void J(Context context, List list) {
        com.heytap.mcssdk.d.a(context, list);
    }

    public static void K() {
        d.i.a.a.a.M(null);
    }

    public static void L(Context context, String string2, String string3, JSONObject jSONObject, d.i.a.a.b.a a10) {
        com.heytap.mcssdk.d.k().b(context, string2, string3, jSONObject, a10);
    }

    public static void M(JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().b(jSONObject);
    }

    public static void a() {
        d.i.a.a.a.b(null);
    }

    public static void b(JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().d(jSONObject);
    }

    public static void c() {
        d.i.a.a.a.d(null);
    }

    public static void d(JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().d(jSONObject);
    }

    public static String e() {
        return com.heytap.mcssdk.d.k().l();
    }

    public static void f() {
        d.i.a.a.a.g(null);
    }

    public static void g(JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().c(jSONObject);
    }

    public static d.i.a.a.b.a h() {
        return com.heytap.mcssdk.d.k().q();
    }

    public static void i() {
        com.heytap.mcssdk.d.k().r();
    }

    public static int j() {
        return com.heytap.mcssdk.d.k().u();
    }

    public static String k() {
        return com.heytap.mcssdk.d.k().t();
    }

    public static String l() {
        return com.heytap.mcssdk.d.k().m();
    }

    public static void m() {
        d.i.a.a.a.n(null);
    }

    public static void n(JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().a(jSONObject);
    }

    public static String o() {
        return com.heytap.mcssdk.d.k().a();
    }

    public static String p() {
        return com.heytap.mcssdk.d.s();
    }

    public static void q(Context context, boolean bl2) {
        com.heytap.mcssdk.d.k().a(context, bl2);
    }

    public static boolean r() {
        return com.heytap.mcssdk.d.k().n();
    }

    public static void s() {
        d.i.a.a.a.t(null);
    }

    public static void t(JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().f(jSONObject);
    }

    public static void u() {
        d.i.a.a.a.v(null);
    }

    public static void v(JSONObject jSONObject) {
        com.heytap.mcssdk.d.k().g(jSONObject);
    }

    public static void w(Context context, String string2, String string3, d.i.a.a.b.a a10) {
        d.i.a.a.a.x(context, string2, string3, null, a10);
    }

    public static void x(Context context, String string2, String string3, JSONObject jSONObject, d.i.a.a.b.a a10) {
        com.heytap.mcssdk.d.k().a(context, string2, string3, jSONObject, a10);
    }

    public static void y() {
        com.heytap.mcssdk.d.k().j();
    }

    public static void z() {
        d.i.a.a.a.A(null);
    }
}

