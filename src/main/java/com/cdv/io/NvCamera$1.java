/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 *  com.cdv.io.NvCamera
 */
package com.cdv.io;

import android.content.Context;
import android.view.OrientationEventListener;
import com.cdv.io.NvCamera;

public class NvCamera$1
extends OrientationEventListener {
    public final /* synthetic */ NvCamera this$0;

    public NvCamera$1(NvCamera nvCamera, Context context, int n10) {
        this.this$0 = nvCamera;
        super(context, n10);
    }

    public void onOrientationChanged(int n10) {
        NvCamera.access$100((int)NvCamera.access$000((NvCamera)this.this$0), (int)n10);
    }
}

