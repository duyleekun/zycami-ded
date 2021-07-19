/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u.a0;

import com.zhiyun.cama.data.MessagePageType;
import com.zhiyun.cama.data.database.DatabaseHelper;
import com.zhiyun.cama.data.database.dao.MessageDao;
import com.zhiyun.cama.data.database.model.MessageSystem;
import d.v.c.v0.l.g;
import d.v.c.v0.u.a0.e;
import d.v.e.l.w1;
import java.util.ArrayList;
import k.d;

public class h
extends e {
    private MessageDao g;

    public h(int n10) {
        super(n10);
        MessageDao messageDao;
        this.g = messageDao = DatabaseHelper.getInstance().getDataBase().messageDao();
    }

    public void e() {
        this.g.deleteMessageSystem();
    }

    public d f(int n10, int n11) {
        g g10 = d.v.c.v0.l.g.a;
        String string2 = MessagePageType.MESSAGE_SYSTEM.getType();
        String string3 = d.v.a.f.c.d.d.F().K();
        String string4 = w1.a();
        return g10.e(string2, n10, n11, string3, string4);
    }

    public void i(ArrayList object) {
        boolean bl2;
        ArrayList<MessageSystem> arrayList = new ArrayList<MessageSystem>();
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            String string2 = "activity_notice";
            MessageSystem messageSystem = (MessageSystem)object.next();
            String string3 = messageSystem.getVerb();
            boolean bl3 = string2.equals(string3);
            if (bl3 || (bl3 = (string2 = "cat_notice").equals(string3 = messageSystem.getVerb()))) continue;
            arrayList.add(messageSystem);
        }
        this.g.insertMessageSystem(arrayList);
    }
}

