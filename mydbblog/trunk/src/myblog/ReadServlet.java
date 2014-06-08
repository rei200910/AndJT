package myblog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 訂閱文章的Servlet 
 */

public class ReadServlet extends HttpServlet{
	
		

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3968455042537261721L;

	protected void doGet(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {

	        perform(request, response);
	    }

	    protected void doPost(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {

	        perform(request, response);
	    }

	    protected void perform(HttpServletRequest request,
	            HttpServletResponse response)
	            throws ServletException, IOException {

	        BlogController ctrl = BlogController.getInstance();
	        List<Topic> topics = ctrl.getTopics();

	        request.setAttribute("topics", topics);

	        request.getRequestDispatcher("/read.jsp")
	        	.forward(request, response);

	    }
}
