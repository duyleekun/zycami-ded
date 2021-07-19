/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.AutoCompleteTextView$Validator
 */
package androidx.databinding.adapters;

import android.widget.AutoCompleteTextView;
import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$FixText;
import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$IsValid;

public final class AutoCompleteTextViewBindingAdapter$1
implements AutoCompleteTextView.Validator {
    public final /* synthetic */ AutoCompleteTextViewBindingAdapter$FixText val$fixText;
    public final /* synthetic */ AutoCompleteTextViewBindingAdapter$IsValid val$isValid;

    public AutoCompleteTextViewBindingAdapter$1(AutoCompleteTextViewBindingAdapter$IsValid isValid, AutoCompleteTextViewBindingAdapter$FixText fixText) {
        this.val$isValid = isValid;
        this.val$fixText = fixText;
    }

    public CharSequence fixText(CharSequence charSequence) {
        AutoCompleteTextViewBindingAdapter$FixText autoCompleteTextViewBindingAdapter$FixText = this.val$fixText;
        if (autoCompleteTextViewBindingAdapter$FixText != null) {
            charSequence = autoCompleteTextViewBindingAdapter$FixText.fixText(charSequence);
        }
        return charSequence;
    }

    public boolean isValid(CharSequence charSequence) {
        AutoCompleteTextViewBindingAdapter$IsValid autoCompleteTextViewBindingAdapter$IsValid = this.val$isValid;
        if (autoCompleteTextViewBindingAdapter$IsValid != null) {
            return autoCompleteTextViewBindingAdapter$IsValid.isValid(charSequence);
        }
        return true;
    }
}

