/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.exceptions;

public final class OnErrorNotImplementedException
extends RuntimeException {
    private static final long serialVersionUID = -6298857009889503852L;

    public OnErrorNotImplementedException(String string2, Throwable throwable) {
        if (throwable == null) {
        }
        super(string2, throwable);
    }

    public OnErrorNotImplementedException(Throwable throwable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("The exception was not handled due to missing onError handler in the subscribe() method call. Further reading: https://github.com/ReactiveX/RxJava/wiki/Error-Handling | ");
        charSequence.append(throwable);
        charSequence = charSequence.toString();
        this((String)charSequence, throwable);
    }
}

