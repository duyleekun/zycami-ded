/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 */
package d.v.c.o0;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumSection;
import d.v.c.o0.c0;
import d.v.c.o0.d0;
import d.v.c.o0.e0;
import d.v.c.o0.f0;
import d.v.c.o0.g0;
import d.v.c.o0.h0;
import d.v.c.o0.u0$a;
import d.v.e.i.j;
import d.v.s.b.g$a;
import d.v.s.b.h;
import d.v.s.b.i;
import d.v.s.b.i$a;
import d.v.s.b.k;
import d.v.s.b.l;
import d.v.s.b.m;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class u0
extends AndroidViewModel {
    private static final String[] m = new String[]{"video/quicktime", "video/mp4", "video/MP4", "image/x-canon-cr2", "image/jpeg", "image/png", "image/JPEG", "image/PNG"};
    private ExecutorService a;
    private Handler b;
    public j c;
    public MutableLiveData d;
    public MutableLiveData e;
    public MutableLiveData f;
    private final i g;
    private final h h;
    private final d.v.s.b.j i;
    private List j;
    private boolean k;
    private final i$a l;

    public u0(Application object) {
        super((Application)object);
        Object object2 = new j();
        this.c = object2;
        super();
        this.d = object2;
        super();
        this.e = object2;
        super();
        this.f = object2;
        object2 = new ArrayList();
        this.j = object2;
        this.l = object2 = new u0$a(this);
        this.a = object2 = Executors.newSingleThreadExecutor();
        Looper looper = Looper.getMainLooper();
        object2 = new Handler(looper);
        this.b = object2;
        this.g = object2 = d.v.s.b.l.J((Context)object);
        this.h = object2 = d.v.s.b.k.E((Context)object);
        object = d.v.s.b.m.B((Context)object);
        this.i = object;
    }

    public static /* synthetic */ boolean b(u0 u02) {
        return u02.k;
    }

    public static /* synthetic */ List c(u0 u02) {
        return u02.j;
    }

    private AlbumSection e(String object) {
        Album album = new Album();
        album.addTimeDay.set(object);
        album.isChecked.set(false);
        object = new AlbumSection(true, album);
        return object;
    }

    private /* synthetic */ void j(List list, g$a object) {
        int n10 = list.size();
        Uri[] uriArray = new Uri[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            Uri uri;
            uriArray[i10] = uri = ((AlbumSection)list.get((int)i10)).getAlbum().uri;
        }
        this.h.q(uriArray, (g$a)object);
        object = (List)this.c.getValue();
        list = this.t((List)object, list);
        object = this.b;
        c0 c02 = new c0(this, list);
        object.post((Runnable)c02);
    }

    private /* synthetic */ void l(List object, boolean bl2) {
        int n10;
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            Object object2 = ((AlbumSection)object.get(i10)).getAlbum();
            ((Album)object2).favorite.set(bl2);
            d.v.s.b.j j10 = this.i;
            int n11 = ((Album)object2).id;
            object2 = ((Album)object2).path;
            j10.d(n11, (String)object2, bl2);
        }
        object = this.e;
        Boolean bl3 = Boolean.FALSE;
        ((MutableLiveData)object).postValue(bl3);
    }

    private /* synthetic */ void n(List list) {
        MutableLiveData mutableLiveData = this.d;
        Integer n10 = 0;
        mutableLiveData.setValue(n10);
        mutableLiveData = this.d;
        n10 = -1;
        mutableLiveData.setValue(n10);
        this.c.setValue(list);
        this.v();
    }

    public static /* synthetic */ boolean p(List list, AlbumSection albumSection) {
        return list.contains(albumSection) ^ true;
    }

    public static /* synthetic */ boolean r(List object, int n10) {
        boolean bl2;
        int n11 = object.size();
        int n12 = 1;
        if (n10 >= (n11 -= n12)) {
            return (((AlbumSection)object.get(n10)).isHeader() ^ n12) != 0;
        }
        AlbumSection albumSection = (AlbumSection)object.get(n10);
        n11 = (int)(albumSection.isHeader() ? 1 : 0);
        if (n11 != 0 && (bl2 = ((AlbumSection)(object = (AlbumSection)object.get(n10 += n12))).isHeader())) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private List t(List stream, List collector) {
        if (stream != null && collector != null) {
            stream = stream.stream();
            Object object = new d0((List)((Object)collector));
            stream = stream.filter(object);
            collector = Collectors.toList();
            stream = (List)stream.collect(collector);
            int n10 = stream.size();
            collector = IntStream.range(0, n10);
            object = new e0((List)((Object)stream));
            collector = collector.filter((IntPredicate)object);
            stream.getClass();
            object = new h0((List)((Object)stream));
            stream = collector.mapToObj(object);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        stream = new Stream();
        return stream;
    }

    public void d(List list, g$a g$a) {
        Object object = this.d;
        Object object2 = 1;
        ((MutableLiveData)object).setValue(object2);
        object = this.a;
        object2 = new g0(this, list, g$a);
        object.execute((Runnable)object2);
    }

    public void f(int n10) {
        int n11 = 6;
        int n12 = 2;
        int n13 = 1;
        if (n10 != 0) {
            if (n10 != n13) {
                if (n10 != n12) {
                    int n14 = 3;
                    if (n10 != n14) {
                        n11 = 0;
                    } else {
                        this.k = n13;
                    }
                } else {
                    n11 = 4;
                    this.k = false;
                }
            } else {
                this.k = false;
                n11 = n12;
            }
        } else {
            this.k = false;
        }
        String[] stringArray = new String[n12];
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Zhiyun");
        String string2 = File.separator;
        ((StringBuilder)charSequence).append(string2);
        String string3 = "ZY_Cami";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        String string4 = "Camera";
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        stringArray[0] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("DCIM");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        stringArray[n13] = charSequence;
        this.g(n11, stringArray, "album_like");
    }

    public void g(int n10, String[] object, String string2) {
        this.g.o((String[])object);
        object = this.g;
        Object object2 = m;
        object.f((String[])object2);
        object = this.g;
        object2 = this.l;
        object.x((i$a)object2);
        this.j.clear();
        this.g.i(n10, string2);
    }

    public void i() {
        i i10 = this.g;
        Object object = new String[2];
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Zhiyun");
        String string2 = File.separator;
        ((StringBuilder)charSequence).append(string2);
        String string3 = "ZY_Cami";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        String string4 = "Camera";
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        object[0] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("DCIM");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        int n10 = 1;
        object[n10] = charSequence;
        i10.o((String[])object);
        this.g.e(n10);
        i10 = this.g;
        object = m;
        i10.f((String[])object);
        i10 = this.g;
        object = this.l;
        i10.x((i$a)object);
        this.j.clear();
        this.g.w(4);
    }

    public /* synthetic */ void k(List list, g$a g$a) {
        this.j(list, g$a);
    }

    public /* synthetic */ void m(List list, boolean bl2) {
        this.l(list, bl2);
    }

    public /* synthetic */ void o(List list) {
        this.n(list);
    }

    public void onCleared() {
        super.onCleared();
        MutableLiveData mutableLiveData = this.d;
        Integer n10 = -1;
        mutableLiveData.setValue(n10);
        this.a.shutdown();
    }

    public void s(List list, boolean bl2) {
        Object object = this.e;
        Object object2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(object2);
        object = this.a;
        object2 = new f0(this, list, bl2);
        object.execute((Runnable)object2);
    }

    public void u(List list) {
        List list2 = (List)this.c.getValue();
        list = this.t(list2, list);
        this.c.setValue(list);
    }

    public void v() {
        boolean bl2;
        Object object = this.f.getValue();
        if (object != null && (bl2 = ((Boolean)(object = (Boolean)this.f.getValue())).booleanValue())) {
            object = this.f;
            Boolean bl3 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl3);
        }
    }

    public void w() {
        this.g.s();
    }
}

