/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.q0;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.main.EditorMainActivity;
import d.v.c.b1.t.g;
import d.v.f.g.a;
import java.util.Objects;

public abstract class b
extends a {
    public g f;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Object object = this.requireActivity();
        boolean bl2 = object instanceof EditorMainActivity;
        if (bl2) {
            object = d.v.i0.b.c(this.requireActivity());
            Class<g> clazz = g.class;
            this.f = object = (g)((ViewModelProvider)object).get(clazz);
            Objects.requireNonNull(object);
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void u(NavDirections navDirections) {
        if (navDirections == null) {
            return;
        }
        NavHostFragment.findNavController(this).navigate(navDirections);
    }

    public void v() {
        NavHostFragment.findNavController(this).navigateUp();
    }
}

