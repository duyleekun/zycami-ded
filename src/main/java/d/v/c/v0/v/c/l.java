/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import com.zhiyun.cama.data.api.entity.music.MusicListBean$MusicBean;
import d.v.c.v0.v.c.s;
import java.util.function.Function;

public final class l
implements Function {
    public final /* synthetic */ boolean a;

    public /* synthetic */ l(boolean bl2) {
        this.a = bl2;
    }

    public final Object apply(Object object) {
        boolean bl2 = this.a;
        object = (MusicListBean$MusicBean)object;
        return s.e0(bl2, (MusicListBean$MusicBean)object);
    }
}

