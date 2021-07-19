/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import android.graphics.Bitmap;

public interface QRCodeListener {
    public void onError(Throwable var1);

    public void onSuccess(Bitmap var1);
}

