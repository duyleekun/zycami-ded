/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.widget;

import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.cama.widget.ThumbnailView$c;
import d.v.c.b2.u$b;

public class ThumbnailView$a
implements u$b {
    public final /* synthetic */ ThumbnailView a;

    public ThumbnailView$a(ThumbnailView thumbnailView) {
        this.a = thumbnailView;
    }

    public void a() {
        ThumbnailView$c thumbnailView$c = ThumbnailView.H(this.a);
        if (thumbnailView$c != null) {
            thumbnailView$c = ThumbnailView.H(this.a);
            thumbnailView$c.a();
        }
    }

    public void c() {
        ThumbnailView$c thumbnailView$c = ThumbnailView.H(this.a);
        if (thumbnailView$c != null) {
            thumbnailView$c = ThumbnailView.H(this.a);
            thumbnailView$c.c();
        }
    }

    public void d() {
    }

    public void e(RecyclerView recyclerView, int n10, int n11) {
        Object object = ThumbnailView.H(this.a);
        if (object != null) {
            object = this.a;
            long l10 = ThumbnailView.I((ThumbnailView)object);
            ThumbnailView thumbnailView = this.a;
            double d10 = ThumbnailView.K(thumbnailView);
            double d11 = n10;
            long l11 = (long)(d10 *= d11);
            ThumbnailView.J((ThumbnailView)object, l10 += l11);
            ThumbnailView$c thumbnailView$c = ThumbnailView.H(this.a);
            object = this.a;
            l10 = ThumbnailView.I((ThumbnailView)object);
            thumbnailView$c.b(recyclerView, l10);
        }
    }
}

