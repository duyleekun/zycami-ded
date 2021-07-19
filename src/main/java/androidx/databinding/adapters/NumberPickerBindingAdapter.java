/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.NumberPicker
 *  android.widget.NumberPicker$OnValueChangeListener
 */
package androidx.databinding.adapters;

import android.widget.NumberPicker;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.NumberPickerBindingAdapter$1;

public class NumberPickerBindingAdapter {
    public static void setListeners(NumberPicker numberPicker, NumberPicker.OnValueChangeListener onValueChangeListener, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            numberPicker.setOnValueChangedListener(onValueChangeListener);
        } else {
            NumberPickerBindingAdapter$1 numberPickerBindingAdapter$1 = new NumberPickerBindingAdapter$1(onValueChangeListener, inverseBindingListener);
            numberPicker.setOnValueChangedListener((NumberPicker.OnValueChangeListener)numberPickerBindingAdapter$1);
        }
    }

    public static void setValue(NumberPicker numberPicker, int n10) {
        int n11 = numberPicker.getValue();
        if (n11 != n10) {
            numberPicker.setValue(n10);
        }
    }
}

