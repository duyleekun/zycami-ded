/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVFile;
import cn.leancloud.core.StorageClient;
import e.a.v0.o;

public class StorageClient$11
implements o {
    public final /* synthetic */ StorageClient this$0;

    public StorageClient$11(StorageClient storageClient) {
        this.this$0 = storageClient;
    }

    public AVFile apply(AVFile aVFile) {
        aVFile.setClassName("_File");
        return aVFile;
    }
}

