/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ie;

import d.v.e0.ie.c;

public interface a
extends c {
    public void onComplete();

    default public void onFailed(Throwable throwable) {
    }
}

