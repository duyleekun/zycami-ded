/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.o.b.f;

import androidx.arch.core.util.Function;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao;
import java.util.List;

public final class a
implements Function {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final Object apply(Object object) {
        return MusicFileDao.f((List)object);
    }
}

