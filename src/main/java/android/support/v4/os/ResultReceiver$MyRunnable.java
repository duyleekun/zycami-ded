/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package android.support.v4.os;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

public class ResultReceiver$MyRunnable
implements Runnable {
    public final int mResultCode;
    public final Bundle mResultData;
    public final /* synthetic */ ResultReceiver this$0;

    public ResultReceiver$MyRunnable(ResultReceiver resultReceiver, int n10, Bundle bundle) {
        this.this$0 = resultReceiver;
        this.mResultCode = n10;
        this.mResultData = bundle;
    }

    public void run() {
        ResultReceiver resultReceiver = this.this$0;
        int n10 = this.mResultCode;
        Bundle bundle = this.mResultData;
        resultReceiver.onReceiveResult(n10, bundle);
    }
}

