# 04 Compose und Kubernetes

Jetzt wird es etwas umfangreicher. In diesem Aufgabenorder befinden sich zwei Anwendungen:

## frontend
Die Anwendung im Unterordner `./frontend` beinhaltet eine Webanwendung auf Basis von Vue.js.
Lokal kann sie mit dem Befehl `npm run serve` gestartet werden.
Um die Anwendung zu Containerisieren muss zunächst ein HTML-Bundle erstellt werden. 

Das kann mit `npm run build-only` durchgeführt werden.

Anschließend werden die dadurch erzeugten inhalte im Rahmen des Containerbuilds in das Verzeichnis für statische Ressourcen eines Nginx-Webservers kopiert.

Der vollständige Containerisierungsprozess sieht daher so aus:

```shell
npm run build-only
docker build -t person-app-frontend:1.0.0 ./
docker run --name person-app-frontend --rm -p 80:80 person-app-frontend:1.0.0
```

Anschließend ist die Anwendung über `http://localhost` im Browser erreichbar.

> Genereller Hinweis: in der Datei `frontend/src/service/person.service.ts` darf der Inhalt der Variable ´backend_host` angepasst werden! ReBuild erforderlich!

## backend

Das Backend ist ein REST-Service auf Basis von Java und Spring Boot.

Dieser stellt drei Endpunkte zur Verfügung:
- `GET /api/persons` -> Gibt eine Lite mit gespeicherten Personen zurück
- `POST /api/persons` -> Wenn im Request Body ein "Person"-JSON gesendet wird, wird eine neue Person angelegt.
- `GET /api/person/{id}` -> Gibt eine einzelne Person zurück.

In der Standardkonfiguration nutzt die Anwendung eine H2-in-Memory-Datenbank, für die keine weitere Konfiguration notwendig ist.
Alternativ kann auch das Spring-Profil `postgres`-Verwendet werden. Damit kann als Datenbank eine Postgres-Datenbank konfiguriert werden.

Bei Verwendung des Profils `postgres` müssen Umgebungsvariablen gesetzt sein:

- `DB_URL` -> die vollständige JDBC-URL einer Postgres-Datenbank.
- `DB_USERNAME` -> Der Benutzername der Datenbank.
- `DB_PASSWORD` -> Das Passwort der Datenbank.

Der Vollständige Containerisierungsprozess sieht so aus:

```shell
docker build -t person-app-backend:1.0.0 ./
docker run --name person-app-backend --rm -p 8080:8080 person-app-backend:1.0.0
```

## Aufgabe 1
- Erstelle eine docker-compose.yaml Datei im Unterordner `compose`.
- Befülle die Datei so, dass der Anwendungsstack mit einer H2-Datenbank startet.

## Aufgabe 2
- Erweitere die in Aufgabe 1 erstellte docker-compose.yaml-Datei so, dass die Anwendung eine PostgreSQL-Datenabank verwendet.

> Hinweis: Dazu muss der Entrypoint vom Backend überschrieben werden, damit das `postgres`-Spring Profil aktiviert wird
>
> Bitte verändere nicht die Anwendungsdateien.
> Bitte verändere nicht die Dockerfiles
> 
> 
> Genereller Hinweis: in der Datei `frontend/src/service/person.service.ts` darf der Inhalt der Variable ´backend_host` angepasst werden! ReBuild erforderlich!