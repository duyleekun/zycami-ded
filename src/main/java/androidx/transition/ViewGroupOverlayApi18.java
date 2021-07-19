/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroupOverlay
 */
package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import androidx.transition.ViewGroupOverlayImpl;

public class ViewGroupOverlayApi18
implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay mViewGroupOverlay;

    public ViewGroupOverlayApi18(ViewGroup viewGroup) {
        viewGroup = viewGroup.getOverlay();
        this.mViewGroupOverlay = viewGroup;
    }

    public void add(Drawable drawable2) {
        this.mViewGroupOverlay.add(drawable2);
    }

    public void add(View view) {
        this.mViewGroupOverlay.add(view);
    }

    public void remove(Drawable drawable2) {
        this.mViewGroupOverlay.remove(drawable2);
    }

    public void remove(View view) {
        this.mViewGroupOverlay.remove(view);
    }
}

