package ua.pp.kaha;

import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.*;

/**
 * Created by skokhanenko on 17.02.2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // Take the port from the environment variable and launch the server
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) webPort = "8080";
        Server server = new Server(Integer.valueOf(webPort));

        // Since we don't package the project as a war, we use our src/main/webapp directory
        // as the resource base directory for the server
        String webappDir = "src/main/webapp/";

        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setResourceBase(webappDir);
        // Descriptor file (empty)
        context.setDescriptor(webappDir + "WEB-INF/web.xml");
        // Configuration classes. This gives support for multiple features.
        // The annotationConfiguration is required to support annotations like @WebServlet
        context.setConfigurations(new Configuration[]{
                new WebXmlConfiguration(),
                new WebInfConfiguration(),
                new PlusConfiguration(), new MetaInfConfiguration(),
                new FragmentConfiguration(), new EnvConfiguration()});

        // Important! make sure Jetty scans all classes under ./classes looking for annotations. Classes
        // directory is generated running 'mvn package'
        context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");
        context.setParentLoaderPriority(true);

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // fix for Windows, so Jetty doesn't lock files
            context.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
        }

        // Config and launch server
        server.setHandler(context);
        server.start();
        server.join();
    }
}
