/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 */
package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.os.IResultReceiver$Stub;
import android.support.v4.os.ResultReceiver;
import android.support.v4.os.ResultReceiver$MyRunnable;

public class ResultReceiver$MyResultReceiver
extends IResultReceiver$Stub {
    public final /* synthetic */ ResultReceiver this$0;

    public ResultReceiver$MyResultReceiver(ResultReceiver resultReceiver) {
        this.this$0 = resultReceiver;
    }

    public void send(int n10, Bundle bundle) {
        ResultReceiver resultReceiver = this.this$0;
        Handler handler = resultReceiver.mHandler;
        if (handler != null) {
            ResultReceiver$MyRunnable resultReceiver$MyRunnable = new ResultReceiver$MyRunnable(resultReceiver, n10, bundle);
            handler.post((Runnable)resultReceiver$MyRunnable);
        } else {
            resultReceiver.onReceiveResult(n10, bundle);
        }
    }
}

