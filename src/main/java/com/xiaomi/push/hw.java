/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class hw
extends Enum {
    public static final /* enum */ hw A;
    public static final /* enum */ hw B;
    public static final /* enum */ hw C;
    public static final /* enum */ hw D;
    public static final /* enum */ hw E;
    public static final /* enum */ hw F;
    public static final /* enum */ hw G;
    public static final /* enum */ hw H;
    public static final /* enum */ hw I;
    public static final /* enum */ hw J;
    public static final /* enum */ hw K;
    public static final /* enum */ hw L;
    public static final /* enum */ hw M;
    public static final /* enum */ hw N;
    public static final /* enum */ hw O;
    public static final /* enum */ hw P;
    public static final /* enum */ hw Q;
    public static final /* enum */ hw R;
    public static final /* enum */ hw a;
    private static final /* synthetic */ hw[] a;
    public static final /* enum */ hw b;
    public static final /* enum */ hw c;
    public static final /* enum */ hw d;
    public static final /* enum */ hw e;
    public static final /* enum */ hw f;
    public static final /* enum */ hw g;
    public static final /* enum */ hw h;
    public static final /* enum */ hw i;
    public static final /* enum */ hw j;
    public static final /* enum */ hw k;
    public static final /* enum */ hw l;
    public static final /* enum */ hw m;
    public static final /* enum */ hw n;
    public static final /* enum */ hw o;
    public static final /* enum */ hw p;
    public static final /* enum */ hw q;
    public static final /* enum */ hw r;
    public static final /* enum */ hw s;
    public static final /* enum */ hw t;
    public static final /* enum */ hw u;
    public static final /* enum */ hw v;
    public static final /* enum */ hw w;
    public static final /* enum */ hw x;
    public static final /* enum */ hw y;
    public static final /* enum */ hw z;
    public final String a;

    static {
        hw hw2;
        hw hw3;
        hw hw4;
        hw hw5;
        hw hw6;
        hw hw7;
        hw hw8;
        hw hw9;
        hw hw10;
        hw hw11;
        hw hw12;
        hw hw13;
        hw hw14;
        a = hw14 = new hw("Invalid", 0, "INVALID");
        b = hw13 = new hw("BarClick", 1, "bar:click");
        c = hw12 = new hw("BarCancel", 2, "bar:cancel");
        d = hw11 = new hw("AppOpen", 3, "app:open");
        e = hw10 = new hw("PackageUninstall", 4, "package uninstalled");
        f = hw9 = new hw("AppUninstall", 5, "app_uninstalled");
        g = hw8 = new hw("ClientInfoUpdate", 6, "client_info_update");
        h = hw7 = new hw("ClientInfoUpdateOk", 7, "client_info_update_ok");
        i = hw6 = new hw("ClientMIIDUpdate", 8, "client_miid_update");
        j = hw5 = new hw("PullOfflineMessage", 9, "pull");
        k = hw4 = new hw("IosSleep", 10, "ios_sleep");
        l = hw3 = new hw("IosWakeUp", 11, "ios_wakeup");
        hw[] hwArray = new hw("AwakeApp", 12, "awake_app");
        m = hwArray;
        hw[] hwArray2 = hwArray;
        n = hw2 = new hw("NormalClientConfigUpdate", 13, "normal_client_config_update");
        hw hw15 = hw2;
        hwArray = new hw("CustomClientConfigUpdate", 14, "custom_client_config_update");
        o = hwArray;
        hw[] hwArray3 = hwArray;
        p = hw2 = new hw("DailyCheckClientConfig", 15, "daily_check_client_config");
        hw hw16 = hw2;
        hwArray = new hw("DataCollection", 16, "data_collection");
        q = hwArray;
        hw[] hwArray4 = hwArray;
        r = hw2 = new hw("RegIdExpired", 17, "registration id expired");
        hw hw17 = hw2;
        hwArray = new hw("ConnectionDisabled", 18, "!!!MILINK CONNECTION DISABLED!!!");
        s = hwArray;
        hw[] hwArray5 = hwArray;
        t = hw2 = new hw("PackageUnregistered", 19, "package_unregistered");
        hw hw18 = hw2;
        hwArray = new hw("DecryptMessageFail", 20, "decrypt_msg_fail");
        u = hwArray;
        hw[] hwArray6 = hwArray;
        v = hw2 = new hw("SyncInfo", 21, "sync_info");
        hw hw19 = hw2;
        hwArray = new hw("SyncInfoResult", 22, "sync_info_result");
        w = hwArray;
        hw[] hwArray7 = hwArray;
        x = hw2 = new hw("ForceSync", 23, "force_sync");
        hw hw20 = hw2;
        hwArray = new hw("UploadClientLog", 24, "upload_client_log");
        y = hwArray;
        hw[] hwArray8 = hwArray;
        z = hw2 = new hw("NotificationBarInfo", 25, "notification_bar_info");
        hw hw21 = hw2;
        hwArray = new hw("SyncMIID", 26, "sync_miid");
        A = hwArray;
        hw[] hwArray9 = hwArray;
        B = hw2 = new hw("UploadTinyData", 27, "upload");
        hw hw22 = hw2;
        hwArray = new hw("CancelPushMessage", 28, "clear_push_message");
        C = hwArray;
        hw[] hwArray10 = hwArray;
        D = hw2 = new hw("DisablePushMessage", 29, "disable_push");
        hw hw23 = hw2;
        hwArray = new hw("EnablePushMessage", 30, "enable_push");
        E = hwArray;
        hw[] hwArray11 = hwArray;
        F = hw2 = new hw("ClientABTest", 31, "client_ab_test");
        hw hw24 = hw2;
        hwArray = new hw("AwakeSystemApp", 32, "awake_system_app");
        G = hwArray;
        hw[] hwArray12 = hwArray;
        H = hw2 = new hw("AwakeAppResponse", 33, "awake_app_response");
        hw hw25 = hw2;
        hwArray = new hw("HybridRegister", 34, "hb_register");
        I = hwArray;
        hw[] hwArray13 = hwArray;
        J = hw2 = new hw("HybridRegisterResult", 35, "hb_register_res");
        hw hw26 = hw2;
        hwArray = new hw("HybridUnregister", 36, "hb_unregister");
        K = hwArray;
        hw[] hwArray14 = hwArray;
        L = hw2 = new hw("HybridUnregisterResult", 37, "hb_unregister_res");
        hw hw27 = hw2;
        hwArray = new hw("ThirdPartyRegUpdate", 38, "3rd_party_reg_update");
        M = hwArray;
        hw[] hwArray15 = hwArray;
        N = hw2 = new hw("VRUpload", 39, "vr_upload");
        hw hw28 = hw2;
        hwArray = new hw("PushLogUpload", 40, "log_upload");
        O = hwArray;
        hw[] hwArray16 = hwArray;
        P = hw2 = new hw("APP_WAKEUP", 41, "app_wakeup");
        hw hw29 = hw2;
        hwArray = new hw("APP_SLEEP", 42, "app_sleep");
        Q = hwArray;
        hw[] hwArray17 = hwArray;
        R = hw2 = new hw("NOTIFICATION_SWITCH", 43, "notification_switch");
        hwArray = new hw[]{hw14, hw13, hw12, hw11, hw10, hw9, hw8, hw7, hw6, hw5, hw4, hw3, hwArray2, hw15, hwArray3, hw16, hwArray4, hw17, hwArray5, hw18, hwArray6, hw19, hwArray7, hw20, hwArray8, hw21, hwArray9, hw22, hwArray10, hw23, hwArray11, hw24, hwArray12, hw25, hwArray13, hw26, hwArray14, hw27, hwArray15, hw28, hwArray16, hw29, hwArray17, hw2};
        a = hwArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private hw() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.a = var3_1;
    }

    public static hw valueOf(String string2) {
        return Enum.valueOf(hw.class, string2);
    }

    public static hw[] values() {
        return (hw[])a.clone();
    }

    public String toString() {
        return this.a;
    }
}

