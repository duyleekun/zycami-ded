/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.icu.text.SimpleDateFormat
 *  android.util.Base64
 */
package com.zhiyun.cama.set.bind;

import android.icu.text.SimpleDateFormat;
import android.util.Base64;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$BindOperateState;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$Status;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$a;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$b;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$c;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$d;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$e;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$f;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$g;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleConnection$j;
import com.zhiyun.protocol.message.bl.active.ActiveState;
import com.zhiyun.stabilizer.Stabilizer;
import com.zhiyun.stabilizer.entities.ActiveInfo;
import d.v.c.q1.h0.b;
import d.v.c.q1.h0.c;
import d.v.c.q1.h0.e;
import d.v.e.h.a;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.e0.ce;
import e.a.i0;
import e.a.v0.g;
import e.a.z;
import java.text.ParsePosition;
import java.util.Date;
import java.util.List;
import k.d;
import k.f;

public class DeviceBindViewModel
extends ViewModel {
    public static final int m = 711;
    public static final String n = "bind";
    public static final String o = "success";
    public MutableLiveData a;
    public MutableLiveData b;
    public MutableLiveData c;
    public MutableLiveData d;
    public MutableLiveData e;
    public MutableLiveData f;
    public MutableLiveData g;
    private final j h;
    private final BleConnection i;
    private boolean j;
    private e.a.s0.b k;
    private final BleConnection$j l;

    public DeviceBindViewModel() {
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
        this.h = object;
        this.l = object = new DeviceBindViewModel$a(this);
        this.i = object = BleConnection.W();
    }

    public static /* synthetic */ int G(DeviceBindViewModel deviceBindViewModel, BindDeviceInfo bindDeviceInfo, BindDeviceInfo bindDeviceInfo2) {
        return deviceBindViewModel.n(bindDeviceInfo, bindDeviceInfo2);
    }

    private /* synthetic */ void H(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.p();
        } else {
            object = this.h;
            DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_FORCE_UPDATE;
            d.v.e.i.h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
        }
    }

    private /* synthetic */ void J(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.x();
        } else {
            object = this.h;
            DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_ACTIVATION;
            d.v.e.i.h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
        }
    }

    private /* synthetic */ void L(Throwable object) {
        object = this.h;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_DEVICE_ERROR;
        d.v.e.i.h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
    }

    private /* synthetic */ void N(Stabilizer object, ActiveInfo object2) {
        ActiveState activeState;
        ActiveState activeState2;
        if (object2 != null && (activeState2 = ((ActiveInfo)object2).state) != (activeState = ActiveState.INACTIVATED) && (object2 = (Object)((ActiveInfo)object2).activeCode) != null) {
            activeState2 = null;
            object2 = Base64.encodeToString((byte[])object2, (int)0);
            object = ((Stabilizer)object).G2();
            this.u((String)object2, (String)object);
        }
    }

    private void W(List list) {
        b b10 = new b(this);
        list.sort(b10);
        this.g.postValue(list);
    }

    public static Date Y(String string2) {
        ParsePosition parsePosition = new ParsePosition(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        return simpleDateFormat.parse(string2, parsePosition);
    }

    public static /* synthetic */ boolean b(DeviceBindViewModel deviceBindViewModel) {
        return deviceBindViewModel.j;
    }

    public static /* synthetic */ boolean c(DeviceBindViewModel deviceBindViewModel, boolean bl2) {
        deviceBindViewModel.j = bl2;
        return bl2;
    }

    public static /* synthetic */ void d(DeviceBindViewModel deviceBindViewModel, String string2, String string3) {
        deviceBindViewModel.l(string2, string3);
    }

    public static /* synthetic */ j e(DeviceBindViewModel deviceBindViewModel) {
        return deviceBindViewModel.h;
    }

    public static /* synthetic */ void f(DeviceBindViewModel deviceBindViewModel, List list) {
        deviceBindViewModel.W(list);
    }

    public static /* synthetic */ String g(DeviceBindViewModel deviceBindViewModel) {
        return deviceBindViewModel.v();
    }

    public static /* synthetic */ String i(DeviceBindViewModel deviceBindViewModel) {
        return deviceBindViewModel.w();
    }

    private void l(String object, String object2) {
        String string2 = d.v.a.f.c.b.N().P();
        object = d.v.c.v0.l.e.a.c(string2, (String)object, (String)object2);
        object2 = new DeviceBindViewModel$c(this);
        object.h((f)object2);
    }

    private int n(BindDeviceInfo object, BindDeviceInfo object2) {
        boolean bl2 = ((Date)(object = DeviceBindViewModel.Y(((BindDeviceInfo)object).getBindAt()))).before((Date)(object2 = DeviceBindViewModel.Y(((BindDeviceInfo)object2).getBindAt())));
        if (bl2) {
            return 1;
        }
        boolean bl3 = ((Date)object2).before((Date)object);
        if (bl3) {
            return -1;
        }
        return 0;
    }

    private void o(Stabilizer object) {
        BindDeviceInfo bindDeviceInfo = new BindDeviceInfo();
        String string2 = ((Stabilizer)object).H2().getName();
        bindDeviceInfo.setDeviceModel(string2);
        string2 = ((Stabilizer)object).b;
        bindDeviceInfo.setDeviceName(string2);
        object = ((Stabilizer)object).G2();
        bindDeviceInfo.setSn((String)object);
        object = this.v();
        bindDeviceInfo.setFirmwareVersion((String)object);
        d.v.e.i.h.g(this.b, bindDeviceInfo);
    }

    private void p() {
        Object object = this.i.a0();
        c c10 = new c(this);
        d.v.c.q1.h0.f f10 = new d.v.c.q1.h0.f(this);
        this.k = object = ((i0)object).c(c10, f10);
    }

    private String v() {
        Object object = ce.E0().a1();
        BleConnection bleConnection = BleConnection.W();
        boolean bl2 = bleConnection.c0();
        if (bl2 && object != null) {
            float f10 = ((Stabilizer)object).s2();
            object = String.valueOf(f10);
        } else {
            float f11 = 0.0f;
            object = null;
        }
        return object;
    }

    private String w() {
        Object object = ce.E0().a1();
        BleConnection bleConnection = BleConnection.W();
        boolean bl2 = bleConnection.c0();
        object = bl2 && object != null ? ((Stabilizer)object).G2() : "";
        return object;
    }

    private void x() {
        ActiveInfo activeInfo = this.i.S();
        ce ce2 = ce.E0();
        DeviceBindViewModel$b deviceBindViewModel$b = new DeviceBindViewModel$b(this, activeInfo);
        ce2.z0(deviceBindViewModel$b);
    }

    public boolean A() {
        boolean bl2;
        Object object = (BindDeviceInfo)this.b.getValue();
        Object object2 = (BindDeviceInfo)this.a.getValue();
        if (object != null && object2 != null && (bl2 = ((String)(object = ((BindDeviceInfo)object).getSn())).equalsIgnoreCase((String)(object2 = ((BindDeviceInfo)object2).getSn())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean F() {
        return d.v.e.h.a.c((Boolean)this.c.getValue());
    }

    public /* synthetic */ void I(Boolean bl2) {
        this.H(bl2);
    }

    public /* synthetic */ void K(Boolean bl2) {
        this.J(bl2);
    }

    public /* synthetic */ void M(Throwable throwable) {
        this.L(throwable);
    }

    public /* synthetic */ void P(Stabilizer stabilizer, ActiveInfo activeInfo) {
        this.N(stabilizer, activeInfo);
    }

    public void Q(String object, String object2) {
        String string2 = d.v.a.f.c.b.N().P();
        object = d.v.c.v0.l.e.a.a(string2, (String)object2, (String)object);
        object2 = new DeviceBindViewModel$g(this);
        object.h((f)object2);
    }

    public void R() {
        BleConnection bleConnection = this.i;
        BleConnection$j bleConnection$j = this.l;
        bleConnection.N0(bleConnection$j);
    }

    public void S(boolean bl2) {
        MutableLiveData mutableLiveData = this.e;
        Boolean bl3 = bl2;
        mutableLiveData.postValue(bl3);
    }

    public void T(boolean bl2) {
        boolean bl3;
        Object object;
        if (bl2 && ((object = this.c.getValue()) == null || !(bl3 = ((Boolean)(object = (Boolean)this.c.getValue())).booleanValue()))) {
            this.t();
        }
        if (!bl2) {
            this.m();
        }
        object = this.c;
        Boolean bl4 = bl2;
        d.v.e.i.h.g((MutableLiveData)object, bl4);
    }

    public void U(BindDeviceInfo bindDeviceInfo) {
        this.a.postValue(bindDeviceInfo);
    }

    public void V(boolean bl2) {
        MutableLiveData mutableLiveData = this.f;
        Boolean bl3 = bl2;
        mutableLiveData.postValue(bl3);
    }

    public void X() {
        boolean bl2;
        e.a.s0.b b10 = this.k;
        if (b10 != null && !(bl2 = b10.isDisposed())) {
            b10 = this.k;
            b10.dispose();
        }
    }

    public void Z(int n10) {
        Object object = this.h;
        DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_START;
        d.v.e.i.h.g((MutableLiveData)object, (Object)deviceBindViewModel$BindOperateState);
        object = d.v.a.f.c.b.N().P();
        d d10 = d.v.c.v0.l.e.a.d((String)object, n10);
        object = new DeviceBindViewModel$e(this);
        d10.h((f)object);
    }

    public void j() {
        this.c.setValue(null);
        this.b.setValue(null);
        BleConnection bleConnection = this.i;
        BleConnection$j bleConnection$j = this.l;
        bleConnection.J(bleConnection$j);
    }

    public void k() {
        Object object = this.h;
        Object object2 = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_START;
        d.v.e.i.h.g((MutableLiveData)object, object2);
        object = this.i;
        boolean bl2 = ((BleConnection)object).c0();
        if (!bl2) {
            object = this.h;
            object2 = DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_DEVICE_ERROR;
            d.v.e.i.h.g((MutableLiveData)object, object2);
            return;
        }
        object = this.a;
        object2 = this.b.getValue();
        d.v.e.i.h.g((MutableLiveData)object, object2);
        object = this.i.V();
        object2 = new d.v.c.q1.h0.d(this);
        this.k = object = ((z)object).d((g)object2);
    }

    public void m() {
        d.v.e.i.h.g(this.b, null);
    }

    public void onCleared() {
        super.onCleared();
        BleConnection bleConnection = this.i;
        BleConnection$j bleConnection$j = this.l;
        bleConnection.N0(bleConnection$j);
    }

    public void r() {
        Object object = d.v.a.f.c.b.N().P();
        Object object2 = this.d;
        DeviceBindViewModel$Status deviceBindViewModel$Status = DeviceBindViewModel$Status.RUNNING;
        d.v.e.i.h.g((MutableLiveData)object2, (Object)deviceBindViewModel$Status);
        object = d.v.c.v0.l.e.a.b((String)object);
        object2 = new DeviceBindViewModel$d(this);
        object.h((f)object2);
    }

    public j s() {
        return this.h;
    }

    public void t() {
        Stabilizer stabilizer = BleConnection.W().T();
        if (stabilizer == null) {
            return;
        }
        this.o(stabilizer);
        ce ce2 = ce.E0();
        e e10 = new e(this, stabilizer);
        ce2.i0(e10);
    }

    public void u(String object, String object2) {
        String string2 = d.v.a.f.c.b.N().P();
        object = d.v.c.v0.l.e.a.a(string2, (String)object2, (String)object);
        object2 = new DeviceBindViewModel$f(this);
        object.h((f)object2);
    }

    public BindDeviceInfo y() {
        return (BindDeviceInfo)this.a.getValue();
    }

    public boolean z() {
        boolean bl2;
        Object object = (BindDeviceInfo)this.b.getValue();
        if (object != null && (object = ((BindDeviceInfo)object).getBindAt()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

