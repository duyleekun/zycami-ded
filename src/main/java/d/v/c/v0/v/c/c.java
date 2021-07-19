/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import com.zhiyun.cama.data.database.model.music.MusicData;
import d.v.c.v0.v.c.s;
import java.util.function.Predicate;

public final class c
implements Predicate {
    public final /* synthetic */ long a;

    public /* synthetic */ c(long l10) {
        this.a = l10;
    }

    public final boolean test(Object object) {
        long l10 = this.a;
        object = (MusicData)object;
        return s.R(l10, (MusicData)object);
    }
}

