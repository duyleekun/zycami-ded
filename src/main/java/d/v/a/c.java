/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.text.SpannableString
 *  android.view.View
 */
package d.v.a;

import android.content.Context;
import android.database.Cursor;
import android.text.SpannableString;
import android.view.View;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$string;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.a;
import d.v.a.c$a;
import d.v.a.f.c.b;
import d.v.a.f.c.d.d;
import d.v.e.l.t1;
import d.v.f.i.g;

public class c {
    public static boolean a = true;
    private static boolean b = false;
    private static boolean c = false;
    private static c$a d;

    public static void a(int n10, Cursor cursor) {
        Object object = cursor;
        int n11 = cursor.moveToFirst();
        if (n11 != 0) {
            n11 = cursor.getColumnIndex("avatar");
            String string2 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("nickname");
            String string3 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("birthday");
            String string4 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("country");
            String string5 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("city");
            String string6 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("introduction");
            String string7 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("hobby");
            String string8 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("sex");
            int n12 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("share_post_count");
            int n13 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("follows_count");
            int n14 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("followers_count");
            int n15 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("token");
            String string9 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("followed");
            int n16 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("verified");
            int n17 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("mobile");
            String string10 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("mail");
            String string11 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("adnotification");
            int n18 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("status");
            String string12 = cursor.getString(n11);
            n11 = cursor.getColumnIndex("longitude");
            double d10 = cursor.getDouble(n11);
            n11 = cursor.getColumnIndex("latitude");
            double d11 = cursor.getDouble(n11);
            n11 = cursor.getColumnIndex("memberId");
            int n19 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("applicantId");
            int n20 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("activity");
            int n21 = cursor.getInt(n11);
            n11 = cursor.getColumnIndex("rank");
            int n22 = cursor.getInt(n11);
            object = new UserInfo(n10, string2, string3, string4, string5, string6, string7, string8, n12, n13, n14, n15, string9, n16, n17, string10, string11, n18, string12, d10, d11, n19, n20, n21, n22, false, 0);
            b b10 = d.v.a.f.c.b.N();
            b10.r((UserInfo)object);
        }
    }

    public static SpannableString b(Context context) {
        Object object = d;
        if (object != null) {
            return object.a(context);
        }
        int n10 = R$string.me_agree_zhiyun;
        object = g.m(context, n10);
        int n11 = R$string.user_agreement;
        String string2 = g.m(context, n11);
        n11 = R$string.user_agreement_uri;
        String string3 = g.m(context, n11);
        int n12 = R$color.com_color_theme_to;
        int n13 = g.c(context, n12);
        Object object2 = new a(context, string2, string3);
        Object object3 = object;
        string3 = t1.a(null, (String)object, string2, n13, false, object2);
        int n14 = R$string.privacy_policy;
        string2 = g.m(context, n14);
        n14 = R$string.privacy_policy_uri;
        object3 = g.m(context, n14);
        n13 = g.c(context, n12);
        object2 = new d.v.a.b(context, string2, (String)object3);
        object3 = object;
        return t1.a((SpannableString)string3, (String)object, string2, n13, false, object2);
    }

    public static String c() {
        return d.v.a.f.c.d.d.H();
    }

    public static boolean d() {
        return a;
    }

    public static boolean e() {
        return b;
    }

    public static boolean f() {
        return c;
    }

    public static /* synthetic */ void g(Context context, String string2, String string3, View view) {
        SimpleWebViewActivity.j(context, string2, string3);
    }

    public static /* synthetic */ void h(Context context, String string2, String string3, View view) {
        SimpleWebViewActivity.j(context, string2, string3);
    }

    public static void i(boolean bl2) {
        b = bl2;
    }

    public static void j(c$a c$a) {
        d = c$a;
    }

    public static void k(String string2) {
        d.v.a.f.c.d.d.Z(string2);
    }

    public static void l(boolean bl2) {
        a = bl2;
    }

    public static void m(boolean bl2) {
        c = bl2;
    }
}

