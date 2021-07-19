/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.util.Log
 */
package d.v.e0.je;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import d.n.a.j0;
import d.v.e0.je.e$a$a;
import d.v.e0.je.e$a$b;
import e.a.b0;
import e.a.c0;
import e.a.s0.b;
import e.a.s0.c;
import e.a.v0.a;

public final class e$a
implements c0 {
    public final /* synthetic */ j0 a;
    public final /* synthetic */ Context b;

    public e$a(j0 j02, Context context) {
        this.a = j02;
        this.b = context;
    }

    public static /* synthetic */ void a(e$a e$a, int n10, j0 j02) {
        e$a.b(n10, j02);
    }

    private void b(int n10, j0 object) {
        int n11 = 11;
        String string2 = "BluetoothDevice";
        if (n10 != n11) {
            n11 = 12;
            String string3 = "Bond ";
            if (n10 != n11) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append(string3);
                object = object.getName();
                charSequence.append((String)object);
                object = " failed";
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                Log.i((String)string2, (String)charSequence);
            } else {
                CharSequence charSequence = new StringBuilder();
                charSequence.append(string3);
                object = object.getName();
                charSequence.append((String)object);
                object = " succeed";
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                Log.i((String)string2, (String)charSequence);
            }
        } else {
            CharSequence charSequence = new StringBuilder();
            String string4 = "Start bonding ";
            charSequence.append(string4);
            object = object.getName();
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            Log.i((String)string2, (String)charSequence);
        }
    }

    public void subscribe(b0 b02) {
        Object object;
        Object object2 = BluetoothAdapter.getDefaultAdapter().getBondedDevices();
        boolean bl2 = object2.contains(object = this.a.b());
        if (bl2) {
            object2 = Boolean.TRUE;
            b02.onNext(object2);
            b02.onComplete();
            return;
        }
        object2 = new e$a$a(this, b02);
        object = this.b;
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED");
        object.registerReceiver((BroadcastReceiver)object2, intentFilter);
        this.a.b().createBond();
        object = new e$a$b(this, (BroadcastReceiver)object2);
        object2 = c.c((a)object);
        b02.setDisposable((b)object2);
    }
}

