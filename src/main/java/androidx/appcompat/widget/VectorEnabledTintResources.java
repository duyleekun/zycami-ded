/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import androidx.appcompat.widget.ResourceManagerInternal;
import java.lang.ref.WeakReference;

public class VectorEnabledTintResources
extends Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private static boolean sCompatVectorFromResourcesEnabled = false;
    private final WeakReference mContextRef;

    public VectorEnabledTintResources(Context context, Resources object) {
        AssetManager assetManager = object.getAssets();
        DisplayMetrics displayMetrics = object.getDisplayMetrics();
        object = object.getConfiguration();
        super(assetManager, displayMetrics, (Configuration)object);
        super(context);
        this.mContextRef = object;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return sCompatVectorFromResourcesEnabled;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean bl2) {
        sCompatVectorFromResourcesEnabled = bl2;
    }

    public static boolean shouldBeUsed() {
        int n10;
        int n11 = VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
        n11 = n11 != 0 && (n11 = Build.VERSION.SDK_INT) <= (n10 = 20) ? 1 : 0;
        return n11 != 0;
    }

    public Drawable getDrawable(int n10) {
        Context context = (Context)this.mContextRef.get();
        if (context != null) {
            return ResourceManagerInternal.get().onDrawableLoadedFromResources(context, this, n10);
        }
        return super.getDrawable(n10);
    }

    public final Drawable superGetDrawable(int n10) {
        return super.getDrawable(n10);
    }
}

