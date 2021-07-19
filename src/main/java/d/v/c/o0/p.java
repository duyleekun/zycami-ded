/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class p
implements Predicate {
    public static final /* synthetic */ p a;

    static {
        p p10;
        a = p10 = new p();
    }

    public final boolean test(Object object) {
        return AlbumListAdapter.l((AlbumSection)object);
    }
}

