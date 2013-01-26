package com.bigdata.mongodb.service;

import java.io.File;

public interface DataLoader {
    public void loadData(File dataFile);

    public long getTotalCount(String candidateName);

    public long getTotalCount();
}
