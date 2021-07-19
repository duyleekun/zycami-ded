/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 */
package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.liteav.basic.license.e;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.b$a;
import com.tencent.liteav.beauty.d;

public class b
implements TXBeautyManager {
    private e a;
    private d b;
    private int c;
    private b$a d;
    private boolean e;

    public b(e object) {
        boolean bl2;
        this.e = bl2 = true;
        this.a = object;
        this.d = object = new b$a(this);
        this.enableSharpnessEnhancement(bl2);
        this.setFilterStrength(0.5f);
    }

    private int a(float f10, int n10) {
        float f11 = n10;
        return Math.round(f10 * f11);
    }

    private void a() {
        String string2 = "applyBeautyParams";
        TXCLog.d("TXBeautyManager", string2);
        Object object = this.b;
        int n10 = this.c;
        ((d)object).b(n10);
        boolean bl2 = this.e;
        this.b(bl2);
        object = this.a;
        bl2 = object.a();
        if (bl2) {
            object = this.b;
            n10 = this.d.e;
            ((d)object).g(n10);
            object = this.b;
            n10 = this.d.f;
            ((d)object).h(n10);
            object = this.b;
            n10 = this.d.g;
            ((d)object).i(n10);
            object = this.b;
            n10 = this.d.h;
            ((d)object).k(n10);
            object = this.b;
            n10 = this.d.i;
            ((d)object).j(n10);
            object = this.b;
            n10 = this.d.j;
            ((d)object).l(n10);
            object = this.b;
            n10 = this.d.k;
            ((d)object).m(n10);
            object = this.b;
            n10 = this.d.l;
            ((d)object).n(n10);
            object = this.b;
            n10 = this.d.m;
            ((d)object).o(n10);
            object = this.b;
            n10 = this.d.n;
            ((d)object).p(n10);
            object = this.b;
            n10 = this.d.o;
            ((d)object).q(n10);
            object = this.b;
            n10 = this.d.p;
            ((d)object).r(n10);
            object = this.b;
            n10 = this.d.q;
            ((d)object).s(n10);
            object = this.b;
            n10 = this.d.r;
            ((d)object).t(n10);
            object = this.b;
            n10 = this.d.s;
            ((d)object).u(n10);
            object = this.b;
            n10 = this.d.t;
            ((d)object).v(n10);
            object = this.b;
            n10 = this.d.u;
            ((d)object).w(n10);
            object = this.b;
            n10 = this.d.v;
            ((d)object).x(n10);
            object = this.b;
            n10 = this.d.w;
            ((d)object).y(n10);
            object = this.b;
            string2 = this.d.B;
            boolean bl3 = true;
            ((d)object).a(string2, bl3);
        }
        object = this.b;
        string2 = this.d.z;
        ((d)object).a((Bitmap)string2);
        object = this.b;
        float f10 = this.d.A;
        ((d)object).a(f10);
        object = this.b;
        string2 = this.d.x;
        ((d)object).a(string2);
        object = this.b;
        n10 = (int)(this.d.y ? 1 : 0);
        ((d)object).c(n10 != 0);
    }

    private void b(boolean bl2) {
        if (bl2) {
            d d10 = this.b;
            int n10 = this.d.a;
            d10.c(n10);
            d10 = this.b;
            n10 = this.d.b;
            d10.d(n10);
            d10 = this.b;
            n10 = this.d.c;
            d10.e(n10);
            d10 = this.b;
            b$a b$a = this.d;
            n10 = b$a.d;
            d10.f(n10);
        } else {
            d d11 = this.b;
            boolean bl3 = false;
            Object var4_7 = null;
            d11.c(0);
            this.b.d(0);
            this.b.e(0);
            d11 = this.b;
            d11.f(0);
        }
    }

    public void a(boolean bl2) {
        this.e = bl2;
        this.b(bl2);
    }

    public void enableSharpnessEnhancement(boolean bl2) {
        int n10 = 1;
        Object object = new Object[n10];
        Object object2 = bl2;
        int n11 = 0;
        object[0] = object2;
        object2 = "TXBeautyManager";
        String string2 = "enableSharpnessEnhancement enable: %b";
        TXCLog.d((String)object2, string2, object);
        object = this.d;
        if (bl2) {
            n11 = 4;
        }
        object.d = n11;
        d d10 = this.b;
        if (d10 != null && (n10 = (int)(this.e ? 1 : 0)) != 0) {
            d10.f(n11);
        }
    }

    public void setBeautyLevel(float f10) {
        boolean bl2;
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setBeautyLevel beautyLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.d;
        ((b$a)object).a = n10 = (int)f10;
        object = this.b;
        if (object != null && (bl2 = this.e)) {
            ((d)object).c(n10);
        }
    }

    public void setBeautyStyle(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setBeautyStyle beautyStyle:");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        this.c = n10;
        object = this.b;
        if (object != null) {
            ((d)object).b(n10);
        }
    }

    public void setChinLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setChinLevel chinLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 15;
        ((b$a)object).h = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).h;
            d10.k(n11);
        }
    }

    public void setEyeAngleLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setEyeAngleLevel eyeAngleLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).r = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).r;
            d10.t(n11);
        }
    }

    public void setEyeDistanceLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setEyeDistanceLevel eyeDistanceLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).q = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).q;
            d10.s(n11);
        }
    }

    public void setEyeLightenLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setEyeLightenLevel eyeLightenLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).k = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).k;
            d10.m(n11);
        }
    }

    public void setEyeScaleLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setEyeScaleLevel eyeScaleLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 15;
        ((b$a)object).e = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).e;
            d10.g(n11);
        }
    }

    public void setFaceBeautyLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setFaceBeautyLevel faceBeautyLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).w = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).w;
            d10.y(n11);
        }
    }

    public void setFaceShortLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setFaceShortLevel faceShortLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 15;
        ((b$a)object).i = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).i;
            d10.j(n11);
        }
    }

    public void setFaceSlimLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setFaceSlimLevel faceSlimLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 15;
        ((b$a)object).f = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).f;
            d10.h(n11);
        }
    }

    public void setFaceVLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setFaceVLevel faceVLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 15;
        ((b$a)object).g = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).g;
            d10.i(n11);
        }
    }

    public void setFilter(Bitmap bitmap) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setFilter image:");
        ((StringBuilder)object).append(bitmap);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        this.d.z = bitmap;
        object = this.b;
        if (object != null) {
            ((d)object).a(bitmap);
        }
    }

    public void setFilterStrength(float f10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setFilterStrength strength:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        this.d.A = f10;
        object = this.b;
        if (object != null) {
            ((d)object).a(f10);
        }
    }

    public void setForeheadLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setForeheadLevel foreheadLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).p = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).p;
            d10.r(n11);
        }
    }

    public void setGreenScreenFile(String string2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setGreenScreenFile path:");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        String string3 = "TXBeautyManager";
        TXCLog.d(string3, (String)object);
        object = this.d;
        ((b$a)object).B = string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) {
            TXCLog.e(string3, "setGreenScreenFile system version below 18");
            return;
        }
        object = this.a;
        n10 = (int)(object.a() ? 1 : 0);
        if (n10 == 0) {
            TXCLog.e(string3, "setGreenScreenFile is only supported in EnterprisePro license");
            return;
        }
        object = this.b;
        if (object != null) {
            boolean bl2 = true;
            ((d)object).a(string2, bl2);
        }
    }

    public void setLipsThicknessLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setLipsThicknessLevel lipsThicknessLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).v = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).v;
            d10.x(n11);
        }
    }

    public void setMotionMute(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setMotionMute motionMute:");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        this.d.y = bl2;
        object = this.b;
        if (object != null) {
            ((d)object).c(bl2);
        }
    }

    public void setMotionTmpl(String string2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setMotionTmpl tmplPath:");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        String string3 = "TXBeautyManager";
        TXCLog.d(string3, (String)object);
        this.d.x = string2;
        object = this.b;
        if (object != null) {
            ((d)object).a(string2);
        }
    }

    public void setMouthShapeLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setMouthShapeLevel mouthShapeLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).s = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).s;
            d10.u(n11);
        }
    }

    public void setNosePositionLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setNosePositionLevel nosePositionLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).u = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).u;
            d10.w(n11);
        }
    }

    public void setNoseSlimLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setNoseSlimLevel noseSlimLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 15;
        ((b$a)object).j = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).j;
            d10.l(n11);
        }
    }

    public void setNoseWingLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setNoseWingLevel noseWingLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).t = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).t;
            d10.v(n11);
        }
    }

    public void setPounchRemoveLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setPounchRemoveLevel pounchRemoveLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).n = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).n;
            d10.p(n11);
        }
    }

    public void setPreprocessor(d d10) {
        this.b = d10;
        if (d10 != null) {
            this.a();
        }
    }

    public void setRuddyLevel(float f10) {
        boolean bl2;
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setRuddyLevel ruddyLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.d;
        ((b$a)object).c = n10 = (int)f10;
        object = this.b;
        if (object != null && (bl2 = this.e)) {
            ((d)object).e(n10);
        }
    }

    public void setSmileLinesRemoveLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setSmileLinesRemoveLevel smileLinesRemoveLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).o = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).o;
            d10.q(n11);
        }
    }

    public void setToothWhitenLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setToothWhitenLevel toothWhitenLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).l = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).l;
            d10.n(n11);
        }
    }

    public void setWhitenessLevel(float f10) {
        boolean bl2;
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setWhitenessLevel whitenessLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.d;
        ((b$a)object).b = n10 = (int)f10;
        object = this.b;
        if (object != null && (bl2 = this.e)) {
            ((d)object).d(n10);
        }
    }

    public void setWrinkleRemoveLevel(float f10) {
        int n10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setWrinkleRemoveLevel wrinkleRemoveLevel:");
        ((StringBuilder)object).append(f10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXBeautyManager";
        TXCLog.d(string2, (String)object);
        object = this.a;
        int n11 = object.a();
        if (n11 == 0) {
            TXCLog.i(string2, "support EnterPrise above!!!");
            return;
        }
        object = this.d;
        int n12 = 10;
        ((b$a)object).m = n10 = this.a(f10, n12);
        d d10 = this.b;
        if (d10 != null) {
            object = this.d;
            n11 = ((b$a)object).m;
            d10.o(n11);
        }
    }
}

