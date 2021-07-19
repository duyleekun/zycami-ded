/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

public class SearchView$8
implements AdapterView.OnItemClickListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$8(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onItemClick(AdapterView adapterView, View view, int n10, long l10) {
        this.this$0.onItemClicked(n10, 0, null);
    }
}

