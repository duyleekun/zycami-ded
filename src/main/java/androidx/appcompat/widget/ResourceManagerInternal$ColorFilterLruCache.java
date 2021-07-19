/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 */
package androidx.appcompat.widget;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.collection.LruCache;

public class ResourceManagerInternal$ColorFilterLruCache
extends LruCache {
    public ResourceManagerInternal$ColorFilterLruCache(int n10) {
        super(n10);
    }

    private static int generateCacheKey(int n10, PorterDuff.Mode mode) {
        int n11 = 31;
        n10 = (n10 + n11) * n11;
        int n12 = mode.hashCode();
        return n10 + n12;
    }

    public PorterDuffColorFilter get(int n10, PorterDuff.Mode mode) {
        Integer n11 = ResourceManagerInternal$ColorFilterLruCache.generateCacheKey(n10, mode);
        return (PorterDuffColorFilter)this.get(n11);
    }

    public PorterDuffColorFilter put(int n10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
        Integer n11 = ResourceManagerInternal$ColorFilterLruCache.generateCacheKey(n10, mode);
        return (PorterDuffColorFilter)this.put(n11, porterDuffColorFilter);
    }
}

