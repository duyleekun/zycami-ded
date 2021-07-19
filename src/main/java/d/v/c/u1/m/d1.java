/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.u1.m;

import android.view.MotionEvent;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import d.v.c.u1.m.x0;
import d.v.c.w0.oc;
import d.v.f.d.b;
import d.v.f.d.b$b;
import d.v.f.f.c;
import d.v.h.e.a;

public class d1
extends b {
    private c g;
    private TemplateEditViewModel h;

    public d1(LifecycleOwner lifecycleOwner, TemplateEditViewModel templateEditViewModel) {
        super(lifecycleOwner, templateEditViewModel);
        this.h = templateEditViewModel;
    }

    private /* synthetic */ boolean o(int n10, View view, MotionEvent motionEvent) {
        c c10 = this.g;
        Object e10 = this.d().get(n10);
        return c10.a(view, n10, e10, motionEvent);
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        viewDataBinding = (oc)viewDataBinding;
        object = (a)this.d().get(n10);
        ((oc)viewDataBinding).B((a)object);
        object = n10;
        ((oc)viewDataBinding).C((Integer)object);
        object = this.h;
        ((oc)viewDataBinding).D((TemplateEditViewModel)object);
        object = viewDataBinding.getRoot();
        x0 x02 = new x0(this, n10);
        object.setOnTouchListener((View.OnTouchListener)x02);
        viewDataBinding.executePendingBindings();
    }

    public int e(int n10) {
        return 2131558652;
    }

    public /* synthetic */ boolean p(int n10, View view, MotionEvent motionEvent) {
        return this.o(n10, view, motionEvent);
    }

    public void q(c c10) {
        this.g = c10;
    }
}

