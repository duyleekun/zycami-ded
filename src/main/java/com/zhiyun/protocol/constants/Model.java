/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.constants;

import com.zhiyun.protocol.constants.Model$1;
import com.zhiyun.protocol.core.entities.Functions;
import d.v.y.d.j;
import d.v.y.d.k;
import java.io.File;

public final class Model
extends Enum {
    private static final /* synthetic */ Model[] $VALUES;
    public static final /* enum */ Model C11;
    public static final /* enum */ Model COV_01;
    public static final /* enum */ Model COV_01_R;
    public static final /* enum */ Model COV_03;
    public static final /* enum */ Model COV_03_AI;
    public static final /* enum */ Model COV_05;
    public static final /* enum */ Model CRANE;
    public static final /* enum */ Model CRANE2;
    public static final /* enum */ Model CRANE2_S;
    public static final /* enum */ Model CRANE3;
    public static final /* enum */ Model CRANE3_LAB;
    public static final /* enum */ Model CRANE3_S;
    public static final /* enum */ Model CRANE_M;
    public static final /* enum */ Model CRANE_M2;
    public static final /* enum */ Model CRANE_PLUS;
    public static final /* enum */ Model EVOLUTION;
    public static final /* enum */ Model EVOLUTION2;
    public static final /* enum */ Model P1;
    public static final /* enum */ Model PROUND;
    public static final /* enum */ Model RIDER_M;
    public static final /* enum */ Model SHINING;
    public static final /* enum */ Model SMOOTH;
    public static final /* enum */ Model SMOOTH2;
    public static final /* enum */ Model SMOOTH3;
    public static final /* enum */ Model SMOOTH4;
    public static final /* enum */ Model SMOOTHQ;
    public static final /* enum */ Model SMOOTHQ2;
    public static final /* enum */ Model SMOOTHQ3;
    public static final /* enum */ Model SMOOTHX;
    public static final /* enum */ Model SMOOTHXS;
    public static final /* enum */ Model SMOOTHXS_HI;
    public static final /* enum */ Model UNKNOWN;
    public static final /* enum */ Model WEEBILL2;
    public static final /* enum */ Model WEEBILL_LAB;
    public static final /* enum */ Model WEEBILL_S;
    private final String codeName;
    private final int[] codes;
    private final Functions functions;
    private final String hidName;
    private final String name;
    private int oemSerial;
    private final int otaCode;

    static {
        Model[] modelArray;
        Model model;
        int n10 = 1;
        Object object = new int[n10];
        object[0] = 4096;
        Object object2 = "SHINING";
        SHINING = model = new Model((String)object2, 0, (String)object2, object);
        object = (Object)new Model;
        object2 = new int[n10];
        object2[0] = 512;
        Object object3 = "PROUND";
        object(object3, n10, object3, (int[])object2);
        PROUND = (Model)((Object)object);
        Object object4 = new int[n10];
        object4[0] = 1024;
        Object object5 = object2;
        object2 = new Model("RIDER_M", 2, "RIDER-M", "RiderM.json", object4);
        RIDER_M = object2;
        object5 = new int[n10];
        object5[0] = 528;
        Object object6 = "SMOOTH";
        object3 = new Model(object6, 3, object6, (int[])object5);
        SMOOTH = object3;
        Object object7 = new int[n10];
        object7[0] = 544;
        Object object8 = object5;
        object5 = new Model("SMOOTH2", 4, "SMOOTH 2", "Smooth2.json", object7);
        SMOOTH2 = object5;
        object8 = new int[n10];
        object8[0] = 560;
        Object object9 = object6;
        object6 = new Model("SMOOTH3", 5, "SMOOTH 3", "Smooth3.json", (int[])object8);
        SMOOTH3 = object6;
        object9 = new int[n10];
        object9[0] = (String)576;
        Object object10 = object8;
        object8 = new Model("SMOOTH4", 6, "SMOOTH 4", "Smooth4.json", (int[])object9);
        SMOOTH4 = object8;
        object4 = new int[n10];
        object4[0] = 545;
        Object object11 = object10;
        object10 = new Model("SMOOTHQ", 7, "SMOOTH-Q", "SmoothQ.json", object4);
        SMOOTHQ = object10;
        object4 = (Object)new Model;
        Object object12 = new int[n10];
        object12[0] = 547;
        int[] nArray = object12;
        object4("SMOOTHQ2", 8, "SMOOTH-Q2", "smooth q2", "SmoothQ2.json", object12);
        SMOOTHQ2 = (Model)((Object)object4);
        object12 = (Object)new Model;
        object9 = new int[n10];
        object9[0] = (String)550;
        Object object13 = object12;
        int n11 = 9;
        object11 = "SMOOTH-X";
        String string2 = "smooth-x";
        Object object14 = "SM108.json";
        Object object15 = object9;
        object12("SMOOTHX", n11, (String)object11, string2, object14, (int[])object9);
        SMOOTHX = (Model)((Object)object12);
        object13 = (Object)new Model;
        object7 = new int[n10];
        object7[0] = 551;
        nArray = object7;
        object13("SMOOTHXS", 10, "SMOOTH-XS", "smooth-xs", "SM110.json", object7);
        SMOOTHXS = (Model)((Object)object13);
        object7 = (Object)new Model;
        Object object16 = ((Model)((Object)object13)).getFunctions();
        object9 = new int[n10];
        int n12 = ((Model)((Object)object13)).getCode();
        object9[0] = (String)n12;
        nArray = object7;
        Object object17 = object9;
        object7("SMOOTHXS_HI", 11, "SMOOTH-XS", "hi-smooth_xs", object16, "2C2W", 552, (int[])object9);
        SMOOTHXS_HI = (Model)((Object)object7);
        Object object18 = new int[n10];
        object18[0] = 592;
        object11 = object9;
        int[] nArray2 = object18;
        object9 = new Model("SMOOTHQ3", 12, "SMOOTH-Q3", "smooth-q3", "SmoothQ3.json", object18);
        SMOOTHQ3 = object9;
        object18 = (Object)new Model;
        object9 = new int[n10];
        object9[0] = (String)768;
        object15 = object7;
        object18("EVOLUTION", 13, "EVO", (int[])object9);
        EVOLUTION = (Model)((Object)object18);
        object9 = new int[1];
        object9[0] = (String)784;
        Object object19 = modelArray;
        Object object20 = object9;
        modelArray = new Model("EVOLUTION2", 14, "EVO 2", "Ev103.json", (int[])object9);
        EVOLUTION2 = modelArray;
        object7 = (Object)new Model;
        Object object21 = new int[]{1280, 1281};
        object20 = object7;
        int[] nArray3 = object21;
        object7("CRANE", 15, "CRANE", "Crane.json", object21);
        CRANE = (Model)((Object)object7);
        object21 = (Object)new Model;
        nArray2 = object7;
        object7 = new int[]{1312};
        object19 = object21;
        object20 = object7;
        object21("CRANE2", 16, "CRANE 2", "Crane2.json", object7);
        CRANE2 = (Model)((Object)object21);
        object7 = (Object)new Model;
        object21 = new int[]{1313};
        object20 = object7;
        nArray3 = object21;
        object7("CRANE2_S", 17, "CRANE 2S", "Crane2S.json", object21);
        CRANE2_S = (Model)((Object)object7);
        object21 = (Object)new Model;
        Object object22 = object7;
        object7 = new int[]{1330};
        Model model2 = modelArray;
        nArray = object18;
        object21("CRANE3", 18, "CRANE 3", object7);
        CRANE3 = (Model)((Object)object21);
        object18 = (Object)new Model;
        object9 = new int[1];
        object9[0] = (String)1328;
        Object object23 = object18;
        Object object24 = object9;
        object18("CRANE3_LAB", 19, "CRANE 3 LAB", "Crane3Lab.json", (int[])object9);
        CRANE3_LAB = (Model)((Object)object18);
        object7 = (Object)new Model;
        modelArray = (Model[])new int[1];
        modelArray[0] = (Model)1338;
        object24 = object7;
        object7("CRANE3_S", 20, "CRANE 3S", "Crane3S.json", (int[])modelArray);
        CRANE3_S = (Model)((Object)object7);
        object20 = object7;
        object7 = new int[]{1282, 1283};
        modelArray = new Model("CRANE_PLUS", 21, "CRANE PLUS", "CranePlus.json", object7);
        CRANE_PLUS = modelArray;
        object7 = (Object)new Model;
        Object object25 = modelArray;
        modelArray = (Model[])new int[2];
        Object object26 = modelArray;
        object26[0] = (Model)1296;
        object26[1] = (Model)1297;
        Object object27 = object7;
        object17 = modelArray;
        object7("CRANE_M", 22, "CRANE-M", "CraneM.json", (int[])modelArray);
        CRANE_M = (Model)((Object)object7);
        object7 = new int[]{1298};
        Object object28 = modelArray;
        Object object29 = object7;
        modelArray = new Model("CRANE_M2", 23, "CRANE-M2", "CraneM2.json", object7);
        CRANE_M2 = modelArray;
        object7 = (Object)new Model;
        Object object30 = modelArray;
        modelArray = (Model[])new int[1];
        modelArray[0] = (Model)1329;
        object29 = object7;
        object7("WEEBILL_LAB", 24, "WEEBILL LAB", "WeebillLab.json", (int[])modelArray);
        WEEBILL_LAB = (Model)((Object)object7);
        object16 = object7;
        object7 = new int[]{1331};
        object28 = modelArray;
        object29 = object7;
        modelArray = new Model("WEEBILL_S", 25, "WEEBILL-S", "WeebillS.json", object7);
        WEEBILL_S = modelArray;
        object7 = (Object)new Model;
        object24 = modelArray;
        modelArray = (Model[])new int[1];
        modelArray[0] = (Model)1332;
        object29 = object7;
        object7("WEEBILL2", 26, "WEEBILL 2", "Weebill2.json", (int[])modelArray);
        WEEBILL2 = (Model)((Object)object7);
        nArray3 = object7;
        object7 = new int[]{546};
        object28 = modelArray;
        object29 = object7;
        modelArray = new Model("P1", 27, "P1", "P1.json", object7);
        P1 = modelArray;
        object7 = (Object)new Model;
        object17 = modelArray;
        modelArray = (Model[])new int[1];
        modelArray[0] = (Model)1536;
        object29 = object7;
        object7("COV_01", 28, "TransMount Image Transmission Transmitter", "COV-1.json", (int[])modelArray);
        COV_01 = (Model)((Object)object7);
        object28 = object7;
        object7 = new int[]{1537};
        Object object31 = object21;
        modelArray = new Model("COV_01_R", 29, "TransMount Image Transmission Receiver", object7);
        COV_01_R = modelArray;
        object21 = (Object)new Model;
        object9 = new int[1];
        object9[0] = (String)1538;
        Object object32 = object9;
        object21("COV_03", 30, "TransMount Image Transmission Transmitter 2.0", "COV-3.json", (int[])object9);
        COV_03 = (Model)((Object)object21);
        object7 = (Object)new Model;
        object18 = new int[]{1541};
        object32 = object7;
        Object object33 = object18;
        object7("COV_03_AI", 31, "TransMount Video Transmission Transmitter (AI)", "COV-3 AI.json", object18);
        COV_03_AI = (Model)((Object)object7);
        object18 = (Object)new Model;
        object7 = new int[]{1540};
        object33 = object18;
        object18("COV_05", 32, "ZHIYUN MasterEye Video Transmitter VT100", "COV-5.json", object7);
        COV_05 = (Model)((Object)object18);
        object7 = (Object)new Model;
        object18 = new int[]{548};
        object29 = object7;
        object7("C11", 33, "C11", "C11.json", object18);
        C11 = (Model)((Object)object7);
        object18 = (Object)new Model;
        object14 = object7;
        object7 = new int[]{0};
        n10 = 34;
        Object object34 = modelArray;
        object18("UNKNOWN", n10, "Unknown", object7);
        UNKNOWN = (Model)((Object)object18);
        modelArray = new Model[35];
        modelArray[0] = model;
        modelArray[1] = (Model)((Object)object);
        modelArray[2] = object2;
        modelArray[3] = object3;
        modelArray[4] = object5;
        modelArray[5] = object6;
        modelArray[6] = object8;
        modelArray[7] = object10;
        modelArray[8] = (Model)((Object)object4);
        modelArray[9] = (Model)((Object)object12);
        modelArray[10] = object13;
        modelArray[11] = object15;
        modelArray[12] = object11;
        modelArray[13] = (Model)nArray;
        modelArray[14] = model2;
        modelArray[15] = (Model)nArray2;
        modelArray[16] = object19;
        modelArray[17] = (Model)((Object)object22);
        modelArray[18] = (Model)((Object)object31);
        modelArray[19] = (Model)((Object)object23);
        modelArray[20] = object20;
        modelArray[21] = object25;
        modelArray[22] = (Model)((Object)object27);
        modelArray[23] = object30;
        modelArray[24] = object16;
        modelArray[25] = object24;
        modelArray[26] = (Model)nArray3;
        modelArray[27] = object17;
        modelArray[28] = object28;
        modelArray[29] = object34;
        modelArray[30] = (Model)((Object)object21);
        modelArray[31] = object32;
        modelArray[32] = (Model)((Object)object33);
        modelArray[33] = (Model)((Object)object29);
        modelArray[n10] = (Model)((Object)object18);
        $VALUES = modelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Model(Functions functions, String string3, int n10, int ... nArray) {
        void var7_5;
        void var8_6;
        void var2_-1;
        void var1_-1;
        this.name = functions;
        this.hidName = string3;
        this.functions = (Functions)n10;
        this.codes = var8_6;
        this.codeName = nArray;
        this.otaCode = var7_5;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Model(String string3, int ... nArray) {
        void var2_-1;
        void var1_-1;
        void var6_4;
        void var5_3;
        Functions functions = Model.getFunctions((String)var5_3);
        void var8_6 = var6_4[0];
        this((String)var1_-1, (int)var2_-1, string3, (String)nArray, functions, null, (int)var8_6, (int[])var6_4);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Model(int ... nArray) {
        this((String)var1_-1, (int)var2_-1, (String)nArray, null, (String)var4_2, (int[])var5_3);
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - void declaration
     */
    private Model() {
        this((String)var1_-1, (int)var2_-1, (String)var3_1, null, (int[])var4_2);
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
    }

    public static Model from(int n10) {
        for (Model model : Model.values()) {
            for (int n11 : model.codes) {
                if (n10 != n11) continue;
                return model;
            }
        }
        return UNKNOWN;
    }

    private String getCodeName() {
        return this.codeName;
    }

    private static Functions getFunctions(String object) {
        boolean bl2 = k.a((String)object);
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("profiles");
            String string2 = File.separator;
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            return Functions.fromJson(j.d(stringBuilder.toString()));
        }
        object = new Functions();
        return object;
    }

    public static int to(Model model) {
        return model.codes[0];
    }

    public static Model valueOf(String string2) {
        return Enum.valueOf(Model.class, string2);
    }

    public static Model[] values() {
        return (Model[])$VALUES.clone();
    }

    public int getCode() {
        return this.codes[0];
    }

    public Functions getFunctions() {
        return this.functions;
    }

    public String getHidName() {
        return this.hidName;
    }

    public String getName() {
        return this.name;
    }

    public int getOemSerial() {
        return this.oemSerial;
    }

    public int getOtaCode() {
        return this.otaCode;
    }

    public boolean isBl() {
        int[] nArray = Model$1.$SwitchMap$com$zhiyun$protocol$constants$Model;
        int n10 = this.ordinal();
        int n11 = nArray[n10];
        switch (n11) {
            default: {
                return true;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
        }
        return false;
    }

    public void setOemSerial(int n10) {
        this.oemSerial = n10;
    }

    public String toString() {
        return this.getName();
    }
}

