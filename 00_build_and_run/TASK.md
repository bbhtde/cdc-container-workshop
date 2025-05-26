# 00 - Containerimage erzeugen und Container starten

## Verzeichnisstruktur und Unterlagen

Das Verzeichnis hat folgende Struktur:

```
.
├── dockerfile-exercise
└── index.js
```

Die Datei `index.js` beinhaltet lediglich die Ausgabe:

```javascript
console.log("Hello, World!");
```

## Aufgabe
- Überlege dir, wie du die Anwendung containerisieren kannst.
- Die Build-Anweisungen sollen in `dockerfile-exercise` hinterlegt werden.
- Baue anschließend das Containerabbild und erzeuge eine Instanz der Anwendung.
- Die Ausgabe aus im Container sollte `Hello, World!` sein.

> Verändere nicht die Dateistruktur im Aufgabenverzeichnis.
> 
> Benenne keine der hinterlegten Dateien um.
> 
> Hier findest du mögliche Basis-Images für dein Containerimage: [Docker Hub: Node](https://hub.docker.com/_/node/tags)