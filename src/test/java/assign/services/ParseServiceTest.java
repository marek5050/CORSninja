package assign.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

public class ParseServiceTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testParseHtml() throws Exception {

        DefaultHttpClient client = new DefaultHttpClient();

        System.out.println("**** Projects w/ openstack-operators ***");
        HttpGet get = new HttpGet("http://localhost:8083/myeavesdrop/projects/%23openstack-operators/irclogs/");
        HttpResponse response = client.execute(get);

        Assert.assertEquals(200, response.getStatusLine().getStatusCode());

        BufferedReader reader = new BufferedReader(new
                InputStreamReader(response.getEntity().getContent()));

        String line = reader.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = reader.readLine();
        }

        System.out.println("**********************************************************************");

        System.out.println("**** Projects with # **************************************************");
        get = new HttpGet("http://localhost:8083/myeavesdrop/projects/#openstack-operators/irclogs/");
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        reader = new BufferedReader(new
                InputStreamReader(response.getEntity().getContent()));

        line = reader.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println("*********************************************************************");

        System.out.println("**** Projects without # **********************************************");
        get = new HttpGet("http://localhost:8083/myeavesdrop/projects/openstack-operators/irclogs/");
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
        reader = new BufferedReader(new
                InputStreamReader(response.getEntity().getContent()));

        line = reader.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = reader.readLine();
        }
        System.out.println("**********************************************************************");

    }


    @Test
    public void testParseNames() throws Exception {
        DefaultHttpClient client = new DefaultHttpClient();

        System.out.println("**** Projects ***");
        HttpGet get = new HttpGet("http://localhost:8083/myeavesdrop/projects");
        HttpResponse response = client.execute(get);

        Assert.assertEquals(200, response.getStatusLine().getStatusCode());

        BufferedReader reader = new BufferedReader(new
                InputStreamReader(response.getEntity().getContent()));

        String line = reader.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = reader.readLine();
        }

        System.out.println("**********************************************************************");
    }

}