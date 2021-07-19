/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ResourcesWrapper;
import java.lang.ref.WeakReference;

public class TintResources
extends ResourcesWrapper {
    private final WeakReference mContextRef;

    public TintResources(Context context, Resources object) {
        super((Resources)object);
        super(context);
        this.mContextRef = object;
    }

    public Drawable getDrawable(int n10) {
        Drawable drawable2 = super.getDrawable(n10);
        Context context = (Context)this.mContextRef.get();
        if (drawable2 != null && context != null) {
            ResourceManagerInternal resourceManagerInternal = ResourceManagerInternal.get();
            resourceManagerInternal.tintDrawableUsingColorFilter(context, n10, drawable2);
        }
        return drawable2;
    }
}

