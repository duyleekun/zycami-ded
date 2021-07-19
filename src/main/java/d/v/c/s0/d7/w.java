/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package d.v.c.s0.d7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.camera.CameraFragment$j;
import com.zhiyun.image.Images;
import com.zhiyun.live.data.LivePlatform;
import d.v.c.s0.d7.p;
import d.v.c.s0.d7.q;
import d.v.c.s0.d7.w$a;
import d.v.c.s0.d7.w$b;
import d.v.c.w0.gb;
import d.v.c.w0.ib;
import d.v.e.l.h2;
import d.v.f.i.g;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class w
extends RecyclerView$Adapter {
    private CameraFragment$j a;
    private final List b;

    public w(CameraFragment$j cameraFragment$j) {
        LivePlatform livePlatform = LivePlatform.HELPER;
        livePlatform = LivePlatform.KWAI;
        livePlatform = LivePlatform.RESTREAM;
        livePlatform = LivePlatform.RTMP;
        Object object = new LivePlatform[]{livePlatform, livePlatform, livePlatform, livePlatform};
        this.b = object = Arrays.asList(object);
        this.a = cameraFragment$j;
    }

    private /* synthetic */ void a(int n10, View object) {
        object = this.a;
        LivePlatform livePlatform = (LivePlatform)((Object)this.b.get(n10));
        ((CameraFragment$j)object).b(livePlatform);
    }

    private /* synthetic */ void c(int n10, View object) {
        object = this.a;
        LivePlatform livePlatform = (LivePlatform)((Object)this.b.get(n10));
        ((CameraFragment$j)object).b(livePlatform);
    }

    public /* synthetic */ void b(int n10, View view) {
        this.a(n10, view);
    }

    public /* synthetic */ void d(int n10, View view) {
        this.c(n10, view);
    }

    public int getItemCount() {
        return this.b.size();
    }

    public long getItemId(int n10) {
        return n10;
    }

    public int getItemViewType(int n10) {
        if (n10 == 0) {
            return 2131558634;
        }
        return 2131558635;
    }

    public void onBindViewHolder(RecyclerView$ViewHolder object, int n10) {
        boolean bl2 = object instanceof w$b;
        if (bl2) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = object;
            recyclerView$ViewHolder = (w$b)object;
            Object object2 = recyclerView$ViewHolder.a().a;
            int n11 = ((LivePlatform)((Object)this.b.get(n10))).getPlatformIconRound();
            object2.setImageResource(n11);
            object2 = recyclerView$ViewHolder.a().d;
            object = object.itemView;
            LivePlatform livePlatform = (LivePlatform)((Object)this.b.get(n10));
            n11 = livePlatform.getPlatformNameRes();
            object = g.q((View)object, n11);
            object2.setText((CharSequence)object);
            object = recyclerView$ViewHolder.a().c;
            object2 = new p(this, n10);
            object.setOnClickListener((View.OnClickListener)object2);
            int n12 = 2;
            if (n10 == n12) {
                object = recyclerView$ViewHolder.a().b;
                n10 = 0;
                object.setVisibility(0);
            }
        } else {
            bl2 = object instanceof w$a;
            if (bl2) {
                object = (w$a)object;
                Object object3 = w$a.a((w$a)object).a;
                int n13 = 2131231818;
                Integer n14 = n13;
                float f10 = 10.0f;
                int n15 = h2.b(f10);
                Images.G(object3, n14, n15);
                object = object.b().c;
                object3 = new q(this, n10);
                object.setOnClickListener((View.OnClickListener)object3);
            }
        }
    }

    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup object, int n10) {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)object.getContext());
        object = layoutInflater.inflate(n10, object, false);
        int n11 = 2131558634;
        if (n10 == n11) {
            object = DataBindingUtil.bind((View)object);
            Objects.requireNonNull(object);
            object = (gb)object;
            w$a w$a = new w$a((gb)object);
            return w$a;
        }
        object = DataBindingUtil.bind((View)object);
        Objects.requireNonNull(object);
        object = (ib)object;
        w$b w$b = new w$b((ib)object);
        return w$b;
    }
}

