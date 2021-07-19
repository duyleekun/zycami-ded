/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView$SearchAutoComplete;

public class SearchView$SearchAutoComplete$1
implements Runnable {
    public final /* synthetic */ SearchView$SearchAutoComplete this$0;

    public SearchView$SearchAutoComplete$1(SearchView$SearchAutoComplete searchView$SearchAutoComplete) {
        this.this$0 = searchView$SearchAutoComplete;
    }

    public void run() {
        this.this$0.showSoftInputIfNecessary();
    }
}

