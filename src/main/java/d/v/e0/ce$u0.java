/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import androidx.core.util.Pair;
import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import d.v.e0.ce;
import d.v.e0.oe.n;
import d.v.e0.xd;
import e.a.v0.o;

public class ce$u0
implements o {
    public final /* synthetic */ ce a;

    public ce$u0(ce ce2) {
        this.a = ce2;
    }

    public xd a(Pair object) {
        xd xd2 = new xd();
        String[] stringArray = (UpgradeLink)((Object)((Pair)object).first);
        xd2.j((UpgradeLink)stringArray);
        stringArray = ce.s(this.a).H2();
        xd2.k((Model)stringArray);
        object = n.g((Integer)((Pair)object).second);
        stringArray = new String[]{object};
        xd2.l(stringArray);
        return xd2;
    }
}

