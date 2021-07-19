/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import androidx.core.provider.CallbackWithHandler;
import androidx.core.provider.FontRequestWorker$TypefaceResult;
import androidx.core.util.Consumer;

public class FontRequestWorker$2
implements Consumer {
    public final /* synthetic */ CallbackWithHandler val$callback;

    public FontRequestWorker$2(CallbackWithHandler callbackWithHandler) {
        this.val$callback = callbackWithHandler;
    }

    public void accept(FontRequestWorker$TypefaceResult fontRequestWorker$TypefaceResult) {
        this.val$callback.onTypefaceResult(fontRequestWorker$TypefaceResult);
    }
}

