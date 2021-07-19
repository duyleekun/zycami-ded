/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.arch.core.util.Function;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentHostCallback;

public class Fragment$6
implements Function {
    public final /* synthetic */ Fragment this$0;

    public Fragment$6(Fragment fragment) {
        this.this$0 = fragment;
    }

    public ActivityResultRegistry apply(Void object) {
        object = this.this$0;
        FragmentHostCallback fragmentHostCallback = ((Fragment)object).mHost;
        boolean bl2 = fragmentHostCallback instanceof ActivityResultRegistryOwner;
        if (bl2) {
            return ((ActivityResultRegistryOwner)((Object)fragmentHostCallback)).getActivityResultRegistry();
        }
        return ((Fragment)object).requireActivity().getActivityResultRegistry();
    }
}

