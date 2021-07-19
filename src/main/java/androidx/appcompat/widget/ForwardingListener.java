/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewConfiguration
 *  android.view.ViewParent
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ForwardingListener$DisallowIntercept;
import androidx.appcompat.widget.ForwardingListener$TriggerLongPress;

public abstract class ForwardingListener
implements View.OnTouchListener,
View.OnAttachStateChangeListener {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    public final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation;
    private Runnable mTriggerLongPress;

    public ForwardingListener(View view) {
        int n10;
        float f10;
        int n11 = 2;
        int[] nArray = new int[n11];
        this.mTmpLocation = nArray;
        this.mSrc = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        this.mScaledTouchSlop = f10 = (float)ViewConfiguration.get((Context)view.getContext()).getScaledTouchSlop();
        this.mTapTimeout = n10 = ViewConfiguration.getTapTimeout();
        int n12 = ViewConfiguration.getLongPressTimeout();
        this.mLongPressTimeout = n10 = (n10 + n12) / n11;
    }

    private void clearCallbacks() {
        View view;
        Runnable runnable = this.mTriggerLongPress;
        if (runnable != null) {
            view = this.mSrc;
            view.removeCallbacks(runnable);
        }
        if ((runnable = this.mDisallowIntercept) != null) {
            view = this.mSrc;
            view.removeCallbacks(runnable);
        }
    }

    private boolean onTouchForwarded(MotionEvent motionEvent) {
        int n10;
        View view = this.mSrc;
        Object object = this.getPopup();
        int n11 = 0;
        if (object != null && (n10 = object.isShowing()) != 0 && (object = (DropDownListView)object.getListView()) != null && (n10 = object.isShown()) != 0) {
            MotionEvent motionEvent2 = MotionEvent.obtainNoHistory((MotionEvent)motionEvent);
            this.toGlobalMotionEvent(view, motionEvent2);
            this.toLocalMotionEvent((View)object, motionEvent2);
            int n12 = this.mActivePointerId;
            n12 = ((DropDownListView)((Object)object)).onForwardedEvent(motionEvent2, n12) ? 1 : 0;
            motionEvent2.recycle();
            int n13 = motionEvent.getActionMasked();
            int n14 = 1;
            if (n13 != n14 && n13 != (n10 = 3)) {
                n13 = n14;
            } else {
                n13 = 0;
                motionEvent = null;
            }
            if (n12 != 0 && n13 != 0) {
                n11 = n14;
            }
        }
        return n11 != 0;
    }

    private boolean onTouchObserved(MotionEvent object) {
        block7: {
            int n10;
            int n11;
            View view;
            block4: {
                block5: {
                    float f10;
                    float f11;
                    boolean bl2;
                    float f12;
                    int n12;
                    block6: {
                        view = this.mSrc;
                        n11 = view.isEnabled();
                        if (!n11) {
                            return false;
                        }
                        n11 = object.getActionMasked();
                        if (!n11) break block4;
                        n12 = 1;
                        if (n11 == n12) break block5;
                        int n13 = 2;
                        f12 = 2.8E-45f;
                        if (n11 == n13) break block6;
                        int n14 = 3;
                        float f13 = 4.2E-45f;
                        if (n11 == n14) break block5;
                        break block7;
                    }
                    n11 = this.mActivePointerId;
                    if ((n11 = object.findPointerIndex(n11)) >= 0 && !(bl2 = ForwardingListener.pointInView(view, f12 = object.getX(n11), f11 = object.getY(n11), f10 = this.mScaledTouchSlop))) {
                        this.clearCallbacks();
                        view.getParent().requestDisallowInterceptTouchEvent(n12 != 0);
                        return n12 != 0;
                    }
                    break block7;
                }
                this.clearCallbacks();
                break block7;
            }
            this.mActivePointerId = n10 = object.getPointerId(0);
            object = this.mDisallowIntercept;
            if (object == null) {
                object = new ForwardingListener$DisallowIntercept(this);
                this.mDisallowIntercept = object;
            }
            object = this.mDisallowIntercept;
            n11 = this.mTapTimeout;
            long l10 = n11;
            view.postDelayed((Runnable)object, l10);
            object = this.mTriggerLongPress;
            if (object == null) {
                object = new ForwardingListener$TriggerLongPress(this);
                this.mTriggerLongPress = object;
            }
            object = this.mTriggerLongPress;
            n11 = this.mLongPressTimeout;
            l10 = n11;
            view.postDelayed((Runnable)object, l10);
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean pointInView(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        float f14 = f10 - f13;
        float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (f15 < 0) return 0 != 0;
        float f16 = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1);
        if (f16 < 0) return 0 != 0;
        f16 = view.getRight();
        f15 = view.getLeft();
        f13 = (float)(f16 -= f15) + f12;
        float f17 = f10 - f13;
        float f18 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
        if (f18 >= 0) return 0 != 0;
        f18 = view.getBottom();
        int n10 = view.getTop();
        float f19 = (float)(f18 -= n10) + f12;
        float f20 = f11 - f19;
        if ((n10 = (int)(f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1))) >= 0) return 0 != 0;
        return 1 != 0;
    }

    private boolean toGlobalMotionEvent(View view, MotionEvent motionEvent) {
        int[] nArray = this.mTmpLocation;
        view.getLocationOnScreen(nArray);
        float f10 = nArray[0];
        boolean bl2 = true;
        float f11 = nArray[bl2];
        motionEvent.offsetLocation(f10, f11);
        return bl2;
    }

    private boolean toLocalMotionEvent(View view, MotionEvent motionEvent) {
        int[] nArray = this.mTmpLocation;
        view.getLocationOnScreen(nArray);
        float f10 = -nArray[0];
        boolean bl2 = true;
        float f11 = -nArray[bl2];
        motionEvent.offsetLocation(f10, f11);
        return bl2;
    }

    public abstract ShowableListMenu getPopup();

    public boolean onForwardingStarted() {
        boolean bl2;
        ShowableListMenu showableListMenu = this.getPopup();
        if (showableListMenu != null && !(bl2 = showableListMenu.isShowing())) {
            showableListMenu.show();
        }
        return true;
    }

    public boolean onForwardingStopped() {
        boolean bl2;
        ShowableListMenu showableListMenu = this.getPopup();
        if (showableListMenu != null && (bl2 = showableListMenu.isShowing())) {
            showableListMenu.dismiss();
        }
        return true;
    }

    public void onLongPress() {
        this.clearCallbacks();
        View view = this.mSrc;
        boolean bl2 = view.isEnabled();
        if (bl2 && !(bl2 = view.isLongClickable())) {
            bl2 = this.onForwardingStarted();
            if (!bl2) {
                return;
            }
            ViewParent viewParent = view.getParent();
            boolean bl3 = true;
            viewParent.requestDisallowInterceptTouchEvent(bl3);
            long l10 = SystemClock.uptimeMillis();
            int n10 = 3;
            viewParent = MotionEvent.obtain((long)l10, (long)l10, (int)n10, (float)0.0f, (float)0.0f, (int)0);
            view.onTouchEvent((MotionEvent)viewParent);
            viewParent.recycle();
            this.mForwarding = bl3;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean bl2;
        boolean bl3 = this.mForwarding;
        boolean bl4 = true;
        if (bl3) {
            bl2 = this.onTouchForwarded(motionEvent);
            if (!bl2 && (bl2 = this.onForwardingStopped())) {
                bl2 = false;
                motionEvent = null;
            } else {
                bl2 = bl4;
            }
        } else {
            bl2 = this.onTouchObserved(motionEvent);
            if (bl2 && (bl2 = this.onForwardingStarted())) {
                bl2 = bl4;
            } else {
                bl2 = false;
                motionEvent = null;
            }
            if (bl2) {
                long l10 = SystemClock.uptimeMillis();
                int n10 = 3;
                MotionEvent motionEvent2 = MotionEvent.obtain((long)l10, (long)l10, (int)n10, (float)0.0f, (float)0.0f, (int)0);
                View view2 = this.mSrc;
                view2.onTouchEvent(motionEvent2);
                motionEvent2.recycle();
            }
        }
        this.mForwarding = bl2;
        if (!bl2 && !bl3) {
            bl4 = false;
        }
        return bl4;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View object) {
        int n10;
        this.mForwarding = false;
        this.mActivePointerId = n10 = -1;
        object = this.mDisallowIntercept;
        if (object != null) {
            View view = this.mSrc;
            view.removeCallbacks((Runnable)object);
        }
    }
}

