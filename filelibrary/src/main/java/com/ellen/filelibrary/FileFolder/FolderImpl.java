package com.ellen.filelibrary.FileFolder;

import java.io.File;

/**
 * 文件夹
 */
public class FolderImpl implements Folder{

    /**
     * 文件夹路径
     */
    private String folderPath;

    public FolderImpl(String path){
        if (!checkIsFolder(path)) {
           //不是文件夹
            if(checkIsFile(path)){
                //是文件
            }else {
                //该目录不存在
            }
        }
        this.folderPath = path;
    }

    public FolderImpl(String fatherPath,String name){
        File file = new File(fatherPath,name);
        if(!checkIsFolder(file.getAbsolutePath())){
            //不是文件夹
            if(checkIsFile(file.getAbsolutePath())){
                //是文件
            }else {
                //该目录不存在
            }
        }
        this.folderPath = file.getAbsolutePath();
    }

    @Override
    public boolean isExist() {
        return new File(folderPath).exists();
    }

    @Override
    public boolean checkIsFolder(String path) {
        File file = new File(path);
        return file.exists() && file.isDirectory();
    }

    @Override
    public boolean checkIsFile(String path) {
        File file = new File(path);
        return file.exists() && file.isFile();
    }

    @Override
    public int getRootAllFileCount() {
        File file = new File(folderPath);
        return file.listFiles().length;
    }

    @Override
    public int getRootFolderCount() {
        File file = new File(folderPath);
        File[] files = file.listFiles();
        int folderCount = 0;
        for(File f:files){
            if(f.isDirectory()){
                folderCount++;
            }
        }
        return folderCount;
    }

    @Override
    public int getRootFileCount() {
        File file = new File(folderPath);
        File[] files = file.listFiles();
        int fileCount = 0;
        for(File f:files){
            if(f.isFile()){
                fileCount++;
            }
        }
        return fileCount;
    }

    @Override
    public File getFileByName(String name) {
        File file = new File(folderPath,name);
        if(file.exists()){
            if(file.isFile()) {
                return file;
            }else {
                //是文件夹抛出异常
                return null;
            }
        }else {
            //抛出异常
            return null;
        }
    }

    @Override
    public FolderImpl getFolderByName(String folderName) {
        FolderImpl folder = new FolderImpl(folderPath,folderName);
        return folder;
    }

    @Override
    public File getFileByFolder() {
        return new File(folderPath);
    }
}
