/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.core.impl;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.ImageProxyBundle;

public interface CaptureProcessor {
    public void onOutputSurface(Surface var1, int var2);

    public void onResolutionUpdate(Size var1);

    public void process(ImageProxyBundle var1);
}

