/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.Uri
 *  android.os.Parcelable
 *  android.os.Process
 */
package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioSession$ITraeAudioCallback;

public class TraeAudioSession
extends BroadcastReceiver {
    public static int s_nSessionIdAllocator;
    public final String TRAE_ACTION_PHONE_STATE;
    private boolean _canSwtich2Earphone;
    private String _connectedDev;
    private TraeAudioSession$ITraeAudioCallback mCallback;
    private Context mContext;
    private boolean mIsHostside;
    private long mSessionId;

    public TraeAudioSession(Context object, TraeAudioSession$ITraeAudioCallback object2) {
        int n10;
        String string2;
        boolean bl2;
        block7: {
            CharSequence charSequence;
            long l10;
            boolean bl3;
            String string3;
            long l11;
            boolean n102 = false;
            this.mIsHostside = false;
            this.mSessionId = l11 = Long.MIN_VALUE;
            this._connectedDev = string3 = "DEVICE_NONE";
            this._canSwtich2Earphone = bl2 = true;
            this.TRAE_ACTION_PHONE_STATE = string2 = "android.intent.action.PHONE_STATE";
            int n11 = Process.myPid();
            int n12 = TraeAudioManager._gHostProcessId;
            if (n11 == n12) {
                bl3 = bl2;
            }
            this.mIsHostside = bl3;
            this.mSessionId = l10 = TraeAudioSession.requestSessionId();
            this.mCallback = object2;
            this.mContext = object;
            n10 = 2;
            string2 = "TRAE";
            if (object == null && (n12 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("AudioSession | Invalid parameters: ctx = ");
                String string4 = "null";
                String string5 = "{object}";
                String string6 = object == null ? string4 : string5;
                ((StringBuilder)charSequence).append(string6);
                string6 = "; cb = ";
                ((StringBuilder)charSequence).append(string6);
                if (object2 != null) {
                    string4 = string5;
                }
                ((StringBuilder)charSequence).append(string4);
                object2 = ((StringBuilder)charSequence).toString();
                QLog.w(string2, n10, (String)object2);
            }
            object2 = new IntentFilter();
            object2.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
            charSequence = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
            object2.addAction((String)charSequence);
            if (object != null) {
                try {
                    object.registerReceiver((BroadcastReceiver)this, (IntentFilter)object2);
                }
                catch (Exception exception) {
                    boolean bl4 = QLog.isColorLevel();
                    if (!bl4) break block7;
                    object2 = new StringBuilder();
                    charSequence = "registerReceiver Exception: ";
                    ((StringBuilder)object2).append((String)charSequence);
                    object = exception.getMessage();
                    ((StringBuilder)object2).append((String)object);
                    object = ((StringBuilder)object2).toString();
                    QLog.e(string2, n10, (String)object);
                }
            }
        }
        this.registerAudioSession(this, bl2);
        boolean bl5 = QLog.isColorLevel();
        if (bl5) {
            object = new StringBuilder();
            object2 = "TraeAudioSession create, mSessionId: ";
            ((StringBuilder)object).append((String)object2);
            long l12 = this.mSessionId;
            ((StringBuilder)object).append(l12);
            object = ((StringBuilder)object).toString();
            QLog.w(string2, n10, (String)object);
        }
    }

    public static void ExConnectDevice(Context context, String string2) {
        int n10;
        if (context != null && string2 != null && (n10 = string2.length()) > 0) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
            long l10 = Long.MIN_VALUE;
            String string3 = "PARAM_SESSIONID";
            intent.putExtra(string3, l10);
            String string4 = "OPERATION_CONNECTDEVICE";
            intent.putExtra("PARAM_OPERATION", string4);
            String string5 = "CONNECTDEVICE_DEVICENAME";
            intent.putExtra(string5, string2);
            context.sendBroadcast(intent);
        }
    }

    private int registerAudioSession(TraeAudioSession traeAudioSession, boolean bl2) {
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        long l10 = this.mSessionId;
        return TraeAudioManager.registerAudioSession(traeAudioSession, bl2, l10, context);
    }

    public static long requestSessionId() {
        int n10;
        long l10 = (long)Process.myPid() << 32;
        s_nSessionIdAllocator = n10 = s_nSessionIdAllocator + 1;
        long l11 = n10;
        return l10 + l11;
    }

    public int EarAction(int n10) {
        int n11 = this.mIsHostside;
        String string2 = "OPERATION_EARACTION";
        if (n11 != 0) {
            long l10 = this.mSessionId;
            return TraeAudioManager.earAction(string2, l10, n11 != 0, n10);
        }
        Context context = this.mContext;
        if (context != null && (n10 == 0 || n10 == (n11 = 1))) {
            context = new Intent();
            context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
            long l11 = this.mSessionId;
            context.putExtra("PARAM_SESSIONID", l11);
            context.putExtra("PARAM_OPERATION", string2);
            context.putExtra("EXTRA_EARACTION", n10);
            this.mContext.sendBroadcast((Intent)context);
            return 0;
        }
        return -1;
    }

    public int connectDevice(String string2) {
        int n10 = this.mIsHostside;
        String string3 = "OPERATION_CONNECTDEVICE";
        if (n10 != 0) {
            long l10 = this.mSessionId;
            return TraeAudioManager.connectDevice(string3, l10, n10 != 0, string2);
        }
        Context context = this.mContext;
        if (context != null && string2 != null && (n10 = string2.length()) > 0) {
            context = new Intent();
            context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
            long l11 = this.mSessionId;
            context.putExtra("PARAM_SESSIONID", l11);
            context.putExtra("PARAM_OPERATION", string3);
            context.putExtra("CONNECTDEVICE_DEVICENAME", string2);
            this.mContext.sendBroadcast((Intent)context);
            return 0;
        }
        return -1;
    }

    public int connectHighestPriorityDevice() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.connectHighestPriorityDevice(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int disableDeviceSwitch() {
        return TraeAudioManager.disableDeviceSwitch();
    }

    public int getConnectedDevice() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_GETCONNECTEDDEVICE";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.getConnectedDevice(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int getConnectingDevice() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_GETCONNECTINGDEVICE";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.getConnectingDevice(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int getDeviceList() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_GETDEVICELIST";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.getDeviceList(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int getStreamType() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_GETSTREAMTYPE";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.getStreamType(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int isDeviceChangabled() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_ISDEVICECHANGABLED";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.isDeviceChangabled(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onReceive(Context var1_1, Intent var2_2) {
        block227: {
            block253: {
                block251: {
                    block239: {
                        block252: {
                            block249: {
                                block248: {
                                    block247: {
                                        block246: {
                                            block245: {
                                                block244: {
                                                    block242: {
                                                        block243: {
                                                            block235: {
                                                                block241: {
                                                                    block240: {
                                                                        block236: {
                                                                            block225: {
                                                                                block234: {
                                                                                    block233: {
                                                                                        block232: {
                                                                                            block228: {
                                                                                                block231: {
                                                                                                    block226: {
                                                                                                        block250: {
                                                                                                            var3_3 = this;
                                                                                                            var4_4 = var2_2;
                                                                                                            var5_5 = 2;
                                                                                                            var6_6 = "TRAE";
                                                                                                            if (var2_2 != null) break block250;
                                                                                                            var7_7 = QLog.isColorLevel();
                                                                                                            if (!var7_7) ** GOTO lbl12
                                                                                                            var8_16 = "[ERROR] intent = null!!";
                                                                                                            QLog.w((String)var6_6, var5_5, (String)var8_16);
lbl12:
                                                                                                            // 2 sources

                                                                                                            return;
                                                                                                        }
                                                                                                        var8_16 = "PARAM_SESSIONID";
                                                                                                        var9_25 = -9223372036854775808L;
                                                                                                        var9_25 = var2_2.getLongExtra((String)var8_16, var9_25);
                                                                                                        var8_16 = "PARAM_OPERATION";
                                                                                                        var8_16 = var2_2.getStringExtra((String)var8_16);
                                                                                                        var11_26 = "PARAM_RES_ERRCODE";
                                                                                                        var12_27 = 0;
                                                                                                        var13_28 = null;
                                                                                                        var14_29 = var2_2.getIntExtra((String)var11_26, 0);
                                                                                                        var11_26 = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
                                                                                                        var15_30 = var2_2.getAction();
                                                                                                        var16_31 = var11_26.equals(var15_30);
                                                                                                        var17_32 = "DEVICE_BLUETOOTHHEADSET";
                                                                                                        var18_33 = " bt:";
                                                                                                        var19_34 /* !! */  = "DEVICE_WIREDHEADSET";
                                                                                                        var20_35 = " prevConnected:";
                                                                                                        var21_36 = " ";
                                                                                                        var13_28 = "AudioSession|    ";
                                                                                                        var22_37 = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
                                                                                                        var23_38 = " st:";
                                                                                                        var24_39 = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
                                                                                                        var25_40 = "EXTRA_DATA_CONNECTEDDEVICE";
                                                                                                        var26_41 = "EXTRA_DATA_STREAMTYPE";
                                                                                                        var27_42 = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
                                                                                                        var28_43 = " Num:";
                                                                                                        var15_30 = "\n";
                                                                                                        var29_44 = var18_33;
                                                                                                        var30_45 = 1;
                                                                                                        if (var16_31 == 0) break block225;
                                                                                                        var11_26 = "NOTIFY_SERVICE_STATE";
                                                                                                        var16_31 = var11_26.equals(var8_16);
                                                                                                        if (var16_31 == 0) break block226;
                                                                                                        var8_16 = "NOTIFY_SERVICE_STATE_DATE";
                                                                                                        var5_5 = 0;
                                                                                                        var24_39 = null;
                                                                                                        var7_8 = var2_2.getBooleanExtra((String)var8_16, false);
                                                                                                        var5_5 = (int)QLog.isColorLevel();
                                                                                                        if (var5_5 == 0) ** GOTO lbl74
                                                                                                        var24_39 = new StringBuilder();
                                                                                                        var22_37 = "AudioSession|[onServiceStateUpdate]";
                                                                                                        var24_39.append((String)var22_37);
                                                                                                        var22_37 = var7_8 != false ? "on" : "off";
                                                                                                        var24_39.append((String)var22_37);
                                                                                                        var24_39 = var24_39.toString();
                                                                                                        var31_46 = 2;
                                                                                                        QLog.w((String)var6_6, var31_46, (String)var24_39);
lbl74:
                                                                                                        // 2 sources

                                                                                                        if ((var24_39 = var3_3.mCallback) == null) break block227;
                                                                                                        var24_39.onServiceStateUpdate(var7_8);
                                                                                                        break block227;
                                                                                                    }
                                                                                                    var11_26 = "NOTIFY_DEVICELISTUPDATE";
                                                                                                    var16_31 = var11_26.equals(var8_16);
                                                                                                    if (var16_31 == 0) break block228;
                                                                                                    var8_16 = var2_2.getStringArrayExtra((String)var27_42);
                                                                                                    var27_42 = var2_2.getStringExtra(var25_40);
                                                                                                    var24_39 = var2_2.getStringExtra((String)var24_39);
                                                                                                    var22_37 = var2_2.getStringExtra((String)var22_37);
                                                                                                    var25_40 = var15_30;
                                                                                                    var16_31 = 0;
                                                                                                    var11_26 = null;
                                                                                                    while (true) {
                                                                                                        block230: {
                                                                                                            block229: {
                                                                                                                var32_51 = ((String[])var8_16).length;
                                                                                                                if (var16_31 >= var32_51) break;
                                                                                                                var4_4 = new StringBuilder();
                                                                                                                var4_4.append(var25_40);
                                                                                                                var4_4.append(var13_28);
                                                                                                                var4_4.append(var16_31);
                                                                                                                var4_4.append(var21_36);
                                                                                                                var25_40 = var8_16[var16_31];
                                                                                                                var4_4.append(var25_40);
                                                                                                                var4_4.append((String)var15_30);
                                                                                                                var25_40 = var4_4.toString();
                                                                                                                var4_4 = var8_16[var16_31];
                                                                                                                var32_51 = (int)var4_4.equals(var19_34 /* !! */ );
                                                                                                                if (var32_51 != 0) break block229;
                                                                                                                var4_4 = var8_16[var16_31];
                                                                                                                var32_51 = (int)var4_4.equals(var17_32);
                                                                                                                if (var32_51 == 0) break block230;
                                                                                                            }
                                                                                                            var30_45 = 0;
                                                                                                            var18_33 = null;
                                                                                                        }
                                                                                                        ++var16_31;
                                                                                                    }
                                                                                                    var4_4 = new StringBuilder();
                                                                                                    var4_4.append(var25_40);
                                                                                                    var4_4.append((String)var15_30);
                                                                                                    var4_4 = var4_4.toString();
                                                                                                    var16_31 = (int)QLog.isColorLevel();
                                                                                                    if (var16_31 == 0) break block231;
                                                                                                    var11_26 = new StringBuilder();
                                                                                                    var13_28 = "AudioSession|[onDeviceListUpdate]  connected:";
                                                                                                    var11_26.append(var13_28);
                                                                                                    var11_26.append((String)var27_42);
                                                                                                    var11_26.append((String)var20_35);
                                                                                                    var11_26.append((String)var24_39);
                                                                                                    var13_28 = var29_44;
                                                                                                    var11_26.append(var29_44);
                                                                                                    var11_26.append((String)var22_37);
                                                                                                    var13_28 = var28_43;
                                                                                                    var11_26.append(var28_43);
                                                                                                    var12_27 = ((String[])var8_16).length;
                                                                                                    var11_26.append(var12_27);
                                                                                                    var11_26.append((String)var4_4);
                                                                                                    var4_4 = var11_26.toString();
                                                                                                    var16_31 = 2;
                                                                                                    QLog.w((String)var6_6, var16_31, (String)var4_4);
                                                                                                }
                                                                                                var3_3._canSwtich2Earphone = var30_45;
                                                                                                var3_3._connectedDev = var27_42;
                                                                                                var4_4 = var3_3.mCallback;
                                                                                                if (var4_4 == null) break block227;
                                                                                                var4_4.onDeviceListUpdate((String[])var8_16, (String)var27_42, (String)var24_39, (String)var22_37);
                                                                                                break block227;
                                                                                            }
                                                                                            var4_4 = "NOTIFY_DEVICECHANGABLE_UPDATE";
                                                                                            var32_51 = (int)var4_4.equals(var8_16);
                                                                                            if (var32_51 == 0) break block232;
                                                                                            var8_16 = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
                                                                                            var4_4 = var2_2;
                                                                                            var7_9 = var2_2.getBooleanExtra((String)var8_16, (boolean)var30_45);
                                                                                            var5_5 = (int)QLog.isColorLevel();
                                                                                            if (var5_5 == 0) ** GOTO lbl221
                                                                                            var24_39 = new StringBuilder();
                                                                                            var22_37 = "AudioSession|[onDeviceChangabledUpdate]";
                                                                                            var24_39.append((String)var22_37);
                                                                                            var24_39.append(var7_9);
                                                                                            var24_39 = var24_39.toString();
                                                                                            var31_47 = 2;
                                                                                            QLog.w((String)var6_6, var31_47, (String)var24_39);
lbl221:
                                                                                            // 2 sources

                                                                                            if ((var24_39 = var3_3.mCallback) == null) break block227;
                                                                                            var24_39.onDeviceChangabledUpdate(var7_9);
                                                                                            break block227;
                                                                                        }
                                                                                        var4_4 = var2_2;
                                                                                        var24_39 = "NOTIFY_STREAMTYPE_UPDATE";
                                                                                        var5_5 = (int)var24_39.equals(var8_16);
                                                                                        if (var5_5 == 0) break block233;
                                                                                        var11_26 = var26_41;
                                                                                        var7_10 = -1;
                                                                                        var7_10 = var2_2.getIntExtra(var26_41, var7_10);
                                                                                        if (var14_29 == 0) ** GOTO lbl260
                                                                                        var5_5 = (int)QLog.isColorLevel();
                                                                                        if (var5_5 == 0) ** GOTO lbl260
                                                                                        var24_39 = new StringBuilder();
                                                                                        var22_37 = "AudioSession|[onStreamTypeUpdate] err:";
                                                                                        var24_39.append((String)var22_37);
                                                                                        var31_48 = var14_29;
                                                                                        var24_39.append(var14_29);
                                                                                        var22_37 = var23_38;
                                                                                        var24_39.append(var23_38);
                                                                                        var24_39.append(var7_10);
                                                                                        var24_39 = var24_39.toString();
                                                                                        var31_48 = 2;
                                                                                        QLog.w((String)var6_6, var31_48, (String)var24_39);
lbl260:
                                                                                        // 3 sources

                                                                                        if ((var24_39 = var3_3.mCallback) == null) break block227;
                                                                                        var24_39.onStreamTypeUpdate(var7_10);
                                                                                        break block227;
                                                                                    }
                                                                                    var24_39 = "NOTIFY_ROUTESWITCHSTART";
                                                                                    var5_5 = (int)var24_39.equals(var8_16);
                                                                                    if (var5_5 == 0) break block234;
                                                                                    var8_16 = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
                                                                                    var8_16 = var2_2.getStringExtra((String)var8_16);
                                                                                    var24_39 = "EXTRA_DATA_ROUTESWITCHSTART_TO";
                                                                                    var24_39 = var2_2.getStringExtra((String)var24_39);
                                                                                    var22_37 = this.mCallback;
                                                                                    if (var22_37 == null || var8_16 == null || var24_39 == null) break block227;
                                                                                    var22_37.onAudioRouteSwitchStart((String)var8_16, (String)var24_39);
                                                                                    break block227;
                                                                                }
                                                                                var24_39 = "NOTIFY_ROUTESWITCHEND";
                                                                                var7_11 = var24_39.equals(var8_16);
                                                                                if (!var7_11) break block227;
                                                                                var8_16 = "EXTRA_DATA_ROUTESWITCHEND_DEV";
                                                                                var8_16 = var2_2.getStringExtra((String)var8_16);
                                                                                var24_39 = "EXTRA_DATA_ROUTESWITCHEND_TIME";
                                                                                var9_25 = -1;
                                                                                var33_52 = var2_2.getLongExtra((String)var24_39, var9_25);
                                                                                var24_39 = this.mCallback;
                                                                                if (var24_39 == null || var8_16 == null || (var31_49 = var33_52 == var9_25 ? 0 : (var33_52 < var9_25 ? -1 : 1)) == false) break block227;
                                                                                var24_39.onAudioRouteSwitchEnd((String)var8_16, var33_52);
                                                                                break block227;
                                                                                catch (Exception var8_17) {
                                                                                    var4_4 = var2_2;
                                                                                }
                                                                                break block251;
                                                                            }
                                                                            var30_45 = var14_29;
                                                                            var35_53 = var6_6;
                                                                            var6_6 = var18_33;
                                                                            var11_26 = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
                                                                            var6_6 = var2_2.getAction();
                                                                            var36_54 = var11_26.equals(var6_6);
                                                                            if (var36_54 == 0) break block227;
                                                                            var6_6 = var17_32;
                                                                            var16_31 = var14_29;
                                                                            var37_55 = this.mSessionId;
                                                                            var39_56 = var37_55 == var9_25 ? 0 : (var37_55 < var9_25 ? -1 : 1);
                                                                            if (var39_56 != false) {
                                                                                return;
                                                                            }
                                                                            var17_32 = "OPERATION_GETDEVICELIST";
                                                                            var39_56 = (long)var17_32.equals(var8_16);
                                                                            if (var39_56 == false) break block235;
                                                                            var17_32 = var2_2.getStringArrayExtra((String)var27_42);
                                                                            var18_33 = var2_2.getStringExtra(var25_40);
                                                                            var8_16 = var2_2.getStringExtra((String)var24_39);
                                                                            var24_39 = var2_2.getStringExtra((String)var22_37);
                                                                            var25_40 = var15_30;
                                                                            var31_50 = 0;
                                                                            var22_37 = null;
                                                                            var40_57 = true;
                                                                            while (true) lbl-1000:
                                                                            // 2 sources

                                                                            {
                                                                                var32_51 = var17_32.length;
                                                                                if (var31_50 >= var32_51) break block236;
                                                                                var4_4 = new StringBuilder();
                                                                                break;
                                                                            }
                                                                            catch (Exception var8_18) {
                                                                                var4_4 = var2_2;
                                                                                break block239;
                                                                            }
                                                                            {
                                                                                block238: {
                                                                                    block237: {
                                                                                        var4_4.append(var25_40);
                                                                                        var4_4.append(var13_28);
                                                                                        var4_4.append(var31_50);
                                                                                        var4_4.append(var21_36);
                                                                                        var25_40 = var17_32[var31_50];
                                                                                        var4_4.append(var25_40);
                                                                                        var4_4.append((String)var15_30);
                                                                                        var25_40 = var4_4.toString();
                                                                                        var4_4 = var17_32[var31_50];
                                                                                        var32_51 = (int)var4_4.equals(var19_34 /* !! */ );
                                                                                        if (var32_51 != 0) break block237;
                                                                                        var4_4 = var17_32[var31_50];
                                                                                        var32_51 = (int)var4_4.equals(var6_6);
                                                                                        if (var32_51 == 0) break block238;
                                                                                    }
                                                                                    var40_57 = false;
                                                                                    var27_42 = null;
                                                                                }
                                                                                ++var31_50;
                                                                                ** while (true)
                                                                            }
                                                                        }
                                                                        var4_4 = new StringBuilder();
                                                                        var4_4.append(var25_40);
                                                                        var4_4.append((String)var15_30);
                                                                        var4_4 = var4_4.toString();
                                                                        var3_3._canSwtich2Earphone = var40_57;
                                                                        var3_3._connectedDev = var18_33;
                                                                        var36_54 = (int)QLog.isColorLevel();
                                                                        if (var36_54 == 0) break block240;
                                                                        var6_6 = new StringBuilder();
                                                                        var22_37 = "AudioSession|[onGetDeviceListRes] err:";
                                                                        var6_6.append((String)var22_37);
                                                                        var6_6.append(var16_31);
                                                                        var22_37 = " connected:";
                                                                        var6_6.append((String)var22_37);
                                                                        var6_6.append(var18_33);
                                                                        var6_6.append((String)var20_35);
                                                                        var6_6.append((String)var8_16);
                                                                        var22_37 = var29_44;
                                                                        var6_6.append(var29_44);
                                                                        var6_6.append((String)var24_39);
                                                                        var22_37 = var28_43;
                                                                        var6_6.append(var28_43);
                                                                        var31_50 = var17_32.length;
                                                                        var6_6.append(var31_50);
                                                                        var6_6.append((String)var4_4);
                                                                        var4_4 = var6_6.toString();
                                                                        var22_37 = var35_53;
                                                                        var36_54 = 2;
                                                                        QLog.w(var35_53, var36_54, (String)var4_4);
                                                                        break block241;
                                                                    }
                                                                    var22_37 = var35_53;
                                                                }
                                                                var15_30 = var3_3.mCallback;
                                                                if (var15_30 == null) break block227;
                                                                var14_29 = var16_31;
                                                                var19_34 /* !! */  = var8_16;
                                                                var20_35 = var24_39;
                                                                var15_30.onGetDeviceListRes(var16_31, var17_32, var18_33, (String)var8_16, (String)var24_39);
                                                                break block227;
                                                                catch (Exception var8_19) {
                                                                    var22_37 = var35_53;
                                                                }
                                                                break block252;
                                                            }
                                                            var22_37 = var35_53;
                                                            var4_4 = "OPERATION_CONNECTDEVICE";
                                                            var32_51 = (int)var4_4.equals(var8_16);
                                                            var24_39 = "AudioSession|[onConnectDeviceRes] err:";
                                                            var6_6 = " dev:";
                                                            if (var32_51 == 0) break block242;
                                                            var8_16 = "CONNECTDEVICE_RESULT_DEVICENAME";
                                                            var4_4 = var2_2;
                                                            try {
                                                                var8_16 = var2_2.getStringExtra((String)var8_16);
                                                            }
                                                            catch (Exception var8_20) {}
                                                            var40_58 = QLog.isColorLevel();
                                                            if (!var40_58) ** GOTO lbl492
                                                            var27_42 = new StringBuilder();
                                                            var27_42.append((String)var24_39);
                                                            var27_42.append(var14_29);
                                                            var27_42.append((String)var6_6);
                                                            var27_42.append((String)var8_16);
                                                            var24_39 = var27_42.toString();
                                                            var36_54 = 2;
                                                            QLog.w(var35_53, var36_54, (String)var24_39);
lbl492:
                                                            // 2 sources

                                                            if ((var24_39 = var3_3.mCallback) == null) break block227;
                                                            if (var16_31 == 0) {
                                                                var12_27 = 1;
                                                                break block243;
                                                            }
                                                            var12_27 = 0;
                                                            var13_28 = null;
                                                        }
                                                        var24_39.onConnectDeviceRes(var16_31, (String)var8_16, (boolean)var12_27);
                                                        break block227;
                                                    }
                                                    var4_4 = var2_2;
                                                    var27_42 = "OPERATION_EARACTION";
                                                    var40_59 = var27_42.equals(var8_16);
                                                    if (!var40_59) break block244;
                                                    var8_16 = "EXTRA_EARACTION";
                                                    var36_54 = -1;
                                                    var7_12 = var2_2.getIntExtra((String)var8_16, var36_54);
                                                    var36_54 = (int)QLog.isColorLevel();
                                                    if (var36_54 == 0) break block227;
                                                    var6_6 = new StringBuilder();
                                                    var6_6.append((String)var24_39);
                                                    var6_6.append(var14_29);
                                                    var24_39 = " earAction:";
                                                    var6_6.append((String)var24_39);
                                                    var6_6.append(var7_12);
                                                    var8_16 = var6_6.toString();
                                                    var5_5 = 2;
                                                    QLog.w(var35_53, var5_5, (String)var8_16);
                                                    break block227;
                                                }
                                                var24_39 = "OPERATION_ISDEVICECHANGABLED";
                                                var5_5 = (int)var24_39.equals(var8_16);
                                                if (var5_5 == 0) break block245;
                                                var8_16 = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
                                                var5_5 = 0;
                                                var24_39 = null;
                                                var7_13 = var2_2.getBooleanExtra((String)var8_16, false);
                                                var5_5 = (int)QLog.isColorLevel();
                                                if (var5_5 == 0) ** GOTO lbl569
                                                var24_39 = new StringBuilder();
                                                var6_6 = "AudioSession|[onIsDeviceChangabledRes] err:";
                                                var24_39.append((String)var6_6);
                                                var24_39.append(var14_29);
                                                var6_6 = " Changabled:";
                                                var24_39.append((String)var6_6);
                                                var6_6 = var7_13 != false ? "Y" : "N";
                                                var24_39.append((String)var6_6);
                                                var24_39 = var24_39.toString();
                                                var36_54 = 2;
                                                QLog.w((String)var22_37, var36_54, (String)var24_39);
lbl569:
                                                // 2 sources

                                                if ((var24_39 = var3_3.mCallback) == null) break block227;
                                                var24_39.onIsDeviceChangabledRes(var16_31, var7_13);
                                                break block227;
                                            }
                                            var24_39 = "OPERATION_GETCONNECTEDDEVICE";
                                            var5_5 = (int)var24_39.equals(var8_16);
                                            if (var5_5 == 0) break block246;
                                            var8_16 = "GETCONNECTEDDEVICE_REULT_LIST";
                                            var8_16 = var2_2.getStringExtra((String)var8_16);
                                            var5_5 = (int)QLog.isColorLevel();
                                            if (var5_5 == 0) ** GOTO lbl603
                                            var24_39 = new StringBuilder();
                                            var27_42 = "AudioSession|[onGetConnectedDeviceRes] err:";
                                            var24_39.append((String)var27_42);
                                            var24_39.append(var14_29);
                                            var24_39.append((String)var6_6);
                                            var24_39.append((String)var8_16);
                                            var24_39 = var24_39.toString();
                                            var36_54 = 2;
                                            QLog.w(var35_53, var36_54, (String)var24_39);
lbl603:
                                            // 2 sources

                                            if ((var24_39 = var3_3.mCallback) == null) break block227;
                                            var24_39.onGetConnectedDeviceRes(var16_31, (String)var8_16);
                                            break block227;
                                        }
                                        var24_39 = "OPERATION_GETCONNECTINGDEVICE";
                                        var5_5 = (int)var24_39.equals(var8_16);
                                        if (var5_5 == 0) break block247;
                                        var8_16 = "GETCONNECTINGDEVICE_REULT_LIST";
                                        var8_16 = var2_2.getStringExtra((String)var8_16);
                                        var5_5 = (int)QLog.isColorLevel();
                                        if (var5_5 == 0) ** GOTO lbl637
                                        var24_39 = new StringBuilder();
                                        var27_42 = "AudioSession|[onGetConnectingDeviceRes] err:";
                                        var24_39.append((String)var27_42);
                                        var24_39.append(var14_29);
                                        var24_39.append((String)var6_6);
                                        var24_39.append((String)var8_16);
                                        var24_39 = var24_39.toString();
                                        var36_54 = 2;
                                        QLog.w(var35_53, var36_54, (String)var24_39);
lbl637:
                                        // 2 sources

                                        if ((var24_39 = var3_3.mCallback) == null) break block227;
                                        var24_39.onGetConnectingDeviceRes(var16_31, (String)var8_16);
                                        break block227;
                                    }
                                    var24_39 = "OPERATION_GETSTREAMTYPE";
                                    var5_5 = (int)var24_39.equals(var8_16);
                                    if (var5_5 == 0) break block248;
                                    var8_16 = var26_41;
                                    var5_5 = -1;
                                    var7_14 = var2_2.getIntExtra(var26_41, var5_5);
                                    var5_5 = (int)QLog.isColorLevel();
                                    if (var5_5 == 0) ** GOTO lbl673
                                    var24_39 = new StringBuilder();
                                    var6_6 = "AudioSession|[onGetStreamTypeRes] err:";
                                    var24_39.append((String)var6_6);
                                    var24_39.append(var14_29);
                                    var6_6 = var23_38;
                                    var24_39.append(var23_38);
                                    var24_39.append(var7_14);
                                    var24_39 = var24_39.toString();
                                    var36_54 = 2;
                                    QLog.w(var35_53, var36_54, (String)var24_39);
lbl673:
                                    // 2 sources

                                    if ((var24_39 = var3_3.mCallback) == null) break block227;
                                    var24_39.onGetStreamTypeRes(var16_31, var7_14);
                                    break block227;
                                }
                                var24_39 = "NOTIFY_RING_COMPLETION";
                                var5_5 = (int)var24_39.equals(var8_16);
                                if (var5_5 == 0) break block249;
                                var8_16 = "PARAM_RING_USERDATA_STRING";
                                var8_16 = var2_2.getStringExtra((String)var8_16);
                                var5_5 = (int)QLog.isColorLevel();
                                if (var5_5 == 0) ** GOTO lbl708
                                var24_39 = new StringBuilder();
                                var6_6 = "AudioSession|[onRingCompletion] err:";
                                var24_39.append((String)var6_6);
                                var24_39.append(var14_29);
                                var6_6 = " userData:";
                                var24_39.append((String)var6_6);
                                var24_39.append((String)var8_16);
                                var24_39 = var24_39.toString();
                                var36_54 = 2;
                                QLog.w(var35_53, var36_54, (String)var24_39);
lbl708:
                                // 2 sources

                                if ((var24_39 = var3_3.mCallback) == null) break block227;
                                var24_39.onRingCompletion(var16_31, (String)var8_16);
                                break block227;
                            }
                            var24_39 = "OPERATION_VOICECALL_PREPROCESS";
                            var7_15 = var24_39.equals(var8_16);
                            if (!var7_15) break block227;
                            var7_15 = QLog.isColorLevel();
                            if (!var7_15) ** GOTO lbl733
                            var8_16 = new StringBuilder();
                            var24_39 = "AudioSession|[onVoicecallPreprocess] err:";
                            var8_16.append((String)var24_39);
                            var8_16.append(var14_29);
                            var8_16 = var8_16.toString();
                            var5_5 = 2;
                            QLog.w(var35_53, var5_5, (String)var8_16);
lbl733:
                            // 2 sources

                            if ((var8_16 = var3_3.mCallback) == null) break block227;
                            var8_16.onVoicecallPreprocessRes(var16_31);
                            break block227;
                            break block253;
                            catch (Exception var8_21) {
                                // empty catch block
                            }
                        }
                        var4_4 = var2_2;
                        break block253;
                        catch (Exception var8_23) {
                            // empty catch block
                        }
                    }
                    var22_37 = var35_53;
                    break block253;
                    catch (Exception var8_24) {
                        // empty catch block
                    }
                }
                var22_37 = var6_6;
            }
            var5_5 = (int)QLog.isColorLevel();
            if (var5_5 != 0) {
                var24_39 = new StringBuilder();
                var24_39.append("AudioSession| nSessinId = ");
                var41_60 = var3_3.mSessionId;
                var24_39.append(var41_60);
                var24_39.append(" onReceive::intent:");
                var6_6 = var2_2.toString();
                var24_39.append((String)var6_6);
                var6_6 = " intent.getAction():";
                var24_39.append((String)var6_6);
                var4_4 = var2_2.getAction();
                var24_39.append((String)var4_4);
                var4_4 = " Exception:";
                var24_39.append((String)var4_4);
                var8_22 = var8_22.getMessage();
                var24_39.append(var8_22);
                var8_22 = var24_39.toString();
                var32_51 = 2;
                QLog.e((String)var22_37, var32_51, var8_22);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void onReceiveCallback(Intent var1_1) {
        block18: {
            block19: {
                var2_2 = 2;
                var3_3 = "TRAE";
                if (var1_1 /* !! */  != null) break block19;
                var4_4 = QLog.isColorLevel();
                if (!var4_4) ** GOTO lbl10
                var5_6 = "[ERROR] intent = null!!";
                QLog.w(var3_3, var2_2, (String)var5_6);
lbl10:
                // 2 sources

                return;
            }
            var5_6 = "PARAM_SESSIONID";
            var6_8 = -9223372036854775808L;
            var8_9 = var1_1 /* !! */ .getLongExtra((String)var5_6, var6_8);
            var10_10 = "PARAM_OPERATION";
            var10_10 = var1_1 /* !! */ .getStringExtra(var10_10);
            var11_11 = "PARAM_RES_ERRCODE";
            var12_12 = false;
            var13_13 = null;
            var14_14 = var1_1 /* !! */ .getIntExtra(var11_11, 0);
            var13_13 = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
            var15_15 = var1_1 /* !! */ .getAction();
            var12_12 = var13_13.equals(var15_15);
            if (!var12_12) break block18;
            var16_16 = this.mSessionId;
            var4_5 = var16_16 == var8_9 ? 0 : (var16_16 < var8_9 ? -1 : 1);
            if (var4_5 != false) {
                return;
            }
            var5_6 = "OPERATION_VOICECALL_PREPROCESS";
            var4_5 = (long)var5_6.equals(var10_10);
            if (var4_5 == false) break block18;
            var4_5 = (long)QLog.isColorLevel();
            if (var4_5 == false) ** GOTO lbl54
            var5_6 = new StringBuilder();
            var18_17 /* !! */  = "AudioSession|[onReceiveCallback onVoicecallPreprocess] err:";
            var5_6.append((String)var18_17 /* !! */ );
            var5_6.append(var14_14);
            var5_6 = var5_6.toString();
            QLog.w(var3_3, var2_2, (String)var5_6);
lbl54:
            // 2 sources

            if ((var5_6 = this.mCallback) == null) break block18;
            try {
                var5_6.onVoicecallPreprocessRes(var14_14);
            }
            catch (Exception var5_7) {
                var19_18 = QLog.isColorLevel();
                if (!var19_18) break block18;
                var18_17 /* !! */  = new StringBuilder();
                var18_17 /* !! */ .append("AudioSession| nSessinId = ");
                var20_19 = this.mSessionId;
                var18_17 /* !! */ .append(var20_19);
                var18_17 /* !! */ .append(" onReceive::intent:");
                var10_10 = var1_1 /* !! */ .toString();
                var18_17 /* !! */ .append(var10_10);
                var10_10 = " intent.getAction():";
                var18_17 /* !! */ .append(var10_10);
                var1_1 /* !! */  = var1_1 /* !! */ .getAction();
                var18_17 /* !! */ .append((String)var1_1 /* !! */ );
                var18_17 /* !! */ .append(" Exception:");
                var1_1 /* !! */  = var5_7.getMessage();
                var18_17 /* !! */ .append((String)var1_1 /* !! */ );
                var1_1 /* !! */  = var18_17 /* !! */ .toString();
                QLog.e(var3_3, var2_2, (String)var1_1 /* !! */ );
            }
        }
    }

    public int recoverAudioFocus() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_RECOVER_AUDIO_FOCUS";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.recoverAudioFocus(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public void release() {
        block4: {
            CharSequence charSequence;
            CharSequence charSequence2;
            boolean bl2 = QLog.isColorLevel();
            int n10 = 2;
            String string2 = "TRAE";
            if (bl2) {
                charSequence2 = new StringBuilder();
                charSequence = "TraeAudioSession release, mSessionId: ";
                charSequence2.append((String)charSequence);
                long l10 = this.mSessionId;
                charSequence2.append(l10);
                charSequence2 = charSequence2.toString();
                QLog.w(string2, n10, (String)charSequence2);
            }
            if ((charSequence2 = this.mContext) != null) {
                try {
                    charSequence2.unregisterReceiver(this);
                }
                catch (Exception exception) {
                    boolean bl3 = QLog.isColorLevel();
                    if (!bl3) break block4;
                    charSequence = new StringBuilder();
                    String string3 = "unregisterReceiver failed.";
                    ((StringBuilder)charSequence).append(string3);
                    String string4 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string4);
                    string4 = ((StringBuilder)charSequence).toString();
                    QLog.e(string2, n10, string4);
                }
            }
        }
        this.registerAudioSession(this, false);
        this.mContext = null;
        this.mCallback = null;
    }

    public int requestReleaseAudioFocus() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.requestReleaseAudioFocus(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public void setCallback(TraeAudioSession$ITraeAudioCallback traeAudioSession$ITraeAudioCallback) {
        this.mCallback = traeAudioSession$ITraeAudioCallback;
    }

    public int startRing(int n10, int n11, Uri uri, String string2, boolean bl2) {
        boolean bl3 = this.mIsHostside;
        if (bl3) {
            long l10 = this.mSessionId;
            return TraeAudioManager.startRing("OPERATION_STARTRING", l10, bl3, n10, n11, uri, string2, bl2, 1, "normal-ring", false);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_RING_DATASOURCE", n10);
        context.putExtra("PARAM_RING_RSID", n11);
        context.putExtra("PARAM_RING_URI", (Parcelable)uri);
        context.putExtra("PARAM_RING_FILEPATH", string2);
        context.putExtra("PARAM_RING_LOOP", bl2);
        context.putExtra("PARAM_RING_MODE", false);
        context.putExtra("PARAM_RING_USERDATA_STRING", "normal-ring");
        context.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int startRing(int n10, int n11, Uri uri, String string2, boolean bl2, int n12, String string3) {
        boolean bl3 = this.mIsHostside;
        if (bl3) {
            long l10 = this.mSessionId;
            return TraeAudioManager.startRing("OPERATION_STARTRING", l10, bl3, n10, n11, uri, string2, bl2, n12, string3, false);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_RING_DATASOURCE", n10);
        context.putExtra("PARAM_RING_RSID", n11);
        context.putExtra("PARAM_RING_URI", (Parcelable)uri);
        context.putExtra("PARAM_RING_FILEPATH", string2);
        context.putExtra("PARAM_RING_LOOP", bl2);
        context.putExtra("PARAM_RING_LOOPCOUNT", n12);
        context.putExtra("PARAM_RING_MODE", false);
        context.putExtra("PARAM_RING_USERDATA_STRING", string3);
        context.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int startRing(int n10, int n11, Uri uri, String string2, boolean bl2, int n12, String string3, boolean bl3) {
        boolean bl4 = this.mIsHostside;
        if (bl4) {
            long l10 = this.mSessionId;
            return TraeAudioManager.startRing("OPERATION_STARTRING", l10, bl4, n10, n11, uri, string2, bl2, n12, string3, bl3);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_RING_DATASOURCE", n10);
        context.putExtra("PARAM_RING_RSID", n11);
        context.putExtra("PARAM_RING_URI", (Parcelable)uri);
        context.putExtra("PARAM_RING_FILEPATH", string2);
        context.putExtra("PARAM_RING_LOOP", bl2);
        context.putExtra("PARAM_RING_LOOPCOUNT", n12);
        context.putExtra("PARAM_RING_MODE", bl3);
        context.putExtra("PARAM_RING_USERDATA_STRING", string3);
        context.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int startService(String string2) {
        boolean bl2;
        if (string2 == null || (bl2 = string2.length()) <= false) {
            string2 = "internal_disable_dev_switch";
        }
        bl2 = this.mIsHostside;
        String string3 = "OPERATION_STARTSERVICE";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.startService(string3, l10, bl2, string2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string3);
        context.putExtra("EXTRA_DATA_DEVICECONFIG", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int stopRing() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_STOPRING";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.stopRing(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int stopService() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_STOPSERVICE";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.stopService(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int voiceCallAudioParamChanged(int n10, int n11) {
        boolean bl2 = this.mIsHostside;
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.voiceCallAudioParamChanged("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", l10, bl2, n10, n11);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_MODEPOLICY", n10);
        context.putExtra("PARAM_STREAMTYPE", n11);
        context.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int voiceCallPostprocess() {
        boolean bl2 = this.mIsHostside;
        String string2 = "OPERATION_VOICECALL_POSTROCESS";
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.voicecallPostprocess(string2, l10, bl2);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_OPERATION", string2);
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }

    public int voiceCallPreprocess(int n10, int n11) {
        boolean bl2 = this.mIsHostside;
        if (bl2) {
            long l10 = this.mSessionId;
            return TraeAudioManager.voicecallPreprocess("OPERATION_VOICECALL_PREPROCESS", l10, bl2, n10, n11);
        }
        Context context = this.mContext;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        long l11 = this.mSessionId;
        context.putExtra("PARAM_SESSIONID", l11);
        context.putExtra("PARAM_MODEPOLICY", n10);
        context.putExtra("PARAM_STREAMTYPE", n11);
        context.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
        this.mContext.sendBroadcast((Intent)context);
        return 0;
    }
}

