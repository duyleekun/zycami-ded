/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.push.gj;
import com.xiaomi.push.gn;
import com.xiaomi.push.gu;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gi
extends gj {
    private boolean a = false;
    private String b;
    private boolean b = null;
    private String c = null;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public gi() {
        String string2;
        this.i = string2 = "";
        this.j = string2;
        this.k = string2;
        this.l = string2;
        this.b = false;
    }

    public gi(Bundle object) {
        super((Bundle)object);
        String string2;
        boolean bl2;
        boolean bl3;
        String string3;
        this.i = string3 = "";
        this.j = string3;
        this.k = string3;
        this.l = string3;
        this.b = false;
        this.b = string3 = object.getString("ext_msg_type");
        this.d = string3 = object.getString("ext_msg_lang");
        this.c = string3 = object.getString("ext_msg_thread");
        this.e = string3 = object.getString("ext_msg_sub");
        this.f = string3 = object.getString("ext_msg_body");
        this.g = string3 = object.getString("ext_body_encode");
        this.h = string3 = object.getString("ext_msg_appid");
        this.a = bl3 = object.getBoolean("ext_msg_trans", false);
        this.b = bl2 = object.getBoolean("ext_msg_encrypt", false);
        this.i = string2 = object.getString("ext_msg_seq");
        this.j = string2 = object.getString("ext_msg_mseq");
        this.k = string2 = object.getString("ext_msg_fseq");
        object = object.getString("ext_msg_status");
        this.l = object;
    }

    public Bundle a() {
        String string2;
        String string3;
        Bundle bundle = super.a();
        String string4 = this.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (!bl2) {
            string4 = this.b;
            string3 = "ext_msg_type";
            bundle.putString(string3, string4);
        }
        if ((string4 = this.d) != null) {
            string3 = "ext_msg_lang";
            bundle.putString(string3, string4);
        }
        if ((string4 = this.e) != null) {
            string3 = "ext_msg_sub";
            bundle.putString(string3, string4);
        }
        if ((string4 = this.f) != null) {
            string3 = "ext_msg_body";
            bundle.putString(string3, string4);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string4 = this.g)))) {
            string4 = this.g;
            string3 = "ext_body_encode";
            bundle.putString(string3, string4);
        }
        if ((string4 = this.c) != null) {
            string3 = "ext_msg_thread";
            bundle.putString(string3, string4);
        }
        if ((string4 = this.h) != null) {
            string3 = "ext_msg_appid";
            bundle.putString(string3, string4);
        }
        bl2 = this.a;
        boolean bl3 = true;
        if (bl2) {
            string4 = "ext_msg_trans";
            bundle.putBoolean(string4, bl3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string4 = this.i)))) {
            string4 = this.i;
            string2 = "ext_msg_seq";
            bundle.putString(string2, string4);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string4 = this.j)))) {
            string4 = this.j;
            string2 = "ext_msg_mseq";
            bundle.putString(string2, string4);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string4 = this.k)))) {
            string4 = this.k;
            string2 = "ext_msg_fseq";
            bundle.putString(string2, string4);
        }
        if (bl2 = this.b) {
            string4 = "ext_msg_encrypt";
            bundle.putBoolean(string4, bl3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string4 = this.l)))) {
            string4 = this.l;
            string3 = "ext_msg_status";
            bundle.putString(string3, string4);
        }
        return bundle;
    }

    public String a() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<message");
        Object object = this.p();
        String string2 = "\"";
        if (object != null) {
            stringBuilder.append(" xmlns=\"");
            object = this.p();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if ((object = this.d) != null) {
            stringBuilder.append(" xml:lang=\"");
            object = this.h();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if ((object = this.j()) != null) {
            stringBuilder.append(" id=\"");
            object = this.j();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if ((object = this.l()) != null) {
            stringBuilder.append(" to=\"");
            object = gu.a(this.l());
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(object = this.d())))) {
            stringBuilder.append(" seq=\"");
            object = this.d();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(object = this.e())))) {
            stringBuilder.append(" mseq=\"");
            object = this.e();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(object = this.f())))) {
            stringBuilder.append(" fseq=\"");
            object = this.f();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(object = this.g())))) {
            stringBuilder.append(" status=\"");
            object = this.g();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if ((object = this.m()) != null) {
            stringBuilder.append(" from=\"");
            object = gu.a(this.m());
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if ((object = this.k()) != null) {
            stringBuilder.append(" chid=\"");
            object = gu.a(this.k());
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if (bl2 = this.a) {
            object = " transient=\"true\"";
            stringBuilder.append((String)object);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(object = this.h)))) {
            stringBuilder.append(" appid=\"");
            object = this.c();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b)))) {
            stringBuilder.append(" type=\"");
            object = this.b;
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        if (bl2 = this.b) {
            object = " s=\"1\"";
            stringBuilder.append((String)object);
        }
        object = ">";
        stringBuilder.append((String)object);
        String string3 = this.e;
        if (string3 != null) {
            stringBuilder.append("<subject>");
            string3 = gu.a(this.e);
            stringBuilder.append(string3);
            string3 = "</subject>";
            stringBuilder.append(string3);
        }
        if ((string3 = this.f) != null) {
            stringBuilder.append("<body");
            string3 = this.g;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl3) {
                stringBuilder.append(" encode=\"");
                string3 = this.g;
                stringBuilder.append(string3);
                stringBuilder.append(string2);
            }
            stringBuilder.append((String)object);
            object = gu.a(this.f);
            stringBuilder.append((String)object);
            object = "</body>";
            stringBuilder.append((String)object);
        }
        if ((object = this.c) != null) {
            stringBuilder.append("<thread>");
            object = this.c;
            stringBuilder.append((String)object);
            object = "</thread>";
            stringBuilder.append((String)object);
        }
        if ((bl2 = (string2 = "error").equalsIgnoreCase((String)(object = this.b))) && (object = this.a()) != null) {
            object = ((gn)object).a();
            stringBuilder.append((String)object);
        }
        object = this.o();
        stringBuilder.append((String)object);
        stringBuilder.append("</message>");
        return stringBuilder.toString();
    }

    public void a(String string2) {
        this.h = string2;
    }

    public void a(String string2, String string3) {
        this.f = string2;
        this.g = string3;
    }

    public void a(boolean bl2) {
        this.a = bl2;
    }

    public String b() {
        return this.b;
    }

    public void b(String string2) {
        this.i = string2;
    }

    public void b(boolean bl2) {
        this.b = bl2;
    }

    public String c() {
        return this.h;
    }

    public void c(String string2) {
        this.j = string2;
    }

    public String d() {
        return this.i;
    }

    public void d(String string2) {
        this.k = string2;
    }

    public String e() {
        return this.j;
    }

    public void e(String string2) {
        this.l = string2;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3 = super.equals(object = (gi)object);
            if (!bl3) {
                return false;
            }
            object3 = this.f;
            if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((gi)object).f)) : (object3 = ((gi)object).f) != null) {
                return false;
            }
            object3 = this.d;
            if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((gi)object).d)) : (object3 = ((gi)object).d) != null) {
                return false;
            }
            object3 = this.e;
            if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((gi)object).e)) : (object3 = ((gi)object).e) != null) {
                return false;
            }
            object3 = this.c;
            if (object3 != null ? !(bl3 = ((String)object3).equals(object2 = ((gi)object).c)) : (object3 = ((gi)object).c) != null) {
                return false;
            }
            object3 = this.b;
            object = ((gi)object).b;
            if (object3 != object) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public void f(String string2) {
        this.b = string2;
    }

    public String g() {
        return this.l;
    }

    public void g(String string2) {
        this.e = string2;
    }

    public String h() {
        return this.d;
    }

    public void h(String string2) {
        this.f = string2;
    }

    public int hashCode() {
        int n10;
        int n11;
        String string2 = this.b;
        int n12 = 0;
        if (string2 != null) {
            n11 = string2.hashCode();
        } else {
            n11 = 0;
            string2 = null;
        }
        n11 *= 31;
        String string3 = this.f;
        if (string3 != null) {
            n10 = string3.hashCode();
        } else {
            n10 = 0;
            string3 = null;
        }
        n11 = (n11 + n10) * 31;
        string3 = this.c;
        if (string3 != null) {
            n10 = string3.hashCode();
        } else {
            n10 = 0;
            string3 = null;
        }
        n11 = (n11 + n10) * 31;
        string3 = this.d;
        if (string3 != null) {
            n10 = string3.hashCode();
        } else {
            n10 = 0;
            string3 = null;
        }
        n11 = (n11 + n10) * 31;
        string3 = this.e;
        if (string3 != null) {
            n12 = string3.hashCode();
        }
        return n11 + n12;
    }

    public void i(String string2) {
        this.c = string2;
    }

    public void j(String string2) {
        this.d = string2;
    }
}

