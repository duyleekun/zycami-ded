/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class s
implements Predicate {
    public static final /* synthetic */ s a;

    static {
        s s10;
        a = s10 = new s();
    }

    public final boolean test(Object object) {
        return AlbumListAdapter.j((AlbumSection)object);
    }
}

