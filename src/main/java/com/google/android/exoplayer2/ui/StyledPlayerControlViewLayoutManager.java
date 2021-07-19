/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.res.Resources
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.animation.LinearInterpolator
 */
package com.google.android.exoplayer2.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.R$dimen;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$1;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager$3;
import d.h.a.a.p0.a0;
import d.h.a.a.p0.p;
import d.h.a.a.p0.q;
import d.h.a.a.p0.r;
import d.h.a.a.p0.v;
import d.h.a.a.p0.y;
import java.util.ArrayList;
import java.util.List;

public final class StyledPlayerControlViewLayoutManager {
    private static final long ANIMATION_INTERVAL_MS = 2000L;
    private static final long DURATION_FOR_HIDING_ANIMATION_MS = 250L;
    private static final long DURATION_FOR_SHOWING_ANIMATION_MS = 250L;
    private static final int UX_STATE_ALL_VISIBLE = 0;
    private static final int UX_STATE_ANIMATING_HIDE = 3;
    private static final int UX_STATE_ANIMATING_SHOW = 4;
    private static final int UX_STATE_NONE_VISIBLE = 2;
    private static final int UX_STATE_ONLY_PROGRESS_VISIBLE = 1;
    private boolean animationEnabled;
    private final ViewGroup basicControls;
    private final ViewGroup bottomBar;
    private final ViewGroup centerControls;
    private final ViewGroup extraControls;
    private final ViewGroup extraControlsScrollView;
    private final AnimatorSet hideAllBarsAnimator;
    private final Runnable hideAllBarsRunnable;
    private final Runnable hideControllerRunnable;
    private final AnimatorSet hideMainBarAnimator;
    private final Runnable hideMainBarRunnable;
    private final AnimatorSet hideProgressBarAnimator;
    private final Runnable hideProgressBarRunnable;
    private boolean isMinimalMode;
    private final ViewGroup minimalControls;
    private boolean needToShowBars;
    private final View.OnLayoutChangeListener onLayoutChangeListener;
    private final ValueAnimator overflowHideAnimator;
    private final ValueAnimator overflowShowAnimator;
    private final View overflowShowButton;
    private final AnimatorSet showAllBarsAnimator;
    private final Runnable showAllBarsRunnable;
    private final AnimatorSet showMainBarAnimator;
    private final List shownButtons;
    private final StyledPlayerControlView styledPlayerControlView;
    private final View timeBar;
    private final ViewGroup timeView;
    private int uxState;

