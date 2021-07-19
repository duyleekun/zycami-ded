/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.webkit.URLUtil
 */
package com.zhiyun.cama.publish;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.zhiyun.cama.data.PublishState;
import com.zhiyun.cama.data.api.entity.IntegerEntity;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.data.me.PublishLogManager$ReasonCode;
import com.zhiyun.cama.publish.PublishFragment;
import com.zhiyun.editorinterface.compose.ComposeParams$Resolution;
import d.v.a.f.b.a;
import d.v.c.n1.j2;
import d.v.c.v0.u.y;
import d.v.e.l.s1;
import d.v.f.i.g;
import java.util.List;

public class PublishFragment$d
extends a {
    public final /* synthetic */ PublishFragment a;

    public PublishFragment$d(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    /*
     * WARNING - void declaration
     */
    public void a(IntegerEntity integerEntity) {
        void var4_9;
        boolean bl2;
        Object object;
        boolean bl3;
        PublishFragment$d publishFragment$d = this;
        PublishFragment.l(this.a);
        Object object2 = PublishFragment.v(this.a).u();
        boolean n10 = TextUtils.isEmpty((CharSequence)object2);
        if (!n10 && !(bl3 = TextUtils.isEmpty((CharSequence)(object = s1.H((String)object2))))) {
            object2 = object;
        }
        if (!(bl3 = URLUtil.isHttpsUrl((String)(object = PublishFragment.v(publishFragment$d.a).R()))) && !(bl2 = URLUtil.isHttpUrl((String)object))) {
            object = "0";
        } else {
            object2 = PublishFragment.v(publishFragment$d.a).R();
            object = "1";
        }
        String string2 = object2;
        String string3 = object;
        object = integerEntity;
        int n11 = integerEntity.id;
        String string4 = PublishFragment.v(publishFragment$d.a).o();
        String string5 = PublishFragment.v(publishFragment$d.a).t();
        String string6 = PublishFragment.m((PublishFragment)publishFragment$d.a).d.getText().toString();
        PublishState publishState = PublishState.STATE_NONE;
        object = PublishFragment.m((PublishFragment)publishFragment$d.a).a;
        boolean bl4 = object.isChecked();
        object = bl4 ? PublishFragment.v(publishFragment$d.a).m() : "";
        Object object3 = object;
        String string7 = PublishFragment.v(publishFragment$d.a).n();
        int n12 = PublishFragment.v(publishFragment$d.a).A();
        List list = PublishFragment.v(publishFragment$d.a).P();
        Object object4 = object2;
        object2 = new PublishWorks(n11, string2, string4, string5, string6, publishState, (String)object3, false, string7, n12, list, string3);
        object = PublishFragment.v(publishFragment$d.a).p();
        ((PublishWorks)object2).setDevices((List)object);
        object = PublishFragment.v(publishFragment$d.a).H();
        if (object != null && (object = PublishFragment.v(publishFragment$d.a).H()) != (object4 = ComposeParams$Resolution.RESOLUTION_ORIGINAL)) {
            object = PublishFragment.v(publishFragment$d.a).H();
            int n13 = ((ComposeParams$Resolution)((Object)object)).getHeight();
        } else {
            boolean bl5 = false;
            object = null;
        }
        ((PublishWorks)object2).setResolution((int)var4_9);
        object = PublishFragment.v(publishFragment$d.a);
        boolean bl6 = ((j2)object).L();
        if (bl6) {
            int n14 = 1;
            ((PublishWorks)object2).setShareToKwai(n14);
            object = PublishFragment.v(publishFragment$d.a).y();
            ((PublishWorks)object2).setKwaiToken((String)object);
        }
        PublishFragment.n(publishFragment$d.a, (PublishWorks)object2);
    }

    public void onError(Throwable object, int n10, String string2) {
        PublishFragment.l(this.a);
        Object object2 = PublishFragment.m((PublishFragment)this.a).h;
        int n11 = 1;
        object2.setEnabled(n11 != 0);
        int n12 = 10184;
        if (n10 == n12) {
            return;
        }
        object2 = PublishFragment.v(this.a);
        Object object3 = this.a.requireContext();
        int n13 = 2131952518;
        object3 = g.m(object3, n13);
        ((j2)object2).t0((String)object3);
        string2 = d.v.a.f.b.a.fromErrCodeToMessage(this.a.requireContext(), n10, string2);
        object2 = g.m(this.a.requireContext(), 2131952792);
        n11 = -1;
        if (n10 == n11) {
            if (object != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object2);
                object = ((Throwable)object).toString();
                stringBuilder.append((String)object);
                object2 = stringBuilder.toString();
            }
            object = PublishLogManager$ReasonCode.NETWORK_ERROR;
            y.x((String)object2, (PublishLogManager$ReasonCode)((Object)object));
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            PublishLogManager$ReasonCode publishLogManager$ReasonCode = PublishLogManager$ReasonCode.API_FAILED;
            y.x((String)object, publishLogManager$ReasonCode);
        }
    }
}

