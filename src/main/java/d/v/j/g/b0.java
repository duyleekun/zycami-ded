/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.j.g;

import android.text.TextUtils;
import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType;
import com.zhiyun.editortemplate.TemEditorConfig$TemplateType;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioData;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateAudioTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateRoi;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateSticker;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateTransition;
import com.zhiyun.editortemplate.data.database.model.template.config.TemplateVideo;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.e.j.a;
import d.v.e.l.s1;
import d.v.j.b;
import d.v.j.g.p;
import d.v.j.g.w;
import java.util.List;
import java.util.function.IntFunction;

public class b0 {
    public static String[] a(List stream) {
        boolean bl2 = b.f((List)((Object)stream));
        if (bl2) {
            return new String[0];
        }
        stream = stream.stream();
        Object object = w.a;
        stream = stream.map(object);
        object = p.a;
        return (String[])stream.toArray((IntFunction<A[]>)object);
    }

    public static void b(TemplatePOJO object) {
        Object object2;
        int n10;
        if (object == null) {
            return;
        }
        if ((object = ((TemplatePOJO)object).getTemplateData()) == null) {
            return;
        }
        int n11 = ((TemplateData)object).getTemplateProtocolType();
        if (n11 == (n10 = 1)) {
            object2 = TemEditorConfig$TemplateType.EOV;
        } else {
            n11 = ((TemplateData)object).getTemplateUseType();
            if (n11 != 0) {
                if (n11 != n10) {
                    n11 = 0;
                    object2 = null;
                } else {
                    object2 = TemEditorConfig$SmartType.SMART_LOCAL;
                }
            } else {
                object2 = TemEditorConfig$TemplateType.TEMPLATE;
            }
        }
        if (object2 == null) {
            return;
        }
        String string2 = ((TemplateData)object).getCoverUrl();
        string2 = TemEditorConfig.c((a)object2, string2);
        ((TemplateData)object).setCoverUrl(string2);
        string2 = ((TemplateData)object).getVideoUrl();
        object2 = TemEditorConfig.c((a)object2, string2);
        ((TemplateData)object).setVideoUrl((String)object2);
    }

