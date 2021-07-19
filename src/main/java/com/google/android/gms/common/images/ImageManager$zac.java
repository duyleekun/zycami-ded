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
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager$ImageReceiver;
import com.google.android.gms.common.images.zaa;
import com.google.android.gms.common.images.zab;
import com.google.android.gms.common.images.zad;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;
import java.util.HashSet;

public final class ImageManager$zac
implements Runnable {
    private final /* synthetic */ ImageManager zamr;
    private final zaa zamt;

    public ImageManager$zac(ImageManager imageManager, zaa zaa2) {
        this.zamr = imageManager;
        this.zamt = zaa2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Object object;
        Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
        Object object2 = ImageManager.zaa(this.zamr);
        Object object3 = this.zamt;
        object2 = (ImageManager$ImageReceiver)((Object)object2.get(object3));
        if (object2 != null) {
            object3 = ImageManager.zaa(this.zamr);
            object = this.zamt;
            object3.remove(object);
            object3 = this.zamt;
            ((ImageManager$ImageReceiver)((Object)object2)).zac((zaa)object3);
        }
        object2 = this.zamt;
        object3 = ((zaa)object2).zamv;
        object = ((zab)object3).uri;
        boolean bl2 = true;
        if (object == null) {
            object3 = ImageManager.zab(this.zamr);
            object = ImageManager.zac(this.zamr);
            ((zaa)object2).zaa((Context)object3, (zak)object, bl2);
            return;
        }
        object2 = ImageManager.zaa(this.zamr, (zab)object3);
        if (object2 != null) {
            object3 = this.zamt;
            object = ImageManager.zab(this.zamr);
            ((zaa)object3).zaa((Context)object, (Bitmap)object2, bl2);
            return;
        }
        object2 = ImageManager.zad(this.zamr);
        object = ((zab)object3).uri;
        if ((object2 = (Long)object2.get(object)) != null) {
            long l10 = SystemClock.elapsedRealtime();
            long l11 = (Long)object2;
            long l12 = (l10 -= l11) - (l11 = 3600000L);
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 < 0) {
                object2 = this.zamt;
                object3 = ImageManager.zab(this.zamr);
                object = ImageManager.zac(this.zamr);
                ((zaa)object2).zaa((Context)object3, (zak)object, bl2);
                return;
            }
            object2 = ImageManager.zad(this.zamr);
            object = ((zab)object3).uri;
            object2.remove(object);
        }
        object2 = this.zamt;
        object = ImageManager.zab(this.zamr);
        Object object5 = ImageManager.zac(this.zamr);
        ((zaa)object2).zaa((Context)object, (zak)object5);
        object2 = ImageManager.zae(this.zamr);
        object = ((zab)object3).uri;
        object2 = (ImageManager$ImageReceiver)((Object)object2.get(object));
        if (object2 == null) {
            object = this.zamr;
            object5 = ((zab)object3).uri;
            object2 = new ImageManager$ImageReceiver((ImageManager)object, (Uri)object5);
            object = ImageManager.zae(this.zamr);
            object5 = ((zab)object3).uri;
            object.put(object5, object2);
        }
        object = this.zamt;
        ((ImageManager$ImageReceiver)((Object)object2)).zab((zaa)object);
        object = this.zamt;
        boolean bl3 = object instanceof zad;
        if (!bl3) {
            object = ImageManager.zaa(this.zamr);
            object5 = this.zamt;
            object.put(object5, object2);
        }
        object = ImageManager.zacc();
        synchronized (object) {
            object5 = ImageManager.zacd();
            Uri uri = ((zab)object3).uri;
            bl2 = ((HashSet)object5).contains(uri);
            if (!bl2) {
                object5 = ImageManager.zacd();
                object3 = ((zab)object3).uri;
                ((HashSet)object5).add(object3);
                ((ImageManager$ImageReceiver)((Object)object2)).zace();
            }
            return;
        }
    }
}

