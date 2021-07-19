/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class ViewModel {
    private final Map mBagOfTags;
    private volatile boolean mCleared;

    public ViewModel() {
        HashMap hashMap;
        this.mBagOfTags = hashMap = new HashMap();
        this.mCleared = false;
    }

    private static void closeWithRuntimeException(Object object) {
        boolean bl2 = object instanceof Closeable;
        if (bl2) {
            try {
                object = (Closeable)object;
            }
            catch (IOException iOException) {
                RuntimeException runtimeException = new RuntimeException(iOException);
                throw runtimeException;
            }
            object.close();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void clear() {
        boolean bl2;
        this.mCleared = bl2 = true;
        Map map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                boolean bl3;
                Iterator iterator2 = this.mBagOfTags;
                iterator2 = iterator2.values();
                iterator2 = iterator2.iterator();
                while (bl3 = iterator2.hasNext()) {
                    Object e10 = iterator2.next();
                    ViewModel.closeWithRuntimeException(e10);
                }
            }
        }
        this.onCleared();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getTag(String string2) {
        Map map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            Map map2 = this.mBagOfTags;
            return map2.get(string2);
        }
    }

    public void onCleared() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public Object setTagIfAbsent(String string2, Object object) {
        Map map = this.mBagOfTags;
        // MONITORENTER : map
        Map map2 = this.mBagOfTags;
        map2 = map2.get(string2);
        if (map2 == null) {
            Map map3 = this.mBagOfTags;
            map3.put(string2, object);
        }
        // MONITOREXIT : map
        if (map2 != null) {
            object = map2;
        }
        boolean bl2 = this.mCleared;
        if (!bl2) return object;
        ViewModel.closeWithRuntimeException(object);
        return object;
    }
}

