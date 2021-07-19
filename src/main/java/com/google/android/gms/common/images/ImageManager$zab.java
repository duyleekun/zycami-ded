/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.ParcelFileDescriptor
 *  android.util.Log
 */
package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager$zad;
import com.google.android.gms.common.internal.Asserts;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public final class ImageManager$zab
implements Runnable {
    private final Uri mUri;
    private final /* synthetic */ ImageManager zamr;
    private final ParcelFileDescriptor zams;

    public ImageManager$zab(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.zamr = imageManager;
        this.mUri = uri;
        this.zams = parcelFileDescriptor;
    }

    public final void run() {
        Object object;
        Asserts.checkNotMainThread("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        Object object2 = this.zams;
        int n10 = 1;
        float f10 = Float.MIN_VALUE;
        String string2 = "ImageManager";
        int n11 = 0;
        Object object3 = null;
        Bitmap bitmap = null;
        if (object2 != null) {
            String string3;
            object2 = object2.getFileDescriptor();
            try {
                bitmap = BitmapFactory.decodeFileDescriptor((FileDescriptor)object2);
            }
            catch (OutOfMemoryError outOfMemoryError) {
                object3 = String.valueOf(this.mUri);
                int n12 = String.valueOf(object3).length() + 34;
                object = new StringBuilder(n12);
                string3 = "OOM while loading bitmap for uri: ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append((String)object3);
                object3 = ((StringBuilder)object).toString();
                Log.e((String)string2, (String)object3, (Throwable)outOfMemoryError);
                n11 = n10;
            }
            object2 = this.zams;
            try {
                object2.close();
            }
            catch (IOException iOException) {
                string3 = "closed failed";
                Log.e((String)string2, (String)string3, (Throwable)iOException);
            }
        }
        object2 = new CountDownLatch(n10);
        Handler handler = ImageManager.zag(this.zamr);
        ImageManager imageManager = this.zamr;
        Uri uri = this.mUri;
        object = object3;
        object3 = new ImageManager$zad(imageManager, uri, bitmap, n11 != 0, (CountDownLatch)object2);
        handler.post((Runnable)object3);
        try {
            ((CountDownLatch)object2).await();
            return;
        }
        catch (InterruptedException interruptedException) {
            object2 = String.valueOf(this.mUri);
            n10 = String.valueOf(object2).length() + 32;
            object3 = new StringBuilder(n10);
            ((StringBuilder)object3).append("Latch interrupted while posting ");
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            Log.w((String)string2, (String)object2);
            return;
        }
    }
}

