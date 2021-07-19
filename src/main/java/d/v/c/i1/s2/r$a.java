/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.s2;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleDevice;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.a.f.c.b;
import d.v.c.i1.s2.r;
import d.v.c.i1.s2.s;
import d.v.g.e.q$b;
import java.util.List;

public class r$a
extends q$b {
    public final /* synthetic */ r a;

    public r$a(r r10) {
        this.a = r10;
    }

    public void g(Stabilizer stabilizer) {
        BleDevice bleDevice;
        List list = r.j(this.a);
        boolean bl2 = list.contains(bleDevice = new BleDevice(stabilizer));
        if (!bl2) {
            list = r.j(this.a);
            bleDevice = new BleDevice(stabilizer);
            list.add(bleDevice);
        }
    }

    public void j() {
        int n10;
        Object object = r.j(this.a);
        int n11 = object.size();
        if (n11 == 0) {
            return;
        }
        object = this.a;
        Object object2 = r.j((r)object);
        int n12 = (object = r.n((r)object, (List)object2)).size();
        if (n12 == (n10 = 1)) {
            object = ((BleDevice)object.get((int)0)).a;
            object2 = b.N();
            n12 = (int)(((b)object2).s() ? 1 : 0);
            n10 = 0;
            String string2 = null;
            if (n12 != 0) {
                n12 = b.N().i().getId();
                string2 = String.valueOf(n12);
                object2 = b.N().i().getToken();
            } else {
                n12 = 0;
                object2 = null;
            }
            BleConnection bleConnection = BleConnection.W();
            bleConnection.P((Stabilizer)object, string2, (String)object2);
        } else {
            object = r.o(this.a);
            ((s)object).d(n10);
        }
    }
}

