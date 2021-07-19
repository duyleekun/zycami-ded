/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import com.zhiyun.cama.main.MainFragment$d;

public class he$b
implements View.OnClickListener {
    private MainFragment$d a;

    public he$b b(MainFragment$d object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.e(view);
    }
}

