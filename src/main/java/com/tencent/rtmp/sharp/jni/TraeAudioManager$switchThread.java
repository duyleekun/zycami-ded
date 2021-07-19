/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;
import java.util.HashMap;

public abstract class TraeAudioManager$switchThread
extends Thread {
    public boolean[] _exited;
    public HashMap _params;
    public boolean _running;
    public long _usingtime;
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$switchThread(TraeAudioManager object) {
        long l10;
        this.this$0 = object;
        int n10 = 1;
        this._running = n10;
        object = new boolean[n10];
        CharSequence charSequence = null;
        object[0] = (TraeAudioManager)false;
        this._exited = (boolean[])object;
        object = null;
        this._params = null;
        this._usingtime = l10 = 0L;
        n10 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n10 != 0) {
            n10 = 2;
            charSequence = new StringBuilder();
            charSequence.append(" ++switchThread:");
            String string2 = this.getDeviceName();
            charSequence.append(string2);
            charSequence = charSequence.toString();
            string2 = "TRAE";
            QLog.w(string2, n10, (String)charSequence);
        }
    }

    public abstract void _quit();

    public abstract void _run();

    public abstract String getDeviceName();

    public void processDeviceConnectRes(int n10) {
        long l10;
        long l11;
        long l12;
        long l13;
        this.this$0.InternalNotifyDeviceChangableUpdate();
        Object object = new StringBuilder();
        Object object2 = this.getDeviceName();
        ((StringBuilder)object).append((String)object2);
        object2 = " err:";
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(n10);
        AudioDeviceInterface.LogTraceEntry(((StringBuilder)object).toString());
        object = this._params;
        if (object == null) {
            this.this$0.InternalNotifyDeviceListUpdate();
            return;
        }
        object = this.this$0;
        object2 = ((TraeAudioManager)object)._deviceConfigManager.getConnectedDevice();
        ((TraeAudioManager)object).sessionConnectedDev = object2;
        object = this._params;
        object2 = "PARAM_SESSIONID";
        object = (Long)((HashMap)object).get(object2);
        boolean bl2 = QLog.isColorLevel();
        int n11 = 2;
        String string2 = "TRAE";
        if (bl2) {
            object2 = new StringBuilder();
            String string3 = " sessonID:";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
            QLog.w(string2, n11, (String)object2);
        }
        if (object != null && (l13 = (l12 = (l11 = ((Long)object).longValue()) - (l10 = Long.MIN_VALUE)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            object = new Intent();
            object2 = (String)this._params.get("PARAM_DEVICE");
            object.putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)object2);
            object2 = this.this$0;
            HashMap hashMap = this._params;
            n10 = ((TraeAudioManager)((Object)object2)).sendResBroadcast((Intent)object, hashMap, n10);
            if (n10 == 0) {
                TraeAudioManager traeAudioManager = this.this$0;
                traeAudioManager.InternalNotifyDeviceListUpdate();
            }
            AudioDeviceInterface.LogTraceExit();
            return;
        }
        Object object3 = this.this$0;
        object3.InternalNotifyDeviceListUpdate();
        n10 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n10 != 0) {
            object3 = "processDeviceConnectRes sid null,don't send res";
            QLog.w(string2, n11, (String)object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void quit() {
        Object object;
        AudioDeviceInterface.LogTraceEntry(this.getDeviceName());
        boolean bl2 = false;
        Object var2_2 = null;
        this._running = false;
        boolean bl3 = QLog.isColorLevel();
        if (bl3) {
            object = "TRAE";
            int n10 = 2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append(" quit:");
            String string2 = this.getDeviceName();
            charSequence.append(string2);
            string2 = " _running:";
            charSequence.append(string2);
            boolean bl4 = this._running;
            charSequence.append(bl4);
            charSequence = charSequence.toString();
            QLog.w((String)object, n10, (String)charSequence);
        }
        this.interrupt();
        this._quit();
        object = this._exited;
        synchronized (object) {
            boolean[] blArray = this._exited;
            bl2 = blArray[0];
            if (!bl2) {
                long l10 = 10000L;
                try {
                    blArray.wait(l10);
                }
                catch (InterruptedException interruptedException) {}
            }
        }
        AudioDeviceInterface.LogTraceExit();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        AudioDeviceInterface.LogTraceEntry(this.getDeviceName());
        Object object = this.this$0._deviceConfigManager;
        Object object2 = this.getDeviceName();
        ((TraeAudioManager$DeviceConfigManager)object).setConnecting((String)object2);
        this.this$0.InternalNotifyDeviceChangableUpdate();
        this._run();
        object = this._exited;
        synchronized (object) {
            object2 = this._exited;
            boolean bl2 = true;
            object2[0] = bl2;
            object2.notifyAll();
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public void setDeviceConnectParam(HashMap hashMap) {
        this._params = hashMap;
    }

    public void updateStatus() {
        TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager = this.this$0._deviceConfigManager;
        String string2 = this.getDeviceName();
        traeAudioManager$DeviceConfigManager.setConnected(string2);
        this.processDeviceConnectRes(0);
    }
}

