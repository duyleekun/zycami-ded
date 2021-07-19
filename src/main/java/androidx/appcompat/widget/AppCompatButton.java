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
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.Button
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
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatButton
extends Button
implements TintableBackgroundView,
AutoSizeableTextView,
TintableCompoundDrawablesView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.buttonStyle;
        this(context, attributeSet, n10);
    }

    public AppCompatButton(Context object, AttributeSet attributeSet, int n10) {
        object = TintContextWrapper.wrap((Context)object);
        super((Context)object, attributeSet, n10);
        object = this.getContext();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)object);
        super((View)this);
        this.mBackgroundTintHelper = object;
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

    public int getAutoSizeMaxTextSize() {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (bl2) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeMaxTextSize();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (bl2) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeMinTextSize();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (bl2) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeStepGranularity();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (bl2) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeTextAvailableSizes();
        }
        return new int[0];
    }

    public int getAutoSizeTextType() {
        int n10 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        int n11 = 0;
        if (n10 != 0) {
            int n12;
            n10 = super.getAutoSizeTextType();
            if (n10 == (n12 = 1)) {
                n11 = n12;
            }
            return n11;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.getAutoSizeTextType();
        }
        return 0;
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

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.getCompoundDrawableTintList();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.getCompoundDrawableTintMode();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        String string2 = Button.class.getName();
        accessibilityEvent.setClassName((CharSequence)string2);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        String string2 = Button.class.getName();
        accessibilityNodeInfo.setClassName((CharSequence)string2);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onLayout(bl2, n10, n11, n12, n13);
        }
    }

    public void onTextChanged(CharSequence object, int n10, int n11, int n12) {
        boolean bl2;
        super.onTextChanged((CharSequence)object, n10, n11, n12);
        object = this.mTextHelper;
        if (object != null && (n10 = (int)(AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE ? 1 : 0)) == 0 && (bl2 = ((AppCompatTextHelper)object).isAutoSizeEnabled())) {
            object = this.mTextHelper;
            ((AppCompatTextHelper)object).autoSizeText();
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int n10, int n11, int n12, int n13) {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (bl2) {
            super.setAutoSizeTextTypeUniformWithConfiguration(n10, n11, n12, n13);
        } else {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeUniformWithConfiguration(n10, n11, n12, n13);
            }
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] nArray, int n10) {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (bl2) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n10);
        } else {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(nArray, n10);
            }
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int n10) {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (bl2) {
            super.setAutoSizeTextTypeWithDefaults(n10);
        } else {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setAutoSizeTextTypeWithDefaults(n10);
            }
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

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        callback = TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, callback);
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setSupportAllCaps(boolean bl2) {
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.setAllCaps(bl2);
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

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.setCompoundDrawableTintList(colorStateList);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.setCompoundDrawableTintMode(mode);
        this.mTextHelper.applyCompoundDrawablesTints();
    }

    public void setTextAppearance(Context context, int n10) {
        super.setTextAppearance(context, n10);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, n10);
        }
    }

    public void setTextSize(int n10, float f10) {
        boolean bl2 = AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE;
        if (bl2) {
            super.setTextSize(n10, f10);
        } else {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                appCompatTextHelper.setTextSize(n10, f10);
            }
        }
    }
}

