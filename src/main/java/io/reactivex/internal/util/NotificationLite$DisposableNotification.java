/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.util;

import e.a.s0.b;
import java.io.Serializable;

public final class NotificationLite$DisposableNotification
implements Serializable {
    private static final long serialVersionUID = -7482590109178395495L;
    public final b upstream;

    public NotificationLite$DisposableNotification(b b10) {
        this.upstream = b10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NotificationLite.Disposable[");
        b b10 = this.upstream;
        stringBuilder.append(b10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

