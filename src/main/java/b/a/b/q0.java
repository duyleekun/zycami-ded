/*
 * Decompiled with CFR 0.151.
 */
package b.a.b;

import androidx.camera.core.ImageSaver;
import androidx.camera.core.ImageSaver$SaveError;

public final class q0
implements Runnable {
    public final /* synthetic */ ImageSaver a;
    public final /* synthetic */ ImageSaver$SaveError b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Throwable d;

    public /* synthetic */ q0(ImageSaver imageSaver, ImageSaver$SaveError imageSaver$SaveError, String string2, Throwable throwable) {
        this.a = imageSaver;
        this.b = imageSaver$SaveError;
        this.c = string2;
        this.d = throwable;
    }

    public final void run() {
        ImageSaver imageSaver = this.a;
        ImageSaver$SaveError imageSaver$SaveError = this.b;
        String string2 = this.c;
        Throwable throwable = this.d;
        imageSaver.b(imageSaver$SaveError, string2, throwable);
    }
}

