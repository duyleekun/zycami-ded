/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.SearchableInfo
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 */
package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView$SearchAutoComplete;

public class SearchView$6
implements View.OnKeyListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$6(SearchView searchView) {
        this.this$0 = searchView;
    }

    public boolean onKey(View object, int n10, KeyEvent object2) {
        int n11;
        int n12;
        Object object3 = this.this$0;
        SearchableInfo searchableInfo = ((SearchView)object3).mSearchable;
        if (searchableInfo == null) {
            return false;
        }
        object3 = ((SearchView)object3).mSearchSrcTextView;
        int n13 = object3.isPopupShowing();
        if (n13 && (n13 = (object3 = this.this$0.mSearchSrcTextView).getListSelection()) != (n12 = -1)) {
            return this.this$0.onSuggestionsKey((View)object, n10, (KeyEvent)object2);
        }
        object3 = this.this$0.mSearchSrcTextView;
        n13 = ((SearchView$SearchAutoComplete)object3).isEmpty() ? 1 : 0;
        if (!n13 && (n13 = (int)(object2.hasNoModifiers() ? 1 : 0)) && (n11 = object2.getAction()) == (n13 = 1) && n10 == (n11 = 66)) {
            object.cancelLongPress();
            object = this.this$0;
            object2 = ((SearchView)object).mSearchSrcTextView.getText().toString();
            ((SearchView)object).launchQuerySearch(0, null, (String)object2);
            return n13;
        }
        return false;
    }
}

