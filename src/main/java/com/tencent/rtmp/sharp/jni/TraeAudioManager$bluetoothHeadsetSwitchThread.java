/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioManager
 *  android.os.Build$VERSION
 */
package com.tencent.rtmp.sharp.jni;

import android.media.AudioManager;
import android.os.Build;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$switchThread;

public class TraeAudioManager$bluetoothHeadsetSwitchThread
extends TraeAudioManager$switchThread {
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$bluetoothHeadsetSwitchThread(TraeAudioManager traeAudioManager) {
        this.this$0 = traeAudioManager;
        super(traeAudioManager);
    }

    public void _quit() {
        AudioManager audioManager = this.this$0._am;
        if (audioManager == null) {
            return;
        }
        this._stopBluetoothSco();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void _run() {
        long l10;
        boolean bl2 = TraeAudioManager.IsMusicScene;
        int n10 = 2;
        String string2 = "TRAE";
        if (!bl2 && (bl2 = TraeAudioManager.IsUpdateSceneFlag)) {
            bl2 = TraeAudioManager.enableDeviceSwitchFlag;
            if (!bl2) {
                bl2 = QLog.isColorLevel();
                if (bl2) {
                    String string3 = "connect bluetoothHeadset: disableDeviceSwitchFlag";
                    QLog.w(string2, n10, string3);
                }
                return;
            }
            l10 = 1000L;
            Thread.sleep(l10);
        } else {
            bl2 = QLog.isColorLevel();
            if (bl2) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("connect bluetoothHeadset: do nothing, IsMusicScene:");
                boolean bl3 = TraeAudioManager.IsMusicScene;
                charSequence.append(bl3);
                String string4 = " ,IsUpdateSceneFlag:";
                charSequence.append(string4);
                bl3 = TraeAudioManager.IsUpdateSceneFlag;
                charSequence.append(bl3);
                charSequence = charSequence.toString();
                QLog.w(string2, n10, (String)charSequence);
            }
            this.updateStatus();
            return;
            catch (InterruptedException interruptedException) {}
        }
        this._startBluetoothSco();
        bl2 = false;
        TraeAudioManager traeAudioManager = null;
        int n11 = 0;
        CharSequence charSequence = null;
        while (true) {
            int n12;
            block17: {
                Object object;
                boolean bl4;
                n12 = this._running;
                int n13 = 10;
                int n14 = 1;
                if (n12 == n14) {
                    n12 = n11 + 1;
                    if (n11 < n13) {
                        n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                        if (n11 != 0) {
                            charSequence = new StringBuilder();
                            charSequence.append("bluetoothHeadsetSwitchThread i:");
                            charSequence.append(n12);
                            charSequence.append(" sco:");
                            Object object2 = this.this$0._am;
                            n14 = (int)(object2.isBluetoothScoOn() ? 1 : 0);
                            object2 = n14 != 0 ? "Y" : "N";
                            charSequence.append((String)object2);
                            charSequence.append(" :");
                            object2 = this.this$0._deviceConfigManager.getBluetoothName();
                            charSequence.append((String)object2);
                            charSequence = charSequence.toString();
                            QLog.w(string2, n10, (String)charSequence);
                        }
                        if ((n11 = (int)((charSequence = this.this$0._am).isBluetoothScoOn() ? 1 : 0)) != 0) {
                            this.updateStatus();
                        } else {
                            Thread.sleep(l10);
                            break block17;
                        }
                    }
                }
                if (!(bl4 = (object = this.this$0._am).isBluetoothScoOn())) {
                    bl4 = QLog.isColorLevel();
                    if (bl4) {
                        object = "bluetoothHeadsetSwitchThread sco fail,remove btheadset";
                        QLog.e(string2, n10, (String)object);
                    }
                    TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager = this.this$0._deviceConfigManager;
                    string2 = this.getDeviceName();
                    traeAudioManager$DeviceConfigManager.setVisible(string2, false);
                    this.processDeviceConnectRes(n13);
                    traeAudioManager = this.this$0;
                    traeAudioManager.checkAutoDeviceListUpdate();
                }
                return;
                catch (InterruptedException interruptedException) {}
            }
            n11 = n12;
        }
    }

    public void _startBluetoothSco() {
        AudioManager audioManager = this.this$0._am;
        audioManager.setBluetoothScoOn(true);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 8;
        if (n10 > n11) {
            audioManager = this.this$0._am;
            audioManager.startBluetoothSco();
        }
    }

    public void _stopBluetoothSco() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 8;
        if (n10 > n11) {
            AudioManager audioManager = this.this$0._am;
            audioManager.stopBluetoothSco();
        }
        this.this$0._am.setBluetoothScoOn(false);
    }

    public String getDeviceName() {
        return "DEVICE_BLUETOOTHHEADSET";
    }
}

