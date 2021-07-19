/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import com.zhiyun.stabilizer.entities.Modules;
import com.zhiyun.stabilizer.entities.Modules$External;
import com.zhiyun.stabilizer.entities.Modules$Internal;
import d.v.e0.ce;
import d.v.e0.xd;
import e.a.v0.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ce$t0
implements o {
    public final /* synthetic */ ce a;

    public ce$t0(ce ce2) {
        this.a = ce2;
    }

    public List a(Modules modules) {
        xd xd2;
        Object object;
        int n10;
        boolean bl2;
        ArrayList<xd> arrayList = new ArrayList<xd>();
        Iterator iterator2 = modules.getExternal().iterator();
        while (true) {
            bl2 = iterator2.hasNext();
            n10 = 1;
            if (!bl2) break;
            object = (Modules$External)iterator2.next();
            xd2 = new xd();
            xd2.h(n10 != 0);
            n10 = ((Modules$External)object).isDependency();
            xd2.g(n10 != 0);
            Object object2 = ((Modules$External)object).getSuffix();
            xd2.l((String)object2);
            object2 = ((Modules$External)object).getLink();
            xd2.j((UpgradeLink)((Object)object2));
            object = ((Modules$External)object).getModel();
            xd2.k((Model)((Object)object));
            arrayList.add(xd2);
        }
        iterator2 = modules.getInternal().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2;
            object = (Modules$Internal)iterator2.next();
            xd2 = new xd();
            xd2.h(false);
            xd2.g(false);
            String[] stringArray = new String[n10];
            stringArray[0] = string2 = ((Modules$Internal)object).getSuffix();
            xd2.l(stringArray);
            object = ((Modules$Internal)object).getLink();
            xd2.j((UpgradeLink)((Object)object));
            object = modules.getModel();
            xd2.k((Model)((Object)object));
            arrayList.add(xd2);
        }
        return arrayList;
    }
}

