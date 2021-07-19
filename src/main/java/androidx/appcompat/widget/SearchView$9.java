/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;

public class SearchView$9
implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$9(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onItemSelected(AdapterView adapterView, View view, int n10, long l10) {
        this.this$0.onItemSelected(n10);
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}

