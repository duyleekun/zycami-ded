/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.Menu
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window$Callback
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar$LayoutParams;
import androidx.appcompat.widget.ToolbarWidgetWrapper$1;
import androidx.appcompat.widget.ToolbarWidgetWrapper$2;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

public class ToolbarWidgetWrapper
implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200L;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    public boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    public CharSequence mTitle;
    private boolean mTitleSet;
    public Toolbar mToolbar;
    public Window.Callback mWindowCallback;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean bl2) {
        int n10 = R$string.abc_action_bar_up_description;
        int n11 = R$drawable.abc_ic_ab_back_material;
        this(toolbar, bl2, n10, n11);
    }

    public ToolbarWidgetWrapper(Toolbar object, boolean n10, int n11, int n12) {
        Object object2;
        int n13;
        Toolbar toolbar = null;
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = object;
        Object object3 = ((Toolbar)((Object)object)).getTitle();
        this.mTitle = object3;
        object3 = ((Toolbar)((Object)object)).getSubtitle();
        this.mSubtitle = object3;
        object3 = this.mTitle;
        if (object3 != null) {
            n13 = 1;
        } else {
            n13 = 0;
            object3 = null;
        }
        this.mTitleSet = n13;
        object3 = ((Toolbar)((Object)object)).getNavigationIcon();
        this.mNavIcon = object3;
        object = object.getContext();
        Object object4 = R$styleable.ActionBar;
        int n14 = R$attr.actionBarStyle;
        object = TintTypedArray.obtainStyledAttributes((Context)object, null, (int[])object4, n14, 0);
        n13 = R$styleable.ActionBar_homeAsUpIndicator;
        object3 = ((TintTypedArray)object).getDrawable(n13);
        this.mDefaultNavigationIcon = object3;
        if (n10 != 0) {
            n10 = R$styleable.ActionBar_title;
            object2 = ((TintTypedArray)object).getText(n10);
            n13 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
            if (n13 == 0) {
                this.setTitle((CharSequence)object2);
            }
            if ((n13 = (int)(TextUtils.isEmpty((CharSequence)(object2 = ((TintTypedArray)object).getText(n10 = R$styleable.ActionBar_subtitle))) ? 1 : 0)) == 0) {
                this.setSubtitle((CharSequence)object2);
            }
            if ((object2 = ((TintTypedArray)object).getDrawable(n10 = R$styleable.ActionBar_logo)) != null) {
                this.setLogo((Drawable)object2);
            }
            if ((object2 = ((TintTypedArray)object).getDrawable(n10 = R$styleable.ActionBar_icon)) != null) {
                this.setIcon((Drawable)object2);
            }
            if ((object2 = this.mNavIcon) == null && (object2 = this.mDefaultNavigationIcon) != null) {
                this.setNavigationIcon((Drawable)object2);
            }
            n10 = R$styleable.ActionBar_displayOptions;
            n10 = ((TintTypedArray)object).getInt(n10, 0);
            this.setDisplayOptions(n10);
            n10 = R$styleable.ActionBar_customNavigationLayout;
            n10 = ((TintTypedArray)object).getResourceId(n10, 0);
            if (n10 != 0) {
                object3 = LayoutInflater.from((Context)this.mToolbar.getContext());
                object4 = (Object)this.mToolbar;
                object2 = object3.inflate(n10, (ViewGroup)object4, false);
                this.setCustomView((View)object2);
                n10 = this.mDisplayOpts | 0x10;
                this.setDisplayOptions(n10);
            }
            n10 = R$styleable.ActionBar_height;
            if ((n10 = ((TintTypedArray)object).getLayoutDimension(n10, 0)) > 0) {
                object3 = this.mToolbar.getLayoutParams();
                ((ViewGroup.LayoutParams)object3).height = n10;
                object2 = this.mToolbar;
                object2.setLayoutParams((ViewGroup.LayoutParams)object3);
            }
            n10 = R$styleable.ActionBar_contentInsetStart;
            n13 = -1;
            n10 = ((TintTypedArray)object).getDimensionPixelOffset(n10, n13);
            int n15 = R$styleable.ActionBar_contentInsetEnd;
            n13 = ((TintTypedArray)object).getDimensionPixelOffset(n15, n13);
            if (n10 >= 0 || n13 >= 0) {
                object4 = (Object)this.mToolbar;
                n10 = Math.max(n10, 0);
                n13 = Math.max(n13, 0);
                ((Toolbar)((Object)object4)).setContentInsetsRelative(n10, n13);
            }
            n10 = R$styleable.ActionBar_titleTextStyle;
            if ((n10 = ((TintTypedArray)object).getResourceId(n10, 0)) != 0) {
                object3 = this.mToolbar;
                object4 = object3.getContext();
                ((Toolbar)((Object)object3)).setTitleTextAppearance((Context)object4, n10);
            }
            n10 = R$styleable.ActionBar_subtitleTextStyle;
            if ((n10 = ((TintTypedArray)object).getResourceId(n10, 0)) != 0) {
                object3 = this.mToolbar;
                object4 = object3.getContext();
                ((Toolbar)((Object)object3)).setSubtitleTextAppearance((Context)object4, n10);
            }
            n10 = R$styleable.ActionBar_popupTheme;
            if ((n10 = ((TintTypedArray)object).getResourceId(n10, 0)) != 0) {
                toolbar = this.mToolbar;
                toolbar.setPopupTheme(n10);
            }
        } else {
            n10 = this.detectDisplayOptions();
            this.mDisplayOpts = n10;
        }
        ((TintTypedArray)object).recycle();
        this.setDefaultNavigationContentDescription(n11);
        this.mHomeDescription = object = this.mToolbar.getNavigationContentDescription();
        object = this.mToolbar;
        object2 = new ToolbarWidgetWrapper$1(this);
        ((Toolbar)((Object)object)).setNavigationOnClickListener((View.OnClickListener)object2);
    }

    private int detectDisplayOptions() {
        int n10;
        Drawable drawable2 = this.mToolbar.getNavigationIcon();
        if (drawable2 != null) {
            Drawable drawable3;
            n10 = 15;
            this.mDefaultNavigationIcon = drawable3 = this.mToolbar.getNavigationIcon();
        } else {
            n10 = 11;
        }
        return n10;
    }

    private void ensureSpinner() {
        Object object = this.mSpinner;
        if (object == null) {
            Context context = this.getContext();
            int n10 = R$attr.actionDropDownStyle;
            this.mSpinner = object = new AppCompatSpinner(context, null, n10);
            int n11 = 8388627;
            int n12 = -2;
            object = new Toolbar$LayoutParams(n12, n12, n11);
            context = this.mSpinner;
            context.setLayoutParams((ViewGroup.LayoutParams)object);
        }
    }

    private void setTitleInt(CharSequence charSequence) {
        this.mTitle = charSequence;
        int n10 = this.mDisplayOpts & 8;
        if (n10 != 0) {
            Toolbar toolbar = this.mToolbar;
            toolbar.setTitle(charSequence);
        }
    }

    private void updateHomeAccessibility() {
        int n10 = this.mDisplayOpts & 4;
        if (n10 != 0) {
            Object object = this.mHomeDescription;
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 != 0) {
                object = this.mToolbar;
                int n11 = this.mDefaultNavigationContentDescription;
                ((Toolbar)((Object)object)).setNavigationContentDescription(n11);
            } else {
                object = this.mToolbar;
                CharSequence charSequence = this.mHomeDescription;
                ((Toolbar)((Object)object)).setNavigationContentDescription(charSequence);
            }
        }
    }

    private void updateNavigationIcon() {
        int n10 = this.mDisplayOpts & 4;
        if (n10 != 0) {
            Toolbar toolbar = this.mToolbar;
            Drawable drawable2 = this.mNavIcon;
            if (drawable2 == null) {
                drawable2 = this.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable2);
        } else {
            Toolbar toolbar = this.mToolbar;
            Object var3_5 = null;
            toolbar.setNavigationIcon(null);
        }
    }

    private void updateToolbarLogo() {
        Drawable drawable2;
        int n10 = this.mDisplayOpts;
        int n11 = n10 & 2;
        if (n11 != 0) {
            if ((n10 &= 1) != 0) {
                drawable2 = this.mLogo;
                if (drawable2 == null) {
                    drawable2 = this.mIcon;
                }
            } else {
                drawable2 = this.mIcon;
            }
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.mToolbar.setLogo(drawable2);
    }

    public void animateToVisibility(int n10) {
        long l10 = 200L;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.setupAnimatorToVisibility(n10, l10);
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.start();
        }
    }

    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    public Context getContext() {
        return this.mToolbar.getContext();
    }

    public View getCustomView() {
        return this.mCustomView;
    }

    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    public int getDropdownItemCount() {
        int n10;
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            n10 = spinner.getCount();
        } else {
            n10 = 0;
            spinner = null;
        }
        return n10;
    }

    public int getDropdownSelectedPosition() {
        int n10;
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            n10 = spinner.getSelectedItemPosition();
        } else {
            n10 = 0;
            spinner = null;
        }
        return n10;
    }

    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    public boolean hasEmbeddedTabs() {
        boolean bl2;
        View view = this.mTabView;
        if (view != null) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    public boolean hasIcon() {
        boolean bl2;
        Drawable drawable2 = this.mIcon;
        if (drawable2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    public boolean hasLogo() {
        boolean bl2;
        Drawable drawable2 = this.mLogo;
        if (drawable2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    public void initIndeterminateProgress() {
        Log.i((String)TAG, (String)"Progress display unsupported");
    }

    public void initProgress() {
        Log.i((String)TAG, (String)"Progress display unsupported");
    }

    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    public void restoreHierarchyState(SparseArray sparseArray) {
        this.mToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveHierarchyState(SparseArray sparseArray) {
        this.mToolbar.saveHierarchyState(sparseArray);
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        ViewCompat.setBackground((View)this.mToolbar, drawable2);
    }

    public void setCollapsible(boolean bl2) {
        this.mToolbar.setCollapsible(bl2);
    }

    public void setCustomView(View view) {
        int n10;
        int n11;
        Object object = this.mCustomView;
        if (object != null && (n11 = this.mDisplayOpts & 0x10) != 0) {
            Toolbar toolbar = this.mToolbar;
            toolbar.removeView((View)object);
        }
        this.mCustomView = view;
        if (view != null && (n10 = this.mDisplayOpts & 0x10) != 0) {
            object = this.mToolbar;
            object.addView(view);
        }
    }

    public void setDefaultNavigationContentDescription(int n10) {
        int n11 = this.mDefaultNavigationContentDescription;
        if (n10 == n11) {
            return;
        }
        this.mDefaultNavigationContentDescription = n10;
        CharSequence charSequence = this.mToolbar.getNavigationContentDescription();
        n10 = (int)(TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0);
        if (n10 != 0) {
            n10 = this.mDefaultNavigationContentDescription;
            this.setNavigationContentDescription(n10);
        }
    }

    public void setDefaultNavigationIcon(Drawable drawable2) {
        Drawable drawable3 = this.mDefaultNavigationIcon;
        if (drawable3 != drawable2) {
            this.mDefaultNavigationIcon = drawable2;
            this.updateNavigationIcon();
        }
    }

    public void setDisplayOptions(int n10) {
        int n11 = this.mDisplayOpts ^ n10;
        this.mDisplayOpts = n10;
        if (n11 != 0) {
            View view;
            int n12 = n11 & 4;
            if (n12 != 0) {
                n12 = n10 & 4;
                if (n12 != 0) {
                    this.updateHomeAccessibility();
                }
                this.updateNavigationIcon();
            }
            if ((n12 = n11 & 3) != 0) {
                this.updateToolbarLogo();
            }
            if ((n12 = n11 & 8) != 0) {
                n12 = n10 & 8;
                if (n12 != 0) {
                    Toolbar toolbar = this.mToolbar;
                    CharSequence charSequence = this.mTitle;
                    toolbar.setTitle(charSequence);
                    toolbar = this.mToolbar;
                    charSequence = this.mSubtitle;
                    toolbar.setSubtitle(charSequence);
                } else {
                    Toolbar toolbar = this.mToolbar;
                    Object var5_7 = null;
                    toolbar.setTitle(null);
                    toolbar = this.mToolbar;
                    toolbar.setSubtitle(null);
                }
            }
            if ((n11 &= 0x10) != 0 && (view = this.mCustomView) != null) {
                if ((n10 &= 0x10) != 0) {
                    Toolbar toolbar = this.mToolbar;
                    toolbar.addView(view);
                } else {
                    Toolbar toolbar = this.mToolbar;
                    toolbar.removeView(view);
                }
            }
        }
    }

    public void setDropdownParams(SpinnerAdapter spinnerAdapter, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.ensureSpinner();
        this.mSpinner.setAdapter(spinnerAdapter);
        this.mSpinner.setOnItemSelectedListener(onItemSelectedListener);
    }

    public void setDropdownSelectedPosition(int n10) {
        Spinner spinner = this.mSpinner;
        if (spinner != null) {
            spinner.setSelection(n10);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Can't set dropdown selected position without an adapter");
        throw illegalStateException;
    }

    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        boolean bl2;
        boolean bl3;
        Toolbar toolbar;
        Object object = this.mTabView;
        if (object != null && (object = object.getParent()) == (toolbar = this.mToolbar)) {
            object = this.mTabView;
            toolbar.removeView((View)object);
        }
        this.mTabView = scrollingTabContainerView;
        if (scrollingTabContainerView != null && (bl3 = this.mNavigationMode) == (bl2 = 2 != 0)) {
            int n10;
            int n11;
            object = this.mToolbar;
            toolbar = null;
            object.addView((View)scrollingTabContainerView, 0);
            object = (Toolbar$LayoutParams)this.mTabView.getLayoutParams();
            object.width = n11 = -2;
            object.height = n11;
            object.gravity = n10 = 8388691;
            bl3 = true;
            scrollingTabContainerView.setAllowCollapse(bl3);
        }
    }

    public void setHomeButtonEnabled(boolean bl2) {
    }

    public void setIcon(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Context context = this.getContext();
            drawable2 = AppCompatResources.getDrawable(context, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setIcon(drawable2);
    }

    public void setIcon(Drawable drawable2) {
        this.mIcon = drawable2;
        this.updateToolbarLogo();
    }

    public void setLogo(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Context context = this.getContext();
            drawable2 = AppCompatResources.getDrawable(context, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setLogo(drawable2);
    }

    public void setLogo(Drawable drawable2) {
        this.mLogo = drawable2;
        this.updateToolbarLogo();
    }

    public void setMenu(Menu menu2, MenuPresenter$Callback object) {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter == null) {
            Context context = this.mToolbar.getContext();
            this.mActionMenuPresenter = actionMenuPresenter = new ActionMenuPresenter(context);
            int n10 = R$id.action_menu_presenter;
            actionMenuPresenter.setId(n10);
        }
        this.mActionMenuPresenter.setCallback((MenuPresenter$Callback)object);
        object = this.mToolbar;
        menu2 = (MenuBuilder)menu2;
        actionMenuPresenter = this.mActionMenuPresenter;
        ((Toolbar)((Object)object)).setMenu((MenuBuilder)menu2, actionMenuPresenter);
    }

    public void setMenuCallbacks(MenuPresenter$Callback menuPresenter$Callback, MenuBuilder$Callback menuBuilder$Callback) {
        this.mToolbar.setMenuCallbacks(menuPresenter$Callback, menuBuilder$Callback);
    }

    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    public void setNavigationContentDescription(int n10) {
        String string2;
        if (n10 == 0) {
            n10 = 0;
            string2 = null;
        } else {
            Context context = this.getContext();
            string2 = context.getString(n10);
        }
        this.setNavigationContentDescription(string2);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.mHomeDescription = charSequence;
        this.updateHomeAccessibility();
    }

    public void setNavigationIcon(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Context context = this.getContext();
            drawable2 = AppCompatResources.getDrawable(context, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setNavigationIcon(drawable2);
    }

    public void setNavigationIcon(Drawable drawable2) {
        this.mNavIcon = drawable2;
        this.updateNavigationIcon();
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setNavigationMode(int n10) {
        int n11 = this.mNavigationMode;
        if (n10 == n11) return;
        int n12 = 2;
        int n13 = 1;
        if (n11 != n13) {
            Toolbar toolbar;
            ViewParent viewParent;
            View view;
            if (n11 == n12 && (view = this.mTabView) != null && (viewParent = view.getParent()) == (toolbar = this.mToolbar)) {
                View view2 = this.mTabView;
                toolbar.removeView(view2);
            }
        } else {
            Toolbar toolbar;
            ViewParent viewParent;
            Spinner spinner = this.mSpinner;
            if (spinner != null && (viewParent = spinner.getParent()) == (toolbar = this.mToolbar)) {
                Spinner spinner2 = this.mSpinner;
                toolbar.removeView((View)spinner2);
            }
        }
        this.mNavigationMode = n10;
        if (n10 == 0) return;
        n11 = 0;
        Object var5_12 = null;
        if (n10 == n13) {
            this.ensureSpinner();
            Toolbar toolbar = this.mToolbar;
            Spinner spinner = this.mSpinner;
            toolbar.addView((View)spinner, 0);
            return;
        }
        if (n10 == n12) {
            View view = this.mTabView;
            if (view == null) return;
            Toolbar toolbar = this.mToolbar;
            toolbar.addView(view, 0);
            Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)this.mTabView.getLayoutParams();
            toolbar$LayoutParams.width = n11 = -2;
            toolbar$LayoutParams.height = n11;
            toolbar$LayoutParams.gravity = n11 = 8388691;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid navigation mode ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        int n10 = this.mDisplayOpts & 8;
        if (n10 != 0) {
            Toolbar toolbar = this.mToolbar;
            toolbar.setSubtitle(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        this.setTitleInt(charSequence);
    }

    public void setVisibility(int n10) {
        this.mToolbar.setVisibility(n10);
    }

    public void setWindowCallback(Window.Callback callback) {
        this.mWindowCallback = callback;
    }

    public void setWindowTitle(CharSequence charSequence) {
        boolean bl2 = this.mTitleSet;
        if (!bl2) {
            this.setTitleInt(charSequence);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int n10, long l10) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = ViewCompat.animate((View)this.mToolbar);
        float f10 = n10 == 0 ? 1.0f : 0.0f;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = viewPropertyAnimatorCompat.alpha(f10).setDuration(l10);
        ToolbarWidgetWrapper$2 toolbarWidgetWrapper$2 = new ToolbarWidgetWrapper$2(this, n10);
        return viewPropertyAnimatorCompat2.setListener(toolbarWidgetWrapper$2);
    }

    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }
}

