package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Exception.UserExistsException;
import Service.impl.AdminService;
import entity.Admin;

import utils.WebUtils2;


/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet1")
public class AdminServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 AdminService adminService=new AdminService();
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public AdminServlet1() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String method = request.getParameter("method");
			if ("register".equals(method)) {
				register(request,response);
			}
		}
		
		private void register(HttpServletRequest request,
				HttpServletResponse response) throws IOException, ServletException {
			

	
			Admin admin=WebUtils2.copyToBean(request, Admin.class);
			System.out.println(admin);
			//2. 调用Service处理注册的业务逻辑
			try {
				adminService.register(admin);
				System.out.println("已经成功保存");
				
				// 注册成功，跳转到首页
				request.getRequestDispatcher("/successful.jsp").forward(request, response);
				
			} catch (UserExistsException e) {
				// 用户名存在，注册失败(跳转到注册页面)
				request.setAttribute("message", "用户名已经存在");
				// 转发
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();  // 测试时候用
				// 其他错误, 跳转到错误页面
				response.sendRedirect(request.getContextPath() + "/error/error.jsp");
			}
		}


		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
