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

- Download the appropriate driver for the browser you wish to use and put it somewhere on your machine
- Replace the following in pom.xml with the driver you chose
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

Once that file is in, run:
```
mvn clean install
```