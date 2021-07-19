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

public final class CompoundButtonBindingAdapter$1
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ InverseBindingListener val$attrChange;
    public final /* synthetic */ CompoundButton.OnCheckedChangeListener val$listener;

    public CompoundButtonBindingAdapter$1(CompoundButton.OnCheckedChangeListener onCheckedChangeListener, InverseBindingListener inverseBindingListener) {
        this.val$listener = onCheckedChangeListener;
        this.val$attrChange = inverseBindingListener;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.val$listener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, bl2);
        }
        this.val$attrChange.onChange();
    }
}

