/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.LongSparseArray
 */
package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

public class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    private ResourcesFlusher() {
    }

    public static void flush(Resources resources) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return;
        }
        n11 = 24;
        if (n10 >= n11) {
            ResourcesFlusher.flushNougats(resources);
        } else {
            n11 = 23;
            if (n10 >= n11) {
                ResourcesFlusher.flushMarshmallows(resources);
            } else {
                n11 = 21;
                if (n10 >= n11) {
                    ResourcesFlusher.flushLollipops(resources);
                }
            }
        }
    }

    private static void flushLollipops(Resources object) {
        Object object2;
        Object object3;
        boolean bl2 = sDrawableCacheFieldFetched;
        String string2 = TAG;
        if (!bl2) {
            bl2 = true;
            object3 = Resources.class;
            String string3 = "mDrawableCache";
            object3 = ((Class)object3).getDeclaredField(string3);
            sDrawableCacheField = object3;
            try {
                ((Field)object3).setAccessible(bl2);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                string3 = "Could not retrieve Resources#mDrawableCache field";
                Log.e((String)string2, (String)string3, (Throwable)noSuchFieldException);
            }
            sDrawableCacheFieldFetched = bl2;
        }
        if ((object2 = sDrawableCacheField) != null) {
            object3 = null;
            object = ((Field)object2).get(object);
            try {
                object = (Map)object;
                object3 = object;
            }
            catch (IllegalAccessException illegalAccessException) {
                object2 = "Could not retrieve value from Resources#mDrawableCache";
                Log.e((String)string2, (String)object2, (Throwable)illegalAccessException);
            }
            if (object3 != null) {
                object3.clear();
            }
        }
    }

    private static void flushMarshmallows(Resources resources) {
        Object object;
        boolean bl2 = sDrawableCacheFieldFetched;
        String string2 = TAG;
        if (!bl2) {
            bl2 = true;
            object = Resources.class;
            String string3 = "mDrawableCache";
            object = ((Class)object).getDeclaredField(string3);
            sDrawableCacheField = object;
            try {
                ((Field)object).setAccessible(bl2);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                string3 = "Could not retrieve Resources#mDrawableCache field";
                Log.e((String)string2, (String)string3, (Throwable)noSuchFieldException);
            }
            sDrawableCacheFieldFetched = bl2;
        }
        bl2 = false;
        Object object2 = null;
        object = sDrawableCacheField;
        if (object != null) {
            try {
                object2 = ((Field)object).get(resources);
            }
            catch (IllegalAccessException illegalAccessException) {
                object = "Could not retrieve value from Resources#mDrawableCache";
                Log.e((String)string2, (String)object, (Throwable)illegalAccessException);
            }
        }
        if (object2 == null) {
            return;
        }
        ResourcesFlusher.flushThemedResourcesCache(object2);
    }

    private static void flushNougats(Resources object) {
        Object object2;
        Object object3;
        boolean bl2 = sResourcesImplFieldFetched;
        boolean bl3 = true;
        String string2 = TAG;
        if (!bl2) {
            object3 = Resources.class;
            object2 = "mResourcesImpl";
            object3 = ((Class)object3).getDeclaredField((String)object2);
            sResourcesImplField = object3;
            try {
                ((Field)object3).setAccessible(bl3);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                object2 = "Could not retrieve Resources#mResourcesImpl field";
                Log.e((String)string2, (String)object2, (Throwable)noSuchFieldException);
            }
            sResourcesImplFieldFetched = bl3;
        }
        if ((object3 = sResourcesImplField) == null) {
            return;
        }
        object2 = null;
        try {
            object = ((Field)object3).get(object);
        }
        catch (IllegalAccessException illegalAccessException) {
            object3 = "Could not retrieve value from Resources#mResourcesImpl";
            Log.e((String)string2, (String)object3, (Throwable)illegalAccessException);
            object = null;
        }
        if (object == null) {
            return;
        }
        bl2 = sDrawableCacheFieldFetched;
        if (!bl2) {
            object3 = object.getClass();
            String string3 = "mDrawableCache";
            object3 = ((Class)object3).getDeclaredField(string3);
            sDrawableCacheField = object3;
            try {
                ((Field)object3).setAccessible(bl3);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                string3 = "Could not retrieve ResourcesImpl#mDrawableCache field";
                Log.e((String)string2, (String)string3, (Throwable)noSuchFieldException);
            }
            sDrawableCacheFieldFetched = bl3;
        }
        if ((object3 = sDrawableCacheField) != null) {
            try {
                object2 = ((Field)object3).get(object);
            }
            catch (IllegalAccessException illegalAccessException) {
                object3 = "Could not retrieve value from ResourcesImpl#mDrawableCache";
                Log.e((String)string2, (String)object3, (Throwable)illegalAccessException);
            }
        }
        if (object2 != null) {
            ResourcesFlusher.flushThemedResourcesCache(object2);
        }
    }

    private static void flushThemedResourcesCache(Object object) {
        String string2;
        Object object2;
        boolean bl2 = sThemedResourceCacheClazzFetched;
        boolean bl3 = true;
        String string3 = TAG;
        if (!bl2) {
            object2 = "android.content.res.ThemedResourceCache";
            object2 = Class.forName((String)object2);
            try {
                sThemedResourceCacheClazz = object2;
            }
            catch (ClassNotFoundException classNotFoundException) {
                string2 = "Could not find ThemedResourceCache class";
                Log.e((String)string3, (String)string2, (Throwable)classNotFoundException);
            }
            sThemedResourceCacheClazzFetched = bl3;
        }
        if ((object2 = sThemedResourceCacheClazz) == null) {
            return;
        }
        boolean bl4 = sThemedResourceCache_mUnthemedEntriesFieldFetched;
        if (!bl4) {
            string2 = "mUnthemedEntries";
            object2 = ((Class)object2).getDeclaredField(string2);
            sThemedResourceCache_mUnthemedEntriesField = object2;
            try {
                ((Field)object2).setAccessible(bl3);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                string2 = "Could not retrieve ThemedResourceCache#mUnthemedEntries field";
                Log.e((String)string3, (String)string2, (Throwable)noSuchFieldException);
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = bl3;
        }
        if ((object2 = sThemedResourceCache_mUnthemedEntriesField) == null) {
            return;
        }
        bl3 = false;
        Object object3 = null;
        object = ((Field)object2).get(object);
        try {
            object3 = object = (LongSparseArray)object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = "Could not retrieve value from ThemedResourceCache#mUnthemedEntries";
            Log.e((String)string3, (String)object2, (Throwable)illegalAccessException);
        }
        if (object3 != null) {
            object3.clear();
        }
    }
}

