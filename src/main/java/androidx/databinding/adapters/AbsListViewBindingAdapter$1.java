/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 */
package androidx.databinding.adapters;

import android.widget.AbsListView;
import androidx.databinding.adapters.AbsListViewBindingAdapter$OnScroll;
import androidx.databinding.adapters.AbsListViewBindingAdapter$OnScrollStateChanged;

public final class AbsListViewBindingAdapter$1
implements AbsListView.OnScrollListener {
    public final /* synthetic */ AbsListViewBindingAdapter$OnScroll val$scrollListener;
    public final /* synthetic */ AbsListViewBindingAdapter$OnScrollStateChanged val$scrollStateListener;

    public AbsListViewBindingAdapter$1(AbsListViewBindingAdapter$OnScrollStateChanged onScrollStateChanged, AbsListViewBindingAdapter$OnScroll onScroll) {
        this.val$scrollStateListener = onScrollStateChanged;
        this.val$scrollListener = onScroll;
    }

    public void onScroll(AbsListView absListView, int n10, int n11, int n12) {
        AbsListViewBindingAdapter$OnScroll absListViewBindingAdapter$OnScroll = this.val$scrollListener;
        if (absListViewBindingAdapter$OnScroll != null) {
            absListViewBindingAdapter$OnScroll.onScroll(absListView, n10, n11, n12);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int n10) {
        AbsListViewBindingAdapter$OnScrollStateChanged absListViewBindingAdapter$OnScrollStateChanged = this.val$scrollStateListener;
        if (absListViewBindingAdapter$OnScrollStateChanged != null) {
            absListViewBindingAdapter$OnScrollStateChanged.onScrollStateChanged(absListView, n10);
        }
    }
}

