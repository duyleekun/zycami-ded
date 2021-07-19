/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.MessageDao;
import d.v.c.v0.l.g;
import d.v.c.v0.u.a0.e;
import d.v.e.l.w1;
import java.util.ArrayList;
import k.d;

public class i
extends e {
    private MessageDao g;

    public i(int n10) {
        super(n10);
        MessageDao messageDao;
        this.g = messageDao = DatabaseHelper.getInstance().getDataBase().messageDao();
    }

    public void e() {
        this.g.deleteMessageViolation();
    }

    public d f(int n10, int n11) {
        g g10 = d.v.c.v0.l.g.a;
        String string2 = MessagePageType.MESSAGE_PERSONAL.getType();
        String string3 = d.v.a.f.c.d.d.F().K();
        String string4 = w1.a();
        return g10.a(string2, n10, n11, string3, string4);
    }

    public void i(ArrayList arrayList) {
        this.g.insertMessageViolation(arrayList);
    }
}

