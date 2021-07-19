/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class NvsTimeUtil {
    public static int compareData(String object, String object2) {
        long l10;
        block8: {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            try {
                object = simpleDateFormat.parse((String)object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return 0;
            }
            object2 = simpleDateFormat.parse((String)object2);
            l10 = ((Date)object).getTime();
            long l11 = ((Date)object2).getTime();
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 >= 0) break block8;
            return 1;
        }
        l10 = ((Date)object).getTime();
        long l13 = ((Date)object2).getTime();
        long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        if (l14 > 0) {
            return -1;
        }
        return 0;
    }

    public static String getCurrentTime() {
        Calendar.getInstance();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    /*
     * Unable to fully structure code
     */
    public static int getHourRange(String var0, String var1_2) {
        block9: {
            var2_3 = NvsTimeUtil.compareData((String)var0, (String)var1_2);
            var3_4 = -1;
            if (var2_3 < 0) {
                return var3_4;
            }
            var5_6 = "yyyy-MM-dd HH:mm:ss";
            var4_5 = new SimpleDateFormat(var5_6);
            var0 = var4_5.parse((String)var0);
            var1_2 = var4_5.parse((String)var1_2);
            var6_7 = var0.getTime();
            var8_8 = var1_2.getTime() - var6_7;
            var6_7 = 3600000L;
            ** try [egrp 6[TRYBLOCK] [6 : 66->69)] { 
lbl18:
            // 1 sources

            var3_4 = (int)(var8_8 /= var6_7);
            break block9;
lbl20:
            // 6 sources

            catch (Exception var0_1) {
                var0_1.printStackTrace();
            }
        }
        return var3_4;
    }

    public static int getRandomTime(int n10, int n11) {
        Random random = null;
        if (n10 >= n11) {
            return 0;
        }
        if (n10 >= 0 && n11 >= 0) {
            n11 -= n10;
            random = new Random();
            n11 = random.nextInt(n11);
            return n10 + n11;
        }
        return 0;
    }
}

