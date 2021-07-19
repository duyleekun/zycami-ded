/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package androidx.databinding.adapters;

import android.widget.CompoundButton;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.CompoundButtonBindingAdapter$1;

public class CompoundButtonBindingAdapter {
    public static void setChecked(CompoundButton compoundButton, boolean bl2) {
        boolean bl3 = compoundButton.isChecked();
        if (bl3 != bl2) {
            compoundButton.setChecked(bl2);
        }
    }

    public static void setListeners(CompoundButton compoundButton, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            compoundButton.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            CompoundButtonBindingAdapter$1 compoundButtonBindingAdapter$1 = new CompoundButtonBindingAdapter$1(onCheckedChangeListener, inverseBindingListener);
            compoundButton.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)compoundButtonBindingAdapter$1);
        }
    }
}

