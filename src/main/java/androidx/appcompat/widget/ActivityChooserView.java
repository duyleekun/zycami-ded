/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.res.TypedArray
 *  android.database.DataSetObserver
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.ListAdapter
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.ActivityChooserModel$ActivityChooserModelClient;
import androidx.appcompat.widget.ActivityChooserView$1;
import androidx.appcompat.widget.ActivityChooserView$ActivityChooserViewAdapter;
import androidx.appcompat.widget.ActivityChooserView$Callbacks;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;

public class ActivityChooserView
extends ViewGroup
implements ActivityChooserModel$ActivityChooserModelClient {
    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    public final ActivityChooserView$ActivityChooserViewAdapter mAdapter;
    private final ActivityChooserView$Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    public final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    public final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    public int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    public boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    public final DataSetObserver mModelDataSetObserver;
    public PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    public ActionProvider mProvider;

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet object, int n10) {
        super(context, object, n10);
        int n11;
        Object object2 = new ActivityChooserView$1(this);
        this.mModelDataSetObserver = object2;
        super(this);
        this.mOnGlobalLayoutListener = object2;
        this.mInitialActivityCount = n11 = 4;
        int[] nArray = R$styleable.ActivityChooserView;
        TypedArray typedArray = context.obtainStyledAttributes(object, nArray, n10, 0);
        ViewCompat.saveAttributeDataForStyleable((View)this, context, nArray, object, typedArray, n10, 0);
        int n12 = R$styleable.ActivityChooserView_initialActivityCount;
        this.mInitialActivityCount = n12 = typedArray.getInt(n12, n11);
        n12 = R$styleable.ActivityChooserView_expandActivityOverflowButtonDrawable;
        object = typedArray.getDrawable(n12);
        typedArray.recycle();
        Object object3 = LayoutInflater.from((Context)this.getContext());
        n11 = R$layout.abc_activity_chooser_view;
        object3.inflate(n11, (ViewGroup)this, true);
        super(this);
        this.mCallbacks = object3;
        n11 = R$id.activity_chooser_view_content;
        object2 = this.findViewById(n11);
        this.mActivityChooserContent = object2;
        object2 = object2.getBackground();
        this.mActivityChooserContentBackground = object2;
        n11 = R$id.default_activity_button;
        object2 = (FrameLayout)this.findViewById(n11);
        this.mDefaultActivityButton = object2;
        object2.setOnClickListener((View.OnClickListener)object3);
        object2.setOnLongClickListener((View.OnLongClickListener)object3);
        int n13 = R$id.image;
        object2 = (ImageView)object2.findViewById(n13);
        this.mDefaultActivityButtonImage = object2;
        n11 = R$id.expand_activities_button;
        object2 = (FrameLayout)this.findViewById(n11);
        object2.setOnClickListener((View.OnClickListener)object3);
        super(this);
        object2.setAccessibilityDelegate((View.AccessibilityDelegate)object3);
        super(this, (View)object2);
        object2.setOnTouchListener((View.OnTouchListener)object3);
        this.mExpandActivityOverflowButton = object2;
        object3 = (ImageView)object2.findViewById(n13);
        this.mExpandActivityOverflowButtonImage = object3;
        object3.setImageDrawable((Drawable)object);
        super(this);
        this.mAdapter = object;
        super(this);
        object.registerDataSetObserver((DataSetObserver)object3);
        context = context.getResources();
        n12 = context.getDisplayMetrics().widthPixels / 2;
        n10 = R$dimen.abc_config_prefDialogWidth;
        int n14 = context.getDimensionPixelSize(n10);
        this.mListPopupMaxWidth = n14 = Math.max(n12, n14);
    }

    public boolean dismissPopup() {
        boolean bl2 = this.isShowingPopup();
        if (bl2) {
            this.getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
            boolean bl3 = viewTreeObserver.isAlive();
            if (bl3) {
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.mOnGlobalLayoutListener;
                viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
            }
        }
        return true;
    }

    public ActivityChooserModel getDataModel() {
        return this.mAdapter.getDataModel();
    }

    public ListPopupWindow getListPopupWindow() {
        ListPopupWindow listPopupWindow = this.mListPopupWindow;
        if (listPopupWindow == null) {
            Object object = this.getContext();
            this.mListPopupWindow = listPopupWindow = new ListPopupWindow((Context)object);
            object = this.mAdapter;
            listPopupWindow.setAdapter((ListAdapter)object);
            this.mListPopupWindow.setAnchorView((View)this);
            listPopupWindow = this.mListPopupWindow;
            boolean bl2 = true;
            listPopupWindow.setModal(bl2);
            listPopupWindow = this.mListPopupWindow;
            object = this.mCallbacks;
            listPopupWindow.setOnItemClickListener((AdapterView.OnItemClickListener)object);
            listPopupWindow = this.mListPopupWindow;
            object = this.mCallbacks;
            listPopupWindow.setOnDismissListener((PopupWindow.OnDismissListener)object);
        }
        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return this.getListPopupWindow().isShowing();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ActivityChooserModel activityChooserModel = this.mAdapter.getDataModel();
        if (activityChooserModel != null) {
            DataSetObserver dataSetObserver = this.mModelDataSetObserver;
            activityChooserModel.registerObserver(dataSetObserver);
        }
        this.mIsAttachedToWindow = true;
    }

    public void onDetachedFromWindow() {
        boolean bl2;
        boolean bl3;
        DataSetObserver dataSetObserver;
        super.onDetachedFromWindow();
        ActivityChooserModel activityChooserModel = this.mAdapter.getDataModel();
        if (activityChooserModel != null) {
            dataSetObserver = this.mModelDataSetObserver;
            activityChooserModel.unregisterObserver(dataSetObserver);
        }
        if (bl3 = (activityChooserModel = this.getViewTreeObserver()).isAlive()) {
            dataSetObserver = this.mOnGlobalLayoutListener;
            activityChooserModel.removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)dataSetObserver);
        }
        if (bl2 = this.isShowingPopup()) {
            this.dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        View view = this.mActivityChooserContent;
        n12 -= n10;
        n10 = 0;
        view.layout(0, 0, n12, n13 -= n11);
        bl2 = this.isShowingPopup();
        if (!bl2) {
            this.dismissPopup();
        }
    }

    public void onMeasure(int n10, int n11) {
        View view = this.mActivityChooserContent;
        FrameLayout frameLayout = this.mDefaultActivityButton;
        int n12 = frameLayout.getVisibility();
        if (n12 != 0) {
            n11 = View.MeasureSpec.getSize((int)n11);
            n12 = 0x40000000;
            n11 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n12);
        }
        this.measureChild(view, n10, n11);
        n10 = view.getMeasuredWidth();
        n11 = view.getMeasuredHeight();
        this.setMeasuredDimension(n10, n11);
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        ActivityChooserView$ActivityChooserViewAdapter activityChooserView$ActivityChooserViewAdapter = this.mAdapter;
        activityChooserView$ActivityChooserViewAdapter.setDataModel(activityChooserModel);
        boolean bl2 = this.isShowingPopup();
        if (bl2) {
            this.dismissPopup();
            this.showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int n10) {
        this.mDefaultActionButtonContentDescription = n10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int n10) {
        String string2 = this.getContext().getString(n10);
        this.mExpandActivityOverflowButtonImage.setContentDescription((CharSequence)string2);
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable2) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable2);
    }

    public void setInitialActivityCount(int n10) {
        this.mInitialActivityCount = n10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.mProvider = actionProvider;
    }

    public boolean showPopup() {
        int n10 = this.isShowingPopup();
        if (n10 == 0 && (n10 = this.mIsAttachedToWindow) != 0) {
            this.mIsSelectingDefaultActivity = false;
            n10 = this.mInitialActivityCount;
            this.showPopupUnchecked(n10);
            return true;
        }
        return false;
    }

    public void showPopupUnchecked(int n10) {
        Object object = this.mAdapter.getDataModel();
        if (object != null) {
            object = this.getViewTreeObserver();
            Object object2 = this.mOnGlobalLayoutListener;
            object.addOnGlobalLayoutListener(object2);
            object = this.mDefaultActivityButton;
            int n11 = object.getVisibility();
            int n12 = 1;
            if (n11 == 0) {
                n11 = n12;
            } else {
                n11 = 0;
                object = null;
            }
            ActivityChooserView$ActivityChooserViewAdapter activityChooserView$ActivityChooserViewAdapter = this.mAdapter;
            int n13 = activityChooserView$ActivityChooserViewAdapter.getActivityCount();
            int n14 = -1 >>> 1;
            if (n10 != n14 && n13 > (n14 = n10 + n11)) {
                this.mAdapter.setShowFooterView(n12 != 0);
                activityChooserView$ActivityChooserViewAdapter = this.mAdapter;
                activityChooserView$ActivityChooserViewAdapter.setMaxActivityCount(n10 -= n12);
            } else {
                this.mAdapter.setShowFooterView(false);
                activityChooserView$ActivityChooserViewAdapter = this.mAdapter;
                activityChooserView$ActivityChooserViewAdapter.setMaxActivityCount(n10);
            }
            ListPopupWindow listPopupWindow = this.getListPopupWindow();
            n13 = (int)(listPopupWindow.isShowing() ? 1 : 0);
            if (n13 == 0) {
                n13 = (int)(this.mIsSelectingDefaultActivity ? 1 : 0);
                if (n13 == 0 && n11 != 0) {
                    object = this.mAdapter;
                    ((ActivityChooserView$ActivityChooserViewAdapter)((Object)object)).setShowDefaultActivity(false, false);
                } else {
                    activityChooserView$ActivityChooserViewAdapter = this.mAdapter;
                    activityChooserView$ActivityChooserViewAdapter.setShowDefaultActivity(n12 != 0, n11 != 0);
                }
                n11 = this.mAdapter.measureContentWidth();
                n13 = this.mListPopupMaxWidth;
                n11 = Math.min(n11, n13);
                listPopupWindow.setContentWidth(n11);
                listPopupWindow.show();
                object = this.mProvider;
                if (object != null) {
                    ((ActionProvider)object).subUiVisibilityChanged(n12 != 0);
                }
                object = listPopupWindow.getListView();
                object2 = this.getContext();
                n13 = R$string.abc_activitychooserview_choose_application;
                object2 = object2.getString(n13);
                object.setContentDescription((CharSequence)object2);
                listPopupWindow = listPopupWindow.getListView();
                object = new ColorDrawable(0);
                listPopupWindow.setSelector((Drawable)object);
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No data model. Did you call #setDataModel?");
        throw illegalStateException;
    }

    public void updateAppearance() {
        Object object = this.mAdapter;
        int n10 = object.getCount();
        int n11 = 0;
        Drawable drawable2 = null;
        int n12 = 1;
        if (n10 > 0) {
            object = this.mExpandActivityOverflowButton;
            object.setEnabled(n12 != 0);
        } else {
            object = this.mExpandActivityOverflowButton;
            object.setEnabled(false);
        }
        object = this.mAdapter;
        n10 = object.getActivityCount();
        ActivityChooserView$ActivityChooserViewAdapter activityChooserView$ActivityChooserViewAdapter = this.mAdapter;
        int n13 = activityChooserView$ActivityChooserViewAdapter.getHistorySize();
        if (n10 != n12 && (n10 <= n12 || n13 <= 0)) {
            object = this.mDefaultActivityButton;
            n11 = 8;
            object.setVisibility(n11);
        } else {
            this.mDefaultActivityButton.setVisibility(0);
            object = this.mAdapter.getDefaultActivity();
            activityChooserView$ActivityChooserViewAdapter = this.getContext().getPackageManager();
            ImageView imageView = this.mDefaultActivityButtonImage;
            Drawable drawable3 = object.loadIcon((PackageManager)activityChooserView$ActivityChooserViewAdapter);
            imageView.setImageDrawable(drawable3);
            int n14 = this.mDefaultActionButtonContentDescription;
            if (n14 != 0) {
                object = object.loadLabel((PackageManager)activityChooserView$ActivityChooserViewAdapter);
                activityChooserView$ActivityChooserViewAdapter = this.getContext();
                n14 = this.mDefaultActionButtonContentDescription;
                Object[] objectArray = new Object[n12];
                objectArray[0] = object;
                object = activityChooserView$ActivityChooserViewAdapter.getString(n14, objectArray);
                drawable2 = this.mDefaultActivityButton;
                drawable2.setContentDescription((CharSequence)object);
            }
        }
        object = this.mDefaultActivityButton;
        n10 = object.getVisibility();
        if (n10 == 0) {
            object = this.mActivityChooserContent;
            drawable2 = this.mActivityChooserContentBackground;
            object.setBackgroundDrawable(drawable2);
        } else {
            object = this.mActivityChooserContent;
            n11 = 0;
            drawable2 = null;
            object.setBackgroundDrawable(null);
        }
    }
}

