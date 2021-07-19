/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.Transformer;
import cn.leancloud.core.StorageClient;
import e.a.v0.o;

public class StorageClient$8
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ String val$className;

    public StorageClient$8(StorageClient storageClient, String string2) {
        this.this$0 = storageClient;
        this.val$className = string2;
    }

    public AVObject apply(AVObject aVObject) {
        Object object = StorageClient.access$000();
        String string2 = aVObject.toString();
        ((AVLogger)object).d(string2);
        object = this.val$className;
        return Transformer.transform(aVObject, (String)object);
    }
}

