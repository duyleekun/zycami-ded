/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

public final class SystemReporter$SystemInfo {
    public String brand;
    public String manufacturer;
    public String model;
    public int osAPILevel;
    public String osCodeName;
    public boolean runOnEmulator;

    public String getBrand() {
        return this.brand;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getOsAPILevel() {
        return this.osAPILevel;
    }

    public String getOsCodeName() {
        return this.osCodeName;
    }

    public boolean isRunOnEmulator() {
        return this.runOnEmulator;
    }

    public void setBrand(String string2) {
        this.brand = string2;
    }

    public void setManufacturer(String string2) {
        this.manufacturer = string2;
    }

    public void setModel(String string2) {
        this.model = string2;
    }

    public void setOsAPILevel(int n10) {
        this.osAPILevel = n10;
    }

    public void setOsCodeName(String string2) {
        this.osCodeName = string2;
    }

    public void setRunOnEmulator(boolean bl2) {
        this.runOnEmulator = bl2;
    }
}

