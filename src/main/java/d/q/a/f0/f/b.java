/*
 * Decompiled with CFR 0.151.
 */
package d.q.a.f0.f;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import d.q.a.f0.f.a;
import d.q.a.f0.f.b$a;
import d.q.a.f0.f.b$b;
import d.q.a.h0.e;
import d.q.a.h0.f;
import d.q.a.h0.g;
import e.a.z;

public final class b
implements f {
    private static final e d = a.a;
    private final e b;
    private final LifecycleEventsObservable c;

    private b(Lifecycle lifecycle, e e10) {
        LifecycleEventsObservable lifecycleEventsObservable;
        this.c = lifecycleEventsObservable = new LifecycleEventsObservable(lifecycle);
        this.b = e10;
    }

    public static b e(Lifecycle lifecycle) {
        e e10 = d;
        return d.q.a.f0.f.b.g(lifecycle, e10);
    }

    public static b f(Lifecycle lifecycle, Lifecycle$Event lifecycle$Event) {
        b$b b$b = new b$b(lifecycle$Event);
        return d.q.a.f0.f.b.g(lifecycle, b$b);
    }

    public static b g(Lifecycle lifecycle, e e10) {
        b b10 = new b(lifecycle, e10);
        return b10;
    }

    public static b h(LifecycleOwner lifecycleOwner) {
        return d.q.a.f0.f.b.e(lifecycleOwner.getLifecycle());
    }

    public static b i(LifecycleOwner lifecycleOwner, Lifecycle$Event lifecycle$Event) {
        return d.q.a.f0.f.b.f(lifecycleOwner.getLifecycle(), lifecycle$Event);
    }

    public static b j(LifecycleOwner lifecycleOwner, e e10) {
        return d.q.a.f0.f.b.g(lifecycleOwner.getLifecycle(), e10);
    }

    public static /* synthetic */ Lifecycle$Event k(Lifecycle$Event object) {
        Object object2 = b$a.a;
        int n10 = object.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    n10 = 4;
                    if (n11 == n10) {
                        return Lifecycle$Event.ON_STOP;
                    }
                    object2 = new LifecycleEndedException;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Lifecycle has ended! Last event was ");
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    object2((String)object);
                    throw object2;
                }
                return Lifecycle$Event.ON_PAUSE;
            }
            return Lifecycle$Event.ON_STOP;
        }
        return Lifecycle$Event.ON_DESTROY;
    }

    public e.a.g a() {
        return g.c(this);
    }

    public z b() {
        return this.c;
    }

    public e d() {
        return this.b;
    }

    public Lifecycle$Event l() {
        this.c.h8();
        return this.c.i8();
    }
}

