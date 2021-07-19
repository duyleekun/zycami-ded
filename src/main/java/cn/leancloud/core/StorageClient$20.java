/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVUser;
import cn.leancloud.core.StorageClient;
import cn.leancloud.types.AVNull;
import e.a.v0.o;

public class StorageClient$20
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ AVUser val$user;

    public StorageClient$20(StorageClient storageClient, AVUser aVUser) {
        this.this$0 = storageClient;
        this.val$user = aVUser;
    }

    public AVNull apply(AVUser object) {
        if (object != null) {
            AVUser aVUser = this.val$user;
            object = ((AVUser)object).getSessionToken();
            aVUser.internalChangeSessionToken((String)object);
        }
        object = new AVNull();
        return object;
    }
}

