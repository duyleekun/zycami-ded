/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;

public final class d0
implements Observer {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ d0(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChanged(Object object) {
        CameraFragment cameraFragment = this.a;
        object = (TemplatePOJO)object;
        cameraFragment.o2((TemplatePOJO)object);
    }
}

