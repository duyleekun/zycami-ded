/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

public class Fragment$4
extends FragmentContainer {
    public final /* synthetic */ Fragment this$0;

    public Fragment$4(Fragment fragment) {
        this.this$0 = fragment;
    }

    public View onFindViewById(int n10) {
        Object object = this.this$0.mView;
        if (object != null) {
            return object.findViewById(n10);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Fragment ");
        Fragment fragment = this.this$0;
        ((StringBuilder)object).append(fragment);
        ((StringBuilder)object).append(" does not have a view");
        object = ((StringBuilder)object).toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public boolean onHasView() {
        boolean bl2;
        View view = this.this$0.mView;
        if (view != null) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }
}

