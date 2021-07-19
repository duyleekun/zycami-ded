/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.media.AudioManager
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 */
package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$1;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$3;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$BluetoohHeadsetCheck;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$BluetoohHeadsetCheckFake;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$BluetoohHeadsetCheckFor2x;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$BluetoohHeadsetCheckInterface;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$bluetoothHeadsetSwitchThread;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$earphoneSwitchThread;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$headsetSwitchThread;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$speakerSwitchThread;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$switchThread;
import com.tencent.rtmp.sharp.jni.TraeAudioSession;
import com.tencent.rtmp.sharp.jni.TraeAudioSessionHost;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioManager
extends BroadcastReceiver {
    public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
    public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
    public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
    public static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP = 128;
    public static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    public static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    public static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO = 16;
    public static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
    public static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
    public static final int AUDIO_DEVICE_OUT_EARPIECE = 1;
    public static final int AUDIO_DEVICE_OUT_SPEAKER = 2;
    public static final int AUDIO_DEVICE_OUT_WIRED_HEADPHONE = 8;
    public static final int AUDIO_DEVICE_OUT_WIRED_HEADSET = 4;
    public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
    public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
    public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
    public static final String AUDIO_PARAMETER_STREAM_ROUTING = "routing";
    public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
    public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
    public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
    public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
    public static final String DEVICE_NONE = "DEVICE_NONE";
    public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
    public static final int DEVICE_STATUS_CONNECTED = 2;
    public static final int DEVICE_STATUS_CONNECTING = 1;
    public static final int DEVICE_STATUS_DISCONNECTED = 0;
    public static final int DEVICE_STATUS_DISCONNECTING = 3;
    public static final int DEVICE_STATUS_ERROR = 255;
    public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
    public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
    public static final int EARACTION_AWAY = 0;
    public static final int EARACTION_CLOSE = 1;
    public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
    public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
    public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
    public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
    public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
    public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
    public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
    public static final int FORCE_ANALOG_DOCK = 8;
    public static final int FORCE_BT_A2DP = 4;
    public static final int FORCE_BT_CAR_DOCK = 6;
    public static final int FORCE_BT_DESK_DOCK = 7;
    public static final int FORCE_BT_SCO = 3;
    public static final int FORCE_DEFAULT = 0;
    public static final int FORCE_DIGITAL_DOCK = 9;
    public static final int FORCE_HEADPHONES = 2;
    public static final int FORCE_NONE = 0;
    public static final int FORCE_NO_BT_A2DP = 10;
    public static final int FORCE_SPEAKER = 1;
    public static final int FORCE_WIRED_ACCESSORY = 5;
    public static final int FOR_COMMUNICATION = 0;
    public static final int FOR_DOCK = 3;
    public static final int FOR_MEDIA = 1;
    public static final int FOR_RECORD = 2;
    public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
    public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
    public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
    public static boolean IsEarPhoneSupported = false;
    public static boolean IsMusicScene = false;
    public static boolean IsUpdateSceneFlag = false;
    public static final int MODE_MUSIC_PLAYBACK = 2;
    public static final int MODE_MUSIC_PLAY_RECORD = 1;
    public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
    public static final int MODE_MUSIC_PLAY_RECORD_LOW_QUALITY = 5;
    public static final int MODE_VOICE_CHAT = 0;
    public static final int MODE_VOICE_PLAYBACK = 4;
    public static final String MUSIC_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
    public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
    public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
    public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
    public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
    public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
    public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
    public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
    private static final int NUM_FORCE_CONFIG = 11;
    private static final int NUM_FORCE_USE = 4;
    public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
    public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
    public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
    public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
    public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
    public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
    public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
    public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
    public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
    public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
    public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
    public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
    public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
    public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
    public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
    public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
    public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
    public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
    public static final String PARAM_DEVICE = "PARAM_DEVICE";
    public static final String PARAM_ERROR = "PARAM_ERROR";
    public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
    public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
    public static final String PARAM_OPERATION = "PARAM_OPERATION";
    public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
    public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
    public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
    public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
    public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
    public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
    public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
    public static final String PARAM_RING_URI = "PARAM_RING_URI";
    public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
    public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
    public static final String PARAM_STATUS = "PARAM_STATUS";
    public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
    public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
    public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
    public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
    public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
    public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
    public static final int RES_ERRCODE_NONE = 0;
    public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
    public static final int RES_ERRCODE_SERVICE_OFF = 1;
    public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
    public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
    public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
    public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
    public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    public static int _gHostProcessId = 0;
    public static TraeAudioManager _ginstance;
    public static ReentrantLock _glock;
    public static boolean enableDeviceSwitchFlag = true;
    public static final String[] forceName;
    public boolean IsBluetoothA2dpExisted;
    public int _activeMode = 0;
    public AudioManager _am = null;
    public TraeAudioSessionHost _audioSessionHost;
    public TraeAudioManager$BluetoohHeadsetCheckInterface _bluetoothCheck;
    public Context _context = null;
    public TraeAudioManager$DeviceConfigManager _deviceConfigManager;
    public ReentrantLock _lock;
    public int _modePolicy = -1;
    public int _prevMode = 0;
    public int _streamType = 0;
    public TraeAudioManager$switchThread _switchThread;
    public TraeAudioManager$TraeAudioManagerLooper mTraeAudioManagerLooper;
    public String sessionConnectedDev;

    static {
        ReentrantLock reentrantLock;
        _glock = reentrantLock = new ReentrantLock();
        _ginstance = null;
        _gHostProcessId = -1;
        forceName = new String[]{"FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK"};
    }

    public TraeAudioManager(Context object) {
        boolean bl2;
        this.IsBluetoothA2dpExisted = bl2 = true;
        Object object2 = new TraeAudioSessionHost();
        this._audioSessionHost = object2;
        this._deviceConfigManager = object2 = new TraeAudioManager$DeviceConfigManager(this);
        this._bluetoothCheck = null;
        this.sessionConnectedDev = DEVICE_NONE;
        this.mTraeAudioManagerLooper = null;
        this._lock = object2 = new ReentrantLock();
        this._switchThread = null;
        CharSequence charSequence = new StringBuilder();
        object2 = " context:";
        charSequence.append((String)object2);
        charSequence.append(object);
        charSequence = charSequence.toString();
        AudioDeviceInterface.LogTraceEntry((String)charSequence);
        if (object == null) {
            return;
        }
        this._context = object;
        super(this, this);
        this.mTraeAudioManagerLooper = object;
        AudioDeviceInterface.LogTraceExit();
    }

    public static boolean IsEabiLowVersion() {
        boolean bl2;
        Object object;
        String string2 = Build.CPU_ABI;
        int n10 = Build.VERSION.SDK_INT;
        boolean bl3 = true;
        int n11 = 8;
        if (n10 >= n11) {
            object = Build.class;
            String string3 = "CPU_ABI2";
            try {
                object = ((Class)object).getDeclaredField(string3);
                n11 = 0;
                string3 = null;
            }
            catch (Exception exception) {
                boolean bl4 = TraeAudioManager.IsEabiLowVersionByAbi(string2);
                if (bl4) {
                    return bl3;
                }
                return false;
            }
            object = ((Field)object).get(null);
            object = (String)object;
        } else {
            object = "unknown";
        }
        n11 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n11 != 0) {
            n11 = 2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("IsEabiVersion CPU_ABI:");
            charSequence.append(string2);
            charSequence.append(" CPU_ABI2:");
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            String string4 = "TRAE";
            QLog.w(string4, n11, (String)charSequence);
        }
        if ((bl2 = TraeAudioManager.IsEabiLowVersionByAbi(string2)) && (bl2 = TraeAudioManager.IsEabiLowVersionByAbi((String)object))) {
            return bl3;
        }
        return false;
    }

    public static boolean IsEabiLowVersionByAbi(String string2) {
        boolean bl2 = true;
        if (string2 == null) {
            return bl2;
        }
        String string3 = "x86";
        boolean bl3 = string2.contains(string3);
        if (bl3) {
            return false;
        }
        string3 = "mips";
        bl3 = string2.contains(string3);
        if (bl3) {
            return false;
        }
        string3 = "armeabi";
        bl3 = string2.equalsIgnoreCase(string3);
        if (bl3) {
            return bl2;
        }
        string3 = "armeabi-v7a";
        bl3 = string2.equalsIgnoreCase(string3);
        if (bl3) {
            return false;
        }
        string3 = "arm64-v8a";
        boolean bl4 = string2.equalsIgnoreCase(string3);
        if (bl4) {
            return false;
        }
        return bl2;
    }

    public static int SetSpeakerForTest(Context context, boolean bl2) {
        int n10;
        _glock.lock();
        Object object = _ginstance;
        if (object != null) {
            n10 = object.InternalSetSpeaker(context, bl2);
        } else {
            n10 = QLog.isColorLevel();
            if (n10 != 0) {
                n10 = 2;
                String string2 = "TRAE";
                object = "TraeAudioManager|static SetSpeakerForTest|null == _ginstance";
                QLog.w(string2, n10, (String)object);
            }
            n10 = -1;
        }
        _glock.unlock();
        return n10;
    }

    public static boolean checkDevName(String string2) {
        boolean bl2;
        if (string2 == null) {
            return false;
        }
        String string3 = DEVICE_SPEAKERPHONE;
        boolean bl3 = string3.equals(string2);
        return bl3 || (bl3 = (string3 = DEVICE_EARPHONE).equals(string2)) || (bl3 = (string3 = DEVICE_WIREDHEADSET).equals(string2)) || (bl2 = (string3 = DEVICE_BLUETOOTHHEADSET).equals(string2));
    }

    public static int connectDevice(String object, long l10, boolean bl2, String string2) {
        if (string2 == null) {
            return -1;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        hashMap.put(CONNECTDEVICE_DEVICENAME, string2);
        hashMap.put(PARAM_DEVICE, string2);
        return TraeAudioManager.sendMessage(32775, hashMap);
    }

    public static int connectHighestPriorityDevice(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32789, hashMap);
    }

    public static int disableDeviceSwitch() {
        enableDeviceSwitchFlag = false;
        return 0;
    }

    public static int earAction(String object, long l10, boolean bl2, int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1)) {
            return -1;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        object = n10;
        hashMap.put(EXTRA_EARACTION, object);
        return TraeAudioManager.sendMessage(32776, hashMap);
    }

    public static void forceVolumeControlStream(AudioManager object, int n10) {
        Object object2;
        Object object3 = Build.MANUFACTURER;
        String string2 = "Google";
        boolean n11 = ((String)object3).equals(string2);
        int n12 = 2;
        String string3 = "TRAE";
        if (n11) {
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = "forceVolumeControlStream, Google phone nothing to do";
                QLog.w(string3, n12, (String)object);
            }
            return;
        }
        int n13 = 1;
        Object object4 = new Object[n13];
        object4[0] = object2 = Integer.valueOf(n10);
        object3 = new Class[n13];
        object2 = Integer.TYPE;
        object3[0] = object2;
        object2 = "forceVolumeControlStream";
        object = TraeAudioManager.invokeMethod(object, (String)object2, object4, (Class[])object3);
        boolean bl3 = QLog.isColorLevel();
        if (bl3) {
            object3 = new StringBuilder();
            object4 = "forceVolumeControlStream  streamType:";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(n10);
            String string4 = " res:";
            ((StringBuilder)object3).append(string4);
            ((StringBuilder)object3).append(object);
            object = ((StringBuilder)object3).toString();
            QLog.w(string3, n12, (String)object);
        }
    }

    public static int getAudioSource(int n10) {
        int n11 = IsMusicScene;
        int n12 = 0;
        if (n11 != 0) {
            return 0;
        }
        n11 = TraeAudioManager.IsEabiLowVersion();
        String string2 = " source:";
        int n13 = 2;
        String string3 = "TRAE";
        if (n11 != 0) {
            n11 = QLog.isColorLevel();
            if (n11 != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:";
                stringBuilder.append(string4);
                stringBuilder.append(n10);
                stringBuilder.append(string2);
                stringBuilder.append(0);
                String string5 = stringBuilder.toString();
                QLog.w(string3, n13, string5);
            }
            return 0;
        }
        n11 = Build.VERSION.SDK_INT;
        String string6 = "[Config] getAudioSource _audioSourcePolicy:";
        if (n10 >= 0) {
            n11 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n11 != 0) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append(string6);
                charSequence.append(n10);
                charSequence.append(string2);
                charSequence.append(n10);
                charSequence = charSequence.toString();
                QLog.w(string3, n13, (String)charSequence);
            }
            return n10;
        }
        int n14 = 11;
        if (n11 >= n14) {
            n12 = 7;
        }
        if ((n11 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string6);
            stringBuilder.append(n10);
            stringBuilder.append(string2);
            stringBuilder.append(n12);
            String string7 = stringBuilder.toString();
            QLog.w(string3, n13, string7);
        }
        return n12;
    }

    public static int getAudioStreamType(int n10) {
        int n11 = IsMusicScene;
        int n12 = 3;
        if (n11 != 0) {
            return n12;
        }
        n11 = TraeAudioManager.IsEabiLowVersion();
        String string2 = " streamType:";
        int n13 = 2;
        String string3 = "TRAE";
        if (n11 != 0) {
            n11 = QLog.isColorLevel();
            if (n11 != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:";
                stringBuilder.append(string4);
                stringBuilder.append(n10);
                stringBuilder.append(string2);
                stringBuilder.append(n12);
                String string5 = stringBuilder.toString();
                QLog.w(string3, n13, string5);
            }
            return n12;
        }
        n11 = Build.VERSION.SDK_INT;
        if (n10 >= 0) {
            n12 = n10;
        } else {
            int n14 = 9;
            if (n11 >= n14) {
                n12 = 0;
            }
        }
        n11 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n11 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String string6 = "[Config] getAudioStreamType audioStreamTypePolicy:";
            stringBuilder.append(string6);
            stringBuilder.append(n10);
            stringBuilder.append(string2);
            stringBuilder.append(n12);
            String string7 = stringBuilder.toString();
            QLog.w(string3, n13, string7);
        }
        return n12;
    }

    public static int getCallAudioMode(int n10) {
        int n11 = IsMusicScene;
        int n12 = 0;
        String string2 = null;
        if (n11 != 0) {
            return 0;
        }
        n11 = TraeAudioManager.IsEabiLowVersion();
        String string3 = " mode:";
        int n13 = 2;
        String string4 = "TRAE";
        if (n11 != 0) {
            n11 = QLog.isColorLevel();
            if (n11 != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String string5 = "[Config] armeabi low Version, getCallAudioMode modePolicy:";
                stringBuilder.append(string5);
                stringBuilder.append(n10);
                stringBuilder.append(string3);
                stringBuilder.append(0);
                String string6 = stringBuilder.toString();
                QLog.w(string4, n13, string6);
            }
            return 0;
        }
        n11 = Build.VERSION.SDK_INT;
        if (n10 >= 0) {
            n11 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n11 != 0) {
                CharSequence charSequence = new StringBuilder();
                string2 = "[Config] getCallAudioMode modePolicy:";
                charSequence.append(string2);
                charSequence.append(n10);
                charSequence.append(string3);
                charSequence.append(n10);
                charSequence = charSequence.toString();
                QLog.w(string4, n13, (String)charSequence);
            }
            return n10;
        }
        int n14 = 11;
        if (n11 >= n14) {
            n12 = 3;
        }
        if ((n11 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = "[Config] getCallAudioMode _modePolicy:";
            stringBuilder.append(string7);
            stringBuilder.append(n10);
            stringBuilder.append(string3);
            stringBuilder.append(n12);
            stringBuilder.append("facturer:");
            String string8 = Build.MANUFACTURER;
            stringBuilder.append(string8);
            stringBuilder.append(" model:");
            string8 = Build.MODEL;
            stringBuilder.append(string8);
            string8 = stringBuilder.toString();
            QLog.w(string4, n13, string8);
        }
        return n12;
    }

    public static int getConnectedDevice(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32778, hashMap);
    }

    public static int getConnectingDevice(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32779, hashMap);
    }

    public static int getDeviceList(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32774, hashMap);
    }

    public static String getForceConfigName(int n10) {
        String[] stringArray;
        int n11;
        if (n10 >= 0 && n10 < (n11 = (stringArray = forceName).length)) {
            return stringArray[n10];
        }
        return "unknow";
    }

    public static int getForceUse(int n10) {
        Object object;
        int n11 = 0;
        Object object2 = 0;
        int n12 = 1;
        Object object3 = new Object[n12];
        object3[0] = object = Integer.valueOf(n10);
        Object object4 = new Class[n12];
        object = Integer.TYPE;
        object4[0] = object;
        object = "getForceUse";
        Object object5 = TraeAudioManager.invokeStaticMethod("android.media.AudioSystem", (String)object, object3, (Class[])object4);
        if (object5 != null) {
            object2 = object5;
            object2 = (Integer)object5;
        }
        if ((n11 = QLog.isColorLevel()) != 0) {
            n11 = 2;
            object4 = new StringBuilder();
            object3 = "getForceUse  usage:";
            ((StringBuilder)object4).append((String)object3);
            ((StringBuilder)object4).append(n10);
            ((StringBuilder)object4).append(" config:");
            ((StringBuilder)object4).append(object2);
            ((StringBuilder)object4).append(" ->");
            n10 = (Integer)object2;
            String string2 = TraeAudioManager.getForceConfigName(n10);
            ((StringBuilder)object4).append(string2);
            string2 = ((StringBuilder)object4).toString();
            object4 = "TRAE";
            QLog.w((String)object4, n11, string2);
        }
        return (Integer)object2;
    }

    public static int getStreamType(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32784, hashMap);
    }

    public static int init(Context context) {
        Object object = new StringBuilder();
        object.append("TraeAudioManager init _ginstance:");
        TraeAudioManager traeAudioManager = _ginstance;
        object.append((Object)traeAudioManager);
        object = object.toString();
        Log.w((String)"TRAE", (String)object);
        object = new StringBuilder();
        object.append(" _ginstance:");
        traeAudioManager = _ginstance;
        object.append((Object)traeAudioManager);
        AudioDeviceInterface.LogTraceEntry(object.toString());
        _glock.lock();
        object = _ginstance;
        if (object == null) {
            object = new TraeAudioManager(context);
            _ginstance = object;
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public static Object invokeMethod(Object object, String object2, Object[] object3, Class[] object4) {
        Class<?> clazz = object.getClass();
        object2 = clazz.getMethod((String)object2, (Class<?>)object4);
        try {
            object = ((Method)object2).invoke(object, object3);
        }
        catch (Exception exception) {
            int n10 = QLog.isColorLevel();
            if (n10 != 0) {
                n10 = 2;
                object3 = new StringBuilder();
                object4 = "invokeMethod Exception:";
                object3.append((String)object4);
                object = exception.getMessage();
                object3.append((String)object);
                object = object3.toString();
                object3 = "TRAE";
                QLog.w((String)object3, n10, (String)object);
            }
            object = null;
        }
        return object;
    }

    public static Object invokeStaticMethod(String charSequence, String charSequence2, Object[] objectArray, Class[] object) {
        Object object2;
        block14: {
            String string2 = "TRAE";
            object2 = null;
            int n10 = 2;
            Class<?> clazz = Class.forName((String)charSequence);
            object = clazz.getMethod((String)charSequence2, (Class<?>)object);
            try {
                object2 = ((Method)object).invoke(null, objectArray);
            }
            catch (Exception exception) {
                boolean bl2 = QLog.isColorLevel();
                if (bl2) {
                    charSequence2 = new StringBuilder();
                    objectArray = "invokeStaticMethod Exception:";
                    ((StringBuilder)charSequence2).append((String)objectArray);
                    String string3 = exception.getMessage();
                    ((StringBuilder)charSequence2).append(string3);
                    string3 = ((StringBuilder)charSequence2).toString();
                    QLog.w(string2, n10, string3);
                }
            }
            catch (InvocationTargetException invocationTargetException) {
                boolean bl3 = QLog.isColorLevel();
                if (bl3) {
                    charSequence = new StringBuilder();
                    objectArray = "InvocationTarget:";
                    ((StringBuilder)charSequence).append((String)objectArray);
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    QLog.w(string2, n10, (String)charSequence);
                }
            }
            catch (IllegalAccessException illegalAccessException) {
                boolean bl4 = QLog.isColorLevel();
                if (bl4) {
                    charSequence = new StringBuilder();
                    objectArray = "IllegalAccess:";
                    ((StringBuilder)charSequence).append((String)objectArray);
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    QLog.w(string2, n10, (String)charSequence);
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                boolean bl5 = QLog.isColorLevel();
                if (bl5) {
                    charSequence = new StringBuilder();
                    objectArray = "IllegalArgument:";
                    ((StringBuilder)charSequence).append((String)objectArray);
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    QLog.w(string2, n10, (String)charSequence);
                }
            }
            catch (NoSuchMethodException noSuchMethodException) {
                boolean bl6 = QLog.isColorLevel();
                if (bl6) {
                    charSequence = new StringBuilder();
                    objectArray = "NoSuchMethod:";
                    ((StringBuilder)charSequence).append((String)objectArray);
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    QLog.w(string2, n10, (String)charSequence);
                }
            }
            catch (ClassNotFoundException classNotFoundException) {
                boolean bl7 = QLog.isColorLevel();
                if (!bl7) break block14;
                charSequence2 = new StringBuilder();
                objectArray = "ClassNotFound:";
                ((StringBuilder)charSequence2).append((String)objectArray);
                ((StringBuilder)charSequence2).append((String)charSequence);
                charSequence = ((StringBuilder)charSequence2).toString();
                QLog.w(string2, n10, (String)charSequence);
            }
        }
        return object2;
    }

    public static boolean isCloseSystemAPM(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            return false;
        }
        String string2 = Build.MANUFACTURER;
        String string3 = "Xiaomi";
        n11 = (int)(string2.equals(string3) ? 1 : 0);
        boolean bl2 = true;
        if (n11 != 0) {
            string2 = Build.MODEL;
            string3 = "MI 2";
            n11 = (int)(string2.equals(string3) ? 1 : 0);
            if (n11 != 0) {
                return bl2;
            }
            string3 = "MI 2A";
            n11 = (int)(string2.equals(string3) ? 1 : 0);
            if (n11 != 0) {
                return bl2;
            }
            string3 = "MI 2S";
            n11 = (int)(string2.equals(string3) ? 1 : 0);
            if (n11 != 0) {
                return bl2;
            }
            string3 = "MI 2SC";
            n10 = (int)(string2.equals(string3) ? 1 : 0);
            if (n10 != 0) {
                return bl2;
            }
        } else {
            string3 = "samsung";
            n10 = (int)(string2.equals(string3) ? 1 : 0);
            if (n10 != 0 && (n10 = (int)((string2 = Build.MODEL).equals(string3 = "SCH-I959") ? 1 : 0)) != 0) {
                return bl2;
            }
        }
        return false;
    }

    public static int isDeviceChangabled(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32777, hashMap);
    }

    public static boolean isHandfree(String string2) {
        boolean bl2 = TraeAudioManager.checkDevName(string2);
        if (!bl2) {
            return false;
        }
        String string3 = DEVICE_SPEAKERPHONE;
        boolean bl3 = string3.equals(string2);
        return bl3;
    }

    public static int recoverAudioFocus(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32791, hashMap);
    }

    public static int registerAudioSession(TraeAudioSession object, boolean bl2, long l10, Context context) {
        int n10;
        _glock.lock();
        TraeAudioManager traeAudioManager = _ginstance;
        if (traeAudioManager != null) {
            String string2 = "_ginstance._audioSessionHost is null";
            int n11 = 2;
            String string3 = "TRAE";
            if (bl2) {
                Object object2 = traeAudioManager._audioSessionHost;
                if (object2 != null) {
                    ((TraeAudioSessionHost)object2).add((TraeAudioSession)((Object)object), l10, context);
                    n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n10 != 0) {
                        object = new StringBuilder();
                        object2 = "[register] add AudioSession: ";
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(l10);
                        object = ((StringBuilder)object).toString();
                        QLog.d(string3, n11, (String)object);
                    }
                } else {
                    n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n10 != 0) {
                        QLog.d(string3, n11, string2);
                    }
                }
            } else {
                object = traeAudioManager._audioSessionHost;
                if (object != null) {
                    ((TraeAudioSessionHost)object).remove(l10);
                    n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n10 != 0) {
                        object = new StringBuilder();
                        String string4 = "[register] remove AudioSession: ";
                        ((StringBuilder)object).append(string4);
                        ((StringBuilder)object).append(l10);
                        object = ((StringBuilder)object).toString();
                        QLog.d(string3, n11, (String)object);
                    }
                } else {
                    n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n10 != 0) {
                        QLog.d(string3, n11, string2);
                    }
                }
            }
            n10 = 0;
            object = null;
        } else {
            n10 = -1;
        }
        _glock.unlock();
        return n10;
    }

    public static int requestReleaseAudioFocus(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32790, hashMap);
    }

    public static int sendMessage(int n10, HashMap hashMap) {
        _glock.lock();
        TraeAudioManager traeAudioManager = _ginstance;
        n10 = traeAudioManager != null ? traeAudioManager.internalSendMessage(n10, hashMap) : -1;
        _glock.unlock();
        return n10;
    }

    public static void setForceUse(int n10, int n11) {
        Class<Integer> clazz;
        Object object;
        int n12 = 2;
        Object object2 = new Object[n12];
        object2[0] = object = Integer.valueOf(n10);
        object = n11;
        int n13 = 1;
        object2[n13] = object;
        object = new Class[n12];
        object[0] = clazz = Integer.TYPE;
        object[n13] = clazz;
        String string2 = "android.media.AudioSystem";
        String string3 = "setForceUse";
        object2 = TraeAudioManager.invokeStaticMethod(string2, string3, object2, (Class[])object);
        boolean bl2 = QLog.isColorLevel();
        if (bl2) {
            object = new StringBuilder();
            string2 = "setForceUse  usage:";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(" config:");
            ((StringBuilder)object).append(n11);
            ((StringBuilder)object).append(" ->");
            String string4 = TraeAudioManager.getForceConfigName(n11);
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(" res:");
            ((StringBuilder)object).append(object2);
            string4 = ((StringBuilder)object).toString();
            String string5 = "TRAE";
            QLog.w(string5, n12, string4);
        }
    }

    public static void setParameters(String string2) {
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = string2;
        Class[] classArray = new Class[n10];
        Object object = String.class;
        classArray[0] = object;
        int n11 = QLog.isColorLevel();
        if (n11 != 0) {
            n11 = 2;
            object = new StringBuilder();
            String string3 = "setParameters  :";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            object = "TRAE";
            QLog.w((String)object, n11, string2);
        }
        TraeAudioManager.invokeStaticMethod("android.media.AudioSystem", "setParameters", objectArray, classArray);
    }

    public static void setPhoneState(int n10) {
        Class<Integer> clazz;
        int n11 = 1;
        Object[] objectArray = new Object[n11];
        Class[] classArray = Integer.valueOf(n10);
        objectArray[0] = classArray;
        classArray = new Class[n11];
        classArray[0] = clazz = Integer.TYPE;
        TraeAudioManager.invokeStaticMethod("android.media.AudioSystem", "setPhoneState", objectArray, classArray);
    }

    public static int startRing(String object, long l10, boolean bl2, int n10, int n11, Uri uri, String string2, boolean bl3, int n12, String string3, boolean bl4) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        object = n10;
        hashMap.put(PARAM_RING_DATASOURCE, object);
        object = n11;
        hashMap.put(PARAM_RING_RSID, object);
        hashMap.put(PARAM_RING_URI, uri);
        hashMap.put(PARAM_RING_FILEPATH, string2);
        object = bl3;
        hashMap.put(PARAM_RING_LOOP, object);
        object = n12;
        hashMap.put(PARAM_RING_LOOPCOUNT, object);
        object = bl4;
        hashMap.put(PARAM_RING_MODE, object);
        hashMap.put(PARAM_RING_USERDATA_STRING, string3);
        return TraeAudioManager.sendMessage(32782, hashMap);
    }

    public static int startService(String object, long l10, boolean bl2, String string2) {
        int n10 = string2.length();
        if (n10 <= 0) {
            return -1;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        hashMap.put(EXTRA_DATA_DEVICECONFIG, string2);
        return TraeAudioManager.sendMessage(32772, hashMap);
    }

    public static int stopRing(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32783, hashMap);
    }

    public static int stopService(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32773, hashMap);
    }

    public static void uninit() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("TraeAudioManager uninit _ginstance:");
        TraeAudioManager traeAudioManager = _ginstance;
        ((StringBuilder)object).append((Object)traeAudioManager);
        object = ((StringBuilder)object).toString();
        Log.w((String)"TRAE", (String)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(" _ginstance:");
        traeAudioManager = _ginstance;
        ((StringBuilder)object).append((Object)traeAudioManager);
        AudioDeviceInterface.LogTraceEntry(((StringBuilder)object).toString());
        _glock.lock();
        object = _ginstance;
        if (object != null) {
            ((TraeAudioManager)((Object)object)).release();
            object = null;
            _ginstance = null;
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
    }

    public static int voiceCallAudioParamChanged(String object, long l10, boolean bl2, int n10, int n11) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        object = n10;
        hashMap.put(PARAM_MODEPOLICY, object);
        object = n11;
        hashMap.put(PARAM_STREAMTYPE, object);
        return TraeAudioManager.sendMessage(32788, hashMap);
    }

    public static int voicecallPostprocess(String object, long l10, boolean bl2) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        return TraeAudioManager.sendMessage(32781, hashMap);
    }

    public static int voicecallPreprocess(String object, long l10, boolean bl2, int n10, int n11) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l11 = l10;
        hashMap.put(PARAM_SESSIONID, l11);
        hashMap.put(PARAM_OPERATION, object);
        object = bl2;
        hashMap.put(PARAM_ISHOSTSIDE, object);
        object = n10;
        hashMap.put(PARAM_MODEPOLICY, object);
        object = n11;
        hashMap.put(PARAM_STREAMTYPE, object);
        return TraeAudioManager.sendMessage(32780, hashMap);
    }

    public TraeAudioManager$BluetoohHeadsetCheckInterface CreateBluetoothCheck(Context context, TraeAudioManager$DeviceConfigManager object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        int n12 = 11;
        TraeAudioManager$BluetoohHeadsetCheckInterface traeAudioManager$BluetoohHeadsetCheckInterface = n10 >= n12 ? new TraeAudioManager$BluetoohHeadsetCheck(this) : (n10 != n11 ? new TraeAudioManager$BluetoohHeadsetCheckFor2x(this) : new TraeAudioManager$BluetoohHeadsetCheckFake(this));
        int n13 = traeAudioManager$BluetoohHeadsetCheckInterface.init(context, (TraeAudioManager$DeviceConfigManager)object);
        if (n13 == 0) {
            traeAudioManager$BluetoohHeadsetCheckInterface = new TraeAudioManager$BluetoohHeadsetCheckFake(this);
        }
        if ((n13 = QLog.isColorLevel()) != 0) {
            n13 = 2;
            object = new StringBuilder();
            ((StringBuilder)object).append("CreateBluetoothCheck:");
            String string2 = traeAudioManager$BluetoohHeadsetCheckInterface.interfaceDesc();
            ((StringBuilder)object).append(string2);
            string2 = " skip android4.3:";
            ((StringBuilder)object).append(string2);
            String string3 = n10 == n11 ? "Y" : "N";
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            string3 = "TRAE";
            QLog.w(string3, n13, (String)object);
        }
        return traeAudioManager$BluetoohHeadsetCheckInterface;
    }

    public int InternalConnectDevice(String object, HashMap serializable, boolean bl2) {
        boolean bl3;
        Object object2;
        CharSequence charSequence = new StringBuilder();
        String string2 = " devName:";
        charSequence.append(string2);
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        AudioDeviceInterface.LogTraceEntry((String)charSequence);
        int n10 = -1;
        if (object == null) {
            return n10;
        }
        boolean bl4 = IsMusicScene;
        String string3 = " failed";
        String string4 = DEVICE_EARPHONE;
        int n11 = 2;
        String string5 = "TRAE";
        if (bl4 && (bl4 = ((String)object).equals(string4))) {
            boolean bl5 = QLog.isColorLevel();
            if (bl5) {
                serializable = new StringBuilder();
                String string6 = "MusicScene, Connect device:";
                ((StringBuilder)serializable).append(string6);
                ((StringBuilder)serializable).append((String)object);
                ((StringBuilder)serializable).append(string3);
                object = ((StringBuilder)serializable).toString();
                QLog.e(string5, n11, (String)object);
            }
            return n10;
        }
        bl4 = IsEarPhoneSupported;
        if (!bl4 && (bl4 = ((String)object).equals(string4))) {
            boolean bl6 = QLog.isColorLevel();
            if (bl6) {
                serializable = new StringBuilder();
                String string7 = "IsEarPhoneSupported = false, Connect device:";
                ((StringBuilder)serializable).append(string7);
                ((StringBuilder)serializable).append((String)object);
                ((StringBuilder)serializable).append(string3);
                object = ((StringBuilder)serializable).toString();
                QLog.e(string5, n11, (String)object);
            }
            return n10;
        }
        bl4 = false;
        string2 = null;
        if (!bl2 && !(bl2 = ((String)(object2 = this._deviceConfigManager.getConnectedDevice())).equals(string3 = DEVICE_NONE)) && (bl2 = ((String)object).equals(object2 = this._deviceConfigManager.getConnectedDevice()))) {
            return 0;
        }
        bl2 = TraeAudioManager.checkDevName((String)object);
        if (bl2 == (bl3 = true) && (bl2 = ((TraeAudioManager$DeviceConfigManager)(object2 = this._deviceConfigManager)).getVisible((String)object)) == bl3) {
            bl2 = this.InternalIsDeviceChangeable();
            if (bl2 != bl3) {
                boolean bl7 = QLog.isColorLevel();
                if (bl7) {
                    object = " InternalIsDeviceChangeable fail";
                    QLog.e(string5, n11, (String)object);
                }
                return n10;
            }
            object2 = this._switchThread;
            if (object2 != null) {
                bl2 = QLog.isColorLevel();
                if (bl2) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("_switchThread:");
                    charSequence = this._switchThread.getDeviceName();
                    ((StringBuilder)object2).append((String)charSequence);
                    object2 = ((StringBuilder)object2).toString();
                    QLog.w(string5, n11, (String)object2);
                }
                this._switchThread.quit();
                bl2 = false;
                object2 = null;
                this._switchThread = null;
            }
            if (bl2 = ((String)object).equals(string4)) {
                this._switchThread = object = new TraeAudioManager$earphoneSwitchThread(this);
            } else {
                object2 = DEVICE_SPEAKERPHONE;
                bl2 = ((String)object).equals(object2);
                if (bl2) {
                    this._switchThread = object = new TraeAudioManager$speakerSwitchThread(this);
                } else {
                    object2 = DEVICE_WIREDHEADSET;
                    bl2 = ((String)object).equals(object2);
                    if (bl2) {
                        this._switchThread = object = new TraeAudioManager$headsetSwitchThread(this);
                    } else {
                        object2 = DEVICE_BLUETOOTHHEADSET;
                        boolean bl8 = ((String)object).equals(object2);
                        if (bl8) {
                            this._switchThread = object = new TraeAudioManager$bluetoothHeadsetSwitchThread(this);
                        }
                    }
                }
            }
            object = this._switchThread;
            if (object != null) {
                ((TraeAudioManager$switchThread)object).setDeviceConnectParam((HashMap)serializable);
                object = this._switchThread;
                ((Thread)object).start();
            }
            AudioDeviceInterface.LogTraceExit();
            return 0;
        }
        boolean bl9 = QLog.isColorLevel();
        if (bl9) {
            object = " checkDevName fail";
            QLog.e(string5, n11, (String)object);
        }
        return n10;
    }

    public boolean InternalIsDeviceChangeable() {
        boolean bl2;
        String string2;
        boolean bl3;
        String string3 = this._deviceConfigManager.getConnectingDevice();
        return string3 == null || (bl3 = string3.equals(string2 = DEVICE_NONE)) || (bl2 = string3.equals(string2 = ""));
        {
        }
    }

    public int InternalNotifyDeviceChangableUpdate() {
        Context context = this._context;
        if (context == null) {
            return -1;
        }
        boolean bl2 = this.InternalIsDeviceChangeable();
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new TraeAudioManager$3(this, bl2);
        handler.post((Runnable)object);
        return 0;
    }

    public int InternalNotifyDeviceListUpdate() {
        Object object;
        AudioDeviceInterface.LogTraceEntry("");
        Object object2 = this._context;
        if (object2 == null) {
            return -1;
        }
        object2 = this._deviceConfigManager.getSnapParams();
        Object object3 = object = object2.get(EXTRA_DATA_AVAILABLEDEVICE_LIST);
        object3 = (ArrayList)object;
        Object object4 = object = object2.get(EXTRA_DATA_CONNECTEDDEVICE);
        object4 = (String)object;
        Object object5 = object2 = object2.get(EXTRA_DATA_PREV_CONNECTEDDEVICE);
        object5 = (String)object2;
        String string2 = this._deviceConfigManager.getBluetoothName();
        object = Looper.getMainLooper();
        object2 = new Handler(object);
        object = new Object(this, (ArrayList)object3, (String)object4, (String)object5, string2);
        object2.post(object);
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public int InternalSessionConnectDevice(HashMap object) {
        Object object2;
        String string2 = "";
        AudioDeviceInterface.LogTraceEntry(string2);
        int n10 = -1;
        if (object != null && (object2 = this._context) != null) {
            int n11;
            boolean bl2 = IsMusicScene;
            int n12 = 2;
            String string3 = "TRAE";
            if (bl2) {
                boolean bl3 = QLog.isColorLevel();
                if (bl3) {
                    object = "MusicScene: InternalSessionConnectDevice failed";
                    QLog.w(string3, n12, (String)object);
                }
                return n10;
            }
            object2 = PARAM_DEVICE;
            String string4 = (String)((HashMap)object).get(object2);
            CharSequence charSequence = new StringBuilder();
            Object object3 = "ConnectDevice: ";
            charSequence.append((String)object3);
            charSequence.append(string4);
            charSequence = charSequence.toString();
            Log.w((String)string3, (String)charSequence);
            boolean bl4 = IsEarPhoneSupported;
            if (!bl4 && (bl4 = string4.equals(charSequence = DEVICE_EARPHONE))) {
                boolean bl5 = QLog.isColorLevel();
                if (bl5) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("InternalSessionConnectDevice IsEarPhoneSupported = false, Connect device:");
                    ((StringBuilder)object).append(string4);
                    object2 = " failed";
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    QLog.e(string3, n12, (String)object);
                }
                return n10;
            }
            bl4 = this.InternalIsDeviceChangeable();
            int n13 = TraeAudioManager.checkDevName(string4);
            if (n13 != (n11 = 1)) {
                n13 = 7;
            } else {
                object3 = this._deviceConfigManager;
                n13 = (int)(((TraeAudioManager$DeviceConfigManager)object3).getVisible(string4) ? 1 : 0);
                if (n13 == 0) {
                    n13 = 8;
                } else if (!bl4) {
                    n13 = 9;
                } else {
                    n13 = 0;
                    object3 = null;
                }
            }
            n11 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n11 != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sessonID:");
                Object object4 = (Long)((HashMap)object).get(PARAM_SESSIONID);
                stringBuilder.append(object4);
                stringBuilder.append(" devName:");
                stringBuilder.append(string4);
                object4 = " bChangabled:";
                stringBuilder.append((String)object4);
                charSequence = bl4 ? "Y" : "N";
                stringBuilder.append((String)charSequence);
                stringBuilder.append(" err:");
                stringBuilder.append(n13);
                charSequence = stringBuilder.toString();
                QLog.w(string3, n12, (String)charSequence);
            }
            charSequence = CONNECTDEVICE_RESULT_DEVICENAME;
            if (n13 != 0) {
                Intent intent = new Intent();
                object2 = (String)((HashMap)object).get(object2);
                intent.putExtra((String)charSequence, (String)object2);
                this.sendResBroadcast(intent, (HashMap)object, n13);
                return n10;
            }
            string2 = this._deviceConfigManager.getConnectedDevice();
            n10 = (int)(string4.equals(string2) ? 1 : 0);
            if (n10 != 0) {
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 != 0) {
                    string2 = " --has connected!";
                    QLog.e(string3, n12, string2);
                }
                string2 = new Intent();
                object2 = (String)((HashMap)object).get(object2);
                string2.putExtra((String)charSequence, (String)object2);
                this.sendResBroadcast((Intent)string2, (HashMap)object, n13);
                return 0;
            }
            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n10 != 0) {
                string2 = " --connecting...";
                QLog.w(string3, n12, string2);
            }
            this.InternalConnectDevice(string4, (HashMap)object, false);
            AudioDeviceInterface.LogTraceExit();
            return 0;
        }
        return n10;
    }

    public int InternalSessionEarAction(HashMap hashMap) {
        return 0;
    }

    public int InternalSessionGetConnectedDevice(HashMap hashMap) {
        Intent intent = new Intent();
        String string2 = this._deviceConfigManager.getConnectedDevice();
        intent.putExtra(GETCONNECTEDDEVICE_RESULT_LIST, string2);
        this.sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    public int InternalSessionGetConnectingDevice(HashMap hashMap) {
        Intent intent = new Intent();
        String string2 = this._deviceConfigManager.getConnectingDevice();
        intent.putExtra(GETCONNECTINGDEVICE_RESULT_LIST, string2);
        this.sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    public int InternalSessionIsDeviceChangabled(HashMap hashMap) {
        Intent intent = new Intent();
        boolean bl2 = this.InternalIsDeviceChangeable();
        intent.putExtra(ISDEVICECHANGABLED_RESULT_ISCHANGABLED, bl2);
        this.sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    public void InternalSetMode(int n10) {
        String string2;
        CharSequence charSequence;
        boolean bl2 = QLog.isColorLevel();
        int n11 = 2;
        String string3 = "TRAE";
        if (bl2) {
            charSequence = new StringBuilder();
            string2 = "SetMode entry:";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            QLog.w(string3, n11, (String)charSequence);
        }
        charSequence = this._am;
        string2 = "setMode:";
        if (charSequence == null) {
            bl2 = QLog.isColorLevel();
            if (bl2) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(n10);
                ((StringBuilder)charSequence).append(" fail am=null");
                String string4 = ((StringBuilder)charSequence).toString();
                QLog.w(string3, n11, string4);
            }
            return;
        }
        charSequence.setMode(n10);
        bl2 = QLog.isColorLevel();
        if (bl2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n10);
            string2 = this._am;
            int n12 = string2.getMode();
            String string5 = n12 != n10 ? "fail" : "success";
            ((StringBuilder)charSequence).append(string5);
            string5 = ((StringBuilder)charSequence).toString();
            QLog.w(string3, n11, string5);
        }
    }

    public int InternalSetSpeaker(Context object, boolean n10) {
        String string2;
        int n11 = -1;
        String string3 = "TRAE";
        int n12 = 2;
        if (object == null) {
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = "Could not InternalSetSpeaker - no context";
                QLog.e(string3, n12, (String)object);
            }
            return n11;
        }
        CharSequence charSequence = "audio";
        if ((object = (AudioManager)object.getSystemService((String)charSequence)) == null) {
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                object = "Could not InternalSetSpeaker - no audio manager";
                QLog.e(string3, n12, (String)object);
            }
            return n11;
        }
        int n13 = QLog.isColorLevel();
        if (n13 != 0) {
            charSequence = new StringBuilder();
            string2 = "InternalSetSpeaker entry:speaker:";
            ((StringBuilder)charSequence).append(string2);
            boolean bl4 = object.isSpeakerphoneOn();
            String string4 = "Y";
            String string5 = "N";
            string2 = bl4 ? string4 : string5;
            ((StringBuilder)charSequence).append(string2);
            string2 = "-->:";
            ((StringBuilder)charSequence).append(string2);
            if (n10 == 0) {
                string4 = string5;
            }
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            QLog.w(string3, n12, (String)charSequence);
        }
        if ((n13 = TraeAudioManager.isCloseSystemAPM(this._modePolicy)) != 0 && (n13 = this._activeMode) != n12) {
            return this.InternalSetSpeakerSpe((AudioManager)object, n10 != 0);
        }
        n13 = (int)(object.isSpeakerphoneOn() ? 1 : 0);
        if (n13 != n10) {
            object.setSpeakerphoneOn(n10 != 0);
        }
        if ((n13 = (int)(object.isSpeakerphoneOn() ? 1 : 0)) == n10) {
            n11 = 0;
        }
        if ((n13 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            charSequence = new StringBuilder();
            string2 = "InternalSetSpeaker exit:";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(n10 != 0);
            ((StringBuilder)charSequence).append(" res:");
            ((StringBuilder)charSequence).append(n11);
            String string6 = " mode:";
            ((StringBuilder)charSequence).append(string6);
            int n14 = object.getMode();
            ((StringBuilder)charSequence).append(n14);
            object = ((StringBuilder)charSequence).toString();
            QLog.w(string3, n12, (String)object);
        }
        return n11;
    }

    public int InternalSetSpeakerSpe(AudioManager object, boolean n10) {
        int n11;
        String string2;
        CharSequence charSequence;
        int n12 = QLog.isColorLevel();
        int n13 = 2;
        String string3 = "TRAE";
        int n14 = 1;
        if (n12 != 0) {
            charSequence = new StringBuilder();
            charSequence.append("InternalSetSpeakerSpe fac:");
            string2 = Build.MANUFACTURER;
            charSequence.append(string2);
            charSequence.append(" model:");
            string2 = Build.MODEL;
            charSequence.append(string2);
            charSequence.append(" st:");
            n11 = this._streamType;
            charSequence.append(n11);
            string2 = " media_force_use:";
            charSequence.append(string2);
            n11 = TraeAudioManager.getForceUse(n14);
            charSequence.append(n11);
            charSequence = charSequence.toString();
            QLog.w(string3, n13, (String)charSequence);
        }
        n12 = 0;
        charSequence = null;
        if (n10 != 0) {
            this.InternalSetMode(0);
            object.setSpeakerphoneOn(n14 != 0);
            TraeAudioManager.setForceUse(n14, n14);
        } else {
            n11 = 3;
            this.InternalSetMode(n11);
            object.setSpeakerphoneOn(false);
            TraeAudioManager.setForceUse(n14, 0);
        }
        n14 = (int)(object.isSpeakerphoneOn() ? 1 : 0);
        if (n14 != n10) {
            n12 = -1;
        }
        n14 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n14 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            string2 = "InternalSetSpeakerSpe exit:";
            stringBuilder.append(string2);
            stringBuilder.append(n10 != 0);
            stringBuilder.append(" res:");
            stringBuilder.append(n12);
            String string4 = " mode:";
            stringBuilder.append(string4);
            int n15 = object.getMode();
            stringBuilder.append(n15);
            object = stringBuilder.toString();
            QLog.w(string3, n13, (String)object);
        }
        return n12;
    }

    public void _updateEarphoneVisable() {
        Object object = this._deviceConfigManager;
        int bl2 = 2;
        String string2 = "TRAE";
        if (object == null) {
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                object = "_deviceConfigManager is null";
                QLog.w(string2, bl2, (String)object);
            }
            return;
        }
        boolean bl4 = ((TraeAudioManager$DeviceConfigManager)object).getVisible(DEVICE_WIREDHEADSET);
        String string3 = DEVICE_EARPHONE;
        if (bl4) {
            bl4 = QLog.isColorLevel();
            if (bl4) {
                object = " detected headset plugin,so disable earphone";
                QLog.w(string2, bl2, (String)object);
            }
            object = this._deviceConfigManager;
            boolean bl5 = false;
            ((TraeAudioManager$DeviceConfigManager)object).setVisible(string3, false);
        } else {
            bl4 = QLog.isColorLevel();
            if (bl4) {
                object = " detected headset plugout,so enable earphone";
                QLog.w(string2, bl2, (String)object);
            }
            object = this._deviceConfigManager;
            boolean bl6 = true;
            ((TraeAudioManager$DeviceConfigManager)object).setVisible(string3, bl6);
        }
    }

    public void checkAutoDeviceListUpdate() {
        boolean bl2;
        HashMap hashMap = this._deviceConfigManager;
        int n10 = 2;
        String string2 = "TRAE";
        if (hashMap == null) {
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                hashMap = "_deviceConfigManager is null";
                QLog.w(string2, n10, (String)((Object)hashMap));
            }
            return;
        }
        boolean bl4 = ((TraeAudioManager$DeviceConfigManager)((Object)hashMap)).getVisiableUpdateFlag();
        if (bl4 == (bl2 = true)) {
            bl4 = QLog.isColorLevel();
            if (bl4) {
                hashMap = "checkAutoDeviceListUpdate got update!";
                QLog.w(string2, n10, (String)((Object)hashMap));
            }
            this._updateEarphoneVisable();
            this._deviceConfigManager.resetVisiableUpdateFlag();
            hashMap = new HashMap();
            n10 = 32785;
            this.internalSendMessage(n10, hashMap);
        }
    }

    public void checkDevicePlug(String object, boolean bl2) {
        boolean bl3;
        Object object2 = this._deviceConfigManager;
        int n10 = 2;
        String string2 = "TRAE";
        if (object2 == null) {
            boolean n11 = QLog.isColorLevel();
            if (n11) {
                object = "_deviceConfigManager is null";
                QLog.w(string2, n10, (String)object);
            }
            return;
        }
        boolean bl4 = ((TraeAudioManager$DeviceConfigManager)object2).getVisiableUpdateFlag();
        if (bl4 == (bl3 = true)) {
            String string3;
            bl4 = QLog.isColorLevel();
            String string4 = " connectedDev:";
            if (bl4) {
                object2 = new StringBuilder();
                string3 = "checkDevicePlug got update dev:";
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append((String)object);
                string3 = bl2 ? " piugin" : " plugout";
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(string4);
                string3 = this._deviceConfigManager.getConnectedDevice();
                ((StringBuilder)object2).append(string3);
                object2 = ((StringBuilder)object2).toString();
                QLog.w(string2, n10, (String)object2);
            }
            this._updateEarphoneVisable();
            this._deviceConfigManager.resetVisiableUpdateFlag();
            object2 = PARAM_DEVICE;
            if (bl2) {
                HashMap object3 = new HashMap();
                object3.put(object2, object);
                int n12 = 32786;
                this.internalSendMessage(n12, object3);
            } else {
                Object object3 = this._deviceConfigManager.getConnectedDevice();
                boolean bl5 = ((String)object3).equals(object);
                if (!bl5 && !(bl5 = ((String)object3).equals(string3 = DEVICE_NONE))) {
                    bl4 = QLog.isColorLevel();
                    if (bl4) {
                        object2 = new StringBuilder();
                        string3 = " ---No switch,plugout:";
                        ((StringBuilder)object2).append(string3);
                        ((StringBuilder)object2).append((String)object);
                        ((StringBuilder)object2).append(string4);
                        ((StringBuilder)object2).append((String)object3);
                        object = ((StringBuilder)object2).toString();
                        QLog.w(string2, n10, (String)object);
                    }
                    object = new HashMap();
                    int n11 = 32785;
                    this.internalSendMessage(n11, (HashMap)object);
                } else {
                    object3 = new Object();
                    ((HashMap)object3).put(object2, object);
                    int n12 = 32787;
                    this.internalSendMessage(n12, (HashMap)object3);
                }
            }
        }
    }

    public int internalSendMessage(int n10, HashMap hashMap) {
        TraeAudioManager$TraeAudioManagerLooper traeAudioManager$TraeAudioManagerLooper = this.mTraeAudioManagerLooper;
        n10 = traeAudioManager$TraeAudioManagerLooper != null ? traeAudioManager$TraeAudioManagerLooper.sendMessage(n10, hashMap) : -1;
        return n10;
    }

    public void onHeadsetPlug(Context object, Intent object2) {
        boolean bl2;
        CharSequence charSequence;
        object = object2.getStringExtra("name");
        if (object == null) {
            object = "unkonw";
        }
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("");
        CharSequence charSequence3 = " [";
        charSequence2.append((String)charSequence3);
        charSequence2.append((String)object);
        charSequence2.append("] ");
        object = charSequence2.toString();
        charSequence2 = "state";
        int n10 = -1;
        int n11 = object2.getIntExtra((String)charSequence2, n10);
        if (n11 != n10) {
            charSequence = new StringBuilder();
            charSequence.append((String)object);
            object = n11 == 0 ? "unplugged" : "plugged";
            charSequence.append((String)object);
            object = charSequence.toString();
        }
        charSequence = new StringBuilder();
        charSequence.append((String)object);
        charSequence.append(" mic:");
        object = charSequence.toString();
        charSequence = "microphone";
        int n12 = object2.getIntExtra((String)charSequence, n10);
        int n13 = 1;
        if (n12 != n10) {
            charSequence3 = new StringBuilder();
            ((StringBuilder)charSequence3).append((String)object);
            object = n12 == n13 ? "Y" : "unkown";
            ((StringBuilder)charSequence3).append((String)object);
            object = ((StringBuilder)charSequence3).toString();
        }
        n12 = (int)(QLog.isColorLevel() ? 1 : 0);
        n10 = 2;
        String string2 = "TRAE";
        if (n12 != 0) {
            object2 = new StringBuilder();
            String string3 = "onHeadsetPlug:: ";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            QLog.w(string2, n10, (String)object);
        }
        if ((object = this._deviceConfigManager) != null) {
            if (n13 != n11) {
                n13 = 0;
                charSequence = null;
            }
            object2 = DEVICE_WIREDHEADSET;
            ((TraeAudioManager$DeviceConfigManager)object).setVisible((String)object2, n13 != 0);
        }
        if (bl2 = QLog.isColorLevel()) {
            object = "onHeadsetPlug exit";
            QLog.w(string2, n10, (String)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceive(Context context, Intent intent) {
        TraeAudioManager traeAudioManager = this;
        Object object = context;
        Object object2 = intent;
        String string2 = DEVICE_BLUETOOTHHEADSET;
        Object object3 = DEVICE_WIREDHEADSET;
        int n10 = 2;
        String string3 = "TRAE";
        if (intent != null && context != null) {
            try {
                int n11;
                Object object4;
                Object object5 = intent.getAction();
                Object object6 = PARAM_OPERATION;
                String string4 = intent.getStringExtra((String)object6);
                int n12 = QLog.isColorLevel();
                if (n12 != 0) {
                    object6 = new StringBuilder();
                    object4 = "TraeAudioManager|onReceive::Action:";
                    ((StringBuilder)object6).append((String)object4);
                    object4 = intent.getAction();
                    ((StringBuilder)object6).append((String)object4);
                    object6 = ((StringBuilder)object6).toString();
                    QLog.w(string3, n10, (String)object6);
                }
                if ((object6 = traeAudioManager._deviceConfigManager) == null) {
                    boolean bl2 = QLog.isColorLevel();
                    if (!bl2) return;
                    object = "_deviceConfigManager null!";
                    QLog.d(string3, n10, (String)object);
                    return;
                }
                n12 = ((TraeAudioManager$DeviceConfigManager)object6).getVisible((String)object3);
                object4 = traeAudioManager._deviceConfigManager;
                boolean bl3 = ((TraeAudioManager$DeviceConfigManager)object4).getVisible(string2);
                String string5 = "android.intent.action.HEADSET_PLUG";
                String string6 = intent.getAction();
                boolean bl4 = string5.equals(string6);
                int n13 = 1;
                int n14 = 0;
                if (bl4) {
                    int n15;
                    this.onHeadsetPlug(context, intent);
                    if (n12 == 0 && (n15 = ((TraeAudioManager$DeviceConfigManager)(object = traeAudioManager._deviceConfigManager)).getVisible((String)object3)) == n13) {
                        traeAudioManager.checkDevicePlug((String)object3, n13 != 0);
                    }
                    if (n12 != n13) return;
                    object = traeAudioManager._deviceConfigManager;
                    n15 = ((TraeAudioManager$DeviceConfigManager)object).getVisible((String)object3);
                    if (n15 != 0) return;
                    traeAudioManager.checkDevicePlug((String)object3, false);
                    return;
                }
                object3 = "android.media.AUDIO_BECOMING_NOISY";
                object6 = intent.getAction();
                boolean bl5 = ((String)object3).equals(object6);
                if (bl5) {
                    return;
                }
                object3 = ACTION_TRAEAUDIOMANAGER_REQUEST;
                bl5 = ((String)object3).equals(object5);
                if (bl5) {
                    int n16 = QLog.isColorLevel();
                    if (n16 != 0) {
                        object = new StringBuilder();
                        string2 = "   OPERATION:";
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(string4);
                        object = ((StringBuilder)object).toString();
                        QLog.w(string3, n10, (String)object);
                    }
                    object = OPERATION_STARTSERVICE;
                    n16 = ((String)object).equals(string4);
                    long l10 = Long.MIN_VALUE;
                    object5 = PARAM_SESSIONID;
                    if (n16 != 0) {
                        l10 = object2.getLongExtra((String)object5, l10);
                        object = EXTRA_DATA_DEVICECONFIG;
                        object = object2.getStringExtra((String)object);
                        TraeAudioManager.startService(string4, l10, false, (String)object);
                        return;
                    }
                    object = OPERATION_STOPSERVICE;
                    n16 = ((String)object).equals(string4);
                    if (n16 != 0) {
                        long l11 = object2.getLongExtra((String)object5, l10);
                        TraeAudioManager.stopService(string4, l11, false);
                        return;
                    }
                    object = OPERATION_GETDEVICELIST;
                    n16 = ((String)object).equals(string4);
                    if (n16 != 0) {
                        long l12 = object2.getLongExtra((String)object5, l10);
                        TraeAudioManager.getDeviceList(string4, l12, false);
                        return;
                    }
                    object = OPERATION_GETSTREAMTYPE;
                    n16 = ((String)object).equals(string4);
                    if (n16 != 0) {
                        long l13 = object2.getLongExtra((String)object5, l10);
                        TraeAudioManager.getStreamType(string4, l13, false);
                        return;
                    }
                    object = OPERATION_CONNECTDEVICE;
                    n16 = ((String)object).equals(string4);
                    if (n16 != 0) {
                        l10 = object2.getLongExtra((String)object5, l10);
                        object = CONNECTDEVICE_DEVICENAME;
                        object = object2.getStringExtra((String)object);
                        TraeAudioManager.connectDevice(string4, l10, false, (String)object);
                        return;
                    }
                    object = OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE;
                    n16 = ((String)object).equals(string4);
                    if (n16 != 0) {
                        long l14 = object2.getLongExtra((String)object5, l10);
                        TraeAudioManager.connectHighestPriorityDevice(string4, l14, false);
                        return;
                    }
                    object = OPERATION_EARACTION;
                    n16 = ((String)object).equals(string4);
                    n12 = -1;
                    if (n16 != 0) {
                        l10 = object2.getLongExtra((String)object5, l10);
                        object = EXTRA_EARACTION;
                        n16 = object2.getIntExtra((String)object, n12);
                        TraeAudioManager.earAction(string4, l10, false, n16);
                        return;
                    }
                    object = OPERATION_ISDEVICECHANGABLED;
                    n16 = ((String)object).equals(string4);
                    if (n16 != 0) {
                        long l15 = object2.getLongExtra((String)object5, l10);
                        TraeAudioManager.isDeviceChangabled(string4, l15, false);
                        return;
                    }
                    object = OPERATION_GETCONNECTEDDEVICE;
                    n16 = (int)(((String)object).equals(string4) ? 1 : 0);
                    if (n16 != 0) {
                        long l16 = object2.getLongExtra((String)object5, l10);
                        TraeAudioManager.getConnectedDevice(string4, l16, false);
                        return;
                    }
                    object = OPERATION_GETCONNECTINGDEVICE;
                    n16 = (int)(((String)object).equals(string4) ? 1 : 0);
                    if (n16 != 0) {
                        long l17 = object2.getLongExtra((String)object5, l10);
                        TraeAudioManager.getConnectingDevice(string4, l17, false);
                        return;
                    }
                    object = OPERATION_VOICECALL_PREPROCESS;
                    n16 = (int)(((String)object).equals(string4) ? 1 : 0);
                    object4 = PARAM_STREAMTYPE;
                    string5 = PARAM_MODEPOLICY;
                    if (n16 != 0) {
                        n14 = object2.getIntExtra(string5, n12);
                        int n17 = object2.getIntExtra((String)object4, n12);
                        long l18 = object2.getLongExtra((String)object5, l10);
                        n13 = 0;
                        string6 = null;
                        TraeAudioManager.voicecallPreprocess(string4, l18, false, n14, n17);
                        return;
                    }
                    object = OPERATION_VOICECALL_POSTPROCESS;
                    n16 = (int)(((String)object).equals(string4) ? 1 : 0);
                    if (n16 != 0) {
                        long l19 = object2.getLongExtra((String)object5, l10);
                        TraeAudioManager.voicecallPostprocess(string4, l19, false);
                        return;
                    }
                    object = OPERATION_VOICECALL_AUDIOPARAM_CHANGED;
                    n16 = (int)(((String)object).equals(string4) ? 1 : 0);
                    if (n16 != 0) {
                        n14 = object2.getIntExtra(string5, n12);
                        int n18 = object2.getIntExtra((String)object4, n12);
                        long l20 = object2.getLongExtra((String)object5, l10);
                        n13 = 0;
                        string6 = null;
                        TraeAudioManager.voiceCallAudioParamChanged(string4, l20, false, n14, n18);
                        return;
                    }
                    object = OPERATION_STARTRING;
                    n16 = (int)(((String)object).equals(string4) ? 1 : 0);
                    if (n16 != 0) {
                        object = PARAM_RING_DATASOURCE;
                        n16 = object2.getIntExtra((String)object, n12);
                        object4 = PARAM_RING_RSID;
                        int n19 = object2.getIntExtra((String)object4, n12);
                        object6 = PARAM_RING_URI;
                        Object object7 = object6 = object2.getParcelableExtra((String)object6);
                        object7 = (Uri)object6;
                        object6 = PARAM_RING_FILEPATH;
                        String string7 = object2.getStringExtra((String)object6);
                        object6 = PARAM_RING_LOOP;
                        boolean bl6 = object2.getBooleanExtra((String)object6, false);
                        object6 = PARAM_RING_USERDATA_STRING;
                        String string8 = object2.getStringExtra((String)object6);
                        object6 = PARAM_RING_LOOPCOUNT;
                        int n20 = object2.getIntExtra((String)object6, n13);
                        object6 = PARAM_RING_MODE;
                        boolean bl7 = object2.getBooleanExtra((String)object6, false);
                        long l21 = object2.getLongExtra((String)object5, l10);
                        n13 = 0;
                        string6 = null;
                        n14 = n16;
                        TraeAudioManager.startRing(string4, l21, false, n16, n19, (Uri)object7, string7, bl6, n20, string8, bl7);
                        return;
                    }
                    object = OPERATION_STOPRING;
                    n16 = (int)(((String)object).equals(string4) ? 1 : 0);
                    if (n16 == 0) return;
                    long l22 = object2.getLongExtra((String)object5, l10);
                    TraeAudioManager.stopRing(string4, l22, false);
                    return;
                }
                object3 = traeAudioManager._deviceConfigManager;
                if (object3 == null) return;
                object5 = traeAudioManager._bluetoothCheck;
                if (object5 != null) {
                    ((TraeAudioManager$BluetoohHeadsetCheckInterface)object5).onReceive((Context)object, (Intent)object2, (TraeAudioManager$DeviceConfigManager)object3);
                }
                if (!bl3 && (n11 = ((TraeAudioManager$DeviceConfigManager)(object = traeAudioManager._deviceConfigManager)).getVisible(string2)) == n13) {
                    traeAudioManager.checkDevicePlug(string2, n13 != 0);
                }
                if (bl3 != n13) return;
                object = traeAudioManager._deviceConfigManager;
                n11 = ((TraeAudioManager$DeviceConfigManager)object).getVisible(string2);
                if (n11 != 0) return;
                traeAudioManager.checkDevicePlug(string2, false);
                return;
            }
            catch (Exception exception) {
                boolean bl8 = QLog.isColorLevel();
                if (!bl8) return;
                object2 = new StringBuilder();
                string2 = "deal with receiver failed.";
                ((StringBuilder)object2).append(string2);
                String string9 = exception.getMessage();
                ((StringBuilder)object2).append(string9);
                string9 = ((StringBuilder)object2).toString();
                QLog.e(string3, n10, string9);
            }
            return;
        }
        boolean bl9 = QLog.isColorLevel();
        if (!bl9) return;
        object = "onReceive intent or context is null!";
        QLog.d(string3, n10, (String)object);
    }

    public void printDevices() {
        int n10;
        Object object;
        boolean bl2;
        CharSequence charSequence;
        String string2;
        String string3;
        Object object2;
        String string4;
        Object object3;
        CharSequence charSequence2;
        AudioDeviceInterface.LogTraceEntry("");
        String[] stringArray = this._deviceConfigManager;
        int n11 = 2;
        String string5 = "TRAE";
        if (stringArray == null) {
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                stringArray = "_deviceConfigManager is null";
                QLog.w(string5, n11, (String)stringArray);
            }
            return;
        }
        int n12 = stringArray.getDeviceNumber();
        int n13 = QLog.isColorLevel();
        if (n13 != 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("   ConnectedDevice:");
            object3 = this._deviceConfigManager.getConnectedDevice();
            ((StringBuilder)charSequence2).append((String)object3);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            QLog.w(string5, n11, (String)charSequence2);
        }
        if ((n13 = QLog.isColorLevel()) != 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("   ConnectingDevice:");
            object3 = this._deviceConfigManager.getConnectingDevice();
            ((StringBuilder)charSequence2).append((String)object3);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            QLog.w(string5, n11, (String)charSequence2);
        }
        if ((n13 = QLog.isColorLevel()) != 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("   prevConnectedDevice:");
            object3 = this._deviceConfigManager.getPrevConnectedDevice();
            ((StringBuilder)charSequence2).append((String)object3);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            QLog.w(string5, n11, (String)charSequence2);
        }
        if ((n13 = QLog.isColorLevel()) != 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("   AHPDevice:");
            object3 = this._deviceConfigManager.getAvailabledHighestPriorityDevice();
            ((StringBuilder)charSequence2).append((String)object3);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            QLog.w(string5, n11, (String)charSequence2);
        }
        if ((n13 = QLog.isColorLevel()) != 0) {
            charSequence2 = new StringBuilder();
            object3 = "   deviceNamber:";
            ((StringBuilder)charSequence2).append((String)object3);
            ((StringBuilder)charSequence2).append(n12);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            QLog.w(string5, n11, (String)charSequence2);
        }
        n13 = 0;
        charSequence2 = null;
        int n14 = 0;
        object3 = null;
        while (true) {
            string4 = " Priority:";
            object2 = " Visible:";
            string3 = " devName:";
            string2 = "      ";
            if (n14 >= n12) break;
            charSequence = this._deviceConfigManager.getDeviceName(n14);
            bl2 = QLog.isColorLevel();
            if (bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(n14);
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append((String)object2);
                object2 = this._deviceConfigManager;
                boolean bl4 = ((TraeAudioManager$DeviceConfigManager)object2).getVisible((String)charSequence);
                ((StringBuilder)object).append(bl4);
                ((StringBuilder)object).append(string4);
                int n15 = this._deviceConfigManager.getPriority((String)charSequence);
                ((StringBuilder)object).append(n15);
                string4 = ((StringBuilder)object).toString();
                QLog.w(string5, n11, string4);
            }
            ++n14;
        }
        stringArray = this._deviceConfigManager.getAvailableDeviceList();
        object3 = new String[]{};
        stringArray = stringArray.toArray((T[])object3);
        n14 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n14 != 0) {
            object3 = new StringBuilder();
            charSequence = "   AvailableNamber:";
            ((StringBuilder)object3).append((String)charSequence);
            n10 = stringArray.length;
            ((StringBuilder)object3).append(n10);
            object3 = ((StringBuilder)object3).toString();
            QLog.w(string5, n11, (String)object3);
        }
        while (n13 < (n14 = stringArray.length)) {
            object3 = stringArray[n13];
            n10 = QLog.isColorLevel();
            if (n10 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append(n13);
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append((String)object3);
                ((StringBuilder)charSequence).append((String)object2);
                bl2 = this._deviceConfigManager.getVisible((String)object3);
                ((StringBuilder)charSequence).append(bl2);
                ((StringBuilder)charSequence).append(string4);
                object = this._deviceConfigManager;
                n14 = ((TraeAudioManager$DeviceConfigManager)object).getPriority((String)object3);
                ((StringBuilder)charSequence).append(n14);
                object3 = ((StringBuilder)charSequence).toString();
                QLog.w(string5, n11, (String)object3);
            }
            ++n13;
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public void release() {
        AudioDeviceInterface.LogTraceEntry("");
        TraeAudioManager$TraeAudioManagerLooper traeAudioManager$TraeAudioManagerLooper = this.mTraeAudioManagerLooper;
        if (traeAudioManager$TraeAudioManagerLooper != null) {
            traeAudioManager$TraeAudioManagerLooper.quit();
            traeAudioManager$TraeAudioManagerLooper = null;
            this.mTraeAudioManagerLooper = null;
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public int sendResBroadcast(Intent intent, HashMap hashMap, int n10) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object = this._context;
        int n11 = -1;
        if (object == null) {
            return n11;
        }
        object = PARAM_SESSIONID;
        Object object2 = (Long)hashMap.get(object);
        int n12 = QLog.isColorLevel();
        int n13 = 2;
        Object object3 = "TRAE";
        String string2 = PARAM_OPERATION;
        if (n12 != 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append(" sessonID:");
            charSequence.append(object2);
            charSequence.append(" ");
            String string3 = (String)hashMap.get(string2);
            charSequence.append(string3);
            charSequence = charSequence.toString();
            QLog.w((String)object3, n13, (String)charSequence);
        }
        if (object2 != null && (l13 = (l12 = (l11 = ((Long)object2).longValue()) - (l10 = Long.MIN_VALUE)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            Object object4;
            Long l14 = (Long)hashMap.get(object);
            object2 = object4 = hashMap.get(string2);
            object4 = OPERATION_VOICECALL_PREPROCESS;
            object2 = (String)object4;
            boolean bl2 = ((String)object4).equals(object2);
            if (bl2) {
                intent.setAction(ACTION_TRAEAUDIOMANAGER_RES);
                intent.putExtra((String)object, (Serializable)l14);
                intent.putExtra(string2, (String)object2);
                intent.putExtra(PARAM_RES_ERRCODE, n10);
                object4 = this._audioSessionHost;
                if (object4 != null) {
                    ((TraeAudioSessionHost)object4).sendToAudioSessionMessage(intent);
                }
            } else {
                object4 = Looper.getMainLooper();
                Handler handler = new Handler((Looper)object4);
                object4 = object3;
                object = this;
                n12 = n10;
                object3 = new TraeAudioManager$1(this, intent, l14, (String)object2, n10);
                handler.post((Runnable)object3);
            }
            return 0;
        }
        this.InternalNotifyDeviceListUpdate();
        boolean bl3 = QLog.isColorLevel();
        if (bl3) {
            String string4 = "sendResBroadcast sid null,don't send res";
            QLog.e((String)object3, n13, string4);
        }
        return n11;
    }

    /*
     * Unable to fully structure code
     */
    public void updateDeviceStatus() {
        var1_1 = this._deviceConfigManager;
        var2_2 = 2;
        var3_3 = "TRAE";
        if (var1_1 == null) {
            var4_4 = QLog.isColorLevel();
            if (var4_4) {
                var1_1 = "_deviceConfigManager is null";
                QLog.w(var3_3, var2_2, (String)var1_1);
            }
            return;
        }
        var4_5 = var1_1.getDeviceNumber();
        for (var5_6 = 0; var5_6 < var4_5; ++var5_6) {
            var6_7 = this._deviceConfigManager.getDeviceName(var5_6);
            var7_8 = true;
            if (var6_7 == null) ** GOTO lbl41
            var8_9 = "DEVICE_BLUETOOTHHEADSET";
            var9_10 = var6_7.equals(var8_9);
            if (var9_10) {
                var8_9 = this._bluetoothCheck;
                if (var8_9 == null) {
                    var8_9 = this._deviceConfigManager;
                    var9_10 = var8_9.setVisible(var6_7, false);
                } else {
                    var10_11 = this._deviceConfigManager;
                    var9_10 = var8_9.isConnected();
                    var9_10 = var10_11.setVisible(var6_7, var9_10);
                }
            } else {
                var8_9 = "DEVICE_WIREDHEADSET";
                var9_10 = var6_7.equals(var8_9);
                if (var9_10) {
                    var8_9 = this._deviceConfigManager;
                    var10_11 = this._am;
                    var11_12 = var10_11.isWiredHeadsetOn();
                    var9_10 = var8_9.setVisible(var6_7, var11_12);
                } else {
                    var8_9 = "DEVICE_SPEAKERPHONE";
                    var9_10 = var6_7.equals(var8_9);
                    if (var9_10) {
                        var8_9 = this._deviceConfigManager;
                        var8_9.setVisible(var6_7, var7_8);
                    }
lbl41:
                    // 4 sources

                    var9_10 = false;
                    var8_9 = null;
                }
            }
            if (var9_10 != var7_8 || !(var7_8 = QLog.isColorLevel())) continue;
            var12_13 = new StringBuilder();
            var12_13.append("pollUpdateDevice dev:");
            var12_13.append(var6_7);
            var12_13.append(" Visible:");
            var8_9 = this._deviceConfigManager;
            var13_14 = var8_9.getVisible(var6_7);
            var12_13.append(var13_14);
            var6_7 = var12_13.toString();
            QLog.w(var3_3, var2_2, var6_7);
        }
        this.checkAutoDeviceListUpdate();
    }
}

