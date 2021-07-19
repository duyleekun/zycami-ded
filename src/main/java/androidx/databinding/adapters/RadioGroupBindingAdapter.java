/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package androidx.databinding.adapters;

import android.widget.RadioGroup;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.RadioGroupBindingAdapter$1;

public class RadioGroupBindingAdapter {
    public static void setCheckedButton(RadioGroup radioGroup, int n10) {
        int n11 = radioGroup.getCheckedRadioButtonId();
        if (n10 != n11) {
            radioGroup.check(n10);
        }
    }

    public static void setListeners(RadioGroup radioGroup, RadioGroup.OnCheckedChangeListener onCheckedChangeListener, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            RadioGroupBindingAdapter$1 radioGroupBindingAdapter$1 = new RadioGroupBindingAdapter$1(onCheckedChangeListener, inverseBindingListener);
            radioGroup.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)radioGroupBindingAdapter$1);
        }
    }
}

