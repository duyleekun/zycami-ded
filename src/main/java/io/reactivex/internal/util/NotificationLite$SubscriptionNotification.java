/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import i.g.e;
import java.io.Serializable;

public final class NotificationLite$SubscriptionNotification
implements Serializable {
    private static final long serialVersionUID = -1322257508628817540L;
    public final e upstream;

    public NotificationLite$SubscriptionNotification(e e10) {
        this.upstream = e10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NotificationLite.Subscription[");
        e e10 = this.upstream;
        stringBuilder.append(e10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

