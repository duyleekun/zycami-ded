/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnHoverListener
 *  android.view.View$OnLongClickListener
 *  android.view.ViewConfiguration
 *  android.view.accessibility.AccessibilityManager
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.TooltipCompatHandler$1;
import androidx.appcompat.widget.TooltipPopup;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

public class TooltipCompatHandler
implements View.OnLongClickListener,
View.OnHoverListener,
View.OnAttachStateChangeListener {
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000L;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000L;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500L;
    private static final String TAG = "TooltipCompatHandler";
    private static TooltipCompatHandler sActiveHandler;
    private static TooltipCompatHandler sPendingHandler;
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mFromTouch;
    private final Runnable mHideRunnable;
    private final int mHoverSlop;
    private TooltipPopup mPopup;
    private final Runnable mShowRunnable;
    private final CharSequence mTooltipText;

    private TooltipCompatHandler(View view, CharSequence charSequence) {
        int n10;
        Runnable runnable = new TooltipCompatHandler$1(this);
        this.mShowRunnable = runnable;
        super(this);
        this.mHideRunnable = runnable;
        this.mAnchor = view;
        this.mTooltipText = charSequence;
        this.mHoverSlop = n10 = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get((Context)view.getContext()));
        this.clearAnchorPos();
        view.setOnLongClickListener((View.OnLongClickListener)this);
        view.setOnHoverListener((View.OnHoverListener)this);
    }

    private void cancelPendingShow() {
        View view = this.mAnchor;
        Runnable runnable = this.mShowRunnable;
        view.removeCallbacks(runnable);
    }

    private void clearAnchorPos() {
        int n10;
        this.mAnchorX = n10 = -1 >>> 1;
        this.mAnchorY = n10;
    }

    private void scheduleShow() {
        View view = this.mAnchor;
        Runnable runnable = this.mShowRunnable;
        long l10 = ViewConfiguration.getLongPressTimeout();
        view.postDelayed(runnable, l10);
    }

    private static void setPendingHandler(TooltipCompatHandler tooltipCompatHandler) {
        TooltipCompatHandler tooltipCompatHandler2 = sPendingHandler;
        if (tooltipCompatHandler2 != null) {
            tooltipCompatHandler2.cancelPendingShow();
        }
        sPendingHandler = tooltipCompatHandler;
        if (tooltipCompatHandler != null) {
            tooltipCompatHandler.scheduleShow();
        }
    }

    public static void setTooltipText(View view, CharSequence object) {
        boolean bl2;
        TooltipCompatHandler tooltipCompatHandler = sPendingHandler;
        if (tooltipCompatHandler != null && (tooltipCompatHandler = tooltipCompatHandler.mAnchor) == view) {
            TooltipCompatHandler.setPendingHandler(null);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            object = sActiveHandler;
            if (object != null && (tooltipCompatHandler = ((TooltipCompatHandler)object).mAnchor) == view) {
                ((TooltipCompatHandler)object).hide();
            }
            view.setOnLongClickListener(null);
            object = null;
            view.setLongClickable(false);
            view.setOnHoverListener(null);
        } else {
            tooltipCompatHandler = new TooltipCompatHandler(view, (CharSequence)object);
        }
    }

    private boolean updateAnchorPos(MotionEvent motionEvent) {
        int n10;
        float f10 = motionEvent.getX();
        int n11 = (int)f10;
        float f11 = motionEvent.getY();
        int n12 = (int)f11;
        int n13 = this.mAnchorX;
        if ((n13 = Math.abs(n11 - n13)) <= (n10 = this.mHoverSlop)) {
            n13 = this.mAnchorY;
            if ((n13 = Math.abs(n12 - n13)) <= (n10 = this.mHoverSlop)) {
                return false;
            }
        }
        this.mAnchorX = n11;
        this.mAnchorY = n12;
        return true;
    }

    public void hide() {
        Object object = sActiveHandler;
        Runnable runnable = null;
        if (object == this) {
            sActiveHandler = null;
            object = this.mPopup;
            if (object != null) {
                ((TooltipPopup)object).hide();
                this.mPopup = null;
                this.clearAnchorPos();
                object = this.mAnchor;
                object.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
            } else {
                object = TAG;
                String string2 = "sActiveHandler.mPopup == null";
                Log.e((String)object, (String)string2);
            }
        }
        if ((object = sPendingHandler) == this) {
            TooltipCompatHandler.setPendingHandler(null);
        }
        object = this.mAnchor;
        runnable = this.mHideRunnable;
        object.removeCallbacks(runnable);
    }

    public boolean onHover(View object, MotionEvent motionEvent) {
        int n10;
        object = this.mPopup;
        if (object != null && (n10 = this.mFromTouch) != 0) {
            return false;
        }
        object = this.mAnchor.getContext();
        String string2 = "accessibility";
        int n11 = (object = (AccessibilityManager)object.getSystemService(string2)).isEnabled();
        if (n11 != 0 && (n10 = object.isTouchExplorationEnabled()) != 0) {
            return false;
        }
        n10 = motionEvent.getAction();
        if (n10 != (n11 = 7)) {
            int n12 = 10;
            if (n10 == n12) {
                this.clearAnchorPos();
                this.hide();
            }
        } else {
            object = this.mAnchor;
            n10 = object.isEnabled() ? 1 : 0;
            if (n10 != 0 && (object = this.mPopup) == null && (n10 = (int)(this.updateAnchorPos(motionEvent) ? 1 : 0)) != 0) {
                TooltipCompatHandler.setPendingHandler(this);
            }
        }
        return false;
    }

    public boolean onLongClick(View view) {
        int bl2;
        int n10;
        this.mAnchorX = n10 = view.getWidth() / 2;
        this.mAnchorY = bl2 = view.getHeight() / 2;
        boolean bl3 = true;
        this.show(bl3);
        return bl3;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.hide();
    }

    /*
     * WARNING - void declaration
     */
    public void show(boolean bl2) {
        long l10;
        TooltipPopup tooltipPopup;
        Object object = this.mAnchor;
        int n10 = ViewCompat.isAttachedToWindow((View)object) ? 1 : 0;
        if (n10 == 0) {
            return;
        }
        n10 = 0;
        TooltipCompatHandler.setPendingHandler(null);
        object = sActiveHandler;
        if (object != null) {
            ((TooltipCompatHandler)object).hide();
        }
        sActiveHandler = this;
        this.mFromTouch = bl2;
        Context context = this.mAnchor.getContext();
        this.mPopup = tooltipPopup = new TooltipPopup(context);
        Object object2 = this.mAnchor;
        int n11 = this.mAnchorX;
        int n12 = this.mAnchorY;
        boolean bl3 = this.mFromTouch;
        CharSequence charSequence = this.mTooltipText;
        tooltipPopup.show((View)object2, n11, n12, bl3, charSequence);
        context = this.mAnchor;
        context.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        boolean bl4 = this.mFromTouch;
        if (bl4) {
            l10 = 2500L;
        } else {
            void var1_7;
            context = this.mAnchor;
            int n14 = ViewCompat.getWindowSystemUiVisibility((View)context);
            n14 = n14 & (n10 = 1);
            if (n14 == n10) {
                l10 = 3000L;
                int n15 = ViewConfiguration.getLongPressTimeout();
            } else {
                l10 = 15000L;
                int n16 = ViewConfiguration.getLongPressTimeout();
            }
            long l11 = (long)var1_7;
            l10 -= l11;
        }
        context = this.mAnchor;
        object2 = this.mHideRunnable;
        context.removeCallbacks((Runnable)object2);
        context = this.mAnchor;
        object2 = this.mHideRunnable;
        context.postDelayed((Runnable)object2, l10);
    }
}

