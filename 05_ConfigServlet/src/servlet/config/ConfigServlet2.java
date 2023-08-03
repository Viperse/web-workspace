package servlet.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigServlet2
 */
public class ConfigServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path;

	
	public void init(ServletConfig config) throws ServletException {
		// 1. ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다.
		// 2. BufferedReader, FileReader를 사용해서 파일을 읽어들인다.
		// 3. count값으로 필드 초기화				
		try {		
			path = config.getInitParameter("path");
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			count = Integer.parseInt(str);
			br.close();
			
			System.out.println("config2.txt 파일의 내용을 읽어들임... count ::" + count);			
		} catch (IOException e) {
			System.out.println("파일 읽어오기 실패");
		}
	}

	public void destroy() {
		// 4. PrintWriter, FileWriter 사용해서 count 값 저장
		File file = new File(path);
		file.getParentFile().mkdirs();
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			pw.close();
			System.out.println(path + "count 값 :: " + count + "파일에 영구적으로 저장");
			
		} catch (IOException e) {
			System.out.println("스트림 생성 실패");
		}
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 5. 폼에 입력된 값을 받아서 ~~ 님은 ~~ 몇 번째 입장하신 고객입니다...
		// 를 브라우저로 출력 (이때 출력은 config2.jsp에서)
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("userName");
		
		out.println("<a href=config2.jsp?userName=" + name + "&count=" + ++count + ">config2.jsp로 이동</a>");
	}

}
