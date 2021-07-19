/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.widget.ImageView
 */
package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.zaa;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zae;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

public final class zac
extends zaa {
    private WeakReference zanc;

    public zac(ImageView imageView, int n10) {
        super(null, n10);
        WeakReference<ImageView> weakReference;
        Asserts.checkNotNull(imageView);
        this.zanc = weakReference = new WeakReference<ImageView>(imageView);
    }

    public zac(ImageView imageView, Uri object) {
        super((Uri)object, 0);
        Asserts.checkNotNull(imageView);
        super(imageView);
        this.zanc = object;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof zac;
        if (!bl3) {
            return false;
        }
        bl3 = true;
        if (this == object) {
            return bl3;
        }
        object = (zac)object;
        ImageView imageView = (ImageView)this.zanc.get();
        object = (ImageView)((zac)object).zanc.get();
        if (object != null && imageView != null && (bl2 = Objects.equal(object, imageView))) {
            return bl3;
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    public final void zaa(Drawable drawable2, boolean bl2, boolean bl3, boolean bl4) {
        block11: {
            int n10;
            int n11;
            boolean bl5;
            void var4_6;
            boolean bl6;
            int n12;
            ImageView imageView;
            block12: {
                imageView = (ImageView)this.zanc.get();
                if (imageView == null) break block11;
                n12 = 0;
                bl5 = !bl6 && var4_6 == false;
                if (!bl5 || (n11 = imageView instanceof zaj) == 0) break block12;
                n11 = zaj.zach();
                n10 = this.zamx;
                if (n10 != 0 && n11 == n10) break block11;
            }
            boolean bl7 = this.zaa(bl2, bl6);
            bl6 = false;
            Uri uri = null;
            if (bl7) {
                Drawable drawable3 = imageView.getDrawable();
                if (drawable3 != null) {
                    n10 = drawable3 instanceof zae;
                    if (n10 != 0) {
                        drawable3 = ((zae)drawable3).zacf();
                    }
                } else {
                    n11 = 0;
                    drawable3 = null;
                }
                zae zae2 = new zae(drawable3, drawable2);
                drawable2 = zae2;
            }
            imageView.setImageDrawable(drawable2);
            boolean bl8 = imageView instanceof zaj;
            if (bl8) {
                if (var4_6 != false) {
                    uri = this.zamv.uri;
                }
                zaj.zaa(uri);
                if (bl5) {
                    n12 = this.zamx;
                }
                zaj.zai(n12);
            }
            if (bl7) {
                drawable2 = (zae)drawable2;
                int n13 = 250;
                drawable2.startTransition(n13);
            }
        }
    }
}

