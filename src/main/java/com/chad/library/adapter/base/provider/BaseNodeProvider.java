/*
 * Decompiled with CFR 0.151.
 */
package com.chad.library.adapter.base.provider;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;

public abstract class BaseNodeProvider
extends BaseItemProvider {
    public BaseNodeAdapter getAdapter() {
        BaseProviderMultiAdapter baseProviderMultiAdapter = super.getAdapter();
        boolean bl2 = baseProviderMultiAdapter instanceof BaseNodeAdapter;
        if (!bl2) {
            baseProviderMultiAdapter = null;
        }
        return (BaseNodeAdapter)baseProviderMultiAdapter;
    }
}

