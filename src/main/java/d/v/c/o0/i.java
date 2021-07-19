/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class i
implements Predicate {
    public final /* synthetic */ AlbumSection a;

    public /* synthetic */ i(AlbumSection albumSection) {
        this.a = albumSection;
    }

    public final boolean test(Object object) {
        AlbumSection albumSection = this.a;
        object = (AlbumSection)object;
        return AlbumListAdapter.m(albumSection, (AlbumSection)object);
    }
}

