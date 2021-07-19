/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.OrientationEventListener
 */
package com.cdv.io;

import android.content.Context;
import android.view.OrientationEventListener;
import com.cdv.io.NvOrientationEventListener;

public class NvOrientationEventListener$1
extends OrientationEventListener {
    public final /* synthetic */ NvOrientationEventListener this$0;

    public NvOrientationEventListener$1(NvOrientationEventListener nvOrientationEventListener, Context context, int n10) {
        this.this$0 = nvOrientationEventListener;
        super(context, n10);
    }

    public void onOrientationChanged(int n10) {
        NvOrientationEventListener.access$100(NvOrientationEventListener.access$000(this.this$0), n10);
    }
}

