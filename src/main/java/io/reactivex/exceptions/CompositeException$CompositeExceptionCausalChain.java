/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.exceptions;

public final class CompositeException$CompositeExceptionCausalChain
extends RuntimeException {
    public static final String MESSAGE = "Chain of Causes for CompositeException In Order Received =>";
    private static final long serialVersionUID = 3875212506787802066L;

    public String getMessage() {
        return MESSAGE;
    }
}

