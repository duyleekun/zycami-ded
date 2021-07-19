/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.y0.b.v;

import android.view.View;
import com.zhiyun.device.connection.BleDevice;
import com.zhiyun.device.connection.BleDevice$State;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.n0.c;
import d.v.c.n0.e;
import d.v.c.w0.z2;
import d.v.c.y0.b.v.a;

public abstract class b
extends c {
    private boolean b = true;

    public b() {
    }

    public b(boolean bl2) {
        this.b = bl2;
    }

    private /* synthetic */ void f(BleDevice bleDevice, int n10, View view) {
        this.h(bleDevice, n10);
    }

    public int a(int n10) {
        return 2131558510;
    }

    public void b(e object, int n10) {
        object = (z2)((e)object).a;
        BleDevice bleDevice = (BleDevice)this.getItem(n10);
        Object object2 = bleDevice.a.M2();
        ((z2)object).C((String)object2);
        object2 = bleDevice.b;
        ((z2)object).D((BleDevice$State)((Object)object2));
        boolean bl2 = this.b;
        ((z2)object).B(bl2);
        object = ((z2)object).a;
        object2 = new a(this, bleDevice, n10);
        object.setOnClickListener((View.OnClickListener)object2);
    }

    public void e(Stabilizer stabilizer, BleDevice$State bleDevice$State) {
        boolean bl2;
        if (stabilizer == null) {
            return;
        }
        Object object = this.getData();
        if (object != null && !(bl2 = object.isEmpty())) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                String string2;
                BleDevice bleDevice = (BleDevice)object.next();
                String string3 = bleDevice.a.F2();
                boolean bl3 = string3.equals(string2 = stabilizer.F2());
                if (!bl3) continue;
                bleDevice.b = bleDevice$State;
                break;
            }
        }
        this.notifyDataSetChanged();
    }

    public /* synthetic */ void g(BleDevice bleDevice, int n10, View view) {
        this.f(bleDevice, n10, view);
    }

    public abstract void h(BleDevice var1, int var2);
}

