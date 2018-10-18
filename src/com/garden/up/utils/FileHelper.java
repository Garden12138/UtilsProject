package com.garden.up.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件工具类
 * Created by Garden on 2018/10/11.
 */
public class FileHelper {

    @Autowired
    private ConfigureBean configureBean;

    public static InputStream getInputStream(HttpServletRequest request, String requestFileName) throws IOException {
        // TODO Auto-generated method stub
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile(requestFileName);
        return multipartFile.getInputStream();
    }

    public static String getFileFinalName(HttpServletRequest request, String requestFileName) {
        // TODO Auto-generated method stub
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile(requestFileName);
        String originalFileName = multipartFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.indexOf("."));
    }

    public static String generateLocalFile(HttpServletRequest request, String requestFileName){
        InputStream inputStream = null;
        try {
            inputStream = getInputStream(request,requestFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileFinalName = getFileFinalName(request,requestFileName);
        // TODO Auto-generated method stub
        byte[] data = new byte[1024];
        int len = 0;
        FileOutputStream fileOutputStream = null;
        String fileName = requestFileName + System.currentTimeMillis() + fileFinalName;
        try {
            fileOutputStream = new FileOutputStream(configureBean.getAvatarUploadPath()+fileName);
            while ((len = inputStream.read(data)) != -1){
                fileOutputStream.write(data, 0, len);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            logger.error(e);
            return null;
        } finally {
            if(null != inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                    return null;
                }
            }
            if(null != fileOutputStream){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    logger.error(e);
                    return null;
                }
            }
        }
        return fileName;
    }
}
