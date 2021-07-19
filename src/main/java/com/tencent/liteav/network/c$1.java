/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.c;
import java.util.ArrayList;
import org.json.JSONObject;

public class c$1
extends Thread {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ c c;

    public c$1(c c10, String string2, String string3, int n10) {
        this.c = c10;
        this.a = string3;
        this.b = n10;
        super(string2);
    }

    /*
     * Unable to fully structure code
     */
    public void run() {
        var1_1 = "use";
        var2_2 = this.c.a;
        if (var2_2 == null) {
            return;
        }
        var2_2 = new ArrayList();
        var3_3 = 7;
        for (var4_4 = 0; var4_4 < var3_3; ++var4_4) {
            block17: {
                var5_5 = 5;
                var6_6 = "TXCIntelligentRoute";
                var7_7 = var4_4 < var5_5 ? "https://tcdns.myqcloud.com/queryip" : "https://tcdnsipv6.myqcloud.com/queryip";
                var8_9 = this.c;
                var9_11 = this.a;
                var10_12 = this.b;
                var7_7 = com.tencent.liteav.network.c.a((c)var8_9, var9_11, var10_12, var7_7);
                var8_9 = new JSONObject(var7_7);
                var11_13 = var8_9.has(var1_1);
                if (!var11_13) ** GOTO lbl33
                try {
                    var12_14 = var8_9.getInt(var1_1);
                    if (var12_14 == 0) {
                        break;
                    }
                    ** GOTO lbl33
                }
                catch (Exception var8_10) {
                    var9_11 = "get value from json failed.";
                    TXCLog.e(var6_6, var9_11, var8_10);
lbl33:
                    // 3 sources

                    var8_9 = this.c;
                }
                var2_2 = com.tencent.liteav.network.c.a((c)var8_9, var7_7);
                if (var2_2 == null) break block17;
                var5_5 = var2_2.size();
                if (var5_5 > 0) break;
            }
            var13_15 = 1000L;
            Thread.sleep(var13_15, 0);
            continue;
            {
                catch (Exception var7_8) {
                    var8_9 = "get json string failed.";
                    TXCLog.e(var6_6, (String)var8_9, var7_8);
                }
            }
        }
        this.c.a.onFetchDone(0, (ArrayList)var2_2);
    }
}

