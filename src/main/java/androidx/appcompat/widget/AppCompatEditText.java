/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.text.Editable
 *  android.util.AttributeSet
 *  android.view.ActionMode$Callback
 *  android.view.DragEvent
 *  android.view.View
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.textclassifier.TextClassifier
 *  android.widget.EditText
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatBackgroundHelper;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.AppCompatReceiveContentHelper;
import androidx.appcompat.widget.AppCompatTextClassifierHelper;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;

public class AppCompatEditText
extends EditText
implements TintableBackgroundView,
OnReceiveContentViewBehavior {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.editTextStyle;
        this(context, attributeSet, n10);
    }

    public AppCompatEditText(Context object, AttributeSet attributeSet, int n10) {
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
        this.mTextClassifierHelper = object = new AppCompatTextClassifierHelper((TextView)this);
        this.mDefaultOnReceiveContentListener = object = new TextViewOnReceiveContentListener();
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

    public Editable getText() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return super.getText();
        }
        return super.getEditableText();
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

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection inputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.populateSurroundingTextIfNeeded((TextView)this, inputConnection, editorInfo);
        inputConnection = AppCompatHintHelper.onCreateInputConnection(inputConnection, editorInfo, (View)this);
        Object object = ViewCompat.getOnReceiveContentMimeTypes((View)this);
        if (inputConnection != null && object != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, object);
            object = AppCompatReceiveContentHelper.createOnCommitContentListener((View)this);
            inputConnection = InputConnectionCompat.createWrapper(inputConnection, editorInfo, (InputConnectionCompat$OnCommitContentListener)object);
        }
        return inputConnection;
    }

    public boolean onDragEvent(DragEvent dragEvent) {
        boolean bl2 = AppCompatReceiveContentHelper.maybeHandleDragEventViaPerformReceiveContent((View)this, dragEvent);
        if (bl2) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent((View)this, contentInfoCompat);
    }

    public boolean onTextContextMenuItem(int n10) {
        boolean bl2 = AppCompatReceiveContentHelper.maybeHandleMenuActionViaPerformReceiveContent((TextView)this, n10);
        if (bl2) {
            return true;
        }
        return super.onTextContextMenuItem(n10);
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
}

