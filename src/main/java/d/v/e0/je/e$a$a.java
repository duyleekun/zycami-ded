/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package d.v.e0.je;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import d.n.a.j0;
import d.v.e0.je.e$a;
import e.a.b0;

public class e$a$a
extends BroadcastReceiver {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ e$a b;

    public e$a$a(e$a a10, b0 b02) {
        this.b = a10;
        this.a = b02;
    }

    public void onReceive(Context object, Intent object2) {
        int n10;
        object = (BluetoothDevice)object2.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        int n11 = 10;
        int n12 = object2.getIntExtra("android.bluetooth.device.extra.BOND_STATE", n11);
        Object object3 = this.b;
        j0 j02 = ((e$a)object3).a;
        e$a.a((e$a)object3, n12, j02);
        object3 = this.a;
        boolean bl2 = object3.isDisposed();
        if (!bl2 && (n10 = TextUtils.equals((CharSequence)(object = object.getAddress()), (CharSequence)(object3 = this.b.a.e()))) != 0 && n12 != (n10 = 11)) {
            n10 = 12;
            if (n12 != n10) {
                object = this.a;
                object2 = Boolean.FALSE;
                object.onNext(object2);
            } else {
                object = this.a;
                object2 = Boolean.TRUE;
                object.onNext(object2);
            }
        }
    }
}

