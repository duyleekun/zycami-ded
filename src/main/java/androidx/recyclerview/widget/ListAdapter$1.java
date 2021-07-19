/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer$ListListener;
import androidx.recyclerview.widget.ListAdapter;
import java.util.List;

public class ListAdapter$1
implements AsyncListDiffer$ListListener {
    public final /* synthetic */ ListAdapter this$0;

    public ListAdapter$1(ListAdapter listAdapter) {
        this.this$0 = listAdapter;
    }

    public void onCurrentListChanged(List list, List list2) {
        this.this$0.onCurrentListChanged(list, list2);
    }
}

