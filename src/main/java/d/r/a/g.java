/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package d.r.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import d.r.a.u.s;
import java.io.Serializable;
import java.util.ArrayList;

public final class g {
    public Bundle a;
    public String b;
    private String c;

    public g(String string2, String string3, Bundle bundle) {
        this.b = string2;
        this.c = string3;
        this.a = bundle;
    }

    public static g a(Intent object) {
        boolean bl2;
        String string2;
        String string3;
        boolean bl3;
        String string4 = "BundleWapper";
        String string5 = null;
        if (object == null) {
            s.a(string4, "create error : intent is null");
            return null;
        }
        Bundle bundle = object.getExtras();
        if (bundle == null || (bl3 = TextUtils.isEmpty((CharSequence)(string3 = bundle.getString("client_pkgname"))))) {
            string3 = null;
        }
        bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            string2 = "create warning: pkgName is null";
            s.h(string4, string2);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)(string2 = object.getPackage()))) {
            string2 = object.getComponent();
            if (string2 != null) {
                object = object.getComponent();
                string5 = object.getPackageName();
            }
            boolean bl4 = TextUtils.isEmpty(string5);
            if (bl4) {
                object = "create warning: targetPkgName is null";
                s.h(string4, (String)object);
            }
            string2 = string5;
        }
        object = new g(string3, string2, bundle);
        return object;
    }

    public final String b(String string2) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(string2);
    }

    public final void c(String string2, int n10) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = bundle = new Bundle();
        }
        this.a.putInt(string2, n10);
    }

    public final void d(String string2, long l10) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = bundle = new Bundle();
        }
        this.a.putLong(string2, l10);
    }

    public final void e(String string2, Serializable serializable) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = bundle = new Bundle();
        }
        this.a.putSerializable(string2, serializable);
    }

    public final void f(String string2, String string3) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = bundle = new Bundle();
        }
        this.a.putString(string2, string3);
    }

    public final void g(String string2, ArrayList arrayList) {
        Bundle bundle = this.a;
        if (bundle == null) {
            this.a = bundle = new Bundle();
        }
        this.a.putStringArrayList(string2, arrayList);
    }

    public final int h(String string2, int n10) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return n10;
        }
        return bundle.getInt(string2, n10);
    }

    public final long i(String string2, long l10) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return l10;
        }
        return bundle.getLong(string2, l10);
    }

    public final ArrayList j(String string2) {
        Bundle bundle = this.a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(string2);
    }
}

