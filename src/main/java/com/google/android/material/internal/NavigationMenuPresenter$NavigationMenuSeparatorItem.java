/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.internal;

import com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuItem;

public class NavigationMenuPresenter$NavigationMenuSeparatorItem
implements NavigationMenuPresenter$NavigationMenuItem {
    private final int paddingBottom;
    private final int paddingTop;

    public NavigationMenuPresenter$NavigationMenuSeparatorItem(int n10, int n11) {
        this.paddingTop = n10;
        this.paddingBottom = n11;
    }

    public int getPaddingBottom() {
        return this.paddingBottom;
    }

    public int getPaddingTop() {
        return this.paddingTop;
    }
}

