package servlets;

import datastore.DAOSQLite;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 * All of this application's web pages send their requests to this controller
 * which then updates the model / database as needed and transfers control with
 * data to one the the HTML/JSP view-oriented programs for display.
 *
 * @author John Phillips
 */
public class Controller extends HttpServlet {

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

        // get real path to the sqlite db
        ServletContext sc = this.getServletContext();
        String dbPath = sc.getRealPath("/WEB-INF/superstar.db");

        // set default url
        String url = "/home.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "home";
        }

        // perform action and set url
        if (action.equalsIgnoreCase("home")) {
            System.out.println("controller:home");
            url = "/home.html";

        } else if (action.equalsIgnoreCase("checkIn")) {
            System.out.println("controller:checkIn");
            int room = 0;

            // get parameters passed in from the request
            String name = request.getParameter("name");
            String roomString = request.getParameter("room");
            String indate = request.getParameter("indate");
            String outdate = request.getParameter("outdate");
            String notes = request.getParameter("notes");

            // validate and convert salary string into a double
            if (roomString == null || roomString.isEmpty()) {
                room = 0;
            } else {
                room = Integer.parseInt(roomString);
            }

            // store data in an User object
            User user = new User(name, room, indate, outdate, notes);
            System.out.println("Controller:checkIn:user=" + user);

            // validate the parameters
            if (name == null || indate == null || outdate == null
                    || name.isEmpty() || indate.isEmpty() || outdate.isEmpty()) {
                url = "/checkIn.jsp";
            } else {
                // insert this data record into the database
                DAOSQLite.checkIn(user, dbPath);
                url = "/home.html";
            }

        } else if (action.equalsIgnoreCase("report")) {
            System.out.println("controller:report");
            String name = request.getParameter("room");
            if (name == null || name.isEmpty()) {
                name = "%";
            }
            //String roomString = request.getParameter("room");
            //String indate = request.getParameter("indate");
            //String outdate = request.getParameter("outdate");
            List<User> mydata = DAOSQLite.retrieveAllRecords(dbPath);
            //request.setAttribute("name", name);
            //request.setAttribute("room", roomString);
            request.setAttribute("mydata", mydata);
            url = "/showRecords.jsp";

        } else if (action.equalsIgnoreCase("checkOut")) {
            System.out.println("controller:checkOut");
            String roomString = request.getParameter("room");
            if (roomString == null || roomString.isEmpty()) {
                url = "/checkOut.jsp";
            } else {
                DAOSQLite.checkOut(Integer.parseInt(roomString), dbPath);
                url = "/home.html";
            }

        } else if (action.equalsIgnoreCase("makeDB")) {
            System.out.println("controller:makeDB");
            DAOSQLite.dropTable(dbPath);
            DAOSQLite.createTable(dbPath);
            DAOSQLite.populateTable(dbPath);
            url = "/home.html";
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);

        dispatcher.forward(request, response);
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
        return "Controller for Employee App";
    }// </editor-fold>

}
