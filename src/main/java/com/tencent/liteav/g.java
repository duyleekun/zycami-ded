/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  org.json.JSONArray
 */
package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.g$1;
import com.tencent.liteav.g$a;
import org.json.JSONArray;

public class g
implements Cloneable {
    public Bitmap A;
    public int B;
    public int C;
    public int D;
    public Bitmap E;
    public int F;
    public int G;
    public float H;
    public float I;
    public float J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public int X;
    public JSONArray Y;
    public int a = 0;
    public int b = 0;
    public int c = 1200;
    public int d = 1500;
    public int e = 800;
    public int f = 5;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public c k;
    public int l;
    public boolean m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public int y;
    public boolean z;

    public g() {
        int n10;
        c c10;
        boolean bl2;
        this.g = bl2 = true;
        this.h = 20;
        this.i = (int)(bl2 ? 1 : 0);
        this.j = 2;
        this.k = c10 = com.tencent.liteav.basic.a.c.c;
        this.l = (int)(bl2 ? 1 : 0);
        this.m = bl2;
        this.n = n10 = 3;
        this.o = 0;
        this.p = false;
        this.q = n10;
        this.r = n10;
        this.s = 48000;
        this.t = (int)(bl2 ? 1 : 0);
        this.u = bl2;
        this.v = false;
        this.w = false;
        this.x = 0;
        this.y = n10 = 10;
        this.z = false;
        this.A = null;
        this.B = 300;
        this.C = n10;
        this.D = (int)(bl2 ? 1 : 0);
        this.E = null;
        this.F = 0;
        this.G = 0;
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = -1.0f;
        this.K = bl2;
        this.L = false;
        this.M = false;
        this.N = bl2;
        this.O = (int)(bl2 ? 1 : 0);
        this.P = false;
        this.Q = false;
        this.R = 0;
        this.S = false;
        this.T = bl2;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = 0;
        this.Y = null;
    }

    public static g$a a(c c10) {
        g$a g$a = new g$a();
        int[] nArray = g$1.a;
        int n10 = c10.ordinal();
        n10 = nArray[n10];
        int n11 = 1920;
        int n12 = 1088;
        int n13 = 240;
        int n14 = 192;
        int n15 = 1280;
        int n16 = 720;
        int n17 = 960;
        int n18 = 544;
        int n19 = 272;
        int n20 = 320;
        int n21 = 640;
        int n22 = 368;
        int n23 = 480;
        switch (n10) {
            default: {
                g$a.a = n22;
                g$a.b = n21;
                break;
            }
            case 23: {
                g$a.a = n11;
                g$a.b = n12;
                break;
            }
            case 22: {
                g$a.a = n12;
                g$a.b = n11;
                break;
            }
            case 21: {
                g$a.a = n10 = 128;
                g$a.b = n10;
                break;
            }
            case 20: {
                g$a.a = n20;
                g$a.b = n14;
                break;
            }
            case 19: {
                g$a.a = n23;
                g$a.b = n19;
                break;
            }
            case 18: {
                g$a.a = n20;
                g$a.b = n13;
                break;
            }
            case 17: {
                g$a.a = n23;
                g$a.b = n22;
                break;
            }
            case 16: {
                g$a.a = n21;
                g$a.b = n23;
                break;
            }
            case 15: {
                g$a.a = n15;
                g$a.b = n16;
                break;
            }
            case 14: {
                g$a.a = n17;
                g$a.b = n18;
                break;
            }
            case 13: {
                g$a.a = n21;
                g$a.b = n22;
                break;
            }
            case 12: {
                g$a.a = n10 = 160;
                g$a.b = n10;
                break;
            }
            case 11: {
                g$a.a = n19;
                g$a.b = n19;
                break;
            }
            case 10: {
                g$a.a = n23;
                g$a.b = n23;
                break;
            }
            case 9: {
                g$a.a = n23;
                g$a.b = n21;
                break;
            }
            case 8: {
                g$a.a = n22;
                g$a.b = n23;
                break;
            }
            case 7: {
                g$a.a = n13;
                g$a.b = n20;
                break;
            }
            case 6: {
                g$a.a = n19;
                g$a.b = n23;
                break;
            }
            case 5: {
                g$a.a = n14;
                g$a.b = n20;
                break;
            }
            case 4: {
                g$a.a = n20;
                g$a.b = n23;
                break;
            }
            case 3: {
                g$a.a = n16;
                g$a.b = n15;
                break;
            }
            case 2: {
                g$a.a = n18;
                g$a.b = n17;
                break;
            }
            case 1: {
                g$a.a = n22;
                g$a.b = n21;
            }
        }
        return g$a;
    }

    public boolean a() {
        int n10;
        int n11;
        Object object = this.k;
        c c10 = com.tencent.liteav.basic.a.c.a;
        if (object != c10) {
            object = com.tencent.liteav.g.a(object);
            this.a = n11 = ((g$a)object).a;
            this.b = n10 = ((g$a)object).b;
        }
        if ((n10 = this.a) > (n11 = this.b)) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public Object clone() {
        return (g)super.clone();
    }
}

