/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 */
package j.a.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import j.a.a.b;
import pub.devrel.easypermissions.R$string;

public class b$b {
    private final Object a;
    private final Context b;
    private int c;
    private String d;
    private String e;
    private String f;
    private String g;
    private int h;
    private boolean i;

    public b$b(Activity activity) {
        int n10;
        this.c = n10 = -1;
        this.h = n10;
        this.i = false;
        this.a = activity;
        this.b = activity;
    }

    public b$b(Fragment fragment) {
        int n10;
        this.c = n10 = -1;
        this.h = n10;
        this.i = false;
        this.a = fragment;
        fragment = fragment.getContext();
        this.b = fragment;
    }

    public b a() {
        int n10;
        Object object = this.d;
        int n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            object = this.b;
            n10 = R$string.rationale_ask_again;
            object = object.getString(n10);
        } else {
            object = this.d;
        }
        this.d = object;
        object = this.e;
        n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            object = this.b;
            n10 = R$string.title_settings_dialog;
            object = object.getString(n10);
        } else {
            object = this.e;
        }
        this.e = object;
        object = this.f;
        n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            object = this.b;
            n10 = 17039370;
            object = object.getString(n10);
        } else {
            object = this.f;
        }
        this.f = object;
        object = this.g;
        n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 != 0) {
            object = this.b;
            n10 = 0x1040000;
            object = object.getString(n10);
        } else {
            object = this.g;
        }
        this.g = object;
        n11 = this.h;
        if (n11 <= 0) {
            n11 = 16061;
        }
        this.h = n11;
        n11 = 0;
        object = null;
        n10 = (int)(this.i ? 1 : 0);
        if (n10 != 0) {
            n11 = 0x10000000;
        }
        Object object2 = this.a;
        int n12 = this.c;
        String string2 = this.d;
        String string3 = this.e;
        String string4 = this.f;
        String string5 = this.g;
        int n13 = this.h;
        object = new b(object2, n12, string2, string3, string4, string5, n13, n11, null);
        return object;
    }

    public b$b b(int n10) {
        String string2;
        this.g = string2 = this.b.getString(n10);
        return this;
    }

    public b$b c(String string2) {
        this.g = string2;
        return this;
    }

    public b$b d(boolean bl2) {
        this.i = bl2;
        return this;
    }

    public b$b e(int n10) {
        String string2;
        this.f = string2 = this.b.getString(n10);
        return this;
    }

    public b$b f(String string2) {
        this.f = string2;
        return this;
    }

    public b$b g(int n10) {
        String string2;
        this.d = string2 = this.b.getString(n10);
        return this;
    }

    public b$b h(String string2) {
        this.d = string2;
        return this;
    }

    public b$b i(int n10) {
        this.h = n10;
        return this;
    }

    public b$b j(int n10) {
        this.c = n10;
        return this;
    }

    public b$b k(int n10) {
        String string2;
        this.e = string2 = this.b.getString(n10);
        return this;
    }

    public b$b l(String string2) {
        this.e = string2;
        return this;
    }
}

