/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CalendarView
 *  android.widget.CalendarView$OnDateChangeListener
 */
package androidx.databinding.adapters;

import android.widget.CalendarView;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.CalendarViewBindingAdapter$1;

public class CalendarViewBindingAdapter {
    public static void setDate(CalendarView calendarView, long l10) {
        long l11 = calendarView.getDate();
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            calendarView.setDate(l10);
        }
    }

    public static void setListeners(CalendarView calendarView, CalendarView.OnDateChangeListener onDateChangeListener, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            calendarView.setOnDateChangeListener(onDateChangeListener);
        } else {
            CalendarViewBindingAdapter$1 calendarViewBindingAdapter$1 = new CalendarViewBindingAdapter$1(onDateChangeListener, inverseBindingListener);
            calendarView.setOnDateChangeListener((CalendarView.OnDateChangeListener)calendarViewBindingAdapter$1);
        }
    }
}

