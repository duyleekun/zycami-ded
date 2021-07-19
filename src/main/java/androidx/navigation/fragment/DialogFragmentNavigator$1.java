/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation.fragment;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavController;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.NavHostFragment;

public class DialogFragmentNavigator$1
implements LifecycleEventObserver {
    public final /* synthetic */ DialogFragmentNavigator this$0;

    public DialogFragmentNavigator$1(DialogFragmentNavigator dialogFragmentNavigator) {
        this.this$0 = dialogFragmentNavigator;
    }

    public void onStateChanged(LifecycleOwner object, Lifecycle$Event lifecycle$Event) {
        boolean bl2;
        Lifecycle$Event lifecycle$Event2 = Lifecycle$Event.ON_STOP;
        if (lifecycle$Event == lifecycle$Event2 && !(bl2 = (lifecycle$Event = ((DialogFragment)(object = (DialogFragment)object)).requireDialog()).isShowing())) {
            object = NavHostFragment.findNavController((Fragment)object);
            ((NavController)object).popBackStack();
        }
    }
}

