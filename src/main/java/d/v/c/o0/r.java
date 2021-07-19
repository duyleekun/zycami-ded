/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class r
implements Predicate {
    public static final /* synthetic */ r a;

    static {
        r r10;
        a = r10 = new r();
    }

    public final boolean test(Object object) {
        return AlbumListAdapter.n((AlbumSection)object);
    }
}

