/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.BaseUpFetchModule;

public interface BaseQuickAdapterModuleImp {
    public BaseDraggableModule addDraggableModule(BaseQuickAdapter var1);

    public BaseLoadMoreModule addLoadMoreModule(BaseQuickAdapter var1);

    public BaseUpFetchModule addUpFetchModule(BaseQuickAdapter var1);
}

