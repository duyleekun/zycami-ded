/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import com.zhiyun.cama.main.me.edit.EditProfileFragment$e;

public class je$b
implements View.OnClickListener {
    private EditProfileFragment$e a;

    public je$b b(EditProfileFragment$e object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.d(view);
    }
}

