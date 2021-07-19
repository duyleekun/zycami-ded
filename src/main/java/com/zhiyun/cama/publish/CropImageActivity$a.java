/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package com.zhiyun.cama.publish;

import android.os.Handler;
import android.os.Message;
import com.zhiyun.cama.publish.CropImageActivity;
import java.lang.ref.WeakReference;

public class CropImageActivity$a
extends Handler {
    private final WeakReference a;

    public CropImageActivity$a(CropImageActivity cropImageActivity) {
        WeakReference<CropImageActivity> weakReference;
        this.a = weakReference = new WeakReference<CropImageActivity>(cropImageActivity);
    }

    public void handleMessage(Message message) {
        CropImageActivity cropImageActivity = (CropImageActivity)this.a.get();
        if (cropImageActivity == null) {
            return;
        }
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11) {
            CropImageActivity.N(cropImageActivity);
        }
    }
}

