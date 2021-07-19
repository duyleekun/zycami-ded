/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import androidx.core.util.Pair;
import com.zhiyun.protocol.message.bl.other.Status;
import d.v.e0.ce;
import e.a.v0.r;

public class ce$q1
implements r {
    public final /* synthetic */ ce a;

    public ce$q1(ce ce2) {
        this.a = ce2;
    }

    public boolean a(Pair object) {
        boolean bl2;
        Object object2 = ((Pair)object).first;
        Status status = Status.ERR_NONE;
        if (object2 == status && (object = ((Pair)object).second) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

