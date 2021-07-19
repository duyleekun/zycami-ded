/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.ProgressBar
 */
package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar
extends ProgressBar {
    private static final int MIN_DELAY = 500;
    private static final int MIN_SHOW_TIME = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    public boolean mDismissed = false;
    public boolean mPostedHide = false;
    public boolean mPostedShow = false;
    public long mStartTime = -1;

    public ContentLoadingProgressBar(Context context) {
        this(context, null);
    }

    public ContentLoadingProgressBar(Context object, AttributeSet attributeSet) {
        super(object, attributeSet, 0);
        super(this);
        this.mDelayedHide = object;
        super(this);
        this.mDelayedShow = object;
    }

    private void removeCallbacks() {
        Runnable runnable = this.mDelayedHide;
        this.removeCallbacks(runnable);
        runnable = this.mDelayedShow;
        this.removeCallbacks(runnable);
    }

    public void hide() {
        synchronized (this) {
            int n10;
            block13: {
                long l10;
                long l11;
                long l12;
                n10 = 1;
                this.mDismissed = n10;
                Runnable runnable = this.mDelayedShow;
                this.removeCallbacks(runnable);
                runnable = null;
                this.mPostedShow = false;
                long l13 = System.currentTimeMillis();
                long l14 = this.mStartTime;
                long l15 = 500L;
                long l16 = (l13 -= l14) - l15;
                long l17 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (l17 >= 0 || (l12 = (l11 = l14 - (l10 = (long)-1)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) break block13;
                l12 = (long)this.mPostedHide;
                if (l12 == false) {
                    Runnable runnable2 = this.mDelayedHide;
                    this.postDelayed(runnable2, l15 -= l13);
                    this.mPostedHide = n10;
                }
                break block14;
            }
            n10 = 8;
            {
                block14: {
                    this.setVisibility(n10);
                }
                return;
            }
            finally {
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void show() {
        synchronized (this) {
            long l10;
            this.mStartTime = l10 = (long)-1;
            boolean bl2 = false;
            Runnable runnable = null;
            this.mDismissed = false;
            Runnable runnable2 = this.mDelayedHide;
            this.removeCallbacks(runnable2);
            this.mPostedHide = false;
            bl2 = this.mPostedShow;
            if (!bl2) {
                runnable = this.mDelayedShow;
                long l11 = 500L;
                this.postDelayed(runnable, l11);
                this.mPostedShow = bl2 = true;
            }
            return;
        }
    }
}

