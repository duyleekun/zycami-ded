/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.opengl.GLES20
 *  android.util.Log
 *  javax.microedition.khronos.egl.EGLContext
 */
package d.v.r;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.util.Log;
import com.google.mediapipe.components.FrameProcessor;
import com.google.mediapipe.components.TextureFrameConsumer;
import com.google.mediapipe.framework.AppTextureFrame;
import com.google.mediapipe.glutil.ShaderUtil;
import d.v.r.a;
import d.v.r.d;
import d.v.r.f;
import d.v.r.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.microedition.khronos.egl.EGLContext;

public class e$a
extends g
implements d {
    private static final long w = 1000L;
    private final List j;
    private List k = null;
    private int l = -1;
    private f m = null;
    private long n;
    private long o;
    private boolean p;
    public int q;
    public int r;
    public long s;
    public long t;
    public boolean u;
    public TextureFrameConsumer v;

    public e$a(EGLContext object, int n10) {
        super(object);
        long l10;
        this.n = l10 = 0L;
        this.o = l10;
        this.p = false;
        this.q = 0;
        this.r = 0;
        this.s = 4355449L;
        this.t = l10;
        this.u = false;
        ArrayList arrayList = new ArrayList(this);
        this.v = arrayList;
        this.k = arrayList = new ArrayList();
        object = Collections.nCopies(n10, null);
        arrayList.addAll(object);
        super();
        this.m = object;
        super();
        this.j = object;
    }

    private void A(int n10) {
        Object object = this.k.get(n10);
        if (object != null) {
            int n11;
            object = (AppTextureFrame)this.k.get(n10);
            this.C((AppTextureFrame)object);
            int n12 = 1;
            int[] nArray = new int[n12];
            AppTextureFrame appTextureFrame = (AppTextureFrame)this.k.get(n10);
            nArray[0] = n11 = appTextureFrame.getTextureName();
            GLES20.glDeleteTextures((int)n12, (int[])nArray, (int)0);
            object = this.k;
            nArray = null;
            object.set(n10, null);
        }
    }

    private void B(AppTextureFrame appTextureFrame) {
        long l10;
        long l11;
        long l12;
        Object object;
        int n10 = appTextureFrame.getTextureName();
        int n11 = this.q;
        int n12 = this.r;
        this.b(n10, n11, n12);
        n10 = 3;
        Object object2 = new Object[n10];
        object2[0] = object = Integer.valueOf(appTextureFrame.getTextureName());
        object = this.q;
        n12 = 1;
        object2[n12] = object;
        object = this.r;
        int n13 = 2;
        object2[n13] = object;
        object2 = String.format("Created output texture: %d width: %d height: %d", (Object[])object2);
        object = "FRAME_BUFFER_OBJ";
        Log.d((String)object, (String)object2);
        object2 = this.m;
        n11 = appTextureFrame.getTextureName();
        ((f)object2).e(n11);
        long l13 = this.s;
        long l14 = 1L;
        this.s = l12 = l13 + l14;
        int n14 = this.p;
        if (n14 != 0 && (n14 = (l11 = (l12 = this.n + l13) - (l10 = this.o)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
            this.n = l10 = l10 + l14 - l13;
        }
        CharSequence charSequence = new StringBuilder();
        String string2 = "Time : ";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(l13);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)"TIME_STAMP_M", (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        long l15 = this.n + l13;
        ((StringBuilder)charSequence).append(l15);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.d((String)"TIME_STAMP_P", (String)charSequence);
        l14 = this.n;
        appTextureFrame.setTimestamp(l13 += l14);
        this.o = l13 = appTextureFrame.getTimestamp();
        this.p = n12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void C(AppTextureFrame object) {
        Object object2 = "ExternalTextureConv";
        int n10 = 2;
        try {
            Object[] objectArray;
            String string2;
            boolean bl2 = Log.isLoggable((String)object2, (int)n10);
            int n11 = 1;
            int n12 = 0;
            Integer n13 = null;
            int n14 = 3;
            if (bl2) {
                string2 = "Waiting for tex: %d width: %d height: %d";
                objectArray = new Object[n14];
                int n15 = ((AppTextureFrame)object).getTextureName();
                Integer n16 = n15;
                objectArray[0] = n16;
                n15 = ((AppTextureFrame)object).getWidth();
                n16 = n15;
                objectArray[n11] = n16;
                n15 = ((AppTextureFrame)object).getHeight();
                n16 = n15;
                objectArray[n10] = n16;
                string2 = String.format(string2, objectArray);
                Log.v((String)object2, (String)string2);
            }
            ((AppTextureFrame)object).waitUntilReleased();
            bl2 = Log.isLoggable((String)object2, (int)n10);
            if (bl2) {
                string2 = "Finished waiting for tex: %d width: %d height: %d";
                Object[] objectArray2 = new Object[n14];
                int n17 = ((AppTextureFrame)object).getTextureName();
                objectArray2[0] = objectArray = Integer.valueOf(n17);
                n12 = ((AppTextureFrame)object).getWidth();
                n13 = n12;
                objectArray2[n11] = n13;
                int n18 = ((AppTextureFrame)object).getHeight();
                objectArray2[n10] = object = Integer.valueOf(n18);
                object = String.format(string2, objectArray2);
                Log.v((String)object2, (String)object);
            }
            return;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("thread was unexpectedly interrupted: ");
            String string3 = interruptedException.getMessage();
            stringBuilder.append(string3);
            String string4 = stringBuilder.toString();
            Log.e((String)object2, (String)string4);
            object2 = new RuntimeException(interruptedException);
            throw object2;
        }
    }

    public static int p(int n10, int n11) {
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = 0;
        GLES20.glGenTextures((int)n12, (int[])nArray, (int)0);
        GLES20.glActiveTexture((int)33985);
        n12 = nArray[0];
        int n13 = 3553;
        GLES20.glBindTexture((int)n13, (int)n12);
        GLES20.glTexImage2D((int)3553, (int)0, (int)6408, (int)n10, (int)n11, (int)0, (int)6408, (int)5121, null);
        ShaderUtil.checkGlError("glTexImage2D");
        n11 = 9729;
        GLES20.glTexParameteri((int)n13, (int)10241, (int)n11);
        GLES20.glTexParameteri((int)n13, (int)10240, (int)n11);
        n11 = 33071;
        GLES20.glTexParameteri((int)n13, (int)10242, (int)n11);
        GLES20.glTexParameteri((int)n13, (int)10243, (int)n11);
        ShaderUtil.checkGlError("texture setup");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Name: Texture cteated ");
        n11 = nArray[0];
        charSequence.append(n11);
        charSequence = charSequence.toString();
        Log.d((String)"TEXT_NAME", (String)charSequence);
        return nArray[0];
    }

    public static int q(int n10, int n11) {
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = 0;
        GLES20.glGenTextures((int)n12, (int[])nArray, (int)0);
        GLES20.glActiveTexture((int)33984);
        n12 = nArray[0];
        int n13 = 3553;
        GLES20.glBindTexture((int)n13, (int)n12);
        GLES20.glTexImage2D((int)3553, (int)0, (int)6408, (int)n10, (int)n11, (int)0, (int)6408, (int)5121, null);
        ShaderUtil.checkGlError("glTexImage2D");
        n11 = 9729;
        GLES20.glTexParameteri((int)n13, (int)10241, (int)n11);
        GLES20.glTexParameteri((int)n13, (int)10240, (int)n11);
        n11 = 33071;
        GLES20.glTexParameteri((int)n13, (int)10242, (int)n11);
        GLES20.glTexParameteri((int)n13, (int)10243, (int)n11);
        ShaderUtil.checkGlError("texture setup");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Name: Texture cteated ");
        n11 = nArray[0];
        charSequence.append(n11);
        charSequence = charSequence.toString();
        Log.d((String)"TEXT_NAME", (String)charSequence);
        return nArray[0];
    }

    private /* synthetic */ void r(Bitmap bitmap) {
        int n10;
        Log.d((String)"FRAME_TES", (String)"OnFrame inside handler");
        this.q = n10 = bitmap.getWidth();
        this.r = n10 = bitmap.getHeight();
        this.m.a(bitmap);
        this.v();
    }

    private AppTextureFrame t() {
        int n10;
        int n11 = this.l + 1;
        int n12 = this.k.size();
        this.l = n11 %= n12;
        List list = this.k;
        Object object = (AppTextureFrame)list.get(n11);
        if (object == null || (n12 = ((AppTextureFrame)object).getWidth()) != (n10 = this.q) || (n12 = ((AppTextureFrame)object).getHeight()) != (n10 = this.r)) {
            n11 = this.l;
            this.z(n11);
            object = this.k;
            n12 = this.l;
            object = (AppTextureFrame)object.get(n12);
        }
        this.C((AppTextureFrame)object);
        return object;
    }

    private void y(int n10) {
        Object object;
        this.A(n10);
        int n11 = this.q;
        int n12 = this.r;
        n11 = e$a.p(n11, n12);
        n12 = 3;
        Object object2 = new Object[n12];
        object2[0] = object = Integer.valueOf(n11);
        object = this.q;
        int n13 = 1;
        object2[n13] = object;
        object = this.r;
        int n14 = 2;
        object2[n14] = object;
        object = "Created output texture: %d width: %d height: %d";
        object2 = String.format((String)object, object2);
        Log.d((String)"ExternalTextureConv", (String)object2);
        Object object3 = new Object[n12];
        object3[0] = object2 = Integer.valueOf(n11);
        object3[n13] = object2 = Integer.valueOf(this.q);
        object3[n14] = object2 = Integer.valueOf(this.r);
        object3 = String.format((String)object, (Object[])object3);
        Log.d((String)"FRAME_BUFFER_OBJ", (String)object3);
        object3 = this.k;
        int n15 = this.q;
        int n16 = this.r;
        object2 = new AppTextureFrame(n11, n15, n16);
        object3.set(n10, object2);
    }

    private void z(int n10) {
        Object object;
        this.A(n10);
        int n11 = this.q;
        int n12 = this.r;
        n11 = e$a.q(n11, n12);
        n12 = 3;
        Object object2 = new Object[n12];
        object2[0] = object = Integer.valueOf(n11);
        object = this.q;
        int n13 = 1;
        object2[n13] = object;
        object = this.r;
        int n14 = 2;
        object2[n14] = object;
        object = "Created output texture: %d width: %d height: %d";
        object2 = String.format((String)object, object2);
        Log.d((String)"ExternalTextureConv", (String)object2);
        Object object3 = new Object[n12];
        object3[0] = object2 = Integer.valueOf(n11);
        object3[n13] = object2 = Integer.valueOf(this.q);
        object3[n14] = object2 = Integer.valueOf(this.r);
        object3 = String.format((String)object, (Object[])object3);
        Log.d((String)"FRAME_BUFFER_OBJ", (String)object3);
        object3 = this.k;
        int n15 = this.q;
        int n16 = this.r;
        object2 = new AppTextureFrame(n11, n15, n16);
        object3.set(n10, object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(Bitmap bitmap) {
        String string2 = "FRAME_TES";
        Object object = "OnFrame";
        try {
            Log.d((String)string2, (String)object);
            string2 = this.e;
        }
        catch (Exception exception) {
            return;
        }
        object = new a(this, bitmap);
        string2.post((Runnable)object);
    }

    public void j() {
        super.j();
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        this.m.g();
    }

    public void l() {
        List list;
        int n10;
        for (int i10 = 0; i10 < (n10 = (list = this.k).size()); ++i10) {
            this.A(i10);
        }
        this.m.d();
        super.l();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void o(TextureFrameConsumer textureFrameConsumer) {
        List list = this.j;
        synchronized (list) {
            List list2 = this.j;
            list2.add(textureFrameConsumer);
            return;
        }
    }

    public /* synthetic */ void s(Bitmap bitmap) {
        this.r(bitmap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void u(TextureFrameConsumer textureFrameConsumer) {
        List list = this.j;
        synchronized (list) {
            List list2 = this.j;
            list2.remove(textureFrameConsumer);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void v() {
        boolean bl2 = this.u;
        if (bl2) {
            Log.d((String)"MP_FRM", (String)"still processing");
            Log.d((String)"OUTPUT_CONSUMER", (String)"still processing");
            return;
        }
        Log.d((String)"OUTPUT_CONSUMER", (String)"starting next process");
        Log.d((String)"MP_FRM", (String)"render next 246");
        List list = this.j;
        synchronized (list) {
            boolean bl3;
            Object object = "MP_FRM";
            String string2 = "render next";
            Log.d((String)object, (String)string2);
            object = this.j;
            object = object.iterator();
            string2 = null;
            int n10 = 1;
            int n11 = 0;
            TextureFrameConsumer textureFrameConsumer = null;
            while (bl3 = object.hasNext()) {
                textureFrameConsumer = (TextureFrameConsumer)object.next();
                textureFrameConsumer = textureFrameConsumer;
                AppTextureFrame appTextureFrame = this.t();
                this.B(appTextureFrame);
                if (textureFrameConsumer != null) {
                    long l10;
                    String string3 = "ExternalTextureConv";
                    int n12 = 2;
                    boolean bl4 = Log.isLoggable((String)string3, (int)n12);
                    if (bl4) {
                        string3 = "ExternalTextureConv";
                        String string4 = "Locking tex: %d width: %d height: %d";
                        int n13 = 3;
                        Object[] objectArray = new Object[n13];
                        int n14 = appTextureFrame.getTextureName();
                        Integer n15 = n14;
                        objectArray[0] = n15;
                        n14 = appTextureFrame.getWidth();
                        n15 = n14;
                        objectArray[n10] = n15;
                        n14 = appTextureFrame.getHeight();
                        n15 = n14;
                        objectArray[n12] = n15;
                        String string5 = String.format(string4, objectArray);
                        Log.v((String)string3, (String)string5);
                    }
                    this.u = n10;
                    this.t = l10 = System.currentTimeMillis();
                    appTextureFrame.setInUse();
                    textureFrameConsumer.onNewFrame(appTextureFrame);
                }
                n11 = n10;
            }
            if (n11 == 0) {
                object = this.t();
                this.B((AppTextureFrame)object);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void w(TextureFrameConsumer object) {
        List list = this.j;
        synchronized (list) {
            Object object2 = this.j;
            object2.clear();
            object2 = this.j;
            object2.add(object);
            try {
                object = (FrameProcessor)object;
                object2 = this.v;
                ((FrameProcessor)object).setConsumer((TextureFrameConsumer)object2);
                object = "OUTPUT_CONSUMER_SETTED";
                object2 = "consumer setup";
                Log.d((String)object, (String)object2);
            }
            catch (Exception exception) {}
            return;
        }
    }

    public void x(boolean bl2) {
        this.m.f(bl2);
    }
}

