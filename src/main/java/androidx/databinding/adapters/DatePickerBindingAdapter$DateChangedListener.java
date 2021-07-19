/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.DatePicker
 *  android.widget.DatePicker$OnDateChangedListener
 */
package androidx.databinding.adapters;

import android.widget.DatePicker;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.DatePickerBindingAdapter$1;

public class DatePickerBindingAdapter$DateChangedListener
implements DatePicker.OnDateChangedListener {
    public InverseBindingListener mDayChanged;
    public DatePicker.OnDateChangedListener mListener;
    public InverseBindingListener mMonthChanged;
    public InverseBindingListener mYearChanged;

    private DatePickerBindingAdapter$DateChangedListener() {
    }

    public /* synthetic */ DatePickerBindingAdapter$DateChangedListener(DatePickerBindingAdapter$1 datePickerBindingAdapter$1) {
        this();
    }

    public void onDateChanged(DatePicker object, int n10, int n11, int n12) {
        DatePicker.OnDateChangedListener onDateChangedListener = this.mListener;
        if (onDateChangedListener != null) {
            onDateChangedListener.onDateChanged((DatePicker)object, n10, n11, n12);
        }
        if ((object = this.mYearChanged) != null) {
            object.onChange();
        }
        if ((object = this.mMonthChanged) != null) {
            object.onChange();
        }
        if ((object = this.mDayChanged) != null) {
            object.onChange();
        }
    }

    public void setListeners(DatePicker.OnDateChangedListener onDateChangedListener, InverseBindingListener inverseBindingListener, InverseBindingListener inverseBindingListener2, InverseBindingListener inverseBindingListener3) {
        this.mListener = onDateChangedListener;
        this.mYearChanged = inverseBindingListener;
        this.mMonthChanged = inverseBindingListener2;
        this.mDayChanged = inverseBindingListener3;
    }
}

