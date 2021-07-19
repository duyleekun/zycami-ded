/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 */
package com.google.android.material.tabs;

import android.database.DataSetObserver;
import com.google.android.material.tabs.TabLayout;

public class TabLayout$PagerAdapterObserver
extends DataSetObserver {
    public final /* synthetic */ TabLayout this$0;

    public TabLayout$PagerAdapterObserver(TabLayout tabLayout) {
        this.this$0 = tabLayout;
    }

    public void onChanged() {
        this.this$0.populateFromPagerAdapter();
    }

    public void onInvalidated() {
        this.this$0.populateFromPagerAdapter();
    }
}

