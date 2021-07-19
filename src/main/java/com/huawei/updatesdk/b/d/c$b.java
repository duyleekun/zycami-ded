/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 */
package com.huawei.updatesdk.b.d;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.updatesdk.a.b.a.a;
import com.huawei.updatesdk.b.d.b;
import com.huawei.updatesdk.b.d.c;
import com.huawei.updatesdk.b.d.c$a;
import com.huawei.updatesdk.b.d.e;

public class c$b
extends Handler {
    private c$b() {
    }

    public /* synthetic */ c$b(c$a c$a) {
        this();
    }

    public void handleMessage(Message object) {
        block4: {
            com.huawei.updatesdk.a.b.b.b b10;
            Intent intent;
            Object object2;
            block1: {
                Object object3;
                block2: {
                    block3: {
                        super.handleMessage((Message)object);
                        object2 = ((Message)object).obj;
                        boolean bl2 = object2 instanceof b;
                        if (!bl2) {
                            return;
                        }
                        object2 = (b)object2;
                        intent = new Intent();
                        b10 = com.huawei.updatesdk.a.b.b.b.a(intent);
                        int n10 = ((Message)object).what;
                        int n11 = 2;
                        if (n10 == n11) break block1;
                        n11 = 3;
                        if (n10 == n11) break block2;
                        n11 = 4;
                        if (n10 == n11) break block3;
                        int n12 = 5;
                        if (n10 == n12) break block2;
                        break block4;
                    }
                    object3 = a.c().a();
                    CharSequence charSequence = new StringBuilder();
                    String string2 = c.c();
                    charSequence.append(string2);
                    string2 = "/appmarket.apk";
                    charSequence.append(string2);
                    charSequence = charSequence.toString();
                    object2 = ((b)object2).c();
                    e.a(object3, (String)charSequence, (String)object2);
                }
                object2 = new Bundle();
                int n13 = ((Message)object).what;
                object3 = "download_status_param";
                object2.putInt((String)object3, n13);
                intent.putExtras((Bundle)object2);
                object = com.huawei.updatesdk.b.f.c.b();
                ((com.huawei.updatesdk.b.f.c)object).b(b10);
                break block4;
            }
            long l10 = ((b)object2).e();
            intent.putExtra("download_apk_size", l10);
            l10 = ((b)object2).a();
            intent.putExtra("download_apk_already", l10);
            object = com.huawei.updatesdk.b.f.c.b();
            ((com.huawei.updatesdk.b.f.c)object).a(b10);
        }
    }
}

