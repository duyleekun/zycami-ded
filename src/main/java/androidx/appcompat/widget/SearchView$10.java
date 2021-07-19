/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.appcompat.widget.SearchView;

public class SearchView$10
implements TextWatcher {
    public final /* synthetic */ SearchView this$0;

    public SearchView$10(SearchView searchView) {
        this.this$0 = searchView;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
        this.this$0.onTextChanged(charSequence);
    }
}

