/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote;

import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.data.api.entity.AliyunEntity;
import com.zhiyun.cama.data.me.remote.AliyunManager;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.c.d.d;
import java.io.IOException;
import k.r;

public class AliyunManager$1
extends OSSFederationCredentialProvider {
    public final /* synthetic */ AliyunManager this$0;

    public AliyunManager$1(AliyunManager aliyunManager) {
        this.this$0 = aliyunManager;
    }

    public OSSFederationToken getFederationToken() {
        block28: {
            Object object;
            Object object2;
            Object object3;
            block27: {
                block26: {
                    try {
                        object3 = d.F();
                    }
                    catch (IOException iOException) {
                        iOException.printStackTrace();
                        return null;
                    }
                    boolean bl2 = ((d)object3).Q();
                    object2 = "rw";
                    if (!bl2) break block26;
                    object3 = d.v.c.v0.l.d.a;
                    object = d.F();
                    object = ((d)object).K();
                    object3 = object3.b((String)object, (String)object2);
                    object3 = object3.execute();
                    object3 = ((r)object3).a();
                    object3 = (AliyunEntity)object3;
                    break block27;
                }
                object3 = d.v.c.v0.l.d.a;
                object = d.F();
                object = ((d)object).L();
                int n10 = ((UserInfo)object).getId();
                object3 = object3.f(n10, (String)object2);
                object3 = object3.execute();
                object3 = ((r)object3).a();
                object3 = (AliyunEntity)object3;
            }
            if (object3 != null) {
                int n11 = ((BaseEntity)object3).errcode;
                if (n11 != 0) break block28;
                object = ((AliyunEntity)object3).AccessKeyId;
                String string2 = ((AliyunEntity)object3).AccessKeySecret;
                String string3 = ((AliyunEntity)object3).SecurityToken;
                object3 = ((AliyunEntity)object3).Expiration;
                object2 = new OSSFederationToken((String)object, string2, string3, (String)object3);
                return object2;
            }
        }
        return null;
    }
}

