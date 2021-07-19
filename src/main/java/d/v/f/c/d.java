/*
 * Decompiled with CFR 0.151.
 */
package d.v.f.c;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import d.v.f.c.a;
import d.v.f.i.g;
import l.a.q.z;

public class d
extends a
implements z {
    public void e() {
        g.b(this.getSupportFragmentManager());
    }

    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }
}

