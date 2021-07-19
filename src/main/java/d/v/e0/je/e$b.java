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
import d.v.e0.je.e$b$a;
import d.v.e0.je.e$b$b;
import e.a.b0;
import e.a.c0;
import e.a.s0.b;
import e.a.s0.c;
import e.a.v0.a;

public class e$b
implements c0 {
    private static final int c = 4;
    private BluetoothProfile a;
    private Context b;

    public e$b(Context context) {
        this.b = context;
    }

    public static /* synthetic */ BluetoothProfile a(e$b e$b) {
        return e$b.a;
    }

    public static /* synthetic */ BluetoothProfile b(e$b e$b, BluetoothProfile bluetoothProfile) {
        e$b.a = bluetoothProfile;
        return bluetoothProfile;
    }

    public static /* synthetic */ void c(e$b e$b, BluetoothProfile bluetoothProfile) {
        e$b.d(bluetoothProfile);
    }

    private void d(BluetoothProfile bluetoothProfile) {
        BluetoothAdapter.getDefaultAdapter().closeProfileProxy(4, bluetoothProfile);
    }

    public void subscribe(b0 b02) {
        Object object = new e$b$a(this, b02);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Context context = this.b;
        bluetoothAdapter.getProfileProxy(context, (BluetoothProfile.ServiceListener)object, 4);
        object = new e$b$b(this);
        object = e.a.s0.c.c((a)object);
        b02.setDisposable((b)object);
    }
}

