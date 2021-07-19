/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import e.a.w0.b.a;
import java.io.Serializable;

public final class NotificationLite$ErrorNotification
implements Serializable {
    private static final long serialVersionUID = -8759979445933046293L;
    public final Throwable e;

    public NotificationLite$ErrorNotification(Throwable throwable) {
        this.e = throwable;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof NotificationLite$ErrorNotification;
        if (bl2) {
            object = (NotificationLite$ErrorNotification)object;
            Throwable throwable = this.e;
            object = ((NotificationLite$ErrorNotification)object).e;
            return a.c(throwable, object);
        }
        return false;
    }

    public int hashCode() {
        return this.e.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NotificationLite.Error[");
        Throwable throwable = this.e;
        stringBuilder.append(throwable);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

