/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.j.g;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig$FilterType;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType;
import com.zhiyun.editortemplate.TemEditorConfig$TemplateType;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateEffect;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateFilter;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateGlobal;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateMusic;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRotate;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileExt;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackMetaData;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPOJO;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPoint;
import com.zhiyun.editortemplate.data.database.model.track.ScriptTrackPointItem;
import d.v.e.l.s1;
import d.v.j.c$a;
import d.v.j.g.a;
import d.v.j.g.b;
import d.v.j.g.b0;
import d.v.j.g.c;
import d.v.j.g.d;
import d.v.j.g.e;
import d.v.j.g.f;
import d.v.j.g.g;
import d.v.j.g.h;
import d.v.j.g.i;
import d.v.j.g.j;
import d.v.j.g.v;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

public class x {
    private static boolean A(TemplateSticker object) {
        boolean bl2;
        block3: {
            boolean bl3;
            block2: {
                boolean bl4;
                boolean bl5;
                int n10 = 2;
                Object[] objectArray = new d.v.e.j.a[n10];
                Object object2 = EditConfig$ResourceType.STICKER;
                bl2 = false;
                objectArray[0] = object2;
                object2 = TemEditorConfig$TemplateType.EOV;
                bl3 = true;
                objectArray[bl3] = object2;
                objectArray = x.I((d.v.e.j.a[])objectArray);
                Object[] objectArray2 = new d.v.e.j.a[n10];
                Object object3 = EditConfig$ResourceType.CAPTION;
                objectArray2[0] = object3;
                objectArray2[bl3] = object2;
                objectArray2 = x.I((d.v.e.j.a[])objectArray2);
                Object[] objectArray3 = new d.v.e.j.a[n10];
                object3 = EditConfig$ResourceType.FONT;
                objectArray3[0] = object3;
                objectArray3[bl3] = object2;
                objectArray3 = x.I((d.v.e.j.a[])objectArray3);
                if (object == null) break block2;
                boolean bl6 = ((TemplateSticker)object).isLocalSource();
                object3 = ((TemplateSticker)object).getGifName();
                if (!(bl6 = x.D(bl6, (String)object3, (String[])objectArray)) || !(bl5 = x.D(bl6 = ((TemplateSticker)object).isLocalSource(), (String)(object3 = ((TemplateSticker)object).getImageName()), (String[])objectArray))) break block3;
                bl5 = ((TemplateSticker)object).isTextCaptionLocalSource();
                object2 = ((TemplateSticker)object).getTextCaptionName();
                if (!(bl5 = x.D(bl5, (String)object2, (String[])objectArray2)) || !(bl4 = x.D(bl5 = ((TemplateSticker)object).isLocalSource(), (String)(object = ((TemplateSticker)object).getTextFontName()), (String[])objectArray3))) break block3;
            }
            bl2 = bl3;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static boolean B(TemplateVideo var0, TemplateData var1_1) {
        block5: {
            var2_2 = true;
            if (var0 == null || var1_1 == null) break block5;
            var3_3 = var0.getTransition();
            if (var3_3 == null) ** GOTO lbl-1000
            var4_4 = var3_3.isLocalSource();
            var3_3 = var3_3.getName();
            var5_5 = c$a.b;
            var6_6 = 2;
            var7_7 /* !! */  = new d.v.e.j.a[var6_6];
            var8_8 /* !! */  = EditConfig$ResourceType.TRANSITION;
            var7_7 /* !! */ [0] = var8_8 /* !! */ ;
            var8_8 /* !! */  = TemEditorConfig$TemplateType.EOV;
            var7_7 /* !! */ [var2_2] = var8_8 /* !! */ ;
            var9_9 = x.F(var2_2, var4_4, (String)var3_3, var5_5, (String[])(var7_7 /* !! */  = x.I(var7_7 /* !! */ )));
            if (!var9_9) {
                var9_9 = false;
                var3_3 = null;
            } else lbl-1000:
            // 2 sources

            {
                var9_9 = var2_2;
            }
            var10_10 = var0.getFilter();
            var4_4 = x.L(var10_10);
            var11_11 = x.M(var1_1);
            if (!var11_11) ** GOTO lbl-1000
            var11_11 = var0.isLocalSource();
            var0 = var0.getVideoPath();
            var5_5 = new String[var2_2];
            var5_5[0] = var7_7 /* !! */  = TemEditorConfig.b(TemEditorConfig$TemplateType.EOV);
            var12_12 = x.D(var11_11, (String)var0, var5_5);
            if (!var12_12) {
                var12_12 = false;
                var0 = null;
            } else lbl-1000:
            // 2 sources

            {
                var12_12 = var2_2;
            }
            if (!(var4_4 && var9_9 && var12_12)) {
                var2_2 = false;
            }
        }
        return var2_2;
    }

    public static boolean C(FileData stringArray) {
        Object[] objectArray = stringArray.getPath();
        Object object = stringArray.getExt();
        object = object != null ? ((FileExt)object).getLicensePath() : "";
        boolean bl2 = TextUtils.isEmpty((CharSequence)objectArray);
        boolean bl3 = true;
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            EditConfig$ResourceType editConfig$ResourceType = stringArray.getCategory();
            bl2 = x.K(editConfig$ResourceType, (String)objectArray, (String)object);
        } else {
            bl2 = bl3;
        }
        Object[] objectArray2 = new Object[]{};
        m.a.a.b("---------checkFileData---------", objectArray2);
        objectArray2 = new Object[bl3];
        objectArray2[0] = stringArray;
        String string2 = " fileData: %s";
        m.a.a.b(string2, objectArray2);
        x.J((FileData)stringArray);
        stringArray = new String[]{};
        boolean bl4 = x.D(false, (String)objectArray, stringArray);
        if (bl4 && (bl4 = x.D(false, (String)object, stringArray = new String[0])) && bl2) {
            bl4 = bl3;
        } else {
            bl4 = false;
            stringArray = null;
        }
        objectArray = new Object[bl3];
        object = new StringBuilder();
        ((StringBuilder)object).append("isInstallSuccessful:");
        ((StringBuilder)object).append(bl2);
        objectArray[0] = object = ((StringBuilder)object).toString();
        return x.H(bl3, bl4, objectArray);
    }

    private static boolean D(boolean bl2, String string2, String ... stringArray) {
        return x.E(true, bl2, string2, stringArray);
    }

    private static boolean E(boolean bl2, boolean n10, String string2, String ... stringArray) {
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = true;
        if (n11 != 0) {
            return bl3;
        }
        n11 = 2;
        int n12 = 3;
        if (n10) {
            if (stringArray != null) {
                n10 = stringArray.length;
                Object var8_8 = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    String string3 = stringArray[i10];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append(string2);
                    string3 = d.v.e.j.b.d(stringBuilder.toString());
                    boolean bl4 = s1.q(string3);
                    if (!bl4) continue;
                    return bl3;
                }
            }
            Object[] objectArray = new Object[n12];
            Boolean bl5 = Boolean.TRUE;
            objectArray[0] = bl5;
            objectArray[bl3] = string2;
            objectArray[n11] = stringArray;
            return x.H(bl2, false, objectArray);
        }
        File file = new File(string2);
        n10 = file.exists();
        Object[] objectArray = new Object[n12];
        Boolean bl6 = Boolean.FALSE;
        objectArray[0] = bl6;
        objectArray[bl3] = string2;
        objectArray[n11] = stringArray;
        return x.H(bl2, n10 != 0, objectArray);
    }

