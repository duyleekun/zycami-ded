/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Handler
 *  android.view.View
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api$ApiOptions$HasOptions;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClient$ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient$OnConnectionFailedListener;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class HuaweiApiClient$Builder {
    private final Context a;
    private final List b;
    private final List c;
    private final Map d;
    private HuaweiApiClient$OnConnectionFailedListener e;
    private HuaweiApiClient$ConnectionCallbacks f;
    private int g;
    private Activity h;

    public HuaweiApiClient$Builder(Context context) {
        Context context2 = new ArrayList();
        this.b = context2;
        context2 = new ArrayList();
        this.c = context2;
        this.d = context2;
        Checker.checkNonNull(context, "context must not be null.");
        this.a = context2 = context.getApplicationContext();
        this.g = -1;
        ResourceLoaderUtil.setmContext(context2);
        this.a(context);
    }

    private void a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    private void a(HuaweiApiClient object) {
        Object object2 = AutoLifecycleFragment.getInstance(this.h);
        if (object2 == null) {
            object = "HuaweiApiClient.builder";
            object2 = "lifecycleFragment must not be NULL here";
            HMSLog.e((String)object, (String)object2);
        } else {
            int n10 = this.g;
            object2.startAutoMange(n10, (HuaweiApiClient)object);
        }
    }

    public HuaweiApiClient$Builder addApi(Api object) {
        Object object2 = this.d;
        CharSequence charSequence = null;
        object2.put(object, null);
        object = ((Api)object).getApiName();
        object2 = "HuaweiGame.API";
        boolean bl2 = ((String)object2).equals(object);
        if (bl2) {
            object = HiAnalyticsUtil.getInstance();
            object2 = this.a.getApplicationContext();
            charSequence = new StringBuilder();
            charSequence.append("|");
            long l10 = System.currentTimeMillis();
            charSequence.append(l10);
            charSequence = charSequence.toString();
            String string2 = "15060106";
            ((HiAnalyticsUtil)object).onEvent((Context)object2, string2, (String)charSequence);
        }
        return this;
    }

    public HuaweiApiClient$Builder addApi(Api object, Api$ApiOptions$HasOptions object2) {
        Checker.checkNonNull(object, "Api must not be null");
        Checker.checkNonNull(object2, "Null options are not permitted for this Api");
        this.d.put(object, object2);
        Object object3 = ((Api)object).getOptions();
        if (object3 != null) {
            object3 = ((Api)object).getOptions().getScopeList(object2);
            List list = this.b;
            list.addAll(object3);
            object = ((Api)object).getOptions().getPermissionInfoList(object2);
            object2 = this.c;
            object2.addAll(object);
        }
        return this;
    }

    public HuaweiApiClient$Builder addApiWithScope(Api list, Api$ApiOptions$HasOptions object, Scope ... scopeArray) {
        Checker.checkNonNull(list, "Api must not be null");
        Checker.checkNonNull(object, "Null options are not permitted for this Api");
        Checker.checkNonNull(scopeArray, "Scopes must not be null");
        this.d.put(list, object);
        Object object2 = ((Api)((Object)list)).getOptions();
        if (object2 != null) {
            object2 = ((Api)((Object)list)).getOptions().getScopeList(object);
            List list2 = this.b;
            list2.addAll(object2);
            list = ((Api)((Object)list)).getOptions().getPermissionInfoList(object);
            object = this.c;
            object.addAll(list);
        }
        object = Arrays.asList(scopeArray);
        list = new List(object);
        this.b.addAll(list);
        return this;
    }

    public HuaweiApiClient$Builder addApiWithScope(Api arrayList, Scope ... object) {
        Checker.checkNonNull(arrayList, "Api must not be null");
        Checker.checkNonNull(object, "Scopes must not be null");
        this.d.put(arrayList, null);
        object = Arrays.asList(object);
        arrayList = new ArrayList(object);
        this.b.addAll(arrayList);
        return this;
    }

    public HuaweiApiClient$Builder addConnectionCallbacks(HuaweiApiClient$ConnectionCallbacks huaweiApiClient$ConnectionCallbacks) {
        Checker.checkNonNull(huaweiApiClient$ConnectionCallbacks, "listener must not be null.");
        this.f = huaweiApiClient$ConnectionCallbacks;
        return this;
    }

    public HuaweiApiClient$Builder addOnConnectionFailedListener(HuaweiApiClient$OnConnectionFailedListener huaweiApiClient$OnConnectionFailedListener) {
        Checker.checkNonNull(huaweiApiClient$OnConnectionFailedListener, "listener must not be null.");
        this.e = huaweiApiClient$OnConnectionFailedListener;
        return this;
    }

    public HuaweiApiClient$Builder addScope(Scope scope) {
        Checker.checkNonNull(scope, "scope must not be null.");
        this.b.add(scope);
        return this;
    }

    public HuaweiApiClient$Builder allowLifeCycleManagement(Activity object, int n10, HuaweiApiClient$OnConnectionFailedListener huaweiApiClient$OnConnectionFailedListener) {
        if (n10 >= 0) {
            this.g = n10;
            this.h = object = (Activity)Preconditions.checkNotNull(object, "activity must not be Null.");
            return this;
        }
        object = new IllegalArgumentException("allowLifeCycleManagement id should be positive");
        throw object;
    }

    public HuaweiApiClient$Builder allowLifeCycleManagement(Activity activity, HuaweiApiClient$OnConnectionFailedListener huaweiApiClient$OnConnectionFailedListener) {
        return this.allowLifeCycleManagement(activity, 0, huaweiApiClient$OnConnectionFailedListener);
    }

    public HuaweiApiClient$Builder applyDefaultAccount() {
        return this;
    }

    public HuaweiApiClient build() {
        Object object = new Api("Core.API");
        this.addApi((Api)object);
        Object object2 = this.a;
        object = new HuaweiApiClientImpl((Context)object2);
        object2 = this.b;
        ((HuaweiApiClientImpl)object).setScopes((List)object2);
        object2 = this.c;
        ((HuaweiApiClientImpl)object).setPermissionInfos((List)object2);
        object2 = this.d;
        ((HuaweiApiClientImpl)object).setApiMap((Map)object2);
        object2 = this.f;
        ((HuaweiApiClientImpl)object).setConnectionCallbacks((HuaweiApiClient$ConnectionCallbacks)object2);
        object2 = this.e;
        ((HuaweiApiClientImpl)object).setConnectionFailedListener((HuaweiApiClient$OnConnectionFailedListener)object2);
        int n10 = this.g;
        ((HuaweiApiClientImpl)object).setAutoLifecycleClientId(n10);
        n10 = this.g;
        if (n10 >= 0) {
            this.a((HuaweiApiClient)object);
        }
        return object;
    }

    public HuaweiApiClient$Builder setAccountName(String string2) {
        return this;
    }

    public HuaweiApiClient$Builder setHandler(Handler handler) {
        return this;
    }

    public HuaweiApiClient$Builder setPopupsGravity(int n10) {
        return this;
    }

    public HuaweiApiClient$Builder setViewForPopups(View view) {
        return this;
    }
}

