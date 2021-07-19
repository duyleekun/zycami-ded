/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.PopupWindow
 */
package d.v.c.y1.f.x;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import d.v.c.w0.ag;
import d.v.c.y1.f.x.b0;
import d.v.e.g.e;

public class m0
extends PopupWindow {
    private e a;
    private e b;

    public m0(Context object) {
        object = (ag)DataBindingUtil.inflate(LayoutInflater.from((Context)object), 2131558743, null, false);
        Object object2 = ((ViewDataBinding)object).getRoot();
        this.setContentView((View)object2);
        int bl2 = -2;
        this.setWidth(bl2);
        this.setHeight(bl2);
        super(0);
        this.setBackgroundDrawable((Drawable)object2);
        boolean bl3 = true;
        this.setFocusable(bl3);
        this.setOutsideTouchable(bl3);
        object2 = ((ag)object).c;
        b0 b02 = new b0(this);
        object2.setOnClickListener((View.OnClickListener)b02);
        object = ((ag)object).d;
        super(this);
        object.setOnClickListener((View.OnClickListener)object2);
    }

    private /* synthetic */ void a(View object) {
        object = this.a;
        if (object == null) {
            return;
        }
        object.a();
        this.dismiss();
    }

    private /* synthetic */ void c(View object) {
        object = this.b;
        if (object == null) {
            return;
        }
        object.a();
        this.dismiss();
    }

    public /* synthetic */ void b(View view) {
        this.a(view);
    }

    public /* synthetic */ void d(View view) {
        this.c(view);
    }

    public void e(e e10) {
        this.a = e10;
    }

    public void f(e e10) {
        this.b = e10;
    }
}

