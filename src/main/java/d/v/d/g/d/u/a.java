/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 */
package d.v.d.g.d.u;

import android.media.ImageReader;
import d.v.d.g.d.u.e$b;

public final class a
implements ImageReader.OnImageAvailableListener {
    public final /* synthetic */ e$b a;

    public /* synthetic */ a(e$b b10) {
        this.a = b10;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        this.a.c(imageReader);
    }
}

