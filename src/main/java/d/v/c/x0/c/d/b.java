/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.d;

import androidx.lifecycle.Observer;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.x0.c.d.j;

public final class b
implements Observer {
    public final /* synthetic */ j a;

    public /* synthetic */ b(j j10) {
        this.a = j10;
    }

    public final void onChanged(Object object) {
        j j10 = this.a;
        object = (DecorationType)((Object)object);
        j10.I((DecorationType)((Object)object));
    }
}

