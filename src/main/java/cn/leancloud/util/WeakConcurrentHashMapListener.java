/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.util;

public interface WeakConcurrentHashMapListener {
    public void notifyOnAdd(Object var1, Object var2);

    public void notifyOnRemoval(Object var1, Object var2);
}

