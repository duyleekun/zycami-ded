/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;

public interface ResourceManagerInternal$ResourceManagerHooks {
    public Drawable createDrawableFor(ResourceManagerInternal var1, Context var2, int var3);

    public ColorStateList getTintListForDrawableRes(Context var1, int var2);

    public PorterDuff.Mode getTintModeForDrawableRes(int var1);

    public boolean tintDrawable(Context var1, int var2, Drawable var3);

    public boolean tintDrawableUsingColorFilter(Context var1, int var2, Drawable var3);
}

