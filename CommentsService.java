package cs.dit.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentsService {

	CommentsDao dao = new CommentsDao();
	
	public void listComments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException	{
		
		int bcode = Integer.parseInt(request, getParameter("bcode"));
		response.setContentType("application/x-json;charset=utf-8");
		JSONArray list = new JSONArray();
		
		list= dao.listComments(bcode);
		response.getWriter().print(list);
	}
	
	public void insertComments(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bcode = Integer.parseInt(request.getParameter("bcode"));
		
		String comments = request.getParameter("commeents");
		
		CommentsDto dto = new CommentsDto(0, 0, bcode, comments, null);
		
		dao.insertComments(dto);
	}
}
