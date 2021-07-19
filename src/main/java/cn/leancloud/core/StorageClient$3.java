/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.AVUser;
import cn.leancloud.core.StorageClient;
import cn.leancloud.core.StorageClient$3$1;
import e.a.e0;
import e.a.v0.o;
import e.a.z;
import java.util.Map;

public class StorageClient$3
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ AVUser val$authenticatedUser;
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ String val$className;
    public final /* synthetic */ Map val$query;

    public StorageClient$3(StorageClient storageClient, AVUser aVUser, String string2, Map map, String string3) {
        this.this$0 = storageClient;
        this.val$authenticatedUser = aVUser;
        this.val$className = string2;
        this.val$query = map;
        this.val$cacheKey = string3;
    }

    public e0 apply(Throwable object) {
        Object object2 = StorageClient.access$000();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("failed to query local cache, cause: ");
        object = ((Throwable)object).getMessage();
        charSequence.append((String)object);
        charSequence.append(", try to query networking");
        object = charSequence.toString();
        ((AVLogger)object2).d((String)object);
        object = this.this$0;
        object2 = this.val$authenticatedUser;
        charSequence = this.val$className;
        Map map = this.val$query;
        object = StorageClient.access$100((StorageClient)object, (AVUser)object2, (String)charSequence, map);
        object2 = new StorageClient$3$1(this);
        return ((z)object).H3((o)object2);
    }
}

