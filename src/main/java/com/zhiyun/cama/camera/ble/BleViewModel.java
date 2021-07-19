/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.RectF
 */
package com.zhiyun.cama.camera.ble;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.camera.StackLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel$PanoramaState;
import com.zhiyun.cama.camera.ble.BleViewModel$a;
import com.zhiyun.cama.camera.ble.BleViewModel$b;
import com.zhiyun.cama.camera.ble.BleViewModel$c;
import com.zhiyun.cama.camera.ble.BleViewModel$d;
import com.zhiyun.cama.camera.ble.BleViewModel$e;
import com.zhiyun.cama.camera.ble.BleViewModel$f;
import com.zhiyun.cama.camera.ble.BleViewModel$g;
import com.zhiyun.cama.camera.ble.BleViewModel$h;
import com.zhiyun.cama.camera.ble.BleViewModel$i;
import com.zhiyun.cama.camera.ble.BleViewModel$j;
import com.zhiyun.cama.camera.ble.BleViewModel$k;
import com.zhiyun.cama.camera.ble.BleViewModel$l;
import com.zhiyun.cama.camera.ble.BleViewModel$m;
import com.zhiyun.cama.camera.ble.BleViewModel$n;
import com.zhiyun.cama.camera.ble.BleViewModel$o;
import com.zhiyun.cama.camera.ble.BleViewModel$p;
import com.zhiyun.cama.camera.ble.BleViewModel$q;
import com.zhiyun.cama.camera.ble.BleViewModel$r;
import com.zhiyun.cama.camera.ble.BleViewModel$t;
import com.zhiyun.cama.camera.ble.BleViewModel$u;
import com.zhiyun.cama.camera.data.CameraSet$Theme;
import com.zhiyun.protocol.constants.JoystickSpeed;
import com.zhiyun.protocol.constants.KeyRedefine;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.constants.SceneMode;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.protocol.core.entities.MoveLimit;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import com.zhiyun.stabilizer.Stabilizer;
import com.zhiyun.stabilizer.Stabilizer$g;
import com.zhiyun.stabilizer.Stabilizer$j;
import com.zhiyun.stabilizer.Stabilizer$k;
import com.zhiyun.stabilizer.entities.StoryAxis;
import d.v.c.i1.s2.q;
import d.v.c.s0.y6.a0;
import d.v.c.s0.y6.a1;
import d.v.c.s0.y6.b0;
import d.v.c.s0.y6.b1;
import d.v.c.s0.y6.c0;
import d.v.c.s0.y6.c1;
import d.v.c.s0.y6.d;
import d.v.c.s0.y6.d0;
import d.v.c.s0.y6.d1;
import d.v.c.s0.y6.e1;
import d.v.c.s0.y6.f;
import d.v.c.s0.y6.f0;
import d.v.c.s0.y6.f1;
import d.v.c.s0.y6.g0;
import d.v.c.s0.y6.h;
import d.v.c.s0.y6.h0;
import d.v.c.s0.y6.i0;
import d.v.c.s0.y6.j0;
import d.v.c.s0.y6.k;
import d.v.c.s0.y6.k0;
import d.v.c.s0.y6.l;
import d.v.c.s0.y6.l0;
import d.v.c.s0.y6.m;
import d.v.c.s0.y6.m0;
import d.v.c.s0.y6.n0;
import d.v.c.s0.y6.o0;
import d.v.c.s0.y6.p;
import d.v.c.s0.y6.p0;
import d.v.c.s0.y6.q0;
import d.v.c.s0.y6.r;
import d.v.c.s0.y6.r0;
import d.v.c.s0.y6.s;
import d.v.c.s0.y6.s0;
import d.v.c.s0.y6.t;
import d.v.c.s0.y6.t0;
import d.v.c.s0.y6.u;
import d.v.c.s0.y6.u0;
import d.v.c.s0.y6.v;
import d.v.c.s0.y6.v0;
import d.v.c.s0.y6.w;
import d.v.c.s0.y6.w0;
import d.v.c.s0.y6.x;
import d.v.c.s0.y6.x0;
import d.v.c.s0.y6.y;
import d.v.c.s0.y6.y0;
import d.v.c.s0.y6.z0;
import d.v.c.s0.z6.c;
import d.v.c.v0.u.z;
import d.v.e.h.a;
import d.v.e.i.e;
import d.v.e.i.j;
import d.v.e0.ae;
import d.v.e0.ce;
import d.v.e0.ke.b;
import d.v.e0.oe.n;
import d.v.e0.yd;
import d.v.y.d.i;
import e.a.e0;
import e.a.v0.g;
import e.a.v0.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class BleViewModel
extends ViewModel {
    public static final int U = 0;
    public static final int V = 1;
    public static final int W = 2;
    public static final int X = 3;
    public final MutableLiveData A;
    public final MutableLiveData B;
    private final e.a.s0.a C;
    public final j D;
    public final MutableLiveData E;
    public final MutableLiveData F;
    public final MutableLiveData G;
    public final MutableLiveData H;
    public final MutableLiveData I;
    public final MutableLiveData J;
    public final MutableLiveData K;
    public final LiveData L;
    public final LiveData M;
    public final LiveData N;
    public final LiveData O;
    public final LiveData P;
    private boolean Q;
    private final f1 R;
    private final d1 S;
    private final e1 T;
    public final MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MutableLiveData d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final MutableLiveData h;
    public final MutableLiveData i;
    public final MutableLiveData j;
    public final StackLiveData k;
    public final MutableLiveData l;
    public final StackLiveData m;
    public final MutableLiveData n;
    public final MutableLiveData o;
    public final MutableLiveData p;
    public final MutableLiveData q;
    public final MutableLiveData r;
    public final MutableLiveData s;
    public final MutableLiveData t;
    public final LiveData u;
    public final LiveData v;
    private final c w;
    public final MutableLiveData x;
    private final LinkedList y;
    public final MutableLiveData z;

    public BleViewModel() {
        LiveData liveData;
        MutableLiveData mutableLiveData;
        Object object = new MutableLiveData();
        this.a = object;
        object = new MutableLiveData();
        this.b = object;
        object = new MutableLiveData();
        this.c = object;
        object = new MutableLiveData();
        this.d = object;
        object = new MutableLiveData();
        this.e = object;
        object = new MutableLiveData();
        this.f = object;
        object = new MutableLiveData();
        this.g = object;
        object = new MutableLiveData();
        this.h = object;
        object = new MutableLiveData();
        this.i = object;
        object = new MutableLiveData();
        this.j = object;
        this.k = object;
        object = new MutableLiveData();
        this.l = object;
        super();
        this.m = object;
        object = new MutableLiveData();
        this.n = object;
        object = new MutableLiveData();
        this.o = object;
        object = new MutableLiveData();
        this.p = object;
        object = new MutableLiveData();
        this.q = object;
        object = new MutableLiveData();
        this.r = object;
        this.s = mutableLiveData = new MutableLiveData();
        Object object2 = new MutableLiveData();
        this.t = object2;
        this.w = object2 = new c();
        this.x = object2 = ((c)object2).b;
        object2 = new LinkedList();
        this.y = object2;
        this.z = object2 = new MutableLiveData();
        this.A = object2 = new MutableLiveData();
        Comparable<Boolean> comparable = Boolean.FALSE;
        this.B = object2 = new MutableLiveData(comparable);
        this.C = object2 = new e.a.s0.a();
        this.D = object2 = new j();
        this.E = object2 = new MutableLiveData();
        this.F = object2 = new MutableLiveData();
        this.G = object2 = new MutableLiveData();
        this.H = object2 = new MutableLiveData();
        this.I = object2 = new MutableLiveData();
        this.J = object2 = new MutableLiveData();
        this.K = object2 = new MutableLiveData();
        comparable = 0;
        this.Q = false;
        this.R = object2 = new f1();
        this.S = object2 = new d1();
        Object object3 = new e1();
        this.T = object3;
        this.L = liveData = ((d1)object2).k();
        this.N = liveData = ((d1)object2).l();
        this.O = liveData = ((e1)object3).d();
        this.P = object3 = ((e1)object3).e();
        this.M = object3 = ((d1)object2).m();
        object3 = BleViewModel$PanoramaState.CANCEL;
        ((MutableLiveData)object).setValue(object3);
        object = Pair.create(comparable, comparable);
        mutableLiveData.setValue(object);
        this.u = object = d.v.c.i1.s2.q.h().g();
        this.v = object = d.v.c.i1.s2.q.h().j();
        ce.E0().w((d.v.e0.ie.b)object2);
    }

    public static /* synthetic */ void A0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "setHorizontalReverse", objectArray);
    }

    public static /* synthetic */ e0 B0(JoystickSpeed joystickSpeed, Stabilizer stabilizer) {
        return stabilizer.l7(joystickSpeed);
    }

    private /* synthetic */ void C0(JoystickSpeed objectArray, Boolean bl2) {
        this.c.postValue(objectArray);
        objectArray = new Object[]{bl2};
        m.a.a.i("setJoystickSpeed: %s", objectArray);
    }

    public static /* synthetic */ void E0(JoystickSpeed joystickSpeed, Throwable throwable) {
        Object[] objectArray = new Object[]{joystickSpeed};
        m.a.a.z(throwable, "setJoystickSpeed %s", objectArray);
    }

    private /* synthetic */ e.a.g F0(KeyFunc keyFunc, Stabilizer stabilizer) {
        return this.l1(stabilizer, keyFunc);
    }

    public static /* synthetic */ void H0(KeyFunc keyFunc) {
        Object[] objectArray = new Object[]{keyFunc};
        m.a.a.i("setMKeyFunction: %s", objectArray);
    }

    public static /* synthetic */ void I0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "setMKeyFunction", objectArray);
    }

    public static /* synthetic */ e0 J0(SceneMode sceneMode, Stabilizer stabilizer) {
        return stabilizer.z7(sceneMode);
    }

    private /* synthetic */ void K0(SceneMode sceneMode, Boolean objectArray) {
        this.a.postValue((Object)sceneMode);
        objectArray = new Object[]{sceneMode};
        m.a.a.i("setSceneMode: %s", objectArray);
    }

    private /* synthetic */ void M(yd object) {
        int n10;
        int n11;
        Object object2 = this.w.c();
        if (object2 != null && (n11 = d.v.e0.oe.n.c((yd)(object2 = this.w.c()), (yd)object)) <= (n10 = 5)) {
            object = this.D;
            n11 = 2131951787;
            object2 = n11;
            ((j)object).setValue(object2);
        } else {
            object2 = this.w;
            ((c)object2).a((yd)object);
        }
    }

    public static /* synthetic */ void M0(SceneMode sceneMode, Throwable throwable) {
        Object[] objectArray = new Object[]{sceneMode};
        m.a.a.z(throwable, "setSceneMode: %s", objectArray);
    }

    public static /* synthetic */ e0 N0(boolean bl2, Stabilizer stabilizer) {
        return stabilizer.F7(bl2);
    }

    public static /* synthetic */ void O0(boolean bl2, Boolean objectArray) {
        objectArray = new Object[1];
        Boolean bl3 = bl2;
        objectArray[0] = bl3;
        m.a.a.i("setShotOrientation: %b", objectArray);
    }

    public static /* synthetic */ void P(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "addTimelapseTrack", objectArray);
    }

    public static /* synthetic */ void P0(boolean bl2, Throwable throwable) {
        Object[] objectArray = new Object[1];
        Boolean bl3 = bl2;
        objectArray[0] = bl3;
        m.a.a.z(throwable, "setShotOrientation: %b", objectArray);
    }

    private /* synthetic */ void Q(Boolean bl2) {
        Object[] objectArray = new Object[]{bl2};
        m.a.a.i("getDemoMode: %b", objectArray);
        this.B.postValue(bl2);
    }

    public static /* synthetic */ e.a.z Q0(boolean bl2, Stabilizer stabilizer, ae ae2) {
        i i10 = stabilizer.J2().pitch;
        boolean bl3 = BleViewModel.f(i10);
        if (bl3) {
            ae2.g(bl2);
        } else {
            ae2.i(bl2);
        }
        return stabilizer.x1(ae2);
    }

    public static /* synthetic */ e0 R0(e.a.z z10) {
        return z10;
    }

    public static /* synthetic */ void S(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "getDemoMode", objectArray);
    }

    private /* synthetic */ void S0(boolean bl2, Boolean object) {
        object = new Object[1];
        Boolean bl3 = bl2;
        object[0] = bl3;
        m.a.a.i("setVerticalReverse: %s", (Object[])object);
        object = this.d;
        Boolean bl4 = bl2;
        ((MutableLiveData)object).postValue(bl4);
    }

    private /* synthetic */ void T(JoystickSpeed joystickSpeed) {
        this.c.postValue((Object)joystickSpeed);
        Object[] objectArray = new Object[]{joystickSpeed};
        m.a.a.i("getJoystickSpeed: %s", objectArray);
    }

    public static /* synthetic */ void U0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "setVerticalReverse", objectArray);
    }

    public static /* synthetic */ void V(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "getJoystickSpeed", objectArray);
    }

    public static /* synthetic */ e0 V0(WorkingMode workingMode, Stabilizer stabilizer) {
        return stabilizer.j0(workingMode);
    }

    private /* synthetic */ void W(Pair object) {
        KeyFunc keyFunc = (KeyFunc)((Object)((Pair)object).first);
        object = Arrays.toString((Object[])((Pair)object).second);
        int n10 = 2;
        Object[] objectArray = new Object[n10];
        objectArray[0] = keyFunc;
        int n11 = 1;
        objectArray[n11] = object;
        m.a.a.i("custom menu: cur=%s, funcs=%s", objectArray);
        object = KeyFunc.APP_TRACKING;
        if (keyFunc == object) {
            keyFunc = KeyFunc.DEFAULT;
        }
        this.g.postValue((Object)keyFunc);
    }

    private /* synthetic */ void W0(WorkingMode workingMode, Boolean objectArray) {
        objectArray = new Object[]{workingMode};
        m.a.a.i("setWorkingMode %s", objectArray);
        this.b.postValue((Object)workingMode);
    }

    public static /* synthetic */ void Y(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "getMKeyRedefine", objectArray);
    }

    public static /* synthetic */ void Y0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "setWorkingMode", objectArray);
    }

    private /* synthetic */ void Z(yd yd2) {
        Object[] objectArray = new Object[]{yd2};
        m.a.a.i("getPoint: %s", objectArray);
        this.o.postValue(yd2);
    }

    public static /* synthetic */ KeyFunc b(BleViewModel bleViewModel, LiveData liveData, KeyFunc keyFunc) {
        return bleViewModel.e1(liveData, keyFunc);
    }

    public static /* synthetic */ void b0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "getPoint", objectArray);
    }

    private /* synthetic */ void c0(ae object) {
        Object object2 = ((ae)object).toString();
        Object object3 = new Object[]{object2};
        m.a.a.i("getReverse: %s", (Object[])object3);
        object3 = this.e;
        object2 = ((ae)object).f();
        ((MutableLiveData)object3).postValue(object2);
        object3 = this.d;
        object2 = ((ae)object).e();
        ((MutableLiveData)object3).postValue(object2);
        object3 = this.f;
        object = ((ae)object).d();
        ((MutableLiveData)object3).postValue(object);
    }

    public static /* synthetic */ void e0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "getReverse", objectArray);
    }

    private KeyFunc e1(LiveData object, KeyFunc object2) {
        Object object3 = Boolean.TRUE;
        object = Optional.ofNullable(((LiveData)object).getValue());
        KeyFunc keyFunc = KeyFunc.DEFAULT;
        if ((object = ((Optional)object).orElse(keyFunc)) != keyFunc) {
            object2 = object;
        }
        Object object4 = this.J();
        if (object4 != 0) {
            object = BleViewModel$h.a;
            int n10 = ((Enum)object2).ordinal();
            object4 = object[n10];
            if (object4 != (n10 = 1)) {
                n10 = 2;
                if (object4 != n10) {
                    n10 = 3;
                    if (object4 == n10) {
                        object = this.h;
                        ((MutableLiveData)object).postValue(object3);
                    }
                } else {
                    object = this.k;
                    object3 = d.v.e.i.e.a(object3);
                    ((MutableLiveData)object).postValue(object3);
                }
            } else {
                object = this.l;
                ((MutableLiveData)object).postValue(object3);
            }
        }
        return object2;
    }

    private static boolean f(i object) {
        int n10;
        Integer n11;
        int n12;
        if (object != null && (n12 = (n11 = (Integer)((i)object).i()).intValue()) > (n10 = ((Integer)(object = (Integer)((i)object).h())).intValue())) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    private /* synthetic */ void f0(SceneMode sceneMode) {
        this.a.postValue((Object)sceneMode);
        Object[] objectArray = new Object[]{sceneMode};
        m.a.a.i("getSceneMode: %s", objectArray);
    }

    public static /* synthetic */ void h0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "getSceneMode", objectArray);
    }

    private /* synthetic */ void i0(WorkingMode workingMode) {
        Object[] objectArray = new Object[]{workingMode};
        m.a.a.i("getWorkingMode: %s", objectArray);
        this.b.postValue((Object)workingMode);
    }

    public static /* synthetic */ void k0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "getWorkingMode", objectArray);
    }

    public static /* synthetic */ e0 l0(boolean bl2, Stabilizer stabilizer) {
        return stabilizer.X6(bl2);
    }

    private e.a.a l1(Stabilizer stabilizer, KeyFunc keyFunc) {
        Object object = stabilizer.z2();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return e.a.a.y();
        }
        object = (KeyRedefine)object.get(0);
        int n10 = ((KeyRedefine)object).getKeyGroup();
        int n11 = ((KeyRedefine)object).getKeyValue();
        int n12 = ((KeyRedefine)object).getKeyEvents()[0];
        return stabilizer.m7(n10, n11, n12, keyFunc).k3();
    }

    private /* synthetic */ void m0(boolean bl2, Boolean object) {
        Object object2 = bl2;
        object = new Object[]{object2};
        m.a.a.i("quickCalibration: %b", object);
        object2 = this.q;
        object = 0;
        ((MutableLiveData)object2).postValue(object);
    }

    private Model o() {
        boolean bl2 = ce.A1();
        if (bl2) {
            return ce.E0().a1().w2();
        }
        return null;
    }

    public static /* synthetic */ void o0(boolean bl2, Throwable throwable) {
        Object[] objectArray = new Object[1];
        Boolean bl3 = bl2;
        objectArray[0] = bl3;
        m.a.a.z(throwable, "quickCalibration: %b", objectArray);
    }

    private List p(int n10) {
        int n11 = 4;
        List list = n10 != n11 ? (n10 != (n11 = 5) ? (n10 != (n11 = 6) ? (n10 != (n11 = 7) ? this.R.e : this.R.i) : this.R.h) : this.R.g) : this.R.f;
        return list;
    }

    public static /* synthetic */ e.a.q p0(BleViewModel bleViewModel, Stabilizer stabilizer) {
        return bleViewModel.z(stabilizer);
    }

    public static /* synthetic */ void q0(Boolean objectArray) {
        objectArray = new Object[]{};
        m.a.a.i("saveFineTune", objectArray);
    }

    public static /* synthetic */ void r0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "saveFineTune", objectArray);
    }

    public static /* synthetic */ e.a.g s0(boolean bl2, Stabilizer stabilizer) {
        return stabilizer.h7(bl2);
    }

    private /* synthetic */ void t0(boolean bl2) {
        Object object = new Object[1];
        Boolean bl3 = bl2;
        object[0] = bl3;
        m.a.a.i("setDemoMode: %b", (Object[])object);
        object = this.B;
        Boolean bl4 = bl2;
        ((MutableLiveData)object).postValue(bl4);
    }

    public static /* synthetic */ void v0(Throwable throwable) {
        Object[] objectArray = new Object[]{};
        m.a.a.z(throwable, "getDemoMode", objectArray);
    }

    public static /* synthetic */ e.a.z w0(boolean bl2, Stabilizer stabilizer, ae ae2) {
        ae2.j(bl2);
        return stabilizer.x1(ae2);
    }

    public static /* synthetic */ e0 x0(e.a.z z10) {
        return z10;
    }

    private /* synthetic */ void y0(boolean bl2, Boolean object) {
        object = new Object[1];
        Boolean bl3 = bl2;
        object[0] = bl3;
        m.a.a.i("setHorizontalReverse: %s", (Object[])object);
        object = this.e;
        Boolean bl4 = bl2;
        ((MutableLiveData)object).postValue(bl4);
    }

    private e.a.q z(Stabilizer stabilizer) {
        Object object = stabilizer.z2();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return e.a.q.d0();
        }
        object = (KeyRedefine)object.get(0);
        int n10 = ((KeyRedefine)object).getKeyGroup();
        int n11 = ((KeyRedefine)object).getKeyValue();
        int n12 = ((KeyRedefine)object).getKeyEvents()[0];
        return stabilizer.Y2(n10, n11, n12).U4(2).r5();
    }

    public List A() {
        Model model = this.o();
        if (model != null) {
            return this.o().getFunctions().workingModes;
        }
        return Collections.emptyList();
    }

    public void A1() {
        ce.E0().E7();
    }

    public void B1() {
    }

    /*
     * Enabled aggressive block sorting
     */
    public void C1(int n10, int n11, String string2, boolean bl2, BleViewModel$r bleViewModel$r, BleViewModel$u bleViewModel$u) {
        ArrayList arrayList;
        int n12;
        int n13;
        block5: {
            block4: {
                block1: {
                    block2: {
                        block3: {
                            Objects.requireNonNull(string2);
                            Objects.requireNonNull(bleViewModel$r);
                            n13 = 1;
                            n12 = 2;
                            if (n10 == n13) break block1;
                            if (n10 == n12) break block2;
                            n13 = 3;
                            if (n10 == n13) break block3;
                            List list = this.R.a;
                            arrayList = new ArrayList(list);
                            break block4;
                        }
                        arrayList = this.p(n11);
                        ArrayList arrayList2 = new ArrayList(arrayList);
                        n13 = n11 = 5;
                        arrayList = arrayList2;
                        break block5;
                    }
                    Object object = this.R;
                    object = bl2 ? ((f1)object).d : ((f1)object).c;
                    arrayList = new ArrayList(object);
                    break block4;
                }
                List list = this.R.b;
                arrayList = new ArrayList(list);
            }
            n13 = n12;
        }
        if (bl2 && n10 != n12) {
            Collections.reverse(arrayList);
        }
        ce ce2 = ce.E0();
        BleViewModel$d bleViewModel$d = new BleViewModel$d(this, arrayList, n10, bleViewModel$u, bleViewModel$r);
        ce2.I7(arrayList, string2, n13, bleViewModel$d);
    }

    public /* synthetic */ void D0(JoystickSpeed joystickSpeed, Boolean bl2) {
        this.C0(joystickSpeed, bl2);
    }

    public int F() {
        return this.y.size();
    }

    public int G() {
        return this.w.e();
    }

    public /* synthetic */ e.a.g G0(KeyFunc keyFunc, Stabilizer stabilizer) {
        return this.F0(keyFunc, stabilizer);
    }

    public void H() {
        Object object = this.v();
        Object object2 = y0.a;
        object = ((e.a.z)object).s2((o)object2);
        object2 = new d.v.c.s0.y6.q(this);
        r0 r02 = r0.a;
        object = ((e.a.z)object).c((g)object2, r02);
        this.C.b((e.a.s0.b)object);
    }

    public String I(WorkingMode workingMode, String string2) {
        Enum enum_ = this.o();
        if (enum_ == null) {
            return string2;
        }
        Model model = Model.SMOOTHX;
        if (enum_ != model && enum_ != (model = Model.SMOOTHXS) && workingMode == (enum_ = WorkingMode.POV)) {
            return enum_.name();
        }
        return string2;
    }

    public boolean J() {
        return this.Q;
    }

    public boolean K() {
        boolean bl2;
        Object object = Optional.ofNullable(this.r.getValue());
        BleViewModel$PanoramaState bleViewModel$PanoramaState = BleViewModel$PanoramaState.END;
        if ((object = (BleViewModel$PanoramaState)((Object)object.orElse((Object)((Object)bleViewModel$PanoramaState)))) != (bleViewModel$PanoramaState = BleViewModel$PanoramaState.START) && object != (bleViewModel$PanoramaState = BleViewModel$PanoramaState.SPLICE)) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean L(BleViewModel$PanoramaState bleViewModel$PanoramaState) {
        boolean bl2;
        BleViewModel$PanoramaState bleViewModel$PanoramaState2;
        if (bleViewModel$PanoramaState != null && bleViewModel$PanoramaState == (bleViewModel$PanoramaState2 = BleViewModel$PanoramaState.START) || bleViewModel$PanoramaState == (bleViewModel$PanoramaState2 = BleViewModel$PanoramaState.SPLICE)) {
            bl2 = true;
        } else {
            bl2 = false;
            bleViewModel$PanoramaState = null;
        }
        return bl2;
    }

    public /* synthetic */ void L0(SceneMode sceneMode, Boolean bl2) {
        this.K0(sceneMode, bl2);
    }

    public /* synthetic */ void N(yd yd2) {
        this.M(yd2);
    }

    public /* synthetic */ void R(Boolean bl2) {
        this.Q(bl2);
    }

    public /* synthetic */ void T0(boolean bl2, Boolean bl3) {
        this.S0(bl2, bl3);
    }

    public /* synthetic */ void U(JoystickSpeed joystickSpeed) {
        this.T(joystickSpeed);
    }

    public /* synthetic */ void X(Pair pair) {
        this.W(pair);
    }

    public /* synthetic */ void X0(WorkingMode workingMode, Boolean bl2) {
        this.W0(workingMode, bl2);
    }

    public void Z0(int n10, int n11, int n12) {
        Object object = (Boolean)this.L.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (!bl2) {
            return;
        }
        object = ((Stabilizer)this.N.getValue()).J2();
        i i10 = ((MoveLimit)object).pitch;
        boolean bl3 = BleViewModel.f(i10);
        if (bl3 && (bl3 = BleViewModel.f(i10 = ((MoveLimit)object).roll)) && (bl2 = BleViewModel.f((i)(object = ((MoveLimit)object).yaw)))) {
            object = ce.E0();
            ((ce)object).U5(n11, n10, n12, null);
        } else {
            object = ce.E0();
            ((ce)object).U5(n10, n11, n12, null);
        }
    }

    public /* synthetic */ void a0(yd yd2) {
        this.Z(yd2);
    }

    public void a1(boolean bl2) {
        e.a.z z10 = this.v();
        Object object = new d.v.c.s0.y6.e0(bl2);
        z10 = z10.s2((o)object);
        object = new d(this, bl2);
        d.v.c.s0.y6.j j10 = new d.v.c.s0.y6.j(bl2);
        e.a.s0.b b10 = z10.c((g)object, j10);
        this.C.b(b10);
    }

    public void b1() {
        this.y.removeLast();
        MutableLiveData mutableLiveData = this.z;
        LinkedList linkedList = this.y;
        mutableLiveData.setValue(linkedList);
    }

    public void c(Bitmap object) {
        this.y.addLast(object);
        object = this.z;
        LinkedList linkedList = this.y;
        ((MutableLiveData)object).setValue(linkedList);
    }

    public void c1() {
        this.w.d();
    }

    public void d(Context object) {
        object = this.v();
        Object object2 = c1.a;
        object = ((e.a.z)object).s2((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((e.a.z)object).i4((e.a.h0)object2);
        object2 = new k0(this);
        l l10 = d.v.c.s0.y6.l.a;
        object = ((e.a.z)object).c((g)object2, l10);
        this.C.b((e.a.s0.b)object);
    }

    public /* synthetic */ void d0(ae ae2) {
        this.c0(ae2);
    }

    public void d1() {
        Object object = this.v();
        Object object2 = z0.a;
        object = ((e.a.z)object).s2((o)object2);
        object2 = d.v.c.s0.y6.m.a;
        k k10 = d.v.c.s0.y6.k.a;
        object = ((e.a.z)object).c((g)object2, k10);
        this.C.b((e.a.s0.b)object);
    }

    public void e() {
        ce.E0().B7();
    }

    public void f1(CameraSet$Theme cameraSet$Theme) {
        d.v.c.i1.s2.q.h().s(cameraSet$Theme);
    }

    public void g() {
        this.y.clear();
        MutableLiveData mutableLiveData = this.z;
        LinkedList linkedList = this.y;
        mutableLiveData.setValue(linkedList);
    }

    public /* synthetic */ void g0(SceneMode sceneMode) {
        this.f0(sceneMode);
    }

    public void g1(String string2) {
        d.v.c.v0.u.z.m().H(string2);
    }

    public void h1(boolean bl2) {
        Object object = this.v();
        Object object2 = new c0(bl2);
        object = ((e.a.z)object).E2((o)object2);
        object2 = new q0(this, bl2);
        Object object3 = d.v.c.s0.y6.b.a;
        object3 = ((e.a.a)object).h((e.a.v0.a)object2, (g)object3);
        this.C.b((e.a.s0.b)object3);
    }

    public void i() {
        this.w.b();
    }

    public void i1(boolean bl2) {
        e.a.z z10 = this.v();
        Object object = a1.a;
        d.v.c.s0.y6.n n10 = new d.v.c.s0.y6.n(bl2);
        z10 = z10.u2((o)object, n10);
        object = d.v.c.s0.y6.v.a;
        z10 = z10.s2((o)object);
        object = new d.v.c.s0.y6.i(this, bl2);
        Object object2 = o0.a;
        object2 = z10.c((g)object, (g)object2);
        this.C.b((e.a.s0.b)object2);
    }

    public String j() {
        return d.v.c.v0.u.z.m().h();
    }

    public /* synthetic */ void j0(WorkingMode workingMode) {
        this.i0(workingMode);
    }

    public void j1(String string2) {
    }

    public void k() {
        Object object = this.v();
        Object object2 = d.v.c.s0.y6.a.a;
        object = ((e.a.z)object).K2((o)object2);
        object2 = new s(this);
        h h10 = d.v.c.s0.y6.h.a;
        object = ((e.a.z)object).c((g)object2, h10);
        this.C.b((e.a.s0.b)object);
    }

    public void k1(JoystickSpeed object) {
        e.a.z z10 = this.v();
        Object object2 = new x((JoystickSpeed)((Object)object));
        z10 = z10.s2((o)object2);
        object2 = new y(this, (JoystickSpeed)((Object)object));
        p0 p02 = new p0((JoystickSpeed)((Object)object));
        object = z10.c((g)object2, p02);
        this.C.b((e.a.s0.b)object);
    }

    public List l(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            int n10;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
                Object object;
                if (i10 == 0) {
                    object = 0;
                    arrayList.add(object);
                    continue;
                }
                object = (yd)list.get(i10);
                int n11 = i10 + -1;
                yd yd2 = (yd)list.get(n11);
                n10 = d.v.e0.oe.n.c((yd)object, yd2);
                object = n10;
                arrayList.add(object);
            }
            return arrayList;
        }
        return null;
    }

    public void m() {
        Object object = this.v();
        Object object2 = x0.a;
        object = ((e.a.z)object).s2((o)object2);
        object2 = new d0(this);
        d.v.c.s0.y6.e e10 = d.v.c.s0.y6.e.a;
        object = ((e.a.z)object).c((g)object2, e10);
        this.C.b((e.a.s0.b)object);
    }

    public void m1(KeyFunc keyFunc) {
        Object object = this.v();
        Object object2 = new h0(this, keyFunc);
        object = ((e.a.z)object).E2((o)object2);
        object2 = new f0(keyFunc);
        l0 l02 = l0.a;
        object = ((e.a.a)object).h((e.a.v0.a)object2, l02);
        this.g.postValue((Object)keyFunc);
        this.C.b((e.a.s0.b)object);
    }

    public void n() {
        Object object = this.v();
        Object object2 = new s0(this);
        object = ((e.a.z)object).I2((o)object2);
        object2 = new j0(this);
        d.v.c.s0.y6.z z10 = d.v.c.s0.y6.z.a;
        object = ((e.a.z)object).c((g)object2, z10);
        this.C.b((e.a.s0.b)object);
    }

    public /* synthetic */ void n0(boolean bl2, Boolean bl3) {
        this.m0(bl2, bl3);
    }

    public void n1(float f10, float f11) {
        ce ce2 = ce.E0();
        BleViewModel$g bleViewModel$g = new BleViewModel$g(this, f10, f11);
        ce2.z6(f10, f11, bleViewModel$g);
    }

    /*
     * WARNING - void declaration
     */
    public void o1(boolean bl2) {
        void var1_4;
        ce ce2 = ce.E0();
        if (bl2) {
            int n10 = 2;
        } else {
            boolean bl3 = false;
        }
        ce2.f6((int)var1_4);
    }

    public void onCleared() {
        ce ce2 = ce.E0();
        d1 d12 = this.S;
        ce2.m5(d12);
    }

    public void p1(SceneMode object) {
        e.a.z z10 = this.v();
        Object object2 = new d.v.c.s0.y6.c((SceneMode)((Object)object));
        z10 = z10.s2((o)object2);
        object2 = new t0(this, (SceneMode)((Object)object));
        a0 a02 = new a0((SceneMode)((Object)object));
        object = z10.c((g)object2, a02);
        this.C.b((e.a.s0.b)object);
    }

    public void q1(boolean bl2) {
        e.a.z z10 = this.v();
        Object object = new u(bl2);
        z10 = z10.s2((o)object);
        object = new v0(bl2);
        w w10 = new w(bl2);
        e.a.s0.b b10 = z10.c((g)object, w10);
        this.C.b(b10);
    }

    public void r() {
        ce ce2 = ce.E0();
        BleViewModel$f bleViewModel$f = new BleViewModel$f(this);
        ce2.Q0(bleViewModel$f);
    }

    public void r1(boolean bl2) {
        this.Q = bl2;
        if (!bl2) {
            MutableLiveData mutableLiveData = this.j;
            Boolean bl3 = Boolean.FALSE;
            mutableLiveData.setValue(bl3);
            mutableLiveData = this.i;
            mutableLiveData.setValue(bl3);
        }
    }

    public void s() {
        Object object = this.v();
        Object object2 = c1.a;
        object = ((e.a.z)object).s2((o)object2);
        object2 = new n0(this);
        t t10 = d.v.c.s0.y6.t.a;
        object = ((e.a.z)object).c((g)object2, t10);
        this.C.b((e.a.s0.b)object);
    }

    public void s1(boolean bl2) {
        e.a.z z10 = this.v();
        Object object = a1.a;
        f f10 = new f(bl2);
        z10 = z10.u2((o)object, f10);
        object = d.v.c.s0.y6.r.a;
        z10 = z10.s2((o)object);
        object = new i0(this, bl2);
        Object object2 = m0.a;
        object2 = z10.c((g)object, (g)object2);
        this.C.b((e.a.s0.b)object2);
    }

    public void t() {
        Object object = this.v();
        Object object2 = a1.a;
        object = ((e.a.z)object).s2((o)object2);
        object2 = new g0(this);
        p p10 = d.v.c.s0.y6.p.a;
        object = ((e.a.z)object).c((g)object2, p10);
        this.C.b((e.a.s0.b)object);
    }

    public void t1(WorkingMode object) {
        e.a.z z10 = this.v();
        Object object2 = new u0((WorkingMode)((Object)object));
        z10 = z10.s2((o)object2);
        object2 = new w0(this, (WorkingMode)((Object)object));
        object = d.v.c.s0.y6.o.a;
        object = z10.c((g)object2, (g)object);
        this.C.b((e.a.s0.b)object);
    }

    public void u() {
        Object object = this.v();
        Object object2 = b1.a;
        object = ((e.a.z)object).s2((o)object2);
        object2 = new d.v.c.s0.y6.g(this);
        b0 b02 = b0.a;
        object = ((e.a.z)object).c((g)object2, b02);
        this.C.b((e.a.s0.b)object);
    }

    public /* synthetic */ void u0(boolean bl2) {
        this.t0(bl2);
    }

    public void u1() {
        ce ce2 = ce.E0();
        Object object = new BleViewModel$i(this);
        ce2.D6((Stabilizer$j)object);
        ce2 = ce.E0();
        object = this.T;
        ce2.e6((Stabilizer$g)object);
        ce2 = ce.E0();
        object = new BleViewModel$j(this);
        ce2.R6((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$k(this);
        ce2.V6((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$l(this);
        ce2.t6((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$m(this);
        ce2.Z5((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$n(this);
        ce2.K6((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$o(this);
        ce2.j6((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$p(this);
        ce2.T6((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$q(this);
        ce2.F6((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$a(this);
        ce2.X5((b)object);
        ce2 = ce.E0();
        object = new BleViewModel$b(this);
        ce2.v((Stabilizer$k)object);
        this.t();
        this.H();
        this.n();
        this.m();
        this.u();
        this.k();
    }

    public e.a.z v() {
        boolean bl2 = ce.A1();
        if (bl2) {
            e.a.z z10 = e.a.z.t3(ce.E0().a1());
            e.a.h0 h02 = e.a.c1.b.d();
            return z10.L5(h02);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Please connect device. ");
        return e.a.z.m2(illegalStateException);
    }

    public void v1(long l10) {
        Object object = Optional.ofNullable(this.x.getValue());
        Object object2 = new LinkedList();
        Object object3 = object = ((Optional)object).orElse(object2);
        object3 = (List)object;
        boolean bl2 = object3.isEmpty();
        if (bl2) {
            return;
        }
        object2 = ce.E0();
        BleViewModel$c bleViewModel$c = new BleViewModel$c(this);
        ((ce)object2).m7(l10, 0L, (List)object3, bleViewModel$c);
    }

    public float w() {
        Object object = (Boolean)this.L.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (bl2 && (object = (Stabilizer)this.N.getValue()) != null) {
            return ((Stabilizer)object).s2();
        }
        return 0.0f;
    }

    public void w1(boolean bl2, StoryAxis ... storyAxisArray) {
        ce ce2 = ce.E0();
        BleViewModel$e bleViewModel$e = new BleViewModel$e(this);
        ce2.t7(bl2, storyAxisArray, bleViewModel$e);
    }

    public Model x() {
        Object object = (Boolean)this.L.getValue();
        boolean bl2 = d.v.e.h.a.c((Boolean)object);
        if (bl2 && (object = (Stabilizer)this.N.getValue()) != null) {
            return ((Stabilizer)object).H2();
        }
        return Model.UNKNOWN;
    }

    public void x1(RectF rectF, boolean bl2, BleViewModel$t bleViewModel$t, BleViewModel$r bleViewModel$r) {
    }

    public String y() {
        boolean bl2 = ce.A1();
        if (bl2) {
            String string2 = ((Stabilizer)this.N.getValue()).M2();
            string2 = string2 == null ? "" : ((Stabilizer)this.N.getValue()).M2();
            return string2;
        }
        return "not connected";
    }

    public void y1() {
        this.C.e();
    }

    public /* synthetic */ void z0(boolean bl2, Boolean bl3) {
        this.y0(bl2, bl3);
    }

    public void z1() {
        ce.E0().z7();
    }
}

