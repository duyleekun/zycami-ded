/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q.e;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import d.v.c.v0.q.e.e;

public final class a
implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ EditConfig$ResourceType b;
    public final /* synthetic */ FileData c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    public /* synthetic */ a(e e10, EditConfig$ResourceType editConfig$ResourceType, FileData fileData, String string2, String string3) {
        this.a = e10;
        this.b = editConfig$ResourceType;
        this.c = fileData;
        this.d = string2;
        this.e = string3;
    }

    public final void run() {
        e e10 = this.a;
        EditConfig$ResourceType editConfig$ResourceType = this.b;
        FileData fileData = this.c;
        String string2 = this.d;
        String string3 = this.e;
        e10.m(editConfig$ResourceType, fileData, string2, string3);
    }
}

