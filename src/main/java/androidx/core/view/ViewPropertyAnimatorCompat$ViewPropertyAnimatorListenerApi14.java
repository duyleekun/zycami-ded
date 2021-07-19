/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;

public class ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14
implements ViewPropertyAnimatorListener {
    public boolean mAnimEndCalled;
    public ViewPropertyAnimatorCompat mVpa;

    public ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        this.mVpa = viewPropertyAnimatorCompat;
    }

    public void onAnimationCancel(View view) {
        int n10 = 0x7E000000;
        Object object = view.getTag(n10);
        boolean bl2 = object instanceof ViewPropertyAnimatorListener;
        if (bl2) {
            object = (ViewPropertyAnimatorListener)object;
        } else {
            n10 = 0;
            object = null;
        }
        if (object != null) {
            object.onAnimationCancel(view);
        }
    }

    public void onAnimationEnd(View view) {
        Object object = this.mVpa;
        int n10 = ((ViewPropertyAnimatorCompat)object).mOldLayerType;
        int n11 = -1;
        Object object2 = null;
        if (n10 > n11) {
            view.setLayerType(n10, null);
            object = this.mVpa;
            ((ViewPropertyAnimatorCompat)object).mOldLayerType = n11;
        }
        if ((n10 = Build.VERSION.SDK_INT) >= (n11 = 16) || (n10 = (int)(this.mAnimEndCalled ? 1 : 0)) == 0) {
            boolean bl2;
            object = this.mVpa;
            Runnable runnable = ((ViewPropertyAnimatorCompat)object).mEndAction;
            if (runnable != null) {
                ((ViewPropertyAnimatorCompat)object).mEndAction = null;
                runnable.run();
            }
            if ((n11 = (object = view.getTag(n10 = 0x7E000000)) instanceof ViewPropertyAnimatorListener) != 0) {
                object2 = object;
                object2 = (ViewPropertyAnimatorListener)object;
            }
            if (object2 != null) {
                object2.onAnimationEnd(view);
            }
            this.mAnimEndCalled = bl2 = true;
        }
    }

    public void onAnimationStart(View view) {
        this.mAnimEndCalled = false;
        Object object = this.mVpa;
        int n10 = ((ViewPropertyAnimatorCompat)object).mOldLayerType;
        Object object2 = null;
        int n11 = -1;
        if (n10 > n11) {
            n10 = 2;
            view.setLayerType(n10, null);
        }
        object = this.mVpa;
        Runnable runnable = ((ViewPropertyAnimatorCompat)object).mStartAction;
        if (runnable != null) {
            ((ViewPropertyAnimatorCompat)object).mStartAction = null;
            runnable.run();
        }
        if ((n11 = (object = view.getTag(n10 = 0x7E000000)) instanceof ViewPropertyAnimatorListener) != 0) {
            object2 = object;
            object2 = (ViewPropertyAnimatorListener)object;
        }
        if (object2 != null) {
            object2.onAnimationStart(view);
        }
    }
}

