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
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 */
package d.v.g0;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import d.v.e.l.h2;
import d.v.f.g.a;
import d.v.g0.e;
import d.v.g0.f;
import d.v.i0.b;

public abstract class q
extends a {
    private DeviceViewModel f;
    private int g = 0;
    private boolean h = false;
    private boolean i = false;
    private int j = 0;
    private int k = 0;

    private void D(Dialog dialog) {
        Window window;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            dialog = dialog.getWindow();
            window = dialog.getAttributes();
            window.gravity = 17;
            dialog.setAttributes((WindowManager.LayoutParams)window);
            window = new ColorDrawable(0);
            dialog.setBackgroundDrawable((Drawable)window);
            dialog.getDecorView().requestLayout();
            dialog = this.getDialog().getWindow();
            int n10 = 1024;
            dialog.setFlags(n10, n10);
        }
    }

    private void w() {
        int n10;
        View view = this.getView();
        if (view != null && (n10 = this.j) <= 0) {
            view = this.getView();
            e e10 = new e(this);
            view.post((Runnable)e10);
        }
    }

    private /* synthetic */ void x() {
        View view = this.getView();
        if (view != null) {
            int n10;
            this.j = n10 = this.getView().getWidth();
            view = this.getView();
            this.k = n10 = view.getHeight();
            n10 = this.g;
            this.B(n10);
        }
    }

    private /* synthetic */ void z(Integer n10) {
        int n11;
        this.w();
        this.g = n11 = n10.intValue();
        this.B(n11);
    }

    public /* synthetic */ void A(Integer n10) {
        this.z(n10);
    }

    /*
     * Unable to fully structure code
     */
    public void B(int var1_1) {
        block11: {
            block13: {
                block12: {
                    var2_2 = this.i;
                    var3_3 = 1;
                    var4_4 = 1.4E-45f;
                    var5_5 = 0;
                    if (var2_2 == 0 && (var2_2 = this.h) == 0) {
                        var2_2 = var3_3;
                    } else {
                        var2_2 = 0;
                        var6_6 = null;
                    }
                    if (var2_2 == 0 && (var2_2 = (int)h2.c(var6_6 = this.getContext())) == 0) {
                        var3_3 = 0;
                        var7_7 = null;
                        var4_4 = 0.0f;
                    }
                    if ((var2_2 = this.j) <= 0 || (var2_2 = this.k) <= 0 || (var6_6 = this.getDialog()) == null || (var6_6 = this.getDialog().getWindow()) == null || (var6_6 = this.getDialog().getWindow().getDecorView()) == null) break block11;
                    var6_6 = this.getDialog().getWindow();
                    var8_8 = var6_6.getAttributes();
                    var8_8.gravity = var9_9 = 17;
                    if (var1_1 == 0) break block12;
                    var9_9 = 90;
                    if (var1_1 == var9_9) ** GOTO lbl-1000
                    var10_10 = 180;
                    if (var1_1 != var10_10) {
                        var10_10 = 270;
                        ** if (var1_1 == var10_10) goto lbl-1000
lbl-1000:
                        // 1 sources

                        {
                            var1_1 = 0;
                            var11_11 = 0.0f;
                            ** GOTO lbl58
                        }
                    }
                    break block12;
lbl-1000:
                    // 2 sources

                    {
                        if (var3_3 == 0) {
                            var9_9 = 0;
                        }
                        var1_1 = var3_3 != 0 ? this.k : this.j;
                        var8_8.width = var1_1;
                        var10_10 = var3_3 != 0 ? this.j : this.k;
                        var8_8.height = var10_10;
                        if (var3_3 != 0) {
                            var1_1 /= 2;
                            var5_5 = var1_1 -= (var10_10 /= 2);
                        }
                        var1_1 = var5_5;
                        var5_5 = var9_9;
                    }
                    break block13;
                }
                if (var3_3 != 0) {
                    var1_1 = 0;
                    var11_11 = 0.0f;
                } else {
                    var1_1 = -90;
                    var11_11 = 0.0f / 0.0f;
                }
                var9_9 = var3_3 != 0 ? this.j : this.k;
                var8_8.width = var9_9;
                var10_10 = var3_3 != 0 ? this.k : this.j;
                var8_8.height = var10_10;
                if (var3_3 == 0) {
                    var9_9 /= 2;
                    var5_5 = var9_9 -= (var10_10 /= 2);
                }
                var12_12 = var5_5;
                var5_5 = var1_1;
                var1_1 = var12_12;
            }
            var6_6.setAttributes(var8_8);
            var6_6 = this.getView();
            var4_4 = var5_5;
            var6_6.setRotation(var4_4);
            var7_7 = var6_6.getLayoutParams();
            var7_7.width = var5_5 = this.j;
            var7_7 = var6_6.getLayoutParams();
            var7_7.height = var5_5 = this.k;
            var7_7 = var6_6.getLayoutParams();
            var6_6.setLayoutParams(var7_7);
            var4_4 = var1_1;
            var6_6.setTranslationX(var4_4);
            var1_1 = -var1_1;
            var11_11 = var1_1;
            var6_6.setTranslationY(var11_11);
        }
    }

    public void C(int n10) {
        this.h = true;
        this.g = n10;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        bundle = this.getDialog();
        this.D((Dialog)bundle);
        this.w();
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (DeviceViewModel)this.v().get(DeviceViewModel.class);
        this.f = object;
    }

    public void onViewCreated(View object, Bundle object2) {
        boolean bl2 = this.i;
        if (bl2) {
            object = this.f.a;
            object2 = this.getViewLifecycleOwner();
            f f10 = new f(this);
            ((LiveData)object).observe((LifecycleOwner)object2, f10);
        }
    }

    public void u() {
        this.i = true;
    }

    public ViewModelProvider v() {
        return b.c(this.requireActivity());
    }

    public /* synthetic */ void y() {
        this.x();
    }
}

