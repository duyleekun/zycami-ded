/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.material.internal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R$layout;
import com.google.android.material.internal.NavigationMenuPresenter$ViewHolder;

public class NavigationMenuPresenter$SeparatorViewHolder
extends NavigationMenuPresenter$ViewHolder {
    public NavigationMenuPresenter$SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int n10 = R$layout.design_navigation_item_separator;
        layoutInflater = layoutInflater.inflate(n10, viewGroup, false);
        super((View)layoutInflater);
    }
}

