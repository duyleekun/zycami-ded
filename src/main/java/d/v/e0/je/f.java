/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothProfile
 *  android.bluetooth.BluetoothProfile$ServiceListener
 *  android.content.Context
 */
package d.v.e0.je;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import d.v.e0.je.f$a;
import d.v.e0.je.f$b;
import e.a.g0;
import e.a.s0.b;
import e.a.s0.c;
import e.a.v0.a;
import e.a.z;

public class f
extends z {
    private final Context a;
    private final RxBleClient b;
    private final int c;
    private BluetoothProfile d;

    public f(Context context, RxBleClient rxBleClient, int n10) {
        this.a = context;
        this.b = rxBleClient;
        this.c = n10;
    }

    public static /* synthetic */ BluetoothProfile h8(f f10) {
        return f10.d;
    }

    public static /* synthetic */ BluetoothProfile i8(f f10, BluetoothProfile bluetoothProfile) {
        f10.d = bluetoothProfile;
        return bluetoothProfile;
    }

    public static /* synthetic */ RxBleClient j8(f f10) {
        return f10.b;
    }

    public static /* synthetic */ int k8(f f10) {
        return f10.c;
    }

    public static /* synthetic */ void l8(f f10, int n10, BluetoothProfile bluetoothProfile) {
        f10.m8(n10, bluetoothProfile);
    }

    private void m8(int n10, BluetoothProfile bluetoothProfile) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            bluetoothAdapter.closeProfileProxy(n10, bluetoothProfile);
        }
    }

    public void K5(g0 g02) {
        Object object = new f$a(this, g02);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            int n10 = 8;
            object = new BleScanException(n10);
            g02.onError((Throwable)object);
        } else {
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            Context context = this.a;
            int n11 = this.c;
            bluetoothAdapter.getProfileProxy(context, (BluetoothProfile.ServiceListener)object, n11);
            object = new f$b(this);
            object = e.a.s0.c.c((a)object);
            g02.onSubscribe((b)object);
        }
    }
}

