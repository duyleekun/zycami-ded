/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.DatePicker
 *  android.widget.DatePicker$OnDateChangedListener
 */
package androidx.databinding.adapters;

import android.view.View;
import android.widget.DatePicker;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.DatePickerBindingAdapter$DateChangedListener;
import androidx.databinding.adapters.ListenerUtil;
import androidx.databinding.library.baseAdapters.R$id;

public class DatePickerBindingAdapter {
    public static void setListeners(DatePicker datePicker, int n10, int n11, int n12, DatePicker.OnDateChangedListener onDateChangedListener, InverseBindingListener inverseBindingListener, InverseBindingListener inverseBindingListener2, InverseBindingListener inverseBindingListener3) {
        if (n10 == 0) {
            n10 = datePicker.getYear();
        }
        if (n12 == 0) {
            n12 = datePicker.getDayOfMonth();
        }
        if (inverseBindingListener == null && inverseBindingListener2 == null && inverseBindingListener3 == null) {
            datePicker.init(n10, n11, n12, onDateChangedListener);
        } else {
            int n13 = R$id.onDateChanged;
            DatePickerBindingAdapter$DateChangedListener datePickerBindingAdapter$DateChangedListener = (DatePickerBindingAdapter$DateChangedListener)ListenerUtil.getListener((View)datePicker, n13);
            if (datePickerBindingAdapter$DateChangedListener == null) {
                datePickerBindingAdapter$DateChangedListener = new DatePickerBindingAdapter$DateChangedListener(null);
                ListenerUtil.trackListener((View)datePicker, datePickerBindingAdapter$DateChangedListener, n13);
            }
            datePickerBindingAdapter$DateChangedListener.setListeners(onDateChangedListener, inverseBindingListener, inverseBindingListener2, inverseBindingListener3);
            datePicker.init(n10, n11, n12, (DatePicker.OnDateChangedListener)datePickerBindingAdapter$DateChangedListener);
        }
    }
}

