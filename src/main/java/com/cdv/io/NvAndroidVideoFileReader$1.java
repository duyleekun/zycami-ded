/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.util.Log
 */
package com.cdv.io;

import android.graphics.SurfaceTexture;
import android.util.Log;
import com.cdv.io.NvAndroidVideoFileReader;
import java.util.concurrent.Semaphore;

public class NvAndroidVideoFileReader$1
implements Runnable {
    public final /* synthetic */ NvAndroidVideoFileReader this$0;

    public NvAndroidVideoFileReader$1(NvAndroidVideoFileReader nvAndroidVideoFileReader) {
        this.this$0 = nvAndroidVideoFileReader;
    }

    public void run() {
        Object object = this.this$0;
        Object object2 = this.this$0;
        int n10 = NvAndroidVideoFileReader.access$100((NvAndroidVideoFileReader)object2);
        CharSequence charSequence = new SurfaceTexture(n10);
        NvAndroidVideoFileReader.access$002((NvAndroidVideoFileReader)object, (SurfaceTexture)charSequence);
        object = this.this$0;
        object = NvAndroidVideoFileReader.access$200((NvAndroidVideoFileReader)object);
        try {
            ((Semaphore)object).release();
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            charSequence.append("");
            object2 = exception.getMessage();
            charSequence.append((String)object2);
            charSequence = charSequence.toString();
            object2 = "NvAndroidVideoFileReader";
            Log.e((String)object2, (String)charSequence);
            exception.printStackTrace();
        }
    }
}

