/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.google.android.gms.common.images.zab;

public final class ImageManager$zaa
extends LruCache {
    public final /* synthetic */ void entryRemoved(boolean bl2, Object object, Object object2, Object object3) {
        object = (zab)object;
        object2 = (Bitmap)object2;
        object3 = (Bitmap)object3;
        super.entryRemoved(bl2, object, object2, object3);
    }

    public final /* synthetic */ int sizeOf(Object object, Object object2) {
        object2 = (Bitmap)object2;
        int n10 = object2.getHeight();
        int n11 = object2.getRowBytes();
        return n10 * n11;
    }
}

