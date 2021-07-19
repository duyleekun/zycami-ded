/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.ProcessingImageReader;
import androidx.camera.core.SettableImageProxyBundle;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import java.util.List;

public class ProcessingImageReader$3
implements FutureCallback {
    public final /* synthetic */ ProcessingImageReader this$0;

    public ProcessingImageReader$3(ProcessingImageReader processingImageReader) {
        this.this$0 = processingImageReader;
    }

    public void onFailure(Throwable throwable) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSuccess(List object) {
        SettableImageProxyBundle settableImageProxyBundle;
        boolean bl2;
        Object object2;
        object = this.this$0.mLock;
        synchronized (object) {
            object2 = this.this$0;
            bl2 = ((ProcessingImageReader)object2).mClosed;
            if (bl2) {
                return;
            }
            ((ProcessingImageReader)object2).mProcessing = bl2 = true;
            settableImageProxyBundle = ((ProcessingImageReader)object2).mSettableImageProxyBundle;
        }
        ((ProcessingImageReader)object2).mCaptureProcessor.process(settableImageProxyBundle);
        object = this.this$0;
        object2 = ((ProcessingImageReader)object).mLock;
        synchronized (object2) {
            object = this.this$0;
            bl2 = false;
            settableImageProxyBundle = null;
            ((ProcessingImageReader)object).mProcessing = false;
            bl2 = ((ProcessingImageReader)object).mClosed;
            if (bl2) {
                object = ((ProcessingImageReader)object).mInputImageReader;
                ((MetadataImageReader)object).close();
                object = this.this$0;
                object = ((ProcessingImageReader)object).mSettableImageProxyBundle;
                ((SettableImageProxyBundle)object).close();
                object = this.this$0;
                object = ((ProcessingImageReader)object).mOutputImageReader;
                object.close();
                object = this.this$0;
                object = ((ProcessingImageReader)object).mCloseCompleter;
                if (object != null) {
                    bl2 = false;
                    settableImageProxyBundle = null;
                    ((CallbackToFutureAdapter$Completer)object).set(null);
                }
            }
            return;
        }
    }
}

