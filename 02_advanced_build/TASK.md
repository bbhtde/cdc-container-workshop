# 02 Erweiterte Build-Techniken

## Verzeichnisstruktur und Unterlagen

In diesem Verzeichnis befinden sich folgende Dateien:

```
.
├── Dockerfile
├── index.js
└── package.json
```

### Dockerfile
Der Dockerfile sollte leer sein

### index.js
In der Datei index.js ist ein einfacher `express.js`-basierter Webserver definiert.
Dieser stellt zwei Endpunkte bereit:

```
GET http://localhost:3000/api/health
```
```json
{
  "healthy": true
}
```
```
GET http://localhost/api/count
```
```json
{
  "requestCount": "",
  "hostname": "",
  "node": {
    "version": ""
  }
}
```
Der Webserver nutzt port `3000`.
Die Anwendung kann mit folgendem Befehl gestartet werden.
```shell
node index.js
```

### package.json
in der package.json sind die notwendigen Bibliotheken für den Webserver definiert.
Die Abhängigkeiten können prinzipiell über die Kommandozeile installiert werden:
```shell
npm install
```

## Aufgabe 01
- Vervollständige die Datei `Dockerfile` mit notwendigen Build anweisungen um ein lauffähiges Container-Abbild zu erzeugen.
- Folgender Befehl sollte für den Build verwendet werden können:
```shell
docker build -t my_node_app:latest ./
```

## Aufgabe 02
- Unten findest du zwei Befehle:
  - 1. einen `docker container run` - Befehl. Dieser ist unvollständig. Im Bereich [DEINE LÖSUNG] soll der Befehl so erweitert werden, dass der zweite Befehl (b.) eine gültige Antwort der containerisierten Anwendung erhält
  - 2. der zweite Befehl ist ein cURL-Aufruf. Das Ziel ist, dass du die Containerisierte Anwendung so startest, dass dieser Befehl eine gültige Antwort des Webservers erhält.

```shell
docker container run --rm [DEINE LÖSUNG] my_node_app:latest
```

```shell
curl http://localhost:8080/api/count
```

> Hinweis: der `docker container run`-Befehl darf nur im Bereich [DEINE LÖSUNG] geändert werden.
> 
> Der cUrl Befehl soll nicht verändert werden.
> 
> Der Dockerfile soll nicht verändert werden. Verwende bitte das in Aufgabe 01 erzeugte Abbild

## Aufgabe 03
- Der Dockerfile soll so verändert werden, dass der Build auch das Installieren der Abhängigkeiten beinhaltet (Es soll zu keinem Zeitpunkt auf die Node-Installation des HOST-Geräts zugegriffen werden).

> Das Containerabbild soll nur die zwingend notwendigen Dateien enthalten

# Nützliche Ressourcen:

- [Dockerfile-Referenz](https://docs.docker.com/reference/dockerfile/)
- [Multi-Stage-Builds](https://docs.docker.com/build/building/multi-stage/) | Das ist für [Aufgabe 03] nützlich!
