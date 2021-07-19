/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;

public class FirebaseInstallations$2
implements FidListenerHandle {
    public final /* synthetic */ FirebaseInstallations this$0;
    public final /* synthetic */ FidListener val$listener;

    public FirebaseInstallations$2(FirebaseInstallations firebaseInstallations, FidListener fidListener) {
        this.this$0 = firebaseInstallations;
        this.val$listener = fidListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unregister() {
        FirebaseInstallations firebaseInstallations = this.this$0;
        synchronized (firebaseInstallations) {
            Object object = this.this$0;
            object = FirebaseInstallations.access$000((FirebaseInstallations)object);
            FidListener fidListener = this.val$listener;
            object.remove(fidListener);
            return;
        }
    }
}

