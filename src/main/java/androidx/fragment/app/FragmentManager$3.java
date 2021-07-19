/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.fragment.app;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;

public class FragmentManager$3
extends FragmentFactory {
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$3(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    public Fragment instantiate(ClassLoader object, String string2) {
        object = this.this$0.getHost();
        Context context = this.this$0.getHost().getContext();
        return ((FragmentContainer)object).instantiate(context, string2, null);
    }
}

