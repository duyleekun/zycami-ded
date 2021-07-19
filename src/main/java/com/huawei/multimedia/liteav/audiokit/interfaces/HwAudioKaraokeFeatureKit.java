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
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit$ParameName;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit$a;
import com.huawei.multimedia.liteav.audiokit.interfaces.HwAudioKaraokeFeatureKit$b;
import com.tencent.liteav.basic.log.TXCLog;
import d.j.e.a.a.b;
import d.j.e.a.b.b.a;

public class HwAudioKaraokeFeatureKit
extends a {
    private static final String h = "HwAudioKit.HwAudioKaraokeFeatureKit";
    private static final String i = "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService";
    private Context a;
    private d.j.e.a.b.b.b b = null;
    private boolean c = false;
    private b d;
    private IBinder e = null;
    private ServiceConnection f;
    private IBinder.DeathRecipient g;

    public HwAudioKaraokeFeatureKit(Context context) {
        Object object = new HwAudioKaraokeFeatureKit$a(this);
        this.f = object;
        object = new HwAudioKaraokeFeatureKit$b(this);
        this.g = object;
        this.b = object = d.j.e.a.b.b.b.d();
        this.a = context;
    }

    public static /* synthetic */ b a(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit) {
        return hwAudioKaraokeFeatureKit.d;
    }

    public static /* synthetic */ b b(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit, b b10) {
        hwAudioKaraokeFeatureKit.d = b10;
        return b10;
    }

    public static /* synthetic */ boolean c(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit, boolean bl2) {
        hwAudioKaraokeFeatureKit.c = bl2;
        return bl2;
    }

    public static /* synthetic */ d.j.e.a.b.b.b d(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit) {
        return hwAudioKaraokeFeatureKit.b;
    }

    public static /* synthetic */ Context e(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit) {
        return hwAudioKaraokeFeatureKit.a;
    }

    public static /* synthetic */ void f(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit, String string2) {
        hwAudioKaraokeFeatureKit.q(string2);
    }

    public static /* synthetic */ void g(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit, IBinder iBinder) {
        hwAudioKaraokeFeatureKit.r(iBinder);
    }

    public static /* synthetic */ IBinder.DeathRecipient h(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit) {
        return hwAudioKaraokeFeatureKit.g;
    }

    public static /* synthetic */ IBinder i(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit) {
        return hwAudioKaraokeFeatureKit.e;
    }

    public static /* synthetic */ IBinder j(HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit, IBinder iBinder) {
        hwAudioKaraokeFeatureKit.e = iBinder;
        return iBinder;
    }

    private void k(Context context) {
        boolean bl2;
        String string2 = "bindService";
        TXCLog.i(h, string2);
        d.j.e.a.b.b.b b10 = this.b;
        if (b10 != null && !(bl2 = this.c)) {
            string2 = this.f;
            String string3 = i;
            b10.a(context, (ServiceConnection)string2, string3);
        }
    }

    private void q(String string2) {
        block4: {
            Object[] objectArray = this.d;
            if (objectArray == null) break block4;
            boolean bl2 = this.c;
            if (!bl2) break block4;
            try {
                objectArray.a(string2);
            }
            catch (RemoteException remoteException) {
                int n10 = 1;
                objectArray = new Object[n10];
                bl2 = false;
                String string3 = remoteException.getMessage();
                objectArray[0] = string3;
                string3 = h;
                String string4 = "isFeatureSupported,RemoteException ex : %s";
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
                object = this.b;
                int n10 = 1002;
                ((d.j.e.a.b.b.b)object).f(n10);
                object = h;
                object2 = "serviceLinkToDeath, RemoteException";
                TXCLog.e((String)object, (String)object2);
            }
        }
    }

    public void l() {
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
            object = this.b;
            object2 = this.a;
            serviceConnection = this.f;
            ((d.j.e.a.b.b.b)object).h((Context)object2, serviceConnection);
        }
    }

    public int m(boolean bl2) {
        block4: {
            Object object;
            int n10 = 1;
            Object object2 = new Object[n10];
            object2[0] = object = Boolean.valueOf(bl2);
            object = h;
            String string2 = "enableKaraokeFeature, enable = %b";
            TXCLog.i((String)object, string2, (Object[])object2);
            object2 = this.d;
            if (object2 == null) break block4;
            boolean bl3 = this.c;
            if (!bl3) break block4;
            try {
                return object2.e(bl2);
            }
            catch (RemoteException remoteException) {
                Object[] objectArray = new Object[n10];
                String string3 = remoteException.getMessage();
                objectArray[0] = string3;
                string3 = "enableKaraokeFeature,RemoteException ex : %s";
                TXCLog.e((String)object, string3, objectArray);
            }
        }
        return -2;
    }

    public int n() {
        block4: {
            String string2 = h;
            Object object = "getKaraokeLatency";
            TXCLog.i(string2, (String)object);
            object = this.d;
            if (object == null) break block4;
            int n10 = (int)(this.c ? 1 : 0);
            if (n10 == 0) break block4;
            try {
                return object.i();
            }
            catch (RemoteException remoteException) {
                n10 = 1;
                Object[] objectArray = new Object[n10];
                String string3 = remoteException.getMessage();
                objectArray[0] = string3;
                string3 = "getKaraokeLatency,RemoteException ex : %s";
                TXCLog.e(string2, string3, objectArray);
            }
        }
        return -1;
    }

    public void o(Context context) {
        String string2 = h;
        Object object = "initialize";
        TXCLog.i(string2, (String)object);
        if (context == null) {
            TXCLog.i(string2, "initialize, context is null");
            return;
        }
        object = this.b;
        boolean bl2 = ((d.j.e.a.b.b.b)object).e(context);
        if (!bl2) {
            this.b.f(2);
            TXCLog.i(string2, "initialize, not install AudioEngine");
            return;
        }
        this.k(context);
    }

    public boolean p() {
        block4: {
            String string2 = h;
            TXCLog.i(string2, "isKaraokeFeatureSupport");
            b b10 = this.d;
            if (b10 == null) break block4;
            int n10 = (int)(this.c ? 1 : 0);
            if (n10 == 0) break block4;
            try {
                return b10.j();
            }
            catch (RemoteException remoteException) {
                n10 = 1;
                Object[] objectArray = new Object[n10];
                String string3 = remoteException.getMessage();
                objectArray[0] = string3;
                string3 = "isFeatureSupported,RemoteException ex : %s";
                TXCLog.e(string2, string3, objectArray);
            }
        }
        return false;
    }

    public int s(HwAudioKaraokeFeatureKit$ParameName object, int n10) {
        block10: {
            String string2 = h;
            if (object == null) {
                return 1807;
            }
            int n11 = 1;
            Object object2 = "parame.getParameName() = %s, parameValue = %d";
            int n12 = 2;
            Object[] objectArray = new Object[n12];
            Object object3 = object.getParameName();
            objectArray[0] = object3;
            object3 = n10;
            objectArray[n11] = object3;
            TXCLog.i(string2, (String)object2, objectArray);
            object2 = this.d;
            if (object2 == null) break block10;
            n12 = (int)(this.c ? 1 : 0);
            if (n12 == 0) break block10;
            object = object.getParameName();
            try {
                return object2.f((String)object, n10);
            }
            catch (RemoteException remoteException) {
                Object[] objectArray2 = new Object[n11];
                String string3 = remoteException.getMessage();
                objectArray2[0] = string3;
                string3 = "setParameter,RemoteException ex : %s";
                TXCLog.e(string2, string3, objectArray2);
            }
        }
        return -2;
    }
}

