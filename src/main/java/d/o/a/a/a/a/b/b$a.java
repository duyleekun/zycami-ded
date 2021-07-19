/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.o.a.a.a.a.b;

import android.net.Uri;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0OO$OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooOO0;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import d.o.a.a.a.a.b.b;
import e.a.g0;
import java.io.File;
import java.util.List;

public class b$a
implements g0 {
    public final /* synthetic */ b a;

    public b$a(b b10) {
        this.a = b10;
    }

    public void a(List list) {
        int n10;
        List list2 = b.a(this.a).OooO0Oo().OooO00o();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = list2.size()); ++i10) {
            MediaType mediaType;
            Object object = ((OooO0OO$OooO00o)list2.get(i10)).OooO0O0();
            if (object != (mediaType = MediaType.IMAGE)) continue;
            object = (OooO0OO$OooO00o)list2.get(i10);
            mediaType = Uri.parse((String)((File)list.get(n11)).getPath());
            ((OooO0OO$OooO00o)object).OooO00o((Uri)mediaType);
            ++n11;
        }
        b.q(this.a);
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        object = this.a;
        Object object2 = OooOO0.OooO0o0;
        int n10 = OooOO0.OooO0Oo;
        b.f((b)object, object2, n10, false);
        object = this.a;
        object2 = OnCompositeListener$State.FAILURE;
        b.d((b)object, (OnCompositeListener$State)((Object)object2));
    }

    public void onSubscribe(e.a.s0.b b10) {
    }
}

