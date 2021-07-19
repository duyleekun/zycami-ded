/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.widget.ImageView$ScaleType
 */
package d.t.a.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import d.t.a.g.c;
import d.t.a.i.a;
import d.t.a.i.d;
import d.t.a.i.g;
import d.t.a.j.b$a;
import d.t.a.j.b$b;

public class b
extends AppCompatImageView {
    private static final String p = "TransformImageView";
    private static final int q = 8;
    private static final int r = 2;
    private static final int s = 9;
    public final float[] a;
    public final float[] b;
    private final float[] c;
    public Matrix d;
    public int e;
    public int f;
    public b$b g;
    private float[] h;
    private float[] i;
    public boolean j;
    public boolean k;
    private int l;
    private String m;
    private String n;
    private c o;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        object = new float[8];
        this.a = (float[])object;
        object = new float[2];
        this.b = (float[])object;
        object = new float[9];
        this.c = (float[])object;
        super();
        this.d = object;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.i();
    }

    public static /* synthetic */ String b(b b10, String string2) {
        b10.m = string2;
        return string2;
    }

    public static /* synthetic */ String c(b b10, String string2) {
        b10.n = string2;
        return string2;
    }

    public static /* synthetic */ c d(b b10, c c10) {
        b10.o = c10;
        return c10;
    }

    private void p() {
        Matrix matrix = this.d;
        float[] fArray = this.a;
        float[] fArray2 = this.h;
        matrix.mapPoints(fArray, fArray2);
        matrix = this.d;
        fArray = this.b;
        fArray2 = this.i;
        matrix.mapPoints(fArray, fArray2);
    }

    public float f(Matrix matrix) {
        double d10 = this.h(matrix, 1);
        double d11 = this.h(matrix, 0);
        return (float)(-(Math.atan2(d10, d11) * 57.29577951308232));
    }

    public float g(Matrix matrix) {
        double d10 = this.h(matrix, 0);
        double d11 = 2.0;
        d10 = Math.pow(d10, d11);
        d11 = Math.pow(this.h(matrix, 3), d11);
        return (float)Math.sqrt(d10 + d11);
    }

    public float getCurrentAngle() {
        Matrix matrix = this.d;
        return this.f(matrix);
    }

    public float getCurrentScale() {
        Matrix matrix = this.d;
        return this.g(matrix);
    }

    public c getExifInfo() {
        return this.o;
    }

    public String getImageInputPath() {
        return this.m;
    }

    public String getImageOutputPath() {
        return this.n;
    }

    public int getMaxBitmapSize() {
        int n10 = this.l;
        if (n10 <= 0) {
            Context context = this.getContext();
            this.l = n10 = d.t.a.i.a.b(context);
        }
        return this.l;
    }

    public Bitmap getViewBitmap() {
        boolean bl2;
        Drawable drawable2 = this.getDrawable();
        if (drawable2 != null && (bl2 = (drawable2 = this.getDrawable()) instanceof d)) {
            return ((d)this.getDrawable()).a();
        }
        return null;
    }

    public float h(Matrix matrix, int n10) {
        float[] fArray = this.c;
        matrix.getValues(fArray);
        return this.c[n10];
    }

    public void i() {
        ImageView.ScaleType scaleType = ImageView.ScaleType.MATRIX;
        this.setScaleType(scaleType);
    }

    public void j() {
        Object object = this.getDrawable();
        if (object == null) {
            return;
        }
        int n10 = object.getIntrinsicWidth();
        float f10 = n10;
        int n11 = object.getIntrinsicHeight();
        float f11 = n11;
        int n12 = 2;
        RectF rectF = new Object[n12];
        Integer n13 = (int)f10;
        rectF[0] = n13;
        Integer n14 = (int)f11;
        int n15 = 1;
        rectF[n15] = n14;
        rectF = String.format("Image size: [%d:%d]", (Object[])rectF);
        Log.d((String)p, (String)rectF);
        n14 = null;
        rectF = new RectF(0.0f, 0.0f, f10, f11);
        object = d.t.a.i.g.b(rectF);
        this.h = (float[])object;
        object = d.t.a.i.g.a(rectF);
        this.i = (float[])object;
        this.k = n15;
        object = this.g;
        if (object != null) {
            object.b();
        }
    }

    public void k(float f10, float f11, float f12) {
        Matrix matrix = null;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false) {
            matrix = this.d;
            matrix.postRotate(f10, f11, f12);
            Object object2 = this.d;
            this.setImageMatrix((Matrix)object2);
            object2 = this.g;
            if (object2 != null) {
                Matrix matrix2 = this.d;
                f11 = this.f(matrix2);
                object2.d(f11);
            }
        }
    }

    public void l(float f10, float f11, float f12) {
        Matrix matrix = null;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false) {
            matrix = this.d;
            matrix.postScale(f10, f10, f11, f12);
            Object object2 = this.d;
            this.setImageMatrix((Matrix)object2);
            object2 = this.g;
            if (object2 != null) {
                Matrix matrix2 = this.d;
                f11 = this.g(matrix2);
                object2.a(f11);
            }
        }
    }

    public void m(float f10, float f11) {
        float f12;
        boolean bl2 = false;
        Matrix matrix = null;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false || (bl2 = (f12 = f11 - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) {
            matrix = this.d;
            matrix.postTranslate(f10, f11);
            Matrix matrix2 = this.d;
            this.setImageMatrix(matrix2);
        }
    }

    public void n(String string2, Matrix matrix) {
        float f10 = this.h(matrix, 2);
        float f11 = this.h(matrix, 5);
        float f12 = this.g(matrix);
        float f13 = this.f(matrix);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": matrix: { x: ");
        stringBuilder.append(f10);
        stringBuilder.append(", y: ");
        stringBuilder.append(f11);
        stringBuilder.append(", scale: ");
        stringBuilder.append(f12);
        stringBuilder.append(", angle: ");
        stringBuilder.append(f13);
        stringBuilder.append(" }");
        string2 = stringBuilder.toString();
        Log.d((String)p, (String)string2);
    }

    public void o(Uri uri, Uri uri2) {
        int n10 = this.getMaxBitmapSize();
        Context context = this.getContext();
        b$a b$a = new b$a(this);
        d.t.a.i.a.d(context, uri, uri2, n10, n10, b$a);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        boolean bl3;
        boolean bl4;
        int n14;
        int n15;
        int n16;
        int n17;
        super.onLayout(bl2, n17, n16, n15, n14);
        if (bl2 || (bl4 = this.j) && !(bl3 = this.k)) {
            int n18 = this.getPaddingLeft();
            n17 = this.getPaddingTop();
            n16 = this.getWidth();
            n15 = this.getPaddingRight();
            n16 -= n15;
            n15 = this.getHeight();
            n14 = this.getPaddingBottom();
            n15 -= n14;
            this.e = n16 -= n18;
            this.f = n15 -= n17;
            this.j();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        d d10 = new d(bitmap);
        this.setImageDrawable(d10);
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.d.set(matrix);
        this.p();
    }

    public void setMaxBitmapSize(int n10) {
        this.l = n10;
    }

    public void setScaleType(ImageView.ScaleType object) {
        Object object2 = ImageView.ScaleType.MATRIX;
        if (object == object2) {
            super.setScaleType(object);
        } else {
            object = p;
            object2 = "Invalid ScaleType. Only ScaleType.MATRIX can be used";
            Log.w((String)object, (String)object2);
        }
    }

    public void setTransformImageListener(b$b b$b) {
        this.g = b$b;
    }
}

