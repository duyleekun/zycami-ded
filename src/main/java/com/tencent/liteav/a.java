/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.module.TXCStatus;
import java.util.ArrayList;

public class a {
    public static void a(String object, ArrayList object2) {
        boolean bl2;
        StatusBucket statusBucket = TXCAudioEngine.getInstance().getStatus(1);
        Object object3 = "18446744073709551615";
        Integer n10 = statusBucket.getIntStatus((String)object3, 10001);
        TXCStatus.a((String)object, 14003, n10);
        n10 = statusBucket.getIntStatus((String)object3, 10002);
        TXCStatus.a((String)object, 8005, n10);
        n10 = statusBucket.getIntStatus((String)object3, 10000);
        TXCStatus.a((String)object, 14017, n10);
        n10 = statusBucket.getIntStatus((String)object3, 10003);
        TXCStatus.a((String)object, 14002, n10);
        n10 = statusBucket.getIntStatus((String)object3, 10004);
        TXCStatus.a((String)object, 14006, n10);
        n10 = statusBucket.getIntStatus((String)object3, 10005);
        int n11 = 14018;
        TXCStatus.a((String)object, n11, n10);
        int n12 = statusBucket.getIntStatus((String)object3, 10006);
        object3 = n12;
        int n13 = 18029;
        TXCStatus.a((String)object, n13, object3);
        if (object2 == null) {
            return;
        }
        object = ((ArrayList)object2).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            n12 = statusBucket.getIntStatus((String)object2, 10114);
            n13 = statusBucket.getIntStatus((String)object2, 10115);
            Integer n14 = n12;
            TXCStatus.a((String)object2, 18031, n14);
            n14 = n13;
            TXCStatus.a((String)object2, 18032, n14);
            n11 = 0;
            Integer n15 = null;
            if (n13 > 0) {
                n12 /= n13;
            } else {
                n12 = 0;
                object3 = null;
            }
            object3 = n12;
            TXCStatus.a((String)object2, 2001, object3);
            n14 = n13;
            TXCStatus.a((String)object2, 2002, n14);
            n10 = n13;
            TXCStatus.a((String)object2, 2005, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10300);
            TXCStatus.a((String)object2, 2004, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10301);
            TXCStatus.a((String)object2, 2034, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10302);
            TXCStatus.a((String)object2, 2035, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10303);
            TXCStatus.a((String)object2, 2014, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10112);
            TXCStatus.a((String)object2, 2008, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10106);
            TXCStatus.a((String)object2, 2010, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10105);
            TXCStatus.a((String)object2, 2007, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10107);
            TXCStatus.a((String)object2, 2011, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10103);
            TXCStatus.a((String)object2, 18001, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10104);
            TXCStatus.a((String)object2, 18002, n10);
            n13 = 10202;
            n14 = statusBucket.getIntStatus((String)object2, n13);
            TXCStatus.a((String)object2, 18006, n14);
            int n16 = 10203;
            Integer n17 = statusBucket.getIntStatus((String)object2, n16);
            TXCStatus.a((String)object2, 18007, n17);
            n17 = statusBucket.getIntStatus((String)object2, 10204);
            TXCStatus.a((String)object2, 18008, n17);
            n17 = statusBucket.getIntStatus((String)object2, 10205);
            TXCStatus.a((String)object2, 18015, n17);
            int n18 = statusBucket.getIntStatus((String)object2, 10206);
            n17 = n18;
            TXCStatus.a((String)object2, 18013, n17);
            n12 = statusBucket.getIntStatus((String)object2, n16);
            n13 = statusBucket.getIntStatus((String)object2, n13);
            if (n13 > 0) {
                n11 = (n12 *= 100) / n13;
            }
            n10 = n11;
            TXCStatus.a((String)object2, 18014, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10200);
            TXCStatus.a((String)object2, 18023, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10110);
            TXCStatus.a((String)object2, 18026, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10111);
            TXCStatus.a((String)object2, 18027, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10201);
            TXCStatus.a((String)object2, 18028, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10113);
            TXCStatus.a((String)object2, 18030, n10);
            n13 = 10100;
            n11 = statusBucket.getIntStatus((String)object2, n13);
            n15 = n11;
            TXCStatus.a((String)object2, 18003, n15);
            n10 = statusBucket.getIntStatus((String)object2, n13);
            TXCStatus.a((String)object2, 2019, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10101);
            TXCStatus.a((String)object2, 2020, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10102);
            TXCStatus.a((String)object2, 18016, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10207);
            TXCStatus.a((String)object2, 18009, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10208);
            TXCStatus.a((String)object2, 18010, n10);
            n10 = statusBucket.getIntStatus((String)object2, 10209);
            TXCStatus.a((String)object2, 18012, n10);
            n12 = 2021;
            n13 = statusBucket.getIntStatus((String)object2, 10109);
            n10 = n13;
            TXCStatus.a((String)object2, n12, n10);
        }
    }
}

