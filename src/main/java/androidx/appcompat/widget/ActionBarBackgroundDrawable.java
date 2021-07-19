/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.drawable.Drawable
 */
package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

public class ActionBarBackgroundDrawable
extends Drawable {
    public final ActionBarContainer mContainer;

    public ActionBarBackgroundDrawable(ActionBarContainer actionBarContainer) {
        this.mContainer = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.mContainer;
        boolean bl2 = actionBarContainer.mIsSplit;
        if (bl2) {
            actionBarContainer = actionBarContainer.mSplitBackground;
            if (actionBarContainer != null) {
                actionBarContainer.draw(canvas);
            }
        } else {
            boolean bl3;
            actionBarContainer = actionBarContainer.mBackground;
            if (actionBarContainer != null) {
                actionBarContainer.draw(canvas);
            }
            actionBarContainer = this.mContainer;
            Drawable drawable2 = actionBarContainer.mStackedBackground;
            if (drawable2 != null && (bl3 = actionBarContainer.mIsStacked)) {
                drawable2.draw(canvas);
            }
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.mContainer;
        boolean bl2 = actionBarContainer.mIsSplit;
        if (bl2) {
            actionBarContainer = actionBarContainer.mSplitBackground;
            if (actionBarContainer != null) {
                actionBarContainer.getOutline(outline);
            }
        } else {
            actionBarContainer = actionBarContainer.mBackground;
            if (actionBarContainer != null) {
                actionBarContainer.getOutline(outline);
            }
        }
    }

    public void setAlpha(int n10) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}

