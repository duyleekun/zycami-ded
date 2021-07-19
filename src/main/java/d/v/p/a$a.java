/*
 * Decompiled with CFR 0.151.
 */
package d.v.p;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import d.v.p.a;
import d.v.p.a$c;

public class a$a
extends BDAbstractLocationListener {
    public final /* synthetic */ a$c a;
    public final /* synthetic */ a b;

    public a$a(a a10, a$c a$c) {
        this.b = a10;
        this.a = a$c;
    }

    public void onReceiveLocation(BDLocation object) {
        int n10;
        int n11;
        if (object != null && ((n11 = ((BDLocation)object).getLocType()) == (n10 = 61) || (n11 = ((BDLocation)object).getLocType()) == (n10 = 161) || (n11 = ((BDLocation)object).getLocType()) == (n10 = 66))) {
            Object object2 = this.a;
            double d10 = ((BDLocation)object).getLongitude();
            double d11 = ((BDLocation)object).getLatitude();
            object2.b(d10, d11);
            object2 = d.v.p.a.a(this.b);
            if (object2 != null) {
                object2 = d.v.p.a.a(this.b);
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = ((BDLocation)object).getCountry();
                stringBuilder.append(string2);
                object = ((BDLocation)object).getCity();
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                object2.a((String)object);
            }
        } else {
            object = this.a;
            object.a();
        }
    }
}

