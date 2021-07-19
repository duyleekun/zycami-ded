/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 */
package com.mob.tools.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mob.tools.gui.PullToRequestAdatper;
import com.mob.tools.gui.PullToRequestView$1;

public class PullToRequestView
extends RelativeLayout {
    private static final int FAULT_TOLERANCE_RANGE = 10;
    private static final long MIN_REF_TIME = 1000L;
    private PullToRequestAdatper adapter;
    private View bodyView;
    private float downY;
    private int footerHeight;
    private View footerView;
    private int headerHeight;
    private View headerView;
    private long pullTime;
    private boolean pullingDownLock;
    private boolean pullingUpLock;
    private int state;
    private Runnable stopAct;
    private int top;

    public PullToRequestView(Context context) {
        super(context);
        this.init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    public PullToRequestView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.init();
    }

    public static /* synthetic */ void access$000(PullToRequestView pullToRequestView) {
        pullToRequestView.reversePulling();
    }

    private boolean canPullDown() {
        PullToRequestAdatper pullToRequestAdatper;
        int n10 = this.pullingDownLock;
        if (n10 == 0 && (n10 = (pullToRequestAdatper = this.adapter).isPullDownReady()) != 0 && (n10 = this.state) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            pullToRequestAdatper = null;
        }
        return n10 != 0;
    }

    private boolean canPullUp() {
        PullToRequestAdatper pullToRequestAdatper;
        int n10 = this.pullingUpLock;
        if (n10 == 0 && (n10 = (pullToRequestAdatper = this.adapter).isPullUpReady()) != 0 && (n10 = this.state) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            pullToRequestAdatper = null;
        }
        return n10 != 0;
    }

    private MotionEvent getCancelEvent(MotionEvent motionEvent) {
        long l10 = motionEvent.getDownTime();
        long l11 = motionEvent.getEventTime();
        float f10 = motionEvent.getX();
        float f11 = motionEvent.getY();
        int n10 = motionEvent.getMetaState();
        return MotionEvent.obtain((long)l10, (long)l11, (int)3, (float)f10, (float)f11, (int)n10);
    }

    private void init() {
        PullToRequestView$1 pullToRequestView$1 = new PullToRequestView$1(this);
        this.stopAct = pullToRequestView$1;
    }

    private void performRequestNext() {
        int n10;
        long l10;
        this.pullTime = l10 = System.currentTimeMillis();
        this.state = n10 = -1;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onRequestNext();
        }
    }

    private void reversePulling() {
        this.top = 0;
        this.scrollTo(0, 0);
        this.state = 0;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onReversed();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        block38: {
            float f10;
            block35: {
                int n10;
                int n11;
                int n12;
                int n13;
                block36: {
                    float f11;
                    int n14;
                    int n15;
                    float f12;
                    float f13;
                    block37: {
                        n13 = motionEvent.getAction();
                        if (n13 == 0) break block35;
                        n12 = -1;
                        f13 = 0.0f / 0.0f;
                        n11 = 1;
                        f12 = Float.MIN_VALUE;
                        n10 = 100;
                        n15 = 0;
                        if (n13 == n11) break block36;
                        n14 = 2;
                        f11 = 2.8E-45f;
                        if (n13 == n14) break block37;
                        n14 = 3;
                        f11 = 4.2E-45f;
                        if (n13 == n14) break block36;
                        break block38;
                    }
                    float f14 = motionEvent.getY();
                    n14 = this.state;
                    float f15 = 2.0f;
                    if (n14 != n12) {
                        if (n14 != n11) {
                            n12 = this.top;
                            if (n12 > 0) {
                                f13 = n12;
                                f12 = this.downY;
                                f12 = (f14 - f12) / f15;
                                this.top = n12 = (int)(f13 += f12);
                                if (n12 < 0) {
                                    this.top = 0;
                                }
                                n12 = -this.top;
                                this.scrollTo(0, n12);
                                PullToRequestAdatper pullToRequestAdatper = this.adapter;
                                if (pullToRequestAdatper != null && (n11 = this.headerHeight) != 0) {
                                    n15 = this.top * n10 / n11;
                                    pullToRequestAdatper.onPullDown(n15);
                                }
                                motionEvent = this.getCancelEvent(motionEvent);
                            } else if (n12 < 0) {
                                f13 = n12;
                                f12 = this.downY;
                                f12 = (f14 - f12) / f15;
                                this.top = n12 = (int)(f13 += f12);
                                if (n12 > 0) {
                                    this.top = 0;
                                }
                                n12 = -this.top;
                                this.scrollTo(0, n12);
                                PullToRequestAdatper pullToRequestAdatper = this.adapter;
                                if (pullToRequestAdatper != null && (n11 = this.footerHeight) != 0) {
                                    n15 = -this.top * n10 / n11;
                                    pullToRequestAdatper.onPullUp(n15);
                                }
                                motionEvent = this.getCancelEvent(motionEvent);
                            } else {
                                f13 = this.downY;
                                f12 = f14 - f13;
                                n14 = 1092616192;
                                f11 = 10.0f;
                                float f16 = f12 - f11;
                                n11 = (int)(f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1));
                                if (n11 > 0) {
                                    n12 = (int)(this.canPullDown() ? 1 : 0);
                                    if (n12 != 0) {
                                        f13 = this.top;
                                        f12 = this.downY;
                                        f12 = (f14 - f12) / f15;
                                        this.top = n12 = (int)(f13 += f12);
                                        n12 = -n12;
                                        this.scrollTo(0, n12);
                                        PullToRequestAdatper pullToRequestAdatper = this.adapter;
                                        if (pullToRequestAdatper != null && (n11 = this.headerHeight) != 0) {
                                            n15 = -this.top * n10 / n11;
                                            pullToRequestAdatper.onPullUp(n15);
                                        }
                                        motionEvent = this.getCancelEvent(motionEvent);
                                    }
                                } else {
                                    float f17 = (f13 -= f14) - f11;
                                    n12 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
                                    if (n12 > 0 && (n12 = (int)(this.canPullUp() ? 1 : 0)) != 0) {
                                        f13 = this.top;
                                        f12 = this.downY;
                                        f12 = (f14 - f12) / f15;
                                        this.top = n12 = (int)(f13 += f12);
                                        n12 = -n12;
                                        this.scrollTo(0, n12);
                                        PullToRequestAdatper pullToRequestAdatper = this.adapter;
                                        if (pullToRequestAdatper != null && (n11 = this.footerHeight) != 0) {
                                            n15 = -this.top * n10 / n11;
                                            pullToRequestAdatper.onPullUp(n15);
                                        }
                                        motionEvent = this.getCancelEvent(motionEvent);
                                    }
                                }
                            }
                        } else {
                            f13 = this.top;
                            f12 = this.downY;
                            f12 = (f14 - f12) / f15;
                            this.top = n12 = (int)(f13 += f12);
                            if (n12 < 0) {
                                this.top = 0;
                            }
                            n12 = -this.top;
                            this.scrollTo(0, n12);
                            motionEvent = this.getCancelEvent(motionEvent);
                        }
                    } else {
                        f13 = this.top;
                        f12 = this.downY;
                        f12 = (f14 - f12) / f15;
                        this.top = n12 = (int)(f13 += f12);
                        if (n12 > 0) {
                            this.top = 0;
                        }
                        n12 = -this.top;
                        this.scrollTo(0, n12);
                        motionEvent = this.getCancelEvent(motionEvent);
                    }
                    this.downY = f14;
                    break block38;
                }
                if ((n13 = this.state) != n12) {
                    if (n13 != 0) {
                        if (n13 == n11) {
                            this.top = n13 = this.headerHeight;
                            n13 = -n13;
                            this.scrollTo(0, n13);
                        }
                    } else {
                        n13 = this.top;
                        n12 = this.headerHeight;
                        if (n13 > n12) {
                            this.top = n12;
                            n13 = -n12;
                            this.scrollTo(0, n13);
                            PullToRequestAdatper pullToRequestAdatper = this.adapter;
                            if (pullToRequestAdatper != null) {
                                pullToRequestAdatper.onPullDown(n10);
                            }
                            this.performFresh();
                            motionEvent = this.getCancelEvent(motionEvent);
                        } else {
                            n12 = this.footerHeight;
                            n11 = -n12;
                            if (n13 < n11) {
                                this.top = n13 = -n12;
                                n13 = -n13;
                                this.scrollTo(0, n13);
                                PullToRequestAdatper pullToRequestAdatper = this.adapter;
                                if (pullToRequestAdatper != null) {
                                    pullToRequestAdatper.onPullUp(n10);
                                }
                                this.performRequestNext();
                                motionEvent = this.getCancelEvent(motionEvent);
                            } else if (n13 != 0) {
                                this.scrollTo(0, 0);
                                PullToRequestAdatper pullToRequestAdatper = this.adapter;
                                if (pullToRequestAdatper != null) {
                                    n12 = this.top;
                                    if (n12 > 0) {
                                        pullToRequestAdatper.onPullDown(0);
                                    } else {
                                        pullToRequestAdatper.onPullUp(0);
                                    }
                                }
                                this.top = 0;
                            }
                        }
                    }
                } else {
                    this.top = n13 = -this.footerHeight;
                    n13 = -n13;
                    this.scrollTo(0, n13);
                }
                break block38;
            }
            this.downY = f10 = motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void lockPullingDown() {
        this.pullingDownLock = true;
    }

    public void lockPullingUp() {
        this.pullingUpLock = true;
    }

    public void performFresh() {
        int n10;
        long l10;
        this.pullTime = l10 = System.currentTimeMillis();
        this.state = n10 = 1;
        PullToRequestAdatper pullToRequestAdatper = this.adapter;
        if (pullToRequestAdatper != null) {
            pullToRequestAdatper.onRefresh();
        }
    }

    public void performPullingDown(boolean bl2) {
        int n10;
        this.top = n10 = this.headerHeight;
        n10 = -n10;
        this.scrollTo(0, n10);
        if (bl2) {
            this.performFresh();
        }
    }

    public void performPullingUp(boolean bl2) {
        int n10;
        this.top = n10 = -this.footerHeight;
        n10 = -n10;
        this.scrollTo(0, n10);
        if (bl2) {
            this.performRequestNext();
        }
    }

    public void releasePullingDownLock() {
        this.pullingDownLock = false;
    }

    public void releasePullingUpLock() {
        this.pullingUpLock = false;
    }

    public void setAdapter(PullToRequestAdatper pullToRequestAdatper) {
        int n10;
        int n11;
        View view;
        this.adapter = pullToRequestAdatper;
        this.removeAllViews();
        this.bodyView = view = (View)pullToRequestAdatper.getBodyView();
        int n12 = -1;
        view = new RelativeLayout.LayoutParams(n12, n12);
        n12 = 9;
        view.addRule(n12);
        int n13 = 11;
        view.addRule(n13);
        int n14 = 10;
        view.addRule(n14);
        View view2 = this.bodyView;
        this.addView(view2, (ViewGroup.LayoutParams)view);
        this.headerView = view = pullToRequestAdatper.getHeaderView();
        int n15 = -2;
        view2 = new RelativeLayout.LayoutParams(n15, n15);
        view.setLayoutParams((ViewGroup.LayoutParams)view2);
        this.headerView.measure(0, 0);
        int n16 = this.headerHeight = (n11 = this.headerView.getMeasuredHeight());
        view = new RelativeLayout.LayoutParams(n15, n16);
        view.addRule(n12);
        view.addRule(n13);
        view.addRule(n14);
        view.topMargin = n14 = -this.headerHeight;
        View view3 = this.headerView;
        this.addView(view3, (ViewGroup.LayoutParams)view);
        pullToRequestAdatper = pullToRequestAdatper.getFooterView();
        this.footerView = pullToRequestAdatper;
        view = new RelativeLayout.LayoutParams(n15, n15);
        pullToRequestAdatper.setLayoutParams((ViewGroup.LayoutParams)view);
        this.footerView.measure(0, 0);
        this.footerHeight = n10 = this.footerView.getMeasuredHeight();
        n11 = this.headerHeight;
        pullToRequestAdatper = new RelativeLayout.LayoutParams(n15, n11);
        pullToRequestAdatper.addRule(n12);
        pullToRequestAdatper.addRule(n13);
        pullToRequestAdatper.addRule(12);
        ((RelativeLayout.LayoutParams)pullToRequestAdatper).bottomMargin = n11 = -this.headerHeight;
        view = this.footerView;
        this.addView(view, (ViewGroup.LayoutParams)pullToRequestAdatper);
    }

    public void stopPulling() {
        long l10 = System.currentTimeMillis();
        long l11 = this.pullTime;
        long l12 = (l10 -= l11) - (l11 = 1000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            Runnable runnable = this.stopAct;
            this.postDelayed(runnable, l11 -= l10);
        } else {
            Runnable runnable = this.stopAct;
            this.post(runnable);
        }
    }
}