    public StyledPlayerControlViewLayoutManager(StyledPlayerControlView object) {
        Object object2;
        Object object3;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        this.styledPlayerControlView = object;
        Object object4 = new a0(this);
        this.showAllBarsRunnable = object4;
        super(this);
        this.hideAllBarsRunnable = object4;
        super(this);
        this.hideProgressBarRunnable = object4;
        super(this);
        this.hideMainBarRunnable = object4;
        super(this);
        this.hideControllerRunnable = object4;
        object4 = new v(this);
        this.onLayoutChangeListener = object4;
        this.animationEnabled = true;
        float f10 = 0.0f;
        this.uxState = 0;
        this.shownButtons = object4 = new ArrayList();
        int n10 = R$id.exo_controls_background;
        object4 = object.findViewById(n10);
        int n11 = R$id.exo_center_controls;
        this.centerControls = viewGroup2 = (ViewGroup)object.findViewById(n11);
        n11 = R$id.exo_minimal_controls;
        this.minimalControls = viewGroup2 = (ViewGroup)object.findViewById(n11);
        n11 = R$id.exo_bottom_bar;
        this.bottomBar = viewGroup2 = (ViewGroup)object.findViewById(n11);
        int n12 = R$id.exo_time;
        this.timeView = viewGroup = (ViewGroup)object.findViewById(n12);
        n12 = R$id.exo_progress;
        viewGroup = object.findViewById(n12);
        this.timeBar = viewGroup;
        int n13 = R$id.exo_basic_controls;
        this.basicControls = object3 = (ViewGroup)object.findViewById(n13);
        n13 = R$id.exo_extra_controls;
        this.extraControls = object3 = (ViewGroup)object.findViewById(n13);
        n13 = R$id.exo_extra_controls_scroll_view;
        this.extraControlsScrollView = object3 = (ViewGroup)object.findViewById(n13);
        n13 = R$id.exo_overflow_show;
        object3 = object.findViewById(n13);
        this.overflowShowButton = object3;
        int n14 = R$id.exo_overflow_hide;
        Object object5 = object.findViewById(n14);
        if (object3 != null && object5 != null) {
            object2 = new y(this);
            object3.setOnClickListener((View.OnClickListener)object2);
            super(this);
            object5.setOnClickListener((View.OnClickListener)object3);
        }
        n13 = 2;
        Object object6 = object5 = (Object)new float[n13];
        object6[0] = (View)1.0f;
        object6[1] = (View)0.0f;
        object5 = ValueAnimator.ofFloat((float[])object5);
        super();
        object5.setInterpolator((TimeInterpolator)object2);
        object2 = new r(this, (View)object4);
        object5.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
        object2 = new StyledPlayerControlViewLayoutManager$1(this, (View)object4);
        object5.addListener((Animator.AnimatorListener)object2);
        Object object7 = object2 = (Object)new float[n13];
        object7[0] = 0.0f;
        object7[1] = 1.0f;
        object2 = ValueAnimator.ofFloat((float[])object2);
        Object object8 = new LinearInterpolator();
        object2.setInterpolator((TimeInterpolator)object8);
        super(this, (View)object4);
        object2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object8);
        super(this, (View)object4);
        object2.addListener((Animator.AnimatorListener)object8);
        object4 = object.getResources();
        int n15 = R$dimen.exo_styled_bottom_bar_height;
        float f11 = object4.getDimension(n15);
        int n16 = R$dimen.exo_styled_progress_bar_height;
        float f12 = object4.getDimension(n16);
        f10 = object4.getDimension(n15);
        super();
        this.hideMainBarAnimator = object8;
        long l10 = 250L;
        object8.setDuration(l10);
        StyledPlayerControlViewLayoutManager$3 styledPlayerControlViewLayoutManager$3 = new StyledPlayerControlViewLayoutManager$3(this, (StyledPlayerControlView)((Object)object));
        object8.addListener((Animator.AnimatorListener)styledPlayerControlViewLayoutManager$3);
        object8 = object8.play((Animator)object5);
        Object object9 = StyledPlayerControlViewLayoutManager.ofTranslationY(0.0f, f11 -= f12, (View)viewGroup);
        object8 = object8.with((Animator)object9);
        object9 = StyledPlayerControlViewLayoutManager.ofTranslationY(0.0f, f11, (View)viewGroup2);
        object8.with((Animator)object9);
        super();
        this.hideProgressBarAnimator = object8;
        object8.setDuration(l10);
        super(this, (StyledPlayerControlView)((Object)object));
        object8.addListener((Animator.AnimatorListener)object9);
        object9 = StyledPlayerControlViewLayoutManager.ofTranslationY(f11, f10, (View)viewGroup);
        object8 = object8.play((Animator)object9);
        object9 = StyledPlayerControlViewLayoutManager.ofTranslationY(f11, f10, (View)viewGroup2);
        object8.with((Animator)object9);
        super();
        this.hideAllBarsAnimator = object8;
        object8.setDuration(l10);
        super(this, (StyledPlayerControlView)((Object)object));
        object8.addListener((Animator.AnimatorListener)object9);
        object = object8.play((Animator)object5);
        object5 = StyledPlayerControlViewLayoutManager.ofTranslationY(0.0f, f10, (View)viewGroup);
        object = object.with((Animator)object5);
        object5 = StyledPlayerControlViewLayoutManager.ofTranslationY(0.0f, f10, (View)viewGroup2);
        object.with((Animator)object5);
        super();
        this.showMainBarAnimator = object;
        object.setDuration(l10);
        super(this);
        object.addListener((Animator.AnimatorListener)object5);
        object = object.play((Animator)object2);
        object5 = StyledPlayerControlViewLayoutManager.ofTranslationY(f11, 0.0f, (View)viewGroup);
        object = object.with((Animator)object5);
        object5 = StyledPlayerControlViewLayoutManager.ofTranslationY(f11, 0.0f, (View)viewGroup2);
        object.with((Animator)object5);
        super();
        this.showAllBarsAnimator = object;
        object.setDuration(l10);
        super(this);
        object.addListener((Animator.AnimatorListener)object5);
        object = object.play((Animator)object2);
        viewGroup = StyledPlayerControlViewLayoutManager.ofTranslationY(f10, 0.0f, (View)viewGroup);
        object = object.with((Animator)viewGroup);
        object4 = StyledPlayerControlViewLayoutManager.ofTranslationY(f10, 0.0f, (View)viewGroup2);
        object.with((Animator)object4);
        Object object10 = object = (Object)new float[n13];
        object10[0] = (StyledPlayerControlView)0.0f;
        object10[1] = (StyledPlayerControlView)1.0f;
        object = ValueAnimator.ofFloat((float[])object);
        this.overflowShowAnimator = object;
        object.setDuration(l10);
        super(this);
        object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object4);
        super(this);
        object.addListener((Animator.AnimatorListener)object4);
        Object object11 = object = (Object)new float[n13];
        object11[0] = (StyledPlayerControlView)1.0f;
        object11[1] = (StyledPlayerControlView)0.0f;
        object = ValueAnimator.ofFloat((float[])object);
        this.overflowHideAnimator = object;
        object.setDuration(l10);
        super(this);
        object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object4);
        super(this);
        object.addListener((Animator.AnimatorListener)object4);
    }

    public static /* synthetic */ void a(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        styledPlayerControlViewLayoutManager.updateLayoutForSizeChange();
    }

    public static /* synthetic */ View access$000(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        return styledPlayerControlViewLayoutManager.timeBar;
    }

    public static /* synthetic */ boolean access$100(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        return styledPlayerControlViewLayoutManager.isMinimalMode;
    }

    public static /* synthetic */ ViewGroup access$200(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        return styledPlayerControlViewLayoutManager.centerControls;
    }

    public static /* synthetic */ ViewGroup access$300(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        return styledPlayerControlViewLayoutManager.minimalControls;
    }

    public static /* synthetic */ void access$400(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, int n10) {
        styledPlayerControlViewLayoutManager.setUxState(n10);
    }

    public static /* synthetic */ boolean access$500(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        return styledPlayerControlViewLayoutManager.needToShowBars;
    }

    public static /* synthetic */ boolean access$502(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, boolean bl2) {
        styledPlayerControlViewLayoutManager.needToShowBars = bl2;
        return bl2;
    }

    public static /* synthetic */ Runnable access$600(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        return styledPlayerControlViewLayoutManager.showAllBarsRunnable;
    }

    public static /* synthetic */ ViewGroup access$700(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        return styledPlayerControlViewLayoutManager.extraControlsScrollView;
    }

    public static /* synthetic */ ViewGroup access$800(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        return styledPlayerControlViewLayoutManager.basicControls;
    }

    private void animateOverflow(float f10) {
        float f11;
        ViewGroup viewGroup = this.extraControlsScrollView;
        float f12 = 1.0f;
        if (viewGroup != null) {
            float f13 = viewGroup.getWidth();
            f11 = f12 - f10;
            int n10 = (int)(f13 * f11);
            ViewGroup viewGroup2 = this.extraControlsScrollView;
            f13 = n10;
            viewGroup2.setTranslationX(f13);
        }
        if ((viewGroup = this.timeView) != null) {
            f11 = f12 - f10;
            viewGroup.setAlpha(f11);
        }
        if ((viewGroup = this.basicControls) != null) {
            viewGroup.setAlpha(f12 -= f10);
        }
    }

    public static /* synthetic */ void b(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        styledPlayerControlViewLayoutManager.onLayoutWidthChanged();
    }

    public static /* synthetic */ void c(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        styledPlayerControlViewLayoutManager.hideAllBars();
    }

    public static /* synthetic */ void d(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        styledPlayerControlViewLayoutManager.hideController();
    }

    public static /* synthetic */ void e(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        styledPlayerControlViewLayoutManager.onLayoutChange(view, n10, n11, n12, n13, n14, n15, n16, n17);
    }

    public static /* synthetic */ void f(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        styledPlayerControlViewLayoutManager.hideProgressBar();
    }

    public static /* synthetic */ void g(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, View view) {
        styledPlayerControlViewLayoutManager.onOverflowButtonClick(view);
    }

    private static int getHeightWithMargins(View view) {
        if (view == null) {
            return 0;
        }
        int n10 = view.getHeight();
        int n11 = (view = view.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams;
        if (n11 != 0) {
            view = (ViewGroup.MarginLayoutParams)view;
            n11 = view.topMargin;
            int n12 = view.bottomMargin;
            n10 += (n11 += n12);
        }
        return n10;
    }

    private static int getWidthWithMargins(View view) {
        if (view == null) {
            return 0;
        }
        int n10 = view.getWidth();
        int n11 = (view = view.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams;
        if (n11 != 0) {
            view = (ViewGroup.MarginLayoutParams)view;
            n11 = view.leftMargin;
            int n12 = view.rightMargin;
            n10 += (n11 += n12);
        }
        return n10;
    }

    public static /* synthetic */ void h(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        styledPlayerControlViewLayoutManager.hideMainBar();
    }

    private void hideAllBars() {
        this.hideAllBarsAnimator.start();
    }

    private void hideController() {
        this.setUxState(2);
    }

    private void hideMainBar() {
        this.hideMainBarAnimator.start();
        Runnable runnable = this.hideProgressBarRunnable;
        this.postDelayedRunnable(runnable, 2000L);
    }

    private void hideProgressBar() {
        this.hideProgressBarAnimator.start();
    }

    private /* synthetic */ void i(View view, ValueAnimator object) {
        object = (Float)object.getAnimatedValue();
        float f10 = ((Float)object).floatValue();
        if (view != null) {
            view.setAlpha(f10);
        }
        if ((view = this.centerControls) != null) {
            view.setAlpha(f10);
        }
        if ((view = this.minimalControls) != null) {
            view.setAlpha(f10);
        }
    }

    private /* synthetic */ void k(View view, ValueAnimator object) {
        object = (Float)object.getAnimatedValue();
        float f10 = ((Float)object).floatValue();
        if (view != null) {
            view.setAlpha(f10);
        }
        if ((view = this.centerControls) != null) {
            view.setAlpha(f10);
        }
        if ((view = this.minimalControls) != null) {
            view.setAlpha(f10);
        }
    }

    private /* synthetic */ void m(ValueAnimator valueAnimator) {
        float f10 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        this.animateOverflow(f10);
    }

    private /* synthetic */ void o(ValueAnimator valueAnimator) {
        float f10 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        this.animateOverflow(f10);
    }

    private static ObjectAnimator ofTranslationY(float f10, float f11, View view) {
        float[] fArray = new float[]{f10, f11};
        return ObjectAnimator.ofFloat((Object)view, (String)"translationY", (float[])fArray);
    }

    private void onLayoutChange(View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        q q10;
        n13 = (int)(this.isMinimalMode ? 1 : 0);
        n11 = (int)(this.useMinimalMode() ? 1 : 0);
        if (n13 != n11) {
            this.isMinimalMode = n11;
            p p10 = new p(this);
            view.post((Runnable)p10);
        }
        if ((n12 -= n10) != (n16 -= n14)) {
            n10 = 1;
        } else {
            n10 = 0;
            q10 = null;
        }
        n11 = (int)(this.isMinimalMode ? 1 : 0);
        if (n11 == 0 && n10 != 0) {
            q10 = new q(this);
            view.post((Runnable)q10);
        }
    }

    private void onLayoutWidthChanged() {
        Object object = this.basicControls;
        if (object != null && (object = this.extraControls) != null) {
            int n10;
            View view;
            int n11;
            int n12;
            ViewGroup viewGroup;
            int n13;
            int n14;
            object = this.styledPlayerControlView;
            int n15 = object.getWidth();
            int n16 = this.styledPlayerControlView.getPaddingLeft();
            n15 -= n16;
            StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
            n16 = styledPlayerControlView.getPaddingRight();
            n15 -= n16;
            while (true) {
                styledPlayerControlView = this.extraControls;
                n16 = styledPlayerControlView.getChildCount();
                n14 = 0;
                n13 = 1;
                if (n16 <= n13) break;
                n16 = this.extraControls.getChildCount() + -2;
                View view2 = this.extraControls.getChildAt(n16);
                viewGroup = this.extraControls;
                viewGroup.removeViewAt(n16);
                styledPlayerControlView = this.basicControls;
                styledPlayerControlView.addView(view2, 0);
            }
            styledPlayerControlView = this.overflowShowButton;
            if (styledPlayerControlView != null) {
                n12 = 8;
                styledPlayerControlView.setVisibility(n12);
            }
            styledPlayerControlView = this.timeView;
            n16 = StyledPlayerControlViewLayoutManager.getWidthWithMargins((View)styledPlayerControlView);
            viewGroup = this.basicControls;
            n12 = viewGroup.getChildCount() - n13;
            Object object2 = null;
            for (n11 = 0; n11 < n12; ++n11) {
                view = this.basicControls.getChildAt(n11);
                n10 = StyledPlayerControlViewLayoutManager.getWidthWithMargins(view);
                n16 += n10;
            }
            if (n16 > n15) {
                object2 = this.overflowShowButton;
                if (object2 != null) {
                    object2.setVisibility(0);
                    object2 = this.overflowShowButton;
                    n11 = StyledPlayerControlViewLayoutManager.getWidthWithMargins((View)object2);
                    n16 += n11;
                }
                object2 = new ArrayList();
                view = null;
                for (n10 = 0; n10 < n12; ++n10) {
                    View view3 = this.basicControls.getChildAt(n10);
                    int n17 = StyledPlayerControlViewLayoutManager.getWidthWithMargins(view3);
                    ((ArrayList)object2).add(view3);
                    if ((n16 -= n17) <= n15) break;
                }
                if ((n15 = (int)(((ArrayList)object2).isEmpty() ? 1 : 0)) == 0) {
                    object = this.basicControls;
                    n16 = ((ArrayList)object2).size();
                    object.removeViews(0, n16);
                    while (n14 < (n15 = ((ArrayList)object2).size())) {
                        object = this.extraControls;
                        n15 = object.getChildCount() - n13;
                        styledPlayerControlView = this.extraControls;
                        viewGroup = (View)((ArrayList)object2).get(n14);
                        styledPlayerControlView.addView((View)viewGroup, n15);
                        ++n14;
                    }
                }
            } else {
                object = this.extraControlsScrollView;
                if (object != null && (n15 = object.getVisibility()) == 0 && (n15 = (int)((object = this.overflowHideAnimator).isStarted() ? 1 : 0)) == 0) {
                    this.overflowShowAnimator.cancel();
                    object = this.overflowHideAnimator;
                    object.start();
                }
            }
        }
    }

    private void onOverflowButtonClick(View view) {
        this.resetHideCallbacks();
        int n10 = view.getId();
        int n11 = R$id.exo_overflow_show;
        if (n10 == n11) {
            view = this.overflowShowAnimator;
            view.start();
        } else {
            int n12 = view.getId();
            if (n12 == (n10 = R$id.exo_overflow_hide)) {
                view = this.overflowHideAnimator;
                view.start();
            }
        }
    }

    private void postDelayedRunnable(Runnable runnable, long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
            styledPlayerControlView.postDelayed(runnable, l10);
        }
    }

    public static /* synthetic */ void q(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        styledPlayerControlViewLayoutManager.showAllBars();
    }

    private void setUxState(int n10) {
        int n11 = this.uxState;
        this.uxState = n10;
        int n12 = 2;
        if (n10 == n12) {
            StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
            int n13 = 8;
            styledPlayerControlView.setVisibility(n13);
        } else if (n11 == n12) {
            StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
            boolean bl2 = false;
            styledPlayerControlView.setVisibility(0);
        }
        if (n11 != n10) {
            StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
            styledPlayerControlView.notifyOnVisibilityChange();
        }
    }

    private boolean shouldHideInMinimalMode(View view) {
        int n10;
        int n11 = view.getId();
        if (n11 != (n10 = R$id.exo_bottom_bar) && n11 != (n10 = R$id.exo_prev) && n11 != (n10 = R$id.exo_next) && n11 != (n10 = R$id.exo_rew) && n11 != (n10 = R$id.exo_rew_with_amount) && n11 != (n10 = R$id.exo_ffwd) && n11 != (n10 = R$id.exo_ffwd_with_amount)) {
            n11 = 0;
            view = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    private void showAllBars() {
        int n10 = this.animationEnabled;
        if (n10 == 0) {
            this.setUxState(0);
            this.resetHideCallbacks();
            return;
        }
        n10 = this.uxState;
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    n11 = 4;
                    if (n10 == n11) {
                        return;
                    }
                } else {
                    this.needToShowBars = n11;
                }
            } else {
                AnimatorSet animatorSet = this.showAllBarsAnimator;
                animatorSet.start();
            }
        } else {
            AnimatorSet animatorSet = this.showMainBarAnimator;
            animatorSet.start();
        }
        this.resetHideCallbacks();
    }

    private void updateLayoutForSizeChange() {
        int n10;
        Resources resources;
        int n11;
        Object object = this.minimalControls;
        int n12 = 4;
        if (object != null) {
            n11 = this.isMinimalMode;
            if (n11 != 0) {
                n11 = 0;
                resources = null;
            } else {
                n11 = n12;
            }
            object.setVisibility(n11);
        }
        if ((object = this.timeBar) != null) {
            object = (ViewGroup.MarginLayoutParams)object.getLayoutParams();
            resources = this.styledPlayerControlView.getResources();
            n10 = R$dimen.exo_styled_progress_margin_bottom;
            n11 = resources.getDimensionPixelSize(n10);
            n10 = (int)(this.isMinimalMode ? 1 : 0);
            if (n10 != 0) {
                n11 = 0;
                resources = null;
            }
            ((ViewGroup.MarginLayoutParams)object).bottomMargin = n11;
            resources = this.timeBar;
            resources.setLayoutParams((ViewGroup.LayoutParams)object);
            object = this.timeBar;
            n11 = object instanceof DefaultTimeBar;
            if (n11 != 0) {
                object = (DefaultTimeBar)object;
                n11 = (int)(this.isMinimalMode ? 1 : 0);
                n10 = 1;
                if (n11 != 0) {
                    ((DefaultTimeBar)object).hideScrubber(n10 != 0);
                } else {
                    n11 = this.uxState;
                    if (n11 == n10) {
                        ((DefaultTimeBar)object).hideScrubber(false);
                    } else {
                        n10 = 3;
                        if (n11 != n10 && n11 != n12) {
                            ((DefaultTimeBar)object).showScrubber();
                        }
                    }
                }
            }
        }
        object = this.shownButtons.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            resources = (View)object.next();
            n10 = (int)(this.isMinimalMode ? 1 : 0);
            n10 = n10 != 0 && (n10 = (int)(this.shouldHideInMinimalMode((View)resources) ? 1 : 0)) != 0 ? n12 : 0;
            resources.setVisibility(n10);
        }
    }

    private boolean useMinimalMode() {
        int n10;
        ViewGroup viewGroup;
        int n11;
        StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
        int n12 = styledPlayerControlView.getWidth();
        int n13 = this.styledPlayerControlView.getPaddingLeft();
        n12 -= n13;
        n13 = this.styledPlayerControlView.getPaddingRight();
        n12 -= n13;
        StyledPlayerControlView styledPlayerControlView2 = this.styledPlayerControlView;
        n13 = styledPlayerControlView2.getHeight();
        int n14 = this.styledPlayerControlView.getPaddingBottom();
        n13 -= n14;
        n14 = this.styledPlayerControlView.getPaddingTop();
        n13 -= n14;
        ViewGroup viewGroup2 = this.centerControls;
        n14 = StyledPlayerControlViewLayoutManager.getWidthWithMargins((View)viewGroup2);
        ViewGroup viewGroup3 = this.centerControls;
        boolean bl2 = false;
        if (viewGroup3 != null) {
            n11 = viewGroup3.getPaddingLeft();
            viewGroup = this.centerControls;
            n10 = viewGroup.getPaddingRight();
            n11 += n10;
        } else {
            n11 = 0;
            viewGroup3 = null;
        }
        n14 -= n11;
        n11 = StyledPlayerControlViewLayoutManager.getWidthWithMargins((View)this.timeView);
        n10 = StyledPlayerControlViewLayoutManager.getWidthWithMargins(this.overflowShowButton);
        n14 = Math.max(n14, n11 += n10);
        viewGroup3 = this.centerControls;
        n11 = StyledPlayerControlViewLayoutManager.getHeightWithMargins((View)viewGroup3);
        viewGroup = this.bottomBar;
        n10 = StyledPlayerControlViewLayoutManager.getHeightWithMargins((View)viewGroup) * 2;
        if (n12 <= n14 || n13 <= (n11 += n10)) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean getShowButton(View view) {
        List list;
        boolean bl2;
        if (view != null && (bl2 = (list = this.shownButtons).contains(view))) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void hide() {
        int n10 = this.uxState;
        int n11 = 3;
        if (n10 != n11 && n10 != (n11 = 2)) {
            this.removeHideCallbacks();
            n10 = (int)(this.animationEnabled ? 1 : 0);
            if (n10 == 0) {
                this.hideController();
            } else {
                n10 = this.uxState;
                n11 = 1;
                if (n10 == n11) {
                    this.hideProgressBar();
                } else {
                    this.hideAllBars();
                }
            }
        }
    }

    public void hideImmediately() {
        int n10 = this.uxState;
        int n11 = 3;
        if (n10 != n11 && n10 != (n11 = 2)) {
            this.removeHideCallbacks();
            this.hideController();
        }
    }

    public boolean isAnimationEnabled() {
        return this.animationEnabled;
    }

    public boolean isFullyVisible() {
        StyledPlayerControlView styledPlayerControlView;
        int n10 = this.uxState;
        if (!n10 && (n10 = (int)((styledPlayerControlView = this.styledPlayerControlView).isVisible() ? 1 : 0))) {
            n10 = 1;
        } else {
            n10 = 0;
            styledPlayerControlView = null;
        }
        return n10 != 0;
    }

    public /* synthetic */ void j(View view, ValueAnimator valueAnimator) {
        this.i(view, valueAnimator);
    }

    public /* synthetic */ void l(View view, ValueAnimator valueAnimator) {
        this.k(view, valueAnimator);
    }

    public /* synthetic */ void n(ValueAnimator valueAnimator) {
        this.m(valueAnimator);
    }

    public void onAttachedToWindow() {
        StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
        View.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
        styledPlayerControlView.addOnLayoutChangeListener(onLayoutChangeListener);
    }

    public void onDetachedFromWindow() {
        StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
        View.OnLayoutChangeListener onLayoutChangeListener = this.onLayoutChangeListener;
        styledPlayerControlView.removeOnLayoutChangeListener(onLayoutChangeListener);
    }

    public /* synthetic */ void p(ValueAnimator valueAnimator) {
        this.o(valueAnimator);
    }

    public void removeHideCallbacks() {
        StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
        Runnable runnable = this.hideControllerRunnable;
        styledPlayerControlView.removeCallbacks(runnable);
        styledPlayerControlView = this.styledPlayerControlView;
        runnable = this.hideAllBarsRunnable;
        styledPlayerControlView.removeCallbacks(runnable);
        styledPlayerControlView = this.styledPlayerControlView;
        runnable = this.hideMainBarRunnable;
        styledPlayerControlView.removeCallbacks(runnable);
        styledPlayerControlView = this.styledPlayerControlView;
        runnable = this.hideProgressBarRunnable;
        styledPlayerControlView.removeCallbacks(runnable);
    }

    public void resetHideCallbacks() {
        int n10 = this.uxState;
        int n11 = 3;
        if (n10 == n11) {
            return;
        }
        this.removeHideCallbacks();
        Object object = this.styledPlayerControlView;
        n10 = object.getShowTimeoutMs();
        if (n10 > 0) {
            n11 = (int)(this.animationEnabled ? 1 : 0);
            if (n11 == 0) {
                Runnable runnable = this.hideControllerRunnable;
                long l10 = n10;
                this.postDelayedRunnable(runnable, l10);
            } else {
                n11 = this.uxState;
                int n12 = 1;
                if (n11 == n12) {
                    object = this.hideProgressBarRunnable;
                    long l11 = 2000L;
                    this.postDelayedRunnable((Runnable)object, l11);
                } else {
                    Runnable runnable = this.hideMainBarRunnable;
                    long l12 = n10;
                    this.postDelayedRunnable(runnable, l12);
                }
            }
        }
    }

    public void setAnimationEnabled(boolean bl2) {
        this.animationEnabled = bl2;
    }

    public void setShowButton(View view, boolean bl2) {
        boolean bl3;
        if (view == null) {
            return;
        }
        if (!bl2) {
            view.setVisibility(8);
            this.shownButtons.remove(view);
            return;
        }
        boolean bl4 = this.isMinimalMode;
        if (bl4 && (bl3 = this.shouldHideInMinimalMode(view))) {
            int n10 = 4;
            view.setVisibility(n10);
        } else {
            boolean bl5 = false;
            view.setVisibility(0);
        }
        this.shownButtons.add(view);
    }

    public void show() {
        StyledPlayerControlView styledPlayerControlView = this.styledPlayerControlView;
        boolean bl2 = styledPlayerControlView.isVisible();
        if (!bl2) {
            this.styledPlayerControlView.setVisibility(0);
            this.styledPlayerControlView.updateAll();
            styledPlayerControlView = this.styledPlayerControlView;
            styledPlayerControlView.requestPlayPauseFocus();
        }
        this.showAllBars();
    }
}

