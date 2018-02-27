package src.com.baizhi.manager.util.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FIleTrasfer {
	
	@SuppressWarnings("deprecation")
	public static String fileTrtans(HttpServletRequest req,MultipartFile file){
		System.out.println(file);
		
		if(file!=null){
		//拿到当前请求的协议
		String scheme = req.getScheme();
		//拿到当前请求的服务器ip
		String serverName = req.getServerName();
		//拿到当前请求的端口号
		int serverPort = req.getServerPort();
		//文件的原始文件名
		String filename = file.getOriginalFilename();
		//拿到项目路径
		String realPath = req.getRealPath("");
		//创建一个文件对象
		File path = new File(realPath);
		//拿到webapps的上级目录
		String imgPath = path.getParent();
		//创建放置资源的文件夹
		File imgs = new File (imgPath+"/images");
		//保证只创建一次目录，进行判断
		if(!imgs.exists()){
			
			imgs.mkdirs();
		}
		//对原始文件名进行处理防止重名覆盖
		filename=UUID.randomUUID().toString().replace("-", "")
		+new Date().getTime()+filename.substring(filename.lastIndexOf("."));
		//拼接需要放入数据库的文件的真实网络路径
		String lastName=scheme+"://"+serverName+":"+serverPort+"/images/"+filename;
		//把文件上传到指定目录
		try {
			file.transferTo(new File(imgPath+"/images/"+filename));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lastName;
		
		}
		return "";
	}
		
}
