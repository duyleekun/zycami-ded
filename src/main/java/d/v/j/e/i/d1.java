/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.j.e.i;

import android.text.TextUtils;
import androidx.core.util.Consumer;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.api.entity.template.Effect;
import com.zhiyun.editortemplate.data.api.entity.template.FileDataBaseBean;
import com.zhiyun.editortemplate.data.api.entity.template.Filter;
import com.zhiyun.editortemplate.data.api.entity.template.Global;
import com.zhiyun.editortemplate.data.api.entity.template.Music;
import com.zhiyun.editortemplate.data.api.entity.template.Music$MusicTransition;
import com.zhiyun.editortemplate.data.api.entity.template.Render;
import com.zhiyun.editortemplate.data.api.entity.template.Roi;
import com.zhiyun.editortemplate.data.api.entity.template.Roi$RoiInfo;
import com.zhiyun.editortemplate.data.api.entity.template.Rotate;
import com.zhiyun.editortemplate.data.api.entity.template.RotateFrame;
import com.zhiyun.editortemplate.data.api.entity.template.Slices;
import com.zhiyun.editortemplate.data.api.entity.template.Stickers;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import com.zhiyun.editortemplate.data.api.entity.template.Text;
import com.zhiyun.editortemplate.data.api.entity.template.Transition;
import com.zhiyun.editortemplate.data.database.AppDatabaseTemplate;
import com.zhiyun.editortemplate.data.database.DatabaseHelperTemplate;
import com.zhiyun.editortemplate.data.database.dao.BaseDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_SortResultDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateDataDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateFileRelationDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateGlobalDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateMusicDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateStickerDao;
import com.zhiyun.editortemplate.data.database.dao.template.G_TemplateVideoDao;
import com.zhiyun.editortemplate.data.database.model.FileDataItem;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;
import com.zhiyun.editortemplate.data.database.model.draft.Withdraw;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotateFrame;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.SortResult;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateDescription;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateFileRelation;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateRetention$TempType;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateRetention$TemplateProtocolType;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateRetention$TemplateUseType;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;
import d.v.j.b;
import d.v.j.e.i.m0;
import d.v.j.e.i.n0;
import d.v.j.e.i.o0;
import d.v.j.e.i.p0;
import d.v.j.e.i.q0;
import d.v.j.e.i.r0;
import d.v.j.g.c0;
import d.v.j.g.x;
import d.v.j.g.y;
import e.a.i0;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import m.a.a;

public class d1 {
    public final AppDatabaseTemplate a;
    public final G_TemplateDataDao b;
    private final G_SortResultDao c;
    private final G_TemplateGlobalDao d;
    private final G_TemplateStickerDao e;
    private final G_TemplateMusicDao f;
    private final G_TemplateVideoDao g;
    private final G_TemplateFileDao h;
    private final G_TemplateFileRelationDao i;

    public d1() {
        BaseDao baseDao;
        Object object = DatabaseHelperTemplate.getInstance().getDataBase();
        this.a = object;
        this.b = baseDao = ((AppDatabaseTemplate)object).templateDataDao();
        baseDao = ((AppDatabaseTemplate)object).templateDatResultDao();
        this.c = baseDao;
        baseDao = ((AppDatabaseTemplate)object).templateGlobalDao();
        this.d = baseDao;
        baseDao = ((AppDatabaseTemplate)object).templateStickerDao();
        this.e = baseDao;
        baseDao = ((AppDatabaseTemplate)object).templateMusicDao();
        this.f = baseDao;
        baseDao = ((AppDatabaseTemplate)object).templateVideoDao();
        this.g = baseDao;
        baseDao = ((AppDatabaseTemplate)object).templateFileDao();
        this.h = baseDao;
        this.i = object = ((AppDatabaseTemplate)object).templateFilRelationDao();
    }

    private TemplatePOJO G(TemplatePOJO templatePOJO, EditorProtocol object) {
        TemplateData templateData = templatePOJO.getTemplateData();
        List list = this.x0(templateData, (EditorProtocol)object);
        List list2 = this.w0(templateData, (EditorProtocol)object);
        List list3 = this.v0(templateData, (EditorProtocol)object);
        TemplateGlobal templateGlobal = this.z0(templateData, (EditorProtocol)object);
        Draft draft = templatePOJO.getDraft();
        Withdraw withdraw = templatePOJO.getWithdraw();
        Template template = templatePOJO.getTemplate();
        Script script = templatePOJO.getScript();
        List list4 = templatePOJO.getScriptTrackPOJOList();
        object = new TemplatePOJO(templateData, draft, withdraw, template, script, templateGlobal, list3, list, list2, list4);
        return object;
    }

    private void I(long l10, List object) {
        c0.d();
        object = Optional.ofNullable(object);
        n0 n02 = new n0(this, l10);
        ((Optional)object).ifPresent(n02);
    }

    private boolean L(FileDataBaseBean object, boolean bl2) {
        if (object != null) {
            boolean bl3;
            FileData fileData = ((FileDataBaseBean)object).getFile();
            if (bl2 && !(bl3 = ((FileDataBaseBean)object).isLocalSource()) && fileData != null && !(bl3 = TextUtils.isEmpty((CharSequence)(object = fileData.getUrl()))) && !(bl3 = TextUtils.isEmpty((CharSequence)(object = fileData.getHash())))) {
                return true;
            }
        }
        return false;
    }

