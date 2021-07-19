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
import com.mob.tools.gui.PullToRequestAdatper;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.gui.Scrollable;

public abstract class PullToRequestBaseListAdapter
extends PullToRequestAdatper {
    public PullToRequestBaseListAdapter(PullToRequestView pullToRequestView) {
        super(pullToRequestView);
    }

    public abstract int getCount();

    public abstract Object getItem(int var1);

    public abstract long getItemId(int var1);

    public int getItemViewType(int n10) {
        return 0;
    }

    public abstract View getView(int var1, View var2, ViewGroup var3);

    public int getViewTypeCount() {
        return 1;
    }

    public abstract boolean isFling();

    public abstract void onScroll(Scrollable var1, int var2, int var3, int var4);
}

