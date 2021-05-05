package ru.tagirov.tm.command.AllCommand;

import com.jcabi.manifests.Manifests;
import ru.tagirov.tm.command.AbstractCommand;
import ru.tagirov.tm.init.ServiceLocator;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class AboutCommand extends AbstractCommand {

    public AboutCommand() {
    }

    @Override
    public void setServiceLocator(ServiceLocator serviceLocator) {
        super.setServiceLocator(serviceLocator);
    }

    @Override
    public String getRoleCommand() {
        return "all";
    }

    @Override
    public String getName() {
        return "about";
    }

    @Override
    public String getDescription() {
        return "about";
    }

    @Override
    public void execute() throws IOException {
//        System.out.println(Manifests.read("Foo-Version"));
        String version = Manifests.read("JCabi-Version");
        System.out.println("version is " + version);
    }
}
