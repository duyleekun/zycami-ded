/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 */
package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

public class DialogFragment$4
implements Observer {
    public final /* synthetic */ DialogFragment this$0;

    public DialogFragment$4(DialogFragment dialogFragment) {
        this.this$0 = dialogFragment;
    }

    public void onChanged(LifecycleOwner object) {
        boolean bl2;
        if (object != null && (bl2 = DialogFragment.access$200((DialogFragment)(object = this.this$0)))) {
            object = this.this$0.requireView();
            Object object2 = object.getParent();
            if (object2 == null) {
                object2 = DialogFragment.access$000(this.this$0);
                if (object2 != null) {
                    boolean bl3 = FragmentManager.isLoggingEnabled(3);
                    if (bl3) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("DialogFragment ");
                        ((StringBuilder)object2).append(this);
                        ((StringBuilder)object2).append(" setting the content view on ");
                        Object object3 = DialogFragment.access$000(this.this$0);
                        ((StringBuilder)object2).append(object3);
                        object2 = ((StringBuilder)object2).toString();
                        object3 = "FragmentManager";
                        Log.d((String)object3, (String)object2);
                    }
                    object2 = DialogFragment.access$000(this.this$0);
                    object2.setContentView((View)object);
                }
            } else {
                object = new IllegalStateException("DialogFragment can not be attached to a container view");
                throw object;
            }
        }
    }
}

