/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.j.g;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import d.v.e.l.b2;
import d.v.j.g.a0;

public class z
extends AndroidViewModel {
    public z(Application application) {
        super(application);
    }

    private Context b() {
        return this.getApplication();
    }

    private boolean d() {
        return b2.l(this.b());
    }

    public boolean c() {
        return a0.B();
    }

    public boolean e() {
        boolean bl2 = this.d();
        bl2 = bl2 && !(bl2 = a0.A());
        return bl2;
    }

    public boolean f() {
        return this.e();
    }

    public boolean g() {
        return b2.m(this.b());
    }

    public void i(boolean bl2) {
        a0.C(bl2);
    }
}

