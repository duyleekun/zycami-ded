/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment$9
extends ActivityResultLauncher {
    public final /* synthetic */ Fragment this$0;
    public final /* synthetic */ ActivityResultContract val$contract;
    public final /* synthetic */ AtomicReference val$ref;

    public Fragment$9(Fragment fragment, AtomicReference atomicReference, ActivityResultContract activityResultContract) {
        this.this$0 = fragment;
        this.val$ref = atomicReference;
        this.val$contract = activityResultContract;
    }

    public ActivityResultContract getContract() {
        return this.val$contract;
    }

    public void launch(Object object, ActivityOptionsCompat activityOptionsCompat) {
        ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher)this.val$ref.get();
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(object, activityOptionsCompat);
            return;
        }
        object = new IllegalStateException("Operation cannot be started before fragment is in created state");
        throw object;
    }

    public void unregister() {
        ActivityResultLauncher activityResultLauncher = this.val$ref.getAndSet(null);
        if (activityResultLauncher != null) {
            activityResultLauncher.unregister();
        }
    }
}

