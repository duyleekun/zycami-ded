/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class q
implements Predicate {
    public static final /* synthetic */ q a;

    static {
        q q10;
        a = q10 = new q();
    }

    public final boolean test(Object object) {
        return AlbumListAdapter.k((AlbumSection)object);
    }
}

