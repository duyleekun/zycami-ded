/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.Transformer;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSONObject;
import e.a.v0.o;

public class StorageClient$12
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ Class val$clazz;
    public final /* synthetic */ JSONObject val$data;

    public StorageClient$12(StorageClient storageClient, Class clazz, JSONObject jSONObject) {
        this.this$0 = storageClient;
        this.val$clazz = clazz;
        this.val$data = jSONObject;
    }

    public AVUser apply(AVUser aVUser) {
        Object object = this.val$clazz;
        aVUser = (AVUser)Transformer.transform((AVObject)aVUser, (Class)object);
        object = this.this$0;
        JSONObject jSONObject = this.val$data;
        StorageClient.access$200((StorageClient)object, jSONObject, aVUser);
        AVUser.changeCurrentUser(aVUser, true);
        return aVUser;
    }
}

