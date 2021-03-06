package servlets;

import business.Annuity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KEith Emery
 */
public class AnnuityCalcServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String URL = "/AnnuityResults.jsp";
        String emsg = "";

        // values to get from the form
        double depositEarly, depositLate, rate;
        int term;

        Annuity a = new Annuity();

        try {
            depositEarly = Double.parseDouble(request.getParameter("amt1")); // find in AnnuityInput.jsp
            if (depositEarly <= 0) {
                emsg += "Deposit must be positive<br>";
            } else {
                a.setDepositEarly(depositEarly);
            }
        } catch (Exception e) {
            emsg += "Illegal deposit value<br>";
        }

        try {
            depositLate = Double.parseDouble(request.getParameter("amt2")); // find in AnnuityInput.jsp
            if (depositLate <= 0) {
                emsg += "Deposit must be positive<br>";
            } else {
                a.setDepositLate(depositLate);
            }
        } catch (Exception e) {
            emsg += "Illegal deposit value<br>";
        }

        // finsihed program needs try/catch for each of the following
        try {
            rate = Double.parseDouble(request.getParameter("irt"));
            if (rate <= 0) {
                emsg += "Interest rate must be greater than zero <br>";
            } else {
                a.setRate(rate);
            } // end if/else
        } catch (Exception e) {
            emsg += "Rate is incorrect: " + e.getMessage() + "<br>";
        } // end try/catch

        try {
            term = Integer.parseInt(request.getParameter("term"));
            if (term <= 0) {
                emsg += "Term must be 1 month or more.<br>";
            } else {
                a.setTerm(term);
            }
        } catch (Exception e) {
            emsg += "Invalid term length: " + e.getMessage() + "<br>";
        }

        if (!emsg.isEmpty()) {
            URL = "/AnnuityInput.jsp";
            request.setAttribute("emsg", emsg);
        }
        HttpSession sess = request.getSession();
        sess.setAttribute("annuity", a);

        //   request.setAttribute("annuity", a);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
