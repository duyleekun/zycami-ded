/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.ops;

import java.util.Map;

public interface ObjectFieldOperation {
    public Object apply(Object var1);

    public boolean checkCircleReference(Map var1);

    public Map encode();

    public String getField();

    public String getOperation();

    public Object getValue();

    public ObjectFieldOperation merge(ObjectFieldOperation var1);
}

