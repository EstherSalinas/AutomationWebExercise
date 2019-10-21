package providers;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.*;
import java.util.Properties;



public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath= "configs//Configuration.properties";
    private static String OS = System.getProperty("os.name").toLowerCase();

    public ConfigFileReader() {

        try {

            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            properties = new Properties();
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


    public String getDriverPathChrome() {
        String driverPath = null;
        if (OS.indexOf("win") >= 0) {
            System.out.println("This is Windows");
            driverPath = properties.getProperty("driverPathChromeWindows");
        } else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
            System.out.println("This is Unix or Linux");
            driverPath = properties.getProperty("driverPathChromeLinux");
        } else if (OS.indexOf("mac") >= 0) {
            System.out.println("This is MacOS");
            driverPath = properties.getProperty("driverPathChromeMacOS");
        }
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPathUnix not specified in the Configuration.properties file.");
    }

    public String getDriverPathFirefox() {
        String driverPath = null;
        if (OS.indexOf("win") >= 0) {
            System.out.println("This is Windows");
            driverPath = properties.getProperty("driverPathFirefoxWindows");
        } else if (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 ) {
            System.out.println("This is Unix or Linux");
            driverPath = properties.getProperty("driverPathFirefoxLinux");
        } else if (OS.indexOf("mac") >= 0) {
            System.out.println("This is MacOS");
            driverPath = properties.getProperty("driverPathFirefoxMacOS");
        }
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPathUnix not specified in the Configuration.properties file.");
    }


    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public int getStepTimeout() {
        String stepTimeout = properties.getProperty("stepTimeout");
        if(stepTimeout != null) return Integer.parseInt(stepTimeout);
        else throw new RuntimeException("stepTimeout not specified in the Configuration.properties file.");
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }


    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
        else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
    }


    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

}
