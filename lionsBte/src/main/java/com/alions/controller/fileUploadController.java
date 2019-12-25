package java.alions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RequestMapping("/upload")
public class fileUploadController {
    @RequestMapping("/uploadMultipartFile")
    public ModelAndView uploadMutipartFile(MultipartFile file){
        ModelAndView mv = new ModelAndView();
        mv.setView(new MappingJackson2JsonView());

        //获取上传的文件名
        String fileName = file.getOriginalFilename();
        file.getContentType();

        //目标文件
        try {
            File dest = new File(fileName);
            file.transferTo(dest);
            mv.addObject("success", true);
            mv.addObject("msg", "上传成功");
        } catch (IOException e) {
            e.printStackTrace();
            mv.addObject("success", false);
            mv.addObject("msg", "上传失败");
        }
        return mv;
    }

//    @RequestMapping("uploadPart")
//    public ModelAndView uploadPart(Part file){
//        ModelAndView mv = new ModelAndView();
//        mv.setView(new MappingJackson2JsonView());
//
//        //获取上传的文件名
//        String fileName = file.getSubmittedFileName();
//        File desc = new File(fileName);
//        try{
//            file.write("e:/mvc/upload" + fileName);
//            mv.addObject("success", true);
//            mv.addObject("msg", "上传成功");
//        }catch (Exception e){
//            mv.addObject("success", true);
//            mv.addObject("msg", "上传成功");
//        }
//        return mv;
//    }


     /**
      * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("fileUpload2")
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
        String path="E:/"+new Date().getTime()+file.getOriginalFilename();

        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "/success";
    }
}
