/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothProfile
 *  android.bluetooth.BluetoothProfile$ServiceListener
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.text.TextUtils
 */
package com.tencent.rtmp.sharp.jni;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$BluetoohHeadsetCheckInterface;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioManager$BluetoohHeadsetCheck
extends TraeAudioManager$BluetoohHeadsetCheckInterface
implements BluetoothProfile.ServiceListener {
    public BluetoothAdapter _adapter;
    public Context _ctx;
    public TraeAudioManager$DeviceConfigManager _devCfg;
    public BluetoothProfile _profile;
    private final ReentrantLock _profileLock;
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$BluetoohHeadsetCheck(TraeAudioManager object) {
        this.this$0 = object;
        super((TraeAudioManager)((Object)object));
        this._ctx = null;
        this._devCfg = null;
        this._adapter = null;
        this._profile = null;
        super();
        this._profileLock = object;
    }

    public void _addAction(IntentFilter intentFilter) {
        int n10 = QLog.isColorLevel();
        if (n10 != 0) {
            n10 = 2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append(" ");
            String string2 = this.interfaceDesc();
            charSequence.append(string2);
            charSequence.append(" _addAction");
            charSequence = charSequence.toString();
            string2 = "TRAE";
            QLog.w(string2, n10, (String)charSequence);
        }
        intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }

    public void _onReceive(Context object, Intent object2) {
        object = object2.getAction();
        String string2 = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
        int n10 = string2.equals(object);
        int n11 = 1;
        boolean bl2 = false;
        CharSequence charSequence = null;
        CharSequence charSequence2 = "android.bluetooth.device.extra.DEVICE";
        int n12 = -1;
        String string3 = "TRAE";
        int n13 = 2;
        if (n10 != 0) {
            String string4;
            object = "android.bluetooth.adapter.extra.CONNECTION_STATE";
            n10 = object2.getIntExtra((String)object, n12);
            String string5 = "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";
            n12 = object2.getIntExtra(string5, n12);
            object2 = (BluetoothDevice)object2.getParcelableExtra((String)charSequence2);
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append("BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE ");
                string5 = this.getBTAdapterConnectionState(n10);
                ((StringBuilder)charSequence2).append(string5);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                QLog.w(string3, n13, (String)charSequence2);
            }
            if (bl3 = QLog.isColorLevel()) {
                charSequence2 = new StringBuilder();
                string5 = "    EXTRA_PREVIOUS_CONNECTION_STATE ";
                ((StringBuilder)charSequence2).append(string5);
                string4 = this.getBTAdapterConnectionState(n12);
                ((StringBuilder)charSequence2).append(string4);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                QLog.w(string3, n13, (String)charSequence2);
            }
            if (bl3 = QLog.isColorLevel()) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append("    EXTRA_DEVICE ");
                ((StringBuilder)charSequence2).append(object2);
                string4 = " ";
                ((StringBuilder)charSequence2).append(string4);
                if (object2 != null) {
                    string4 = object2.getName();
                }
                ((StringBuilder)charSequence2).append(string4);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                QLog.w(string3, n13, (String)charSequence2);
            }
            charSequence2 = "DEVICE_BLUETOOTHHEADSET";
            if (n10 == n13) {
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 != 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("   dev:");
                    charSequence = object2.getName();
                    ((StringBuilder)object).append((String)charSequence);
                    charSequence = " connected,start sco...";
                    ((StringBuilder)object).append((String)charSequence);
                    object = ((StringBuilder)object).toString();
                    QLog.w(string3, n13, (String)object);
                }
                this._devCfg.setVisible((String)charSequence2, n11 != 0);
                object = this._devCfg;
                object2 = object2 != null ? object2.getName() : "unkown";
                ((TraeAudioManager$DeviceConfigManager)object).setBluetoothName((String)object2);
            } else if (n10 == 0) {
                object = this._devCfg;
                ((TraeAudioManager$DeviceConfigManager)object).setVisible((String)charSequence2, false);
            }
        } else {
            String string6 = "android.media.ACTION_SCO_AUDIO_STATE_UPDATED";
            object = object2.getAction();
            n10 = (int)(string6.equals(object) ? 1 : 0);
            if (n10 != 0) {
                boolean bl4;
                object = "android.media.extra.SCO_AUDIO_STATE";
                n10 = object2.getIntExtra((String)object, n12);
                string2 = "android.media.extra.SCO_AUDIO_PREVIOUS_STATE";
                n11 = object2.getIntExtra(string2, n12);
                object2 = (BluetoothDevice)object2.getParcelableExtra((String)charSequence2);
                bl2 = QLog.isColorLevel();
                if (bl2) {
                    charSequence = new StringBuilder();
                    charSequence2 = "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:";
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append(object2);
                    object2 = ((StringBuilder)charSequence).toString();
                    QLog.w(string3, n13, (String)object2);
                }
                if (bl4 = QLog.isColorLevel()) {
                    object2 = new StringBuilder();
                    charSequence = "   EXTRA_SCO_AUDIO_STATE ";
                    ((StringBuilder)object2).append((String)charSequence);
                    object = this.getSCOAudioStateExtraString(n10);
                    ((StringBuilder)object2).append((String)object);
                    object = ((StringBuilder)object2).toString();
                    QLog.w(string3, n13, (String)object);
                }
                if ((n10 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("   EXTRA_SCO_AUDIO_PREVIOUS_STATE ");
                    object2 = this.getSCOAudioStateExtraString(n11);
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    QLog.w(string3, n13, (String)object);
                }
            } else {
                object2 = "android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED";
                object = object2.getAction();
                n10 = (int)(((String)object2).equals(object) ? 1 : 0);
                if (n10 != 0) {
                    object = BluetoothAdapter.getDefaultAdapter();
                    int n14 = object.getProfileConnectionState(n13);
                    if (n14 != 0) {
                        if (n14 != n13) {
                            object2 = new StringBuilder();
                            string2 = "BluetoothA2dp";
                            ((StringBuilder)object2).append(string2);
                            n10 = object.getProfileConnectionState(n13);
                            ((StringBuilder)object2).append(n10);
                            object = ((StringBuilder)object2).toString();
                            QLog.w(string3, n13, (String)object);
                        } else {
                            QLog.w(string3, n13, "BluetoothA2dp STATE_CONNECTED");
                            object = this.this$0;
                            ((TraeAudioManager)object).IsBluetoothA2dpExisted = n11;
                        }
                    } else {
                        QLog.w(string3, n13, "BluetoothA2dp STATE_DISCONNECTED");
                        object = this.this$0;
                        ((TraeAudioManager)object).IsBluetoothA2dpExisted = false;
                    }
                }
            }
        }
    }

    public boolean init(Context object, TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager) {
        String string2 = "";
        AudioDeviceInterface.LogTraceEntry(string2);
        int n10 = 2;
        String string3 = "TRAE";
        if (object != null && traeAudioManager$DeviceConfigManager != null) {
            int n11;
            block14: {
                block15: {
                    this._ctx = object;
                    this._devCfg = traeAudioManager$DeviceConfigManager;
                    object = BluetoothAdapter.getDefaultAdapter();
                    this._adapter = object;
                    if (object == null) {
                        boolean bl2 = QLog.isColorLevel();
                        if (bl2) {
                            object = " err getDefaultAdapter fail!";
                            QLog.e(string3, n10, (String)object);
                        }
                        return false;
                    }
                    object = this._profileLock;
                    ((ReentrantLock)object).lock();
                    object = this._adapter;
                    boolean bl3 = object.isEnabled();
                    n11 = 1;
                    if (!bl3) break block14;
                    object = this._profile;
                    if (object != null) break block14;
                    object = this._adapter;
                    Context context = this._ctx;
                    bl3 = object.getProfileProxy(context, (BluetoothProfile.ServiceListener)this, n11);
                    if (bl3) break block14;
                    bl3 = QLog.isColorLevel();
                    if (!bl3) break block15;
                    object = "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!";
                    QLog.e(string3, n10, (String)object);
                }
                return false;
            }
            this._profileLock.unlock();
            AudioDeviceInterface.LogTraceExit();
            return n11 != 0;
            finally {
                this._profileLock.unlock();
            }
        }
        boolean bl4 = QLog.isColorLevel();
        if (bl4) {
            object = " err ctx==null||_devCfg==null";
            QLog.e(string3, n10, (String)object);
        }
        return false;
    }

    public String interfaceDesc() {
        return "BluetoohHeadsetCheck";
    }

    public boolean isConnected() {
        int n10;
        block4: {
            Object object;
            block5: {
                object = this._profileLock;
                ((ReentrantLock)object).lock();
                try {
                    object = this._profile;
                    n10 = 0;
                    if (object == null) break block4;
                }
                catch (Throwable throwable) {
                    this._profileLock.unlock();
                    throw throwable;
                }
                object = object.getConnectedDevices();
                if (object != null) break block5;
                this._profileLock.unlock();
                return false;
            }
            int n11 = object.size();
            if (n11 <= 0) break block4;
            n10 = n11 = 1;
        }
        this._profileLock.unlock();
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onServiceConnected(int n10, BluetoothProfile bluetoothProfile) {
        block19: {
            String string2;
            Object object;
            boolean bl2;
            block20: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("_profile:");
                BluetoothProfile bluetoothProfile2 = this._profile;
                stringBuilder.append(bluetoothProfile2);
                stringBuilder.append(" profile:");
                stringBuilder.append(n10);
                String string3 = " proxy:";
                stringBuilder.append(string3);
                stringBuilder.append(bluetoothProfile);
                String string4 = stringBuilder.toString();
                AudioDeviceInterface.LogTraceEntry(string4);
                bl2 = true;
                if (n10 != bl2) break block19;
                object = this._profileLock;
                ((ReentrantLock)object).lock();
                try {
                    CharSequence charSequence;
                    object = this._profile;
                    String string5 = " _profile:";
                    string2 = null;
                    String string6 = "TRAE";
                    int n11 = 2;
                    if (object != null && object != bluetoothProfile) {
                        n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                        if (n10 != 0) {
                            object = new StringBuilder();
                            charSequence = "BluetoohHeadsetCheck: HEADSET Connected proxy:";
                            ((StringBuilder)object).append((String)charSequence);
                            ((StringBuilder)object).append(bluetoothProfile);
                            ((StringBuilder)object).append(string5);
                            charSequence = this._profile;
                            ((StringBuilder)object).append((Object)charSequence);
                            object = ((StringBuilder)object).toString();
                            QLog.w(string6, n11, (String)object);
                        }
                        object = this._adapter;
                        charSequence = this._profile;
                        object.closeProfileProxy((int)(bl2 ? 1 : 0), (BluetoothProfile)charSequence);
                        this._profile = null;
                    }
                    this._profile = bluetoothProfile;
                    if (bluetoothProfile != null) {
                        object = bluetoothProfile.getConnectedDevices();
                    } else {
                        n10 = 0;
                        object = null;
                    }
                    bluetoothProfile = null;
                    if (object != null && (charSequence = this._profile) != null) {
                        int n12;
                        String string7;
                        int n13 = QLog.isColorLevel();
                        if (n13 != 0) {
                            charSequence = new StringBuilder();
                            string7 = "TRAEBluetoohProxy: HEADSET Connected devs:";
                            ((StringBuilder)charSequence).append(string7);
                            n12 = object.size();
                            ((StringBuilder)charSequence).append(n12);
                            ((StringBuilder)charSequence).append(string5);
                            BluetoothProfile bluetoothProfile3 = this._profile;
                            ((StringBuilder)charSequence).append(bluetoothProfile3);
                            String string8 = ((StringBuilder)charSequence).toString();
                            QLog.w(string6, n11, string8);
                        }
                        Object var4_11 = null;
                        for (int i10 = 0; i10 < (n13 = object.size()); ++i10) {
                            String string9;
                            Object object2;
                            boolean bl3;
                            block18: {
                                block17: {
                                    charSequence = object.get(i10);
                                    charSequence = (BluetoothDevice)charSequence;
                                    try {
                                        string7 = this._profile;
                                        if (string7 == null) break block17;
                                        n12 = string7.getConnectionState((BluetoothDevice)charSequence);
                                        break block18;
                                    }
                                    catch (Exception exception) {
                                        bl3 = QLog.isColorLevel();
                                        if (!bl3) break block17;
                                        object2 = new StringBuilder();
                                        string9 = "get bluetooth connection state failed.";
                                        ((StringBuilder)object2).append(string9);
                                        string7 = exception.getMessage();
                                        ((StringBuilder)object2).append(string7);
                                        string7 = ((StringBuilder)object2).toString();
                                        QLog.e(string6, n11, string7);
                                    }
                                }
                                n12 = 0;
                                string7 = null;
                            }
                            if (n12 == n11) {
                                object2 = this._devCfg;
                                string9 = charSequence.getName();
                                ((TraeAudioManager$DeviceConfigManager)object2).setBluetoothName(string9);
                            }
                            if (!(bl3 = QLog.isColorLevel())) continue;
                            object2 = new StringBuilder();
                            string9 = "   ";
                            ((StringBuilder)object2).append(string9);
                            ((StringBuilder)object2).append(i10);
                            string9 = " ";
                            ((StringBuilder)object2).append(string9);
                            charSequence = charSequence.getName();
                            ((StringBuilder)object2).append((String)charSequence);
                            charSequence = " ConnectionState:";
                            ((StringBuilder)object2).append((String)charSequence);
                            ((StringBuilder)object2).append(n12);
                            charSequence = ((StringBuilder)object2).toString();
                            QLog.w(string6, n11, (String)charSequence);
                        }
                    }
                    this._profileLock.unlock();
                    object = this._devCfg;
                    if (object == null) break block19;
                    object = this.this$0._deviceConfigManager;
                    if (object == null) break block20;
                    string2 = ((TraeAudioManager$DeviceConfigManager)object).getBluetoothName();
                }
                catch (Throwable throwable) {
                    this._profileLock.unlock();
                    throw throwable;
                }
            }
            n10 = (int)(TextUtils.isEmpty(string2) ? 1 : 0);
            String string10 = "DEVICE_BLUETOOTHHEADSET";
            if (n10 != 0) {
                object = this._devCfg;
                ((TraeAudioManager$DeviceConfigManager)object).setVisible(string10, false);
            } else {
                n10 = (int)(this.isConnected() ? 1 : 0);
                if (n10 != 0) {
                    this._devCfg.setVisible(string10, bl2);
                    object = this.this$0;
                    ((TraeAudioManager)((Object)object)).checkDevicePlug(string10, bl2);
                } else {
                    object = this._devCfg;
                    ((TraeAudioManager$DeviceConfigManager)object).setVisible(string10, false);
                }
            }
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public void onServiceDisconnected(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("_profile:");
        Object object = this._profile;
        charSequence.append(object);
        object = " profile:";
        charSequence.append((String)object);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        AudioDeviceInterface.LogTraceEntry((String)charSequence);
        int n11 = 1;
        if (n10 == n11) {
            Object object2;
            block8: {
                String string2;
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 != 0) {
                    n10 = 2;
                    object = "TRAE";
                    string2 = "TRAEBluetoohProxy: HEADSET Disconnected";
                    QLog.w((String)object, n10, string2);
                }
                if ((n10 = (int)(this.isConnected() ? 1 : 0)) != 0) {
                    object2 = this.this$0;
                    object = null;
                    string2 = "DEVICE_BLUETOOTHHEADSET";
                    ((TraeAudioManager)((Object)object2)).checkDevicePlug(string2, false);
                }
                object2 = this._profileLock;
                ((ReentrantLock)object2).lock();
                try {
                    object2 = this._profile;
                    if (object2 == null) break block8;
                }
                catch (Throwable throwable) {
                    this._profileLock.unlock();
                    throw throwable;
                }
                object = this._adapter;
                object.closeProfileProxy(n11, (BluetoothProfile)object2);
                n10 = 0;
                object2 = null;
                this._profile = null;
            }
            object2 = this._profileLock;
            ((ReentrantLock)object2).unlock();
        }
        AudioDeviceInterface.LogTraceExit();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        block7: {
            var1_1 = new StringBuilder();
            var1_1.append("_profile:");
            var2_4 /* !! */  = this._profile;
            var1_1.append(var2_4 /* !! */ );
            AudioDeviceInterface.LogTraceEntry(var1_1.toString());
            var1_1 = this._profileLock;
            var1_1.lock();
            var1_1 = this._adapter;
            if (var1_1 != null) {
                var2_4 /* !! */  = this._profile;
                if (var2_4 /* !! */  != null) {
                    var3_5 = 1;
                    var1_1.closeProfileProxy(var3_5, var2_4 /* !! */ );
                }
                var1_1 = null;
                this._profile = null;
            }
lbl19:
            // 5 sources

            while (true) {
                var1_1 = this._profileLock;
                var1_1.unlock();
                break;
            }
            {
                catch (Throwable var1_2) {
                    break block7;
                }
                catch (Exception var1_3) {}
                {
                    var4_7 = QLog.isColorLevel();
                    if (!var4_7) ** GOTO lbl19
                    var2_4 /* !! */  = "TRAE";
                    var3_6 = 2;
                    var5_8 = new StringBuilder();
                    var6_9 = " closeProfileProxy:e:";
                    var5_8.append(var6_9);
                    var1_1 = var1_3.getMessage();
                    var5_8.append((String)var1_1);
                    var1_1 = var5_8.toString();
                    QLog.w((String)var2_4 /* !! */ , var3_6, (String)var1_1);
                    ** continue;
                }
            }
            AudioDeviceInterface.LogTraceExit();
            return;
        }
        this._profileLock.unlock();
        throw var1_2;
    }
}

