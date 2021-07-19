/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.TimePicker
 *  android.widget.TimePicker$OnTimeChangedListener
 */
package androidx.databinding.adapters;

import android.widget.TimePicker;
import androidx.databinding.InverseBindingListener;

public final class TimePickerBindingAdapter$1
implements TimePicker.OnTimeChangedListener {
    public final /* synthetic */ InverseBindingListener val$hourChange;
    public final /* synthetic */ TimePicker.OnTimeChangedListener val$listener;
    public final /* synthetic */ InverseBindingListener val$minuteChange;

    public TimePickerBindingAdapter$1(TimePicker.OnTimeChangedListener onTimeChangedListener, InverseBindingListener inverseBindingListener, InverseBindingListener inverseBindingListener2) {
        this.val$listener = onTimeChangedListener;
        this.val$hourChange = inverseBindingListener;
        this.val$minuteChange = inverseBindingListener2;
    }

    public void onTimeChanged(TimePicker object, int n10, int n11) {
        TimePicker.OnTimeChangedListener onTimeChangedListener = this.val$listener;
        if (onTimeChangedListener != null) {
            onTimeChangedListener.onTimeChanged((TimePicker)object, n10, n11);
        }
        if ((object = this.val$hourChange) != null) {
            object.onChange();
        }
        if ((object = this.val$minuteChange) != null) {
            object.onChange();
        }
    }
}

