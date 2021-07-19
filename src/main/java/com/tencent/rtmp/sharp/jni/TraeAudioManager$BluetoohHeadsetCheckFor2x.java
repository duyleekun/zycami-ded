/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$BluetoohHeadsetCheckInterface;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TraeAudioManager$BluetoohHeadsetCheckFor2x
extends TraeAudioManager$BluetoohHeadsetCheckInterface {
    public static final String ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED = "android.bluetooth.headset.action.AUDIO_STATE_CHANGED";
    public static final String ACTION_BLUETOOTHHEADSET_STATE_CHANGED = "android.bluetooth.headset.action.STATE_CHANGED";
    public static final int AUDIO_STATE_CONNECTED = 1;
    public static final int AUDIO_STATE_DISCONNECTED = 0;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_DISCONNECTED;
    public Class BluetoothHeadsetClass;
    public Object BluetoothHeadsetObj;
    public Class ListenerClass;
    public Context _ctx;
    public TraeAudioManager$DeviceConfigManager _devCfg;
    public Method getCurrentHeadsetMethod;
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$BluetoohHeadsetCheckFor2x(TraeAudioManager traeAudioManager) {
        this.this$0 = traeAudioManager;
        super(traeAudioManager);
        this.BluetoothHeadsetClass = null;
        this.ListenerClass = null;
        this.BluetoothHeadsetObj = null;
        this.getCurrentHeadsetMethod = null;
        this._ctx = null;
        this._devCfg = null;
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
        intentFilter.addAction(ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED);
        intentFilter.addAction(ACTION_BLUETOOTHHEADSET_STATE_CHANGED);
    }

    public void _onReceive(Context object, Intent intent) {
        object = intent.getAction();
        int n10 = ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED.equals(object);
        boolean bl2 = true;
        String string2 = "       AUDIO_STATE ";
        String string3 = "       PREVIOUS_STATE ";
        CharSequence charSequence = "android.bluetooth.headset.extra.AUDIO_STATE";
        String string4 = "android.bluetooth.headset.extra.PREVIOUS_STATE";
        String string5 = "android.bluetooth.headset.extra.STATE";
        String string6 = "DEVICE_BLUETOOTHHEADSET";
        String string7 = "TRAE";
        int n11 = -2;
        int n12 = 2;
        if (n10 != 0) {
            n10 = intent.getIntExtra(string5, n11);
            int n13 = intent.getIntExtra(string4, n11);
            int n14 = intent.getIntExtra((String)charSequence, n11);
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                charSequence = new StringBuilder();
                string5 = "++ AUDIO_STATE_CHANGED|  STATE ";
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append(n10);
                object = ((StringBuilder)charSequence).toString();
                QLog.w(string7, n12, (String)object);
            }
            if ((n10 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(n13);
                object = ((StringBuilder)object).toString();
                QLog.w(string7, n12, (String)object);
            }
            if ((n10 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(n14);
                object = ((StringBuilder)object).toString();
                QLog.w(string7, n12, (String)object);
            }
            if (n14 == n12) {
                object = this._devCfg;
                ((TraeAudioManager$DeviceConfigManager)object).setVisible(string6, bl2);
            } else if (n14 == 0) {
                object = this._devCfg;
                ((TraeAudioManager$DeviceConfigManager)object).setVisible(string6, false);
            }
        } else {
            String string8 = ACTION_BLUETOOTHHEADSET_STATE_CHANGED;
            object = intent.getAction();
            n10 = (int)(string8.equals(object) ? 1 : 0);
            if (n10 != 0) {
                n10 = intent.getIntExtra(string5, n11);
                int n15 = intent.getIntExtra(string4, n11);
                int n16 = intent.getIntExtra((String)charSequence, n11);
                boolean bl4 = QLog.isColorLevel();
                if (bl4) {
                    charSequence = new StringBuilder();
                    string5 = "++ STATE_CHANGED|  STATE ";
                    ((StringBuilder)charSequence).append(string5);
                    ((StringBuilder)charSequence).append(n10);
                    object = ((StringBuilder)charSequence).toString();
                    QLog.w(string7, n12, (String)object);
                }
                if ((n10 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(n15);
                    object = ((StringBuilder)object).toString();
                    QLog.w(string7, n12, (String)object);
                }
                if ((n10 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(n16);
                    object = ((StringBuilder)object).toString();
                    QLog.w(string7, n12, (String)object);
                }
                if (n16 == n12) {
                    object = this._devCfg;
                    ((TraeAudioManager$DeviceConfigManager)object).setVisible(string6, bl2);
                } else if (n16 == 0) {
                    object = this._devCfg;
                    ((TraeAudioManager$DeviceConfigManager)object).setVisible(string6, false);
                }
            }
        }
    }

    public boolean init(Context object, TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager) {
        String string2 = "TRAE";
        AudioDeviceInterface.LogTraceEntry("");
        this._ctx = object;
        this._devCfg = traeAudioManager$DeviceConfigManager;
        if (object != null && traeAudioManager$DeviceConfigManager != null) {
            boolean bl2;
            int n10;
            int n11;
            block39: {
                Object[] objectArray;
                Constructor constructor;
                Object object2;
                block38: {
                    block37: {
                        block36: {
                            n11 = 2;
                            object2 = "android.bluetooth.BluetoothHeadset";
                            object2 = Class.forName((String)object2);
                            try {
                                this.BluetoothHeadsetClass = object2;
                            }
                            catch (Exception exception) {
                                boolean n102 = QLog.isColorLevel();
                                if (!n102) break block36;
                                object2 = "BTLooperThread BluetoothHeadset class not found";
                                QLog.e(string2, n11, (String)object2);
                            }
                        }
                        object2 = this.BluetoothHeadsetClass;
                        if (object2 == null) {
                            return false;
                        }
                        object2 = "android.bluetooth.BluetoothHeadset$ServiceListener";
                        object2 = Class.forName((String)object2);
                        try {
                            this.ListenerClass = object2;
                        }
                        catch (Exception exception) {
                            boolean bl3 = QLog.isColorLevel();
                            if (!bl3) break block37;
                            constructor = new Constructor();
                            objectArray = "BTLooperThread BluetoothHeadset.ServiceListener class not found:";
                            ((StringBuilder)((Object)constructor)).append((String)objectArray);
                            ((StringBuilder)((Object)constructor)).append(exception);
                            object2 = ((StringBuilder)((Object)constructor)).toString();
                            QLog.e(string2, n11, (String)object2);
                        }
                    }
                    object2 = this.BluetoothHeadsetClass;
                    constructor = "getCurrentHeadset";
                    objectArray = new Class[]{};
                    object2 = ((Class)object2).getDeclaredMethod((String)((Object)constructor), (Class<?>[])objectArray);
                    try {
                        this.getCurrentHeadsetMethod = object2;
                    }
                    catch (NoSuchMethodException noSuchMethodException) {
                        boolean bl4 = QLog.isColorLevel();
                        if (!bl4) break block38;
                        object2 = "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException";
                        QLog.e(string2, n11, (String)object2);
                    }
                }
                object2 = this.getCurrentHeadsetMethod;
                if (object2 == null) {
                    return false;
                }
                n10 = 1;
                constructor = this.BluetoothHeadsetClass;
                objectArray = new Class[n11];
                Class clazz = Context.class;
                objectArray[0] = clazz;
                clazz = this.ListenerClass;
                objectArray[n10] = clazz;
                constructor = ((Class)((Object)constructor)).getConstructor((Class<?>[])objectArray);
                objectArray = new Object[n11];
                objectArray[0] = object;
                bl2 = false;
                object = null;
                objectArray[n10] = null;
                object = constructor.newInstance(objectArray);
                try {
                    this.BluetoothHeadsetObj = object;
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        object = "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException";
                        QLog.e(string2, n11, (String)object);
                    }
                }
                catch (InvocationTargetException invocationTargetException) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        object = "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException";
                        QLog.e(string2, n11, (String)object);
                    }
                }
                catch (IllegalAccessException illegalAccessException) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        object = "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException";
                        QLog.e(string2, n11, (String)object);
                    }
                }
                catch (InstantiationException instantiationException) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        object = "BTLooperThread BluetoothHeadset getConstructor InstantiationException";
                        QLog.e(string2, n11, (String)object);
                    }
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    bl2 = QLog.isColorLevel();
                    if (!bl2) break block39;
                    object = "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException";
                    QLog.e(string2, n11, (String)object);
                }
            }
            object = this.BluetoothHeadsetObj;
            if (object == null) {
                return false;
            }
            object = this._devCfg;
            n11 = (int)(this.isConnected() ? 1 : 0);
            string2 = "DEVICE_BLUETOOTHHEADSET";
            object.setVisible(string2, n11 != 0);
            bl2 = this.isConnected();
            if (bl2) {
                this._devCfg.setVisible(string2, n10 != 0);
                object = this.this$0;
                object.checkDevicePlug(string2, n10 != 0);
            } else {
                object = this._devCfg;
                object.setVisible(string2, false);
            }
            AudioDeviceInterface.LogTraceExit();
            return n10 != 0;
        }
        return false;
    }

    public String interfaceDesc() {
        return "BluetoohHeadsetCheckFor2x";
    }

    public boolean isConnected() {
        String string2 = "TRAE";
        Object object = this.getCurrentHeadsetMethod;
        boolean bl2 = false;
        if (object != null && object != null) {
            Object object2;
            Object object3;
            int n10;
            block11: {
                boolean bl3;
                block12: {
                    n10 = 2;
                    object3 = this.BluetoothHeadsetObj;
                    object2 = new Object[]{};
                    try {
                        object = ((Method)object).invoke(object3, object2);
                        break block11;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                        bl3 = QLog.isColorLevel();
                        if (bl3) {
                            object = "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException";
                            QLog.w(string2, n10, (String)object);
                        }
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        bl3 = QLog.isColorLevel();
                        if (bl3) {
                            object = "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException";
                            QLog.w(string2, n10, (String)object);
                        }
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        bl3 = QLog.isColorLevel();
                        if (!bl3) break block12;
                        object = "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException";
                        QLog.w(string2, n10, (String)object);
                    }
                }
                bl3 = false;
                object = null;
            }
            boolean bl4 = QLog.isColorLevel();
            if (bl4) {
                object3 = new StringBuilder();
                object2 = "BTLooperThread BluetoothHeadset method getCurrentHeadset res:";
                ((StringBuilder)object3).append((String)object2);
                object2 = object != null ? " Y" : "N";
                ((StringBuilder)object3).append((String)object2);
                object3 = ((StringBuilder)object3).toString();
                QLog.w(string2, n10, (String)object3);
            }
            if (object != null) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public void release() {
        block11: {
            boolean bl2;
            String string2 = "TRAE";
            AudioDeviceInterface.LogTraceEntry("");
            Object object = this.BluetoothHeadsetObj;
            if (object == null) {
                return;
            }
            int n10 = 2;
            Object[] objectArray = null;
            Object object2 = this.BluetoothHeadsetClass;
            Object object3 = "close";
            Class[] classArray = new Class[]{};
            try {
                object2 = ((Class)object2).getDeclaredMethod((String)object3, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                bl2 = QLog.isColorLevel();
                if (bl2) {
                    object2 = "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException";
                    QLog.e(string2, n10, (String)object2);
                }
                bl2 = false;
                object2 = null;
            }
            if (object2 == null) {
                return;
            }
            object3 = this.BluetoothHeadsetObj;
            objectArray = new Object[]{};
            try {
                ((Method)object2).invoke(object3, objectArray);
            }
            catch (Exception exception) {
                bl2 = QLog.isColorLevel();
                if (!bl2) break block11;
                object2 = new StringBuilder();
                object3 = "close bluetooth headset failed.";
                ((StringBuilder)object2).append((String)object3);
                String string3 = exception.getMessage();
                ((StringBuilder)object2).append(string3);
                string3 = ((StringBuilder)object2).toString();
                QLog.e(string2, n10, string3);
            }
        }
        this.BluetoothHeadsetClass = null;
        this.ListenerClass = null;
        this.BluetoothHeadsetObj = null;
        this.getCurrentHeadsetMethod = null;
        AudioDeviceInterface.LogTraceExit();
    }
}

