/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.o.b;

import com.zhiyun.cama.data.database.dao.MusicInfoDataDao;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;
import java.util.function.Predicate;

public final class c
implements Predicate {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final boolean test(Object object) {
        return MusicInfoDataDao.e((MusicInfoData)object);
    }
}

