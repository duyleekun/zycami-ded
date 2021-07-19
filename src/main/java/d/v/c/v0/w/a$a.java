/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.w;

import com.zhiyun.cama.data.api.entity.SplashEntity;
import d.v.c.v0.w.a;
import d.v.c.v0.w.b.h;
import java.util.ArrayList;

public class a$a
extends d.v.a.f.b.a {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    public void a(SplashEntity object) {
        h h10 = d.v.c.v0.w.a.a(this.a);
        object = ((SplashEntity)object).splash_ad;
        h10.z((ArrayList)object);
    }

    public void onError(Throwable throwable, int n10, String string2) {
    }
}

