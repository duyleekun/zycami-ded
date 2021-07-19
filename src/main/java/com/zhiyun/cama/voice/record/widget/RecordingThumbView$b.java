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
package com.zhiyun.cama.voice.record.widget;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import com.zhiyun.cama.voice.record.widget.RecordingThumbView;
import com.zhiyun.cama.voice.record.widget.RecordingThumbView$a;
import com.zhiyun.cama.voice.record.widget.RecordingThumbView$c;
import com.zhiyun.cama.widget.RoundImageView;
import com.zhiyun.common.util.Windows;
import com.zhiyun.image.Images;
import d.v.c.m0;
import d.v.c.m0$a;
import d.v.c.w0.yc;
import d.v.c.x1.q.c;
import d.v.c.y1.g.m.a;
import d.v.e.f;
import d.v.e.l.h2;
import java.util.List;

public class RecordingThumbView$b
extends RecyclerView$Adapter {
    private static final int b = 0;
    private static final int c = 1;
    private static final int d = 2;
    public final /* synthetic */ RecordingThumbView a;

    private RecordingThumbView$b(RecordingThumbView recordingThumbView) {
        this.a = recordingThumbView;
    }

    public /* synthetic */ RecordingThumbView$b(RecordingThumbView recordingThumbView, RecordingThumbView$a recordingThumbView$a) {
        this(recordingThumbView);
    }

    private boolean a(String string2) {
        ContentResolver contentResolver = f.a().c().getContentResolver();
        string2 = Uri.parse((String)string2);
        if ((string2 = contentResolver.getType((Uri)string2)) == null) {
            return false;
        }
        return string2.toLowerCase().startsWith("image/");
    }

    public void b(RecordingThumbView$c object, int n10) {
        Object object2;
        int n11;
        a a10 = (a)RecordingThumbView.a(this.a).get(n10);
        object = (yc)((RecordingThumbView$c)object).getBinding();
        RoundImageView roundImageView = ((yc)object).a;
        boolean bl2 = false;
        roundImageView.setCornerTopLeftRadius(0);
        roundImageView.setCornerBottomLeftRadius(0);
        roundImageView.setCornerTopRightRadius(0);
        roundImageView.setCornerBottomRightRadius(0);
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)roundImageView.getLayoutParams();
        recyclerView$LayoutParams.height = n11 = m0.m;
        recyclerView$LayoutParams.width = n11 = a10.d();
        n11 = this.getItemViewType(n10);
        float f10 = 6.0f;
        int n12 = 10;
        int n13 = 1;
        if (n11 == 0) {
            if (n10 == 0) {
                object2 = Windows.l(((yc)object).a.getContext());
                n10 = object2.getWidth() >> n13;
                recyclerView$LayoutParams.setMarginStart(n10);
            } else {
                recyclerView$LayoutParams.width = n10 = a10.d() - n12;
                recyclerView$LayoutParams.setMarginStart(n12);
            }
            n10 = h2.d(f10);
            roundImageView.setCornerTopLeftRadius(n10);
            n10 = h2.d(f10);
            roundImageView.setCornerBottomLeftRadius(n10);
        } else if (n11 == n13) {
            List list = RecordingThumbView.a(this.a);
            n11 = list.size() - n13;
            if (n10 == n11) {
                object2 = Windows.l(((yc)object).a.getContext());
                n10 = object2.getWidth() >> n13;
                recyclerView$LayoutParams.setMarginEnd(n10);
            } else {
                n10 = a10.d();
                n11 = n10 + -10;
                int n14 = n11 < 0 ? n13 : n11;
                recyclerView$LayoutParams.width = n14;
                if (n11 < 0) {
                    n12 = n10 + -1;
                }
                recyclerView$LayoutParams.setMarginEnd(n12);
            }
            n10 = h2.d(f10);
            roundImageView.setCornerTopRightRadius(n10);
            n10 = h2.d(f10);
            roundImageView.setCornerBottomRightRadius(n10);
        }
        roundImageView.setLayoutParams((ViewGroup.LayoutParams)recyclerView$LayoutParams);
        object2 = a10.a();
        bl2 = this.a((String)object2);
        if (bl2) {
            a10 = this.a.getContext();
            Images.s((Context)a10, object2, roundImageView);
        } else {
            object2 = a10.a();
            long l10 = a10.b();
            int n15 = m0$a.b;
            object2 = d.v.c.x1.q.c.b((String)object2, l10, n15);
            a10 = roundImageView.getContext();
            Images.s((Context)a10, object2, roundImageView);
        }
        ((ViewDataBinding)object).executePendingBindings();
    }

    public RecordingThumbView$c c(ViewGroup object, int n10) {
        object = DataBindingUtil.inflate(LayoutInflater.from((Context)object.getContext()), 2131558658, object, false);
        RecordingThumbView$c recordingThumbView$c = new RecordingThumbView$c((ViewDataBinding)object);
        return recordingThumbView$c;
    }

    public int getItemCount() {
        return RecordingThumbView.a(this.a).size();
    }

    public int getItemViewType(int n10) {
        List list = RecordingThumbView.a(this.a);
        a a10 = (a)list.get(n10);
        boolean bl2 = a10.f();
        if (bl2) {
            return 0;
        }
        n10 = (int)(a10.e() ? 1 : 0);
        if (n10 != 0) {
            return 1;
        }
        return 2;
    }
}

