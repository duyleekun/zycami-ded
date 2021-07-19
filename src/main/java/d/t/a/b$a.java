/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$CompressFormat
 *  android.os.Bundle
 */
package d.t.a;

import android.graphics.Bitmap;
import android.os.Bundle;
import d.t.a.g.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class b$a {
    public static final String A = "com.yalantis.ucrop.FreeStyleCrop";
    public static final String B = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
    public static final String C = "com.yalantis.ucrop.AspectRatioOptions";
    public static final String D = "com.yalantis.ucrop.UcropRootViewBackgroundColor";
    public static final String b = "com.yalantis.ucrop.CompressionFormatName";
    public static final String c = "com.yalantis.ucrop.CompressionQuality";
    public static final String d = "com.yalantis.ucrop.AllowedGestures";
    public static final String e = "com.yalantis.ucrop.MaxBitmapSize";
    public static final String f = "com.yalantis.ucrop.MaxScaleMultiplier";
    public static final String g = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";
    public static final String h = "com.yalantis.ucrop.DimmedLayerColor";
    public static final String i = "com.yalantis.ucrop.CircleDimmedLayer";
    public static final String j = "com.yalantis.ucrop.ShowCropFrame";
    public static final String k = "com.yalantis.ucrop.CropFrameColor";
    public static final String l = "com.yalantis.ucrop.CropFrameStrokeWidth";
    public static final String m = "com.yalantis.ucrop.ShowCropGrid";
    public static final String n = "com.yalantis.ucrop.CropGridRowCount";
    public static final String o = "com.yalantis.ucrop.CropGridColumnCount";
    public static final String p = "com.yalantis.ucrop.CropGridColor";
    public static final String q = "com.yalantis.ucrop.CropGridStrokeWidth";
    public static final String r = "com.yalantis.ucrop.ToolbarColor";
    public static final String s = "com.yalantis.ucrop.StatusBarColor";
    public static final String t = "com.yalantis.ucrop.UcropColorControlsWidgetActive";
    public static final String u = "com.yalantis.ucrop.UcropToolbarWidgetColor";
    public static final String v = "com.yalantis.ucrop.UcropToolbarTitleText";
    public static final String w = "com.yalantis.ucrop.UcropToolbarCancelDrawable";
    public static final String x = "com.yalantis.ucrop.UcropToolbarCropDrawable";
    public static final String y = "com.yalantis.ucrop.UcropLogoColor";
    public static final String z = "com.yalantis.ucrop.HideBottomControls";
    private final Bundle a;

    public b$a() {
        Bundle bundle;
        this.a = bundle = new Bundle();
    }

    public void A(int n10) {
        this.a.putInt(x, n10);
    }

    public void B(String string2) {
        this.a.putString(v, string2);
    }

    public void C(int n10) {
        this.a.putInt(u, n10);
    }

    public void D() {
        this.a.putFloat("com.yalantis.ucrop.AspectRatioX", 0.0f);
        this.a.putFloat("com.yalantis.ucrop.AspectRatioY", 0.0f);
    }

    public void E(float f10, float f11) {
        this.a.putFloat("com.yalantis.ucrop.AspectRatioX", f10);
        this.a.putFloat("com.yalantis.ucrop.AspectRatioY", f11);
    }

    public void F(int n10, int n11) {
        this.a.putInt("com.yalantis.ucrop.MaxSizeX", n10);
        this.a.putInt("com.yalantis.ucrop.MaxSizeY", n11);
    }

    public Bundle a() {
        return this.a;
    }

    public void b(int n10) {
        this.a.putInt(t, n10);
    }

    public void c(int n10, int n11, int n12) {
        Bundle bundle = this.a;
        int[] nArray = new int[]{n10, n11, n12};
        bundle.putIntArray(d, nArray);
    }

    public void d(int n10, a ... object) {
        int n11 = ((a[])object).length;
        if (n10 <= n11) {
            this.a.putInt(B, n10);
            Bundle bundle = this.a;
            object = Arrays.asList(object);
            ArrayList arrayList = new ArrayList(object);
            bundle.putParcelableArrayList(C, arrayList);
            return;
        }
        Locale locale = Locale.US;
        Object object2 = n10;
        Object[] objectArray = new Object[]{object2, object = Integer.valueOf(((a[])object).length)};
        object2 = String.format(locale, "Index [selectedByDefault = %d] cannot be higher than aspect ratio options count [count = %d].", objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object2);
        throw illegalArgumentException;
    }

    public void e(boolean bl2) {
        this.a.putBoolean(i, bl2);
    }

    public void f(Bitmap.CompressFormat object) {
        Bundle bundle = this.a;
        object = object.name();
        bundle.putString(b, (String)object);
    }

    public void g(int n10) {
        this.a.putInt(c, n10);
    }

    public void h(int n10) {
        this.a.putInt(k, n10);
    }

    public void i(int n10) {
        this.a.putInt(l, n10);
    }

    public void j(int n10) {
        this.a.putInt(p, n10);
    }

    public void k(int n10) {
        this.a.putInt(o, n10);
    }

    public void l(int n10) {
        this.a.putInt(n, n10);
    }

    public void m(int n10) {
        this.a.putInt(q, n10);
    }

    public void n(int n10) {
        this.a.putInt(h, n10);
    }

    public void o(boolean bl2) {
        this.a.putBoolean(A, bl2);
    }

    public void p(boolean bl2) {
        this.a.putBoolean(z, bl2);
    }

    public void q(int n10) {
        this.a.putInt(g, n10);
    }

    public void r(int n10) {
        this.a.putInt(y, n10);
    }

    public void s(int n10) {
        this.a.putInt(e, n10);
    }

    public void t(float f10) {
        this.a.putFloat(f, f10);
    }

    public void u(int n10) {
        this.a.putInt(D, n10);
    }

    public void v(boolean bl2) {
        this.a.putBoolean(j, bl2);
    }

    public void w(boolean bl2) {
        this.a.putBoolean(m, bl2);
    }

    public void x(int n10) {
        this.a.putInt(s, n10);
    }

    public void y(int n10) {
        this.a.putInt(w, n10);
    }

    public void z(int n10) {
        this.a.putInt(r, n10);
    }
}

