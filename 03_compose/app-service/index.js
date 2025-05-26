const express = require('express')
const os = require('os')
const app = express()

let backendUrl = undefined;

app.get('/', (req, res) => {
    new Promise((resolveInner) => {
      setTimeout(resolveInner, 1000);
    }).then(() => {
      const apiResponse =  {
        "response": Date.now(),
        "hostname": os.hostname()
      };
      console.info(apiResponse)
      res.send(apiResponse)
    })
});

app.listen(3000, () => {
  console.info("startup complete")
});
