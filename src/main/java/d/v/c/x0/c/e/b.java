/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.c.x0.c.e;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.BackEditText;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.q0.d;
import d.v.c.w0.h8;
import d.v.c.x0.c.e.a;
import d.v.c.x0.c.e.b$a;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.e.l.v1;

public class b
extends d {
    private h8 j;
    private d.v.c.x0.c.b k;
    private m2$d l;

    public static /* synthetic */ g A(b b10) {
        return b10.g;
    }

    public static /* synthetic */ g B(b b10) {
        return b10.g;
    }

    public static /* synthetic */ g C(b b10) {
        return b10.g;
    }

    private /* synthetic */ void D() {
        BackEditText backEditText = this.j.a;
        boolean bl2 = true;
        backEditText.setFocusable(bl2);
        this.j.a.setFocusableInTouchMode(bl2);
        this.j.a.requestFocus();
        this.j.a.findFocus();
        backEditText = this.requireContext();
        BackEditText backEditText2 = this.j.a;
        v1.h((Context)backEditText, (View)backEditText2);
    }

    public static /* synthetic */ d.v.c.x0.c.b x(b b10) {
        return b10.k;
    }

    public static /* synthetic */ h8 y(b b10) {
        return b10.j;
    }

    public static /* synthetic */ g z(b b10) {
        return b10.g;
    }

    public /* synthetic */ void E() {
        this.D();
    }

    public int h() {
        return 2131558591;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (h8)object;
        this.j = object;
        b$a b$a = new b$a(this);
        ((h8)object).z(b$a);
        this.k = object = (d.v.c.x0.c.b)d.v.i0.b.a(this.requireParentFragment()).get(d.v.c.x0.c.b.class);
    }

    public void onPause() {
        super.onPause();
        m2.a(this.l);
        Context context = this.requireContext();
        BackEditText backEditText = this.j.a;
        v1.d(context, (View)backEditText);
    }

    public void onResume() {
        super.onResume();
        Object object = this.g.X0();
        if (object == null) {
            this.j.a.setText("");
            object = this.j.a;
            Object object2 = this.requireContext();
            int n10 = 2131952109;
            object2 = d.v.f.i.g.m(object2, n10);
            object.setHint((CharSequence)object2);
            object = this.g;
            object2 = this.requireContext();
            ((i2)object).w((Context)object2);
        } else {
            object = this.g.X0().y();
            this.j.a.setText((CharSequence)object);
            BackEditText backEditText = this.j.a;
            int n11 = ((String)object).length();
            backEditText.setSelection(n11);
        }
        m2.a(this.l);
        a a10 = new a(this);
        this.l = object = m2.Y(200L, a10);
    }
}

