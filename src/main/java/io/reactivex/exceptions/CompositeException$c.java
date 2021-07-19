/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.exceptions;

import io.reactivex.exceptions.CompositeException$a;
import java.io.PrintWriter;

public final class CompositeException$c
extends CompositeException$a {
    private final PrintWriter a;

    public CompositeException$c(PrintWriter printWriter) {
        this.a = printWriter;
    }

    public void a(Object object) {
        this.a.println(object);
    }
}

