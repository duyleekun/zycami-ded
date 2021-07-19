/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 */
package com.cdv.text;

import android.graphics.SurfaceTexture;
import com.cdv.text.NvAndroidGlyphMaskGenerator;

public class NvAndroidGlyphMaskGenerator$1
implements SurfaceTexture.OnFrameAvailableListener {
    public final /* synthetic */ NvAndroidGlyphMaskGenerator this$0;

    public NvAndroidGlyphMaskGenerator$1(NvAndroidGlyphMaskGenerator nvAndroidGlyphMaskGenerator) {
        this.this$0 = nvAndroidGlyphMaskGenerator;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        NvAndroidGlyphMaskGenerator.access$000(this.this$0).release();
    }
}

