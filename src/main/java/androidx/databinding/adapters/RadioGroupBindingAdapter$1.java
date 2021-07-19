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

public final class RadioGroupBindingAdapter$1
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ InverseBindingListener val$attrChange;
    public final /* synthetic */ RadioGroup.OnCheckedChangeListener val$listener;

    public RadioGroupBindingAdapter$1(RadioGroup.OnCheckedChangeListener onCheckedChangeListener, InverseBindingListener inverseBindingListener) {
        this.val$listener = onCheckedChangeListener;
        this.val$attrChange = inverseBindingListener;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int n10) {
        RadioGroup.OnCheckedChangeListener onCheckedChangeListener = this.val$listener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(radioGroup, n10);
        }
        this.val$attrChange.onChange();
    }
}

