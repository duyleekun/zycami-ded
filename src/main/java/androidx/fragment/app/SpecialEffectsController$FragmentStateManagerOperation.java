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
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController$Operation;
import androidx.fragment.app.SpecialEffectsController$Operation$LifecycleImpact;
import androidx.fragment.app.SpecialEffectsController$Operation$State;

public class SpecialEffectsController$FragmentStateManagerOperation
extends SpecialEffectsController$Operation {
    private final FragmentStateManager mFragmentStateManager;

    public SpecialEffectsController$FragmentStateManagerOperation(SpecialEffectsController$Operation$State specialEffectsController$Operation$State, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, FragmentStateManager fragmentStateManager, CancellationSignal cancellationSignal) {
        Fragment fragment = fragmentStateManager.getFragment();
        super(specialEffectsController$Operation$State, specialEffectsController$Operation$LifecycleImpact, fragment, cancellationSignal);
        this.mFragmentStateManager = fragmentStateManager;
    }

    public void complete() {
        super.complete();
        this.mFragmentStateManager.moveToExpectedState();
    }

    public void onStart() {
        Object object;
        Object object2 = this.getLifecycleImpact();
        if (object2 == (object = SpecialEffectsController$Operation$LifecycleImpact.ADDING)) {
            float f10;
            String string2;
            Object object3;
            int n10;
            float f11;
            object2 = this.mFragmentStateManager.getFragment();
            object = ((Fragment)object2).mView.findFocus();
            if (object != null) {
                ((Fragment)object2).setFocusedView((View)object);
                f11 = 2.8E-45f;
                n10 = FragmentManager.isLoggingEnabled(2);
                if (n10 != 0) {
                    object3 = new StringBuilder();
                    string2 = "requestFocus: Saved focused view ";
                    ((StringBuilder)object3).append(string2);
                    ((StringBuilder)object3).append(object);
                    ((StringBuilder)object3).append(" for Fragment ");
                    ((StringBuilder)object3).append(object2);
                    object = ((StringBuilder)object3).toString();
                    object3 = "FragmentManager";
                    Log.v((String)object3, (String)object);
                }
            }
            object = this.getFragment().requireView();
            object3 = object.getParent();
            string2 = null;
            if (object3 == null) {
                object3 = this.mFragmentStateManager;
                ((FragmentStateManager)object3).addViewToContainer();
                object.setAlpha(0.0f);
            }
            if ((n10 = (f10 = (f11 = object.getAlpha()) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) == 0 && (n10 = object.getVisibility()) == 0) {
                n10 = 4;
                f11 = 5.6E-45f;
                object.setVisibility(n10);
            }
            float f12 = ((Fragment)object2).getPostOnViewCreatedAlpha();
            object.setAlpha(f12);
        }
    }
}

