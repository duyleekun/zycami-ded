/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.ActionMode$Callback
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.textclassifier.TextClassifier
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatTextClassifierHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.text.PrecomputedTextCompat$Params;
import androidx.core.view.TintableBackgroundView;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView
extends TextView
implements TintableBackgroundView,
TintableCompoundDrawablesView,
AutoSizeableTextView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future mPrecomputedTextFuture;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context object, AttributeSet attributeSet, int n10) {
        object = TintContextWrapper.wrap((Context)object);
        super((Context)object, attributeSet, n10);
        this.mIsSetTypefaceProcessing = false;
        object = this.getContext();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)object);
        super((View)this);
        this.mBackgroundTintHelper = object;
        ((AppCompatBackgroundHelper)object).loadFromAttributes(attributeSet, n10);
        this.mTextHelper = object = new AppCompatTextHelper(this);
        ((AppCompatTextHelper)object).loadFromAttributes(attributeSet, n10);
        ((AppCompatTextHelper)object).applyCompoundDrawablesTints();
        this.mTextClassifierHelper = object = new AppCompatTextClassifierHelper(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void consumeTextFutureAndSetBlocking() {
        Object object = this.mPrecomputedTextFuture;
        if (object == null) return;
        try {
            this.mPrecomputedTextFuture = null;
            object = object.get();
            object = (PrecomputedTextCompat)object;
            TextViewCompat.setPrecomputedText(this, (PrecomputedTextCompat)object);
            return;
        }
        catch (InterruptedException | ExecutionException exception) {
            return;
        }
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

    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
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

    public CharSequence getText() {
        this.consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 < n11 && (appCompatTextClassifierHelper = this.mTextClassifierHelper) != null) {
            return appCompatTextClassifierHelper.getTextClassifier();
        }
        return super.getTextClassifier();
    }

    public PrecomputedTextCompat$Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, inputConnection, editorInfo);
        return AppCompatHintHelper.onCreateInputConnection(inputConnection, editorInfo, (View)this);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        super.onLayout(bl2, n10, n11, n12, n13);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onLayout(bl2, n10, n11, n12, n13);
        }
    }

    public void onMeasure(int n10, int n11) {
        this.consumeTextFutureAndSetBlocking();
        super.onMeasure(n10, n11);
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

    public void setCompoundDrawables(Drawable object, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables((Drawable)object, drawable2, drawable3, drawable4);
        object = this.mTextHelper;
        if (object != null) {
            ((AppCompatTextHelper)object).onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesRelative(Drawable object, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative((Drawable)object, drawable2, drawable3, drawable4);
        object = this.mTextHelper;
        if (object != null) {
            ((AppCompatTextHelper)object).onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int n10, int n11, int n12, int n13) {
        Drawable drawable2;
        Drawable drawable3;
        Object object;
        Context context = this.getContext();
        Drawable drawable4 = null;
        if (n10 != 0) {
            object = AppCompatResources.getDrawable(context, n10);
        } else {
            n10 = 0;
            object = null;
        }
        if (n11 != 0) {
            drawable3 = AppCompatResources.getDrawable(context, n11);
        } else {
            n11 = 0;
            drawable3 = null;
        }
        if (n12 != 0) {
            drawable2 = AppCompatResources.getDrawable(context, n12);
        } else {
            n12 = 0;
            drawable2 = null;
        }
        if (n13 != 0) {
            drawable4 = AppCompatResources.getDrawable(context, n13);
        }
        this.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)object, drawable3, drawable2, drawable4);
        object = this.mTextHelper;
        if (object != null) {
            ((AppCompatTextHelper)object).onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable object, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)object, drawable2, drawable3, drawable4);
        object = this.mTextHelper;
        if (object != null) {
            ((AppCompatTextHelper)object).onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int n10, int n11, int n12, int n13) {
        Drawable drawable2;
        Drawable drawable3;
        Object object;
        Context context = this.getContext();
        Drawable drawable4 = null;
        if (n10 != 0) {
            object = AppCompatResources.getDrawable(context, n10);
        } else {
            n10 = 0;
            object = null;
        }
        if (n11 != 0) {
            drawable3 = AppCompatResources.getDrawable(context, n11);
        } else {
            n11 = 0;
            drawable3 = null;
        }
        if (n12 != 0) {
            drawable2 = AppCompatResources.getDrawable(context, n12);
        } else {
            n12 = 0;
            drawable2 = null;
        }
        if (n13 != 0) {
            drawable4 = AppCompatResources.getDrawable(context, n13);
        }
        this.setCompoundDrawablesWithIntrinsicBounds((Drawable)object, drawable3, drawable2, drawable4);
        object = this.mTextHelper;
        if (object != null) {
            ((AppCompatTextHelper)object).onSetCompoundDrawables();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable object, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds((Drawable)object, drawable2, drawable3, drawable4);
        object = this.mTextHelper;
        if (object != null) {
            ((AppCompatTextHelper)object).onSetCompoundDrawables();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        callback = TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback);
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setFirstBaselineToTopHeight(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            super.setFirstBaselineToTopHeight(n10);
        } else {
            TextViewCompat.setFirstBaselineToTopHeight(this, n10);
        }
    }

    public void setLastBaselineToBottomHeight(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            super.setLastBaselineToBottomHeight(n10);
        } else {
            TextViewCompat.setLastBaselineToBottomHeight(this, n10);
        }
    }

    public void setLineHeight(int n10) {
        TextViewCompat.setLineHeight(this, n10);
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.setPrecomputedText(this, precomputedTextCompat);
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

    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 < n11 && (appCompatTextClassifierHelper = this.mTextClassifierHelper) != null) {
            appCompatTextClassifierHelper.setTextClassifier(textClassifier);
            return;
        }
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            this.requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat$Params precomputedTextCompat$Params) {
        TextViewCompat.setTextMetricsParams(this, precomputedTextCompat$Params);
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

    public void setTypeface(Typeface typeface, int n10) {
        boolean bl2;
        boolean bl3 = this.mIsSetTypefaceProcessing;
        if (bl3) {
            return;
        }
        bl3 = false;
        Typeface typeface2 = null;
        if (typeface != null && n10 > 0) {
            typeface2 = TypefaceCompat.create(this.getContext(), typeface, n10);
        }
        this.mIsSetTypefaceProcessing = bl2 = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        bl3 = false;
        typeface2 = null;
        try {
            super.setTypeface(typeface, n10);
            return;
        }
        finally {
            this.mIsSetTypefaceProcessing = false;
        }
    }
}

