/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.exceptions;

import io.reactivex.exceptions.CompositeException$a;
import java.io.PrintStream;

public final class CompositeException$b
extends CompositeException$a {
    private final PrintStream a;

    public CompositeException$b(PrintStream printStream) {
        this.a = printStream;
    }

    public void a(Object object) {
        this.a.println(object);
    }
}

