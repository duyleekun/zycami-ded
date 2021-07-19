/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SuggestionsAdapter;
import androidx.cursoradapter.widget.CursorAdapter;

public class SearchView$2
implements Runnable {
    public final /* synthetic */ SearchView this$0;

    public SearchView$2(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void run() {
        CursorAdapter cursorAdapter = this.this$0.mSuggestionsAdapter;
        boolean bl2 = cursorAdapter instanceof SuggestionsAdapter;
        if (bl2) {
            bl2 = false;
            cursorAdapter.changeCursor(null);
        }
    }
}

