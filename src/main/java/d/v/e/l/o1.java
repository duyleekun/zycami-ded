/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.view.View
 */
package d.v.e.l;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import d.v.e.l.d1;
import d.v.e.l.u1;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class o1 {
    private o1() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static int[] A(Fragment fragment, int n10) {
        return o1.x(fragment.requireContext(), n10);
    }

    public static int B(Context context, int n10) {
        return o1.C(o1.J(context), n10);
    }

    public static int C(Resources resources, int n10) {
        try {
            return resources.getInteger(n10);
        }
        catch (Resources.NotFoundException notFoundException) {
            notFoundException.printStackTrace();
            return 0;
        }
    }

    public static int D(View view, int n10) {
        return o1.B(view.getContext(), n10);
    }

    public static int E(Fragment fragment, int n10) {
        return o1.B(fragment.requireContext(), n10);
    }

    public static String F(Context context, int n10, int ... nArray) {
        int n11;
        if (nArray != null && (n11 = nArray.length) != 0) {
            int n12;
            n11 = nArray.length;
            Object[] objectArray = new String[n11];
            for (int i10 = 0; i10 < (n12 = nArray.length); ++i10) {
                n12 = nArray[i10];
                String string2 = o1.L(context, n12);
                objectArray[i10] = string2;
            }
            return o1.M(context, n10, objectArray);
        }
        return o1.L(context, n10);
    }

    public static String G(View view, int n10, int ... nArray) {
        return o1.F(view.getContext(), n10, nArray);
    }

    public static String H(Fragment fragment, int n10, int ... nArray) {
        return o1.F(fragment.requireContext(), n10, nArray);
    }

    private static int I(Context context, String string2, String string3) {
        context = o1.J(context);
        String string4 = d1.d();
        return context.getIdentifier(string2, string3, string4);
    }

    public static Resources J(Context context) {
        return context.getResources();
    }

    public static Resources K(Resources resources) {
        Configuration configuration = resources.getConfiguration();
        float f10 = configuration.fontScale;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            resources.getConfiguration().fontScale = f11;
            object = false;
            f10 = 0.0f;
            configuration = null;
            resources.updateConfiguration(null, null);
        }
        return resources;
    }

    public static String L(Context context, int n10) {
        return o1.N(o1.J(context), n10);
    }

    public static String M(Context context, int n10, Object ... objectArray) {
        return o1.O(o1.J(context), n10, objectArray);
    }

    public static String N(Resources resources, int n10) {
        try {
            return resources.getString(n10);
        }
        catch (Resources.NotFoundException notFoundException) {
            notFoundException.printStackTrace();
            return "";
        }
    }

    public static String O(Resources resources, int n10, Object ... objectArray) {
        try {
            return resources.getString(n10, objectArray);
        }
        catch (Resources.NotFoundException notFoundException) {
            notFoundException.printStackTrace();
            return "";
        }
    }

    public static String P(View view, int n10) {
        return o1.L(view.getContext(), n10);
    }

    public static String Q(View view, int n10, Object ... objectArray) {
        return o1.M(view.getContext(), n10, objectArray);
    }

    public static String R(Fragment fragment, int n10) {
        return o1.L(fragment.requireContext(), n10);
    }

    public static String S(Fragment fragment, int n10, Object ... objectArray) {
        return o1.M(fragment.requireContext(), n10, objectArray);
    }

    public static String[] T(Context context, int n10) {
        return o1.U(o1.J(context), n10);
    }

    public static String[] U(Resources resources, int n10) {
        try {
            return resources.getStringArray(n10);
        }
        catch (Resources.NotFoundException notFoundException) {
            notFoundException.printStackTrace();
            return new String[0];
        }
    }

    public static String[] V(View view, int n10) {
        return o1.T(view.getContext(), n10);
    }

    public static String[] W(Fragment fragment, int n10) {
        return o1.T(fragment.requireContext(), n10);
    }

    public static int X(Context context, String string2) {
        return o1.I(context, string2, "string");
    }

    public static int Y(View view, String string2) {
        return o1.I(view.getContext(), string2, "string");
    }

    public static int Z(Fragment fragment, String string2) {
        return o1.I(fragment.requireContext(), string2, "string");
    }

    public static int a(Context context, int n10) {
        return o1.c(o1.J(context), n10);
    }

    public static InputStream a0(Context context, int n10) {
        return o1.J(context).openRawResource(n10);
    }

    public static int b(Context context, int n10, Resources.Theme theme) {
        return o1.d(o1.J(context), n10, theme);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static byte[] b0(Context var0, int var1_1) {
        block6: {
            var0 = o1.a0((Context)var0, var1_1);
            var2_2 = new ByteArrayOutputStream();
            var3_3 = 8192;
            try {
                var4_4 = new byte[var3_3];
                while ((var5_7 = var0.read(var4_4)) != (var6_8 = -1)) {
                    var6_8 = 0;
                    var2_2.write(var4_4, 0, var5_7);
                }
                var4_4 = var2_2.toByteArray();
                break block6;
            }
            catch (IOException var4_6) {
                try {
                    var4_6.printStackTrace();
                    var4_4 = var2_2.toByteArray();
                    return var4_4;
                }
                catch (Throwable var4_5) {}
            }
            ** finally { 
        }
        u1.a(var2_2);
        u1.a((Closeable)var0);
        return var4_4;
    }

    public static int c(Resources resources, int n10) {
        return o1.d(resources, n10, null);
    }

    public static byte[] c0(View view, int n10) {
        return o1.b0(view.getContext(), n10);
    }

    public static int d(Resources resources, int n10, Resources.Theme theme) {
        block4: {
            try {
                int n11 = Build.VERSION.SDK_INT;
                int n12 = 23;
                if (n11 < n12) break block4;
            }
            catch (Resources.NotFoundException notFoundException) {
                notFoundException.printStackTrace();
                return 0;
            }
            return resources.getColor(n10, theme);
        }
        return resources.getColor(n10);
    }

    public static byte[] d0(Fragment fragment, int n10) {
        return o1.b0(fragment.requireContext(), n10);
    }

    public static int e(View view, int n10) {
        return o1.a(view.getContext(), n10);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String e0(Context object, int n10) {
        Throwable throwable2;
        ByteArrayOutputStream byteArrayOutputStream;
        block5: {
            int n11;
            int n12;
            object = o1.a0((Context)object, n10);
            byteArrayOutputStream = new ByteArrayOutputStream();
            int n13 = 512;
            Object object2 = new byte[n13];
            while ((n12 = ((InputStream)object).read((byte[])object2)) != (n11 = -1)) {
                n11 = 0;
                byteArrayOutputStream.write((byte[])object2, 0, n12);
            }
            object2 = "utf-8";
            object2 = byteArrayOutputStream.toString((String)object2);
            {
                catch (Throwable throwable2) {
                    break block5;
                }
                catch (IOException iOException) {}
                {
                    iOException.printStackTrace();
                    n13 = 0;
                    object2 = null;
                }
            }
            u1.a((Closeable)object);
            u1.a(byteArrayOutputStream);
            return object2;
        }
        u1.a((Closeable)object);
        u1.a(byteArrayOutputStream);
        throw throwable2;
    }

    public static int f(View view, int n10, Resources.Theme theme) {
        return o1.b(view.getContext(), n10, theme);
    }

    public static Uri f0(int n10) {
        String string2 = d1.d();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android.resource://");
        stringBuilder.append(string2);
        stringBuilder.append("/");
        stringBuilder.append(n10);
        return Uri.parse((String)stringBuilder.toString());
    }

    public static int g(Fragment fragment, int n10) {
        return o1.a(fragment.requireContext(), n10);
    }

    public static int h(Fragment fragment, int n10, Resources.Theme theme) {
        return o1.b(fragment.requireContext(), n10, theme);
    }

    public static float i(Context context, int n10) {
        return o1.j(o1.J(context), n10);
    }

    public static float j(Resources resources, int n10) {
        try {
            return resources.getDimension(n10);
        }
        catch (Resources.NotFoundException notFoundException) {
            notFoundException.printStackTrace();
            return 0.0f;
        }
    }

    public static float k(View view, int n10) {
        return o1.i(view.getContext(), n10);
    }

    public static float l(Fragment fragment, int n10) {
        return o1.i(fragment.requireContext(), n10);
    }

    public static Drawable m(Context context, int n10) {
        return o1.o(o1.J(context), n10);
    }

    public static Drawable n(Context context, int n10, Resources.Theme theme) {
        return o1.p(o1.J(context), n10, theme);
    }

    public static Drawable o(Resources resources, int n10) {
        return o1.p(resources, n10, null);
    }

    public static Drawable p(Resources resources, int n10, Resources.Theme theme) {
        return resources.getDrawable(n10, theme);
    }

    public static Drawable q(View view, int n10) {
        return o1.m(view.getContext(), n10);
    }

    public static Drawable r(View view, int n10, Resources.Theme theme) {
        return o1.n(view.getContext(), n10, theme);
    }

    public static Drawable s(Fragment fragment, int n10) {
        return o1.m(fragment.requireContext(), n10);
    }

    public static Drawable t(Fragment fragment, int n10, Resources.Theme theme) {
        return o1.n(fragment.requireContext(), n10, theme);
    }

    public static int u(Context context, String string2) {
        return o1.I(context, string2, "drawable");
    }

    public static int v(View view, String string2) {
        return o1.I(view.getContext(), string2, "drawable");
    }

    public static int w(Fragment fragment, String string2) {
        return o1.I(fragment.requireContext(), string2, "drawable");
    }

    public static int[] x(Context context, int n10) {
        return o1.y(o1.J(context), n10);
    }

    public static int[] y(Resources resources, int n10) {
        try {
            return resources.getIntArray(n10);
        }
        catch (Resources.NotFoundException notFoundException) {
            notFoundException.printStackTrace();
            return new int[0];
        }
    }

    public static int[] z(View view, int n10) {
        return o1.x(view.getContext(), n10);
    }
}

