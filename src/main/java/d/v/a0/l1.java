/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.h1;
import d.v.a0.l1$a;
import d.v.a0.n1.a;
import d.v.a0.n1.e;
import d.v.z.n.b;
import d.v.z.n.c;
import d.v.z.n.d;
import d.v.z.n.g;
import d.v.z.n.h;
import d.v.z.o.i;
import java.util.function.Consumer;

public class l1 {
    private e a;
    private a b;

    public void a(d.v.k0.f.d.a a10) {
        this.b(a10, null);
    }

    public void b(d.v.k0.f.d.a object, Consumer consumer) {
        Object object2 = ((d.v.k0.f.d.a)object).c();
        Object object3 = i.a(object2);
        boolean bl2 = i.e(object2);
        Object object4 = bl2 ? new d.v.z.m.c() : ((bl2 = i.f(object2)) ? new d.v.z.m.d() : new d.v.z.m.a());
        Object object5 = this.b;
        if (object5 != null) {
            object5.a((d.v.k0.f.d.a)object);
        }
        object5 = l1$a.a;
        Object object6 = ((Enum)object3).ordinal();
        Object object7 = 2;
        if ((object6 = (Object)object5[object6]) != object7) {
            object7 = 3;
            if (object6 != object7) {
                object7 = 4;
                if (object6 != object7) {
                    object7 = 5;
                    if (object6 != object7) {
                        object7 = 6;
                        if (object6 == object7) {
                            object3 = new d.v.z.n.e((d.v.z.m.b)object4);
                            object4 = new h1((g)object3, (d.v.k0.f.d.a)object);
                            boolean bl3 = ((g)object3).parseFrom((byte[])object2);
                            if (bl3) {
                                if (consumer != null) {
                                    consumer.accept(object4);
                                } else {
                                    object = this.a;
                                    if (object != null) {
                                        object.b((h1)object4);
                                    }
                                }
                            }
                        }
                    } else {
                        object3 = new b((d.v.z.m.b)object4);
                        boolean bl4 = ((g)object3).parseFrom((byte[])object2);
                        if (bl4) {
                            object2 = new h1;
                            object2((g)object3, (d.v.k0.f.d.a)object);
                            if (consumer != null) {
                                consumer.accept(object2);
                            } else {
                                object = this.a;
                                if (object != null) {
                                    object.e((h1)object2);
                                }
                            }
                        }
                    }
                } else {
                    object3 = new c((d.v.z.m.b)object4);
                    boolean bl5 = ((g)object3).parseFrom((byte[])object2);
                    if (bl5) {
                        object2 = new h1;
                        object2((g)object3, (d.v.k0.f.d.a)object);
                        if (consumer != null) {
                            consumer.accept(object2);
                        } else {
                            object = this.a;
                            if (object != null) {
                                object.d((h1)object2);
                            }
                        }
                    }
                }
            } else {
                object3 = new h((d.v.z.m.b)object4);
                boolean bl6 = ((g)object3).parseFrom((byte[])object2);
                if (bl6) {
                    object2 = new h1;
                    object2((g)object3, (d.v.k0.f.d.a)object);
                    if (consumer != null) {
                        consumer.accept(object2);
                    } else {
                        object = this.a;
                        if (object != null) {
                            object.c((h1)object2);
                        }
                    }
                }
            }
        } else {
            object3 = new d((d.v.z.m.b)object4);
            boolean bl7 = ((g)object3).parseFrom((byte[])object2);
            if (bl7) {
                object2 = new h1;
                object2((g)object3, (d.v.k0.f.d.a)object);
                if (consumer != null) {
                    consumer.accept(object2);
                } else {
                    object = this.a;
                    if (object != null) {
                        object.a((h1)object2);
                    }
                }
            }
        }
    }

    public void c(a a10) {
        this.b = a10;
    }

    public void d(e e10) {
        this.a = e10;
    }
}

