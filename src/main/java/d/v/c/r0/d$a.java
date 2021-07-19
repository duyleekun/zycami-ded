/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.r0;

import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.widget.ThumbnailView$c;
import d.v.c.r0.d$b;
import d.v.c.r0.d$c;
import d.v.c.r0.d$d;

public final class d$a
implements ThumbnailView$c {
    public final /* synthetic */ d$c a;
    public final /* synthetic */ d$d b;
    public final /* synthetic */ d$b c;

    public d$a(d$c d$c, d$d d$d, d$b d$b) {
        this.a = d$c;
        this.b = d$d;
        this.c = d$b;
    }

    public void a() {
        d$d d$d = this.b;
        if (d$d != null) {
            d$d.a();
        }
    }

    public void b(RecyclerView recyclerView, long l10) {
        d$b d$b = this.c;
        if (d$b != null) {
            d$b.b(recyclerView, l10);
        }
    }

    public void c() {
        d$c d$c = this.a;
        if (d$c != null) {
            d$c.a();
        }
    }
}

