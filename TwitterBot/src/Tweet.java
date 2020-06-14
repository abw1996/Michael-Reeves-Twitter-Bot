import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class Tweet {
    static String consumerKeyStr = "uFjchg2KGUEOnQ0EOTbsshAGb";
    static String consumerSecretStr = "kcxLXlxq2P3ylpQOzZDgiSGKeSK5Qo8q4OqiNCUqAXXcKSgFHL";
    static String accessTokenStr = "1264978316454494208-0DB7XhefRUbpqs5YcMjbZ8YH6konM9";
    static String accessTokenSecretStr = "dDCz4kefwfPB9VbcB1LTMkegybZ8fzb3F4P3LhMrwOImQ";

    public Tweet() {

    }

    public void send(int subCount) {

        OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr,
                consumerSecretStr);
        oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);

        HttpPost httpPost = new HttpPost(
                "http://api.twitter.com/1.1/statuses/update.json?status=Congrats%20Micheal%20Reeves%20on%20reaching%20" + subCount + "%20subscribers.");

        try {
            oAuthConsumer.sign(httpPost);
        } catch (OAuthMessageSignerException e) {
            e.printStackTrace();
        } catch (OAuthExpectationFailedException e) {
            e.printStackTrace();
        } catch (OAuthCommunicationException e) {
            e.printStackTrace();
        }

        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ':'
                + httpResponse.getStatusLine().getReasonPhrase());
        try {
            System.out.println(IOUtils.toString(httpResponse.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
