/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.k1.a;

import android.view.MotionEvent;
import android.view.View;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import d.v.c.k1.a.n;
import d.v.c.k1.a.w;
import d.v.c.w0.ob;
import d.v.f.d.b;
import d.v.f.d.b$b;
import d.v.f.f.c;
import d.v.h.e.a;

public class v
extends b {
    private w g;
    private c h;
    private ObservableInt i;

    public v(LifecycleOwner object, w w10) {
        super((LifecycleOwner)object, w10);
        this.i = object = new ObservableInt(-1);
        this.g = w10;
    }

    private /* synthetic */ boolean o(int n10, View view, MotionEvent motionEvent) {
        c c10 = this.h;
        Object e10 = this.d().get(n10);
        return c10.a(view, n10, e10, motionEvent);
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (ob)viewDataBinding;
        object = (a)this.d().get(n10);
        ((ob)viewDataBinding).G((a)object);
        object = this.g;
        ((ob)viewDataBinding).J((w)object);
        object = n10;
        ((ob)viewDataBinding).H((Integer)object);
        object = this.i;
        ((ob)viewDataBinding).I((ObservableInt)object);
        object = viewDataBinding.getRoot();
        n n11 = new n(this, n10);
        object.setOnTouchListener((View.OnTouchListener)n11);
        viewDataBinding.executePendingBindings();
    }

    public int e(int n10) {
        return 2131558638;
    }

    public /* synthetic */ boolean p(int n10, View view, MotionEvent motionEvent) {
        return this.o(n10, view, motionEvent);
    }

    public void q(int n10) {
        this.i.set(n10);
    }

    public void r(c c10) {
        this.h = c10;
    }
}

