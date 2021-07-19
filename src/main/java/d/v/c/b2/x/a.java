/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b2.x;

public interface a {
    default public float a() {
        float f10 = this.getTimeMinimum();
        float f11 = this.getLengthMinimum();
        return f10 / f11;
    }

    default public float b() {
        float f10 = this.getLengthMinimum();
        float f11 = this.getTimeMinimum();
        return f10 / f11;
    }

    default public int c() {
        float f10 = this.b();
        float f11 = this.getTotalTime();
        return (int)(f10 * f11);
    }

    public float getLengthMinimum();

    public long getTimeMinimum();

    public long getTotalTime();
}

