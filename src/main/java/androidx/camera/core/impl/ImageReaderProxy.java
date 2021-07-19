/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core.impl;

import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import java.util.concurrent.Executor;

public interface ImageReaderProxy {
    public ImageProxy acquireLatestImage();

    public ImageProxy acquireNextImage();

    public void clearOnImageAvailableListener();

    public void close();

    public int getHeight();

    public int getImageFormat();

    public int getMaxImages();

    public Surface getSurface();

    public int getWidth();

    public void setOnImageAvailableListener(ImageReaderProxy$OnImageAvailableListener var1, Executor var2);
}

