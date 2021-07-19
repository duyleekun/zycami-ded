/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.media.Image
 *  android.media.Image$Plane
 *  android.media.ImageReader
 *  android.media.ImageReader$OnImageAvailableListener
 *  android.os.Handler
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.c.s0.e7.u;

import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Size;
import android.view.Surface;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class l {
    private ImageReader a;
    private ImageReader b;

    public l(Size size) {
        ImageReader imageReader;
        int n10 = size.getWidth();
        int n11 = size.getHeight();
        int n12 = 1;
        this.a = imageReader = ImageReader.newInstance((int)n10, (int)n11, (int)n12, (int)n12);
        size = ImageReader.newInstance((int)n11, (int)n10, (int)n12, (int)n12);
        this.b = size;
    }

    private boolean c(Size size, ImageReader imageReader) {
        int n10;
        int n11 = size.getWidth();
        int n12 = size.getHeight();
        int n13 = imageReader.getWidth();
        if (n13 == n11 && (n10 = imageReader.getHeight()) == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            size = null;
        }
        return n12;
    }

    public static l d(Size size) {
        l l10 = new l(size);
        return l10;
    }

    public static Bitmap f(Image image) {
        int n10;
        try {
            n10 = image.getWidth();
        }
        catch (IllegalStateException illegalStateException) {
            illegalStateException.printStackTrace();
            return null;
        }
        int n11 = image.getHeight();
        Image.Plane plane = image.getPlanes();
        ByteBuffer byteBuffer = null;
        plane = plane[0];
        byteBuffer = plane.getBuffer();
        int n12 = plane.getPixelStride();
        int n13 = plane.getRowStride();
        int n14 = n12 * n10;
        n13 -= n14;
        n10 += (n13 /= n12);
        plane = Bitmap.Config.ARGB_8888;
        Bitmap bitmap = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)plane);
        bitmap.copyPixelsFromBuffer((Buffer)byteBuffer);
        image.close();
        return bitmap;
    }

    public void a() {
        this.a.close();
        this.b.close();
        this.a = null;
        this.b = null;
    }

    public Surface b(Size object) {
        ImageReader imageReader = this.a;
        boolean bl2 = this.c((Size)object, imageReader);
        if (bl2) {
            return this.a.getSurface();
        }
        imageReader = this.b;
        boolean bl3 = this.c((Size)object, imageReader);
        if (bl3) {
            return this.b.getSurface();
        }
        object = new IllegalArgumentException("Surface not found. ");
        throw object;
    }

    public void e(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        this.a.setOnImageAvailableListener(onImageAvailableListener, handler);
        this.b.setOnImageAvailableListener(onImageAvailableListener, handler);
    }
}

