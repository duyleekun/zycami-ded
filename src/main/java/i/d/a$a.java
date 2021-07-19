/*
 * Decompiled with CFR 0.151.
 */
package i.d;

import i.d.a;
import i.d.f;
import java.util.ArrayList;
import java.util.Iterator;

public class a$a
implements Runnable {
    private ArrayList a;
    public final /* synthetic */ a b;

    public a$a(a arrayList) {
        this.b = arrayList;
        this.a = arrayList = new ArrayList();
    }

    public void run() {
        block15: {
            ArrayList arrayList = this.a;
            arrayList.clear();
            arrayList = this.a;
            Object object = this.b;
            object = ((a)object).getConnections();
            arrayList.addAll(object);
            long l10 = System.nanoTime();
            double d10 = l10;
            Iterator iterator2 = this.b;
            long l11 = i.d.a.access$000((a)((Object)iterator2));
            double d11 = l11;
            double d12 = 1.5;
            l10 = (long)(d10 -= (d11 *= d12));
            iterator2 = this.a;
            try {
                iterator2 = ((ArrayList)((Object)iterator2)).iterator();
            }
            catch (Exception exception) {}
            while (true) {
                boolean bl2 = iterator2.hasNext();
                if (!bl2) break block15;
                break;
            }
            {
                Object object2 = iterator2.next();
                object2 = (f)object2;
                a a10 = this.b;
                i.d.a.access$100(a10, object2, l10);
                continue;
            }
        }
        this.a.clear();
    }
}

