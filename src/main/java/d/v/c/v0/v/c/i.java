/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import com.zhiyun.cama.data.database.model.music.MusicData;
import d.v.c.v0.v.c.s;
import java.util.function.Predicate;

public final class i
implements Predicate {
    public static final /* synthetic */ i a;

    static {
        i i10;
        a = i10 = new i();
    }

    public final boolean test(Object object) {
        return s.Z((MusicData)object);
    }
}

