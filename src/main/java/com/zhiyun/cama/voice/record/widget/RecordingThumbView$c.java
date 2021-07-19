/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.voice.record.widget;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class RecordingThumbView$c
extends RecyclerView$ViewHolder {
    private ViewDataBinding a;

    public RecordingThumbView$c(ViewDataBinding viewDataBinding) {
        View view = viewDataBinding.getRoot();
        super(view);
        this.a = viewDataBinding;
    }

    public void a(ViewDataBinding viewDataBinding) {
        this.a = viewDataBinding;
    }

    public ViewDataBinding getBinding() {
        return this.a;
    }
}

