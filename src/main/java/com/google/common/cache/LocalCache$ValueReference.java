/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.cache;

import com.google.common.cache.ReferenceEntry;
import java.lang.ref.ReferenceQueue;

public interface LocalCache$ValueReference {
    public LocalCache$ValueReference copyFor(ReferenceQueue var1, Object var2, ReferenceEntry var3);

    public Object get();

    public ReferenceEntry getEntry();

    public int getWeight();

    public boolean isActive();

    public boolean isLoading();

    public void notifyNewValue(Object var1);

    public Object waitForValue();
}

