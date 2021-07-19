/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.q1.h0;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import d.v.c.n0.c;
import d.v.c.n0.e;
import d.v.c.q1.h0.h0;
import d.v.c.q1.h0.i0;
import d.v.c.w0.wf;
import d.v.f.f.b;

public class n0
extends c {
    private b b;
    private b c;

    private /* synthetic */ void e(int n10, View view) {
        b b10 = this.b;
        if (b10 != null) {
            Object object = this.getItem(n10);
            b10.a(view, n10, object);
        }
    }

    private /* synthetic */ void g(int n10, View view) {
        b b10 = this.c;
        if (b10 != null) {
            Object object = this.getItem(n10);
            b10.a(view, n10, object);
        }
    }

    public int a(int n10) {
        return 2131558719;
    }

    public void b(e object, int n10) {
        object = (wf)((e)object).a;
        Object object2 = (BindDeviceInfo)this.getItem(n10);
        ((wf)object).z((BindDeviceInfo)object2);
        object2 = ((wf)object).a;
        Object object3 = new h0(this, n10);
        object2.setOnClickListener((View.OnClickListener)object3);
        object2 = ((ViewDataBinding)object).getRoot();
        object3 = new i0(this, n10);
        object2.setOnClickListener((View.OnClickListener)object3);
        object2 = this.getData();
        int n11 = object2.size() + -1;
        if (n10 == n11) {
            object = ((wf)object).b;
            n10 = 4;
            object.setVisibility(n10);
        }
    }

    public /* synthetic */ void f(int n10, View view) {
        this.e(n10, view);
    }

    public /* synthetic */ void h(int n10, View view) {
        this.g(n10, view);
    }

    public void i(b b10) {
        this.b = b10;
    }

    public void j(b b10) {
        this.c = b10;
    }
}

