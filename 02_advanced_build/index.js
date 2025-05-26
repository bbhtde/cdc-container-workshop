const express = require('express')
const os = require('os')
const app = express()
let requestCount = 0;

app.get('/api/count', (req, res) => {
  res.send(createAndGetResponse(requestCount));
  addRequestCount();
});

app.get('/api/health', (req, res) => {
  res.send({'healthy': 'true'})
})

app.listen(3000, () => {
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
