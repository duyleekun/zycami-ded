/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.AutoCompleteTextView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.TextViewCompat;

public class AppCompatAutoCompleteTextView
extends AutoCompleteTextView
implements TintableBackgroundView {
    private static final int[] TINT_ATTRS;
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    static {
        int[] nArray = new int[]{16843126};
        TINT_ATTRS = nArray;
    }

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.autoCompleteTextViewStyle;
        this(context, attributeSet, n10);
    }

    public AppCompatAutoCompleteTextView(Context object, AttributeSet attributeSet, int n10) {
        object = TintContextWrapper.wrap((Context)object);
        super((Context)object, attributeSet, n10);
        object = this.getContext();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)object);
        object = this.getContext();
        Object object2 = TINT_ATTRS;
        object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, object2, n10, 0);
        boolean bl2 = ((TintTypedArray)object).hasValue(0);
        if (bl2) {
            object2 = ((TintTypedArray)object).getDrawable(0);
            this.setDropDownBackgroundDrawable((Drawable)object2);
        }
        ((TintTypedArray)object).recycle();
        this.mBackgroundTintHelper = object = new AppCompatBackgroundHelper((View)this);
        ((AppCompatBackgroundHelper)object).loadFromAttributes(attributeSet, n10);
        this.mTextHelper = object = new AppCompatTextHelper((TextView)this);
        ((AppCompatTextHelper)object).loadFromAttributes(attributeSet, n10);
        ((AppCompatTextHelper)object).applyCompoundDrawablesTints();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        Object object = this.mBackgroundTintHelper;
        if (object != null) {
            ((AppCompatBackgroundHelper)object).applySupportBackgroundTint();
        }
        if ((object = this.mTextHelper) != null) {
            ((AppCompatTextHelper)object).applyCompoundDrawablesTints();
        }
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

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(editorInfo), editorInfo, (View)this);
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        callback = TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, callback);
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setDropDownBackgroundResource(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getContext(), n10);
        this.setDropDownBackgroundDrawable(drawable2);
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

    public void setTextAppearance(Context context, int n10) {
        super.setTextAppearance(context, n10);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, n10);
        }
    }
}

