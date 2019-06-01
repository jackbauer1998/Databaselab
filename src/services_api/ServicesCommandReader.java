package services_api;


import Services_clinet.Servicesclinet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by JackSon on 22/03/2019.
 */
public class ServicesCommandReader extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         /*   response.getWriter().write(String.valueOf(servicesclinet.Check_Phone_Number(request.getParameter("phone"))));
        response.getWriter().write(String.valueOf(servicesclinet.Check_UserName(request.getParameter("user"))));*/
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        Servicesclinet servicesclinet = new Servicesclinet();

        /***********************************************************/
        String commandname = request.getParameter("CommandReader").toString();

        //response.getWriter().write(servicesclinet.Add_Users(";کیارش","مهاجم","1376/09/10"));

        //response.getWriter().write(servicesclinet.Add_team("سایپا","900","3","سیاه"));
        //  response.getWriter().write(servicesclinet.Add_list_team("3","2"));



        switch (commandname) {
            case "get_games_users": {
                response.getWriter().write(servicesclinet.get_games_users());
            }
            break;
            case "get_games_team" :
            {
                response.getWriter().write(servicesclinet.get_games_team());
            }
            break;
            case "get_info_team" :
            {
                response.getWriter().write(servicesclinet.get_info_team());
            }
            break;
            case "get_info_users" :
            {
                response.getWriter().write(servicesclinet.get_info_users());
            }

            case "set_games" :
            {
                response.getWriter().write(servicesclinet.set_games(request.getParameter("name_team_noe").toString(),request.getParameter("name_team_two").toString()
                        ,request.getParameter("number_of_goals_first").toString(),request.getParameter("number_of_goals_last").toString(),
                        request.getParameter("dates").toString()));
            }

            case "set_goals" :
            {
                response.getWriter().write(servicesclinet.set_goals(request.getParameter("users").toString(),request.getParameter("dates").toString()
                        ,request.getParameter("games_id").toString()));
            }

            case "set_list_team" :
            {
                response.getWriter().write(servicesclinet.set_list_team(request.getParameter("team_id").toString(),request.getParameter("user_id").toString()));
            }

            case "set_team" :
            {
                response.getWriter().write(servicesclinet.set_team(request.getParameter("name").toString(),request.getParameter("points").toString()
                        ,request.getParameter("rank_in_the_table").toString(),request.getParameter("color").toString()));
            }

            case "set_Users" :
            {
                response.getWriter().write(servicesclinet.set_Users(request.getParameter("name").toString(),request.getParameter("role").toString()
                        ,request.getParameter("dataes").toString()));
            }


            break;
            default: {
                response.getWriter().write("not find service");
                break;
            }

        }
    }


}
