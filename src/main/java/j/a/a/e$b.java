/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package j.a.a;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import j.a.a.i.e;
import pub.devrel.easypermissions.R$string;

public final class e$b {
    private final e a;
    private final int b;
    private final String[] c;
    private String d;
    private String e;
    private String f;
    private int g = -1;

    public e$b(Activity object, int n10, String ... stringArray) {
        object = j.a.a.i.e.d(object);
        this.a = object;
        this.b = n10;
        this.c = stringArray;
    }

    public e$b(Fragment object, int n10, String ... stringArray) {
        this.a = object = j.a.a.i.e.e((Fragment)object);
        this.b = n10;
        this.c = stringArray;
    }

    public j.a.a.e a() {
        int n10;
        Object object = this.d;
        if (object == null) {
            object = this.a.b();
            n10 = R$string.rationale_ask;
            object = object.getString(n10);
            this.d = object;
        }
        if ((object = this.e) == null) {
            object = this.a.b();
            n10 = 17039370;
            this.e = object = object.getString(n10);
        }
        if ((object = this.f) == null) {
            object = this.a.b();
            n10 = 0x1040000;
            this.f = object = object.getString(n10);
        }
        e e10 = this.a;
        String[] stringArray = this.c;
        int n11 = this.b;
        String string2 = this.d;
        String string3 = this.e;
        String string4 = this.f;
        int n12 = this.g;
        object = new j.a.a.e(e10, stringArray, n11, string2, string3, string4, n12, null);
        return object;
    }

    public e$b b(int n10) {
        String string2;
        this.f = string2 = this.a.b().getString(n10);
        return this;
    }

    public e$b c(String string2) {
        this.f = string2;
        return this;
    }

    public e$b d(int n10) {
        String string2;
        this.e = string2 = this.a.b().getString(n10);
        return this;
    }

    public e$b e(String string2) {
        this.e = string2;
        return this;
    }

    public e$b f(int n10) {
        String string2;
        this.d = string2 = this.a.b().getString(n10);
        return this;
    }

    public e$b g(String string2) {
        this.d = string2;
        return this;
    }

    public e$b h(int n10) {
        this.g = n10;
        return this;
    }
}

