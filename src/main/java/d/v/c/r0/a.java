/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.r0;

import com.zhiyun.cama.widget.AudioBarView;
import d.v.c.r0.a$a;
import d.v.c.r0.a$b;
import d.v.c.r0.a$c;
import d.v.c.r0.a$d;

public class a {
    public static void a(AudioBarView audioBarView, a$c a$c, a$d a$d, a$b a$b) {
        if (a$c == null && a$d == null && a$b == null) {
            return;
        }
        a$a a$a = new a$a(a$b, a$c, a$d);
        audioBarView.setOnScrollListener(a$a);
    }
}

