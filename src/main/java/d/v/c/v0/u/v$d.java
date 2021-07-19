/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.api.entity.UnReadMessageEntity;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;
import d.v.c.v0.u.v;
import d.v.e.l.c1;
import d.v.j.e.h.j;
import k.d;

public class v$d
extends j {
    public final /* synthetic */ v d;

    public v$d(v v10, c1 c12) {
        this.d = v10;
        super(c12);
    }

    public d e() {
        return v.K(this.d).createMessageUnreadCount();
    }

    public LiveData n() {
        return v.L(this.d).k();
    }

    public void t(UnReadMessageEntity unReadMessageEntity) {
        v.L(this.d).p(unReadMessageEntity);
    }

    public boolean u(MessageUnReadCount messageUnReadCount) {
        return true;
    }
}

