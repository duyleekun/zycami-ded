/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.s;

import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestCoordinator$RequestState;
import d.c.a.s.d;

public final class b
implements RequestCoordinator,
d {
    private final Object a;
    private final RequestCoordinator b;
    private volatile d c;
    private volatile d d;
    private RequestCoordinator$RequestState e;
    private RequestCoordinator$RequestState f;

    public b(Object object, RequestCoordinator requestCoordinator) {
        RequestCoordinator$RequestState requestCoordinator$RequestState;
        this.e = requestCoordinator$RequestState = RequestCoordinator$RequestState.CLEARED;
        this.f = requestCoordinator$RequestState;
        this.a = object;
        this.b = requestCoordinator;
    }

    private boolean j(d d10) {
        boolean bl2;
        RequestCoordinator$RequestState requestCoordinator$RequestState;
        Object object = this.c;
        boolean bl3 = d10.equals(object);
        if (!(bl3 || (object = this.e) == (requestCoordinator$RequestState = RequestCoordinator$RequestState.FAILED) && (bl2 = d10.equals(object = this.d)))) {
            bl2 = false;
            d10 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean k() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.b;
        if (requestCoordinator != null && !(bl2 = requestCoordinator.i(this))) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean l() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.b;
        if (requestCoordinator != null && !(bl2 = requestCoordinator.b(this))) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean m() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.b;
        if (requestCoordinator != null && !(bl2 = requestCoordinator.c(this))) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a() {
        Object object = this.a;
        synchronized (object) {
            d d10 = this.c;
            boolean bl2 = d10.a();
            if (bl2) return true;
            d10 = this.d;
            bl2 = d10.a();
            if (!bl2) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b(d d10) {
        Object object = this.a;
        synchronized (object) {
            boolean bl2 = this.l();
            if (!bl2) return false;
            boolean bl3 = this.j(d10);
            if (!bl3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void begin() {
        Object object = this.a;
        synchronized (object) {
            Object object2 = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState = RequestCoordinator$RequestState.RUNNING;
            if (object2 != requestCoordinator$RequestState) {
                this.e = requestCoordinator$RequestState;
                object2 = this.c;
                object2.begin();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c(d d10) {
        Object object = this.a;
        synchronized (object) {
            boolean bl2 = this.m();
            if (!bl2) return false;
            boolean bl3 = this.j(d10);
            if (!bl3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        Object object = this.a;
        synchronized (object) {
            Object object2 = RequestCoordinator$RequestState.CLEARED;
            this.e = object2;
            Object object3 = this.c;
            object3.clear();
            object3 = this.f;
            if (object3 != object2) {
                this.f = object2;
                object2 = this.d;
                object2.clear();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(d object) {
        Object object2 = this.a;
        synchronized (object2) {
            Object object3 = this.d;
            boolean bl2 = object.equals(object3);
            if (!bl2) {
                object = RequestCoordinator$RequestState.FAILED;
                this.e = object;
                object = this.f;
                object3 = RequestCoordinator$RequestState.RUNNING;
                if (object != object3) {
                    this.f = object3;
                    object = this.d;
                    object.begin();
                }
                return;
            }
            object = RequestCoordinator$RequestState.FAILED;
            this.f = object;
            object = this.b;
            if (object != null) {
                object.d(this);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean e() {
        Object object = this.a;
        synchronized (object) {
            RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.CLEARED;
            if (requestCoordinator$RequestState != requestCoordinator$RequestState2) return false;
            requestCoordinator$RequestState = this.f;
            if (requestCoordinator$RequestState != requestCoordinator$RequestState2) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f(d object) {
        Object object2 = this.a;
        synchronized (object2) {
            d d10 = this.c;
            boolean bl2 = object.equals(d10);
            if (bl2) {
                object = RequestCoordinator$RequestState.SUCCESS;
                this.e = object;
            } else {
                d10 = this.d;
                boolean bl3 = object.equals(d10);
                if (bl3) {
                    object = RequestCoordinator$RequestState.SUCCESS;
                    this.f = object;
                }
            }
            object = this.b;
            if (object != null) {
                object.f(this);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean g() {
        Object object = this.a;
        synchronized (object) {
            RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.SUCCESS;
            if (requestCoordinator$RequestState == requestCoordinator$RequestState2) return true;
            requestCoordinator$RequestState = this.f;
            if (requestCoordinator$RequestState != requestCoordinator$RequestState2) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public RequestCoordinator getRoot() {
        Object object = this.a;
        synchronized (object) {
            RequestCoordinator requestCoordinator = this.b;
            if (requestCoordinator == null) return this;
            return requestCoordinator.getRoot();
        }
    }

    public boolean h(d d10) {
        boolean bl2 = d10 instanceof b;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            d10 = (b)d10;
            d d11 = this.c;
            d d12 = ((b)d10).c;
            bl2 = d11.h(d12);
            if (bl2 && (bl4 = (d11 = this.d).h(d10 = ((b)d10).d))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean i(d d10) {
        Object object = this.a;
        synchronized (object) {
            boolean bl2 = this.k();
            if (!bl2) return false;
            boolean bl3 = this.j(d10);
            if (!bl3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isRunning() {
        Object object = this.a;
        synchronized (object) {
            RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.RUNNING;
            if (requestCoordinator$RequestState == requestCoordinator$RequestState2) return true;
            requestCoordinator$RequestState = this.f;
            if (requestCoordinator$RequestState != requestCoordinator$RequestState2) return false;
            return true;
        }
    }

    public void n(d d10, d d11) {
        this.c = d10;
        this.d = d11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pause() {
        Object object = this.a;
        synchronized (object) {
            Object object2 = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState = RequestCoordinator$RequestState.RUNNING;
            if (object2 == requestCoordinator$RequestState) {
                object2 = RequestCoordinator$RequestState.PAUSED;
                this.e = object2;
                object2 = this.c;
                object2.pause();
            }
            if ((object2 = this.f) == requestCoordinator$RequestState) {
                object2 = RequestCoordinator$RequestState.PAUSED;
                this.f = object2;
                object2 = this.d;
                object2.pause();
            }
            return;
        }
    }
}

