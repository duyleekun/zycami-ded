/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.SettableImageProxyBundle;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import b.a.b.w0;
import java.util.concurrent.Executor;

public class ProcessingImageReader$2
implements ImageReaderProxy$OnImageAvailableListener {
    public final /* synthetic */ ProcessingImageReader this$0;

    public ProcessingImageReader$2(ProcessingImageReader processingImageReader) {
        this.this$0 = processingImageReader;
    }

    private /* synthetic */ void a(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        ProcessingImageReader processingImageReader = this.this$0;
        imageReaderProxy$OnImageAvailableListener.onImageAvailable(processingImageReader);
    }

    public /* synthetic */ void b(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        this.a(imageReaderProxy$OnImageAvailableListener);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onImageAvailable(ImageReaderProxy object) {
        Executor executor;
        ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener;
        object = this.this$0.mLock;
        synchronized (object) {
            Object object2 = this.this$0;
            imageReaderProxy$OnImageAvailableListener = ((ProcessingImageReader)object2).mListener;
            executor = ((ProcessingImageReader)object2).mExecutor;
            object2 = ((ProcessingImageReader)object2).mSettableImageProxyBundle;
            ((SettableImageProxyBundle)object2).reset();
            object2 = this.this$0;
            ((ProcessingImageReader)object2).setupSettableImageProxyBundleCallbacks();
        }
        if (imageReaderProxy$OnImageAvailableListener == null) return;
        if (executor != null) {
            object = new w0(this, imageReaderProxy$OnImageAvailableListener);
            executor.execute((Runnable)object);
            return;
        }
        object = this.this$0;
        imageReaderProxy$OnImageAvailableListener.onImageAvailable((ImageReaderProxy)object);
    }
}

