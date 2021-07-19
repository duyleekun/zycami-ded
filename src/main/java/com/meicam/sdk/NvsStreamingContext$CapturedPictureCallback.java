/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsVideoFrameInfo;
import java.nio.ByteBuffer;

public interface NvsStreamingContext$CapturedPictureCallback {
    public void onCapturedPictureArrived(ByteBuffer var1, NvsVideoFrameInfo var2);
}

