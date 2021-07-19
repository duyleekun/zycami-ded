/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2.p0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.me.edit.EditProfileFragment;

public final class g
implements Observer {
    public final /* synthetic */ EditProfileFragment a;

    public /* synthetic */ g(EditProfileFragment editProfileFragment) {
        this.a = editProfileFragment;
    }

    public final void onChanged(Object object) {
        EditProfileFragment editProfileFragment = this.a;
        object = (String)object;
        editProfileFragment.x((String)object);
    }
}

