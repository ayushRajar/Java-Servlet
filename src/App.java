import java.io.File;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;


public class App{
    public static void main(String[] args) throws LifecycleException{
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);
        tomcat.getConnector();

        Context ctx = tomcat.addWebapp("api/", new File("build/webapp").getAbsolutePath());

        //Tomcat.addServlet(ctx,"HelloServlet", new HelloServlet());
        
        //ctx.addServletMappingDecoded("/hello", "HelloServlet");

        tomcat.start();
        System.out.println("Tomcat server ready on http://localhost:9090");

        tomcat.getServer().await();

    }
}