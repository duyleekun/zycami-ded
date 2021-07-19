/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;

public abstract class TraeAudioManager$BluetoohHeadsetCheckInterface {
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$BluetoohHeadsetCheckInterface(TraeAudioManager traeAudioManager) {
        this.this$0 = traeAudioManager;
    }

    public abstract void _addAction(IntentFilter var1);

    public abstract void _onReceive(Context var1, Intent var2);

    public void addAction(IntentFilter intentFilter) {
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        this._addAction(intentFilter);
    }

    public String getBTActionStateChangedExtraString(int n10) {
        String string2;
        switch (n10) {
            default: {
                string2 = "unknow";
                break;
            }
            case 13: {
                string2 = "STATE_TURNING_OFF";
                break;
            }
            case 12: {
                string2 = "STATE_ON";
                break;
            }
            case 11: {
                string2 = "STATE_TURNING_ON";
                break;
            }
            case 10: {
                string2 = "STATE_OFF";
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public String getBTAdapterConnectionState(int n10) {
        int n11;
        String string2 = n10 != 0 ? (n10 != (n11 = 1) ? (n10 != (n11 = 2) ? (n10 != (n11 = 3) ? "unknow" : "STATE_DISCONNECTING") : "STATE_CONNECTED") : "STATE_CONNECTING") : "STATE_DISCONNECTED";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public String getBTHeadsetAudioState(int n10) {
        CharSequence charSequence;
        CharSequence charSequence2;
        int n11 = 10;
        if (n10 != n11) {
            n11 = 12;
            if (n10 != n11) {
                charSequence2 = new StringBuilder();
                charSequence = "unknow:";
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(n10);
                charSequence2 = ((StringBuilder)charSequence2).toString();
            } else {
                charSequence2 = "STATE_AUDIO_CONNECTED";
            }
        } else {
            charSequence2 = "STATE_AUDIO_DISCONNECTED";
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(":");
        ((StringBuilder)charSequence).append(n10);
        return ((StringBuilder)charSequence).toString();
    }

    public String getBTHeadsetConnectionState(int n10) {
        int n11;
        String string2 = n10 != 0 ? (n10 != (n11 = 1) ? (n10 != (n11 = 2) ? (n10 != (n11 = 3) ? "unknow" : "STATE_DISCONNECTING") : "STATE_CONNECTED") : "STATE_CONNECTING") : "STATE_DISCONNECTED";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public String getSCOAudioStateExtraString(int n10) {
        int n11 = -1;
        String string2 = n10 != n11 ? (n10 != 0 ? (n10 != (n11 = 1) ? (n10 != (n11 = 2) ? "unknow" : "SCO_AUDIO_STATE_CONNECTING") : "SCO_AUDIO_STATE_CONNECTED") : "SCO_AUDIO_STATE_DISCONNECTED") : "SCO_AUDIO_STATE_ERROR";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public abstract boolean init(Context var1, TraeAudioManager$DeviceConfigManager var2);

    public abstract String interfaceDesc();

    public abstract boolean isConnected();

    public void onReceive(Context object, Intent object2, TraeAudioManager$DeviceConfigManager object3) {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "android.bluetooth.adapter.action.STATE_CHANGED";
        String string3 = object2.getAction();
        int n11 = string2.equals(string3);
        if (n11 != 0) {
            String string4;
            CharSequence charSequence;
            object = "android.bluetooth.adapter.extra.STATE";
            n10 = -1;
            int n12 = object2.getIntExtra((String)object, n10);
            string3 = "android.bluetooth.adapter.extra.PREVIOUS_STATE";
            int n13 = object2.getIntExtra(string3, n10);
            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
            n11 = 2;
            string2 = "TRAE";
            if (n10 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("BT ACTION_STATE_CHANGED|   EXTRA_STATE ");
                string4 = this.getBTActionStateChangedExtraString(n12);
                ((StringBuilder)charSequence).append(string4);
                charSequence = ((StringBuilder)charSequence).toString();
                QLog.w(string2, n11, (String)charSequence);
            }
            if ((n10 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                charSequence = new StringBuilder();
                string4 = "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE ";
                ((StringBuilder)charSequence).append(string4);
                object2 = this.getBTActionStateChangedExtraString(n13);
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ((StringBuilder)charSequence).toString();
                QLog.w(string2, n11, (String)object2);
            }
            if (n12 == (n13 = 10)) {
                n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n12 != 0) {
                    object = "    BT off";
                    QLog.w(string2, n11, (String)object);
                }
                n12 = 0;
                object = null;
                object2 = "DEVICE_BLUETOOTHHEADSET";
                ((TraeAudioManager$DeviceConfigManager)object3).setVisible((String)object2, false);
            } else {
                n13 = 12;
                if (n12 == n13 && (n12 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                    object = "BT OFF-->ON,Visiable it...";
                    QLog.w(string2, n11, (String)object);
                }
            }
        } else {
            object3 = object2.getAction();
            string3 = "android.bluetooth.device.action.ACL_CONNECTED";
            boolean bl2 = string3.equals(object3);
            n11 = 11;
            if (!(bl2 && n10 < n11 || (bl2 = (string2 = "android.bluetooth.device.action.ACL_DISCONNECTED").equals(object3 = object2.getAction())) && n10 < n11)) {
                this._onReceive((Context)object, (Intent)object2);
            }
        }
    }

    public abstract void release();
}

