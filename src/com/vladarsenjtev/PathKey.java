package com.vladarsenjtev;

import java.util.Objects;

public class PathKey {
    private String dataPath;

    public PathKey(String dataPath) {
        this.dataPath = dataPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PathKey pathKey = (PathKey) o;
        return Objects.equals(dataPath, pathKey.dataPath);
    }

    public String getDataPath() {
        return dataPath;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataPath);
    }

    @Override
    public String toString() {
        return "PathKey{" +
                "dataPath='" + dataPath + '\'' +
                '}';
    }
}
