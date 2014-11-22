package com.vendas.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

public class Upload {

    public Upload() {  
    }  
  
      
    public boolean anexos(HttpServletRequest request, HttpServletResponse response) throws Exception {  
  
       // if (ServletFileUpload.isMultipartContent(request)) {  
  
            int cont = 0;  
  
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());  
  
            List fileItemsList = null;  
  
            try {  
                fileItemsList = servletFileUpload.parseRequest((RequestContext) request);  
            } catch (FileUploadException e) {  
                e.printStackTrace();  
            }  
  
            String optionalFileName = "";  
            FileItem fileItem = null;  
  
            Iterator it = fileItemsList.iterator();  
  
            do {  
  
                cont++;  
  
                FileItem fileItemTemp = (FileItem) it.next();  
  
                if (fileItemTemp.isFormField()) {  
                    if (fileItemTemp.getFieldName().equals("logo_foto")) {  
                        optionalFileName = fileItemTemp.getString();  
                    }  
                } else {  
                    fileItem = fileItemTemp;  
                }  
  
                if (cont != (fileItemsList.size())) {  
                    if (fileItem != null) {  
  
                        String fileName = fileItem.getName();  
                          
  
                        if (fileItem.getSize() > 0) {  
  
                            if (optionalFileName.trim().equals("")) {  
                                fileName = fileName + "878787878";  
                            } else {  
                                fileName = optionalFileName;  
                            }  
  
                            String dirName = "/home/gisomar/git/projetojavaweb/ProjetoVendasWebEE/WebContent/Loja/logo"; //caminho para o projeto  
  
                            File saveTo = new File(dirName + fileName);  
                            System.out.println("caminho: " + saveTo.toString() );  
                            try {  
                                fileItem.write(saveTo);  
                            } catch (Exception e) {  
                            }  
  
                        }  
                    }  
                }  
            } while (it.hasNext());  
            return true;  
        
    }  
}  