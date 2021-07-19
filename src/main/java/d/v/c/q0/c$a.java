/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q0;

import androidx.activity.result.ActivityResultCaller;
import com.zhiyun.cama.main.EditorMainActivity;
import d.v.c.m1.b;
import d.v.c.m1.d.l$b;
import d.v.c.q0.c;

public class c$a
implements l$b {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void a() {
        b.e(this.a);
    }

    public void b() {
        ActivityResultCaller activityResultCaller = this.a;
        int n10 = ((c)activityResultCaller).b;
        int n11 = 2;
        if (n10 == n11) {
            ((c)activityResultCaller).k();
            activityResultCaller = this.a.requireActivity();
            boolean bl2 = activityResultCaller instanceof EditorMainActivity;
            if (bl2) {
                activityResultCaller = (EditorMainActivity)this.a.requireActivity();
                n10 = 1;
                ((EditorMainActivity)activityResultCaller).N(n10 != 0);
            }
        }
    }
}

