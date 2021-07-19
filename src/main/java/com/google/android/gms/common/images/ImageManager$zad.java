/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.os.SystemClock
 */
package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import androidx.collection.LruCache;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager$ImageReceiver;
import com.google.android.gms.common.images.zaa;
import com.google.android.gms.common.images.zab;
import com.google.android.gms.common.images.zad;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

public final class ImageManager$zad
implements Runnable {
    private final Bitmap mBitmap;
    private final Uri mUri;
    private final CountDownLatch zadr;
    private final /* synthetic */ ImageManager zamr;
    private boolean zamu;

    public ImageManager$zad(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean bl2, CountDownLatch countDownLatch) {
        this.zamr = imageManager;
        this.mUri = uri;
        this.mBitmap = bitmap;
        this.zamu = bl2;
        this.zadr = countDownLatch;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object;
        Uri uri;
        boolean bl2;
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        Object object2 = this.mBitmap;
        HashSet hashSet = null;
        if (object2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        Object object3 = ImageManager.zah(this.zamr);
        if (object3 != null) {
            boolean bl3 = this.zamu;
            if (bl3) {
                ImageManager.zah(this.zamr).evictAll();
                System.gc();
                this.zamu = false;
                ImageManager.zag(this.zamr).post((Runnable)this);
                return;
            }
            if (bl2) {
                object3 = ImageManager.zah(this.zamr);
                uri = this.mUri;
                object = new zab(uri);
                uri = this.mBitmap;
                ((LruCache)object3).put(object, uri);
            }
        }
        object3 = ImageManager.zae(this.zamr);
        object = this.mUri;
        if ((object3 = (ImageManager$ImageReceiver)((Object)object3.remove(object))) != null) {
            object3 = ImageManager$ImageReceiver.zaa((ImageManager$ImageReceiver)((Object)object3));
            int n10 = ((ArrayList)object3).size();
            uri = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object4;
                Object object5;
                zaa zaa2 = (zaa)((ArrayList)object3).get(i10);
                if (bl2) {
                    object5 = ImageManager.zab(this.zamr);
                    object4 = this.mBitmap;
                    zaa2.zaa((Context)object5, (Bitmap)object4, false);
                } else {
                    object5 = ImageManager.zad(this.zamr);
                    object4 = this.mUri;
                    long l10 = SystemClock.elapsedRealtime();
                    Long l11 = l10;
                    object5.put(object4, l11);
                    object5 = ImageManager.zab(this.zamr);
                    object4 = ImageManager.zac(this.zamr);
                    zaa2.zaa((Context)object5, (zak)object4, false);
                }
                boolean bl4 = zaa2 instanceof zad;
                if (bl4) continue;
                object5 = ImageManager.zaa(this.zamr);
                object5.remove(zaa2);
            }
        }
        this.zadr.countDown();
        object2 = ImageManager.zacc();
        synchronized (object2) {
            hashSet = ImageManager.zacd();
            object3 = this.mUri;
            hashSet.remove(object3);
            return;
        }
    }
}

