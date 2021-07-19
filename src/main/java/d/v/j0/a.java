/*
 * Decompiled with CFR 0.151.
 */
package d.v.j0;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public class a
implements LoadControl {
    public static final int A = 131072;
    public static final int B = 0x22C0000;
    public static final int o = 15000;
    public static final int p = 50000;
    public static final int q = 2500;
    public static final int r = 5000;
    public static final int s = 255;
    public static final boolean t = true;
    public static final int u = 0;
    public static final boolean v = false;
    public static final int w = 32768000;
    public static final int x = 0x360000;
    public static final int y = 131072;
    public static final int z = 131072;
    private final DefaultAllocator a;
    private final long b;
    private final long c;
    private final long d;
    private final long e;
    private final long f;
    private final int g;
    private final boolean h;
    private final long i;
    private final boolean j;
    private int k;
    private boolean l;
    private boolean m;
    private boolean n;

    public a() {
        DefaultAllocator defaultAllocator = new DefaultAllocator(true, 65536);
        this(defaultAllocator);
    }

    public a(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, 15000, 50000, 50000, 2500, 5000, -1, true, 0, false);
    }

    public a(DefaultAllocator defaultAllocator, int n10, int n11, int n12, int n13, int n14, int n15, boolean bl2, int n16, boolean bl3) {
        long l10;
        long l11;
        this.n = true;
        String string2 = "bufferForPlaybackMs";
        String string3 = "0";
        d.v.j0.a.b(n13, 0, string2, string3);
        String string4 = "bufferForPlaybackAfterRebufferMs";
        d.v.j0.a.b(n14, 0, string4, string3);
        String string5 = "minBufferAudioMs";
        d.v.j0.a.b(n10, n13, string5, string2);
        String string6 = "minBufferVideoMs";
        d.v.j0.a.b(n11, n13, string6, string2);
        d.v.j0.a.b(n10, n14, string5, string4);
        d.v.j0.a.b(n11, n14, string6, string4);
        string2 = "maxBufferMs";
        d.v.j0.a.b(n12, n10, string2, string5);
        d.v.j0.a.b(n12, n11, string2, string6);
        d.v.j0.a.b(n16, 0, "backBufferDurationMs", string3);
        this.a = defaultAllocator;
        this.b = l11 = C.msToUs(n10);
        this.c = l10 = C.msToUs(n11);
        this.d = l10 = C.msToUs(n12);
        this.e = l10 = C.msToUs(n13);
        this.f = l10 = C.msToUs(n14);
        this.g = n15;
        this.h = bl2;
        this.i = l10 = C.msToUs(n16);
        this.j = bl3;
    }

    public a(DefaultAllocator defaultAllocator, int n10, int n11, int n12, int n13, int n14, boolean bl2) {
        this(defaultAllocator, n10, n10, n11, n12, n13, n14, bl2, 0, false);
    }

    public static /* synthetic */ void a(int n10, int n11, String string2, String string3) {
        d.v.j0.a.b(n10, n11, string2, string3);
    }

    private static void b(int n10, int n11, String string2, String string3) {
        n10 = n10 >= n11 ? 1 : 0;
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append(" cannot be less than ");
        charSequence.append(string3);
        charSequence = charSequence.toString();
        Assertions.checkArgument(n10 != 0, charSequence);
    }

    private static int d(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    int n12 = 131072;
                    if (n10 != n11 && n10 != (n11 = 5) && n10 != (n11 = 6)) {
                        n11 = 7;
                        if (n10 == n11) {
                            return 0;
                        }
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                        throw illegalArgumentException;
                    }
                    return n12;
                }
                return 32768000;
            }
            return 0x360000;
        }
        return 0x22C0000;
    }

    private static boolean e(Renderer[] rendererArray, ExoTrackSelection[] exoTrackSelectionArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = rendererArray.length); ++i10) {
            int n11;
            Object object = rendererArray[i10];
            n10 = object.getTrackType();
            if (n10 != (n11 = 2) || (object = exoTrackSelectionArray[i10]) == null) continue;
            return true;
        }
        return false;
    }

    private void g(boolean bl2) {
        this.k = 0;
        this.l = false;
        if (bl2) {
            DefaultAllocator defaultAllocator = this.a;
            defaultAllocator.reset();
        }
    }

    public int c(Renderer[] rendererArray, ExoTrackSelection[] exoTrackSelectionArray) {
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = rendererArray.length); ++i10) {
            Object object = exoTrackSelectionArray[i10];
            if (object == null) continue;
            object = rendererArray[i10];
            n10 = d.v.j0.a.d(object.getTrackType());
            n11 += n10;
        }
        return n11;
    }

    public boolean f() {
        return this.n;
    }

    public Allocator getAllocator() {
        return this.a;
    }

    public long getBackBufferDurationUs() {
        return this.i;
    }

    public void h(boolean bl2) {
        this.n = bl2;
    }

    public void onPrepared() {
        this.g(false);
    }

    public void onReleased() {
        this.g(true);
    }

    public void onStopped() {
        this.g(true);
    }

    public void onTracksSelected(Renderer[] rendererArray, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArray) {
        int n10;
        this.m = n10 = d.v.j0.a.e(rendererArray, exoTrackSelectionArray);
        n10 = this.g;
        int n11 = -1;
        if (n10 == n11) {
            n10 = this.c(rendererArray, exoTrackSelectionArray);
        }
        this.k = n10;
        this.a.setTargetBufferSize(n10);
    }

    public boolean retainBackBufferFromKeyframe() {
        return this.j;
    }

    public boolean shouldContinueLoading(long l10, long l11, float f10) {
        DefaultAllocator defaultAllocator = this.a;
        int n10 = defaultAllocator.getTotalBytesAllocated();
        int n11 = this.k;
        int n12 = 1;
        if (n10 >= n11) {
            n10 = n12;
        } else {
            n10 = 0;
            defaultAllocator = null;
        }
        n11 = (int)(this.m ? 1 : 0);
        long l12 = n11 != 0 ? this.c : this.b;
        float f11 = 1.0f;
        n11 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
        if (n11 > 0) {
            l12 = Util.getMediaDurationForPlayoutDuration(l12, f10);
            long l13 = this.d;
            l12 = Math.min(l12, l13);
        }
        if ((n11 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1))) < 0) {
            n11 = (int)(this.h ? 1 : 0);
            if (n11 == 0 && n10) {
                n10 = 0;
                defaultAllocator = null;
            } else {
                n10 = n12;
            }
            this.l = n10;
        } else {
            l12 = this.d;
            long l14 = l11 - l12;
            n11 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n11 >= 0 || n10) {
                this.l = false;
            }
        }
        n10 = (int)(this.l ? 1 : 0);
        if (!n10 || !(n10 = (int)(this.n ? 1 : 0))) {
            n12 = 0;
        }
        return n12;
    }

    public boolean shouldStartPlayback(long l10, float f10, boolean bl2, long l11) {
        int n10;
        DefaultAllocator defaultAllocator;
        int n11;
        l10 = Util.getPlayoutDurationForMediaDuration(l10, f10);
        long l12 = bl2 ? this.f : this.e;
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0 && (n11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) < 0 && ((n11 = (int)(this.h ? 1 : 0)) != 0 || (n11 = (defaultAllocator = this.a).getTotalBytesAllocated()) < (n10 = this.k))) {
            n11 = 0;
            defaultAllocator = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }
}

