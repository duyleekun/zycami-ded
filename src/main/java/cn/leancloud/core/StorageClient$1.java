/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.core.StorageClient;
import cn.leancloud.utils.ErrorUtils;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class StorageClient$1
implements o {
    public final /* synthetic */ StorageClient this$0;

    public StorageClient$1(StorageClient storageClient) {
        this.this$0 = storageClient;
    }

    public e0 apply(Throwable throwable) {
        return z.m2(ErrorUtils.propagateException(throwable));
    }
}

