package gr.aueb.mscis.educore.app;

import gr.aueb.mscis.educore.app.config.ApplicationResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import java.net.URI;

public class EducoreApp {

    public EducoreApp(){
        startServer();
    }

    public void startServer(){
        // Get a ServiceLocator
        ServiceLocator locator =
                ServiceLocatorUtilities.createAndPopulateServiceLocator();

        // pass the ServiceLocator to Grizzly Http Server
        final HttpServer httpServer =
                GrizzlyHttpServerFactory
                        .createHttpServer(URI.create("http://127.0.0.1:8080"), new ApplicationResourceConfig(), locator);
    }

    public static void main(String args[]){
        new EducoreApp();
    }
}
