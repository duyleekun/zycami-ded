/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package d.v.c.s0.h7.o0;

import android.app.Application;
import android.content.Context;
import androidx.core.util.Pair;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.album.Album;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.editorsdk.fundation.UseCases;
import d.v.c.s0.h7.k0;
import d.v.c.s0.h7.o0.a;
import d.v.c.s0.h7.o0.a0;
import d.v.c.s0.h7.o0.b;
import d.v.c.s0.h7.o0.b0;
import d.v.c.s0.h7.o0.d;
import d.v.c.s0.h7.o0.d0;
import d.v.c.s0.h7.o0.e;
import d.v.c.s0.h7.o0.e0;
import d.v.c.s0.h7.o0.f;
import d.v.c.s0.h7.o0.f0;
import d.v.c.s0.h7.o0.g0;
import d.v.c.s0.h7.o0.h0;
import d.v.c.s0.h7.o0.i0;
import d.v.c.s0.h7.o0.j0;
import d.v.c.s0.h7.o0.l0;
import d.v.c.s0.h7.o0.m0;
import d.v.c.s0.h7.o0.n;
import d.v.c.s0.h7.o0.n0;
import d.v.c.s0.h7.o0.o;
import d.v.c.s0.h7.o0.p;
import d.v.c.s0.h7.o0.q;
import d.v.c.s0.h7.o0.q0;
import d.v.c.s0.h7.o0.r;
import d.v.c.s0.h7.o0.r0;
import d.v.c.s0.h7.o0.s;
import d.v.c.s0.h7.o0.s0;
import d.v.c.s0.h7.o0.t;
import d.v.c.s0.h7.o0.t0;
import d.v.c.s0.h7.o0.u;
import d.v.c.s0.h7.o0.u0;
import d.v.c.s0.h7.o0.v;
import d.v.c.s0.h7.o0.w;
import d.v.c.s0.h7.o0.x;
import d.v.c.s0.h7.o0.y;
import d.v.c.s0.h7.o0.z;
import d.v.e.l.c1;
import d.v.e.l.k2;
import d.v.e.l.m1;
import d.v.e.l.s1;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.io.FilesKt__UtilsKt;

