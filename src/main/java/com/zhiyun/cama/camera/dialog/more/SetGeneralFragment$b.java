/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.CheckedTextView
 */
package com.zhiyun.cama.camera.dialog.more;

import android.view.View;
import android.widget.CheckedTextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment$a;
import d.v.c.y0.b.s;

public final class SetGeneralFragment$b {
    public final /* synthetic */ SetGeneralFragment a;

    private SetGeneralFragment$b(SetGeneralFragment setGeneralFragment) {
        this.a = setGeneralFragment;
    }

    public /* synthetic */ SetGeneralFragment$b(SetGeneralFragment setGeneralFragment, SetGeneralFragment.a a10) {
        this(setGeneralFragment);
    }

    public void a() {
        ((DialogFragment)this.a.getParentFragment().getParentFragment()).dismiss();
        s s10 = new s();
        FragmentManager fragmentManager = this.a.getActivity().getSupportFragmentManager();
        int n10 = SetGeneralFragment.j(this.a);
        s10.r(fragmentManager, n10);
    }

    public void b(View view) {
        view = (CheckedTextView)view;
        view.toggle();
        BleViewModel bleViewModel = SetGeneralFragment.l(this.a);
        boolean bl2 = view.isChecked();
        bleViewModel.h1(bl2);
    }
}

