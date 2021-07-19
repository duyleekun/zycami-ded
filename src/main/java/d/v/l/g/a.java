/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.util.Size
 *  android.widget.ImageView
 */
package d.v.l.g;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.widget.ImageView;
import com.zhiyun.image.Images;
import com.zhiyun.image.Images$CacheStrategy;
import com.zhiyun.image.Images$d;
import d.v.l.e;
import d.v.l.g.a$a;
import d.v.l.g.a$b;
import d.v.l.g.a$c;

public class a {
    private static int a(float f10) {
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        return (int)(f10 * f11 + 0.5f);
    }

    /*
     * WARNING - void declaration
     */
    public static void b(ImageView imageView, Object object, Bitmap bitmap, Drawable object2, int n10, boolean bl2, boolean bl3, Images$CacheStrategy images$CacheStrategy, a$c a$c, a$b a$b) {
        void var9_10;
        void var8_9;
        void var6_7;
        void var7_8;
        int n11;
        Images$d images$d = new Images$d();
        if (object2 != null) {
            images$d.t((Drawable)object2);
        }
        if (n10 != 0) {
            float f10 = n10;
            n11 = a.a(f10);
            images$d.y(n11);
        }
        if (bl2 && (n11 = imageView.getWidth()) != 0 && (n11 = imageView.getHeight()) != 0) {
            n10 = imageView.getWidth();
            int n12 = imageView.getHeight();
            object2 = new Size(n10, n12);
            images$d.v((Size)object2);
        }
        if (var7_8 != null) {
            images$d.p((Images$CacheStrategy)var7_8);
        }
        images$d.o((boolean)var6_7);
        object2 = new a$a((a$c)var8_9, (a$b)var9_10);
        if (object != null) {
            Images.l(imageView, object, images$d, (e)object2);
        } else if (bitmap != null) {
            Images.l(imageView, bitmap, images$d, (e)object2);
        } else {
            object = "";
            Images.l(imageView, object, images$d, (e)object2);
        }
    }
}

