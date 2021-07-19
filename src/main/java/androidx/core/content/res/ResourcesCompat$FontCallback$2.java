/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat$FontCallback;

public class ResourcesCompat$FontCallback$2
implements Runnable {
    public final /* synthetic */ ResourcesCompat$FontCallback this$0;
    public final /* synthetic */ int val$reason;

    public ResourcesCompat$FontCallback$2(ResourcesCompat$FontCallback resourcesCompat$FontCallback, int n10) {
        this.this$0 = resourcesCompat$FontCallback;
        this.val$reason = n10;
    }

    public void run() {
        ResourcesCompat$FontCallback resourcesCompat$FontCallback = this.this$0;
        int n10 = this.val$reason;
        resourcesCompat$FontCallback.onFontRetrievalFailed(n10);
    }
}

