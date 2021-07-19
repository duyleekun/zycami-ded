/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q.e;

import com.zhiyun.cama.data.api.entity.FileResourceUrlBean$DataBean;
import com.zhiyun.cama.data.database.AppDatabaseComm;
import com.zhiyun.cama.data.database.DatabaseCommHelper;
import com.zhiyun.cama.data.database.dao.BaseDao;
import com.zhiyun.cama.data.database.dao.MusicInfoDataDao;
import com.zhiyun.cama.data.database.dao.filter.FilterDataDao;
import com.zhiyun.cama.data.database.dao.filter.FilterFileDao;
import com.zhiyun.cama.data.database.dao.filter.FilterTypeDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleDao;
import com.zhiyun.cama.data.database.dao.font.CaptionStyleFileDao;
import com.zhiyun.cama.data.database.dao.font.FontDao;
import com.zhiyun.cama.data.database.dao.font.FontFileDao;
import com.zhiyun.cama.data.database.dao.music.AlbumDao;
import com.zhiyun.cama.data.database.dao.music.MusicDao;
import com.zhiyun.cama.data.database.dao.music.MusicFileDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerDataDao;
import com.zhiyun.cama.data.database.dao.sticker.StickerFileDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionDataDao;
import com.zhiyun.cama.data.database.dao.transition.TransitionFileDao;
import com.zhiyun.cama.data.database.model.filter.FilterFile;
import com.zhiyun.cama.data.database.model.font.CaptionStyleFile;
import com.zhiyun.cama.data.database.model.font.FontFile;
import com.zhiyun.cama.data.database.model.music.MusicFile;
import com.zhiyun.cama.data.database.model.sticker.StickerFile;
import com.zhiyun.cama.data.database.model.transition.TransitionFile;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import d.v.c.d0;
import d.v.c.v0.q.c;
import d.v.c.v0.q.e.a;
import d.v.c.v0.q.e.b;
import d.v.c.v0.q.e.d;
import d.v.c.v0.q.e.e$a;
import d.v.e.l.s1;
import java.util.Arrays;

public class e {
    private static volatile e q;
    private final AppDatabaseComm a;
    private final AlbumDao b;
    private final MusicFileDao c;
    private final MusicDao d;
    private final MusicInfoDataDao e;
    private final FontFileDao f;
    private final FontDao g;
    private final CaptionStyleFileDao h;
    private final CaptionStyleDao i;
    private final FilterTypeDao j;
    private final FilterDataDao k;
    private final FilterFileDao l;
    private final StickerFileDao m;
    private final StickerDataDao n;
    private final TransitionDataDao o;
    private final TransitionFileDao p;

    private e() {
        BaseDao baseDao;
        Object object = DatabaseCommHelper.getInstance().getDataBase();
        this.a = object;
        this.b = baseDao = ((AppDatabaseComm)object).albumDao();
        baseDao = ((AppDatabaseComm)object).musicFileDao();
        this.c = baseDao;
        baseDao = ((AppDatabaseComm)object).musicDao();
        this.d = baseDao;
        baseDao = ((AppDatabaseComm)object).musicInfoDataDao();
        this.e = baseDao;
        baseDao = ((AppDatabaseComm)object).fontFileDao();
        this.f = baseDao;
        baseDao = ((AppDatabaseComm)object).fontDao();
        this.g = baseDao;
        baseDao = ((AppDatabaseComm)object).captionStyleFileDao();
        this.h = baseDao;
        baseDao = ((AppDatabaseComm)object).captionStyleDao();
        this.i = baseDao;
        baseDao = ((AppDatabaseComm)object).filterTypeDao();
        this.j = baseDao;
        baseDao = ((AppDatabaseComm)object).filterDataDao();
        this.k = baseDao;
        baseDao = ((AppDatabaseComm)object).filterFileDao();
        this.l = baseDao;
        baseDao = ((AppDatabaseComm)object).stickerFileDao();
        this.m = baseDao;
        baseDao = ((AppDatabaseComm)object).stickerDataDao();
        this.n = baseDao;
        baseDao = ((AppDatabaseComm)object).transitionDataDao();
        this.o = baseDao;
        this.p = object = ((AppDatabaseComm)object).transitionFileDao();
    }