    public static int c(List list, long l10) {
        int n10;
        int n11 = b.f(list);
        int n12 = -1;
        if (n11 != 0) {
            return n12;
        }
        long l11 = 0L;
        n11 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (n11 != 0 && (n11 = list.size()) != (n10 = 1)) {
            for (int i10 = 0; i10 < (n11 = list.size()); ++i10) {
                d.v.h.e.a a10 = (d.v.h.e.a)list.get(i10);
                long l12 = a10.d();
                long l13 = (l11 += l12) - l10;
                n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n11 < 0) continue;
                return i10;
            }
            return n12;
        }
        return 0;
    }

    public static long d(TemplateAudioData templateAudioData) {
        long l10;
        long l11;
        long l12;
        long l13 = 0L;
        double d10 = 0.0;
        if (templateAudioData != null && (l12 = (l11 = (l10 = templateAudioData.getTimebase()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            d10 = (double)templateAudioData.getAttachTime() * 1.0;
            double d11 = templateAudioData.getTimebase();
            d10 /= d11;
            l10 = 4696837146684686336L;
            d11 = 1000000.0;
            l13 = (long)(d10 *= d11);
        }
        return l13;
    }

    public static long[] e(TemplateAudioData templateAudioData) {
        long l10;
        long l11;
        long l12;
        long l13;
        int n10 = 2;
        if (templateAudioData != null && (l13 = (l12 = (l11 = templateAudioData.getTimebase()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            long l14;
            long[] lArray = new long[n10];
            double d10 = templateAudioData.getStartTime();
            double d11 = 1.0;
            d10 *= d11;
            double d12 = templateAudioData.getTimebase();
            d10 /= d12;
            d12 = 1000000.0;
            lArray[0] = l14 = (long)(d10 * d12);
            d10 = (double)templateAudioData.getEndTime() * d11;
            d11 = templateAudioData.getTimebase();
            lArray[1] = l14 = (long)(d10 / d11 * d12);
            return lArray;
        }
        return new long[n10];
    }

    public static long[] f(TemplateAudioData templateAudioData, int n10) {
        long l10;
        long l11;
        long l12;
        long l13;
        int n11 = 0;
        long[] lArray = null;
        if (templateAudioData != null && (l13 = (l12 = (l11 = templateAudioData.getTimebase()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            long l14;
            long l15;
            TemplateAudioTransition templateAudioTransition = b0.p(templateAudioData, n10);
            if (templateAudioTransition == null) {
                return null;
            }
            n11 = 2;
            lArray = new long[n11];
            double d10 = templateAudioTransition.getStartTime();
            double d11 = 1.0;
            d10 *= d11;
            double d12 = templateAudioData.getTimebase();
            d10 /= d12;
            d12 = 1000000.0;
            lArray[0] = l15 = (long)(d10 * d12);
            l13 = 1;
            l15 = templateAudioTransition.getEndTime();
            d10 = (double)l15 * d11;
            double d13 = templateAudioData.getTimebase();
            d10 = d10 / d13 * d12;
            lArray[l13] = l14 = (long)d10;
        }
        return lArray;
    }

    public static long[] g(TemplateSticker templateSticker, long l10) {
        long l11;
        long l12;
        long l13;
        int n10 = 2;
        if (templateSticker != null && (l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            long l14;
            long l15;
            long[] lArray = new long[n10];
            double d10 = templateSticker.getStartTime();
            double d11 = 1.0;
            d10 *= d11;
            double d12 = l10;
            double d13 = 1000000.0;
            lArray[0] = l15 = (long)((d10 /= d12) * d13);
            lArray[1] = l14 = (long)((double)templateSticker.getEndTime() * d11 / d12 * d13);
            return lArray;
        }
        return new long[n10];
    }

    public static long h(TemplateVideo templateVideo) {
        long l10;
        long l11;
        long l12;
        long l13 = 0L;
        double d10 = 0.0;
        if (templateVideo != null && (l12 = (l11 = (l10 = templateVideo.getTimebase()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            l13 = templateVideo.getEndTime();
            l10 = templateVideo.getStartTime();
            d10 = (double)(l13 - l10) * 1.0;
            double d11 = templateVideo.getTimebase();
            d10 /= d11;
            l10 = 4696837146684686336L;
            d11 = 1000000.0;
            l13 = (long)(d10 *= d11);
        }
        return l13;
    }

    public static long i(TemplateVideo templateVideo) {
        long l10;
        long l11;
        long l12;
        long l13 = 0L;
        if (templateVideo != null && (l12 = (l11 = (l10 = templateVideo.getTimebase()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            float f10 = templateVideo.getRate();
            int n10 = Float.compare(f10, 0.0f);
            if (n10 <= 0) {
                n10 = 1065353216;
                f10 = 1.0f;
            } else {
                f10 = templateVideo.getRate();
            }
            long l14 = templateVideo.getEndTime();
            long l15 = templateVideo.getStartTime();
            double d10 = (double)(l14 -= l15) * 1.0;
            double d11 = templateVideo.getTimebase();
            d10 /= d11;
            l15 = 4696837146684686336L;
            d10 *= 1000000.0;
            d11 = f10;
            l13 = (long)(d10 /= d11);
        }
        return l13;
    }

    public static long j(TemplateVideo templateVideo) {
        long l10;
        long l11;
        long l12;
        long l13 = 0L;
        double d10 = 0.0;
        if (templateVideo != null && (l12 = (l11 = (l10 = templateVideo.getTimebase()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            d10 = (double)templateVideo.getEndTime() * 1.0;
            double d11 = templateVideo.getTimebase();
            d10 /= d11;
            l10 = 4696837146684686336L;
            d11 = 1000000.0;
            l13 = (long)(d10 *= d11);
        }
        return l13;
    }

    public static long k(TemplateVideo templateVideo) {
        long l10;
        long l11;
        long l12;
        long l13 = 0L;
        if (templateVideo != null && (l12 = (l11 = (l10 = templateVideo.getTimebase()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            float f10 = templateVideo.getRate();
            int n10 = Float.compare(f10, 0.0f);
            if (n10 <= 0) {
                n10 = 1065353216;
                f10 = 1.0f;
            } else {
                f10 = templateVideo.getRate();
            }
            long l14 = templateVideo.getEndTime();
            double d10 = (double)l14 * 1.0;
            double d11 = templateVideo.getTimebase();
            d10 /= d11;
            d10 *= 1000000.0;
            d11 = f10;
            l13 = (long)(d10 /= d11);
        }
        return l13;
    }

    public static int l(String string2) {
        Object object;
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        int n12 = -1;
        if (n11 != 0) {
            return n12;
        }
        for (n11 = 0; n11 < (n10 = ((String[])(object = EditConfig$a.l)).length); ++n11) {
            boolean bl2 = string2.equals(object = object[n11]);
            if (!bl2) continue;
            return n11;
        }
        return n12;
    }

    public static int m(String string2, int n10) {
        Object object;
        int n11;
        int n12 = TextUtils.isEmpty((CharSequence)string2);
        int n13 = -1;
        if (n12 != 0) {
            return n13;
        }
        n12 = 1;
        if (n10 == n12) {
            return 6;
        }
        for (n10 = 0; n10 < (n11 = ((String[])(object = EditConfig$a.l)).length); ++n10) {
            n12 = (int)(string2.equals(object = object[n10]) ? 1 : 0);
            if (n12 == 0) continue;
            return n10;
        }
        return n13;
    }

    public static long n(TemplateVideo templateVideo) {
        long l10;
        long l11;
        long l12;
        long l13 = 0L;
        double d10 = 0.0;
        if (templateVideo != null && (l12 = (l11 = (l10 = templateVideo.getTimebase()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            d10 = (double)templateVideo.getStartTime() * 1.0;
            double d11 = templateVideo.getTimebase();
            d10 /= d11;
            l10 = 4696837146684686336L;
            d11 = 1000000.0;
            l13 = (long)(d10 *= d11);
        }
        return l13;
    }

    public static long o(TemplateVideo templateVideo) {
        long l10;
        long l11;
        long l12;
        long l13 = 0L;
        if (templateVideo != null && (l12 = (l11 = (l10 = templateVideo.getTimebase()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            float f10 = templateVideo.getRate();
            int n10 = Float.compare(f10, 0.0f);
            if (n10 <= 0) {
                n10 = 1065353216;
                f10 = 1.0f;
            } else {
                f10 = templateVideo.getRate();
            }
            long l14 = templateVideo.getStartTime();
            double d10 = (double)l14 * 1.0;
            double d11 = templateVideo.getTimebase();
            d10 /= d11;
            d10 *= 1000000.0;
            d11 = f10;
            l13 = (long)(d10 /= d11);
        }
        return l13;
    }

    public static TemplateAudioTransition p(TemplateAudioData object, int n10) {
        int n11;
        object = n10 != 0 ? (n10 != (n11 = 1) ? null : ((TemplateAudioData)object).getFadeout()) : ((TemplateAudioData)object).getFadeIn();
        return object;
    }

    public static TemplateRoi q(int n10) {
        TemplateRoi templateRoi;
        switch (n10) {
            default: {
                templateRoi = null;
                break;
            }
            case 6: {
                boolean bl2 = true;
                float f10 = 0.8f;
                float f11 = 0.8f;
                float f12 = 0.8f;
                float f13 = 0.8f;
                long l10 = 0L;
                String string2 = "(0.5, 0.4)";
                String string3 = "(0.5, 0.6)";
                templateRoi = new TemplateRoi(bl2, string2, f10, f11, string3, f12, f13, l10);
                break;
            }
            case 5: {
                boolean bl3 = true;
                float f14 = 0.8f;
                float f15 = 0.8f;
                float f16 = 0.8f;
                float f17 = 0.8f;
                long l11 = 0L;
                String string4 = "(0.5, 0.6)";
                String string5 = "(0.5, 0.4)";
                templateRoi = new TemplateRoi(bl3, string4, f14, f15, string5, f16, f17, l11);
                break;
            }
            case 4: {
                boolean bl4 = true;
                float f18 = 0.8f;
                float f19 = 0.8f;
                float f20 = 0.8f;
                float f21 = 0.8f;
                long l12 = 0L;
                String string6 = "(0.6, 0.5)";
                String string7 = "(0.4, 0.5)";
                templateRoi = new TemplateRoi(bl4, string6, f18, f19, string7, f20, f21, l12);
                break;
            }
            case 3: {
                boolean bl5 = true;
                float f22 = 0.8f;
                float f23 = 0.8f;
                float f24 = 0.8f;
                float f25 = 0.8f;
                long l13 = 0L;
                String string8 = "(0.4, 0.5)";
                String string9 = "(0.6, 0.5)";
                templateRoi = new TemplateRoi(bl5, string8, f22, f23, string9, f24, f25, l13);
                break;
            }
            case 2: {
                boolean bl6 = true;
                float f26 = 0.8f;
                float f27 = 0.8f;
                float f28 = 1.0f;
                float f29 = 1.0f;
                long l14 = 0L;
                String string10 = "(0.5, 0.5)";
                String string11 = "(0.5, 0.5)";
                templateRoi = new TemplateRoi(bl6, string10, f26, f27, string11, f28, f29, l14);
                break;
            }
            case 1: {
                boolean bl7 = true;
                float f30 = 1.0f;
                float f31 = 1.0f;
                float f32 = 0.8f;
                float f33 = 0.8f;
                long l15 = 0L;
                String string12 = "(0.5, 0.5)";
                String string13 = "(0.5, 0.5)";
                templateRoi = new TemplateRoi(bl7, string12, f30, f31, string13, f32, f33, l15);
                break;
            }
            case 0: {
                boolean bl8 = false;
                Object var9_29 = null;
                float f34 = 0.0f;
                float f35 = 0.0f;
                Object var10_33 = null;
                float f36 = 0.0f;
                float f37 = 0.0f;
                long l16 = 0L;
                templateRoi = new TemplateRoi(false, null, 0.0f, 0.0f, null, 0.0f, 0.0f, l16);
            }
        }
        return templateRoi;
    }

    public static long r(TemplateVideo templateVideo) {
        long l10;
        long l11;
        long l12;
        long l13 = 0L;
        double d10 = 0.0;
        if (templateVideo != null && (l12 = (l11 = (l10 = templateVideo.getTimebase()) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            TemplateTransition templateTransition = templateVideo.getTransition();
            d10 = (double)templateTransition.getDuration() * 1.0;
            double d11 = templateVideo.getTimebase();
            d10 /= d11;
            l10 = 4696837146684686336L;
            d11 = 1000000.0;
            l13 = (long)(d10 *= d11);
        }
        return l13;
    }

    public static int s(TemplateRoi object) {
        float f10;
        float f11;
        float f12;
        float f13;
        Object object2 = object.isEnable();
        if (object2 == 0) {
            return 0;
        }
        float f14 = object.getStartWidth();
        float f15 = f14 - (f13 = object.getEndWidth());
        object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
        if (object2 < 0 && (object2 = (Object)((f12 = (f14 = object.getStartHeight()) - (f13 = object.getEndHeight())) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1))) < 0) {
            return 2;
        }
        f14 = object.getStartWidth();
        f13 = object.getEndWidth();
        object2 = f14 == f13 ? 0 : (f14 > f13 ? 1 : -1);
        int n10 = 1;
        f13 = Float.MIN_VALUE;
        if (object2 > 0 && (object2 = (Object)((f11 = (f14 = object.getStartHeight()) - (f10 = object.getEndHeight())) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) > 0) {
            return n10;
        }
        Object object3 = object.getStartCenter();
        String string2 = ",";
        object3 = ((String)object3).split(string2);
        String string3 = object3[0];
        String string4 = "(";
        String string5 = "";
        string3 = string3.replace(string4, string5);
        float f16 = Float.parseFloat(string3);
        object3 = object3[n10];
        String string6 = ")";
        object3 = ((String)object3).replace(string6, string5);
        f14 = Float.parseFloat((String)object3);
        object = object.getEndCenter().split(string2);
        string2 = object[0].replace(string4, string5);
        f10 = Float.parseFloat(string2);
        object = object[n10].replace(string6, string5);
        float f17 = Float.parseFloat((String)object);
        n10 = (int)(f16 == f10 ? 0 : (f16 > f10 ? 1 : -1));
        if (n10 > 0) {
            return 4;
        }
        n10 = (int)(f16 == f10 ? 0 : (f16 < f10 ? -1 : 1));
        if (n10 < 0) {
            return 3;
        }
        n10 = (int)(f14 == f17 ? 0 : (f14 > f17 ? 1 : -1));
        if (n10 > 0) {
            return 5;
        }
        Object object4 = f14 == f17 ? 0 : (f14 < f17 ? -1 : 1);
        if (object4 < 0) {
            return 6;
        }
        return 0;
    }

    public static boolean t(String string2) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        String string3 = ".caf";
        bl3 = string2.endsWith(string3);
        if (bl3 || (bl3 = string2.endsWith(string3 = ".animatedsticker")) || (bl2 = string2.endsWith(string3 = ".gif"))) {
            bl4 = true;
        }
        return bl4;
    }

    public static boolean u(String stringArray) {
        int n10;
        Object object;
        int n11 = TextUtils.isEmpty((CharSequence)stringArray);
        int n12 = 1;
        if (n11 == 0 && (n11 = stringArray.startsWith((String)(object = d.v.e.j.b.f().getAbsolutePath()))) == 0 && (n11 = stringArray.startsWith((String)(object = "file:///android_asset/"))) == 0 && (n11 = stringArray.startsWith((String)(object = "assets:/"))) == 0 && ((n11 = ((String[])(object = stringArray.split("\\."))).length) != n12 || (n10 = (stringArray = stringArray.split((String)(object = "/"))).length) != n12)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public static /* synthetic */ String[] v(int n10) {
        return new String[n10];
    }

    public static String w(String string2) {
        boolean bl2 = b0.u(string2);
        if (bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            string2 = s1.D(string2);
        }
        return string2;
    }
}