    private static boolean F(boolean bl2, boolean bl3, String string2, String[] stringArray, String ... stringArray2) {
        boolean bl4;
        boolean bl5 = true;
        bl4 = bl2 && !(bl4 = x.f(string2, stringArray)) && !(bl4 = x.E(false, bl3, string2, stringArray2)) ? false : bl5;
        Object[] objectArray = new Object[5];
        Boolean bl6 = bl2;
        objectArray[0] = bl6;
        bl6 = bl3;
        objectArray[bl5] = bl6;
        objectArray[2] = string2;
        objectArray[3] = stringArray;
        objectArray[4] = stringArray2;
        return x.H(bl5, bl4, objectArray);
    }

    private static boolean G(Float f10, float f11, float f12) {
        float f13;
        float f14;
        int n10;
        float f15;
        float f16;
        float f17;
        if (f10 != null && ((f17 = (f16 = (f15 = f10.floatValue()) - f11) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) < 0 || (n10 = (f14 = (f13 = f10.floatValue()) - f12) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1)) > 0)) {
            n10 = 0;
            f13 = 0.0f;
            f10 = null;
        } else {
            n10 = 1;
            f13 = Float.MIN_VALUE;
        }
        return n10 != 0;
    }

    private static boolean H(boolean bl2, boolean bl3, Object ... object) {
        if (!bl3 && bl2) {
            String string2 = Thread.currentThread().getStackTrace()[3].getMethodName();
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = string2;
            bl2 = true;
            objectArray[bl2] = object = Arrays.deepToString(object);
            string2 = "\u9a8c\u8bc1\u5931\u8d25, methodName: %s, params: %s";
            m.a.a.x(string2, objectArray);
        }
        return bl3;
    }

    private static String[] I(d.v.e.j.a[] object) {
        object = Arrays.stream(object);
        Object object2 = v.a;
        object = object.map(object2);
        object2 = a.a;
        return (String[])object.toArray((IntFunction<A[]>)object2);
    }

    private static void J(FileData object) {
        EditConfig$ResourceType editConfig$ResourceType;
        if (object == null || (editConfig$ResourceType = EditConfig$ResourceType.STICKER) != (object = ((FileData)object).getCategory())) {
            // empty if block
        }
    }

    private static boolean K(EditConfig$ResourceType editConfig$ResourceType, String string2, String string3) {
        return true;
    }

    private static boolean L(TemplateFilter object) {
        int n10;
        block3: {
            int n11;
            block2: {
                n10 = 0;
                n11 = 1;
                if (object == null) break block2;
                boolean bl2 = ((TemplateFilter)object).isEnable();
                boolean bl3 = ((TemplateFilter)object).isLocalSource();
                object = ((TemplateFilter)object).getName();
                String[] stringArray = c$a.a;
                int n12 = 3;
                Object[] objectArray = new d.v.e.j.a[n12];
                TemEditorConfig$FilterType temEditorConfig$FilterType = TemEditorConfig$FilterType.FILTER_LUT;
                objectArray[0] = temEditorConfig$FilterType;
                temEditorConfig$FilterType = TemEditorConfig$FilterType.FILTER_FX;
                objectArray[n11] = temEditorConfig$FilterType;
                int n13 = 2;
                TemEditorConfig$TemplateType temEditorConfig$TemplateType = TemEditorConfig$TemplateType.EOV;
                objectArray[n13] = temEditorConfig$TemplateType;
                boolean bl4 = x.F(bl2, bl3, (String)object, stringArray, (String[])(objectArray = x.I((d.v.e.j.a[])objectArray)));
                if (!bl4) break block3;
            }
            n10 = n11;
        }
        return n10 != 0;
    }

    private static boolean M(TemplateData templateData) {
        int n10;
        int n11 = 0;
        if (templateData == null) {
            return false;
        }
        int n12 = templateData.getTemplateProtocolType();
        if (n12 == (n10 = 1)) {
            n11 = n10;
        }
        return n11 != 0;
    }

    public static /* synthetic */ boolean N(TemplateMusic templateMusic) {
        return x.a(templateMusic);
    }

    public static /* synthetic */ boolean O(TemplateMusic templateMusic) {
        return x.z(templateMusic);
    }

    public static /* synthetic */ boolean P(TemplateSticker templateSticker) {
        return x.A(templateSticker);
    }

    public static /* synthetic */ Boolean Q(ScriptTrackMetaData scriptTrackMetaData) {
        return TextUtils.isEmpty((CharSequence)scriptTrackMetaData.getProduct()) ^ true;
    }

    public static /* synthetic */ Boolean R(TemplatePOJO object, TemplateVideo templateVideo) {
        object = ((TemplatePOJO)object).getTemplateData();
        return x.c(templateVideo, (TemplateData)object);
    }

    public static /* synthetic */ Boolean S(TemplateGlobal templateGlobal, TemplateSticker templateSticker) {
        return x.b(templateSticker, templateGlobal);
    }

    public static /* synthetic */ Boolean T(ScriptTrackPOJO scriptTrackPOJO) {
        return x.d(scriptTrackPOJO);
    }

    public static /* synthetic */ Boolean U(TemplateData templateData, TemplateVideo templateVideo) {
        return x.c(templateVideo, templateData);
    }

    public static /* synthetic */ String[] V(int n10) {
        return new String[n10];
    }

    public static /* synthetic */ boolean W(ScriptTrackPoint scriptTrackPoint) {
        return x.m(scriptTrackPoint);
    }

    private static boolean a(TemplateMusic templateMusic) {
        boolean bl2;
        boolean bl3 = x.i(templateMusic);
        if (bl3 && (bl2 = x.z(templateMusic))) {
            bl2 = true;
        } else {
            bl2 = false;
            templateMusic = null;
        }
        return bl2;
    }

    private static boolean b(TemplateSticker templateSticker, TemplateGlobal templateGlobal) {
        boolean bl2;
        boolean bl3 = x.j(templateSticker, templateGlobal);
        if (bl3 && (bl2 = x.A(templateSticker))) {
            bl2 = true;
        } else {
            bl2 = false;
            templateSticker = null;
        }
        return bl2;
    }

    private static boolean c(TemplateVideo templateVideo, TemplateData templateData) {
        boolean bl2;
        boolean bl3 = x.k(templateVideo);
        if (bl3 && (bl2 = x.B(templateVideo, templateData))) {
            bl2 = true;
        } else {
            bl2 = false;
            templateVideo = null;
        }
        return bl2;
    }

    private static boolean d(ScriptTrackPOJO scriptTrackPOJO) {
        boolean bl2;
        boolean bl3 = true;
        if (scriptTrackPOJO == null) {
            return bl3;
        }
        Object object = scriptTrackPOJO.getScriptTrack();
        Object[] objectArray = scriptTrackPOJO.getScriptTrackPointList();
        List list = scriptTrackPOJO.getScriptTrackMetaDataList();
        if (object != null && objectArray != null && (bl2 = objectArray.size()) > false && (bl2 = (boolean)x.e((List)objectArray, (Function)(object = i.a))) && (bl2 = x.e(list, (Function)(object = b.a)))) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        objectArray = new Object[bl3];
        objectArray[0] = scriptTrackPOJO;
        return x.H(bl3, bl2, objectArray);
    }

    public static boolean e(List object, Function function) {
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                bl2 = (Boolean)(object2 = (Boolean)function.apply(object2));
                if (bl2) continue;
                return false;
            }
        }
        return true;
    }

    private static boolean f(String string2, String[] stringArray) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0 && stringArray != null) {
            for (String string3 : stringArray) {
                boolean bl2 = string3.equals(string2);
                if (!bl2) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean g(TemplatePOJO object) {
        boolean bl2;
        List list = ((TemplatePOJO)object).getTemplateMusicList();
        List list2 = ((TemplatePOJO)object).getTemplateStickerList();
        List list3 = ((TemplatePOJO)object).getTemplateVideoList();
        TemplateGlobal templateGlobal = ((TemplatePOJO)object).getTemplateGlobal();
        List list4 = ((TemplatePOJO)object).getScriptTrackPOJOList();
        Object object2 = ((TemplatePOJO)object).getTemplateData();
        int n10 = 0;
        Object[] objectArray = new Object[]{};
        m.a.a.b("---------checkData---------", objectArray);
        int n11 = 1;
        Object[] objectArray2 = new Object[n11];
        objectArray2[0] = object2;
        String string2 = "templateData: %s";
        m.a.a.b(string2, objectArray2);
        boolean bl3 = x.l((TemplateData)object2);
        if (bl3 && (bl3 = x.h(templateGlobal, (TemplateData)(object2 = ((TemplatePOJO)object).getTemplateData()))) && (bl3 = x.y(templateGlobal)) && (bl2 = x.e(list3, (Function)(object2 = new g((TemplatePOJO)object)))) && (bl2 = x.e(list, (Function)(object = c.a))) && (bl2 = x.e(list2, (Function)(object = new e(templateGlobal)))) && (bl2 = x.e(list4, (Function)(object = h.a)))) {
            n10 = n11;
        }
        return n10 != 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static boolean h(TemplateGlobal var0, TemplateData var1_1) {
        var2_2 = true;
        if (var0 == null) {
            return var2_2;
        }
        var3_3 = x.M(var1_1);
        if (var3_3 != false) ** GOTO lbl-1000
        var4_4 = var0.getRender();
        var3_3 = (int)TextUtils.isEmpty((CharSequence)var4_4);
        if (var3_3 != false) ** GOTO lbl-1000
        var4_4 = var0.getRender();
        var5_5 = var0.getDisplayType();
        var3_3 = b0.m(var4_4, var5_5);
        if (var3_3 == (var5_5 = -1)) lbl-1000:
        // 2 sources

        {
            var3_3 = false;
            var4_4 = null;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 = var2_2;
        }
        var6_6 = var0.getFilter();
        var5_5 = x.o((TemplateFilter)var6_6);
        var7_7 = var0.getRotate();
        var8_8 = x.t(var7_7);
        var9_9 = var0.getEffect();
        var10_10 = x.p(var9_9);
        var11_11 = var0.getRoi();
        var12_12 = x.s(var11_11);
        if (var3_3 != 0 && var5_5 != 0 && var8_8 && var10_10 && var12_12) {
            var3_3 = var2_2;
        } else {
            var3_3 = 0;
            var4_4 = null;
        }
        var6_6 = new Object[2];
        var6_6[0] = var0;
        var6_6[var2_2] = var1_1;
        return x.H(var2_2, (boolean)var3_3, var6_6);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static boolean i(TemplateMusic var0) {
        var1_1 = 1;
        if (var0 == null) {
            return (boolean)var1_1;
        }
        var2_2 = b0.e(var0);
        var3_3 = var2_2[var1_1];
        cfr_temp_0 = var3_3 - (var5_4 = var2_2[0]);
        var7_5 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
        if (var7_5 /* !! */  <= 0 || (var7_5 /* !! */  = (long)d.v.j.b.k(var8_6 = var0.getVolume())) != false) ** GOTO lbl-1000
        var3_3 = var2_2[var1_1];
        var5_4 = var2_2[0];
        var7_5 /* !! */  = (long)x.q(var0, var3_3 -= var5_4, 0);
        if (var7_5 /* !! */  == false) ** GOTO lbl-1000
        var3_3 = var2_2[var1_1];
        var5_4 = var2_2[0];
        var9_7 = x.q(var0, var3_3 -= var5_4, var1_1);
        if (var9_7 != 0) {
            var9_7 = var1_1;
        } else lbl-1000:
        // 3 sources

        {
            var9_7 = 0;
            var2_2 = null;
        }
        var10_8 = new Object[var1_1];
        var10_8[0] = var0;
        return x.H((boolean)var1_1, (boolean)var9_7, var10_8);
    }

    private static boolean j(TemplateSticker templateSticker, TemplateGlobal templateGlobal) {
        float f10;
        float f11;
        boolean bl2 = true;
        float f12 = Float.MIN_VALUE;
        if (templateSticker == null) {
            return bl2;
        }
        long l10 = templateGlobal.getTimebase();
        long[] lArray = b0.g(templateSticker, l10);
        long l11 = lArray[bl2];
        long l12 = lArray[0];
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        boolean bl3 = false;
        Object[] objectArray = null;
        if (l13 > 0 && (l13 = (long)Float.compare(f11 = templateSticker.getScale(), 0.0f)) > 0) {
            l13 = (long)bl2;
            f11 = f12;
        } else {
            l13 = 0;
            lArray = null;
            f11 = 0.0f;
        }
        String string2 = templateSticker.getType();
        String string3 = "text";
        boolean bl4 = string3.equals(string2);
        if (bl4 && ((bl4 = TextUtils.isEmpty((CharSequence)(string2 = templateSticker.getTextContent()))) || (bl3 = Float.compare(f10 = templateSticker.getTextFontSize(), 0.0f)) <= false)) {
            bl3 = false;
            objectArray = null;
        } else {
            bl3 = bl2;
        }
        if (l13 != false && bl3) {
            l13 = (long)bl2;
            f11 = f12;
        } else {
            l13 = 0;
            lArray = null;
            f11 = 0.0f;
        }
        objectArray = new Object[2];
        objectArray[0] = templateSticker;
        objectArray[bl2] = templateGlobal;
        return x.H(bl2, (boolean)l13, objectArray);
    }

    private static boolean k(TemplateVideo templateVideo) {
        float f10;
        long l10;
        boolean bl2 = true;
        float f11 = Float.MIN_VALUE;
        if (templateVideo == null) {
            return bl2;
        }
        long l11 = b0.h(templateVideo);
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0 && (object = (Object)d.v.j.b.k(f10 = templateVideo.getVolume())) == false) {
            object = bl2;
            f10 = f11;
        } else {
            object = 0;
            f10 = 0.0f;
        }
        boolean bl3 = x.r(templateVideo);
        TemplateTransition templateTransition = templateVideo.getTransition();
        boolean bl4 = x.u(templateVideo, templateTransition);
        TemplateFilter templateFilter = templateVideo.getFilter();
        boolean bl5 = x.o(templateFilter);
        TemplateRotate templateRotate = templateVideo.getRotate();
        boolean bl6 = x.t(templateRotate);
        TemplateEffect templateEffect = templateVideo.getEffect();
        boolean bl7 = x.p(templateEffect);
        TemplateRoi templateRoi = templateVideo.getRoi();
        boolean bl8 = x.s(templateRoi);
        if (object != false && bl3 && bl4 && bl5 && bl6 && bl7 && bl8) {
            object = bl2;
            f10 = f11;
        } else {
            object = 0;
            f10 = 0.0f;
        }
        Object[] objectArray = new Object[bl2];
        objectArray[0] = templateVideo;
        return x.H(bl2, (boolean)object, objectArray);
    }

    private static boolean l(TemplateData templateData) {
        int n10;
        String string2;
        int n11;
        int n12 = 1;
        if (templateData != null && (n11 = x.M(templateData)) == 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)(string2 = templateData.getVideoRatio())) ? 1 : 0)) == 0 && (n11 = b0.l(string2 = templateData.getVideoRatio())) == (n10 = -1)) {
            n11 = 0;
            string2 = null;
        } else {
            n11 = n12;
        }
        Object[] objectArray = new Object[n12];
        objectArray[0] = templateData;
        return x.H(n12 != 0, n11 != 0, objectArray);
    }

    private static boolean m(ScriptTrackPoint scriptTrackPoint) {
        boolean bl2;
        if (scriptTrackPoint != null) {
            bl2 = true;
        } else {
            bl2 = false;
            scriptTrackPoint = null;
        }
        return bl2;
    }

    private static boolean n(ScriptTrackPointItem scriptTrackPointItem) {
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean o(TemplateFilter templateFilter) {
        if (templateFilter == null) return true;
        int n10 = templateFilter.isEnable();
        if (n10 == 0) return true;
        float f10 = templateFilter.getStrength();
        n10 = 1120403456;
        float f11 = 100.0f;
        boolean bl2 = d.v.j.b.c((int)(f10 *= f11));
        if (bl2) return false;
        return true;
    }

    private static boolean p(TemplateEffect templateEffect) {
        float f10;
        boolean bl2;
        float f11;
        boolean bl3;
        if (templateEffect != null && (bl3 = templateEffect.isEnable()) && ((bl3 = d.v.j.b.e(d.v.j.b.o(f11 = templateEffect.getSaturation()))) || (bl3 = d.v.j.b.e(d.v.j.b.o(f11 = templateEffect.getContrast()))) || (bl3 = d.v.j.b.e(d.v.j.b.o(f11 = templateEffect.getHue()))) || (bl3 = d.v.j.b.e(d.v.j.b.o(f11 = templateEffect.getExposure()))) || (bl2 = d.v.j.b.e(d.v.j.b.o(f10 = templateEffect.getTemperature()))))) {
            bl2 = false;
            f10 = 0.0f;
            templateEffect = null;
        } else {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        }
        return bl2;
    }

    private static boolean q(TemplateMusic object, long l10, int n10) {
        long[] lArray = b0.f((TemplateAudioData)object, n10);
        int n11 = 1;
        if (lArray == null) {
            return n11 != 0;
        }
        long l11 = lArray[0];
        long l12 = lArray[n11];
        int n12 = d.v.j.b.j(l11, l12, l10) ^ n11;
        object = b0.p((TemplateAudioData)object, n10);
        float f10 = ((TemplateAudioTransition)object).getStartVolume();
        float f11 = ((TemplateAudioTransition)object).getEndVolume();
        n10 = n10 == n11 ? n11 : 0;
        int n13 = d.v.j.b.l(f10, f11, n10 != 0) ^ n11;
        if (n12 == 0 || n13 == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private static boolean r(TemplateVideo object) {
        boolean bl2;
        float f10;
        int n10;
        int n11 = 1;
        if (!(object == null || (n10 = ((TemplateVideo)object).getRateType()) == 0 && (n10 = Float.compare(f10 = ((TemplateVideo)object).getRate(), 0.0f)) > 0 || (n10 = ((TemplateVideo)object).getRateType()) == n11 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((TemplateVideo)object).getBezierRate()))))) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private static boolean s(TemplateRoi stringArray) {
        int n10;
        int n11 = 1;
        if (stringArray != null && (n10 = stringArray.isEnable()) != 0) {
            int n12;
            String[] stringArray2 = stringArray.getStartCenter();
            stringArray = stringArray.getEndCenter();
            boolean bl2 = TextUtils.isEmpty((CharSequence)stringArray2);
            int n13 = 2;
            String string2 = ",";
            String string3 = ")";
            String string4 = "(";
            if (!bl2 && (bl2 = stringArray2.startsWith(string4)) && (bl2 = stringArray2.endsWith(string3)) && (n10 = (stringArray2 = stringArray2.split(string2)).length) == n13) {
                n10 = n11;
            } else {
                n10 = 0;
                stringArray2 = null;
            }
            bl2 = TextUtils.isEmpty((CharSequence)stringArray);
            if (!bl2 && (bl2 = stringArray.startsWith(string4)) && (bl2 = stringArray.endsWith(string3)) && (n12 = (stringArray = stringArray.split(string2)).length) == n13) {
                n12 = n11;
            } else {
                n12 = 0;
                stringArray = null;
            }
            if (n10 == 0 || n12 == 0) {
                n11 = 0;
            }
        }
        return n11 != 0;
    }

    private static boolean t(TemplateRotate templateRotate) {
        boolean bl2;
        boolean bl3;
        if (templateRotate != null && (bl3 = templateRotate.isEnable()) && (bl2 = d.v.j.b.i(templateRotate.getRotate()))) {
            bl2 = false;
            templateRotate = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static boolean u(TemplateVideo templateVideo, TemplateTransition object) {
        long l10;
        long l11;
        long l12;
        int n10;
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((TemplateTransition)object).getName()))) && (n10 = (l12 = (l11 = b0.r(templateVideo)) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
            n10 = 0;
            templateVideo = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public static boolean v(TemplatePOJO object) {
        if (object == null) {
            return false;
        }
        List list = ((TemplatePOJO)object).getTemplateMusicList();
        List list2 = ((TemplatePOJO)object).getTemplateStickerList();
        List list3 = ((TemplatePOJO)object).getTemplateVideoList();
        TemplateGlobal templateGlobal = ((TemplatePOJO)object).getTemplateGlobal();
        object = ((TemplatePOJO)object).getTemplateData();
        return x.x(list, list2, list3, templateGlobal, (TemplateData)object);
    }

    private static boolean w(TemplateData templateData) {
        boolean bl2;
        boolean bl3 = true;
        bl2 = templateData != null && (bl2 = templateData.isDownloadFinished()) ? bl3 : false;
        Object[] objectArray = new Object[bl3];
        objectArray[0] = templateData;
        return x.H(bl3, bl2, objectArray);
    }

    private static boolean x(List object, List list, List object2, TemplateGlobal object3, TemplateData templateData) {
        boolean bl2;
        boolean bl3;
        boolean bl4;
        int n10 = 0;
        Object[] objectArray = new Object[]{};
        m.a.a.b("---------checkDownload---------", objectArray);
        int n11 = 1;
        Object[] objectArray2 = new Object[n11];
        objectArray2[0] = templateData;
        String string2 = "templateData: %s";
        m.a.a.b(string2, objectArray2);
        boolean bl5 = x.w(templateData);
        if (bl5 && (bl4 = x.y((TemplateGlobal)object3)) && (bl3 = x.e((List)object2, (Function)(object3 = new j(templateData)))) && (bl2 = x.e((List)object, (Function)(object2 = d.a))) && (bl2 = x.e(list, (Function)(object = f.a)))) {
            n10 = n11;
        }
        return n10 != 0;
    }

    private static boolean y(TemplateGlobal templateGlobal) {
        if (templateGlobal == null) {
            return true;
        }
        return x.L(templateGlobal.getFilter());
    }

    private static boolean z(TemplateMusic object) {
        int n10;
        block3: {
            int n11;
            block2: {
                n10 = 0;
                n11 = 1;
                if (object == null) break block2;
                boolean bl2 = ((TemplateAudioData)object).isLocalSource();
                object = ((TemplateAudioData)object).getName();
                int n12 = 3;
                Object[] objectArray = new d.v.e.j.a[n12];
                Enum enum_ = EditConfig$ResourceType.MUSIC;
                objectArray[0] = enum_;
                enum_ = TemEditorConfig$SmartType.SMART_LOCAL;
                objectArray[n11] = enum_;
                int n13 = 2;
                TemEditorConfig$TemplateType temEditorConfig$TemplateType = TemEditorConfig$TemplateType.EOV;
                objectArray[n13] = temEditorConfig$TemplateType;
                boolean bl3 = x.D(bl2, (String)object, (String[])(objectArray = x.I((d.v.e.j.a[])objectArray)));
                if (!bl3) break block3;
            }
            n10 = n11;
        }
        return n10 != 0;
    }
}

