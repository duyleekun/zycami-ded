/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.l.a.e;

import android.content.Context;
import d.l.a.c;

public final class a {
    public static final int A = 64527;
    public static final String B = "com.smile.gifmaker";
    private static final String C = "https://open.test.gifshow.com";
    private static final String D = "https://open.kuaishou.com";
    public static final String E = "KWAI_APP_ID";
    public static final String F = "KWAI_SCOPE";
    public static final String a = "";
    public static final String b = "extra_url";
    public static final String c = "extra_title";
    public static final String d = "extra_request_code";
    public static final String e = "extra_need_show_title";
    public static final String f = "extra_load_url_method";
    public static final String g = "extra_post_param";
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 1000;
    public static final int k = 1001;
    public static final int l = 1002;
    public static final int m = 1003;
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 0;
    public static final int q = 255;
    public static final int r = 64536;
    public static final int s = 64535;
    public static final int t = 55534;
    public static final int u = 64533;
    public static final int v = 64532;
    public static final int w = 64531;
    public static final int x = 64530;
    public static final int y = 64529;
    public static final int z = 64528;

    public static String a() {
        c c10 = d.l.a.c.f();
        boolean bl2 = c10.j();
        if (bl2) {
            return C;
        }
        return D;
    }

    public static String b(Context object) {
        StringBuilder stringBuilder = new StringBuilder();
        object = object.getPackageName();
        stringBuilder.append((String)object);
        stringBuilder.append("://login/result");
        return stringBuilder.toString();
    }

    public static String c(String charSequence, String string2, String string3, String string4, Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence2 = d.l.a.e.a.a();
        stringBuilder.append((String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("/oauth2/authorize?app_id=");
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence = ((StringBuilder)charSequence2).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("&response_type=");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("&state=");
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("&scope=");
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        stringBuilder.append("&webVersion=1");
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("&redirect_uri=");
        string2 = d.l.a.e.a.b(context);
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        return stringBuilder.toString();
    }
}

