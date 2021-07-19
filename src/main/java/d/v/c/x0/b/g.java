/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.x0.b.p;

public final class g
implements Observer {
    public final /* synthetic */ p a;

    public /* synthetic */ g(p p10) {
        this.a = p10;
    }

    public final void onChanged(Object object) {
        p p10 = this.a;
        object = (DecorationType)((Object)object);
        p10.M((DecorationType)((Object)object));
    }
}

