# 01 CMD und Entrypoint

## Verzeichnisstruktur und Unterlagen

Das Verzeichnis sollte folgende Dateien beinhalten.
```
.
├── AppMain.java
├── Dockerfile
```

Wird die Datei `AppMain.java` regulär ausgeführt (`java AppMain.java`) wird die Ausgabe `Du hast die Aufgabe ` erzeugt.

In dem Verzeichnis befindet sich auch ein Dockerfile mit Anweisungen für den Build eines Containerimages.

## Aufgabe

- Sieh dir den Dockerfile an und erzeuge ein Containerabbild.
- Führe die Anwendung mit `docker container run [...]` so aus, dass die Ausgabe `Du hast die Aufgabe gelöst!` in der Kommandozeile ausgegeben wird.

> Die Inhalte der Dateien Dockerfile und AppMain.java sollen nicht verändert werden
> 
> Die Dateien sollen nicht umbenannt werden
> 
> Eine Hilfestellung zu den Möglichkeiten, die `docker container run` bietet, findest du hier: [docker container run reference](https://docs.docker.com/reference/cli/docker/container/run/)