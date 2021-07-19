/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.otherevent.MoveLineStatus;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.e0;
import e.a.v0.o;

public class ce$o0
implements o {
    public final /* synthetic */ ce a;

    public ce$o0(ce ce2) {
        this.a = ce2;
    }

    public e0 a(int[] object) {
        q.f("7: setMovelineStatus\uff1a ");
        object = ce.s(this.a);
        MoveLineStatus moveLineStatus = MoveLineStatus.STARTED;
        return ((Stabilizer)object).u7(moveLineStatus);
    }
}

