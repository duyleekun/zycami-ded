/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.widget.TextView
 *  android.widget.TextView$OnEditorActionListener
 */
package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;

public class SearchView$7
implements TextView.OnEditorActionListener {
    public final /* synthetic */ SearchView this$0;

    public SearchView$7(SearchView searchView) {
        this.this$0 = searchView;
    }

    public boolean onEditorAction(TextView textView, int n10, KeyEvent keyEvent) {
        this.this$0.onSubmitQuery();
        return true;
    }
}

