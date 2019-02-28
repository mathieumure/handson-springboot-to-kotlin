package org.zenika.fetcher;

import java.util.Map;

public class Type {

    private int slot;

    private Map<String, String> type;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Map<String, String> getType() {
        return type;
    }

    public void setType(Map<String, String> type) {
        this.type = type;
    }
}
