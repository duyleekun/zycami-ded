/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumDetailFragment;
import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class d
implements Predicate {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final boolean test(Object object) {
        return AlbumDetailFragment.x((AlbumSection)object);
    }
}

