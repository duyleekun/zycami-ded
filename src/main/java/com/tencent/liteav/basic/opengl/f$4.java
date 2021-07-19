/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 */
package com.tencent.liteav.basic.opengl;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.liteav.basic.opengl.f;
import com.tencent.liteav.basic.opengl.o;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class f$4
implements Runnable {
    public final /* synthetic */ ByteBuffer a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ o e;
    public final /* synthetic */ f f;

    public f$4(f f10, ByteBuffer byteBuffer, Bitmap bitmap, int n10, int n11, o o10) {
        this.f = f10;
        this.a = byteBuffer;
        this.b = bitmap;
        this.c = n10;
        this.d = n11;
        this.e = o10;
    }

    public void run() {
        this.a.position(0);
        Bitmap bitmap = this.b;
        ByteBuffer byteBuffer = this.a;
        bitmap.copyPixelsFromBuffer((Buffer)byteBuffer);
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, -1.0f);
        Bitmap bitmap2 = this.b;
        int n10 = this.c;
        int n11 = this.d;
        bitmap = Bitmap.createBitmap((Bitmap)bitmap2, (int)0, (int)0, (int)n10, (int)n11, (Matrix)matrix, (boolean)false);
        this.e.a(bitmap);
        this.b.recycle();
    }
}

