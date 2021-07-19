/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 */
package d.v.c.s0.h7.p0;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.common.util.Windows;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.n0.c;
import d.v.c.n0.e;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.p0.b;
import d.v.c.w0.kc;
import d.v.e.l.h2;

public class o
extends c {
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private LifecycleOwner b;
    private m0 c;
    private d.v.f.f.b d;

    public o(LifecycleOwner lifecycleOwner, m0 m02) {
        this.b = lifecycleOwner;
        this.c = m02;
    }

    private /* synthetic */ void e(kc object, View view) {
        d.v.f.f.b b10 = this.d;
        if (b10 != null) {
            Integer n10 = ((kc)object).u();
            int n11 = n10;
            object = ((kc)object).u();
            b10.a(view, n11, object);
        }
    }

    public int a(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            return 2131558650;
        }
        return 2131558649;
    }

    public void b(e object, int n10) {
        int n11 = this.getItemViewType(n10);
        int n12 = 1;
        float f10 = Float.MIN_VALUE;
        if (n11 == n12) {
            object = (kc)((e)object).a;
            Object object2 = this.b;
            ((ViewDataBinding)object).setLifecycleOwner((LifecycleOwner)object2);
            object2 = n10 -= n12;
            ((kc)object).B((Integer)object2);
            Object object3 = ((TemplatePOJO)this.getItem(n10)).getTemplateData();
            ((kc)object).C((TemplateData)object3);
            object3 = this.c;
            ((kc)object).D((m0)object3);
            object3 = ((ViewDataBinding)object).getRoot();
            object2 = new b(this, (kc)object);
            object3.setOnClickListener((View.OnClickListener)object2);
            ((ViewDataBinding)object).executePendingBindings();
        } else {
            object = ((e)object).a.getRoot();
            ViewGroup.LayoutParams layoutParams = object.getLayoutParams();
            Size size = Windows.o(object.getContext());
            float f11 = 45.0f;
            if (n11 == 0) {
                n11 = size.getHeight() / 2;
                n12 = h2.b(f11);
                n11 -= n12;
                f10 = 7.0f;
                n12 = h2.b(f10);
            } else {
                n11 = size.getHeight() / 2;
                n12 = h2.b(f11);
            }
            layoutParams.height = n11 -= n12;
            object.setLayoutParams(layoutParams);
        }
    }

    public /* synthetic */ void f(kc kc2, View view) {
        this.e(kc2, view);
    }

    public void g(d.v.f.f.b b10) {
        this.d = b10;
    }

    public int getItemCount() {
        return this.getData().size() + 2;
    }

    public int getItemViewType(int n10) {
        if (n10 == 0) {
            return 0;
        }
        int n11 = this.getItemCount();
        int n12 = 1;
        if (n10 == (n11 -= n12)) {
            return 2;
        }
        return n12;
    }
}

