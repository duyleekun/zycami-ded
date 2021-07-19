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

public final class NumberPickerBindingAdapter$1
implements NumberPicker.OnValueChangeListener {
    public final /* synthetic */ InverseBindingListener val$attrChange;
    public final /* synthetic */ NumberPicker.OnValueChangeListener val$listener;

    public NumberPickerBindingAdapter$1(NumberPicker.OnValueChangeListener onValueChangeListener, InverseBindingListener inverseBindingListener) {
        this.val$listener = onValueChangeListener;
        this.val$attrChange = inverseBindingListener;
    }

    public void onValueChange(NumberPicker numberPicker, int n10, int n11) {
        NumberPicker.OnValueChangeListener onValueChangeListener = this.val$listener;
        if (onValueChangeListener != null) {
            onValueChangeListener.onValueChange(numberPicker, n10, n11);
        }
        this.val$attrChange.onChange();
    }
}

