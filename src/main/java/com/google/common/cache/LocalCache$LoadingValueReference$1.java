/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.LocalCache$LoadingValueReference;

public class LocalCache$LoadingValueReference$1
implements Function {
    public final /* synthetic */ LocalCache$LoadingValueReference this$0;

    public LocalCache$LoadingValueReference$1(LocalCache$LoadingValueReference localCache$LoadingValueReference) {
        this.this$0 = localCache$LoadingValueReference;
    }

    public Object apply(Object object) {
        this.this$0.set(object);
        return object;
    }
}

