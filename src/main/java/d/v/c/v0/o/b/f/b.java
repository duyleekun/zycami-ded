/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.o.b.f;

import com.zhiyun.cama.data.database.dao.music.MusicFileDao;
import com.zhiyun.cama.data.database.model.music.MusicFile;
import java.util.function.Predicate;

public final class b
implements Predicate {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final boolean test(Object object) {
        return MusicFileDao.c((MusicFile)object);
    }
}

