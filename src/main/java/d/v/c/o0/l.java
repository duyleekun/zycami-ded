/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumListAdapter;
import java.util.function.Consumer;

public final class l
implements Consumer {
    public static final /* synthetic */ l a;

    static {
        l l10;
        a = l10 = new l();
    }

    public final void accept(Object object) {
        AlbumListAdapter.i((Album)object);
    }
}

