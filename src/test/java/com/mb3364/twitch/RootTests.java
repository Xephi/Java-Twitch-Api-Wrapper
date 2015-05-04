package test.java.com.mb3364.twitch;

import main.java.com.mb3364.twitch.api.Twitch;
import main.java.com.mb3364.twitch.api.handlers.TokenResponseHandler;
import main.java.com.mb3364.twitch.api.models.Token;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class RootTests {

    private final static String CLIENT_ID = "3ecse7kg5j1tmagtkmzzyxqmvtw1lze";
    private final static String AUTH_TOKEN = "9z2ompq3y9zwx58emz6u9w86mn477s";

    private Twitch client;

    @Before
    public void before() {
        client = new Twitch();
        client.setClientId(CLIENT_ID);
        client.auth().setAccessToken(AUTH_TOKEN);
    }

    @Test
    public void getTest() {
        client.root().get(new TokenResponseHandler() {
            @Override
            public void onSuccess(Token token) {
                System.out.println("Success");
                System.out.println(token);
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
