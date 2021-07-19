/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o1;

import cn.leancloud.AVInstallation;
import cn.leancloud.AVObject;
import d.v.a.f.c.b;
import d.v.a.f.c.d.d;
import e.a.g0;
import m.a.a;

public final class b$a
implements g0 {
    public void a(AVObject object) {
        object = AVInstallation.getCurrentInstallation().getInstallationId();
        d.F().a0((String)object);
        b.N().a();
        b.N().p();
        Object[] objectArray = new StringBuilder();
        objectArray.append("AVInstallation \u4fdd\u5b58installationId");
        objectArray.append((String)object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        a.b((String)object, objectArray);
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        ((Throwable)object).printStackTrace();
        d.F().a0("");
        Object[] objectArray = new StringBuilder();
        objectArray.append("AVInstallation onError");
        object = ((Throwable)object).toString();
        objectArray.append((String)object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        a.b((String)object, objectArray);
    }

    public void onSubscribe(e.a.s0.b b10) {
    }
}

