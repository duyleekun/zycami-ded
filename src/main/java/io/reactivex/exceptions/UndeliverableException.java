/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.exceptions;

public final class UndeliverableException
extends IllegalStateException {
    private static final long serialVersionUID = 1644750035281290266L;

    public UndeliverableException(Throwable throwable) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | ");
        charSequence.append(throwable);
        charSequence = charSequence.toString();
        super((String)charSequence, throwable);
    }
}

