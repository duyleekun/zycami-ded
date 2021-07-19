/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2.p0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.me.edit.EditProfileFragment;
import d.v.j.e.h.k;

public final class a
implements Observer {
    public final /* synthetic */ EditProfileFragment a;

    public /* synthetic */ a(EditProfileFragment editProfileFragment) {
        this.a = editProfileFragment;
    }

    public final void onChanged(Object object) {
        EditProfileFragment editProfileFragment = this.a;
        object = (k)object;
        editProfileFragment.v((k)object);
    }
}

