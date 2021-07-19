/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.meicam.sdk;

import android.os.Handler;
import com.meicam.sdk.NvsARFaceContext;
import com.meicam.sdk.NvsARFaceContext$1$1;
import com.meicam.sdk.NvsARFaceContext$1$2;
import com.meicam.sdk.NvsARFaceContext$1$3;
import com.meicam.sdk.NvsARFaceContext$1$4;
import com.meicam.sdk.NvsARFaceContext$1$5;
import com.meicam.sdk.NvsARFaceContext$NvsARFaceContextInternalCallback;

public class NvsARFaceContext$1
implements NvsARFaceContext$NvsARFaceContextInternalCallback {
    public final /* synthetic */ NvsARFaceContext this$0;

    public NvsARFaceContext$1(NvsARFaceContext nvsARFaceContext) {
        this.this$0 = nvsARFaceContext;
    }

    public void notifyDetectedAction(long l10) {
        Handler handler = this.this$0.mainHandler;
        NvsARFaceContext$1$5 nvsARFaceContext$1$5 = new NvsARFaceContext$1$5(this, l10);
        handler.post((Runnable)nvsARFaceContext$1$5);
    }

    public void notifyFaceItemLoadingBegin(String string2) {
        Handler handler = this.this$0.mainHandler;
        NvsARFaceContext$1$1 nvsARFaceContext$1$1 = new NvsARFaceContext$1$1(this, string2);
        handler.post((Runnable)nvsARFaceContext$1$1);
    }

    public void notifyFaceItemLoadingFailed(String string2, int n10) {
        Handler handler = this.this$0.mainHandler;
        NvsARFaceContext$1$3 nvsARFaceContext$1$3 = new NvsARFaceContext$1$3(this, string2, n10);
        handler.post((Runnable)nvsARFaceContext$1$3);
    }

    public void notifyFaceItemLoadingFinish() {
        Handler handler = this.this$0.mainHandler;
        NvsARFaceContext$1$2 nvsARFaceContext$1$2 = new NvsARFaceContext$1$2(this);
        handler.post((Runnable)nvsARFaceContext$1$2);
    }

    public void notifyObjectLandmark(float[] fArray, int n10, int n11, long l10) {
        Handler handler = this.this$0.mainHandler;
        NvsARFaceContext$1$4 nvsARFaceContext$1$4 = new NvsARFaceContext$1$4(this, fArray, n10, n11, l10);
        handler.post((Runnable)nvsARFaceContext$1$4);
    }
}

