/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsARFaceContext$1;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextDetectActionCallback;

public class NvsARFaceContext$1$5
implements Runnable {
    public final /* synthetic */ NvsARFaceContext$1 this$1;
    public final /* synthetic */ long val$actionType;

    public NvsARFaceContext$1$5(NvsARFaceContext$1 nvsARFaceContext$1, long l10) {
        this.this$1 = nvsARFaceContext$1;
        this.val$actionType = l10;
    }

    public void run() {
        NvsARFaceContext$NvsARFaceContextDetectActionCallback nvsARFaceContext$NvsARFaceContextDetectActionCallback = this.this$1.this$0.m_detectActionCallback;
        if (nvsARFaceContext$NvsARFaceContextDetectActionCallback != null) {
            long l10 = this.val$actionType;
            nvsARFaceContext$NvsARFaceContextDetectActionCallback.notifyDetectedAction(l10);
        }
    }
}

