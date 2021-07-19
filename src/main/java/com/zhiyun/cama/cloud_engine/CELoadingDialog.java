/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.zhiyun.cama.cloud_engine;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.LifecycleOwner;
import com.zhiyun.cama.cloud_engine.CELoadingDialog$a;
import d.v.f.g.c;

public class CELoadingDialog
extends c {
    private void s() {
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2131558517, viewGroup, false);
    }

    public void onStart() {
        super.onStart();
        this.s();
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.requireActivity().getOnBackPressedDispatcher();
        object2 = this.getViewLifecycleOwner();
        CELoadingDialog$a cELoadingDialog$a = new CELoadingDialog$a(this, true);
        ((OnBackPressedDispatcher)object).addCallback((LifecycleOwner)object2, cELoadingDialog$a);
    }
}

