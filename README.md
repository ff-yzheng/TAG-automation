To run:

First install maven
insert this into <HOME_DIRECTORY>/.m2/settings.xml (<HOME_DIRECTORY>\.m2\settings.xml)
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

Once that file is in, run:
```
mvn clean install
```