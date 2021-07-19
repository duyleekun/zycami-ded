/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.PublishFragment;
import com.zhiyun.editortemplate.data.database.model.draft.Draft;

public final class z0
implements Observer {
    public final /* synthetic */ PublishFragment a;
    public final /* synthetic */ LiveData b;

    public /* synthetic */ z0(PublishFragment publishFragment, LiveData liveData) {
        this.a = publishFragment;
        this.b = liveData;
    }

    public final void onChanged(Object object) {
        PublishFragment publishFragment = this.a;
        LiveData liveData = this.b;
        object = (Draft)object;
        publishFragment.C0(liveData, (Draft)object);
    }
}

