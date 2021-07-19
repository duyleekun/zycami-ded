/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package com.mob.tools.gui;

import android.content.Context;
import android.view.View;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.gui.Scrollable;

public abstract class PullToRequestAdatper {
    private Context context;
    private PullToRequestView parent;

    public PullToRequestAdatper(PullToRequestView pullToRequestView) {
        Context context;
        this.context = context = pullToRequestView.getContext();
        this.parent = pullToRequestView;
    }

    public abstract Scrollable getBodyView();

    public Context getContext() {
        return this.context;
    }

    public abstract View getFooterView();

    public abstract View getHeaderView();

    public PullToRequestView getParent() {
        return this.parent;
    }

    public abstract boolean isPullDownReady();

    public abstract boolean isPullUpReady();

    public void notifyDataSetChanged() {
        this.parent.stopPulling();
    }

    public void onPullDown(int n10) {
    }

    public void onPullUp(int n10) {
    }

    public void onRefresh() {
    }

    public void onRequestNext() {
    }

    public void onReversed() {
    }
}

