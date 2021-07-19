/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.f;

import androidx.lifecycle.Observer;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.x0.c.f.k;

public final class b
implements Observer {
    public final /* synthetic */ k a;

    public /* synthetic */ b(k k10) {
        this.a = k10;
    }

    public final void onChanged(Object object) {
        k k10 = this.a;
        object = (DecorationType)((Object)object);
        k10.I((DecorationType)((Object)object));
    }
}

