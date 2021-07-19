/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class k
implements Predicate {
    public final /* synthetic */ AlbumSection a;

    public /* synthetic */ k(AlbumSection albumSection) {
        this.a = albumSection;
    }

    public final boolean test(Object object) {
        AlbumSection albumSection = this.a;
        object = (AlbumSection)object;
        return AlbumListAdapter.q(albumSection, (AlbumSection)object);
    }
}

