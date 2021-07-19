/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 */
package androidx.databinding.adapters;

import android.widget.AbsListView;
import androidx.databinding.adapters.AbsListViewBindingAdapter$1;
import androidx.databinding.adapters.AbsListViewBindingAdapter$OnScroll;
import androidx.databinding.adapters.AbsListViewBindingAdapter$OnScrollStateChanged;

public class AbsListViewBindingAdapter {
    public static void setOnScroll(AbsListView absListView, AbsListViewBindingAdapter$OnScroll absListViewBindingAdapter$OnScroll, AbsListViewBindingAdapter$OnScrollStateChanged absListViewBindingAdapter$OnScrollStateChanged) {
        AbsListViewBindingAdapter$1 absListViewBindingAdapter$1 = new AbsListViewBindingAdapter$1(absListViewBindingAdapter$OnScrollStateChanged, absListViewBindingAdapter$OnScroll);
        absListView.setOnScrollListener((AbsListView.OnScrollListener)absListViewBindingAdapter$1);
    }
}

