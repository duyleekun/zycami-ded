/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q.e;

import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.c.v0.q.e.e;

public final class d
implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ EditConfig$ResourceType[] b;

    public /* synthetic */ d(e e10, EditConfig$ResourceType[] editConfig$ResourceTypeArray) {
        this.a = e10;
        this.b = editConfig$ResourceTypeArray;
    }

    public final void run() {
        e e10 = this.a;
        EditConfig$ResourceType[] editConfig$ResourceTypeArray = this.b;
        e10.k(editConfig$ResourceTypeArray);
    }
}

