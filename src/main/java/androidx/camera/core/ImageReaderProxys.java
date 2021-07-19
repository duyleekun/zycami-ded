/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 */
package androidx.camera.core;

import android.media.ImageReader;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy;

public final class ImageReaderProxys {
    private ImageReaderProxys() {
    }

    public static ImageReaderProxy createIsolatedReader(int n10, int n11, int n12, int n13) {
        ImageReader imageReader = ImageReader.newInstance((int)n10, (int)n11, (int)n12, (int)n13);
        AndroidImageReaderProxy androidImageReaderProxy = new AndroidImageReaderProxy(imageReader);
        return androidImageReaderProxy;
    }
}

