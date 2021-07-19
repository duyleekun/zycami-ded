/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.graphics.drawable.WrappedDrawableApi14;
import androidx.core.graphics.drawable.WrappedDrawableApi21;

public final class WrappedDrawableState
extends Drawable.ConstantState {
    public int mChangingConfigurations;
    public Drawable.ConstantState mDrawableState;
    public ColorStateList mTint;
    public PorterDuff.Mode mTintMode;

    public WrappedDrawableState(WrappedDrawableState wrappedDrawableState) {
        PorterDuff.Mode mode;
        int n10 = 0;
        this.mTint = null;
        this.mTintMode = mode = WrappedDrawableApi14.DEFAULT_TINT_MODE;
        if (wrappedDrawableState != null) {
            this.mChangingConfigurations = n10 = wrappedDrawableState.mChangingConfigurations;
            mode = wrappedDrawableState.mDrawableState;
            this.mDrawableState = mode;
            mode = wrappedDrawableState.mTint;
            this.mTint = mode;
            wrappedDrawableState = wrappedDrawableState.mTintMode;
            this.mTintMode = wrappedDrawableState;
        }
    }

    public boolean canConstantState() {
        boolean bl2;
        Drawable.ConstantState constantState = this.mDrawableState;
        if (constantState != null) {
            bl2 = true;
        } else {
            bl2 = false;
            constantState = null;
        }
        return bl2;
    }

    public int getChangingConfigurations() {
        int n10;
        int n11 = this.mChangingConfigurations;
        Drawable.ConstantState constantState = this.mDrawableState;
        if (constantState != null) {
            n10 = constantState.getChangingConfigurations();
        } else {
            n10 = 0;
            constantState = null;
        }
        return n11 | n10;
    }

    public Drawable newDrawable() {
        return this.newDrawable(null);
    }

    public Drawable newDrawable(Resources resources) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            WrappedDrawableApi21 wrappedDrawableApi21 = new WrappedDrawableApi21(this, resources);
            return wrappedDrawableApi21;
        }
        WrappedDrawableApi14 wrappedDrawableApi14 = new WrappedDrawableApi14(this, resources);
        return wrappedDrawableApi14;
    }
}

