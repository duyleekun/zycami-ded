/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  android.widget.LinearLayout
 */
package d.v.g0;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.ui.R$layout;
import com.zhiyun.ui.R$style;
import d.v.e.l.h2;
import d.v.g0.i$a;
import d.v.g0.i$b;
import d.v.g0.i$c;
import d.v.g0.o;
import d.v.g0.t.c;
import d.v.g0.t.g;
import java.util.List;

public class i
extends d.v.f.g.c {
    private static final String n = "dark_mode";
    private static final String o = "BottomListDialog";
    private c e;
    private i$a f;
    private List g;
    private i$c h;
    private i$b i;
    private boolean j = true;
    private Drawable k = null;
    private Drawable l = null;
    private int m = -1;

    private void E(Dialog dialog) {
        Window window;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            int n10;
            dialog = dialog.getWindow();
            window = dialog.getAttributes();
            window.windowAnimations = n10 = R$style.dialogBottomAnim;
            window = dialog.getAttributes();
            window.gravity = 80;
            window.width = -1;
            window.flags = n10 = window.flags | 2;
            dialog.setAttributes((WindowManager.LayoutParams)window);
            n10 = 0;
            window = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)window);
            dialog = dialog.getDecorView();
            float f10 = 20.0f;
            int n11 = h2.b(f10);
            int n12 = h2.b(f10);
            float f11 = 32.0f;
            int n13 = h2.b(f11);
            dialog.setPadding(n11, 0, n12, n13);
            dialog.requestLayout();
        }
    }

    public static /* synthetic */ i$c s(i i10) {
        return i10.h;
    }

    public static /* synthetic */ i$b t(i i10) {
        return i10.i;
    }

    private void u() {
        Object object;
        int n10;
        List list = this.g;
        if (list == null) {
            return;
        }
        this.e.a.removeAllViews();
        list = null;
        for (int i10 = 0; i10 < (n10 = (object = this.g).size()); ++i10) {
            object = this.getLayoutInflater();
            boolean bl2 = R$layout.zyui_item_bottom_list;
            LinearLayout linearLayout = this.e.a;
            object = (g)DataBindingUtil.inflate((LayoutInflater)object, (int)(bl2 ? 1 : 0), (ViewGroup)linearLayout, false);
            ((ViewDataBinding)object).setLifecycleOwner(this);
            Object object2 = (o)this.g.get(i10);
            ((g)object).E((o)object2);
            object2 = this.f;
            ((g)object).C((i$a)object2);
            object2 = i10;
            ((g)object).F((Integer)object2);
            bl2 = this.j;
            object2 = bl2;
            ((g)object).D((Boolean)object2);
            object2 = this.e.a;
            object = ((ViewDataBinding)object).getRoot();
            object2.addView((View)object);
        }
    }

    public static i v() {
        return d.v.g0.i.w(true);
    }

    public static i w(boolean bl2) {
        i i10 = new i();
        Bundle bundle = new Bundle();
        bundle.putBoolean(n, bl2);
        i10.setArguments(bundle);
        return i10;
    }

    private void x() {
        int n10;
        int n11;
        LinearLayout linearLayout;
        Drawable drawable2 = this.k;
        if (drawable2 != null) {
            this.e.a.setBackground(drawable2);
            drawable2 = this.e.b;
            linearLayout = this.k;
            drawable2.setBackground((Drawable)linearLayout);
        }
        if ((drawable2 = this.l) != null) {
            linearLayout = this.e.a;
            linearLayout.setDividerDrawable(drawable2);
        }
        if ((n11 = this.m) != (n10 = -1)) {
            linearLayout = this.e.b;
            linearLayout.setTextColor(n11);
        }
    }

    public i A(Drawable drawable2) {
        this.l = drawable2;
        return this;
    }

    public i B(List list) {
        this.g = list;
        return this;
    }

    public i C(i$b i$b) {
        this.i = i$b;
        return this;
    }

    public i D(i$c i$c) {
        this.h = i$c;
        return this;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.x();
        bundle = this.getDialog();
        this.E((Dialog)bundle);
        this.u();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup object, Bundle object2) {
        int bl2 = R$layout.zyui_frag_bottom_list_dialog;
        String string2 = null;
        layoutInflater = layoutInflater.inflate(bl2, (ViewGroup)object, false);
        object = this.getArguments();
        if (object != null) {
            boolean bl3;
            boolean bl4 = true;
            string2 = n;
            this.j = bl3 = object.getBoolean(string2, bl4);
        }
        this.e = object = c.s((View)layoutInflater);
        ((ViewDataBinding)object).setLifecycleOwner(this);
        object = this.e;
        object2 = this.j;
        ((c)object).B((Boolean)object2);
        this.f = object = new i$a(this);
        this.e.A((i$a)object);
        return layoutInflater;
    }

    public i y(Drawable drawable2) {
        this.k = drawable2;
        return this;
    }

    public i z(int n10) {
        this.m = n10;
        return this;
    }
}

