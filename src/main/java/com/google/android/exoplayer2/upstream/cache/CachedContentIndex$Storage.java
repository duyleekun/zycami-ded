/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.upstream.cache;

import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.cache.CachedContent;
import java.util.HashMap;

public interface CachedContentIndex$Storage {
    public void delete();

    public boolean exists();

    public void initialize(long var1);

    public void load(HashMap var1, SparseArray var2);

    public void onRemove(CachedContent var1, boolean var2);

    public void onUpdate(CachedContent var1);

    public void storeFully(HashMap var1);

    public void storeIncremental(HashMap var1);
}

