/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment$OnPreAttachedListener;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment$8
extends Fragment$OnPreAttachedListener {
    public final /* synthetic */ Fragment this$0;
    public final /* synthetic */ ActivityResultCallback val$callback;
    public final /* synthetic */ ActivityResultContract val$contract;
    public final /* synthetic */ AtomicReference val$ref;
    public final /* synthetic */ Function val$registryProvider;

    public Fragment$8(Fragment fragment, Function function, AtomicReference atomicReference, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        this.this$0 = fragment;
        this.val$registryProvider = function;
        this.val$ref = atomicReference;
        this.val$contract = activityResultContract;
        this.val$callback = activityResultCallback;
        super(null);
    }

    public void onPreAttached() {
        Object object = this.this$0.generateActivityResultKey();
        ActivityResultRegistry activityResultRegistry = (ActivityResultRegistry)this.val$registryProvider.apply(null);
        AtomicReference atomicReference = this.val$ref;
        Fragment fragment = this.this$0;
        ActivityResultContract activityResultContract = this.val$contract;
        ActivityResultCallback activityResultCallback = this.val$callback;
        object = activityResultRegistry.register((String)object, fragment, activityResultContract, activityResultCallback);
        atomicReference.set(object);
    }
}

