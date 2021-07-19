/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

import com.mob.tools.MobLog;
import com.mob.tools.gui.CachePool$Node;
import com.mob.tools.gui.CachePool$OnRemoveListener;
import com.mob.tools.log.NLog;
import java.util.AbstractSequentialList;
import java.util.LinkedList;

public class CachePool {
    private int capacity;
    private CachePool$OnRemoveListener listener;
    private LinkedList pool;
    private int poolSize;

    public CachePool(int n10) {
        LinkedList linkedList;
        this.capacity = n10;
        this.pool = linkedList = new LinkedList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        synchronized (this) {
            int n10;
            Object object = this.pool;
            if (object != null && (n10 = this.capacity) > 0) {
                int n11;
                CachePool$OnRemoveListener cachePool$OnRemoveListener = this.listener;
                if (cachePool$OnRemoveListener == null) {
                    ((LinkedList)object).clear();
                } else {
                    while ((n11 = ((LinkedList)(object = this.pool)).size()) > 0) {
                        object = this.pool;
                        object = ((LinkedList)object).removeLast();
                        if ((object = (CachePool$Node)object) == null) continue;
                        n10 = this.poolSize;
                        int n12 = CachePool$Node.access$200((CachePool$Node)object);
                        this.poolSize = n10 -= n12;
                        cachePool$OnRemoveListener = this.listener;
                        if (cachePool$OnRemoveListener == null) continue;
                        Object object2 = ((CachePool$Node)object).key;
                        object = ((CachePool$Node)object).value;
                        cachePool$OnRemoveListener.onRemove(object2, object);
                    }
                }
                n11 = 0;
                object = null;
                this.poolSize = 0;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get(Object object) {
        synchronized (this) {
            Object object2 = this.pool;
            if (object2 == null) return null;
            int n10 = this.capacity;
            if (n10 <= 0) return null;
            try {
                Object object3;
                Object object4;
                int n11;
                int n12;
                while ((n10 = this.poolSize) > (n12 = this.capacity)) {
                    object2 = this.pool;
                    object2 = ((LinkedList)object2).removeLast();
                    if ((object2 = (CachePool$Node)object2) == null) continue;
                    n12 = this.poolSize;
                    n11 = CachePool$Node.access$200((CachePool$Node)object2);
                    this.poolSize = n12 -= n11;
                    object4 = this.listener;
                    if (object4 == null) continue;
                    object3 = ((CachePool$Node)object2).key;
                    object2 = ((CachePool$Node)object2).value;
                    object4.onRemove(object3, object2);
                }
                object2 = this.pool;
                object2 = ((AbstractSequentialList)object2).iterator();
                do {
                    if ((n12 = (int)(object2.hasNext() ? 1 : 0)) == 0) return null;
                    object4 = object2.next();
                } while ((object4 = (CachePool$Node)object4) == null || (object != null || (object3 = ((CachePool$Node)object4).key) != null) && (object == null || (n11 = (int)(object.equals(object3 = ((CachePool$Node)object4).key) ? 1 : 0)) == 0));
                if (object4 == null) return null;
                object = this.pool;
                n10 = 0;
                object2 = null;
                ((LinkedList)object).set(0, object4);
                long l10 = System.currentTimeMillis();
                CachePool$Node.access$102(object4, l10);
                return ((CachePool$Node)object4).value;
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).w(throwable);
            }
            return null;
        }
    }

    public boolean put(Object object, Object object2) {
        synchronized (this) {
            int n10 = 1;
            boolean bl2 = this.put(object, object2, n10);
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean put(Object object, Object object2, int n10) {
        synchronized (this) {
            int n11;
            Object object3 = this.pool;
            if (object3 != null && (n11 = this.capacity) > 0) {
                Object object4;
                try {
                    int n12;
                    int n13;
                    int n14;
                    object3 = new CachePool$Node(this, null);
                    ((CachePool$Node)object3).key = object;
                    ((CachePool$Node)object3).value = object4;
                    long l10 = System.currentTimeMillis();
                    CachePool$Node.access$102((CachePool$Node)object3, l10);
                    CachePool$Node.access$202((CachePool$Node)object3, n14);
                    object = this.pool;
                    ((LinkedList)object).add(0, object3);
                    this.poolSize = n13 = this.poolSize + n14;
                    while ((n13 = this.poolSize) > (n12 = this.capacity)) {
                        object = this.pool;
                        object = ((LinkedList)object).removeLast();
                        if ((object = (CachePool$Node)object) == null) continue;
                        n12 = this.poolSize;
                        n14 = CachePool$Node.access$200((CachePool$Node)object);
                        this.poolSize = n12 -= n14;
                        object4 = this.listener;
                        if (object4 == null) continue;
                        Object object5 = ((CachePool$Node)object).key;
                        object = ((CachePool$Node)object).value;
                        object4.onRemove(object5, object);
                    }
                    return true;
                }
                catch (Throwable throwable) {
                    object4 = MobLog.getInstance();
                    ((NLog)object4).w(throwable);
                }
            }
            return false;
        }
    }

    public void setOnRemoveListener(CachePool$OnRemoveListener cachePool$OnRemoveListener) {
        this.listener = cachePool$OnRemoveListener;
    }

    public int size() {
        synchronized (this) {
            int n10 = this.poolSize;
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void trimBeforeTime(long l10) {
        synchronized (this) {
            int n10;
            Object object = this.pool;
            if (object != null && (n10 = this.capacity) > 0) {
                int n11;
                int n12;
                int n13 = ((LinkedList)object).size() + -1;
                while (n13 >= 0) {
                    Object object2 = this.pool;
                    object2 = ((LinkedList)object2).get(n13);
                    long l11 = CachePool$Node.access$100((CachePool$Node)(object2 = (CachePool$Node)object2));
                    long l12 = l11 - l10;
                    n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                    if (n10 < 0) {
                        object2 = this.pool;
                        object2 = ((LinkedList)object2).remove(n13);
                        if ((object2 = (CachePool$Node)object2) == null) continue;
                        int n14 = this.poolSize;
                        int n15 = CachePool$Node.access$200((CachePool$Node)object2);
                        this.poolSize = n14 -= n15;
                        CachePool$OnRemoveListener cachePool$OnRemoveListener = this.listener;
                        if (cachePool$OnRemoveListener == null) continue;
                        Object object3 = ((CachePool$Node)object2).key;
                        object2 = ((CachePool$Node)object2).value;
                        cachePool$OnRemoveListener.onRemove(object3, object2);
                        continue;
                    }
                    n13 += -1;
                }
                while ((n12 = this.poolSize) > (n11 = this.capacity)) {
                    Object object4 = this.pool;
                    object4 = ((LinkedList)object4).removeLast();
                    if ((object4 = (CachePool$Node)object4) == null) continue;
                    n11 = this.poolSize;
                    n13 = CachePool$Node.access$200((CachePool$Node)object4);
                    this.poolSize = n11 -= n13;
                    CachePool$OnRemoveListener cachePool$OnRemoveListener = this.listener;
                    if (cachePool$OnRemoveListener == null) continue;
                    object = ((CachePool$Node)object4).key;
                    object4 = ((CachePool$Node)object4).value;
                    cachePool$OnRemoveListener.onRemove(object, object4);
                }
            }
            return;
        }
    }
}

