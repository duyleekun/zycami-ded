/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.widget.TimePicker
 *  android.widget.TimePicker$OnTimeChangedListener
 */
package androidx.databinding.adapters;

import android.os.Build;
import android.widget.TimePicker;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.TimePickerBindingAdapter$1;

public class TimePickerBindingAdapter {
    public static int getHour(TimePicker object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return object.getHour();
        }
        if ((object = object.getCurrentHour()) == null) {
            return 0;
        }
        return (Integer)object;
    }

    public static int getMinute(TimePicker object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return object.getMinute();
        }
        if ((object = object.getCurrentMinute()) == null) {
            return 0;
        }
        return (Integer)object;
    }

    public static void setHour(TimePicker timePicker, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            n11 = timePicker.getHour();
            if (n11 != n10) {
                timePicker.setHour(n10);
            }
        } else {
            Integer n13 = timePicker.getCurrentHour();
            n11 = n13;
            if (n11 != n10) {
                Integer n14 = n10;
                timePicker.setCurrentHour(n14);
            }
        }
    }

    public static void setListeners(TimePicker timePicker, TimePicker.OnTimeChangedListener onTimeChangedListener, InverseBindingListener inverseBindingListener, InverseBindingListener inverseBindingListener2) {
        if (inverseBindingListener == null && inverseBindingListener2 == null) {
            timePicker.setOnTimeChangedListener(onTimeChangedListener);
        } else {
            TimePickerBindingAdapter$1 timePickerBindingAdapter$1 = new TimePickerBindingAdapter$1(onTimeChangedListener, inverseBindingListener, inverseBindingListener2);
            timePicker.setOnTimeChangedListener((TimePicker.OnTimeChangedListener)timePickerBindingAdapter$1);
        }
    }

    public static void setMinute(TimePicker timePicker, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            n11 = timePicker.getMinute();
            if (n11 != n10) {
                timePicker.setMinute(n10);
            }
        } else {
            Integer n13 = timePicker.getCurrentMinute();
            n11 = n13;
            if (n11 != n10) {
                Integer n14 = n10;
                timePicker.setCurrentHour(n14);
            }
        }
    }
}

