package src.com.baizhi.manager.controller;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.enterprise.inject.spi.Producer;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validateCode")

public class KaptchaController {

	//声明kaptcha对象；面向接口编程
	@Autowired
	private Producer producer;
	
	@RequestMapping("/code")
	public void getKaptcha(HttpSession session,HttpServletResponse response) throws IOException{
		
		
		//通过kaptcha工具生成一张图片
			//1.需要有一个Kaptcha对象；声明成员变量；通过自动装配完成赋值
			//2.通过kaptcha对象的方法，可以得到随机字符串
			//3.把生成的字符串放置在session作用域中 ==>session.setAttribute("kaptcha","生成的字符串")
			//4.通过kaptcha对象的方法，可以把字符串生成一张图片
		
		//生成一个随机字符串
		String kaptcha = producer.createText();
		
		//把生成的字符串放置在session作用域中
		session.setAttribute("code", kaptcha);
		
		//把生成的字符串放入到图片中；使用生成的字符串生成一张图片
		BufferedImage image = producer.createImage(kaptcha);
		
		
		//把一张图片响应给客户端（jsp）
			//1.需要一个响应对象；在方法形参中声明HttpServletResponse
			//2.让response能响应一张图片到客户端
		
		//把image这个图片，以jpg的格式写入到响应输出流===》把image这个图片，以jpg的格式给客户端响应
		ImageIO.write(image, "jpg", response.getOutputStream());
		
	}
}
