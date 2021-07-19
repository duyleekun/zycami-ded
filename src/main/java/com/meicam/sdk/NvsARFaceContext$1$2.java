/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsARFaceContext$1;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextCallback;

public class NvsARFaceContext$1$2
implements Runnable {
    public final /* synthetic */ NvsARFaceContext$1 this$1;

    public NvsARFaceContext$1$2(NvsARFaceContext$1 nvsARFaceContext$1) {
        this.this$1 = nvsARFaceContext$1;
    }

    public void run() {
        NvsARFaceContext$NvsARFaceContextCallback nvsARFaceContext$NvsARFaceContextCallback = this.this$1.this$0.m_callback;
        if (nvsARFaceContext$NvsARFaceContextCallback != null) {
            nvsARFaceContext$NvsARFaceContextCallback.notifyFaceItemLoadingFinish();
        }
    }
}

