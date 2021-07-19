/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.i.b;

import android.view.View;
import com.zhiyun.account.R$layout;
import d.v.a.g.q;
import d.v.a.g.s;
import d.v.a.i.b.a;
import d.v.a.i.b.e;
import d.v.a.i.b.h;
import d.v.a.i.b.i;
import d.v.f.f.b;

public class d
extends h {
    private boolean b;
    private b c;

    public d(boolean bl2) {
        this.b = bl2;
    }

    private /* synthetic */ void e(int n10, e e10, View view) {
        b b10 = this.c;
        if (b10 != null) {
            b10.a(view, n10, e10);
        }
    }

    private void g(i object, int n10, e object2) {
        object = (q)((i)object).a;
        object2 = ((e)object2).d();
        ((q)object).B((String)object2);
        ((q)object).C(n10);
        n10 = (int)(this.b ? 1 : 0);
        ((q)object).D(n10 != 0);
    }

    public int a(int n10) {
        int n11 = 16;
        if (n11 == n10) {
            return R$layout.me_country_head_item;
        }
        n11 = 32;
        if (n11 == n10) {
            return R$layout.me_country_layout_item;
        }
        return 0;
    }

    public void b(i i10, int n10) {
        int n11 = 16;
        e e10 = (e)this.getItem(n10);
        int n12 = e10.e();
        if (n11 == n12) {
            this.g(i10, n10, e10);
        } else {
            n12 = 32;
            n11 = e10.e();
            if (n12 == n11) {
                this.h(i10, n10, e10);
            }
        }
    }

    public /* synthetic */ void f(int n10, e e10, View view) {
        this.e(n10, e10, view);
    }

    public int getItemViewType(int n10) {
        Object object = this.getItem(n10);
        if (object != null) {
            return ((e)this.getItem(n10)).e();
        }
        return -1;
    }

    public void h(i i10, int n10, e e10) {
        Object object = (s)i10.a;
        ((s)object).A(e10);
        boolean bl2 = this.b;
        ((s)object).B(bl2);
        i10 = i10.itemView;
        object = new a(this, n10, e10);
        i10.setOnClickListener((View.OnClickListener)object);
    }

    public void i(b b10) {
        this.c = b10;
    }
}

