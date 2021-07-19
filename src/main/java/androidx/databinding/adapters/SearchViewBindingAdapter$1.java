/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SearchView$OnQueryTextListener
 */
package androidx.databinding.adapters;

import android.widget.SearchView;
import androidx.databinding.adapters.SearchViewBindingAdapter$OnQueryTextChange;
import androidx.databinding.adapters.SearchViewBindingAdapter$OnQueryTextSubmit;

public final class SearchViewBindingAdapter$1
implements SearchView.OnQueryTextListener {
    public final /* synthetic */ SearchViewBindingAdapter$OnQueryTextChange val$change;
    public final /* synthetic */ SearchViewBindingAdapter$OnQueryTextSubmit val$submit;

    public SearchViewBindingAdapter$1(SearchViewBindingAdapter$OnQueryTextSubmit onQueryTextSubmit, SearchViewBindingAdapter$OnQueryTextChange onQueryTextChange) {
        this.val$submit = onQueryTextSubmit;
        this.val$change = onQueryTextChange;
    }

    public boolean onQueryTextChange(String string2) {
        SearchViewBindingAdapter$OnQueryTextChange searchViewBindingAdapter$OnQueryTextChange = this.val$change;
        if (searchViewBindingAdapter$OnQueryTextChange != null) {
            return searchViewBindingAdapter$OnQueryTextChange.onQueryTextChange(string2);
        }
        return false;
    }

    public boolean onQueryTextSubmit(String string2) {
        SearchViewBindingAdapter$OnQueryTextSubmit searchViewBindingAdapter$OnQueryTextSubmit = this.val$submit;
        if (searchViewBindingAdapter$OnQueryTextSubmit != null) {
            return searchViewBindingAdapter$OnQueryTextSubmit.onQueryTextSubmit(string2);
        }
        return false;
    }
}

