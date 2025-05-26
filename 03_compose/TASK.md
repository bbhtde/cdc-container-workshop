# 03 Arbeiten mit Docker Compose

## Verzeichnisstruktur und Unterlagen

In diesem Verzeichnis befinden sich folgende Dateien:

```
.
├── app-front
│         ├── Dockerfile
│         ├── index.js
│         ├── package-lock.json
│         └── package.json
├── app-service
│         ├── Dockerfile
│         ├── index.js
│         ├── package-lock.json
│         └── package.json
└── docker-compose.yml
```
Insgesamt bilden die Inhalte der zwei Verzeichnisse `app-front` und `app-service` eine service-to-service-Anwendung ab.
<br/>
Hierbei handelt es sich also um zwei REST basierte Anwendungen wobei `app-front` einen REST-Endpunkt bereitstellt, der bei einem Aufruf eine Anfrage an `app-service` stellt.

## Funktionsweise:

### app-front
app-front stellt den Endpunkt `GET localhost:3000/` zur Verfügung.
Wird `app-front` gestartet wird die Umgebungsvariable `BACKEND_HOSTNAME` abgefragt.
Ist diese nicht gesetzt, wird die Anwendung sofort beendet. <br/>
Ist die Umgebungsvariable gesetzt wird der Wert der Umgebungsvariable als Hostname von `app-service` verwendet.

Die Anwendung kann wie folgt gestartet werden:

```shell
cd app-front
```
```shell
npm install
```
```shell
node index.js
```

### app-service
Die Anwendung stellt nach dem Start folgenden Endpunkt bereit:

``GET localhost:3000/``
Dieser Endpunkt gibt ein JSON-Objekt zurück. Dieser wird von `app-front` konsumiert.

Die Anwendung kann wie folgt gestartet werden:
```shell
cd app-service
```
```shell
npm install
```
```shell
node index.js
```

## Aufgabe
- Nutze die Datei `docker-compose.yml` und befülle sie mit einer Konfiguration, um den Anwendungsstack zu starten.
- Setze dazu auch die notwendigen Umgebungsvariablen.

> Hinweis: `app-service` soll lediglich innerhalb des Anwendungsstacks verfügbar sein! (Kein Aufruf über localhost:XYZ/!)
>
> Bitte ändere nicht die Inhalte der Dateien (außer docker-compose.yml)
 
Erwartetes Ergebnis:
- `GET http://localhost/` kann aufgerufen werden
- `app-front` beantwortet den Aufruf und gibt folgende Antwort zurück:
```json
{
  "backend-response": {
    "response": "",
    "hostname": ""
  },
  "hostname": "",
  "time": 0
}
```

# Weitere Ressourcen

- Eine Hilfestellung findest du hier: [compose reference](https://docs.docker.com/reference/compose-file/)