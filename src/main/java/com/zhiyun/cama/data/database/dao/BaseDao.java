/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import d.v.c.v0.o.b.a;
import d.v.c.v0.o.b.b;
import d.v.c.v0.o.b.e;
import e.a.i0;
import e.a.p0;
import e.a.v0.g;
import java.util.List;
import java.util.function.Consumer;

public interface BaseDao {
    public static /* synthetic */ void a(Consumer consumer, List list) {
        if (consumer != null) {
            consumer.accept(list);
        }
    }

    public static /* synthetic */ void b(Consumer consumer, List list) {
        if (consumer != null) {
            consumer.accept(list);
        }
    }

    default public void defaultInsertSingle(List object, Consumer object2) {
        object = this.insertSingle((List)object);
        Object object3 = d.v.e.k.e.f();
        object = ((i0)object).s((p0)object3);
        object3 = new a((Consumer)object2);
        object2 = e.a;
        ((i0)object).c((g)object3, (g)object2);
    }

    default public void defaultReplaceSingle(List object, Consumer object2) {
        object = this.replaceSingle((List)object);
        Object object3 = d.v.e.k.e.f();
        object = ((i0)object).s((p0)object3);
        object3 = new b((Consumer)object2);
        object2 = e.a;
        ((i0)object).c((g)object3, (g)object2);
    }

    public void delete(Object var1);

    public void delete(List var1);

    public long insert(Object var1);

    public List insert(List var1);

    public i0 insertSingle(List var1);

    public long replace(Object var1);

    public List replace(List var1);

    public i0 replaceSingle(List var1);

    public void update(Object var1);
}

