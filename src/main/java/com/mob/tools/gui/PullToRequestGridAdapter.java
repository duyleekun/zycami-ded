/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.GridView
 *  android.widget.ListAdapter
 */
package com.mob.tools.gui;

import android.content.Context;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.mob.tools.gui.OnListStopScrollListener;
import com.mob.tools.gui.PullToRequestBaseAdapter;
import com.mob.tools.gui.PullToRequestBaseListAdapter;
import com.mob.tools.gui.PullToRequestGridAdapter$1;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.gui.Scrollable;
import com.mob.tools.gui.ScrollableGridView;

public abstract class PullToRequestGridAdapter
extends PullToRequestBaseListAdapter {
    private PullToRequestBaseAdapter adapter;
    private boolean fling;
    private ScrollableGridView gridView;
    private OnListStopScrollListener osListener;
    private boolean pullUpReady;

    public PullToRequestGridAdapter(PullToRequestView object) {
        super((PullToRequestView)((Object)object));
        object = this.getContext();
        object = this.onNewGridView((Context)object);
        this.gridView = object;
        PullToRequestGridAdapter$1 pullToRequestGridAdapter$1 = new PullToRequestGridAdapter$1(this);
        object.setOnScrollListener(pullToRequestGridAdapter$1);
        super(this);
        this.adapter = object;
        this.gridView.setAdapter((ListAdapter)object);
    }

    public static /* synthetic */ boolean access$002(PullToRequestGridAdapter pullToRequestGridAdapter, boolean bl2) {
        pullToRequestGridAdapter.fling = bl2;
        return bl2;
    }

    public static /* synthetic */ OnListStopScrollListener access$100(PullToRequestGridAdapter pullToRequestGridAdapter) {
        return pullToRequestGridAdapter.osListener;
    }

    public static /* synthetic */ PullToRequestBaseAdapter access$200(PullToRequestGridAdapter pullToRequestGridAdapter) {
        return pullToRequestGridAdapter.adapter;
    }

    public static /* synthetic */ boolean access$302(PullToRequestGridAdapter pullToRequestGridAdapter, boolean bl2) {
        pullToRequestGridAdapter.pullUpReady = bl2;
        return bl2;
    }

    public static /* synthetic */ ScrollableGridView access$400(PullToRequestGridAdapter pullToRequestGridAdapter) {
        return pullToRequestGridAdapter.gridView;
    }

    public Scrollable getBodyView() {
        return this.gridView;
    }

    public GridView getGridView() {
        return this.gridView;
    }

    public boolean isFling() {
        return this.fling;
    }

    public boolean isPullDownReady() {
        return this.gridView.isReadyToPull();
    }

    public boolean isPullUpReady() {
        return this.pullUpReady;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    public ScrollableGridView onNewGridView(Context context) {
        ScrollableGridView scrollableGridView = new ScrollableGridView(context);
        return scrollableGridView;
    }

    public void onScroll(Scrollable scrollable, int n10, int n11, int n12) {
    }

    public void setColumnWidth(int n10) {
        this.gridView.setColumnWidth(n10);
    }

    public void setHorizontalSpacing(int n10) {
        this.gridView.setHorizontalSpacing(n10);
    }

    public void setNumColumns(int n10) {
        this.gridView.setNumColumns(n10);
    }

    public void setStretchMode(int n10) {
        this.gridView.setStretchMode(n10);
    }

    public void setVerticalSpacing(int n10) {
        this.gridView.setVerticalSpacing(n10);
    }
}

