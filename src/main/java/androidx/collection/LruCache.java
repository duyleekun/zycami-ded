/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class LruCache {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int n10) {
        if (n10 > 0) {
            LinkedHashMap linkedHashMap;
            this.maxSize = n10;
            this.map = linkedHashMap = new LinkedHashMap(0, 0.75f, true);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
        throw illegalArgumentException;
    }

    private int safeSizeOf(Object object, Object object2) {
        int n10 = this.sizeOf(object, object2);
        if (n10 >= 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative size: ");
        stringBuilder.append(object);
        stringBuilder.append("=");
        stringBuilder.append(object2);
        object = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public Object create(Object object) {
        return null;
    }

    public final int createCount() {
        synchronized (this) {
            int n10 = this.createCount;
            return n10;
        }
    }

    public void entryRemoved(boolean bl2, Object object, Object object2, Object object3) {
    }

    public final void evictAll() {
        this.trimToSize(-1);
    }

    public final int evictionCount() {
        synchronized (this) {
            int n10 = this.evictionCount;
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final Object get(Object object) {
        int n10;
        int n11;
        Object object2 = "key == null";
        Objects.requireNonNull(object, (String)object2);
        // MONITORENTER : this
        object2 = this.map;
        object2 = ((LinkedHashMap)object2).get(object);
        if (object2 != null) {
            int n12;
            this.hitCount = n12 = this.hitCount + 1;
            // MONITOREXIT : this
            return object2;
        }
        this.missCount = n11 = this.missCount + 1;
        // MONITOREXIT : this
        object2 = this.create(object);
        if (object2 == null) {
            return null;
        }
        // MONITORENTER : this
        this.createCount = n10 = this.createCount + 1;
        Object object3 = this.map;
        object3 = ((HashMap)object3).put(object, object2);
        if (object3 != null) {
            LinkedHashMap linkedHashMap = this.map;
            linkedHashMap.put(object, object3);
        } else {
            int n13 = this.size;
            int n14 = this.safeSizeOf(object, object2);
            this.size = n13 += n14;
        }
        // MONITOREXIT : this
        if (object3 != null) {
            this.entryRemoved(false, object, object2, object3);
            return object3;
        }
        int n15 = this.maxSize;
        this.trimToSize(n15);
        return object2;
    }

    public final int hitCount() {
        synchronized (this) {
            int n10 = this.hitCount;
            return n10;
        }
    }

    public final int maxSize() {
        synchronized (this) {
            int n10 = this.maxSize;
            return n10;
        }
    }

    public final int missCount() {
        synchronized (this) {
            int n10 = this.missCount;
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final Object put(Object object, Object object2) {
        if (object != null && object2 != null) {
            int n10;
            // MONITORENTER : this
            this.putCount = n10 = this.putCount + 1;
            n10 = this.size;
            int n11 = this.safeSizeOf(object, object2);
            this.size = n10 += n11;
            Object object3 = this.map;
            object3 = ((HashMap)object3).put(object, object2);
            if (object3 != null) {
                n11 = this.size;
                int n12 = this.safeSizeOf(object, object3);
                this.size = n11 -= n12;
            }
            // MONITOREXIT : this
            if (object3 != null) {
                n11 = 0;
                this.entryRemoved(false, object, object3, object2);
            }
            int n13 = this.maxSize;
            this.trimToSize(n13);
            return object3;
        }
        object = new NullPointerException("key == null || value == null");
        throw object;
    }

    public final int putCount() {
        synchronized (this) {
            int n10 = this.putCount;
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final Object remove(Object object) {
        int n10;
        int n11;
        Object object2 = "key == null";
        Objects.requireNonNull(object, (String)object2);
        // MONITORENTER : this
        object2 = this.map;
        object2 = ((HashMap)object2).remove(object);
        if (object2 != null) {
            n11 = this.size;
            n10 = this.safeSizeOf(object, object2);
            this.size = n11 -= n10;
        }
        // MONITOREXIT : this
        if (object2 == null) return object2;
        n11 = 0;
        n10 = 0;
        this.entryRemoved(false, object, object2, null);
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void resize(int n10) {
        if (n10 > 0) {
            synchronized (this) {
                this.maxSize = n10;
            }
            this.trimToSize(n10);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("maxSize <= 0");
        throw illegalArgumentException;
    }

    public final int size() {
        synchronized (this) {
            int n10 = this.size;
            return n10;
        }
    }

    public int sizeOf(Object object, Object object2) {
        return 1;
    }

    public final Map snapshot() {
        synchronized (this) {
            LinkedHashMap linkedHashMap = this.map;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
            return linkedHashMap2;
        }
    }

    public final String toString() {
        synchronized (this) {
            int n10;
            int n11;
            block20: {
                n11 = this.hitCount;
                int n12 = this.missCount + n11;
                n10 = 0;
                if (n12 == 0) break block20;
                n11 *= 100;
                n11 /= n12;
            }
            n11 = 0;
            Object object = null;
            Locale locale = Locale.US;
            String string2 = "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]";
            int n13 = 4;
            Object[] objectArray = new Object[n13];
            int n14 = this.maxSize;
            Integer n15 = n14;
            objectArray[0] = n15;
            n10 = 1;
            n14 = this.hitCount;
            n15 = n14;
            objectArray[n10] = n15;
            n10 = 2;
            n14 = this.missCount;
            n15 = n14;
            objectArray[n10] = n15;
            n10 = 3;
            objectArray[n10] = object = Integer.valueOf(n11);
            object = String.format(locale, string2, objectArray);
            return object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void trimToSize(int n10) {
        Object object;
        Object object2;
        while (true) {
            int n11;
            int n12;
            LinkedHashMap linkedHashMap;
            synchronized (this) {
                int n13 = this.size;
                if (n13 < 0 || (n13 = (int)(((HashMap)(object2 = this.map)).isEmpty() ? 1 : 0)) != 0 && (n13 = this.size) != 0) break block5;
                n13 = this.size;
                if (n13 <= n10 || (n13 = (int)(((HashMap)(object2 = this.map)).isEmpty() ? 1 : 0)) != 0) break;
                object2 = this.map;
                object2 = ((LinkedHashMap)object2).entrySet();
                object2 = object2.iterator();
                object2 = object2.next();
                object2 = (Map.Entry)object2;
                object = object2.getKey();
                object2 = object2.getValue();
                linkedHashMap = this.map;
                linkedHashMap.remove(object);
                n12 = this.size;
                n11 = this.safeSizeOf(object, object2);
                this.size = n12 -= n11;
                n12 = this.evictionCount;
                n11 = 1;
                this.evictionCount = n12 += n11;
            }
            n12 = 0;
            linkedHashMap = null;
            this.entryRemoved(n11 != 0, object, object2, null);
        }
        {
            block5: {
                return;
            }
            object2 = new StringBuilder();
            object = this.getClass();
            object = ((Class)object).getName();
            ((StringBuilder)object2).append((String)object);
            object = ".sizeOf() is reporting inconsistent results!";
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object2);
            throw illegalStateException;
        }
    }
}

