/*
 * Decompiled with CFR 0.151.
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager$OpGenerator;
import java.util.ArrayList;

public class FragmentManager$PopBackStackState
implements FragmentManager$OpGenerator {
    public final int mFlags;
    public final int mId;
    public final String mName;
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$PopBackStackState(FragmentManager fragmentManager, String string2, int n10, int n11) {
        this.this$0 = fragmentManager;
        this.mName = string2;
        this.mId = n10;
        this.mFlags = n11;
    }

    public boolean generateOps(ArrayList arrayList, ArrayList arrayList2) {
        boolean bl2;
        Object object;
        int n10;
        Object object2 = this.this$0.mPrimaryNav;
        if (object2 != null && (n10 = this.mId) < 0 && (object = this.mName) == null && (bl2 = ((FragmentManager)(object2 = ((Fragment)object2).getChildFragmentManager())).popBackStackImmediate())) {
            return false;
        }
        object2 = this.this$0;
        String string2 = this.mName;
        int n11 = this.mId;
        int n12 = this.mFlags;
        object = arrayList;
        return ((FragmentManager)object2).popBackStackState(arrayList, arrayList2, string2, n11, n12);
    }
}

