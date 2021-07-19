/*
 * Decompiled with CFR 0.151.
 */
package d.q.a.f0.f;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import d.q.a.b0;
import d.q.a.d;
import d.q.a.d0;
import d.q.a.f0.f.b;
import d.q.a.h0.e;
import d.q.a.t;
import d.q.a.u;
import d.q.a.x;
import d.q.a.y;
import d.q.a.z;
import e.a.a;
import e.a.a0;
import e.a.i0;
import e.a.j;
import e.a.j0;
import e.a.k;
import e.a.q;
import e.a.r;
import f.h2.t.f0;

public final class c {
    public static final b0 A(Lifecycle object, e e10) {
        f0.q(object, "$this$scope");
        f0.q(e10, "boundaryResolver");
        object = b.g((Lifecycle)object, e10);
        f0.h(object, "AndroidLifecycleScopePro\u2026  this, boundaryResolver)");
        return object;
    }

    public static final b0 B(LifecycleOwner object) {
        f0.q(object, "$this$scope");
        object = b.h((LifecycleOwner)object);
        f0.h(object, "AndroidLifecycleScopeProvider.from(this)");
        return object;
    }

    public static final b0 C(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$scope");
        f0.q((Object)lifecycle$Event, "untilEvent");
        object = b.i((LifecycleOwner)object, lifecycle$Event);
        f0.h(object, "AndroidLifecycleScopePro\u2026er.from(this, untilEvent)");
        return object;
    }

    public static final b0 D(LifecycleOwner object, e e10) {
        f0.q(object, "$this$scope");
        f0.q(e10, "boundaryResolver");
        object = b.j((LifecycleOwner)object, e10);
        f0.h(object, "AndroidLifecycleScopePro\u2026m(this, boundaryResolver)");
        return object;
    }

    public static final t a(a object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((a)object).s((e.a.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (t)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((a)object).s((e.a.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (t)object;
        }
        return object;
    }

    public static final u b(j object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((j)object).r((k)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (u)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((j)object).r((k)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (u)object;
        }
        return object;
    }

    public static final x c(q object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((q)object).n((r)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (x)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((q)object).n((r)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (x)object;
        }
        return object;
    }

    public static final y d(e.a.z object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((e.a.z)object).q((a0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (y)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((e.a.z)object).q((a0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (y)object;
        }
        return object;
    }

    public static final z e(e.a.z0.a object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((e.a.z0.a)object).b((e.a.z0.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (z)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((e.a.z0.a)object).b((e.a.z0.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (z)object;
        }
        return object;
    }

    public static final d0 f(i0 object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((i0)object).o((j0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (d0)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((i0)object).o((j0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (d0)object;
        }
        return object;
    }

    public static /* synthetic */ t g(a object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((a)object).s((e.a.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (t)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((a)object).s((e.a.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (t)object;
        }
        return object;
    }

    public static /* synthetic */ u h(j object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((j)object).r((k)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (u)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((j)object).r((k)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (u)object;
        }
        return object;
    }

    public static /* synthetic */ x i(q object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((q)object).n((r)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (x)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((q)object).n((r)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (x)object;
        }
        return object;
    }

    public static /* synthetic */ y j(e.a.z object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((e.a.z)object).q((a0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (y)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((e.a.z)object).q((a0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (y)object;
        }
        return object;
    }

    public static /* synthetic */ z k(e.a.z0.a object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((e.a.z0.a)object).b((e.a.z0.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (z)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((e.a.z0.a)object).b((e.a.z0.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (z)object;
        }
        return object;
    }

    public static /* synthetic */ d0 l(i0 object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDisposable");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((i0)object).o((j0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (d0)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((i0)object).o((j0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (d0)object;
        }
        return object;
    }

    public static final t m(a object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((a)object).s((e.a.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (t)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((a)object).s((e.a.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (t)object;
        }
        return object;
    }

    public static final u n(j object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((j)object).r((k)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (u)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((j)object).r((k)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (u)object;
        }
        return object;
    }

    public static final x o(q object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((q)object).n((r)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (x)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((q)object).n((r)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (x)object;
        }
        return object;
    }

    public static final y p(e.a.z object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((e.a.z)object).q((a0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (y)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((e.a.z)object).q((a0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (y)object;
        }
        return object;
    }

    public static final z q(e.a.z0.a object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((e.a.z0.a)object).b((e.a.z0.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (z)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((e.a.z0.a)object).b((e.a.z0.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (z)object;
        }
        return object;
    }

    public static final d0 r(i0 object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((i0)object).o((j0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (d0)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((i0)object).o((j0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (d0)object;
        }
        return object;
    }

    public static /* synthetic */ t s(a object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((a)object).s((e.a.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (t)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((a)object).s((e.a.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (t)object;
        }
        return object;
    }

    public static /* synthetic */ u t(j object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((j)object).r((k)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (u)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((j)object).r((k)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (u)object;
        }
        return object;
    }

    public static /* synthetic */ x u(q object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((q)object).n((r)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (x)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((q)object).n((r)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (x)object;
        }
        return object;
    }

    public static /* synthetic */ y v(e.a.z object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((e.a.z)object).q((a0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (y)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((e.a.z)object).q((a0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (y)object;
        }
        return object;
    }

    public static /* synthetic */ z w(e.a.z0.a object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((e.a.z0.a)object).b((e.a.z0.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (z)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((e.a.z0.a)object).b((e.a.z0.b)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (z)object;
        }
        return object;
    }

    public static /* synthetic */ d0 x(i0 object, LifecycleOwner object2, Lifecycle$Event lifecycle$Event, int n10, Object object3) {
        if ((n10 &= 2) != 0) {
            lifecycle$Event = null;
        }
        f0.q(object, "$this$autoDispose");
        String string2 = "lifecycleOwner";
        f0.q(object2, string2);
        if (lifecycle$Event == null) {
            object2 = d.a(b.h((LifecycleOwner)object2));
            object = ((i0)object).o((j0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026er.from(lifecycleOwner)))";
            f0.h(object, (String)object2);
            object = (d0)object;
        } else {
            object2 = d.a(b.i((LifecycleOwner)object2, lifecycle$Event));
            object = ((i0)object).o((j0)object2);
            object2 = "this.`as`(AutoDispose.au\u2026cycleOwner, untilEvent)))";
            f0.h(object, (String)object2);
            object = (d0)object;
        }
        return object;
    }

    public static final b0 y(Lifecycle object) {
        f0.q(object, "$this$scope");
        object = b.e((Lifecycle)object);
        f0.h(object, "AndroidLifecycleScopeProvider.from(this)");
        return object;
    }

    public static final b0 z(Lifecycle object, Lifecycle$Event lifecycle$Event) {
        f0.q(object, "$this$scope");
        f0.q((Object)lifecycle$Event, "untilEvent");
        object = b.f((Lifecycle)object, lifecycle$Event);
        f0.h(object, "AndroidLifecycleScopePro\u2026om(\n    this, untilEvent)");
        return object;
    }
}

