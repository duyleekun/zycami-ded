/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.SettableImageProxyBundle;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public class SettableImageProxyBundle$1
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ SettableImageProxyBundle this$0;
    public final /* synthetic */ int val$captureId;

    public SettableImageProxyBundle$1(SettableImageProxyBundle settableImageProxyBundle, int n10) {
        this.this$0 = settableImageProxyBundle;
        this.val$captureId = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object attachCompleter(CallbackToFutureAdapter$Completer object) {
        Object object2 = this.this$0.mLock;
        synchronized (object2) {
            SettableImageProxyBundle settableImageProxyBundle = this.this$0;
            settableImageProxyBundle = settableImageProxyBundle.mCompleters;
            int n10 = this.val$captureId;
            settableImageProxyBundle.put(n10, object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("getImageProxy(id: ");
        int n11 = this.val$captureId;
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(")");
        return ((StringBuilder)object).toString();
    }
}

