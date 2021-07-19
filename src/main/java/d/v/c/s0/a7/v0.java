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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.camera.data.BeautyData;
import com.zhiyun.common.util.Windows;
import com.zhiyun.ui.ShadowSeekBar;
import d.v.c.n0.c;
import d.v.c.s0.a7.t0;
import d.v.c.s0.a7.v0$a;
import d.v.c.s0.a7.v0$b;
import d.v.c.s0.u6;
import d.v.c.w0.h0;
import d.v.e.h.d;
import d.v.e.l.h2;
import d.v.i0.b;
import java.util.List;

public class v0
extends t0 {
    private h0 f;
    private c g;
    private int h;
    private u6 i;
    private List j;

    public static /* synthetic */ void A(v0 v02, int n10, List list) {
        v02.I(n10, list);
    }

    public static /* synthetic */ void B(v0 v02) {
        v02.G();
    }

    private void C() {
        int n10;
        Object object = (u6)b.c(this.requireActivity()).get(u6.class);
        this.i = object;
        this.j = object = d.v.c.v0.n.d.s().a();
        this.h = n10 = d.c((Integer)this.i.t().getValue());
    }

    private void D() {
        ShadowSeekBar shadowSeekBar = this.f.c;
        v0$b v0$b = new v0$b(this);
        shadowSeekBar.setOnSeekBarChangeListener(v0$b);
    }

    private void E() {
        this.G();
        Object object = new v0$a(this);
        this.g = object;
        Object object2 = this.j;
        ((c)object).d((List)object2);
        object = this.f.b;
        Context context = this.getContext();
        object2 = new LinearLayoutManager(context, 0, false);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object = this.f.b;
        object2 = this.g;
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
        object = this.f.b;
        int n10 = this.h;
        ((RecyclerView)object).scrollToPosition(n10);
    }

    public static v0 F() {
        v0 v02 = new v0();
        return v02;
    }

    private void G() {
        Object object;
        int n10;
        Object object2 = this.f.a;
        int n11 = this.h;
        if (n11 != 0 && (n10 = 1) != n11) {
            n11 = 0;
            object = null;
        } else {
            n11 = 8;
        }
        object2.setVisibility(n11);
        object2 = this.f.c;
        object = this.j;
        n10 = this.h;
        object = (BeautyData)object.get(n10);
        n11 = ((BeautyData)object).getProgress();
        object2.setProgress(n11);
        object2 = this.g;
        if (object2 != null) {
            ((RecyclerView$Adapter)object2).notifyDataSetChanged();
        }
    }

    private void H() {
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            View view = dialog.getDecorView();
            int n10 = 0;
            float f10 = 0.0f;
            ViewGroup.LayoutParams layoutParams = null;
            view.setPadding(0, 0, 0, 0);
            view = dialog.getAttributes();
            int n11 = this.k();
            int n12 = 0x800003;
            int n13 = 2;
            view.gravity = n11 != 0 && n11 != n13 ? n12 : n12;
            n11 = -90;
            view.width = n12 = h2.b(220.0f);
            view.height = n12 = Windows.l(this.requireContext()).getHeight();
            n12 = 0;
            view.dimAmount = 0.0f;
            dialog.setAttributes((WindowManager.LayoutParams)view);
            ColorDrawable colorDrawable = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)colorDrawable);
            dialog = this.getView();
            if (dialog != null && (layoutParams = dialog.getLayoutParams()) != null) {
                f10 = n11;
                dialog.setRotation(f10);
                layoutParams = dialog.getLayoutParams();
                layoutParams.width = n11 = view.height;
                layoutParams = dialog.getLayoutParams();
                layoutParams.height = n11 = view.width;
                layoutParams = dialog.getLayoutParams();
                dialog.setLayoutParams(layoutParams);
                n10 = view.width / n13;
                int n14 = view.height / n13;
                float f11 = n10 -= n14;
                dialog.setTranslationX(f11);
                n14 = -n10;
                f11 = n14;
                dialog.setTranslationY(f11);
            }
        }
    }

    private void I(int n10, List list) {
        int n11;
        for (int i10 = n10 = 2; i10 < (n11 = list.size()); ++i10) {
            int n12;
            BeautyData beautyData = (BeautyData)list.get(i10);
            if (i10 != n10) {
                n12 = 3;
                if (i10 != n12) {
                    n12 = 4;
                    int n13 = 30;
                    if (i10 != n12) {
                        n12 = 5;
                        if (i10 != n12) {
                            n12 = 7;
                            if (i10 != n12) continue;
                            beautyData.setProgress(n13);
                            continue;
                        }
                        n12 = 40;
                        beautyData.setProgress(n12);
                        continue;
                    }
                    beautyData.setProgress(n13);
                    continue;
                }
                n12 = 70;
                beautyData.setProgress(n12);
                continue;
            }
            n12 = 50;
            beautyData.setProgress(n12);
        }
    }

    public static /* synthetic */ int w(v0 v02) {
        return v02.h;
    }

    public static /* synthetic */ int x(v0 v02, int n10) {
        v02.h = n10;
        return n10;
    }

    public static /* synthetic */ List y(v0 v02) {
        return v02.j;
    }

    public static /* synthetic */ u6 z(v0 v02) {
        return v02.i;
    }

    public void onResume() {
        super.onResume();
        this.H();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.C();
        this.E();
        this.D();
    }

    public void p(int n10) {
        this.H();
        c c10 = this.g;
        if (c10 != null) {
            c10.notifyDataSetChanged();
        }
    }

    public int s() {
        return 2131558457;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (h0)viewDataBinding;
        this.f = viewDataBinding;
    }
}

