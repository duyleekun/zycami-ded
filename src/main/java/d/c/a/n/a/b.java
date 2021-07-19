/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.n.a;

import com.bumptech.glide.integration.webp.WebpFrame;

public class b {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;

    public b(int n10, WebpFrame webpFrame) {
        this.a = n10;
        this.b = n10 = webpFrame.getXOffest();
        this.c = n10 = webpFrame.getYOffest();
        this.d = n10 = webpFrame.getWidth();
        this.e = n10 = webpFrame.getHeight();
        this.f = n10 = webpFrame.getDurationMs();
        n10 = (int)(webpFrame.isBlendWithPreviousFrame() ? 1 : 0);
        this.g = n10;
        n10 = (int)(webpFrame.shouldDisposeToBackgroundColor() ? 1 : 0);
        this.h = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("frameNumber=");
        int bl2 = this.a;
        stringBuilder.append(bl2);
        stringBuilder.append(", xOffset=");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", yOffset=");
        int n11 = this.c;
        stringBuilder.append(n11);
        stringBuilder.append(", width=");
        int n12 = this.d;
        stringBuilder.append(n12);
        stringBuilder.append(", height=");
        int n13 = this.e;
        stringBuilder.append(n13);
        stringBuilder.append(", duration=");
        int n14 = this.f;
        stringBuilder.append(n14);
        stringBuilder.append(", blendPreviousFrame=");
        boolean bl3 = this.g;
        stringBuilder.append(bl3);
        stringBuilder.append(", disposeBackgroundColor=");
        boolean bl4 = this.h;
        stringBuilder.append(bl4);
        return stringBuilder.toString();
    }
}

