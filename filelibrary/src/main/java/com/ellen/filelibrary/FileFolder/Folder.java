package com.ellen.filelibrary.FileFolder;

import java.io.File;

public interface Folder {
    /**
     * 是否存在
     * @return
     */
    boolean isExist();

    /**
     * 检测是否为文件夹
     * @return
     */
    boolean checkIsFolder(String path);

    /**
     * 检测是否为文件夹
     * @return
     */
    boolean checkIsFile(String path);

    /**
     * 获取根目录下文件总个数
     * @return
     */
    int getRootAllFileCount();

    /**
     * 获取根目录下文件夹个数
     * @return
     */
    int getRootFolderCount();

    /**
     * 获取根目录下文件的个数
     * @return
     */
    int getRootFileCount();

    File getFileByName(String name);

    FolderImpl  getFolderByName(String folderName);

    File getFileByFolder();
}
