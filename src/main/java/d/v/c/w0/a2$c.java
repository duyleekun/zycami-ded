/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment$c;

public class a2$c
implements View.OnClickListener {
    private SetStabilizerFragment$c a;

    public a2$c b(SetStabilizerFragment$c object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.g(view);
    }
}

