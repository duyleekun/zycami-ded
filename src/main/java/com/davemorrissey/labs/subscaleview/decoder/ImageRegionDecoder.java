/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.net.Uri
 */
package com.davemorrissey.labs.subscaleview.decoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

public interface ImageRegionDecoder {
    public Bitmap decodeRegion(Rect var1, int var2);

    public Point init(Context var1, Uri var2);

    public boolean isReady();

    public void recycle();
}

