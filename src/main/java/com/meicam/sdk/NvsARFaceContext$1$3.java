/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsARFaceContext$1;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextErrorCallback;

public class NvsARFaceContext$1$3
implements Runnable {
    public final /* synthetic */ NvsARFaceContext$1 this$1;
    public final /* synthetic */ int val$error;
    public final /* synthetic */ String val$itemPath;

    public NvsARFaceContext$1$3(NvsARFaceContext$1 nvsARFaceContext$1, String string2, int n10) {
        this.this$1 = nvsARFaceContext$1;
        this.val$itemPath = string2;
        this.val$error = n10;
    }

    public void run() {
        NvsARFaceContext$NvsARFaceContextErrorCallback nvsARFaceContext$NvsARFaceContextErrorCallback = this.this$1.this$0.m_errorCallback;
        if (nvsARFaceContext$NvsARFaceContextErrorCallback != null) {
            String string2 = this.val$itemPath;
            int n10 = this.val$error;
            nvsARFaceContext$NvsARFaceContextErrorCallback.notifyFaceItemLoadingFailed(string2, n10);
        }
    }
}

