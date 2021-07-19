/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource$LoadCallbackHelper;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;

public class DataSource$LoadCallbackHelper$1
implements Runnable {
    public final /* synthetic */ DataSource$LoadCallbackHelper this$0;
    public final /* synthetic */ PageResult val$result;

    public DataSource$LoadCallbackHelper$1(DataSource$LoadCallbackHelper loadCallbackHelper, PageResult pageResult) {
        this.this$0 = loadCallbackHelper;
        this.val$result = pageResult;
    }

    public void run() {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper = this.this$0;
        PageResult$Receiver pageResult$Receiver = dataSource$LoadCallbackHelper.mReceiver;
        int n10 = dataSource$LoadCallbackHelper.mResultType;
        PageResult pageResult = this.val$result;
        pageResult$Receiver.onPageResult(n10, pageResult);
    }
}

