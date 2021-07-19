/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.view.TextureView
 */
package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.TextureView;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.renderer.e;

public class e$1
implements Runnable {
    public final /* synthetic */ Matrix a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ TextureView c;
    public final /* synthetic */ o d;
    public final /* synthetic */ e e;

    public e$1(e e10, Matrix matrix, Bitmap bitmap, TextureView textureView, o o10) {
        this.e = e10;
        this.a = matrix;
        this.b = bitmap;
        this.c = textureView;
        this.d = o10;
    }

    public void run() {
        Object object = "takePhoto error ";
        String string2 = "TXCVideoRender";
        Bitmap bitmap = null;
        e e10 = this.e;
        StringBuilder stringBuilder = this.a;
        Bitmap bitmap2 = this.b;
        TextureView textureView = this.c;
        int n10 = textureView.getWidth();
        TextureView textureView2 = this.c;
        int n11 = textureView2.getHeight();
        try {
            bitmap = com.tencent.liteav.renderer.e.a(e10, (Matrix)stringBuilder, bitmap2, n10, n11);
        }
        catch (Error error) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(error);
            object = stringBuilder.toString();
            TXCLog.w(string2, (String)object);
        }
        catch (Exception exception) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(exception);
            object = stringBuilder.toString();
            TXCLog.w(string2, (String)object);
        }
        object = this.d;
        if (object != null) {
            object.a(bitmap);
        }
    }
}

