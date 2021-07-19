/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Function;

public final class j0
implements Function {
    public static final /* synthetic */ j0 a;

    static {
        j0 j02;
        a = j02 = new j0();
    }

    public final Object apply(Object object) {
        return ((AlbumSection)object).getAlbum();
    }
}

