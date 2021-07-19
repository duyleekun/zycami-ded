/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.template.edit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;

public class EditorTemplateEditActivity$a
implements Observer {
    public final /* synthetic */ LiveData a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String[] c;
    public final /* synthetic */ EditorTemplateEditActivity d;

    public EditorTemplateEditActivity$a(EditorTemplateEditActivity editorTemplateEditActivity, LiveData liveData, long l10, String[] stringArray) {
        this.d = editorTemplateEditActivity;
        this.a = liveData;
        this.b = l10;
        this.c = stringArray;
    }

    public void a(TemplatePOJO templatePOJO) {
        Object object = this.a;
        ((LiveData)object).removeObserver(this);
        if (templatePOJO == null) {
            return;
        }
        object = this.d;
        long l10 = this.b;
        String[] stringArray = this.c;
        EditorTemplateEditActivity.i((EditorTemplateEditActivity)object, l10, stringArray, templatePOJO);
    }
}

