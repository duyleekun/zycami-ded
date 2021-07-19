/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.l1.e0;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import androidx.databinding.ViewDataBinding;
import d.v.c.l1.e0.a;
import d.v.c.l1.e0.d$b;
import d.v.c.w0.x3;
import d.v.e.l.h2;

public class d
extends d.v.f.g.a {
    private x3 f;
    private boolean g;
    private boolean h;
    private boolean i;
    private d.v.f.f.a j;
    private d.v.f.f.a k;
    private d.v.f.f.a l;
    private d.v.f.f.a m;

    private void D(Dialog dialog) {
        Window window;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            dialog = dialog.getWindow();
            int n10 = h2.b(300.0f);
            int n11 = -2;
            dialog.setLayout(n10, n11);
            n10 = 2131099771;
            dialog.setBackgroundDrawableResource(n10);
        }
    }

    public static /* synthetic */ d.v.f.f.a u(d d10) {
        return d10.m;
    }

    private /* synthetic */ void v(RadioGroup object, int n10) {
        int n11 = 2131362080;
        if (n10 == n11) {
            object = this.j;
            if (object != null) {
                object.a(this);
            }
        } else {
            n11 = 2131362071;
            if (n10 == n11) {
                object = this.k;
                if (object != null) {
                    object.a(this);
                }
            } else {
                n11 = 2131362072;
                if (n10 == n11 && (object = this.l) != null) {
                    object.a(this);
                }
            }
        }
    }

    public void A(d.v.f.f.a a10) {
        this.m = a10;
    }

    public void B(d.v.f.f.a a10) {
        this.l = a10;
    }

    public void C(d.v.f.f.a a10) {
        this.j = a10;
    }

    public void E(boolean bl2) {
        this.g = bl2;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bundle = this.getDialog();
        this.D((Dialog)bundle);
    }

    public void onViewCreated(View view, Bundle object) {
        super.onViewCreated(view, (Bundle)object);
        boolean bl2 = this.g;
        int n10 = 8;
        if (!bl2) {
            this.f.c.setVisibility(n10);
            view = this.f.f;
            view.setVisibility(n10);
        }
        if (!(bl2 = this.h)) {
            this.f.a.setVisibility(n10);
            view = this.f.d;
            view.setVisibility(n10);
        }
        if (!(bl2 = this.i)) {
            this.f.b.setVisibility(n10);
            view = this.f.e;
            view.setVisibility(n10);
        }
        view = this.f.h;
        object = new a(this);
        view.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object);
    }

    public int s() {
        return 2131558523;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (x3)viewDataBinding;
        this.f = viewDataBinding;
        d$b d$b = new d$b(this);
        ((x3)viewDataBinding).z(d$b);
    }

    public /* synthetic */ void w(RadioGroup radioGroup, int n10) {
        this.v(radioGroup, n10);
    }

    public void x(boolean bl2) {
        this.h = bl2;
    }

    public void y(boolean bl2) {
        this.i = bl2;
    }

    public void z(d.v.f.f.a a10) {
        this.k = a10;
    }
}

