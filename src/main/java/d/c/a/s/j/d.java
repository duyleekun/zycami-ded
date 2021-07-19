/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 */
package d.c.a.s.j;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import d.c.a.s.j.q;

public class d
extends q {
    public d(ImageView imageView) {
        super(imageView);
    }

    public d(ImageView imageView, boolean bl2) {
        super(imageView, bl2);
    }

    public Drawable x(Bitmap bitmap) {
        Resources resources = ((ImageView)this.b).getResources();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
        return bitmapDrawable;
    }
}

