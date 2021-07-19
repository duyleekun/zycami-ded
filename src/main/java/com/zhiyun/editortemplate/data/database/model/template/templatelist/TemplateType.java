/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

import com.zhiyun.editortemplate.data.database.model.template.templatelist.AutoValue_TemplateType;
import d.v.j.e.e.a;
import d.v.j.e.e.b;

public abstract class TemplateType
implements b,
a {
    public static TemplateType create(long l10, String string2, String string3, String string4, int n10, int n11) {
        AutoValue_TemplateType autoValue_TemplateType = new AutoValue_TemplateType(l10, string2, string3, string4, n10, n11);
        return autoValue_TemplateType;
    }

    public abstract long getId();

    public abstract int getResourceType();

    public abstract int getTemplateProtocolType();

    public abstract String getTextEn();

    public abstract String getTextZh();

    public abstract String getTextZhTw();
}

