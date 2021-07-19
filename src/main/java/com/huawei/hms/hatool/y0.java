/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.hatool.f;
import com.huawei.hms.hatool.i;
import com.huawei.hms.hatool.l;
import com.huawei.hms.hatool.v0;
import com.huawei.hms.hatool.w0;
import com.huawei.hms.hatool.z0;

public abstract class y0 {
    public final v0 a(int n10, Context object) {
        int n11;
        Object object2;
        if (n10 != 0) {
            object2 = this.f();
            n11 = TextUtils.isEmpty((CharSequence)object2);
            if (n11 == 0) {
                object = w0.b;
                v0 v02 = new v0((w0)((Object)object), (String)object2);
                return v02;
            }
        } else {
            object2 = "";
        }
        if ((n11 = n10 & 2) != 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)(object2 = this.b((Context)object))) ? 1 : 0)) == 0) {
            object = w0.a;
            v0 v03 = new v0((w0)((Object)object), (String)object2);
            return v03;
        }
        if ((n10 &= 1) != 0) {
            String string2 = this.c((Context)object);
            object2 = w0.c;
            object = new v0((w0)((Object)object2), string2);
            return object;
        }
        object = w0.d;
        v0 v04 = new v0((w0)((Object)object), (String)object2);
        return v04;
    }

    public v0 a(Context object) {
        Object object2 = this.c();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            w0 w02 = w0.b;
            object = new v0(w02, (String)object2);
            return object;
        }
        object2 = this.a();
        bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            w0 w03 = w0.a;
            object = new v0(w03, (String)object2);
            return object;
        }
        int n10 = this.e();
        String string2 = this.b();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3) {
            if (n10 != 0) {
                object2 = w0.c;
                object = new v0((w0)((Object)object2), string2);
                return object;
            }
            object2 = w0.b;
            string2 = this.a(string2);
            object = new v0((w0)((Object)object2), string2);
            return object;
        }
        if (n10 != 0) {
            n10 = this.d();
            return this.a(n10, (Context)object);
        }
        n10 = this.d();
        return this.b(n10, (Context)object);
    }

    public abstract String a();

    public abstract String a(String var1);

    public final v0 b(int n10, Context object) {
        Object object2;
        int n11 = n10 & 4;
        if (n11 != 0 && (n11 = n10 & 1) != 0) {
            w0 w02 = w0.b;
            object = this.c((Context)object);
            object = this.a((String)object);
            v0 v02 = new v0(w02, (String)object);
            return v02;
        }
        n11 = n10 & 1;
        if (n11 != 0) {
            object2 = this.c((Context)object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                object = w0.c;
                v0 v03 = new v0((w0)((Object)object), (String)object2);
                return v03;
            }
        } else {
            object2 = "";
        }
        if ((n10 &= 2) != 0) {
            String string2 = this.b((Context)object);
            object2 = w0.a;
            object = new v0((w0)((Object)object2), string2);
            return object;
        }
        object = w0.d;
        v0 v04 = new v0((w0)((Object)object), (String)object2);
        return v04;
    }

    public abstract String b();

    public final String b(Context object) {
        l l10 = i.c().b();
        String string2 = l10.m();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            object = z0.f(object);
            l10.h((String)object);
        }
        return l10.m();
    }

    public abstract String c();

    public final String c(Context object) {
        l l10 = i.c().b();
        String string2 = l10.a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            object = z0.h(object);
            l10.l((String)object);
        }
        return l10.a();
    }

    public abstract int d();

    public final boolean e() {
        l l10 = i.c().b();
        String string2 = l10.i();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = f.a();
            l10.e(string2);
        }
        return TextUtils.isEmpty((CharSequence)l10.i()) ^ true;
    }

    public final String f() {
        l l10 = i.c().b();
        String string2 = l10.c();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = z0.c();
            l10.m(string2);
        }
        return l10.c();
    }
}

