/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothProfile
 *  android.content.Context
 */
package d.v.e0.je;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.polidea.rxandroidble2.RxBleClient;
import d.n.a.j0;
import d.v.e0.je.a;
import d.v.e0.je.b;
import d.v.e0.je.c;
import d.v.e0.je.d;
import d.v.e0.je.e$a;
import d.v.e0.je.e$b;
import e.a.c0;
import e.a.e0;
import e.a.v0.o;
import e.a.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class e {
    private static final String a = "BluetoothDevice";

    public static z a(Context context, j0 j02) {
        e$a e$a = new e$a(j02, context);
        return z.y1(e$a);
    }

    private static List b(RxBleClient rxBleClient, List object) {
        int n10 = object.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object object2 = ((BluetoothDevice)object.next()).getAddress();
            object2 = rxBleClient.c((String)object2);
            arrayList.add(object2);
        }
        return arrayList;
    }

    private static List c(BluetoothProfile object, Long l10) {
        try {
            object = object.getConnectedDevices();
        }
        catch (Exception exception) {
            object = new ArrayList();
        }
        return object;
    }

    private static z d() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return z.l3(0L, 1L, timeUnit);
    }

    public static /* synthetic */ List e(BluetoothProfile bluetoothProfile, Long l10) {
        return e.c(bluetoothProfile, l10);
    }

    public static /* synthetic */ e0 f(BluetoothProfile bluetoothProfile) {
        return e.d();
    }

    public static /* synthetic */ List g(RxBleClient rxBleClient, List list) {
        return e.b(rxBleClient, list);
    }

    public static z h(Context object, RxBleClient object2) {
        Object object3 = new e$b((Context)object);
        object = z.y1((c0)object3);
        object3 = b.a;
        c c10 = c.a;
        object = ((z)object).u2((o)object3, c10);
        object3 = new d((RxBleClient)object2);
        object = ((z)object).H3((o)object3);
        object2 = d.v.e0.je.a.a;
        return ((z)object).s2((o)object2);
    }
}

