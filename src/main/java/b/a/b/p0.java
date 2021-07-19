/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageSaver;
import java.io.File;

public final class p0
implements Runnable {
    public final /* synthetic */ ImageSaver a;
    public final /* synthetic */ File b;

    public /* synthetic */ p0(ImageSaver imageSaver, File file) {
        this.a = imageSaver;
        this.b = file;
    }

    public final void run() {
        ImageSaver imageSaver = this.a;
        File file = this.b;
        imageSaver.f(file);
    }
}

