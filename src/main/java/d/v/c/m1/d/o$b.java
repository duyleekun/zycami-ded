/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.c.m1.d;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import d.v.c.m1.d.n;
import d.v.c.m1.d.o;

public final class o$b {
    public final /* synthetic */ o a;

    public o$b(o o10) {
        this.a = o10;
    }

    public void a() {
        String string2 = this.a.G();
        View view = o.F((o)this.a).k;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            n10 = 8;
        } else {
            n10 = 0;
            string2 = null;
        }
        view.setVisibility(n10);
    }

    public void b() {
        o.F((o)this.a).b.setText((CharSequence)"");
    }

    public void c() {
        Object object = o.E(this.a);
        boolean bl2 = ((n)object).g;
        if (!bl2) {
            object = this.a;
            ((DialogFragment)object).dismiss();
        }
        if ((object = o.E((o)this.a).i) != null) {
            object = o.E((o)this.a).i;
            o o10 = this.a;
            object.a(o10);
        }
    }

    public void d() {
        Object object = o.E(this.a);
        boolean bl2 = ((n)object).c;
        if (!bl2) {
            object = o.E(this.a);
            bl2 = ((n)object).g;
            if (!bl2) {
                object = this.a;
                ((DialogFragment)object).dismiss();
            }
        }
        if ((object = o.E((o)this.a).k) != null) {
            object = o.E((o)this.a).k;
            o o10 = this.a;
            object.a(o10);
        }
    }
}

