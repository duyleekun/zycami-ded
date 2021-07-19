/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package com.zhiyun.cama.camera.dialog.more;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.camera.dialog.more.WhiteBalanceFragment$a;
import com.zhiyun.cama.data.database.model.CameraParam;
import d.v.c.s0.a7.m1;
import d.v.c.s0.a7.o1.p0;
import d.v.c.s0.a7.o1.q0;
import d.v.c.s0.u6;
import d.v.c.w0.d2;
import d.v.f.h.a;
import d.v.i0.b;

public class WhiteBalanceFragment
extends a {
    private d2 b;
    private u6 c;

    public static /* synthetic */ u6 j(WhiteBalanceFragment whiteBalanceFragment) {
        return whiteBalanceFragment.c;
    }

    public static /* synthetic */ d2 k(WhiteBalanceFragment whiteBalanceFragment) {
        return whiteBalanceFragment.b;
    }

    public static int l(Integer n10) {
        int n11 = 2131953244;
        if (n10 == null) {
            return n11;
        }
        int n12 = n10;
        if (n12 != 0) {
            int n13 = 1;
            if (n12 != n13) {
                n13 = 2;
                if (n12 != n13) {
                    n13 = 3;
                    if (n12 != n13) {
                        n13 = 4;
                        if (n12 == n13) {
                            n11 = 2131953287;
                        }
                    } else {
                        n11 = 2131953288;
                    }
                } else {
                    n11 = 2131953285;
                }
            } else {
                n11 = 2131953289;
            }
        }
        return n11;
    }

    private void m() {
        LiveData liveData = this.c.J();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        q0 q02 = new q0(this);
        liveData.observe(lifecycleOwner, q02);
    }

    private void n() {
        Object object = this.b.a;
        Object object2 = new p0(this);
        object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object2);
        object = this.b.b;
        object2 = new WhiteBalanceFragment$a(this);
        object.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)object2);
    }

    private void o() {
        int n10;
        Object object = this.c.o();
        Object object2 = this.b.a;
        object2.removeAllViews();
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            n10 = (Integer)object.next();
            Context context = this.requireContext();
            RadioGroup radioGroup = this.b.a;
            Integer n11 = n10;
            int n12 = WhiteBalanceFragment.l(n11);
            object2 = n10;
            object2 = m1.c(context, radioGroup, n12, object2);
            context = this.b.a;
            context.addView((View)object2);
        }
    }

    private /* synthetic */ void p(CameraParam object) {
        if (object != null) {
            Object object2 = this.b.a;
            int n10 = ((CameraParam)object).getWhiteBalance();
            object = n10;
            m1.a(object2, object);
            object = this.c.J();
            object2 = this.getViewLifecycleOwner();
            ((LiveData)object).removeObservers((LifecycleOwner)object2);
        }
    }

    private /* synthetic */ void r(RadioGroup radioGroup, int n10) {
        radioGroup = (RadioButton)radioGroup.findViewById(n10);
        u6 u62 = this.c;
        int n11 = (Integer)radioGroup.getTag();
        u62.T1(n11);
    }

    public int h() {
        return 2131558481;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (d2)viewDataBinding;
        this.b = viewDataBinding;
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (u6)d.v.i0.b.c(this.requireActivity()).get(u6.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m();
        this.o();
        this.n();
    }

    public /* synthetic */ void q(CameraParam cameraParam) {
        this.p(cameraParam);
    }

    public /* synthetic */ void s(RadioGroup radioGroup, int n10) {
        this.r(radioGroup, n10);
    }
}

