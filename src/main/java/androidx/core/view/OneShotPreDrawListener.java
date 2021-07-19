/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

public final class OneShotPreDrawListener
implements ViewTreeObserver.OnPreDrawListener,
View.OnAttachStateChangeListener {
    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.mView = view;
        view = view.getViewTreeObserver();
        this.mViewTreeObserver = view;
        this.mRunnable = runnable;
    }

    public static OneShotPreDrawListener add(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)oneShotPreDrawListener);
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    public boolean onPreDraw() {
        this.removeListener();
        this.mRunnable.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        view = view.getViewTreeObserver();
        this.mViewTreeObserver = view;
    }

    public void onViewDetachedFromWindow(View view) {
        this.removeListener();
    }

    public void removeListener() {
        ViewTreeObserver viewTreeObserver = this.mViewTreeObserver;
        boolean bl2 = viewTreeObserver.isAlive();
        if (bl2) {
            viewTreeObserver = this.mViewTreeObserver;
            viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        } else {
            viewTreeObserver = this.mView.getViewTreeObserver();
            viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        }
        this.mView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }
}

