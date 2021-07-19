/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;

public class Fragment$7
implements Function {
    public final /* synthetic */ Fragment this$0;
    public final /* synthetic */ ActivityResultRegistry val$registry;

    public Fragment$7(Fragment fragment, ActivityResultRegistry activityResultRegistry) {
        this.this$0 = fragment;
        this.val$registry = activityResultRegistry;
    }

    public ActivityResultRegistry apply(Void void_) {
        return this.val$registry;
    }
}

