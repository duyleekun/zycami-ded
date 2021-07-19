/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package androidx.activity.result;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistry$CallbackAndContract;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class ActivityResultRegistry$1
implements LifecycleEventObserver {
    public final /* synthetic */ ActivityResultRegistry this$0;
    public final /* synthetic */ ActivityResultCallback val$callback;
    public final /* synthetic */ ActivityResultContract val$contract;
    public final /* synthetic */ String val$key;

    public ActivityResultRegistry$1(ActivityResultRegistry activityResultRegistry, String string2, ActivityResultCallback activityResultCallback, ActivityResultContract activityResultContract) {
        this.this$0 = activityResultRegistry;
        this.val$key = string2;
        this.val$callback = activityResultCallback;
        this.val$contract = activityResultContract;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event object2) {
        object = Lifecycle$Event.ON_START;
        boolean bl2 = ((Enum)object).equals(object2);
        if (bl2) {
            object = this.this$0.mKeyToCallback;
            object2 = this.val$key;
            ActivityResultCallback activityResultCallback = this.val$callback;
            ActivityResultContract activityResultContract = this.val$contract;
            Object object3 = new ActivityResultRegistry$CallbackAndContract(activityResultCallback, activityResultContract);
            object.put(object2, object3);
            object = this.this$0.mParsedPendingResults;
            object2 = this.val$key;
            bl2 = object.containsKey(object2);
            if (bl2) {
                object = this.this$0.mParsedPendingResults;
                object2 = this.val$key;
                object = object.get(object2);
                object2 = this.this$0.mParsedPendingResults;
                object3 = this.val$key;
                object2.remove(object3);
                object2 = this.val$callback;
                object2.onActivityResult(object);
            }
            object = this.this$0.mPendingResults;
            object2 = this.val$key;
            if ((object = (ActivityResult)object.getParcelable((String)object2)) != null) {
                object2 = this.this$0.mPendingResults;
                object3 = this.val$key;
                object2.remove((String)object3);
                object2 = this.val$callback;
                object3 = this.val$contract;
                int n10 = ((ActivityResult)object).getResultCode();
                object = ((ActivityResult)object).getData();
                object = ((ActivityResultContract)object3).parseResult(n10, (Intent)object);
                object2.onActivityResult(object);
            }
        } else {
            object = Lifecycle$Event.ON_STOP;
            bl2 = ((Enum)object).equals(object2);
            if (bl2) {
                object = this.this$0.mKeyToCallback;
                object2 = this.val$key;
                object.remove(object2);
            } else {
                object = Lifecycle$Event.ON_DESTROY;
                bl2 = ((Enum)object).equals(object2);
                if (bl2) {
                    object = this.this$0;
                    object2 = this.val$key;
                    ((ActivityResultRegistry)object).unregister((String)object2);
                }
            }
        }
    }
}

