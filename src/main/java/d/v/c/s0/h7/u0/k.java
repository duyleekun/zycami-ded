/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.ImageView
 */
package d.v.c.s0.h7.u0;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import com.zhiyun.cama.camera.story.track.TrackDescriptionBean;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.TemEditorConfig$SmartType;
import com.zhiyun.image.Images;
import d.v.c.n0.c;
import d.v.c.n0.e;
import d.v.c.s0.h7.u0.g;
import d.v.c.s0.h7.u0.k$a;
import d.v.c.w0.uh;
import d.v.f.f.b;

public class k
extends c {
    private static final int d = 1;
    private int b = 0;
    private b c;

    private /* synthetic */ void g(int n10, TrackDescriptionBean trackDescriptionBean, View view) {
        b b10 = this.c;
        if (b10 != null) {
            b10.a(view, n10, trackDescriptionBean);
        }
        this.j(n10);
    }

    public int a(int n10) {
        int n11 = 1;
        if (n11 == n10) {
            return 2131558784;
        }
        return 2131558788;
    }

    public void b(e object, int n10) {
        Object object2;
        g g10;
        int n11 = 1;
        int n12 = this.getItemViewType(n10);
        if (n11 == n12) {
            return;
        }
        object = (uh)((e)object).a;
        TrackDescriptionBean trackDescriptionBean = (TrackDescriptionBean)this.getItem(n10);
        int n13 = this.b;
        if (n13 != n10) {
            n11 = 0;
            g10 = null;
        }
        ((uh)object).a.setSelected(n11 != 0);
        n13 = 0;
        Object object3 = null;
        if (trackDescriptionBean != null && (object2 = trackDescriptionBean.getIcon()) != null) {
            object3 = trackDescriptionBean.getIcon().getNormal();
            object3 = this.e((String)object3);
            object2 = trackDescriptionBean.getIcon().getSelected();
            object2 = this.e((String)object2);
        } else {
            object2 = null;
        }
        boolean bl2 = TextUtils.isEmpty(object3);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
            ImageView imageView = ((uh)object).a;
            if (n11 != 0) {
                object3 = object2;
            }
            Images.e(imageView, object3);
        } else {
            object3 = ((uh)object).a;
            n11 = n11 != 0 ? 2131231688 : 2131231687;
            object3.setImageResource(n11);
        }
        object = ((uh)object).a;
        g10 = new g(this, n10, trackDescriptionBean);
        object.setOnClickListener((View.OnClickListener)g10);
    }

    public String e(String string2) {
        return TemEditorConfig.c(TemEditorConfig$SmartType.SMART_DIY_TRACK, string2);
    }

    public GridLayoutManager f(Context object, int n10) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager((Context)object, n10);
        object = new k$a(this, n10);
        gridLayoutManager.setSpanSizeLookup((GridLayoutManager$SpanSizeLookup)object);
        return gridLayoutManager;
    }

    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    public int getItemViewType(int n10) {
        int n11 = this.getItemCount();
        int n12 = 1;
        if (n10 == (n11 -= n12)) {
            return n12;
        }
        return super.getItemViewType(n10);
    }

    public /* synthetic */ void h(int n10, TrackDescriptionBean trackDescriptionBean, View view) {
        this.g(n10, trackDescriptionBean, view);
    }

    public void i(b b10) {
        this.c = b10;
    }

    public void j(int n10) {
        this.b = n10;
        b b10 = this.c;
        if (b10 != null) {
            Object object = this.getItem(n10);
            b10.a(null, n10, object);
        }
        this.notifyDataSetChanged();
    }
}

