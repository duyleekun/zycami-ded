/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.KeyEvent
 *  android.view.View
 */
package d.v.c.m1.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import d.v.c.m1.d.f;
import d.v.c.m1.d.l$a;
import d.v.c.m1.d.l$b;
import d.v.c.m1.d.m;
import d.v.c.w0.f3;
import d.v.e.l.h2;
import d.v.f.g.a;
import d.v.i0.b;

public class l
extends a {
    private static final String i = "from_type";
    private f3 f;
    private m g;
    private l$b h;

    private void A() {
        float f10 = 284.0f;
        int n10 = h2.b(f10);
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            dialog.setLayout(n10, -2);
            n10 = 17;
            f10 = 2.4E-44f;
            dialog.setGravity(n10);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
        }
    }

    public static /* synthetic */ l$b u(l l10) {
        return l10.h;
    }

    private void v() {
        Dialog dialog = this.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCancelable(false);
            f f10 = new f(this);
            dialog.setOnKeyListener((DialogInterface.OnKeyListener)f10);
        }
    }

    private /* synthetic */ boolean w(DialogInterface object, int n10, KeyEvent keyEvent) {
        int n11 = keyEvent.getKeyCode();
        if (n11 == (n10 = 4) && (object = this.getActivity()) != null) {
            this.dismiss();
            return true;
        }
        return false;
    }

    public static l y(int n10) {
        l l10 = new l();
        Bundle bundle = new Bundle();
        bundle.putInt(i, n10);
        l10.setArguments(bundle);
        return l10;
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (m)b.a(this).get(m.class);
        this.g = object;
    }

    public void onResume() {
        super.onResume();
        this.A();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view = this.getArguments();
        int n10 = 2;
        if (view != null) {
            String string2 = i;
            n10 = view.getInt(string2, n10);
        }
        this.g.b(n10);
        this.v();
    }

    public int s() {
        return 2131558513;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (f3)viewDataBinding;
        this.f = viewDataBinding;
        Object object = this.g;
        ((f3)viewDataBinding).B((m)object);
        viewDataBinding = this.f;
        object = new l$a(this);
        ((f3)viewDataBinding).A((l$a)object);
    }

    public /* synthetic */ boolean x(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        return this.w(dialogInterface, n10, keyEvent);
    }

    public l z(l$b l$b) {
        this.h = l$b;
        return this;
    }
}

