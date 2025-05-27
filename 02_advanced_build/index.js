const express = require('express')
const os = require('os')
const app = express()
let requestCount = 0;

// Is delivered on Windows when Ctrl+Break is pressed. 
// On non-Windows platforms, it can be listened on, but there 
// is no way to send or generate it.
app.get('/api/count', (req, res) => {
  res.send(createAndGetResponse(requestCount));
  addRequestCount();
});

app.get('/api/health', (req, res) => {
  res.send({'healthy': 'true'})
})

const server = app.listen(3000, () => {
  console.info("startup complete")
});

function createAndGetResponse(countValue) {
  return {
    "requestCount": countValue.toString(),
    "hostname": os.hostname(),
    "node": {
      "version": process.version
    }
  }
}

function addRequestCount() {
  requestCount = requestCount + 1;
}

// Hier kommt die Ergänzung für die Reaktion auf Strg+C
process.on('SIGINT', () => {
  console.info('\nSIGINT signal received. Shutting down gracefully...');
  server.close(() => {
    console.info('HTTP server closed.');
    // Hier könntest du weitere Aufräumarbeiten durchführen, z.B. Datenbankverbindungen schließen
    process.exit(0); // Beende den Prozess
  });
});

// Optional: Für SIGTERM (z.B. bei Docker-Stopp)
process.on('SIGTERM', () => {
  console.info('\nSIGTERM signal received. Shutting down gracefully...');
  server.close(() => {
    console.info('HTTP server closed.');
    process.exit(0);
  });
});
