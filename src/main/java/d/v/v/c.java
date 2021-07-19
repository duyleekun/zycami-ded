/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Size
 */
package d.v.v;

import android.content.Context;
import android.util.Size;
import com.zhiyun.editorinterface.EditConfig;
import d.v.v.b;

public class c
extends EditConfig {
    public static final String A = "Scale Y";
    public static final String B = "Rotation";
    public static final String C = "Trans X";
    public static final String D = "Trans Y";
    public static final String E = "Lut";
    public static final String F = "Data File Path";
    public static final String G = "Intensity";
    public static final String H = "Vignette";
    public static final String I = "Degree";
    public static final String J = "Sharpen";
    public static final String K = "Amount";
    public static final String L = "Storyboard";
    public static final Size a;
    public static final int b = 25;
    public static final int c = 44100;
    public static final int d = 2;
    public static final long e = 2000000L;
    public static final long f = 3000000L;
    public static final long g = 3000000L;
    public static final float h = 1.0f;
    public static final float[] i;
    public static final float j = 1.0f;
    public static final String k = "animatedsticker";
    public static final long l = 500000L;
    public static final long m = 500000L;
    public static final int n = 1;
    public static final int o = 1;
    public static final String p = "assets:/E14FEE65-71A0-4717-9D66-3397B6C11223.5.animatedsticker";
    public static final String q = "assets:/E14FEE65-71A0-4717-9D66-3397B6C11223.5.animatedsticker";
    public static final String r = "assets:/shuiyin.png";
    public static final String s = "6595F262-0140-42EC-908D-C304C1CA3CBF";
    public static final String t = "E14FEE65-71A0-4717-9D66-3397B6C11223";
    public static final String u = "Color Property";
    public static final String v = "Brightness";
    public static final String w = "Contrast";
    public static final String x = "Saturation";
    public static final String y = "Transform 2D";
    public static final String z = "Scale X";

    static {
        Object object;
        a = object = new Size(1920, 1080);
        Object object2 = object = (Object)new float[2];
        object2[0] = (Size)1.0f;
        object2[1] = (Size)1.0f;
        i = (float[])object;
    }

    public void a() {
    }

    public void b(Context context) {
        d.v.v.b.b().c(context);
    }
}

