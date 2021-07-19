/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVObject;
import cn.leancloud.Transformer;
import cn.leancloud.core.StorageClient;
import e.a.v0.o;

public class StorageClient$2
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ String val$className;

    public StorageClient$2(StorageClient storageClient, String string2) {
        this.this$0 = storageClient;
        this.val$className = string2;
    }

    public AVObject apply(AVObject aVObject) {
        String string2 = this.val$className;
        return Transformer.transform(aVObject, string2);
    }
}

