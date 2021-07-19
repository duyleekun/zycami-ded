/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatDrawableManager$1;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.VectorEnabledTintResources;

public final class AppCompatDrawableManager {
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    private static AppCompatDrawableManager INSTANCE;
    private static final String TAG = "AppCompatDrawableManag";
    private ResourceManagerInternal mResourceManager;

    public static /* synthetic */ PorterDuff.Mode access$000() {
        return DEFAULT_MODE;
    }

    public static AppCompatDrawableManager get() {
        Class<AppCompatDrawableManager> clazz = AppCompatDrawableManager.class;
        synchronized (clazz) {
            AppCompatDrawableManager appCompatDrawableManager = INSTANCE;
            if (appCompatDrawableManager == null) {
                AppCompatDrawableManager.preload();
            }
            appCompatDrawableManager = INSTANCE;
            return appCompatDrawableManager;
        }
    }

    public static PorterDuffColorFilter getPorterDuffColorFilter(int n10, PorterDuff.Mode mode) {
        Class<AppCompatDrawableManager> clazz = AppCompatDrawableManager.class;
        synchronized (clazz) {
            PorterDuffColorFilter porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(n10, mode);
            return porterDuffColorFilter;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void preload() {
        Class<AppCompatDrawableManager> clazz = AppCompatDrawableManager.class;
        synchronized (clazz) {
            Object object = INSTANCE;
            if (object == null) {
                object = new AppCompatDrawableManager();
                INSTANCE = object;
                Object object2 = ResourceManagerInternal.get();
                ((AppCompatDrawableManager)object).mResourceManager = object2;
                object = INSTANCE;
                object = ((AppCompatDrawableManager)object).mResourceManager;
                object2 = new AppCompatDrawableManager$1();
                ((ResourceManagerInternal)object).setHooks((ResourceManagerInternal$ResourceManagerHooks)object2);
            }
            return;
        }
    }

    public static void tintDrawable(Drawable drawable2, TintInfo tintInfo, int[] nArray) {
        ResourceManagerInternal.tintDrawable(drawable2, tintInfo, nArray);
    }

    public Drawable getDrawable(Context context, int n10) {
        synchronized (this) {
            ResourceManagerInternal resourceManagerInternal = this.mResourceManager;
            context = resourceManagerInternal.getDrawable(context, n10);
            return context;
        }
    }

    public Drawable getDrawable(Context context, int n10, boolean bl2) {
        synchronized (this) {
            ResourceManagerInternal resourceManagerInternal = this.mResourceManager;
            context = resourceManagerInternal.getDrawable(context, n10, bl2);
            return context;
        }
    }

    public ColorStateList getTintList(Context context, int n10) {
        synchronized (this) {
            ResourceManagerInternal resourceManagerInternal = this.mResourceManager;
            context = resourceManagerInternal.getTintList(context, n10);
            return context;
        }
    }

    public void onConfigurationChanged(Context context) {
        synchronized (this) {
            ResourceManagerInternal resourceManagerInternal = this.mResourceManager;
            resourceManagerInternal.onConfigurationChanged(context);
            return;
        }
    }

    public Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int n10) {
        synchronized (this) {
            ResourceManagerInternal resourceManagerInternal = this.mResourceManager;
            context = resourceManagerInternal.onDrawableLoadedFromResources(context, vectorEnabledTintResources, n10);
            return context;
        }
    }

    public boolean tintDrawableUsingColorFilter(Context context, int n10, Drawable drawable2) {
        return this.mResourceManager.tintDrawableUsingColorFilter(context, n10, drawable2);
    }
}

