/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.Transformer;
import cn.leancloud.core.StorageClient;
import e.a.v0.o;

public class StorageClient$18
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ Class val$clazz;

    public StorageClient$18(StorageClient storageClient, Class clazz) {
        this.this$0 = storageClient;
        this.val$clazz = clazz;
    }

    public AVUser apply(AVUser aVUser) {
        if (aVUser == null) {
            StorageClient.access$000().e("The mapper function returned a null value.");
            return null;
        }
        Class clazz = this.val$clazz;
        return (AVUser)Transformer.transform((AVObject)aVUser, clazz);
    }
}

