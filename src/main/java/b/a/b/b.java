/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 */
package b.a.b;

import android.media.ImageReader;
import androidx.camera.core.AndroidImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import java.util.concurrent.Executor;

public final class b
implements ImageReader.OnImageAvailableListener {
    public final /* synthetic */ AndroidImageReaderProxy a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ ImageReaderProxy$OnImageAvailableListener c;

    public /* synthetic */ b(AndroidImageReaderProxy androidImageReaderProxy, Executor executor, ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        this.a = androidImageReaderProxy;
        this.b = executor;
        this.c = imageReaderProxy$OnImageAvailableListener;
    }

    public final void onImageAvailable(ImageReader imageReader) {
        AndroidImageReaderProxy androidImageReaderProxy = this.a;
        Executor executor = this.b;
        ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener = this.c;
        androidImageReaderProxy.d(executor, imageReaderProxy$OnImageAvailableListener, imageReader);
    }
}

