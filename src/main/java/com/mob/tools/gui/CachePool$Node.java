/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

import com.mob.tools.gui.CachePool;
import com.mob.tools.gui.CachePool$1;

public class CachePool$Node {
    private long cacheTime;
    public Object key;
    private int size;
    public final /* synthetic */ CachePool this$0;
    public Object value;

    private CachePool$Node(CachePool cachePool) {
        this.this$0 = cachePool;
    }

    public /* synthetic */ CachePool$Node(CachePool cachePool, CachePool$1 cachePool$1) {
        this(cachePool);
    }

    public static /* synthetic */ long access$100(CachePool$Node cachePool$Node) {
        return cachePool$Node.cacheTime;
    }

    public static /* synthetic */ long access$102(CachePool$Node cachePool$Node, long l10) {
        cachePool$Node.cacheTime = l10;
        return l10;
    }

    public static /* synthetic */ int access$200(CachePool$Node cachePool$Node) {
        return cachePool$Node.size;
    }

    public static /* synthetic */ int access$202(CachePool$Node cachePool$Node, int n10) {
        cachePool$Node.size = n10;
        return n10;
    }
}

