/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.BroadcastReceiver
 *  android.content.IntentFilter
 *  android.media.AudioDeviceInfo
 *  android.media.AudioManager
 */
package d.v.c.s0.f7;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import d.v.c.s0.f7.a;
import d.v.c.s0.f7.b;
import d.v.c.s0.f7.c;
import d.v.c.s0.f7.d$a;
import d.v.e.i.h;
import d.v.e.i.j;

public class d
extends ViewModel {
    public static final int k = 0;
    public static final int l = 1;
    public static final int m = 2;
    public MutableLiveData a;
    public final MutableLiveData b;
    public final MutableLiveData c;
    public final MediatorLiveData d;
    public final MutableLiveData e;
    public final MediatorLiveData f;
    public final j g;
    private AudioManager h;
    private BroadcastReceiver i;
    private boolean j;

    public d() {
        Object object = new MutableLiveData();
        this.a = object;
        Object object2 = Boolean.FALSE;
        object = new MutableLiveData(object2);
        this.b = object;
        object = new MutableLiveData(object2);
        this.c = object;
        this.d = object;
        object = new MutableLiveData();
        this.e = object;
        super();
        this.f = object;
        super();
        this.g = object;
        this.j = false;
        object2 = this.a;
        object = 0;
        ((MutableLiveData)object2).setValue(object);
    }

    private void b() {
        Object[] objectArray = Boolean.TRUE;
        Object object = (Integer)this.a.getValue();
        int bl2 = d.v.e.h.d.c((Integer)object);
        int n10 = 1;
        if (bl2 != 0) {
            if (bl2 != n10) {
                int n11 = 2;
                if (bl2 == n11) {
                    this.n(false);
                    Object object2 = (Boolean)this.c.getValue();
                    boolean bl3 = d.v.e.h.a.c((Boolean)object2);
                    if (bl3) {
                        this.o(n10 != 0);
                    } else {
                        object2 = this.f;
                        Integer n12 = bl2;
                        objectArray = Pair.create(n12, objectArray);
                        ((MutableLiveData)object2).setValue(objectArray);
                        this.o(false);
                    }
                }
            } else {
                this.o(false);
                Object object3 = (Boolean)this.b.getValue();
                boolean bl4 = d.v.e.h.a.c((Boolean)object3);
                if (bl4) {
                    this.n(n10 != 0);
                } else {
                    object3 = this.f;
                    Integer n13 = bl2;
                    objectArray = Pair.create(n13, objectArray);
                    ((MutableLiveData)object3).setValue(objectArray);
                    this.n(false);
                }
            }
        } else {
            this.o(false);
            this.n(false);
        }
        objectArray = new Object[n10];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bl2);
        stringBuilder.append(", micOut = ");
        boolean bl5 = d.v.e.h.a.c((Boolean)this.b.getValue());
        stringBuilder.append(bl5);
        stringBuilder.append(", micSCO = ");
        boolean bl6 = d.v.e.h.a.c((Boolean)this.c.getValue());
        stringBuilder.append(bl6);
        objectArray[0] = object = stringBuilder.toString();
        m.a.a.b("changeMicState %s ", objectArray);
    }

    private boolean c() {
        for (AudioDeviceInfo audioDeviceInfo : this.h.getDevices(2)) {
            Object object;
            int n10 = audioDeviceInfo.getType();
            boolean bl2 = true;
            Object[] objectArray = new Object[bl2];
            objectArray[0] = object = Integer.valueOf(n10);
            object = "deviceType %s";
            m.a.a.b((String)object, objectArray);
            int n11 = 3;
            if (n11 != n10 && (n11 = 4) != n10 && (n11 = 22) != n10 && (n11 = 11) != n10) {
                continue;
            }
            return bl2;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    private void e() {
        void var4_7;
        Object object = this.b;
        Boolean bl2 = this.c();
        d.v.e.i.h.d((MutableLiveData)object, bl2);
        object = BluetoothAdapter.getDefaultAdapter();
        int bl3 = 1;
        int bl4 = object.getProfileConnectionState(bl3);
        MutableLiveData mutableLiveData = this.c;
        int n10 = 2;
        if (n10 == bl4) {
            int n11 = bl3;
        } else {
            boolean bl5 = false;
            object = null;
        }
        object = (boolean)var4_7;
        d.v.e.i.h.d(mutableLiveData, object);
        boolean bl6 = this.j;
        if (!bl6) {
            object = this.d;
            mutableLiveData = this.a;
            Observer observer = new b(this);
            ((MediatorLiveData)object).addSource(mutableLiveData, observer);
            object = this.d;
            mutableLiveData = this.b;
            observer = new a(this);
            ((MediatorLiveData)object).addSource(mutableLiveData, observer);
            object = this.d;
            mutableLiveData = this.c;
            observer = new c(this);
            ((MediatorLiveData)object).addSource(mutableLiveData, observer);
            this.j = bl3;
        }
    }

    private /* synthetic */ void g(Integer n10) {
        this.b();
    }

    private /* synthetic */ void j(Boolean comparable) {
        int n10 = 1;
        comparable = (Integer)this.a.getValue();
        int n11 = d.v.e.h.d.c((Integer)comparable);
        if (n10 == n11) {
            this.b();
        }
    }

    private /* synthetic */ void l(Boolean comparable) {
        int n10 = 2;
        comparable = (Integer)this.a.getValue();
        int n11 = d.v.e.h.d.c((Integer)comparable);
        if (n10 == n11) {
            this.b();
        }
    }

    private void n(boolean bl2) {
        MutableLiveData mutableLiveData = this.e;
        Boolean bl3 = bl2;
        d.v.e.i.h.d(mutableLiveData, bl3);
    }

    private void o(boolean bl2) {
        AudioManager audioManager = this.h;
        if (audioManager == null) {
            return;
        }
        boolean bl3 = audioManager.isBluetoothScoOn();
        if (bl2 && !bl3) {
            AudioManager audioManager2 = this.h;
            audioManager2.startBluetoothSco();
        } else if (!bl2 && bl3) {
            AudioManager audioManager3 = this.h;
            audioManager3.stopBluetoothSco();
        }
    }

    public void d(FragmentActivity fragmentActivity) {
        Object object = this.h;
        if (object == null) {
            object = "audio";
            fragmentActivity = (AudioManager)fragmentActivity.getSystemService((String)object);
            this.h = fragmentActivity;
        }
    }

    public boolean f(boolean bl2, CameraSet$Mode cameraSet$Mode) {
        CameraSet$Mode cameraSet$Mode2;
        if (bl2 && (cameraSet$Mode2 = CameraSet$Mode.photograph) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.panorama) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.delay_video) != cameraSet$Mode && (cameraSet$Mode2 = CameraSet$Mode.sport_delay) != cameraSet$Mode) {
            bl2 = true;
        } else {
            bl2 = false;
            cameraSet$Mode2 = null;
        }
        return bl2;
    }

    public /* synthetic */ void i(Integer n10) {
        this.g(n10);
    }

    public /* synthetic */ void k(Boolean bl2) {
        this.j(bl2);
    }

    public /* synthetic */ void m(Boolean bl2) {
        this.l(bl2);
    }

    public void onCleared() {
        this.h = null;
        this.i = null;
        super.onCleared();
    }

    public void p(FragmentActivity fragmentActivity) {
        this.e();
        BroadcastReceiver broadcastReceiver = this.i;
        if (broadcastReceiver == null) {
            this.i = broadcastReceiver = new d$a(this);
        }
        broadcastReceiver = new IntentFilter();
        broadcastReceiver.addAction("android.intent.action.HEADSET_PLUG");
        broadcastReceiver.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        broadcastReceiver.addAction("android.media.AUDIO_BECOMING_NOISY");
        BroadcastReceiver broadcastReceiver2 = this.i;
        fragmentActivity.registerReceiver(broadcastReceiver2, (IntentFilter)broadcastReceiver);
    }

    public void r(FragmentActivity fragmentActivity) {
        BroadcastReceiver broadcastReceiver = this.i;
        if (broadcastReceiver != null) {
            fragmentActivity.unregisterReceiver(broadcastReceiver);
        }
    }
}

