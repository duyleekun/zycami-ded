/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 */
package d.v.c.i1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.common.util.Windows;
import d.v.c.b2.w.j;
import d.v.c.w0.cb;
import d.v.c.w0.wa;
import d.v.f.d.b;
import d.v.f.d.b$b;
import java.util.ArrayList;

public class n2
extends b {
    public static final int k = 255;
    public static final int l;
    public View.OnTouchListener g;
    public final int h;
    public int i;
    public int j;

    public n2(Context context) {
        super(null, null);
        int n10;
        this.k();
        this.h = n10 = Windows.l(context).getWidth() / 2;
        this.i = n10;
        this.j = n10;
    }

    public void b(b$b object, int n10, ViewDataBinding viewDataBinding) {
        boolean bl2 = this.s(n10);
        if (bl2) {
            viewDataBinding = (wa)viewDataBinding;
            object = viewDataBinding.getRoot().getLayoutParams();
            n10 = (n10 = (int)(this.r(n10) ? 1 : 0)) != 0 ? this.i : this.j;
            ((ViewGroup.LayoutParams)object).width = n10;
            ((ViewGroup.LayoutParams)object).height = n10 = -1;
            View view = viewDataBinding.getRoot();
            view.setLayoutParams((ViewGroup.LayoutParams)object);
        } else {
            viewDataBinding = (cb)viewDataBinding;
            object = viewDataBinding.getRoot();
            View.OnTouchListener onTouchListener = this.g;
            object.setOnTouchListener(onTouchListener);
            object = this.d();
            object = (j)((ArrayList)object).get(n10 += -1);
            ((cb)viewDataBinding).z((j)object);
            viewDataBinding.executePendingBindings();
        }
    }

    public int e(int n10) {
        n10 = n10 == 0 ? 2131558632 : 2131558629;
        return n10;
    }

    public int getItemCount() {
        return super.getItemCount() + 2;
    }

    public int getItemViewType(int n10) {
        if ((n10 = (int)(this.s(n10) ? 1 : 0)) != 0) {
            return -1;
        }
        return 0;
    }

    public int o() {
        return this.i;
    }

    public int p() {
        return this.j;
    }

    public boolean q(int n10) {
        ObservableArrayList observableArrayList = this.d();
        int n11 = observableArrayList.size();
        int n12 = 1;
        if (n10 != (n11 += n12)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public boolean r(int n10) {
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean s(int n10) {
        boolean bl2 = this.r(n10);
        n10 = !bl2 && (n10 = (int)(this.q(n10) ? 1 : 0)) == 0 ? 0 : 1;
        return n10 != 0;
    }

    public void t(View.OnTouchListener onTouchListener) {
        this.g = onTouchListener;
    }

    public void u(int n10) {
        this.i = n10;
    }

    public void v(int n10) {
        this.j = n10;
    }
}

