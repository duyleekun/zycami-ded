/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.h7.q0;

import android.view.View;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.util.DownloadState;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.h1.s;
import d.v.c.n0.e;
import d.v.c.s0.h7.l0;
import d.v.c.s0.h7.q0.h;
import d.v.c.w0.ih;
import d.v.f.f.b;

public class y$b
extends s {
    private b j;

    private /* synthetic */ void x(int n10, View view) {
        b b10 = this.j;
        Object object = this.getItem(n10);
        b10.a(view, n10, object);
    }

    public void e(DiffUtil$DiffResult diffUtil$DiffResult) {
        this.notifyDataSetChanged();
    }

    public int g(int n10) {
        return 2131558782;
    }

    public long getItemId(int n10) {
        int n11;
        int n12 = this.getItemViewType(n10);
        if (n12 == (n11 = 1)) {
            return super.getItemId(n10);
        }
        return l0.c((TemplatePOJO)this.getItem(n10));
    }

    /*
     * WARNING - void declaration
     */
    public void n(e object, int n10) {
        void var5_8;
        object = (ih)((e)object).a;
        Object object2 = ((TemplatePOJO)this.getItem(n10)).getTemplateData();
        ((ih)object).z((TemplateData)object2);
        object2 = ((ih)object).d;
        Object object3 = ((TemplatePOJO)this.getItem(n10)).getTemplateData();
        boolean n11 = ((TemplateData)object3).isPrimeUsable();
        int n12 = 0;
        DownloadState downloadState = null;
        int n13 = 4;
        if (n11) {
            boolean bl2 = false;
            object3 = null;
        } else {
            int n14 = n13;
        }
        object2.setVisibility((int)var5_8);
        object2 = ((ih)object).c;
        object3 = ((TemplatePOJO)this.getItem(n10)).getTemplateData();
        boolean bl3 = ((TemplateData)object3).isFirstLoaded();
        if (!bl3) {
            n12 = n13;
        }
        object2.setVisibility(n12);
        object2 = new h(this, n10);
        ((ih)object).b.setOnClickListener((View.OnClickListener)object2);
        object3 = ((TemplatePOJO)this.getItem(n10)).getDownloadEvent();
        if (object3 != null && (object3 = DownloadState.DOWNLOADING) == (downloadState = ((TemplatePOJO)this.getItem(n10)).getDownloadEvent().getDownloadState())) {
            object3 = ((ih)object).e;
            DownloadEvent downloadEvent = ((TemplatePOJO)this.getItem(n10)).getDownloadEvent();
            n10 = downloadEvent.getProgress();
            ((RingProgressBar)((Object)object3)).setProgress(n10);
        } else {
            RingProgressBar ringProgressBar = ((ih)object).e;
            int n15 = -1;
            ringProgressBar.setProgress(n15);
        }
        ((ih)object).e.setOnClickListener((View.OnClickListener)object2);
    }

    public boolean v(TemplatePOJO templatePOJO, TemplatePOJO templatePOJO2) {
        return false;
    }

    public boolean w(TemplatePOJO templatePOJO, TemplatePOJO templatePOJO2) {
        long l10;
        long l11 = l0.c(templatePOJO);
        long l12 = l11 - (l10 = l0.c(templatePOJO2));
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 1;
        } else {
            object = 0;
            templatePOJO = null;
        }
        return (boolean)object;
    }

    public /* synthetic */ void y(int n10, View view) {
        this.x(n10, view);
    }

    public void z(b b10) {
        this.j = b10;
    }
}

