/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.Interpolator
 */
package androidx.core.view;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.os.Build;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat$1;
import androidx.core.view.ViewPropertyAnimatorCompat$2;
import androidx.core.view.ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    public static final int LISTENER_TAG_ID = 0x7E000000;
    public Runnable mEndAction = null;
    public int mOldLayerType = -1;
    public Runnable mStartAction = null;
    private WeakReference mView;

    public ViewPropertyAnimatorCompat(View view) {
        WeakReference<View> weakReference;
        this.mView = weakReference = new WeakReference<View>(view);
    }

    private void setListenerInternal(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (viewPropertyAnimatorListener != null) {
            ViewPropertyAnimator viewPropertyAnimator = view.animate();
            ViewPropertyAnimatorCompat$1 viewPropertyAnimatorCompat$1 = new ViewPropertyAnimatorCompat$1(this, viewPropertyAnimatorListener, view);
            viewPropertyAnimator.setListener((Animator.AnimatorListener)viewPropertyAnimatorCompat$1);
        } else {
            view = view.animate();
            viewPropertyAnimatorListener = null;
            view.setListener(null);
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.alpha(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.alphaBy(f10);
        }
        return this;
    }

    public void cancel() {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.cancel();
        }
    }

    public long getDuration() {
        View view = (View)this.mView.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    public Interpolator getInterpolator() {
        int n10;
        int n11;
        View view = (View)this.mView.get();
        if (view != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 18)) {
            return (Interpolator)view.animate().getInterpolator();
        }
        return null;
    }

    public long getStartDelay() {
        View view = (View)this.mView.get();
        if (view != null) {
            return view.animate().getStartDelay();
        }
        return 0L;
    }

    public ViewPropertyAnimatorCompat rotation(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.rotation(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.rotationBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.rotationX(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.rotationXBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.rotationY(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.rotationYBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.scaleX(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.scaleXBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.scaleY(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.scaleYBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long l10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.setDuration(l10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator2) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.setInterpolator((TimeInterpolator)interpolator2);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        View view = (View)this.mView.get();
        if (view != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 16;
            if (n10 >= n11) {
                this.setListenerInternal(view, viewPropertyAnimatorListener);
            } else {
                n10 = 0x7E000000;
                view.setTag(n10, (Object)viewPropertyAnimatorListener);
                viewPropertyAnimatorListener = new ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14(this);
                this.setListenerInternal(view, viewPropertyAnimatorListener);
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long l10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.setStartDelay(l10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        int n10;
        int n11;
        View view = (View)this.mView.get();
        if (view != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 19)) {
            n11 = 0;
            ViewPropertyAnimatorCompat$2 viewPropertyAnimatorCompat$2 = null;
            if (viewPropertyAnimatorUpdateListener != null) {
                viewPropertyAnimatorCompat$2 = new ViewPropertyAnimatorCompat$2(this, viewPropertyAnimatorUpdateListener, view);
            }
            viewPropertyAnimatorUpdateListener = view.animate();
            viewPropertyAnimatorUpdateListener.setUpdateListener(viewPropertyAnimatorCompat$2);
        }
        return this;
    }

    public void start() {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.start();
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.translationX(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.translationXBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.translationY(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.translationYBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f10) {
        int n10;
        int n11;
        View view = (View)this.mView.get();
        if (view != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            view = view.animate();
            view.translationZ(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f10) {
        int n10;
        int n11;
        View view = (View)this.mView.get();
        if (view != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            view = view.animate();
            view.translationZBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        View view = (View)this.mView.get();
        if (view != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 16;
            if (n10 >= n11) {
                view = view.animate();
                view.withEndAction(runnable);
            } else {
                ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14 viewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14 = new ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14(this);
                this.setListenerInternal(view, viewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14);
                this.mEndAction = runnable;
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view = (View)this.mView.get();
        if (view != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 16;
            if (n10 >= n11) {
                view = view.animate();
                view.withLayer();
            } else {
                this.mOldLayerType = n10 = view.getLayerType();
                ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14 viewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14 = new ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14(this);
                this.setListenerInternal(view, viewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14);
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        View view = (View)this.mView.get();
        if (view != null) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 16;
            if (n10 >= n11) {
                view = view.animate();
                view.withStartAction(runnable);
            } else {
                ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14 viewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14 = new ViewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14(this);
                this.setListenerInternal(view, viewPropertyAnimatorCompat$ViewPropertyAnimatorListenerApi14);
                this.mStartAction = runnable;
            }
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.x(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.xBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.y(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f10) {
        View view = (View)this.mView.get();
        if (view != null) {
            view = view.animate();
            view.yBy(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f10) {
        int n10;
        int n11;
        View view = (View)this.mView.get();
        if (view != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            view = view.animate();
            view.z(f10);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f10) {
        int n10;
        int n11;
        View view = (View)this.mView.get();
        if (view != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 21)) {
            view = view.animate();
            view.zBy(f10);
        }
        return this;
    }
}

