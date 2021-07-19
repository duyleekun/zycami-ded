/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVFriendshipRequest;
import cn.leancloud.AVObject;
import cn.leancloud.Transformer;
import cn.leancloud.core.StorageClient;
import e.a.v0.o;

public class StorageClient$14
implements o {
    public final /* synthetic */ StorageClient this$0;

    public StorageClient$14(StorageClient storageClient) {
        this.this$0 = storageClient;
    }

    public AVFriendshipRequest apply(AVObject aVObject) {
        return (AVFriendshipRequest)Transformer.transform(aVObject, AVFriendshipRequest.class);
    }
}

