/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 */
package com.zhiyun.cama.album;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.databinding.ObservableField;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.common.collect.Lists;
import com.zhiyun.cama.album.AlbumDetailFragment;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.cama.main.EditorMainActivity;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.c.o0.u0;
import d.v.c.x1.l;
import d.v.h.e.a;
import java.util.ArrayList;
import java.util.List;

public class AlbumDetailFragment$c {
    public final /* synthetic */ AlbumDetailFragment a;

    public AlbumDetailFragment$c(AlbumDetailFragment albumDetailFragment) {
        this.a = albumDetailFragment;
    }

    public void a() {
        AlbumDetailFragment.o(this.a);
    }

    public void b(View object) {
        object = AlbumDetailFragment.k(this.a);
        Object object2 = AlbumDetailFragment.j(this.a);
        int n10 = AlbumDetailFragment.p(this.a).getCurrentItem();
        object2 = ((BaseQuickAdapter)object2).getItem(n10);
        ((ObservableField)object).set(object2);
        object2 = (AlbumSection)AlbumDetailFragment.k(this.a).get();
        object = new AlbumSection[]{object2};
        object2 = new Bundle();
        object2.putParcelableArray("album_delete", (Parcelable[])object);
        l.e(this.a, 2131362006, (Bundle)object2);
    }

    public void c() {
        Object object = AlbumDetailFragment.j(this.a).getData();
        boolean bl2 = object.isEmpty();
        if (bl2) {
            return;
        }
        object = AlbumDetailFragment.j(this.a);
        int n10 = AlbumDetailFragment.p(this.a).getCurrentItem();
        object = (AlbumSection)((BaseQuickAdapter)object).getItem(n10);
        ArrayList<a> arrayList = new ArrayList<a>();
        a a10 = new a();
        long l10 = object.getAlbum().duration;
        Object object2 = a10.k(l10);
        String string2 = object.getAlbum().path;
        object2 = object2.l(string2);
        object = object.getAlbum().path;
        object = object2.p((String)object);
        object2 = MediaType.VIDEO;
        ((a)object).m((MediaType)((Object)object2));
        arrayList.add(a10);
        EditorMainActivity.T(this.a.requireActivity(), arrayList);
    }

    public void d(View object) {
        object = (AlbumSection)AlbumDetailFragment.k(this.a).get();
        Bundle bundle = new Bundle();
        bundle.putParcelable("album_info", (Parcelable)object);
        l.e(this.a, 2131362008, bundle);
    }

    public void e() {
        int n10 = AlbumDetailFragment.p(this.a).getCurrentItem();
        Object object = (AlbumSection)AlbumDetailFragment.j(this.a).getItem(n10);
        boolean bl2 = object.getAlbum().favorite.get();
        u0 u02 = AlbumDetailFragment.q(this.a);
        int n11 = 1;
        Object[] objectArray = new AlbumSection[n11];
        objectArray[0] = object;
        object = Lists.newArrayList(objectArray);
        u02.s((List)object, bl2 ^= n11);
    }
}

