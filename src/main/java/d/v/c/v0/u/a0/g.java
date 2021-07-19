/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.MessageDao;
import d.v.c.v0.u.a0.e;
import d.v.e.l.w1;
import java.util.ArrayList;
import k.d;

public class g
extends e {
    private MessageDao g;

    public g(int n10) {
        super(n10);
        MessageDao messageDao;
        this.g = messageDao = DatabaseHelper.getInstance().getDataBase().messageDao();
    }

    public void e() {
        this.g.deleteMessageLike();
    }

    public d f(int n10, int n11) {
        d.v.c.v0.l.g g10 = d.v.c.v0.l.g.a;
        String string2 = MessagePageType.MESSAGE_LIKE.getType();
        String string3 = d.v.a.f.c.d.d.F().K();
        String string4 = w1.a();
        return g10.g(string2, n10, n11, string3, string4);
    }

    public void i(ArrayList arrayList) {
        this.g.insertMessageLike(arrayList);
    }
}

