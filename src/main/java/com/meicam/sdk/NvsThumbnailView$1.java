/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.meicam.sdk;

import android.graphics.Bitmap;
import com.meicam.sdk.NvsThumbnailView;

public class NvsThumbnailView$1
implements Runnable {
    public final /* synthetic */ NvsThumbnailView this$0;
    public final /* synthetic */ Bitmap val$bitmap;

    public NvsThumbnailView$1(NvsThumbnailView nvsThumbnailView, Bitmap bitmap) {
        this.this$0 = nvsThumbnailView;
        this.val$bitmap = bitmap;
    }

    public void run() {
        NvsThumbnailView nvsThumbnailView = this.this$0;
        Bitmap bitmap = this.val$bitmap;
        NvsThumbnailView.access$002(nvsThumbnailView, bitmap);
        this.this$0.invalidate();
    }
}

