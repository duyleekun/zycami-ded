/*
 * Decompiled with CFR 0.151.
 */
package d.v.j;

import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.e.l.k2;
import d.v.e.l.s1;
import java.io.File;

public class d {
    public static File a(TemplatePOJO templatePOJO) {
        if (templatePOJO == null) {
            return null;
        }
        return d.b(templatePOJO.getTemplateData());
    }

    public static File b(TemplateData object) {
        if (object == null) {
            return null;
        }
        File file = new File((String)(object = ((TemplateData)object).getCoverUrl()));
        boolean bl2 = s1.p(file);
        if (!bl2) {
            return null;
        }
        return file.getParentFile();
    }

    public static File c() {
        File file = k2.m();
        File file2 = new File(file, "TemplateDataRes");
        s1.c0(file2);
        return file2;
    }

    public static File d() {
        File file = k2.m();
        File file2 = new File(file, "Template");
        s1.c0(file2);
        return file2;
    }

    public static File e(String string2) {
        File file = d.c();
        File file2 = new File(file, string2);
        s1.c0(file2);
        return file2;
    }
}

