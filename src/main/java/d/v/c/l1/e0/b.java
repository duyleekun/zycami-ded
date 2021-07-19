/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.l1.e0;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.l1.e0.b$b;
import d.v.c.w0.v3;
import d.v.e.l.h2;
import d.v.f.f.a;
import d.v.f.g.c;

public class b
extends c {
    private v3 e;
    private String f;
    private String g;
    private String h;
    private String i;
    private a j;
    private a k;

    public static /* synthetic */ a s(b b10) {
        return b10.k;
    }

    public static /* synthetic */ a t(b b10) {
        return b10.j;
    }

    private void z() {
        float f10 = 284.0f;
        int n10 = h2.b(f10);
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            int n11 = -1;
            dialog.setLayout(n10, n11);
            n10 = 2131099771;
            f10 = 1.7811905E38f;
            dialog.setBackgroundDrawableResource(n10);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.z();
    }

    public View onCreateView(LayoutInflater object, ViewGroup object2, Bundle bundle) {
        object = (v3)DataBindingUtil.inflate((LayoutInflater)object, 2131558522, object2, false);
        this.e = object;
        ((ViewDataBinding)object).setLifecycleOwner(this);
        object = this.e;
        object2 = new b$b(this);
        ((v3)object).z((b$b)object2);
        return this.e.getRoot();
    }

    public void onViewCreated(View object, Bundle object2) {
        boolean bl2;
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.f;
        if (object != null) {
            object2 = this.e.g;
            object2.setText((CharSequence)object);
        }
        if ((object = this.g) != null) {
            object2 = this.e.e;
            object2.setText((CharSequence)object);
        }
        if ((object = this.i) != null) {
            object2 = this.e.f;
            object2.setText((CharSequence)object);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)(object = this.h))) {
            object = this.e.d;
            int n10 = 8;
            object.setVisibility(n10);
        } else {
            object = this.e.d;
            boolean bl3 = false;
            object.setVisibility(0);
            object = this.e.d;
            object2 = this.h;
            object.setText((CharSequence)object2);
        }
    }

    public void u(String string2, a a10) {
        this.i = string2;
        this.j = a10;
    }

    public void v(String string2) {
        this.g = string2;
    }

    public void w(String string2) {
        this.h = string2;
    }

    public void x(a a10) {
        this.k = a10;
    }

    public void y(String string2) {
        this.f = string2;
    }
}

