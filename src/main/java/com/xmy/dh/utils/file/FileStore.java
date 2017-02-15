package com.xmy.dh.utils.file;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.request.UploadFileRequest;

/**
 * Created by qinyong on 2017/2/15.
 */
public class FileStore {

    private COSClient cosClient;

    private StoreConfig storeConfig;

    private FileStore(StoreConfig storeConfig){
        this.storeConfig = storeConfig;
        cosClient = new COSClient(this.storeConfig.appId,this.storeConfig.secretId,this.storeConfig.secretKey);
    }

    public static FileStore getInstance(StoreConfig storeConfig){
        return new FileStore(storeConfig);
    }

    public String uploadFile(String storePath,String localFilePath){
        UploadFileRequest uploadFileRequest = new UploadFileRequest(this.storeConfig.bucketName, storePath, localFilePath);
        String res =  cosClient.uploadFile(uploadFileRequest);
        return res;
    }


    public void shutdown() {
        cosClient.shutdown();
    }
}
