/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVUser;
import cn.leancloud.core.StorageClient;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;

public class StorageClient$19
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ AVUser val$user;

    public StorageClient$19(StorageClient storageClient, AVUser aVUser) {
        this.this$0 = storageClient;
        this.val$user = aVUser;
    }

    public Boolean apply(AVUser object) {
        Object object2;
        boolean bl2;
        if (object != null && !(bl2 = StringUtil.isEmpty((String)(object2 = ((AVUser)object).getSessionToken())))) {
            object2 = this.val$user;
            object = ((AVUser)object).getSessionToken();
            ((AVUser)object2).internalChangeSessionToken((String)object);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}

