/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.DialogRedirect;

public final class zad
extends DialogRedirect {
    private final /* synthetic */ Fragment val$fragment;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zaoh;

    public zad(Intent intent, Fragment fragment, int n10) {
        this.zaoh = intent;
        this.val$fragment = fragment;
        this.val$requestCode = n10;
    }

    public final void redirect() {
        Intent intent = this.zaoh;
        if (intent != null) {
            Fragment fragment = this.val$fragment;
            int n10 = this.val$requestCode;
            fragment.startActivityForResult(intent, n10);
        }
    }
}

