/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.google.gson.reflect.TypeToken;
import com.zhiyun.cama.data.api.entity.music.AlbumListBean;
import com.zhiyun.cama.data.api.entity.music.AlbumListBean$AlbumBean;
import com.zhiyun.cama.data.api.entity.music.MusicListBean;
import com.zhiyun.cama.data.api.entity.music.MusicListBean$MusicBean;
import com.zhiyun.cama.data.database.AppDatabaseComm;
import com.zhiyun.cama.data.database.DatabaseCommHelper;
import com.zhiyun.cama.data.database.dao.BaseDao;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao;
import com.zhiyun.cama.data.database.dao.music.AlbumDao;
import com.zhiyun.cama.data.database.dao.music.MusicBeatDao;
import com.zhiyun.cama.data.database.dao.music.MusicDao;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao;
import com.zhiyun.cama.data.database.model.music.AlbumData;
import com.zhiyun.cama.data.database.model.music.MusicBeatData;
import com.zhiyun.cama.data.database.model.music.MusicData;
import com.zhiyun.cama.data.database.model.music.MusicFile;
import com.zhiyun.cama.data.database.model.music.MusicInfoData;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.TemEditorConfig;
import d.v.c.m0;
import d.v.c.v0.v.c.a;
import d.v.c.v0.v.c.b;
import d.v.c.v0.v.c.c;
import d.v.c.v0.v.c.d;
import d.v.c.v0.v.c.e;
import d.v.c.v0.v.c.f;
import d.v.c.v0.v.c.g;
import d.v.c.v0.v.c.h;
import d.v.c.v0.v.c.i;
import d.v.c.v0.v.c.j;
import d.v.c.v0.v.c.k;
import d.v.c.v0.v.c.l;
import d.v.c.v0.v.c.m;
import d.v.c.v0.v.c.n;
import d.v.c.v0.v.c.o;
import d.v.c.v0.v.c.p;
import d.v.c.v0.v.c.q;
import d.v.c.v0.v.c.r;
import d.v.c.v0.v.c.s$a;
import d.v.c.v0.v.c.s$b;
import d.v.c.v0.v.c.s$c;
import d.v.c.v0.v.c.s$d;
import d.v.e.l.c1;
import d.v.e.l.s1;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class s {
    private final AppDatabaseComm a;
    private MusicInfoDataDao b;
    private final AlbumDao c;
    private final MusicDao d;
    private final MusicFileDao e;
    private final MusicBeatDao f;

    private s() {
        BaseDao baseDao;
        Object object = DatabaseCommHelper.getInstance().getDataBase();
        this.a = object;
        this.b = baseDao = ((AppDatabaseComm)object).musicInfoDataDao();
        baseDao = ((AppDatabaseComm)object).albumDao();
        this.c = baseDao;
        baseDao = ((AppDatabaseComm)object).musicDao();
        this.d = baseDao;
        baseDao = ((AppDatabaseComm)object).musicFileDao();
        this.e = baseDao;
        this.f = object = ((AppDatabaseComm)object).musicBeatDao();
    }

    public /* synthetic */ s(s$a a10) {
        this();
    }

    private /* synthetic */ void J(List list) {
        r r10 = r.a;
        list.forEach(r10);
        this.d.deleteDownloadMusic(list);
        this.e.deleteDownloadMusic(list);
        this.f.deleteMusicBeatList(list);
    }

    private /* synthetic */ void L(List list) {
        this.b.deleteMusicInfoDataByPath(list);
    }

    private /* synthetic */ void N(MediatorLiveData mediatorLiveData, LiveData object, LiveData object2, List list) {
        object = (List)((LiveData)object).getValue();
        object2 = (List)((LiveData)object2).getValue();
        this.l0(mediatorLiveData, (List)object, (List)object2);
    }

    private /* synthetic */ void P(MediatorLiveData mediatorLiveData, LiveData object, LiveData object2, List list) {
        object = (List)((LiveData)object).getValue();
        object2 = (List)((LiveData)object2).getValue();
        this.l0(mediatorLiveData, (List)object, (List)object2);
    }

    public static /* synthetic */ boolean R(long l10, MusicData object) {
        long l11 = (Long)(object = ((MusicData)object).getAlbumId());
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object2 = object2 == false ? (Object)1 : (Object)0;
        return (boolean)object2;
    }

    private /* synthetic */ void S() {
        this.b();
        this.z();
    }

    private /* synthetic */ void U(long l10) {
        this.c(l10);
        this.A(l10);
    }

    private /* synthetic */ void W(long l10) {
        this.d(l10);
        this.A(l10);
    }

    public static /* synthetic */ void Y(MusicData musicData) {
        Object object = EditConfig$ResourceType.MUSIC;
        String string2 = musicData.getPath();
        object = TemEditorConfig.c((d.v.e.j.a)object, string2);
        long l10 = d.v.v.q.h.C((String)object);
        musicData.setDuration(l10);
        long l11 = s1.x((String)object);
        musicData.setSize(l11);
    }

    public static /* synthetic */ boolean Z(MusicData musicData) {
        return d.v.j.b.b(musicData.getPath()) ^ true;
    }

    public static /* synthetic */ MusicInfoData a0(MusicData musicData) {
        MusicInfoData musicInfoData = new MusicInfoData();
        String string2 = musicData.showLabel();
        musicInfoData.setMusicName(string2);
        long l10 = musicData.getDuration();
        musicInfoData.setDuration(l10);
        string2 = musicData.getPath();
        musicInfoData.setMusicPath(string2);
        l10 = musicData.getSize();
        musicInfoData.setSize(l10);
        string2 = musicData.getThumb();
        musicInfoData.setMusicImage(string2);
        l10 = musicData.getFileDownloadTimestamp();
        musicInfoData.setImportTimestamp(l10);
        return musicInfoData;
    }

    private void b() {
        this.d.deleteAssetsMusic();
    }

    public static /* synthetic */ int b0(MusicInfoData musicInfoData, MusicInfoData musicInfoData2) {
        long l10 = musicInfoData2.getImportTimestamp();
        long l11 = musicInfoData.getImportTimestamp();
        return Long.compare(l10, l11);
    }

    private void c(long l10) {
        this.d.deleteAlbumMusic(l10);
    }

    /*
     * WARNING - void declaration
     */
    public static /* synthetic */ AlbumData c0(boolean bl2, AlbumListBean$AlbumBean albumListBean$AlbumBean) {
        void var1_2;
        int n10 = var1_2.getId();
        long l10 = n10;
        String string2 = var1_2.getName();
        String string3 = var1_2.getName_tw();
        String string4 = var1_2.getName_en();
        int n11 = var1_2.getSort();
        String string5 = var1_2.getCover_url();
        int n12 = var1_2.getMusicTotal();
        AlbumData albumData = new AlbumData(l10, string2, string3, string4, n11, string5, n12);
        if (bl2) {
            int n13 = var1_2.getId();
            long l11 = n13;
            albumData.setId(l11);
        }
        return albumData;
    }

    private void d(long l10) {
        this.d.deleteAlbumMusicNoHash(l10);
    }

    public static /* synthetic */ MusicFile d0(List object, int n10) {
        object = (MusicListBean$MusicBean)object.get(n10);
        String string2 = s1.J(((MusicListBean$MusicBean)object).getUrl());
        String string3 = String.valueOf(-1 - n10);
        String string4 = ((MusicListBean$MusicBean)object).getTitle_en();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("audio/");
        stringBuilder.append(string2);
        String string5 = stringBuilder.toString();
        String string6 = ((MusicListBean$MusicBean)object).getUrl();
        String string7 = ((MusicListBean$MusicBean)object).getUrl();
        MusicFile musicFile = new MusicFile(string3, string4, string5, 0, string6, string7, 0L);
        return musicFile;
    }

    public static /* synthetic */ MusicData e0(boolean bl2, MusicListBean$MusicBean musicListBean$MusicBean) {
        long l10 = musicListBean$MusicBean.getRes_id();
        long l11 = bl2 ? musicListBean$MusicBean.getLocal_id() : musicListBean$MusicBean.getAlbum_id();
        Long l12 = l11;
        String string2 = musicListBean$MusicBean.getTitle();
        String string3 = musicListBean$MusicBean.getTitle_tw();
        String string4 = musicListBean$MusicBean.getTitle_en();
        int n10 = musicListBean$MusicBean.getSort();
        String string5 = musicListBean$MusicBean.getHash();
        long l13 = (long)musicListBean$MusicBean.getDuration() * 1000000L;
        long l14 = musicListBean$MusicBean.getSize();
        String string6 = musicListBean$MusicBean.getUrl();
        String string7 = musicListBean$MusicBean.getThumb();
        int n11 = musicListBean$MusicBean.getRequiredPrime();
        MusicData musicData = new MusicData(l10, l12, string2, string3, string4, n10, string5, l13, l14, string6, string7, n11);
        return musicData;
    }

    public static /* synthetic */ MusicData f0(MusicListBean$MusicBean musicListBean$MusicBean) {
        long l10 = musicListBean$MusicBean.getRes_id();
        String string2 = musicListBean$MusicBean.getTitle();
        String string3 = musicListBean$MusicBean.getTitle_tw();
        String string4 = musicListBean$MusicBean.getTitle_en();
        int n10 = musicListBean$MusicBean.getSort();
        String string5 = musicListBean$MusicBean.getHash();
        long l11 = (long)musicListBean$MusicBean.getDuration() * 1000000L;
        long l12 = musicListBean$MusicBean.getSize();
        String string6 = musicListBean$MusicBean.getUrl();
        String string7 = musicListBean$MusicBean.getThumb();
        int n11 = musicListBean$MusicBean.getRequiredPrime();
        MusicData musicData = new MusicData(l10, string2, string3, string4, n10, string5, l11, l12, string6, string7, n11);
        return musicData;
    }

    private /* synthetic */ void g0(String string2, String string3, long l10) {
        this.d.updateMusicPath(string2, string3, l10);
    }

    private void l0(MediatorLiveData mediatorLiveData, List object, List collector) {
        boolean bl2;
        boolean bl3;
        ArrayList arrayList = new ArrayList();
        if (object != null && !(bl3 = object.isEmpty())) {
            arrayList.addAll(object);
        }
        if (collector != null && !(bl2 = collector.isEmpty())) {
            object = collector.stream();
            collector = i.a;
            object = object.filter(collector);
            collector = d.v.c.v0.v.c.a.a;
            object = object.map(collector);
            collector = Collectors.toSet();
            object = object.collect(collector);
            arrayList.addAll(object);
        }
        if (!(bl2 = arrayList.isEmpty())) {
            object = d.v.c.v0.v.c.b.a;
            Collections.sort(arrayList, object);
        }
        mediatorLiveData.setValue(arrayList);
    }

    private List n0(MusicListBean stream) {
        boolean bl2;
        Collector collector;
        if (stream != null && (collector = ((MusicListBean)((Object)stream)).getList()) != null && !(bl2 = (collector = ((MusicListBean)((Object)stream)).getList()).isEmpty())) {
            stream = ((MusicListBean)((Object)stream)).getList();
            int n10 = stream.size();
            collector = IntStream.range(0, n10);
            d d10 = new d((List)((Object)stream));
            stream = collector.mapToObj(d10);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return null;
    }

    public static s p() {
        return s$d.a();
    }

    private void v() {
        this.a();
        this.C();
    }

    private void x() {
        this.b();
        this.z();
    }

    public List A(long l10) {
        Stream stream = this.j0().stream();
        c c10 = new c(l10);
        Object object = stream.filter(c10);
        Collector collector = Collectors.toList();
        object = object.collect(collector);
        return this.B((List)object);
    }

    public List B(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            return this.d.insert(list);
        }
        return null;
    }

    public List C() {
        List list = this.i0();
        return this.y(list);
    }

    public void D() {
        AppDatabaseComm appDatabaseComm = this.a;
        f f10 = new f(this);
        appDatabaseComm.runOnTransition(f10);
    }

    public void E(long l10) {
        AppDatabaseComm appDatabaseComm = this.a;
        k k10 = new k(this, l10);
        appDatabaseComm.runOnTransition(k10);
    }

    public void F(long l10) {
        AppDatabaseComm appDatabaseComm = this.a;
        q q10 = new q(this, l10);
        appDatabaseComm.runOnTransition(q10);
    }

    public void G() {
        boolean bl2;
        Object object = m0.j();
        Object object2 = new s$a(this);
        object2 = ((TypeToken)object2).getType();
        object = (MusicListBean)d.v.e.l.q2.c.d((String)object, (Type)object2);
        if ((object = this.n0((MusicListBean)object)) != null && !(bl2 = object.isEmpty())) {
            object2 = this.e;
            object2.defaultInsertSingle((List)object, null);
        }
    }

    public void H(MusicBeatData musicBeatData) {
        this.f.insertMusicBeatData(musicBeatData);
    }

    public void I(List list, Consumer consumer) {
        this.b.defaultReplaceSingle(list, consumer);
    }

    public /* synthetic */ void K(List list) {
        this.J(list);
    }

    public /* synthetic */ void M(List list) {
        this.L(list);
    }

    public /* synthetic */ void O(MediatorLiveData mediatorLiveData, LiveData liveData, LiveData liveData2, List list) {
        this.N(mediatorLiveData, liveData, liveData2, list);
    }

    public /* synthetic */ void Q(MediatorLiveData mediatorLiveData, LiveData liveData, LiveData liveData2, List list) {
        this.P(mediatorLiveData, liveData, liveData2, list);
    }

    public /* synthetic */ void T() {
        this.S();
    }

    public /* synthetic */ void V(long l10) {
        this.U(l10);
    }

    public /* synthetic */ void X(long l10) {
        this.W(l10);
    }

    public void a() {
        this.c.deleteAssetsAlbum();
    }

    public void e() {
        this.e.deleteAllAssetsFile();
    }

    public void f() {
        this.c.deleteDownloadAlbum();
    }

    public void g(long l10) {
        this.d.deleteDownloadAlbumMusic(l10);
    }

    public void h(List list) {
        Executor executor = c1.b().d();
        p p10 = new p(this, list);
        executor.execute(p10);
    }

    public /* synthetic */ void h0(String string2, String string3, long l10) {
        this.g0(string2, string3, l10);
    }

    public void i(String object) {
        MusicBeatDao musicBeatDao = this.f;
        if ((object = musicBeatDao.getMusicBeatDataByPath((String)object)) != null) {
            musicBeatDao = this.f;
            musicBeatDao.delete((MusicBeatData)object);
        }
    }

    public List i0() {
        Object object = m0.a();
        Object object2 = new s$b(this);
        object2 = ((TypeToken)object2).getType();
        object = (AlbumListBean)d.v.e.l.q2.c.d((String)object, (Type)object2);
        boolean bl2 = true;
        if ((object = this.m0((AlbumListBean)object, bl2)) != null && !(bl2 = object.isEmpty())) {
            return object;
        }
        return Collections.emptyList();
    }

    public void j(List list) {
        Executor executor = c1.b().d();
        j j10 = new j(this, list);
        executor.execute(j10);
    }

    public List j0() {
        Object object = m0.j();
        Object object2 = new s$c(this);
        object2 = ((TypeToken)object2).getType();
        object = (MusicListBean)d.v.e.l.q2.c.d((String)object, (Type)object2);
        boolean bl2 = true;
        if ((object = this.o0(bl2, (MusicListBean)object)) != null && !(bl2 = object.isEmpty())) {
            object2 = h.a;
            object.forEach(object2);
            return object;
        }
        return Collections.emptyList();
    }

    public void k() {
        this.d.deleteMusicNoAlbumId();
    }

    public LiveData k0() {
        return this.e.getAllDistinctMusicFileListLiveData();
    }

    public LiveData l(long l10) {
        return this.d.getDistinctMusicDataByAlbumIdLiveData(l10);
    }

    public LiveData m() {
        return this.c.getDistinctAlbumDataLiveData();
    }

    public List m0(AlbumListBean stream, boolean bl2) {
        boolean bl3;
        Object object;
        if (stream != null && (object = ((AlbumListBean)((Object)stream)).getList()) != null && !(bl3 = (object = ((AlbumListBean)((Object)stream)).getList()).isEmpty())) {
            stream = ((AlbumListBean)((Object)stream)).getList().stream();
            object = new n(bl2);
            stream = stream.map(object);
            Collector collector = Collectors.toList();
            return stream.collect(collector);
        }
        return null;
    }

    public LiveData n() {
        return this.d.getDistinctMusicDataLiveData();
    }

    public LiveData o() {
        return this.d.getDistinctMusicDataNoAlbumIdLiveData();
    }

    public List o0(boolean bl2, MusicListBean collector) {
        boolean bl3;
        Object object;
        if (collector != null && (object = ((MusicListBean)((Object)collector)).getList()) != null && !(bl3 = (object = ((MusicListBean)((Object)collector)).getList()).isEmpty())) {
            collector = ((MusicListBean)((Object)collector)).getList().stream();
            object = new l(bl2);
            Stream stream = collector.map(object);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return null;
    }

    public List p0(MusicListBean stream) {
        boolean bl2;
        Collector collector;
        if (stream != null && (collector = ((MusicListBean)((Object)stream)).getList()) != null && !(bl2 = (collector = ((MusicListBean)((Object)stream)).getList()).isEmpty())) {
            stream = ((MusicListBean)((Object)stream)).getList().stream();
            collector = o.a;
            stream = stream.map(collector);
            collector = Collectors.toList();
            return stream.collect(collector);
        }
        return null;
    }

    public MusicBeatData q(String string2) {
        return this.f.getMusicBeatDataByPath(string2);
    }

    public void q0(String object, HashMap hashMap) {
        MusicBeatData musicBeatData = this.f.getMusicBeatDataByPath((String)object);
        if (musicBeatData != null) {
            musicBeatData.setBeatMaps(hashMap);
            object = this.f;
            object.update(musicBeatData);
        } else {
            musicBeatData = new MusicBeatData((String)object, hashMap);
            object = this.f;
            object.insertMusicBeatData(musicBeatData);
        }
    }

    public LiveData r() {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        LiveData liveData = this.b.getAllExistMusicInfoDataList();
        LiveData liveData2 = this.d.getDistinctMusicDataLiveData();
        Observer observer = new g(this, mediatorLiveData, liveData, liveData2);
        mediatorLiveData.addSource(liveData, observer);
        observer = new m(this, mediatorLiveData, liveData, liveData2);
        mediatorLiveData.addSource(liveData2, observer);
        return mediatorLiveData;
    }

    public void r0(String string2, String string3, long l10) {
        Executor executor = c1.b().d();
        e e10 = new e(this, string2, string3, l10);
        executor.execute(e10);
    }

    public LiveData s(int n10) {
        return this.b.getMusicInfoDataListByAlbumType(n10);
    }

    public List t(String string2) {
        return this.b.getMusicInfoDataListByMusicName(string2);
    }

    public LiveData u(String string2) {
        return this.b.getMusicInfoDataLiveDataByMusicName(string2);
    }

    public void w() {
        this.v();
        this.x();
    }

    public List y(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            return this.c.replace(list);
        }
        return null;
    }

    public List z() {
        List list = this.j0();
        return this.B(list);
    }
}

