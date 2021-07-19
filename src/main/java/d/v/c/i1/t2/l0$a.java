/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.Works;

public final class l0$a
extends DiffUtil$ItemCallback {
    public boolean a(Works works, Works works2) {
        return works.equals(works2);
    }

    public boolean b(Works works, Works works2) {
        long l10;
        long l11 = works.getId();
        long l12 = l11 - (l10 = works2.getId());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            works = null;
        }
        return (boolean)object;
    }
}

