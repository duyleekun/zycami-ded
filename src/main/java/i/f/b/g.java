/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.opengl.GLSurfaceView
 *  android.opengl.GLSurfaceView$Renderer
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.SurfaceHolder
 */
package i.f.b;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import i.f.b.f;
import i.f.b.g$a;
import org.opencv.R$styleable;

public class g
extends GLSurfaceView {
    private static final String c = "CameraGLSurfaceView";
    private g$a a;
    private f b;

    public g(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        object = this.getContext();
        int[] nArray = R$styleable.CameraBridgeViewBase;
        object = object.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.CameraBridgeViewBase_camera_id;
        n10 = object.getInt(n10, -1);
        object.recycle();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            super(this);
            this.b = object;
        } else {
            super(this);
            this.b = object;
        }
        this.setCameraIndex(n10);
        this.setEGLContextClientVersion(2);
        object = this.b;
        this.setRenderer((GLSurfaceView.Renderer)object);
        this.setRenderMode(0);
    }

    public void a() {
        this.b.e();
    }

    public void b() {
        this.b.i();
    }

    public void c(int n10, int n11) {
        this.b.t(n10, n11);
    }

    public g$a getCameraTextureListener() {
        return this.a;
    }

    public void onPause() {
        Log.i((String)c, (String)"onPause");
        this.b.o();
        super.onPause();
    }

    public void onResume() {
        Log.i((String)c, (String)"onResume");
        super.onResume();
        this.b.p();
    }

    public void setCameraIndex(int n10) {
        this.b.r(n10);
    }

    public void setCameraTextureListener(g$a g$a) {
        this.a = g$a;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int n10, int n11, int n12) {
        super.surfaceChanged(surfaceHolder, n10, n11, n12);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.b.C = false;
        super.surfaceDestroyed(surfaceHolder);
    }
}

