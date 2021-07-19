/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ImageCapture$5
implements ThreadFactory {
    private final AtomicInteger mId;
    public final /* synthetic */ ImageCapture this$0;

    public ImageCapture$5(ImageCapture object) {
        this.this$0 = object;
        this.mId = object = new AtomicInteger(0);
    }

    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("CameraX-image_capture_");
        int n10 = this.mId.getAndIncrement();
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Thread thread = new Thread(runnable, (String)charSequence);
        return thread;
    }
}

