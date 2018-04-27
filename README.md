To run:

- First install maven
- insert this into <HOME_DIRECTORY>/.m2/settings.xml (<HOME_DIRECTORY>\.m2\settings.xml)
```
<?xml version="1.0"?>
<settings>
  <mirrors>
    <mirror>
      <id>MavenCentral</id>
      <name>Nexus Public Mirror</name>
      <url>https://nexus.wexapps.com/repository/maven-central/</url>
      <mirrorOf>central</mirrorOf>
    </mirror>
  </mirrors>
</settings>
```

(The pom.xml steps below should no longer be needed since the drivers are in the project)

- <div style="background-color:gray">Download the appropriate driver for the browser you wish to use and put it somewhere on your machine
- <div style="background-color:gray">Replace the following in pom.xml with the driver you chose

```
<systemProperties>
    <property>
        <name>webdriver</name>
        <value>[chrome|ie|opera|gecko]</value>
    </property>
    <property>
        <name>webdriver.[chrome|ie|opera|gecko].driver</name>
        <value>/Path/To/Driver</value>
    </property>
</systemProperties>
```
</div>

- Add the following to the IntelliJ Run - Edit Configurations - Cucumber Java - VM Options

```
-Dwebdriver.chrome.driver=src/test/drivers/chromedriver.exe -Dwebdriver=chrome
```



Once that file is in, run:
```
mvn clean install
```