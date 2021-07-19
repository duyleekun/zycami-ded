/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.widget.ImageView
 */
package com.zhiyun.cama.album;

import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.image.Images;
import d.v.c.o0.i;
import d.v.c.o0.i0;
import d.v.c.o0.j;
import d.v.c.o0.j0;
import d.v.c.o0.k;
import d.v.c.o0.l;
import d.v.c.o0.m;
import d.v.c.o0.n;
import d.v.c.o0.o;
import d.v.c.o0.p;
import d.v.c.o0.q;
import d.v.c.o0.r;
import d.v.c.o0.s;
import d.v.c.w0.v9;
import d.v.c.w0.x9;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AlbumListAdapter
extends BaseSectionQuickAdapter {
    private final ObservableBoolean a;

    public AlbumListAdapter(List object) {
        super(2131558617, 2131558616, (List)object);
        this.a = object = new ObservableBoolean();
        object = new int[1];
        object[0] = 2131362556;
        this.addChildClickViewIds((int[])object);
    }

    public static /* synthetic */ boolean h(AlbumSection albumSection) {
        return albumSection.getAlbum().favorite.get();
    }

    public static /* synthetic */ void i(Album album) {
        album.isChecked.set(false);
    }

    public static /* synthetic */ boolean j(AlbumSection albumSection) {
        return albumSection.isHeader() ^ true;
    }

    public static /* synthetic */ boolean k(AlbumSection albumSection) {
        return albumSection.getAlbum().isChecked.get();
    }

    public static /* synthetic */ boolean l(AlbumSection albumSection) {
        return albumSection.isHeader() ^ true;
    }

    public static /* synthetic */ boolean m(AlbumSection object, AlbumSection object2) {
        object2 = (CharSequence)object2.getAlbum().addTimeDay.get();
        object = (CharSequence)object.getAlbum().addTimeDay.get();
        return TextUtils.equals((CharSequence)object2, (CharSequence)object);
    }

    public static /* synthetic */ boolean n(AlbumSection albumSection) {
        return albumSection.getAlbum().isChecked.get();
    }

    public static /* synthetic */ boolean o(AlbumSection object, AlbumSection object2) {
        object2 = (CharSequence)object2.getAlbum().addTimeDay.get();
        object = (CharSequence)object.getAlbum().addTimeDay.get();
        return TextUtils.equals((CharSequence)object2, (CharSequence)object);
    }

    public static /* synthetic */ void p(boolean bl2, AlbumSection albumSection) {
        albumSection.getAlbum().isChecked.set(bl2);
    }

    public static /* synthetic */ boolean q(AlbumSection object, AlbumSection object2) {
        object2 = (CharSequence)object2.getAlbum().addTimeDay.get();
        object = (CharSequence)object.getAlbum().addTimeDay.get();
        return TextUtils.equals((CharSequence)object2, (CharSequence)object);
    }

    public static /* synthetic */ void r(boolean bl2, AlbumSection albumSection) {
        albumSection.getAlbum().isChecked.set(bl2);
    }

    public boolean a() {
        j j10;
        boolean bl2;
        Object object = this.e();
        boolean bl3 = object.isEmpty();
        if (!bl3 && (bl2 = (object = object.stream()).allMatch(j10 = j.a))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void b() {
        Stream<Object> stream = this.getData().stream();
        Object object = j0.a;
        stream = stream.map(object);
        object = l.a;
        stream.forEach((Consumer<Object>)object);
    }

    public void c(BaseViewHolder object, AlbumSection object2) {
        object = (v9)DataBindingUtil.getBinding(((RecyclerView$ViewHolder)object).itemView);
        if (object != null) {
            ((v9)object).z((AlbumSection)object2);
            ((ViewDataBinding)object).executePendingBindings();
            object = ((v9)object).b;
            Uri uri = object2.getAlbum().uri;
            object2 = uri == null ? object2.getAlbum().path : object2.getAlbum().uri;
            Images.e((ImageView)object, object2);
        }
    }

    public void d(BaseViewHolder object, AlbumSection object2) {
        object = (x9)DataBindingUtil.getBinding(((RecyclerView$ViewHolder)object).itemView);
        if (object != null) {
            ObservableBoolean observableBoolean = this.a;
            ((x9)object).C(observableBoolean);
            observableBoolean = object2.getAlbum().isChecked;
            ((x9)object).B(observableBoolean);
            object2 = object2.getAlbum().addTimeDay;
            ((x9)object).D((ObservableField)object2);
            ((ViewDataBinding)object).executePendingBindings();
        }
    }

    public List e() {
        Stream stream = this.getData().stream();
        Object object = s.a;
        stream = stream.filter(object);
        object = q.a;
        stream = stream.filter(object);
        object = Collectors.toList();
        return (List)stream.collect(object);
    }

    public boolean f(AlbumSection object) {
        Object object2 = this.getData().stream();
        Predicate predicate = p.a;
        object2 = object2.filter(predicate);
        predicate = new i((AlbumSection)object);
        object = object2.filter(predicate);
        object2 = r.a;
        return object.allMatch(object2);
    }

    public void g(AlbumSection object) {
        boolean bl2 = this.f((AlbumSection)object);
        Object object2 = this.getData().stream();
        Predicate predicate = i0.a;
        object2 = object2.filter(predicate);
        predicate = new m((AlbumSection)object);
        object = object2.filter(predicate).findFirst();
        object2 = new o(bl2);
        ((Optional)object).ifPresent(object2);
    }

    public void onItemViewHolderCreated(BaseViewHolder baseViewHolder, int n10) {
        super.onItemViewHolderCreated(baseViewHolder, n10);
        DataBindingUtil.bind(baseViewHolder.itemView);
    }

    public void s(AlbumSection object) {
        boolean bl2 = this.f((AlbumSection)object) ^ true;
        object.getAlbum().isChecked.set(bl2);
        Object object2 = this.getData().stream();
        k k10 = new k((AlbumSection)object);
        object = object2.filter(k10);
        object2 = new n(bl2);
        object.forEach(object2);
    }

    public void t(boolean bl2) {
        ObservableBoolean observableBoolean = this.a;
        observableBoolean.set(bl2);
        if (!bl2) {
            this.b();
        }
    }
}

