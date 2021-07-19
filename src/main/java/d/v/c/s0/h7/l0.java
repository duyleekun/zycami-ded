/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import d.v.c.s0.h7.l0$b;
import d.v.j.e.c;
import d.v.j.e.i.c1;

public class l0 {
    public static String a(TemplatePOJO templatePOJO) {
        Object object = templatePOJO.getTemplateData();
        int n10 = ((TemplateData)object).getTempType();
        int n11 = ((TemplateData)object).getTemplateUseType();
        long l10 = l0.b(l0.d(templatePOJO), templatePOJO);
        object = new l0$b(n10, n11, l10, null);
        return ((l0$b)object).toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static long b(int n10, TemplatePOJO templatePOJO) {
        int n11 = -2;
        if (n10 != n11) {
            n11 = -1;
            if (n10 != n11) {
                if (n10 != 0) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("\u9009\u62e9\u7684\u6a21\u677f\u7c7b\u578b\u4e0d\u6b63\u786e,\u8bf7\u9009\u62e9smart\u6a21\u677f");
                    throw illegalArgumentException;
                }
            } else {
                Object object = templatePOJO.getTemplateData();
                n10 = (int)(((TemplateData)object).isEditorTemplate() ? 1 : 0);
                if (n10 != 0) {
                    object = templatePOJO.getTemplate();
                    return ((Template)object).getReferenceId();
                }
                object = templatePOJO.getScript();
                return ((Script)object).getReferenceId();
            }
        }
        TemplateData templateData = templatePOJO.getTemplateData();
        return templateData.getId();
    }

    public static long c(TemplatePOJO templatePOJO) {
        return l0.b(l0.d(templatePOJO), templatePOJO);
    }

    public static int d(TemplatePOJO object) {
        boolean bl2 = ((TemplateData)(object = ((TemplatePOJO)object).getTemplateData())).isBuiltInTemplate();
        if (bl2) {
            return -1;
        }
        bl2 = ((TemplateData)object).isDIYTemplate();
        if (bl2) {
            return -2;
        }
        boolean bl3 = ((TemplateData)object).isNetworkTemplate();
        if (bl3) {
            return 0;
        }
        object = new IllegalArgumentException("\u9009\u62e9\u7684\u6a21\u677f\u6765\u6e90\u4e0d\u6b63\u786e,\u8bf7\u9009\u62e9smart\u6a21\u677f");
        throw object;
    }

    public static LiveData e(int n10, long l10) {
        LiveData liveData;
        block2: {
            c1 c12;
            block0: {
                block1: {
                    c12 = c.a();
                    int n11 = -2;
                    if (n10 == n11) break block0;
                    n11 = -1;
                    if (n10 == n11) break block1;
                    if (n10 == 0) break block0;
                    liveData = new MutableLiveData();
                    break block2;
                }
                liveData = c12.g().e1(l10);
                break block2;
            }
            liveData = c12.d().g0(l10);
        }
        return liveData;
    }

    public static l0$b f(String string2) {
        l0$b l0$b = new l0$b(null);
        return l0$b.a(l0$b, string2);
    }
}

