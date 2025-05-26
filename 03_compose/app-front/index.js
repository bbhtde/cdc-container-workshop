const express = require('express')
const os = require('os')
const {response} = require("express");
const app = express()

let backendUrl = undefined;

app.get('/', (req, res) => {
  fetchAndGetBackendData().then((response) => {
    console.info("retrieved backend response: " + response)
    res.send({
      "backend-response": response,
      "hostname": os.hostname(),
      "time": Date.now()
    })
  });
});

app.listen(3000, () => {
  init();
  console.info("startup complete")
});

async function fetchAndGetBackendData() {
  try {
    const apiResponse = await fetch(backendUrl)
    return apiResponse.json();
  } catch (err) {
    console.warn(err)
    return {
      "error" : true
    }
  }
}

function init() {
  if (!process.env.BACKEND_URL) {
    console.error("FATAL: 'BACKEND_URL' must be set!")
    process.exit(12)
  }
  backendUrl = process.env.BACKEND_URL
}
