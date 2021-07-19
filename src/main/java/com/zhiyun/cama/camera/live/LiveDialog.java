/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.app.Dialog
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 *  android.view.Window
 *  android.widget.TextView
 */
package com.zhiyun.cama.camera.live;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.camera.live.LiveDialog$a;
import com.zhiyun.cama.camera.live.LiveDialog$b;
import com.zhiyun.common.util.Windows;
import d.v.c.s0.d7.z;
import d.v.c.w0.f5;
import d.v.f.g.a;
import d.v.f.i.g;
import d.v.i0.b;

public class LiveDialog
extends a {
    public static final String j = "LIVE_DIALOG_TYPE";
    public static final String k = "LIVE_DIALOG_ROTATION";
    public static final int l = 1;
    public static final int m = 2;
    public static final int n = 3;
    public static final int o = 4;
    public static final int p = 5;
    public static final int q = 6;
    public static final int r = 7;
    private f5 f;
    private z g;
    public int h;
    public int i = 3;

    public static /* synthetic */ z u(LiveDialog liveDialog) {
        return liveDialog.g;
    }

    public static /* synthetic */ f5 v(LiveDialog liveDialog) {
        return liveDialog.f;
    }

    private void w() {
        int n10;
        int n11 = this.h;
        switch (n11) {
            default: {
                break;
            }
            case 6: {
                TextView textView = this.f.c;
                String string2 = d.v.f.i.g.o(this.getResources(), 2131952411);
                textView.setText((CharSequence)string2);
                textView = this.f.e;
                string2 = d.v.f.i.g.o(this.getResources(), 2131952477);
                textView.setText((CharSequence)string2);
                textView = this.f.d;
                string2 = this.getResources();
                int n12 = 2131951892;
                string2 = d.v.f.i.g.o((Resources)string2, n12);
                textView.setText((CharSequence)string2);
                break;
            }
            case 5: {
                TextView textView = this.f.c;
                String string3 = d.v.f.i.g.o(this.getResources(), 2131952433);
                textView.setText((CharSequence)string3);
                textView = this.f.e;
                string3 = this.getResources();
                int n13 = 2131952434;
                string3 = d.v.f.i.g.o((Resources)string3, n13);
                textView.setText((CharSequence)string3);
                break;
            }
            case 4: 
            case 7: {
                TextView textView = this.f.c;
                Object object = this.getResources();
                int n14 = 2131952479;
                object = d.v.f.i.g.o(object, n14);
                textView.setText((CharSequence)object);
                break;
            }
            case 3: {
                TextView textView = this.f.c;
                String string4 = d.v.f.i.g.o(this.getResources(), 2131952404);
                textView.setText((CharSequence)string4);
                textView = this.f.e;
                string4 = d.v.f.i.g.o(this.getResources(), 2131952799);
                textView.setText((CharSequence)string4);
                textView = this.f.d;
                string4 = this.getResources();
                int n15 = 2131951851;
                string4 = d.v.f.i.g.o((Resources)string4, n15);
                textView.setText((CharSequence)string4);
                break;
            }
            case 2: {
                TextView textView = this.f.f;
                n10 = 0;
                textView.setVisibility(0);
                textView = this.f.f;
                String string5 = d.v.f.i.g.o(this.getResources(), 2131952431);
                textView.setText((CharSequence)string5);
                textView = this.f.c;
                string5 = this.g.z();
                textView.setText((CharSequence)string5);
                textView = this.f.e;
                string5 = this.getResources();
                int n16 = 2131952432;
                string5 = d.v.f.i.g.o((Resources)string5, n16);
                textView.setText((CharSequence)string5);
                break;
            }
            case 1: {
                TextView textView = this.f.c;
                Object object = this.getResources();
                int n17 = 2131952410;
                object = d.v.f.i.g.o(object, n17);
                textView.setText((CharSequence)object);
            }
        }
        n11 = this.i;
        if (n11 == 0 || n11 == (n10 = 2)) {
            this.y(n11);
        }
    }

    private void x(int n10, int n11) {
        View view = this.getView();
        float f10 = n10;
        f10 = n11;
        float[] fArray = new float[]{f10, f10};
        ObjectAnimator.ofFloat((Object)view, (String)"rotation", (float[])fArray).setDuration(0L).start();
    }

    private void y(int n10) {
        block4: {
            block2: {
                block3: {
                    if (n10 == 0) break block2;
                    int n11 = 1;
                    if (n10 == n11) break block3;
                    n11 = 2;
                    if (n10 == n11) break block2;
                    n11 = 3;
                    if (n10 != n11) break block4;
                }
                n10 = 90;
                this.x(n10, 0);
                break block4;
            }
            n10 = -90;
            this.x(0, n10);
        }
    }

    private void z() {
        Dialog dialog = this.getDialog();
        if (dialog == null) {
            return;
        }
        dialog = this.getDialog().getWindow();
        if (dialog == null) {
            return;
        }
        int n10 = -1;
        dialog.setLayout(n10, n10);
        dialog.setBackgroundDrawable(null);
    }

    public void onResume() {
        super.onResume();
        Dialog dialog = this.getDialog();
        if (dialog != null && (dialog = this.getDialog().getWindow()) != null) {
            dialog = this.getDialog().getWindow();
            int n10 = 8;
            dialog.clearFlags(n10);
            dialog = this.getDialog().getWindow();
            Windows.p((Window)dialog);
        }
    }

    public void onStart() {
        super.onStart();
        this.z();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = (z)b.c(this.requireActivity()).get(z.class);
        this.g = object;
        object = this.requireActivity().getOnBackPressedDispatcher();
        object2 = this.getViewLifecycleOwner();
        boolean bl2 = true;
        LiveDialog$a liveDialog$a = new LiveDialog$a(this, bl2);
        ((OnBackPressedDispatcher)object).addCallback((LifecycleOwner)object2, liveDialog$a);
        object = this.getArguments();
        if (object != null) {
            int n10;
            this.h = n10 = this.getArguments().getInt(j);
            object = this.getArguments();
            object2 = k;
            this.i = n10 = object.getInt((String)object2);
        }
        this.w();
    }

    public void p(int n10) {
        int n11 = this.i;
        if (n10 != n11) {
            this.i = n10;
            this.y(n10);
        }
    }

    public int s() {
        return 2131558551;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        viewDataBinding = (f5)viewDataBinding;
        this.f = viewDataBinding;
        LiveDialog$b liveDialog$b = new LiveDialog$b(this);
        ((f5)viewDataBinding).z(liveDialog$b);
    }
}