    private void c(EditConfig$ResourceType object) {
        s1.g(d0.b((EditConfig$ResourceType)object));
        int[] nArray = e$a.a;
        int n10 = ((Enum)object).ordinal();
        n10 = nArray[n10];
        int n11 = 1;
        if (n10 != n11) {
            n11 = 3;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 5;
                    if (n10 != n11) {
                        n11 = 6;
                        if (n10 != n11) {
                            n11 = 7;
                            if (n10 == n11) {
                                this.n.deleteDownloadSticker();
                                object = this.m;
                                object.deleteAll();
                            }
                        } else {
                            this.i.deleteDownloadCaptionStyle();
                            object = this.h;
                            object.deleteAll();
                        }
                    } else {
                        this.g.deleteDownloadFont();
                        object = this.f;
                        object.deleteAll();
                    }
                } else {
                    this.j.deleteDownloadFilterType();
                    this.k.deleteDownloadFilter();
                    object = this.l;
                    object.deleteAll();
                }
            } else {
                this.o.deleteDownloadTransition();
                object = this.p;
                object.deleteAll();
            }
        } else {
            this.b.deleteDownloadAlbum();
            this.c.deleteAll();
            this.d.deleteDownloadMusic();
            object = this.e;
            object.deleteAll();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e d() {
        Object object = q;
        if (object != null) return q;
        object = e.class;
        synchronized (object) {
            e e10 = q;
            if (e10 != null) return q;
            q = e10 = new e();
            return q;
        }
    }

    private void f(EditConfig$ResourceType editConfig$ResourceType, FileData fileData) {
        String string2 = fileData.getPath();
        String string3 = fileData.getHash();
        AppDatabaseComm appDatabaseComm = this.a;
        a a10 = new a(this, editConfig$ResourceType, fileData, string2, string3);
        appDatabaseComm.runOnTransition(a10);
    }

    public static /* synthetic */ void g(e e10, EditConfig$ResourceType editConfig$ResourceType) {
        e10.c(editConfig$ResourceType);
    }

    private /* synthetic */ void h(EditConfig$ResourceType editConfig$ResourceType) {
        this.c(editConfig$ResourceType);
    }

    private /* synthetic */ void j(EditConfig$ResourceType[] object) {
        object = Arrays.stream(object);
        b b10 = new b(this);
        object.forEach(b10);
    }

    private /* synthetic */ void l(EditConfig$ResourceType object, FileData object2, String string2, String string3) {
        int[] nArray = e$a.a;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 3;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 5;
                    if (n10 != n11) {
                        n11 = 6;
                        if (n10 != n11) {
                            n11 = 7;
                            if (n10 == n11) {
                                object = new StickerFile((FileData)object2);
                                object2 = this.m;
                                object2.replace(object);
                                object = this.n;
                                object.updateStickerPath(string2, string3);
                            }
                        } else {
                            object = new CaptionStyleFile((FileData)object2);
                            object2 = this.h;
                            object2.replace(object);
                            object = this.i;
                            object.updateCaptionPath(string2, string3);
                        }
                    } else {
                        object = new FontFile((FileData)object2);
                        object2 = this.f;
                        object2.replace(object);
                        object = this.g;
                        object.updateFontPath(string2, string3);
                    }
                } else {
                    object = new FilterFile((FileData)object2);
                    object2 = this.l;
                    object2.replace(object);
                    object = this.k;
                    object.updateFilterPath(string2, string3);
                }
            } else {
                object = new TransitionFile((FileData)object2);
                object2 = this.p;
                object2.replace(object);
                object = this.o;
                object.updateTransitionPath(string2, string3);
            }
        } else {
            object = new MusicFile((FileData)object2);
            object2 = this.c;
            object2.replace(object);
            object = this.d;
            long l10 = System.currentTimeMillis();
            object.updateMusicPath(string2, string3, l10);
        }
    }

    public void a(EditConfig$ResourceType editConfig$ResourceType) {
        AppDatabaseComm appDatabaseComm = this.a;
        d.v.c.v0.q.e.c c10 = new d.v.c.v0.q.e.c(this, editConfig$ResourceType);
        appDatabaseComm.runOnTransition(c10);
    }

    public void b(EditConfig$ResourceType[] editConfig$ResourceTypeArray) {
        int n10;
        if (editConfig$ResourceTypeArray != null && (n10 = editConfig$ResourceTypeArray.length) != 0) {
            AppDatabaseComm appDatabaseComm = this.a;
            d d10 = new d(this, editConfig$ResourceTypeArray);
            appDatabaseComm.runOnTransition(d10);
        }
    }

    public void e(c object) {
        FileResourceUrlBean$DataBean fileResourceUrlBean$DataBean = ((c)object).s();
        String string2 = fileResourceUrlBean$DataBean.getHash();
        String string3 = fileResourceUrlBean$DataBean.getName();
        EditConfig$ResourceType editConfig$ResourceType = ((c)object).F();
        String string4 = fileResourceUrlBean$DataBean.getType();
        int n10 = fileResourceUrlBean$DataBean.getSize();
        String string5 = fileResourceUrlBean$DataBean.getUrl();
        String string6 = ((c)object).u();
        long l10 = System.currentTimeMillis();
        FileData fileData = new FileData(string2, string3, editConfig$ResourceType, string4, n10, string5, string6, l10);
        object = ((c)object).y();
        this.f((EditConfig$ResourceType)object, fileData);
    }

    public /* synthetic */ void i(EditConfig$ResourceType editConfig$ResourceType) {
        this.h(editConfig$ResourceType);
    }

    public /* synthetic */ void k(EditConfig$ResourceType[] editConfig$ResourceTypeArray) {
        this.j(editConfig$ResourceTypeArray);
    }

    public /* synthetic */ void m(EditConfig$ResourceType editConfig$ResourceType, FileData fileData, String string2, String string3) {
        this.l(editConfig$ResourceType, fileData, string2, string3);
    }
}

