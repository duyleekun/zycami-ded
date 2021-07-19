/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.ops.BaseOperation;
import java.util.HashMap;
import java.util.Map;

public class SetOperation
extends BaseOperation {
    public SetOperation(String string2, Object object) {
        super("Set", string2, object, true);
    }

    public Object apply(Object object) {
        return this.getValue();
    }

    public Map encode() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string2 = this.getField();
        Object object = BaseOperation.encodeObject(this.getValue());
        hashMap.put(string2, object);
        return hashMap;
    }
}

