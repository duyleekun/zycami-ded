/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.SparseArray
 *  android.view.View
 */
package androidx.databinding.adapters;

import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class ListenerUtil {
    private static final SparseArray sListeners;

    static {
        SparseArray sparseArray;
        sListeners = sparseArray = new SparseArray();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object getListener(View object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 14;
        if (n11 >= n12) {
            return object.getTag(n10);
        }
        SparseArray sparseArray = sListeners;
        synchronized (sparseArray) {
            Object object2 = sparseArray.get(n10);
            object2 = (WeakHashMap)object2;
            n12 = 0;
            if (object2 == null) {
                return null;
            }
            object = ((WeakHashMap)object2).get(object);
            if ((object = (WeakReference)object) != null) return object.get();
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Object trackListener(View object, Object object2, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 14;
        if (n11 >= n12) {
            Object object3 = object.getTag(n10);
            object.setTag(n10, object2);
            return object3;
        }
        SparseArray sparseArray = sListeners;
        synchronized (sparseArray) {
            WeakHashMap<View, WeakReference<Object>> weakHashMap = sparseArray.get(n10);
            weakHashMap = weakHashMap;
            if (weakHashMap == null) {
                weakHashMap = new WeakHashMap<View, WeakReference<Object>>();
                sparseArray.put(n10, weakHashMap);
            }
            if (object2 == null) {
                object = weakHashMap.remove(object);
                object = (WeakReference)object;
            } else {
                WeakReference<Object> weakReference = new WeakReference<Object>(object2);
                object = weakHashMap.put((View)object, weakReference);
                object = (WeakReference)object;
            }
            if (object != null) return object.get();
            return null;
        }
    }
}

