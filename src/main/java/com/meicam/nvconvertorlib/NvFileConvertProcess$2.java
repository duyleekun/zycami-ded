/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.meicam.nvconvertorlib;

import android.os.Handler;
import android.os.Looper;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriter$OnReleaseEncoderListener;
import com.meicam.nvconvertorlib.NvFileConvertProcess;
import com.meicam.nvconvertorlib.NvFileConvertProcess$2$1;

public class NvFileConvertProcess$2
implements NvAndroidSurfaceFileWriter$OnReleaseEncoderListener {
    public final /* synthetic */ NvFileConvertProcess this$0;

    public NvFileConvertProcess$2(NvFileConvertProcess nvFileConvertProcess) {
        this.this$0 = nvFileConvertProcess;
    }

    public void onCatchException() {
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new NvFileConvertProcess$2$1(this);
        handler.post((Runnable)object);
    }

    public void onReleaseEncoder(boolean bl2) {
    }
}

