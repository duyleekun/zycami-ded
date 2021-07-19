/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 */
package com.huawei.multimedia.liteav.audiokit.interfaces;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit$FeatureType;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit$a;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKit$b;
import com.tencent.liteav.basic.log.TXCLog;
import d.j.e.a.b.b.a;
import d.j.e.a.b.b.b;
import d.j.e.a.b.b.c;
import java.util.ArrayList;
import java.util.List;

public class HwAudioKit {
    private static final String h = "HwAudioKit.HwAudioKit";
    private static final String i = "com.huawei.multimedia.audioengine.HwAudioEngineService";
    private static final List j;
    private Context a = null;
    private d.j.e.a.a.a b = null;
    private boolean c = false;
    private b d;
    private IBinder e = null;
    private ServiceConnection f;
    private IBinder.DeathRecipient g;

    static {
        ArrayList arrayList;
        j = arrayList = new ArrayList(0);
    }

    public HwAudioKit(Context context, c c10) {
        Object object = new HwAudioKit$a(this);
        this.f = object;
        object = new HwAudioKit$b(this);
        this.g = object;
        this.d = object = d.j.e.a.b.b.b.d();
        ((b)object).g(c10);
        this.a = context;
    }

    public static /* synthetic */ d.j.e.a.a.a a(HwAudioKit hwAudioKit) {
        return hwAudioKit.b;
    }

    public static /* synthetic */ d.j.e.a.a.a b(HwAudioKit hwAudioKit, d.j.e.a.a.a a10) {
        hwAudioKit.b = a10;
        return a10;
    }

    public static /* synthetic */ boolean c(HwAudioKit hwAudioKit, boolean bl2) {
        hwAudioKit.c = bl2;
        return bl2;
    }

    public static /* synthetic */ b d(HwAudioKit hwAudioKit) {
        return hwAudioKit.d;
    }

    public static /* synthetic */ Context e(HwAudioKit hwAudioKit) {
        return hwAudioKit.a;
    }

    public static /* synthetic */ void f(HwAudioKit hwAudioKit, String string2, String string3) {
        hwAudioKit.q(string2, string3);
    }

    public static /* synthetic */ void g(HwAudioKit hwAudioKit, IBinder iBinder) {
        hwAudioKit.r(iBinder);
    }

    public static /* synthetic */ IBinder.DeathRecipient h(HwAudioKit hwAudioKit) {
        return hwAudioKit.g;
    }

    public static /* synthetic */ IBinder i(HwAudioKit hwAudioKit) {
        return hwAudioKit.e;
    }

    public static /* synthetic */ IBinder j(HwAudioKit hwAudioKit, IBinder iBinder) {
        hwAudioKit.e = iBinder;
        return iBinder;
    }

    private void k(Context context) {
        Object object;
        int n10 = 1;
        Object object2 = new Object[n10];
        boolean bl2 = this.c;
        object2[0] = object = Boolean.valueOf(bl2);
        object = h;
        String string2 = "bindService, mIsServiceConnected = %b";
        TXCLog.i((String)object, string2, (Object[])object2);
        object2 = this.d;
        if (object2 != null && !(bl2 = this.c)) {
            object = this.f;
            string2 = i;
            ((b)object2).a(context, (ServiceConnection)object, string2);
        }
    }

    private void q(String string2, String objectArray) {
        block4: {
            String string3 = h;
            Object object = "serviceInit";
            TXCLog.i(string3, (String)object);
            object = this.b;
            if (object == null) break block4;
            boolean bl2 = this.c;
            if (!bl2) break block4;
            try {
                object.c(string2, (String)objectArray);
            }
            catch (RemoteException remoteException) {
                int n10 = 1;
                objectArray = new Object[n10];
                object = null;
                String string4 = remoteException.getMessage();
                objectArray[0] = string4;
                string4 = "isFeatureSupported,RemoteException ex : %s";
                TXCLog.e(string3, string4, objectArray);
            }
        }
    }

    private void r(IBinder object) {
        this.e = object;
        if (object != null) {
            Object object2 = this.g;
            try {
                object.linkToDeath(object2, 0);
            }
            catch (RemoteException remoteException) {
                object = this.d;
                int n10 = 5;
                ((b)object).f(n10);
                object = h;
                object2 = "serviceLinkToDeath, RemoteException";
                TXCLog.e((String)object, (String)object2);
            }
        }
    }

    public a l(HwAudioKit$FeatureType hwAudioKit$FeatureType) {
        b b10 = this.d;
        if (b10 != null && hwAudioKit$FeatureType != null) {
            int n10 = hwAudioKit$FeatureType.getFeatureType();
            Context context = this.a;
            return b10.b(n10, context);
        }
        return null;
    }

    public void m() {
        Object object = new Object[1];
        boolean bl2 = this.c;
        Object object2 = bl2;
        ServiceConnection serviceConnection = null;
        object[0] = object2;
        object2 = h;
        String string2 = "destroy, mIsServiceConnected = %b";
        TXCLog.i((String)object2, string2, (Object[])object);
        boolean bl3 = this.c;
        if (bl3) {
            this.c = false;
            object = this.d;
            object2 = this.a;
            serviceConnection = this.f;
            ((b)object).h((Context)object2, serviceConnection);
        }
    }

    public List n() {
        String string2;
        block4: {
            string2 = h;
            Object object = "getSupportedFeatures";
            TXCLog.i(string2, (String)object);
            object = this.b;
            if (object == null) break block4;
            boolean bl2 = this.c;
            if (!bl2) break block4;
            try {
                return object.h();
            }
            catch (RemoteException remoteException) {
                object = "getSupportedFeatures, createFeature,wait bind service fail";
                TXCLog.e(string2, (String)object);
            }
        }
        TXCLog.i(string2, "getSupportedFeatures, service not bind");
        return j;
    }

    public void o() {
        String string2 = h;
        TXCLog.i(string2, "initialize");
        Context context = this.a;
        if (context == null) {
            TXCLog.i(string2, "mContext is null");
            this.d.f(7);
            return;
        }
        b b10 = this.d;
        boolean bl2 = b10.e(context);
        if (!bl2) {
            TXCLog.i(string2, "not install AudioKitEngine");
            this.d.f(2);
            return;
        }
        string2 = this.a;
        this.k((Context)string2);
    }

    public boolean p(HwAudioKit$FeatureType hwAudioKit$FeatureType) {
        block6: {
            Object object;
            if (hwAudioKit$FeatureType == null) {
                return false;
            }
            int n10 = 1;
            Object object2 = new Object[n10];
            int n11 = hwAudioKit$FeatureType.getFeatureType();
            object2[0] = object = Integer.valueOf(n11);
            object = h;
            String string2 = "isFeatureSupported, type = %d";
            TXCLog.i((String)object, string2, (Object[])object2);
            object2 = this.b;
            if (object2 == null) break block6;
            boolean bl2 = this.c;
            if (!bl2) break block6;
            int n12 = hwAudioKit$FeatureType.getFeatureType();
            try {
                return object2.n(n12);
            }
            catch (RemoteException remoteException) {
                Object[] objectArray = new Object[n10];
                String string3 = remoteException.getMessage();
                objectArray[0] = string3;
                string3 = "isFeatureSupported,RemoteException ex : %s";
                TXCLog.e((String)object, string3, objectArray);
            }
        }
        return false;
    }
}

