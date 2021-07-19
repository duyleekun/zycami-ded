/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.core;

import i.f.c.a;
import i.f.c.u;
import i.f.c.w;
import i.f.c.y;
import i.f.c.z;
import java.nio.ByteBuffer;
import org.opencv.core.Range;

public class Mat {
    public final long a;

    public Mat() {
        long l10;
        this.a = l10 = Mat.n_Mat();
    }

    public Mat(int n10, int n11, int n12) {
        long l10;
        this.a = l10 = Mat.n_Mat(n10, n11, n12);
    }

    public Mat(int n10, int n11, int n12, y y10) {
        long l10;
        Object object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        this.a = l10 = Mat.n_Mat(n10, n11, n12, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public Mat(int n10, int n11, int n12, ByteBuffer byteBuffer) {
        long l10;
        this.a = l10 = Mat.n_Mat(n10, n11, n12, byteBuffer);
    }

    public Mat(long l10) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            this.a = l10;
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Native object address is NULL");
        throw unsupportedOperationException;
    }

    public Mat(z z10, int n10) {
        long l10;
        double d10 = z10.a;
        double d11 = z10.b;
        this.a = l10 = Mat.n_Mat(d10, d11, n10);
    }

    public Mat(z z10, int n10, y y10) {
        long l10;
        Object object = z10;
        double d10 = z10.a;
        double d11 = z10.b;
        object = y10;
        object = y10.a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        this.a = l10 = Mat.n_Mat(d10, d11, n10, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public Mat(Mat mat, w w10) {
        long l10;
        long l11 = mat.a;
        int n10 = w10.b;
        int n11 = w10.d;
        int n12 = n10 + n11;
        int n13 = w10.a;
        n11 = w10.c;
        int n14 = n13 + n11;
        this.a = l10 = Mat.n_Mat(l11, n10, n12, n13, n14);
    }

    public Mat(Mat mat, Range range) {
        long l10;
        long l11 = mat.a;
        int n10 = range.a;
        int n11 = range.b;
        this.a = l10 = Mat.n_Mat(l11, n10, n11);
    }

    public Mat(Mat mat, Range range, Range range2) {
        long l10;
        long l11 = mat.a;
        int n10 = range.a;
        int n11 = range.b;
        int n12 = range2.a;
        int n13 = range2.b;
        this.a = l10 = Mat.n_Mat(l11, n10, n11, n12, n13);
    }

    public Mat(Mat mat, Range[] rangeArray) {
        long l10;
        this.a = l10 = Mat.n_Mat(mat.a, rangeArray);
    }

    public Mat(int[] nArray, int n10) {
        long l10;
        this.a = l10 = Mat.n_Mat(nArray.length, nArray, n10);
    }

    public Mat(int[] nArray, int n10, y object) {
        long l10;
        int n11 = nArray.length;
        object = ((y)object).a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        this.a = l10 = Mat.n_Mat(n11, nArray, n10, (double)object2, (double)object3, (double)object4, (double)object5);
    }

    public static Mat A(Mat mat) {
        long l10 = Mat.n_diag(mat.a);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public static Mat H(int n10, int n11, int n12) {
        long l10 = Mat.n_eye(n10, n11, n12);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat I(z z10, int n10) {
        double d10 = z10.a;
        double d11 = z10.b;
        long l10 = Mat.n_eye(d10, d11, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat S0(int n10, int n11, int n12) {
        long l10 = Mat.n_zeros(n10, n11, n12);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat T0(z z10, int n10) {
        double d10 = z10.a;
        double d11 = z10.b;
        long l10 = Mat.n_zeros(d10, d11, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat U0(int[] nArray, int n10) {
        long l10 = Mat.n_zeros(nArray.length, nArray, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat e0(int n10, int n11, int n12) {
        long l10 = Mat.n_ones(n10, n11, n12);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat f0(z z10, int n10) {
        double d10 = z10.a;
        double d11 = z10.b;
        long l10 = Mat.n_ones(d10, d11, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public static Mat g0(int[] nArray, int n10) {
        long l10 = Mat.n_ones(nArray.length, nArray, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    private static native void locateROI_0(long var0, double[] var2, double[] var3);

    private static native String nDump(long var0);

    private static native double[] nGet(long var0, int var2, int var3);

    private static native int nGetB(long var0, int var2, int var3, int var4, byte[] var5);

    private static native int nGetBIdx(long var0, int[] var2, int var3, byte[] var4);

    private static native int nGetD(long var0, int var2, int var3, int var4, double[] var5);

    private static native int nGetDIdx(long var0, int[] var2, int var3, double[] var4);

    private static native int nGetF(long var0, int var2, int var3, int var4, float[] var5);

    private static native int nGetFIdx(long var0, int[] var2, int var3, float[] var4);

    private static native int nGetI(long var0, int var2, int var3, int var4, int[] var5);

    private static native int nGetIIdx(long var0, int[] var2, int var3, int[] var4);

    private static native double[] nGetIdx(long var0, int[] var2);

    private static native int nGetS(long var0, int var2, int var3, int var4, short[] var5);

    private static native int nGetSIdx(long var0, int[] var2, int var3, short[] var4);

    private static native int nPutB(long var0, int var2, int var3, int var4, byte[] var5);

    private static native int nPutBIdx(long var0, int[] var2, int var3, byte[] var4);

    private static native int nPutBwIdxOffset(long var0, int[] var2, int var3, int var4, byte[] var5);

    private static native int nPutBwOffset(long var0, int var2, int var3, int var4, int var5, byte[] var6);

    private static native int nPutD(long var0, int var2, int var3, int var4, double[] var5);

    private static native int nPutDIdx(long var0, int[] var2, int var3, double[] var4);

    private static native int nPutF(long var0, int var2, int var3, int var4, float[] var5);

    private static native int nPutFIdx(long var0, int[] var2, int var3, float[] var4);

    private static native int nPutI(long var0, int var2, int var3, int var4, int[] var5);

    private static native int nPutIIdx(long var0, int[] var2, int var3, int[] var4);

    private static native int nPutS(long var0, int var2, int var3, int var4, short[] var5);

    private static native int nPutSIdx(long var0, int[] var2, int var3, short[] var4);

    private static native long n_Mat();

    private static native long n_Mat(double var0, double var2, int var4);

    private static native long n_Mat(double var0, double var2, int var4, double var5, double var7, double var9, double var11);

    private static native long n_Mat(int var0, int var1, int var2);

    private static native long n_Mat(int var0, int var1, int var2, double var3, double var5, double var7, double var9);

    private static native long n_Mat(int var0, int var1, int var2, ByteBuffer var3);

    private static native long n_Mat(int var0, int[] var1, int var2);

    private static native long n_Mat(int var0, int[] var1, int var2, double var3, double var5, double var7, double var9);

    private static native long n_Mat(long var0, int var2, int var3);

    private static native long n_Mat(long var0, int var2, int var3, int var4, int var5);

    private static native long n_Mat(long var0, Range[] var2);

    private static native long n_adjustROI(long var0, int var2, int var3, int var4, int var5);

    private static native void n_assignTo(long var0, long var2);

    private static native void n_assignTo(long var0, long var2, int var4);

    private static native int n_channels(long var0);

    private static native int n_checkVector(long var0, int var2);

    private static native int n_checkVector(long var0, int var2, int var3);

    private static native int n_checkVector(long var0, int var2, int var3, boolean var4);

    private static native long n_clone(long var0);

    private static native long n_col(long var0, int var2);

    private static native long n_colRange(long var0, int var2, int var3);

    private static native int n_cols(long var0);

    private static native void n_convertTo(long var0, long var2, int var4);

    private static native void n_convertTo(long var0, long var2, int var4, double var5);

    private static native void n_convertTo(long var0, long var2, int var4, double var5, double var7);

    private static native void n_copySize(long var0, long var2);

    private static native void n_copyTo(long var0, long var2);

    private static native void n_copyTo(long var0, long var2, long var4);

    private static native void n_create(long var0, double var2, double var4, int var6);

    private static native void n_create(long var0, int var2, int var3, int var4);

    private static native void n_create(long var0, int var2, int[] var3, int var4);

    private static native long n_cross(long var0, long var2);

    private static native long n_dataAddr(long var0);

    private static native void n_delete(long var0);

    private static native int n_depth(long var0);

    private static native long n_diag(long var0);

    private static native long n_diag(long var0, int var2);

    private static native int n_dims(long var0);

    private static native double n_dot(long var0, long var2);

    private static native long n_elemSize(long var0);

    private static native long n_elemSize1(long var0);

    private static native boolean n_empty(long var0);

    private static native long n_eye(double var0, double var2, int var4);

    private static native long n_eye(int var0, int var1, int var2);

    private static native long n_inv(long var0);

    private static native long n_inv(long var0, int var2);

    private static native boolean n_isContinuous(long var0);

    private static native boolean n_isSubmatrix(long var0);

    private static native long n_mul(long var0, long var2);

    private static native long n_mul(long var0, long var2, double var4);

    private static native long n_ones(double var0, double var2, int var4);

    private static native long n_ones(int var0, int var1, int var2);

    private static native long n_ones(int var0, int[] var1, int var2);

    private static native void n_push_back(long var0, long var2);

    private static native void n_release(long var0);

    private static native long n_reshape(long var0, int var2);

    private static native long n_reshape(long var0, int var2, int var3);

    private static native long n_reshape_1(long var0, int var2, int var3, int[] var4);

    private static native long n_row(long var0, int var2);

    private static native long n_rowRange(long var0, int var2, int var3);

    private static native int n_rows(long var0);

    private static native long n_setTo(long var0, double var2, double var4, double var6, double var8);

    private static native long n_setTo(long var0, double var2, double var4, double var6, double var8, long var10);

    private static native long n_setTo(long var0, long var2);

    private static native long n_setTo(long var0, long var2, long var4);

    private static native double[] n_size(long var0);

    private static native int n_size_i(long var0, int var2);

    private static native long n_step1(long var0);

    private static native long n_step1(long var0, int var2);

    private static native long n_submat(long var0, int var2, int var3, int var4, int var5);

    private static native long n_submat_ranges(long var0, Range[] var2);

    private static native long n_submat_rr(long var0, int var2, int var3, int var4, int var5);

    private static native long n_t(long var0);

    private static native long n_total(long var0);

    private static native int n_type(long var0);

    private static native long n_zeros(double var0, double var2, int var4);

    private static native long n_zeros(int var0, int var1, int var2);

    private static native long n_zeros(int var0, int[] var1, int var2);

    public Mat A0(Range range) {
        long l10 = this.a;
        int n10 = range.a;
        int n11 = range.b;
        l10 = Mat.n_rowRange(l10, n10, n11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int B() {
        return Mat.n_dims(this.a);
    }

    public int B0() {
        return Mat.n_rows(this.a);
    }

    public double C(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        return Mat.n_dot(l10, l11);
    }

    public Mat C0(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        l10 = Mat.n_setTo(l10, l11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public String D() {
        return Mat.nDump(this.a);
    }

    public Mat D0(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        long l13 = Mat.n_setTo(l10, l11, l12);
        Mat mat3 = new Mat(l13);
        return mat3;
    }

    public long E() {
        return Mat.n_elemSize(this.a);
    }

    public Mat E0(y object) {
        long l10 = this.a;
        object = ((y)object).a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        l10 = Mat.n_setTo(l10, (double)object2, (double)object3, (double)object4, (double)object5);
        Mat mat = new Mat(l10);
        return mat;
    }

    public long F() {
        return Mat.n_elemSize1(this.a);
    }

    public Mat F0(y object, Mat mat) {
        long l10 = this.a;
        object = ((y)object).a;
        Object object2 = object[0];
        Object object3 = object[1];
        Object object4 = object[2];
        Object object5 = object[3];
        long l11 = mat.a;
        long l12 = Mat.n_setTo(l10, (double)object2, (double)object3, (double)object4, (double)object5, l11);
        Mat mat2 = new Mat(l12);
        return mat2;
    }

    public boolean G() {
        return Mat.n_empty(this.a);
    }

    public int G0(int n10) {
        return Mat.n_size_i(this.a, n10);
    }

    public z H0() {
        double[] dArray = Mat.n_size(this.a);
        z z10 = new z(dArray);
        return z10;
    }

    public long I0() {
        return Mat.n_step1(this.a);
    }

    public int J(int n10, int n11, byte[] byArray) {
        int n12;
        int n13 = this.Q0();
        if (byArray != null) {
            int n14 = byArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 != 0 && (n14 = i.f.c.a.k(n13)) != (n15 = 1)) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Mat data type is not compatible: ");
                    charSequence.append(n13);
                    charSequence = charSequence.toString();
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                    throw unsupportedOperationException;
                }
                long l10 = this.a;
                int n16 = byArray.length;
                n15 = n10;
                return Mat.nGetB(l10, n10, n11, n16, byArray);
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (byArray == null) {
            n12 = 0;
            byArray = null;
        } else {
            n12 = byArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public long J0(int n10) {
        return Mat.n_step1(this.a, n10);
    }

    public int K(int n10, int n11, double[] dArray) {
        int n12;
        int n13 = this.Q0();
        if (dArray != null) {
            int n14 = dArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 == (n15 = 6)) {
                    long l10 = this.a;
                    int n16 = dArray.length;
                    return Mat.nGetD(l10, n10, n11, n16, dArray);
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Mat data type is not compatible: ");
                charSequence.append(n13);
                charSequence = charSequence.toString();
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                throw unsupportedOperationException;
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (dArray == null) {
            n12 = 0;
            dArray = null;
        } else {
            n12 = dArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public Mat K0(int n10, int n11, int n12, int n13) {
        long l10 = Mat.n_submat_rr(this.a, n10, n11, n12, n13);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int L(int n10, int n11, float[] fArray) {
        int n12;
        int n13 = this.Q0();
        if (fArray != null) {
            int n14 = fArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 == (n15 = 5)) {
                    long l10 = this.a;
                    int n16 = fArray.length;
                    return Mat.nGetF(l10, n10, n11, n16, fArray);
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Mat data type is not compatible: ");
                charSequence.append(n13);
                charSequence = charSequence.toString();
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                throw unsupportedOperationException;
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (fArray == null) {
            n12 = 0;
            fArray = null;
        } else {
            n12 = fArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public Mat L0(Range range, Range range2) {
        long l10 = this.a;
        int n10 = range.a;
        int n11 = range.b;
        int n12 = range2.a;
        int n13 = range2.b;
        long l11 = Mat.n_submat_rr(l10, n10, n11, n12, n13);
        Mat mat = new Mat(l11);
        return mat;
    }

    public int M(int n10, int n11, int[] nArray) {
        int n12;
        int n13 = this.Q0();
        if (nArray != null) {
            int n14 = nArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 == (n15 = 4)) {
                    long l10 = this.a;
                    int n16 = nArray.length;
                    return Mat.nGetI(l10, n10, n11, n16, nArray);
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Mat data type is not compatible: ");
                charSequence.append(n13);
                charSequence = charSequence.toString();
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                throw unsupportedOperationException;
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (nArray == null) {
            n12 = 0;
            nArray = null;
        } else {
            n12 = nArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public Mat M0(w w10) {
        long l10 = this.a;
        int n10 = w10.a;
        int n11 = w10.b;
        int n12 = w10.c;
        int n13 = w10.d;
        l10 = Mat.n_submat(l10, n10, n11, n12, n13);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int N(int n10, int n11, short[] sArray) {
        int n12;
        int n13 = this.Q0();
        if (sArray != null) {
            int n14 = sArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 != (n15 = 2) && (n14 = i.f.c.a.k(n13)) != (n15 = 3)) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Mat data type is not compatible: ");
                    charSequence.append(n13);
                    charSequence = charSequence.toString();
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                    throw unsupportedOperationException;
                }
                long l10 = this.a;
                int n16 = sArray.length;
                n15 = n10;
                return Mat.nGetS(l10, n10, n11, n16, sArray);
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (sArray == null) {
            n12 = 0;
            sArray = null;
        } else {
            n12 = sArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public Mat N0(Range[] rangeArray) {
        long l10 = Mat.n_submat_ranges(this.a, rangeArray);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int O(int[] object, byte[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((byte[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 != 0 && (n12 = i.f.c.a.k(n11)) != (n13 = 1)) {
                        object = new UnsupportedOperationException;
                        object2 = new StringBuilder;
                        ((StringBuilder)object2)();
                        ((StringBuilder)object2).append("Mat data type is not compatible: ");
                        ((StringBuilder)object2).append(n11);
                        object2 = ((StringBuilder)object2).toString();
                        object((String)object2);
                        throw object;
                    }
                    long l10 = this.a;
                    n13 = ((byte[])object2).length;
                    return Mat.nGetBIdx(l10, object, n13, (byte[])object2);
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((byte[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public Mat O0() {
        long l10 = Mat.n_t(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int P(int[] object, double[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((double[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 == (n13 = 6)) {
                        long l10 = this.a;
                        n13 = ((double[])object2).length;
                        return Mat.nGetDIdx(l10, object, n13, (double[])object2);
                    }
                    object = new UnsupportedOperationException;
                    object2 = new StringBuilder;
                    ((StringBuilder)object2)();
                    ((StringBuilder)object2).append("Mat data type is not compatible: ");
                    ((StringBuilder)object2).append(n11);
                    object2 = ((StringBuilder)object2).toString();
                    object((String)object2);
                    throw object;
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((double[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public long P0() {
        return Mat.n_total(this.a);
    }

    public int Q(int[] object, float[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((float[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 == (n13 = 5)) {
                        long l10 = this.a;
                        n13 = ((float[])object2).length;
                        return Mat.nGetFIdx(l10, object, n13, (float[])object2);
                    }
                    object = new UnsupportedOperationException;
                    object2 = new StringBuilder;
                    ((StringBuilder)object2)();
                    ((StringBuilder)object2).append("Mat data type is not compatible: ");
                    ((StringBuilder)object2).append(n11);
                    object2 = ((StringBuilder)object2).toString();
                    object((String)object2);
                    throw object;
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((float[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public int Q0() {
        return Mat.n_type(this.a);
    }

    public int R(int[] object, int[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((int[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 == (n13 = 4)) {
                        long l10 = this.a;
                        n13 = ((int[])object2).length;
                        return Mat.nGetIIdx(l10, object, n13, (int[])object2);
                    }
                    object = new UnsupportedOperationException;
                    object2 = new StringBuilder;
                    ((StringBuilder)object2)();
                    ((StringBuilder)object2).append("Mat data type is not compatible: ");
                    ((StringBuilder)object2).append(n11);
                    object2 = ((StringBuilder)object2).toString();
                    object((String)object2);
                    throw object;
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((int[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public int R0() {
        return this.l();
    }

    public int S(int[] object, short[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((short[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 != (n13 = 2) && (n12 = i.f.c.a.k(n11)) != (n13 = 3)) {
                        object = new UnsupportedOperationException;
                        object2 = new StringBuilder;
                        ((StringBuilder)object2)();
                        ((StringBuilder)object2).append("Mat data type is not compatible: ");
                        ((StringBuilder)object2).append(n11);
                        object2 = ((StringBuilder)object2).toString();
                        object((String)object2);
                        throw object;
                    }
                    long l10 = this.a;
                    n13 = ((short[])object2).length;
                    return Mat.nGetSIdx(l10, object, n13, (short[])object2);
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((short[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public double[] T(int n10, int n11) {
        return Mat.nGet(this.a, n10, n11);
    }

    public double[] U(int[] object) {
        int n10 = ((int[])object).length;
        int n11 = this.B();
        if (n10 == n11) {
            return Mat.nGetIdx(this.a, object);
        }
        object = new IllegalArgumentException;
        object("Incorrect number of indices");
        throw object;
    }

    public long V() {
        return this.a;
    }

    public int W() {
        return this.B0();
    }

    public Mat X() {
        long l10 = Mat.n_inv(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat Y(int n10) {
        long l10 = Mat.n_inv(this.a, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public boolean Z() {
        return Mat.n_isContinuous(this.a);
    }

    public Mat a(int n10, int n11, int n12, int n13) {
        long l10 = Mat.n_adjustROI(this.a, n10, n11, n12, n13);
        Mat mat = new Mat(l10);
        return mat;
    }

    public boolean a0() {
        return Mat.n_isSubmatrix(this.a);
    }

    public void b(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        Mat.n_assignTo(l10, l11);
    }

    public void b0(z z10, u u10) {
        int n10 = 2;
        double[] dArray = new double[n10];
        double[] dArray2 = new double[n10];
        long l10 = this.a;
        Mat.locateROI_0(l10, dArray, dArray2);
        int n11 = 1;
        if (z10 != null) {
            double d10;
            z10.a = d10 = dArray[0];
            z10.b = d10 = dArray[n11];
        }
        if (u10 != null) {
            double d11;
            double d12;
            u10.a = d12 = dArray2[0];
            u10.b = d11 = dArray2[n11];
        }
    }

    public void c(Mat mat, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        Mat.n_assignTo(l10, l11, n10);
    }

    public Mat c0(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        l10 = Mat.n_mul(l10, l11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public int d() {
        return Mat.n_channels(this.a);
    }

    public Mat d0(Mat mat, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = Mat.n_mul(l10, l11, d10);
        Mat mat2 = new Mat(l12);
        return mat2;
    }

    public int e(int n10) {
        return Mat.n_checkVector(this.a, n10);
    }

    public int f(int n10, int n11) {
        return Mat.n_checkVector(this.a, n10, n11);
    }

    public void finalize() {
        Mat.n_delete(this.a);
        super.finalize();
    }

    public int g(int n10, int n11, boolean bl2) {
        return Mat.n_checkVector(this.a, n10, n11, bl2);
    }

    public Mat h() {
        long l10 = Mat.n_clone(this.a);
        Mat mat = new Mat(l10);
        return mat;
    }

    public void h0(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        Mat.n_push_back(l10, l11);
    }

    public Mat i(int n10) {
        long l10 = Mat.n_col(this.a, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int i0(int n10, int n11, byte[] byArray) {
        int n12;
        int n13 = this.Q0();
        if (byArray != null) {
            int n14 = byArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 != 0 && (n14 = i.f.c.a.k(n13)) != (n15 = 1)) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Mat data type is not compatible: ");
                    charSequence.append(n13);
                    charSequence = charSequence.toString();
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                    throw unsupportedOperationException;
                }
                long l10 = this.a;
                int n16 = byArray.length;
                n15 = n10;
                return Mat.nPutB(l10, n10, n11, n16, byArray);
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (byArray == null) {
            n12 = 0;
            byArray = null;
        } else {
            n12 = byArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public Mat j(int n10, int n11) {
        long l10 = Mat.n_colRange(this.a, n10, n11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int j0(int n10, int n11, byte[] byArray, int n12, int n13) {
        int n14;
        int n15 = this.Q0();
        if (byArray != null) {
            int n16 = i.f.c.a.j(n15);
            if ((n16 = n13 % n16) == 0) {
                int n17;
                n16 = i.f.c.a.k(n15);
                if (n16 != 0 && (n16 = i.f.c.a.k(n15)) != (n17 = 1)) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Mat data type is not compatible: ");
                    charSequence.append(n15);
                    charSequence = charSequence.toString();
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                    throw unsupportedOperationException;
                }
                long l10 = this.a;
                n17 = n10;
                return Mat.nPutBwOffset(l10, n10, n11, n13, n12, byArray);
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (byArray == null) {
            n14 = 0;
            byArray = null;
        } else {
            n14 = byArray.length;
        }
        charSequence.append(n14);
        charSequence.append(") should be multiple of the Mat channels count (");
        n14 = i.f.c.a.j(n15);
        charSequence.append(n14);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public Mat k(Range range) {
        long l10 = this.a;
        int n10 = range.a;
        int n11 = range.b;
        l10 = Mat.n_colRange(l10, n10, n11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int k0(int n10, int n11, double ... dArray) {
        int n12;
        int n13 = this.Q0();
        if (dArray != null) {
            int n14 = dArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                long l10 = this.a;
                int n16 = dArray.length;
                return Mat.nPutD(l10, n10, n11, n16, dArray);
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (dArray == null) {
            n12 = 0;
            dArray = null;
        } else {
            n12 = dArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public int l() {
        return Mat.n_cols(this.a);
    }

    public int l0(int n10, int n11, float[] fArray) {
        int n12;
        int n13 = this.Q0();
        if (fArray != null) {
            int n14 = fArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 == (n15 = 5)) {
                    long l10 = this.a;
                    int n16 = fArray.length;
                    return Mat.nPutF(l10, n10, n11, n16, fArray);
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Mat data type is not compatible: ");
                charSequence.append(n13);
                charSequence = charSequence.toString();
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                throw unsupportedOperationException;
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (fArray == null) {
            n12 = 0;
            fArray = null;
        } else {
            n12 = fArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public void m(Mat mat, int n10) {
        long l10 = this.a;
        long l11 = mat.a;
        Mat.n_convertTo(l10, l11, n10);
    }

    public int m0(int n10, int n11, int[] nArray) {
        int n12;
        int n13 = this.Q0();
        if (nArray != null) {
            int n14 = nArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 == (n15 = 4)) {
                    long l10 = this.a;
                    int n16 = nArray.length;
                    return Mat.nPutI(l10, n10, n11, n16, nArray);
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Mat data type is not compatible: ");
                charSequence.append(n13);
                charSequence = charSequence.toString();
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                throw unsupportedOperationException;
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (nArray == null) {
            n12 = 0;
            nArray = null;
        } else {
            n12 = nArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public void n(Mat mat, int n10, double d10) {
        long l10 = this.a;
        long l11 = mat.a;
        Mat.n_convertTo(l10, l11, n10, d10);
    }

    public int n0(int n10, int n11, short[] sArray) {
        int n12;
        int n13 = this.Q0();
        if (sArray != null) {
            int n14 = sArray.length;
            int n15 = i.f.c.a.j(n13);
            if ((n14 %= n15) == 0) {
                n14 = i.f.c.a.k(n13);
                if (n14 != (n15 = 2) && (n14 = i.f.c.a.k(n13)) != (n15 = 3)) {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Mat data type is not compatible: ");
                    charSequence.append(n13);
                    charSequence = charSequence.toString();
                    UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
                    throw unsupportedOperationException;
                }
                long l10 = this.a;
                int n16 = sArray.length;
                n15 = n10;
                return Mat.nPutS(l10, n10, n11, n16, sArray);
            }
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Provided data element number (";
        charSequence.append(string2);
        if (sArray == null) {
            n12 = 0;
            sArray = null;
        } else {
            n12 = sArray.length;
        }
        charSequence.append(n12);
        charSequence.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        charSequence.append(n12);
        charSequence.append(")");
        charSequence = charSequence.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)charSequence);
        throw unsupportedOperationException;
    }

    public void o(Mat mat, int n10, double d10, double d11) {
        long l10 = this.a;
        long l11 = mat.a;
        Mat.n_convertTo(l10, l11, n10, d10, d11);
    }

    public int o0(int[] object, byte[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((byte[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 != 0 && (n12 = i.f.c.a.k(n11)) != (n13 = 1)) {
                        object = new UnsupportedOperationException;
                        object2 = new StringBuilder;
                        ((StringBuilder)object2)();
                        ((StringBuilder)object2).append("Mat data type is not compatible: ");
                        ((StringBuilder)object2).append(n11);
                        object2 = ((StringBuilder)object2).toString();
                        object((String)object2);
                        throw object;
                    }
                    long l10 = this.a;
                    n13 = ((byte[])object2).length;
                    return Mat.nPutBIdx(l10, object, n13, (byte[])object2);
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((byte[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public void p(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        Mat.n_copySize(l10, l11);
    }

    public int p0(int[] object, byte[] object2, int n10, int n11) {
        int n12;
        int n13 = this.Q0();
        if (object2 != null) {
            int n14 = i.f.c.a.j(n13);
            if ((n14 = n11 % n14) == 0) {
                n14 = ((int[])object).length;
                int n15 = this.B();
                if (n14 == n15) {
                    n14 = i.f.c.a.k(n13);
                    if (n14 != 0 && (n14 = i.f.c.a.k(n13)) != (n15 = 1)) {
                        object = new UnsupportedOperationException;
                        object2 = new StringBuilder;
                        ((StringBuilder)object2)();
                        ((StringBuilder)object2).append("Mat data type is not compatible: ");
                        ((StringBuilder)object2).append(n13);
                        object2 = ((StringBuilder)object2).toString();
                        object((String)object2);
                        throw object;
                    }
                    return Mat.nPutBwIdxOffset(this.a, object, n11, n10, (byte[])object2);
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n12 = 0;
            object2 = null;
        } else {
            n12 = ((byte[])object2).length;
        }
        stringBuilder.append(n12);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n12 = i.f.c.a.j(n13);
        stringBuilder.append(n12);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public void q(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        Mat.n_copyTo(l10, l11);
    }

    public int q0(int[] object, double ... object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((double[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n11 = ((int[])object).length;
                n12 = this.B();
                if (n11 == n12) {
                    long l10 = this.a;
                    n13 = ((double[])object2).length;
                    return Mat.nPutDIdx(l10, object, n13, object2);
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((double[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public void r(Mat mat, Mat mat2) {
        long l10 = this.a;
        long l11 = mat.a;
        long l12 = mat2.a;
        Mat.n_copyTo(l10, l11, l12);
    }

    public int r0(int[] object, float[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((float[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 == (n13 = 5)) {
                        long l10 = this.a;
                        n13 = ((float[])object2).length;
                        return Mat.nPutFIdx(l10, object, n13, (float[])object2);
                    }
                    object = new UnsupportedOperationException;
                    object2 = new StringBuilder;
                    ((StringBuilder)object2)();
                    ((StringBuilder)object2).append("Mat data type is not compatible: ");
                    ((StringBuilder)object2).append(n11);
                    object2 = ((StringBuilder)object2).toString();
                    object((String)object2);
                    throw object;
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((float[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public void s(int n10, int n11, int n12) {
        Mat.n_create(this.a, n10, n11, n12);
    }

    public int s0(int[] object, int[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((int[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 == (n13 = 4)) {
                        long l10 = this.a;
                        n13 = ((int[])object2).length;
                        return Mat.nPutIIdx(l10, object, n13, (int[])object2);
                    }
                    object = new UnsupportedOperationException;
                    object2 = new StringBuilder;
                    ((StringBuilder)object2)();
                    ((StringBuilder)object2).append("Mat data type is not compatible: ");
                    ((StringBuilder)object2).append(n11);
                    object2 = ((StringBuilder)object2).toString();
                    object((String)object2);
                    throw object;
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((int[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public void t(z z10, int n10) {
        long l10 = this.a;
        double d10 = z10.a;
        double d11 = z10.b;
        Mat.n_create(l10, d10, d11, n10);
    }

    public int t0(int[] object, short[] object2) {
        int n10;
        int n11 = this.Q0();
        if (object2 != null) {
            int n12 = ((short[])object2).length;
            int n13 = i.f.c.a.j(n11);
            if ((n12 %= n13) == 0) {
                n12 = ((int[])object).length;
                n13 = this.B();
                if (n12 == n13) {
                    n12 = i.f.c.a.k(n11);
                    if (n12 != (n13 = 2) && (n12 = i.f.c.a.k(n11)) != (n13 = 3)) {
                        object = new UnsupportedOperationException;
                        object2 = new StringBuilder;
                        ((StringBuilder)object2)();
                        ((StringBuilder)object2).append("Mat data type is not compatible: ");
                        ((StringBuilder)object2).append(n11);
                        object2 = ((StringBuilder)object2).toString();
                        object((String)object2);
                        throw object;
                    }
                    long l10 = this.a;
                    n13 = ((short[])object2).length;
                    return Mat.nPutSIdx(l10, object, n13, (short[])object2);
                }
                object = new IllegalArgumentException;
                object("Incorrect number of indices");
                throw object;
            }
        }
        object = new UnsupportedOperationException;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Provided data element number (";
        stringBuilder.append(string2);
        if (object2 == null) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = ((short[])object2).length;
        }
        stringBuilder.append(n10);
        stringBuilder.append(") should be multiple of the Mat channels count (");
        n10 = i.f.c.a.j(n11);
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object2 = stringBuilder.toString();
        object((String)object2);
        throw object;
    }

    public String toString() {
        int n10;
        int n11 = this.B();
        String string2 = n11 > 0 ? "" : "-1*-1*";
        StringBuilder stringBuilder = null;
        for (int i10 = 0; i10 < (n10 = this.B()); ++i10) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            n11 = this.G0(i10);
            stringBuilder2.append(n11);
            stringBuilder2.append("*");
            string2 = stringBuilder2.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Mat [ ");
        stringBuilder.append(string2);
        string2 = i.f.c.a.n(this.Q0());
        stringBuilder.append(string2);
        stringBuilder.append(", isCont=");
        n11 = (int)(this.Z() ? 1 : 0);
        stringBuilder.append(n11 != 0);
        stringBuilder.append(", isSubmat=");
        n11 = this.a0();
        stringBuilder.append(n11 != 0);
        stringBuilder.append(", nativeObj=0x");
        string2 = Long.toHexString(this.a);
        stringBuilder.append(string2);
        stringBuilder.append(", dataAddr=0x");
        string2 = Long.toHexString(this.w());
        stringBuilder.append(string2);
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    public void u(int[] nArray, int n10) {
        long l10 = this.a;
        int n11 = nArray.length;
        Mat.n_create(l10, n11, nArray, n10);
    }

    public void u0() {
        Mat.n_release(this.a);
    }

    public Mat v(Mat mat) {
        long l10 = this.a;
        long l11 = mat.a;
        l10 = Mat.n_cross(l10, l11);
        Mat mat2 = new Mat(l10);
        return mat2;
    }

    public Mat v0(int n10) {
        long l10 = Mat.n_reshape(this.a, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public long w() {
        return Mat.n_dataAddr(this.a);
    }

    public Mat w0(int n10, int n11) {
        long l10 = Mat.n_reshape(this.a, n10, n11);
        Mat mat = new Mat(l10);
        return mat;
    }

    public int x() {
        return Mat.n_depth(this.a);
    }

    public Mat x0(int n10, int[] nArray) {
        long l10 = this.a;
        int n11 = nArray.length;
        long l11 = Mat.n_reshape_1(l10, n10, n11, nArray);
        Mat mat = new Mat(l11);
        return mat;
    }

    public Mat y() {
        long l10 = Mat.n_diag(this.a, 0);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat y0(int n10) {
        long l10 = Mat.n_row(this.a, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat z(int n10) {
        long l10 = Mat.n_diag(this.a, n10);
        Mat mat = new Mat(l10);
        return mat;
    }

    public Mat z0(int n10, int n11) {
        long l10 = Mat.n_rowRange(this.a, n10, n11);
        Mat mat = new Mat(l10);
        return mat;
    }
}

