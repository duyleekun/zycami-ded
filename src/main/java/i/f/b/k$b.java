/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Image
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 */
package i.f.b;

import android.media.Image;
import android.media.ImageReader;
import i.f.b.k;
import i.f.b.k$d;

public class k$b
implements ImageReader.OnImageAvailableListener {
    public static final /* synthetic */ boolean b;
    public final /* synthetic */ k a;

    public k$b(k k10) {
        this.a = k10;
    }

    public void onImageAvailable(ImageReader imageReader) {
        if ((imageReader = imageReader.acquireLatestImage()) == null) {
            return;
        }
        imageReader.getPlanes();
        k k10 = this.a;
        k$d k$d = new k$d(k10, (Image)imageReader);
        this.a.f(k$d);
        k$d.c();
        imageReader.close();
    }
}

