/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 */
package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager$OnImageLoadedListener;
import com.google.android.gms.common.images.zaa;
import com.google.android.gms.common.images.zab;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import java.lang.ref.WeakReference;

public final class zad
extends zaa {
    private WeakReference zand;

    public zad(ImageManager$OnImageLoadedListener imageManager$OnImageLoadedListener, Uri object) {
        super((Uri)object, 0);
        Asserts.checkNotNull(imageManager$OnImageLoadedListener);
        super(imageManager$OnImageLoadedListener);
        this.zand = object;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = object instanceof zad;
        if (!bl4) {
            return false;
        }
        bl4 = true;
        if (this == object) {
            return bl4;
        }
        object = (zad)object;
        Object object2 = (ImageManager$OnImageLoadedListener)this.zand.get();
        ImageManager$OnImageLoadedListener imageManager$OnImageLoadedListener = (ImageManager$OnImageLoadedListener)((zad)object).zand.get();
        if (imageManager$OnImageLoadedListener != null && object2 != null && (bl3 = Objects.equal(imageManager$OnImageLoadedListener, object2)) && (bl2 = Objects.equal(object = ((zaa)object).zamv, object2 = this.zamv))) {
            return bl4;
        }
        return false;
    }

    public final int hashCode() {
        Object[] objectArray = new Object[1];
        zab zab2 = this.zamv;
        objectArray[0] = zab2;
        return Objects.hashCode(objectArray);
    }

    public final void zaa(Drawable drawable2, boolean bl2, boolean bl3, boolean bl4) {
        ImageManager$OnImageLoadedListener imageManager$OnImageLoadedListener;
        if (!bl3 && (imageManager$OnImageLoadedListener = (ImageManager$OnImageLoadedListener)this.zand.get()) != null) {
            Uri uri = this.zamv.uri;
            imageManager$OnImageLoadedListener.onImageLoaded(uri, drawable2, bl4);
        }
    }
}

