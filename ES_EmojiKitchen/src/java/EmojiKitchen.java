
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
@WebServlet(urlPatterns = {"/EmojiKitchen"})
public class EmojiKitchen extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          try (PrintWriter out = response.getWriter()) {

            String[] emoji = new String[]{"1f600", "1f605", "1f643", "1f970", "1f618", "1f60b", "1f928", "1f62c", "1f634", "1f922", "1f975", "1f976", "1f60e", "1f913", "1f631", "1f608"};

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmojiKitchen</title>");
            out.println("<link rel='stylesheet' href='css.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<h1>Servlet EmojiKitchen at " + request.getContextPath() + "</h1>");
            if(request.getParameter("emoji1") != null && request.getParameter("emoji2") != null){
            out.println("<table>");
            for (int i = 0; i < 4; i++) {
                out.println("<tr>");
                for (int j = 0; j < 4; j++) {
                    out.println("<td>");
                    out.println("<img src='https://fonts.gstatic.com/s/e/notoemoji/latest/"+ emoji[(i+1)*j] + "/emoji.svg'/>");
                    out.println("<input type='radio' name='emoji1' value='" + emoji[(i+1)*j]+"'>");
                    out.println("</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<table>");
            for (int i = 0; i < 4; i++) {
                out.println("<tr>");
                for (int j = 0; j < 4; j++) {
                    out.println("<td>");
                    out.println("<img src='https://fonts.gstatic.com/s/e/notoemoji/latest/"+ emoji[(i+1)*j] + "/emoji.svg'/>");
                    out.println("<input type='radio' name='emoji2' value='" + emoji[(i+1)*j]+"' >");
                    out.println("</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<button type='submit'>INVIA</button>");
            out.println("</form>");
            }else{
                String emoji1 = request.getParameter("emoji1");
                String emoji2 = request.getParameter("emoji2");
                out.println("<img src='https://emojik.vercel.app/s/" + emoji1 + "_" + emoji2+ "?size=512' />");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Emoji Kitchen";
    }// </editor-fold>

}
