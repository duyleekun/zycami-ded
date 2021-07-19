/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaRecorder
 *  android.media.MediaRecorder$OnInfoListener
 *  android.util.Size
 *  android.view.Surface
 */
package d.v.d.g.h;

import android.media.MediaRecorder;
import android.util.Size;
import android.view.Surface;
import d.v.d.g.b;
import d.v.d.h.f;
import java.io.File;

public class a {
    public static final int c = 2;
    public static final int d = 44100;
    public static final int e = 96000;
    private MediaRecorder a;
    private b b;

    private void a() {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object = this.b;
        if (object == null) {
            return;
        }
        CharSequence charSequence = this.b.h;
        object = new File((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("deletedInvalidFile file.exists=");
        boolean bl2 = ((File)object).exists();
        ((StringBuilder)charSequence).append(bl2);
        String string2 = ",file.length=";
        ((StringBuilder)charSequence).append(string2);
        long l132 = ((File)object).length();
        ((StringBuilder)charSequence).append(l132);
        charSequence = ((StringBuilder)charSequence).toString();
        f.a((String)charSequence);
        boolean n10 = ((File)object).exists();
        if (n10 && (l13 = (l12 = (l11 = ((File)object).length()) - (l10 = 1000L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
            boolean bl3 = ((File)object).delete();
            charSequence = new StringBuilder();
            string2 = "deletedInvalidFile delete=";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(bl3);
            object = ((StringBuilder)charSequence).toString();
            f.a((String)object);
        }
    }

    private void f() {
        MediaRecorder.OnInfoListener onInfoListener;
        MediaRecorder mediaRecorder = this.a;
        if (mediaRecorder != null && (onInfoListener = this.b.i) != null) {
            mediaRecorder.setOnInfoListener(onInfoListener);
        }
    }

    public MediaRecorder b() {
        return this.a;
    }

    public Surface c() {
        Object object = this.a.getSurface();
        boolean bl2 = object.isValid();
        if (bl2) {
            return this.a.getSurface();
        }
        object = new IllegalStateException("surface is not valid");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d(b object) {
        try {
            int n10;
            MediaRecorder mediaRecorder;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "prepare videoProfile =";
            stringBuilder.append(string2);
            string2 = ((b)object).toString();
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            f.a(string3);
            this.a = mediaRecorder = new MediaRecorder();
            String string4 = "MediaRecorder prepare start ";
            f.a(string4);
            MediaRecorder mediaRecorder2 = this.a;
            mediaRecorder2.reset();
            this.b = object;
            boolean bl2 = ((b)object).g;
            if (!bl2) {
                MediaRecorder mediaRecorder3 = this.a;
                n10 = ((b)object).k;
                mediaRecorder3.setAudioSource(n10);
            }
            MediaRecorder mediaRecorder4 = this.a;
            n10 = 2;
            mediaRecorder4.setVideoSource(n10);
            MediaRecorder mediaRecorder5 = this.a;
            mediaRecorder5.setOutputFormat(n10);
            MediaRecorder mediaRecorder6 = this.a;
            String string5 = ((b)object).h;
            mediaRecorder6.setOutputFile(string5);
            MediaRecorder mediaRecorder7 = this.a;
            int n11 = ((b)object).d;
            mediaRecorder7.setVideoFrameRate(n11);
            MediaRecorder mediaRecorder8 = this.a;
            n11 = ((b)object).f;
            mediaRecorder8.setVideoEncodingBitRate(n11);
            MediaRecorder mediaRecorder9 = this.a;
            string5 = ((b)object).a;
            n11 = string5.getWidth();
            Size size = ((b)object).a;
            int n12 = size.getHeight();
            mediaRecorder9.setVideoSize(n11, n12);
            MediaRecorder mediaRecorder10 = this.a;
            mediaRecorder10.setVideoEncoder(n10);
            bl2 = ((b)object).g;
            if (!bl2) {
                MediaRecorder mediaRecorder11 = this.a;
                n11 = 3;
                mediaRecorder11.setAudioEncoder(n11);
                MediaRecorder mediaRecorder12 = this.a;
                n11 = 96000;
                mediaRecorder12.setAudioEncodingBitRate(n11);
                MediaRecorder mediaRecorder13 = this.a;
                n11 = 44100;
                mediaRecorder13.setAudioSamplingRate(n11);
                MediaRecorder mediaRecorder14 = this.a;
                mediaRecorder14.setAudioChannels(n10);
            }
            MediaRecorder mediaRecorder15 = this.a;
            double d10 = ((b)object).e;
            mediaRecorder15.setCaptureRate(d10);
            this.f();
            MediaRecorder mediaRecorder16 = this.a;
            int n13 = ((b)object).c;
            mediaRecorder16.setOrientationHint(n13);
            object = this.a;
            object.prepare();
            object = "mMediaRecorder prepare done!";
            f.a((String)object);
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mMediaRecorder prepare failed: ");
            String string6 = exception.toString();
            stringBuilder.append(string6);
            f.a(stringBuilder.toString());
            return false;
        }
    }

    public void e() {
        f.a("releaseMediaRecorder");
        MediaRecorder mediaRecorder = this.a;
        if (mediaRecorder != null) {
            f.a("Releasing media recorder.");
            this.a.reset();
            this.a.setOnInfoListener(null);
            mediaRecorder = this.a;
            mediaRecorder.release();
            this.a = null;
        }
    }

    public boolean g() {
        String string2 = "Recording starts!";
        try {
            f.a(string2);
            string2 = this.a;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("mMediaRecorder start failed=");
            String string3 = exception.toString();
            stringBuilder.append(string3);
            f.a(stringBuilder.toString());
            this.a();
            return false;
        }
        string2.start();
        return true;
    }

    public boolean h() {
        StringBuilder stringBuilder;
        String string2 = "Recording stop!";
        try {
            f.a(string2);
            string2 = this.a;
            stringBuilder = null;
        }
        catch (Exception exception) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("mMediaRecorder stop  failed =");
            String string3 = exception.toString();
            stringBuilder.append(string3);
            f.a(stringBuilder.toString());
            this.a();
            return false;
        }
        string2.setOnErrorListener(null);
        string2 = this.a;
        string2.stop();
        this.e();
        return true;
    }
}

