/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import d.v.e.i.g$a;
import d.v.e.i.g$b;
import d.v.e.i.g$c;
import d.v.e.i.g$d;
import d.v.e.i.i;

public class g {
    private g() {
    }

    public static i a(LiveData liveData, Function function) {
        i i10 = new i();
        g$a g$a = new g$a(i10, function);
        i10.addSource(liveData, g$a);
        return i10;
    }

    public static i b(LiveData liveData, Function function, boolean bl2) {
        i i10 = new i();
        g$c g$c = new g$c(i10, function);
        i10.b(liveData, g$c, bl2);
        return i10;
    }

    public static i c(LiveData liveData, Function function) {
        i i10 = new i();
        g$b g$b = new g$b(function, i10);
        i10.addSource(liveData, g$b);
        return i10;
    }

    public static i d(LiveData liveData, Function function, boolean bl2) {
        i i10 = new i();
        g$d g$d = new g$d(function, i10);
        i10.b(liveData, g$d, bl2);
        return i10;
    }
}

