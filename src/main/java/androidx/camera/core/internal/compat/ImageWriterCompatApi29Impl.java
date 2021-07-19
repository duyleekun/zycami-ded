/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageWriter
 *  android.view.Surface
 */
package androidx.camera.core.internal.compat;

import android.media.ImageWriter;
import android.view.Surface;

public final class ImageWriterCompatApi29Impl {
    private ImageWriterCompatApi29Impl() {
    }

    public static ImageWriter newInstance(Surface surface, int n10, int n11) {
        return ImageWriter.newInstance((Surface)surface, (int)n10, (int)n11);
    }
}

