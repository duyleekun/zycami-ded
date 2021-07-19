/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Handler
 */
package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.provider.CallbackWithHandler$1;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.core.provider.CalleeHandler;
import androidx.core.provider.FontRequestWorker$TypefaceResult;
import androidx.core.provider.FontsContractCompat$FontRequestCallback;

public class CallbackWithHandler {
    private final FontsContractCompat$FontRequestCallback mCallback;
    private final Handler mCallbackHandler;

    public CallbackWithHandler(FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback) {
        this.mCallback = fontsContractCompat$FontRequestCallback;
        fontsContractCompat$FontRequestCallback = CalleeHandler.create();
        this.mCallbackHandler = fontsContractCompat$FontRequestCallback;
    }

    public CallbackWithHandler(FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback, Handler handler) {
        this.mCallback = fontsContractCompat$FontRequestCallback;
        this.mCallbackHandler = handler;
    }

    private void onTypefaceRequestFailed(int n10) {
        FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback = this.mCallback;
        Handler handler = this.mCallbackHandler;
        CallbackWithHandler$2 callbackWithHandler$2 = new CallbackWithHandler$2(this, fontsContractCompat$FontRequestCallback, n10);
        handler.post((Runnable)callbackWithHandler$2);
    }

    private void onTypefaceRetrieved(Typeface typeface) {
        FontsContractCompat$FontRequestCallback fontsContractCompat$FontRequestCallback = this.mCallback;
        Handler handler = this.mCallbackHandler;
        CallbackWithHandler$1 callbackWithHandler$1 = new CallbackWithHandler$1(this, fontsContractCompat$FontRequestCallback, typeface);
        handler.post((Runnable)callbackWithHandler$1);
    }

    public void onTypefaceResult(FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult) {
        boolean bl2 = fontRequestWorker$TypefaceResult.isSuccess();
        if (bl2) {
            fontRequestWorker$TypefaceResult = fontRequestWorker$TypefaceResult.mTypeface;
            this.onTypefaceRetrieved((Typeface)fontRequestWorker$TypefaceResult);
        } else {
            int n10 = fontRequestWorker$TypefaceResult.mResult;
            this.onTypefaceRequestFailed(n10);
        }
    }
}

