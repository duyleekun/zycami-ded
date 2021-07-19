/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.widget.ListAdapter
 *  android.widget.ListView
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.mob.tools.gui.OnListStopScrollListener;
import com.mob.tools.gui.PullToRequestBaseAdapter;
import com.mob.tools.gui.PullToRequestBaseListAdapter;
import com.mob.tools.gui.PullToRequestListAdapter$1;
import com.mob.tools.gui.PullToRequestView;
import com.mob.tools.gui.Scrollable;
import com.mob.tools.gui.ScrollableListView;

public abstract class PullToRequestListAdapter
extends PullToRequestBaseListAdapter {
    private PullToRequestBaseAdapter adapter;
    private boolean fling;
    private ScrollableListView listView;
    private OnListStopScrollListener osListener;
    private boolean pullUpReady;

    public PullToRequestListAdapter(PullToRequestView object) {
        super((PullToRequestView)((Object)object));
        object = this.getContext();
        object = this.onNewListView((Context)object);
        this.listView = object;
        PullToRequestListAdapter$1 pullToRequestListAdapter$1 = new PullToRequestListAdapter$1(this);
        object.setOnScrollListener(pullToRequestListAdapter$1);
        super(this);
        this.adapter = object;
        this.listView.setAdapter((ListAdapter)object);
    }

    public static /* synthetic */ boolean access$002(PullToRequestListAdapter pullToRequestListAdapter, boolean bl2) {
        pullToRequestListAdapter.fling = bl2;
        return bl2;
    }

    public static /* synthetic */ OnListStopScrollListener access$100(PullToRequestListAdapter pullToRequestListAdapter) {
        return pullToRequestListAdapter.osListener;
    }

    public static /* synthetic */ PullToRequestBaseAdapter access$200(PullToRequestListAdapter pullToRequestListAdapter) {
        return pullToRequestListAdapter.adapter;
    }

    public static /* synthetic */ boolean access$302(PullToRequestListAdapter pullToRequestListAdapter, boolean bl2) {
        pullToRequestListAdapter.pullUpReady = bl2;
        return bl2;
    }

    public static /* synthetic */ ScrollableListView access$400(PullToRequestListAdapter pullToRequestListAdapter) {
        return pullToRequestListAdapter.listView;
    }

    public Scrollable getBodyView() {
        return this.listView;
    }

    public ListView getListView() {
        return this.listView;
    }

    public boolean isFling() {
        return this.fling;
    }

    public boolean isPullDownReady() {
        return this.listView.isReadyToPull();
    }

    public boolean isPullUpReady() {
        return this.pullUpReady;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.adapter.notifyDataSetChanged();
    }

    public ScrollableListView onNewListView(Context context) {
        ScrollableListView scrollableListView = new ScrollableListView(context);
        return scrollableListView;
    }

    public void onScroll(Scrollable scrollable, int n10, int n11, int n12) {
    }

    public void setDivider(Drawable drawable2) {
        this.listView.setDivider(drawable2);
    }

    public void setDividerHeight(int n10) {
        this.listView.setDividerHeight(n10);
    }
}

