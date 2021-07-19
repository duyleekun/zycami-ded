/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Looper
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi$Settings$Builder;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.zab;

public class GoogleApi$Settings {
    public static final GoogleApi$Settings DEFAULT_SETTINGS;
    public final StatusExceptionMapper zabn;
    public final Looper zabo;

    static {
        GoogleApi$Settings$Builder googleApi$Settings$Builder = new GoogleApi$Settings$Builder();
        DEFAULT_SETTINGS = googleApi$Settings$Builder.build();
    }

    private GoogleApi$Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
        this.zabn = statusExceptionMapper;
        this.zabo = looper;
    }

    public /* synthetic */ GoogleApi$Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper, zab zab2) {
        this(statusExceptionMapper, null, looper);
    }
}

