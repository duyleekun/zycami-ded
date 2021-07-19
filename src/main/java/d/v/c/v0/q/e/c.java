/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q.e;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.c.v0.q.e.e;

public final class c
implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ EditConfig$ResourceType b;

    public /* synthetic */ c(e e10, EditConfig$ResourceType editConfig$ResourceType) {
        this.a = e10;
        this.b = editConfig$ResourceType;
    }

    public final void run() {
        e e10 = this.a;
        EditConfig$ResourceType editConfig$ResourceType = this.b;
        e10.i(editConfig$ResourceType);
    }
}

