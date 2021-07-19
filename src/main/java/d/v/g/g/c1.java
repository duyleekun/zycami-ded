/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.g.g;

import android.util.SparseArray;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.device.data.local.entity.DeviceInfo;
import com.zhiyun.device.data.local.entity.DeviceInfo$Model;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e.l.b2;
import d.v.e.l.w1;
import d.v.g.f.b.d.c;
import d.v.g.f.b.e.b;
import d.v.g.g.c1$a;
import d.v.g.g.d;
import d.v.g.g.d1;
import d.v.g.g.e;
import d.v.g.g.f;
import d.v.g.g.g;
import d.v.g.g.h;
import d.v.g.g.i;
import d.v.g.g.j;
import d.v.g.g.k;
import java.util.List;
import java.util.stream.IntStream;
import m.a.a;

public class c1
extends ViewModel {
    private static final int l = 5;
    public MediatorLiveData a;
    public MediatorLiveData b;
    public d.v.e.i.j c;
    private c d;
    private d.v.g.f.b.d.e e;
    private b f;
    private boolean g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;

    public c1() {
        Object object = new MediatorLiveData();
        this.a = object;
        object = new MediatorLiveData();
        this.b = object;
        this.c = object;
        this.d = object = d.v.g.f.b.c.b().a().f();
        this.e = object = d.v.g.f.b.c.b().a().g();
        this.f = object = d.v.g.f.b.e.b.A();
    }

    private /* synthetic */ void A(DeviceInfo object) {
        int n10;
        float f10;
        Object object2;
        SparseArray sparseArray = new SparseArray();
        Object object3 = this.e;
        int n11 = ((DeviceInfo)object).getSerial();
        if ((object3 = object3.d(n11, (String)(object2 = ((DeviceInfo)object).getVer()))) != null && ((n11 = (int)(this.k ? 1 : 0)) == 0 || (n11 = (int)(((FirmwareInfo)object3).isShowPopup() ? 1 : 0)) != 0 && (n11 = (int)(this.t(f10 = ((FirmwareInfo)object3).getVersion(), n10 = ((DeviceInfo)object).getSerial()) ? 1 : 0)) != 0)) {
            n11 = ((DeviceInfo)object).getSerial();
            sparseArray.put(n11, object3);
        }
        object3 = ((DeviceInfo)object).getSubModels().iterator();
        while ((n11 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            int n12;
            float f11;
            float f12;
            String string2;
            DeviceInfo$Model deviceInfo$Model = (DeviceInfo$Model)object3.next();
            object2 = this.e;
            int n13 = deviceInfo$Model.getSerial();
            if ((object2 = object2.d(n13, string2 = String.valueOf(f12 = deviceInfo$Model.getVersion()))) == null || (n13 = (int)(this.k ? 1 : 0)) != 0 && ((n13 = (int)(((FirmwareInfo)object2).isShowPopup() ? 1 : 0)) == 0 || (n13 = (int)(this.t(f11 = ((FirmwareInfo)object2).getVersion(), n12 = ((DeviceInfo)object).getSerial()) ? 1 : 0)) == 0)) continue;
            n11 = deviceInfo$Model.getSerial();
            sparseArray.put(n11, object2);
        }
        object3 = this.b;
        object = Pair.create(object, sparseArray);
        ((MutableLiveData)object3).postValue(object);
    }

    private /* synthetic */ String G(Pair object) {
        int n10;
        String string2 = "";
        if (object == null) {
            this.R();
            return string2;
        }
        object = (SparseArray)((Pair)object).second;
        if (object != null && (n10 = object.size()) != 0) {
            n10 = 0;
            if ((object = (FirmwareInfo)object.valueAt(0)) == null) {
                this.R();
                return string2;
            }
            return ((FirmwareInfo)object).getVer();
        }
        this.R();
        return string2;
    }

    public static /* synthetic */ void I(c1 c12) {
        c12.k();
    }

    public static /* synthetic */ void J(c1 c12, Pair pair) {
        c12.l(pair);
    }

    private /* synthetic */ void K(DeviceInfo deviceInfo) {
        this.d.a(deviceInfo);
    }

    private void P(Runnable runnable) {
        d.v.e.l.c1.b().a().execute(runnable);
    }

    public static /* synthetic */ void b(c1 c12, Runnable runnable) {
        c12.P(runnable);
    }

    public static /* synthetic */ boolean c(c1 c12) {
        return c12.k;
    }

    public static /* synthetic */ void d(c1 c12, DeviceInfo deviceInfo) {
        c12.p(deviceInfo);
    }

    public static /* synthetic */ boolean e(c1 c12) {
        return c12.g;
    }

    public static /* synthetic */ int f(c1 c12) {
        return c12.h;
    }

    public static /* synthetic */ int g(c1 c12) {
        int n10;
        int n11 = c12.h;
        c12.h = n10 = n11 + 1;
        return n11;
    }

    public static /* synthetic */ void i(c1 c12, DeviceInfo deviceInfo) {
        c12.s(deviceInfo);
    }

    public static /* synthetic */ d.v.g.f.b.d.e j(c1 c12) {
        return c12.e;
    }

    private void k() {
        boolean bl2 = this.i;
        if (!bl2) {
            return;
        }
        bl2 = b2.o();
        if (!bl2) {
            return;
        }
        bl2 = this.u();
        if (!bl2) {
            return;
        }
        SparseArray sparseArray = (SparseArray)((Pair)this.b.getValue()).second;
        d1.i().a(sparseArray);
    }

    private void l(Pair object) {
        if (object == null) {
            return;
        }
        boolean bl2 = this.m((Pair)object);
        if (!bl2) {
            bl2 = this.j;
            if (bl2) {
                object = this.a;
                Boolean bl3 = Boolean.FALSE;
                ((MutableLiveData)object).setValue(bl3);
            }
            return;
        }
        object = this.a;
        Boolean bl4 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(bl4);
        object = new g(this);
        this.P((Runnable)object);
    }

    private void o(DeviceInfo object) {
        Object object2;
        Object object3 = null;
        this.j = false;
        boolean bl2 = this.k;
        if (bl2) {
            object3 = this.e;
            int n10 = ((DeviceInfo)object).getSerial();
            object2 = ((DeviceInfo)object).getVer();
            object3 = object3.f(n10, (String)object2);
        } else {
            object3 = this.e;
            int n11 = ((DeviceInfo)object).getSerial();
            object2 = ((DeviceInfo)object).getVer();
            object3 = object3.e(n11, (String)object2);
        }
        Object object4 = this.a;
        object2 = new d(this, (LiveData)object3, (DeviceInfo)object);
        ((MediatorLiveData)object4).addSource((LiveData)object3, (Observer)object2);
        object = this.a;
        object3 = this.b;
        ((MediatorLiveData)object).removeSource((LiveData)object3);
        object = this.a;
        object3 = this.b;
        object4 = new i(this);
        ((MediatorLiveData)object).addSource((LiveData)object3, (Observer)object4);
    }

    private void p(DeviceInfo deviceInfo) {
        this.j = true;
        e e10 = new e(this, deviceInfo);
        this.P(e10);
    }

    private void s(DeviceInfo deviceInfo) {
        Object object = d.v.g.f.c.b.a;
        int n10 = deviceInfo.getSerial();
        float f10 = deviceInfo.getVersion();
        String string2 = w1.a();
        object = object.b(n10, f10, string2);
        c1$a c1$a = new c1$a(this, deviceInfo);
        object.h(c1$a);
    }

    private boolean t(float f10, int n10) {
        List list = this.f.z(f10);
        String string2 = String.valueOf(n10);
        return list.contains(string2) ^ true;
    }

    public static /* synthetic */ boolean v(SparseArray object, int n10) {
        boolean bl2;
        if ((object = object.valueAt(n10)) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private /* synthetic */ void w(DeviceInfo deviceInfo) {
        this.d.f(deviceInfo);
    }

    private /* synthetic */ void y(LiveData liveData, DeviceInfo deviceInfo, FirmwareInfo objectArray) {
        int n10;
        float f10;
        boolean bl2;
        MediatorLiveData mediatorLiveData = this.a;
        mediatorLiveData.removeSource(liveData);
        if (objectArray != null && (!(bl2 = this.k) || (bl2 = this.t(f10 = objectArray.getVersion(), n10 = deviceInfo.getSerial())))) {
            this.p(deviceInfo);
            return;
        }
        objectArray = new Object[]{};
        m.a.a.b("get firmware info from db, but value is null.", objectArray);
        this.s(deviceInfo);
        this.h = 0;
    }

    public /* synthetic */ void F(DeviceInfo deviceInfo) {
        this.A(deviceInfo);
    }

    public /* synthetic */ String H(Pair pair) {
        return this.G(pair);
    }

    public /* synthetic */ void L(DeviceInfo deviceInfo) {
        this.K(deviceInfo);
    }

    public void M(Stabilizer stabilizer, boolean bl2) {
        this.N(stabilizer, true, bl2);
    }

    /*
     * WARNING - void declaration
     */
    public void N(Stabilizer object, boolean bl2, boolean bl3) {
        void var3_4;
        this.k = bl2;
        if (object == null) {
            return;
        }
        this.i = var3_4;
        Model model = ((Stabilizer)object).H2();
        float f10 = ((Stabilizer)object).s2();
        String string2 = ((Stabilizer)object).M2();
        DeviceInfo deviceInfo = new DeviceInfo();
        int n10 = model.getOtaCode();
        deviceInfo.setSerial(n10);
        deviceInfo.setVersion(f10);
        deviceInfo.setDeviceName(string2);
        object = ((Stabilizer)object).G2();
        deviceInfo.setDeviceSn((String)object);
        object = new k(this, deviceInfo);
        this.P((Runnable)object);
        this.o(deviceInfo);
    }

    public void Q(boolean bl2) {
        int n10;
        Object object = (Pair)this.b.getValue();
        if (object == null) {
            return;
        }
        Object object2 = (DeviceInfo)((Pair)object).first;
        object = (SparseArray)((Pair)object).second;
        if (object2 != null && object != null && (n10 = object.size()) > 0) {
            n10 = 0;
            if ((object = (FirmwareInfo)object.valueAt(0)) == null) {
                return;
            }
            float f10 = ((FirmwareInfo)object).getVersion();
            int n11 = ((DeviceInfo)object2).getSerial();
            object2 = String.valueOf(n11);
            if (bl2) {
                b b10 = this.f;
                b10.B(f10, (String)object2);
            } else {
                b b11 = this.f;
                b11.C(f10, (String)object2);
            }
        }
    }

    public void R() {
        MediatorLiveData mediatorLiveData = this.a;
        Boolean bl2 = Boolean.FALSE;
        mediatorLiveData.setValue(bl2);
    }

    public void S(boolean bl2) {
        this.g = bl2;
    }

    public boolean m(Pair objectArray) {
        int n10;
        if (objectArray == null) {
            objectArray = new Object[]{};
            m.a.a.b("Check has firmware update false due to pair is null", objectArray);
            return false;
        }
        Object object = (DeviceInfo)objectArray.first;
        objectArray = (Object[])objectArray.second;
        if (object != null && objectArray != null && (n10 = objectArray.size()) > 0) {
            j j10;
            n10 = objectArray.size();
            object = IntStream.range(0, n10);
            boolean bl2 = object.allMatch(j10 = new j((SparseArray)objectArray));
            if (bl2) {
                objectArray = new Object[]{};
                m.a.a.b("Check has firmware update false due to info map value all null", objectArray);
                return false;
            }
            return true;
        }
        objectArray = new Object[]{};
        m.a.a.b("Check has firmware update false due to deviceInfo null or info map null", objectArray);
        return false;
    }

    public void n(DeviceInfo deviceInfo) {
        h h10 = new h(this, deviceInfo);
        this.P(h10);
        this.b.setValue(null);
    }

    public void onCleared() {
        super.onCleared();
        this.g = false;
    }

    public LiveData r() {
        MediatorLiveData mediatorLiveData = this.b;
        f f10 = new f(this);
        return Transformations.map(mediatorLiveData, f10);
    }

    public boolean u() {
        int n10;
        Object object = (Pair)this.b.getValue();
        if (object == null) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo)((Pair)object).first;
        object = (SparseArray)((Pair)object).second;
        if (deviceInfo != null && object != null && (n10 = object.size()) > 0) {
            if ((object = (FirmwareInfo)object.valueAt(0)) == null) {
                return false;
            }
            return ((FirmwareInfo)object).isOtaUpdate();
        }
        return false;
    }

    public /* synthetic */ void x(DeviceInfo deviceInfo) {
        this.w(deviceInfo);
    }

    public /* synthetic */ void z(LiveData liveData, DeviceInfo deviceInfo, FirmwareInfo firmwareInfo) {
        this.y(liveData, deviceInfo, firmwareInfo);
    }
}

