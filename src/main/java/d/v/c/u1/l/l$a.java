/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Size
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package d.v.c.u1.l;

import android.content.Context;
import android.util.Size;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.zhiyun.cama.template.PlayLayout;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import d.v.c.u1.j;
import d.v.c.u1.l.l;
import m.a.a;

public class l$a
implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ TemplateData a;
    public final /* synthetic */ l b;

    public l$a(l l10, TemplateData templateData) {
        this.b = l10;
        this.a = templateData;
    }

    public boolean onPreDraw() {
        int n10;
        l.w(this.b).getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        int n11 = l.w(this.b).getHeight();
        int n12 = l.x(this.b).getHeight();
        Object object = (ViewGroup.MarginLayoutParams)l.x(this.b).getLayoutParams();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("totalHeight:");
        charSequence.append(n11);
        charSequence.append(",infoHeight:");
        charSequence.append(n12);
        charSequence.append(",marginLayoutParams.bottomMargin\uff1a");
        int n13 = object.bottomMargin;
        charSequence.append(n13);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b((String)charSequence, objectArray);
        n11 -= n12;
        n12 = object.bottomMargin;
        Object object2 = this.b.requireContext();
        object = this.a.getVideoRatio();
        Size size = j.a((Context)object2, n11 -= n12, (String)object);
        object2 = l.y(this.b).getLayoutParams();
        ((ViewGroup.LayoutParams)object2).height = n10 = size.getHeight();
        ((ViewGroup.LayoutParams)object2).width = n10 = size.getWidth();
        l.y(this.b).setLayoutParams((ViewGroup.LayoutParams)object2);
        object2 = l.y(this.b);
        object = this.a.getCoverUrl();
        ((PlayLayout)((Object)object2)).w(size, (String)object);
        return false;
    }
}

