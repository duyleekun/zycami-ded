/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common;

import com.google.android.gms.common.internal.Preconditions;

public class MlKitException
extends Exception {
    public static final int ABORTED = 10;
    public static final int ALREADY_EXISTS = 6;
    public static final int CANCELLED = 1;
    public static final int DATA_LOSS = 15;
    public static final int DEADLINE_EXCEEDED = 4;
    public static final int FAILED_PRECONDITION = 9;
    public static final int INTERNAL = 13;
    public static final int INVALID_ARGUMENT = 3;
    public static final int MODEL_HASH_MISMATCH = 102;
    public static final int MODEL_INCOMPATIBLE_WITH_TFLITE = 100;
    public static final int NETWORK_ISSUE = 17;
    public static final int NOT_ENOUGH_SPACE = 101;
    public static final int NOT_FOUND = 5;
    public static final int OUT_OF_RANGE = 11;
    public static final int PERMISSION_DENIED = 7;
    public static final int RESOURCE_EXHAUSTED = 8;
    public static final int UNAUTHENTICATED = 16;
    public static final int UNAVAILABLE = 14;
    public static final int UNIMPLEMENTED = 12;
    public static final int UNKNOWN = 2;
    private final int zza;

    public MlKitException(String string2, int n10) {
        string2 = Preconditions.checkNotEmpty(string2, "Provided message must not be empty.");
        super(string2);
        this.zza = n10;
    }

    public MlKitException(String string2, int n10, Throwable throwable) {
        string2 = Preconditions.checkNotEmpty(string2, "Provided message must not be empty.");
        super(string2, throwable);
        this.zza = n10;
    }

    public int getErrorCode() {
        return this.zza;
    }
}

