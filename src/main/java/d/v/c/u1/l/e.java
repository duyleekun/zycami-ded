/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.l;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.PlayState;
import d.v.c.u1.l.l;

public final class e
implements Observer {
    public final /* synthetic */ l a;

    public /* synthetic */ e(l l10) {
        this.a = l10;
    }

    public final void onChanged(Object object) {
        l l10 = this.a;
        object = (PlayState)((Object)object);
        l10.b0((PlayState)((Object)object));
    }
}

