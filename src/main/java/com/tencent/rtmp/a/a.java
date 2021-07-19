/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.rtmp.a;

import android.graphics.Bitmap;
import java.util.List;

public interface a {
    public Bitmap getThumbnail(float var1);

    public void release();

    public void setVTTUrlAndImageUrls(String var1, List var2);
}

