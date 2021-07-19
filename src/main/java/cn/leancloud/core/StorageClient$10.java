/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVObject;
import cn.leancloud.Transformer;
import cn.leancloud.core.StorageClient;
import e.a.v0.o;

public class StorageClient$10
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ Class val$clazz;

    public StorageClient$10(StorageClient storageClient, Class clazz) {
        this.this$0 = storageClient;
        this.val$clazz = clazz;
    }

    public AVObject apply(AVObject aVObject) {
        Class clazz = this.val$clazz;
        return Transformer.transform(aVObject, clazz);
    }
}

