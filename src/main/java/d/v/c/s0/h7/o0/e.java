/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import com.zhiyun.cama.album.AlbumSection;
import java.util.List;
import java.util.function.Consumer;

public final class e
implements Consumer {
    public final /* synthetic */ List a;

    public /* synthetic */ e(List list) {
        this.a = list;
    }

    public final void accept(Object object) {
        List list = this.a;
        object = (AlbumSection)object;
        list.add(object);
    }
}

