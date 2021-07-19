/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.BaseAdapter
 */
package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.mob.tools.gui.PullToRequestBaseListAdapter;

public class PullToRequestBaseAdapter
extends BaseAdapter {
    private PullToRequestBaseListAdapter adapter;

    public PullToRequestBaseAdapter(PullToRequestBaseListAdapter pullToRequestBaseListAdapter) {
        this.adapter = pullToRequestBaseListAdapter;
    }

    public int getCount() {
        return this.adapter.getCount();
    }

    public Object getItem(int n10) {
        return this.adapter.getItem(n10);
    }

    public long getItemId(int n10) {
        return this.adapter.getItemId(n10);
    }

    public int getItemViewType(int n10) {
        return this.adapter.getItemViewType(n10);
    }

    public View getView(int n10, View view, ViewGroup viewGroup) {
        return this.adapter.getView(n10, view, viewGroup);
    }

    public int getViewTypeCount() {
        return this.adapter.getViewTypeCount();
    }
}

