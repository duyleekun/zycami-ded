/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.graphics.Bitmap
 *  android.media.MediaFormat
 */
package com.zhishen.imagetool;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import com.zhishen.imagetool.ImageStitcher;
import com.zhishen.imagetool.ImageStitcher$a$a;
import com.zhishen.imagetool.ImageStitcher$b;
import d.u.a.b;
import d.u.a.c;

public final class ImageStitcher$a
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ String c;
    public final /* synthetic */ AssetFileDescriptor d;
    public final /* synthetic */ ImageStitcher$b e;

    public ImageStitcher$a(String string2, Bitmap bitmap, String string3, AssetFileDescriptor assetFileDescriptor, ImageStitcher$b b10) {
        this.a = string2;
        this.b = bitmap;
        this.c = string3;
        this.d = assetFileDescriptor;
        this.e = b10;
    }

    /*
     * WARNING - void declaration
     */
    public void run() {
        Object object;
        Object object2 = this.a;
        Object object3 = new c((String)object2);
        object2 = ImageStitcher.y(this.b);
        Object object4 = this.c;
        boolean bl2 = ImageStitcher.a((String)object4);
        if (bl2) {
            object = this.d;
            object4 = new b((AssetFileDescriptor)object);
        } else {
            object = this.c;
            object4 = new b((String)object);
        }
        object = ((b)object4).b();
        boolean bl3 = true;
        boolean bl4 = ((c)object3).a((MediaFormat)object, (int)(bl3 ? 1 : 0));
        ImageStitcher$a$a imageStitcher$a$a = new ImageStitcher$a$a(this, (ImageStitcher)object2, (c)object3);
        ((b)object4).m(imageStitcher$a$a);
        ((b)object4).a();
        bl2 = ((b)object4).l();
        boolean bl5 = ((c)object3).h();
        int bl6 = ImageStitcher.b((ImageStitcher)object2);
        int n10 = 5;
        int n11 = 0;
        if (bl6 < n10) {
            boolean bl7 = bl3;
        } else {
            boolean bl8 = false;
        }
        int n12 = ImageStitcher.d((ImageStitcher)object2);
        ((c)object3).j();
        object3 = this.e;
        if (object3 != null) {
            void var10_13;
            if (bl2 && bl5 && var10_13 != false) {
                n12 = 0;
                object2 = null;
                if (!bl4) {
                    n11 = -4;
                }
                object3.a(bl3, null, n11);
            } else if (!bl2) {
                n12 = -2;
                object4 = "Video Decoder Init Failed";
                object3.a(false, (String)object4, n12);
            } else if (var10_13 == false) {
                object4 = "Stitch Failed";
                object3.a(false, (String)object4, n12);
            } else if (!bl5) {
                n12 = -3;
                object4 = "Video Encoder Init Failed";
                object3.a(false, (String)object4, n12);
            }
        }
    }
}

