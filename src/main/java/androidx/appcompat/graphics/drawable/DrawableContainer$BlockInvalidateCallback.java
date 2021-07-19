/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 */
package androidx.appcompat.graphics.drawable;

import android.graphics.drawable.Drawable;

public class DrawableContainer$BlockInvalidateCallback
implements Drawable.Callback {
    private Drawable.Callback mCallback;

    public void invalidateDrawable(Drawable drawable2) {
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l10) {
        Drawable.Callback callback = this.mCallback;
        if (callback != null) {
            callback.scheduleDrawable(drawable2, runnable, l10);
        }
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        Drawable.Callback callback = this.mCallback;
        if (callback != null) {
            callback.unscheduleDrawable(drawable2, runnable);
        }
    }

    public Drawable.Callback unwrap() {
        Drawable.Callback callback = this.mCallback;
        this.mCallback = null;
        return callback;
    }

    public DrawableContainer$BlockInvalidateCallback wrap(Drawable.Callback callback) {
        this.mCallback = callback;
        return this;
    }
}