public class w0
extends AndroidViewModel {
    public MutableLiveData a;
    public MutableLiveData b;

    public w0(Application object) {
        super((Application)object);
        super();
        this.a = object;
        Integer n10 = -1;
        super(n10);
        this.b = object;
    }

    public static /* synthetic */ boolean F(String string2) {
        return string2.matches("^-?\\d+$");
    }

    public static /* synthetic */ boolean G(AlbumSection albumSection) {
        return albumSection.isHeader() ^ true;
    }

    public static /* synthetic */ String H(AlbumSection albumSection, AlbumSection albumSection2) {
        return albumSection.getAlbum().path;
    }

    private /* synthetic */ Stream I(File file) {
        return Arrays.stream(k0.e0(this.f(file)));
    }

    public static /* synthetic */ int K(String string2) {
        return w0.g0(string2, null);
    }

    public static /* synthetic */ Throwable L() {
        Exception exception = new Exception("no tag");
        return exception;
    }

    public static /* synthetic */ Stream M(File file) {
        return Arrays.stream(file.listFiles());
    }

    public static /* synthetic */ boolean N(File fileArray) {
        boolean bl2 = (fileArray = fileArray.listFiles()).length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            fileArray = null;
        }
        return bl2;
    }

    public static /* synthetic */ int P(File file, File file2) {
        long l10 = Long.parseLong(file2.getName());
        long l11 = Long.parseLong(file.getName());
        return Long.compare(l10, l11);
    }

    public static /* synthetic */ boolean Q(File file) {
        return UseCases.a(file.getAbsolutePath()) ^ true;
    }

    public static /* synthetic */ File R(AlbumSection object) {
        object = object.getAlbum().path;
        File file = new File((String)object);
        return file;
    }

    public static /* synthetic */ Stream S(File file) {
        return Arrays.stream(file.listFiles());
    }

    private /* synthetic */ void T(File file) {
        k0.e((Context)this.getApplication(), file);
    }

    public static /* synthetic */ File V(AlbumSection object) {
        object = object.getAlbum().path;
        File file = new File((String)object);
        return file.getParentFile();
    }

    public static /* synthetic */ void W(File file) {
        FilesKt__UtilsKt.V(file);
    }

    private /* synthetic */ void X(List object) {
        object = object.stream();
        Object object2 = y.a;
        object = object.map(object2);
        object2 = d.v.c.s0.h7.o0.b.a;
        object = object.filter(object2);
        object2 = u0.a;
        object = object.map(object2);
        object2 = p.a;
        object = object.flatMap(object2);
        object2 = new t(this);
        object.forEach(object2);
        object = this.b;
        object2 = 0;
        ((MutableLiveData)object).postValue(object2);
    }

    private /* synthetic */ AlbumSection Z(File file) {
        String string2 = this.j0(file);
        file = file.listFiles()[0];
        return this.c(false, string2, file);
    }

    private boolean b(File stream) {
        stream = Stream.of(((File)((Object)stream)).listFiles());
        Object object = d.v.c.s0.h7.o0.a.a;
        stream = stream.map(object);
        object = q.a;
        return stream.allMatch(object);
    }

    public static /* synthetic */ String b0(AlbumSection albumSection) {
        return (String)albumSection.getAlbum().addTimeDay.get();
    }

    private AlbumSection c(boolean bl2, String string2, File file) {
        Album album = new Album();
        ObservableField observableField = album.addTimeDay;
        observableField.set(string2);
        if (bl2) {
            AlbumSection albumSection = new AlbumSection(true, album);
            return albumSection;
        }
        Object object = file.getAbsolutePath();
        album.path = object;
        object = this.j(file);
        album.storyName = object;
        object = new AlbumSection(false, album);
        return object;
    }

    public static /* synthetic */ int c0(Map.Entry entry, Map.Entry entry2) {
        long l10 = m1.i((String)entry2.getKey());
        long l11 = m1.i((String)entry.getKey());
        return Long.compare(l10, l11);
    }

    private /* synthetic */ void d0(List list, Map.Entry object) {
        object = (String)object.getKey();
        object = this.c(true, (String)object, null);
        list.add(object);
    }

    private String f(File file) {
        return s1.k(file.getName());
    }

    public static /* synthetic */ Stream f0(Map.Entry entry) {
        return ((List)entry.getValue()).stream();
    }

    private static Integer g0(String string2, Integer n10) {
        int n11;
        if (string2 == null) {
            n11 = n10;
        } else {
            n11 = Integer.parseInt(string2);
        }
        try {
            return n11;
        }
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
    }

    private List i0(List stream) {
        stream = stream.stream();
        ArrayList arrayList = new ArrayList(this);
        stream = stream.filter((Predicate<Object>)((Object)arrayList));
        arrayList = new ArrayList(this);
        stream = stream.map(arrayList);
        arrayList = Collectors.groupingBy(f0.a);
        stream = stream.collect(arrayList);
        arrayList = new ArrayList();
        stream = stream.entrySet().stream();
        Object object = q0.a;
        stream = stream.sorted((Comparator<Object>)object);
        object = new b0(this, arrayList);
        stream = stream.peek((Consumer<Object>)object);
        object = w.a;
        stream = stream.flatMap(object);
        object = new e(arrayList);
        stream.forEach((Consumer<Object>)object);
        return arrayList;
    }

    private String j(File stringArray) {
        stringArray = k0.e0(this.f((File)stringArray));
        int n10 = k0.m("SCRIPT_TITLE");
        return stringArray[n10];
    }

    private String j0(File file) {
        return m1.q(Long.parseLong(file.getName()));
    }

    private int l(File stringArray) {
        stringArray = k0.e0(this.f((File)stringArray));
        int n10 = k0.m("SCRIPT_PART_INDEX");
        return d.v.e.h.d.b(stringArray[n10], 0);
    }

    public static /* synthetic */ boolean m(w0 w02, File file) {
        return w02.b(file);
    }

    public static /* synthetic */ boolean n(String string2) {
        return k0.s(k0.e0(string2).length);
    }

    private /* synthetic */ void o(List stream) {
        stream = stream.stream();
        Object object = u.a;
        stream = stream.map(object);
        object = d.v.c.s0.h7.o0.b.a;
        stream = stream.filter(object);
        object = g0.a;
        stream.forEach(object);
        this.e();
    }

    private /* synthetic */ void r() {
        Object object = Stream.of(k2.O());
        Object object2 = d.v.c.s0.h7.o0.b.a;
        object = object.filter((Predicate<File>)object2);
        object2 = n.a;
        object = object.flatMap(object2);
        object2 = t0.a;
        object = object.filter((Predicate<File>)object2);
        object2 = m0.a;
        object = object.filter((Predicate<File>)object2);
        object2 = a0.a;
        object = object.sorted((Comparator<File>)object2);
        object2 = Collectors.toList();
        object = object.collect(object2);
        object2 = this.a;
        object = this.i0((List)object);
        ((MutableLiveData)object2).postValue(object);
    }

    public static /* synthetic */ String t(AlbumSection albumSection, AlbumSection albumSection2) {
        return albumSection.getAlbum().path;
    }

    public static /* synthetic */ Stream u(File object) {
        object = Arrays.stream(((File)object).listFiles());
        z z10 = z.a;
        return object.filter(z10);
    }

    private /* synthetic */ Pair v(File object) {
        Integer n10 = this.l((File)object);
        object = ((File)object).getAbsolutePath();
        return Pair.create(n10, object);
    }

    public static /* synthetic */ boolean x(AlbumSection albumSection) {
        return albumSection.isHeader() ^ true;
    }

    public static /* synthetic */ String y(AlbumSection albumSection, AlbumSection albumSection2) {
        return albumSection.getAlbum().path;
    }

    private /* synthetic */ Stream z(File file) {
        return Arrays.stream(k0.e0(this.f(file)));
    }

    public /* synthetic */ Stream A(File file) {
        return this.z(file);
    }

    public /* synthetic */ Stream J(File file) {
        return this.I(file);
    }

    public /* synthetic */ void U(File file) {
        this.T(file);
    }

    public /* synthetic */ void Y(List list) {
        this.X(list);
    }

    public /* synthetic */ AlbumSection a0(File file) {
        return this.Z(file);
    }

    public void d(List list) {
        Executor executor = c1.b().a();
        e0 e02 = new e0(this, list);
        executor.execute(e02);
    }

    public void e() {
        Executor executor = c1.b().a();
        d0 d02 = new d0(this);
        executor.execute(d02);
    }

    public /* synthetic */ void e0(List list, Map.Entry entry) {
        this.d0(list, entry);
    }

    public List g(AlbumSection stream) {
        Collector collector = Stream.of(stream);
        l0 l02 = new l0((AlbumSection)((Object)stream));
        stream = collector.map(l02);
        collector = d.a;
        stream = stream.map(collector);
        collector = d.v.c.s0.h7.o0.b.a;
        stream = stream.filter(collector);
        collector = u0.a;
        stream = stream.map(collector);
        collector = h0.a;
        stream = stream.flatMap(collector);
        collector = new Collector(this);
        stream = stream.map(collector);
        collector = Collectors.toList();
        return stream.collect(collector);
    }

    public void h0(List list) {
        Object object = this.b;
        Object object2 = 1;
        ((MutableLiveData)object).setValue(object2);
        object = c1.b().a();
        object2 = new d.v.c.s0.h7.o0.k0(this, list);
        object.execute((Runnable)object2);
    }

    public long i(AlbumSection stream) {
        Object object = Stream.of(stream);
        Object object2 = o.a;
        object = object.filter((Predicate<AlbumSection>)object2);
        object2 = new r((AlbumSection)((Object)stream));
        stream = object.map(object2);
        object = d.a;
        stream = stream.map(object);
        object = new j0(this);
        stream = stream.flatMap(object);
        long l10 = k0.m("SCRIPT_ID");
        stream = stream.skip(l10);
        object = i0.a;
        stream = stream.filter(object);
        object = f.a;
        return stream.mapToLong(object).findFirst().orElse(-1);
    }

    public int k(AlbumSection object) {
        Object object2 = Stream.of(object);
        Object object3 = x.a;
        object2 = object2.filter((Predicate<AlbumSection>)object3);
        object3 = new n0((AlbumSection)object);
        object = object2.map(object3);
        object2 = d.a;
        object = object.map(object2);
        object2 = new r0(this);
        object = object.flatMap(object2);
        long l10 = k0.m("SCRIPT_TAG");
        object = object.skip(l10);
        object2 = s0.a;
        object = object.map(object2);
        object2 = s.a;
        object = object.mapToInt(object2).findFirst();
        object2 = v.a;
        return ((OptionalInt)object).orElseThrow(object2);
    }

    public /* synthetic */ void p(List list) {
        this.o(list);
    }

    public /* synthetic */ void s() {
        this.r();
    }

    public /* synthetic */ Pair w(File file) {
        return this.v(file);
    }
}

