const express = require("express");
const Cacheservice = require("../services/cacheServices");
const cacheserv = new Cacheservice();
const router = express.Router();
router.post("/api/creatcache/:name",cacheserv.createCache);
router.post("/api/senddatatocache/:cachename",cacheserv.sendDataToCache);
router.get("/api/getdatafromcache/:cachename/:name",cacheserv.getDataFromCache);
module.exports = router;