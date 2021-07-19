/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVUser;
import cn.leancloud.core.StorageClient;
import e.a.v0.o;

public class StorageClient$17
implements o {
    public final /* synthetic */ StorageClient this$0;

    public StorageClient$17(StorageClient storageClient) {
        this.this$0 = storageClient;
    }

    public Boolean apply(AVUser aVUser) {
        if (aVUser != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

