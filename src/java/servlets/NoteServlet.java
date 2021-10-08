package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

public class NoteServlet extends HttpServlet {

    Note newNote;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String edit = request.getParameter("edit");

        if (edit != null) {
            
            request.setAttribute("note", newNote);
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            return;
        }

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        Scanner fileIn = new Scanner(new File(path));

        String title = fileIn.nextLine();
        String content = fileIn.nextLine();

        newNote = new Note(title, content);

        request.setAttribute("note", newNote);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = "";
        
        title = request.getParameter("editTitle");
        StringBuffer content = new StringBuffer(request.getParameter("editContent"));
        
        int location = (new String(content).indexOf('\n'));
        
        while(location > 0) {
            content.replace(location, location + 1, "<BR>");
            location = (new String(content)).indexOf('\n');
        }
        
        String msg = content.toString();
        
        newNote = new Note(title, msg);
        
        request.setAttribute("note", newNote);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
        
    }

}
