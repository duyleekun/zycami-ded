/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.ops.BaseOperation;
import java.util.HashMap;
import java.util.Map;

public class DeleteOperation
extends BaseOperation {
    public DeleteOperation(String string2) {
        super("Delete", string2, null, true);
    }

    public Object apply(Object object) {
        return null;
    }

    public Map encode() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        HashMap hashMap2 = this.getOperation();
        hashMap.put("__op", (String)((Object)hashMap2));
        hashMap2 = new HashMap();
        String string2 = this.getField();
        hashMap2.put(string2, hashMap);
        return hashMap2;
    }
}

