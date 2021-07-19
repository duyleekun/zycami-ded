/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.zhiyun.cama.data.database.model.Likes;

public final class j0$a
extends DiffUtil$ItemCallback {
    public boolean a(Likes likes, Likes likes2) {
        return likes.equals(likes2);
    }

    public boolean b(Likes likes, Likes likes2) {
        long l10;
        long l11 = likes.getId();
        long l12 = l11 - (l10 = likes2.getId());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            likes = null;
        }
        return (boolean)object;
    }
}

