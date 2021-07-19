/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar$LayoutParams;
import androidx.appcompat.app.ActionBar$OnMenuVisibilityListener;
import androidx.appcompat.app.ActionBar$OnNavigationListener;
import androidx.appcompat.app.ActionBar$Tab;
import androidx.appcompat.app.NavItemSelectedListener;
import androidx.appcompat.app.WindowDecorActionBar$1;
import androidx.appcompat.app.WindowDecorActionBar$2;
import androidx.appcompat.app.WindowDecorActionBar$3;
import androidx.appcompat.app.WindowDecorActionBar$ActionModeImpl;
import androidx.appcompat.app.WindowDecorActionBar$TabImpl;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;

public class WindowDecorActionBar
extends ActionBar
implements ActionBarOverlayLayout$ActionBarVisibilityCallback {
    private static final long FADE_IN_DURATION_MS = 200L;
    private static final long FADE_OUT_DURATION_MS = 100L;
    private static final int INVALID_POSITION = 255;
    private static final String TAG = "WindowDecorActionBar";
    private static final Interpolator sHideInterpolator;
    private static final Interpolator sShowInterpolator;
    public WindowDecorActionBar$ActionModeImpl mActionMode;
    private Activity mActivity;
    public ActionBarContainer mContainerView;
    public boolean mContentAnimations;
    public View mContentView;
    public Context mContext;
    public ActionBarContextView mContextView;
    private int mCurWindowVisibility;
    public ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    public DecorToolbar mDecorToolbar;
    public ActionMode mDeferredDestroyActionMode;
    public ActionMode$Callback mDeferredModeDestroyCallback;
    private boolean mDisplayHomeAsUpSet;
    private boolean mHasEmbeddedTabs;
    public boolean mHiddenByApp;
    public boolean mHiddenBySystem;
    public final ViewPropertyAnimatorListener mHideListener;
    public boolean mHideOnContentScroll;
    private boolean mLastMenuVisibility;
    private ArrayList mMenuVisibilityListeners;
    private boolean mNowShowing;
    public ActionBarOverlayLayout mOverlayLayout;
    private int mSavedTabPosition;
    private WindowDecorActionBar$TabImpl mSelectedTab;
    private boolean mShowHideAnimationEnabled;
    public final ViewPropertyAnimatorListener mShowListener;
    private boolean mShowingForMode;
    public ScrollingTabContainerView mTabScrollView;
    private ArrayList mTabs;
    private Context mThemedContext;
    public final ViewPropertyAnimatorUpdateListener mUpdateListener;

    static {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        sHideInterpolator = accelerateInterpolator;
        accelerateInterpolator = new DecelerateInterpolator();
        sShowInterpolator = accelerateInterpolator;
    }

    public WindowDecorActionBar(Activity activity, boolean bl2) {
        boolean bl3;
        Object object = new ArrayList();
        this.mTabs = object;
        this.mSavedTabPosition = -1;
        object = new ArrayList();
        this.mMenuVisibilityListeners = object;
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = bl3 = true;
        this.mNowShowing = bl3;
        this.mHideListener = object = new WindowDecorActionBar$1(this);
        this.mShowListener = object = new WindowDecorActionBar$2(this);
        this.mUpdateListener = object = new WindowDecorActionBar$3(this);
        this.mActivity = activity;
        activity = activity.getWindow().getDecorView();
        this.init((View)activity);
        if (!bl2) {
            int n10 = 0x1020002;
            activity = activity.findViewById(n10);
            this.mContentView = activity;
        }
    }

    public WindowDecorActionBar(Dialog dialog) {
        boolean bl2;
        Object object = new ArrayList();
        this.mTabs = object;
        this.mSavedTabPosition = -1;
        object = new ArrayList();
        this.mMenuVisibilityListeners = object;
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = bl2 = true;
        this.mNowShowing = bl2;
        this.mHideListener = object = new WindowDecorActionBar$1(this);
        this.mShowListener = object = new WindowDecorActionBar$2(this);
        this.mUpdateListener = object = new WindowDecorActionBar$3(this);
        dialog = dialog.getWindow().getDecorView();
        this.init((View)dialog);
    }

    public WindowDecorActionBar(View view) {
        boolean bl2;
        Object object = new ArrayList();
        this.mTabs = object;
        this.mSavedTabPosition = -1;
        object = new ArrayList();
        this.mMenuVisibilityListeners = object;
        this.mCurWindowVisibility = 0;
        this.mContentAnimations = bl2 = true;
        this.mNowShowing = bl2;
        this.mHideListener = object = new WindowDecorActionBar$1(this);
        this.mShowListener = object = new WindowDecorActionBar$2(this);
        this.mUpdateListener = object = new WindowDecorActionBar$3(this);
        this.init(view);
    }

    public static boolean checkShowingFlags(boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5 = true;
        if (bl4) {
            return bl5;
        }
        if (!bl2 && !bl3) {
            return bl5;
        }
        return false;
    }

    private void cleanupTabs() {
        Object object = this.mSelectedTab;
        if (object != null) {
            object = null;
            this.selectTab(null);
        }
        this.mTabs.clear();
        object = this.mTabScrollView;
        if (object != null) {
            ((ScrollingTabContainerView)((Object)object)).removeAllTabs();
        }
        this.mSavedTabPosition = -1;
    }

    private void configureTab(ActionBar$Tab object, int n10) {
        Object object2 = ((WindowDecorActionBar$TabImpl)(object = (WindowDecorActionBar$TabImpl)object)).getCallback();
        if (object2 != null) {
            ((WindowDecorActionBar$TabImpl)object).setPosition(n10);
            object2 = this.mTabs;
            ((ArrayList)object2).add(n10, object);
            object = this.mTabs;
            int n11 = ((ArrayList)object).size();
            while (++n10 < n11) {
                object2 = (WindowDecorActionBar$TabImpl)this.mTabs.get(n10);
                ((WindowDecorActionBar$TabImpl)object2).setPosition(n10);
            }
            return;
        }
        object = new IllegalStateException("Action Bar Tab must have a Callback");
        throw object;
    }

    private void ensureTabsExist() {
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        if (scrollingTabContainerView != null) {
            return;
        }
        Object object = this.mContext;
        scrollingTabContainerView = new ScrollingTabContainerView((Context)object);
        int n10 = this.mHasEmbeddedTabs;
        if (n10 != 0) {
            scrollingTabContainerView.setVisibility(0);
            object = this.mDecorToolbar;
            object.setEmbeddedTabView(scrollingTabContainerView);
        } else {
            int n11;
            n10 = this.getNavigationMode();
            if (n10 == (n11 = 2)) {
                scrollingTabContainerView.setVisibility(0);
                object = this.mOverlayLayout;
                if (object != null) {
                    ViewCompat.requestApplyInsets((View)object);
                }
            } else {
                n10 = 8;
                scrollingTabContainerView.setVisibility(n10);
            }
            object = this.mContainerView;
            ((ActionBarContainer)((Object)object)).setTabContainer(scrollingTabContainerView);
        }
        this.mTabScrollView = scrollingTabContainerView;
    }

    private DecorToolbar getDecorToolbar(View object) {
        boolean bl2 = object instanceof DecorToolbar;
        if (bl2) {
            return (DecorToolbar)object;
        }
        bl2 = object instanceof Toolbar;
        if (bl2) {
            return ((Toolbar)((Object)object)).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Can't make a decor toolbar out of ";
        stringBuilder.append(string2);
        object = object != null ? object.getClass().getSimpleName() : "null";
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    private void hideForActionMode() {
        boolean bl2 = this.mShowingForMode;
        if (bl2) {
            bl2 = false;
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            this.updateVisibility(false);
        }
    }

    private void init(View object) {
        Object object2;
        int n10 = R$id.decor_content_parent;
        Object object3 = (ActionBarOverlayLayout)object.findViewById(n10);
        this.mOverlayLayout = object3;
        if (object3 != null) {
            ((ActionBarOverlayLayout)object3).setActionBarVisibilityCallback(this);
        }
        int n11 = R$id.action_bar;
        object3 = object.findViewById(n11);
        this.mDecorToolbar = object3 = this.getDecorToolbar((View)object3);
        int n12 = R$id.action_context_bar;
        object3 = (ActionBarContextView)object.findViewById(n12);
        this.mContextView = object3;
        int n13 = R$id.action_bar_container;
        object = (ActionBarContainer)object.findViewById(n13);
        this.mContainerView = object;
        object3 = this.mDecorToolbar;
        if (object3 != null && (object2 = this.mContextView) != null && object != null) {
            int n14;
            int n15;
            ActionBarPolicy actionBarPolicy;
            boolean bl2;
            object = object3.getContext();
            this.mContext = object;
            object = this.mDecorToolbar;
            boolean bl3 = object.getDisplayOptions() & 4;
            boolean bl4 = true;
            float f10 = Float.MIN_VALUE;
            object2 = null;
            if (bl3) {
                bl3 = bl4;
            } else {
                bl3 = false;
                object = null;
            }
            if (bl3) {
                this.mDisplayHomeAsUpSet = bl4;
            }
            if (!(bl2 = (actionBarPolicy = ActionBarPolicy.get(this.mContext)).enableHomeButtonByDefault()) && !bl3) {
                bl3 = false;
                object = null;
            } else {
                bl3 = bl4;
            }
            this.setHomeButtonEnabled(bl3);
            bl3 = actionBarPolicy.hasEmbeddedTabs();
            this.setHasEmbeddedTabs(bl3);
            object = this.mContext;
            actionBarPolicy = null;
            int[] nArray = R$styleable.ActionBar;
            int n16 = R$attr.actionBarStyle;
            object = object.obtainStyledAttributes(null, nArray, n16, 0);
            int n17 = R$styleable.ActionBar_hideOnContentScroll;
            n17 = (int)(object.getBoolean(n17, false) ? 1 : 0);
            if (n17 != 0) {
                this.setHideOnContentScrollEnabled(bl4);
            }
            if ((n15 = object.getDimensionPixelSize(n14 = R$styleable.ActionBar_elevation, 0)) != 0) {
                f10 = n15;
                this.setElevation(f10);
            }
            object.recycle();
            return;
        }
        object3 = new StringBuilder();
        object2 = this.getClass().getSimpleName();
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(" can only be used with a compatible window decor layout");
        object3 = ((StringBuilder)object3).toString();
        object = new IllegalStateException((String)object3);
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    private void setHasEmbeddedTabs(boolean bl2) {
        void var6_15;
        void var1_5;
        Object object;
        this.mHasEmbeddedTabs = bl2;
        boolean bl3 = false;
        Object object2 = null;
        if (!bl2) {
            this.mDecorToolbar.setEmbeddedTabView(null);
            object = this.mContainerView;
            object2 = this.mTabScrollView;
            ((ActionBarContainer)((Object)object)).setTabContainer((ScrollingTabContainerView)((Object)object2));
        } else {
            this.mContainerView.setTabContainer(null);
            object = this.mDecorToolbar;
            object2 = this.mTabScrollView;
            object.setEmbeddedTabView((ScrollingTabContainerView)((Object)object2));
        }
        int n10 = this.getNavigationMode();
        int n11 = 2;
        boolean bl4 = true;
        if (n10 == n11) {
            boolean bl5 = bl4;
        } else {
            boolean bl6 = false;
            object = null;
        }
        object2 = this.mTabScrollView;
        if (object2 != null) {
            if (var1_5 != false) {
                object2.setVisibility(0);
                object2 = this.mOverlayLayout;
                if (object2 != null) {
                    ViewCompat.requestApplyInsets((View)object2);
                }
            } else {
                int n12 = 8;
                object2.setVisibility(n12);
            }
        }
        object2 = this.mDecorToolbar;
        boolean bl7 = this.mHasEmbeddedTabs;
        if (!bl7 && var1_5 != false) {
            boolean bl8 = bl4;
        } else {
            boolean bl9 = false;
        }
        object2.setCollapsible((boolean)var6_15);
        object2 = this.mOverlayLayout;
        boolean bl10 = this.mHasEmbeddedTabs;
        if (bl10 || var1_5 == false) {
            bl4 = false;
        }
        ((ActionBarOverlayLayout)object2).setHasNonEmbeddedTabs(bl4);
    }

    private boolean shouldAnimateContextView() {
        return ViewCompat.isLaidOut((View)this.mContainerView);
    }

    private void showForActionMode() {
        boolean bl2 = this.mShowingForMode;
        if (!bl2) {
            this.mShowingForMode = bl2 = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(bl2);
            }
            bl2 = false;
            this.updateVisibility(false);
        }
    }

    private void updateVisibility(boolean bl2) {
        boolean bl3 = this.mHiddenByApp;
        boolean bl4 = this.mHiddenBySystem;
        boolean bl5 = this.mShowingForMode;
        if (bl3 = WindowDecorActionBar.checkShowingFlags(bl3, bl4, bl5)) {
            bl3 = this.mNowShowing;
            if (!bl3) {
                this.mNowShowing = bl3 = true;
                this.doShow(bl2);
            }
        } else {
            bl3 = this.mNowShowing;
            if (bl3) {
                bl3 = false;
                this.mNowShowing = false;
                this.doHide(bl2);
            }
        }
    }

    public void addOnMenuVisibilityListener(ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.add(actionBar$OnMenuVisibilityListener);
    }

    public void addTab(ActionBar$Tab actionBar$Tab) {
        boolean bl2 = this.mTabs.isEmpty();
        this.addTab(actionBar$Tab, bl2);
    }

    public void addTab(ActionBar$Tab actionBar$Tab, int n10) {
        boolean bl2 = this.mTabs.isEmpty();
        this.addTab(actionBar$Tab, n10, bl2);
    }

    public void addTab(ActionBar$Tab actionBar$Tab, int n10, boolean bl2) {
        this.ensureTabsExist();
        ScrollingTabContainerView scrollingTabContainerView = this.mTabScrollView;
        scrollingTabContainerView.addTab(actionBar$Tab, n10, bl2);
        this.configureTab(actionBar$Tab, n10);
        if (bl2) {
            this.selectTab(actionBar$Tab);
        }
    }

    public void addTab(ActionBar$Tab actionBar$Tab, boolean bl2) {
        this.ensureTabsExist();
        this.mTabScrollView.addTab(actionBar$Tab, bl2);
        ArrayList arrayList = this.mTabs;
        int n10 = arrayList.size();
        this.configureTab(actionBar$Tab, n10);
        if (bl2) {
            this.selectTab(actionBar$Tab);
        }
    }

    public void animateToMode(boolean bl2) {
        if (bl2) {
            this.showForActionMode();
        } else {
            this.hideForActionMode();
        }
        boolean bl3 = this.shouldAnimateContextView();
        int n10 = 4;
        int n11 = 8;
        if (bl3) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
            long l10 = 100;
            long l11 = 200L;
            if (bl2) {
                viewPropertyAnimatorCompat2 = this.mDecorToolbar.setupAnimatorToVisibility(n10, l10);
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(0, l11);
            } else {
                viewPropertyAnimatorCompat = this.mDecorToolbar.setupAnimatorToVisibility(0, l11);
                viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(n11, l10);
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            viewPropertyAnimatorCompatSet.playSequentially(viewPropertyAnimatorCompat2, viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
        } else if (bl2) {
            this.mDecorToolbar.setVisibility(n10);
            ActionBarContextView actionBarContextView = this.mContextView;
            actionBarContextView.setVisibility(0);
        } else {
            this.mDecorToolbar.setVisibility(0);
            ActionBarContextView actionBarContextView = this.mContextView;
            actionBarContextView.setVisibility(n11);
        }
    }

    public boolean collapseActionView() {
        boolean bl2;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null && (bl2 = decorToolbar.hasExpandedActionView())) {
            this.mDecorToolbar.collapseActionView();
            return true;
        }
        return false;
    }

    public void completeDeferredDestroyActionMode() {
        ActionMode$Callback actionMode$Callback = this.mDeferredModeDestroyCallback;
        if (actionMode$Callback != null) {
            ActionMode actionMode = this.mDeferredDestroyActionMode;
            actionMode$Callback.onDestroyActionMode(actionMode);
            actionMode$Callback = null;
            this.mDeferredDestroyActionMode = null;
            this.mDeferredModeDestroyCallback = null;
        }
    }

    public void dispatchMenuVisibilityChanged(boolean n10) {
        int n11 = this.mLastMenuVisibility;
        if (n10 == n11) {
            return;
        }
        this.mLastMenuVisibility = n10;
        ArrayList arrayList = this.mMenuVisibilityListeners;
        n11 = arrayList.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener = (ActionBar$OnMenuVisibilityListener)this.mMenuVisibilityListeners.get(i10);
            actionBar$OnMenuVisibilityListener.onMenuVisibilityChanged(n10 != 0);
        }
    }

    public void doHide(boolean object) {
        int n10;
        Object object2 = this.mCurrentShowAnim;
        if (object2 != null) {
            ((ViewPropertyAnimatorCompatSet)object2).cancel();
        }
        if ((n10 = this.mCurWindowVisibility) == 0 && ((n10 = (int)(this.mShowHideAnimationEnabled ? 1 : 0)) != 0 || object)) {
            Object object3;
            this.mContainerView.setAlpha(1.0f);
            object2 = this.mContainerView;
            int n11 = 1;
            ((ActionBarContainer)((Object)object2)).setTransitioning(n11 != 0);
            object2 = new ViewPropertyAnimatorCompatSet();
            ActionBarContainer actionBarContainer = this.mContainerView;
            int n12 = -actionBarContainer.getHeight();
            float f10 = n12;
            if (object) {
                object3 = new int[]{0, 0};
                ActionBarContainer actionBarContainer2 = this.mContainerView;
                actionBarContainer2.getLocationInWindow((int[])object3);
                object = object3[n11];
                float f11 = (float)object;
                f10 -= f11;
            }
            object3 = ViewCompat.animate((View)this.mContainerView).translationY(f10);
            ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener = this.mUpdateListener;
            object3.setUpdateListener(viewPropertyAnimatorUpdateListener);
            ((ViewPropertyAnimatorCompatSet)object2).play((ViewPropertyAnimatorCompat)object3);
            object = this.mContentAnimations;
            if (object && (object3 = this.mContentView) != null) {
                object3 = ViewCompat.animate((View)object3).translationY(f10);
                ((ViewPropertyAnimatorCompatSet)object2).play((ViewPropertyAnimatorCompat)object3);
            }
            object3 = sHideInterpolator;
            ((ViewPropertyAnimatorCompatSet)object2).setInterpolator((Interpolator)object3);
            long l10 = 250L;
            ((ViewPropertyAnimatorCompatSet)object2).setDuration(l10);
            object3 = this.mHideListener;
            ((ViewPropertyAnimatorCompatSet)object2).setListener((ViewPropertyAnimatorListener)object3);
            this.mCurrentShowAnim = object2;
            ((ViewPropertyAnimatorCompatSet)object2).start();
        } else {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = this.mHideListener;
            n10 = 0;
            object2 = null;
            viewPropertyAnimatorListener.onAnimationEnd(null);
        }
    }

    public void doShow(boolean object) {
        Object object2;
        Object object3 = this.mCurrentShowAnim;
        if (object3 != null) {
            object3.cancel();
        }
        object3 = this.mContainerView;
        ((ActionBarContainer)((Object)object3)).setVisibility(0);
        int n10 = this.mCurWindowVisibility;
        if (n10 == 0 && ((n10 = (int)(this.mShowHideAnimationEnabled ? 1 : 0)) != 0 || object)) {
            int n11;
            Object object4;
            this.mContainerView.setTranslationY(0.0f);
            object3 = this.mContainerView;
            n10 = -object3.getHeight();
            float f10 = n10;
            if (object) {
                object2 = new int[2];
                Object object5 = object2;
                object5[0] = (ActionBarContainer)false;
                object5[1] = (ActionBarContainer)false;
                object4 = this.mContainerView;
                object4.getLocationInWindow((int[])object2);
                n11 = 1;
                object = object2[n11];
                float f11 = (float)object;
                f10 -= f11;
            }
            this.mContainerView.setTranslationY(f10);
            object2 = new ViewPropertyAnimatorCompatSet();
            object4 = ViewCompat.animate((View)this.mContainerView).translationY(0.0f);
            ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener = this.mUpdateListener;
            ((ViewPropertyAnimatorCompat)object4).setUpdateListener(viewPropertyAnimatorUpdateListener);
            ((ViewPropertyAnimatorCompatSet)object2).play((ViewPropertyAnimatorCompat)object4);
            n11 = (int)(this.mContentAnimations ? 1 : 0);
            if (n11 != 0 && (object4 = this.mContentView) != null) {
                object4.setTranslationY(f10);
                object3 = ViewCompat.animate(this.mContentView).translationY(0.0f);
                ((ViewPropertyAnimatorCompatSet)object2).play((ViewPropertyAnimatorCompat)object3);
            }
            object3 = sShowInterpolator;
            ((ViewPropertyAnimatorCompatSet)object2).setInterpolator((Interpolator)object3);
            long l10 = 250L;
            ((ViewPropertyAnimatorCompatSet)object2).setDuration(l10);
            object3 = this.mShowListener;
            ((ViewPropertyAnimatorCompatSet)object2).setListener((ViewPropertyAnimatorListener)object3);
            this.mCurrentShowAnim = object2;
            ((ViewPropertyAnimatorCompatSet)object2).start();
        } else {
            object2 = this.mContainerView;
            n10 = 1065353216;
            float f12 = 1.0f;
            object2.setAlpha(f12);
            object2 = this.mContainerView;
            object2.setTranslationY(0.0f);
            object = this.mContentAnimations;
            if (object && (object2 = this.mContentView) != null) {
                object2.setTranslationY(0.0f);
            }
            object2 = this.mShowListener;
            n10 = 0;
            f12 = 0.0f;
            object3 = null;
            object2.onAnimationEnd(null);
        }
        object2 = this.mOverlayLayout;
        if (object2 != null) {
            ViewCompat.requestApplyInsets((View)object2);
        }
    }

    public void enableContentAnimations(boolean bl2) {
        this.mContentAnimations = bl2;
    }

    public View getCustomView() {
        return this.mDecorToolbar.getCustomView();
    }

    public int getDisplayOptions() {
        return this.mDecorToolbar.getDisplayOptions();
    }

    public float getElevation() {
        return ViewCompat.getElevation((View)this.mContainerView);
    }

    public int getHeight() {
        return this.mContainerView.getHeight();
    }

    public int getHideOffset() {
        return this.mOverlayLayout.getActionBarHideOffset();
    }

    public int getNavigationItemCount() {
        int n10;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        int n11 = decorToolbar.getNavigationMode();
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                return 0;
            }
            return this.mTabs.size();
        }
        return this.mDecorToolbar.getDropdownItemCount();
    }

    public int getNavigationMode() {
        return this.mDecorToolbar.getNavigationMode();
    }

    public int getSelectedNavigationIndex() {
        int n10;
        Object object = this.mDecorToolbar;
        int n11 = object.getNavigationMode();
        if (n11 != (n10 = 1)) {
            n10 = 2;
            int n12 = -1;
            if (n11 != n10) {
                return n12;
            }
            object = this.mSelectedTab;
            if (object != null) {
                n12 = ((WindowDecorActionBar$TabImpl)object).getPosition();
            }
            return n12;
        }
        return this.mDecorToolbar.getDropdownSelectedPosition();
    }

    public ActionBar$Tab getSelectedTab() {
        return this.mSelectedTab;
    }

    public CharSequence getSubtitle() {
        return this.mDecorToolbar.getSubtitle();
    }

    public ActionBar$Tab getTabAt(int n10) {
        return (ActionBar$Tab)this.mTabs.get(n10);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public Context getThemedContext() {
        Context context = this.mThemedContext;
        if (context == null) {
            context = new TypedValue();
            Resources.Theme theme = this.mContext.getTheme();
            int n10 = R$attr.actionBarWidgetTheme;
            boolean bl2 = true;
            theme.resolveAttribute(n10, (TypedValue)context, bl2);
            int n11 = context.resourceId;
            if (n11 != 0) {
                Context context2 = this.mContext;
                theme = new ContextThemeWrapper(context2, n11);
                this.mThemedContext = theme;
            } else {
                this.mThemedContext = context = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public CharSequence getTitle() {
        return this.mDecorToolbar.getTitle();
    }

    public boolean hasIcon() {
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        return this.mDecorToolbar.hasLogo();
    }

    public void hide() {
        boolean bl2 = this.mHiddenByApp;
        if (!bl2) {
            this.mHiddenByApp = true;
            bl2 = false;
            this.updateVisibility(false);
        }
    }

    public void hideForSystem() {
        boolean bl2 = this.mHiddenBySystem;
        if (!bl2) {
            this.mHiddenBySystem = bl2 = true;
            this.updateVisibility(bl2);
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mOverlayLayout.isHideOnContentScrollEnabled();
    }

    public boolean isShowing() {
        int n10 = this.getHeight();
        int n11 = this.mNowShowing;
        n10 = n11 != 0 && (n10 == 0 || (n11 = this.getHideOffset()) < n10) ? 1 : 0;
        return n10 != 0;
    }

    public boolean isTitleTruncated() {
        boolean bl2;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar != null && (bl2 = decorToolbar.isTitleTruncated())) {
            bl2 = true;
        } else {
            bl2 = false;
            decorToolbar = null;
        }
        return bl2;
    }

    public ActionBar$Tab newTab() {
        WindowDecorActionBar$TabImpl windowDecorActionBar$TabImpl = new WindowDecorActionBar$TabImpl(this);
        return windowDecorActionBar$TabImpl;
    }

    public void onConfigurationChanged(Configuration configuration) {
        boolean bl2 = ActionBarPolicy.get(this.mContext).hasEmbeddedTabs();
        this.setHasEmbeddedTabs(bl2);
    }

    public void onContentScrollStarted() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.cancel();
            viewPropertyAnimatorCompatSet = null;
            this.mCurrentShowAnim = null;
        }
    }

    public void onContentScrollStopped() {
    }

    /*
     * WARNING - void declaration
     */
    public boolean onKeyShortcut(int n10, KeyEvent keyEvent) {
        WindowDecorActionBar$ActionModeImpl windowDecorActionBar$ActionModeImpl = this.mActionMode;
        if (windowDecorActionBar$ActionModeImpl == null) {
            return false;
        }
        if ((windowDecorActionBar$ActionModeImpl = windowDecorActionBar$ActionModeImpl.getMenu()) != null) {
            void var4_6;
            if (keyEvent != null) {
                int bl3 = keyEvent.getDeviceId();
            } else {
                int n11 = -1;
            }
            KeyCharacterMap keyCharacterMap = KeyCharacterMap.load((int)var4_6);
            boolean bl2 = keyCharacterMap.getKeyboardType();
            boolean bl3 = true;
            if (bl2 == bl3) {
                bl3 = false;
            }
            windowDecorActionBar$ActionModeImpl.setQwertyMode(bl3);
            return windowDecorActionBar$ActionModeImpl.performShortcut(n10, keyEvent, 0);
        }
        return false;
    }

    public void onWindowVisibilityChanged(int n10) {
        this.mCurWindowVisibility = n10;
    }

    public void removeAllTabs() {
        this.cleanupTabs();
    }

    public void removeOnMenuVisibilityListener(ActionBar$OnMenuVisibilityListener actionBar$OnMenuVisibilityListener) {
        this.mMenuVisibilityListeners.remove(actionBar$OnMenuVisibilityListener);
    }

    public void removeTab(ActionBar$Tab actionBar$Tab) {
        int n10 = actionBar$Tab.getPosition();
        this.removeTabAt(n10);
    }

    public void removeTabAt(int n10) {
        int n11;
        Object object = this.mTabScrollView;
        if (object == null) {
            return;
        }
        object = this.mSelectedTab;
        int n12 = object != null ? ((WindowDecorActionBar$TabImpl)object).getPosition() : this.mSavedTabPosition;
        this.mTabScrollView.removeTabAt(n10);
        Object object2 = (WindowDecorActionBar$TabImpl)this.mTabs.remove(n10);
        if (object2 != null) {
            n11 = -1;
            ((WindowDecorActionBar$TabImpl)object2).setPosition(n11);
        }
        object2 = this.mTabs;
        int n13 = ((ArrayList)object2).size();
        for (n11 = n10; n11 < n13; ++n11) {
            WindowDecorActionBar$TabImpl windowDecorActionBar$TabImpl = (WindowDecorActionBar$TabImpl)this.mTabs.get(n11);
            windowDecorActionBar$TabImpl.setPosition(n11);
        }
        if (n12 == n10) {
            WindowDecorActionBar$TabImpl windowDecorActionBar$TabImpl;
            object = this.mTabs;
            n12 = (int)(((ArrayList)object).isEmpty() ? 1 : 0);
            if (n12 != 0) {
                n10 = 0;
                windowDecorActionBar$TabImpl = null;
            } else {
                object = this.mTabs;
                n13 = 0;
                object2 = null;
                n10 += -1;
                n10 = Math.max(0, n10);
                windowDecorActionBar$TabImpl = (WindowDecorActionBar$TabImpl)((ArrayList)object).get(n10);
            }
            this.selectTab(windowDecorActionBar$TabImpl);
        }
    }

    public boolean requestFocus() {
        boolean bl2;
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        if (viewGroup != null && !(bl2 = viewGroup.hasFocus())) {
            viewGroup.requestFocus();
            return true;
        }
        return false;
    }

    public void selectTab(ActionBar$Tab object) {
        int n10;
        int n11 = this.getNavigationMode();
        int n12 = -1;
        int n13 = 2;
        if (n11 != n13) {
            if (object != null) {
                n12 = ((ActionBar$Tab)object).getPosition();
            }
            this.mSavedTabPosition = n12;
            return;
        }
        Object object2 = this.mActivity;
        n11 = object2 instanceof FragmentActivity;
        if (n11 != 0 && (n11 = (int)((object2 = this.mDecorToolbar.getViewGroup()).isInEditMode() ? 1 : 0)) == 0) {
            object2 = ((FragmentActivity)this.mActivity).getSupportFragmentManager().beginTransaction().disallowAddToBackStack();
        } else {
            n11 = 0;
            object2 = null;
        }
        Object object3 = this.mSelectedTab;
        if (object3 == object) {
            if (object3 != null) {
                Object object4 = ((WindowDecorActionBar$TabImpl)object3).getCallback();
                object3 = this.mSelectedTab;
                object4.onTabReselected((ActionBar$Tab)object3, (FragmentTransaction)object2);
                object4 = this.mTabScrollView;
                n10 = ((ActionBar$Tab)object).getPosition();
                ((ScrollingTabContainerView)((Object)object4)).animateToTab(n10);
            }
        } else {
            object3 = this.mTabScrollView;
            if (object != null) {
                n12 = ((ActionBar$Tab)object).getPosition();
            }
            ((ScrollingTabContainerView)((Object)object3)).setTabSelected(n12);
            Object object5 = this.mSelectedTab;
            if (object5 != null) {
                object5 = ((WindowDecorActionBar$TabImpl)object5).getCallback();
                object3 = this.mSelectedTab;
                object5.onTabUnselected((ActionBar$Tab)object3, (FragmentTransaction)object2);
            }
            object = (WindowDecorActionBar$TabImpl)object;
            this.mSelectedTab = object;
            if (object != null) {
                object = ((WindowDecorActionBar$TabImpl)object).getCallback();
                object5 = this.mSelectedTab;
                object.onTabSelected((ActionBar$Tab)object5, (FragmentTransaction)object2);
            }
        }
        if (object2 != null && (n10 = ((FragmentTransaction)object2).isEmpty()) == 0) {
            ((FragmentTransaction)object2).commit();
        }
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        this.mContainerView.setPrimaryBackground(drawable2);
    }

    public void setCustomView(int n10) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.getThemedContext());
        ViewGroup viewGroup = this.mDecorToolbar.getViewGroup();
        View view = layoutInflater.inflate(n10, viewGroup, false);
        this.setCustomView(view);
    }

    public void setCustomView(View view) {
        this.mDecorToolbar.setCustomView(view);
    }

    public void setCustomView(View view, ActionBar$LayoutParams actionBar$LayoutParams) {
        view.setLayoutParams((ViewGroup.LayoutParams)actionBar$LayoutParams);
        this.mDecorToolbar.setCustomView(view);
    }

    public void setDefaultDisplayHomeAsUpEnabled(boolean bl2) {
        boolean bl3 = this.mDisplayHomeAsUpSet;
        if (!bl3) {
            this.setDisplayHomeAsUpEnabled(bl2);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void setDisplayHomeAsUpEnabled(boolean bl2) {
        void var1_4;
        int n10 = 4;
        if (bl2) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
        }
        this.setDisplayOptions((int)var1_4, n10);
    }

    public void setDisplayOptions(int n10) {
        int n11 = n10 & 4;
        if (n11 != 0) {
            n11 = 1;
            this.mDisplayHomeAsUpSet = n11;
        }
        this.mDecorToolbar.setDisplayOptions(n10);
    }

    public void setDisplayOptions(int n10, int n11) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        int n12 = decorToolbar.getDisplayOptions();
        int n13 = n11 & 4;
        if (n13 != 0) {
            n13 = 1;
            this.mDisplayHomeAsUpSet = n13;
        }
        DecorToolbar decorToolbar2 = this.mDecorToolbar;
        n10 &= n11;
        n11 = ~n11 & n12;
        decorToolbar2.setDisplayOptions(n10 |= n11);
    }

    /*
     * WARNING - void declaration
     */
    public void setDisplayShowCustomEnabled(boolean bl2) {
        void var1_4;
        int n10 = 16;
        if (bl2) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
        }
        this.setDisplayOptions((int)var1_4, n10);
    }

    /*
     * WARNING - void declaration
     */
    public void setDisplayShowHomeEnabled(boolean bl2) {
        void var1_4;
        int n10 = 2;
        if (bl2) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
        }
        this.setDisplayOptions((int)var1_4, n10);
    }

    /*
     * WARNING - void declaration
     */
    public void setDisplayShowTitleEnabled(boolean bl2) {
        void var1_4;
        int n10 = 8;
        if (bl2) {
            int n11 = n10;
        } else {
            boolean bl3 = false;
        }
        this.setDisplayOptions((int)var1_4, n10);
    }

    public void setDisplayUseLogoEnabled(boolean bl2) {
        this.setDisplayOptions((int)(bl2 ? 1 : 0), 1);
    }

    public void setElevation(float f10) {
        ViewCompat.setElevation((View)this.mContainerView, f10);
    }

    public void setHideOffset(int n10) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        boolean bl2;
        if (n10 != 0 && !(bl2 = (actionBarOverlayLayout = this.mOverlayLayout).isInOverlayMode())) {
            IllegalStateException illegalStateException = new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to set a non-zero hide offset");
            throw illegalStateException;
        }
        this.mOverlayLayout.setActionBarHideOffset(n10);
    }

    public void setHideOnContentScrollEnabled(boolean bl2) {
        ActionBarOverlayLayout actionBarOverlayLayout;
        boolean bl3;
        if (bl2 && !(bl3 = (actionBarOverlayLayout = this.mOverlayLayout).isInOverlayMode())) {
            IllegalStateException illegalStateException = new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            throw illegalStateException;
        }
        this.mHideOnContentScroll = bl2;
        this.mOverlayLayout.setHideOnContentScrollEnabled(bl2);
    }

    public void setHomeActionContentDescription(int n10) {
        this.mDecorToolbar.setNavigationContentDescription(n10);
    }

    public void setHomeActionContentDescription(CharSequence charSequence) {
        this.mDecorToolbar.setNavigationContentDescription(charSequence);
    }

    public void setHomeAsUpIndicator(int n10) {
        this.mDecorToolbar.setNavigationIcon(n10);
    }

    public void setHomeAsUpIndicator(Drawable drawable2) {
        this.mDecorToolbar.setNavigationIcon(drawable2);
    }

    public void setHomeButtonEnabled(boolean bl2) {
        this.mDecorToolbar.setHomeButtonEnabled(bl2);
    }

    public void setIcon(int n10) {
        this.mDecorToolbar.setIcon(n10);
    }

    public void setIcon(Drawable drawable2) {
        this.mDecorToolbar.setIcon(drawable2);
    }

    public void setListNavigationCallbacks(SpinnerAdapter spinnerAdapter, ActionBar$OnNavigationListener actionBar$OnNavigationListener) {
        DecorToolbar decorToolbar = this.mDecorToolbar;
        NavItemSelectedListener navItemSelectedListener = new NavItemSelectedListener(actionBar$OnNavigationListener);
        decorToolbar.setDropdownParams(spinnerAdapter, navItemSelectedListener);
    }

    public void setLogo(int n10) {
        this.mDecorToolbar.setLogo(n10);
    }

    public void setLogo(Drawable drawable2) {
        this.mDecorToolbar.setLogo(drawable2);
    }

    public void setNavigationMode(int n10) {
        int n11;
        int n12;
        Object object;
        int n13;
        int n14;
        Object object2 = this.mDecorToolbar;
        int n15 = object2.getNavigationMode();
        if (n15 == (n14 = 2)) {
            this.mSavedTabPosition = n13 = this.getSelectedNavigationIndex();
            n13 = 0;
            this.selectTab(null);
            object = this.mTabScrollView;
            n12 = 8;
            object.setVisibility(n12);
        }
        if (n15 != n10 && (n15 = (int)(this.mHasEmbeddedTabs ? 1 : 0)) == 0 && (object2 = this.mOverlayLayout) != null) {
            ViewCompat.requestApplyInsets((View)object2);
        }
        this.mDecorToolbar.setNavigationMode(n10);
        n15 = 0;
        object2 = null;
        if (n10 == n14) {
            this.ensureTabsExist();
            object = this.mTabScrollView;
            object.setVisibility(0);
            n13 = this.mSavedTabPosition;
            n12 = -1;
            if (n13 != n12) {
                this.setSelectedNavigationItem(n13);
                this.mSavedTabPosition = n12;
            }
        }
        object = this.mDecorToolbar;
        n12 = 1;
        n11 = n10 == n14 && (n11 = this.mHasEmbeddedTabs) == 0 ? n12 : 0;
        object.setCollapsible(n11 != 0);
        object = this.mOverlayLayout;
        if (n10 == n14 && (n10 = (int)(this.mHasEmbeddedTabs ? 1 : 0)) == 0) {
            n15 = n12;
        }
        ((ActionBarOverlayLayout)object).setHasNonEmbeddedTabs(n15 != 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setSelectedNavigationItem(int n10) {
        int n11;
        Object object = this.mDecorToolbar;
        int n12 = object.getNavigationMode();
        if (n12 == (n11 = 1)) {
            object = this.mDecorToolbar;
            object.setDropdownSelectedPosition(n10);
            return;
        }
        n11 = 2;
        if (n12 == n11) {
            object = this.mTabs;
            ActionBar$Tab actionBar$Tab = (ActionBar$Tab)((ArrayList)object).get(n10);
            this.selectTab(actionBar$Tab);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("setSelectedNavigationIndex not valid for current navigation mode");
        throw illegalStateException;
    }

    public void setShowHideAnimationEnabled(boolean bl2) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = bl2;
        if (!bl2 && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    public void setSplitBackgroundDrawable(Drawable drawable2) {
    }

    public void setStackedBackgroundDrawable(Drawable drawable2) {
        this.mContainerView.setStackedBackground(drawable2);
    }

    public void setSubtitle(int n10) {
        String string2 = this.mContext.getString(n10);
        this.setSubtitle(string2);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mDecorToolbar.setSubtitle(charSequence);
    }

    public void setTitle(int n10) {
        String string2 = this.mContext.getString(n10);
        this.setTitle(string2);
    }

    public void setTitle(CharSequence charSequence) {
        this.mDecorToolbar.setTitle(charSequence);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public void show() {
        boolean bl2 = this.mHiddenByApp;
        if (bl2) {
            bl2 = false;
            this.mHiddenByApp = false;
            this.updateVisibility(false);
        }
    }

    public void showForSystem() {
        boolean bl2 = this.mHiddenBySystem;
        if (bl2) {
            this.mHiddenBySystem = false;
            bl2 = true;
            this.updateVisibility(bl2);
        }
    }

    public ActionMode startActionMode(ActionMode$Callback actionMode$Callback) {
        WindowDecorActionBar$ActionModeImpl windowDecorActionBar$ActionModeImpl = this.mActionMode;
        if (windowDecorActionBar$ActionModeImpl != null) {
            windowDecorActionBar$ActionModeImpl.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        Context context = this.mContextView.getContext();
        windowDecorActionBar$ActionModeImpl = new WindowDecorActionBar$ActionModeImpl(this, context, actionMode$Callback);
        boolean bl2 = windowDecorActionBar$ActionModeImpl.dispatchOnCreate();
        if (bl2) {
            this.mActionMode = windowDecorActionBar$ActionModeImpl;
            windowDecorActionBar$ActionModeImpl.invalidate();
            this.mContextView.initForMode(windowDecorActionBar$ActionModeImpl);
            this.animateToMode(true);
            this.mContextView.sendAccessibilityEvent(32);
            return windowDecorActionBar$ActionModeImpl;
        }
        return null;
    }
}

