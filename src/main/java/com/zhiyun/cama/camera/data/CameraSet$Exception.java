/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.data;

import com.zhiyun.cama.camera.widget.HintLayout$b;
import java.util.concurrent.TimeUnit;

public final class CameraSet$Exception
extends Enum {
    public static final /* enum */ CameraSet$Exception AXIS_LOCK;
    public static final /* enum */ CameraSet$Exception FW_UPDATE;
    public static final /* enum */ CameraSet$Exception LOW_BATTERY;
    public static final /* enum */ CameraSet$Exception LOW_OPS;
    public static final /* enum */ CameraSet$Exception NO_LOAD;
    public static final /* enum */ CameraSet$Exception OVER_HEAT;
    private static final /* synthetic */ CameraSet$Exception[] a;
    private HintLayout$b hint;

    static {
        CameraSet$Exception cameraSet$Exception;
        Object object = "FW_UPDATE";
        Object object2 = new HintLayout$b((String)object);
        object2 = object2.u(2131952611).o(2131953200).r(false);
        int n10 = 1;
        object2 = object2.t(n10 != 0);
        FW_UPDATE = cameraSet$Exception = new CameraSet$Exception((String)object, 0, object2);
        object = CameraSet$Exception.a("NO LOAD", 2131952733);
        object2 = new CameraSet$Exception("NO_LOAD", n10, (HintLayout$b)object);
        NO_LOAD = object2;
        Object object3 = CameraSet$Exception.a("LOW BATTERY", 2131952732);
        int n11 = 2;
        object = new CameraSet$Exception("LOW_BATTERY", n11, object3);
        LOW_BATTERY = object;
        Object object4 = CameraSet$Exception.a("LOW OPS", 2131952735);
        int n12 = 3;
        object3 = new CameraSet$Exception("LOW_OPS", n12, object4);
        LOW_OPS = object3;
        CameraSet$Exception[] cameraSet$ExceptionArray = "OVER HEAT";
        Object object5 = CameraSet$Exception.a((String)cameraSet$ExceptionArray, 2131952734);
        int n13 = 4;
        object4 = new CameraSet$Exception("OVER_HEAT", n13, object5);
        OVER_HEAT = object4;
        cameraSet$ExceptionArray = CameraSet$Exception.a((String)cameraSet$ExceptionArray, 2131952731);
        int n14 = 5;
        object5 = new CameraSet$Exception("AXIS_LOCK", n14, (HintLayout$b)cameraSet$ExceptionArray);
        AXIS_LOCK = object5;
        cameraSet$ExceptionArray = new CameraSet$Exception[6];
        cameraSet$ExceptionArray[0] = cameraSet$Exception;
        cameraSet$ExceptionArray[n10] = object2;
        cameraSet$ExceptionArray[n11] = object;
        cameraSet$ExceptionArray[n12] = object3;
        cameraSet$ExceptionArray[n13] = object4;
        cameraSet$ExceptionArray[n14] = object5;
        a = cameraSet$ExceptionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CameraSet$Exception() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.hint = var3_1;
    }

    private static HintLayout$b a(String object, int n10) {
        HintLayout$b hintLayout$b = new HintLayout$b((String)object);
        object = hintLayout$b.u(n10).r(true);
        long l10 = TimeUnit.DAYS.toMillis(1L);
        return ((HintLayout$b)object).q(l10);
    }

    public static CameraSet$Exception valueOf(String string2) {
        return Enum.valueOf(CameraSet$Exception.class, string2);
    }

    public static CameraSet$Exception[] values() {
        return (CameraSet$Exception[])a.clone();
    }

    public HintLayout$b getHint() {
        return this.hint;
    }

    public void setHint(HintLayout$b hintLayout$b) {
        this.hint = hintLayout$b;
    }
}

