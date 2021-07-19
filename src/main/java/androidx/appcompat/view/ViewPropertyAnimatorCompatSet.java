/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.appcompat.view;

import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet {
    public final ArrayList mAnimators;
    private long mDuration = -1;
    private Interpolator mInterpolator;
    private boolean mIsStarted;
    public ViewPropertyAnimatorListener mListener;
    private final ViewPropertyAnimatorListenerAdapter mProxyListener;

    public ViewPropertyAnimatorCompatSet() {
        ArrayList arrayList = new ArrayList(this);
        this.mProxyListener = arrayList;
        this.mAnimators = arrayList = new ArrayList();
    }

    public void cancel() {
        boolean bl2;
        boolean bl3 = this.mIsStarted;
        if (!bl3) {
            return;
        }
        Iterator iterator2 = this.mAnimators.iterator();
        while (bl2 = iterator2.hasNext()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)iterator2.next();
            viewPropertyAnimatorCompat.cancel();
        }
        this.mIsStarted = false;
    }

    public void onAnimationsEnded() {
        this.mIsStarted = false;
    }

    public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        boolean bl2 = this.mIsStarted;
        if (!bl2) {
            ArrayList arrayList = this.mAnimators;
            arrayList.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.mAnimators.add(viewPropertyAnimatorCompat);
        long l10 = viewPropertyAnimatorCompat.getDuration();
        viewPropertyAnimatorCompat2.setStartDelay(l10);
        this.mAnimators.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet setDuration(long l10) {
        boolean bl2 = this.mIsStarted;
        if (!bl2) {
            this.mDuration = l10;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator interpolator2) {
        boolean bl2 = this.mIsStarted;
        if (!bl2) {
            this.mInterpolator = interpolator2;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        boolean bl2 = this.mIsStarted;
        if (!bl2) {
            this.mListener = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void start() {
        boolean bl2;
        boolean bl3 = this.mIsStarted;
        if (bl3) {
            return;
        }
        Iterator iterator2 = this.mAnimators.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat)iterator2.next();
            long l10 = this.mDuration;
            long l11 = 0L;
            long l12 = l10 - l11;
            long l13 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (l13 >= 0) {
                viewPropertyAnimatorCompat.setDuration(l10);
            }
            if ((object = this.mInterpolator) != null) {
                viewPropertyAnimatorCompat.setInterpolator((Interpolator)object);
            }
            if ((object = this.mListener) != null) {
                object = this.mProxyListener;
                viewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)object);
            }
            viewPropertyAnimatorCompat.start();
        }
        this.mIsStarted = true;
    }
}

