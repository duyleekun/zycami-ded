/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.fragment.app;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class FragmentManager$6
implements LifecycleEventObserver {
    public final /* synthetic */ FragmentManager this$0;
    public final /* synthetic */ Lifecycle val$lifecycle;
    public final /* synthetic */ FragmentResultListener val$listener;
    public final /* synthetic */ String val$requestKey;

    public FragmentManager$6(FragmentManager fragmentManager, String string2, FragmentResultListener fragmentResultListener, Lifecycle lifecycle) {
        this.this$0 = fragmentManager;
        this.val$requestKey = string2;
        this.val$listener = fragmentResultListener;
        this.val$lifecycle = lifecycle;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event object2) {
        object = Lifecycle$Event.ON_START;
        if (object2 == object) {
            object = FragmentManager.access$000(this.this$0);
            Object object3 = this.val$requestKey;
            if ((object = (Bundle)object.get(object3)) != null) {
                object3 = this.val$listener;
                String string2 = this.val$requestKey;
                object3.onFragmentResult(string2, (Bundle)object);
                object = this.this$0;
                object3 = this.val$requestKey;
                ((FragmentManager)object).clearFragmentResult((String)object3);
            }
        }
        if (object2 == (object = Lifecycle$Event.ON_DESTROY)) {
            this.val$lifecycle.removeObserver(this);
            object = FragmentManager.access$100(this.this$0);
            object2 = this.val$requestKey;
            object.remove(object2);
        }
    }
}

