/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package androidx.transition;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.transition.ViewGroupOverlayApi14;
import androidx.transition.ViewOverlayApi14$OverlayViewGroup;
import androidx.transition.ViewOverlayImpl;

public class ViewOverlayApi14
implements ViewOverlayImpl {
    public ViewOverlayApi14$OverlayViewGroup mOverlayViewGroup;

    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        ViewOverlayApi14$OverlayViewGroup viewOverlayApi14$OverlayViewGroup;
        this.mOverlayViewGroup = viewOverlayApi14$OverlayViewGroup = new ViewOverlayApi14$OverlayViewGroup(context, viewGroup, view, this);
    }

    public static ViewOverlayApi14 createFrom(View view) {
        ViewGroup viewGroup = ViewOverlayApi14.getContentView(view);
        if (viewGroup != null) {
            int n10 = viewGroup.getChildCount();
            Context context = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                View view2 = viewGroup.getChildAt(i10);
                boolean bl2 = view2 instanceof ViewOverlayApi14$OverlayViewGroup;
                if (!bl2) continue;
                return ((ViewOverlayApi14$OverlayViewGroup)view2).mViewOverlay;
            }
            context = viewGroup.getContext();
            ViewGroupOverlayApi14 viewGroupOverlayApi14 = new ViewGroupOverlayApi14(context, viewGroup, view);
            return viewGroupOverlayApi14;
        }
        return null;
    }

    public static ViewGroup getContentView(View view) {
        while (view != null) {
            int n10;
            int n11 = view.getId();
            if (n11 == (n10 = 0x1020002) && (n11 = view instanceof ViewGroup) != 0) {
                return (ViewGroup)view;
            }
            ViewParent viewParent = view.getParent();
            n11 = viewParent instanceof ViewGroup;
            if (n11 == 0) continue;
            view = (ViewGroup)view.getParent();
        }
        return null;
    }

    public void add(Drawable drawable2) {
        this.mOverlayViewGroup.add(drawable2);
    }

    public void remove(Drawable drawable2) {
        this.mOverlayViewGroup.remove(drawable2);
    }
}

