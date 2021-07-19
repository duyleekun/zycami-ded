/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

public interface NvsStreamingContext$CaptureDeviceCallback {
    public void onCaptureDeviceAutoFocusComplete(int var1, boolean var2);

    public void onCaptureDeviceCapsReady(int var1);

    public void onCaptureDeviceError(int var1, int var2);

    public void onCaptureDevicePreviewResolutionReady(int var1);

    public void onCaptureDevicePreviewStarted(int var1);

    public void onCaptureDeviceStopped(int var1);

    public void onCaptureRecordingError(int var1);

    public void onCaptureRecordingFinished(int var1);
}

