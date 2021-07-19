/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.text.TextUtils$TruncateAt
 *  android.util.AttributeSet
 *  android.view.ContextThemeWrapper
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.widget.ImageButton
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar$LayoutParams;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ActionMenuView$OnMenuItemClickListener;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar$1;
import androidx.appcompat.widget.Toolbar$2;
import androidx.appcompat.widget.Toolbar$3;
import androidx.appcompat.widget.Toolbar$ExpandedActionViewMenuPresenter;
import androidx.appcompat.widget.Toolbar$LayoutParams;
import androidx.appcompat.widget.Toolbar$OnMenuItemClickListener;
import androidx.appcompat.widget.Toolbar$SavedState;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
extends ViewGroup {
    private static final String TAG = "Toolbar";
    private MenuPresenter$Callback mActionMenuPresenterCallback;
    public int mButtonGravity;
    public ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    public View mExpandedActionView;
    private Toolbar$ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    private MenuBuilder$Callback mMenuBuilderCallback;
    private ActionMenuView mMenuView;
    private final ActionMenuView$OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    public Toolbar$OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.toolbarStyle;
        this(context, attributeSet, n10);
    }

    public Toolbar(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        this.mGravity = 8388627;
        Object object2 = new ArrayList();
        this.mTempViews = object2;
        object2 = new ArrayList();
        this.mHiddenViews = object2;
        int n11 = 2;
        object2 = new int[n11];
        this.mTempMargins = (int[])object2;
        this.mMenuViewItemClickListener = object2 = new Toolbar$1(this);
        this.mShowOverflowMenuRunnable = object2 = new Toolbar$2(this);
        object2 = this.getContext();
        Object object3 = R$styleable.Toolbar;
        object2 = TintTypedArray.obtainStyledAttributes((Context)object2, attributeSet, (int[])object3, n10, 0);
        TypedArray typedArray = ((TintTypedArray)object2).getWrappedTypeArray();
        Object object4 = this;
        ViewCompat.saveAttributeDataForStyleable((View)this, object, (int[])object3, attributeSet, typedArray, n10, 0);
        int n12 = R$styleable.Toolbar_titleTextAppearance;
        this.mTitleTextAppearance = n12 = ((TintTypedArray)object2).getResourceId(n12, 0);
        n12 = R$styleable.Toolbar_subtitleTextAppearance;
        this.mSubtitleTextAppearance = n12 = ((TintTypedArray)object2).getResourceId(n12, 0);
        n12 = R$styleable.Toolbar_android_gravity;
        int n13 = this.mGravity;
        this.mGravity = n12 = ((TintTypedArray)object2).getInteger(n12, n13);
        n12 = R$styleable.Toolbar_buttonGravity;
        this.mButtonGravity = n12 = ((TintTypedArray)object2).getInteger(n12, 48);
        n12 = R$styleable.Toolbar_titleMargin;
        n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n12, 0);
        n13 = R$styleable.Toolbar_titleMargins;
        n10 = ((TintTypedArray)object2).hasValue(n13) ? 1 : 0;
        if (n10 != 0) {
            n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n13, n12);
        }
        this.mTitleMarginBottom = n12;
        this.mTitleMarginTop = n12;
        this.mTitleMarginEnd = n12;
        this.mTitleMarginStart = n12;
        n12 = R$styleable.Toolbar_titleMarginStart;
        n13 = -1;
        if ((n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n12, n13)) >= 0) {
            this.mTitleMarginStart = n12;
        }
        n12 = R$styleable.Toolbar_titleMarginEnd;
        if ((n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n12, n13)) >= 0) {
            this.mTitleMarginEnd = n12;
        }
        n12 = R$styleable.Toolbar_titleMarginTop;
        if ((n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n12, n13)) >= 0) {
            this.mTitleMarginTop = n12;
        }
        n12 = R$styleable.Toolbar_titleMarginBottom;
        if ((n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n12, n13)) >= 0) {
            this.mTitleMarginBottom = n12;
        }
        n12 = R$styleable.Toolbar_maxButtonHeight;
        this.mMaxButtonHeight = n12 = ((TintTypedArray)object2).getDimensionPixelSize(n12, n13);
        n12 = R$styleable.Toolbar_contentInsetStart;
        n13 = -1 << -1;
        n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n12, n13);
        n10 = R$styleable.Toolbar_contentInsetEnd;
        n10 = ((TintTypedArray)object2).getDimensionPixelOffset(n10, n13);
        int n14 = R$styleable.Toolbar_contentInsetLeft;
        n14 = ((TintTypedArray)object2).getDimensionPixelSize(n14, 0);
        int n15 = R$styleable.Toolbar_contentInsetRight;
        n15 = ((TintTypedArray)object2).getDimensionPixelSize(n15, 0);
        this.ensureContentInsets();
        object3 = this.mContentInsets;
        ((RtlSpacingHelper)object3).setAbsolute(n14, n15);
        if (n12 != n13 || n10 != n13) {
            object4 = this.mContentInsets;
            ((RtlSpacingHelper)object4).setRelative(n12, n10);
        }
        n12 = R$styleable.Toolbar_contentInsetStartWithNavigation;
        this.mContentInsetStartWithNavigation = n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n12, n13);
        n12 = R$styleable.Toolbar_contentInsetEndWithActions;
        this.mContentInsetEndWithActions = n12 = ((TintTypedArray)object2).getDimensionPixelOffset(n12, n13);
        n12 = R$styleable.Toolbar_collapseIcon;
        object = ((TintTypedArray)object2).getDrawable(n12);
        this.mCollapseIcon = object;
        n12 = R$styleable.Toolbar_collapseContentDescription;
        object = ((TintTypedArray)object2).getText(n12);
        this.mCollapseDescription = object;
        n12 = R$styleable.Toolbar_title;
        object = ((TintTypedArray)object2).getText(n12);
        n13 = TextUtils.isEmpty((CharSequence)object) ? 1 : 0;
        if (n13 == 0) {
            this.setTitle((CharSequence)object);
        }
        if ((n13 = (int)(TextUtils.isEmpty((CharSequence)(object = ((TintTypedArray)object2).getText(n12 = R$styleable.Toolbar_subtitle))) ? 1 : 0)) == 0) {
            this.setSubtitle((CharSequence)object);
        }
        this.mPopupContext = object = this.getContext();
        n12 = R$styleable.Toolbar_popupTheme;
        n12 = ((TintTypedArray)object2).getResourceId(n12, 0);
        this.setPopupTheme(n12);
        n12 = R$styleable.Toolbar_navigationIcon;
        object = ((TintTypedArray)object2).getDrawable(n12);
        if (object != null) {
            this.setNavigationIcon((Drawable)object);
        }
        if ((n13 = (int)(TextUtils.isEmpty((CharSequence)(object = ((TintTypedArray)object2).getText(n12 = R$styleable.Toolbar_navigationContentDescription))) ? 1 : 0)) == 0) {
            this.setNavigationContentDescription((CharSequence)object);
        }
        if ((object = ((TintTypedArray)object2).getDrawable(n12 = R$styleable.Toolbar_logo)) != null) {
            this.setLogo((Drawable)object);
        }
        if ((n13 = (int)(TextUtils.isEmpty((CharSequence)(object = ((TintTypedArray)object2).getText(n12 = R$styleable.Toolbar_logoDescription))) ? 1 : 0)) == 0) {
            this.setLogoDescription((CharSequence)object);
        }
        if ((n13 = (int)(((TintTypedArray)object2).hasValue(n12 = R$styleable.Toolbar_titleTextColor) ? 1 : 0)) != 0) {
            object = ((TintTypedArray)object2).getColorStateList(n12);
            this.setTitleTextColor((ColorStateList)object);
        }
        if ((n13 = (int)(((TintTypedArray)object2).hasValue(n12 = R$styleable.Toolbar_subtitleTextColor) ? 1 : 0)) != 0) {
            object = ((TintTypedArray)object2).getColorStateList(n12);
            this.setSubtitleTextColor((ColorStateList)object);
        }
        if ((n13 = (int)(((TintTypedArray)object2).hasValue(n12 = R$styleable.Toolbar_menu) ? 1 : 0)) != 0) {
            n12 = ((TintTypedArray)object2).getResourceId(n12, 0);
            this.inflateMenu(n12);
        }
        ((TintTypedArray)object2).recycle();
    }

    private void addCustomViewsWithGravity(List list, int n10) {
        View view;
        int n11 = ViewCompat.getLayoutDirection((View)this);
        int n12 = 0;
        Toolbar$LayoutParams toolbar$LayoutParams = null;
        int n13 = 1;
        if (n11 == n13) {
            n11 = n13;
        } else {
            n11 = 0;
            view = null;
        }
        int n14 = this.getChildCount();
        int n15 = ViewCompat.getLayoutDirection((View)this);
        n10 = GravityCompat.getAbsoluteGravity(n10, n15);
        list.clear();
        if (n11 != 0) {
            n14 -= n13;
            while (n14 >= 0) {
                view = this.getChildAt(n14);
                toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
                n13 = toolbar$LayoutParams.mViewType;
                if (n13 == 0 && (n13 = (int)(this.shouldLayout(view) ? 1 : 0)) != 0) {
                    n12 = toolbar$LayoutParams.gravity;
                    if ((n12 = this.getChildHorizontalGravity(n12)) == n10) {
                        list.add(view);
                    }
                }
                n14 += -1;
            }
        } else {
            while (n12 < n14) {
                view = this.getChildAt(n12);
                Toolbar$LayoutParams toolbar$LayoutParams2 = (Toolbar$LayoutParams)view.getLayoutParams();
                n15 = toolbar$LayoutParams2.mViewType;
                if (n15 == 0 && (n15 = (int)(this.shouldLayout(view) ? 1 : 0)) != 0) {
                    n13 = toolbar$LayoutParams2.gravity;
                    if ((n13 = this.getChildHorizontalGravity(n13)) == n10) {
                        list.add(view);
                    }
                }
                ++n12;
            }
        }
    }

    private void addSystemView(View view, boolean bl2) {
        Object object;
        boolean bl3;
        Object object2 = view.getLayoutParams();
        object2 = object2 == null ? this.generateDefaultLayoutParams() : (!(bl3 = this.checkLayoutParams((ViewGroup.LayoutParams)object2)) ? this.generateLayoutParams((ViewGroup.LayoutParams)object2) : (Toolbar$LayoutParams)((Object)object2));
        bl3 = true;
        object2.mViewType = bl3 ? 1 : 0;
        if (bl2 && (object = this.mExpandedActionView) != null) {
            view.setLayoutParams(object2);
            object = this.mHiddenViews;
            ((ArrayList)object).add(view);
        } else {
            this.addView(view, (ViewGroup.LayoutParams)object2);
        }
    }

    private void ensureContentInsets() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper == null) {
            this.mContentInsets = rtlSpacingHelper = new RtlSpacingHelper();
        }
    }

    private void ensureLogoView() {
        ImageView imageView = this.mLogoView;
        if (imageView == null) {
            Context context = this.getContext();
            this.mLogoView = imageView = new AppCompatImageView(context);
        }
    }

    private void ensureMenu() {
        this.ensureMenuView();
        MenuBuilder menuBuilder = this.mMenuView.peekMenu();
        if (menuBuilder == null) {
            menuBuilder = (MenuBuilder)this.mMenuView.getMenu();
            Object object = this.mExpandedMenuPresenter;
            if (object == null) {
                this.mExpandedMenuPresenter = object = new Toolbar$ExpandedActionViewMenuPresenter(this);
            }
            object = this.mMenuView;
            boolean bl2 = true;
            ((ActionMenuView)object).setExpandedActionViewsExclusive(bl2);
            object = this.mExpandedMenuPresenter;
            Context context = this.mPopupContext;
            menuBuilder.addMenuPresenter((MenuPresenter)object, context);
        }
    }

    private void ensureMenuView() {
        Object object = this.mMenuView;
        if (object == null) {
            Object object2 = this.getContext();
            this.mMenuView = object = new ActionMenuView((Context)object2);
            int n10 = this.mPopupTheme;
            object.setPopupTheme(n10);
            object = this.mMenuView;
            object2 = this.mMenuViewItemClickListener;
            object.setOnMenuItemClickListener((ActionMenuView$OnMenuItemClickListener)object2);
            object = this.mMenuView;
            object2 = this.mActionMenuPresenterCallback;
            MenuBuilder$Callback menuBuilder$Callback = this.mMenuBuilderCallback;
            object.setMenuCallbacks((MenuPresenter$Callback)object2, menuBuilder$Callback);
            object = this.generateDefaultLayoutParams();
            int n11 = this.mButtonGravity & 0x70;
            ((ActionBar$LayoutParams)object).gravity = n10 = 0x800005 | n11;
            this.mMenuView.setLayoutParams((ViewGroup.LayoutParams)object);
            object = this.mMenuView;
            n10 = 0;
            object2 = null;
            this.addSystemView((View)object, false);
        }
    }

    private void ensureNavButtonView() {
        Object object = this.mNavButtonView;
        if (object == null) {
            int n10;
            Context context = this.getContext();
            int n11 = R$attr.toolbarNavigationButtonStyle;
            this.mNavButtonView = object = new AppCompatImageButton(context, null, n11);
            object = this.generateDefaultLayoutParams();
            int n12 = this.mButtonGravity & 0x70;
            object.gravity = n10 = 0x800003 | n12;
            context = this.mNavButtonView;
            context.setLayoutParams((ViewGroup.LayoutParams)object);
        }
    }

    private int getChildHorizontalGravity(int n10) {
        int n11;
        int n12;
        int n13;
        int n14 = ViewCompat.getLayoutDirection((View)this);
        if ((n10 = GravityCompat.getAbsoluteGravity(n10, n14) & 7) != (n13 = 1) && n10 != (n12 = 3) && n10 != (n11 = 5)) {
            if (n14 == n13) {
                n12 = n11;
            }
            return n12;
        }
        return n10;
    }

    private int getChildTop(View view, int n10) {
        int n11;
        Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
        int n12 = view.getMeasuredHeight();
        int n13 = 0;
        n10 = n10 > 0 ? (n12 - n10) / 2 : 0;
        int n14 = toolbar$LayoutParams.gravity;
        if ((n14 = this.getChildVerticalGravity(n14)) != (n11 = 48)) {
            n11 = 80;
            if (n14 != n11) {
                int n15;
                n10 = this.getPaddingTop();
                n14 = this.getPaddingBottom();
                n11 = this.getHeight();
                int n16 = (n11 - n10 - n14 - n12) / 2;
                if (n16 < (n15 = toolbar$LayoutParams.topMargin)) {
                    n16 = n15;
                } else if ((n11 = n11 - n14 - n12 - n16 - n10) < (n12 = toolbar$LayoutParams.bottomMargin)) {
                    n16 -= (n12 -= n11);
                    n16 = Math.max(0, n16);
                }
                return n10 + n16;
            }
            n13 = this.getHeight();
            n14 = this.getPaddingBottom();
            n13 = n13 - n14 - n12;
            n12 = toolbar$LayoutParams.bottomMargin;
            return n13 - n12 - n10;
        }
        return this.getPaddingTop() - n10;
    }

    private int getChildVerticalGravity(int n10) {
        int n11 = 16;
        if ((n10 &= 0x70) != n11 && n10 != (n11 = 48) && n10 != (n11 = 80)) {
            n10 = this.mGravity & 0x70;
        }
        return n10;
    }

    private int getHorizontalMargins(View view) {
        view = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n10 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)view);
        int n11 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)view);
        return n10 + n11;
    }

    private MenuInflater getMenuInflater() {
        Context context = this.getContext();
        SupportMenuInflater supportMenuInflater = new SupportMenuInflater(context);
        return supportMenuInflater;
    }

    private int getVerticalMargins(View view) {
        view = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n10 = view.topMargin;
        int n11 = view.bottomMargin;
        return n10 + n11;
    }

    private int getViewListMeasuredWidth(List list, int[] nArray) {
        int n10 = nArray[0];
        int n11 = nArray[1];
        int n12 = list.size();
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            View view = (View)list.get(i10);
            Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
            int n14 = toolbar$LayoutParams.leftMargin - n10;
            n10 = toolbar$LayoutParams.rightMargin - n11;
            n11 = Math.max(0, n14);
            int n15 = Math.max(0, n10);
            n14 = -n14;
            n14 = Math.max(0, n14);
            n10 = -n10;
            n10 = Math.max(0, n10);
            int n16 = view.getMeasuredWidth();
            n11 = n11 + n16 + n15;
            n13 += n11;
            n11 = n10;
            n10 = n14;
        }
        return n13;
    }

    private boolean isChildOrHidden(View view) {
        boolean bl2;
        Object object = view.getParent();
        if (object != this && !(bl2 = ((ArrayList)(object = this.mHiddenViews)).contains(view))) {
            bl2 = false;
            view = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private int layoutChildLeft(View view, int n10, int[] nArray, int n11) {
        Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
        int n12 = toolbar$LayoutParams.leftMargin;
        int n13 = nArray[0];
        n12 -= n13;
        n13 = Math.max(0, n12);
        n12 = -n12;
        nArray[0] = n12 = Math.max(0, n12);
        int n14 = this.getChildTop(view, n11);
        n11 = view.getMeasuredWidth();
        n12 = (n10 += n13) + n11;
        int n15 = view.getMeasuredHeight() + n14;
        view.layout(n10, n14, n12, n15);
        int n16 = toolbar$LayoutParams.rightMargin;
        return n10 + (n11 += n16);
    }

    private int layoutChildRight(View view, int n10, int[] nArray, int n11) {
        Toolbar$LayoutParams toolbar$LayoutParams = (Toolbar$LayoutParams)view.getLayoutParams();
        int n12 = toolbar$LayoutParams.rightMargin;
        int n13 = 1;
        int n14 = nArray[n13];
        int n15 = Math.max(0, n12 -= n14);
        n12 = -n12;
        nArray[n13] = n12 = Math.max(0, n12);
        int n16 = this.getChildTop(view, n11);
        n11 = view.getMeasuredWidth();
        n12 = (n10 -= n15) - n11;
        n13 = view.getMeasuredHeight() + n16;
        view.layout(n12, n16, n10, n13);
        int n17 = toolbar$LayoutParams.leftMargin;
        return n10 - (n11 += n17);
    }

    private int measureChildCollapseMargins(View view, int n10, int n11, int n12, int n13, int[] nArray) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n14 = marginLayoutParams.leftMargin;
        int n15 = nArray[0];
        n14 -= n15;
        n15 = marginLayoutParams.rightMargin;
        int n16 = 1;
        int n17 = nArray[n16];
        n15 -= n17;
        n17 = Math.max(0, n14);
        int n18 = Math.max(0, n15);
        n14 = -n14;
        nArray[0] = n14 = Math.max(0, n14);
        n14 = -n15;
        nArray[n16] = n14 = Math.max(0, n14);
        int n19 = this.getPaddingLeft();
        n14 = this.getPaddingRight();
        n19 = n19 + n14 + (n17 += n18) + n11;
        n11 = marginLayoutParams.width;
        n10 = ViewGroup.getChildMeasureSpec((int)n10, (int)n19, (int)n11);
        n11 = this.getPaddingTop();
        n19 = this.getPaddingBottom();
        n11 += n19;
        n19 = marginLayoutParams.topMargin;
        n11 += n19;
        n19 = marginLayoutParams.bottomMargin;
        n11 = n11 + n19 + n13;
        n13 = marginLayoutParams.height;
        n11 = ViewGroup.getChildMeasureSpec((int)n12, (int)n11, (int)n13);
        view.measure(n10, n11);
        return view.getMeasuredWidth() + n17;
    }

    private void measureChildConstrained(View view, int n10, int n11, int n12, int n13, int n14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        int n15 = this.getPaddingLeft();
        int n16 = this.getPaddingRight();
        n15 += n16;
        n16 = marginLayoutParams.leftMargin;
        n15 += n16;
        n16 = marginLayoutParams.rightMargin;
        n15 = n15 + n16 + n11;
        n11 = marginLayoutParams.width;
        n10 = ViewGroup.getChildMeasureSpec((int)n10, (int)n15, (int)n11);
        n11 = this.getPaddingTop();
        n15 = this.getPaddingBottom();
        n11 += n15;
        n15 = marginLayoutParams.topMargin;
        n11 += n15;
        n15 = marginLayoutParams.bottomMargin;
        n11 = n11 + n15 + n13;
        n13 = marginLayoutParams.height;
        if ((n12 = View.MeasureSpec.getMode((int)(n11 = ViewGroup.getChildMeasureSpec((int)n12, (int)n11, (int)n13)))) != (n13 = 0x40000000) && n14 >= 0) {
            if (n12 != 0) {
                n11 = View.MeasureSpec.getSize((int)n11);
                n14 = Math.min(n11, n14);
            }
            n11 = View.MeasureSpec.makeMeasureSpec((int)n14, (int)n13);
        }
        view.measure(n10, n11);
    }

    private void postShowOverflowMenu() {
        Runnable runnable = this.mShowOverflowMenuRunnable;
        this.removeCallbacks(runnable);
        runnable = this.mShowOverflowMenuRunnable;
        this.post(runnable);
    }

    private boolean shouldCollapse() {
        int n10 = this.mCollapsible;
        if (n10 == 0) {
            return false;
        }
        n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            View view = this.getChildAt(i10);
            int n12 = this.shouldLayout(view);
            if (n12 == 0 || (n12 = view.getMeasuredWidth()) <= 0 || (n11 = view.getMeasuredHeight()) <= 0) continue;
            return false;
        }
        return true;
    }

    private boolean shouldLayout(View view) {
        int n10;
        int n11;
        ViewParent viewParent;
        if (view != null && (viewParent = view.getParent()) == this && (n11 = view.getVisibility()) != (n10 = 8)) {
            n11 = 1;
        } else {
            n11 = 0;
            view = null;
        }
        return n11 != 0;
    }

    public void addChildrenForExpandedActionView() {
        ArrayList arrayList = this.mHiddenViews;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            View view = (View)this.mHiddenViews.get(i10);
            this.addView(view);
        }
        this.mHiddenViews.clear();
    }

    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        int n10 = this.getVisibility();
        if (!n10 && (actionMenuView = this.mMenuView) != null && (n10 = actionMenuView.isOverflowReserved())) {
            n10 = 1;
        } else {
            n10 = 0;
            actionMenuView = null;
        }
        return n10 != 0;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl2;
        boolean bl3 = super.checkLayoutParams(layoutParams);
        if (bl3 && (bl2 = layoutParams instanceof Toolbar$LayoutParams)) {
            bl2 = true;
        } else {
            bl2 = false;
            layoutParams = null;
        }
        return bl2;
    }

    public void collapseActionView() {
        Object object = this.mExpandedMenuPresenter;
        object = object == null ? null : ((Toolbar$ExpandedActionViewMenuPresenter)object).mCurrentExpandedItem;
        if (object != null) {
            ((MenuItemImpl)object).collapseActionView();
        }
    }

    public void dismissPopupMenus() {
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.dismissPopupMenus();
        }
    }

    public void ensureCollapseButtonView() {
        Object object = this.mCollapseButtonView;
        if (object == null) {
            int n10;
            Object object2 = this.getContext();
            int n11 = R$attr.toolbarNavigationButtonStyle;
            this.mCollapseButtonView = object = new AppCompatImageButton((Context)object2, null, n11);
            object2 = this.mCollapseIcon;
            object.setImageDrawable((Drawable)object2);
            object = this.mCollapseButtonView;
            object2 = this.mCollapseDescription;
            object.setContentDescription((CharSequence)object2);
            object = this.generateDefaultLayoutParams();
            int n12 = this.mButtonGravity & 0x70;
            object.gravity = n10 = 0x800003 | n12;
            object.mViewType = n10 = 2;
            this.mCollapseButtonView.setLayoutParams((ViewGroup.LayoutParams)object);
            object = this.mCollapseButtonView;
            object2 = new Toolbar$3(this);
            object.setOnClickListener((View.OnClickListener)object2);
        }
    }

    public Toolbar$LayoutParams generateDefaultLayoutParams() {
        int n10 = -2;
        Toolbar$LayoutParams toolbar$LayoutParams = new Toolbar$LayoutParams(n10, n10);
        return toolbar$LayoutParams;
    }

    public Toolbar$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        Toolbar$LayoutParams toolbar$LayoutParams = new Toolbar$LayoutParams(context, attributeSet);
        return toolbar$LayoutParams;
    }

    public Toolbar$LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        boolean bl2 = object instanceof Toolbar$LayoutParams;
        if (bl2) {
            object = (Toolbar$LayoutParams)((Object)object);
            Toolbar$LayoutParams toolbar$LayoutParams = new Toolbar$LayoutParams((Toolbar$LayoutParams)((Object)object));
            return toolbar$LayoutParams;
        }
        bl2 = object instanceof ActionBar$LayoutParams;
        if (bl2) {
            object = (ActionBar$LayoutParams)((Object)object);
            Toolbar$LayoutParams toolbar$LayoutParams = new Toolbar$LayoutParams((ActionBar$LayoutParams)((Object)object));
            return toolbar$LayoutParams;
        }
        bl2 = object instanceof ViewGroup.MarginLayoutParams;
        if (bl2) {
            object = (ViewGroup.MarginLayoutParams)object;
            Toolbar$LayoutParams toolbar$LayoutParams = new Toolbar$LayoutParams((ViewGroup.MarginLayoutParams)object);
            return toolbar$LayoutParams;
        }
        Toolbar$LayoutParams toolbar$LayoutParams = new Toolbar$LayoutParams((ViewGroup.LayoutParams)object);
        return toolbar$LayoutParams;
    }

    public CharSequence getCollapseContentDescription() {
        Object object = this.mCollapseButtonView;
        object = object != null ? object.getContentDescription() : null;
        return object;
    }

    public Drawable getCollapseIcon() {
        Object object = this.mCollapseButtonView;
        object = object != null ? object.getDrawable() : null;
        return object;
    }

    public int getContentInsetEnd() {
        int n10;
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            n10 = rtlSpacingHelper.getEnd();
        } else {
            n10 = 0;
            rtlSpacingHelper = null;
        }
        return n10;
    }

    public int getContentInsetEndWithActions() {
        int n10 = this.mContentInsetEndWithActions;
        int n11 = -1 << -1;
        if (n10 == n11) {
            n10 = this.getContentInsetEnd();
        }
        return n10;
    }

    public int getContentInsetLeft() {
        int n10;
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            n10 = rtlSpacingHelper.getLeft();
        } else {
            n10 = 0;
            rtlSpacingHelper = null;
        }
        return n10;
    }

    public int getContentInsetRight() {
        int n10;
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            n10 = rtlSpacingHelper.getRight();
        } else {
            n10 = 0;
            rtlSpacingHelper = null;
        }
        return n10;
    }

    public int getContentInsetStart() {
        int n10;
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            n10 = rtlSpacingHelper.getStart();
        } else {
            n10 = 0;
            rtlSpacingHelper = null;
        }
        return n10;
    }

    public int getContentInsetStartWithNavigation() {
        int n10 = this.mContentInsetStartWithNavigation;
        int n11 = -1 << -1;
        if (n10 == n11) {
            n10 = this.getContentInsetStart();
        }
        return n10;
    }

    public int getCurrentContentInsetEnd() {
        int n10;
        Object object = this.mMenuView;
        int n11 = 0;
        if (object != null && (object = ((ActionMenuView)object).peekMenu()) != null && (n10 = ((MenuBuilder)object).hasVisibleItems()) != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            n10 = this.getContentInsetEnd();
            int n12 = this.mContentInsetEndWithActions;
            n11 = Math.max(n12, 0);
            n10 = Math.max(n10, n11);
        } else {
            n10 = this.getContentInsetEnd();
        }
        return n10;
    }

    public int getCurrentContentInsetLeft() {
        int n10;
        int n11 = ViewCompat.getLayoutDirection((View)this);
        n11 = n11 == (n10 = 1) ? this.getCurrentContentInsetEnd() : this.getCurrentContentInsetStart();
        return n11;
    }

    public int getCurrentContentInsetRight() {
        int n10;
        int n11 = ViewCompat.getLayoutDirection((View)this);
        n11 = n11 == (n10 = 1) ? this.getCurrentContentInsetStart() : this.getCurrentContentInsetEnd();
        return n11;
    }

    public int getCurrentContentInsetStart() {
        int n10;
        Drawable drawable2 = this.getNavigationIcon();
        if (drawable2 != null) {
            n10 = this.getContentInsetStart();
            int n11 = Math.max(this.mContentInsetStartWithNavigation, 0);
            n10 = Math.max(n10, n11);
        } else {
            n10 = this.getContentInsetStart();
        }
        return n10;
    }

    public Drawable getLogo() {
        Object object = this.mLogoView;
        object = object != null ? object.getDrawable() : null;
        return object;
    }

    public CharSequence getLogoDescription() {
        Object object = this.mLogoView;
        object = object != null ? object.getContentDescription() : null;
        return object;
    }

    public Menu getMenu() {
        this.ensureMenu();
        return this.mMenuView.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        Object object = this.mNavButtonView;
        object = object != null ? object.getContentDescription() : null;
        return object;
    }

    public Drawable getNavigationIcon() {
        Object object = this.mNavButtonView;
        object = object != null ? object.getDrawable() : null;
        return object;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Drawable getOverflowIcon() {
        this.ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    public DecorToolbar getWrapper() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.mWrapper;
        if (toolbarWidgetWrapper == null) {
            boolean bl2 = true;
            this.mWrapper = toolbarWidgetWrapper = new ToolbarWidgetWrapper(this, bl2);
        }
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        boolean bl2;
        Object object = this.mExpandedMenuPresenter;
        if (object != null && (object = ((Toolbar$ExpandedActionViewMenuPresenter)object).mCurrentExpandedItem) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean hideOverflowMenu() {
        boolean bl2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && (bl2 = actionMenuView.hideOverflowMenu())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuView = null;
        }
        return bl2;
    }

    public void inflateMenu(int n10) {
        MenuInflater menuInflater = this.getMenuInflater();
        Menu menu2 = this.getMenu();
        menuInflater.inflate(n10, menu2);
    }

    public boolean isOverflowMenuShowPending() {
        boolean bl2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && (bl2 = actionMenuView.isOverflowMenuShowPending())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuView = null;
        }
        return bl2;
    }

    public boolean isOverflowMenuShowing() {
        boolean bl2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && (bl2 = actionMenuView.isOverflowMenuShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuView = null;
        }
        return bl2;
    }

    public boolean isTitleTruncated() {
        TextView textView = this.mTitleTextView;
        if (textView == null) {
            return false;
        }
        if ((textView = textView.getLayout()) == null) {
            return false;
        }
        int n10 = textView.getLineCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = textView.getEllipsisCount(i10);
            if (n11 <= 0) continue;
            return true;
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.mShowOverflowMenuRunnable;
        this.removeCallbacks(runnable);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n10;
        int n11;
        int n12 = motionEvent.getActionMasked();
        if (n12 == (n11 = 9)) {
            this.mEatingHover = false;
        }
        boolean bl2 = this.mEatingHover;
        boolean bl3 = true;
        if (!bl2) {
            n10 = super.onHoverEvent(motionEvent) ? 1 : 0;
            if (n12 == n11 && n10 == 0) {
                this.mEatingHover = bl3;
            }
        }
        if (n12 == (n10 = 10) || n12 == (n10 = 3)) {
            this.mEatingHover = false;
        }
        return bl3;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onLayout(boolean var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        block51: {
            block52: {
                block49: {
                    block50: {
                        var6_6 = this;
                        var7_7 = ViewCompat.getLayoutDirection((View)this);
                        var8_8 = 1;
                        var9_9 = 0;
                        var10_10 /* !! */  = null;
                        if (var7_7 == var8_8) {
                            var7_7 = var8_8;
                        } else {
                            var7_7 = 0;
                            var11_11 = null;
                        }
                        var12_12 = this.getWidth();
                        var13_13 = this.getHeight();
                        var14_14 = this.getPaddingLeft();
                        var15_15 = this.getPaddingRight();
                        var16_16 = this.getPaddingTop();
                        var17_17 = this.getPaddingBottom();
                        var18_18 = var12_12 - var15_15;
                        var19_19 = var6_6.mTempMargins;
                        var19_19[var8_8] = 0;
                        var19_19[0] = 0;
                        var20_20 = ViewCompat.getMinimumHeight((View)this);
                        if (var20_20 >= 0) {
                            var21_21 = var5_5 - var3_3;
                            var20_20 = Math.min(var20_20, var21_21);
                        } else {
                            var20_20 = 0;
                        }
                        var22_22 = var6_6.mNavButtonView;
                        var21_21 = (int)var6_6.shouldLayout((View)var22_22);
                        if (var21_21 == 0) break block49;
                        if (var7_7 == 0) break block50;
                        var22_22 = var6_6.mNavButtonView;
                        var23_23 = var6_6.layoutChildRight((View)var22_22, var18_18, var19_19, var20_20);
                        var21_21 = var14_14;
                        break block51;
                    }
                    var22_22 = var6_6.mNavButtonView;
                    var21_21 = var6_6.layoutChildLeft((View)var22_22, var14_14, var19_19, var20_20);
                    break block52;
                }
                var21_21 = var14_14;
            }
            var23_23 = var18_18;
        }
        var24_24 /* !! */  = var6_6.mCollapseButtonView;
        var25_25 = var6_6.shouldLayout((View)var24_24 /* !! */ );
        if (var25_25 != 0) {
            if (var7_7 != 0) {
                var24_24 /* !! */  = var6_6.mCollapseButtonView;
                var23_23 = var6_6.layoutChildRight((View)var24_24 /* !! */ , var23_23, var19_19, var20_20);
            } else {
                var24_24 /* !! */  = var6_6.mCollapseButtonView;
                var21_21 = var6_6.layoutChildLeft((View)var24_24 /* !! */ , var21_21, var19_19, var20_20);
            }
        }
        if ((var25_25 = var6_6.shouldLayout((View)(var24_24 /* !! */  = var6_6.mMenuView))) != 0) {
            if (var7_7 != 0) {
                var24_24 /* !! */  = var6_6.mMenuView;
                var21_21 = var6_6.layoutChildLeft((View)var24_24 /* !! */ , var21_21, var19_19, var20_20);
            } else {
                var24_24 /* !! */  = var6_6.mMenuView;
                var23_23 = var6_6.layoutChildRight((View)var24_24 /* !! */ , var23_23, var19_19, var20_20);
            }
        }
        var25_25 = this.getCurrentContentInsetLeft();
        var26_26 = this.getCurrentContentInsetRight();
        var8_8 = var25_25 - var21_21;
        var19_19[0] = var8_8 = Math.max(0, var8_8);
        var8_8 = var18_18 - var23_23;
        var8_8 = var26_26 - var8_8;
        var8_8 = Math.max(0, var8_8);
        var27_27 = 1;
        var19_19[var27_27] = var8_8;
        var8_8 = Math.max(var21_21, var25_25);
        var18_18 -= var26_26;
        var18_18 = Math.min(var23_23, var18_18);
        var22_22 = var6_6.mExpandedActionView;
        var21_21 = (int)var6_6.shouldLayout((View)var22_22);
        if (var21_21 != 0) {
            if (var7_7 != 0) {
                var22_22 = var6_6.mExpandedActionView;
                var18_18 = var6_6.layoutChildRight((View)var22_22, var18_18, var19_19, var20_20);
            } else {
                var22_22 = var6_6.mExpandedActionView;
                var8_8 = var6_6.layoutChildLeft((View)var22_22, var8_8, var19_19, var20_20);
            }
        }
        if ((var21_21 = (int)var6_6.shouldLayout((View)(var22_22 = var6_6.mLogoView))) != 0) {
            if (var7_7 != 0) {
                var22_22 = var6_6.mLogoView;
                var18_18 = var6_6.layoutChildRight((View)var22_22, var18_18, var19_19, var20_20);
            } else {
                var22_22 = var6_6.mLogoView;
                var8_8 = var6_6.layoutChildLeft((View)var22_22, var8_8, var19_19, var20_20);
            }
        }
        var22_22 = var6_6.mTitleTextView;
        var21_21 = (int)var6_6.shouldLayout((View)var22_22);
        var28_28 = var6_6.mSubtitleTextView;
        var23_23 = (int)var6_6.shouldLayout((View)var28_28);
        if (var21_21 != 0) {
            var24_24 /* !! */  = (Toolbar$LayoutParams)var6_6.mTitleTextView.getLayoutParams();
            var9_9 = var24_24 /* !! */ .topMargin;
            var4_4 = var15_15;
            var15_15 = var6_6.mTitleTextView.getMeasuredHeight();
            var9_9 += var15_15;
            var15_15 = var24_24 /* !! */ .bottomMargin;
            var9_9 += var15_15;
            var15_15 = 0;
            var29_29 = null;
            var9_9 += 0;
        } else {
            var4_4 = var15_15;
            var9_9 = 0;
            var10_10 /* !! */  = null;
        }
        if (var23_23 != 0) {
            var29_29 = (Toolbar$LayoutParams)var6_6.mSubtitleTextView.getLayoutParams();
            var25_25 = var29_29.topMargin;
            var26_26 = var12_12;
            var30_30 /* !! */  = var6_6.mSubtitleTextView;
            var12_12 = var30_30 /* !! */ .getMeasuredHeight();
            var25_25 += var12_12;
            var12_12 = var29_29.bottomMargin;
            var9_9 += (var25_25 += var12_12);
        } else {
            var26_26 = var12_12;
        }
        if (var21_21 == 0 && var23_23 == 0) {
            var31_31 = var14_14;
            var3_3 = var20_20;
lbl121:
            // 2 sources

            while (true) {
                var7_7 = 0;
                var11_11 = null;
                break;
            }
        } else {
            var30_30 /* !! */  = var21_21 != 0 ? var6_6.mTitleTextView : var6_6.mSubtitleTextView;
            var29_29 = var23_23 != 0 ? var6_6.mSubtitleTextView : var6_6.mTitleTextView;
            var30_30 /* !! */  = (Toolbar$LayoutParams)var30_30 /* !! */ .getLayoutParams();
            var29_29 = (Toolbar$LayoutParams)var29_29.getLayoutParams();
            var27_27 = var21_21 != 0 && (var25_25 = (var24_24 /* !! */  = var6_6.mTitleTextView).getMeasuredWidth()) > 0 || var23_23 != 0 && (var25_25 = (var24_24 /* !! */  = var6_6.mSubtitleTextView).getMeasuredWidth()) > 0 ? 1 : 0;
            var25_25 = var6_6.mGravity & 112;
            var31_31 = var14_14;
            var14_14 = 48;
            if (var25_25 != var14_14) {
                var14_14 = 80;
                if (var25_25 != var14_14) {
                    var14_14 = (var13_13 - var16_16 - var17_17 - var9_9) / 2;
                    var25_25 = var30_30 /* !! */ .topMargin;
                    var3_3 = var20_20;
                    var20_20 = var6_6.mTitleMarginTop;
                    var5_5 = var8_8;
                    var8_8 = var25_25 + var20_20;
                    if (var14_14 < var8_8) {
                        var14_14 = var25_25 + var20_20;
                    } else {
                        var13_13 = var13_13 - var17_17 - var9_9 - var14_14 - var16_16;
                        var8_8 = var30_30 /* !! */ .bottomMargin;
                        var9_9 = var6_6.mTitleMarginBottom;
                        if (var13_13 < (var8_8 += var9_9)) {
                            var8_8 = var29_29.bottomMargin + var9_9 - var13_13;
                            var14_14 -= var8_8;
                            var8_8 = 0;
                            var32_32 = null;
                            var14_14 = Math.max(0, var14_14);
                        }
                    }
                    var16_16 += var14_14;
                } else {
                    var5_5 = var8_8;
                    var3_3 = var20_20;
                    var13_13 -= var17_17;
                    var8_8 = var29_29.bottomMargin;
                    var13_13 -= var8_8;
                    var8_8 = var6_6.mTitleMarginBottom;
                    var16_16 = (var13_13 -= var8_8) - var9_9;
                }
            } else {
                var5_5 = var8_8;
                var3_3 = var20_20;
                var8_8 = this.getPaddingTop();
                var9_9 = var30_30 /* !! */ .topMargin;
                var8_8 += var9_9;
                var9_9 = var6_6.mTitleMarginTop;
                var16_16 = var8_8 + var9_9;
            }
            if (var7_7 != 0) {
                if (var27_27 != 0) {
                    var7_7 = var6_6.mTitleMarginStart;
                } else {
                    var7_7 = 0;
                    var11_11 = null;
                }
                var8_8 = 1;
                var9_9 = var19_19[var8_8];
                var7_7 -= var9_9;
                var9_9 = 0;
                var10_10 /* !! */  = null;
                var12_12 = Math.max(0, var7_7);
                var18_18 -= var12_12;
                var7_7 = -var7_7;
                var19_19[var8_8] = var7_7 = Math.max(0, var7_7);
                if (var21_21 != 0) {
                    var11_11 = (Toolbar$LayoutParams)var6_6.mTitleTextView.getLayoutParams();
                    var32_32 = var6_6.mTitleTextView;
                    var8_8 = var32_32.getMeasuredWidth();
                    var8_8 = var18_18 - var8_8;
                    var10_10 /* !! */  = var6_6.mTitleTextView;
                    var9_9 = var10_10 /* !! */ .getMeasuredHeight() + var16_16;
                    var30_30 /* !! */  = var6_6.mTitleTextView;
                    var30_30 /* !! */ .layout(var8_8, var16_16, var18_18, var9_9);
                    var12_12 = var6_6.mTitleMarginEnd;
                    var8_8 -= var12_12;
                    var7_7 = var11_11.bottomMargin;
                    var16_16 = var9_9 + var7_7;
                } else {
                    var8_8 = var18_18;
                }
                if (var23_23 != 0) {
                    var11_11 = (Toolbar$LayoutParams)var6_6.mSubtitleTextView.getLayoutParams();
                    var9_9 = var11_11.topMargin;
                    var16_16 += var9_9;
                    var10_10 /* !! */  = var6_6.mSubtitleTextView;
                    var9_9 = var10_10 /* !! */ .getMeasuredWidth();
                    var9_9 = var18_18 - var9_9;
                    var30_30 /* !! */  = var6_6.mSubtitleTextView;
                    var12_12 = var30_30 /* !! */ .getMeasuredHeight() + var16_16;
                    var33_33 = var6_6.mSubtitleTextView;
                    var33_33.layout(var9_9, var16_16, var18_18, var12_12);
                    var9_9 = var6_6.mTitleMarginEnd;
                    var9_9 = var18_18 - var9_9;
                    var7_7 = var11_11.bottomMargin;
                } else {
                    var9_9 = var18_18;
                }
                if (var27_27 != 0) {
                    var18_18 = var7_7 = Math.min(var8_8, var9_9);
                }
                var8_8 = var5_5;
                ** continue;
            }
            if (var27_27 != 0) {
                var15_15 = var6_6.mTitleMarginStart;
                var7_7 = 0;
                var11_11 = null;
            } else {
                var7_7 = 0;
                var11_11 = null;
                var15_15 = 0;
                var29_29 = null;
            }
            var8_8 = var19_19[0];
            var15_15 -= var8_8;
            var8_8 = Math.max(0, var15_15);
            var8_8 = var5_5 + var8_8;
            var9_9 = -var15_15;
            var19_19[0] = var9_9 = Math.max(0, var9_9);
            if (var21_21 != 0) {
                var10_10 /* !! */  = (Toolbar$LayoutParams)var6_6.mTitleTextView.getLayoutParams();
                var30_30 /* !! */  = var6_6.mTitleTextView;
                var12_12 = var30_30 /* !! */ .getMeasuredWidth() + var8_8;
                var33_33 = var6_6.mTitleTextView;
                var13_13 = var33_33.getMeasuredHeight() + var16_16;
                var34_34 = var6_6.mTitleTextView;
                var34_34.layout(var8_8, var16_16, var12_12, var13_13);
                var14_14 = var6_6.mTitleMarginEnd;
                var12_12 += var14_14;
                var9_9 = var10_10 /* !! */ .bottomMargin;
                var16_16 = var13_13 + var9_9;
            } else {
                var12_12 = var8_8;
            }
            if (var23_23 != 0) {
                var10_10 /* !! */  = (Toolbar$LayoutParams)var6_6.mSubtitleTextView.getLayoutParams();
                var13_13 = var10_10 /* !! */ .topMargin;
                var16_16 += var13_13;
                var33_33 = var6_6.mSubtitleTextView;
                var13_13 = var33_33.getMeasuredWidth() + var8_8;
                var34_34 = var6_6.mSubtitleTextView;
                var14_14 = var34_34.getMeasuredHeight() + var16_16;
                var29_29 = var6_6.mSubtitleTextView;
                var29_29.layout(var8_8, var16_16, var13_13, var14_14);
                var14_14 = var6_6.mTitleMarginEnd;
                var13_13 += var14_14;
                var9_9 = var10_10 /* !! */ .bottomMargin;
            } else {
                var13_13 = var8_8;
            }
            if (var27_27 != 0) {
                var8_8 = Math.max(var12_12, var13_13);
            }
        }
        var10_10 /* !! */  = var6_6.mTempViews;
        var12_12 = 3;
        var6_6.addCustomViewsWithGravity(var10_10 /* !! */ , var12_12);
        var10_10 /* !! */  = var6_6.mTempViews;
        var9_9 = var10_10 /* !! */ .size();
        var29_29 = null;
        for (var15_15 = 0; var15_15 < var9_9; ++var15_15) {
            var30_30 /* !! */  = (View)var6_6.mTempViews.get(var15_15);
            var20_20 = var3_3;
            var8_8 = var6_6.layoutChildLeft((View)var30_30 /* !! */ , var8_8, var19_19, var3_3);
        }
        var20_20 = var3_3;
        var10_10 /* !! */  = var6_6.mTempViews;
        var12_12 = 5;
        var6_6.addCustomViewsWithGravity(var10_10 /* !! */ , var12_12);
        var10_10 /* !! */  = var6_6.mTempViews;
        var9_9 = var10_10 /* !! */ .size();
        var29_29 = null;
        for (var15_15 = 0; var15_15 < var9_9; ++var15_15) {
            var30_30 /* !! */  = (View)var6_6.mTempViews.get(var15_15);
            var18_18 = var6_6.layoutChildRight((View)var30_30 /* !! */ , var18_18, var19_19, var20_20);
        }
        var10_10 /* !! */  = var6_6.mTempViews;
        var6_6.addCustomViewsWithGravity(var10_10 /* !! */ , 1);
        var10_10 /* !! */  = var6_6.mTempViews;
        var9_9 = var6_6.getViewListMeasuredWidth(var10_10 /* !! */ , var19_19);
        var12_12 = (var26_26 - var31_31 - var4_4) / 2;
        var14_14 = var31_31 + var12_12;
        var12_12 = var9_9 / 2;
        var9_9 += (var14_14 -= var12_12);
        if (var14_14 >= var8_8) {
            var8_8 = var9_9 > var18_18 ? var14_14 - (var9_9 -= var18_18) : var14_14;
        }
        var10_10 /* !! */  = var6_6.mTempViews;
        var9_9 = var10_10 /* !! */ .size();
        while (var7_7 < var9_9) {
            var30_30 /* !! */  = (View)var6_6.mTempViews.get(var7_7);
            var8_8 = var6_6.layoutChildLeft((View)var30_30 /* !! */ , var8_8, var19_19, var20_20);
            ++var7_7;
        }
        var6_6.mTempViews.clear();
    }

    /*
     * WARNING - void declaration
     */
    public void onMeasure(int n10, int n11) {
        int n12;
        View view;
        boolean bl2;
        int n13;
        void var5_18;
        int n14;
        int n15;
        int n16;
        int n17;
        Object object;
        int n18;
        int n19;
        int n20;
        int n21;
        Object object2;
        int n22;
        int n23;
        Toolbar toolbar = this;
        int[] nArray = this.mTempMargins;
        boolean n212 = ViewUtils.isLayoutRtl((View)this);
        int n24 = 1;
        int n25 = 0;
        if (n212) {
            n23 = n24;
            n22 = 0;
        } else {
            n22 = n24;
            n23 = 0;
        }
        Object object3 = toolbar.mNavButtonView;
        boolean bl3 = toolbar.shouldLayout((View)object3);
        if (bl3) {
            object2 = toolbar.mNavButtonView;
            n21 = 0;
            n20 = toolbar.mMaxButtonHeight;
            n19 = 0;
            object3 = this;
            n18 = n10;
            this.measureChildConstrained((View)object2, n10, 0, n11, 0, n20);
            object3 = toolbar.mNavButtonView;
            int n26 = object3.getMeasuredWidth();
            object2 = toolbar.mNavButtonView;
            n24 = toolbar.getHorizontalMargins((View)object2);
            int n27 = n26 + n24;
            object2 = toolbar.mNavButtonView;
            n24 = object2.getMeasuredHeight();
            object = toolbar.mNavButtonView;
            n18 = toolbar.getVerticalMargins((View)object);
            n24 += n18;
            n24 = Math.max(0, n24);
            object = toolbar.mNavButtonView;
            n18 = object.getMeasuredState();
            n18 = View.combineMeasuredStates((int)0, (int)n18);
            n17 = n24;
            n16 = n18;
        } else {
            boolean bl4 = false;
            object3 = null;
            n17 = 0;
            n16 = 0;
        }
        object2 = toolbar.mCollapseButtonView;
        n24 = toolbar.shouldLayout((View)object2);
        if (n24 != 0) {
            object2 = toolbar.mCollapseButtonView;
            n21 = 0;
            n20 = toolbar.mMaxButtonHeight;
            n19 = 0;
            object3 = this;
            n18 = n10;
            this.measureChildConstrained((View)object2, n10, 0, n11, 0, n20);
            object3 = toolbar.mCollapseButtonView;
            int n28 = object3.getMeasuredWidth();
            object2 = toolbar.mCollapseButtonView;
            n24 = toolbar.getHorizontalMargins((View)object2);
            n15 = n28 + n24;
            n24 = toolbar.mCollapseButtonView.getMeasuredHeight();
            object = toolbar.mCollapseButtonView;
            n18 = toolbar.getVerticalMargins((View)object);
            n17 = Math.max(n17, n24 += n18);
            object2 = toolbar.mCollapseButtonView;
            n24 = object2.getMeasuredState();
            n16 = View.combineMeasuredStates((int)n16, (int)n24);
        }
        n24 = this.getCurrentContentInsetStart();
        n18 = Math.max(n24, n15);
        int n29 = 0 + n18;
        nArray[n23] = n14 = Math.max(0, n24 -= n15);
        object3 = toolbar.mMenuView;
        boolean bl5 = toolbar.shouldLayout((View)object3);
        if (bl5) {
            object2 = toolbar.mMenuView;
            n21 = 0;
            n20 = toolbar.mMaxButtonHeight;
            object3 = this;
            n18 = n10;
            n19 = n29;
            this.measureChildConstrained((View)object2, n10, n29, n11, 0, n20);
            object3 = toolbar.mMenuView;
            int n30 = object3.getMeasuredWidth();
            object2 = toolbar.mMenuView;
            n24 = toolbar.getHorizontalMargins((View)object2);
            int n31 = n30 + n24;
            n24 = toolbar.mMenuView.getMeasuredHeight();
            object = toolbar.mMenuView;
            n18 = toolbar.getVerticalMargins((View)object);
            n17 = Math.max(n17, n24 += n18);
            object2 = toolbar.mMenuView;
            n24 = object2.getMeasuredState();
            n16 = View.combineMeasuredStates((int)n16, (int)n24);
        } else {
            boolean bl6 = false;
            object3 = null;
        }
        n24 = this.getCurrentContentInsetEnd();
        n18 = Math.max(n24, (int)var5_18);
        n29 += n18;
        nArray[n22] = n13 = Math.max(0, n24 -= var5_18);
        object3 = toolbar.mExpandedActionView;
        boolean bl7 = toolbar.shouldLayout((View)object3);
        if (bl7) {
            object2 = toolbar.mExpandedActionView;
            n21 = 0;
            object3 = this;
            n18 = n10;
            n19 = n29;
            int n32 = this.measureChildCollapseMargins((View)object2, n10, n29, n11, 0, nArray);
            n29 += n32;
            int n33 = toolbar.mExpandedActionView.getMeasuredHeight();
            object2 = toolbar.mExpandedActionView;
            n24 = toolbar.getVerticalMargins((View)object2);
            int n34 = n33 + n24;
            n17 = Math.max(n17, n34);
            object3 = toolbar.mExpandedActionView;
            int n35 = object3.getMeasuredState();
            n16 = View.combineMeasuredStates((int)n16, (int)n35);
        }
        if (bl2 = toolbar.shouldLayout((View)(object3 = toolbar.mLogoView))) {
            object2 = toolbar.mLogoView;
            n21 = 0;
            object3 = this;
            n18 = n10;
            n19 = n29;
            int n36 = this.measureChildCollapseMargins((View)object2, n10, n29, n11, 0, nArray);
            n29 += n36;
            int n37 = toolbar.mLogoView.getMeasuredHeight();
            object2 = toolbar.mLogoView;
            n24 = toolbar.getVerticalMargins((View)object2);
            int n38 = n37 + n24;
            n17 = Math.max(n17, n38);
            object3 = toolbar.mLogoView;
            int n39 = object3.getMeasuredState();
            n16 = View.combineMeasuredStates((int)n16, (int)n39);
        }
        n23 = this.getChildCount();
        for (n22 = 0; n22 < n23; ++n22) {
            view = toolbar.getChildAt(n22);
            object3 = (Toolbar$LayoutParams)view.getLayoutParams();
            int n40 = object3.mViewType;
            if (n40 != 0 || (n40 = (int)(toolbar.shouldLayout(view) ? 1 : 0)) == 0) continue;
            n21 = 0;
            object3 = this;
            object2 = view;
            n18 = n10;
            n19 = n29;
            n40 = this.measureChildCollapseMargins(view, n10, n29, n11, 0, nArray);
            n29 += n40;
            n40 = view.getMeasuredHeight();
            n24 = toolbar.getVerticalMargins(view);
            n40 += n24;
            n40 = Math.max(n17, n40);
            n24 = view.getMeasuredState();
            n24 = View.combineMeasuredStates((int)n16, (int)n24);
            n17 = n40;
            n16 = n24;
        }
        int n41 = toolbar.mTitleMarginTop;
        n24 = toolbar.mTitleMarginBottom;
        n23 = n41 + n24;
        int n42 = toolbar.mTitleMarginStart;
        n24 = toolbar.mTitleMarginEnd;
        n22 = n42 + n24;
        object3 = toolbar.mTitleTextView;
        boolean bl8 = toolbar.shouldLayout((View)object3);
        if (bl8) {
            object2 = toolbar.mTitleTextView;
            n19 = n29 + n22;
            object3 = this;
            n18 = n10;
            n21 = n23;
            this.measureChildCollapseMargins((View)object2, n10, n19, n11, n23, nArray);
            object3 = toolbar.mTitleTextView;
            int n43 = object3.getMeasuredWidth();
            object2 = toolbar.mTitleTextView;
            n24 = toolbar.getHorizontalMargins((View)object2);
            int n44 = n43 + n24;
            object2 = toolbar.mTitleTextView;
            n24 = object2.getMeasuredHeight();
            object = toolbar.mTitleTextView;
            n18 = toolbar.getVerticalMargins((View)object);
            n24 += n18;
            object = toolbar.mTitleTextView;
            n18 = object.getMeasuredState();
            n16 = View.combineMeasuredStates((int)n16, (int)n18);
            n12 = n24;
            n20 = n16;
            n16 = n44;
        } else {
            n12 = 0;
            view = null;
            n20 = n16;
            n16 = 0;
        }
        object3 = toolbar.mSubtitleTextView;
        boolean bl9 = toolbar.shouldLayout((View)object3);
        if (bl9) {
            object2 = toolbar.mSubtitleTextView;
            n19 = n29 + n22;
            n21 = n12 + n23;
            object3 = this;
            n18 = n10;
            n23 = n20;
            int n45 = this.measureChildCollapseMargins((View)object2, n10, n19, n11, n21, nArray);
            n16 = Math.max(n16, n45);
            int n46 = toolbar.mSubtitleTextView.getMeasuredHeight();
            object2 = toolbar.mSubtitleTextView;
            n24 = toolbar.getVerticalMargins((View)object2);
            int n47 = n46 + n24;
            n12 += n47;
            object3 = toolbar.mSubtitleTextView;
            int n48 = object3.getMeasuredState();
            n20 = View.combineMeasuredStates((int)n20, (int)n48);
        } else {
            n23 = n20;
        }
        n29 += n16;
        int n49 = Math.max(n17, n12);
        n24 = this.getPaddingLeft();
        n18 = this.getPaddingRight();
        n29 += (n24 += n18);
        n24 = this.getPaddingTop();
        n18 = this.getPaddingBottom();
        int n50 = n49 + (n24 += n18);
        n24 = this.getSuggestedMinimumWidth();
        n24 = Math.max(n29, n24);
        n18 = 0xFF000000 & n20;
        n19 = n10;
        n24 = View.resolveSizeAndState((int)n24, (int)n10, (int)n18);
        n18 = this.getSuggestedMinimumHeight();
        int n51 = Math.max(n50, n18);
        n18 = n20 << 16;
        n19 = n11;
        int n52 = View.resolveSizeAndState((int)n51, (int)n11, (int)n18);
        n18 = this.shouldCollapse() ? 1 : 0;
        if (n18 == 0) {
            n25 = n52;
        }
        toolbar.setMeasuredDimension(n24, n25);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2;
        Toolbar$ExpandedActionViewMenuPresenter toolbar$ExpandedActionViewMenuPresenter;
        boolean bl3 = parcelable instanceof Toolbar$SavedState;
        if (!bl3) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (Toolbar$SavedState)parcelable;
        Object object = parcelable.getSuperState();
        super.onRestoreInstanceState((Parcelable)object);
        object = this.mMenuView;
        if (object != null) {
            object = ((ActionMenuView)object).peekMenu();
        } else {
            bl3 = false;
            object = null;
        }
        int n10 = parcelable.expandedMenuItemId;
        if (n10 != 0 && (toolbar$ExpandedActionViewMenuPresenter = this.mExpandedMenuPresenter) != null && object != null && (object = object.findItem(n10)) != null) {
            object.expandActionView();
        }
        if (bl2 = parcelable.isOverflowOpen) {
            this.postShowOverflowMenu();
        }
    }

    public void onRtlPropertiesChanged(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 >= n12) {
            super.onRtlPropertiesChanged(n10);
        }
        this.ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        n12 = 1;
        if (n10 != n12) {
            n12 = 0;
        }
        rtlSpacingHelper.setDirection(n12 != 0);
    }

    public Parcelable onSaveInstanceState() {
        int n10;
        Object object = super.onSaveInstanceState();
        Toolbar$SavedState toolbar$SavedState = new Toolbar$SavedState((Parcelable)object);
        object = this.mExpandedMenuPresenter;
        if (object != null && (object = ((Toolbar$ExpandedActionViewMenuPresenter)object).mCurrentExpandedItem) != null) {
            toolbar$SavedState.expandedMenuItemId = n10 = ((MenuItemImpl)object).getItemId();
        }
        toolbar$SavedState.isOverflowOpen = n10 = this.isOverflowMenuShowing();
        return toolbar$SavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getActionMasked();
        if (!n11) {
            this.mEatingTouch = false;
        }
        boolean bl2 = this.mEatingTouch;
        int n12 = 1;
        if (!bl2) {
            n10 = super.onTouchEvent(motionEvent);
            if (!n11 && !n10) {
                this.mEatingTouch = n12;
            }
        }
        if (n11 == n12 || n11 == (n10 = 3)) {
            this.mEatingTouch = false;
        }
        return n12 != 0;
    }

    public void removeChildrenForExpandedActionView() {
        for (int i10 = this.getChildCount() + -1; i10 >= 0; i10 += -1) {
            View view = this.getChildAt(i10);
            Object object = (Toolbar$LayoutParams)view.getLayoutParams();
            int n10 = ((Toolbar$LayoutParams)object).mViewType;
            int n11 = 2;
            if (n10 == n11 || view == (object = this.mMenuView)) continue;
            this.removeViewAt(i10);
            object = this.mHiddenViews;
            ((ArrayList)object).add(view);
        }
    }

    public void setCollapseContentDescription(int n10) {
        CharSequence charSequence;
        if (n10 != 0) {
            Context context = this.getContext();
            charSequence = context.getText(n10);
        } else {
            n10 = 0;
            charSequence = null;
        }
        this.setCollapseContentDescription(charSequence);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        ImageButton imageButton;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl2) {
            this.ensureCollapseButtonView();
        }
        if ((imageButton = this.mCollapseButtonView) != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getContext(), n10);
        this.setCollapseIcon(drawable2);
    }

    public void setCollapseIcon(Drawable drawable2) {
        if (drawable2 != null) {
            this.ensureCollapseButtonView();
            ImageButton imageButton = this.mCollapseButtonView;
            imageButton.setImageDrawable(drawable2);
        } else {
            drawable2 = this.mCollapseButtonView;
            if (drawable2 != null) {
                Drawable drawable3 = this.mCollapseIcon;
                drawable2.setImageDrawable(drawable3);
            }
        }
    }

    public void setCollapsible(boolean bl2) {
        this.mCollapsible = bl2;
        this.requestLayout();
    }

    public void setContentInsetEndWithActions(int n10) {
        int n11;
        if (n10 < 0) {
            n10 = -1 << -1;
        }
        if (n10 != (n11 = this.mContentInsetEndWithActions)) {
            this.mContentInsetEndWithActions = n10;
            Drawable drawable2 = this.getNavigationIcon();
            if (drawable2 != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int n10) {
        int n11;
        if (n10 < 0) {
            n10 = -1 << -1;
        }
        if (n10 != (n11 = this.mContentInsetStartWithNavigation)) {
            this.mContentInsetStartWithNavigation = n10;
            Drawable drawable2 = this.getNavigationIcon();
            if (drawable2 != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetsAbsolute(int n10, int n11) {
        this.ensureContentInsets();
        this.mContentInsets.setAbsolute(n10, n11);
    }

    public void setContentInsetsRelative(int n10, int n11) {
        this.ensureContentInsets();
        this.mContentInsets.setRelative(n10, n11);
    }

    public void setLogo(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getContext(), n10);
        this.setLogo(drawable2);
    }

    public void setLogo(Drawable drawable2) {
        Object object;
        if (drawable2 != null) {
            this.ensureLogoView();
            object = this.mLogoView;
            boolean bl2 = this.isChildOrHidden((View)object);
            if (!bl2) {
                object = this.mLogoView;
                boolean bl3 = true;
                this.addSystemView((View)object, bl3);
            }
        } else {
            boolean bl4;
            object = this.mLogoView;
            if (object != null && (bl4 = this.isChildOrHidden((View)object))) {
                object = this.mLogoView;
                this.removeView((View)object);
                object = this.mHiddenViews;
                ImageView imageView = this.mLogoView;
                ((ArrayList)object).remove(imageView);
            }
        }
        if ((object = this.mLogoView) != null) {
            object.setImageDrawable(drawable2);
        }
    }

    public void setLogoDescription(int n10) {
        CharSequence charSequence = this.getContext().getText(n10);
        this.setLogoDescription(charSequence);
    }

    public void setLogoDescription(CharSequence charSequence) {
        ImageView imageView;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl2) {
            this.ensureLogoView();
        }
        if ((imageView = this.mLogoView) != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setMenu(MenuBuilder object, ActionMenuPresenter actionMenuPresenter) {
        MenuPresenter menuPresenter;
        Object object2;
        if (object == null && (object2 = this.mMenuView) == null) {
            return;
        }
        this.ensureMenuView();
        object2 = this.mMenuView.peekMenu();
        if (object2 == object) {
            return;
        }
        if (object2 != null) {
            menuPresenter = this.mOuterActionMenuPresenter;
            ((MenuBuilder)object2).removeMenuPresenter(menuPresenter);
            menuPresenter = this.mExpandedMenuPresenter;
            ((MenuBuilder)object2).removeMenuPresenter(menuPresenter);
        }
        if ((object2 = this.mExpandedMenuPresenter) == null) {
            this.mExpandedMenuPresenter = object2 = new Toolbar$ExpandedActionViewMenuPresenter(this);
        }
        boolean bl2 = true;
        actionMenuPresenter.setExpandedActionViewsExclusive(bl2);
        if (object != null) {
            object2 = this.mPopupContext;
            ((MenuBuilder)object).addMenuPresenter(actionMenuPresenter, (Context)object2);
            object2 = this.mExpandedMenuPresenter;
            menuPresenter = this.mPopupContext;
            ((MenuBuilder)object).addMenuPresenter((MenuPresenter)object2, (Context)menuPresenter);
        } else {
            object = this.mPopupContext;
            menuPresenter = null;
            actionMenuPresenter.initForMenu((Context)object, null);
            object = this.mExpandedMenuPresenter;
            Context context = this.mPopupContext;
            ((Toolbar$ExpandedActionViewMenuPresenter)object).initForMenu(context, null);
            actionMenuPresenter.updateMenuView(bl2);
            object = this.mExpandedMenuPresenter;
            ((Toolbar$ExpandedActionViewMenuPresenter)object).updateMenuView(bl2);
        }
        object = this.mMenuView;
        int n10 = this.mPopupTheme;
        ((ActionMenuView)object).setPopupTheme(n10);
        this.mMenuView.setPresenter(actionMenuPresenter);
        this.mOuterActionMenuPresenter = actionMenuPresenter;
    }

    public void setMenuCallbacks(MenuPresenter$Callback menuPresenter$Callback, MenuBuilder$Callback menuBuilder$Callback) {
        this.mActionMenuPresenterCallback = menuPresenter$Callback;
        this.mMenuBuilderCallback = menuBuilder$Callback;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.setMenuCallbacks(menuPresenter$Callback, menuBuilder$Callback);
        }
    }

    public void setNavigationContentDescription(int n10) {
        CharSequence charSequence;
        if (n10 != 0) {
            Context context = this.getContext();
            charSequence = context.getText(n10);
        } else {
            n10 = 0;
            charSequence = null;
        }
        this.setNavigationContentDescription(charSequence);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        ImageButton imageButton;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl2) {
            this.ensureNavButtonView();
        }
        if ((imageButton = this.mNavButtonView) != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getContext(), n10);
        this.setNavigationIcon(drawable2);
    }

    public void setNavigationIcon(Drawable drawable2) {
        Object object;
        if (drawable2 != null) {
            this.ensureNavButtonView();
            object = this.mNavButtonView;
            boolean bl2 = this.isChildOrHidden((View)object);
            if (!bl2) {
                object = this.mNavButtonView;
                boolean bl3 = true;
                this.addSystemView((View)object, bl3);
            }
        } else {
            boolean bl4;
            object = this.mNavButtonView;
            if (object != null && (bl4 = this.isChildOrHidden((View)object))) {
                object = this.mNavButtonView;
                this.removeView((View)object);
                object = this.mHiddenViews;
                ImageButton imageButton = this.mNavButtonView;
                ((ArrayList)object).remove(imageButton);
            }
        }
        if ((object = this.mNavButtonView) != null) {
            object.setImageDrawable(drawable2);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        this.ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(Toolbar$OnMenuItemClickListener toolbar$OnMenuItemClickListener) {
        this.mOnMenuItemClickListener = toolbar$OnMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable2) {
        this.ensureMenu();
        this.mMenuView.setOverflowIcon(drawable2);
    }

    public void setPopupTheme(int n10) {
        int n11 = this.mPopupTheme;
        if (n11 != n10) {
            this.mPopupTheme = n10;
            if (n10 == 0) {
                Context context;
                this.mPopupContext = context = this.getContext();
            } else {
                Context context = this.getContext();
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, n10);
                this.mPopupContext = contextThemeWrapper;
            }
        }
    }

    public void setSubtitle(int n10) {
        CharSequence charSequence = this.getContext().getText(n10);
        this.setSubtitle(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        Object object;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl2) {
            int n10;
            object = this.mSubtitleTextView;
            if (object == null) {
                object = this.getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView((Context)object);
                this.mSubtitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                appCompatTextView = this.mSubtitleTextView;
                TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                appCompatTextView.setEllipsize(truncateAt);
                n10 = this.mSubtitleTextAppearance;
                if (n10 != 0) {
                    truncateAt = this.mSubtitleTextView;
                    truncateAt.setTextAppearance((Context)object, n10);
                }
                if ((object = this.mSubtitleTextColor) != null) {
                    appCompatTextView = this.mSubtitleTextView;
                    appCompatTextView.setTextColor((ColorStateList)object);
                }
            }
            if (!(bl2 = this.isChildOrHidden((View)(object = this.mSubtitleTextView)))) {
                object = this.mSubtitleTextView;
                n10 = 1;
                this.addSystemView((View)object, n10 != 0);
            }
        } else {
            object = this.mSubtitleTextView;
            if (object != null && (bl2 = this.isChildOrHidden((View)object))) {
                object = this.mSubtitleTextView;
                this.removeView((View)object);
                object = this.mHiddenViews;
                TextView textView = this.mSubtitleTextView;
                ((ArrayList)object).remove(textView);
            }
        }
        if ((object = this.mSubtitleTextView) != null) {
            object.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextAppearance(Context context, int n10) {
        this.mSubtitleTextAppearance = n10;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, n10);
        }
    }

    public void setSubtitleTextColor(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        this.setSubtitleTextColor(colorStateList);
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        TextView textView = this.mSubtitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int n10) {
        CharSequence charSequence = this.getContext().getText(n10);
        this.setTitle(charSequence);
    }

    public void setTitle(CharSequence charSequence) {
        Object object;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (!bl2) {
            int n10;
            object = this.mTitleTextView;
            if (object == null) {
                object = this.getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView((Context)object);
                this.mTitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                appCompatTextView = this.mTitleTextView;
                TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
                appCompatTextView.setEllipsize(truncateAt);
                n10 = this.mTitleTextAppearance;
                if (n10 != 0) {
                    truncateAt = this.mTitleTextView;
                    truncateAt.setTextAppearance((Context)object, n10);
                }
                if ((object = this.mTitleTextColor) != null) {
                    appCompatTextView = this.mTitleTextView;
                    appCompatTextView.setTextColor((ColorStateList)object);
                }
            }
            if (!(bl2 = this.isChildOrHidden((View)(object = this.mTitleTextView)))) {
                object = this.mTitleTextView;
                n10 = 1;
                this.addSystemView((View)object, n10 != 0);
            }
        } else {
            object = this.mTitleTextView;
            if (object != null && (bl2 = this.isChildOrHidden((View)object))) {
                object = this.mTitleTextView;
                this.removeView((View)object);
                object = this.mHiddenViews;
                TextView textView = this.mTitleTextView;
                ((ArrayList)object).remove(textView);
            }
        }
        if ((object = this.mTitleTextView) != null) {
            object.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleMargin(int n10, int n11, int n12, int n13) {
        this.mTitleMarginStart = n10;
        this.mTitleMarginTop = n11;
        this.mTitleMarginEnd = n12;
        this.mTitleMarginBottom = n13;
        this.requestLayout();
    }

    public void setTitleMarginBottom(int n10) {
        this.mTitleMarginBottom = n10;
        this.requestLayout();
    }

    public void setTitleMarginEnd(int n10) {
        this.mTitleMarginEnd = n10;
        this.requestLayout();
    }

    public void setTitleMarginStart(int n10) {
        this.mTitleMarginStart = n10;
        this.requestLayout();
    }

    public void setTitleMarginTop(int n10) {
        this.mTitleMarginTop = n10;
        this.requestLayout();
    }

    public void setTitleTextAppearance(Context context, int n10) {
        this.mTitleTextAppearance = n10;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextAppearance(context, n10);
        }
    }

    public void setTitleTextColor(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        this.setTitleTextColor(colorStateList);
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public boolean showOverflowMenu() {
        boolean bl2;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null && (bl2 = actionMenuView.showOverflowMenu())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuView = null;
        }
        return bl2;
    }
}

