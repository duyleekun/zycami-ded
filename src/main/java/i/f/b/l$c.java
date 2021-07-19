/*
 * Decompiled with CFR 0.151.
 */
package i.f.b;

import i.f.b.e$b;
import i.f.b.l;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class l$c
implements e$b {
    private Mat a;
    private Mat b;
    private int c;
    private int d;
    public final /* synthetic */ l e;

    public l$c(l object, Mat mat, int n10, int n11) {
        this.e = object;
        this.c = n10;
        this.d = n11;
        this.a = mat;
        this.b = object;
    }

    public Mat a() {
        Mat mat = this.a;
        int n10 = this.d;
        int n11 = this.c;
        return mat.K0(0, n10, 0, n11);
    }

    public Mat b() {
        Object object;
        block4: {
            block3: {
                int n10;
                int n11;
                int n12;
                block2: {
                    object = this.e;
                    n12 = l.t(object);
                    n11 = 4;
                    n10 = 17;
                    if (n12 != n10) break block2;
                    object = this.a;
                    Mat mat = this.b;
                    int n13 = 96;
                    Imgproc.n1((Mat)object, mat, n13, n11);
                    break block3;
                }
                object = this.e;
                n12 = l.t(object);
                if (n12 != (n10 = 842094169)) break block4;
                object = this.a;
                Mat mat = this.b;
                int n14 = 100;
                Imgproc.n1((Mat)object, mat, n14, n11);
            }
            return this.b;
        }
        object = new IllegalArgumentException("Preview Format can be NV21 or YV12");
        throw object;
    }

    public void c() {
        this.b.u0();
    }
}

