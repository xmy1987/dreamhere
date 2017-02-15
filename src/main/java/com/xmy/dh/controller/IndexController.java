package com.xmy.dh.controller;

import com.xmy.dh.service.store.FileStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qinyong on 2017/2/15.
 */
@RestController
@RequestMapping("/dh")
public class IndexController {


    @Autowired
    private FileStoreService fileStoreService;

    @RequestMapping("/index")
    String index() {

        return "hello world";
    }

    @RequestMapping("/upload")
    String uploadFile(){
		String storePath = "/blockingQueue.png";
		String localPath = "C:/Users/qinyong/Desktop/BlockingQueue-uml.png";
		String res = fileStoreService.uploadFile(storePath, localPath);
		System.out.println("res="+res);
        return res;
    }

}
