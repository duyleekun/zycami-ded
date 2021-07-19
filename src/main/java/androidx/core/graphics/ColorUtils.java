/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 *  android.graphics.ColorSpace
 */
package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import java.util.Objects;

public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final ThreadLocal TEMP_ARRAY;
    private static final double XYZ_EPSILON = 0.008856;
    private static final double XYZ_KAPPA = 903.3;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883;

    static {
        ThreadLocal threadLocal;
        TEMP_ARRAY = threadLocal = new ThreadLocal();
    }

    private ColorUtils() {
    }

    public static int HSLToColor(float[] fArray) {
        int n10;
        float f10 = fArray[0];
        float f11 = fArray[1];
        float f12 = fArray[2];
        int n11 = 0x40000000;
        float f13 = 2.0f;
        float f14 = f12 * f13;
        float f15 = 1.0f;
        f14 = Math.abs(f14 - f15);
        f14 = (f15 - f14) * f11;
        f11 = 0.5f * f14;
        f12 -= f11;
        f11 = Math.abs(f10 / 60.0f % f13 - f15);
        f15 = (f15 - f11) * f14;
        int n12 = (int)f10 / 60;
        int n13 = 1132396544;
        f11 = 255.0f;
        switch (n12) {
            default: {
                n10 = 0;
                fArray = null;
                f12 = 0.0f;
                n12 = 0;
                f10 = 0.0f;
                n11 = 0;
                f13 = 0.0f;
                break;
            }
            case 5: 
            case 6: {
                f14 = (f14 + f12) * f11;
                n12 = Math.round(f14);
                f13 = f12 * f11;
                n11 = Math.round(f13);
                f15 = (f15 + f12) * f11;
                n10 = Math.round(f15);
                break;
            }
            case 4: {
                f15 = (f15 + f12) * f11;
                n12 = Math.round(f15);
                f13 = f12 * f11;
                n11 = Math.round(f13);
                f14 = (f14 + f12) * f11;
                n10 = Math.round(f14);
                break;
            }
            case 3: {
                f10 = f12 * f11;
                n12 = Math.round(f10);
                f15 = (f15 + f12) * f11;
                n11 = Math.round(f15);
                f14 = (f14 + f12) * f11;
                n10 = Math.round(f14);
                break;
            }
            case 2: {
                f10 = f12 * f11;
                n12 = Math.round(f10);
                f14 = (f14 + f12) * f11;
                n11 = Math.round(f14);
                f15 = (f15 + f12) * f11;
                n10 = Math.round(f15);
                break;
            }
            case 1: {
                f15 = (f15 + f12) * f11;
                n12 = Math.round(f15);
                f14 = (f14 + f12) * f11;
                n11 = Math.round(f14);
                n10 = Math.round(f12 *= f11);
                break;
            }
            case 0: {
                f14 = (f14 + f12) * f11;
                n12 = Math.round(f14);
                f15 = (f15 + f12) * f11;
                n11 = Math.round(f15);
                n10 = Math.round(f12 *= f11);
            }
        }
        n13 = 255;
        n12 = ColorUtils.constrain(n12, 0, n13);
        n11 = ColorUtils.constrain(n11, 0, n13);
        n10 = ColorUtils.constrain(n10, 0, n13);
        return Color.rgb((int)n12, (int)n11, (int)n10);
    }

    public static int LABToColor(double d10, double d11, double d12) {
        double[] dArray = ColorUtils.getTempDouble3Array();
        double d13 = d10;
        double d14 = d11;
        double d15 = d12;
        ColorUtils.LABToXYZ(d10, d11, d12, dArray);
        d13 = dArray[0];
        d14 = dArray[1];
        d15 = dArray[2];
        return ColorUtils.XYZToColor(d13, d14, d15);
    }

    public static void LABToXYZ(double d10, double d11, double d12, double[] dArray) {
        double d13 = 16.0;
        double d14 = d10 + d13;
        double d15 = 116.0;
        double d16 = d11 / 500.0 + (d14 /= d15);
        double d17 = d12 / 200.0;
        d17 = d14 - d17;
        double d18 = 3.0;
        double d19 = Math.pow(d16, d18);
        double d20 = 0.008856;
        double d21 = d19 == d20 ? 0 : (d19 > d20 ? 1 : -1);
        double d22 = 903.3;
        if (d21 <= 0) {
            d16 = d16 * d15 - d13;
            d19 = d16 / d22;
        }
        d16 = 7.9996247999999985;
        double d23 = d10 == d16 ? 0 : (d10 > d16 ? 1 : -1);
        d14 = d23 > 0 ? Math.pow(d14, d18) : d10 / d22;
        d16 = Math.pow(d17, d18);
        double d24 = d16 == d20 ? 0 : (d16 > d20 ? 1 : -1);
        if (d24 <= 0) {
            d17 = d17 * d15 - d13;
            d16 = d17 / d22;
        }
        dArray[0] = d19 *= 95.047;
        dArray[1] = d14 *= 100.0;
        dArray[2] = d16 *= 108.883;
    }

    public static void RGBToHSL(int n10, int n11, int n12, float[] fArray) {
        float f10 = n10;
        int n13 = 1132396544;
        float f11 = 255.0f;
        f10 /= f11;
        float f12 = (float)n11 / f11;
        float f13 = (float)n12 / f11;
        f11 = Math.max(f12, f13);
        f11 = Math.max(f10, f11);
        float f14 = Math.min(f12, f13);
        f14 = Math.min(f10, f14);
        float f15 = f11 - f14;
        float f16 = f11 + f14;
        float f17 = 2.0f;
        f16 /= f17;
        Object object = f11 == f14 ? 0 : (f11 > f14 ? 1 : -1);
        float f18 = 1.0f;
        if (object == false) {
            n11 = 0;
            f12 = 0.0f;
            f15 = 0.0f;
        } else {
            object = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (object == false) {
                f12 = (f12 - f13) / f15;
                n10 = 0x40C00000;
                f10 = 6.0f;
                f12 %= f10;
            } else {
                n13 = (int)(f11 == f12 ? 0 : (f11 > f12 ? 1 : -1));
                if (n13 == 0) {
                    f13 = (f13 - f10) / f15;
                    f12 = f13 + f17;
                } else {
                    f10 = (f10 - f12) / f15;
                    n11 = 0x40800000;
                    f12 = 4.0f + f10;
                }
            }
            f17 = f17 * f16 - f18;
            f10 = Math.abs(f17);
            f10 = f18 - f10;
            f15 /= f10;
        }
        f12 *= 60.0f;
        n10 = 1135869952;
        f10 = 360.0f;
        float f19 = (f12 %= f10) - 0.0f;
        n12 = (int)(f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1));
        if (n12 < 0) {
            f12 += f10;
        }
        fArray[0] = f10 = ColorUtils.constrain(f12, 0.0f, f10);
        fArray[1] = f12 = ColorUtils.constrain(f15, 0.0f, f18);
        fArray[2] = f12 = ColorUtils.constrain(f16, 0.0f, f18);
    }

    public static void RGBToLAB(int n10, int n11, int n12, double[] dArray) {
        ColorUtils.RGBToXYZ(n10, n11, n12, dArray);
        double d10 = dArray[0];
        double d11 = dArray[1];
        double d12 = dArray[2];
        ColorUtils.XYZToLAB(d10, d11, d12, dArray);
    }

    public static void RGBToXYZ(int n10, int n11, int n12, double[] dArray) {
        Object object = dArray;
        int n13 = dArray.length;
        int n14 = 3;
        if (n13 == n14) {
            n13 = n10;
            double d10 = n10;
            double d11 = 255.0;
            double d12 = 0.04045;
            double d13 = (d10 /= d11) - d12;
            double d14 = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
            double d15 = 12.92;
            double d16 = 2.4;
            double d17 = 1.055;
            double d18 = 0.055;
            d10 = d14 < 0 ? (d10 /= d15) : Math.pow((d10 + d18) / d17, d16);
            d14 = n11;
            d16 = (double)n11 / d11;
            d14 = d16 == d12 ? 0 : (d16 < d12 ? -1 : 1);
            if (d14 < 0) {
                d16 /= d15;
            } else {
                d16 = (d16 + d18) / d17;
                d17 = 2.4;
                d16 = Math.pow(d16, d17);
            }
            d14 = n12;
            d17 = (double)n12 / d11;
            double d19 = d17 == d12 ? 0 : (d17 < d12 ? -1 : 1);
            if (d19 < 0) {
                d17 /= d15;
            } else {
                d17 = (d17 + d18) / 1.055;
                d11 = 2.4;
                d17 = Math.pow(d17, d11);
            }
            double d20 = 0.4124 * d10;
            double d21 = 0.3576 * d16;
            d20 += d21;
            d21 = 0.1805 * d17;
            d20 += d21;
            d21 = 100.0;
            object[0] = d20 *= d21;
            d20 = 0.2126 * d10;
            d15 = 0.7152 * d16;
            d20 += d15;
            d15 = 0.0722 * d17;
            object[1] = d20 = (d20 + d15) * d21;
            d10 *= 0.0193;
            d10 += (d16 *= 0.1192);
            object[2] = d10 = (d10 + (d17 *= 0.9505)) * d21;
            return;
        }
        object = new IllegalArgumentException;
        object("outXyz must have a length of 3.");
        throw object;
    }

    public static int XYZToColor(double d10, double d11, double d12) {
        double d13 = 3.2406 * d10;
        double d14 = -1.5372 * d11;
        d13 += d14;
        d14 = -0.4986 * d12;
        d13 += d14;
        d14 = 100.0;
        d13 /= d14;
        double d15 = -0.9689 * d10;
        double d16 = 1.8758 * d11;
        d15 += d16;
        d16 = 0.0415 * d12;
        d15 = (d15 + d16) / d14;
        d16 = 0.0557 * d10;
        double d17 = -0.204 * d11;
        d16 += d17;
        d17 = 1.057 * d12;
        d16 = (d16 + d17) / d14;
        d14 = 0.0031308;
        double d18 = d13 == d14 ? 0 : (d13 > d14 ? 1 : -1);
        double d19 = 0.055;
        double d20 = 0.4166666666666667;
        double d21 = 1.055;
        double d22 = 12.92;
        d13 = d18 > 0 ? Math.pow(d13, d20) * d21 - d19 : (d13 *= d22);
        d18 = d15 == d14 ? 0 : (d15 > d14 ? 1 : -1);
        d15 = d18 > 0 ? Math.pow(d15, d20) * d21 - d19 : (d15 *= d22);
        double d23 = d16 == d14 ? 0 : (d16 > d14 ? 1 : -1);
        d14 = d23 > 0 ? Math.pow(d16, d20) * d21 - d19 : d16 * d22;
        d16 = 255.0;
        int n10 = (int)Math.round(d13 * d16);
        d18 = 255;
        n10 = ColorUtils.constrain(n10, 0, (int)d18);
        int n11 = ColorUtils.constrain((int)Math.round(d15 * d16), 0, (int)d18);
        int n12 = ColorUtils.constrain((int)Math.round(d14 * d16), 0, (int)d18);
        return Color.rgb((int)n10, (int)n11, (int)n12);
    }

    public static void XYZToLAB(double d10, double d11, double d12, double[] dArray) {
        int n10 = dArray.length;
        int n11 = 3;
        if (n10 == n11) {
            double d13;
            d10 = ColorUtils.pivotXyzComponent(d10 / 95.047);
            d11 = ColorUtils.pivotXyzComponent(d11 / 100.0);
            d12 = ColorUtils.pivotXyzComponent(d12 / 108.883);
            double d14 = 116.0 * d11 - 16.0;
            dArray[0] = d13 = Math.max(0.0, d14);
            dArray[1] = d10 = (d10 - d11) * 500.0;
            dArray[2] = d11 = (d11 - d12) * 200.0;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("outLab must have a length of 3.");
        throw illegalArgumentException;
    }

    public static int blendARGB(int n10, int n11, float f10) {
        float f11 = 1.0f - f10;
        float f12 = (float)Color.alpha((int)n10) * f11;
        float f13 = (float)Color.alpha((int)n11) * f10;
        f12 += f13;
        f13 = (float)Color.red((int)n10) * f11;
        float f14 = (float)Color.red((int)n11) * f10;
        f13 += f14;
        f14 = (float)Color.green((int)n10) * f11;
        float f15 = (float)Color.green((int)n11) * f10;
        float f16 = (float)Color.blue((int)n10) * f11;
        float f17 = (float)Color.blue((int)n11) * f10;
        n11 = (int)f12;
        int n12 = (int)f13;
        int n13 = (int)(f14 += f15);
        n10 = (int)(f16 += f17);
        return Color.argb((int)n11, (int)n12, (int)n13, (int)n10);
    }

    public static void blendHSL(float[] object, float[] fArray, float f10, float[] fArray2) {
        int n10 = fArray2.length;
        int n11 = 3;
        if (n10 == n11) {
            float f11 = 1.0f - f10;
            float f12 = object[0];
            float f13 = fArray[0];
            fArray2[0] = f12 = ColorUtils.circularInterpolate(f12, f13, f10);
            n11 = 1;
            f12 = object[n11] * f11;
            f13 = fArray[n11] * f10;
            fArray2[n11] = f12 += f13;
            n11 = 2;
            float f14 = object[n11] * f11;
            float f15 = fArray[n11] * f10;
            fArray2[n11] = f14 += f15;
            return;
        }
        object = new IllegalArgumentException;
        object("result must have a length of 3.");
        throw object;
    }

    public static void blendLAB(double[] object, double[] dArray, double d10, double[] dArray2) {
        int n10 = dArray2.length;
        int n11 = 3;
        if (n10 == n11) {
            double d11 = 1.0 - d10;
            double d12 = object[0] * d11;
            double d13 = dArray[0] * d10;
            dArray2[0] = d12 += d13;
            int n12 = 1;
            d12 = object[n12] * d11;
            d13 = dArray[n12] * d10;
            dArray2[n12] = d12 += d13;
            n12 = 2;
            d12 = object[n12] * d11;
            double d14 = dArray[n12] * d10;
            dArray2[n12] = d12 += d14;
            return;
        }
        object = new IllegalArgumentException;
        object("outResult must have a length of 3.");
        throw object;
    }

    public static double calculateContrast(int n10, int n11) {
        int n12;
        int n13 = Color.alpha((int)n11);
        if (n13 == (n12 = 255)) {
            n13 = Color.alpha((int)n10);
            if (n13 < n12) {
                n10 = ColorUtils.compositeColors(n10, n11);
            }
            double d10 = ColorUtils.calculateLuminance(n10);
            double d11 = 0.05;
            d10 += d11;
            double d12 = ColorUtils.calculateLuminance(n11) + d11;
            d11 = Math.max(d10, d12);
            d12 = Math.min(d10, d12);
            return d11 / d12;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("background can not be translucent: #");
        String string2 = Integer.toHexString(n11);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static double calculateLuminance(int n10) {
        double[] dArray = ColorUtils.getTempDouble3Array();
        ColorUtils.colorToXYZ(n10, dArray);
        return dArray[1] / 100.0;
    }

    public static int calculateMinimumAlpha(int n10, int n11, float f10) {
        int n12;
        int n13 = Color.alpha((int)n11);
        if (n13 == (n12 = 255)) {
            int n14;
            int n15;
            double d10;
            n13 = ColorUtils.setAlphaComponent(n10, n12);
            double d11 = ColorUtils.calculateContrast(n13, n11);
            double d12 = d11 - (d10 = (double)f10);
            Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
            if (object < 0) {
                return -1;
            }
            f10 = 0.0f;
            Object var10_8 = null;
            n13 = 0;
            for (object = (Object)false; object <= (n15 = 10) && (n15 = n12 - n13) > (n14 = 1); ++object) {
                n15 = (n13 + n12) / 2;
                double d13 = ColorUtils.calculateContrast(ColorUtils.setAlphaComponent(n10, n15), n11);
                double d14 = d13 - d10;
                n14 = (int)(d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1));
                if (n14 < 0) {
                    n13 = n15;
                    continue;
                }
                n12 = n15;
            }
            return n12;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("background can not be translucent: #");
        String string2 = Integer.toHexString(n11);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static float circularInterpolate(float f10, float f11, float f12) {
        float f13 = Math.abs(f11 - f10);
        float f14 = f13 - 180.0f;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        float f15 = 360.0f;
        if (object > 0) {
            object = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
            if (object > 0) {
                f10 += f15;
            } else {
                f11 += f15;
            }
        }
        f11 = (f11 - f10) * f12;
        return (f10 + f11) % f15;
    }

    public static void colorToHSL(int n10, float[] fArray) {
        int n11 = Color.red((int)n10);
        int n12 = Color.green((int)n10);
        n10 = Color.blue((int)n10);
        ColorUtils.RGBToHSL(n11, n12, n10, fArray);
    }

    public static void colorToLAB(int n10, double[] dArray) {
        int n11 = Color.red((int)n10);
        int n12 = Color.green((int)n10);
        n10 = Color.blue((int)n10);
        ColorUtils.RGBToLAB(n11, n12, n10, dArray);
    }

    public static void colorToXYZ(int n10, double[] dArray) {
        int n11 = Color.red((int)n10);
        int n12 = Color.green((int)n10);
        n10 = Color.blue((int)n10);
        ColorUtils.RGBToXYZ(n11, n12, n10, dArray);
    }

    private static int compositeAlpha(int n10, int n11) {
        n11 = 255 - n11;
        n10 = 255 - n10;
        n11 = n11 * n10 / 255;
        return 255 - n11;
    }

    public static int compositeColors(int n10, int n11) {
        int n12 = Color.alpha((int)n11);
        int n13 = Color.alpha((int)n10);
        int n14 = ColorUtils.compositeAlpha(n13, n12);
        int n15 = Color.red((int)n10);
        int n16 = Color.red((int)n11);
        n15 = ColorUtils.compositeComponent(n15, n13, n16, n12, n14);
        n16 = Color.green((int)n10);
        int n17 = Color.green((int)n11);
        n16 = ColorUtils.compositeComponent(n16, n13, n17, n12, n14);
        n10 = Color.blue((int)n10);
        n11 = Color.blue((int)n11);
        n10 = ColorUtils.compositeComponent(n10, n13, n11, n12, n14);
        return Color.argb((int)n14, (int)n15, (int)n16, (int)n10);
    }

    public static Color compositeColors(Color object, Color color2) {
        Object object2;
        Object object3 = object.getModel();
        boolean bl2 = Objects.equals(object3, object2 = color2.getModel());
        if (bl2) {
            object3 = color2.getColorSpace();
            bl2 = Objects.equals(object3, object2 = object.getColorSpace());
            if (!bl2) {
                object3 = color2.getColorSpace();
                object = object.convert((ColorSpace)object3);
            }
            object3 = object.getComponents();
            object2 = color2.getComponents();
            float f10 = object.alpha();
            float f11 = color2.alpha();
            float f12 = 1.0f - f10;
            int n10 = color2.getComponentCount() + -1;
            float f13 = f10 + (f11 *= f12);
            object2[n10] = f13;
            f13 = (float)object2[n10];
            float f14 = 0.0f;
            float f15 = f13 - 0.0f;
            float f16 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (f16 > 0) {
                f13 = (float)object2[n10];
                f10 /= f13;
                f13 = (float)object2[n10];
                f11 /= f13;
            }
            f13 = 0.0f;
            for (f16 = 0.0f; f16 < n10; ++f16) {
                f14 = (float)(object3[f16] * f10);
                reference var12_12 = object2[f16] * f11;
                object2[f16] = f14 += var12_12;
            }
            object = color2.getColorSpace();
            return Color.valueOf((float[])object2, (ColorSpace)object);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Color models must match (");
        object = object.getModel();
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" vs. ");
        object = color2.getModel();
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(")");
        object = ((StringBuilder)object2).toString();
        object3 = new IllegalArgumentException((String)object);
        throw object3;
    }

    private static int compositeComponent(int n10, int n11, int n12, int n13, int n14) {
        if (n14 == 0) {
            return 0;
        }
        n10 = n10 * 255 * n11;
        n12 *= n13;
        n11 = 255 - n11;
        return (n10 += (n12 *= n11)) / (n14 *= 255);
    }

    private static float constrain(float f10, float f11, float f12) {
        Object object = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (object < 0) {
            f10 = f11;
        } else {
            Object object2 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
            if (object2 > 0) {
                f10 = f12;
            }
        }
        return f10;
    }

    private static int constrain(int n10, int n11, int n12) {
        if (n10 < n11) {
            n10 = n11;
        } else if (n10 > n12) {
            n10 = n12;
        }
        return n10;
    }

    public static double distanceEuclidean(double[] dArray, double[] dArray2) {
        double d10 = dArray[0];
        double d11 = dArray2[0];
        d10 -= d11;
        d11 = 2.0;
        double d12 = Math.pow(d10, d11);
        int n10 = 1;
        double d13 = dArray[n10];
        double d14 = dArray2[n10];
        d13 = Math.pow(d13 - d14, d11);
        d12 += d13;
        n10 = 2;
        d13 = dArray[n10];
        double d15 = dArray2[n10];
        d15 = Math.pow(d13 - d15, d11);
        return Math.sqrt(d12 + d15);
    }

    private static double[] getTempDouble3Array() {
        ThreadLocal threadLocal = TEMP_ARRAY;
        double[] dArray = (double[])threadLocal.get();
        if (dArray == null) {
            int n10 = 3;
            dArray = new double[n10];
            threadLocal.set(dArray);
        }
        return dArray;
    }

    private static double pivotXyzComponent(double d10) {
        double d11 = 0.008856;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object > 0) {
            d11 = 0.3333333333333333;
            d10 = Math.pow(d10, d11);
        } else {
            d10 = d10 * 903.3 + 16.0;
            d11 = 116.0;
            d10 /= d11;
        }
        return d10;
    }

    public static int setAlphaComponent(int n10, int n11) {
        int n12;
        if (n11 >= 0 && n11 <= (n12 = 255)) {
            return (n10 &= 0xFFFFFF) | (n11 <<= 24);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("alpha must be between 0 and 255.");
        throw illegalArgumentException;
    }
}

