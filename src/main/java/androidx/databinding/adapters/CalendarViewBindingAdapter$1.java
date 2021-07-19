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

public final class CalendarViewBindingAdapter$1
implements CalendarView.OnDateChangeListener {
    public final /* synthetic */ InverseBindingListener val$attrChange;
    public final /* synthetic */ CalendarView.OnDateChangeListener val$onDayChange;

    public CalendarViewBindingAdapter$1(CalendarView.OnDateChangeListener onDateChangeListener, InverseBindingListener inverseBindingListener) {
        this.val$onDayChange = onDateChangeListener;
        this.val$attrChange = inverseBindingListener;
    }

    public void onSelectedDayChange(CalendarView calendarView, int n10, int n11, int n12) {
        CalendarView.OnDateChangeListener onDateChangeListener = this.val$onDayChange;
        if (onDateChangeListener != null) {
            onDateChangeListener.onSelectedDayChange(calendarView, n10, n11, n12);
        }
        this.val$attrChange.onChange();
    }
}

