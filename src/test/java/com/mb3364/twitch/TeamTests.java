package test.java.com.mb3364.twitch;

import main.java.com.mb3364.twitch.api.Twitch;
import main.java.com.mb3364.twitch.api.handlers.TeamResponseHandler;
import main.java.com.mb3364.twitch.api.handlers.TeamsResponseHandler;
import main.java.com.mb3364.twitch.api.models.Team;
import main.java.com.mb3364.twitch.http.JsonParams;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TeamTests {

    private final static String CLIENT_ID = "3ecse7kg5j1tmagtkmzzyxqmvtw1lze";

    private Twitch client;

    @Before
    public void before() {
        client = new Twitch();
        client.setClientId(CLIENT_ID);
    }

    @Test
    public void getTeamsTest() {
        JsonParams params = new JsonParams();
        params.put("limit", 10);

        client.teams().get(params, new TeamsResponseHandler() {
            @Override
            public void onSuccess(List<Team> teams) {
                System.out.println("Success");
                System.out.println(teams.size());
                System.out.println(teams);
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                System.out.println(statusCode);
                System.out.println(statusMessage);
                System.out.println(errorMessage);
            }

            @Override
            public void onFailure(IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void getTeamTest() {
        client.teams().get("ths", new TeamResponseHandler() {
            @Override
            public void onSuccess(Team team) {
                System.out.println("Success");
                System.out.println(team);
            }

            @Override
            public void onFailure(int statusCode, String statusMessage, String errorMessage) {
                System.out.println(statusCode);
                System.out.println(statusMessage);
                System.out.println(errorMessage);
            }

            @Override
            public void onFailure(IOException e) {
                e.printStackTrace();
            }
        });
    }
}
