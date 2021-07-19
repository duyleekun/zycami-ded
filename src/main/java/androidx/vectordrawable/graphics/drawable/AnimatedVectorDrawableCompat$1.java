/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 */
package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

public class AnimatedVectorDrawableCompat$1
implements Drawable.Callback {
    public final /* synthetic */ AnimatedVectorDrawableCompat this$0;

    public AnimatedVectorDrawableCompat$1(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.this$0 = animatedVectorDrawableCompat;
    }

    public void invalidateDrawable(Drawable drawable2) {
        this.this$0.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l10) {
        this.this$0.scheduleSelf(runnable, l10);
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        this.this$0.unscheduleSelf(runnable);
    }
}

