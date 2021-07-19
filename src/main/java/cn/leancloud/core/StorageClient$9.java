/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.Transformer;
import cn.leancloud.core.StorageClient;
import e.a.v0.o;

public class StorageClient$9
implements o {
    public final /* synthetic */ StorageClient this$0;
    public final /* synthetic */ String val$className;

    public StorageClient$9(StorageClient storageClient, String string2) {
        this.this$0 = storageClient;
        this.val$className = string2;
    }

    public AVObject apply(AVObject aVObject) {
        Object object = StorageClient.access$000();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("saveObject finished. intermediaObj=");
        String string2 = aVObject.toString();
        charSequence.append(string2);
        charSequence.append(", convert to ");
        string2 = this.val$className;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object).d((String)charSequence);
        object = this.val$className;
        return Transformer.transform(aVObject, (String)object);
    }
}

