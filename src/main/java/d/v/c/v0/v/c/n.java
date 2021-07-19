/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import com.zhiyun.cama.data.api.entity.music.AlbumListBean$AlbumBean;
import d.v.c.v0.v.c.s;
import java.util.function.Function;

public final class n
implements Function {
    public final /* synthetic */ boolean a;

    public /* synthetic */ n(boolean bl2) {
        this.a = bl2;
    }

    public final Object apply(Object object) {
        boolean bl2 = this.a;
        object = (AlbumListBean$AlbumBean)object;
        return s.c0(bl2, (AlbumListBean$AlbumBean)object);
    }
}

