/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.a$a;
import com.geetest.sdk.a$b;
import com.geetest.sdk.a$c;
import com.geetest.sdk.ac;
import com.geetest.sdk.ad$b;
import com.geetest.sdk.aj;
import com.geetest.sdk.b;
import com.geetest.sdk.j;
import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.utils.GT3ServiceNode;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.m;
import com.geetest.sdk.utils.n;
import java.io.File;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private Context a;
    private GT3ConfigBean b;
    private b c;
    private long d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public a(Context context) {
        this.a = context;
        if (context != null) {
            Object object;
            Object object2 = new b(context);
            this.c = object2;
            this.a(context);
            object2 = new StringBuilder();
            Object object3 = context.getApplicationContext().getCacheDir();
            ((StringBuilder)object2).append(object3);
            object3 = File.separator;
            ((StringBuilder)object2).append((String)object3);
            n.f = ((StringBuilder)object2).toString();
            boolean bl2 = false;
            object2 = context.getExternalFilesDir(null);
            object3 = context.getFilesDir().getAbsolutePath();
            if (object2 != null) {
                try {
                    object = ((File)object2).getAbsolutePath();
                    m.a = object;
                    object3 = ((File)object2).getAbsolutePath();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            object2 = new ad$b();
            object2 = ((ad$b)object2).a((String)object3).b((String)object3);
            object3 = "0123456789012345";
            object = ((String)object3).getBytes();
            object2 = ((ad$b)object2).b((byte[])object);
            object3 = ((String)object3).getBytes();
            ac.a(((ad$b)object2).a((byte[])object3).a());
            bl2 = true;
            ac.a(bl2);
            object2 = new a$a(this);
            ac.a((aj)object2);
            try {
                ac.a();
            }
            catch (Exception exception) {}
            try {
                object3 = j.a();
                object3 = ((j)object3).a(context);
                object2 = new JSONObject((String)object3);
                object3 = "fp";
                object2 = object2.getString((String)object3);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                object2 = "";
            }
            String string2 = context.getPackageName();
            a$b a$b = new a$b(this);
            object = "https://log.geetest.com/logger/mobile/log";
            String string3 = "1";
            object3 = context;
            ac.a(context, (String)object, string2, string3, (String)object2, a$b);
        }
    }

    private void a(Context context) {
        String string2;
        String string3 = "unknown";
        String string4 = (context = context.getSharedPreferences("mydata", 0)).getString(string2 = "uuid", string3);
        boolean bl2 = string3.equals(string4);
        if (bl2) {
            context = context.edit();
            string3 = UUID.randomUUID().toString();
            context = context.putString(string2, string3);
            context.apply();
        }
    }

    private void i() {
        Object object = this.b;
        Object object2 = "GeetestUtilsHolder";
        if (object != null) {
            if ((object = ((GT3ConfigBean)object).getListener()) != null) {
                object = this.a;
                if (object != null) {
                    boolean bl2 = object instanceof Activity;
                    if (bl2) {
                        return;
                    }
                    object = "Context must be activity type !";
                    l.b((String)object2, (String)object);
                    object2 = new IllegalArgumentException((String)object);
                    throw object2;
                }
                object = "Context cannot be null !";
                l.b((String)object2, (String)object);
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            object = "Listener cannot be null !";
            l.b((String)object2, (String)object);
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        object = "GT3ConfigBean cannot be null !";
        l.b((String)object2, (String)object);
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private int j() {
        int n10;
        GT3ConfigBean gT3ConfigBean = this.b;
        int n11 = gT3ConfigBean.getPattern();
        if (n11 == (n10 = 2)) {
            return n10;
        }
        this.b.getPattern();
        return 1;
    }

    public void a() {
        this.c.a();
    }

    public void a(GT3ConfigBean object) {
        boolean n10 = ((GT3ConfigBean)object).isReleaseLog();
        l.a(n10);
        String string2 = "GeetestUtilsHolder";
        l.b(string2, "GT3Version-->4.3.3");
        this.b = object;
        this.i();
        Object object2 = this.a.getResources().getConfiguration().locale;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Lang-->");
        CharSequence charSequence2 = ((GT3ConfigBean)object).getLang();
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence2);
        String string3 = "null";
        charSequence2 = bl2 ? string3 : ((GT3ConfigBean)object).getLang();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(", Default Lang-->");
        charSequence2 = ((Locale)object2).getLanguage();
        ((StringBuilder)charSequence).append((String)charSequence2);
        charSequence = ((StringBuilder)charSequence).toString();
        l.b(string2, (String)charSequence);
        charSequence = ((GT3ConfigBean)object).getLang();
        boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl3) {
            charSequence = ((Locale)object2).getLanguage();
            bl3 = TextUtils.equals((CharSequence)"in", (CharSequence)charSequence);
            charSequence2 = "";
            String string4 = "-";
            if (bl3) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("id");
                String string6 = ((Locale)object2).getCountry();
                boolean bl5 = TextUtils.isEmpty((CharSequence)string6);
                if (!bl5) {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append(string4);
                    object2 = ((Locale)object2).getCountry();
                    ((StringBuilder)charSequence2).append((String)object2);
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                }
                ((StringBuilder)charSequence).append((String)charSequence2);
                object2 = ((StringBuilder)charSequence).toString();
                ((GT3ConfigBean)object).setLang((String)object2);
            } else {
                charSequence = ((Locale)object2).getLanguage();
                bl3 = TextUtils.isEmpty((CharSequence)charSequence);
                if (bl3) {
                    object2 = "zh";
                } else {
                    charSequence = new StringBuilder();
                    String string5 = ((Locale)object2).getLanguage();
                    ((StringBuilder)charSequence).append(string5);
                    string5 = ((Locale)object2).getCountry();
                    boolean bl4 = TextUtils.isEmpty((CharSequence)string5);
                    if (!bl4) {
                        charSequence2 = new StringBuilder();
                        ((StringBuilder)charSequence2).append(string4);
                        object2 = ((Locale)object2).getCountry();
                        ((StringBuilder)charSequence2).append((String)object2);
                        charSequence2 = ((StringBuilder)charSequence2).toString();
                    }
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    object2 = ((StringBuilder)charSequence).toString();
                }
                ((GT3ConfigBean)object).setLang((String)object2);
            }
        }
        i.a(this.a);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Parsed Lang-->");
        charSequence = ((GT3ConfigBean)object).getLang();
        bl3 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl3) {
            string3 = ((GT3ConfigBean)object).getLang();
        }
        ((StringBuilder)object2).append(string3);
        object2 = ((StringBuilder)object2).toString();
        l.b(string2, (String)object2);
        this.c.a((GT3ConfigBean)object);
        object = this.c;
        int n11 = this.j();
        ((b)object).a(n11);
    }

    public void b() {
        this.c.b();
    }

    public void c() {
        this.c.c();
    }

    public b d() {
        return this.c;
    }

    public void e() {
        Object object = this.b;
        String string2 = "api.geetest.com";
        if (object != null && (object = ((GT3ConfigBean)object).getGt3ServiceNode()) != null) {
            object = a$c.a;
            GT3ServiceNode gT3ServiceNode = this.b.getGt3ServiceNode();
            int n10 = gT3ServiceNode.ordinal();
            GT3ConfigBean gT3ConfigBean = object[n10];
            if (gT3ConfigBean != (n10 = 1)) {
                n10 = 2;
                if (gT3ConfigBean != n10) {
                    n10 = 3;
                    if (gT3ConfigBean != n10) {
                        object = this.c;
                        ((b)object).a(string2);
                    } else {
                        object = this.c;
                        string2 = "apiv6.geetest.com";
                        ((b)object).a(string2);
                    }
                } else {
                    object = this.c;
                    string2 = "api-ng.geetest.com";
                    ((b)object).a(string2);
                }
            } else {
                object = this.c;
                string2 = "api-na.geetest.com";
                ((b)object).a(string2);
            }
        } else {
            object = this.c;
            ((b)object).a(string2);
        }
        this.c.m();
    }

    public void f() {
        this.c.i();
    }

    public void g() {
        this.c.k();
    }

    public void h() {
        long l10 = System.currentTimeMillis();
        long l11 = this.d;
        long l12 = (l10 -= l11) - (l11 = 1000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            return;
        }
        this.d = l10 = System.currentTimeMillis();
        Object object2 = this.b;
        String string2 = "api.geetest.com";
        if (object2 != null && (object2 = ((GT3ConfigBean)object2).getGt3ServiceNode()) != null) {
            object2 = a$c.a;
            GT3ServiceNode gT3ServiceNode = this.b.getGt3ServiceNode();
            int n10 = gT3ServiceNode.ordinal();
            object = object2[n10];
            if (object != (n10 = 1)) {
                n10 = 2;
                if (object != n10) {
                    n10 = 3;
                    if (object != n10) {
                        object2 = this.c;
                        ((b)object2).a(string2);
                    } else {
                        object2 = this.c;
                        string2 = "apiv6.geetest.com";
                        ((b)object2).a(string2);
                    }
                } else {
                    object2 = this.c;
                    string2 = "api-ng.geetest.com";
                    ((b)object2).a(string2);
                }
            } else {
                object2 = this.c;
                string2 = "api-na.geetest.com";
                ((b)object2).a(string2);
            }
        } else {
            object2 = this.c;
            ((b)object2).a(string2);
        }
        this.c.l();
    }
}

