/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.SurfaceTexture
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGLContext
 */
package d.v.r;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.Log;
import com.google.mediapipe.components.TextureFrameConsumer;
import com.google.mediapipe.components.TextureFrameProducer;
import d.v.r.d;
import d.v.r.e$a;
import d.v.r.g;
import javax.microedition.khronos.egl.EGLContext;

public class e
implements TextureFrameProducer,
d {
    private static final String b = "ExternalTextureConv";
    private static final int c = 2;
    private static final String d = "MpExternalTextureConverter";
    private e$a a;

    public e(EGLContext eGLContext) {
        this(eGLContext, 2);
    }

    public e(EGLContext object, int n10) {
        Object object2 = new e$a((EGLContext)object, n10);
        this.a = object2;
        ((Thread)object2).setName(d);
        object = this.a;
        ((Thread)object).start();
        try {
            object = this.a;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append("thread was unexpectedly interrupted: ");
            object2 = interruptedException.getMessage();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            Log.e((String)b, (String)object3);
            object3 = new RuntimeException(interruptedException);
            throw object3;
        }
        ((g)object).m();
    }

    public e(EGLContext eGLContext, SurfaceTexture surfaceTexture, int n10, int n11) {
        this(eGLContext);
    }

    public void a(Bitmap bitmap) {
        this.a.a(bitmap);
    }

    public void b(TextureFrameConsumer textureFrameConsumer) {
        this.a.o(textureFrameConsumer);
    }

    public void c() {
        e$a e$a = this.a;
        if (e$a == null) {
            return;
        }
        e$a.k();
        try {
            e$a = this.a;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            Object object = new StringBuilder();
            ((StringBuilder)object).append("thread was unexpectedly interrupted: ");
            String string2 = interruptedException.getMessage();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            Log.e((String)b, (String)object);
            object = new RuntimeException(interruptedException);
            throw object;
        }
        e$a.join();
    }

    public void d(TextureFrameConsumer textureFrameConsumer) {
        this.a.u(textureFrameConsumer);
    }

    public void e(boolean bl2) {
        this.a.x(bl2);
    }

    public void setConsumer(TextureFrameConsumer textureFrameConsumer) {
        this.a.w(textureFrameConsumer);
    }
}

