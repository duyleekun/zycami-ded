/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.a.a.b;

import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o;
import com.quvideo.mobile.external.component.cloudcomposite.compressor.OooO0o$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0OO$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;
import d.o.a.a.a.a.b.b;
import e.a.v0.o;
import java.util.ArrayList;
import java.util.List;

public class b$b
implements o {
    public final /* synthetic */ b a;

    public b$b(b b10) {
        this.a = b10;
    }

    public List a(List object) {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            MediaType mediaType;
            Object object2 = (OooO0OO$OooO00o)object.next();
            MediaType mediaType2 = ((OooO0OO$OooO00o)object2).OooO0O0();
            if (mediaType2 != (mediaType = MediaType.IMAGE)) continue;
            object2 = ((OooO0OO$OooO00o)object2).OooO0OO().getPath();
            arrayList.add(object2);
        }
        object = OooO0o.OooO0OO(b.u(this.a)).OooO00o(arrayList);
        int n10 = b.a(this.a).OooO0o0();
        object = ((OooO0o$OooO00o)object).OooO00o(n10);
        n10 = b.a(this.a).OooO00o();
        return ((OooO0o$OooO00o)object).OooO0O0(n10).OooO0O0();
    }
}

