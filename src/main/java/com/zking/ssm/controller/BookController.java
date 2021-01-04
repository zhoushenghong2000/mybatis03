package com.zking.ssm.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.ssm.model.Book;
import com.zking.ssm.model.MyFile;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.service.IFileService;
import com.zking.ssm.utils.PageBean;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("Book")
public class BookController {
    //到spring上下文拿到bookdao方法
    @Autowired
    private IBookService bookService;
    private Book book = new Book();

    //拿到图片表
    @Autowired
   private  IFileService iFileService;

    @RequestMapping("books")
    public String list(Model model, HttpServletRequest request, Book book){
          PageBean pageBean = new PageBean();
            pageBean.setRequest(request);
           int n =pageBean.getNextPage();
           int nt = pageBean.getPreivousPage();
        //设置分页处理
      /*  if (null != pageBean && pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getStartIndex(), pageBean.getRows());
        }*/
        //调用查询所有书本的方法
        List<Book> books = bookService.listBooks(book);
        PageInfo pageInfo = new PageInfo(books);

        //设置分页处理
        model.addAttribute("books",books);
       /* model.addAttribute("pageInfo",pageInfo);*/
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("n",n);
        model.addAttribute("nt",nt);
        return "book/BookList";
    }

    @RequestMapping("edit")
    public String edit(Model model, Book book){
        int n =-1;
        if(book.getBookId()!=null){
            n=bookService.updateByPrimaryKey(book);
        }else{
            n=bookService.insert(book);
        }
        if(n>0){
            return "redirect:books";
        }
       return "book/Edit";
    }







    @RequestMapping("/Edit")
    public String toadd(){
        return "/book/Edit";
    }

    @RequestMapping("load")
    public String load(Model model, Book book){
        Book book1 = bookService.selectByPrimaryKey(book);
        model.addAttribute("book1",book1);
        return "book/Edit";
    }

    @RequestMapping("del")
    public String delete(Integer bookId){
        int i = bookService.deleteByPrimaryKey(bookId);
            return "redirect:books";
    }




    @RequestMapping("/doupload")
    public String doUpload(Book book,MultipartFile fname){
        MyFile myFile = new MyFile();
        myFile.setFileId(System.currentTimeMillis());
        String originalFilename = fname.getOriginalFilename();
        //图片名字
        myFile.setRealName(originalFilename);
        //图片类型
        myFile.setContentType(fname.getContentType());
        File file=new File("E:\\img2\\"+originalFilename);
        try {
            //文件上传关键代码
            fname.transferTo(file);
            //图片表需要新增
            int n =iFileService.insert(myFile);
            if(n>0){
                //书本表需要修改bookImage
                System.out.println(myFile.getFileId());
               book.setBookImage(myFile.getFileId());
                bookService.updateByPrimaryKeySelective(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:books";
    }


    @RequestMapping("fileupload")
    public String fileupload(){
        return "/fileupload";
    }



   @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(Long bookImage) {
        //根据图片编号找到所有的信息
      MyFile myFile= iFileService.selectByPrimaryKey(bookImage);
       //下载关键代码
       try {
           File file = new File("E:\\img2\\"+ myFile.getRealName());
           HttpHeaders headers = new HttpHeaders();//http头信息fileName
           String downloadFileName = new String(myFile.getRealName().getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);//设置编码
           headers.setContentDispositionFormData("attachment", downloadFileName);
           headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
           //MediaType:互联网媒介类型  contentType：具体请求中的媒体类型信息
           return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }

   }














}
