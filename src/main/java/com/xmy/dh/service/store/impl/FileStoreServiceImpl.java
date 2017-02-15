package com.xmy.dh.service.store.impl;

import com.xmy.dh.utils.file.FileStore;
import com.xmy.dh.service.store.FileStoreService;
import com.xmy.dh.utils.file.StoreConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qinyong on 2017/2/15.
 */
@Service
public class FileStoreServiceImpl implements FileStoreService{

    @Autowired
    private StoreConfig storeConfig;

    @Override
    public String uploadFile(String storePath, String localFilePath) {
        FileStore fileStore = FileStore.getInstance(storeConfig);
        String res =  fileStore.uploadFile(storePath, localFilePath);
        return res;
    }

}
