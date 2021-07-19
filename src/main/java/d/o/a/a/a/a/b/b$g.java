/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.a.a.b;

import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0o;
import com.quvideo.mobile.external.platform.api.cloudengine.OooO0O0;
import d.o.a.a.a.a.b.b;
import e.a.e0;
import e.a.v0.o;

public class b$g
implements o {
    public final /* synthetic */ b a;

    public b$g(b b10) {
        this.a = b10;
    }

    public e0 a(Long object) {
        long l10;
        String string2 = b.y((b)this.a).data.businessId;
        long l11 = (Long)object;
        long l12 = l11 - (l10 = (long)((OooO0o)(object = b.a(this.a))).OooO0O0());
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            object2 = 1;
        } else {
            object2 = 0;
            object = null;
        }
        return OooO0O0.OooO00o(string2, (boolean)object2);
    }
}

