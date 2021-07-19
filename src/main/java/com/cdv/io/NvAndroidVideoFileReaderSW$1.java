/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 */
package com.cdv.io;

import android.media.ImageReader;
import com.cdv.io.NvAndroidVideoFileReaderSW;

public class NvAndroidVideoFileReaderSW$1
implements ImageReader.OnImageAvailableListener {
    public final /* synthetic */ NvAndroidVideoFileReaderSW this$0;

    public NvAndroidVideoFileReaderSW$1(NvAndroidVideoFileReaderSW nvAndroidVideoFileReaderSW) {
        this.this$0 = nvAndroidVideoFileReaderSW;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onImageAvailable(ImageReader object) {
        object = NvAndroidVideoFileReaderSW.access$000(this.this$0);
        synchronized (object) {
            Object object2 = this.this$0;
            boolean bl2 = true;
            NvAndroidVideoFileReaderSW.access$102((NvAndroidVideoFileReaderSW)object2, bl2);
            object2 = this.this$0;
            object2 = NvAndroidVideoFileReaderSW.access$000((NvAndroidVideoFileReaderSW)object2);
            object2.notifyAll();
            return;
        }
    }
}

