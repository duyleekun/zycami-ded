/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager$DeviceConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioManager$DeviceConfigManager {
    public String _bluetoothDevName;
    public String connectedDevice;
    public String connectingDevice;
    public HashMap deviceConfigs;
    public ReentrantLock mLock;
    public String prevConnectedDevice;
    public final /* synthetic */ TraeAudioManager this$0;
    public boolean visiableUpdate;

    public TraeAudioManager$DeviceConfigManager(TraeAudioManager object) {
        this.this$0 = object;
        this.deviceConfigs = object;
        object = "DEVICE_NONE";
        this.prevConnectedDevice = object;
        this.connectedDevice = object;
        this.connectingDevice = object;
        super();
        this.mLock = object;
        this.visiableUpdate = false;
        this._bluetoothDevName = "unknow";
    }

    public boolean _addConfig(String string2, int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(" devName:");
        ((StringBuilder)object).append(string2);
        String string3 = " priority:";
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(n10);
        AudioDeviceInterface.LogTraceEntry(((StringBuilder)object).toString());
        object = new TraeAudioManager$DeviceConfigManager$DeviceConfig(this);
        n10 = (int)(((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).init(string2, n10) ? 1 : 0);
        int n11 = 2;
        String string4 = "TRAE";
        if (n10 != 0) {
            boolean bl2;
            Object object2 = this.deviceConfigs;
            n10 = (int)(((HashMap)object2).containsKey(string2) ? 1 : 0);
            if (n10 != 0) {
                boolean bl3 = QLog.isColorLevel();
                if (bl3) {
                    string2 = "err dev exist!";
                    QLog.e(string4, n11, string2);
                }
                return false;
            }
            object2 = this.deviceConfigs;
            ((HashMap)object2).put(string2, object);
            this.visiableUpdate = bl2 = true;
            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n10 != 0) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(" n");
                int n12 = this.getDeviceNumber();
                ((StringBuilder)object2).append(n12);
                ((StringBuilder)object2).append(" 0:");
                object = this.getDeviceName(0);
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
                QLog.w(string4, n11, (String)object2);
            }
            AudioDeviceInterface.LogTraceExit();
            return bl2;
        }
        boolean bl4 = QLog.isColorLevel();
        if (bl4) {
            string2 = " err dev init!";
            QLog.e(string4, n11, string2);
        }
        return false;
    }

    public ArrayList _getAvailableDeviceList() {
        boolean bl2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.deviceConfigs.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)iterator2.next().getValue();
            if (object == null || !(bl3 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getVisible())) continue;
            object = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getDeviceName();
            arrayList.add(object);
        }
        return arrayList;
    }

    public String _getConnectedDevice() {
        boolean bl2;
        Object object = this.deviceConfigs;
        String string2 = this.connectedDevice;
        object = (object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)((HashMap)object).get(string2)) != null && (bl2 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getVisible()) ? this.connectedDevice : "DEVICE_NONE";
        return object;
    }

    public String _getPrevConnectedDevice() {
        boolean bl2;
        Object object = this.deviceConfigs;
        String string2 = this.prevConnectedDevice;
        object = (object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)((HashMap)object).get(string2)) != null && (bl2 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getVisible()) ? this.prevConnectedDevice : "DEVICE_NONE";
        return object;
    }

    public void clearConfig() {
        String string2;
        this.mLock.lock();
        this.deviceConfigs.clear();
        this.prevConnectedDevice = string2 = "DEVICE_NONE";
        this.connectedDevice = string2;
        this.connectingDevice = string2;
        this.mLock.unlock();
    }

    public ArrayList getAvailableDeviceList() {
        new ArrayList();
        this.mLock.lock();
        ArrayList arrayList = this._getAvailableDeviceList();
        this.mLock.unlock();
        return arrayList;
    }

    public String getAvailabledHighestPriorityDevice() {
        boolean bl2;
        this.mLock.lock();
        Object object = this.deviceConfigs.entrySet().iterator();
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            int n10;
            int n11;
            Object object3 = object.next();
            object3.getKey();
            object3.getValue();
            if ((object3 = (TraeAudioManager$DeviceConfigManager$DeviceConfig)object3.getValue()) == null || (n11 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object3).getVisible()) == 0 || object2 != null && (n11 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object3).getPriority()) < (n10 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object2).getPriority())) continue;
            object2 = object3;
        }
        object = this.mLock;
        ((ReentrantLock)object).unlock();
        object = object2 != null ? ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object2).getDeviceName() : "DEVICE_SPEAKERPHONE";
        return object;
    }

    public String getAvailabledHighestPriorityDevice(String object) {
        boolean bl2;
        this.mLock.lock();
        Iterator iterator2 = this.deviceConfigs.entrySet().iterator();
        Object object2 = null;
        while (bl2 = iterator2.hasNext()) {
            int n10;
            String string2;
            int n11;
            Object object3 = iterator2.next();
            object3.getKey();
            object3.getValue();
            if ((object3 = (TraeAudioManager$DeviceConfigManager$DeviceConfig)object3.getValue()) == null || (n11 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object3).getVisible()) == 0 || (n11 = (string2 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object3).getDeviceName()).equals(object)) != 0 || object2 != null && (n11 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object3).getPriority()) < (n10 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object2).getPriority())) continue;
            object2 = object3;
        }
        object = this.mLock;
        ((ReentrantLock)object).unlock();
        object = object2 != null ? ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object2).getDeviceName() : "DEVICE_SPEAKERPHONE";
        return object;
    }

    public String getBluetoothName() {
        return this._bluetoothDevName;
    }

    public String getConnectedDevice() {
        this.mLock.lock();
        String string2 = this._getConnectedDevice();
        this.mLock.unlock();
        return string2;
    }

    public String getConnectingDevice() {
        boolean bl2;
        this.mLock.lock();
        Object object = this.deviceConfigs;
        String string2 = this.connectingDevice;
        object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)((HashMap)object).get(string2);
        if (object != null && (bl2 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getVisible())) {
            object = this.connectingDevice;
        } else {
            bl2 = false;
            object = null;
        }
        this.mLock.unlock();
        return object;
    }

    public String getDeviceName(int n10) {
        Object object;
        block2: {
            boolean bl2;
            this.mLock.lock();
            Iterator iterator2 = this.deviceConfigs.entrySet().iterator();
            int n11 = 0;
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                if (n11 == n10) {
                    object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)entry.getValue();
                    break block2;
                }
                ++n11;
            }
            n10 = 0;
            object = null;
        }
        object = object != null ? ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getDeviceName() : "DEVICE_NONE";
        this.mLock.unlock();
        return object;
    }

    public int getDeviceNumber() {
        this.mLock.lock();
        int n10 = this.deviceConfigs.size();
        this.mLock.unlock();
        return n10;
    }

    public String getPrevConnectedDevice() {
        this.mLock.lock();
        String string2 = this._getPrevConnectedDevice();
        this.mLock.unlock();
        return string2;
    }

    public int getPriority(String object) {
        this.mLock.lock();
        HashMap hashMap = this.deviceConfigs;
        object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)hashMap.get(object);
        int n10 = object != null ? ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getPriority() : -1;
        this.mLock.unlock();
        return n10;
    }

    public HashMap getSnapParams() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        this.mLock.lock();
        Object object = this._getAvailableDeviceList();
        hashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", object);
        object = this._getConnectedDevice();
        hashMap.put("EXTRA_DATA_CONNECTEDDEVICE", object);
        object = this._getPrevConnectedDevice();
        hashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", object);
        this.mLock.unlock();
        return hashMap;
    }

    public boolean getVisiableUpdateFlag() {
        this.mLock.lock();
        boolean bl2 = this.visiableUpdate;
        this.mLock.unlock();
        return bl2;
    }

    public boolean getVisible(String object) {
        boolean bl2;
        this.mLock.lock();
        HashMap hashMap = this.deviceConfigs;
        object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)hashMap.get(object);
        if (object != null) {
            bl2 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getVisible();
        } else {
            bl2 = false;
            object = null;
        }
        this.mLock.unlock();
        return bl2;
    }

    public boolean init(String object) {
        int n10;
        StringBuilder stringBuilder = new StringBuilder();
        Object object2 = " strConfigs:";
        stringBuilder.append((String)object2);
        stringBuilder.append((String)object);
        AudioDeviceInterface.LogTraceEntry(stringBuilder.toString());
        int n11 = 0;
        stringBuilder = null;
        if (object != null && (n10 = object.length()) > 0) {
            CharSequence charSequence = "";
            object = object.replace("\n", charSequence);
            object2 = "\r";
            if ((object = object.replace((CharSequence)object2, charSequence)) != null && (n10 = object.length()) > 0) {
                object2 = ";";
                int n12 = object.indexOf((String)object2);
                if (n12 < 0) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append((String)object2);
                    object = ((StringBuilder)charSequence).toString();
                }
                if ((object = object.split((String)object2)) != null && (n12 = 1) <= (n10 = ((String[])object).length)) {
                    object2 = this.mLock;
                    ((ReentrantLock)object2).lock();
                    while (n11 < (n10 = ((String[])object).length)) {
                        object2 = object[n11];
                        this._addConfig((String)object2, n11);
                        ++n11;
                    }
                    this.mLock.unlock();
                    this.this$0.printDevices();
                    return n12 != 0;
                }
            }
        }
        return false;
    }

    public boolean isConnected(String string2) {
        boolean bl2;
        boolean bl3;
        this.mLock.lock();
        Object object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)this.deviceConfigs.get(string2);
        if (object != null && (bl3 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getVisible())) {
            object = this.connectedDevice;
            bl2 = ((String)object).equals(string2);
        } else {
            bl2 = false;
            string2 = null;
        }
        this.mLock.unlock();
        return bl2;
    }

    public void resetVisiableUpdateFlag() {
        this.mLock.lock();
        this.visiableUpdate = false;
        this.mLock.unlock();
    }

    public void setBluetoothName(String string2) {
        String string3 = "unknow";
        if (string2 == null) {
            this._bluetoothDevName = string3;
            return;
        }
        boolean bl2 = string2.isEmpty();
        this._bluetoothDevName = bl2 ? string3 : string2;
    }

    public boolean setConnected(String string2) {
        boolean bl2;
        boolean bl3;
        this.mLock.lock();
        Object object = (TraeAudioManager$DeviceConfigManager$DeviceConfig)this.deviceConfigs.get(string2);
        if (object != null && (bl3 = ((TraeAudioManager$DeviceConfigManager$DeviceConfig)object).getVisible())) {
            object = this.connectedDevice;
            if (object != null && !(bl3 = ((String)object).equals(string2))) {
                this.prevConnectedDevice = object = this.connectedDevice;
            }
            this.connectedDevice = string2;
            this.connectingDevice = string2 = "";
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        this.mLock.unlock();
        return bl2;
    }

    public boolean setConnecting(String string2) {
        boolean bl2;
        boolean bl3;
        this.mLock.lock();
        TraeAudioManager$DeviceConfigManager$DeviceConfig traeAudioManager$DeviceConfigManager$DeviceConfig = (TraeAudioManager$DeviceConfigManager$DeviceConfig)this.deviceConfigs.get(string2);
        if (traeAudioManager$DeviceConfigManager$DeviceConfig != null && (bl3 = traeAudioManager$DeviceConfigManager$DeviceConfig.getVisible())) {
            this.connectingDevice = string2;
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        this.mLock.unlock();
        return bl2;
    }

    public boolean setVisible(String string2, boolean bl2) {
        boolean bl3;
        this.mLock.lock();
        TraeAudioManager$DeviceConfigManager$DeviceConfig traeAudioManager$DeviceConfigManager$DeviceConfig = (TraeAudioManager$DeviceConfigManager$DeviceConfig)this.deviceConfigs.get(string2);
        boolean bl4 = true;
        if (traeAudioManager$DeviceConfigManager$DeviceConfig != null && (bl3 = traeAudioManager$DeviceConfigManager$DeviceConfig.getVisible()) != bl2) {
            traeAudioManager$DeviceConfigManager$DeviceConfig.setVisible(bl2);
            this.visiableUpdate = bl4;
            int n10 = QLog.isColorLevel();
            if (n10 != 0) {
                n10 = 2;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = " ++setVisible:";
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                string2 = bl2 ? " Y" : " N";
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                String string4 = "TRAE";
                QLog.w(string4, n10, string2);
            }
        } else {
            bl4 = false;
        }
        this.mLock.unlock();
        return bl4;
    }
}

