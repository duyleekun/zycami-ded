/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.w0.b.a;
import io.reactivex.internal.util.NotificationLite;

public final class y {
    public static final y b;
    public final Object a;

    static {
        y y10;
        b = y10 = new y(null);
    }

    private y(Object object) {
        this.a = object;
    }

    public static y a() {
        return b;
    }

    public static y b(Throwable object) {
        e.a.w0.b.a.g(object, "error is null");
        object = NotificationLite.error((Throwable)object);
        y y10 = new y(object);
        return y10;
    }

    public static y c(Object object) {
        e.a.w0.b.a.g(object, "value is null");
        y y10 = new y(object);
        return y10;
    }

    public Throwable d() {
        Object object = this.a;
        boolean bl2 = NotificationLite.isError(object);
        if (bl2) {
            return NotificationLite.getError(object);
        }
        return null;
    }

    public Object e() {
        boolean bl2;
        Object object = this.a;
        if (object != null && !(bl2 = NotificationLite.isError(object))) {
            return this.a;
        }
        return null;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof y;
        if (bl2) {
            object = (y)object;
            Object object2 = this.a;
            object = ((y)object).a;
            return e.a.w0.b.a.c(object2, object);
        }
        return false;
    }

    public boolean f() {
        boolean bl2;
        Object object = this.a;
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean g() {
        return NotificationLite.isError(this.a);
    }

    public boolean h() {
        boolean bl2;
        Object object = this.a;
        if (object != null && !(bl2 = NotificationLite.isError(object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        Object object = this.a;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public String toString() {
        Object object = this.a;
        if (object == null) {
            return "OnCompleteNotification";
        }
        boolean bl2 = NotificationLite.isError(object);
        String string2 = "]";
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OnErrorNotification[");
            object = NotificationLite.getError(object);
            stringBuilder.append(object);
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("OnNextNotification[");
        Object object2 = this.a;
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(string2);
        return ((StringBuilder)object).toString();
    }
}

