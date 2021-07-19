/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;

public final class AutoValue_TemplateType
extends TemplateType {
    private final long id;
    private final int resourceType;
    private final int templateProtocolType;
    private final String textEn;
    private final String textZh;
    private final String textZhTw;

    public AutoValue_TemplateType(long l10, String string2, String string3, String string4, int n10, int n11) {
        this.id = l10;
        this.textZh = string2;
        this.textZhTw = string3;
        this.textEn = string4;
        this.resourceType = n10;
        this.templateProtocolType = n11;
    }

    public boolean equals(Object object) {
        block4: {
            boolean bl2;
            block6: {
                block5: {
                    int n10;
                    String string2;
                    String string3;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    Object object2 = object instanceof TemplateType;
                    if (object2 == 0) break block4;
                    long l10 = this.id;
                    long l11 = ((TemplateType)(object = (TemplateType)object)).getId();
                    long l12 = l10 - l11;
                    object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object2 != 0 || !((string3 = this.textZh) == null ? (string3 = ((TemplateType)object).getTextZh()) == null : (object2 = string3.equals(string2 = ((TemplateType)object).getTextZh())) != 0) || !((string3 = this.textZhTw) == null ? (string3 = ((TemplateType)object).getTextZhTw()) == null : (object2 = string3.equals(string2 = ((TemplateType)object).getTextZhTw())) != 0) || !((string3 = this.textEn) == null ? (string3 = ((TemplateType)object).getTextEn()) == null : (object2 = string3.equals(string2 = ((TemplateType)object).getTextEn())) != 0)) break block5;
                    object2 = this.resourceType;
                    int n11 = ((TemplateType)object).getResourceType();
                    if (object2 == n11 && (object2 = this.templateProtocolType) == (n10 = ((TemplateType)object).getTemplateProtocolType())) break block6;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getId() {
        return this.id;
    }

    public int getResourceType() {
        return this.resourceType;
    }

    public int getTemplateProtocolType() {
        return this.templateProtocolType;
    }

    public String getTextEn() {
        return this.textEn;
    }

    public String getTextZh() {
        return this.textZh;
    }

    public String getTextZhTw() {
        return this.textZhTw;
    }

    public int hashCode() {
        long l10 = this.id;
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^= l11);
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        String string2 = this.textZh;
        int n13 = 0;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        string2 = this.textZhTw;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        string2 = this.textEn;
        if (string2 != null) {
            n13 = string2.hashCode();
        }
        n11 = (n11 ^ n13) * n12;
        n10 = this.resourceType;
        n11 = (n11 ^ n10) * n12;
        n12 = this.templateProtocolType;
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TemplateType{id=");
        long l10 = this.id;
        stringBuilder.append(l10);
        stringBuilder.append(", textZh=");
        String string2 = this.textZh;
        stringBuilder.append(string2);
        stringBuilder.append(", textZhTw=");
        string2 = this.textZhTw;
        stringBuilder.append(string2);
        stringBuilder.append(", textEn=");
        string2 = this.textEn;
        stringBuilder.append(string2);
        stringBuilder.append(", resourceType=");
        int n10 = this.resourceType;
        stringBuilder.append(n10);
        stringBuilder.append(", templateProtocolType=");
        n10 = this.templateProtocolType;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

