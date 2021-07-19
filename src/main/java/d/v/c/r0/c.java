/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.r0;

import com.zhiyun.cama.widget.MediaConstrainLayout;
import d.v.c.r0.c$a;
import d.v.c.r0.c$b;
import d.v.c.r0.c$c;

public class c {
    public static void a(MediaConstrainLayout mediaConstrainLayout, c$b c$b, c$c c$c) {
        if (c$b == null && c$c == null) {
            return;
        }
        c$a c$a = new c$a(c$b, c$c);
        mediaConstrainLayout.setOnTouchUpListener(c$a);
    }
}

