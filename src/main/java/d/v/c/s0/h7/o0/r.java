/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import com.zhiyun.cama.album.AlbumSection;
import d.v.c.s0.h7.o0.w0;
import java.util.function.Function;

public final class r
implements Function {
    public final /* synthetic */ AlbumSection a;

    public /* synthetic */ r(AlbumSection albumSection) {
        this.a = albumSection;
    }

    public final Object apply(Object object) {
        AlbumSection albumSection = this.a;
        object = (AlbumSection)object;
        return w0.y(albumSection, (AlbumSection)object);
    }
}

