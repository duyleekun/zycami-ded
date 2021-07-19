/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.SearchView$OnSuggestionListener
 */
package androidx.databinding.adapters;

import android.widget.SearchView;
import androidx.databinding.adapters.SearchViewBindingAdapter$OnSuggestionClick;
import androidx.databinding.adapters.SearchViewBindingAdapter$OnSuggestionSelect;

public final class SearchViewBindingAdapter$2
implements SearchView.OnSuggestionListener {
    public final /* synthetic */ SearchViewBindingAdapter$OnSuggestionClick val$change;
    public final /* synthetic */ SearchViewBindingAdapter$OnSuggestionSelect val$submit;

    public SearchViewBindingAdapter$2(SearchViewBindingAdapter$OnSuggestionSelect onSuggestionSelect, SearchViewBindingAdapter$OnSuggestionClick onSuggestionClick) {
        this.val$submit = onSuggestionSelect;
        this.val$change = onSuggestionClick;
    }

    public boolean onSuggestionClick(int n10) {
        SearchViewBindingAdapter$OnSuggestionClick searchViewBindingAdapter$OnSuggestionClick = this.val$change;
        if (searchViewBindingAdapter$OnSuggestionClick != null) {
            return searchViewBindingAdapter$OnSuggestionClick.onSuggestionClick(n10);
        }
        return false;
    }

    public boolean onSuggestionSelect(int n10) {
        SearchViewBindingAdapter$OnSuggestionSelect searchViewBindingAdapter$OnSuggestionSelect = this.val$submit;
        if (searchViewBindingAdapter$OnSuggestionSelect != null) {
            return searchViewBindingAdapter$OnSuggestionSelect.onSuggestionSelect(n10);
        }
        return false;
    }
}

