/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.AdapterView$OnItemSelectedListener
 *  android.widget.AutoCompleteTextView
 *  android.widget.AutoCompleteTextView$Validator
 */
package androidx.databinding.adapters;

import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import androidx.databinding.adapters.AdapterViewBindingAdapter$OnItemSelected;
import androidx.databinding.adapters.AdapterViewBindingAdapter$OnItemSelectedComponentListener;
import androidx.databinding.adapters.AdapterViewBindingAdapter$OnNothingSelected;
import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$1;
import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$FixText;
import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter$IsValid;

public class AutoCompleteTextViewBindingAdapter {
    public static void setOnItemSelectedListener(AutoCompleteTextView autoCompleteTextView, AdapterViewBindingAdapter$OnItemSelected adapterViewBindingAdapter$OnItemSelected, AdapterViewBindingAdapter$OnNothingSelected adapterViewBindingAdapter$OnNothingSelected) {
        if (adapterViewBindingAdapter$OnItemSelected == null && adapterViewBindingAdapter$OnNothingSelected == null) {
            autoCompleteTextView.setOnItemSelectedListener(null);
        } else {
            AdapterViewBindingAdapter$OnItemSelectedComponentListener adapterViewBindingAdapter$OnItemSelectedComponentListener = new AdapterViewBindingAdapter$OnItemSelectedComponentListener(adapterViewBindingAdapter$OnItemSelected, adapterViewBindingAdapter$OnNothingSelected, null);
            autoCompleteTextView.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)adapterViewBindingAdapter$OnItemSelectedComponentListener);
        }
    }

    public static void setValidator(AutoCompleteTextView autoCompleteTextView, AutoCompleteTextViewBindingAdapter$FixText autoCompleteTextViewBindingAdapter$FixText, AutoCompleteTextViewBindingAdapter$IsValid autoCompleteTextViewBindingAdapter$IsValid) {
        if (autoCompleteTextViewBindingAdapter$FixText == null && autoCompleteTextViewBindingAdapter$IsValid == null) {
            autoCompleteTextViewBindingAdapter$FixText = null;
            autoCompleteTextView.setValidator(null);
        } else {
            AutoCompleteTextViewBindingAdapter$1 autoCompleteTextViewBindingAdapter$1 = new AutoCompleteTextViewBindingAdapter$1(autoCompleteTextViewBindingAdapter$IsValid, autoCompleteTextViewBindingAdapter$FixText);
            autoCompleteTextView.setValidator((AutoCompleteTextView.Validator)autoCompleteTextViewBindingAdapter$1);
        }
    }
}

