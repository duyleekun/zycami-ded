/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.util.Size
 */
package d.v.c.s0;

import android.app.Application;
import android.content.Context;
import android.util.Size;
import androidx.arch.core.util.Function;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.cama.camera.data.BeautyData;
import com.zhiyun.cama.camera.data.CameraSet$CountDownTime;
import com.zhiyun.cama.camera.data.CameraSet$DelayInterval;
import com.zhiyun.cama.camera.data.CameraSet$DelayTime;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.camera.data.CameraSet$Panorama;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.cama.data.database.model.CameraParam;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.protocol.core.entities.MoveLimit;
import d.v.c.s0.c6;
import d.v.c.s0.o6;
import d.v.c.s0.u6$a;
import d.v.c.s0.x6;
import d.v.c.s0.z6.a;
import d.v.c.v0.n.d;
import d.v.d.i.g.k;
import d.v.d.i.g.k$a;
import d.v.e.i.h;
import d.v.e.i.i;
import d.v.e0.ce;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.Callable;

public class u6
extends AndroidViewModel {
    private final MediatorLiveData A;
    private LiveData B;
    private final MutableLiveData C;
    private final MutableLiveData D;
    private a E;
    private final LiveData F;
    private final MutableLiveData G;
    private final MutableLiveData H;
    private final MutableLiveData I;
    private final MutableLiveData J;
    private final MutableLiveData K;
    private MutableLiveData L;
    private final MutableLiveData M;
    private final MutableLiveData N;
    private final MutableLiveData O;
    private final MutableLiveData P;
    private final MutableLiveData Q;
    private final MutableLiveData R;
    private final MutableLiveData S;
    private final MutableLiveData T;
    private final MutableLiveData U;
    private final MutableLiveData V;
    private final MutableLiveData W;
    private final MutableLiveData X;
    public final List Y;
    public final MutableLiveData Z;
    public final x6 a;
    private d b;
    private final MutableLiveData c;
    private final MutableLiveData d;
    private final MutableLiveData e;
    private final MutableLiveData f;
    private final MutableLiveData g;
    private final MutableLiveData h;
    private final MutableLiveData i;
    private final MutableLiveData j;
    private final MutableLiveData k;
    private final MutableLiveData l;
    private final MutableLiveData m;
    private final MutableLiveData n;
    private final MutableLiveData o;
    private final MutableLiveData p;
    private final MutableLiveData q;
    private final MutableLiveData r;
    private final MutableLiveData s;
    private final MutableLiveData t;
    private final MutableLiveData u;
    private final MutableLiveData v;
    private final MutableLiveData w;
    private String x;
    private final MutableLiveData y;
    private final ObservableBoolean z;

    public u6(Application application) {
        Object object;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        MutableLiveData mutableLiveData6;
        MutableLiveData mutableLiveData7;
        u6 u62 = this;
        super(application);
        Object object2 = new MutableLiveData();
        this.c = object2;
        object2 = new MutableLiveData();
        this.d = object2;
        object2 = new MutableLiveData();
        this.e = object2;
        object2 = new MutableLiveData();
        this.f = object2;
        object2 = new MutableLiveData();
        this.g = object2;
        object2 = new MutableLiveData();
        this.h = object2;
        object2 = new MutableLiveData();
        this.i = object2;
        Object object3 = new MutableLiveData();
        this.j = object3;
        this.k = mutableLiveData7 = new MutableLiveData();
        this.l = mutableLiveData6 = new MutableLiveData();
        this.m = mutableLiveData5 = new MutableLiveData();
        this.n = mutableLiveData5 = new MutableLiveData();
        Object object4 = new MutableLiveData();
        this.o = object4;
        object4 = new MutableLiveData();
        this.p = object4;
        object4 = new MutableLiveData();
        this.q = object4;
        object4 = new MutableLiveData();
        this.r = object4;
        object4 = new MutableLiveData();
        this.s = object4;
        object4 = new MutableLiveData();
        this.t = object4;
        object4 = new MutableLiveData();
        this.u = object4;
        this.v = mutableLiveData4 = new MutableLiveData();
        this.w = mutableLiveData3 = new MutableLiveData();
        this.y = mutableLiveData3 = new MutableLiveData();
        Object object5 = new ObservableBoolean();
        this.z = object5;
        this.A = object5 = new i();
        this.C = object5 = new MutableLiveData();
        this.D = object5 = new MutableLiveData();
        Object object6 = new a();
        this.E = object6;
        this.G = object6 = new MutableLiveData();
        this.H = mutableLiveData2 = new MutableLiveData();
        this.I = mutableLiveData = new MutableLiveData();
        Object object7 = new MutableLiveData();
        this.J = object7;
        Object object8 = new MutableLiveData();
        this.K = object8;
        this.L = object = new MutableLiveData();
        this.M = object = new MutableLiveData();
        this.N = object = new MutableLiveData();
        this.O = object = new MutableLiveData();
        this.P = object = new MutableLiveData();
        this.Q = object = new MutableLiveData();
        this.R = object = new MutableLiveData();
        this.S = object = new MutableLiveData();
        int n10 = 2131231456;
        MutableLiveData mutableLiveData8 = object8;
        object8 = n10;
        this.T = object = new MutableLiveData(object8);
        this.U = object8 = new MutableLiveData();
        this.V = object8 = new MutableLiveData();
        this.W = object8 = new MutableLiveData();
        this.X = object = new MutableLiveData();
        MutableLiveData mutableLiveData9 = object7;
        object7 = Boolean.TRUE;
        this.Z = object = new MutableLiveData(object7);
        object7 = new CameraSet$Mode[8];
        object = CameraSet$Mode.story;
        MutableLiveData mutableLiveData10 = mutableLiveData;
        mutableLiveData = null;
        object7[0] = object;
        object = CameraSet$Mode.live;
        boolean bl2 = true;
        object7[bl2] = object;
        object = CameraSet$Mode.photograph;
        object7[2] = object;
        object = CameraSet$Mode.video;
        object7[3] = object;
        object = CameraSet$Mode.panorama;
        object7[4] = object;
        object = CameraSet$Mode.dolly_zoom;
        object7[5] = object;
        object = CameraSet$Mode.delay_video;
        object7[6] = object;
        object = CameraSet$Mode.sport_delay;
        int n11 = 7;
        object7[n11] = object;
        object7 = Arrays.asList(object7);
        this.Y = object7;
        super();
        this.a = object7;
        this.b = object7 = d.v.c.v0.n.d.s();
        object7 = ((d)object7).L();
        ((MutableLiveData)object4).setValue(object7);
        object4 = this.e;
        object7 = this.b.m();
        ((MutableLiveData)object4).setValue(object7);
        object4 = this.f;
        object7 = this.b.y();
        ((MutableLiveData)object4).setValue(object7);
        object4 = this.b.w();
        object7 = this.B0();
        boolean bl3 = object7.contains(object4);
        if (!bl3) {
            object4 = CameraSet$Panorama.P_180;
        }
        u62.g.setValue(object4);
        object4 = u62.h;
        object7 = u62.b.A();
        ((MutableLiveData)object4).setValue(object7);
        object4 = u62.b.C();
        ((MutableLiveData)object2).setValue(object4);
        object2 = u62.b.x();
        ((MutableLiveData)object8).setValue(object2);
        object2 = u62.b.K();
        ((MutableLiveData)object3).setValue(object2);
        object2 = u62.b.g();
        mutableLiveData7.setValue(object2);
        object2 = u62.b.f();
        ((MutableLiveData)object5).setValue(object2);
        object2 = u62.b.r();
        mutableLiveData6.setValue(object2);
        object2 = u62.b.a();
        mutableLiveData5.setValue(object2);
        u62.x1((List)object2);
        int n12 = u62.b.b();
        u62.D1(n12, false);
        object2 = u62.b.n();
        mutableLiveData4.setValue(object2);
        object2 = u62.b.o();
        u62.Y1((CameraSet$DelayTime)((Object)object2));
        object2 = u62.b.B();
        u62.x = object2;
        object2 = u62.b.v();
        mutableLiveData3.setValue(object2);
        this.I0((Context)application);
        n12 = u62.b.d();
        u62.J1(n12);
        object2 = u62.b.h();
        u62.N1((CameraSet$Mode)((Object)object2));
        object2 = u62.c;
        object3 = new c6(u62);
        object2 = Transformations.switchMap((LiveData)object2, (Function)object3);
        u62.F = object2;
        u62.Z1(2131231442);
        u62.h2(false);
        u62.p2(0);
        u62.k2(bl2);
        u62.h2(false);
        u62.j2(bl2);
        object2 = Boolean.FALSE;
        ((MutableLiveData)object6).setValue(object2);
        mutableLiveData2.setValue("100");
        object3 = mutableLiveData10;
        mutableLiveData10.setValue("1/10000");
        object3 = mutableLiveData9;
        mutableLiveData9.setValue("0");
        object2 = 200;
        object3 = mutableLiveData8;
        mutableLiveData8.setValue(object2);
    }

    private void D1(int n10, boolean bl2) {
        Object object;
        Object object2;
        Object object3 = this.m;
        Integer n11 = n10;
        ((MutableLiveData)object3).setValue(n11);
        if (n10 == 0) {
            this.U1();
        } else {
            int n12 = 1;
            if (n12 == n10) {
                this.y1();
            } else {
                object3 = this.b.a();
                this.x1((List)object3);
            }
        }
        if (bl2) {
            object2 = this.b;
            ((d)object2).U(n10);
        }
        if ((bl2 = this.l1()) && n10 != 0 && (object = this.C.getValue()) != null && (n10 = (object = this.n()).indexOf(object2 = this.C.getValue())) <= 0) {
            n10 = 0;
            object = null;
            this.K1(0);
        }
    }

    private void I0(Context object) {
        object = LiveDataReactiveStreams.fromPublisher(d.v.c.x1.i.c(object));
        this.B = object;
        MediatorLiveData mediatorLiveData = this.A;
        mediatorLiveData.getClass();
        o6 o62 = new o6(mediatorLiveData);
        mediatorLiveData.addSource((LiveData)object, o62);
    }

    private void U1() {
        this.G1(0);
        this.A1(0);
        this.H1(0);
        this.B1(0);
        this.E1(0);
        this.F1(0);
    }

    private float V(int n10) {
        return (float)n10 * 1.0f / 100.0f;
    }

    private boolean b(List list, int n10, List object) {
        int n11;
        object = object.iterator();
        while ((n11 = object.hasNext()) != 0) {
            Integer n12 = (Integer)object.next();
            n11 = n12;
            if (n11 != n10) continue;
            Integer n13 = n10;
            list.add(n13);
            return true;
        }
        return false;
    }

    public static String e(long l10) {
        long l11 = 3600L;
        int n10 = (int)(l10 / l11);
        int n11 = (int)(l10 % l11) / 60;
        int n12 = (int)(l10 % (long)60);
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[3];
        Integer n13 = n10;
        objectArray[0] = n13;
        Integer n14 = n11;
        objectArray[1] = n14;
        Integer n15 = n12;
        objectArray[2] = n15;
        return String.format(locale, "%1$02d:%2$02d:%3$02d", objectArray);
    }

    /*
     * Unable to fully structure code
     */
    private int f(String var1_1) {
        block6: {
            block4: {
                block5: {
                    var2_2 = var1_1.hashCode();
                    var3_3 = 1602;
                    var4_4 = 1;
                    if (var2_2 == var3_3) break block4;
                    var3_3 = 1629;
                    if (var2_2 == var3_3) break block5;
                    var3_3 = 1722;
                    if (var2_2 != var3_3 || (var6_8 = (int)var1_1.equals(var5_5 = "60")) == 0) ** GOTO lbl-1000
                    var6_8 = var4_4;
                    break block6;
                }
                var5_6 = "30";
                var6_8 = (int)var1_1.equals(var5_6);
                if (var6_8 == 0) ** GOTO lbl-1000
                var6_8 = 0;
                var1_1 = null;
                break block6;
            }
            var5_7 = "24";
            var6_8 = var1_1.equals(var5_7);
            if (var6_8 != 0) {
                var6_8 = 2;
            } else lbl-1000:
            // 3 sources

            {
                var6_8 = -1;
            }
        }
        if (var6_8 != 0) {
            if (var6_8 != var4_4) {
                return 2131231427;
            }
            return 2131231432;
        }
        return 2131231429;
    }

    /*
     * Unable to fully structure code
     */
    private int g(String var1_1) {
        block6: {
            block4: {
                block5: {
                    var2_2 = var1_1.hashCode();
                    var3_3 = 1602;
                    var4_4 = 1;
                    if (var2_2 == var3_3) break block4;
                    var3_3 = 1629;
                    if (var2_2 == var3_3) break block5;
                    var3_3 = 1722;
                    if (var2_2 != var3_3 || (var6_8 = (int)var1_1.equals(var5_5 = "60")) == 0) ** GOTO lbl-1000
                    var6_8 = var4_4;
                    break block6;
                }
                var5_6 = "30";
                var6_8 = (int)var1_1.equals(var5_6);
                if (var6_8 == 0) ** GOTO lbl-1000
                var6_8 = 0;
                var1_1 = null;
                break block6;
            }
            var5_7 = "24";
            var6_8 = var1_1.equals(var5_7);
            if (var6_8 != 0) {
                var6_8 = 2;
            } else lbl-1000:
            // 3 sources

            {
                var6_8 = -1;
            }
        }
        if (var6_8 != 0) {
            if (var6_8 != var4_4) {
                return 2131231434;
            }
            return 2131231438;
        }
        return 2131231436;
    }

    /*
     * Unable to fully structure code
     */
    private int i(String var1_1) {
        block6: {
            block4: {
                block5: {
                    var2_2 = var1_1.hashCode();
                    var3_3 = 1602;
                    var4_4 = 1;
                    if (var2_2 == var3_3) break block4;
                    var3_3 = 1629;
                    if (var2_2 == var3_3) break block5;
                    var3_3 = 1722;
                    if (var2_2 != var3_3 || (var6_8 = (int)var1_1.equals(var5_5 = "60")) == 0) ** GOTO lbl-1000
                    var6_8 = var4_4;
                    break block6;
                }
                var5_6 = "30";
                var6_8 = (int)var1_1.equals(var5_6);
                if (var6_8 == 0) ** GOTO lbl-1000
                var6_8 = 0;
                var1_1 = null;
                break block6;
            }
            var5_7 = "24";
            var6_8 = var1_1.equals(var5_7);
            if (var6_8 != 0) {
                var6_8 = 2;
            } else lbl-1000:
            // 3 sources

            {
                var6_8 = -1;
            }
        }
        if (var6_8 != 0) {
            if (var6_8 != var4_4) {
                return 2131231440;
            }
            return 2131231445;
        }
        return 2131231442;
    }

    /*
     * Unable to fully structure code
     */
    private int j() {
        block8: {
            block5: {
                block6: {
                    block7: {
                        var1_1 = this.x;
                        var2_2 = var1_1.hashCode();
                        var3_3 = 1731;
                        var4_4 = 2;
                        var5_5 = 1;
                        if (var2_2 == var3_3) break block5;
                        var3_3 = 48665;
                        if (var2_2 == var3_3) break block6;
                        var3_3 = 48820;
                        if (var2_2 == var3_3) break block7;
                        var3_3 = 50587;
                        if (var2_2 != var3_3 || (var7_10 = (int)var1_1.equals(var6_6 = "30X")) == 0) ** GOTO lbl-1000
                        var7_10 = var4_4;
                        break block8;
                    }
                    var6_7 = "15X";
                    var7_10 = (int)var1_1.equals(var6_7);
                    if (var7_10 == 0) ** GOTO lbl-1000
                    var7_10 = var5_5;
                    break block8;
                }
                var6_8 = "10X";
                var7_10 = (int)var1_1.equals(var6_8);
                if (var7_10 == 0) ** GOTO lbl-1000
                var7_10 = 0;
                var1_1 = null;
                break block8;
            }
            var6_9 = "5X";
            var7_10 = var1_1.equals(var6_9);
            if (var7_10 != 0) {
                var7_10 = 3;
            } else lbl-1000:
            // 4 sources

            {
                var7_10 = -1;
            }
        }
        if (var7_10 != 0) {
            if (var7_10 != var5_5) {
                if (var7_10 != var4_4) {
                    return 2131231517;
                }
                return 2131231515;
            }
            return 2131231511;
        }
        return 2131231509;
    }

    /*
     * Unable to fully structure code
     */
    private int k() {
        block8: {
            block5: {
                block6: {
                    block7: {
                        var1_1 = this.x;
                        var2_2 = var1_1.hashCode();
                        var3_3 = 1731;
                        var4_4 = 2;
                        var5_5 = 1;
                        if (var2_2 == var3_3) break block5;
                        var3_3 = 48665;
                        if (var2_2 == var3_3) break block6;
                        var3_3 = 48820;
                        if (var2_2 == var3_3) break block7;
                        var3_3 = 50587;
                        if (var2_2 != var3_3 || (var7_10 = (int)var1_1.equals(var6_6 = "30X")) == 0) ** GOTO lbl-1000
                        var7_10 = var4_4;
                        break block8;
                    }
                    var6_7 = "15X";
                    var7_10 = (int)var1_1.equals(var6_7);
                    if (var7_10 == 0) ** GOTO lbl-1000
                    var7_10 = var5_5;
                    break block8;
                }
                var6_8 = "10X";
                var7_10 = (int)var1_1.equals(var6_8);
                if (var7_10 == 0) ** GOTO lbl-1000
                var7_10 = 0;
                var1_1 = null;
                break block8;
            }
            var6_9 = "5X";
            var7_10 = var1_1.equals(var6_9);
            if (var7_10 != 0) {
                var7_10 = 3;
            } else lbl-1000:
            // 4 sources

            {
                var7_10 = -1;
            }
        }
        if (var7_10 != 0) {
            if (var7_10 != var5_5) {
                if (var7_10 != var4_4) {
                    return 2131231529;
                }
                return 2131231527;
            }
            return 2131231523;
        }
        return 2131231521;
    }

    private void m() {
        Object object = this.v.getValue();
        if (object != null && (object = this.w.getValue()) != null) {
            object = CameraSet$DelayTime.t_infinite;
            Object object2 = this.w.getValue();
            if (object == object2) {
                object = this.R;
                object2 = "--:--:--";
                ((MutableLiveData)object).setValue(object2);
            } else {
                object = this.R;
                long l10 = ((CameraSet$DelayInterval)((Object)this.v.getValue())).getTime();
                CameraSet$DelayTime cameraSet$DelayTime = (CameraSet$DelayTime)((Object)this.w.getValue());
                long l11 = cameraSet$DelayTime.getTime();
                object2 = this.X(l10, l11);
                ((MutableLiveData)object).setValue(object2);
            }
        }
    }

    private CameraSet$Mode n0(CameraSet$Mode cameraSet$Mode) {
        CameraSet$Panorama cameraSet$Panorama = this.o0();
        int[] nArray = u6$a.b;
        int n10 = cameraSet$Panorama.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n10 = 2131231670;
                    n11 = 2131951804;
                } else {
                    n10 = 2131231673;
                    n11 = 2131951850;
                }
            } else {
                n10 = 2131231671;
                n11 = 2131951805;
            }
        } else {
            n10 = 2131231672;
            n11 = 2131951806;
        }
        cameraSet$Mode.setDrawableRes(n10);
        cameraSet$Mode.setHintRes(n11);
        return cameraSet$Mode;
    }

    private /* synthetic */ LiveData p1(CameraSet$Mode cameraSet$Mode) {
        d d10 = this.b;
        int n10 = d10.d();
        return d10.j(n10, cameraSet$Mode);
    }

    private boolean s2() {
        int n10;
        int n11;
        Object object = ce.E0().a1().J2();
        Integer n12 = (Integer)((MoveLimit)object).pitch.h();
        int n13 = n12;
        if (n13 <= (n11 = -45) && (n10 = ((Integer)(object = (Integer)((MoveLimit)object).pitch.i())).intValue()) >= (n13 = 45)) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    private void w1(int n10, List list) {
        boolean bl2;
        Iterator iterator2 = list.iterator();
        while (bl2 = iterator2.hasNext()) {
            int n11;
            int n12;
            BeautyData beautyData = (BeautyData)iterator2.next();
            for (int i10 = n11 = 2; i10 < (n12 = list.size()); ++i10) {
                if (i10 != n11) {
                    n12 = 3;
                    if (i10 != n12) {
                        n12 = 4;
                        int n13 = 30;
                        if (i10 != n12) {
                            n12 = 5;
                            if (i10 != n12) {
                                n12 = 7;
                                if (i10 != n12) continue;
                                beautyData.setProgress(n13);
                                continue;
                            }
                            n12 = 40;
                            beautyData.setProgress(n12);
                            continue;
                        }
                        beautyData.setProgress(n13);
                        continue;
                    }
                    n12 = 70;
                    beautyData.setProgress(n12);
                    continue;
                }
                n12 = 50;
                beautyData.setProgress(n12);
            }
        }
        this.z1(list);
    }

    private void x1(List list) {
        int n10;
        block8: for (int i10 = 2; i10 < (n10 = list.size()); ++i10) {
            BeautyData beautyData = (BeautyData)list.get(i10);
            n10 = beautyData.getProgress();
            switch (i10) {
                default: {
                    continue block8;
                }
                case 7: {
                    this.F1(n10);
                    continue block8;
                }
                case 6: {
                    this.E1(n10);
                    continue block8;
                }
                case 5: {
                    this.B1(n10);
                    continue block8;
                }
                case 4: {
                    this.H1(n10);
                    continue block8;
                }
                case 3: {
                    this.A1(n10);
                    continue block8;
                }
                case 2: {
                    this.G1(n10);
                }
            }
        }
    }

    private void y1() {
        int n10;
        List list = this.b.a();
        block8: for (int i10 = 2; i10 < (n10 = list.size()); ++i10) {
            BeautyData beautyData = (BeautyData)list.get(i10);
            int n11 = 30;
            switch (i10) {
                default: {
                    continue block8;
                }
                case 7: {
                    beautyData.setProgress(n11);
                    this.F1(n11);
                    continue block8;
                }
                case 6: {
                    n11 = 0;
                    beautyData.setProgress(0);
                    this.E1(0);
                    continue block8;
                }
                case 5: {
                    n11 = 40;
                    beautyData.setProgress(n11);
                    this.B1(n11);
                    continue block8;
                }
                case 4: {
                    beautyData.setProgress(n11);
                    this.H1(n11);
                    continue block8;
                }
                case 3: {
                    n11 = 70;
                    beautyData.setProgress(n11);
                    this.A1(n11);
                    continue block8;
                }
                case 2: {
                    n11 = 50;
                    beautyData.setProgress(n11);
                    this.G1(n11);
                }
            }
        }
        this.z1(list);
    }

    public MutableLiveData A() {
        return this.C;
    }

    public MutableLiveData A0() {
        return this.i;
    }

    public void A1(int n10) {
        MutableLiveData mutableLiveData = this.p;
        Float f10 = Float.valueOf(this.V(n10));
        mutableLiveData.setValue(f10);
    }

    public List B0() {
        Object object = CameraSet$Panorama.values();
        int n10 = ((CameraSet$Panorama[])object).length;
        ArrayList arrayList = new ArrayList(n10);
        Collections.addAll(arrayList, object);
        object = BleConnection.W();
        boolean bl2 = object.c0();
        if (bl2 && !(bl2 = this.s2())) {
            object = CameraSet$Panorama.P_3x3;
            arrayList.remove(object);
        }
        return arrayList;
    }

    public void B1(int n10) {
        MutableLiveData mutableLiveData = this.r;
        Float f10 = Float.valueOf(this.V(n10));
        mutableLiveData.setValue(f10);
    }

    public MutableLiveData C0() {
        return this.j;
    }

    public void C1(int n10) {
        this.D1(n10, true);
    }

    public MutableLiveData D0() {
        return this.U;
    }

    public List E0() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("5X");
        arrayList.add("10X");
        arrayList.add("15X");
        arrayList.add("30X");
        return arrayList;
    }

    public void E1(int n10) {
        MutableLiveData mutableLiveData = this.s;
        Float f10 = Float.valueOf(this.V(n10));
        mutableLiveData.setValue(f10);
    }

    public MutableLiveData F() {
        return this.D;
    }

    public MutableLiveData F0() {
        return this.O;
    }

    public void F1(int n10) {
        MutableLiveData mutableLiveData = this.t;
        Float f10 = Float.valueOf(this.V(n10));
        mutableLiveData.setValue(f10);
    }

    public MutableLiveData G() {
        return this.k;
    }

    public MutableLiveData G0() {
        return this.K;
    }

    public void G1(int n10) {
        MutableLiveData mutableLiveData = this.o;
        Float f10 = Float.valueOf(this.V(n10));
        mutableLiveData.setValue(f10);
    }

    public MutableLiveData H() {
        return this.c;
    }

    public MutableLiveData H0() {
        return this.u;
    }

    public void H1(int n10) {
        MutableLiveData mutableLiveData = this.q;
        Float f10 = Float.valueOf(this.V(n10));
        mutableLiveData.setValue(f10);
    }

    public CameraSet$Mode I() {
        Object object = this.c.getValue();
        object = object == null ? CameraSet$Mode.video : (CameraSet$Mode)((Object)this.c.getValue());
        return object;
    }

    public void I1(a object) {
        Objects.requireNonNull(object);
        this.E = object;
        object = this.b;
        List list = this.t0();
        List list2 = this.o();
        ((d)object).E0(list, list2);
    }

    public LiveData J() {
        return this.F;
    }

    public boolean J0(int n10) {
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void J1(int n10) {
        MutableLiveData mutableLiveData = this.d;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public MutableLiveData K() {
        return this.P;
    }

    public boolean K0() {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode;
        CameraSet$Mode cameraSet$Mode2 = this.I();
        if (cameraSet$Mode2 == (cameraSet$Mode = CameraSet$Mode.dolly_zoom)) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$Mode2 = null;
        }
        return bl2;
    }

    public void K1(int n10) {
        int n11 = this.l1();
        int n12 = 2131231453;
        Integer n13 = n12;
        if (n11 != 0) {
            Object object;
            if (n10 != 0) {
                n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 == n11) {
                            object = this.S;
                            n12 = 2131231454;
                            n13 = n12;
                            ((MutableLiveData)object).setValue(n13);
                        }
                    } else {
                        object = this.S;
                        n12 = 2131231452;
                        n13 = n12;
                        ((MutableLiveData)object).setValue(n13);
                    }
                } else {
                    object = this.S;
                    n12 = 2131231455;
                    n13 = n12;
                    ((MutableLiveData)object).setValue(n13);
                }
            } else {
                object = this.S;
                ((MutableLiveData)object).setValue(n13);
            }
            object = this.C;
            n13 = n10;
            ((MutableLiveData)object).setValue(n13);
            object = this.b;
            ((d)object).X(n10);
        } else {
            MutableLiveData mutableLiveData = this.C;
            n11 = 0;
            Integer n14 = 0;
            mutableLiveData.setValue(n14);
            mutableLiveData = this.S;
            mutableLiveData.setValue(n13);
        }
    }

    public boolean L() {
        Optional<Object> optional = Optional.ofNullable(this.P.getValue());
        Boolean bl2 = Boolean.FALSE;
        return (Boolean)optional.orElse(bl2);
    }

    public boolean L0() {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode;
        CameraSet$Mode cameraSet$Mode2 = this.I();
        if (cameraSet$Mode2 == (cameraSet$Mode = CameraSet$Mode.live)) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$Mode2 = null;
        }
        return bl2;
    }

    public void L1(String string2) {
        this.D.setValue(string2);
        this.b.Y(string2);
    }

    public MutableLiveData M() {
        return this.J;
    }

    public boolean M0() {
        int n10;
        int[] nArray = u6$a.a;
        CameraSet$Mode cameraSet$Mode = this.I();
        int n11 = cameraSet$Mode.ordinal();
        int n12 = nArray[n11];
        if (n12 != (n11 = 1) && n12 != (n10 = 2)) {
            return false;
        }
        return n11;
    }

    public void M1(int n10) {
        MutableLiveData mutableLiveData = this.k;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
        this.b.Z(n10);
    }

    public MutableLiveData N() {
        return this.H;
    }

    public boolean N0() {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode;
        CameraSet$Mode cameraSet$Mode2 = this.I();
        if (cameraSet$Mode2 == (cameraSet$Mode = CameraSet$Mode.story)) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$Mode2 = null;
        }
        return bl2;
    }

    public void N1(CameraSet$Mode object) {
        Object object2;
        Object object3 = CameraSet$Mode.panorama;
        if (object == object3) {
            object = this.n0((CameraSet$Mode)((Object)object));
        }
        this.c.setValue(object);
        object3 = this.b;
        ((d)object3).a0((CameraSet$Mode)((Object)object));
        object = this.b;
        int n10 = ((d)object).e();
        int n11 = this.l1();
        if (n11 != 0 && (object3 = CameraSet$Mode.photograph) != (object2 = this.c.getValue()) && (n11 = (object3 = this.n()).indexOf(object2 = Integer.valueOf(n10))) <= 0) {
            n10 = 0;
            object = null;
            this.K1(0);
        } else {
            this.K1(n10);
        }
    }

    public boolean O0(CameraSet$Mode cameraSet$Mode, k$a object) {
        int n10;
        boolean bl2;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.photograph;
        if (cameraSet$Mode2 != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.video) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.live) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.story) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.dolly_zoom) != cameraSet$Mode) {
            bl2 = false;
            cameraSet$Mode = null;
        } else {
            bl2 = true;
        }
        if (object == null) {
            return bl2;
        }
        if (bl2 && (n10 = d.v.d.i.g.k.s((Size)(object = ((k$a)object).a))) == 0) {
            object = this.b;
            n10 = ((d)object).b();
            this.D1(n10, false);
        } else {
            this.D1(0, false);
        }
        return bl2;
    }

    public void O1(String string2) {
        this.J.setValue(string2);
    }

    public MutableLiveData P() {
        return this.I;
    }

    public boolean P0(CameraSet$StoryState cameraSet$StoryState) {
        boolean bl2;
        CameraSet$StoryState cameraSet$StoryState2 = CameraSet$StoryState.STORY_REVIEW;
        if (cameraSet$StoryState != cameraSet$StoryState2 && cameraSet$StoryState != (cameraSet$StoryState2 = CameraSet$StoryState.STORY_DRAFT) && cameraSet$StoryState != (cameraSet$StoryState2 = CameraSet$StoryState.STORY_DRAFT_TO_REVIEW) && cameraSet$StoryState != (cameraSet$StoryState2 = CameraSet$StoryState.STORY_PERSONAL) && cameraSet$StoryState != (cameraSet$StoryState2 = CameraSet$StoryState.STORY_MORE) && cameraSet$StoryState != (cameraSet$StoryState2 = CameraSet$StoryState.STORY_SAVE)) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$StoryState = null;
        }
        return bl2;
    }

    public void P1(String string2) {
        this.H.setValue(string2);
    }

    public k$a Q() {
        Object object = this.F.getValue();
        if (object == null) {
            return d.v.d.i.g.k.r;
        }
        return ((CameraParam)this.F.getValue()).getVideoResolution();
    }

    public boolean Q0(CameraSet$Mode enum_, CameraSet$Panorama cameraSet$Panorama) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.photograph;
        if (cameraSet$Mode != enum_ && ((cameraSet$Mode = CameraSet$Mode.panorama) != enum_ || (enum_ = CameraSet$Panorama.P_CLONE) == cameraSet$Panorama)) {
            bl2 = false;
            enum_ = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void Q1(boolean bl2) {
        MutableLiveData mutableLiveData = this.G;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public MutableLiveData R() {
        return this.e;
    }

    public boolean R0(CameraSet$Mode cameraSet$Mode) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.video;
        if (cameraSet$Mode2 != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.slow_motion) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.delay_video) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.sport_delay) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.live) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.dolly_zoom) != cameraSet$Mode) {
            bl2 = false;
            cameraSet$Mode = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void R1(String string2) {
        this.I.setValue(string2);
    }

    public CameraSet$CountDownTime S() {
        Object object = this.e.getValue();
        object = object == null ? CameraSet$CountDownTime.c_0 : (CameraSet$CountDownTime)((Object)this.e.getValue());
        return object;
    }

    public boolean S0(CameraSet$Mode cameraSet$Mode) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.dolly_zoom;
        if (cameraSet$Mode2 == cameraSet$Mode) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$Mode = null;
        }
        return bl2;
    }

    public void S1(k$a object) {
        CameraParam cameraParam = (CameraParam)this.F.getValue();
        if (cameraParam != null) {
            cameraParam.setVideoResolution((k$a)object);
            object = this.b;
            ((d)object).b0(cameraParam);
        }
    }

    public MutableLiveData T() {
        return this.Q;
    }

    public boolean T0(CameraSet$Mode cameraSet$Mode, boolean bl2) {
        Boolean bl3;
        boolean bl4;
        boolean bl5;
        Object object = CameraSet$Mode.dolly_zoom;
        boolean bl6 = true;
        if (object == cameraSet$Mode) {
            bl5 = bl6;
        } else {
            bl5 = false;
            cameraSet$Mode = null;
        }
        object = this.Z;
        if (bl5 && bl2) {
            bl4 = bl6;
        } else {
            bl4 = false;
            bl3 = null;
        }
        bl3 = bl4;
        ((MutableLiveData)object).postValue(bl3);
        if (!bl5 || !bl2) {
            bl6 = false;
        }
        return bl6;
    }

    public void T1(int n10) {
        CameraParam cameraParam = (CameraParam)this.F.getValue();
        if (cameraParam != null) {
            cameraParam.setWhiteBalance(n10);
            d d10 = this.b;
            d10.F0(cameraParam);
        }
    }

    public boolean U() {
        boolean bl2;
        Object object = this.Q.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.Q.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public boolean U0(CameraSet$Mode cameraSet$Mode) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.photograph;
        if (cameraSet$Mode2 != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.video) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.live) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.delay_video) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.sport_delay) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.panorama) != cameraSet$Mode) {
            bl2 = false;
            cameraSet$Mode = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean V0(CameraSet$Mode enum_, CameraSet$Panorama cameraSet$Panorama) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.photograph;
        if (cameraSet$Mode != enum_ && (cameraSet$Mode = CameraSet$Mode.video) != enum_ && ((cameraSet$Mode = CameraSet$Mode.panorama) != enum_ || (enum_ = CameraSet$Panorama.P_CLONE) == cameraSet$Panorama)) {
            bl2 = false;
            enum_ = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void V1(CameraSet$CountDownTime cameraSet$CountDownTime) {
        this.e.setValue((Object)cameraSet$CountDownTime);
        this.b.e0(cameraSet$CountDownTime);
    }

    public MutableLiveData W() {
        return this.R;
    }

    public boolean W0(CameraSet$Mode cameraSet$Mode) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.photograph;
        if (cameraSet$Mode2 != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.video) != cameraSet$Mode) {
            bl2 = false;
            cameraSet$Mode = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void W1(boolean bl2) {
        MutableLiveData mutableLiveData = this.Q;
        Boolean bl3 = bl2;
        d.v.e.i.h.g(mutableLiveData, bl3);
    }

    public String X(long l10, long l11) {
        LiveData liveData = this.F;
        if (liveData == null) {
            return u6.e(l11 / l10 / (long)30);
        }
        l11 /= l10;
        l10 = ((CameraParam)liveData.getValue()).getVideoResolution().c();
        return u6.e(l11 / l10);
    }

    public boolean X0(CameraSet$Mode cameraSet$Mode) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.panorama;
        if (cameraSet$Mode2 == cameraSet$Mode) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$Mode = null;
        }
        return bl2;
    }

    public void X1(CameraSet$DelayInterval cameraSet$DelayInterval) {
        this.v.setValue((Object)cameraSet$DelayInterval);
        this.m();
        this.b.f0(cameraSet$DelayInterval);
    }

    public MutableLiveData Y() {
        return this.v;
    }

    public boolean Y0(CameraSet$Mode enum_, CameraSet$Panorama cameraSet$Panorama) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.panorama;
        if (cameraSet$Mode == enum_ && (enum_ = CameraSet$Panorama.P_CLONE) == cameraSet$Panorama) {
            bl2 = true;
        } else {
            bl2 = false;
            enum_ = null;
        }
        return bl2;
    }

    public void Y1(CameraSet$DelayTime cameraSet$DelayTime) {
        this.w.setValue((Object)cameraSet$DelayTime);
        this.m();
        this.b.g0(cameraSet$DelayTime);
    }

    public CameraSet$DelayInterval Z() {
        Object object = this.v.getValue();
        if (object != null) {
            return (CameraSet$DelayInterval)((Object)this.v.getValue());
        }
        return this.b.n();
    }

    public boolean Z0(CameraSet$Mode cameraSet$Mode) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.panorama;
        if (cameraSet$Mode2 == cameraSet$Mode) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$Mode = null;
        }
        return bl2;
    }

    public void Z1(int n10) {
        MutableLiveData mutableLiveData = this.N;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public MutableLiveData a0() {
        return this.w;
    }

    public boolean a1(CameraSet$Mode cameraSet$Mode, boolean bl2, Integer n10) {
        boolean bl3;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.photograph;
        if (!(cameraSet$Mode2 != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.video) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.dolly_zoom) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.sport_delay) != cameraSet$Mode || bl2 || n10 != null && (bl3 = n10.intValue()) != (bl2 = 2))) {
            bl3 = true;
        } else {
            bl3 = false;
            cameraSet$Mode = null;
        }
        return bl3;
    }

    public void a2(Callable callable) {
        d.v.c.x1.i.l(callable);
    }

    public CameraSet$DelayTime b0() {
        Object object = this.w.getValue();
        if (object != null) {
            return (CameraSet$DelayTime)((Object)this.w.getValue());
        }
        return this.b.o();
    }

    public int b1() {
        int n10;
        CameraSet$Mode cameraSet$Mode;
        CameraSet$Mode cameraSet$Mode2 = this.I();
        if (cameraSet$Mode2 == (cameraSet$Mode = CameraSet$Mode.photograph)) {
            n10 = 0;
            cameraSet$Mode2 = null;
        } else {
            n10 = 8;
        }
        return n10;
    }

    public void b2(int n10) {
        MutableLiveData mutableLiveData = this.l;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
        this.b.k0(n10);
    }

    public void c() {
        CameraSet$Panorama cameraSet$Panorama = this.o0();
        List list = this.B0();
        boolean bl2 = list.contains((Object)cameraSet$Panorama);
        if (!bl2) {
            cameraSet$Panorama = CameraSet$Panorama.P_180;
            this.d2(cameraSet$Panorama);
        }
    }

    public MutableLiveData c0() {
        return this.N;
    }

    public boolean c1(CameraSet$Mode cameraSet$Mode) {
        boolean bl2;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.photograph;
        if (cameraSet$Mode2 != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.video) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.sport_delay) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.dolly_zoom) != cameraSet$Mode) {
            bl2 = false;
            cameraSet$Mode = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void c2(boolean bl2) {
        Object object = this.y;
        Boolean bl3 = bl2;
        ((MutableLiveData)object).setValue(bl3);
        object = this.b;
        ((d)object).n0(bl2);
        if (bl2) {
            CameraSet$CountDownTime cameraSet$CountDownTime = CameraSet$CountDownTime.c_0;
            this.V1(cameraSet$CountDownTime);
        }
    }

    public boolean d() {
        int n10;
        int n11;
        CameraSet$Mode cameraSet$Mode = this.I();
        Object object = CameraSet$Mode.photograph;
        int n12 = 0;
        int n13 = 1;
        if (cameraSet$Mode == object) {
            n11 = n13;
        } else {
            n11 = 0;
            cameraSet$Mode = null;
        }
        object = this.d.getValue();
        if (object != null && (n10 = ((Integer)(object = (Integer)this.d.getValue())).intValue()) == n13) {
            n10 = n13;
        } else {
            n10 = 0;
            object = null;
        }
        if (n11 != 0 && n10 != 0) {
            n12 = n13;
        }
        return n12 != 0;
    }

    public MutableLiveData d0() {
        return this.S;
    }

    public boolean d1() {
        boolean bl2;
        Enum enum_ = CameraSet$Mode.delay_video;
        Object object = this.c.getValue();
        if (enum_ == object && (enum_ = CameraSet$DelayTime.t_infinite) != (object = this.w.getValue())) {
            bl2 = true;
        } else {
            bl2 = false;
            enum_ = null;
        }
        return bl2;
    }

    public void d2(CameraSet$Panorama cameraSet$Panorama) {
        this.g.setValue((Object)cameraSet$Panorama);
        this.b.o0(cameraSet$Panorama);
    }

    public MutableLiveData e0() {
        return this.T;
    }

    public boolean e1(CameraSet$Mode enum_, boolean bl2, CameraSet$DelayTime cameraSet$DelayTime) {
        boolean bl3;
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.delay_video;
        if (cameraSet$Mode == enum_ && bl2 && (enum_ = CameraSet$DelayTime.t_infinite) != cameraSet$DelayTime) {
            bl3 = true;
        } else {
            bl3 = false;
            enum_ = null;
        }
        return bl3;
    }

    public void e2(int n10) {
        MutableLiveData mutableLiveData = this.W;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
        this.b.p0(n10);
    }

    public LiveData f0() {
        return this.A;
    }

    public boolean f1(CameraSet$Mode cameraSet$Mode, boolean bl2) {
        boolean bl3;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.delay_video;
        if (cameraSet$Mode2 == cameraSet$Mode) {
            bl3 = true;
        } else {
            bl3 = false;
            cameraSet$Mode = null;
        }
        return bl3;
    }

    public void f2(boolean bl2) {
        MutableLiveData mutableLiveData = this.h;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
        this.b.q0(bl2);
    }

    public MutableLiveData g0() {
        return this.l;
    }

    public boolean g1(CameraSet$Mode cameraSet$Mode, boolean bl2) {
        boolean bl3;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.video;
        if ((cameraSet$Mode2 == cameraSet$Mode || (cameraSet$Mode2 = CameraSet$Mode.slow_motion) == cameraSet$Mode || (cameraSet$Mode2 = CameraSet$Mode.dolly_zoom) == cameraSet$Mode) && bl2) {
            bl3 = true;
        } else {
            bl3 = false;
            cameraSet$Mode = null;
        }
        return bl3;
    }

    public void g2(CameraSet$CountDownTime cameraSet$CountDownTime) {
        this.f.setValue((Object)cameraSet$CountDownTime);
        this.b.r0(cameraSet$CountDownTime);
    }

    public MutableLiveData h0() {
        return this.G;
    }

    public boolean h1(CameraSet$Mode cameraSet$Mode, boolean bl2) {
        boolean bl3;
        CameraSet$Mode cameraSet$Mode2 = CameraSet$Mode.sport_delay;
        if (cameraSet$Mode2 == cameraSet$Mode && bl2) {
            bl3 = true;
        } else {
            bl3 = false;
            cameraSet$Mode = null;
        }
        return bl3;
    }

    public void h2(boolean bl2) {
        MutableLiveData mutableLiveData = this.P;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public MutableLiveData i0() {
        return this.y;
    }

    public boolean i1(CameraSet$Mode cameraSet$Mode, boolean bl2) {
        boolean bl3;
        CameraSet$Mode cameraSet$Mode2;
        if (bl2 && ((cameraSet$Mode2 = CameraSet$Mode.photograph) == cameraSet$Mode || (cameraSet$Mode2 = CameraSet$Mode.video) == cameraSet$Mode)) {
            bl3 = true;
        } else {
            bl3 = false;
            cameraSet$Mode = null;
        }
        return bl3;
    }

    public void i2(int n10) {
        MutableLiveData mutableLiveData = this.L;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public boolean j0() {
        return d.v.e.h.a.c((Boolean)this.i0().getValue());
    }

    public boolean j1() {
        int n10;
        List list = this.o();
        if (list != null && (n10 = (list = this.o()).size()) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            list = null;
        }
        return n10 != 0;
    }

    public void j2(boolean bl2) {
        MutableLiveData mutableLiveData = this.V;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public MutableLiveData k0() {
        return this.g;
    }

    public boolean k1() {
        CameraSet$Mode cameraSet$Mode;
        CameraSet$Mode cameraSet$Mode2 = (CameraSet$Mode)((Object)this.c.getValue());
        boolean bl2 = false;
        if (cameraSet$Mode2 != null && ((cameraSet$Mode = CameraSet$Mode.photograph) == cameraSet$Mode2 || (cameraSet$Mode = CameraSet$Mode.video) == cameraSet$Mode2 || (cameraSet$Mode = CameraSet$Mode.story) == cameraSet$Mode2 || (cameraSet$Mode = CameraSet$Mode.dolly_zoom) == cameraSet$Mode2)) {
            bl2 = true;
        }
        return bl2;
    }

    public void k2(boolean bl2) {
        MutableLiveData mutableLiveData = this.M;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public int l(k$a object) {
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.slow_motion;
        CameraSet$Mode cameraSet$Mode2 = (CameraSet$Mode)((Object)this.c.getValue());
        if (cameraSet$Mode == cameraSet$Mode2) {
            return 2131231531;
        }
        cameraSet$Mode = CameraSet$Mode.delay_video;
        if (cameraSet$Mode == cameraSet$Mode2) {
            cameraSet$Mode2 = ((k$a)object).a;
            boolean bl2 = d.v.d.i.g.k.u((Size)cameraSet$Mode2);
            if (bl2) {
                object = String.valueOf(((k$a)object).c());
                return this.i((String)object);
            }
            cameraSet$Mode2 = ((k$a)object).a;
            bl2 = d.v.d.i.g.k.r((Size)cameraSet$Mode2);
            if (bl2) {
                object = String.valueOf(((k$a)object).c());
                return this.f((String)object);
            }
            cameraSet$Mode2 = ((k$a)object).a;
            bl2 = d.v.d.i.g.k.s((Size)cameraSet$Mode2);
            if (bl2) {
                object = String.valueOf(((k$a)object).c());
                return this.g((String)object);
            }
            return 2131231442;
        }
        cameraSet$Mode = CameraSet$Mode.sport_delay;
        if (cameraSet$Mode == cameraSet$Mode2) {
            cameraSet$Mode2 = ((k$a)object).a;
            boolean bl3 = d.v.d.i.g.k.u((Size)cameraSet$Mode2);
            if (bl3) {
                return this.k();
            }
            object = ((k$a)object).a;
            boolean bl4 = d.v.d.i.g.k.r((Size)object);
            if (bl4) {
                return this.j();
            }
            return this.k();
        }
        cameraSet$Mode2 = ((k$a)object).a;
        boolean bl5 = d.v.d.i.g.k.u((Size)cameraSet$Mode2);
        if (bl5) {
            object = String.valueOf(((k$a)object).c());
            return this.i((String)object);
        }
        cameraSet$Mode2 = ((k$a)object).a;
        bl5 = d.v.d.i.g.k.r((Size)cameraSet$Mode2);
        if (bl5) {
            object = String.valueOf(((k$a)object).c());
            return this.f((String)object);
        }
        cameraSet$Mode2 = ((k$a)object).a;
        bl5 = d.v.d.i.g.k.s((Size)cameraSet$Mode2);
        if (bl5) {
            object = String.valueOf(((k$a)object).c());
            return this.g((String)object);
        }
        object = String.valueOf(((k$a)object).c());
        return this.i((String)object);
    }

    public MutableLiveData l0() {
        return this.W;
    }

    public boolean l1() {
        Object object;
        int n10;
        Object object2 = this.d.getValue();
        boolean bl2 = false;
        if (object2 == null) {
            return false;
        }
        object2 = this.o();
        if (object2 != null && (n10 = (object2 = this.o()).size()) > 0 && (object2 = CameraSet$Mode.story) != (object = this.c.getValue()) && (n10 = ((Integer)(object2 = (Integer)this.d.getValue())).intValue()) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public void l2(String object) {
        this.x = object;
        d d10 = this.b;
        d10.t0((String)object);
        object = this.c.getValue();
        if (object != null) {
            object = (CameraSet$Mode)((Object)this.c.getValue());
            this.N1((CameraSet$Mode)((Object)object));
        }
    }

    public MutableLiveData m0() {
        return this.X;
    }

    public boolean m1() {
        CameraSet$Mode cameraSet$Mode = CameraSet$Mode.photograph;
        CameraSet$Mode cameraSet$Mode2 = this.I();
        return cameraSet$Mode.equals((Object)cameraSet$Mode2);
    }

    public void m2(boolean bl2) {
        MutableLiveData mutableLiveData = this.i;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
        this.b.u0(bl2);
    }

    public List n() {
        int n10;
        List list = this.E.b;
        Object object = this.m.getValue();
        if (object != null && (n10 = this.l1()) != 0) {
            object = CameraSet$Mode.photograph;
            Object object2 = this.c.getValue();
            int n11 = 3;
            if (object == object2 && (n10 = ((Integer)(object = (Integer)this.m.getValue())).intValue()) == 0) {
                object = new ArrayList();
                this.b((List)object, 0, list);
                this.b((List)object, 2, list);
                this.b((List)object, 1, list);
                this.b((List)object, n11, list);
                return object;
            }
            object = new ArrayList();
            this.b((List)object, 0, list);
            this.b((List)object, n11, list);
            return object;
        }
        return null;
    }

    public boolean n1(CameraSet$Mode cameraSet$Mode, boolean bl2) {
        boolean bl3;
        CameraSet$Mode cameraSet$Mode2;
        if (bl2 && ((cameraSet$Mode2 = CameraSet$Mode.photograph) == cameraSet$Mode || (cameraSet$Mode2 = CameraSet$Mode.video) == cameraSet$Mode)) {
            bl3 = true;
        } else {
            bl3 = false;
            cameraSet$Mode = null;
        }
        return bl3;
    }

    public void n2(boolean bl2) {
        MutableLiveData mutableLiveData = this.j;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
        this.b.C0(bl2);
    }

    public List o() {
        return this.E.a;
    }

    public CameraSet$Panorama o0() {
        Object object = this.g.getValue();
        object = object == null ? CameraSet$Panorama.P_180 : (CameraSet$Panorama)((Object)this.g.getValue());
        return object;
    }

    public boolean o1() {
        int n10;
        CameraSet$Mode cameraSet$Mode = (CameraSet$Mode)((Object)this.c.getValue());
        int[] nArray = u6$a.a;
        int n11 = cameraSet$Mode.ordinal();
        int n12 = 1;
        if ((n11 = nArray[n11]) != n12 && n11 != (n10 = 2) && n11 != (n10 = 3) && n11 != (n10 = 4)) {
            return false;
        }
        return n12 != 0;
    }

    public void o2(String string2) {
        this.U.setValue(string2);
    }

    public void onCleared() {
        this.a2(null);
    }

    public MutableLiveData p() {
        return this.n;
    }

    public MutableLiveData p0() {
        return this.f;
    }

    public void p2(int n10) {
        int n11 = 170;
        n10 = n10 >= n11 ? 2131231708 : (n10 >= (n11 = 150) ? 2131231716 : (n10 >= (n11 = 130) ? 2131231715 : (n10 >= (n11 = 110) ? 2131231714 : (n10 >= (n11 = 90) ? 2131231713 : (n10 >= (n11 = 70) ? 2131231712 : (n10 >= (n11 = 50) ? 2131231711 : (n10 >= (n11 = 30) ? 2131231710 : (n10 >= (n11 = 10) ? 2131231709 : (n10 >= 0 ? 2131231707 : 2131231706)))))))));
        MutableLiveData mutableLiveData = this.O;
        Integer n12 = n10;
        mutableLiveData.setValue(n12);
    }

    public CameraSet$CountDownTime q0() {
        Object object = this.f.getValue();
        object = object == null ? CameraSet$CountDownTime.c_0 : (CameraSet$CountDownTime)((Object)this.f.getValue());
        return object;
    }

    public /* synthetic */ LiveData q1(CameraSet$Mode cameraSet$Mode) {
        return this.p1(cameraSet$Mode);
    }

    public void q2(int n10) {
        MutableLiveData mutableLiveData = this.K;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public MutableLiveData r() {
        return this.p;
    }

    public List r0() {
        return this.E.d;
    }

    public void r1() {
        ObservableBoolean observableBoolean = this.z;
        boolean bl2 = this.j0();
        observableBoolean.set(bl2);
        observableBoolean = this.z;
        boolean bl3 = observableBoolean.get();
        if (bl3) {
            bl3 = false;
            observableBoolean = null;
            this.c2(false);
        }
    }

    public void r2(int n10) {
        MutableLiveData mutableLiveData = this.u;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
        this.b.D0(n10);
    }

    public MutableLiveData s() {
        return this.r;
    }

    public MutableLiveData s0() {
        return this.V;
    }

    public void s1() {
        ObservableBoolean observableBoolean = this.z;
        boolean bl2 = observableBoolean.get();
        if (bl2) {
            bl2 = true;
            this.c2(bl2);
        }
        this.z.set(false);
    }

    public LiveData t() {
        return this.m;
    }

    public List t0() {
        return this.E.c;
    }

    public void t1(boolean bl2) {
        d d10 = this.b;
        d10.W((int)((bl2 ^= true) ? 1 : 0));
    }

    public MutableLiveData u() {
        return this.s;
    }

    public MutableLiveData u0() {
        return this.L;
    }

    public void u1(String string2) {
    }

    public MutableLiveData v() {
        return this.t;
    }

    public MutableLiveData v0() {
        return this.h;
    }

    public void v1(String string2) {
    }

    public MutableLiveData w() {
        return this.o;
    }

    public MutableLiveData w0() {
        return this.M;
    }

    public MutableLiveData x() {
        return this.q;
    }

    public String x0(int n10, long l10) {
        long l11 = n10;
        return u6.e(l10 / l11);
    }

    public a y() {
        return this.E;
    }

    public String y0() {
        return this.x;
    }

    public MutableLiveData z() {
        return this.d;
    }

    public int z0() {
        String string2 = this.x;
        string2.hashCode();
        int n10 = string2.hashCode();
        int n11 = 1;
        int n12 = -1;
        switch (n10) {
            default: {
                break;
            }
            case 50587: {
                String string3 = "30X";
                boolean bl2 = string2.equals(string3);
                if (!bl2) break;
                n12 = 3;
                break;
            }
            case 48820: {
                String string4 = "15X";
                boolean bl3 = string2.equals(string4);
                if (!bl3) break;
                n12 = 2;
                break;
            }
            case 48665: {
                String string5 = "10X";
                boolean bl4 = string2.equals(string5);
                if (!bl4) break;
                n12 = n11;
                break;
            }
            case 1731: {
                String string6 = "5X";
                boolean bl5 = string2.equals(string6);
                if (!bl5) break;
                n12 = 0;
            }
        }
        switch (n12) {
            default: {
                return n11;
            }
            case 3: {
                return 30;
            }
            case 2: {
                return 15;
            }
            case 1: {
                return 10;
            }
            case 0: 
        }
        return 5;
    }

    public void z1(List list) {
        this.n.setValue(list);
        this.b.T(list);
    }
}

