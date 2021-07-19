/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 */
package d.v.d.g.g;

import android.media.ImageReader;
import d.v.d.g.g.m;

public final class g
implements ImageReader.OnImageAvailableListener {
    public final /* synthetic */ m a;

    public /* synthetic */ g(m m10) {
        this.a = m10;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.a.K(imageReader);
    }
}

