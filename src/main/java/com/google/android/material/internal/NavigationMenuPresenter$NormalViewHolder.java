/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package com.google.android.material.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$layout;
import com.google.android.material.internal.NavigationMenuPresenter$ViewHolder;

public class NavigationMenuPresenter$NormalViewHolder
extends NavigationMenuPresenter$ViewHolder {
    public NavigationMenuPresenter$NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        int n10 = R$layout.design_navigation_item;
        layoutInflater = layoutInflater.inflate(n10, viewGroup, false);
        super((View)layoutInflater);
        this.itemView.setOnClickListener(onClickListener);
    }
}

