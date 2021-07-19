/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

public interface NvsARFaceContext$NvsARFaceContextInternalCallback {
    public void notifyDetectedAction(long var1);

    public void notifyFaceItemLoadingBegin(String var1);

    public void notifyFaceItemLoadingFailed(String var1, int var2);

    public void notifyFaceItemLoadingFinish();

    public void notifyObjectLandmark(float[] var1, int var2, int var3, long var4);
}

