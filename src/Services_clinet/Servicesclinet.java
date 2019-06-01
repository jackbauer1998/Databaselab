package Services_clinet;

import Data_Model.Data_mode_sql;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by JackSon on 22/03/2019.
 */
public class Servicesclinet {







    public String set_Users(String name, String role, String dataes) {
        try {
            PreparedStatement preparedStatement = null;
            /********************************************/

            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.insert_users);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, role);
            preparedStatement.setString(3, dataes);
            preparedStatement.executeQuery();

            return "[{\"hasError\": false,\"message\": \"عملیات موفق آمیز\",\"status\": 200}]";


        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }

    public String set_team(String name, String points, String rank_in_the_table, String color) {
        try {
            PreparedStatement preparedStatement = null;
            /********************************************/

            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.insert_team);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, points);
            preparedStatement.setString(3, rank_in_the_table);
            preparedStatement.setString(4, color);

            preparedStatement.executeQuery();

            return "[{\"hasError\": false,\"message\": \"عملیات موفق آمیز\",\"status\": 200}]";


        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }
    public String set_list_team(String team_id, String user_id) {
        try {
            PreparedStatement preparedStatement = null;
            /********************************************/

            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.insert_list_team);
            preparedStatement.setString(1, team_id);
            preparedStatement.setString(2, user_id);


            preparedStatement.executeQuery();

            return "[{\"hasError\": false,\"message\": \"عملیات موفق آمیز\",\"status\": 200}]";


        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }
    public String set_games(String name_team_noe, String name_team_two,String number_of_goals_first, String number_of_goals_last , String dates) {
        try {
            PreparedStatement preparedStatement = null;
            /********************************************/

            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.insert_games);
            preparedStatement.setString(1, name_team_noe);
            preparedStatement.setString(2, name_team_two);
            preparedStatement.setString(3, number_of_goals_first);
            preparedStatement.setString(4, number_of_goals_last);
            preparedStatement.setString(5, dates);


            preparedStatement.executeQuery();

            return "[{\"hasError\": false,\"message\": \"عملیات موفق آمیز\",\"status\": 200}]";


        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }
    public String set_goals(String users, String dates, String games_id) {
        try {
            PreparedStatement preparedStatement = null;
            /********************************************/

            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.insert_goals);
            preparedStatement.setString(1, users);
            preparedStatement.setString(2, dates);
            preparedStatement.setString(2, games_id);


            preparedStatement.executeQuery();

            return "[{\"hasError\": false,\"message\": \"عملیات موفق آمیز\",\"status\": 200}]";


        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }


    public String get_games_team() {
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            /********************************************/
            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.select_gols_team);
            resultSet = preparedStatement.executeQuery();

            JSONArray jsonArray = new JSONArray();

            while (resultSet.next()) {
                JSONObject json_Object = new JSONObject();

                json_Object.put("name_games", String.valueOf(resultSet.getString(1)));
                json_Object.put("number_of_goals_first", String.valueOf(resultSet.getString(2)));
                json_Object.put("number_of_goals_last", String.valueOf(resultSet.getString(3)));
                json_Object.put("dates", String.valueOf(resultSet.getString(4)));
                //    json_Object.put("chat_name",String.valueOf(resultSet.getString(3)));
                json_Object.put("status", 200);
                json_Object.put("hasError", false);
                jsonArray.put(json_Object);

            }

            resultSet.close();
            Database.dbconn.dbConnectioned().close();
            return jsonArray.toString();

        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }
    public String get_games_users() {
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            /********************************************/
            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.select_gols_users);
            resultSet = preparedStatement.executeQuery();

            JSONArray jsonArray = new JSONArray();

            while (resultSet.next()) {
                JSONObject json_Object = new JSONObject();

                json_Object.put("name", String.valueOf(resultSet.getString(1)));
                json_Object.put("dates_users", String.valueOf(resultSet.getString(2)));
                json_Object.put("games", String.valueOf(resultSet.getString(3)));
                json_Object.put("all_goals", String.valueOf(resultSet.getString(4)));



                json_Object.put("dates_games", String.valueOf(resultSet.getString(7)));
                //    json_Object.put("chat_name",String.valueOf(resultSet.getString(3)));
                json_Object.put("status", 200);
                json_Object.put("hasError", false);
                jsonArray.put(json_Object);

            }

            resultSet.close();
            Database.dbconn.dbConnectioned().close();
            return jsonArray.toString();

        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }
    public String get_info_team() {
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            /********************************************/
            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.select_info_team);
            resultSet = preparedStatement.executeQuery();

            JSONArray jsonArray = new JSONArray();

            while (resultSet.next()) {
                JSONObject json_Object = new JSONObject();

                json_Object.put("id", String.valueOf(resultSet.getString(1)));
                json_Object.put("points", String.valueOf(resultSet.getString(2)));
                json_Object.put("rank_in_the_table", String.valueOf(resultSet.getString(3)));
                json_Object.put("name", String.valueOf(resultSet.getString(4)));
                json_Object.put("color", String.valueOf(resultSet.getString(5)));
                //    json_Object.put("chat_name",String.valueOf(resultSet.getString(3)));
                json_Object.put("status", 200);
                json_Object.put("hasError", false);
                jsonArray.put(json_Object);

            }

            resultSet.close();
            Database.dbconn.dbConnectioned().close();
            return jsonArray.toString();

        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }
    public String get_info_users() {
        try {
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            /********************************************/
            preparedStatement = Database.dbconn.dbConnectioned().prepareStatement(Data_mode_sql.select_info_users);
            resultSet = preparedStatement.executeQuery();

            JSONArray jsonArray = new JSONArray();

            while (resultSet.next()) {
                JSONObject json_Object = new JSONObject();

                json_Object.put("id", String.valueOf(resultSet.getString(1)));
                json_Object.put("name", String.valueOf(resultSet.getString(2)));
                json_Object.put("team", String.valueOf(resultSet.getString(3)));
                json_Object.put("role", String.valueOf(resultSet.getString(4)));
                json_Object.put("dates", String.valueOf(resultSet.getString(5)));
                //    json_Object.put("chat_name",String.valueOf(resultSet.getString(3)));
                json_Object.put("status", 200);
                json_Object.put("hasError", false);
                jsonArray.put(json_Object);

            }

            resultSet.close();
            Database.dbconn.dbConnectioned().close();
            return jsonArray.toString();

        } catch (Exception Error) {
            return "[{\"hasError\": true,\"message\": \"" + Error.getMessage() + "\",\"status\": 500}]";
        }
    }


}
