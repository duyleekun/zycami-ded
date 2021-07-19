/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.widget.ImageView
 */
package d.c.a.s.j;

import android.graphics.Bitmap;
import android.widget.ImageView;
import d.c.a.s.j.j;

public class c
extends j {
    public c(ImageView imageView) {
        super(imageView);
    }

    public c(ImageView imageView, boolean bl2) {
        super(imageView, bl2);
    }

    public void w(Bitmap bitmap) {
        ((ImageView)this.b).setImageBitmap(bitmap);
    }
}

