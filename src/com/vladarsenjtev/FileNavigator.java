package com.vladarsenjtev;

import java.util.*;

public class FileNavigator {
    private final Map<PathKey, List> fileData = new HashMap<>();


    public void add(String dataPath, String name, int size, String path) {
        PathKey pathKey = new PathKey(dataPath);
        FileData fileDataAr = new FileData(name, size, path);
        if (!dataPath.equals(path)) {
            throw new RuntimeException("Путь-ключ и путь к файлу не совпадают");
        }

        if (fileData.containsKey(pathKey)) {
            fileData.get(pathKey).add(fileDataAr);
        } else {
            List<FileData> fileDataList = new ArrayList<>();
            fileDataList.add(fileDataAr);
            fileData.put(pathKey, fileDataList);
        }
    }

    public Map<PathKey, List> getFileData() {
        return fileData;
    }

    public List<FileData> find(String str) {
        PathKey pathKey = new PathKey(str);
        return fileData.get(pathKey);
    }

    public List<FileData> filterBySize(int size) {
        List<FileData> filteredFiles = new ArrayList<>();

        for (List<FileData> batchOfFiles : fileData.values()) {
            for (FileData file : batchOfFiles) {
                if (file.getSize() <= size) {
                    filteredFiles.add(file);
                }
            }

        }
        return filteredFiles;
    }

    public void remove(String str) {
        PathKey pathKey = new PathKey(str);
        fileData.remove(pathKey);
    }

    public FileNavigator() {
    }

    public void sortBySize() {

        Set<FileData> fileDataSet = new TreeSet<>(new Comparator<FileData>() {
            @Override
            public int compare(FileData o1, FileData o2) {
                return o1.getSize() - o2.getSize();
            }
        });
        for (List<FileData> batchOfFiles : fileData.values()) {
            for (FileData file : batchOfFiles) {
                fileDataSet.add(file);
            }
        }
        for (FileData file : fileDataSet) {
            System.out.println(file);
        }
    }

    public void checkAdd(FileData file, PathKey pathKey) {
        if (!file.getPath().equals(fileData.get(pathKey))) {
            throw new RuntimeException("Путь-ключ и путь к файлу не совпадают");
        }
    }
}