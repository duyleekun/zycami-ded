/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 */
package com.zhiyun.cama.me.help.view;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.zhiyun.image.Images;
import d.v.c.j1.a.q0.c;
import d.v.c.j1.a.q0.d;
import d.v.c.n0.e;
import d.v.c.w0.ye;
import d.v.e.l.h2;
import d.v.f.f.b;
import java.util.List;

public class AddImageRecyclerView$a
extends d.v.c.n0.c {
    private static final int d = 3;
    private static final int e = 1;
    private View.OnClickListener b;
    private b c;

    private /* synthetic */ void e(int n10, View view) {
        b b10 = this.c;
        Integer n11 = n10;
        b10.a(view, n10, n11);
    }

    private /* synthetic */ void g(View view) {
        this.b.onClick(view);
    }

    public int a(int n10) {
        return 2131558701;
    }

    public void b(e object, int n10) {
        object = (ye)((e)object).a;
        int n11 = 1;
        int n12 = this.getItemViewType(n10);
        if (n11 != n12) {
            Object object2 = (String)this.getItem(n10);
            ImageView imageView = ((ye)object).b;
            object2 = Uri.parse((String)object2);
            float f10 = 8.0f;
            int n13 = h2.b(f10);
            Images.G(imageView, object2, n13);
            object2 = ((ye)object).a;
            n11 = 0;
            imageView = null;
            object2.setVisibility(0);
            object2 = this.c;
            if (object2 != null) {
                object = ((ye)object).a;
                object2 = new d(this, n10);
                object.setOnClickListener((View.OnClickListener)object2);
            }
        } else {
            ((ye)object).b.setImageResource(2131231241);
            Object object3 = ((ye)object).a;
            n12 = 4;
            object3.setVisibility(n12);
            object3 = this.b;
            if (object3 != null) {
                object = ((ye)object).b;
                object3 = new c(this);
                object.setOnClickListener((View.OnClickListener)object3);
            }
        }
    }

    public /* synthetic */ void f(int n10, View view) {
        this.e(n10, view);
    }

    public int getItemCount() {
        return Math.min(super.getItemCount() + 1, 3);
    }

    public int getItemViewType(int n10) {
        int n11 = 3;
        List list = this.getData();
        int n12 = list.size();
        if (n11 > n12) {
            n12 = this.getItemCount();
            n11 = 1;
            if (n10 == (n12 -= n11)) {
                return n11;
            }
            return super.getItemViewType(n10);
        }
        return super.getItemViewType(n10);
    }

    public /* synthetic */ void h(View view) {
        this.g(view);
    }

    public void i(View.OnClickListener onClickListener) {
        this.b = onClickListener;
    }

    public void j(b b10) {
        this.c = b10;
    }
}

