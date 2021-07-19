/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 */
package d.v.d.g.d;

import android.media.ImageReader;
import d.v.d.g.d.o;

public final class k
implements ImageReader.OnImageAvailableListener {
    public final /* synthetic */ o a;

    public /* synthetic */ k(o o10) {
        this.a = o10;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.a.Y(imageReader);
    }
}

