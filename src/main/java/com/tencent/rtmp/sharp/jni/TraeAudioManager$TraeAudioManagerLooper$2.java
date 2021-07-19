/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Handler
 *  android.os.Message
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper;
import java.util.HashMap;

public class TraeAudioManager$TraeAudioManagerLooper$2
extends Handler {
    public final /* synthetic */ TraeAudioManager$TraeAudioManagerLooper this$1;

    public TraeAudioManager$TraeAudioManagerLooper$2(TraeAudioManager$TraeAudioManagerLooper traeAudioManagerLooper) {
        this.this$1 = traeAudioManagerLooper;
    }

    public void handleMessage(Message object) {
        int n10;
        Object object2;
        int n11;
        Object object3;
        int n12;
        Object object4 = null;
        Object object5 = ((Message)object).obj;
        try {
            object5 = (HashMap)object5;
        }
        catch (Exception exception) {
            n12 = 0;
            object5 = null;
        }
        int n13 = QLog.isColorLevel();
        int n14 = 2;
        String string2 = "TRAE";
        if (n13 != 0) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("TraeAudioManagerLooper msg:");
            n11 = ((Message)object).what;
            ((StringBuilder)object3).append(n11);
            ((StringBuilder)object3).append(" _enabled:");
            object2 = this.this$1;
            n11 = (int)(((TraeAudioManager$TraeAudioManagerLooper)object2)._enabled ? 1 : 0);
            object2 = n11 != 0 ? "Y" : "N";
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            QLog.w(string2, n14, (String)object3);
        }
        if ((n10 = ((Message)object).what) == (n13 = 32772)) {
            object = this.this$1;
            ((TraeAudioManager$TraeAudioManagerLooper)object).startService((HashMap)object5);
        } else {
            object3 = this.this$1;
            n11 = (int)(((TraeAudioManager$TraeAudioManagerLooper)object3)._enabled ? 1 : 0);
            boolean bl2 = true;
            if (n11 == 0) {
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 != 0) {
                    object = "******* disabled ,skip msg******";
                    QLog.w(string2, n14, (String)object);
                }
                object = new Intent();
                object4 = this.this$1.this$0;
                ((TraeAudioManager)((Object)object4)).sendResBroadcast((Intent)object, (HashMap)object5, (int)(bl2 ? 1 : 0));
            } else {
                object2 = " connected fail,auto switch!";
                String string3 = " sessionConnectedDev:";
                String string4 = "PARAM_DEVICE";
                switch (n10) {
                    default: {
                        break;
                    }
                    case 32790: {
                        ((TraeAudioManager$TraeAudioManagerLooper)object3).abandonAudioFocus();
                        break;
                    }
                    case 32788: {
                        object = (Integer)((HashMap)object5).get("PARAM_STREAMTYPE");
                        if (object == null) {
                            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                            if (n10 == 0) break;
                            object = " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!";
                            QLog.e(string2, n14, (String)object);
                            break;
                        }
                        object4 = this.this$1.this$0;
                        ((TraeAudioManager)object4)._streamType = n12 = ((Integer)object).intValue();
                        object4 = this.this$1;
                        n10 = (Integer)object;
                        ((TraeAudioManager$TraeAudioManagerLooper)object4).InternalNotifyStreamTypeUpdate(n10);
                        break;
                    }
                    case 32787: {
                        object = ((TraeAudioManager$TraeAudioManagerLooper)object3).this$0;
                        object3 = ((TraeAudioManager)object).sessionConnectedDev;
                        n10 = ((TraeAudioManager)((Object)object)).InternalConnectDevice((String)object3, null, false);
                        if (n10 == 0) break;
                        object = (String)((HashMap)object5).get(string4);
                        n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                        if (n12 != 0) {
                            object5 = new StringBuilder();
                            object3 = " plugout dev:";
                            ((StringBuilder)object5).append((String)object3);
                            ((StringBuilder)object5).append((String)object);
                            ((StringBuilder)object5).append(string3);
                            object = this.this$1.this$0.sessionConnectedDev;
                            ((StringBuilder)object5).append((String)object);
                            ((StringBuilder)object5).append((String)object2);
                            object = ((StringBuilder)object5).toString();
                            QLog.w(string2, n14, (String)object);
                        }
                        object = this.this$1.this$0;
                        object5 = ((TraeAudioManager)object)._deviceConfigManager.getAvailabledHighestPriorityDevice();
                        ((TraeAudioManager)((Object)object)).InternalConnectDevice((String)object5, null, false);
                        break;
                    }
                    case 32786: {
                        object = (String)((HashMap)object5).get(string4);
                        object5 = this.this$1.this$0;
                        n12 = ((TraeAudioManager)((Object)object5)).InternalConnectDevice((String)object, null, false);
                        if (n12 == 0) break;
                        n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                        if (n12 != 0) {
                            object5 = new StringBuilder();
                            object3 = " plugin dev:";
                            ((StringBuilder)object5).append((String)object3);
                            ((StringBuilder)object5).append((String)object);
                            ((StringBuilder)object5).append(string3);
                            object = this.this$1.this$0.sessionConnectedDev;
                            ((StringBuilder)object5).append((String)object);
                            ((StringBuilder)object5).append((String)object2);
                            object = ((StringBuilder)object5).toString();
                            QLog.w(string2, n14, (String)object);
                        }
                        object = this.this$1.this$0;
                        object5 = ((TraeAudioManager)object)._deviceConfigManager.getAvailabledHighestPriorityDevice();
                        ((TraeAudioManager)((Object)object)).InternalConnectDevice((String)object5, null, false);
                        break;
                    }
                    case 32785: 
                    case 32789: {
                        object = object3.this$0._deviceConfigManager.getAvailabledHighestPriorityDevice();
                        object5 = this.this$1.this$0._deviceConfigManager.getConnectedDevice();
                        n13 = (int)(QLog.isColorLevel() ? 1 : 0);
                        if (n13 != 0) {
                            object3 = new StringBuilder();
                            ((StringBuilder)object3).append("MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:");
                            ((StringBuilder)object3).append((String)object5);
                            object2 = " highestDev";
                            ((StringBuilder)object3).append((String)object2);
                            ((StringBuilder)object3).append((String)object);
                            object3 = ((StringBuilder)object3).toString();
                            QLog.w(string2, n14, (String)object3);
                        }
                        if ((n13 = (int)(TraeAudioManager.IsUpdateSceneFlag ? 1 : 0)) != 0) {
                            n12 = (int)(TraeAudioManager.IsMusicScene ? 1 : 0);
                            if (n12 != 0) {
                                object5 = this.this$1.this$0;
                                n13 = (int)(((TraeAudioManager)object5).IsBluetoothA2dpExisted ? 1 : 0);
                                if (n13 == 0) {
                                    object = ((TraeAudioManager)object5)._deviceConfigManager;
                                    object3 = "DEVICE_BLUETOOTHHEADSET";
                                    object = ((TraeAudioManager$DeviceConfigManager)object).getAvailabledHighestPriorityDevice((String)object3);
                                    ((TraeAudioManager)((Object)object5)).InternalConnectDevice((String)object, null, bl2);
                                    break;
                                }
                            }
                            object5 = this.this$1.this$0;
                            ((TraeAudioManager)((Object)object5)).InternalConnectDevice((String)object, null, bl2);
                            break;
                        }
                        n12 = (int)(((String)object).equals(object5) ? 1 : 0);
                        if (n12 == 0) {
                            object5 = this.this$1.this$0;
                            ((TraeAudioManager)((Object)object5)).InternalConnectDevice((String)object, null, false);
                            break;
                        }
                        object = this.this$1.this$0;
                        ((TraeAudioManager)((Object)object)).InternalNotifyDeviceListUpdate();
                        break;
                    }
                    case 32784: {
                        ((TraeAudioManager$TraeAudioManagerLooper)object3).InternalGetStreamType((HashMap)object5);
                        break;
                    }
                    case 32783: {
                        ((TraeAudioManager$TraeAudioManagerLooper)object3).InternalStopRing((HashMap)object5);
                        break;
                    }
                    case 32782: {
                        ((TraeAudioManager$TraeAudioManagerLooper)object3).InternalStartRing((HashMap)object5);
                        break;
                    }
                    case 32781: {
                        ((TraeAudioManager$TraeAudioManagerLooper)object3).InternalVoicecallPostprocess((HashMap)object5);
                        break;
                    }
                    case 32780: {
                        ((TraeAudioManager$TraeAudioManagerLooper)object3).InternalVoicecallPreprocess((HashMap)object5);
                        break;
                    }
                    case 32779: {
                        object = ((TraeAudioManager$TraeAudioManagerLooper)object3).this$0;
                        ((TraeAudioManager)((Object)object)).InternalSessionGetConnectingDevice((HashMap)object5);
                        break;
                    }
                    case 32778: {
                        object = ((TraeAudioManager$TraeAudioManagerLooper)object3).this$0;
                        ((TraeAudioManager)((Object)object)).InternalSessionGetConnectedDevice((HashMap)object5);
                        break;
                    }
                    case 32777: {
                        object = ((TraeAudioManager$TraeAudioManagerLooper)object3).this$0;
                        ((TraeAudioManager)((Object)object)).InternalSessionIsDeviceChangabled((HashMap)object5);
                        break;
                    }
                    case 32776: {
                        object = ((TraeAudioManager$TraeAudioManagerLooper)object3).this$0;
                        ((TraeAudioManager)((Object)object)).InternalSessionEarAction((HashMap)object5);
                        break;
                    }
                    case 32775: {
                        object = ((TraeAudioManager$TraeAudioManagerLooper)object3).this$0;
                        ((TraeAudioManager)((Object)object)).InternalSessionConnectDevice((HashMap)object5);
                        break;
                    }
                    case 32774: {
                        ((TraeAudioManager$TraeAudioManagerLooper)object3).InternalSessionGetDeviceList((HashMap)object5);
                        break;
                    }
                    case 32773: {
                        ((TraeAudioManager$TraeAudioManagerLooper)object3).stopService();
                    }
                }
            }
        }
    }
}

