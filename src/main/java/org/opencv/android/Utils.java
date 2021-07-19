/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package org.opencv.android;

import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.opencv.core.CvException;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Utils {
    public static void a(Bitmap bitmap, Mat mat) {
        Utils.b(bitmap, mat, false);
    }

    public static void b(Bitmap object, Mat mat, boolean bl2) {
        if (object != null) {
            if (mat != null) {
                long l10 = mat.a;
                Utils.nBitmapToMat2(object, l10, bl2);
                return;
            }
            object = new IllegalArgumentException("mat == null");
            throw object;
        }
        object = new IllegalArgumentException("bmp == null");
        throw object;
    }

    public static String c(Context context, int n10) {
        return Utils.d(context, n10, "OpenCV_data");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String d(Context object, int n10, String object2) {
        String string2 = object.getResources().getString(n10);
        String string3 = "/";
        int n11 = string2.lastIndexOf(string3) + 1;
        string2 = string2.substring(n11);
        try {
            string3 = object.getResources();
            InputStream inputStream = string3.openRawResource(n10);
            n11 = 0;
            string3 = null;
            object = object.getDir((String)object2, 0);
            object2 = new File((File)object, string2);
            object = new FileOutputStream((File)object2);
            int n12 = 4096;
            byte[] byArray = new byte[n12];
            while (true) {
                int n13;
                int n14;
                if ((n14 = inputStream.read(byArray)) == (n13 = -1)) {
                    inputStream.close();
                    ((FileOutputStream)object).close();
                    return ((File)object2).getAbsolutePath();
                }
                ((FileOutputStream)object).write(byArray, 0, n14);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to export resource ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(". Exception thrown: ");
            ((StringBuilder)object2).append(iOException);
            String string4 = ((StringBuilder)object2).toString();
            CvException cvException = new CvException(string4);
            throw cvException;
        }
    }

    public static Mat e(Context context, int n10) {
        return Utils.f(context, n10, -1);
    }

    public static Mat f(Context object, int n10, int n11) {
        int n12;
        int n13;
        object = object.getResources().openRawResource(n10);
        int n14 = ((InputStream)object).available();
        Object object2 = new ByteArrayOutputStream(n14);
        n14 = 4096;
        byte[] byArray = new byte[n14];
        while ((n13 = ((InputStream)object).read(byArray)) != (n12 = -1)) {
            ((ByteArrayOutputStream)object2).write(byArray, 0, n13);
        }
        ((InputStream)object).close();
        n13 = ((ByteArrayOutputStream)object2).size();
        object = new Mat(1, n13, 0);
        byArray = ((ByteArrayOutputStream)object2).toByteArray();
        ((Mat)object).i0(0, 0, byArray);
        ((ByteArrayOutputStream)object2).close();
        object2 = Imgcodecs.c((Mat)object, n11);
        ((Mat)object).u0();
        return object2;
    }

    public static void g(Mat mat, Bitmap bitmap) {
        Utils.h(mat, bitmap, false);
    }

    public static void h(Mat object, Bitmap bitmap, boolean bl2) {
        if (object != null) {
            if (bitmap != null) {
                Utils.nMatToBitmap2(((Mat)object).a, bitmap, bl2);
                return;
            }
            object = new IllegalArgumentException("bmp == null");
            throw object;
        }
        object = new IllegalArgumentException("mat == null");
        throw object;
    }

    private static native void nBitmapToMat2(Bitmap var0, long var1, boolean var3);

    private static native void nMatToBitmap2(long var0, Bitmap var2, boolean var3);
}

