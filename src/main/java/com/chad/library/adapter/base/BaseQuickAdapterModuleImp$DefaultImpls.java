/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapterModuleImp;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.BaseUpFetchModule;
import f.h2.t.f0;

public final class BaseQuickAdapterModuleImp$DefaultImpls {
    public static BaseDraggableModule addDraggableModule(BaseQuickAdapterModuleImp object, BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        object = new BaseDraggableModule(baseQuickAdapter);
        return object;
    }

    public static BaseLoadMoreModule addLoadMoreModule(BaseQuickAdapterModuleImp object, BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        object = new BaseLoadMoreModule(baseQuickAdapter);
        return object;
    }

    public static BaseUpFetchModule addUpFetchModule(BaseQuickAdapterModuleImp object, BaseQuickAdapter baseQuickAdapter) {
        f0.q(baseQuickAdapter, "baseQuickAdapter");
        object = new BaseUpFetchModule(baseQuickAdapter);
        return object;
    }
}

