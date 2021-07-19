/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.module;

import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import f.h2.t.f0;

public final class LoadMoreModuleConfig {
    public static final LoadMoreModuleConfig INSTANCE;
    private static BaseLoadMoreView defLoadMoreView;

    static {
        Object object = new LoadMoreModuleConfig();
        INSTANCE = object;
        defLoadMoreView = object = new SimpleLoadMoreView();
    }

    private LoadMoreModuleConfig() {
    }

    public static /* synthetic */ void defLoadMoreView$annotations() {
    }

    public static final BaseLoadMoreView getDefLoadMoreView() {
        return defLoadMoreView;
    }

    public static final void setDefLoadMoreView(BaseLoadMoreView baseLoadMoreView) {
        f0.q(baseLoadMoreView, "<set-?>");
        defLoadMoreView = baseLoadMoreView;
    }
}

