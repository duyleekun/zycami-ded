/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.template.templatelist;

import d.v.j.e.e.b;
import java.util.Objects;

public class TemplateDescription
implements b {
    private String textEn;
    private String textZh;
    private String textZhTw;

    public TemplateDescription() {
    }

    public TemplateDescription(String string2, String string3, String string4) {
        this.textZh = string2;
        this.textEn = string3;
        this.textZhTw = string4;
    }

    public TemplateDescription clone() {
        String string2 = this.textZh;
        String string3 = this.textEn;
        TemplateDescription templateDescription = new TemplateDescription(string2, string3, string2);
        return templateDescription;
    }

    public boolean equals(Object object) {
        Object object2;
        Object object3;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object3 = this.getClass()) == (object2 = object.getClass())) {
            boolean bl3;
            object = (TemplateDescription)object;
            object3 = this.textZh;
            object2 = ((TemplateDescription)object).textZh;
            boolean bl4 = Objects.equals(object3, object2);
            if (!(bl4 && (bl4 = Objects.equals(object3 = this.textEn, object2 = ((TemplateDescription)object).textEn)) && (bl3 = Objects.equals(object3 = this.textZhTw, object = ((TemplateDescription)object).textZhTw)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
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
        Object[] objectArray = new Object[3];
        String string2 = this.textZh;
        objectArray[0] = string2;
        string2 = this.textEn;
        objectArray[1] = string2;
        string2 = this.textZhTw;
        objectArray[2] = string2;
        return Objects.hash(objectArray);
    }

    public void setTextEn(String string2) {
        this.textEn = string2;
    }

    public void setTextZh(String string2) {
        this.textZh = string2;
    }

    public void setTextZhTw(String string2) {
        this.textZhTw = string2;
    }
}

