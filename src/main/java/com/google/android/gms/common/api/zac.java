/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import java.util.Map;
import java.util.WeakHashMap;

public abstract class zac {
    private static final Object sLock;
    private static final Map zack;

    static {
        Object object = new WeakHashMap();
        zack = object;
        sLock = object = new Object();
    }

    public abstract void remove(int var1);
}

