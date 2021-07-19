/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontsContractCompat$FontRequestCallback;

public class CallbackWithHandler$2
implements Runnable {
    public final /* synthetic */ CallbackWithHandler this$0;
    public final /* synthetic */ FontsContractCompat$FontRequestCallback val$callback;
    public final /* synthetic */ int val$reason;

    public CallbackWithHandler$2(CallbackWithHandler callbackWithHandler, FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback, int n10) {
        this.this$0 = callbackWithHandler;
        this.val$callback = fontsContractCompat$FontRequestCallback;
        this.val$reason = n10;
    }

    public void run() {
        FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback = this.val$callback;
        int n10 = this.val$reason;
        fontsContractCompat$FontRequestCallback.onTypefaceRequestFailed(n10);
    }
}

