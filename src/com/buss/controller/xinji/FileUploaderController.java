package com.buss.controller.xinji;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import jodd.util.StringUtil;

/**   
 * @Title: Controller
 * @Description: 文件上传类
 * @author liliming
 * @date 2016-03-25 00:35:39
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/fileUploaderController")
public class FileUploaderController extends BaseController {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(FileUploaderController.class);

  @Autowired
  private SystemService systemService;
  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  /**
   * 上传文件, 返回文件的保存相对路径，多个则以|分隔
   * fileUploaderController.do?upload&folder=xxx
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(params = "upload", method = RequestMethod.POST)
  @ResponseBody
  public String upload(MultipartHttpServletRequest request, HttpServletResponse response, String folder) {
    //1. build an iterator
    Iterator<String> itr = request.getFileNames();
    MultipartFile mpf = null;
    String filepaths = "";

    //2. get each file
    while (itr.hasNext()) {

      //2.1 get next MultipartFile
      mpf = request.getFile(itr.next());

      //2.2 file save path
      String path ="upload/"+folder+"/";
      String relatePath = "";

      try {
        String realPath = request.getSession().getServletContext().getRealPath("/") + "/" + path ;// 文件的硬盘真实路径
        String savePath = realPath + mpf.getOriginalFilename();// 文件保存全路径
        relatePath = path + mpf.getOriginalFilename();// 文件保存相对路径
        
        // copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
        FileCopyUtils.copy(mpf.getBytes(),new File(savePath));

      } catch (IOException e) {
        e.printStackTrace();
      }
      //2.3 add to filepaths
      if(StringUtil.isEmpty(filepaths)) {
        filepaths = relatePath;
      } else {
        filepaths = filepaths + "|" + relatePath;
      }

    }

    // result will be like this
    // a.png|b.jpg...
    System.out.println("============ filepaths:"+filepaths);
    return filepaths;
  }
  
}
