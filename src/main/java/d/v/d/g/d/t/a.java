/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 */
package d.v.d.g.d.t;

import android.media.ImageReader;
import d.v.d.g.d.t.f$a;

public final class a
implements ImageReader.OnImageAvailableListener {
    public final /* synthetic */ f$a a;

    public /* synthetic */ a(f$a a10) {
        this.a = a10;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.a.c(imageReader);
    }
}

