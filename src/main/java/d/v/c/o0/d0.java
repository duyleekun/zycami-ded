/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.u0;
import java.util.List;
import java.util.function.Predicate;

public final class d0
implements Predicate {
    public final /* synthetic */ List a;

    public /* synthetic */ d0(List list) {
        this.a = list;
    }

    public final boolean test(Object object) {
        List list = this.a;
        object = (AlbumSection)object;
        return u0.p(list, (AlbumSection)object);
    }
}

