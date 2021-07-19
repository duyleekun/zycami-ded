/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsCheckExpirationOnline;

public class NvsCheckExpirationOnline$1
implements Runnable {
    public final /* synthetic */ NvsCheckExpirationOnline this$0;

    public NvsCheckExpirationOnline$1(NvsCheckExpirationOnline nvsCheckExpirationOnline) {
        this.this$0 = nvsCheckExpirationOnline;
    }

    public void run() {
        Thread thread = NvsCheckExpirationOnline.access$000(this.this$0);
        if (thread != null) {
            thread = NvsCheckExpirationOnline.access$000(this.this$0);
            thread.start();
        }
    }
}

