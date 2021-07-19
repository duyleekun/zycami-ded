/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.widget.SearchView
 *  android.widget.SearchView$OnQueryTextListener
 *  android.widget.SearchView$OnSuggestionListener
 */
package androidx.databinding.adapters;

import android.os.Build;
import android.widget.SearchView;
import androidx.databinding.adapters.SearchViewBindingAdapter$1;
import androidx.databinding.adapters.SearchViewBindingAdapter$2;
import androidx.databinding.adapters.SearchViewBindingAdapter$OnQueryTextChange;
import androidx.databinding.adapters.SearchViewBindingAdapter$OnQueryTextSubmit;
import androidx.databinding.adapters.SearchViewBindingAdapter$OnSuggestionClick;
import androidx.databinding.adapters.SearchViewBindingAdapter$OnSuggestionSelect;

public class SearchViewBindingAdapter {
    public static void setOnQueryTextListener(SearchView searchView, SearchViewBindingAdapter$OnQueryTextSubmit searchViewBindingAdapter$OnQueryTextSubmit, SearchViewBindingAdapter$OnQueryTextChange searchViewBindingAdapter$OnQueryTextChange) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 11;
        if (n10 >= n11) {
            if (searchViewBindingAdapter$OnQueryTextSubmit == null && searchViewBindingAdapter$OnQueryTextChange == null) {
                searchViewBindingAdapter$OnQueryTextSubmit = null;
                searchView.setOnQueryTextListener(null);
            } else {
                SearchViewBindingAdapter$1 searchViewBindingAdapter$1 = new SearchViewBindingAdapter$1(searchViewBindingAdapter$OnQueryTextSubmit, searchViewBindingAdapter$OnQueryTextChange);
                searchView.setOnQueryTextListener((SearchView.OnQueryTextListener)searchViewBindingAdapter$1);
            }
        }
    }

    public static void setOnSuggestListener(SearchView searchView, SearchViewBindingAdapter$OnSuggestionSelect searchViewBindingAdapter$OnSuggestionSelect, SearchViewBindingAdapter$OnSuggestionClick searchViewBindingAdapter$OnSuggestionClick) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 11;
        if (n10 >= n11) {
            if (searchViewBindingAdapter$OnSuggestionSelect == null && searchViewBindingAdapter$OnSuggestionClick == null) {
                searchViewBindingAdapter$OnSuggestionSelect = null;
                searchView.setOnSuggestionListener(null);
            } else {
                SearchViewBindingAdapter$2 searchViewBindingAdapter$2 = new SearchViewBindingAdapter$2(searchViewBindingAdapter$OnSuggestionSelect, searchViewBindingAdapter$OnSuggestionClick);
                searchView.setOnSuggestionListener((SearchView.OnSuggestionListener)searchViewBindingAdapter$2);
            }
        }
    }
}

