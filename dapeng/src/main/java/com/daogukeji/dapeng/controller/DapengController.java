package com.daogukeji.dapeng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daogukeji.dapeng.entity.Dapeng_1;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_DiGuan;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_JuanLian;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Led;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Paifeng;
import com.daogukeji.dapeng.entity.Dapeng_1_Order_Voice;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_DiGuan;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_JuanLian;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_Led;
import com.daogukeji.dapeng.entity.Dapeng_1_Status_Paifeng;
import com.daogukeji.dapeng.service.DapengService;
import com.daogukeji.dapeng.service.OrderService;
import com.daogukeji.dapeng.service.Order_DiGuanService;
import com.daogukeji.dapeng.service.Order_JuanLianService;
import com.daogukeji.dapeng.service.Order_LedService;
import com.daogukeji.dapeng.service.Order_VoiceService;
import com.daogukeji.dapeng.service.Status_dg_Service;
import com.daogukeji.dapeng.service.Status_jl_Service;
import com.daogukeji.dapeng.service.Status_led_Service;
import com.daogukeji.dapeng.service.Status_pf_Service;

/**
 * ���������
 * @author Administrator
 *
 */
@Controller//前端控制器注解
//@RequestMapping("/save")//映射ַ
public class DapengController {
	@Resource//依赖注入注解 传感器服务层注入进来
	private DapengService dapengService;
	@Resource//依赖注入注解 排风开关命令服务层注入进来
	private OrderService orderService;
	@Resource//依赖注入注解 排风开关实时状态显示服务层注入进来
	private Status_pf_Service status_pf_Service;
	@Resource//依赖注入注解 排风开关实时状态显示服务层注入进来
	private Status_led_Service status_led_Service;
	@Resource//依赖注入注解 生长灯实时状态显示服务层注入进来
	private Status_dg_Service status_dg_Service;
	@Resource//依赖注入注解 滴灌开关实时状态显示服务层注入进来
	private Status_jl_Service status_jl_Service;
	@Resource//依赖注入注解 卷帘机命令服务层注入进来
	private Order_VoiceService order_VoiceService;
	@Resource//依赖注入注解 卷帘机命令服务层注入进来
	private Order_JuanLianService order_JuanLianService;
	@Resource//依赖注入注解 生长灯命令服务层注入进来
	private Order_LedService order_LedService;
	@Resource//依赖注入注解 滴灌命令服务层注入进来
	private Order_DiGuanService order_DiGuanService;
	
	@RequestMapping("/saveInfo")//上传传感器数据到服务器
		public Dapeng_1 save(String tem1,String tem2,String sun,String soil1,String soil2){
			Dapeng_1 dp_1 = dapengService.save(tem1, tem2, sun, soil1, soil2);
			
			return dp_1;
		}
	
	@RequestMapping("/findAll")//从服务器读取传感器数据
		public void findAll(HttpServletResponse response) throws IOException{
			Dapeng_1 da_1 = dapengService.findAll();
			
			PrintWriter writer = response.getWriter();
			writer.write(new JSONObject(da_1).toString());
			writer.flush();
			//return da_1;
	}
	
	@RequestMapping("/addOrder")//发送排风指令到服务器
		public Dapeng_1_Order_Paifeng addOrder(String zhiling){
			Dapeng_1_Order_Paifeng dp_1_o_pf = orderService.addOrder(zhiling);
			
			return dp_1_o_pf;
	}
	
