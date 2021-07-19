/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import com.zhiyun.cama.publish.PublishFragment$f;

public class hg$c
implements View.OnClickListener {
    private PublishFragment$f a;

    public hg$c b(PublishFragment$f object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.d(view);
    }
}

