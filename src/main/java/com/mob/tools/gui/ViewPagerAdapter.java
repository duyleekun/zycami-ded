/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;
import com.mob.tools.gui.MobViewPager;

public abstract class ViewPagerAdapter {
    private MobViewPager parent;

    public abstract int getCount();

    public abstract View getView(int var1, View var2, ViewGroup var3);

    public void invalidate() {
        MobViewPager mobViewPager = this.parent;
        if (mobViewPager != null) {
            mobViewPager.setAdapter(this);
        }
    }

    public void onScreenChange(int n10, int n11) {
    }

    public void onScreenChanging(float f10) {
    }

    public final void setMobViewPager(MobViewPager mobViewPager) {
        this.parent = mobViewPager;
    }
}

