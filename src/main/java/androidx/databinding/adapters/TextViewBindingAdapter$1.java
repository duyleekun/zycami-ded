/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package androidx.databinding.adapters;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged;
import androidx.databinding.adapters.TextViewBindingAdapter$BeforeTextChanged;
import androidx.databinding.adapters.TextViewBindingAdapter$OnTextChanged;

public final class TextViewBindingAdapter$1
implements TextWatcher {
    public final /* synthetic */ TextViewBindingAdapter$AfterTextChanged val$after;
    public final /* synthetic */ TextViewBindingAdapter$BeforeTextChanged val$before;
    public final /* synthetic */ TextViewBindingAdapter$OnTextChanged val$on;
    public final /* synthetic */ InverseBindingListener val$textAttrChanged;

    public TextViewBindingAdapter$1(TextViewBindingAdapter$BeforeTextChanged beforeTextChanged, TextViewBindingAdapter$OnTextChanged onTextChanged, InverseBindingListener inverseBindingListener, TextViewBindingAdapter$AfterTextChanged afterTextChanged) {
        this.val$before = beforeTextChanged;
        this.val$on = onTextChanged;
        this.val$textAttrChanged = inverseBindingListener;
        this.val$after = afterTextChanged;
    }

    public void afterTextChanged(Editable editable) {
        TextViewBindingAdapter$AfterTextChanged textViewBindingAdapter$AfterTextChanged = this.val$after;
        if (textViewBindingAdapter$AfterTextChanged != null) {
            textViewBindingAdapter$AfterTextChanged.afterTextChanged(editable);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
        TextViewBindingAdapter$BeforeTextChanged textViewBindingAdapter$BeforeTextChanged = this.val$before;
        if (textViewBindingAdapter$BeforeTextChanged != null) {
            textViewBindingAdapter$BeforeTextChanged.beforeTextChanged(charSequence, n10, n11, n12);
        }
    }

    public void onTextChanged(CharSequence object, int n10, int n11, int n12) {
        TextViewBindingAdapter$OnTextChanged textViewBindingAdapter$OnTextChanged = this.val$on;
        if (textViewBindingAdapter$OnTextChanged != null) {
            textViewBindingAdapter$OnTextChanged.onTextChanged((CharSequence)object, n10, n11, n12);
        }
        if ((object = this.val$textAttrChanged) != null) {
            object.onChange();
        }
    }
}