	@RequestMapping("/findOrder")//从服务器读取排风指令
		public void findOrder(HttpServletResponse response) throws IOException{
		Dapeng_1_Order_Paifeng dp_1_o_pf = orderService.findOrder();
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_o_pf).toString());
		writer.flush();
		//return dp_1_o_pf;
	}
	
	@RequestMapping("/addStatus_pf")//发送排风状态到服务器
		public Dapeng_1_Status_Paifeng addStatus_pf(String state_pf,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		Dapeng_1_Status_Paifeng dp_1_s_pf = status_pf_Service.addStatus_pf(new String(state_pf.getBytes("iso-8859-1"),"utf-8"));
		return dp_1_s_pf;
	}
	
	@RequestMapping("/findStatus_pf")//从服务器读取排风状态
		public void findStatus_pf(HttpServletResponse response)throws IOException{
		Dapeng_1_Status_Paifeng dp_1_s_pf = status_pf_Service.findStatus_pf();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_s_pf).toString());
		writer.flush();
	}
	
	@RequestMapping("/addStatus_led")//发送排风状态到服务器
		public Dapeng_1_Status_Led addStatus_led(String state_led,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		Dapeng_1_Status_Led dp_1_s_led = status_led_Service.addStatus_led(new String(state_led.getBytes("iso-8859-1"),"utf-8"));
		return dp_1_s_led;
	}
	
	@RequestMapping("/findStatus_led")//从服务器读取排风状态
		public void findStatus_led(HttpServletResponse response)throws IOException{
		Dapeng_1_Status_Led dp_1_s_led = status_led_Service.findStatus_led();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_s_led).toString());
		writer.flush();
	}
	@RequestMapping("/addStatus_dg")//发送排风状态到服务器
		public Dapeng_1_Status_DiGuan addStatus_dg(String state_diguan,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		Dapeng_1_Status_DiGuan dp_1_s_dg = status_dg_Service.addStatus_dg(new String(state_diguan.getBytes("iso-8859-1"),"utf-8"));
		return dp_1_s_dg;
		}
	
	@RequestMapping("/findStatus_dg")//从服务器读取排风状态
		public void findStatus_dg(HttpServletResponse response)throws IOException{
		Dapeng_1_Status_DiGuan dp_1_s_dg = status_dg_Service.findStatus_dg();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_s_dg).toString());
		writer.flush();
		}
	@RequestMapping("/addStatus_jl")//发送排风状态到服务器
		public Dapeng_1_Status_JuanLian addStatus_jl(String state_juanlian,HttpServletRequest request) throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		Dapeng_1_Status_JuanLian dp_1_s_jl = status_jl_Service.addStatus_jl(new String(state_juanlian.getBytes("iso-8859-1"),"utf-8"));
		return dp_1_s_jl;
		}
	
	@RequestMapping("/findStatus_jl")//从服务器读取排风状态
		public void findStatus_jl(HttpServletResponse response)throws IOException{
		Dapeng_1_Status_JuanLian dp_1_s_jl = status_jl_Service.findStatus_jl();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_s_jl).toString());
		writer.flush();
		}
	
	@RequestMapping("/addOrder_Voice")//发送喇叭指令到服务器
		public Dapeng_1_Order_Voice addOrder_Voice(String voice){
		Dapeng_1_Order_Voice dp_1_o_v = order_VoiceService.addOrder_Voice(voice);
		return dp_1_o_v;
	}
	
	@RequestMapping("/findOrder_Voice")//从服务器读取喇叭指令
		public void findOrder_Voice(HttpServletResponse response)throws IOException{
		Dapeng_1_Order_Voice dp_1_o_v = order_VoiceService.findOrder_Voice();
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_o_v).toString());
		writer.flush();
	}
	
	@RequestMapping("/addOrder_JuanLian")//发送卷帘机命令到服务器
		public Dapeng_1_Order_JuanLian addOrder_JuanLian(String juanlian){
		Dapeng_1_Order_JuanLian dp_1_o_jl = order_JuanLianService.addOrder_JuanLian(juanlian);
		return dp_1_o_jl;
	}

	@RequestMapping("/findOrder_JuanLian")//从服务器读取卷帘机指令
		public void findOrder_JuanLian(HttpServletResponse response)throws IOException{
		Dapeng_1_Order_JuanLian dp_1_o_jl = order_JuanLianService.findOrder_JuanLian();
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_o_jl).toString());
		writer.flush();
	}
	
	@RequestMapping("/addOrder_Led")//发送生长灯命令到服务器
		public Dapeng_1_Order_Led addOrder_Led(String led){
		Dapeng_1_Order_Led dp_1_o_l = order_LedService.addOrder_Led(led);
		return dp_1_o_l;
	}
	
	@RequestMapping("/findOrder_Led")//从服务器读取生长灯指令
		public void findOrder_Led(HttpServletResponse response)throws IOException{
		Dapeng_1_Order_Led dp_1_o_l = order_LedService.findOrder_Led();
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_o_l).toString());
		writer.flush();
	}
	
	@RequestMapping("/addOrder_DiGuan")//发送滴灌指令到服务器
		public Dapeng_1_Order_DiGuan addOrder_DiGuan(String diguan){
		Dapeng_1_Order_DiGuan dp_1_o_dg = order_DiGuanService.addOrder_DiGuan(diguan);
		return dp_1_o_dg;
	}
	
	@RequestMapping("/findOrder_DiGuan")//从服务器读取滴灌指令
		public void findOrder_DiGuan(HttpServletResponse response)throws IOException{
		Dapeng_1_Order_DiGuan dp_1_o_dg = order_DiGuanService.findOrder_DiGuan();
		PrintWriter writer = response.getWriter();
		writer.write(new JSONObject(dp_1_o_dg).toString());
		writer.flush();
	}
}







