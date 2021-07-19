/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Build$VERSION
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import androidx.appcompat.widget.TintResources;
import androidx.appcompat.widget.VectorEnabledTintResources;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper
extends ContextWrapper {
    private static final Object CACHE_LOCK;
    private static ArrayList sCache;
    private final Resources mResources;
    private final Resources.Theme mTheme;

    static {
        Object object;
        CACHE_LOCK = object = new Object();
    }

    private TintContextWrapper(Context context) {
        super(context);
        boolean bl2 = VectorEnabledTintResources.shouldBeUsed();
        if (bl2) {
            Resources resources = context.getResources();
            VectorEnabledTintResources vectorEnabledTintResources = new VectorEnabledTintResources((Context)this, resources);
            this.mResources = vectorEnabledTintResources;
            vectorEnabledTintResources = vectorEnabledTintResources.newTheme();
            this.mTheme = vectorEnabledTintResources;
            context = context.getTheme();
            vectorEnabledTintResources.setTo((Resources.Theme)context);
        } else {
            context = context.getResources();
            TintResources tintResources = new TintResources((Context)this, (Resources)context);
            this.mResources = tintResources;
            context = null;
            this.mTheme = null;
        }
    }

    private static boolean shouldWrap(Context context) {
        int n10;
        Resources resources;
        int n11 = context instanceof TintContextWrapper;
        boolean bl2 = false;
        if (n11 == 0 && (n11 = (resources = context.getResources()) instanceof TintResources) == 0 && (n10 = (context = context.getResources()) instanceof VectorEnabledTintResources) == 0 && ((n10 = Build.VERSION.SDK_INT) < (n11 = 21) || (n10 = (int)(VectorEnabledTintResources.shouldBeUsed() ? 1 : 0)) != 0)) {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Context wrap(Context object) {
        boolean bl2 = TintContextWrapper.shouldWrap((Context)object);
        if (!bl2) {
            return object;
        }
        Object object2 = CACHE_LOCK;
        synchronized (object2) {
            Object object3;
            ArrayList arrayList = sCache;
            if (arrayList == null) {
                arrayList = new ArrayList();
                sCache = arrayList;
            } else {
                int n10;
                for (n10 = arrayList.size() + -1; n10 >= 0; n10 += -1) {
                    object3 = sCache;
                    object3 = ((ArrayList)object3).get(n10);
                    if ((object3 = (WeakReference)object3) != null && (object3 = ((Reference)object3).get()) != null) continue;
                    object3 = sCache;
                    ((ArrayList)object3).remove(n10);
                }
                arrayList = sCache;
                for (n10 = arrayList.size() + -1; n10 >= 0; n10 += -1) {
                    Context context;
                    object3 = sCache;
                    object3 = ((ArrayList)object3).get(n10);
                    if ((object3 = (WeakReference)object3) != null) {
                        object3 = ((Reference)object3).get();
                        object3 = (TintContextWrapper)((Object)object3);
                    } else {
                        object3 = null;
                    }
                    if (object3 == null || (context = object3.getBaseContext()) != object) continue;
                    return object3;
                }
            }
            arrayList = new TintContextWrapper((Context)object);
            object = sCache;
            object3 = new WeakReference(arrayList);
            ((ArrayList)object).add(object3);
            return arrayList;
        }
    }

    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }

    public Resources getResources() {
        return this.mResources;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.mTheme;
        if (theme == null) {
            theme = super.getTheme();
        }
        return theme;
    }

    public void setTheme(int n10) {
        Resources.Theme theme = this.mTheme;
        if (theme == null) {
            super.setTheme(n10);
        } else {
            boolean bl2 = true;
            theme.applyStyle(n10, bl2);
        }
    }
}

