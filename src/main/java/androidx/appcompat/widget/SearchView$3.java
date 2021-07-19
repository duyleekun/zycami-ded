/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnFocusChangeListener
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.SearchView;

public class SearchView$3
implements View.OnFocusChangeListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$3(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void onFocusChange(View object, boolean bl2) {
        object = this.this$0;
        View.OnFocusChangeListener onFocusChangeListener = object.mOnQueryTextFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(object, bl2);
        }
    }
}

