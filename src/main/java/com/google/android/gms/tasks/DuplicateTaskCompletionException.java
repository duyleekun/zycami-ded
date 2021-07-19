/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;

public final class DuplicateTaskCompletionException
extends IllegalStateException {
    private DuplicateTaskCompletionException(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public static IllegalStateException of(Task object) {
        Object object2;
        CharSequence charSequence;
        boolean bl2 = ((Task)object).isComplete();
        if (!bl2) {
            object = new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
            return object;
        }
        Exception exception = ((Task)object).getException();
        if (exception != null) {
            object = "failure";
        } else {
            boolean n10 = ((Task)object).isSuccessful();
            if (n10) {
                object = String.valueOf(((Task)object).getResult());
                int n11 = String.valueOf(object).length() + 7;
                charSequence = new StringBuilder(n11);
                object2 = "result ";
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
            } else {
                boolean bl3 = ((Task)object).isCanceled();
                object = bl3 ? "cancellation" : "unknown issue";
            }
        }
        charSequence = "Complete with: ";
        object = String.valueOf(object);
        int n12 = ((String)object).length();
        object = n12 != 0 ? ((String)charSequence).concat((String)object) : new String((String)charSequence);
        object2 = new DuplicateTaskCompletionException((String)object, exception);
        return object2;
    }
}

