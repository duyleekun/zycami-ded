/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class j
implements Predicate {
    public static final /* synthetic */ j a;

    static {
        j j10;
        a = j10 = new j();
    }

    public final boolean test(Object object) {
        return AlbumListAdapter.h((AlbumSection)object);
    }
}

