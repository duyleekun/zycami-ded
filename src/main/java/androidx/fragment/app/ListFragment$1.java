/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ListView
 */
package androidx.fragment.app;

import android.view.View;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;

public class ListFragment$1
implements Runnable {
    public final /* synthetic */ ListFragment this$0;

    public ListFragment$1(ListFragment listFragment) {
        this.this$0 = listFragment;
    }

    public void run() {
        ListView listView = this.this$0.mList;
        listView.focusableViewAvailable((View)listView);
    }
}

