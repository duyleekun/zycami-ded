/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVObject$7$1;
import cn.leancloud.AVUser;
import cn.leancloud.core.PaasClient;
import cn.leancloud.core.StorageClient;
import cn.leancloud.json.JSONArray$Builder;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import e.a.e0;
import e.a.v0.o;
import e.a.z;
import java.util.Collection;
import java.util.List;

public final class AVObject$7
implements o {
    public final /* synthetic */ AVUser val$asAuthenticatedUser;
    public final /* synthetic */ Collection val$objects;

    public AVObject$7(AVUser aVUser, Collection collection) {
        this.val$asAuthenticatedUser = aVUser;
        this.val$objects = collection;
    }

    public e0 apply(List object) {
        boolean bl2;
        boolean bl3;
        Object object2 = AVObject.logger;
        Object object3 = "begin to save objects with batch mode...";
        ((AVLogger)object2).d((String)object3);
        if (object != null && !(bl3 = object.isEmpty())) {
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                object2 = (AVFile)object.next();
                object3 = this.val$asAuthenticatedUser;
                ((AVFile)object2).save((AVUser)object3);
            }
        }
        object = null;
        object2 = JSONArray$Builder.create(null);
        object3 = this.val$objects.iterator();
        while (bl2 = object3.hasNext()) {
            Object object4 = (AVObject)object3.next();
            JSONObject jSONObject = ((AVObject)object4).generateChangedParam();
            JSONObject jSONObject2 = JSONObject$Builder.create(null);
            String string2 = ((AVObject)object4).getRequestMethod();
            String string3 = "method";
            jSONObject2.put(string3, string2);
            object4 = ((AVObject)object4).getRequestRawEndpoint();
            string2 = "path";
            jSONObject2.put(string2, object4);
            object4 = "body";
            jSONObject2.put(object4, jSONObject);
            object2.add(jSONObject2);
        }
        object = JSONObject$Builder.create(null);
        object.put("requests", object2);
        object2 = PaasClient.getStorageClient();
        object3 = this.val$asAuthenticatedUser;
        object = ((StorageClient)object2).batchSave((AVUser)object3, (JSONObject)object);
        object2 = new AVObject$7$1(this);
        return ((z)object).H3((o)object2);
    }
}

