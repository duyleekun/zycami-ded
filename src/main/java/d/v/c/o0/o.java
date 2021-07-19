/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Consumer;

public final class o
implements Consumer {
    public final /* synthetic */ boolean a;

    public /* synthetic */ o(boolean bl2) {
        this.a = bl2;
    }

    public final void accept(Object object) {
        boolean bl2 = this.a;
        object = (AlbumSection)object;
        AlbumListAdapter.p(bl2, (AlbumSection)object);
    }
}

