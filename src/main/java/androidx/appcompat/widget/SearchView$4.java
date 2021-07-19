/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.SearchView;

public class SearchView$4
implements View.OnLayoutChangeListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$4(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onLayoutChange(View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        this.this$0.adjustDropDownSizeAndPosition();
    }
}

