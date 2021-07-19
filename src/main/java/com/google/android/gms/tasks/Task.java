/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import java.util.concurrent.Executor;

public abstract class Task {
    public Task addOnCanceledListener(Activity object, OnCanceledListener onCanceledListener) {
        object = new UnsupportedOperationException("addOnCanceledListener is not implemented.");
        throw object;
    }

    public Task addOnCanceledListener(OnCanceledListener object) {
        object = new UnsupportedOperationException("addOnCanceledListener is not implemented.");
        throw object;
    }

    public Task addOnCanceledListener(Executor object, OnCanceledListener onCanceledListener) {
        object = new UnsupportedOperationException("addOnCanceledListener is not implemented");
        throw object;
    }

    public Task addOnCompleteListener(Activity object, OnCompleteListener onCompleteListener) {
        object = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw object;
    }

    public Task addOnCompleteListener(OnCompleteListener object) {
        object = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw object;
    }

    public Task addOnCompleteListener(Executor object, OnCompleteListener onCompleteListener) {
        object = new UnsupportedOperationException("addOnCompleteListener is not implemented");
        throw object;
    }

    public abstract Task addOnFailureListener(Activity var1, OnFailureListener var2);

    public abstract Task addOnFailureListener(OnFailureListener var1);

    public abstract Task addOnFailureListener(Executor var1, OnFailureListener var2);

    public abstract Task addOnSuccessListener(Activity var1, OnSuccessListener var2);

    public abstract Task addOnSuccessListener(OnSuccessListener var1);

    public abstract Task addOnSuccessListener(Executor var1, OnSuccessListener var2);

    public Task continueWith(Continuation object) {
        object = new UnsupportedOperationException("continueWith is not implemented");
        throw object;
    }

    public Task continueWith(Executor object, Continuation continuation) {
        object = new UnsupportedOperationException("continueWith is not implemented");
        throw object;
    }

    public Task continueWithTask(Continuation object) {
        object = new UnsupportedOperationException("continueWithTask is not implemented");
        throw object;
    }

    public Task continueWithTask(Executor object, Continuation continuation) {
        object = new UnsupportedOperationException("continueWithTask is not implemented");
        throw object;
    }

    public abstract Exception getException();

    public abstract Object getResult();

    public abstract Object getResult(Class var1);

    public abstract boolean isCanceled();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();

    public Task onSuccessTask(SuccessContinuation object) {
        object = new UnsupportedOperationException("onSuccessTask is not implemented");
        throw object;
    }

    public Task onSuccessTask(Executor object, SuccessContinuation successContinuation) {
        object = new UnsupportedOperationException("onSuccessTask is not implemented");
        throw object;
    }
}

