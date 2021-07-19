/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.module;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnUpFetchListener;
import com.chad.library.adapter.base.listener.UpFetchListenerImp;
import f.h2.t.f0;

public class BaseUpFetchModule
implements UpFetchListenerImp {
    private final BaseQuickAdapter baseQuickAdapter;
    private boolean isUpFetchEnable;
    private boolean isUpFetching;
    private OnUpFetchListener mUpFetchListener;
    private int startUpFetchPosition;

    public BaseUpFetchModule(BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter;
        this.startUpFetchPosition = 1;
    }

    public final void autoUpFetch$com_github_CymChad_brvah(int n10) {
        OnUpFetchListener onUpFetchListener;
        int n11 = this.isUpFetchEnable;
        if (n11 != 0 && (n11 = this.isUpFetching) == 0 && n10 <= (n11 = this.startUpFetchPosition) && (onUpFetchListener = this.mUpFetchListener) != null) {
            onUpFetchListener.onUpFetch();
        }
    }

    public final int getStartUpFetchPosition() {
        return this.startUpFetchPosition;
    }

    public final boolean isUpFetchEnable() {
        return this.isUpFetchEnable;
    }

    public final boolean isUpFetching() {
        return this.isUpFetching;
    }

    public void setOnUpFetchListener(OnUpFetchListener onUpFetchListener) {
        this.mUpFetchListener = onUpFetchListener;
    }

    public final void setStartUpFetchPosition(int n10) {
        this.startUpFetchPosition = n10;
    }

    public final void setUpFetchEnable(boolean bl2) {
        this.isUpFetchEnable = bl2;
    }

    public final void setUpFetching(boolean bl2) {
        this.isUpFetching = bl2;
    }
}

