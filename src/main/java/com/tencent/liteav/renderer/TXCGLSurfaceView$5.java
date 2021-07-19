/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 */
package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class TXCGLSurfaceView$5
implements Runnable {
    public final /* synthetic */ ByteBuffer a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ o e;
    public final /* synthetic */ TXCGLSurfaceView f;

    public TXCGLSurfaceView$5(TXCGLSurfaceView tXCGLSurfaceView, ByteBuffer byteBuffer, Bitmap bitmap, int n10, int n11, o o10) {
        this.f = tXCGLSurfaceView;
        this.a = byteBuffer;
        this.b = bitmap;
        this.c = n10;
        this.d = n11;
        this.e = o10;
    }

    public void run() {
        String string2 = "takePhoto error ";
        String string3 = "TXCGLSurfaceView";
        Bitmap bitmap = null;
        ByteBuffer byteBuffer = this.a;
        float f10 = 0.0f;
        Comparable<StringBuilder> comparable = null;
        byteBuffer.position(0);
        byteBuffer = this.b;
        comparable = this.a;
        byteBuffer.copyPixelsFromBuffer((Buffer)((Object)comparable));
        Matrix matrix = new Matrix();
        float f11 = 1.0f;
        f10 = -1.0f;
        matrix.setScale(f11, f10);
        Bitmap bitmap2 = this.b;
        int n10 = this.c;
        int n11 = this.d;
        try {
            bitmap = Bitmap.createBitmap((Bitmap)bitmap2, (int)0, (int)0, (int)n10, (int)n11, (Matrix)matrix, (boolean)false);
        }
        catch (Error error) {
            comparable = new StringBuilder();
            comparable.append(string2);
            comparable.append(error);
            string2 = comparable.toString();
            TXCLog.w(string3, string2);
        }
        catch (Exception exception) {
            comparable = new StringBuilder();
            comparable.append(string2);
            comparable.append(exception);
            string2 = comparable.toString();
            TXCLog.w(string3, string2);
        }
        this.e.a(bitmap);
        this.b.recycle();
    }
}

