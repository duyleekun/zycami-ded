/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.widget.CheckedTextView
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.widget.TextViewCompat;

public class AppCompatCheckedTextView
extends CheckedTextView {
    private static final int[] TINT_ATTRS;
    private final AppCompatTextHelper mTextHelper;

    static {
        int[] nArray = new int[]{0x1010108};
        TINT_ATTRS = nArray;
    }

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context object, AttributeSet attributeSet, int n10) {
        object = TintContextWrapper.wrap((Context)object);
        super((Context)object, attributeSet, n10);
        object = this.getContext();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)object);
        super((TextView)this);
        this.mTextHelper = object;
        ((AppCompatTextHelper)object).loadFromAttributes(attributeSet, n10);
        ((AppCompatTextHelper)object).applyCompoundDrawablesTints();
        object = this.getContext();
        int[] nArray = TINT_ATTRS;
        object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, nArray, n10, 0);
        attributeSet = ((TintTypedArray)object).getDrawable(0);
        this.setCheckMarkDrawable((Drawable)attributeSet);
        ((TintTypedArray)object).recycle();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.onCreateInputConnection(super.onCreateInputConnection(editorInfo), editorInfo, (View)this);
    }

    public void setCheckMarkDrawable(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getContext(), n10);
        this.setCheckMarkDrawable(drawable2);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        callback = TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, callback);
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setTextAppearance(Context context, int n10) {
        super.setTextAppearance(context, n10);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, n10);
        }
    }
}

