/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsARFaceContext;
import com.meicam.sdk.NvsARFaceContext$1;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextLandmarkCallback;

public class NvsARFaceContext$1$4
implements Runnable {
    public final /* synthetic */ NvsARFaceContext$1 this$1;
    public final /* synthetic */ float[] val$landmark;
    public final /* synthetic */ int val$landmarkSize;
    public final /* synthetic */ int val$objectType;
    public final /* synthetic */ long val$timestamp;

    public NvsARFaceContext$1$4(NvsARFaceContext$1 nvsARFaceContext$1, float[] fArray, int n10, int n11, long l10) {
        this.this$1 = nvsARFaceContext$1;
        this.val$landmark = fArray;
        this.val$landmarkSize = n10;
        this.val$objectType = n11;
        this.val$timestamp = l10;
    }

    public void run() {
        NvsARFaceContext nvsARFaceContext = this.this$1.this$0;
        NvsARFaceContext$NvsARFaceContextLandmarkCallback nvsARFaceContext$NvsARFaceContextLandmarkCallback = nvsARFaceContext.m_landmarkCallback;
        if (nvsARFaceContext$NvsARFaceContextLandmarkCallback != null) {
            float[] fArray = this.val$landmark;
            int n10 = this.val$landmarkSize;
            int n11 = this.val$objectType;
            long l10 = this.val$timestamp;
            nvsARFaceContext$NvsARFaceContextLandmarkCallback.notifyObjectLandmark(fArray, n10, n11, l10);
        }
    }
}

