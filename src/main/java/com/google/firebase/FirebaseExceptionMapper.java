/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;

public class FirebaseExceptionMapper
implements StatusExceptionMapper {
    public Exception getException(Status object) {
        int n10;
        int n11 = ((Status)object).getStatusCode();
        if (n11 == (n10 = 8)) {
            object = ((Status)object).zza();
            FirebaseException firebaseException = new FirebaseException((String)object);
            return firebaseException;
        }
        object = ((Status)object).zza();
        FirebaseApiNotAvailableException firebaseApiNotAvailableException = new FirebaseApiNotAvailableException((String)object);
        return firebaseApiNotAvailableException;
    }
}

