/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsARFaceContext$1;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextCallback;

public class NvsARFaceContext$1$1
implements Runnable {
    public final /* synthetic */ NvsARFaceContext$1 this$1;
    public final /* synthetic */ String val$itemPath;

    public NvsARFaceContext$1$1(NvsARFaceContext$1 var1_1, String string2) {
        this.this$1 = var1_1;
        this.val$itemPath = string2;
    }

    public void run() {
        NvsARFaceContext$NvsARFaceContextCallback nvsARFaceContext$NvsARFaceContextCallback = this.this$1.this$0.m_callback;
        if (nvsARFaceContext$NvsARFaceContextCallback != null) {
            String string2 = this.val$itemPath;
            nvsARFaceContext$NvsARFaceContextCallback.notifyFaceItemLoadingBegin(string2);
        }
    }
}

