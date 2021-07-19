/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.TypedValue
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources$ColorStateListCacheEntry;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class AppCompatResources {
    private static final String LOG_TAG = "AppCompatResources";
    private static final ThreadLocal TL_TYPED_VALUE;
    private static final Object sColorStateCacheLock;
    private static final WeakHashMap sColorStateCaches;

    static {
        Object object = new ThreadLocal();
        TL_TYPED_VALUE = object;
        object = new WeakHashMap(0);
        sColorStateCaches = object;
        sColorStateCacheLock = object = new Object();
    }

    private AppCompatResources() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void addColorStateListToCache(Context context, int n10, ColorStateList colorStateList) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            Object object2 = sColorStateCaches;
            Object object3 = ((WeakHashMap)object2).get(context);
            object3 = (SparseArray)object3;
            if (object3 == null) {
                object3 = new Object();
                ((WeakHashMap)object2).put(context, object3);
            }
            context = context.getResources();
            context = context.getConfiguration();
            object2 = new AppCompatResources$ColorStateListCacheEntry(colorStateList, (Configuration)context);
            object3.append(n10, object2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ColorStateList getCachedColorStateList(Context context, int n10) {
        Object object = sColorStateCacheLock;
        synchronized (object) {
            WeakHashMap weakHashMap = sColorStateCaches;
            weakHashMap = weakHashMap.get(context);
            weakHashMap = (SparseArray)weakHashMap;
            if (weakHashMap == null) return null;
            int n11 = weakHashMap.size();
            if (n11 <= 0) return null;
            Object object2 = weakHashMap.get(n10);
            if ((object2 = (AppCompatResources$ColorStateListCacheEntry)object2) == null) return null;
            Configuration configuration = ((AppCompatResources$ColorStateListCacheEntry)object2).configuration;
            context = context.getResources();
            boolean bl2 = configuration.equals((Configuration)(context = context.getConfiguration()));
            if (bl2) {
                return ((AppCompatResources$ColorStateListCacheEntry)object2).value;
            }
            weakHashMap.remove(n10);
            return null;
        }
    }

    public static ColorStateList getColorStateList(Context context, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return context.getColorStateList(n10);
        }
        ColorStateList colorStateList = AppCompatResources.getCachedColorStateList(context, n10);
        if (colorStateList != null) {
            return colorStateList;
        }
        colorStateList = AppCompatResources.inflateColorStateList(context, n10);
        if (colorStateList != null) {
            AppCompatResources.addColorStateListToCache(context, n10, colorStateList);
            return colorStateList;
        }
        return ContextCompat.getColorStateList(context, n10);
    }

    public static Drawable getDrawable(Context context, int n10) {
        return ResourceManagerInternal.get().getDrawable(context, n10);
    }

    private static TypedValue getTypedValue() {
        ThreadLocal threadLocal = TL_TYPED_VALUE;
        TypedValue typedValue = (TypedValue)threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        return typedValue;
    }

    private static ColorStateList inflateColorStateList(Context context, int n10) {
        boolean bl2 = AppCompatResources.isColorInt(context, n10);
        if (bl2) {
            return null;
        }
        Resources resources = context.getResources();
        XmlResourceParser xmlResourceParser = resources.getXml(n10);
        try {
            context = context.getTheme();
        }
        catch (Exception exception) {
            Log.e((String)LOG_TAG, (String)"Failed to inflate ColorStateList, leaving it to the framework", (Throwable)exception);
            return null;
        }
        return ColorStateListInflaterCompat.createFromXml(resources, (XmlPullParser)xmlResourceParser, (Resources.Theme)context);
    }

    private static boolean isColorInt(Context context, int n10) {
        context = context.getResources();
        TypedValue typedValue = AppCompatResources.getTypedValue();
        boolean bl2 = true;
        context.getValue(n10, typedValue, bl2);
        int n11 = typedValue.type;
        n10 = 28;
        if (n11 < n10 || n11 > (n10 = 31)) {
            bl2 = false;
        }
        return bl2;
    }
}

