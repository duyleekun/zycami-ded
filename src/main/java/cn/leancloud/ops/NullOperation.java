/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.ObjectFieldOperation;
import java.util.Map;

public final class NullOperation
extends BaseOperation {
    public static final NullOperation gInstance;

    static {
        NullOperation nullOperation;
        gInstance = nullOperation = new NullOperation("nothing", null);
    }

    public NullOperation(String string2, Object object) {
        super("Null", string2, object, false);
    }

    public Object apply(Object object) {
        return object;
    }

    public Map encode() {
        return null;
    }

    public ObjectFieldOperation mergeWithPrevious(ObjectFieldOperation objectFieldOperation) {
        return objectFieldOperation;
    }
}

