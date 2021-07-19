/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;

public interface FirebaseInstallationsApi {
    public Task delete();

    public Task getId();

    public Task getToken(boolean var1);

    public FidListenerHandle registerFidListener(FidListener var1);
}

