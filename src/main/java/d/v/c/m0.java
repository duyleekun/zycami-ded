/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 */
package d.v.c;

import android.app.Application;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.cama.data.api.entity.sticker.AssetsStickerListBean;
import com.zhiyun.cama.data.api.entity.sticker.AssetsStickerListBean$AssetsStickerBean;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editorsdk.decoration.DecorationUseCases;
import com.zhiyun.editorsdk.fundation.EditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig;
import d.v.c.v;
import d.v.c.w;
import d.v.e.j.b;
import d.v.e.l.h2;
import d.v.e.l.q2.c;
import java.util.stream.Collectors;

public class m0 {
    public static final int a = 2500;
    public static final double b = 4.0E-4;
    public static final int c = 0;
    public static final int d = 251;
    public static final int e = 5;
    public static final double[] f;
    public static final String[] g;
    public static final long[] h;
    public static final int i = 30;
    public static final int j = 1000;
    public static final int k = 1;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 1920;
    public static final int o = 1080;

    static {
        Object[] objectArray;
        c = h2.g(25.0f);
        double[] dArray = objectArray = new double[6];
        double[] dArray2 = objectArray;
        dArray[0] = 0.125;
        dArray2[1] = 0.25;
        dArray[2] = 0.5;
        dArray2[3] = 1.0;
        dArray[4] = 2.0;
        dArray2[5] = 4.0;
        f = objectArray;
        g = new String[]{"1/8x", "1/4x", "1/2x", "1x", "2x", "4x"};
        Object[] objectArray2 = objectArray = (Object[])new long[4];
        Object[] objectArray3 = objectArray;
        objectArray2[0] = 500000L;
        objectArray3[1] = 1000000L;
        objectArray2[2] = 1500000L;
        objectArray3[3] = 2000000L;
        h = (long[])objectArray;
        float f10 = 54.0f;
        l = h2.b(f10);
        m = h2.b(f10);
    }

    public static String a() {
        return TemEditorConfig.c(EditConfig$ResourceType.MUSIC, "album/album.json");
    }

    public static String b() {
        return TemEditorConfig.c(EditConfig$ResourceType.CAPTION, "captionStyle.json");
    }

    public static String c() {
        return TemEditorConfig.c(EditConfig$ResourceType.SPEED, "curve_speed.json");
    }

    public static String d() {
        return TemEditorConfig.c(ResConfig$AppResType.WATERMARK, "image_watermark_logo_vertical.png");
    }

    public static String e() {
        return TemEditorConfig.c(EditConfig$ResourceType.FILTER, "filter.json");
    }

    public static String f() {
        return TemEditorConfig.c(EditConfig$ResourceType.FILTER, "filter_general.png");
    }

    public static String g() {
        return TemEditorConfig.c(EditConfig$ResourceType.FILTER, "filter_type.json");
    }

    public static String h() {
        return TemEditorConfig.c(EditConfig$ResourceType.FONT, "font.json");
    }

    public static String i() {
        return d.v.e.j.b.a("ic_common_none.png");
    }

    public static String j() {
        return TemEditorConfig.c(EditConfig$ResourceType.MUSIC, "song.json");
    }

    public static String k() {
        return TemEditorConfig.c(EditConfig$ResourceType.STICKER, "sticker.json");
    }

    public static String l() {
        return TemEditorConfig.c(EditConfig$ResourceType.STICKER, "sticker_type.json");
    }

    public static String m() {
        return TemEditorConfig.c(EditConfig$ResourceType.TRANSITION, "transition.json");
    }

    public static String n() {
        return TemEditorConfig.c(ResConfig$AppResType.WATERMARK, "watermark.json");
    }

    public static void o(Application application) {
        EditorConfig.a(application);
    }

    public static void p() {
        boolean bl2;
        Object object = m0.k();
        Object object2 = AssetsStickerListBean.class;
        if ((object = (AssetsStickerListBean)d.v.e.l.q2.c.d((String)object, object2)) != null && !(bl2 = (object2 = ((AssetsStickerListBean)object).getList()).isEmpty())) {
            object = ((AssetsStickerListBean)object).getList().stream();
            object2 = v.a;
            object = object.filter(object2);
            object2 = Collectors.toList();
            bl2 = (object = object.collect(object2)).isEmpty();
            if (bl2) {
                return;
            }
            object2 = w.a;
            object.forEach(object2);
        }
    }

    public static boolean q() {
        return false;
    }

    public static /* synthetic */ boolean r(AssetsStickerListBean$AssetsStickerBean assetsStickerListBean$AssetsStickerBean) {
        long l10;
        long l11 = assetsStickerListBean$AssetsStickerBean.getTypeId();
        long l12 = l11 - (l10 = (long)-1);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            assetsStickerListBean$AssetsStickerBean = null;
        }
        return (boolean)object;
    }

    public static /* synthetic */ void s(AssetsStickerListBean$AssetsStickerBean object) {
        EditConfig$ResourceType editConfig$ResourceType = EditConfig$ResourceType.STICKER;
        object = ((AssetsStickerListBean$AssetsStickerBean)object).getUrl();
        DecorationUseCases.d(TemEditorConfig.c(editConfig$ResourceType, (String)object));
    }
}

