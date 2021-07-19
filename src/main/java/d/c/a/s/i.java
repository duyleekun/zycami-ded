/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.s;

import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestCoordinator$RequestState;
import d.c.a.s.d;

public class i
implements RequestCoordinator,
d {
    private final RequestCoordinator a;
    private final Object b;
    private volatile d c;
    private volatile d d;
    private RequestCoordinator$RequestState e;
    private RequestCoordinator$RequestState f;
    private boolean g;

    public i(Object object, RequestCoordinator requestCoordinator) {
        RequestCoordinator$RequestState requestCoordinator$RequestState;
        this.e = requestCoordinator$RequestState = RequestCoordinator$RequestState.CLEARED;
        this.f = requestCoordinator$RequestState;
        this.b = object;
        this.a = requestCoordinator;
    }

    private boolean j() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.a;
        if (requestCoordinator != null && !(bl2 = requestCoordinator.i(this))) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean k() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.a;
        if (requestCoordinator != null && !(bl2 = requestCoordinator.b(this))) {
            bl2 = false;
            requestCoordinator = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private boolean l() {
        boolean bl2;
        RequestCoordinator requestCoordinator = this.a;
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
        Object object = this.b;
        synchronized (object) {
            d d10 = this.d;
            boolean bl2 = d10.a();
            if (bl2) return true;
            d10 = this.c;
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
        Object object = this.b;
        synchronized (object) {
            boolean bl2 = this.k();
            if (!bl2) return false;
            d d11 = this.c;
            boolean bl3 = d10.equals(d11);
            if (!bl3) return false;
            bl3 = this.a();
            if (bl3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void begin() {
        Object object = this.b;
        synchronized (object) {
            boolean bl2;
            boolean bl3;
            this.g = bl3 = true;
            bl3 = false;
            Object var3_3 = null;
            Object object2 = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState = RequestCoordinator$RequestState.SUCCESS;
            if (object2 != requestCoordinator$RequestState && (object2 = this.f) != (requestCoordinator$RequestState = RequestCoordinator$RequestState.RUNNING)) {
                this.f = requestCoordinator$RequestState;
                object2 = this.d;
                object2.begin();
            }
            if (!(bl2 = this.g)) return;
            object2 = this.e;
            requestCoordinator$RequestState = RequestCoordinator$RequestState.RUNNING;
            if (object2 == requestCoordinator$RequestState) return;
            this.e = requestCoordinator$RequestState;
            object2 = this.c;
            object2.begin();
            return;
            finally {
                this.g = false;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean c(d object) {
        Object object2 = this.b;
        synchronized (object2) {
            boolean bl2 = this.l();
            if (!bl2) return false;
            Object object3 = this.c;
            boolean bl3 = object.equals(object3);
            if (bl3) return true;
            object = this.e;
            object3 = RequestCoordinator$RequestState.SUCCESS;
            if (object == object3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        Object object = this.b;
        synchronized (object) {
            Object object2 = null;
            this.g = false;
            object2 = RequestCoordinator$RequestState.CLEARED;
            this.e = object2;
            this.f = object2;
            object2 = this.d;
            object2.clear();
            object2 = this.c;
            object2.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(d object) {
        Object object2 = this.b;
        synchronized (object2) {
            d d10 = this.c;
            boolean bl2 = object.equals(d10);
            if (!bl2) {
                object = RequestCoordinator$RequestState.FAILED;
                this.f = object;
                return;
            }
            object = RequestCoordinator$RequestState.FAILED;
            this.e = object;
            object = this.a;
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
        Object object = this.b;
        synchronized (object) {
            RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.CLEARED;
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
        Object object2 = this.b;
        synchronized (object2) {
            d d10 = this.d;
            boolean bl2 = object.equals(d10);
            if (bl2) {
                object = RequestCoordinator$RequestState.SUCCESS;
                this.f = object;
                return;
            }
            object = RequestCoordinator$RequestState.SUCCESS;
            this.e = object;
            object = this.a;
            if (object != null) {
                object.f(this);
            }
            if (!(bl2 = ((RequestCoordinator$RequestState)((Object)(object = this.f))).isComplete())) {
                object = this.d;
                object.clear();
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
        Object object = this.b;
        synchronized (object) {
            RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.SUCCESS;
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
        Object object = this.b;
        synchronized (object) {
            RequestCoordinator requestCoordinator = this.a;
            if (requestCoordinator == null) return this;
            return requestCoordinator.getRoot();
        }
    }

    public boolean h(d d10) {
        boolean bl2 = d10 instanceof i;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            d d11;
            d10 = (i)d10;
            d d12 = this.c;
            if ((d12 == null ? (d12 = ((i)d10).c) == null : (bl2 = (d12 = this.c).h(d11 = ((i)d10).c))) && ((d12 = this.d) == null ? (d10 = ((i)d10).d) == null : (bl4 = (d12 = this.d).h(d10 = ((i)d10).d)))) {
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
    public boolean i(d object) {
        Object object2 = this.b;
        synchronized (object2) {
            boolean bl2 = this.j();
            if (!bl2) return false;
            Object object3 = this.c;
            boolean bl3 = object.equals(object3);
            if (!bl3) return false;
            object = this.e;
            object3 = RequestCoordinator$RequestState.PAUSED;
            if (object == object3) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isRunning() {
        Object object = this.b;
        synchronized (object) {
            RequestCoordinator$RequestState requestCoordinator$RequestState = this.e;
            RequestCoordinator$RequestState requestCoordinator$RequestState2 = RequestCoordinator$RequestState.RUNNING;
            if (requestCoordinator$RequestState != requestCoordinator$RequestState2) return false;
            return true;
        }
    }

    public void m(d d10, d d11) {
        this.c = d10;
        this.d = d11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void pause() {
        Object object = this.b;
        synchronized (object) {
            Object object2 = this.f;
            boolean bl2 = ((RequestCoordinator$RequestState)((Object)object2)).isComplete();
            if (!bl2) {
                object2 = RequestCoordinator$RequestState.PAUSED;
                this.f = object2;
                object2 = this.d;
                object2.pause();
            }
            if (!(bl2 = ((RequestCoordinator$RequestState)((Object)(object2 = this.e))).isComplete())) {
                object2 = RequestCoordinator$RequestState.PAUSED;
                this.e = object2;
                object2 = this.c;
                object2.pause();
            }
            return;
        }
    }
}

