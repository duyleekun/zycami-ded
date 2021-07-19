/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 */
package d.v.c.s0.a7;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.widget.StringScrollView;
import com.zhiyun.cama.camera.widget.StringScrollView$c;
import d.v.c.s0.a7.d0;
import d.v.c.s0.u6;
import d.v.c.w0.t3;
import d.v.e.l.h2;
import d.v.f.g.a;
import d.v.i0.b;
import java.util.ArrayList;
import java.util.List;

public class g1
extends a {
    private t3 f;
    private u6 g;
    private BleViewModel h;
    private StringScrollView$c i;

    private void u() {
        Object object;
        int n10;
        int n11;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (n11 = 3; n11 < (n10 = 8); ++n11) {
            object = String.valueOf(n11);
            arrayList.add((String)object);
        }
        n11 = (Integer)this.g.l0().getValue();
        object = this.f.a;
        int n12 = h2.b(116.0f);
        ((StringScrollView)object).setRecyclerViewWidth(n12);
        object = this.f.a;
        n12 = h2.b(24.0f);
        int n13 = h2.b(46.0f);
        ((StringScrollView)object).o(n12, n13);
        this.f.a.setOrientation(0);
        this.f.a.setData(arrayList);
        this.f.a.setTextSize(16.0f);
        object = this.f.a;
        Object object2 = String.valueOf(n11);
        n11 = arrayList.indexOf(object2);
        ((StringScrollView)object).setSelected(n11);
        object2 = this.f.a;
        object = new d0(this, arrayList);
        ((StringScrollView)object2).setOnSelectListener((StringScrollView$c)object);
    }

    private /* synthetic */ void v(List list, int n10) {
        u6 u62 = this.g;
        int n11 = Integer.parseInt((String)list.get(n10));
        u62.e2(n11);
    }

    /*
     * WARNING - void declaration
     */
    private void x() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            void var7_9;
            dialog = this.getDialog().getWindow();
            View view = dialog.getDecorView();
            int n11 = 0;
            float f10 = 0.0f;
            ViewGroup.LayoutParams layoutParams = null;
            view.setPadding(0, 0, 0, 0);
            view = dialog.getAttributes();
            Object object = this.h.B.getValue();
            if (object == null) {
                boolean n10 = false;
                object = null;
            } else {
                object = (Boolean)this.h.B.getValue();
                boolean bl2 = (Boolean)object;
            }
            int n10 = this.k();
            int n12 = 1110966272;
            float f11 = 46.0f;
            int n13 = 1110179840;
            float f12 = 43.0f;
            int n14 = 1124204544;
            float f13 = 130.0f;
            int n15 = 2;
            if (n10 != 0 && n10 != n15) {
                int n16;
                int n17;
                void var7_12;
                view.gravity = 48;
                float f14 = 58.0f;
                int n18 = h2.b(f14);
                if (var7_9 != false) {
                    int n19 = h2.b(f12);
                } else {
                    boolean bl3 = false;
                    object = null;
                }
                view.y = n18 += var7_12;
                view.x = 0;
                view.width = n17 = h2.b(f13);
                view.height = n16 = h2.b(f11);
                boolean bl4 = false;
                object = null;
            } else {
                void var7_18;
                int n20 = 0x800003;
                float f15 = 1.1754948E-38f;
                view.gravity = n20;
                view.y = 0;
                n14 = h2.b(f13);
                if (var7_9 != false) {
                    int n21 = h2.b(f12);
                } else {
                    boolean bl5 = false;
                    object = null;
                }
                view.x = n14 += var7_18;
                int n22 = -90;
                f12 = 132.0f;
                view.height = n13 = h2.b(f12);
                view.width = n12 = h2.b(f11);
            }
            n12 = 0;
            f11 = 0.0f;
            view.dimAmount = 0.0f;
            dialog.setAttributes((WindowManager.LayoutParams)view);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            dialog = this.getView();
            if (dialog != null) {
                void var7_20;
                f10 = (float)var7_20;
                dialog.setRotation(f10);
                if (n10 != 0 && n10 != n15) {
                    int n23;
                    int n24;
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.width = n24 = view.width;
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.height = n23 = view.height;
                    view = dialog.getLayoutParams();
                    dialog.setLayoutParams((ViewGroup.LayoutParams)view);
                    dialog.setTranslationX(0.0f);
                    dialog.setTranslationY(0.0f);
                } else {
                    int n25;
                    int n26;
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.width = n26 = view.height;
                    layoutParams = dialog.getLayoutParams();
                    layoutParams.height = n25 = view.width;
                    layoutParams = dialog.getLayoutParams();
                    dialog.setLayoutParams(layoutParams);
                    n11 = view.width / n15;
                    int n27 = view.height / n15;
                    float f16 = n11 -= n27;
                    dialog.setTranslationX(f16);
                    n27 = -n11;
                    f16 = n27;
                    dialog.setTranslationY(f16);
                }
            }
        }
    }

    public void onAttach(Context object) {
        u6 u62;
        super.onAttach((Context)object);
        object = b.c(this.requireActivity());
        this.g = u62 = (u6)((ViewModelProvider)object).get(u6.class);
        this.h = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
    }

    public void onResume() {
        super.onResume();
        this.x();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.u();
    }

    public void p(int n10) {
        super.p(n10);
        this.x();
    }

    public int s() {
        return 2131558521;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (t3)viewDataBinding;
        this.f = viewDataBinding;
    }

    public /* synthetic */ void w(List list, int n10) {
        this.v(list, n10);
    }

    public void y(StringScrollView$c stringScrollView$c) {
        this.i = stringScrollView$c;
    }
}

