/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothProfile
 *  android.bluetooth.BluetoothProfile$ServiceListener
 */
package d.v.e0.je;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import com.polidea.rxandroidble2.RxBleClient;
import d.v.e0.je.f;
import e.a.g0;
import java.util.Iterator;

public class f$a
implements BluetoothProfile.ServiceListener {
    public final /* synthetic */ g0 a;
    public final /* synthetic */ f b;

    public f$a(f f10, g0 g02) {
        this.b = f10;
        this.a = g02;
    }

    public void onServiceConnected(int n10, BluetoothProfile object) {
        boolean bl2;
        f.i8(this.b, object);
        Iterator iterator2 = object.getConnectedDevices().iterator();
        while (bl2 = iterator2.hasNext()) {
            object = ((BluetoothDevice)iterator2.next()).getAddress();
            g0 g02 = this.a;
            RxBleClient rxBleClient = f.j8(this.b);
            object = rxBleClient.c((String)object);
            g02.onNext(object);
        }
    }

    public void onServiceDisconnected(int n10) {
    }
}

