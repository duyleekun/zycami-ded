/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import com.zhiyun.cama.me.help.FeedbackEditFragment$c;

public class ve$d
implements View.OnClickListener {
    private FeedbackEditFragment$c a;

    public ve$d b(FeedbackEditFragment$c object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.l(view);
    }
}

