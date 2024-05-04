const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const cacheRouter = require("./router/cacheRouter");
const app = express();
app.use(cors({
    origin: true,
    credentials: true
  }));
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.json());

app.use(cacheRouter);
app.listen(5000,()=>{
    console.log("Server running on port:5000")
})