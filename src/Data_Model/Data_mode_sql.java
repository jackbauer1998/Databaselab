package Data_Model;

/**
 * Created by JackSon on 22/03/2019.
 */
public class Data_mode_sql
{
    public static String insert_users = "INSERT INTO users (id,name,role,dates) VALUES ((select count(id)+1 from users),?,?,?)";

    public static String insert_team = "INSERT INTO ss_team (id,name,points,rank_in_the_table,color) VALUES ((select count(id)+1 from ss_team),?,?,?,?)";

    public static String insert_list_team = "INSERT INTO ss_list_team (id,team_id, user_id) VALUES ((select count(id)+1 from ss_list_team),?,?)";

    public static String insert_games = "INSERT INTO ss_games (id,name_team_noe,name_team_two,number_of_goals_first,number_of_goals_last,dates) VALUES ((select count(id)+1 from ss_games),?,?,?,?,?)";

    public static String insert_goals = "INSERT INTO ss_goals (id,users,dates,games_id) VALUES ((select count(id)+1 from ss_goals),?,?,?)";


    public static String select_gols_users = "select ds.name , ds.dates as dates_users , (select (select name from ss_team where id = name_team_noe) || ' - ' ||(select name from ss_team where id = name_team_two) from ss_games where id =ds1.games_id)as games  ,(ds2.number_of_goals_first + ds2.number_of_goals_last ) as all_goals , ds2.number_of_goals_first , ds2.number_of_goals_last ,ds2.dates as dates_games from users ds join ss_goals ds1 on ds.id = ds1.users join ss_games ds2 on ds1.games_id = ds2.id";
    public static String select_gols_team = "select (select (select name from ss_team where id = name_team_noe) || ' - ' ||(select name from ss_team where id = name_team_two) from ss_games where id in (ds.id))as name_games, ds.number_of_goals_first ,  ds.number_of_goals_last,ds.dates from ss_games ds";



    public static  String select_info_team = "select * from ss_team";

    public static  String select_info_users = "select * from users";

}

