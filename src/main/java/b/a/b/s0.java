/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;

public final class s0
implements Runnable {
    public final /* synthetic */ MetadataImageReader a;
    public final /* synthetic */ ImageReaderProxy$OnImageAvailableListener b;

    public /* synthetic */ s0(MetadataImageReader metadataImageReader, ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        this.a = metadataImageReader;
        this.b = imageReaderProxy$OnImageAvailableListener;
    }

    public final void run() {
        MetadataImageReader metadataImageReader = this.a;
        ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener = this.b;
        metadataImageReader.b(imageReaderProxy$OnImageAvailableListener);
    }
}

