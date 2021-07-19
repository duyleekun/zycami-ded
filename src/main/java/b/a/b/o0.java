/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package b.a.b;

import android.net.Uri;
import androidx.camera.core.ImageSaver;

public final class o0
implements Runnable {
    public final /* synthetic */ ImageSaver a;
    public final /* synthetic */ Uri b;

    public /* synthetic */ o0(ImageSaver imageSaver, Uri uri) {
        this.a = imageSaver;
        this.b = uri;
    }

    public final void run() {
        ImageSaver imageSaver = this.a;
        Uri uri = this.b;
        imageSaver.d(uri);
    }
}

