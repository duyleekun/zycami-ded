/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.chad.library.adapter.base.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import f.h2.t.f0;

public final class AdapterUtilsKt {
    public static final View getItemView(ViewGroup viewGroup, int n10) {
        f0.q(viewGroup, "$this$getItemView");
        viewGroup = LayoutInflater.from((Context)viewGroup.getContext()).inflate(n10, viewGroup, false);
        f0.h(viewGroup, "LayoutInflater.from(this\u2026layoutResId, this, false)");
        return viewGroup;
    }
}

