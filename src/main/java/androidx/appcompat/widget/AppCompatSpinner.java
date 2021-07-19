/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.ArrayAdapter
 *  android.widget.Spinner
 *  android.widget.SpinnerAdapter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatSpinner$1;
import androidx.appcompat.widget.AppCompatSpinner$2;
import androidx.appcompat.widget.AppCompatSpinner$DialogPopup;
import androidx.appcompat.widget.AppCompatSpinner$DropDownAdapter;
import androidx.appcompat.widget.AppCompatSpinner$DropdownPopup;
import androidx.appcompat.widget.AppCompatSpinner$SavedState;
import androidx.appcompat.widget.AppCompatSpinner$SpinnerPopup;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.TintableBackgroundView;

public class AppCompatSpinner
extends Spinner
implements TintableBackgroundView {
    private static final int[] ATTRS_ANDROID_SPINNERMODE;
    private static final int MAX_ITEMS_MEASURED = 15;
    private static final int MODE_DIALOG = 0;
    private static final int MODE_DROPDOWN = 1;
    private static final int MODE_THEME = 255;
    private static final String TAG = "AppCompatSpinner";
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    public int mDropDownWidth;
    private ForwardingListener mForwardingListener;
    private AppCompatSpinner$SpinnerPopup mPopup;
    private final Context mPopupContext;
    private final boolean mPopupSet;
    private SpinnerAdapter mTempAdapter;
    public final Rect mTempRect;

    static {
        int[] nArray = new int[]{16843505};
        ATTRS_ANDROID_SPINNERMODE = nArray;
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public AppCompatSpinner(Context context, int n10) {
        int n11 = R$attr.spinnerStyle;
        this(context, null, n11, n10);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.spinnerStyle;
        this(context, attributeSet, n10);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int n10) {
        this(context, attributeSet, n10, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int n10, int n11) {
        this(context, attributeSet, n10, n11, null);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AppCompatSpinner(Context context, AttributeSet attributeSet, int n10, int n11, Resources.Theme object) {
        Object[] objectArray;
        Object object2;
        int n12;
        int n13;
        Object object3;
        int n14;
        Object object4;
        block20: {
            AppCompatBackgroundHelper appCompatBackgroundHelper;
            super(context, attributeSet, n10);
            object4 = new Rect();
            this.mTempRect = object4;
            object4 = this.getContext();
            ThemeUtils.checkAppCompatTheme((View)this, (Context)object4);
            object4 = R$styleable.Spinner;
            n14 = 0;
            object3 = null;
            object4 = TintTypedArray.obtainStyledAttributes(context, attributeSet, (int[])object4, n10, 0);
            this.mBackgroundTintHelper = appCompatBackgroundHelper = new AppCompatBackgroundHelper((View)this);
            if (object != null) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, (Resources.Theme)object);
                this.mPopupContext = contextThemeWrapper;
            } else {
                n13 = R$styleable.Spinner_popupTheme;
                if ((n13 = ((TintTypedArray)object4).getResourceId(n13, 0)) != 0) {
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, n13);
                    this.mPopupContext = contextThemeWrapper;
                } else {
                    this.mPopupContext = context;
                }
            }
            n13 = -1;
            Object var9_20 = null;
            if (n11 == n13) {
                void var1_4;
                void var9_22;
                block23: {
                    void var5_11;
                    block21: {
                        block22: {
                            int[] nArray = ATTRS_ANDROID_SPINNERMODE;
                            TypedArray typedArray = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
                            try {
                                n12 = typedArray.hasValue(0);
                                if (n12 != 0) {
                                    n11 = typedArray.getInt(0, 0);
                                }
                                if (typedArray == null) break block20;
                                break block21;
                            }
                            catch (Exception exception) {
                                break block22;
                            }
                            catch (Throwable throwable) {
                                break block23;
                            }
                            catch (Exception exception) {
                                n13 = 0;
                                Object var5_12 = null;
                            }
                        }
                        object2 = TAG;
                        String string2 = "Could not read android:spinnerMode";
                        try {
                            void var12_25;
                            Log.i((String)object2, (String)string2, (Throwable)var12_25);
                            if (var5_11 == null) break block20;
                        }
                        catch (Throwable throwable) {
                            void var9_21 = var5_11;
                        }
                    }
                    var5_11.recycle();
                    {
                        break block20;
                    }
                }
                if (var9_22 != null) {
                    var9_22.recycle();
                }
                throw var1_4;
            }
        }
        n13 = 1;
        if (n11 != 0) {
            if (n11 == n13) {
                Context context2 = this.mPopupContext;
                super(this, context2, attributeSet, n10);
                Context context3 = this.mPopupContext;
                object2 = R$styleable.Spinner;
                object3 = TintTypedArray.obtainStyledAttributes(context3, attributeSet, (int[])object2, n10, 0);
                n12 = R$styleable.Spinner_android_dropDownWidth;
                int n15 = -2;
                this.mDropDownWidth = n12 = ((TintTypedArray)object3).getLayoutDimension(n12, n15);
                n12 = R$styleable.Spinner_android_popupBackground;
                Drawable drawable2 = ((TintTypedArray)object3).getDrawable(n12);
                objectArray.setBackgroundDrawable(drawable2);
                n12 = R$styleable.Spinner_android_prompt;
                String string3 = ((TintTypedArray)object4).getString(n12);
                objectArray.setPromptText(string3);
                ((TintTypedArray)object3).recycle();
                this.mPopup = objectArray;
                this.mForwardingListener = object3 = new AppCompatSpinner$1(this, (View)this, (AppCompatSpinner$DropdownPopup)objectArray);
            }
        } else {
            objectArray = new AppCompatSpinner$DialogPopup(this);
            this.mPopup = objectArray;
            n14 = R$styleable.Spinner_android_prompt;
            object3 = ((TintTypedArray)object4).getString(n14);
            objectArray.setPromptText((CharSequence)object3);
        }
        n11 = R$styleable.Spinner_android_entries;
        objectArray = ((TintTypedArray)object4).getTextArray(n11);
        if (objectArray != null) {
            n12 = 17367048;
            object3 = new ArrayAdapter(context, n12, objectArray);
            int n16 = R$layout.support_simple_spinner_dropdown_item;
            object3.setDropDownViewResource(n16);
            this.setAdapter((SpinnerAdapter)object3);
        }
        ((TintTypedArray)object4).recycle();
        this.mPopupSet = n13;
        context = this.mTempAdapter;
        if (context != null) {
            this.setAdapter((SpinnerAdapter)context);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, n10);
    }

    public int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable2) {
        int n10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int n11 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredWidth(), (int)0);
        int n12 = View.MeasureSpec.makeMeasureSpec((int)this.getMeasuredHeight(), (int)0);
        int n13 = this.getSelectedItemPosition();
        n13 = Math.max(0, n13);
        int n14 = spinnerAdapter.getCount();
        int n15 = n13 + 15;
        n14 = Math.min(n14, n15);
        n15 = n14 - n13;
        n15 = 15 - n15;
        n13 -= n15;
        n13 = Math.max(0, n13);
        n15 = 0;
        int n16 = n13;
        View view = null;
        n13 = 0;
        while (n16 < n14) {
            ViewGroup.LayoutParams layoutParams;
            int n17 = spinnerAdapter.getItemViewType(n16);
            if (n17 != n10) {
                view = null;
                n10 = n17;
            }
            if ((layoutParams = (view = spinnerAdapter.getView(n16, view, (ViewGroup)this)).getLayoutParams()) == null) {
                int n18 = -2;
                layoutParams = new ViewGroup.LayoutParams(n18, n18);
                view.setLayoutParams(layoutParams);
            }
            view.measure(n11, n12);
            n17 = view.getMeasuredWidth();
            n13 = Math.max(n13, n17);
            ++n16;
        }
        if (drawable2 != null) {
            spinnerAdapter = this.mTempRect;
            drawable2.getPadding((Rect)spinnerAdapter);
            spinnerAdapter = this.mTempRect;
            int n19 = spinnerAdapter.left;
            int n20 = spinnerAdapter.right;
            n13 += (n19 += n20);
        }
        return n13;
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
    }

    public int getDropDownHorizontalOffset() {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            return appCompatSpinner$SpinnerPopup.getHorizontalOffset();
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    public int getDropDownVerticalOffset() {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            return appCompatSpinner$SpinnerPopup.getVerticalOffset();
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    public int getDropDownWidth() {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            return this.mDropDownWidth;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    public final AppCompatSpinner$SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    public Drawable getPopupBackground() {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            return appCompatSpinner$SpinnerPopup.getBackground();
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            return super.getPopupBackground();
        }
        return null;
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public CharSequence getPrompt() {
        Object object = this.mPopup;
        object = object != null ? object.getHintText() : super.getPrompt();
        return object;
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        appCompatBackgroundHelper = appCompatBackgroundHelper != null ? appCompatBackgroundHelper.getSupportBackgroundTintList() : null;
        return appCompatBackgroundHelper;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        appCompatBackgroundHelper = appCompatBackgroundHelper != null ? appCompatBackgroundHelper.getSupportBackgroundTintMode() : null;
        return appCompatBackgroundHelper;
    }

    public void onDetachedFromWindow() {
        boolean bl2;
        super.onDetachedFromWindow();
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null && (bl2 = appCompatSpinner$SpinnerPopup.isShowing())) {
            appCompatSpinner$SpinnerPopup = this.mPopup;
            appCompatSpinner$SpinnerPopup.dismiss();
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        super.onMeasure(n10, n11);
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null && (n11 = View.MeasureSpec.getMode((int)n10)) == (n12 = -1 << -1)) {
            n11 = this.getMeasuredWidth();
            SpinnerAdapter spinnerAdapter = this.getAdapter();
            Drawable drawable2 = this.getBackground();
            n12 = this.compatMeasureContentWidth(spinnerAdapter, drawable2);
            n11 = Math.max(n11, n12);
            n10 = View.MeasureSpec.getSize((int)n10);
            n10 = Math.min(n11, n10);
            n11 = this.getMeasuredHeight();
            this.setMeasuredDimension(n10, n11);
        }
    }

    public void onRestoreInstanceState(Parcelable object) {
        object = (AppCompatSpinner$SavedState)((Object)object);
        Object object2 = object.getSuperState();
        super.onRestoreInstanceState(object2);
        boolean bl2 = object.mShowDropdown;
        if (bl2 && (object = this.getViewTreeObserver()) != null) {
            object2 = new AppCompatSpinner$2(this);
            object.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object2);
        }
    }

    public Parcelable onSaveInstanceState() {
        boolean bl2;
        Object object = super.onSaveInstanceState();
        AppCompatSpinner$SavedState appCompatSpinner$SavedState = new AppCompatSpinner$SavedState((Parcelable)object);
        object = this.mPopup;
        if (object != null && (bl2 = object.isShowing())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        appCompatSpinner$SavedState.mShowDropdown = bl2;
        return appCompatSpinner$SavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        ForwardingListener forwardingListener = this.mForwardingListener;
        if (forwardingListener != null && (bl2 = forwardingListener.onTouch((View)this, motionEvent))) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean performClick() {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            boolean bl2 = appCompatSpinner$SpinnerPopup.isShowing();
            if (!bl2) {
                this.showPopup();
            }
            return true;
        }
        return super.performClick();
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        boolean bl2 = this.mPopupSet;
        if (!bl2) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            appCompatSpinner$SpinnerPopup = this.mPopupContext;
            if (appCompatSpinner$SpinnerPopup == null) {
                appCompatSpinner$SpinnerPopup = this.getContext();
            }
            AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup2 = this.mPopup;
            appCompatSpinner$SpinnerPopup = appCompatSpinner$SpinnerPopup.getTheme();
            AppCompatSpinner$DropDownAdapter appCompatSpinner$DropDownAdapter = new AppCompatSpinner$DropDownAdapter(spinnerAdapter, (Resources.Theme)appCompatSpinner$SpinnerPopup);
            appCompatSpinner$SpinnerPopup2.setAdapter(appCompatSpinner$DropDownAdapter);
        }
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable(drawable2);
        }
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(n10);
        }
    }

    public void setDropDownHorizontalOffset(int n10) {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            appCompatSpinner$SpinnerPopup.setHorizontalOriginalOffset(n10);
            appCompatSpinner$SpinnerPopup = this.mPopup;
            appCompatSpinner$SpinnerPopup.setHorizontalOffset(n10);
        } else {
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 16;
            if (n11 >= n12) {
                super.setDropDownHorizontalOffset(n10);
            }
        }
    }

    public void setDropDownVerticalOffset(int n10) {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            appCompatSpinner$SpinnerPopup.setVerticalOffset(n10);
        } else {
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 16;
            if (n11 >= n12) {
                super.setDropDownVerticalOffset(n10);
            }
        }
    }

    public void setDropDownWidth(int n10) {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            this.mDropDownWidth = n10;
        } else {
            int n11 = Build.VERSION.SDK_INT;
            int n12 = 16;
            if (n11 >= n12) {
                super.setDropDownWidth(n10);
            }
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable2) {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            appCompatSpinner$SpinnerPopup.setBackgroundDrawable(drawable2);
        } else {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 16;
            if (n10 >= n11) {
                super.setPopupBackgroundDrawable(drawable2);
            }
        }
    }

    public void setPopupBackgroundResource(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getPopupContext(), n10);
        this.setPopupBackgroundDrawable(drawable2);
    }

    public void setPrompt(CharSequence charSequence) {
        AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
        if (appCompatSpinner$SpinnerPopup != null) {
            appCompatSpinner$SpinnerPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    public void showPopup() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
            n11 = this.getTextDirection();
            int n12 = this.getTextAlignment();
            appCompatSpinner$SpinnerPopup.show(n11, n12);
        } else {
            AppCompatSpinner$SpinnerPopup appCompatSpinner$SpinnerPopup = this.mPopup;
            n11 = -1;
            appCompatSpinner$SpinnerPopup.show(n11, n11);
        }
    }
}

