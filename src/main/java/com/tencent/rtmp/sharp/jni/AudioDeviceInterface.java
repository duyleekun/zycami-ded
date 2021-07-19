/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningTaskInfo
 *  android.content.Context
 *  android.hardware.SensorManager
 *  android.media.AudioManager
 *  android.media.AudioRecord
 *  android.media.AudioTrack
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecList
 *  android.os.Build
 *  android.os.Build$VERSION
 */
package com.tencent.rtmp.sharp.jni;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.tencent.rtmp.sharp.jni.AudioDecoder;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface$2;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface$3;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface$4;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeAudioCodecList;
import com.tencent.rtmp.sharp.jni.TraeAudioCodecList$CodecInfo;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioSession;
import com.tencent.rtmp.sharp.jni.TraeAudioSession$ITraeAudioCallback;
import com.tencent.rtmp.sharp.jni.VivoKTVHelper;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AudioDeviceInterface {
    private static final FileFilter CPU_FILTER;
    public static final int OUTPUT_MODE_HEADSET = 0;
    public static final int OUTPUT_MODE_SPEAKER = 1;
    private static boolean _dumpEnable = false;
    private static boolean _logEnable = true;
    private static boolean isSupportVivoKTVHelper = false;
    private static String[] mDeviceList;
    private static VivoKTVHelper mVivoKTVHelper;
    private TraeAudioSession _as;
    private TraeAudioSession _asAudioManager;
    private AudioManager _audioManager;
    private AudioRecord _audioRecord;
    private boolean _audioRouteChanged;
    private int _audioSource;
    private int _audioSourcePolicy;
    private int _audioStreamTypePolicy;
    private AudioTrack _audioTrack;
    private int _bufferedPlaySamples;
    private int _bufferedRecSamples;
    private int _channelOutType;
    private String _connectedDev;
    private Context _context;
    private ByteBuffer _decBuffer0;
    private ByteBuffer _decBuffer1;
    private ByteBuffer _decBuffer10;
    private ByteBuffer _decBuffer2;
    private ByteBuffer _decBuffer3;
    private ByteBuffer _decBuffer4;
    private ByteBuffer _decBuffer5;
    private ByteBuffer _decBuffer6;
    private ByteBuffer _decBuffer7;
    private ByteBuffer _decBuffer8;
    private ByteBuffer _decBuffer9;
    private int _deviceStat;
    private boolean _doPlayInit;
    private boolean _doRecInit;
    private boolean _isPlaying;
    private boolean _isRecording;
    private int _modePolicy;
    private ByteBuffer _playBuffer;
    private int _playPosition;
    private int _playSamplerate;
    private File _play_dump;
    private FileOutputStream _play_out;
    private boolean _preDone;
    private Condition _precon;
    private ReentrantLock _prelock;
    private ByteBuffer _recBuffer;
    private File _rec_dump;
    private FileOutputStream _rec_out;
    private int _sceneMode;
    private int _sessionId;
    private int _streamType;
    private byte[] _tempBufPlay;
    private byte[] _tempBufRec;
    private TraeAudioCodecList _traeAudioCodecList;
    private int nPlayLengthMs;
    private int nRecordLengthMs;
    private int switchState;
    private boolean usingJava;

    static {
        AudioDeviceInterface$4 audioDeviceInterface$4 = new AudioDeviceInterface$4();
        CPU_FILTER = audioDeviceInterface$4;
    }

    public AudioDeviceInterface() {
        Object object;
        int n10;
        int n11;
        Object object2;
        int n12;
        Object object3;
        String string2;
        block20: {
            string2 = "TRAE";
            object3 = null;
            this._audioTrack = null;
            this._audioRecord = null;
            this._streamType = 0;
            this._playSamplerate = 8000;
            this._channelOutType = 4;
            this._audioSource = 0;
            this._deviceStat = 0;
            this._sceneMode = 0;
            this._sessionId = 0;
            this._context = null;
            this._modePolicy = n12 = -1;
            this._audioSourcePolicy = n12;
            this._audioStreamTypePolicy = n12;
            this._audioManager = null;
            n12 = 1;
            this._doPlayInit = n12;
            this._doRecInit = n12;
            this._isRecording = false;
            this._isPlaying = false;
            this._bufferedRecSamples = 0;
            this._bufferedPlaySamples = 0;
            this._playPosition = 0;
            this._rec_dump = null;
            this._play_dump = null;
            this._rec_out = null;
            this._play_out = null;
            this.nRecordLengthMs = 0;
            this.nPlayLengthMs = 0;
            this._traeAudioCodecList = null;
            this._as = null;
            this._connectedDev = "DEVICE_NONE";
            this._audioRouteChanged = false;
            object2 = new ReentrantLock();
            this._prelock = object2;
            this._precon = object2 = ((ReentrantLock)object2).newCondition();
            this._preDone = false;
            this.usingJava = n12;
            this.switchState = 0;
            this._asAudioManager = null;
            n11 = 1920;
            n10 = 2;
            object = ByteBuffer.allocateDirect(n11);
            this._playBuffer = object;
            object = ByteBuffer.allocateDirect(n11);
            this._recBuffer = object;
            n12 = 3840;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer0 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer1 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer2 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer3 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer4 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer5 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer6 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer7 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer8 = object2;
            object2 = ByteBuffer.allocateDirect(n12);
            this._decBuffer9 = object2;
            object = ByteBuffer.allocateDirect(n12);
            try {
                this._decBuffer10 = object;
            }
            catch (Exception exception) {
                boolean bl2 = QLog.isColorLevel();
                if (!bl2) break block20;
                object = exception.getMessage();
                QLog.w(string2, n10, (String)object);
            }
        }
        object = new byte[n11];
        this._tempBufPlay = (byte[])object;
        object3 = new byte[n11];
        this._tempBufRec = object3;
        object3 = new TraeAudioCodecList;
        this._traeAudioCodecList = object3;
        n11 = Build.VERSION.SDK_INT;
        n12 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n12 != 0) {
            object = new StringBuilder();
            object2 = "AudioDeviceInterface apiLevel:";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            QLog.w(string2, n10, (String)object);
        }
        if ((n12 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            object = new StringBuilder();
            object2 = " SDK_INT:";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            QLog.w(string2, n10, (String)object);
        }
        if ((n11 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            object3 = new StringBuilder;
            super();
            ((StringBuilder)object3).append("manufacture:");
            object = Build.MANUFACTURER;
            ((StringBuilder)object3).append((String)object);
            object3 = ((StringBuilder)object3).toString();
            QLog.w(string2, n10, (String)object3);
        }
        if ((n11 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            object3 = new StringBuilder;
            super();
            ((StringBuilder)object3).append("MODEL:");
            object = Build.MODEL;
            ((StringBuilder)object3).append((String)object);
            object3 = ((StringBuilder)object3).toString();
            QLog.w(string2, n10, (String)object3);
        }
    }

    private int CloseMp3File(int n10) {
        TraeAudioCodecList traeAudioCodecList = this._traeAudioCodecList;
        long l10 = n10;
        TraeAudioCodecList$CodecInfo traeAudioCodecList$CodecInfo = traeAudioCodecList.find(l10);
        if (traeAudioCodecList$CodecInfo != null) {
            traeAudioCodecList$CodecInfo.audioDecoder.release();
            traeAudioCodecList$CodecInfo.audioDecoder = null;
            this._traeAudioCodecList.remove(l10);
            return 0;
        }
        return -1;
    }

    private int EnableVivoKTVLoopback(int n10) {
        boolean bl2;
        VivoKTVHelper vivoKTVHelper;
        int n11 = QLog.isColorLevel();
        if (n11 != 0) {
            n11 = 2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("EnableVivoKTVLoopback: ");
            charSequence.append(n10);
            charSequence.append(" isSupportVivoKTVHelper:");
            boolean bl3 = isSupportVivoKTVHelper;
            charSequence.append(bl3);
            charSequence.append(" mVivoKTVHelper:");
            Object object = mVivoKTVHelper;
            charSequence.append(object);
            charSequence = charSequence.toString();
            object = "TRAE";
            QLog.w((String)object, n11, (String)charSequence);
        }
        if ((vivoKTVHelper = mVivoKTVHelper) != null && (bl2 = isSupportVivoKTVHelper)) {
            vivoKTVHelper.setPlayFeedbackParam(n10);
            return 0;
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int InitPlayback(int n10, int n11) {
        CharSequence charSequence;
        Object object;
        AudioDeviceInterface audioDeviceInterface = this;
        int n12 = n10;
        int n13 = n11;
        int n14 = QLog.isColorLevel();
        String string2 = "TRAE";
        int n15 = 2;
        if (n14 != 0) {
            object = new StringBuilder();
            charSequence = "InitPlayback entry: sampleRate ";
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            QLog.w(string2, n15, (String)object);
        }
        n14 = audioDeviceInterface._isPlaying;
        int n16 = -1;
        if (n14 == 0 && (object = audioDeviceInterface._audioTrack) == null && n13 <= n15) {
            Object object2;
            Object object3;
            String string3;
            int n17;
            int[] nArray;
            String string4;
            object = audioDeviceInterface._audioManager;
            if (object == null) {
                try {
                    object = audioDeviceInterface._context;
                    String string5 = "audio";
                    object = object.getSystemService(string5);
                    object = (AudioManager)object;
                    audioDeviceInterface._audioManager = object;
                }
                catch (Exception exception) {
                    n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n12 != 0) {
                        String string6 = exception.getMessage();
                        QLog.w(string2, n15, string6);
                    }
                    return n16;
                }
            }
            n14 = 12;
            int n18 = 4;
            audioDeviceInterface._channelOutType = n13 == n15 ? n14 : n18;
            audioDeviceInterface._playSamplerate = n12;
            int n19 = audioDeviceInterface._channelOutType;
            n19 = AudioTrack.getMinBufferSize((int)n12, (int)n19, (int)n15);
            int n20 = audioDeviceInterface._channelOutType;
            if (n20 == n14) {
                String string7;
                n20 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n20 != 0) {
                    string7 = "InitPlayback, _channelOutType stero";
                    QLog.w(string2, n15, string7);
                } else {
                    n20 = audioDeviceInterface._channelOutType;
                    if (n20 == n18 && (n20 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                        string7 = "InitPlayback, _channelOutType Mono";
                        QLog.w(string2, n15, string7);
                    }
                }
            }
            n20 = n12 * 20;
            int n21 = 1;
            n20 = n20 * n21 * n15 / 1000;
            int n22 = audioDeviceInterface._channelOutType;
            if (n22 == n14) {
                n20 *= 2;
            }
            if ((n14 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("InitPlayback: minPlayBufSize:");
                ((StringBuilder)object).append(n19);
                string4 = " 20msFz:";
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(n20);
                object = ((StringBuilder)object).toString();
                QLog.w(string2, n15, (String)object);
            }
            n22 = 0;
            string4 = null;
            audioDeviceInterface._bufferedPlaySamples = 0;
            object = audioDeviceInterface._audioTrack;
            int n23 = 0;
            if (object != null) {
                object.release();
                audioDeviceInterface._audioTrack = null;
            }
            int[] nArray2 = nArray = new int[n18];
            int[] nArray3 = nArray;
            nArray2[0] = 0;
            nArray3[1] = 0;
            nArray2[2] = 3;
            nArray3[3] = 1;
            audioDeviceInterface._streamType = n14 = TraeAudioManager.getAudioStreamType(audioDeviceInterface._audioStreamTypePolicy);
            n14 = (int)(audioDeviceInterface._audioRouteChanged ? 1 : 0);
            if (n14 != 0) {
                n14 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n14 != 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("_audioRouteChanged:");
                    n17 = audioDeviceInterface._audioRouteChanged;
                    ((StringBuilder)object).append(n17 != 0);
                    string3 = " _streamType:";
                    ((StringBuilder)object).append(string3);
                    n17 = audioDeviceInterface._streamType;
                    ((StringBuilder)object).append(n17);
                    object = ((StringBuilder)object).toString();
                    QLog.w(string2, n15, (String)object);
                }
                audioDeviceInterface._streamType = (n14 = (object = audioDeviceInterface._audioManager).getMode()) == 0 && (n14 = (int)(((String)(object = audioDeviceInterface._connectedDev)).equals(string3 = "DEVICE_SPEAKERPHONE") ? 1 : 0)) != 0 ? (n14 = 3) : 0;
                audioDeviceInterface._audioRouteChanged = false;
            }
            nArray[0] = n14 = audioDeviceInterface._streamType;
            n14 = n19;
            string3 = null;
            for (n17 = 0; n17 < n18 && (object3 = audioDeviceInterface._audioTrack) == null; ++n17) {
                block34: {
                    int n24;
                    audioDeviceInterface._streamType = n24 = nArray[n17];
                    n24 = (int)(QLog.isColorLevel() ? 1 : 0);
                    if (n24 != 0) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("InitPlayback: min play buf size is ");
                        ((StringBuilder)object3).append(n19);
                        ((StringBuilder)object3).append(" hw_sr:");
                        n22 = AudioTrack.getNativeOutputSampleRate((int)audioDeviceInterface._streamType);
                        ((StringBuilder)object3).append(n22);
                        string4 = ((StringBuilder)object3).toString();
                        QLog.w(string2, n15, string4);
                    }
                    for (n22 = n21; n22 <= n15; ++n22) {
                        block33: {
                            n24 = n19 * n22;
                            n14 = n20 * 4;
                            if (n24 < n14 && n22 < n15) {
                                n16 = 0;
                                charSequence = null;
                            } else {
                                n14 = n24 * 500;
                                int n25 = n12 * n13;
                                try {
                                    audioDeviceInterface.nPlayLengthMs = n14 /= n25;
                                    n18 = audioDeviceInterface._streamType;
                                    n16 = audioDeviceInterface._playSamplerate;
                                    n23 = audioDeviceInterface._channelOutType;
                                    int n26 = 2;
                                    int n27 = 1;
                                    object = new AudioTrack(n18, n16, n23, n26, n24, n27);
                                    audioDeviceInterface._audioTrack = object;
                                }
                                catch (Exception exception) {
                                    n16 = (int)(QLog.isColorLevel() ? 1 : 0);
                                    if (n16 != 0) {
                                        charSequence = new StringBuilder();
                                        object = exception.getMessage();
                                        ((StringBuilder)charSequence).append((String)object);
                                        ((StringBuilder)charSequence).append(" _audioTrack:");
                                        object = audioDeviceInterface._audioTrack;
                                        ((StringBuilder)charSequence).append(object);
                                        object = ((StringBuilder)charSequence).toString();
                                        QLog.w(string2, n15, (String)object);
                                    }
                                    if ((object = audioDeviceInterface._audioTrack) != null) {
                                        object.release();
                                    }
                                    n16 = 0;
                                    charSequence = null;
                                    audioDeviceInterface._audioTrack = null;
                                    break block33;
                                }
                                n14 = object.getState();
                                if (n14 == n21) {
                                    n14 = n24;
                                    n16 = 0;
                                    charSequence = null;
                                    break block34;
                                }
                                n14 = (int)(QLog.isColorLevel() ? 1 : 0);
                                if (n14 != 0) {
                                    object = new StringBuilder();
                                    ((StringBuilder)object).append("InitPlayback: play not initialized playBufSize:");
                                    ((StringBuilder)object).append(n24);
                                    charSequence = " sr:";
                                    ((StringBuilder)object).append((String)charSequence);
                                    n16 = audioDeviceInterface._playSamplerate;
                                    ((StringBuilder)object).append(n16);
                                    object = ((StringBuilder)object).toString();
                                    QLog.w(string2, n15, (String)object);
                                }
                                object = audioDeviceInterface._audioTrack;
                                object.release();
                                n16 = 0;
                                charSequence = null;
                                audioDeviceInterface._audioTrack = null;
                            }
                        }
                        n23 = 0;
                        n14 = n24;
                        n16 = -1;
                        n18 = 4;
                    }
                    n16 = 0;
                    charSequence = null;
                }
                n23 = 0;
                n16 = -1;
                n18 = 4;
                n22 = 0;
                string4 = null;
            }
            Object object4 = audioDeviceInterface._audioTrack;
            if (object4 == null) {
                n14 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n14 != 0) {
                    object = "InitPlayback fail!!!";
                    QLog.w(string2, n15, (String)object);
                }
                return -1;
            }
            object4 = audioDeviceInterface._as;
            if (object4 != null && (object2 = audioDeviceInterface._audioManager) != null) {
                n13 = object2.getMode();
                n16 = audioDeviceInterface._streamType;
                object4.voiceCallAudioParamChanged(n13, n16);
            }
            object4 = audioDeviceInterface._audioTrack;
            audioDeviceInterface._playPosition = n12 = object4.getPlaybackHeadPosition();
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n12 != 0) {
                object4 = new StringBuilder();
                object4.append("InitPlayback exit: streamType:");
                n13 = audioDeviceInterface._streamType;
                object4.append(n13);
                object4.append(" samplerate:");
                n13 = audioDeviceInterface._playSamplerate;
                object4.append(n13);
                object4.append(" _playPosition:");
                n13 = audioDeviceInterface._playPosition;
                object4.append(n13);
                object2 = " playBufSize:";
                object4.append((String)object2);
                object4.append(n14);
                object4.append(" nPlayLengthMs:");
                n14 = audioDeviceInterface.nPlayLengthMs;
                object4.append(n14);
                object = object4.toString();
                QLog.w(string2, n15, (String)object);
            }
            object = audioDeviceInterface._audioManager;
            object4 = audioDeviceInterface._connectedDev;
            object2 = "DEVICE_BLUETOOTHHEADSET";
            n12 = (int)(object4.equals(object2) ? 1 : 0);
            if (n12 != 0) {
                n12 = 6;
            } else {
                object4 = audioDeviceInterface._audioTrack;
                n12 = object4.getStreamType();
            }
            TraeAudioManager.forceVolumeControlStream((AudioManager)object, n12);
            return 0;
        }
        n14 = QLog.isColorLevel();
        if (n14 != 0) {
            object = new StringBuilder();
            String string8 = "InitPlayback _isPlaying:";
            ((StringBuilder)object).append(string8);
            n12 = (int)(audioDeviceInterface._isPlaying ? 1 : 0);
            ((StringBuilder)object).append(n12 != 0);
            object = ((StringBuilder)object).toString();
            QLog.e(string2, n15, (String)object);
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int InitRecording(int n10, int n11) {
        CharSequence charSequence;
        CharSequence charSequence2;
        String string2;
        int n12;
        AudioDeviceInterface audioDeviceInterface;
        block28: {
            Object object;
            int n13;
            audioDeviceInterface = this;
            int n14 = n10;
            int n15 = n11;
            n12 = QLog.isColorLevel();
            string2 = "TRAE";
            int n16 = 2;
            float f10 = 2.8E-45f;
            if (n12 != 0) {
                charSequence2 = new StringBuilder();
                charSequence = "InitRecording entry:";
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(n10);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                QLog.w(string2, n16, (String)charSequence2);
            }
            if ((n12 = audioDeviceInterface._isRecording) != 0 || (charSequence2 = audioDeviceInterface._audioRecord) != null || n15 > n16) break block28;
            n12 = 16;
            float f11 = 2.24E-44f;
            if (n15 == n16) {
                n12 = 12;
                f11 = 1.7E-44f;
            }
            int n17 = n12;
            float f12 = f11;
            int n18 = AudioRecord.getMinBufferSize((int)n14, (int)n12, (int)n16);
            int n19 = n14 * 20 * n15 * n16 / 1000;
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            String string3 = " sr:";
            if (n12 != 0) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append("InitRecording: min rec buf size is ");
                ((StringBuilder)charSequence2).append(n18);
                ((StringBuilder)charSequence2).append(string3);
                n13 = this.getLowlatencySamplerate();
                ((StringBuilder)charSequence2).append(n13);
                ((StringBuilder)charSequence2).append(" fp");
                n13 = this.getLowlatencyFramesPerBuffer();
                ((StringBuilder)charSequence2).append(n13);
                charSequence = " 20msFZ:";
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(n19);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                QLog.w(string2, n16, (String)charSequence2);
            }
            audioDeviceInterface._bufferedRecSamples = n12 = n14 * 5 / 200;
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n12 != 0) {
                charSequence2 = new StringBuilder();
                charSequence = "  rough rec delay set to ";
                ((StringBuilder)charSequence2).append((String)charSequence);
                n13 = audioDeviceInterface._bufferedRecSamples;
                ((StringBuilder)charSequence2).append(n13);
                charSequence2 = ((StringBuilder)charSequence2).toString();
                QLog.w(string2, n16, (String)charSequence2);
            }
            charSequence2 = audioDeviceInterface._audioRecord;
            int n20 = 0;
            if (charSequence2 != null) {
                charSequence2.release();
                audioDeviceInterface._audioRecord = null;
            }
            int n21 = 4;
            float f13 = 5.6E-45f;
            int[] nArray = object = new int[n21];
            int[] nArray2 = object;
            nArray[0] = 0;
            nArray2[1] = 1;
            nArray[2] = 5;
            nArray2[3] = 0;
            n12 = TraeAudioManager.getAudioSource(audioDeviceInterface._audioSourcePolicy);
            n13 = 0;
            float f14 = 0.0f;
            charSequence = null;
            object[0] = n12;
            int n22 = 0;
            String string4 = null;
            n12 = n18;
            while (n22 < n21 && (charSequence = audioDeviceInterface._audioRecord) == null) {
                float f15;
                int n23;
                int[] nArray3;
                int n24;
                block27: {
                    int n25;
                    audioDeviceInterface._audioSource = n13 = object[n22];
                    n13 = 1;
                    f14 = Float.MIN_VALUE;
                    for (int i10 = n13; i10 <= n16; ++i10) {
                        block30: {
                            block26: {
                                block25: {
                                    String string5;
                                    int n26;
                                    int n27;
                                    block29: {
                                        n20 = n18 * i10;
                                        n12 = n19 * 4;
                                        if (n20 >= n12 || i10 >= n16) break block29;
                                        n16 = n13;
                                        f10 = f14;
                                        n24 = n22;
                                        nArray3 = object;
                                        n23 = n21;
                                        f15 = f13;
                                        n13 = n20;
                                        string4 = string3;
                                        n25 = 0;
                                        object = null;
                                        break block30;
                                    }
                                    n12 = n20 * 500;
                                    n23 = n14 * n15;
                                    try {
                                        audioDeviceInterface.nRecordLengthMs = n12 /= n23;
                                    }
                                    catch (Exception exception) {
                                        n16 = n13;
                                        f10 = f14;
                                        n24 = n22;
                                        nArray3 = object;
                                        n23 = n21;
                                        f15 = f13;
                                        n13 = n20;
                                        string4 = string3;
                                        break block25;
                                    }
                                    try {
                                        n21 = audioDeviceInterface._audioSource;
                                        n27 = 2;
                                        n16 = n13;
                                        f10 = f14;
                                        charSequence = charSequence2;
                                        n24 = n22;
                                        n22 = n21;
                                        nArray3 = object;
                                        n25 = n10;
                                        n23 = 4;
                                        f15 = 5.6E-45f;
                                        n21 = n17;
                                        f13 = f12;
                                        n26 = n20;
                                        n20 = n27;
                                        string5 = string3;
                                    }
                                    catch (Exception exception) {
                                        n16 = n13;
                                        f10 = f14;
                                        n24 = n22;
                                        nArray3 = object;
                                        n13 = n20;
                                        string4 = string3;
                                        n25 = 0;
                                        object = null;
                                        n23 = 4;
                                        f15 = 5.6E-45f;
                                        break block26;
                                    }
                                    try {
                                        charSequence2 = new AudioRecord(n22, n10, n17, n27, n26);
                                        audioDeviceInterface._audioRecord = charSequence2;
                                    }
                                    catch (Exception exception) {
                                        n13 = n26;
                                        string4 = string5;
                                        break block25;
                                    }
                                    n12 = charSequence2.getState();
                                    if (n12 != n13) {
                                        n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                                        if (n12 != 0) {
                                            charSequence2 = new StringBuilder();
                                            charSequence = "InitRecording:  rec not initialized,try agine,  minbufsize:";
                                            ((StringBuilder)charSequence2).append((String)charSequence);
                                            n13 = n26;
                                            ((StringBuilder)charSequence2).append(n26);
                                            string4 = string3;
                                            ((StringBuilder)charSequence2).append(string3);
                                            ((StringBuilder)charSequence2).append(n14);
                                            object = " as:";
                                            ((StringBuilder)charSequence2).append((String)object);
                                            n25 = audioDeviceInterface._audioSource;
                                            ((StringBuilder)charSequence2).append(n25);
                                            charSequence2 = ((StringBuilder)charSequence2).toString();
                                            n25 = 2;
                                            QLog.w(string2, n25, (String)charSequence2);
                                        } else {
                                            n13 = n26;
                                            string4 = string3;
                                        }
                                        charSequence2 = audioDeviceInterface._audioRecord;
                                        charSequence2.release();
                                        n25 = 0;
                                        object = null;
                                        audioDeviceInterface._audioRecord = null;
                                        break block30;
                                    } else {
                                        n13 = n26;
                                        string4 = string3;
                                        n25 = 0;
                                        object = null;
                                        n12 = n26;
                                        break block27;
                                    }
                                }
                                n25 = 0;
                                object = null;
                            }
                            n21 = (int)(QLog.isColorLevel() ? 1 : 0);
                            if (n21 != 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                charSequence2 = ((Throwable)((Object)charSequence2)).getMessage();
                                stringBuilder.append((String)charSequence2);
                                stringBuilder.append(" _audioRecord:");
                                charSequence2 = audioDeviceInterface._audioRecord;
                                stringBuilder.append((Object)charSequence2);
                                charSequence2 = stringBuilder.toString();
                                n21 = 2;
                                f13 = 2.8E-45f;
                                QLog.w(string2, n21, (String)charSequence2);
                            }
                            if ((charSequence2 = audioDeviceInterface._audioRecord) != null) {
                                charSequence2.release();
                            }
                            audioDeviceInterface._audioRecord = null;
                        }
                        n12 = n13;
                        string3 = string4;
                        n20 = 0;
                        n13 = n16;
                        f14 = f10;
                        n21 = n23;
                        f13 = f15;
                        n22 = n24;
                        object = nArray3;
                        n16 = 2;
                        f10 = 2.8E-45f;
                    }
                    n24 = n22;
                    nArray3 = object;
                    n23 = n21;
                    f15 = f13;
                    n25 = 0;
                    object = null;
                    string4 = string3;
                }
                n13 = n24 + 1;
                string3 = string4;
                n20 = 0;
                n21 = n23;
                f13 = f15;
                object = nArray3;
                n16 = 2;
                f10 = 2.8E-45f;
                n22 = n13;
            }
            charSequence = audioDeviceInterface._audioRecord;
            if (charSequence == null) {
                n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n12 != 0) {
                    charSequence2 = "InitRecording fail!!!";
                    n13 = 2;
                    f14 = 2.8E-45f;
                    QLog.w(string2, n13, (String)charSequence2);
                }
                return -1;
            }
            n13 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n13 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(" [Config] InitRecording: audioSession:");
                n22 = audioDeviceInterface._sessionId;
                ((StringBuilder)charSequence).append(n22);
                ((StringBuilder)charSequence).append(" audioSource:");
                n22 = audioDeviceInterface._audioSource;
                ((StringBuilder)charSequence).append(n22);
                ((StringBuilder)charSequence).append(" rec sample rate set to ");
                ((StringBuilder)charSequence).append(n14);
                string4 = " recBufSize:";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(n12);
                ((StringBuilder)charSequence).append(" nRecordLengthMs:");
                n12 = audioDeviceInterface.nRecordLengthMs;
                ((StringBuilder)charSequence).append(n12);
                charSequence2 = ((StringBuilder)charSequence).toString();
                n13 = 2;
                f14 = 2.8E-45f;
                QLog.w(string2, n13, (String)charSequence2);
            } else {
                n13 = 2;
                f14 = 2.8E-45f;
            }
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n12 != 0) {
                charSequence2 = "InitRecording exit";
                QLog.w(string2, n13, (String)charSequence2);
            }
            return audioDeviceInterface._bufferedRecSamples;
        }
        n12 = QLog.isColorLevel();
        if (n12 != 0) {
            charSequence2 = new StringBuilder();
            charSequence = "InitRecording _isRecording:";
            ((StringBuilder)charSequence2).append((String)charSequence);
            int n28 = audioDeviceInterface._isRecording;
            ((StringBuilder)charSequence2).append(n28 != 0);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            n28 = 2;
            float f16 = 2.8E-45f;
            QLog.e(string2, n28, (String)charSequence2);
        }
        return -1;
    }

    private int InitSetting(int n10, int n11, int n12, int n13, int n14) {
        int n15;
        this._audioSourcePolicy = n10;
        this._audioStreamTypePolicy = n11;
        this._modePolicy = n12;
        this._deviceStat = n13;
        this._sceneMode = n14;
        n10 = 2;
        n11 = 0;
        n12 = 1;
        TraeAudioManager.IsMusicScene = n13 != n12 && n13 != (n15 = 5) && n13 != n10 && n13 != (n15 = 3) ? 0 : n12;
        TraeAudioManager.IsEarPhoneSupported = n14 != 0 && n14 != (n15 = 4) ? 0 : n12;
        TraeAudioManager.IsUpdateSceneFlag = n12;
        n12 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n12 != 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("InitSetting: _audioSourcePolicy:");
            n14 = this._audioSourcePolicy;
            charSequence.append(n14);
            charSequence.append(" _audioStreamTypePolicy:");
            n14 = this._audioStreamTypePolicy;
            charSequence.append(n14);
            charSequence.append(" _modePolicy:");
            n14 = this._modePolicy;
            charSequence.append(n14);
            String string2 = " DeviceStat:";
            charSequence.append(string2);
            charSequence.append(n13);
            charSequence.append(" isSupportVivoKTVHelper:");
            n13 = (int)(isSupportVivoKTVHelper ? 1 : 0);
            charSequence.append(n13 != 0);
            charSequence = charSequence.toString();
            String string3 = "TRAE";
            QLog.w(string3, n10, (String)charSequence);
        }
        return 0;
    }

    public static final void LogTraceEntry(String string2) {
        int n10 = _logEnable;
        if (n10 == 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = AudioDeviceInterface.getTraceInfo();
        stringBuilder.append(string3);
        string3 = " entry:";
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        n10 = QLog.isColorLevel();
        if (n10 != 0) {
            n10 = 2;
            string3 = "TRAE";
            QLog.w(string3, n10, string2);
        }
    }

    public static final void LogTraceExit() {
        boolean bl2 = _logEnable;
        if (!bl2) {
            return;
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = AudioDeviceInterface.getTraceInfo();
        charSequence.append(string2);
        string2 = " exit";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        int n10 = QLog.isColorLevel();
        if (n10 != 0) {
            n10 = 2;
            String string3 = "TRAE";
            QLog.w(string3, n10, (String)charSequence);
        }
    }

    private int OpenMp3File(String object, int n10, int n11) {
        Object object2 = this._traeAudioCodecList;
        long l10 = n10;
        if ((object2 = ((TraeAudioCodecList)object2).find(l10)) == null) {
            object2 = this._traeAudioCodecList.add(l10);
            Object object3 = ((TraeAudioCodecList$CodecInfo)object2).audioDecoder;
            ((AudioDecoder)object3).setIOPath((String)object);
            ((TraeAudioCodecList$CodecInfo)object2).audioDecoder.setIndex(n10);
            object = ((TraeAudioCodecList$CodecInfo)object2).audioDecoder;
            int n12 = ((AudioDecoder)object).prepare(n11);
            if (n12 != 0) {
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 != 0) {
                    n10 = 2;
                    String string2 = "TRAE";
                    object3 = "openFile mp3 Failed!!!";
                    QLog.w(string2, n10, (String)object3);
                }
                ((TraeAudioCodecList$CodecInfo)object2).audioDecoder.release();
                ((TraeAudioCodecList$CodecInfo)object2).audioDecoder = null;
                this._traeAudioCodecList.remove(l10);
                return n12;
            }
            return 0;
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int OpenslesNeedResetAudioTrack(boolean bl2) {
        try {
            String string2;
            String string3;
            Object object;
            int n10 = this._modePolicy;
            n10 = (int)(TraeAudioManager.isCloseSystemAPM(n10) ? 1 : 0);
            if (n10 == 0) {
                return -1;
            }
            n10 = (int)(this._audioRouteChanged ? 1 : 0);
            if (n10 == 0) {
                if (!bl2) return this._audioStreamTypePolicy;
            }
            if ((object = this._audioManager) == null && (object = this._context) != null) {
                string3 = "audio";
                object = object.getSystemService(string3);
                this._audioManager = object;
            }
            object = this._audioManager;
            n10 = 0;
            string3 = null;
            if (object == null) {
                return 0;
            }
            bl2 = object.getMode();
            if (!bl2 && (bl2 = ((String)(object = this._connectedDev)).equals(string2 = "DEVICE_SPEAKERPHONE"))) {
                bl2 = 3;
                this._audioStreamTypePolicy = (int)(bl2 ? 1 : 0);
            } else {
                this._audioStreamTypePolicy = 0;
            }
            this._audioRouteChanged = false;
            return this._audioStreamTypePolicy;
        }
        catch (Exception exception) {
            boolean bl3 = QLog.isColorLevel();
            if (!bl3) return this._audioStreamTypePolicy;
            String string4 = "TRAE";
            int n11 = 2;
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "PlayAudio Exception: ";
            stringBuilder.append(string5);
            String string6 = exception.getMessage();
            stringBuilder.append(string6);
            string6 = stringBuilder.toString();
            QLog.e(string4, n11, string6);
            return this._audioStreamTypePolicy;
        }
    }

    /*
     * Exception decompiling
     */
    private int PlayAudio(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [172[CATCHBLOCK]], but top level block is 14[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private int ReadMp3File(int n10) {
        Object object = this._traeAudioCodecList;
        long l10 = n10;
        object = ((TraeAudioCodecList)object).find(l10);
        int n11 = -1;
        if (object != null) {
            ByteBuffer byteBuffer = this.getDecBuffer(n10);
            if (byteBuffer == null) {
                return n11;
            }
            byteBuffer.rewind();
            n11 = ((TraeAudioCodecList$CodecInfo)object).audioDecoder.getFrameSize();
            AudioDecoder audioDecoder = ((TraeAudioCodecList$CodecInfo)object).audioDecoder;
            byte[] byArray = ((TraeAudioCodecList$CodecInfo)object)._tempBufdec;
            int n12 = audioDecoder.ReadOneFrame(byArray, n11);
            object = ((TraeAudioCodecList$CodecInfo)object)._tempBufdec;
            byteBuffer.put((byte[])object, 0, n11);
            return n12;
        }
        return n11;
    }

    /*
     * Exception decompiling
     */
    private int RecordAudio(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 40[TRYBLOCK] [98 : 531->534)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private int SeekMp3To(int n10, int n11) {
        TraeAudioCodecList traeAudioCodecList = this._traeAudioCodecList;
        long l10 = n10;
        TraeAudioCodecList$CodecInfo traeAudioCodecList$CodecInfo = traeAudioCodecList.find(l10);
        if (traeAudioCodecList$CodecInfo != null) {
            return traeAudioCodecList$CodecInfo.audioDecoder.SeekTo(n11);
        }
        return 0;
    }

    private int SetAudioOutputMode(int n10) {
        CharSequence charSequence;
        int n11 = QLog.isColorLevel();
        if (n11 != 0) {
            n11 = 2;
            charSequence = new StringBuilder();
            charSequence.append("TraeAudioSession SetAudioOutputMode: ");
            charSequence.append(n10);
            charSequence = charSequence.toString();
            String string2 = "TRAE";
            QLog.w(string2, n11, (String)charSequence);
        }
        n11 = -1;
        charSequence = null;
        int n12 = 1;
        if (n10 == 0) {
            Object object = mDeviceList;
            if (object != null && (object = this._asAudioManager) != null) {
                n10 = 0;
                object = null;
                block0: do {
                    boolean bl2;
                    String string3;
                    Object object2;
                    int n13;
                    for (n11 = 0; n11 < (n13 = ((String[])(object2 = mDeviceList)).length) && n10 == 0; ++n11) {
                        string3 = "DEVICE_WIREDHEADSET";
                        bl2 = string3.equals(object2 = object2[n11]);
                        if (!bl2) continue;
                        object = this._asAudioManager;
                        ((TraeAudioSession)((Object)object)).connectDevice(string3);
                        n10 = n12;
                        break;
                    }
                    for (n11 = 0; n11 < (n13 = ((String[])(object2 = mDeviceList)).length) && n10 == 0; ++n11) {
                        string3 = "DEVICE_BLUETOOTHHEADSET";
                        bl2 = string3.equals(object2 = object2[n11]);
                        if (!bl2) continue;
                        object = this._asAudioManager;
                        ((TraeAudioSession)((Object)object)).connectDevice(string3);
                        n10 = n12;
                        break;
                    }
                    for (n11 = 0; n11 < (n13 = ((String[])(object2 = mDeviceList)).length) && n10 == 0; ++n11) {
                        string3 = "DEVICE_EARPHONE";
                        bl2 = string3.equals(object2 = object2[n11]);
                        if (!bl2) continue;
                        object = this._asAudioManager;
                        ((TraeAudioSession)((Object)object)).connectDevice(string3);
                        n10 = n12;
                        continue block0;
                    }
                } while (n10 == 0);
                return 0;
            }
            return n11;
        }
        if (n12 == n10) {
            TraeAudioSession traeAudioSession = this._asAudioManager;
            if (traeAudioSession == null) {
                return n11;
            }
            traeAudioSession.connectDevice("DEVICE_SPEAKERPHONE");
            return 0;
        }
        return n11;
    }

    private int SetPlayoutVolume(int n10) {
        Object object;
        AudioManager audioManager = this._audioManager;
        if (audioManager == null && (audioManager = this._context) != null) {
            object = "audio";
            this._audioManager = audioManager = (AudioManager)audioManager.getSystemService((String)object);
        }
        int n11 = -1;
        object = this._audioManager;
        if (object != null) {
            object.setStreamVolume(0, n10, 0);
            n11 = 0;
            audioManager = null;
        }
        return n11;
    }

    private int StartPlayback() {
        Object object;
        String string2;
        int n10;
        boolean bl2;
        block13: {
            Object object2;
            int n11;
            block14: {
                bl2 = this._isPlaying;
                n11 = -1;
                n10 = 2;
                string2 = "TRAE";
                if (bl2) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        String string3 = "StartPlayback _isPlaying";
                        QLog.e(string2, n10, string3);
                    }
                    return n11;
                }
                object = this._audioTrack;
                if (object == null) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("StartPlayback _audioTrack:");
                        AudioTrack audioTrack = this._audioTrack;
                        ((StringBuilder)object).append(audioTrack);
                        object = ((StringBuilder)object).toString();
                        QLog.e(string2, n10, (String)object);
                    }
                    return n11;
                }
                try {
                    object.play();
                    bl2 = _dumpEnable;
                    if (!bl2) break block13;
                    object2 = this._audioManager;
                    if (object2 == null) break block14;
                }
                catch (IllegalStateException illegalStateException) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        object = "StartPlayback fail";
                        QLog.e(string2, n10, (String)object);
                    }
                    return n11;
                }
                n11 = object2.getMode();
            }
            object2 = "jniplay.pcm";
            Object object3 = this.getDumpFilePath((String)object2, n11);
            this._play_dump = object = new File((String)object3);
            object3 = this._play_dump;
            object = new FileOutputStream((File)object3);
            try {
                this._play_out = object;
            }
            catch (FileNotFoundException fileNotFoundException) {
                bl2 = QLog.isColorLevel();
                if (!bl2) break block13;
                object = "open play dump file failed.";
                QLog.e(string2, n10, (String)object);
            }
        }
        this._isPlaying = true;
        bl2 = QLog.isColorLevel();
        if (bl2) {
            object = "StartPlayback ok";
            QLog.w(string2, n10, (String)object);
        }
        return 0;
    }

    private int StartRecording() {
        Object object;
        String string2;
        int n10;
        boolean bl2;
        block14: {
            Object object2;
            int n11;
            block15: {
                bl2 = QLog.isColorLevel();
                n10 = 2;
                string2 = "TRAE";
                if (bl2) {
                    object = "StartRecording entry";
                    QLog.w(string2, n10, (String)object);
                }
                bl2 = this._isRecording;
                n11 = -1;
                if (bl2) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        object = new StringBuilder();
                        String string3 = "StartRecording _isRecording:";
                        ((StringBuilder)object).append(string3);
                        boolean bl3 = this._isRecording;
                        ((StringBuilder)object).append(bl3);
                        object = ((StringBuilder)object).toString();
                        QLog.e(string2, n10, (String)object);
                    }
                    return n11;
                }
                object = this._audioRecord;
                if (object == null) {
                    bl2 = QLog.isColorLevel();
                    if (bl2) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("StartRecording _audioRecord:");
                        AudioRecord audioRecord = this._audioRecord;
                        ((StringBuilder)object).append(audioRecord);
                        object = ((StringBuilder)object).toString();
                        QLog.e(string2, n10, (String)object);
                    }
                    return n11;
                }
                try {
                    object.startRecording();
                    bl2 = _dumpEnable;
                    if (!bl2) break block14;
                    object2 = this._audioManager;
                    if (object2 == null) break block15;
                }
                catch (IllegalStateException illegalStateException) {
                    boolean bl4 = QLog.isColorLevel();
                    if (bl4) {
                        String string4 = "StartRecording fail";
                        QLog.e(string2, n10, string4);
                    }
                    illegalStateException.printStackTrace();
                    return n11;
                }
                n11 = object2.getMode();
            }
            object2 = "jnirecord.pcm";
            Object object3 = this.getDumpFilePath((String)object2, n11);
            this._rec_dump = object = new File((String)object3);
            object3 = this._rec_dump;
            object = new FileOutputStream((File)object3);
            try {
                this._rec_out = object;
            }
            catch (FileNotFoundException fileNotFoundException) {
                bl2 = QLog.isColorLevel();
                if (!bl2) break block14;
                object = "open rec dump file failed.";
                QLog.e(string2, n10, (String)object);
            }
        }
        this._isRecording = true;
        bl2 = QLog.isColorLevel();
        if (bl2) {
            object = "StartRecording ok";
            QLog.w(string2, n10, (String)object);
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int StopPlayback() {
        int n10;
        int n11;
        String string2;
        CharSequence charSequence;
        int n12 = QLog.isColorLevel();
        int n13 = 2;
        String string3 = "TRAE";
        if (n12 != 0) {
            charSequence = new StringBuilder();
            string2 = "StopPlayback entry _isPlaying:";
            ((StringBuilder)charSequence).append(string2);
            n11 = (int)(this._isPlaying ? 1 : 0);
            ((StringBuilder)charSequence).append(n11 != 0);
            charSequence = ((StringBuilder)charSequence).toString();
            QLog.w(string3, n13, (String)charSequence);
        }
        charSequence = this._audioTrack;
        n11 = -1;
        if (charSequence == null) {
            n12 = QLog.isColorLevel();
            if (n12 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("StopPlayback _isPlaying:");
                boolean bl2 = this._isPlaying;
                ((StringBuilder)charSequence).append(bl2);
                ((StringBuilder)charSequence).append(" ");
                AudioTrack audioTrack = this._audioTrack;
                ((StringBuilder)charSequence).append(audioTrack);
                charSequence = ((StringBuilder)charSequence).toString();
                QLog.e(string3, n13, (String)charSequence);
            }
            return n11;
        }
        n12 = charSequence.getPlayState();
        if (n12 == (n10 = 3)) {
            try {
                n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n12 != 0) {
                    charSequence = "StopPlayback stoping...";
                    QLog.w(string3, n13, (String)charSequence);
                }
                charSequence = this._audioTrack;
                charSequence.stop();
            }
            catch (IllegalStateException illegalStateException) {
                n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n12 != 0) {
                    charSequence = "StopPlayback err";
                    QLog.e(string3, n13, (String)charSequence);
                }
                return n11;
            }
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n12 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("StopPlayback flushing... state:");
                string2 = this._audioTrack;
                n11 = string2.getPlayState();
                ((StringBuilder)charSequence).append(n11);
                charSequence = ((StringBuilder)charSequence).toString();
                QLog.w(string3, n13, (String)charSequence);
            }
            charSequence = this._audioTrack;
            charSequence.flush();
        }
        if ((n12 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("StopPlayback releaseing... state:");
            string2 = this._audioTrack;
            n11 = string2.getPlayState();
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
            QLog.w(string3, n13, (String)charSequence);
        }
        this._audioTrack.release();
        this._audioTrack = null;
        n12 = 0;
        charSequence = null;
        this._isPlaying = false;
        n11 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n11 != 0) {
            string2 = "StopPlayback exit ok";
            QLog.w(string3, n13, string2);
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int StopRecording() {
        int n10;
        CharSequence charSequence;
        int n11 = QLog.isColorLevel();
        int n12 = 2;
        String string2 = "TRAE";
        if (n11 != 0) {
            charSequence = "StopRecording entry";
            QLog.w(string2, n12, (String)charSequence);
        }
        charSequence = this._audioRecord;
        int n13 = -1;
        if (charSequence == null) {
            n11 = QLog.isColorLevel();
            if (n11 != 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("UnintRecord:");
                AudioRecord audioRecord = this._audioRecord;
                ((StringBuilder)charSequence).append(audioRecord);
                charSequence = ((StringBuilder)charSequence).toString();
                QLog.e(string2, n12, (String)charSequence);
            }
            return n13;
        }
        n11 = charSequence.getRecordingState();
        if (n11 == (n10 = 3)) {
            try {
                n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n11 != 0) {
                    charSequence = new StringBuilder();
                    String string3 = "StopRecording stop... state:";
                    ((StringBuilder)charSequence).append(string3);
                    string3 = this._audioRecord;
                    n10 = string3.getRecordingState();
                    ((StringBuilder)charSequence).append(n10);
                    charSequence = ((StringBuilder)charSequence).toString();
                    QLog.w(string2, n12, (String)charSequence);
                }
                charSequence = this._audioRecord;
                charSequence.stop();
            }
            catch (IllegalStateException illegalStateException) {
                n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n11 != 0) {
                    charSequence = "StopRecording  err";
                    QLog.e(string2, n12, (String)charSequence);
                }
                return n13;
            }
        }
        if ((n11 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("StopRecording releaseing... state:");
            AudioRecord audioRecord = this._audioRecord;
            n13 = audioRecord.getRecordingState();
            ((StringBuilder)charSequence).append(n13);
            charSequence = ((StringBuilder)charSequence).toString();
            QLog.w(string2, n12, (String)charSequence);
        }
        this._audioRecord.release();
        this._audioRecord = null;
        n11 = 0;
        charSequence = null;
        this._isRecording = false;
        n13 = (int)(QLog.isColorLevel() ? 1 : 0);
        if (n13 != 0) {
            String string4 = "StopRecording exit ok";
            QLog.w(string2, n12, string4);
        }
        return 0;
    }

    public static /* synthetic */ ReentrantLock access$000(AudioDeviceInterface audioDeviceInterface) {
        return audioDeviceInterface._prelock;
    }

    public static /* synthetic */ boolean access$102(AudioDeviceInterface audioDeviceInterface, boolean bl2) {
        audioDeviceInterface._preDone = bl2;
        return bl2;
    }

    public static /* synthetic */ Condition access$200(AudioDeviceInterface audioDeviceInterface) {
        return audioDeviceInterface._precon;
    }

    public static /* synthetic */ String[] access$302(String[] stringArray) {
        mDeviceList = stringArray;
        return stringArray;
    }

    public static /* synthetic */ boolean access$400(AudioDeviceInterface audioDeviceInterface) {
        return audioDeviceInterface.usingJava;
    }

    public static /* synthetic */ void access$500(AudioDeviceInterface audioDeviceInterface, String string2) {
        audioDeviceInterface.onOutputChanage(string2);
    }

    private int getAndroidSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    private int getAudioSessionId(AudioRecord audioRecord) {
        return 0;
    }

    private ByteBuffer getDecBuffer(int n10) {
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getDecBuffer failed!! index:");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                QLog.w("TRAE", 2, string2);
                return null;
            }
            case 10: {
                return this._decBuffer10;
            }
            case 9: {
                return this._decBuffer9;
            }
            case 8: {
                return this._decBuffer8;
            }
            case 7: {
                return this._decBuffer7;
            }
            case 6: {
                return this._decBuffer6;
            }
            case 5: {
                return this._decBuffer5;
            }
            case 4: {
                return this._decBuffer4;
            }
            case 3: {
                return this._decBuffer3;
            }
            case 2: {
                return this._decBuffer2;
            }
            case 1: {
                return this._decBuffer1;
            }
            case 0: 
        }
        return this._decBuffer0;
    }

    private String getDumpFilePath(String string2, int n10) {
        CharSequence charSequence;
        Object object;
        int n11 = QLog.isColorLevel();
        int n12 = 2;
        String string3 = "TRAE";
        if (n11 != 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("manufacture:");
            charSequence = Build.MANUFACTURER;
            ((StringBuilder)object).append((String)charSequence);
            object = ((StringBuilder)object).toString();
            QLog.w(string3, n12, (String)object);
        }
        if ((n11 = QLog.isColorLevel()) != 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("MODEL:");
            charSequence = Build.MODEL;
            ((StringBuilder)object).append((String)charSequence);
            object = ((StringBuilder)object).toString();
            QLog.w(string3, n12, (String)object);
        }
        object = this._context;
        charSequence = null;
        if (object == null) {
            return null;
        }
        if ((object = object.getExternalFilesDir(null)) == null) {
            return null;
        }
        charSequence = new StringBuilder();
        object = ((File)object).getPath();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("/MF-");
        object = Build.MANUFACTURER;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("-M-");
        object = Build.MODEL;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("-as-");
        n11 = TraeAudioManager.getAudioSource(this._audioSourcePolicy);
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append("-st-");
        n11 = this._streamType;
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append("-m-");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append("-");
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        Object object2 = new File(string2);
        object = ((File)object2).getParentFile();
        n11 = (int)(((File)object).exists() ? 1 : 0);
        if (n11 == 0) {
            object2 = ((File)object2).getParentFile();
            ((File)object2).mkdirs();
        }
        if ((n10 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
            object2 = new StringBuilder();
            object = "dump:";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            QLog.w(string3, n12, (String)object2);
        }
        n10 = (int)(QLog.isColorLevel() ? 1 : 0);
        object = "_";
        charSequence = " ";
        if (n10 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("dump replace:");
            String string4 = string2.replace(charSequence, (CharSequence)object);
            ((StringBuilder)object2).append(string4);
            object2 = ((StringBuilder)object2).toString();
            QLog.w(string3, n12, (String)object2);
        }
        return string2.replace(charSequence, (CharSequence)object);
    }

    private int getLowlatencyFramesPerBuffer() {
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        Object object = this._context;
        int n12 = 2;
        String string2 = "TRAE";
        if (object != null && n11 >= (n10 = 9)) {
            object = object.getPackageManager();
            CharSequence charSequence = "android.hardware.audio.low_latency";
            int n13 = object.hasSystemFeature((String)charSequence);
            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n10 != 0) {
                charSequence = new StringBuilder();
                String string3 = "LOW_LATENCY:";
                ((StringBuilder)charSequence).append(string3);
                int n14 = 1;
                object = n13 == n14 ? "Y" : "N";
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                QLog.w(string2, n12, (String)object);
            }
            if (n11 < (n13 = 17) && (n11 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                String string4 = "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE";
                QLog.e(string2, n12, string4);
            }
            return 0;
        }
        boolean bl2 = QLog.isColorLevel();
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getLowlatencySamplerate err, _context:");
            Object object2 = this._context;
            ((StringBuilder)object).append(object2);
            object2 = " api:";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n11);
            String string5 = ((StringBuilder)object).toString();
            QLog.e(string2, n12, string5);
        }
        return 0;
    }

    private int getLowlatencySamplerate() {
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        Object object = this._context;
        int n12 = 2;
        String string2 = "TRAE";
        if (object != null && n11 >= (n10 = 9)) {
            object = object.getPackageManager();
            CharSequence charSequence = "android.hardware.audio.low_latency";
            int n13 = object.hasSystemFeature((String)charSequence);
            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n10 != 0) {
                charSequence = new StringBuilder();
                String string3 = "LOW_LATENCY:";
                ((StringBuilder)charSequence).append(string3);
                int n14 = 1;
                object = n13 == n14 ? "Y" : "N";
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                QLog.w(string2, n12, (String)object);
            }
            if (n11 < (n13 = 17)) {
                n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n11 != 0) {
                    String string4 = "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE";
                    QLog.e(string2, n12, string4);
                }
                return 0;
            }
            n11 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n11 != 0) {
                String string5 = "getLowlatencySamplerate not support right now!";
                QLog.e(string2, n12, string5);
            }
            return 0;
        }
        boolean bl2 = QLog.isColorLevel();
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getLowlatencySamplerate err, _context:");
            Object object2 = this._context;
            ((StringBuilder)object).append(object2);
            object2 = " api:";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n11);
            String string6 = ((StringBuilder)object).toString();
            QLog.e(string2, n12, string6);
        }
        return 0;
    }

    private int getMp3Channels(int n10) {
        TraeAudioCodecList traeAudioCodecList = this._traeAudioCodecList;
        long l10 = n10;
        TraeAudioCodecList$CodecInfo traeAudioCodecList$CodecInfo = traeAudioCodecList.find(l10);
        if (traeAudioCodecList$CodecInfo != null) {
            return traeAudioCodecList$CodecInfo.audioDecoder.getChannels();
        }
        return -1;
    }

    private long getMp3FileTotalMs(int n10) {
        TraeAudioCodecList traeAudioCodecList = this._traeAudioCodecList;
        long l10 = n10;
        TraeAudioCodecList$CodecInfo traeAudioCodecList$CodecInfo = traeAudioCodecList.find(l10);
        if (traeAudioCodecList$CodecInfo != null) {
            return traeAudioCodecList$CodecInfo.audioDecoder.getFileTotalMs();
        }
        return -1;
    }

    private int getMp3SampleRate(int n10) {
        TraeAudioCodecList traeAudioCodecList = this._traeAudioCodecList;
        long l10 = n10;
        TraeAudioCodecList$CodecInfo traeAudioCodecList$CodecInfo = traeAudioCodecList.find(l10);
        if (traeAudioCodecList$CodecInfo != null) {
            return traeAudioCodecList$CodecInfo.audioDecoder.getSampleRate();
        }
        return -1;
    }

    private int getPlayRecordSysBufferMs() {
        int n10 = this.nRecordLengthMs;
        int n11 = this.nPlayLengthMs;
        return (n10 + n11) * 2;
    }

    public static String getTraceInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTraceElementArray = new Throwable();
        stackTraceElementArray = stackTraceElementArray.getStackTrace();
        int n10 = stackTraceElementArray.length;
        stringBuffer.append("");
        n10 = 2;
        String string2 = stackTraceElementArray[n10].getClassName();
        stringBuffer.append(string2);
        stringBuffer.append(".");
        string2 = stackTraceElementArray[n10].getMethodName();
        stringBuffer.append(string2);
        stringBuffer.append(": ");
        int n11 = stackTraceElementArray[n10].getLineNumber();
        stringBuffer.append(n11);
        return stringBuffer.toString();
    }

    private void initTRAEAudioManager() {
        Object object = this._context;
        if (object != null) {
            Object object2;
            String string2;
            TraeAudioManager.init((Context)object);
            int n10 = QLog.isColorLevel();
            if (n10 != 0) {
                n10 = 2;
                string2 = "TRAE";
                object2 = "initTRAEAudioManager , TraeAudioSession create";
                QLog.w(string2, n10, (String)object2);
            }
            if ((object = this._asAudioManager) == null) {
                string2 = this._context;
                object2 = new AudioDeviceInterface$3(this);
                object = new TraeAudioSession((Context)string2, (TraeAudioSession$ITraeAudioCallback)object2);
                this._asAudioManager = object;
            }
            object = this._asAudioManager;
            string2 = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
            ((TraeAudioSession)((Object)object)).startService(string2);
        }
    }

    public static boolean isHardcodeOpenSles() {
        String string2 = Build.MANUFACTURER;
        String string3 = "Xiaomi";
        boolean bl2 = string2.equals(string3);
        boolean bl3 = true;
        if (bl2) {
            string2 = Build.MODEL;
            string3 = "MI 5";
            bl2 = string2.equals(string3);
            if (bl2) {
                return bl3;
            }
            string3 = "MI 5s";
            bl2 = string2.equals(string3);
            if (bl2) {
                return bl3;
            }
            string3 = "MI 5s Plus";
            boolean bl4 = string2.equals(string3);
            if (bl4) {
                return bl3;
            }
        } else {
            string3 = "samsung";
            boolean bl5 = string2.equals(string3);
            if (bl5 && (bl5 = (string2 = Build.MODEL).equals(string3 = "SM-G9350"))) {
                return bl3;
            }
        }
        return false;
    }

    private int isSupportLowLatency() {
        int n10 = AudioDeviceInterface.isHardcodeOpenSles();
        if (n10 != 0) {
            n10 = QLog.isColorLevel();
            if (n10 != 0) {
                n10 = 2;
                CharSequence charSequence = new StringBuilder();
                charSequence.append("hardcode FEATURE_AUDIO_LOW_LATENCY: ");
                String string2 = Build.MANUFACTURER;
                charSequence.append(string2);
                charSequence.append("_");
                string2 = Build.MODEL;
                charSequence.append(string2);
                charSequence = charSequence.toString();
                string2 = "TRAE";
                QLog.w(string2, n10, (String)charSequence);
            }
            return 1;
        }
        return 0;
    }

    private int isSupportVivoKTVHelper() {
        int n10;
        int n11;
        Object object = this._context;
        if (object != null) {
            object = VivoKTVHelper.getInstance((Context)object);
            mVivoKTVHelper = object;
            if (object != null) {
                boolean n112;
                isSupportVivoKTVHelper = n112 = ((VivoKTVHelper)object).isDeviceSupportKaraoke();
            }
        }
        if ((n11 = isSupportVivoKTVHelper) != (n10 = 1)) {
            n10 = 0;
        }
        return n10;
    }

    private int isVivoKTVLoopback() {
        boolean bl2;
        VivoKTVHelper vivoKTVHelper = mVivoKTVHelper;
        if (vivoKTVHelper != null && (bl2 = isSupportVivoKTVHelper)) {
            return vivoKTVHelper.getPlayFeedbackParam();
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void onOutputChanage(String charSequence) {
        int n10;
        block15: {
            int n11;
            Object object;
            int n12 = QLog.isColorLevel();
            CharSequence charSequence2 = " onOutputChanage:";
            String string2 = "TRAE";
            int n13 = 2;
            if (n12 != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)charSequence2);
                ((StringBuilder)object).append((String)charSequence);
                object = ((StringBuilder)object).toString();
                QLog.w(string2, n13, (String)object);
            }
            this.setAudioRouteSwitchState((String)charSequence);
            n12 = TraeAudioManager.isCloseSystemAPM(this._modePolicy);
            if (n12 == 0) {
                return;
            }
            n12 = this._deviceStat;
            n10 = 1;
            if (n12 == n10) return;
            int n14 = 5;
            if (n12 == n14) return;
            if (n12 == n13) return;
            n14 = 3;
            if (n12 == n14) {
                return;
            }
            this._connectedDev = charSequence;
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            String string3 = " mode:";
            if (n12 != 0) {
                int n15;
                AudioManager audioManager;
                object = new StringBuilder();
                ((StringBuilder)object).append((String)charSequence2);
                ((StringBuilder)object).append((String)charSequence);
                charSequence2 = this._audioManager;
                if (charSequence2 == null) {
                    charSequence2 = " am==null";
                } else {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append(string3);
                    audioManager = this._audioManager;
                    n15 = audioManager.getMode();
                    ((StringBuilder)charSequence2).append(n15);
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                }
                ((StringBuilder)object).append((String)charSequence2);
                ((StringBuilder)object).append(" st:");
                n11 = this._streamType;
                ((StringBuilder)object).append(n11);
                charSequence2 = this._audioTrack;
                if (charSequence2 == null) {
                    charSequence2 = "_audioTrack==null";
                } else {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append(" at.st:");
                    audioManager = this._audioTrack;
                    n15 = audioManager.getStreamType();
                    ((StringBuilder)charSequence2).append(n15);
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                }
                ((StringBuilder)object).append((String)charSequence2);
                object = ((StringBuilder)object).toString();
                QLog.w(string2, n13, (String)object);
            }
            try {
                boolean bl2;
                object = this._audioManager;
                if (object == null) {
                    object = this._context;
                    charSequence2 = "audio";
                    object = object.getSystemService((String)charSequence2);
                    object = (AudioManager)object;
                    this._audioManager = object;
                }
                if ((n12 = (int)(QLog.isColorLevel() ? 1 : 0)) != 0) {
                    object = new StringBuilder();
                    charSequence2 = " curr mode:";
                    ((StringBuilder)object).append((String)charSequence2);
                    ((StringBuilder)object).append((String)charSequence);
                    charSequence = this._audioManager;
                    if (charSequence == null) {
                        charSequence = "am==null";
                    } else {
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append(string3);
                        charSequence2 = this._audioManager;
                        n11 = charSequence2.getMode();
                        ((StringBuilder)charSequence).append(n11);
                        charSequence = ((StringBuilder)charSequence).toString();
                    }
                    ((StringBuilder)object).append((String)charSequence);
                    charSequence = ((StringBuilder)object).toString();
                    QLog.w(string2, n13, (String)charSequence);
                }
                if ((charSequence = this._audioManager) != null && (bl2 = ((String)(charSequence = this._connectedDev)).equals(object = "DEVICE_SPEAKERPHONE"))) {
                    charSequence = this._audioManager;
                    n12 = 0;
                    object = null;
                    charSequence.setMode(0);
                }
            }
            catch (Exception exception) {
                n12 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n12 == 0) break block15;
                String string4 = exception.getMessage();
                QLog.w(string2, n13, string4);
            }
        }
        this._audioRouteChanged = n10;
    }

    private void setAudioRouteSwitchState(String string2) {
        String string3 = "DEVICE_EARPHONE";
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            int n10;
            this.switchState = n10 = 1;
        } else {
            string3 = "DEVICE_SPEAKERPHONE";
            bl2 = string2.equals(string3);
            if (bl2) {
                int n11;
                this.switchState = n11 = 2;
            } else {
                string3 = "DEVICE_WIREDHEADSET";
                bl2 = string2.equals(string3);
                if (bl2) {
                    int n12;
                    this.switchState = n12 = 3;
                } else {
                    string3 = "DEVICE_BLUETOOTHHEADSET";
                    int n13 = string2.equals(string3);
                    if (n13 != 0) {
                        this.switchState = n13 = 4;
                    } else {
                        n13 = 0;
                        string2 = null;
                        this.switchState = 0;
                    }
                }
            }
        }
    }

    private int startService(String string2) {
        TraeAudioSession traeAudioSession;
        int n10 = QLog.isColorLevel();
        if (n10 != 0) {
            n10 = 2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("initTRAEAudioManager , TraeAudioSession startService: ");
            Object object = this._asAudioManager;
            charSequence.append(object);
            charSequence.append(" deviceConfig:");
            charSequence.append(string2);
            charSequence = charSequence.toString();
            object = "TRAE";
            QLog.w((String)object, n10, (String)charSequence);
        }
        if ((traeAudioSession = this._asAudioManager) != null) {
            return traeAudioSession.startService(string2);
        }
        return -1;
    }

    private int stopService() {
        TraeAudioSession traeAudioSession;
        int n10 = QLog.isColorLevel();
        if (n10 != 0) {
            n10 = 2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("initTRAEAudioManager , TraeAudioSession stopService: ");
            Object object = this._asAudioManager;
            charSequence.append(object);
            charSequence = charSequence.toString();
            object = "TRAE";
            QLog.w((String)object, n10, (String)charSequence);
        }
        if ((traeAudioSession = this._asAudioManager) != null) {
            return traeAudioSession.stopService();
        }
        return -1;
    }

    private void uninitTRAEAudioManager() {
        Object object = this._context;
        int n10 = 2;
        String string2 = "TRAE";
        if (object != null) {
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = "uninitTRAEAudioManager , stopService";
                QLog.w(string2, n10, (String)object);
            }
            if ((object = this._asAudioManager) != null) {
                ((TraeAudioSession)((Object)object)).stopService();
                this._asAudioManager.release();
                bl2 = false;
                object = null;
                this._asAudioManager = null;
            }
        } else {
            boolean bl3 = QLog.isColorLevel();
            if (bl3) {
                object = "uninitTRAEAudioManager , context null";
                QLog.w(string2, n10, (String)object);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int GetPlayoutVolume() {
        int n10 = -1;
        try {
            AudioManager audioManager;
            Context context;
            AudioManager audioManager2 = this._audioManager;
            if (audioManager2 == null && (context = this._context) != null) {
                AudioManager audioManager3;
                String string2 = "audio";
                Object object = context.getSystemService(string2);
                this._audioManager = audioManager3 = (AudioManager)object;
            }
            if ((audioManager = this._audioManager) == null) return n10;
            int n11 = this._streamType;
            return audioManager.getStreamVolume(n11);
        }
        catch (Exception exception) {
            int n12 = QLog.isColorLevel();
            if (n12 == 0) return n10;
            n12 = 2;
            String string3 = exception.getMessage();
            String string4 = "TRAE GetPlayoutVolume";
            QLog.w(string4, n12, string3);
        }
        return n10;
    }

    public int call_postprocess() {
        AudioDeviceInterface.LogTraceEntry("");
        this.switchState = 0;
        TraeAudioSession traeAudioSession = this._as;
        if (traeAudioSession != null) {
            traeAudioSession.voiceCallPostprocess();
            this._as.release();
            traeAudioSession = null;
            this._as = null;
        }
        TraeAudioManager.IsUpdateSceneFlag = false;
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public int call_postprocess_media() {
        boolean bl2;
        AudioDeviceInterface.LogTraceEntry("");
        this.switchState = 0;
        Object object = this._as;
        if (object != null) {
            ((TraeAudioSession)((Object)object)).release();
            object = null;
            this._as = null;
        }
        TraeAudioManager.IsUpdateSceneFlag = false;
        object = mVivoKTVHelper;
        if (object != null && (bl2 = isSupportVivoKTVHelper)) {
            ((VivoKTVHelper)object).closeKTVDevice();
        }
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    /*
     * Exception decompiling
     */
    public int call_preprocess() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [35[TRYBLOCK]], but top level block is 44[UNCONDITIONALDOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int call_preprocess_media() {
        int n10;
        AudioDeviceInterface.LogTraceEntry("");
        this.switchState = 0;
        Object object = mVivoKTVHelper;
        if (object != null && (n10 = isSupportVivoKTVHelper) != 0) {
            ((VivoKTVHelper)object).openKTVDevice();
            object = mVivoKTVHelper;
            n10 = 1;
            ((VivoKTVHelper)object).setPreModeParam(n10);
            mVivoKTVHelper.setPlayFeedbackParam(n10);
            object = mVivoKTVHelper;
            ((VivoKTVHelper)object).setPlayFeedbackParam(0);
        }
        if ((object = this._as) == null) {
            Context context = this._context;
            AudioDeviceInterface$2 audioDeviceInterface$2 = new AudioDeviceInterface$2(this);
            object = new TraeAudioSession(context, audioDeviceInterface$2);
            this._as = object;
        }
        if ((object = this._as) != null) {
            try {
                int n11;
                object = this._audioManager;
                if (object == null) {
                    object = this._context;
                    String string2 = "audio";
                    object = object.getSystemService(string2);
                    object = (AudioManager)object;
                    this._audioManager = object;
                }
                object = this._audioManager;
                String string3 = "TRAE";
                int n12 = 2;
                if (object != null) {
                    n11 = object.getMode();
                    if (n11 == n12) {
                        n11 = 5;
                        while (true) {
                            int n13 = n11 + -1;
                            if (n11 <= 0 || (n11 = (object = this._audioManager).getMode()) != n12) break;
                            n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                            if (n11 != 0) {
                                object = new StringBuilder();
                                String string4 = "media call_preprocess_media waiting...  mode:";
                                ((StringBuilder)object).append(string4);
                                string4 = this._audioManager;
                                int n14 = string4.getMode();
                                ((StringBuilder)object).append(n14);
                                object = ((StringBuilder)object).toString();
                                QLog.e(string3, n12, (String)object);
                            }
                            long l10 = 500L;
                            Thread.sleep(l10);
                            n11 = n13;
                        }
                    }
                    if ((n11 = (object = this._audioManager).getMode()) != 0) {
                        object = this._audioManager;
                        object.setMode(0);
                    }
                    if ((n11 = (int)((object = this._audioManager).isMicrophoneMute() ? 1 : 0)) != 0) {
                        object = this._audioManager;
                        object.setMicrophoneMute(false);
                        n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                        if (n11 != 0) {
                            object = "media call_preprocess_media setMicrophoneMute false";
                            QLog.e(string3, n12, (String)object);
                        }
                    }
                }
                object = this._as;
                ((TraeAudioSession)((Object)object)).connectHighestPriorityDevice();
                object = this._as;
                ((TraeAudioSession)((Object)object)).getConnectedDevice();
                n11 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n11 != 0) {
                    object = "call_preprocess_media done!";
                    QLog.e(string3, n12, (String)object);
                }
            }
            catch (InterruptedException interruptedException) {}
        }
        AudioDeviceInterface.LogTraceExit();
        return 0;
    }

    public int checkAACMediaCodecSupported(boolean bl2) {
        CharSequence charSequence;
        int n10;
        String string2;
        block48: {
            int n11;
            String string3;
            String string4;
            int n12;
            int n13;
            String string5;
            block41: {
                string2 = "TRAE";
                n10 = 2;
                string5 = "audio/mp4a-latm";
                n13 = Build.VERSION.SDK_INT;
                n12 = 21;
                string4 = "checkAACSupported support!, ";
                string3 = "nvidia";
                n11 = 1;
                if (n13 < n12) break block41;
                MediaCodecInfo[] mediaCodecInfoArray = new MediaCodecList(n11);
                mediaCodecInfoArray = mediaCodecInfoArray.getCodecInfos();
                n12 = mediaCodecInfoArray.length;
                Object var12_12 = null;
                block36: for (int i10 = 0; i10 < n12; ++i10) {
                    String[] stringArray;
                    MediaCodecInfo mediaCodecInfo;
                    block42: {
                        mediaCodecInfo = mediaCodecInfoArray[i10];
                        boolean bl3 = mediaCodecInfo.isEncoder();
                        if (bl3 == bl2) continue;
                        stringArray = mediaCodecInfo.getName();
                        stringArray = stringArray.toLowerCase();
                        bl3 = stringArray.contains(string3);
                        if (!bl3) break block42;
                        return 0;
                    }
                    stringArray = mediaCodecInfo.getSupportedTypes();
                    int n14 = 0;
                    Object var17_22 = null;
                    while (true) {
                        block43: {
                            block44: {
                                int n15 = stringArray.length;
                                if (n14 >= n15) continue block36;
                                String string6 = stringArray[n14];
                                n15 = (int)(string6.equalsIgnoreCase(string5) ? 1 : 0);
                                if (n15 == 0) break block43;
                                bl2 = QLog.isColorLevel();
                                if (!bl2) break block44;
                                charSequence = new StringBuilder();
                                ((StringBuilder)charSequence).append(string4);
                                string5 = mediaCodecInfo.getName();
                                ((StringBuilder)charSequence).append(string5);
                                charSequence = ((StringBuilder)charSequence).toString();
                                QLog.w(string2, n10, (String)charSequence);
                            }
                            return n11;
                        }
                        ++n14;
                    }
                }
                break block48;
            }
            n13 = MediaCodecList.getCodecCount();
            block38: for (n12 = 0; n12 < n13; ++n12) {
                int n16;
                String[] stringArray;
                MediaCodecInfo mediaCodecInfo;
                block45: {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt((int)n12);
                    boolean bl4 = mediaCodecInfo.isEncoder();
                    if (bl4 == bl2) continue;
                    stringArray = mediaCodecInfo.getName();
                    stringArray = stringArray.toLowerCase();
                    bl4 = stringArray.contains(string3);
                    if (!bl4) break block45;
                    return 0;
                }
                try {
                    stringArray = mediaCodecInfo.getSupportedTypes();
                    n16 = 0;
                    Object var15_19 = null;
                }
                catch (Exception exception) {
                    bl2 = QLog.isColorLevel();
                    if (!bl2) break;
                    charSequence = "check if support aac codec failed.";
                    QLog.e(string2, n10, (String)charSequence);
                }
                while (true) {
                    block46: {
                        block47: {
                            int n17 = stringArray.length;
                            if (n16 >= n17) continue block38;
                            String string7 = stringArray[n16];
                            n17 = (int)(string7.equalsIgnoreCase(string5) ? 1 : 0);
                            if (n17 == 0) break block46;
                            bl2 = QLog.isColorLevel();
                            if (!bl2) break block47;
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append(string4);
                            string5 = mediaCodecInfo.getName();
                            ((StringBuilder)charSequence).append(string5);
                            charSequence = ((StringBuilder)charSequence).toString();
                            QLog.w(string2, n10, (String)charSequence);
                        }
                        return n11;
                    }
                    ++n16;
                }
            }
        }
        if (bl2 = QLog.isColorLevel()) {
            charSequence = "Error when checking aac codec availability";
            QLog.e(string2, n10, (String)charSequence);
        }
        return 0;
    }

    public int checkAACSupported() {
        int n10 = this.checkAACMediaCodecSupported(false);
        int n11 = 1;
        int n12 = this.checkAACMediaCodecSupported(n11 != 0);
        int n13 = QLog.isColorLevel();
        if (n13 != 0) {
            n13 = 2;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("checkAACSupported isSupportEncoder: ");
            charSequence.append(n10);
            charSequence.append(", isSupportDecoder:");
            charSequence.append(n12);
            charSequence = charSequence.toString();
            String string2 = "TRAE";
            QLog.w(string2, n13, (String)charSequence);
        }
        if (n10 == n11 && n12 == n11) {
            return n11;
        }
        return 0;
    }

    public int getAudioRouteSwitchState() {
        return this.switchState;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getMode() {
        int n10 = -1;
        try {
            AudioManager audioManager;
            Context context;
            AudioManager audioManager2 = this._audioManager;
            if (audioManager2 == null && (context = this._context) != null) {
                AudioManager audioManager3;
                String string2 = "audio";
                Object object = context.getSystemService(string2);
                this._audioManager = audioManager3 = (AudioManager)object;
            }
            if ((audioManager = this._audioManager) == null) return n10;
            return audioManager.getMode();
        }
        catch (Exception exception) {
            int n11 = QLog.isColorLevel();
            if (n11 == 0) return n10;
            n11 = 2;
            String string3 = exception.getMessage();
            String string4 = "TRAE getMode";
            QLog.w(string4, n11, string3);
        }
        return n10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int getNumberOfCPUCores() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 10;
        if (n10 <= n11) {
            return 1;
        }
        n10 = -1;
        Object object = "/sys/devices/system/cpu/";
        File[] fileArray = new File((String)object);
        object = CPU_FILTER;
        fileArray = fileArray.listFiles((FileFilter)object);
        try {
            return fileArray.length;
        }
        catch (NullPointerException | SecurityException runtimeException) {
            return n10;
        }
    }

    public int hasLightSensorManager() {
        int n10;
        int n11;
        Object object;
        String string2;
        block8: {
            int n12;
            string2 = "TRAE";
            object = this._context;
            n11 = 1;
            if (object == null) {
                return n11;
            }
            n10 = 2;
            String string3 = "sensor";
            try {
                object = object.getSystemService(string3);
            }
            catch (Exception exception) {
                n12 = QLog.isColorLevel();
                if (n12 != 0) {
                    String string4 = exception.getMessage();
                    QLog.w(string2, n10, string4);
                }
                return n11;
            }
            object = (SensorManager)object;
            n12 = 5;
            object = object.getDefaultSensor(n12);
            if (object != null) break block8;
            boolean bl2 = QLog.isColorLevel();
            if (bl2) {
                object = "not hasLightSensorManager null == sensor8";
                QLog.w(string2, n10, (String)object);
            }
            return 0;
        }
        boolean bl3 = QLog.isColorLevel();
        if (bl3) {
            object = "hasLightSensorManager";
            QLog.w(string2, n10, (String)object);
        }
        return n11;
    }

    public int isBackground() {
        block22: {
            String string2;
            int n10;
            Object object;
            block21: {
                Object object2;
                int n11;
                block19: {
                    block20: {
                        object = this._context;
                        if (object == null) {
                            return 0;
                        }
                        n10 = 2;
                        String string3 = "activity";
                        try {
                            object = object.getSystemService(string3);
                        }
                        catch (Exception exception) {
                            boolean bl2 = QLog.isColorLevel();
                            if (bl2) {
                                String string4 = exception.getMessage();
                                string3 = "TRAE isBackground";
                                QLog.w(string3, n10, string4);
                            }
                            return 0;
                        }
                        object = (ActivityManager)object;
                        n11 = 1;
                        object2 = object.getRunningTasks(n11);
                        string2 = "TRAE";
                        if (object2 != null) break block19;
                        boolean n12 = QLog.isColorLevel();
                        if (!n12) break block20;
                        object = "running task is null, ams is abnormal!!!";
                        QLog.e(string2, n10, (String)object);
                    }
                    return 0;
                }
                object = object.getRunningTasks(n11);
                object = object.get(0);
                object = (ActivityManager.RunningTaskInfo)object;
                if (object == null) break block21;
                object = ((ActivityManager.RunningTaskInfo)object).topActivity;
                if (object == null) break block21;
                object = object.getPackageName();
                object2 = this._context;
                object2 = object2.getPackageName();
                int bl3 = ((String)object).equals(object2) ^ n11;
                if (bl3 != 0) {
                    return n11;
                }
                return 0;
            }
            boolean bl3 = QLog.isColorLevel();
            if (!bl3) break block22;
            object = "failed to get RunningTaskInfo";
            QLog.e(string2, n10, (String)object);
        }
        return 0;
    }

    public void setContext(Context context) {
        this._context = context;
    }

    public void setJavaInterface(int n10) {
        int n11;
        if (n10 == 0) {
            n11 = 0;
            this.usingJava = false;
        } else {
            this.usingJava = n11 = 1;
        }
        n11 = QLog.isColorLevel();
        if (n11 != 0) {
            n11 = 2;
            CharSequence charSequence = new StringBuilder();
            String string2 = "setJavaInterface flg:";
            charSequence.append(string2);
            charSequence.append(n10);
            String string3 = charSequence.toString();
            charSequence = "TRAE";
            QLog.w((String)charSequence, n11, string3);
        }
    }
}

