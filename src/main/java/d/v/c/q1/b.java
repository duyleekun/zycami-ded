/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.SetAboutFragment;

public final class b
implements Observer {
    public final /* synthetic */ SetAboutFragment a;

    public /* synthetic */ b(SetAboutFragment setAboutFragment) {
        this.a = setAboutFragment;
    }

    public final void onChanged(Object object) {
        SetAboutFragment setAboutFragment = this.a;
        object = (String)object;
        setAboutFragment.o((String)object);
    }
}

