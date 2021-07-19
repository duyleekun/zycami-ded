/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.v.b0.i;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.faceunity.wrapper.faceunity;
import com.faceunity.wrapper.faceunity$RotatedImage;
import d.v.b0.i.b$a;
import d.v.b0.i.b$a0;
import d.v.b0.i.b$b;
import d.v.b0.i.b$b0;
import d.v.b0.i.b$c;
import d.v.b0.i.b$c0;
import d.v.b0.i.b$d;
import d.v.b0.i.b$e;
import d.v.b0.i.b$f;
import d.v.b0.i.b$g;
import d.v.b0.i.b$h;
import d.v.b0.i.b$i;
import d.v.b0.i.b$j;
import d.v.b0.i.b$k;
import d.v.b0.i.b$l;
import d.v.b0.i.b$m;
import d.v.b0.i.b$n;
import d.v.b0.i.b$o;
import d.v.b0.i.b$p;
import d.v.b0.i.b$q;
import d.v.b0.i.b$r;
import d.v.b0.i.b$s;
import d.v.b0.i.b$t;
import d.v.b0.i.b$u;
import d.v.b0.i.b$v;
import d.v.b0.i.b$w;
import d.v.b0.i.b$y;
import d.v.b0.i.b$z;
import d.v.b0.i.c;
import d.v.b0.i.d;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class b
implements c {
    private static final String A0 = "graphics/fxaa.bundle";
    private static final int A1 = 11;
    private static final String B0 = "graphics/face_beautification.bundle";
    private static final int B1 = 50;
    private static final String C0 = "effect/hair_seg/hair_normal.bundle";
    public static final int C1 = 0;
    private static final String D0 = "effect/hair_seg/hair_gradient.bundle";
    public static final int D1 = 1;
    private static final String E0 = "change_face/change_face.bundle";
    private static boolean E1 = false;
    private static final String F0 = "graphics/fuzzytoonfilter.bundle";
    private static final String F1 = "pta/";
    private static final String G0 = "light_makeup/light_makeup.bundle";
    private static final String G1 = "boy/";
    private static final String H0 = "graphics/face_makeup.bundle";
    private static final String H1 = "girl/";
    private static final String I0 = "graphics/body_slim.bundle";
    private static final String[] I1 = new String[]{"head.bundle", "midBody_male.bundle", "male_hair_5.bundle", "toushi_7.bundle", "peishi_erding_2.bundle", "waitao_3.bundle", "kuzi_changku_5.bundle", "xiezi_tuoxie_2.bundle"};
    private static final String J0 = "model/";
    private static final String[] J1 = new String[]{"head.bundle", "midBody_female.bundle", "female_hair_23.bundle", "toushi_5.bundle", "taozhuang_12.bundle", "facemakeup_3.bundle", "xiezi_danxie.bundle"};
    private static final String K0 = "model/ai_face_processor.bundle";
    private static final String[] K1;
    private static final String L0 = "graphics/tongue.bundle";
    private static final int L1 = 2;
    private static final String M0 = "landmarks";
    private static final int M1 = 2;
    private static float N0 = 1.0f;
    private static final int N1 = 0;
    private static float O0 = 0.4f;
    public static final int O1 = 1;
    private static float P0 = 0.7f;
    public static final int P1 = 0;
    private static float Q0 = 2.0f;
    private static final int Q1 = 1000000;
    private static float R0 = 0.3f;
    private static final int R1 = 1000000000;
    private static float S0 = 0.2f;
    private static final int S1 = 10;
    private static float T0 = 0.3f;
    private static float U0 = 0.0f;
    private static float V0 = 0.0f;
    private static float W0 = 4.0f;
    private static float X0 = 1.0f;
    private static float Y0 = 0.0f;
    private static float Z0 = 0.0f;
    private static float a1 = 0.0f;
    private static float b1 = 0.5f;
    private static float c1 = 0.0f;
    private static float d1 = 0.0f;
    private static float e1 = 0.4f;
    private static float f1 = 0.3f;
    private static float g1 = 0.3f;
    private static float h1 = 0.4f;
    private static float i1 = 0.5f;
    private static float j1 = 0.0f;
    private static float k1 = 0.0f;
    private static float l1 = 0.0f;
    private static float m1 = 0.0f;
    private static float n1 = 0.5f;
    private static final String o0 = "b";
    private static float o1 = 0.5f;
    public static final int p0 = 1;
    private static float p1 = 0.5f;
    public static final int q0 = 32;
    private static float q1 = 0.5f;
    public static final int r0 = 128;
    private static final int r1 = 0;
    public static final int s0 = 0;
    public static final int s1 = 1;
    public static final int t0 = 1;
    private static final int t1 = 2;
    public static final int u0 = 255;
    private static final int u1 = 3;
    public static final int v0 = 0;
    private static final int v1 = 4;
    public static final int w0 = 1;
    private static final int w1 = 5;
    public static final int x0 = 1024;
    private static final int x1 = 6;
    public static final int y0 = 8;
    private static final int y1 = 7;
    private static final String z0 = "graphics/";
    private static final int z1 = 10;
    private float A;
    private int B;
    private int C;
    private Map D;
    private Map E;
    private boolean F;
    private float[] G;
    private float[] H;
    private List I;
    private long J;
    private b$z K;
    private int L;
    private int M;
    private boolean N;
    private boolean O;
    private double[] P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;
    private boolean X;
    private int Y;
    private String Z;
    private Context a;
    private faceunity$RotatedImage a0;
    private int b = 0;
    private int[] b0;
    private int[] c;
    private int c0;
    private Handler d;
    private int d0;
    private boolean e;
    private int e0;
    private boolean f;
    private int f0;
    private boolean g;
    private b$c0 g0;
    private boolean h;
    private b$b0 h0;
    private boolean i;
    private int i0;
    private boolean j;
    private long j0;
    private int k;
    private long k0;
    private int l;
    private boolean l0;
    private volatile boolean m;
    private long m0;
    private float n;
    private b$a0 n0;
    private float o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private int u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    static {
        String[] stringArray = new String[]{"anim_idle.bundle", "anim_eight.bundle", "anim_fist.bundle", "anim_greet.bundle", "anim_gun.bundle", "anim_heart.bundle", "anim_hold.bundle", "anim_korheart.bundle", "anim_merge.bundle", "anim_ok.bundle", "anim_one.bundle", "anim_palm.bundle", "anim_rock.bundle", "anim_six.bundle", "anim_thumb.bundle", "anim_two.bundle"};
        K1 = stringArray;
        N1 = stringArray.length + 2;
    }

    private b(Context context, boolean bl2) {
        long l10;
        faceunity$RotatedImage faceunity$RotatedImage;
        float f10;
        int n10;
        int n11;
        boolean bl3;
        int[] nArray = new int[11];
        this.c = nArray;
        this.e = bl3 = true;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.k = 0;
        this.l = 0;
        this.m = bl3;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0.5f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = 0.0f;
        this.u = 270;
        this.v = n11 = -1;
        this.x = (int)(bl3 ? 1 : 0);
        this.y = n10 = 4;
        this.z = (int)(bl3 ? 1 : 0);
        this.A = 0.6f;
        this.B = (int)(bl3 ? 1 : 0);
        this.C = 0;
        int n12 = 16;
        Object object = new ConcurrentHashMap(n12);
        this.D = object;
        super(n12);
        this.E = object;
        object = new float[n10];
        this.G = (float[])object;
        Object[] objectArray = new float[n10];
        this.H = objectArray;
        this.L = 90;
        this.M = (int)(bl3 ? 1 : 0);
        Object[] objectArray2 = objectArray = (Object[])new double[3];
        objectArray[0] = (float)0.0;
        objectArray2[1] = (float)255.0;
        objectArray2[2] = (float)0.0;
        this.P = objectArray;
        this.Q = 0.45f;
        this.R = 0.3f;
        this.S = 0.2f;
        this.T = 0.0f;
        this.U = 0.0f;
        this.V = f10 = 1.0f;
        this.W = f10;
        this.X = bl3;
        this.Z = "bg_seg_green/classroom.mp4";
        this.a0 = faceunity$RotatedImage = new faceunity$RotatedImage();
        this.c0 = (int)(bl3 ? 1 : 0);
        this.d0 = n11;
        this.e0 = n11;
        this.f0 = n11;
        this.i0 = 0;
        this.j0 = l10 = 0L;
        this.k0 = l10;
        this.l0 = bl3;
        this.m0 = l10;
        this.a = context;
        this.j = bl2;
    }

    public /* synthetic */ b(Context context, boolean bl2, b$k b$k) {
        this(context, bl2);
    }

    public static /* synthetic */ int A0(b b10, int n10) {
        b10.k = n10;
        return n10;
    }

    public static /* synthetic */ int B0(b b10, int n10) {
        b10.l = n10;
        return n10;
    }

    public static /* synthetic */ int C0(b b10, int n10) {
        b10.v = n10;
        return n10;
    }

    public static /* synthetic */ boolean D0(b b10, boolean bl2) {
        b10.e = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean E0(b b10, boolean bl2) {
        b10.i = bl2;
        return bl2;
    }

    private void E1() {
        Object object;
        String string2;
        String string3;
        float f10;
        Object object2;
        this.Z0();
        Object object3 = faceunity.fuIsTracking();
        Object object4 = this.g0;
        if (object4 != null && (object2 = this.e0) != object3) {
            this.e0 = object3;
            object2 = 1024;
            f10 = 1.435E-42f;
            object4.a((int)object2, (int)object3);
        }
        if ((object3 = faceunity.fuGetSystemError()) != 0) {
            object4 = faceunity.fuGetSystemErrorString(object3);
            string3 = o0;
            StringBuilder stringBuilder = new StringBuilder();
            string2 = "system error code: ";
            stringBuilder.append(string2);
            stringBuilder.append((int)object3);
            stringBuilder.append(", error message: ");
            stringBuilder.append((String)object4);
            object = stringBuilder.toString();
            Log.e((String)string3, (String)object);
            object = this.h0;
            if (object != null) {
                object.a((String)object4);
            }
        }
        object3 = this.m;
        object4 = null;
        if (object3 != 0 && (object2 = (Object)(object = this.c)[0]) > 0) {
            object3 = object[0];
            double d10 = N0;
            faceunity.fuItemSetParam(object3, "is_beauty_on", d10);
            d10 = O0;
            faceunity.fuItemSetParam(object3, "filter_level", d10);
            faceunity.fuItemSetParam(object3, "heavy_blur", 0.0);
            d10 = Q0;
            faceunity.fuItemSetParam(object3, "blur_type", d10);
            float f11 = P0;
            double d11 = (double)f11 * 6.0;
            string3 = "blur_level";
            faceunity.fuItemSetParam(object3, string3, d11);
            d10 = R0;
            faceunity.fuItemSetParam(object3, "color_level", d10);
            d10 = S0;
            faceunity.fuItemSetParam(object3, "sharpen", d10);
            d10 = T0;
            faceunity.fuItemSetParam(object3, "red_level", d10);
            d10 = U0;
            faceunity.fuItemSetParam(object3, "eye_bright", d10);
            d10 = V0;
            faceunity.fuItemSetParam(object3, "tooth_whiten", d10);
            d10 = X0;
            faceunity.fuItemSetParam(object3, "face_shape_level", d10);
            d10 = W0;
            faceunity.fuItemSetParam(object3, "face_shape", d10);
            d10 = e1;
            faceunity.fuItemSetParam(object3, "eye_enlarging", d10);
            d10 = a1;
            faceunity.fuItemSetParam(object3, "cheek_thinning", d10);
            d10 = c1;
            faceunity.fuItemSetParam(object3, "cheek_narrow", d10);
            d10 = d1;
            faceunity.fuItemSetParam(object3, "cheek_small", d10);
            d10 = b1;
            faceunity.fuItemSetParam(object3, "cheek_v", d10);
            d10 = Y0;
            faceunity.fuItemSetParam(object3, "intensity_cheekbones", d10);
            d10 = Z0;
            faceunity.fuItemSetParam(object3, "intensity_lower_jaw", d10);
            d10 = i1;
            faceunity.fuItemSetParam(object3, "intensity_nose", d10);
            d10 = f1;
            faceunity.fuItemSetParam(object3, "intensity_chin", d10);
            d10 = g1;
            faceunity.fuItemSetParam(object3, "intensity_forehead", d10);
            d10 = h1;
            faceunity.fuItemSetParam(object3, "intensity_mouth", d10);
            d10 = j1;
            faceunity.fuItemSetParam(object3, "remove_pouch_strength", d10);
            d10 = k1;
            faceunity.fuItemSetParam(object3, "remove_nasolabial_folds_strength", d10);
            d10 = l1;
            faceunity.fuItemSetParam(object3, "intensity_smile", d10);
            d10 = m1;
            faceunity.fuItemSetParam(object3, "intensity_canthus", d10);
            d10 = n1;
            faceunity.fuItemSetParam(object3, "intensity_philtrum", d10);
            d10 = o1;
            faceunity.fuItemSetParam(object3, "intensity_long_nose", d10);
            d10 = p1;
            faceunity.fuItemSetParam(object3, "intensity_eye_space", d10);
            f10 = q1;
            d10 = f10;
            string2 = "intensity_eye_rotate";
            faceunity.fuItemSetParam(object3, string2, d10);
            this.m = false;
        }
        while ((object3 = (Object)(object = (Object)this.I).isEmpty()) == 0) {
            object = (Runnable)this.I.remove(0);
            object.run();
        }
    }

    public static /* synthetic */ boolean F0(b b10, boolean bl2) {
        b10.g = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean G0(b b10, boolean bl2) {
        b10.f = bl2;
        return bl2;
    }

    private static byte[] G1(Context object, String string2) {
        Object object2;
        object = object.getAssets();
        try {
            object = object.open(string2);
        }
        catch (IOException iOException) {
            object2 = o0;
            String string3 = "readFile: e1";
            Log.w((String)object2, (String)string3, (Throwable)iOException);
            try {
                object = new FileInputStream(string2);
            }
            catch (IOException iOException2) {
                object2 = o0;
                string3 = "readFile: e2";
                Log.w((String)object2, (String)string3, (Throwable)iOException2);
                object = null;
            }
        }
        if (object != null) {
            int n10 = ((InputStream)object).available();
            object2 = new byte[n10];
            int n11 = ((InputStream)object).read((byte[])object2);
            String string4 = o0;
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "readFile. path: ";
            stringBuilder.append(string5);
            stringBuilder.append(string2);
            string2 = ", length: ";
            stringBuilder.append(string2);
            stringBuilder.append(n11);
            string2 = " Byte";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            try {
                Log.v((String)string4, (String)string2);
                ((InputStream)object).close();
                return object2;
            }
            catch (IOException iOException) {
                string2 = o0;
                object2 = "readFile: e3";
                Log.e((String)string2, (String)object2, (Throwable)iOException);
            }
        }
        return null;
    }

    public static /* synthetic */ String[] H0() {
        return K1;
    }

    private static void H1(int n10) {
        int n11;
        int n12 = faceunity.fuIsAIModelLoaded(n10);
        if (n12 == (n11 = 1)) {
            n12 = faceunity.fuReleaseAIModel(n10);
            String string2 = o0;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "releaseAiModel. type: ";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            String string4 = ", isReleased: ";
            stringBuilder.append(string4);
            string4 = n12 == n11 ? "yes" : "no";
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.d((String)string2, (String)string4);
        }
    }

    public static /* synthetic */ boolean I0(b b10, boolean bl2) {
        b10.h = bl2;
        return bl2;
    }

    private static void I1() {
        d.v.b0.i.b.H1(2);
        d.v.b0.i.b.H1(4);
        d.v.b0.i.b.H1(8);
    }

    public static /* synthetic */ b$a0 J0(b b10, b$a0 b$a0) {
        b10.n0 = b$a0;
        return b$a0;
    }

    private void J1() {
        faceunity.fuOnCameraChange();
    }

    public static /* synthetic */ b$c0 K0(b b10, b$c0 b$c0) {
        b10.g0 = b$c0;
        return b$c0;
    }

    private void K1(byte[] byArray, int n10, int n11) {
        int n12 = this.x;
        int n13 = 1;
        float f10 = Float.MIN_VALUE;
        if ((n12 = n12 == n13 ? n13 : 0) != 0) {
            n13 = 3;
            f10 = 4.2E-45f;
        }
        faceunity.fuRotateImage(this.a0, byArray, 2, n10, n11, n13, n12, 0);
        faceunity.fuSetInputCameraMatrix(n12, 0, n13);
    }

    public static /* synthetic */ b$b0 L0(b b10, b$b0 b$b0) {
        b10.h0 = b$b0;
        return b$b0;
    }

    public static /* synthetic */ b$z M0(b b10) {
        return b10.K;
    }

    public static /* synthetic */ b$z N0(b b10, b$z b$z) {
        b10.K = b$z;
        return b$z;
    }

    public static /* synthetic */ boolean O0(b b10, boolean bl2) {
        b10.N = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean P0(b b10, boolean bl2) {
        b10.O = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean Q0(b b10, boolean bl2) {
        b10.m = bl2;
        return bl2;
    }

    public static /* synthetic */ int[] R0(b b10, int[] nArray) {
        return b10.V1(nArray);
    }

    public static /* synthetic */ int S0(b b10) {
        return b10.M;
    }

    public static /* synthetic */ int T0(b b10, int n10) {
        b10.M = n10;
        return n10;
    }

    public static /* synthetic */ int[] U0(b b10) {
        return b10.c;
    }

    public static /* synthetic */ int[] V0(b b10, int[] nArray) {
        b10.c = nArray;
        return nArray;
    }

    private int[] V1(int[] nArray) {
        int n10 = nArray.length;
        int[] nArray2 = new int[n10];
        int n11 = nArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n13 = nArray[i10];
            if (n13 <= 0) continue;
            int n14 = n12 + 1;
            nArray2[n12] = n13;
            n12 = n14;
        }
        return Arrays.copyOfRange(nArray2, 0, n12);
    }

    public static /* synthetic */ int[] W0(b b10) {
        return b10.b0;
    }

    public static /* synthetic */ int[] X0(b b10, int[] nArray) {
        b10.b0 = nArray;
        return nArray;
    }

    public static /* synthetic */ int Y0(b b10) {
        return b10.c0;
    }

    private void Z0() {
        int n10 = this.l0;
        if (n10 == 0) {
            return;
        }
        this.i0 = n10 = this.i0 + 1;
        int n11 = 10;
        float f10 = 1.4E-44f;
        if (n10 == n11) {
            long l10;
            this.i0 = 0;
            n10 = 1343554297;
            long l11 = System.nanoTime();
            long l12 = this.j0;
            f10 = l11 -= l12;
            float f11 = 1.0E10f / f10;
            double d10 = f11;
            long l13 = this.k0;
            float f12 = (float)l13 / 10.0f;
            float f13 = 1000000.0f;
            double d11 = f12 /= f13;
            this.j0 = l10 = System.nanoTime();
            this.k0 = l10 = 0L;
            b$a0 b$a0 = this.n0;
            if (b$a0 != null) {
                b$a0.a(d10, d11);
            }
        }
    }

    public static /* synthetic */ Context a0(b b10) {
        return b10.a;
    }

    private int a1() {
        int n10 = this.u;
        int n11 = 1;
        int n12 = 270;
        n10 = n10 == n12 ? ((n10 = this.x) == n11 ? this.L / 90 : (this.L + -180) / 90) : ((n10 = this.x) == n11 ? (this.L + 180) / 90 : this.L / 90);
        return n10;
    }

    public static /* synthetic */ void b0(Context context, String string2, int n10) {
        d.v.b0.i.b.p1(context, string2, n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    private int b1() {
        int n10 = this.v;
        int n11 = 0;
        if (n10 == 0) {
            return 0;
        }
        int n12 = 3;
        int n13 = 270;
        int n14 = 1;
        int n15 = 90;
        if (n10 == n14) {
            n10 = this.u;
            if (n10 == n15) return n12;
            if (n10 == n13) return n14;
            return 0;
        }
        n10 = this.u;
        int n16 = 2;
        int n17 = 180;
        if (n10 == n13) {
            n10 = this.x;
            if (n10 == n14) {
                n10 = this.L;
                return n10 / 90;
            }
            n10 = this.L;
            if (n10 == n17) {
                return n11;
            }
            if (n10 == 0) return n16;
            return n10 / 90;
        }
        if (n10 != n15) return n11;
        n10 = this.x;
        if (n10 == 0) {
            n10 = this.L;
            if (n10 == n15) return n12;
            if (n10 == n13) return n14;
            return n10 / 90;
        }
        n10 = this.L;
        if (n10 == 0) {
            return n16;
        }
        if (n10 == n15) {
            return n12;
        }
        if (n10 == n17) return n11;
        return n14;
    }

    public static /* synthetic */ String[] c0() {
        return J1;
    }

    public static /* synthetic */ String[] d0() {
        return I1;
    }

    private void d1() {
        int n10;
        int[] nArray = this.b0;
        if (nArray != null && (n10 = nArray[0]) > 0) {
            nArray = this.c;
            n10 = nArray[0];
            double d10 = 0.0;
            faceunity.fuItemSetParam(n10, "enable_human_processor", d10);
            int[] nArray2 = this.b0;
            nArray2 = this.V1(nArray2);
            String string2 = o0;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("destroyControllerRelated: unbind ");
            String string3 = Arrays.toString(nArray2);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
            faceunity.fuUnBindItems(n10, nArray2);
            for (n10 = nArray2.length + -1; n10 >= 0; n10 += -1) {
                int n11 = nArray2[n10];
                faceunity.fuDestroyItem(n11);
            }
            Arrays.fill(nArray2, 0);
            n10 = 0;
            nArray = null;
            this.b0 = null;
        }
    }

    public static /* synthetic */ int e0() {
        return N1;
    }

    public static void e1() {
        boolean bl2 = E1;
        if (bl2) {
            d.v.b0.i.b.H1(1024);
            faceunity.fuDestroyLibData();
            E1 = bl2 = d.v.b0.i.b.o1();
            String string2 = o0;
            CharSequence charSequence = new StringBuilder();
            String string3 = "destroyLibData. isLibraryInit: ";
            charSequence.append(string3);
            boolean bl3 = E1;
            string3 = bl3 ? "yes" : "no";
            charSequence.append(string3);
            charSequence = charSequence.toString();
            Log.d((String)string2, (String)charSequence);
        }
    }

    public static /* synthetic */ int f0(b b10, int n10) {
        b10.b = n10;
        return n10;
    }

    public static /* synthetic */ void g0(b b10) {
        b10.J1();
    }

    private double[] g1(float[] fArray) {
        int n10;
        if (fArray == null) {
            return null;
        }
        int n11 = fArray.length;
        double[] dArray = new double[n11];
        for (int i10 = 0; i10 < (n10 = fArray.length); ++i10) {
            double d10;
            float f10 = fArray[i10];
            dArray[i10] = d10 = (double)f10;
        }
        return dArray;
    }

    public static /* synthetic */ int h0(b b10, int n10) {
        b10.x = n10;
        return n10;
    }

    public static /* synthetic */ int i0(b b10, int n10) {
        b10.u = n10;
        return n10;
    }

    public static /* synthetic */ int j0(b b10) {
        return b10.b1();
    }

    public static int j1(int n10) {
        return faceunity.fuGetModuleCode(n10);
    }

    public static /* synthetic */ int k0(b b10, int n10) {
        b10.L = n10;
        return n10;
    }

    public static /* synthetic */ float l0() {
        return N0;
    }

    public static /* synthetic */ int m0(Context context, String string2) {
        return d.v.b0.i.b.q1(context, string2);
    }

    public static String m1() {
        return faceunity.fuGetVersion();
    }

    public static /* synthetic */ double[] n0(b b10, double[] dArray) {
        b10.P = dArray;
        return dArray;
    }

    public static void n1(Context object) {
        boolean bl2;
        boolean bl3 = E1;
        if (bl3) {
            return;
        }
        faceunity.fuCreateEGLContext();
        String string2 = o0;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("fu sdk version ");
        Object object3 = faceunity.fuGetVersion();
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        Log.e((String)string2, (String)object2);
        object2 = new byte[0];
        object3 = d.v.b0.i.d.a();
        faceunity.fuSetup((byte[])object2, (byte[])object3);
        faceunity.fuReleaseEGLContext();
        d.v.b0.i.b.p1(object, K0, 1024);
        d.v.b0.i.b.s1(object, L0);
        E1 = bl2 = d.v.b0.i.b.o1();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("initFURenderer finish. isLibraryInit: ");
        ((StringBuilder)object2).append(bl2);
        object = ((StringBuilder)object2).toString();
        Log.i((String)string2, (String)object);
    }

    public static /* synthetic */ float o0(b b10, float f10) {
        b10.Q = f10;
        return f10;
    }

    public static boolean o1() {
        int n10;
        int n11 = faceunity.fuIsLibraryInit();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public static /* synthetic */ float p0(b b10, float f10) {
        b10.R = f10;
        return f10;
    }

    private static void p1(Context object, String string2, int n10) {
        if ((object = (Object)d.v.b0.i.b.G1(object, string2)) != null) {
            int n11 = faceunity.fuLoadAIModelFromPackage((byte[])object, n10);
            string2 = o0;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "loadAiModel. type: ";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            String string4 = ", isLoaded: ";
            stringBuilder.append(string4);
            n10 = 1;
            object = n11 == n10 ? "yes" : "no";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.d((String)string2, (String)object);
        }
    }

    public static /* synthetic */ float q0(b b10, float f10) {
        b10.S = f10;
        return f10;
    }

    private static int q1(Context object, String string2) {
        int n10;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (object = (Object)d.v.b0.i.b.G1(object, string2)) != null) {
            n10 = faceunity.fuCreateItemFromPackage((byte[])object);
        } else {
            n10 = 0;
            object = null;
        }
        String string3 = o0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loadItem. bundlePath: ");
        stringBuilder.append(string2);
        stringBuilder.append(", itemHandle: ");
        stringBuilder.append(n10);
        string2 = stringBuilder.toString();
        Log.d((String)string3, (String)string2);
        return n10;
    }

    public static /* synthetic */ float r0(b b10, float f10) {
        b10.T = f10;
        return f10;
    }

    private void r1() {
        Handler handler = this.d;
        b$l b$l = new b$l(this);
        handler.post((Runnable)b$l);
    }

    public static /* synthetic */ float s0(b b10, float f10) {
        b10.U = f10;
        return f10;
    }

    private static void s1(Context object, String string2) {
        if ((object = (Object)d.v.b0.i.b.G1(object, string2)) != null) {
            int n10 = faceunity.fuLoadTongueModel((byte[])object);
            string2 = o0;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "loadTongueModel. isLoaded: ";
            stringBuilder.append(string3);
            object = n10 == 0 ? "no" : "yes";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.d((String)string2, (String)object);
        }
    }

    public static /* synthetic */ float t0(b b10, float f10) {
        b10.V = f10;
        return f10;
    }

    public static /* synthetic */ float u0(b b10, float f10) {
        b10.W = f10;
        return f10;
    }

    public static /* synthetic */ boolean v0(b b10, boolean bl2) {
        b10.X = bl2;
        return bl2;
    }

    public static /* synthetic */ int w0(b b10) {
        return b10.Y;
    }

    public static /* synthetic */ String x0() {
        return o0;
    }

    public static /* synthetic */ int y0(b b10, int n10) {
        b10.y = n10;
        return n10;
    }

    public static /* synthetic */ int z0(b b10, int n10) {
        b10.z = n10;
        return n10;
    }

    public void A(double[] dArray) {
        b$g b$g = new b$g(this, dArray);
        this.F1(b$g);
    }

    public int A1(byte[] object, int n10, int n11, int n12) {
        if (object != null && n10 > 0 && n11 > 0 && n12 > 0) {
            int n13;
            long l10;
            this.E1();
            boolean bl2 = this.l0;
            if (bl2) {
                this.m0 = l10 = System.nanoTime();
            }
            this.K1((byte[])object, n11, n12);
            object = this.a0;
            byte[] byArray = object.mData;
            int n14 = 1;
            int n15 = object.mWidth;
            int n16 = object.mHeight;
            int n17 = this.b;
            this.b = n13 = n17 + 1;
            int[] nArray = this.c;
            n13 = faceunity.fuRenderBundlesWithCamera(byArray, n10, n14, n15, n16, n17, nArray);
            n10 = (int)(this.l0 ? 1 : 0);
            if (n10 != 0) {
                long l11 = this.k0;
                l10 = System.nanoTime();
                long l12 = this.m0;
                this.k0 = l11 += (l10 -= l12);
            }
            return n13;
        }
        Log.e((String)o0, (String)"onDrawFrame data is invalid");
        return 0;
    }

    public void B(float f10) {
        O0 = f10;
        this.m = true;
    }

    public int B1(byte[] byArray, int n10, int n11) {
        if (byArray != null && n10 > 0 && n11 > 0) {
            long l10;
            this.E1();
            int n12 = this.l;
            int n13 = this.x;
            int n14 = 1;
            if (n13 != n14) {
                n12 |= 0x20;
            }
            int n15 = n12;
            n12 = (int)(this.l0 ? 1 : 0);
            if (n12 != 0) {
                this.m0 = l10 = System.nanoTime();
            }
            int n16 = this.b;
            this.b = n12 = n16 + 1;
            int[] nArray = this.c;
            n14 = n10;
            int n17 = faceunity.fuRenderToRgbaImage(byArray, n10, n11, n16, nArray, n15);
            n10 = (int)(this.l0 ? 1 : 0);
            if (n10 != 0) {
                long l11 = this.k0;
                l10 = System.nanoTime();
                long l12 = this.m0;
                this.k0 = l11 += (l10 -= l12);
            }
            return n17;
        }
        Log.e((String)o0, (String)"onDrawFrame data null");
        return 0;
    }

    public void C(float f10) {
        P0 = f10;
        this.m = true;
    }

    public void C1() {
        b$k b$k;
        long l10;
        Log.e((String)o0, (String)"onSurfaceCreated");
        int n10 = 16;
        Object object = new ArrayList(n10);
        object = Collections.synchronizedList(object);
        this.I = object;
        this.J = l10 = Thread.currentThread().getId();
        object = new HandlerThread("FUItemWorker");
        object.start();
        object = object.getLooper();
        b$y b$y = new b$y(this, (Looper)object);
        this.d = b$y;
        int n11 = this.j;
        if (n11 != 0) {
            faceunity.fuCreateEGLContext();
        }
        n11 = 0;
        object = null;
        this.b = 0;
        int n12 = this.y;
        this.P1(n12);
        n12 = this.b1();
        faceunity.fuSetDefaultRotationMode(n12);
        this.M = n12;
        n12 = (int)(this.N ? 1 : 0);
        if (n12 != 0) {
            b$k = new b$k(this);
            b$y.post(b$k);
        }
        if ((n12 = (int)(this.e ? 1 : 0)) != 0) {
            b$y.sendEmptyMessage(0);
        }
        if ((n11 = this.f) != 0) {
            n11 = 4;
            b$y.sendEmptyMessage(n11);
        }
        if ((n11 = (int)(this.g ? 1 : 0)) != 0) {
            n11 = 3;
            b$y.sendEmptyMessage(n11);
        }
        if ((n11 = (int)(this.i ? 1 : 0)) != 0) {
            n11 = 10;
            b$y.sendEmptyMessage(n11);
        }
        if ((n11 = (int)(this.h ? 1 : 0)) != 0) {
            object = this.c;
            n10 = 5;
            b$k = this.a;
            String string2 = E0;
            n12 = d.v.b0.i.b.q1((Context)b$k, string2);
            object[n10] = (HandlerThread)n12;
        }
    }

    public void D(float f10) {
        f1 = f10;
        this.m = true;
    }

    public void D1() {
        long l10;
        Log.e((String)o0, (String)"onSurfaceDestroyed");
        Object object = this.d;
        int n10 = 0;
        int[] nArray = null;
        if (object != null) {
            object.removeCallbacksAndMessages(null);
            object = this.d.getLooper();
            object.quit();
            this.d = null;
        }
        if ((object = this.I) != null) {
            object.clear();
            this.I = null;
        }
        boolean bl2 = false;
        object = null;
        this.Y = 0;
        this.J = l10 = 0L;
        nArray = this.c;
        int n11 = nArray.length;
        int n12 = 2;
        if (n11 > n12 && (n10 = nArray[n11 = 5]) > 0) {
            faceunity.fuDeleteTexForItem(n10, "tex_input");
            String string2 = "tex_template";
            faceunity.fuDeleteTexForItem(n10, string2);
        }
        this.b = 0;
        n10 = 1;
        this.m = n10;
        this.J1();
        d.v.b0.i.b.I1();
        this.d1();
        for (int n13 : this.c) {
            if (n13 <= 0) continue;
            faceunity.fuDestroyItem(n13);
        }
        nArray = this.c;
        Arrays.fill(nArray, 0);
        faceunity.fuDestroyAllItems();
        faceunity.fuDone();
        faceunity.fuOnDeviceLost();
        bl2 = this.j;
        if (bl2) {
            faceunity.fuReleaseEGLContext();
        }
    }

    public void E(float f10) {
        i1 = f10;
        this.m = true;
    }

    public void F(String string2) {
    }

    public void F1(Runnable runnable) {
        long l10;
        Object object = Thread.currentThread();
        long l11 = ((Thread)object).getId();
        long l12 = l11 - (l10 = this.J);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            runnable.run();
        } else {
            object = this.I;
            if (object != null) {
                object.add(runnable);
            }
        }
    }

    public void G(float f10) {
        U0 = f10;
        this.m = true;
    }

    public void H(String string2, double[] dArray) {
        if (dArray == null) {
            return;
        }
        this.D.put(string2, dArray);
        b$f b$f = new b$f(this, string2, dArray);
        this.F1(b$f);
    }

    public void I(float f10) {
        T0 = f10;
        this.m = true;
    }

    public void J(long l10) {
        b$c b$c = new b$c(this, l10);
        this.F1(b$c);
    }

    public void K(float f10) {
        b$j b$j = new b$j(this, f10);
        this.F1(b$j);
    }

    public void L(float f10) {
        b$h b$h = new b$h(this, f10);
        this.F1(b$h);
    }

    public void L1(String string2) {
        Object object = this.c;
        b$q b$q = null;
        int n10 = object[0];
        if (n10 <= 0) {
            this.r1();
        }
        object = this.d;
        b$q = new b$q(this, string2);
        object.post((Runnable)b$q);
    }

    public void M(float f10) {
        V0 = f10;
        this.m = true;
    }

    public void M1(float f10) {
        b$p b$p = new b$p(this, f10);
        this.F1(b$p);
    }

    public void N(int n10, int n11, float f10) {
        int n12 = this.B;
        if (n12 == n10) {
            this.z(n11, f10);
        } else {
            this.B = n10;
            this.C = n11;
            this.A = f10;
            Handler handler = this.d;
            n11 = 4;
            handler.sendEmptyMessage(n11);
        }
    }

    public void N1(int n10) {
    }

    public void O(float f10) {
        j1 = f10;
        this.m = true;
    }

    public void O1(int n10) {
        Object object = o0;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setHumanTrackScene() called with: humanTrackScene = [");
        charSequence.append(n10);
        charSequence.append("]");
        charSequence = charSequence.toString();
        Log.d((String)object, (String)charSequence);
        this.c0 = n10;
        object = new b$r(this, n10);
        this.F1((Runnable)object);
    }

    public void P(boolean bl2) {
        b$d b$d;
        float f10;
        if (bl2) {
            int n10 = 1065353216;
            f10 = 1.0f;
        } else {
            boolean bl3 = false;
            f10 = 0.0f;
            b$d = null;
        }
        float f11 = N0;
        float f12 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1);
        if (f12 == false) {
            return;
        }
        N0 = f10;
        b$d = new b$d(this);
        this.F1(b$d);
    }

    public void P1(int n10) {
        if (n10 > 0) {
            this.y = n10;
            b$s b$s = new b$s(this, n10);
            this.F1(b$s);
        }
    }

    public void Q(float f10) {
        h1 = f10;
        this.m = true;
    }

    public void Q1(int n10) {
        if (n10 > 0) {
            this.z = n10;
            b$t b$t = new b$t(this, n10);
            this.F1(b$t);
        }
    }

    public void R(float f10) {
        b$i b$i = new b$i(this, f10);
        this.F1(b$i);
    }

    public void R1(int n10) {
        b$u b$u = new b$u(this, n10);
        this.F1(b$u);
    }

    public void S(Map map) {
    }

    public void S1(int n10) {
        int n11 = this.L;
        if (n11 != n10) {
            b$a b$a = new b$a(this, n10);
            this.F1(b$a);
        }
    }

    public void T(float f10) {
        R0 = f10;
        this.m = true;
    }

    public void T1(int n10, boolean bl2) {
        this.u = n10;
        this.w = bl2;
        b$b b$b = new b$b(this);
        this.F1(b$b);
    }

    public void U(float f10) {
        k1 = f10;
        this.m = true;
    }

    public int U1(byte[] byArray, int n10, int n11, int n12) {
        if (byArray != null && n10 > 0 && n11 > 0) {
            faceunity.fuOnCameraChange();
            int n13 = faceunity.fuGetCurrentRotationMode();
            faceunity.fuSetDefaultRotationMode(n12);
            for (int i10 = 0; i10 < (n12 = 50); ++i10) {
                n12 = 2;
                faceunity.fuTrackFace(byArray, n12, n10, n11);
            }
            faceunity.fuSetDefaultRotationMode(n13);
            return faceunity.fuIsTracking();
        }
        return 0;
    }

    public void V(float f10) {
        l1 = f10;
        this.m = true;
    }

    public void W(float f10) {
    }

    public void X(int n10, int n11, byte[] byArray, float[] object) {
        Object object2 = o0;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onPosterInputPhoto() called with: inputWidth = [");
        charSequence.append(n10);
        charSequence.append("], inputHeight = [");
        charSequence.append(n11);
        charSequence.append("], input = [");
        charSequence.append(byArray);
        charSequence.append("], landmark = [");
        String string2 = Arrays.toString(object);
        charSequence.append(string2);
        string2 = "]";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        Log.v((String)object2, (String)charSequence);
        object2 = this.c;
        int n12 = 5;
        Object object3 = object2[n12];
        if (object3 > 0) {
            object = this.g1((float[])object);
            double d10 = n10;
            faceunity.fuItemSetParam((int)object3, "input_width", d10);
            d10 = n11;
            String string3 = "input_height";
            faceunity.fuItemSetParam((int)object3, string3, d10);
            charSequence = "input_face_points";
            faceunity.fuItemSetParam((int)object3, (String)charSequence, object);
            object = "tex_input";
            faceunity.fuCreateTexForItem((int)object3, (String)object, byArray, n10, n11);
        }
    }

    public void Y(float f10) {
        e1 = f10;
        this.m = true;
    }

    public void Z(float f10) {
    }

    public void a(String string2, double d10) {
        Object object = this.D;
        Double d11 = d10;
        object.put(string2, d11);
        object = new b$e(this, string2, d10);
        this.F1((Runnable)object);
    }

    public void b(float f10) {
        b1 = f10;
        this.m = true;
    }

    public void c(float f10) {
    }

    public void c1() {
        b$v b$v = new b$v(this);
        this.F1(b$v);
    }

    public void d(float f10) {
        g1 = f10;
        this.m = true;
    }

    public void e(float f10) {
        S0 = f10;
        this.m = true;
    }

    public void f(float f10) {
    }

    public void f1(float f10) {
        b$o b$o = new b$o(this, f10);
        this.F1(b$o);
    }

    public void g(float f10) {
    }

    public void h(boolean bl2) {
        boolean bl3 = this.X;
        if (bl3 == bl2) {
            return;
        }
        b$n b$n = new b$n(this, bl2);
        this.F1(b$n);
    }

    public float[] h1(int n10, int n11) {
        int n12 = faceunity.fuGetCurrentRotationMode();
        faceunity.fuSetDefaultRotationMode(n11);
        float[] fArray = this.H;
        faceunity.fuGetFaceInfo(n10, "face_rect", fArray);
        faceunity.fuSetDefaultRotationMode(n12);
        return this.H;
    }

    public void i(int n10, int n11, byte[] byArray, float[] object) {
        Object object2 = o0;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onPosterTemplateSelected() called with: tempWidth = [");
        charSequence.append(n10);
        charSequence.append("], tempHeight = [");
        charSequence.append(n11);
        charSequence.append("], temp = [");
        charSequence.append(byArray);
        charSequence.append("], landmark = [");
        String string2 = Arrays.toString(object);
        charSequence.append(string2);
        string2 = "]";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        Log.v((String)object2, (String)charSequence);
        object2 = this.c;
        int n12 = 5;
        Object object3 = object2[n12];
        if (object3 > 0) {
            object = this.g1((float[])object);
            double d10 = n10;
            faceunity.fuItemSetParam((int)object3, "template_width", d10);
            d10 = n11;
            String string3 = "template_height";
            faceunity.fuItemSetParam((int)object3, string3, d10);
            charSequence = "template_face_points";
            faceunity.fuItemSetParam((int)object3, (String)charSequence, object);
            object = "tex_template";
            faceunity.fuCreateTexForItem((int)object3, (String)object, byArray, n10, n11);
        }
    }

    public void i1(int n10, float[] fArray) {
        int n11 = faceunity.fuIsTracking();
        if (n11 > 0) {
            String string2 = M0;
            faceunity.fuGetFaceInfo(n10, string2, fArray);
        }
    }

    public void j(String string2) {
    }

    public void k(float f10) {
        Y0 = f10;
        this.m = true;
    }

    public float[] k1() {
        Arrays.fill(this.G, 0.0f);
        float[] fArray = this.G;
        faceunity.fuGetFaceInfo(0, "rotation", fArray);
        return this.G;
    }

    public void l(float f10) {
        m1 = f10;
        this.m = true;
    }

    public int l1() {
        return faceunity.fuIsTracking();
    }

    public void m(float f10) {
        Z0 = f10;
        this.m = true;
    }

    public void n(float f10) {
        o1 = f10;
        this.m = true;
    }

    public void o(float f10) {
        d1 = f10 / 2.0f;
        this.m = true;
    }

    public void p(float f10) {
        c1 = f10 / 2.0f;
        this.m = true;
    }

    public void q(int n10) {
    }

    public void r(float f10) {
    }

    public void s(float f10) {
        Q0 = f10;
        this.m = true;
    }

    public void t(float f10) {
        q1 = f10;
        this.m = true;
    }

    public void t1(int n10, int n11) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onCameraChange. cameraFacing: ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(", inputOrientation:");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        Log.d((String)"ZL", (String)object);
        object = new b$w(this, n10, n11);
        this.F1((Runnable)object);
    }

    public void u(float f10) {
        p1 = f10;
        this.m = true;
    }

    public int u1(int n10, int n11, int n12) {
        if (n10 > 0 && n11 > 0 && n12 > 0) {
            long l10;
            this.E1();
            int n13 = this.k;
            int n14 = this.x;
            int n15 = 1;
            if (n14 != n15) {
                n13 |= 0x20;
            }
            int n16 = n13;
            n13 = (int)(this.l0 ? 1 : 0);
            if (n13 != 0) {
                this.m0 = l10 = System.nanoTime();
            }
            int n17 = this.b;
            this.b = n13 = n17 + 1;
            int[] nArray = this.c;
            n14 = n10;
            n15 = n11;
            n10 = faceunity.fuRenderToTexture(n10, n11, n12, n17, nArray, n16);
            n11 = (int)(this.l0 ? 1 : 0);
            if (n11 != 0) {
                long l11 = this.k0;
                l10 = System.nanoTime();
                long l12 = this.m0;
                this.k0 = l11 += (l10 -= l12);
            }
            return n10;
        }
        Log.e((String)o0, (String)"onDrawFrame data null");
        return 0;
    }

    public void v(float f10) {
        a1 = f10;
        this.m = true;
    }

    public int v1(byte[] byArray, int n10, int n11) {
        if (byArray != null && n10 > 0 && n11 > 0) {
            long l10;
            this.E1();
            int n12 = this.l;
            int n13 = this.x;
            int n14 = 1;
            if (n13 != n14) {
                n12 |= 0x20;
            }
            int n15 = n12;
            n12 = (int)(this.l0 ? 1 : 0);
            if (n12 != 0) {
                this.m0 = l10 = System.nanoTime();
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("\u5355\u5904\u7406 flag: ");
            charSequence.append(n15);
            charSequence.append(" mInputImageFormat:");
            n13 = this.l;
            charSequence.append(n13);
            charSequence = charSequence.toString();
            Log.e((String)"ZL", (String)charSequence);
            int n16 = this.b;
            this.b = n12 = n16 + 1;
            int[] nArray = this.c;
            n14 = n10;
            int n17 = faceunity.fuRenderToNV21Image(byArray, n10, n11, n16, nArray, n15);
            n10 = (int)(this.l0 ? 1 : 0);
            if (n10 != 0) {
                long l11 = this.k0;
                l10 = System.nanoTime();
                long l12 = this.m0;
                this.k0 = l11 += (l10 -= l12);
            }
            return n17;
        }
        Log.e((String)o0, (String)"onDrawFrame data null");
        return 0;
    }

    public void w(float f10) {
        n1 = f10;
        this.m = true;
    }

    public int w1(byte[] byArray, int n10, int n11, int n12) {
        if (n10 > 0 && byArray != null && n11 > 0 && n12 > 0) {
            long l10;
            this.E1();
            int n13 = this.k;
            int n14 = this.l;
            n13 |= n14;
            n14 = this.x;
            int n15 = 1;
            if (n14 != n15) {
                n13 |= 0x20;
            }
            int n16 = n13;
            n13 = (int)(this.l0 ? 1 : 0);
            if (n13 != 0) {
                this.m0 = l10 = System.nanoTime();
            }
            int n17 = this.b;
            this.b = n13 = n17 + 1;
            int[] nArray = this.c;
            n15 = n10;
            int n18 = faceunity.fuDualInputToTexture(byArray, n10, n16, n11, n12, n17, nArray);
            n10 = (int)(this.l0 ? 1 : 0);
            if (n10 != 0) {
                long l11 = this.k0;
                l10 = System.nanoTime();
                long l12 = this.m0;
                this.k0 = l11 += (l10 -= l12);
            }
            return n18;
        }
        Log.e((String)o0, (String)"onDrawFrame data null");
        return 0;
    }

    public void x(float f10) {
    }

    public int x1(byte[] byArray, int n10, int n11, int n12, byte[] byArray2, int n13, int n14) {
        b b10 = this;
        if (n10 > 0 && byArray != null && n11 > 0 && n12 > 0 && byArray2 != null && n13 > 0 && n14 > 0) {
            this.E1();
            int n15 = this.k;
            int n16 = this.l;
            n15 |= n16;
            n16 = this.x;
            int n17 = 1;
            if (n16 != n17) {
                n15 |= 0x20;
            }
            n17 = n15;
            n15 = (int)(b10.l0 ? 1 : 0);
            if (n15 != 0) {
                long l10;
                b10.m0 = l10 = System.nanoTime();
            }
            int n18 = b10.b;
            b10.b = n15 = n18 + 1;
            int[] nArray = b10.c;
            n16 = n10;
            n15 = faceunity.fuDualInputToTexture(byArray, n10, n17, n11, n12, n18, nArray, n13, n14, byArray2);
            n16 = (int)(b10.l0 ? 1 : 0);
            if (n16 != 0) {
                long l11 = b10.k0;
                long l12 = System.nanoTime();
                long l13 = b10.m0;
                b10.k0 = l11 += (l12 -= l13);
            }
            return n15;
        }
        Log.e((String)o0, (String)"onDrawFrame data null");
        return 0;
    }

    public void y(float f10, float f11, float f12, float f13) {
        b$m b$m = new b$m(this, f10, f11, f12, f13);
        this.F1(b$m);
    }

    public int y1(byte[] byArray, int n10, int n11, byte[] byArray2, int n12, int n13) {
        b b10 = this;
        if (byArray != null && n10 > 0 && n11 > 0 && byArray2 != null && n12 > 0 && n13 > 0) {
            this.E1();
            int n14 = this.l;
            int n15 = this.x;
            int n16 = 1;
            if (n15 != n16) {
                n14 |= 0x20;
            }
            int n17 = n14;
            n14 = (int)(b10.l0 ? 1 : 0);
            if (n14 != 0) {
                long l10;
                b10.m0 = l10 = System.nanoTime();
            }
            int n18 = b10.b;
            b10.b = n14 = n18 + 1;
            int[] nArray = b10.c;
            n15 = n10;
            n16 = n11;
            n14 = faceunity.fuRenderToNV21Image(byArray, n10, n11, n18, nArray, n17, n12, n13, byArray2);
            n15 = (int)(b10.l0 ? 1 : 0);
            if (n15 != 0) {
                long l11 = b10.k0;
                long l12 = System.nanoTime();
                long l13 = b10.m0;
                b10.k0 = l11 += (l12 -= l13);
            }
            return n14;
        }
        Log.e((String)o0, (String)"onDrawFrame data null");
        return 0;
    }

    public void z(int n10, float f10) {
    }

    public int z1(int n10, int n11, int n12) {
        if (n10 > 0 && n11 > 0 && n12 > 0) {
            long l10;
            this.E1();
            int n13 = this.k;
            int n14 = this.l0;
            if (n14 != 0) {
                this.m0 = l10 = System.nanoTime();
            }
            int n15 = this.b;
            this.b = n14 = n15 + 1;
            int[] nArray = this.c;
            n14 = n10;
            n10 = faceunity.fuBeautifyImage(n10, n13, n11, n12, n15, nArray);
            n11 = (int)(this.l0 ? 1 : 0);
            if (n11 != 0) {
                long l11 = this.k0;
                long l12 = System.nanoTime();
                l10 = this.m0;
                this.k0 = l11 += (l12 -= l10);
            }
            return n10;
        }
        Log.e((String)o0, (String)"onDrawFrame data null");
        return 0;
    }
}

