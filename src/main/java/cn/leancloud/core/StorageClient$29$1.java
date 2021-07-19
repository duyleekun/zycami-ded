/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.core.StorageClient;
import cn.leancloud.core.StorageClient$29;
import cn.leancloud.gson.NumberDeserializerDoubleAsIntFix;
import cn.leancloud.json.JSON;
import cn.leancloud.ops.Utils;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import java.util.Collection;
import java.util.Map;

public class StorageClient$29$1
implements o {
    public final /* synthetic */ StorageClient$29 this$1;

    public StorageClient$29$1(StorageClient$29 storageClient$29) {
        this.this$1 = storageClient$29;
    }

    public Object apply(String string2) {
        boolean bl2;
        Object object;
        block8: {
            String string3 = "result";
            boolean bl3 = StringUtil.isEmpty(string2);
            if (bl3) {
                return null;
            }
            object = StorageClient.access$000();
            CharSequence charSequence = new StringBuilder();
            String string4 = "found cached function result: ";
            charSequence.append(string4);
            charSequence.append(string2);
            charSequence = charSequence.toString();
            ((AVLogger)object).d((String)charSequence);
            object = JSON.parseObject(string2);
            if (object == null) break block8;
            boolean bl4 = object.containsKey(string3);
            if (!bl4) break block8;
            try {
                object = object.get(string3);
            }
            catch (Exception exception) {
                object = JSON.parse(string2);
            }
        }
        if (bl2 = object instanceof Collection) {
            return Utils.getObjectFrom((Collection)object);
        }
        bl2 = object instanceof Map;
        if (bl2) {
            return Utils.getObjectFrom((Map)object);
        }
        bl2 = object instanceof Number;
        if (bl2) {
            return NumberDeserializerDoubleAsIntFix.parsePrecisionNumber((Number)object);
        }
        return object;
    }
}

