/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import com.zhiyun.cama.data.database.model.music.MusicInfoData;
import d.v.c.v0.v.c.s;
import java.util.Comparator;

public final class b
implements Comparator {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final int compare(Object object, Object object2) {
        object = (MusicInfoData)object;
        object2 = (MusicInfoData)object2;
        return s.b0((MusicInfoData)object, (MusicInfoData)object2);
    }
}