    private boolean M(String string2) {
        G_TemplateFileDao g_TemplateFileDao;
        int n10;
        c0.d();
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 && (n10 = (g_TemplateFileDao = this.h).getFileDataCount(string2)) >= (n11 = 1)) {
            return n11;
        }
        return false;
    }

    private /* synthetic */ void N(List object, List list, List list2, FileDataItem fileDataItem) {
        FileDataBaseBean fileDataBaseBean = fileDataItem.entity;
        boolean bl2 = fileDataItem.enable;
        boolean bl3 = this.L(fileDataBaseBean, bl2);
        if (bl3) {
            fileDataBaseBean = fileDataItem.entity;
            object.add(fileDataBaseBean);
            object = fileDataItem.entity.getFile();
            list.add(object);
            object = fileDataItem.entity.getFile().getHash();
            boolean bl4 = this.M((String)object);
            if (!bl4) {
                object = fileDataItem.entity;
                list2.add(object);
            }
        }
    }

    private /* synthetic */ void P(long l10, List object) {
        object = object.stream();
        m0 m02 = new m0(l10);
        Object object2 = object.map(m02).distinct();
        Collector collector = Collectors.toList();
        object2 = object2.collect(collector);
        this.i.insert((List)object2);
    }

    private /* synthetic */ Pair R(TemplatePOJO object, long l10) {
        object = this.b.insertOrUpdateAll((TemplatePOJO)object, false, false);
        G_TemplateFileRelationDao g_TemplateFileRelationDao = this.i;
        long l11 = (Long)((Pair)object).first;
        g_TemplateFileRelationDao.copyAndInsertRelation(l10, l11);
        return object;
    }

    public static /* synthetic */ Integer T(TemplatePOJO templatePOJO) {
        return (int)templatePOJO.getTemplateData().getId();
    }

    public static /* synthetic */ TemplateFileRelation U(long l10, FileData object) {
        object = ((FileData)object).getHash();
        TemplateFileRelation templateFileRelation = new TemplateFileRelation(l10, (String)object);
        return templateFileRelation;
    }

    private /* synthetic */ Boolean V(TemplatePOJO object, EditorProtocol object2) {
        boolean bl2 = x.g((TemplatePOJO)(object = this.G((TemplatePOJO)object, (EditorProtocol)object2)));
        if (!bl2) {
            return Boolean.FALSE;
        }
        object2 = this.m((EditorProtocol)object2);
        this.h.insert((List)object2);
        object = (Long)this.m0((TemplatePOJO)object).first;
        G_TemplateDataDao g_TemplateDataDao = this.b;
        long l10 = (Long)object;
        bl2 = g_TemplateDataDao.checkInsertSuccessful(l10);
        if (bl2) {
            l10 = (Long)object;
            this.I(l10, (List)object2);
        }
        return bl2;
    }

    private List m(EditorProtocol editorProtocol) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        q0 q02 = new q0(this, arrayList2, arrayList3, arrayList);
        this.j(editorProtocol, q02);
        return arrayList3;
    }

    private TemplateAudioTransition o0(Music music, int n10) {
        int n11 = n10;
        TemplateAudioTransition templateAudioTransition = null;
        if (music == null) {
            return null;
        }
        int n12 = 1;
        Object object = n10 != 0 ? (n10 != n12 ? null : music.getFadeOut()) : music.getFadeIn();
        if (object == null) {
            return null;
        }
        if (n11 != 0) {
            if (n11 == n12) {
                long l10 = ((Music$MusicTransition)object).getStartTime();
                long l11 = music.getEndTime();
                float f10 = ((Music$MusicTransition)object).getStartVolume();
                float f11 = ((Music$MusicTransition)object).getEndVolume();
                templateAudioTransition = new TemplateAudioTransition(l10, l11, f10, f11);
            }
        } else {
            long l12 = 0L;
            long l13 = ((Music$MusicTransition)object).getEndTime();
            float f12 = ((Music$MusicTransition)object).getStartVolume();
            float f13 = ((Music$MusicTransition)object).getEndVolume();
            templateAudioTransition = new TemplateAudioTransition(l12, l13, f12, f13);
        }
        return templateAudioTransition;
    }

    private static int[] p(int[] nArray, int[] nArray2) {
        if (nArray == null) {
            nArray = nArray2;
        }
        return nArray;
    }

    private TemplateEffect p0(Effect effect) {
        if (effect != null) {
            boolean bl2 = effect.isEnable();
            float f10 = effect.getSaturation();
            float f11 = effect.getContrast();
            float f12 = effect.getTemperature();
            float f13 = effect.getHue();
            float f14 = effect.getExposure();
            float f15 = effect.getVignette();
            float f16 = effect.getSharpen();
            TemplateEffect templateEffect = new TemplateEffect(bl2, f10, f11, f12, f13, f14, f15, f16);
            return templateEffect;
        }
        return null;
    }

    private TemplateFilter q0(Filter filter, String string2) {
        if (filter != null) {
            boolean bl2 = filter.isEnable();
            String string3 = filter.getName();
            boolean bl3 = filter.isLocalSource();
            string2 = this.t(string2, string3, bl3);
            boolean bl4 = filter.isLocalSource();
            float f10 = filter.getStrength();
            TemplateFilter templateFilter = new TemplateFilter(bl2, string2, bl4, f10);
            return templateFilter;
        }
        return null;
    }

    private TemplateMusic r0(long l10, Music music, String string2) {
        TemplateMusic templateMusic = new TemplateMusic();
        templateMusic.setTempId(l10);
        l10 = music.getAttachTime();
        templateMusic.setAttachTime(l10);
        l10 = music.getStartTime();
        templateMusic.setStartTime(l10);
        l10 = music.getEndTime();
        templateMusic.setEndTime(l10);
        l10 = music.getTimebase();
        templateMusic.setTimebase(l10);
        float f10 = music.getVolume();
        templateMusic.setVolume(f10);
        boolean bl2 = music.isMute();
        templateMusic.setMute(bl2);
        Object object = music.getName();
        boolean bl3 = music.isLocalSource();
        object = this.t(string2, (String)object, bl3);
        templateMusic.setName((String)object);
        bl2 = music.isLocalSource();
        templateMusic.setLocalSource(bl2);
        object = this.o0(music, 0);
        templateMusic.setFadeIn((TemplateAudioTransition)object);
        object = this.o0(music, 1);
        templateMusic.setFadeout((TemplateAudioTransition)object);
        return templateMusic;
    }

    private TemplateRoi s0(Roi roi) {
        if (roi != null) {
            Roi$RoiInfo roi$RoiInfo = roi.getStart();
            Roi$RoiInfo roi$RoiInfo2 = roi.getEnd();
            boolean bl2 = roi.isEnable();
            String string2 = roi$RoiInfo.getCenter();
            float f10 = roi$RoiInfo.getWidth();
            float f11 = roi$RoiInfo.getHeight();
            String string3 = roi$RoiInfo2.getCenter();
            float f12 = roi$RoiInfo2.getWidth();
            float f13 = roi$RoiInfo2.getHeight();
            long l10 = roi.getDuration();
            TemplateRoi templateRoi = new TemplateRoi(bl2, string2, f10, f11, string3, f12, f13, l10);
            return templateRoi;
        }
        return null;
    }

    private String t(String string2, String string3, boolean bl2) {
        if (!bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
        }
        return string3;
    }

    private TemplateRotate t0(Rotate rotate) {
        if (rotate != null) {
            boolean bl2 = rotate.isEnable();
            int n10 = rotate.getRotate();
            TemplateRotate templateRotate = new TemplateRotate(bl2, n10);
            return templateRotate;
        }
        return null;
    }

    private TemplateRotateFrame u0(RotateFrame rotateFrame) {
        if (rotateFrame == null) {
            return null;
        }
        String string2 = rotateFrame.getCenter();
        String string3 = rotateFrame.getScale();
        int n10 = rotateFrame.getRotate();
        TemplateRotateFrame templateRotateFrame = new TemplateRotateFrame(string2, string3, n10);
        return templateRotateFrame;
    }

    private List v0(TemplateData templateData, EditorProtocol object) {
        ArrayList<TemplateVideo> arrayList = new ArrayList<TemplateVideo>();
        List list = ((EditorProtocol)object).getSlices();
        if (list != null) {
            boolean bl2;
            object = ((EditorProtocol)object).getResPath();
            for (boolean bl3 = false; bl3 < (bl2 = list.size()); bl3 += 1) {
                Object object2 = (Slices)list.get((int)(bl3 ? 1 : 0));
                TemplateVideo templateVideo = new TemplateVideo();
                long l10 = templateData.getId();
                templateVideo.setTempId(l10);
                l10 = ((Slices)object2).getTimebase();
                templateVideo.setTimebase(l10);
                l10 = ((Slices)object2).getStartTime();
                templateVideo.setStartTime(l10);
                l10 = ((Slices)object2).getEndTime();
                templateVideo.setEndTime(l10);
                l10 = ((Slices)object2).getDuration();
                templateVideo.setDuration(l10);
                int n10 = ((Slices)object2).isMute();
                templateVideo.setMute(n10 != 0);
                float f10 = ((Slices)object2).getVolume();
                templateVideo.setVolume(f10);
                f10 = ((Slices)object2).getRate();
                float f11 = f10 - 0.0f;
                n10 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
                if (n10 == 0) {
                    n10 = 1065353216;
                    f10 = 1.0f;
                } else {
                    f10 = ((Slices)object2).getRate();
                }
                templateVideo.setRate(f10);
                n10 = ((Slices)object2).getRateType();
                templateVideo.setRateType(n10);
                Object object3 = ((Slices)object2).getBezierRate();
                templateVideo.setBezierRate((String)object3);
                object3 = ((Slices)object2).getRotate();
                object3 = this.t0((Rotate)object3);
                templateVideo.setRotate((TemplateRotate)object3);
                object3 = ((Slices)object2).getFilter();
                object3 = this.q0((Filter)object3, (String)object);
                templateVideo.setFilter((TemplateFilter)object3);
                object3 = ((Slices)object2).getEffect();
                object3 = this.p0((Effect)object3);
                templateVideo.setEffect((TemplateEffect)object3);
                object3 = ((Slices)object2).getTransition();
                object3 = this.y0((Transition)object3, (String)object);
                templateVideo.setTransition((TemplateTransition)object3);
                object3 = ((Slices)object2).getRotateFrame();
                object3 = this.u0((RotateFrame)object3);
                templateVideo.setRotateFrame((TemplateRotateFrame)object3);
                object3 = ((Slices)object2).getRoi();
                object3 = this.s0((Roi)object3);
                templateVideo.setRoi((TemplateRoi)object3);
                object2 = ((Slices)object2).getSliceRes();
                if (object2 != null) {
                    object3 = ((FileDataBaseBean)object2).getName();
                    templateVideo.setVideoPath((String)object3);
                    bl2 = ((FileDataBaseBean)object2).isLocalSource();
                    templateVideo.setLocalSource(bl2);
                }
                arrayList.add(templateVideo);
            }
        }
        return arrayList;
    }

    private List w0(TemplateData object, EditorProtocol object2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ((EditorProtocol)object2).getGlobal().getMusic();
        Object object3 = ((EditorProtocol)object2).getGlobal().getMusics();
        object2 = ((EditorProtocol)object2).getResPath();
        long l10 = ((TemplateData)object).getId();
        if (object3 != null) {
            boolean bl2;
            object = object3.iterator();
            while (bl2 = object.hasNext()) {
                object3 = (Music)object.next();
                object3 = this.r0(l10, (Music)object3, (String)object2);
                arrayList.add(object3);
            }
        }
        return arrayList;
    }

    private List x0(TemplateData templateData, EditorProtocol object) {
        ArrayList<TemplateSticker> arrayList = new ArrayList<TemplateSticker>();
        List list = ((EditorProtocol)object).getGlobal().getStickers();
        if (list != null) {
            boolean bl2;
            object = ((EditorProtocol)object).getResPath();
            for (boolean bl3 = false; bl3 < (bl2 = list.size()); bl3 += 1) {
                Object object2 = (Stickers)list.get((int)(bl3 ? 1 : 0));
                TemplateSticker templateSticker = new TemplateSticker();
                long l10 = templateData.getId();
                templateSticker.setTempId(l10);
                l10 = ((Stickers)object2).getStartTime();
                templateSticker.setStartTime(l10);
                l10 = ((Stickers)object2).getEndTime();
                templateSticker.setEndTime(l10);
                float f10 = ((Stickers)object2).getAngle();
                templateSticker.setAngle(f10);
                String string2 = ((Stickers)object2).getCenter();
                templateSticker.setCenter(string2);
                string2 = ((Stickers)object2).getType();
                templateSticker.setType(string2);
                f10 = ((Stickers)object2).getScale();
                boolean bl4 = false;
                float f11 = f10 - 0.0f;
                float f12 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
                if (f12 == false) {
                    f12 = 1065353216;
                    f10 = 1.0f;
                } else {
                    f10 = ((Stickers)object2).getScale();
                }
                templateSticker.setScale(f10);
                string2 = templateSticker.getType();
                f12 = (float)TextUtils.isEmpty((CharSequence)string2);
                if (f12 == false) {
                    string2 = templateSticker.getType();
                    string2.hashCode();
                    bl4 = -1 != 0;
                    int n10 = string2.hashCode();
                    switch (n10) {
                        default: {
                            break;
                        }
                        case 100313435: {
                            String string3 = "image";
                            f12 = (float)string2.equals(string3);
                            if (f12 == false) break;
                            bl4 = 2 != 0;
                            break;
                        }
                        case 3556653: {
                            String string3 = "text";
                            f12 = (float)string2.equals(string3);
                            if (f12 == false) break;
                            bl4 = true;
                            break;
                        }
                        case 102340: {
                            String string3 = "gif";
                            f12 = (float)string2.equals(string3);
                            if (f12 == false) break;
                            bl4 = false;
                        }
                    }
                    switch (bl4) {
                        default: {
                            break;
                        }
                        case 2: {
                            object2 = ((Stickers)object2).getImage();
                            if (object2 == null) break;
                            string2 = ((FileDataBaseBean)object2).getName();
                            bl4 = ((FileDataBaseBean)object2).isLocalSource();
                            string2 = this.t((String)object, string2, bl4);
                            templateSticker.setImageName(string2);
                            bl2 = ((FileDataBaseBean)object2).isLocalSource();
                            templateSticker.setLocalSource(bl2);
                            break;
                        }
                        case 1: {
                            object2 = ((Stickers)object2).getText();
                            if (object2 == null) break;
                            f10 = ((Text)object2).getFontSize();
                            templateSticker.setTextFontSize(f10);
                            string2 = ((Text)object2).getName();
                            bl4 = ((FileDataBaseBean)object2).isLocalSource();
                            string2 = this.t((String)object, string2, bl4);
                            templateSticker.setTextFontName(string2);
                            f12 = (float)((FileDataBaseBean)object2).isLocalSource();
                            templateSticker.setLocalSource((boolean)f12);
                            string2 = ((Text)object2).getTextColor();
                            templateSticker.setTextColor(string2);
                            string2 = ((Text)object2).getText();
                            templateSticker.setTextContent(string2);
                            object2 = ((Text)object2).getCaption();
                            if (object2 == null) break;
                            string2 = ((FileDataBaseBean)object2).getName();
                            bl4 = ((FileDataBaseBean)object2).isLocalSource();
                            string2 = this.t((String)object, string2, bl4);
                            templateSticker.setTextCaptionName(string2);
                            bl2 = ((FileDataBaseBean)object2).isLocalSource();
                            templateSticker.setTextCaptionLocalSource(bl2);
                            break;
                        }
                        case 0: {
                            object2 = ((Stickers)object2).getGif();
                            if (object2 == null) break;
                            string2 = ((FileDataBaseBean)object2).getName();
                            bl4 = ((FileDataBaseBean)object2).isLocalSource();
                            string2 = this.t((String)object, string2, bl4);
                            templateSticker.setGifName(string2);
                            bl2 = ((FileDataBaseBean)object2).isLocalSource();
                            templateSticker.setLocalSource(bl2);
                        }
                    }
                }
                arrayList.add(templateSticker);
            }
        }
        return arrayList;
    }

    private TemplateTransition y0(Transition transition, String string2) {
        if (transition != null) {
            TemplateTransition templateTransition;
            Object object = transition.getName();
            boolean bl2 = transition.isLocalSource();
            String string3 = this.t(string2, (String)object, bl2);
            long l10 = transition.getDuration();
            long l11 = transition.getTimebase();
            boolean bl3 = transition.isLocalSource();
            object = templateTransition;
            templateTransition = new TemplateTransition(string3, l10, l11, bl3);
            return templateTransition;
        }
        return null;
    }

    private TemplateGlobal z0(TemplateData object, EditorProtocol object2) {
        Global global = ((EditorProtocol)object2).getGlobal();
        object2 = ((EditorProtocol)object2).getResPath();
        TemplateGlobal templateGlobal = new TemplateGlobal();
        long l10 = ((TemplateData)object).getId();
        templateGlobal.setTempId(l10);
        l10 = global.getDuration();
        templateGlobal.setDuration(l10);
        l10 = global.getTimebase();
        templateGlobal.setTimebase(l10);
        float f10 = global.getVolume();
        templateGlobal.setVolume(f10);
        int n10 = global.isMute();
        templateGlobal.setMute(n10 != 0);
        object = global.getRender();
        if (object != null) {
            String string2 = ((Render)object).getRenderSize();
            templateGlobal.setRender(string2);
            n10 = ((Render)object).getDisplayType();
            templateGlobal.setDisplayType(n10);
        }
        object = global.getFilter();
        object = this.q0((Filter)object, (String)object2);
        templateGlobal.setFilter((TemplateFilter)object);
        object = global.getRotate();
        object = this.t0((Rotate)object);
        templateGlobal.setRotate((TemplateRotate)object);
        object = global.getEffect();
        object = this.p0((Effect)object);
        templateGlobal.setEffect((TemplateEffect)object);
        object = global.getRoi();
        object = this.s0((Roi)object);
        templateGlobal.setRoi((TemplateRoi)object);
        return templateGlobal;
    }

    public List A(long l10) {
        c0.d();
        return this.f.getTemplateMusics(l10);
    }

    public void A0(long l10, boolean bl2) {
        c0.d();
        this.b.updateFirstLoaded(l10, bl2);
    }

    public TemplatePOJO B(long l10) {
        c0.d();
        return this.b.getTemplate(l10);
    }

    public void B0(TemplateData templateData) {
        c0.d();
        this.b.update(templateData);
    }

    public List C(long l10) {
        c0.d();
        return this.e.getTemplateStick(l10);
    }

    public LiveData D(long l10) {
        return this.g.getTemplateVideos_LiveData(l10);
    }

    public List E(long l10) {
        c0.d();
        return this.g.getTemplateVideos(l10);
    }

    public List F() {
        c0.d();
        return this.h.getUnuseFilePaths();
    }

    public TemplatePOJO H(TemplateInfoData templateInfoData, int n10, boolean bl2, int n11, int n12, ScriptDataExt scriptDataExt) {
        boolean bl3;
        Object object;
        String string2;
        Object object2 = templateInfoData.getDescription();
        Object object3 = null;
        if (object2 != null) {
            string2 = templateInfoData.getDescription().getZh();
            String string3 = templateInfoData.getDescription().getEn();
            String string4 = templateInfoData.getDescription().getZh_tw();
            object = object2 = new TemplateDescription(string2, string3, string4);
        } else {
            object = null;
        }
        String string5 = templateInfoData.getName();
        String string6 = templateInfoData.getName_zh_tw();
        String string7 = templateInfoData.getName_en();
        String string8 = templateInfoData.getCoverUrl();
        String string9 = templateInfoData.getVideoUrl();
        double d10 = templateInfoData.getVideoTime();
        int n13 = templateInfoData.getVideoCount();
        String string10 = templateInfoData.getVideoRatio();
        int n14 = templateInfoData.getResSize();
        boolean bl4 = templateInfoData.getRequiredPrime();
        boolean bl5 = true;
        if (bl4 == bl5) {
            bl3 = bl5;
        } else {
            boolean bl6 = false;
            string2 = null;
            bl3 = false;
        }
        if (bl2) {
            long l10 = System.currentTimeMillis();
            object3 = l10;
        }
        String string3 = templateInfoData.getEditorName();
        String string4 = templateInfoData.getTrackChainName();
        object2 = new TemplateData(string5, string6, string7, string8, string9, d10, n13, string10, n14, bl3, n10, bl2, (Long)object3, (TemplateDescription)object, string3, string4, n11, n12, scriptDataExt, false);
        object3 = new TemplatePOJO((TemplateData)object2);
        return object3;
    }

    public Pair J(long l10, TemplatePOJO templatePOJO) {
        c0.d();
        AppDatabaseTemplate appDatabaseTemplate = this.a;
        r0 r02 = new r0(this, templatePOJO, l10);
        return (Pair)appDatabaseTemplate.runInTransaction(r02);
    }

    public Pair K(TemplatePOJO templatePOJO, boolean bl2, boolean bl3) {
        c0.d();
        return this.b.insertOrUpdateAll(templatePOJO, bl2, bl3);
    }

    public /* synthetic */ void O(List list, List list2, List list3, FileDataItem fileDataItem) {
        this.N(list, list2, list3, fileDataItem);
    }

    public /* synthetic */ void Q(long l10, List list) {
        this.P(l10, list);
    }

    public /* synthetic */ Pair S(TemplatePOJO templatePOJO, long l10) {
        return this.R(templatePOJO, l10);
    }

    public /* synthetic */ Boolean W(TemplatePOJO templatePOJO, EditorProtocol editorProtocol) {
        return this.V(templatePOJO, editorProtocol);
    }

    public LiveData X(List list) {
        return this.h.getFilePathsFromTemplates_LiveData(list);
    }

    public LiveData Y(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2, boolean bl3, Integer n13) {
        return this.b.getSortTemplateData_LiveData(n10, n11, n12, bl2, string2, bl3, n13);
    }

    public LiveData Z(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        G_TemplateDataDao g_TemplateDataDao = this.b;
        int[] nArray4 = this.r(nArray);
        int[] nArray5 = this.s(nArray2);
        int[] nArray6 = this.q(nArray3);
        return g_TemplateDataDao.getSortTemplateDataFromNonNullParam_LiveData(nArray4, nArray5, nArray6, bl2, string2);
    }

    public int a(List list) {
        c0.d();
        return this.h.deleteFile(list);
    }

    public LiveData a0(List list) {
        LiveData liveData = this.b.getTemplatePOJO_LiveData(list);
        p0 p02 = p0.a;
        return y.l(list, liveData, p02);
    }

    public void b(List list) {
        c0.d();
        this.f.delete(list);
    }

    public LiveData b0(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2, boolean bl3, Integer n13) {
        return this.b.getSortTemplatePOJO_LiveData(n10, n11, n12, bl2, string2, bl3, n13);
    }

    public void c(long l10) {
        c0.d();
        this.i.deleteRelationFromTemplateData(l10);
    }

    public LiveData c0(int[] nArray, int[] nArray2, int[] nArray3, Boolean bl2, String string2) {
        G_TemplateDataDao g_TemplateDataDao = this.b;
        int[] nArray4 = this.r(nArray);
        int[] nArray5 = this.s(nArray2);
        int[] nArray6 = this.q(nArray3);
        return g_TemplateDataDao.getSortTemplatePOJOFromNonNullParam_LiveData(nArray4, nArray5, nArray6, bl2, string2);
    }

    public void d(List list) {
        c0.d();
        this.e.delete(list);
    }

    public LiveData d0(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2, Integer n13) {
        return this.b.getTemplateCount_LiveData(n10, n11, n12, bl2, string2, n13);
    }

    public void e(TemplateData templateData) {
        c0.d();
        this.b.delete(templateData);
    }

    public LiveData e0(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        return this.b.getTemplateDataIds_LiveData(n10, n11, n12, bl2, string2);
    }

    public void f(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        c0.d();
        this.b.deleteTemplateData(n10, n11, n12, bl2, string2);
    }

    public LiveData f0(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        return this.b.getTemplateData_LiveData(n10, n11, n12, bl2, string2);
    }

    public i0 g(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        return this.b.deleteTemplateData_Single(n10, n11, n12, bl2, string2);
    }

    public LiveData g0(long l10) {
        return Transformations.distinctUntilChanged(this.b.getTemplate_LiveData(l10));
    }

    public void h(TemplateGlobal templateGlobal) {
        c0.d();
        this.d.delete(templateGlobal);
    }

    public LiveData h0(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        return this.b.getTemplatePOJO_LiveData(n10, n11, n12, bl2, string2);
    }

    public void i(List list) {
        c0.d();
        this.g.delete(list);
    }

    public LiveData i0(String string2) {
        return this.c.getSortResult_LiveData(string2);
    }

    public void j(EditorProtocol iterator2, Consumer consumer) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        boolean bl3;
        Object object5;
        boolean bl4;
        Object object6;
        Object object7 = ((EditorProtocol)((Object)iterator2)).getGlobal().getFilter();
        if (object7 != null) {
            object6 = EditConfig$ResourceType.FILTER;
            bl4 = ((Filter)object7).isEnable();
            object5 = new FileDataItem((EditConfig$ResourceType)object6, (FileDataBaseBean)object7, bl4);
            object7 = ((FileDataItem)object5).setData();
            consumer.accept(object7);
        }
        object7 = ((EditorProtocol)((Object)iterator2)).getGlobal().getMusic();
        object6 = EditConfig$ResourceType.MUSIC;
        object5 = new FileDataItem((EditConfig$ResourceType)object6, (FileDataBaseBean)object7);
        object7 = ((FileDataItem)object5).setData();
        consumer.accept(object7);
        object7 = ((EditorProtocol)((Object)iterator2)).getGlobal().getMusics();
        if (object7 != null) {
            object7 = object7.iterator();
            while (bl3 = object7.hasNext()) {
                object5 = (Music)object7.next();
                object4 = EditConfig$ResourceType.MUSIC;
                object6 = new FileDataItem((EditConfig$ResourceType)object4, (FileDataBaseBean)object5);
                object5 = ((FileDataItem)object6).setData();
                consumer.accept(object5);
            }
        }
        object7 = ((EditorProtocol)((Object)iterator2)).getGlobal().getStickers();
        bl3 = true;
        object6 = null;
        if (object7 != null) {
            object7 = object7.iterator();
            block11: while (bl4 = object7.hasNext()) {
                object4 = (Stickers)object7.next();
                object3 = ((Stickers)object4).getType();
                ((String)object3).hashCode();
                int n10 = -1;
                int bl2 = ((String)object3).hashCode();
                switch (bl2) {
                    default: {
                        break;
                    }
                    case 100313435: {
                        object2 = "image";
                        boolean bl5 = ((String)object3).equals(object2);
                        if (!bl5) break;
                        n10 = 2;
                        break;
                    }
                    case 3556653: {
                        object2 = "text";
                        boolean bl5 = ((String)object3).equals(object2);
                        if (!bl5) break;
                        n10 = (int)(bl3 ? 1 : 0);
                        break;
                    }
                    case 102340: {
                        object2 = "gif";
                        boolean bl5 = ((String)object3).equals(object2);
                        if (!bl5) break;
                        n10 = 0;
                        object = null;
                    }
                }
                switch (n10) {
                    default: {
                        continue block11;
                    }
                    case 2: {
                        object4 = ((Stickers)object4).getImage();
                        object = EditConfig$ResourceType.STICKER;
                        object3 = new FileDataItem((EditConfig$ResourceType)object, (FileDataBaseBean)object4);
                        object4 = ((FileDataItem)object3).setData();
                        consumer.accept(object4);
                        continue block11;
                    }
                    case 1: {
                        object3 = ((Stickers)object4).getText();
                        object2 = EditConfig$ResourceType.FONT;
                        object = new FileDataItem((EditConfig$ResourceType)object2, (FileDataBaseBean)object3);
                        object = ((FileDataItem)object).setData();
                        consumer.accept(object);
                        if (object3 == null || (object4 = ((Stickers)object4).getText().getCaption()) == null) continue block11;
                        object = EditConfig$ResourceType.CAPTION;
                        object3 = new FileDataItem((EditConfig$ResourceType)object, (FileDataBaseBean)object4);
                        object4 = ((FileDataItem)object3).setData();
                        consumer.accept(object4);
                        continue block11;
                    }
                    case 0: 
                }
                object4 = ((Stickers)object4).getGif();
                object = EditConfig$ResourceType.STICKER;
                object3 = new FileDataItem((EditConfig$ResourceType)object, (FileDataBaseBean)object4);
                object4 = ((FileDataItem)object3).setData();
                consumer.accept(object4);
            }
        }
        if ((iterator2 = ((EditorProtocol)((Object)iterator2)).getSlices()) != null) {
            boolean bl6;
            iterator2 = iterator2.iterator();
            while (bl6 = iterator2.hasNext()) {
                boolean bl7;
                object7 = (Slices)iterator2.next();
                object4 = ((Slices)object7).getFilter();
                object = EditConfig$ResourceType.FILTER;
                if (object4 != null && (bl7 = ((Filter)object4).isEnable())) {
                    bl7 = bl3;
                } else {
                    bl7 = false;
                    object2 = null;
                }
                object3 = new FileDataItem((EditConfig$ResourceType)object, (FileDataBaseBean)object4, bl7);
                object4 = ((FileDataItem)object3).setData();
                consumer.accept(object4);
                object7 = ((Slices)object7).getTransition();
                object3 = EditConfig$ResourceType.TRANSITION;
                object4 = new FileDataItem((EditConfig$ResourceType)object3, (FileDataBaseBean)object7);
                object7 = ((FileDataItem)object4).setData();
                consumer.accept(object7);
            }
        }
    }

    public void j0(long l10, String string2, String string3, String string4) {
        c0.d();
        this.b.renameTemplate(l10, string2, string3, string4);
    }

    public List k() {
        c0.d();
        return this.b.queryAll();
    }

    public void k0(SortResult sortResult) {
        c0.d();
        this.c.replace(sortResult);
    }

    public FileData l(String string2) {
        c0.d();
        return this.h.getFileData(string2);
    }

    public boolean l0(TemplatePOJO templatePOJO, EditorProtocol editorProtocol) {
        c0.d();
        AppDatabaseTemplate appDatabaseTemplate = this.a;
        o0 o02 = new o0(this, templatePOJO, editorProtocol);
        return (Boolean)appDatabaseTemplate.runInTransaction(o02);
    }

    public Pair m0(TemplatePOJO templatePOJO) {
        c0.d();
        long l10 = templatePOJO.getTemplateData().getId();
        TemplateData templateData = this.x(l10);
        if (templateData != null) {
            templatePOJO.setTemplateData(templateData);
        }
        templateData = templatePOJO.getTemplateData();
        boolean bl2 = true;
        templateData.setDownloadFinished(bl2);
        Long l11 = System.currentTimeMillis();
        templateData.setDownloadTimestamp(l11);
        return this.K(templatePOJO, false, bl2);
    }

    public List n(long l10) {
        c0.d();
        return this.h.getFilePathsFromTemplateOnlyUse(l10);
    }

    public void n0(FileData fileData) {
        c0.d();
        this.h.insert(fileData);
    }

    public List o(List list) {
        c0.d();
        return this.h.getFilePathsFromTemplates(list);
    }

    public int[] q(int[] nArray) {
        int[] nArray2 = TemplateRetention$TemplateProtocolType.allArray;
        return d1.p(nArray, nArray2);
    }

    public int[] r(int[] nArray) {
        int[] nArray2 = TemplateRetention$TempType.allArray;
        return d1.p(nArray, nArray2);
    }

    public int[] s(int[] nArray) {
        int[] nArray2 = TemplateRetention$TemplateUseType.allArray;
        return d1.p(nArray, nArray2);
    }

    public SortResult u(String objectArray, List list, List list2, int n10, int n11, int n12) {
        int n13 = 6;
        Object object = new Object[n13];
        object[0] = objectArray;
        int n14 = 1;
        object[n14] = list;
        int n15 = 2;
        object[n15] = list2;
        List list3 = n10;
        int n16 = 3;
        object[n16] = list3;
        object[4] = list3 = Integer.valueOf(n11);
        list3 = n12;
        int n17 = 5;
        object[n17] = list3;
        list3 = "\u6392\u5e8f\u53c2\u6570, pageType:%s, prefixIds: %s, resultIds: %s, requestPage: %s, requestPageSize: %s, count: %s";
        m.a.a.b((String)((Object)list3), (Object[])object);
        object = this.c.getSortResult((String)objectArray);
        list3 = object != null && n10 != n14 ? ((SortResult)object).getIdList() : null;
        List[] listArray = new List[n16];
        listArray[0] = list;
        listArray[n14] = list3;
        listArray[n15] = list2;
        list = y.e(listArray);
        n15 = (int)(d.v.j.b.f(list2) ? 1 : 0);
        if (n15 == 0) {
            int n18 = list2.size();
            n18 = n18 < n11 ? -1 : n10 + 1;
            object = new SortResult((String)objectArray, n18, n12, list);
        } else if (object != null) {
            ((SortResult)object).setIdList(list);
        } else {
            object = new SortResult((String)objectArray, 0, 0, list);
        }
        objectArray = new Object[n14];
        objectArray[0] = object;
        m.a.a.b("\u6700\u7ec8\u7684\u6392\u5e8f\u6570\u636e, SortResult:%s", objectArray);
        return object;
    }

    public SortResult v(String objectArray, List list, List object, List list2) {
        boolean bl2;
        int n10 = 4;
        Object object2 = new Object[n10];
        object2[0] = objectArray;
        int n11 = 1;
        object2[n11] = list;
        int n12 = 2;
        object2[n12] = object;
        int n13 = 3;
        object2[n13] = list2;
        List[] listArray = "\u6392\u5e8f\u53c2\u6570, pageType:%s, prefixIds: %s, unorderedIds: %s, resultIds: %s";
        m.a.a.b((String)listArray, (Object[])object2);
        object2 = this.c.getSortResult((String)objectArray);
        if (object2 != null && (object2 = ((SortResult)object2).getIdList()) != null && object != null) {
            listArray = new List[n12];
            List[] listArray2 = new List[n12];
            listArray2[0] = object2;
            listArray2[n11] = object;
            listArray[0] = object2 = y.c(listArray2);
            listArray[n11] = object;
            object = y.e(listArray);
        } else {
            bl2 = false;
            object = null;
        }
        object2 = new List[n13];
        object2[0] = list;
        object2[n11] = list2;
        object2[n12] = object;
        list = y.e((List[])object2);
        bl2 = d.v.j.b.f(list2);
        if (!bl2) {
            int n14 = -1;
            object = new SortResult((String)objectArray, n14, 0, list);
        } else {
            object = new SortResult((String)objectArray, 0, 0, list);
        }
        objectArray = new Object[n11];
        objectArray[0] = object;
        m.a.a.b("\u6700\u7ec8\u7684\u6392\u5e8f\u6570\u636e, SortResult:%s", objectArray);
        return object;
    }

    public Long w(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        c0.d();
        return this.b.getTemplateCount(n10, n11, n12, bl2, string2, null);
    }

    public TemplateData x(long l10) {
        c0.d();
        return this.b.loadTemplate(l10);
    }

    public List y(Integer n10, Integer n11, Integer n12, Boolean bl2, String string2) {
        c0.d();
        return this.b.getTemplateDataIds(n10, n11, n12, bl2, string2);
    }

    public TemplateGlobal z(long l10) {
        c0.d();
        return this.d.getTemplateGlobal(l10);
    }
}

