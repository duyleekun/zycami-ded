/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.core.StorageClient;
import cn.leancloud.core.StorageClient$27;
import cn.leancloud.json.JSON;
import cn.leancloud.ops.Utils;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import java.util.Collection;
import java.util.Map;

public class StorageClient$27$1
implements o {
    public final /* synthetic */ StorageClient$27 this$1;

    public StorageClient$27$1(StorageClient$27 storageClient$27) {
        this.this$1 = storageClient$27;
    }

    public Object apply(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (bl2) {
            return null;
        }
        AVLogger aVLogger = StorageClient.access$000();
        CharSequence charSequence = new StringBuilder();
        String string2 = "found cached rpc result: ";
        charSequence.append(string2);
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        aVLogger.d((String)charSequence);
        object = JSON.parse((String)object);
        bl2 = object instanceof Collection;
        if (bl2) {
            return Utils.getObjectFrom((Collection)object);
        }
        bl2 = object instanceof Map;
        if (bl2) {
            object = Utils.getObjectFrom((Map)object);
        }
        return object;
    }
}

