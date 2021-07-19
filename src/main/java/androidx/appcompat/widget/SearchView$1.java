/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;

public class SearchView$1
implements Runnable {
    public final /* synthetic */ SearchView this$0;

    public SearchView$1(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void run() {
        this.this$0.updateFocusedState();
    }
}

