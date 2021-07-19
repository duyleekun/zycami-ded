/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 */
package d.c.a.s.j;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import d.c.a.s.j.c;
import d.c.a.s.j.g;
import d.c.a.s.j.r;

public class k {
    public r a(ImageView object, Class object2) {
        Class<Bitmap> clazz = Bitmap.class;
        boolean bl2 = clazz.equals(object2);
        if (bl2) {
            object2 = new c((ImageView)object);
            return object2;
        }
        clazz = Drawable.class;
        bl2 = clazz.isAssignableFrom((Class<?>)object2);
        if (bl2) {
            object2 = new g((ImageView)object);
            return object2;
        }
        clazz = new StringBuilder();
        ((StringBuilder)((Object)clazz)).append("Unhandled class: ");
        ((StringBuilder)((Object)clazz)).append(object2);
        ((StringBuilder)((Object)clazz)).append(", try .as*(Class).transcode(ResourceTranscoder)");
        object2 = ((StringBuilder)((Object)clazz)).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }
}

