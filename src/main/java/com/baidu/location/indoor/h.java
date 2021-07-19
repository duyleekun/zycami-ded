/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor;

import com.baidu.location.BDLocation;
import com.baidu.location.f.f;
import com.baidu.location.indoor.g;
import com.baidu.location.indoor.g$e;
import com.baidu.location.indoor.g$f;
import com.baidu.location.indoor.q$a;

public class h
implements q$a {
    public final /* synthetic */ g a;

    public h(g g10) {
        this.a = g10;
    }

    public void a(BDLocation object) {
        long l10;
        long l11;
        Object object2 = this.a;
        Object object3 = ((g)object2).f();
        if (object3 != 0) {
            object2 = g.a(this.a);
            int n10 = 61;
            float f10 = 8.5E-44f;
            if (object2 != null) {
                l11 = System.currentTimeMillis();
                object2 = g.a(this.a);
                l10 = g$e.a((g$e)object2);
                long l12 = (l11 -= l10) - (l10 = 20000L);
                object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 > 0) {
                    l11 = System.currentTimeMillis();
                    object2 = g.a(this.a);
                    l10 = g$e.b((g$e)object2);
                    long l13 = (l11 -= l10) - (l10 = 10000L);
                    object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                    if (object3 < 0) {
                        ((BDLocation)object).setLocType(n10);
                        object3 = 0;
                        object2 = null;
                        ((BDLocation)object).setFloor(null);
                        ((BDLocation)object).setBuildingID(null);
                        ((BDLocation)object).setBuildingName(null);
                    }
                }
            }
            object2 = new BDLocation((BDLocation)object);
            Object object4 = f.a();
            boolean n11 = ((f)object4).k();
            if (n11 && (object4 = f.a().g()) != null) {
                BDLocation bDLocation = new BDLocation((String)object4);
                ((BDLocation)object2).setLocType(n10);
                n10 = bDLocation.getSatelliteNumber();
                ((BDLocation)object2).setSatelliteNumber(n10);
                f10 = bDLocation.getSpeed();
                ((BDLocation)object2).setSpeed(f10);
                double d10 = bDLocation.getAltitude();
                ((BDLocation)object2).setAltitude(d10);
                f10 = bDLocation.getDirection();
                ((BDLocation)object2).setDirection(f10);
            }
            g g10 = this.a;
            int n12 = 29;
            g.a(g10, (BDLocation)object2, n12);
            object2 = g.b(this.a);
            ((g$f)object2).a((BDLocation)object);
        }
        long l14 = System.currentTimeMillis();
        object = g.a(this.a);
        if (object != null) {
            long l15;
            object = g.a(this.a);
            l11 = g$e.a((g$e)object);
            l10 = 30000L;
            long l16 = (l11 = l14 - l11) - l10;
            Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object4 > 0 && (object4 = (l15 = (l14 -= (l11 = g$e.b((g$e)(object = g.a(this.a))))) - l10) == 0L ? 0 : (l15 < 0L ? -1 : 1)) > 0) {
                object = this.a;
                ((g)object).d();
            }
        }
    }
}

