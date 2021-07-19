/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.media.AudioManager
 *  android.media.AudioManager$OnAudioFocusChangeListener
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.os.Process
 *  android.os.SystemClock
 *  android.util.Log
 */
package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$BluetoohHeadsetCheckInterface;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper$1;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper$2;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$TraeAudioManagerLooper$3;
import com.tencent.rtmp.sharp.jni.TraeMediaPlayer;
import com.tencent.rtmp.sharp.jni.TraeMediaPlayer$OnCompletionListener;
import java.util.HashMap;

public class TraeAudioManager$TraeAudioManagerLooper
extends Thread {
    public static final int MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE = 32786;
    public static final int MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE = 32787;
    public static final int MESSAGE_AUTO_DEVICELIST_UPDATE = 32785;
    public static final int MESSAGE_BEGIN = 32768;
    public static final int MESSAGE_CONNECTDEVICE = 32775;
    public static final int MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE = 32789;
    public static final int MESSAGE_DISABLE = 32773;
    public static final int MESSAGE_EARACTION = 32776;
    public static final int MESSAGE_ENABLE = 32772;
    public static final int MESSAGE_GETCONNECTEDDEVICE = 32778;
    public static final int MESSAGE_GETCONNECTINGDEVICE = 32779;
    public static final int MESSAGE_GETDEVICELIST = 32774;
    public static final int MESSAGE_GETSTREAMTYPE = 32784;
    public static final int MESSAGE_ISDEVICECHANGABLED = 32777;
    public static final int MESSAGE_RECOVER_AUDIO_FOCUS = 32791;
    public static final int MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS = 32790;
    public static final int MESSAGE_STARTRING = 32782;
    public static final int MESSAGE_STOPRING = 32783;
    public static final int MESSAGE_VOICECALLPOSTPROCESS = 32781;
    public static final int MESSAGE_VOICECALLPREPROCESS = 32780;
    public static final int MESSAGE_VOICECALL_AUIDOPARAM_CHANGED = 32788;
    public boolean _enabled;
    public int _focusSteamType;
    public String _lastCfg;
    public TraeAudioManager _parent;
    public int _preRingMode;
    public int _preServiceMode;
    public String _ringOperation;
    public TraeMediaPlayer _ringPlayer;
    public long _ringSessionID;
    public String _ringUserdata;
    public final boolean[] _started;
    public String _voiceCallOperation;
    public long _voiceCallSessionID;
    public AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    public Handler mMsgHandler;
    public final /* synthetic */ TraeAudioManager this$0;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TraeAudioManager$TraeAudioManagerLooper(TraeAudioManager object, TraeAudioManager traeAudioManager) {
        long l10;
        String string2;
        String string3;
        long l11;
        this.this$0 = object;
        object = null;
        this.mMsgHandler = null;
        this._ringPlayer = null;
        this._ringSessionID = l11 = (long)-1;
        this._ringOperation = "";
        this._ringUserdata = "";
        int n10 = 1;
        Object object2 = new boolean[n10];
        String string4 = null;
        object2[0] = false;
        this._started = object2;
        this._enabled = false;
        this._parent = null;
        this._lastCfg = string3 = "";
        this._preServiceMode = 0;
        this._preRingMode = 0;
        this._voiceCallSessionID = l11;
        this._voiceCallOperation = string2 = "";
        this.mAudioFocusChangeListener = null;
        this._focusSteamType = 0;
        this._parent = traeAudioManager;
        long l12 = SystemClock.elapsedRealtime();
        boolean bl2 = QLog.isColorLevel();
        int n11 = 2;
        if (bl2) {
            string2 = "TRAE";
            string3 = "TraeAudioManagerLooper start...";
            QLog.e(string2, n11, string3);
        }
        this.start();
        synchronized (object2) {
            bl2 = object2[0];
            if (!bl2) {
                l10 = 3000L;
                try {
                    object2.wait(l10);
                }
                catch (InterruptedException interruptedException) {}
            }
        }
        bl2 = QLog.isColorLevel();
        if (bl2) {
            string2 = "TRAE";
            object2 = new StringBuilder;
            string4 = "  start used:";
            ((StringBuilder)object2).append(string4);
            l10 = SystemClock.elapsedRealtime() - l12;
            ((StringBuilder)object2).append(l10);
            ((StringBuilder)object2).append("ms");
            object = ((StringBuilder)object2).toString();
            QLog.e(string2, n11, (String)object);
        }
    }

    public int InternalGetStreamType(HashMap object) {
        int n10;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(" activeMode:");
        int n11 = this.this$0._activeMode;
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append(" _preRingMode:");
        n11 = this._preRingMode;
        ((StringBuilder)object2).append(n11);
        AudioDeviceInterface.LogTraceEntry(((StringBuilder)object2).toString());
        object2 = this.this$0;
        AudioManager audioManager = ((TraeAudioManager)object2)._am;
        int n12 = 2;
        if (audioManager == null) {
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = "TRAE";
                object2 = " InternalStopRing am==null!!";
                QLog.e((String)object, n12, (String)object2);
            }
            return -1;
        }
        n11 = ((TraeAudioManager)object2)._activeMode;
        if (n11 == n12) {
            object2 = this._ringPlayer;
            n10 = ((TraeMediaPlayer)object2).getStreamType();
        } else {
            n10 = ((TraeAudioManager)object2)._streamType;
        }
        audioManager = new Intent();
        audioManager.putExtra("EXTRA_DATA_STREAMTYPE", n10);
        this.this$0.sendResBroadcast((Intent)audioManager, (HashMap)object, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public int InternalNotifyStreamTypeUpdate(int n10) {
        Context context = this.this$0._context;
        if (context == null) {
            return -1;
        }
        Object object = Looper.getMainLooper();
        context = new Handler(object);
        object = new TraeAudioManager$TraeAudioManagerLooper$3(this, n10);
        context.post((Runnable)object);
        return 0;
    }

    public int InternalSessionGetDeviceList(HashMap hashMap) {
        Intent intent = new Intent();
        Object object = this.this$0._deviceConfigManager.getSnapParams();
        String string2 = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
        String[] stringArray = (String[])((HashMap)object).get(string2);
        String string3 = "EXTRA_DATA_CONNECTEDDEVICE";
        String string4 = (String)((HashMap)object).get(string3);
        String string5 = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
        object = (String)((HashMap)object).get(string5);
        String[] stringArray2 = new String[]{};
        stringArray = stringArray.toArray(stringArray2);
        intent.putExtra(string2, stringArray);
        intent.putExtra(string3, string4);
        intent.putExtra(string5, (String)object);
        object = this.this$0._deviceConfigManager.getBluetoothName();
        intent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", (String)object);
        this.this$0.sendResBroadcast(intent, hashMap, 0);
        return 0;
    }

    public int InternalStartRing(HashMap hashMap) {
        int n10;
        boolean bl2;
        int n11;
        boolean bl3;
        Object object;
        Object object2;
        int n12;
        int n13;
        int n14;
        String string2;
        int n15;
        Object object3;
        int n16;
        Object object4;
        Object object5;
        Object object6;
        TraeAudioManager$TraeAudioManagerLooper traeAudioManager$TraeAudioManagerLooper;
        block42: {
            block41: {
                traeAudioManager$TraeAudioManagerLooper = this;
                object6 = hashMap;
                object5 = "PARAM_RING_USERDATA_STRING";
                object4 = new StringBuilder();
                object4.append(" activeMode:");
                n16 = this.this$0._activeMode;
                object4.append(n16);
                AudioDeviceInterface.LogTraceEntry(object4.toString());
                object4 = this.this$0;
                object3 = ((TraeAudioManager)object4)._am;
                n15 = -1;
                string2 = "TRAE";
                n14 = 2;
                if (object3 == null) {
                    boolean bl4 = QLog.isColorLevel();
                    if (bl4) {
                        object6 = " InternalStartRing am==null!!";
                        QLog.e(string2, n14, (String)object6);
                    }
                    return n15;
                }
                int n17 = ((TraeAudioManager)object4)._activeMode;
                if (n17 == n14) {
                    this.interruptRing();
                }
                object4 = "PARAM_SESSIONID";
                try {
                    object4 = ((HashMap)object6).get(object4);
                }
                catch (Exception exception) {
                    boolean bl5 = QLog.isColorLevel();
                    if (bl5) {
                        object6 = " startRing err params";
                        QLog.e(string2, n14, (String)object6);
                    }
                    return n15;
                }
                object4 = (Long)object4;
                long l10 = (Long)object4;
                traeAudioManager$TraeAudioManagerLooper._ringSessionID = l10;
                object4 = "PARAM_OPERATION";
                object4 = ((HashMap)object6).get(object4);
                object4 = (String)object4;
                traeAudioManager$TraeAudioManagerLooper._ringOperation = object4;
                object4 = ((HashMap)object6).get(object5);
                object4 = (String)object4;
                traeAudioManager$TraeAudioManagerLooper._ringUserdata = object4;
                object4 = "PARAM_RING_DATASOURCE";
                object4 = ((HashMap)object6).get(object4);
                object4 = (Integer)object4;
                n13 = (Integer)object4;
                n17 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n17 == 0) break block41;
                object4 = new StringBuilder();
                object3 = "  dataSource:";
                object4.append((String)object3);
                object4.append(n13);
                object4 = object4.toString();
                QLog.w(string2, n14, (String)object4);
            }
            object4 = "PARAM_RING_RSID";
            object4 = ((HashMap)object6).get(object4);
            object4 = (Integer)object4;
            n12 = (Integer)object4;
            object4 = "PARAM_RING_URI";
            object2 = object4 = ((HashMap)object6).get(object4);
            object2 = (Uri)object4;
            object4 = "PARAM_RING_FILEPATH";
            object = object4 = ((HashMap)object6).get(object4);
            object = (String)object4;
            object4 = "PARAM_RING_LOOP";
            object4 = ((HashMap)object6).get(object4);
            object4 = (Boolean)object4;
            bl3 = (Boolean)object4;
            object4 = "PARAM_RING_LOOPCOUNT";
            object4 = ((HashMap)object6).get(object4);
            object4 = (Integer)object4;
            n11 = (Integer)object4;
            object4 = "PARAM_RING_MODE";
            object4 = ((HashMap)object6).get(object4);
            object4 = (Boolean)object4;
            bl2 = (Boolean)object4;
            object4 = traeAudioManager$TraeAudioManagerLooper.this$0;
            n16 = ((TraeAudioManager)object4)._activeMode;
            n15 = 1;
            if (n16 == n15) break block42;
            ((TraeAudioManager)object4)._activeMode = n14;
        }
        object4 = new Intent();
        object3 = traeAudioManager$TraeAudioManagerLooper._ringUserdata;
        object4.putExtra((String)object5, (String)object3);
        object5 = traeAudioManager$TraeAudioManagerLooper.this$0;
        n16 = 0;
        object3 = null;
        ((TraeAudioManager)((Object)object5)).sendResBroadcast((Intent)object4, (HashMap)object6, 0);
        traeAudioManager$TraeAudioManagerLooper._preRingMode = n10 = traeAudioManager$TraeAudioManagerLooper.this$0._am.getMode();
        TraeMediaPlayer traeMediaPlayer = traeAudioManager$TraeAudioManagerLooper._ringPlayer;
        object6 = traeAudioManager$TraeAudioManagerLooper.this$0;
        int n18 = ((TraeAudioManager)object6)._activeMode;
        int n19 = n18 == n15 ? n15 : 0;
        n10 = ((TraeAudioManager)object6)._streamType;
        traeMediaPlayer.playRing(n13, n12, (Uri)object2, (String)object, bl3, n11, bl2, n19 != 0, n10);
        n10 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n10 != 0) {
            object6 = new StringBuilder();
            ((StringBuilder)object6).append(" _ringUserdata:");
            object5 = traeAudioManager$TraeAudioManagerLooper._ringUserdata;
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append(" DurationMS:");
            object5 = traeAudioManager$TraeAudioManagerLooper._ringPlayer;
            n18 = ((TraeMediaPlayer)object5).getDuration();
            ((StringBuilder)object6).append(n18);
            object6 = ((StringBuilder)object6).toString();
            QLog.w(string2, n14, (String)object6);
        }
        n10 = traeAudioManager$TraeAudioManagerLooper._ringPlayer.getStreamType();
        traeAudioManager$TraeAudioManagerLooper.InternalNotifyStreamTypeUpdate(n10);
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public int InternalStopRing(HashMap object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(" activeMode:");
        int n10 = this.this$0._activeMode;
        ((StringBuilder)object2).append(n10);
        String string2 = " _preRingMode:";
        ((StringBuilder)object2).append(string2);
        n10 = this._preRingMode;
        ((StringBuilder)object2).append(n10);
        AudioDeviceInterface.LogTraceEntry(((StringBuilder)object2).toString());
        object2 = this.this$0._am;
        n10 = 2;
        if (object2 != null && (object2 = this._ringPlayer) != null) {
            ((TraeMediaPlayer)object2).stopRing();
            object2 = this._ringPlayer;
            boolean n11 = ((TraeMediaPlayer)object2).hasCall();
            if (!n11) {
                object2 = this.this$0;
                int n12 = ((TraeAudioManager)object2)._activeMode;
                if (n12 == n10) {
                    this.abandonAudioFocus();
                    object2 = this.this$0;
                    ((TraeAudioManager)object2)._activeMode = 0;
                }
            }
            object2 = new Intent();
            string2 = this._ringUserdata;
            object2.putExtra("PARAM_RING_USERDATA_STRING", string2);
            this.this$0.sendResBroadcast((Intent)object2, (HashMap)object, 0);
            AudioDeviceInterface.LogTraceExit();
            return 0;
        }
        boolean bl2 = QLog.isColorLevel();
        if (bl2) {
            object = "TRAE";
            object2 = " InternalStopRing am==null!!";
            QLog.e((String)object, n10, (String)object2);
        }
        return -1;
    }

    public int InternalVoicecallPostprocess(HashMap object) {
        Object object2 = new StringBuilder();
        object2.append(" activeMode:");
        int n10 = this.this$0._activeMode;
        object2.append(n10);
        AudioDeviceInterface.LogTraceEntry(object2.toString());
        object2 = this.this$0;
        AudioManager audioManager = ((TraeAudioManager)object2)._am;
        int n11 = 2;
        String string2 = "TRAE";
        int n12 = -1;
        if (audioManager == null) {
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = " InternalVoicecallPostprocess am==null!!";
                QLog.e(string2, n11, (String)object);
            }
            return n12;
        }
        n10 = ((TraeAudioManager)object2)._activeMode;
        int n13 = 1;
        if (n10 != n13) {
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                object2 = " not ACTIVE_VOICECALL!!";
                QLog.e(string2, n11, (String)object2);
            }
            object2 = new Intent();
            this.this$0.sendResBroadcast((Intent)object2, (HashMap)object, 3);
            return n12;
        }
        ((TraeAudioManager)object2)._activeMode = 0;
        this.abandonAudioFocus();
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public int InternalVoicecallPreprocess(HashMap var1_1) {
        var2_2 = new StringBuilder();
        var2_2.append(" activeMode:");
        var3_3 /* !! */  = this.this$0;
        var4_4 = var3_3 /* !! */ ._activeMode;
        var2_2.append(var4_4);
        var2_2 = var2_2.toString();
        AudioDeviceInterface.LogTraceEntry((String)var2_2);
        var5_5 = -1;
        if (var1_1 == null) {
            return var5_5;
        }
        var3_3 /* !! */  = this.this$0;
        var6_6 /* !! */  = var3_3 /* !! */ ._deviceConfigManager;
        if (var6_6 /* !! */  == null) {
            return var5_5;
        }
        var6_6 /* !! */  = var3_3 /* !! */ ._am;
        var7_7 = "TRAE";
        var8_8 = 2;
        if (var6_6 /* !! */  == null) {
            var9_9 = QLog.isColorLevel();
            if (var9_9) {
                var1_1 = " InternalVoicecallPreprocess am==null!!";
                QLog.e(var7_7, var8_8, (String)var1_1);
            }
            return var5_5;
        }
        var4_4 = var3_3 /* !! */ ._activeMode;
        var10_10 = 1;
        if (var4_4 == var10_10) {
            var3_3 /* !! */  = new Intent();
            this.this$0.sendResBroadcast((Intent)var3_3 /* !! */ , (HashMap)var1_1, var8_8);
            return var5_5;
        }
        this._voiceCallSessionID = var11_11 = ((Long)var1_1.get("PARAM_SESSIONID")).longValue();
        var3_3 /* !! */  = (String)var1_1.get("PARAM_OPERATION");
        this._voiceCallOperation = var3_3 /* !! */ ;
        var3_3 /* !! */  = this.this$0;
        var3_3 /* !! */ ._activeMode = var10_10;
        var6_6 /* !! */  = var3_3 /* !! */ ._am;
        var3_3 /* !! */ ._prevMode = var10_10 = var6_6 /* !! */ .getMode();
        var3_3 /* !! */  = (Integer)var1_1.get("PARAM_MODEPOLICY");
        if (var3_3 /* !! */  == null) {
            var4_4 = (int)QLog.isColorLevel();
            if (var4_4 != 0) {
                var3_3 /* !! */  = " params.get(PARAM_MODEPOLICY)==null!!";
                QLog.e(var7_7, var8_8, (String)var3_3 /* !! */ );
            }
            var3_3 /* !! */  = this.this$0;
            var3_3 /* !! */ ._modePolicy = var5_5;
        } else {
            var2_2 = this.this$0;
            var2_2._modePolicy = var4_4 = var3_3 /* !! */ .intValue();
        }
        var5_5 = (int)QLog.isColorLevel();
        if (var5_5 != 0) {
            var2_2 = new StringBuilder();
            var2_2.append("  _modePolicy:");
            var3_3 /* !! */  = this.this$0;
            var4_4 = var3_3 /* !! */ ._modePolicy;
            var2_2.append(var4_4);
            var2_2 = var2_2.toString();
            QLog.e(var7_7, var8_8, (String)var2_2);
        }
        var2_2 = (Integer)var1_1.get("PARAM_STREAMTYPE");
        var4_4 = 0;
        var3_3 /* !! */  = null;
        if (var2_2 == null) {
            var5_5 = (int)QLog.isColorLevel();
            if (var5_5 != 0) {
                var2_2 = " params.get(PARAM_STREAMTYPE)==null!!";
                QLog.e(var7_7, var8_8, (String)var2_2);
            }
            var2_2 = this.this$0;
            var2_2._streamType = 0;
        } else {
            var6_6 /* !! */  = this.this$0;
            var6_6 /* !! */ ._streamType = var5_5 = var2_2.intValue();
        }
        var2_2 = this.this$0;
        var5_5 = (int)TraeAudioManager.isCloseSystemAPM(var2_2._modePolicy);
        if (var5_5 == 0) ** GOTO lbl-1000
        var2_2 = this.this$0;
        var10_10 = var2_2._activeMode;
        if (var10_10 != var8_8 && (var2_2 = var2_2._deviceConfigManager) != null) {
            var5_5 = (int)(var2_2 = var2_2.getConnectedDevice()).equals(var6_6 /* !! */  = "DEVICE_SPEAKERPHONE");
            if (var5_5 != 0) {
                var2_2 = this.this$0;
                var2_2.InternalSetMode(0);
            } else {
                var2_2 = this.this$0;
                var10_10 = 3;
                var2_2.InternalSetMode(var10_10);
            }
        } else lbl-1000:
        // 2 sources

        {
            var2_2 = this.this$0;
            var10_10 = TraeAudioManager.getCallAudioMode(var2_2._modePolicy);
            var2_2.InternalSetMode(var10_10);
        }
        var2_2 = new Intent();
        this.this$0.sendResBroadcast((Intent)var2_2, (HashMap)var1_1, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public void _init() {
        block22: {
            AudioDeviceInterface.LogTraceEntry("");
            Object object = this.this$0._deviceConfigManager;
            int n10 = 2;
            String string2 = "TRAE";
            if (object == null) {
                boolean bl2 = QLog.isColorLevel();
                if (bl2) {
                    object = "_deviceConfigManager is null";
                    QLog.w(string2, n10, (String)object);
                }
                return;
            }
            int n11 = Process.myPid();
            TraeAudioManager._gHostProcessId = n11;
            object = this.this$0;
            Object object2 = ((TraeAudioManager)object)._context;
            Object object3 = "audio";
            object2 = object2.getSystemService((String)object3);
            object2 = (AudioManager)object2;
            ((TraeAudioManager)object)._am = object2;
            object = this.this$0;
            object2 = ((TraeAudioManager)object)._context;
            object3 = ((TraeAudioManager)object)._deviceConfigManager;
            object2 = ((TraeAudioManager)((Object)object)).CreateBluetoothCheck((Context)object2, (TraeAudioManager$DeviceConfigManager)object3);
            ((TraeAudioManager)object)._bluetoothCheck = object2;
            object = new IntentFilter();
            object2 = "android.intent.action.HEADSET_PLUG";
            object.addAction((String)object2);
            object2 = "android.media.AUDIO_BECOMING_NOISY";
            object.addAction((String)object2);
            object2 = this.this$0;
            object2 = object2._bluetoothCheck;
            object2.addAction((IntentFilter)object);
            object2 = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
            object.addAction((String)object2);
            object2 = this.this$0;
            object2 = object2._context;
            object3 = this._parent;
            try {
                object2.registerReceiver((BroadcastReceiver)object3, (IntentFilter)object);
            }
            catch (Exception exception) {
                n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n11 == 0) break block22;
                object = "======7";
                QLog.e(string2, n10, (String)object);
            }
        }
        AudioDeviceInterface.LogTraceExit();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void _post_stopService() {
        TraeAudioManager traeAudioManager = this.this$0;
        TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager = traeAudioManager._deviceConfigManager;
        int n10 = 2;
        String string2 = "TRAE";
        if (traeAudioManager$DeviceConfigManager == null) {
            boolean bl2 = QLog.isColorLevel();
            if (!bl2) return;
            String string3 = "_deviceConfigManager is null";
            QLog.w(string2, n10, string3);
            return;
        }
        try {
            TraeAudioManager$BluetoohHeadsetCheckInterface traeAudioManager$BluetoohHeadsetCheckInterface = traeAudioManager._bluetoothCheck;
            if (traeAudioManager$BluetoohHeadsetCheckInterface != null) {
                traeAudioManager$BluetoohHeadsetCheckInterface.release();
            }
            TraeAudioManager traeAudioManager2 = this.this$0;
            boolean bl3 = false;
            Object var2_11 = null;
            traeAudioManager2._bluetoothCheck = null;
            Context context = traeAudioManager2._context;
            if (context == null) return;
            TraeAudioManager traeAudioManager3 = this._parent;
            context.unregisterReceiver((BroadcastReceiver)traeAudioManager3);
            IntentFilter intentFilter = new IntentFilter();
            String string4 = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
            intentFilter.addAction(string4);
            TraeAudioManager traeAudioManager4 = this.this$0;
            Context context2 = traeAudioManager4._context;
            TraeAudioManager traeAudioManager5 = this._parent;
            context2.registerReceiver((BroadcastReceiver)traeAudioManager5, intentFilter);
            return;
        }
        catch (Exception exception) {
            boolean bl4 = QLog.isColorLevel();
            if (!bl4) return;
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "stop service failed.";
            stringBuilder.append(string5);
            String string6 = exception.getMessage();
            stringBuilder.append(string6);
            String string7 = stringBuilder.toString();
            QLog.e(string2, n10, string7);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void _prev_startService() {
        Object object = this.this$0;
        TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager = ((TraeAudioManager)object)._deviceConfigManager;
        int n10 = 2;
        String string2 = "TRAE";
        if (traeAudioManager$DeviceConfigManager == null) {
            boolean bl2 = QLog.isColorLevel();
            if (!bl2) return;
            object = "_deviceConfigManager is null";
            QLog.w(string2, n10, (String)object);
            return;
        }
        try {
            AudioManager audioManager;
            Context context = ((TraeAudioManager)object)._context;
            String string3 = "audio";
            Object object2 = context.getSystemService(string3);
            ((TraeAudioManager)object)._am = audioManager = (AudioManager)object2;
            object = this.this$0;
            TraeAudioManager$BluetoohHeadsetCheckInterface traeAudioManager$BluetoohHeadsetCheckInterface = ((TraeAudioManager)object)._bluetoothCheck;
            if (traeAudioManager$BluetoohHeadsetCheckInterface == null) {
                TraeAudioManager$BluetoohHeadsetCheckInterface traeAudioManager$BluetoohHeadsetCheckInterface2;
                Context context2 = ((TraeAudioManager)object)._context;
                TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager2 = ((TraeAudioManager)object)._deviceConfigManager;
                ((TraeAudioManager)object)._bluetoothCheck = traeAudioManager$BluetoohHeadsetCheckInterface2 = ((TraeAudioManager)((Object)object)).CreateBluetoothCheck(context2, traeAudioManager$DeviceConfigManager2);
            }
            object = this.this$0;
            object = ((TraeAudioManager)object)._context;
            TraeAudioManager traeAudioManager = this._parent;
            object.unregisterReceiver((BroadcastReceiver)traeAudioManager);
            object = new IntentFilter();
            String string4 = "android.intent.action.HEADSET_PLUG";
            object.addAction(string4);
            String string5 = "android.media.AUDIO_BECOMING_NOISY";
            object.addAction(string5);
            TraeAudioManager traeAudioManager2 = this.this$0;
            TraeAudioManager$BluetoohHeadsetCheckInterface traeAudioManager$BluetoohHeadsetCheckInterface3 = traeAudioManager2._bluetoothCheck;
            traeAudioManager$BluetoohHeadsetCheckInterface3.addAction((IntentFilter)object);
            String string6 = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
            object.addAction(string6);
            TraeAudioManager traeAudioManager3 = this.this$0;
            Context context3 = traeAudioManager3._context;
            TraeAudioManager traeAudioManager4 = this._parent;
            context3.registerReceiver((BroadcastReceiver)traeAudioManager4, (IntentFilter)object);
            return;
        }
        catch (Exception exception) {
            boolean bl3 = QLog.isColorLevel();
            if (!bl3) return;
            object = "======7";
            QLog.w(string2, n10, (String)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void _uninit() {
        block5: {
            Object object = "";
            AudioDeviceInterface.LogTraceEntry((String)object);
            try {
                this.stopService();
                object = this.this$0;
                object = ((TraeAudioManager)object)._bluetoothCheck;
                if (object != null) {
                    ((TraeAudioManager$BluetoohHeadsetCheckInterface)object).release();
                }
                object = this.this$0;
                boolean bl2 = false;
                ((TraeAudioManager)object)._bluetoothCheck = null;
                object = ((TraeAudioManager)object)._context;
                if (object != null) {
                    TraeAudioManager traeAudioManager = this._parent;
                    object.unregisterReceiver((BroadcastReceiver)traeAudioManager);
                    object = this.this$0;
                    ((TraeAudioManager)object)._context = null;
                }
                object = this.this$0;
                object = ((TraeAudioManager)object)._deviceConfigManager;
                if (object != null) {
                    ((TraeAudioManager$DeviceConfigManager)object).clearConfig();
                }
            }
            catch (Exception exception) {
                int n10 = QLog.isColorLevel();
                if (n10 == 0) break block5;
                n10 = 2;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "uninit failed.";
                stringBuilder.append(string2);
                String string3 = exception.getMessage();
                stringBuilder.append(string3);
                string3 = stringBuilder.toString();
                String string4 = "TRAE";
                QLog.e(string4, n10, string3);
            }
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public void abandonAudioFocus() {
    }

    public int interruptRing() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(" activeMode:");
        int n10 = this.this$0._activeMode;
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" _preRingMode:");
        n10 = this._preRingMode;
        ((StringBuilder)object).append(n10);
        AudioDeviceInterface.LogTraceEntry(((StringBuilder)object).toString());
        object = this.this$0;
        AudioManager audioManager = ((TraeAudioManager)object)._am;
        Object object2 = "TRAE";
        int n11 = -1;
        int n12 = 2;
        if (audioManager == null) {
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = " interruptRing am==null!!";
                QLog.e((String)object2, n12, (String)object);
            }
            return n11;
        }
        int n13 = ((TraeAudioManager)object)._activeMode;
        if (n13 != n12) {
            n13 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n13 != 0) {
                object = " not ACTIVE_RING!!";
                QLog.e((String)object2, n12, (String)object);
            }
            return n11;
        }
        this._ringPlayer.stopRing();
        this.abandonAudioFocus();
        this.this$0._activeMode = 0;
        object = new HashMap();
        object2 = this._ringSessionID;
        ((HashMap)object).put("PARAM_SESSIONID", object2);
        object2 = this._ringOperation;
        ((HashMap)object).put("PARAM_OPERATION", object2);
        object2 = new Intent();
        String string2 = this._ringUserdata;
        object2.putExtra("PARAM_RING_USERDATA_STRING", string2);
        this.this$0.sendResBroadcast((Intent)object2, (HashMap)object, 4);
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public int interruptVoicecallPostprocess() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(" activeMode:");
        int n10 = this.this$0._activeMode;
        ((StringBuilder)object).append(n10);
        AudioDeviceInterface.LogTraceEntry(((StringBuilder)object).toString());
        object = this.this$0;
        AudioManager audioManager = ((TraeAudioManager)object)._am;
        int n11 = 2;
        String string2 = "TRAE";
        int n12 = -1;
        if (audioManager == null) {
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = " am==null!!";
                QLog.e(string2, n11, (String)object);
            }
            return n12;
        }
        n10 = ((TraeAudioManager)object)._activeMode;
        int n13 = 1;
        if (n10 != n13) {
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                object = " not ACTIVE_RING!!";
                QLog.e(string2, n11, (String)object);
            }
            return n12;
        }
        n10 = 0;
        audioManager = null;
        ((TraeAudioManager)object)._activeMode = 0;
        n11 = ((TraeAudioManager)object)._prevMode;
        if (n11 != n12) {
            ((TraeAudioManager)((Object)object)).InternalSetMode(n11);
        }
        object = new HashMap();
        Object object2 = this._voiceCallSessionID;
        ((HashMap)object).put("PARAM_SESSIONID", object2);
        object2 = this._voiceCallOperation;
        ((HashMap)object).put("PARAM_OPERATION", object2);
        object2 = new Intent();
        this.this$0.sendResBroadcast((Intent)object2, (HashMap)object, 6);
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public boolean isNeedForceVolumeType() {
        String string2 = Build.MANUFACTURER;
        String string3 = "Xiaomi";
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            string2 = Build.MODEL;
            string3 = "MI 5";
            boolean bl3 = string2.equals(string3);
            boolean bl4 = true;
            if (bl3) {
                return bl4;
            }
            string3 = "MI 5s";
            bl3 = string2.equals(string3);
            if (bl3) {
                return bl4;
            }
            string3 = "MI 5s Plus";
            bl2 = string2.equals(string3);
            if (bl2) {
                return bl4;
            }
        }
        return false;
    }

    public void notifyRingCompletion() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Long l10 = this._ringSessionID;
        hashMap.put("PARAM_SESSIONID", l10);
        hashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
        l10 = new Intent();
        String string2 = this._ringUserdata;
        l10.putExtra("PARAM_RING_USERDATA_STRING", string2);
        this.this$0.sendResBroadcast((Intent)l10, hashMap, 0);
    }

    public int notifyServiceState(boolean bl2) {
        Context context = this.this$0._context;
        if (context == null) {
            return -1;
        }
        context = new Intent();
        context.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        String string2 = "NOTIFY_SERVICE_STATE";
        context.putExtra("PARAM_OPERATION", string2);
        String string3 = "NOTIFY_SERVICE_STATE_DATE";
        context.putExtra(string3, bl2);
        Context context2 = this.this$0._context;
        if (context2 != null) {
            context2.sendBroadcast((Intent)context);
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void quit() {
        StringBuilder stringBuilder;
        AudioDeviceInterface.LogTraceEntry("");
        Object object = this.mMsgHandler;
        if (object == null) {
            return;
        }
        long l10 = SystemClock.elapsedRealtime();
        this.mMsgHandler.getLooper().quit();
        Object object2 = this._started;
        synchronized (object2) {
            boolean[] blArray = this._started;
            boolean bl2 = false;
            stringBuilder = null;
            bl2 = blArray[0];
            boolean bl3 = true;
            if (bl2 == bl3) {
                long l11 = 10000L;
                try {
                    blArray.wait(l11);
                }
                catch (InterruptedException interruptedException) {}
            }
        }
        boolean bl4 = QLog.isColorLevel();
        if (bl4) {
            object2 = "TRAE";
            int n10 = 2;
            stringBuilder = new StringBuilder();
            String string2 = "  quit used:";
            stringBuilder.append(string2);
            long l12 = SystemClock.elapsedRealtime() - l10;
            stringBuilder.append(l12);
            stringBuilder.append("ms");
            object = stringBuilder.toString();
            QLog.e((String)object2, n10, (String)object);
        }
        this.mMsgHandler = null;
        AudioDeviceInterface.LogTraceExit();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        boolean[] blArray;
        AudioDeviceInterface.LogTraceEntry("");
        Looper.prepare();
        Object object = new TraeAudioManager$TraeAudioManagerLooper$2(this);
        this.mMsgHandler = object;
        this._init();
        object = this._started;
        synchronized (object) {
            boolean bl2;
            blArray = this._started;
            blArray[0] = bl2 = true;
            blArray.notifyAll();
        }
        Looper.loop();
        this._uninit();
        blArray = this._started;
        synchronized (blArray) {
            object = this._started;
            object[0] = (TraeAudioManager$TraeAudioManagerLooper$2)false;
            object.notifyAll();
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public int sendMessage(int n10, HashMap serializable) {
        Object object = this.mMsgHandler;
        int n11 = -1;
        if (object == null) {
            serializable = new StringBuilder();
            object = " fail mMsgHandler==null _enabled:";
            ((StringBuilder)serializable).append((String)object);
            int n12 = this._enabled;
            object = n12 != 0 ? "Y" : "N";
            ((StringBuilder)serializable).append((String)object);
            ((StringBuilder)serializable).append(" activeMode:");
            n12 = this.this$0._activeMode;
            ((StringBuilder)serializable).append(n12);
            ((StringBuilder)serializable).append(" msg:");
            ((StringBuilder)serializable).append(n10);
            AudioDeviceInterface.LogTraceEntry(((StringBuilder)serializable).toString());
            return n11;
        }
        serializable = this.mMsgHandler;
        Message message = Message.obtain((Handler)object, (int)n10, (Object)serializable);
        if ((n10 = (int)(serializable.sendMessage(message) ? 1 : 0)) != 0) {
            n11 = 0;
        }
        return n11;
    }

    public void startService(HashMap object) {
        boolean bl2;
        int n10;
        Object object2;
        Object object3;
        block9: {
            block8: {
                object = (String)((HashMap)object).get("EXTRA_DATA_DEVICECONFIG");
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("startService cfg:");
                ((StringBuilder)object3).append((String)object);
                object3 = ((StringBuilder)object3).toString();
                object2 = "TRAE";
                Log.w((String)object2, (String)object3);
                object3 = new StringBuilder();
                CharSequence charSequence = " _enabled:";
                ((StringBuilder)object3).append((String)charSequence);
                int n11 = this._enabled;
                charSequence = n11 != 0 ? "Y" : "N";
                ((StringBuilder)object3).append((String)charSequence);
                ((StringBuilder)object3).append(" activeMode:");
                n11 = this.this$0._activeMode;
                ((StringBuilder)object3).append(n11);
                charSequence = " cfg:";
                ((StringBuilder)object3).append((String)charSequence);
                ((StringBuilder)object3).append((String)object);
                AudioDeviceInterface.LogTraceEntry(((StringBuilder)object3).toString());
                object3 = this.this$0._context;
                if (object3 == null) {
                    return;
                }
                charSequence = new StringBuilder();
                String string2 = "   startService:";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((String)object);
                charSequence = ((StringBuilder)charSequence).toString();
                QLog.w((String)object2, 2, (String)charSequence);
                n10 = this._enabled;
                if (n10 != 0 && (n10 = (int)(((String)(object3 = this._lastCfg)).equals(object) ? 1 : 0)) != 0) break block8;
                object3 = this.this$0;
                n10 = ((TraeAudioManager)object3)._activeMode;
                if (n10 == 0) break block9;
            }
            return;
        }
        n10 = (int)(this._enabled ? 1 : 0);
        if (n10 != 0) {
            this.stopService();
        }
        this._prev_startService();
        object3 = this.this$0._context;
        object2 = "audio";
        object3 = (AudioManager)object3.getSystemService((String)object2);
        object3 = this.this$0._deviceConfigManager;
        if (object3 != null) {
            ((TraeAudioManager$DeviceConfigManager)object3).clearConfig();
            object3 = this.this$0._deviceConfigManager;
            ((TraeAudioManager$DeviceConfigManager)object3).init((String)object);
        }
        this._lastCfg = object;
        object = this.this$0._am;
        if (object != null) {
            int bl22;
            this._preServiceMode = bl22 = object.getMode();
        }
        this._enabled = bl2 = true;
        object = this._ringPlayer;
        if (object == null) {
            object3 = this.this$0._context;
            object2 = new TraeAudioManager$TraeAudioManagerLooper$1(this);
            this._ringPlayer = object = new TraeMediaPlayer((Context)object3, (TraeMediaPlayer$OnCompletionListener)object2);
        }
        boolean bl3 = this._enabled;
        this.notifyServiceState(bl3);
        this.this$0.updateDeviceStatus();
        AudioDeviceInterface.LogTraceExit();
    }

    public void stopService() {
        block13: {
            String string2;
            Object object = new StringBuilder();
            Object object2 = " _enabled:";
            object.append((String)object2);
            int n10 = this._enabled;
            object2 = n10 != 0 ? "Y" : "N";
            object.append((String)object2);
            object.append(" activeMode:");
            object2 = this.this$0;
            n10 = ((TraeAudioManager)object2)._activeMode;
            object.append(n10);
            object = object.toString();
            AudioDeviceInterface.LogTraceEntry((String)object);
            int n11 = this._enabled;
            if (n11 == 0) {
                return;
            }
            object = this.this$0;
            n11 = ((TraeAudioManager)object)._activeMode;
            n10 = 1;
            int n12 = 2;
            if (n11 == n10) {
                this.interruptVoicecallPostprocess();
            } else if (n11 == n12) {
                this.interruptRing();
            }
            object = this.this$0._switchThread;
            n10 = 0;
            object2 = null;
            String string3 = "TRAE";
            if (object != null) {
                n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n11 != 0) {
                    object = new StringBuilder();
                    object.append("_switchThread:");
                    string2 = this.this$0._switchThread.getDeviceName();
                    object.append(string2);
                    object = object.toString();
                    QLog.w(string3, n12, (String)object);
                }
                this.this$0._switchThread.quit();
                object = this.this$0;
                ((TraeAudioManager)object)._switchThread = null;
            }
            if ((object = this._ringPlayer) != null) {
                ((TraeMediaPlayer)object).stopRing();
            }
            this._ringPlayer = null;
            n11 = 0;
            object = null;
            this._enabled = false;
            this.notifyServiceState(false);
            object2 = this.this$0;
            string2 = ((TraeAudioManager)object2)._am;
            if (string2 != null && (string2 = ((TraeAudioManager)object2)._context) != null) {
                ((TraeAudioManager)((Object)object2)).InternalSetMode(0);
                n11 = (int)(this.isNeedForceVolumeType() ? 1 : 0);
                if (n11 == 0) break block13;
                object = "NeedForceVolumeType: AudioManager.STREAM_MUSIC";
                QLog.w(string3, n12, (String)object);
                object = this.this$0;
                object = ((TraeAudioManager)object)._am;
                n10 = 3;
                try {
                    TraeAudioManager.forceVolumeControlStream((AudioManager)object, n10);
                }
                catch (Exception exception) {
                    n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n10 == 0) break block13;
                    object2 = new StringBuilder();
                    string2 = "set mode failed.";
                    ((StringBuilder)object2).append(string2);
                    String string4 = exception.getMessage();
                    ((StringBuilder)object2).append(string4);
                    string4 = ((StringBuilder)object2).toString();
                    QLog.e(string3, n12, string4);
                }
            }
        }
        this._post_stopService();
        AudioDeviceInterface.LogTraceExit();
    }
}

