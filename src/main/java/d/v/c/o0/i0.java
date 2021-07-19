/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.o0;

import com.zhiyun.cama.album.AlbumSection;
import java.util.function.Predicate;

public final class i0
implements Predicate {
    public static final /* synthetic */ i0 a;

    static {
        i0 i02;
        a = i02 = new i0();
    }

    public final boolean test(Object object) {
        return ((AlbumSection)object).isHeader();
    }
}

