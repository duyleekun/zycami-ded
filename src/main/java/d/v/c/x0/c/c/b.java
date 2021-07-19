/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.c;

import androidx.lifecycle.Observer;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.x0.c.c.d;

public final class b
implements Observer {
    public final /* synthetic */ d a;

    public /* synthetic */ b(d d10) {
        this.a = d10;
    }

    public final void onChanged(Object object) {
        d d10 = this.a;
        object = (DecorationType)((Object)object);
        d10.B((DecorationType)((Object)object));
    }
}

