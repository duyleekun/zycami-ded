/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.rtmp.b;
import com.tencent.rtmp.ui.TXCloudVideoView;

public class b$12
implements Runnable {
    public final /* synthetic */ Bundle a;
    public final /* synthetic */ int b;
    public final /* synthetic */ b c;

    public b$12(b b10, Bundle bundle, int n10) {
        this.c = b10;
        this.a = bundle;
        this.b = n10;
    }

    public void run() {
        TXCloudVideoView tXCloudVideoView = com.tencent.rtmp.b.g(this.c);
        if (tXCloudVideoView != null) {
            tXCloudVideoView = com.tencent.rtmp.b.g(this.c);
            Bundle bundle = this.a;
            int n10 = this.b;
            tXCloudVideoView.setLogText(null, bundle, n10);
        }
    }
}

