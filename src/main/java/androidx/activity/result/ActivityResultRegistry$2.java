/*
 * Decompiled with CFR 0.151.
 */
package androidx.activity.result;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import java.util.ArrayList;

public class ActivityResultRegistry$2
extends ActivityResultLauncher {
    public final /* synthetic */ ActivityResultRegistry this$0;
    public final /* synthetic */ ActivityResultContract val$contract;
    public final /* synthetic */ String val$key;
    public final /* synthetic */ int val$requestCode;

    public ActivityResultRegistry$2(ActivityResultRegistry activityResultRegistry, String string2, int n10, ActivityResultContract activityResultContract) {
        this.this$0 = activityResultRegistry;
        this.val$key = string2;
        this.val$requestCode = n10;
        this.val$contract = activityResultContract;
    }

    public ActivityResultContract getContract() {
        return this.val$contract;
    }

    public void launch(Object object, ActivityOptionsCompat activityOptionsCompat) {
        Object object2 = this.this$0.mLaunchedKeys;
        String string2 = this.val$key;
        ((ArrayList)object2).add(string2);
        object2 = this.this$0;
        int n10 = this.val$requestCode;
        ActivityResultContract activityResultContract = this.val$contract;
        ((ActivityResultRegistry)object2).onLaunch(n10, activityResultContract, object, activityOptionsCompat);
    }

    public void unregister() {
        ActivityResultRegistry activityResultRegistry = this.this$0;
        String string2 = this.val$key;
        activityResultRegistry.unregister(string2);
    }
}

