package com.example.LLD.entity.panel.impl;

import com.example.LLD.entity.panel.intf.Panel;

public abstract class AbstractPanel implements Panel {
    private final int panelNumber;

    public AbstractPanel(int panelNumber){
        this.panelNumber = panelNumber;
    }
    @Override
    public int getPanelNumber() {
        return 0;
    }
}
