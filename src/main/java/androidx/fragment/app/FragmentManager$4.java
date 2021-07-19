/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsControllerFactory;

public class FragmentManager$4
implements SpecialEffectsControllerFactory {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$4(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public SpecialEffectsController createController(ViewGroup viewGroup) {
        DefaultSpecialEffectsController defaultSpecialEffectsController = new DefaultSpecialEffectsController(viewGroup);
        return defaultSpecialEffectsController;
    }
}

