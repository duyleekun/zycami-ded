/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothProfile
 *  android.bluetooth.BluetoothProfile$ServiceListener
 */
package d.v.e0.je;

import android.bluetooth.BluetoothProfile;
import d.v.e0.je.e$b;
import e.a.b0;

public class e$b$a
implements BluetoothProfile.ServiceListener {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ e$b b;

    public e$b$a(e$b b10, b0 b02) {
        this.b = b10;
        this.a = b02;
    }

    public void onServiceConnected(int n10, BluetoothProfile bluetoothProfile) {
        e$b.b(this.b, bluetoothProfile);
        this.a.onNext(bluetoothProfile);
    }

    public void onServiceDisconnected(int n10) {
    }
}

