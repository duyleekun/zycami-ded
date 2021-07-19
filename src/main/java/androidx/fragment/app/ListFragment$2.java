/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 *  android.widget.ListView
 */
package androidx.fragment.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;

public class ListFragment$2
implements AdapterView.OnItemClickListener {
    public final /* synthetic */ ListFragment this$0;

    public ListFragment$2(ListFragment listFragment) {
        this.this$0 = listFragment;
    }

    public void onItemClick(AdapterView adapterView, View view, int n10, long l10) {
        ListFragment listFragment = this.this$0;
        AdapterView adapterView2 = adapterView;
        adapterView2 = (ListView)adapterView;
        listFragment.onListItemClick((ListView)adapterView2, view, n10, l10);
    }
}

