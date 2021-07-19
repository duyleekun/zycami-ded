/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder
 */
package cn.leancloud.im.v2.audio;

import android.media.MediaRecorder;
import cn.leancloud.AVLogger;
import cn.leancloud.im.v2.audio.AVIMAudioRecorder$RecordEventListener;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.io.File;
import java.io.IOException;

public class AVIMAudioRecorder {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVIMAudioRecorder.class);
    private static final long MIN_INTERVAL_TIME = 1000L;
    private static final String REASON_TOO_SHORT_TIME = "time is too short(less than 1 second)";
    private AVIMAudioRecorder$RecordEventListener listener;
    private String localPath = null;
    private MediaRecorder recorder = null;
    private long startRecordTime;

    public AVIMAudioRecorder(String object, AVIMAudioRecorder$RecordEventListener aVIMAudioRecorder$RecordEventListener) {
        long l10;
        this.startRecordTime = l10 = 0L;
        this.listener = null;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            this.localPath = object;
            this.listener = aVIMAudioRecorder$RecordEventListener;
            return;
        }
        object = new IllegalArgumentException("local path is empty.");
        throw object;
    }

    private void removeRecordFile() {
        String string2 = this.localPath;
        File file = new File(string2);
        boolean bl2 = file.exists();
        if (bl2) {
            file.delete();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void stopRecorder(boolean var1_1) {
        block7: {
            block6: {
                var2_2 = this.recorder;
                if (var2_2 == null) return;
                var2_2.stop();
                if (var1_1 /* !! */  == 0 || (var3_3 = this.listener) == null) break block6;
                var4_6 = System.currentTimeMillis();
                var6_7 = this.startRecordTime;
                cfr_temp_0 = (var4_6 -= var6_7) - (var6_7 = 1000L);
                var1_1 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var1_1 /* !! */  < 0) {
                }
                ** GOTO lbl26
                {
                    catch (Throwable var3_4) {
                        break block7;
                    }
                    catch (Exception var3_5) {}
                    {
                        var2_2 = AVIMAudioRecorder.LOGGER;
                        var8_8 = "failed to stop MediaRecorder. cause: ";
                        var2_2.e(var8_8, var3_5);
                        break block6;
                    }
                }
                {
                    this.removeRecordFile();
                    var3_3 = this.listener;
                    var4_6 = 0L;
                    var2_2 = "time is too short(less than 1 second)";
                    var3_3.onFinishedRecord(var4_6, (String)var2_2);
                    break block6;
lbl26:
                    // 1 sources

                    var3_3 = this.listener;
                    var3_3.onFinishedRecord(var4_6, null);
                }
            }
            var3_3 = this.recorder;
            var3_3.release();
            this.recorder = null;
            return;
        }
        this.recorder.release();
        this.recorder = null;
        throw var3_4;
    }

    public void cancel() {
        this.stopRecorder(false);
        this.removeRecordFile();
    }

    public int getMaxAmplitude() {
        MediaRecorder mediaRecorder = this.recorder;
        if (mediaRecorder == null) {
            return 0;
        }
        return mediaRecorder.getMaxAmplitude();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void start() {
        try {
            long l10;
            Object object = this.recorder;
            if (object == null) {
                object = new MediaRecorder();
                this.recorder = object;
                int n10 = 0;
                String string2 = null;
                object.setAudioSource(0);
                object = this.recorder;
                object.setOutputFormat(0);
                object = this.recorder;
                n10 = 3;
                object.setAudioEncoder(n10);
                object = this.recorder;
                string2 = this.localPath;
                object.setOutputFile(string2);
                object = this.recorder;
                object.prepare();
            } else {
                object.reset();
                object = this.recorder;
                String string3 = this.localPath;
                object.setOutputFile(string3);
            }
            object = this.recorder;
            object.start();
            this.startRecordTime = l10 = System.currentTimeMillis();
            object = this.listener;
            if (object == null) return;
            object.onStartRecord();
            return;
        }
        catch (IOException iOException) {
            AVLogger aVLogger = LOGGER;
            String string4 = "failed to start MediaRecorder. cause: ";
            aVLogger.e(string4, iOException);
        }
    }

    public void stop() {
        this.stopRecorder(true);
    }
}

