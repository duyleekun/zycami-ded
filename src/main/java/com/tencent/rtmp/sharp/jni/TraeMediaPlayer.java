/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.AudioManager
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.net.Uri
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.rtmp.sharp.jni.AudioDeviceInterface;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.rtmp.sharp.jni.TraeMediaPlayer$OnCompletionListener;
import java.util.Timer;
import java.util.TimerTask;

public class TraeMediaPlayer
implements MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener {
    public static final int TRAE_MEDIAPLAER_DATASOURCE_FILEPATH = 2;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_RSID = 0;
    public static final int TRAE_MEDIAPLAER_DATASOURCE_URI = 1;
    public static final int TRAE_MEDIAPLAER_STOP = 100;
    private Context _context;
    private int _durationMS;
    private boolean _hasCall = false;
    private boolean _loop = false;
    public int _loopCount;
    private int _prevVolume;
    public boolean _ringMode;
    private int _streamType = 0;
    private Timer _watchTimer;
    private TimerTask _watchTimertask;
    private TraeMediaPlayer$OnCompletionListener mCallback;
    private MediaPlayer mMediaPlay = null;

    public TraeMediaPlayer(Context context, TraeMediaPlayer$OnCompletionListener traeMediaPlayer$OnCompletionListener) {
        int n10;
        this._durationMS = n10 = -1;
        this._loopCount = 0;
        this._ringMode = false;
        this._watchTimer = null;
        this._watchTimertask = null;
        this._prevVolume = n10;
        this._context = context;
        this.mCallback = traeMediaPlayer$OnCompletionListener;
    }

    public static /* synthetic */ MediaPlayer access$000(TraeMediaPlayer traeMediaPlayer) {
        return traeMediaPlayer.mMediaPlay;
    }

    public static /* synthetic */ TraeMediaPlayer$OnCompletionListener access$100(TraeMediaPlayer traeMediaPlayer) {
        return traeMediaPlayer.mCallback;
    }

    private void volumeDo() {
        block30: {
            int n10;
            int n11;
            String string2 = "TRAE";
            Object object = this.mMediaPlay;
            if (object != null && (n11 = this._ringMode) != 0 && (n11 = this._streamType) != (n10 = 2)) {
                int n12;
                int n13;
                int n14;
                int n15;
                int n16;
                CharSequence charSequence;
                block29: {
                    object = this._context;
                    charSequence = "audio";
                    object = object.getSystemService((String)charSequence);
                    object = (AudioManager)object;
                    n16 = this._streamType;
                    n16 = object.getStreamVolume(n16);
                    n15 = this._streamType;
                    n15 = object.getStreamMaxVolume(n15);
                    n14 = object.getStreamVolume(n10);
                    n13 = object.getStreamMaxVolume(n10);
                    double d10 = (double)n14 * 1.0;
                    double d11 = n13;
                    d10 /= d11;
                    d11 = n15;
                    n12 = (int)(d10 *= d11);
                    boolean bl2 = QLog.isColorLevel();
                    if (!bl2) break block29;
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "TraeMediaPlay volumeDo currV:";
                    stringBuilder.append(string3);
                    stringBuilder.append(n16);
                    string3 = " maxV:";
                    stringBuilder.append(string3);
                    stringBuilder.append(n15);
                    string3 = " currRV:";
                    stringBuilder.append(string3);
                    stringBuilder.append(n14);
                    String string4 = " maxRV:";
                    stringBuilder.append(string4);
                    stringBuilder.append(n13);
                    string4 = " setV:";
                    stringBuilder.append(string4);
                    stringBuilder.append(n12);
                    string4 = stringBuilder.toString();
                    QLog.e(string2, n10, string4);
                }
                if (++n12 < n15) {
                    n15 = n12;
                }
                n14 = this._streamType;
                n13 = 0;
                object.setStreamVolume(n14, n15, 0);
                try {
                    this._prevVolume = n16;
                }
                catch (Exception exception) {
                    n16 = QLog.isColorLevel();
                    if (n16 == 0) break block30;
                    charSequence = new StringBuilder();
                    String string5 = "set stream volume failed.";
                    ((StringBuilder)charSequence).append(string5);
                    String string6 = exception.getMessage();
                    ((StringBuilder)charSequence).append(string6);
                    string6 = ((StringBuilder)charSequence).toString();
                    QLog.e(string2, n10, string6);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void volumeUndo() {
        String string2 = "TRAE";
        Object object = this.mMediaPlay;
        if (object == null) return;
        int n10 = this._ringMode;
        if (n10 == 0) return;
        n10 = this._streamType;
        int n11 = 2;
        if (n10 == n11) return;
        n10 = this._prevVolume;
        int n12 = -1;
        if (n10 == n12) {
            return;
        }
        try {
            String string3;
            n10 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n10 != 0) {
                object = new StringBuilder();
                string3 = "TraeMediaPlay volumeUndo _prevVolume:";
                ((StringBuilder)object).append(string3);
                n12 = this._prevVolume;
                ((StringBuilder)object).append(n12);
                object = ((StringBuilder)object).toString();
                QLog.e(string2, n11, (String)object);
            }
            object = this._context;
            string3 = "audio";
            object = object.getSystemService(string3);
            object = (AudioManager)object;
            n12 = this._streamType;
            int n13 = this._prevVolume;
            object.setStreamVolume(n12, n13, 0);
            return;
        }
        catch (Exception exception) {
            n12 = (int)(QLog.isColorLevel() ? 1 : 0);
            if (n12 == 0) return;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "set stream volume failed.";
            stringBuilder.append(string4);
            String string5 = exception.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            QLog.e(string2, n11, string5);
        }
    }

    public int getDuration() {
        return this._durationMS;
    }

    public int getStreamType() {
        return this._streamType;
    }

    public boolean hasCall() {
        return this._hasCall;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCompletion(MediaPlayer object) {
        block7: {
            object = new StringBuilder();
            ((StringBuilder)object).append(" cb:");
            Object object2 = this.mCallback;
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append(" loopCount:");
            int n10 = this._loopCount;
            ((StringBuilder)object).append(n10);
            object2 = " _loop:";
            ((StringBuilder)object).append((String)object2);
            n10 = (int)(this._loop ? 1 : 0);
            ((StringBuilder)object).append(n10 != 0);
            object = ((StringBuilder)object).toString();
            AudioDeviceInterface.LogTraceEntry((String)object);
            int n11 = this._loop;
            n10 = 2;
            String string2 = "TRAE";
            if (n11 != 0) {
                n11 = QLog.isColorLevel();
                if (n11 != 0) {
                    object = "loop play,continue...";
                    QLog.d(string2, n10, (String)object);
                }
                return;
            }
            try {
                n11 = this._loopCount;
                if (n11 <= 0) {
                    this.volumeUndo();
                    object = this.mMediaPlay;
                    n11 = (int)(object.isPlaying() ? 1 : 0);
                    if (n11 != 0) {
                        object = this.mMediaPlay;
                        object.stop();
                    }
                    object = this.mMediaPlay;
                    object.reset();
                    object = this.mMediaPlay;
                    object.release();
                    n11 = 0;
                    object = null;
                    this.mMediaPlay = null;
                    object = this.mCallback;
                    if (object != null) {
                        object.onCompletion();
                    }
                    break block7;
                }
                object = this.mMediaPlay;
                object.start();
                this._loopCount = n11 = this._loopCount + -1;
            }
            catch (Exception exception) {
                boolean bl2 = QLog.isColorLevel();
                if (!bl2) break block7;
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "stop play failed.";
                stringBuilder.append(string3);
                String string4 = exception.getMessage();
                stringBuilder.append(string4);
                string4 = stringBuilder.toString();
                QLog.e(string2, n10, string4);
            }
        }
        AudioDeviceInterface.LogTraceExit();
    }

    public boolean onError(MediaPlayer object, int n10, int n11) {
        block4: {
            object = new StringBuilder();
            ((StringBuilder)object).append(" cb:");
            Object object2 = this.mCallback;
            ((StringBuilder)object).append(object2);
            object2 = " arg1:";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(n10);
            String string2 = " arg2:";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            AudioDeviceInterface.LogTraceEntry((String)object);
            object = this.mMediaPlay;
            try {
                object.release();
            }
            catch (Exception exception) {
                n10 = (int)(QLog.isColorLevel() ? 1 : 0);
                if (n10 == 0) break block4;
                n10 = 2;
                CharSequence charSequence = new StringBuilder();
                object2 = "release MediaPlayer failed.";
                charSequence.append((String)object2);
                object = exception.getMessage();
                charSequence.append((String)object);
                object = charSequence.toString();
                charSequence = "TRAE";
                QLog.e((String)charSequence, n10, (String)object);
            }
        }
        this.mMediaPlay = null;
        object = this.mCallback;
        if (object != null) {
            object.onCompletion();
        }
        AudioDeviceInterface.LogTraceExit();
        return false;
    }

    /*
     * Exception decompiling
     */
    public boolean playRing(int var1_1, int var2_2, Uri var3_3, String var4_4, boolean var5_5, int var6_6, boolean var7_7, boolean var8_8, int var9_9) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 5[TRYBLOCK] [19 : 474->477)] java.lang.Throwable
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stopRing() {
        block6: {
            String string2;
            boolean bl2 = QLog.isColorLevel();
            int n10 = 2;
            String string3 = "TRAE";
            if (bl2) {
                string2 = "TraeMediaPlay stopRing ";
                QLog.d(string3, n10, string2);
            }
            if ((string2 = this.mMediaPlay) == null) {
                return;
            }
            bl2 = string2.isPlaying();
            if (bl2) {
                string2 = this.mMediaPlay;
                string2.stop();
            }
            this.mMediaPlay.reset();
            bl2 = false;
            string2 = null;
            try {
                Timer timer = this._watchTimer;
                if (timer != null) {
                    timer.cancel();
                    this._watchTimer = null;
                    this._watchTimertask = null;
                }
                timer = this.mMediaPlay;
                timer.release();
            }
            catch (Exception exception) {
                boolean bl3 = QLog.isColorLevel();
                if (!bl3) break block6;
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "release MediaPlayer failed.";
                stringBuilder.append(string4);
                String string5 = exception.getMessage();
                stringBuilder.append(string5);
                string5 = stringBuilder.toString();
                QLog.e(string3, n10, string5);
            }
        }
        this.mMediaPlay = null;
        this._durationMS = -1;
    }
}

