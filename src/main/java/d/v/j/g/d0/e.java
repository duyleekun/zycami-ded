/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.j.g.d0;

import android.text.TextUtils;
import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import com.zhiyun.editortemplate.data.api.entity.track.TrackListBean;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.track.Script;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import d.v.e.l.q2.c;
import d.v.j.e.i.b1;
import d.v.j.g.d0.e$a;
import d.v.j.g.d0.f;
import java.util.List;

public class e
extends f {
    public static /* synthetic */ void R(e e10, TemplatePOJO templatePOJO, TrackListBean trackListBean) {
        e10.S(templatePOJO, trackListBean);
    }

    private void S(TemplatePOJO templatePOJO, TrackListBean object) {
        if (object != null) {
            b1 b12 = this.d.g();
            object = ((TrackListBean)object).getTrackList();
            object = b12.H0(null, (List)object);
            templatePOJO.setScriptTrackPOJOList((List)object);
        }
    }

    public Long C(TemplatePOJO templatePOJO) {
        return templatePOJO.getScript().getId();
    }

    public void N(TemplatePOJO templatePOJO, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        Object object = templatePOJO.getTemplateData();
        Object object2 = templatePOJO.getScript();
        long l10 = ((Script)object2).getReferenceId();
        boolean bl2 = ((TemplateData)object).isFileTemplate();
        if (bl2) {
            object = this.d.i().a();
            int n10 = (int)l10;
            object = object.a(n10);
            object2 = new e$a(this, templatePOJO, downLoadHelper$CancelControl);
            object.h((k.f)object2);
        } else {
            this.i(templatePOJO);
        }
    }

    public TrackListBean T(TemplateInfoData object) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((TemplateInfoData)object).getTrackChainNameJson())))) {
            Class<TrackListBean> clazz = TrackListBean.class;
            object = (TrackListBean)c.a(clazz, (String)object);
        } else {
            object = null;
        }
        return object;
    }
}

