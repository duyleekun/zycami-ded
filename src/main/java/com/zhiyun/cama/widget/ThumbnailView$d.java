/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.view.LayoutInflater
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package com.zhiyun.cama.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.cama.widget.ThumbnailView;
import com.zhiyun.cama.widget.ThumbnailView$a;
import com.zhiyun.cama.widget.ThumbnailView$b;
import com.zhiyun.image.Images;
import d.v.c.m0;
import d.v.c.m0$a;
import d.v.c.w0.ad;
import d.v.c.w0.yc;
import d.v.c.x1.q.c;
import d.v.e.f;
import java.util.List;

public class ThumbnailView$d
extends RecyclerView$Adapter {
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    public final /* synthetic */ ThumbnailView a;

    private ThumbnailView$d(ThumbnailView thumbnailView) {
        this.a = thumbnailView;
    }

    public /* synthetic */ ThumbnailView$d(ThumbnailView thumbnailView, ThumbnailView$a thumbnailView$a) {
        this(thumbnailView);
    }

    private boolean a(String string2) {
        ContentResolver contentResolver = f.a().c().getContentResolver();
        string2 = Uri.parse((String)string2);
        if ((string2 = contentResolver.getType((Uri)string2)) == null) {
            return false;
        }
        return string2.toLowerCase().startsWith("image/");
    }

    public void b(ThumbnailView$b object, int n10) {
        int n11;
        int n12 = this.getItemViewType(n10);
        if (n12 == (n11 = 1)) {
            Object object2;
            int n13;
            object = (yc)((ThumbnailView$b)object).getBinding();
            RoundImageView roundImageView = ((yc)object).a;
            Object object3 = roundImageView.getLayoutParams();
            object3.height = n13 = m0.m;
            n13 = this.getItemCount() + -2;
            if (n10 == n13) {
                object2 = this.a;
                n13 = ThumbnailView.L((ThumbnailView)object2);
                if (n13 == 0) {
                    n13 = m0.l;
                } else {
                    object2 = this.a;
                    n13 = ThumbnailView.L((ThumbnailView)object2);
                }
            } else {
                n13 = m0.l;
            }
            object3.width = n13;
            roundImageView.setLayoutParams((ViewGroup.LayoutParams)object3);
            object3 = ThumbnailView.M(this.a);
            n11 = (int)(this.a((String)object3) ? 1 : 0);
            if (n11 != 0) {
                Context context = this.a.getContext();
                object3 = ThumbnailView.M(this.a);
                Images.s(context, object3, roundImageView);
            } else {
                object3 = ThumbnailView.M(this.a);
                object2 = ThumbnailView.N(this.a);
                long l10 = (Long)object2.get(n10);
                n10 = m0$a.b;
                c c10 = d.v.c.x1.q.c.b((String)object3, l10, n10);
                object3 = roundImageView.getContext();
                Images.s((Context)object3, c10, roundImageView);
            }
            ((ViewDataBinding)object).executePendingBindings();
        } else {
            object = ((ad)object.getBinding()).a;
            ViewGroup.LayoutParams layoutParams = object.getLayoutParams();
            layoutParams.height = n12 = m0.m;
            ThumbnailView thumbnailView = this.a;
            n12 = ThumbnailView.O(thumbnailView);
            if (n12 < 0) {
                thumbnailView = this.a;
                n12 = thumbnailView.getWidth() >> n11;
            } else {
                thumbnailView = this.a;
                n12 = ThumbnailView.O(thumbnailView);
            }
            layoutParams.width = n12;
            object.setLayoutParams(layoutParams);
        }
    }

    public ThumbnailView$b c(ViewGroup object, int n10) {
        Object object2;
        ThumbnailView thumbnailView = null;
        int n11 = 1;
        if (n10 != n11) {
            object2 = LayoutInflater.from((Context)object.getContext());
            n11 = 2131558659;
            object = DataBindingUtil.inflate(object2, n11, object, false);
        } else {
            object2 = LayoutInflater.from((Context)object.getContext());
            n11 = 2131558658;
            object = DataBindingUtil.inflate(object2, n11, object, false);
        }
        thumbnailView = this.a;
        object2 = new ThumbnailView$b(thumbnailView, (ViewDataBinding)object);
        return object2;
    }

    public int getItemCount() {
        return ThumbnailView.N(this.a).size();
    }

    public int getItemViewType(int n10) {
        long l10;
        List list = ThumbnailView.N(this.a);
        Long l11 = (Long)list.get(n10);
        long l12 = l11;
        long l13 = l12 - (l10 = (long)-1);
        n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        if (n10 == 0) {
            return 0;
        }
        l10 = -2;
        long l14 = l12 - l10;
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n10 == 0) {
            return 2;
        }
        return 1;
    }
}

