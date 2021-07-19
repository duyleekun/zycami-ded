/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.o.a.a.a.b.a;

import android.net.Uri;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.MediaType;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o$OooO00o;
import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooO$OooO0O0;
import com.quvideo.mobile.external.platform.uploader.OooOOO;
import com.quvideo.mobile.external.platform.uploader.listener.OooO0O0;
import d.o.a.a.a.b.a.g$b$a;
import java.util.UUID;

public final class g$b
implements OooO00o {
    public String OooO00o(Uri object, MediaType object2, OooO00o$OooO00o oooO00o$OooO00o) {
        object2 = UUID.randomUUID().toString();
        OooO$OooO0O0 oooO$OooO0O0 = new OooO$OooO0O0();
        Object object3 = object.getPath();
        oooO$OooO0O0 = oooO$OooO0O0.OooO00o((String)object3);
        object3 = new g$b$a(this, oooO00o$OooO00o, (Uri)object);
        object = oooO$OooO0O0.OooO00o((OooO0O0)object3).OooO00o();
        OooOOO.OooO0Oo((String)object2, (OooO)object);
        return object2;
    }

    public void OooO00o(String string2) {
        OooOOO.OooO00o(string2);
    }
}

