/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.o.b;

import com.zhiyun.cama.data.database.dao.BaseDao;
import e.a.v0.g;
import java.util.List;
import java.util.function.Consumer;

public final class b
implements g {
    public final /* synthetic */ Consumer a;

    public /* synthetic */ b(Consumer consumer) {
        this.a = consumer;
    }

    public final void accept(Object object) {
        Consumer consumer = this.a;
        object = (List)object;
        BaseDao.a(consumer, (List)object);
    }
}

