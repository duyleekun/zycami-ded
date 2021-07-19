/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.SearchView;

public class SearchView$5
implements View.OnClickListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$5(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onClick(View view) {
        SearchView searchView = this.this$0;
        Object object = searchView.mSearchButton;
        if (view == object) {
            searchView.onSearchClicked();
        } else {
            object = searchView.mCloseButton;
            if (view == object) {
                searchView.onCloseClicked();
            } else {
                object = searchView.mGoButton;
                if (view == object) {
                    searchView.onSubmitQuery();
                } else {
                    object = searchView.mVoiceButton;
                    if (view == object) {
                        searchView.onVoiceClicked();
                    } else {
                        object = searchView.mSearchSrcTextView;
                        if (view == object) {
                            searchView.forceSuggestionQuery();
                        }
                    }
                }
            }
        }
    }
}

