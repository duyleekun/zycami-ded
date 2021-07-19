/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.provider;

import android.graphics.Typeface;
import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontsContractCompat$FontRequestCallback;

public class CallbackWithHandler$1
implements Runnable {
    public final /* synthetic */ CallbackWithHandler this$0;
    public final /* synthetic */ FontsContractCompat$FontRequestCallback val$callback;
    public final /* synthetic */ Typeface val$typeface;

    public CallbackWithHandler$1(CallbackWithHandler callbackWithHandler, FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback, Typeface typeface) {
        this.this$0 = callbackWithHandler;
        this.val$callback = fontsContractCompat$FontRequestCallback;
        this.val$typeface = typeface;
    }

    public void run() {
        FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback = this.val$callback;
        Typeface typeface = this.val$typeface;
        fontsContractCompat$FontRequestCallback.onTypefaceRetrieved(typeface);
    }
}

