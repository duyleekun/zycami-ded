/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewOverlay
 */
package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;
import androidx.transition.ViewOverlayImpl;

public class ViewOverlayApi18
implements ViewOverlayImpl {
    private final ViewOverlay mViewOverlay;

    public ViewOverlayApi18(View view) {
        view = view.getOverlay();
        this.mViewOverlay = view;
    }

    public void add(Drawable drawable2) {
        this.mViewOverlay.add(drawable2);
    }

    public void remove(Drawable drawable2) {
        this.mViewOverlay.remove(drawable2);
    }
}

