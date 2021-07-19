/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Image
 */
package i.f.b;

import android.media.Image;
import i.f.b.e$b;
import i.f.b.k;
import i.f.c.a;
import java.nio.ByteBuffer;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class k$d
implements e$b {
    public static final /* synthetic */ boolean e;
    private Image a;
    private Mat b;
    private Mat c;
    public final /* synthetic */ k d;

    public k$d(k object, Image image) {
        this.d = object;
        this.a = image;
        this.b = object;
        super();
        this.c = object;
    }

    public Mat a() {
        Mat mat;
        Object object = this.a.getPlanes();
        int n10 = this.a.getWidth();
        int n11 = this.a.getHeight();
        object = object[0].getBuffer();
        int n12 = i.f.c.a.j;
        this.c = mat = new Mat(n11, n10, n12, (ByteBuffer)object);
        return mat;
    }

    public Mat b() {
        Object object = this.a.getPlanes();
        Object object2 = this.a;
        int n10 = object2.getWidth();
        Image image = this.a;
        int n11 = image.getHeight();
        int n12 = 1;
        Object object3 = object[n12];
        int n13 = object3.getPixelStride();
        Mat mat = null;
        int n14 = 2;
        if (n13 == n14) {
            object3 = object[0].getBuffer();
            Object object4 = object[n12].getBuffer();
            object = object[n14].getBuffer();
            int n15 = i.f.c.a.j;
            mat = new Mat(n11, n10, n15, (ByteBuffer)object3);
            n11 /= n14;
            n10 /= n14;
            n14 = i.f.c.a.k;
            object3 = new Mat(n11, n10, n14, (ByteBuffer)object4);
            object4 = new Mat(n11, n10, n14, (ByteBuffer)object);
            long l10 = ((Mat)object4).w();
            long l11 = ((Mat)object3).w();
            long l12 = (l10 -= l11) - (l11 = 0L);
            Object object5 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object5 > 0) {
                object = this.b;
                n10 = 94;
                Imgproc.o1(mat, (Mat)object3, (Mat)object, n10);
            } else {
                object = this.b;
                n10 = 96;
                Imgproc.o1(mat, (Mat)object4, (Mat)object, n10);
            }
            return this.b;
        }
        n13 = n11 / 2;
        int n16 = n11 + n13;
        int n17 = n10 * n16;
        byte[] byArray = new byte[n17];
        ByteBuffer byteBuffer = object[0].getBuffer();
        ByteBuffer byteBuffer2 = object[n12].getBuffer();
        ByteBuffer byteBuffer3 = object[n14].getBuffer();
        byteBuffer.get(byArray, 0, n11 *= n10);
        object = object[n12];
        int n18 = object.getRowStride();
        n12 = n10 / 2;
        if ((n18 -= n12) == 0) {
            n18 = n11 / 4;
            byteBuffer2.get(byArray, n11, n18);
            byteBuffer3.get(byArray, n11 += n18, n18);
        } else {
            int n19;
            byteBuffer = null;
            for (n19 = 0; n19 < n13; ++n19) {
                byteBuffer2.get(byArray, n11, n12);
                n11 += n12;
                int n20 = n13 + -1;
                if (n19 >= n20) continue;
                n20 = byteBuffer2.position() + n18;
                byteBuffer2.position(n20);
            }
            byteBuffer = null;
            for (n19 = 0; n19 < n13; ++n19) {
                byteBuffer3.get(byArray, n11, n12);
                n11 += n12;
                int n21 = n13 + -1;
                if (n19 >= n21) continue;
                n21 = byteBuffer3.position() + n18;
                byteBuffer3.position(n21);
            }
        }
        n11 = i.f.c.a.j;
        object = new Mat(n16, n10, n11);
        ((Mat)object).i0(0, 0, byArray);
        object2 = this.b;
        Imgproc.n1((Mat)object, (Mat)object2, 104, 4);
        return this.b;
    }

    public void c() {
        this.b.u0();
        this.c.u0();
    }
}

