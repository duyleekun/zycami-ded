/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.BitmapFactory
 *  android.graphics.Matrix
 */
package d.v.d.i.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import d.v.d.h.a;
import d.v.d.h.f;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class b
extends d.v.d.i.a.a {
    public b() {
        d.v.d.i.a.b b10 = new d.v.d.i.a.b();
        this.a = b10;
    }

    private int n() {
        int n10;
        Object object = d.v.d.h.a.b();
        int n11 = ((a)object).a();
        int n12 = 0;
        if (n11 != 0 && n11 == (n10 = 8)) {
            n12 = 180;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("getRotate degree=");
        ((StringBuilder)object).append(n12);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        return n12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void o(byte[] object, boolean bl2, int n10) {
        int n11;
        if (object == null) {
            d.v.d.h.f.a("set photo data ,invalid photo data");
            return;
        }
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("setPhotoData mirror=");
        ((StringBuilder)object2).append(bl2);
        String string2 = ",orientation=";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(n11);
        d.v.d.h.f.a(((StringBuilder)object2).toString());
        Object object3 = d.v.d.h.a.b();
        ((a)object3).e((byte[])object);
        if (bl2) {
            n11 = ((Object)object).length;
            object = BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)n11);
            Matrix matrix = new Matrix();
            n11 = 1065353216;
            float f10 = 1.0f;
            matrix.setScale(-1.0f, f10);
            int n12 = this.n();
            float f11 = n12;
            matrix.postRotate(f11);
            string2 = null;
            int n13 = object.getWidth();
            int n14 = object.getHeight();
            boolean bl3 = true;
            object2 = object;
            Bitmap bitmap = Bitmap.createBitmap((Bitmap)object, (int)0, (int)0, (int)n13, (int)n14, (Matrix)matrix, (boolean)bl3);
            object3 = new ByteArrayOutputStream();
            object2 = Bitmap.CompressFormat.JPEG;
            int n15 = 90;
            bitmap.compress((Bitmap.CompressFormat)object2, n15, (OutputStream)object3);
            try {
                boolean bl4;
                ((ByteArrayOutputStream)object3).close();
                boolean bl5 = object.isRecycled();
                if (!bl5) {
                    object.recycle();
                }
                if (!(bl4 = bitmap.isRecycled())) {
                    bitmap.recycle();
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            object = (d.v.d.i.a.b)this.a;
            byte[] byArray = ((ByteArrayOutputStream)object3).toByteArray();
            ((d.v.d.i.a.b)object).c(byArray);
        } else {
            d.v.d.i.a.b b10 = (d.v.d.i.a.b)this.a;
            b10.c((byte[])object);
        }
        this.d();
    }
}

