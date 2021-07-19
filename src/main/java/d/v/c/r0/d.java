/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.r0;

import com.zhiyun.cama.widget.ThumbnailView;
import d.v.c.r0.d$a;
import d.v.c.r0.d$b;
import d.v.c.r0.d$c;
import d.v.c.r0.d$d;

public class d {
    public static void a(ThumbnailView thumbnailView, d$c d$c, d$d d$d, d$b d$b) {
        if (d$b == null && d$c == null && d$d == null) {
            return;
        }
        d$a d$a = new d$a(d$c, d$d, d$b);
        thumbnailView.setOnThumbnailScrollListener(d$a);
    }
}

