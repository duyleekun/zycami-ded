/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.rtmp;

import android.os.Bundle;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.b;

public class b$6
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Bundle b;
    public final /* synthetic */ b c;

    public b$6(b b10, int n10, Bundle bundle) {
        this.c = b10;
        this.a = n10;
        this.b = bundle;
    }

    public void run() {
        ITXLivePushListener iTXLivePushListener = com.tencent.rtmp.b.a(this.c);
        if (iTXLivePushListener != null) {
            iTXLivePushListener = com.tencent.rtmp.b.a(this.c);
            int n10 = this.a;
            Bundle bundle = this.b;
            iTXLivePushListener.onPushEvent(n10, bundle);
        }
    }
}

