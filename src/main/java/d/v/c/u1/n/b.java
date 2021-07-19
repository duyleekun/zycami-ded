/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.u1.n;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.template.list.EditorTemplateListFragment;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;

public final class b
implements Observer {
    public final /* synthetic */ EditorTemplateListFragment a;

    public /* synthetic */ b(EditorTemplateListFragment editorTemplateListFragment) {
        this.a = editorTemplateListFragment;
    }

    public final void onChanged(Object object) {
        EditorTemplateListFragment editorTemplateListFragment = this.a;
        object = (DeviceViewModel$NetWorkEvent)((Object)object);
        editorTemplateListFragment.K((DeviceViewModel$NetWorkEvent)((Object)object));
    }
}

