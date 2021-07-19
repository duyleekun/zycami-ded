/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource$InvalidatedCallback;
import androidx.paging.LivePagedListBuilder$1;

public class LivePagedListBuilder$1$1
implements DataSource$InvalidatedCallback {
    public final /* synthetic */ LivePagedListBuilder$1 this$0;

    public LivePagedListBuilder$1$1(LivePagedListBuilder$1 livePagedListBuilder$1) {
        this.this$0 = livePagedListBuilder$1;
    }

    public void onInvalidated() {
        this.this$0.invalidate();
    }
}

