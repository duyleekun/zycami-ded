/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

public final class RendererConfiguration {
    public static final RendererConfiguration DEFAULT;
    public final boolean tunneling;

    static {
        RendererConfiguration rendererConfiguration;
        DEFAULT = rendererConfiguration = new RendererConfiguration(false);
    }

    public RendererConfiguration(boolean bl2) {
        this.tunneling = bl2;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<RendererConfiguration> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = RendererConfiguration.class) == (clazz = object.getClass())) {
            object = (RendererConfiguration)object;
            boolean bl3 = this.tunneling;
            boolean bl4 = ((RendererConfiguration)object).tunneling;
            if (bl3 != bl4) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        return this.tunneling ^ 1;
    }
}

