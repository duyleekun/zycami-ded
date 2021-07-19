/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.a.b.a;

import com.quvideo.mobile.external.platform.log.OooO00o;
import java.util.HashMap;

public final class g$a
implements com.quvideo.mobile.external.platform.uploader.listener.OooO00o {
    public void OooO00o(String string2, HashMap hashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" - ");
        stringBuilder.append(hashMap);
        string2 = stringBuilder.toString();
        OooO00o.OooO00o("cloudEngine", string2);
    }
}

