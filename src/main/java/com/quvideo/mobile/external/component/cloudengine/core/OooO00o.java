/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.quvideo.mobile.external.component.cloudengine.core;

import android.content.Context;
import android.text.TextUtils;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import com.quvideo.mobile.external.component.cloudengine.core.OooO00o$OooO0o;
import com.quvideo.mobile.external.component.cloudengine.core.OooO00o$a;
import com.quvideo.mobile.external.component.cloudengine.core.OooO00o$b;
import com.quvideo.mobile.external.component.cloudengine.core.OooO00o$c;
import com.quvideo.mobile.external.component.cloudengine.core.OooO0O0;
import com.quvideo.mobile.external.component.cloudengine.model.CloudEngineConfig;
import com.quvideo.mobile.external.component.cloudengine.model.CompositeConfig;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import com.quvideo.mobile.external.component.cloudengine.model.TemplateConfig;
import com.quvideo.mobile.external.component.cloudengine.model.VideoConfig;
import com.quvideo.mobile.external.component.cloudengine.protocal.OnTemplateListener;
import com.quvideo.mobile.external.component.cloudengine.protocal.OnVideoListener;
import com.quvideo.mobile.external.platform.api.device.OooO0OO;
import com.quvideo.mobile.external.platform.httpcore.OooO0o;
import com.quvideo.mobile.external.platform.httpcore.country.OooO;
import com.quvideo.mobile.external.platform.uploader.OooOOO;
import d.o.a.a.a.b.a.a;
import d.o.a.a.a.b.a.b;
import d.o.a.a.a.b.a.c;
import d.o.a.a.a.b.a.d;
import d.o.a.a.a.b.a.e;
import d.o.a.a.a.b.a.f;
import d.o.a.a.a.b.a.g;
import d.o.a.a.a.b.a.h;
import e.a.g0;
import e.a.h0;
import e.a.z;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class OooO00o {
    private Context OooO00o;
    private OooO00o$OooO0o OooO0O0;
    private List OooO0OO;
    private volatile CloudEngineConfig OooO0Oo;

    private OooO00o() {
        OooO00o$OooO0o oooO00o$OooO0o;
        this.OooO0O0 = oooO00o$OooO0o = OooO00o$OooO0o.IDEL;
    }

    public /* synthetic */ OooO00o(OooO00o$a a10) {
        this();
    }

    private boolean OooO() {
        OooO00o$OooO0o oooO00o$OooO0o = this.OooO0O0;
        OooO00o$OooO0o oooO00o$OooO0o2 = OooO00o$OooO0o.IDEL;
        if (oooO00o$OooO0o == oooO00o$OooO0o2) {
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0("cloudEngine", "has not been initialized!");
            return true;
        }
        return false;
    }

    private void OooO00o(String string2) {
        OooO0OO oooO0OO = com.quvideo.mobile.external.platform.api.device.OooO0OO.OooO0O0();
        d d10 = new d(this);
        oooO0OO.OooO00o(string2, d10);
    }

    private /* synthetic */ void OooO00o(List list) {
        this.OooO0O0(list);
    }

    private /* synthetic */ void OooO00o(boolean bl2) {
        boolean bl3;
        Object object = bl2 ? OooO00o$OooO0o.SUCCESS : OooO00o$OooO0o.FAILURE;
        this.OooO0O0 = object;
        object = this.OooO0OO.iterator();
        while (bl3 = object.hasNext()) {
            h h10 = (h)object.next();
            h10.OooO00o();
        }
        this.OooO0OO.clear();
        object = "cloudEngine";
        if (!bl2) {
            String string2 = "init failed: something terrible occurred, please contact Quvideo.";
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0((String)object, string2);
        } else {
            String string3 = "init success.";
            com.quvideo.mobile.external.platform.log.OooO00o.OooO00o((String)object, string3);
        }
    }

    private static /* synthetic */ com.quvideo.mobile.external.platform.httpcore.provider.OooO0OO OooO0O0(String object) {
        object = new com.quvideo.mobile.external.platform.httpcore.provider.OooO0OO();
        Object object2 = new OooO0o();
        ((com.quvideo.mobile.external.platform.httpcore.provider.OooO0OO)object).OooO00o((OooO0o)object2);
        object2 = com.quvideo.mobile.external.platform.api.device.OooO0OO.OooO0O0().OooO0Oo();
        ((com.quvideo.mobile.external.platform.httpcore.provider.OooO0OO)object).OooO00o((String)object2);
        object2 = com.quvideo.mobile.external.platform.api.device.OooO0OO.OooO0O0().OooO0OO();
        ((com.quvideo.mobile.external.platform.httpcore.provider.OooO0OO)object).OooO0O0((String)object2);
        return object;
    }

    private /* synthetic */ void OooO0O0(CompositeConfig compositeConfig, OnCompositeListener onCompositeListener) {
        this.OooO00o(compositeConfig, onCompositeListener);
    }

    private /* synthetic */ void OooO0O0(TemplateConfig templateConfig, OnTemplateListener onTemplateListener) {
        this.OooO00o(templateConfig, onTemplateListener);
    }

    private /* synthetic */ void OooO0O0(VideoConfig videoConfig, OnVideoListener onVideoListener) {
        this.OooO00o(videoConfig, onVideoListener);
    }

    private boolean OooO0O0() {
        Object object = this.OooO0O0;
        OooO00o$OooO0o oooO00o$OooO0o = OooO00o$OooO0o.FAILURE;
        if (object == oooO00o$OooO0o) {
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0("cloudEngine", "something horrible occurred, please check has not been initialized successfully!");
            this.OooO0O0 = object = OooO00o$OooO0o.INITING;
            object = this.OooO0o0();
            this.OooO00o((String)object);
            return true;
        }
        return false;
    }

    public static OooO00o OooO0OO() {
        return OooO00o$c.a();
    }

    private void OooO0OO(List list) {
        com.quvideo.mobile.external.platform.api.cloudengine.OooO0O0.OooO00o(list).a();
    }

    private String OooO0Oo() {
        boolean bl2;
        Object object = this.OooO0Oo;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.OooO0Oo.getCountryCode())))) {
            return this.OooO0Oo.getCountryCode();
        }
        return OooO.OooO00o().OooO0O0();
    }

    private String OooO0o() {
        return com.quvideo.mobile.external.platform.api.device.OooO0OO.OooO0O0().OooO0Oo();
    }

    private String OooO0o0() {
        return com.quvideo.mobile.external.platform.api.device.OooO0OO.OooO0O0().OooO0OO();
    }

    /*
     * Enabled aggressive block sorting
     */
    private String OooO0oO() {
        String string2;
        boolean bl2;
        Object object = this.OooO0Oo;
        String string3 = "_";
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.OooO0Oo.getLanguageCode())))) {
            object = new StringBuilder();
            string2 = this.OooO0Oo.getLanguageCode();
        } else {
            object = new StringBuilder();
            string2 = Locale.getDefault().getLanguage();
        }
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(string3);
        string3 = this.OooO0Oo();
        ((StringBuilder)object).append(string3);
        return ((StringBuilder)object).toString();
    }

    private boolean OooO0oo() {
        boolean bl2;
        OooO00o$OooO0o oooO00o$OooO0o;
        Object object = this.OooO0o();
        if (object != null && (object = this.OooO0o0()) != null && (object = this.OooO0O0) != (oooO00o$OooO0o = OooO00o$OooO0o.INITING)) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static /* synthetic */ void a(OooO00o oooO00o, TemplateConfig templateConfig, OnTemplateListener onTemplateListener) {
        oooO00o.OooO0O0(templateConfig, onTemplateListener);
    }

    public static /* synthetic */ void b(OooO00o oooO00o, List list) {
        oooO00o.OooO00o(list);
    }

    public static /* synthetic */ void c(OooO00o oooO00o, VideoConfig videoConfig, OnVideoListener onVideoListener) {
        oooO00o.OooO0O0(videoConfig, onVideoListener);
    }

    public static /* synthetic */ void d(OooO00o oooO00o, boolean bl2) {
        oooO00o.OooO00o(bl2);
    }

    public static /* synthetic */ com.quvideo.mobile.external.platform.httpcore.provider.OooO0OO e(String string2) {
        return com.quvideo.mobile.external.component.cloudengine.core.OooO00o.OooO0O0(string2);
    }

    public static /* synthetic */ void f(OooO00o oooO00o, CompositeConfig compositeConfig, OnCompositeListener onCompositeListener) {
        oooO00o.OooO0O0(compositeConfig, onCompositeListener);
    }

    public void OooO00o() {
        boolean bl2 = this.OooO();
        if (bl2) {
            return;
        }
        com.quvideo.mobile.external.component.cloudcomposite.OooO00o.OooO00o();
    }

    public void OooO00o(Context object, CloudEngineConfig object2) {
        Object object3 = this.OooO0O0;
        Object object4 = OooO00o$OooO0o.IDEL;
        String string2 = "cloudEngine";
        if (object3 != object4) {
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(string2, "has already initialized!");
            return;
        }
        object3 = OooO00o$OooO0o.INITING;
        this.OooO0O0 = object3;
        object3 = "init failed: config & context can't be null!";
        if (object2 != null && object != null) {
            String string3;
            boolean bl2;
            object4 = object.getApplicationContext();
            this.OooO00o = object4;
            object4 = ((CloudEngineConfig)object2).getAppKey();
            if (!(object4 == null || (bl2 = (string3 = "").equals(object4 = ((CloudEngineConfig)object2).getAppKey())) || (object4 = ((CloudEngineConfig)object2).getAppSecret()) == null || (bl2 = string3.equals(object4 = ((CloudEngineConfig)object2).getAppSecret())) || (object4 = ((CloudEngineConfig)object2).getUserId()) == null || (bl2 = string3.equals(object4 = ((CloudEngineConfig)object2).getUserId())))) {
                boolean bl3;
                object3 = new CopyOnWriteArrayList();
                this.OooO0OO = object3;
                try {
                    object3 = ((CloudEngineConfig)object2).getAppKey();
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(string2, "init failed: appKey & appSecret are't available!");
                    object = OooO00o$OooO0o.FAILURE;
                    this.OooO0O0 = object;
                    return;
                }
                object4 = ((CloudEngineConfig)object2).getAppSecret();
                string3 = "1.3.0";
                object3 = com.quvideo.mobile.external.component.cloudengine.utils.OooO0O0.OooO00o((String)object3, (String)object4, string3);
                this.OooO0Oo = object2;
                object4 = new com.quvideo.mobile.external.platform.httpcore.provider.OooO0O0();
                ((com.quvideo.mobile.external.platform.httpcore.provider.OooO0O0)object4).OooO0OO = string2 = ((com.quvideo.mobile.external.component.cloudengine.utils.OooO00o)object3).OooO00o();
                ((com.quvideo.mobile.external.platform.httpcore.provider.OooO0O0)object4).OooO0Oo = object3 = ((com.quvideo.mobile.external.component.cloudengine.utils.OooO00o)object3).OooO0O0();
                ((com.quvideo.mobile.external.platform.httpcore.provider.OooO0O0)object4).OooO00o = bl3 = ((CloudEngineConfig)object2).isDebug();
                com.quvideo.mobile.external.platform.log.OooO00o.OooO00o(((CloudEngineConfig)object2).isDebug());
                com.quvideo.mobile.external.platform.httpcore.OooO.OooO00o(object.getApplicationContext(), (com.quvideo.mobile.external.platform.httpcore.provider.OooO0O0)object4);
                com.quvideo.mobile.external.platform.httpcore.OooO.OooO00o(e.a);
                OooO.OooO00o().OooO0Oo();
                object2 = ((CloudEngineConfig)object2).getUserId();
                this.OooO00o((String)object2);
                object2 = g.c();
                OooOOO.OooO00o(object, (com.quvideo.mobile.external.platform.uploader.listener.OooO00o)object2);
                object2 = g.a();
                object3 = g.b();
                com.quvideo.mobile.external.component.cloudcomposite.OooO00o.OooO00o(object, (com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o)object2, (com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO0O0)object3);
                return;
            }
            com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(string2, (String)object3);
            object = OooO00o$OooO0o.FAILURE;
            this.OooO0O0 = object;
            return;
        }
        com.quvideo.mobile.external.platform.log.OooO00o.OooO0O0(string2, (String)object3);
        object = OooO00o$OooO0o.FAILURE;
        this.OooO0O0 = object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void OooO00o(CompositeConfig object, OnCompositeListener onCompositeListener) {
        Object object2;
        block6: {
            block5: {
                boolean bl2;
                block4: {
                    bl2 = this.OooO();
                    object2 = null;
                    if (!bl2) break block4;
                    String string2 = com.quvideo.mobile.external.component.cloudengine.core.OooO0O0.OooO0Oo;
                    int n10 = com.quvideo.mobile.external.component.cloudengine.core.OooO0O0.OooO0OO;
                    object = new RequestError(string2, n10);
                    break block5;
                }
                bl2 = this.OooO0O0();
                if (bl2 || (bl2 = this.OooO0oo())) break block6;
                Context context = this.OooO00o;
                List list = ((CompositeConfig)object).getLocalMedia();
                bl2 = com.quvideo.mobile.external.component.cloudengine.utils.OooO0OO.OooO00o(context, list);
                if (bl2) {
                    String string3 = this.OooO0Oo();
                    object2 = this.OooO0oO();
                    object = ((CompositeConfig)object).toCompositeConfig(string3, (String)object2);
                    com.quvideo.mobile.external.component.cloudcomposite.OooO00o.OooO00o((com.quvideo.mobile.external.component.cloudcomposite.core.OooO0o)object, onCompositeListener);
                    return;
                }
                String string4 = com.quvideo.mobile.external.component.cloudengine.core.OooO0O0.OooO0O0;
                int n11 = com.quvideo.mobile.external.component.cloudengine.core.OooO0O0.OooO00o;
                object = new RequestError(string4, n11);
            }
            OnCompositeListener$State onCompositeListener$State = OnCompositeListener$State.IDEL;
            onCompositeListener.onFailure(null, (RequestError)object, onCompositeListener$State, false);
            return;
        }
        List list = this.OooO0OO;
        object2 = new f(this, (CompositeConfig)object, onCompositeListener);
        list.add(object2);
    }

    public void OooO00o(TemplateConfig object, OnTemplateListener onTemplateListener) {
        boolean bl2 = this.OooO();
        if (bl2) {
            String string2 = com.quvideo.mobile.external.component.cloudengine.core.OooO0O0.OooO0Oo;
            int n10 = com.quvideo.mobile.external.component.cloudengine.core.OooO0O0.OooO0OO;
            object = new RequestError(string2, n10);
            onTemplateListener.onFailure((RequestError)object);
            return;
        }
        bl2 = this.OooO0O0();
        if (!bl2 && !(bl2 = this.OooO0oo())) {
            Object object2 = new JSONObject();
            String string3 = "country";
            String string4 = this.OooO0Oo();
            object2.put(string3, (Object)string4);
            string3 = "lang";
            string4 = this.OooO0oO();
            object2.put(string3, (Object)string4);
            string3 = "pageSize";
            int n11 = ((TemplateConfig)object).getPageSize();
            object2.put(string3, n11);
            string3 = "pageNum";
            int n12 = ((TemplateConfig)object).getPageNum();
            try {
                object2.put(string3, n12);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            object = com.quvideo.mobile.external.platform.api.template.OooO0O0.OooO00o(object2);
            object2 = e.a.q0.c.a.c();
            object = ((z)object).i4((h0)object2);
            object2 = new OooO00o$a(this, onTemplateListener);
            ((z)object).subscribe((g0)object2);
        } else {
            List list = this.OooO0OO;
            a a10 = new a(this, (TemplateConfig)object, onTemplateListener);
            list.add(a10);
        }
    }

    public void OooO00o(VideoConfig object, OnVideoListener onVideoListener) {
        int n10 = this.OooO();
        if (n10 != 0) {
            String string2 = com.quvideo.mobile.external.component.cloudengine.core.OooO0O0.OooO0Oo;
            int n11 = com.quvideo.mobile.external.component.cloudengine.core.OooO0O0.OooO0OO;
            object = new RequestError(string2, n11);
            onVideoListener.onFailure((RequestError)object);
            return;
        }
        n10 = this.OooO0O0();
        if (n10 == 0 && (n10 = this.OooO0oo()) == 0) {
            n10 = ((VideoConfig)object).getPageSize();
            int n12 = ((VideoConfig)object).getPageNum();
            boolean bl2 = false;
            Object var7_10 = null;
            object = com.quvideo.mobile.external.component.cloudcomposite.OooO00o.OooO00o(n10, n12, 0);
            Object object2 = e.a.q0.c.a.c();
            object = ((z)object).i4((h0)object2);
            object2 = new OooO00o$b(this, onVideoListener);
            ((z)object).subscribe((g0)object2);
        } else {
            List list = this.OooO0OO;
            c c10 = new c(this, (VideoConfig)object, onVideoListener);
            list.add(c10);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void OooO0O0(List list) {
        int n10 = this.OooO();
        if (n10 != 0) {
            return;
        }
        n10 = this.OooO0O0();
        if (n10 == 0 && (n10 = this.OooO0oo()) == 0) {
            int n11;
            if (list == null || (n10 = list.size()) <= 0) return;
            n10 = list.size();
            if (n10 <= (n11 = 100)) {
                this.OooO0OO(list);
                return;
            }
            n10 = 0;
            Object var4_4 = null;
            while (true) {
                int n12 = n10 * 100;
                int n13 = ++n10 * 100;
                int n14 = list.size();
                n13 = Math.min(n13, n14);
                n14 = list.size();
                if (n12 >= n14) return;
                List list2 = list.subList(n12, n13);
                this.OooO0OO(list2);
            }
        }
        List list3 = this.OooO0OO;
        b b10 = new b(this, list);
        list3.add(b10);
    }
}

