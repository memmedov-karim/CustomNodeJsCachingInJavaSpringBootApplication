const Cachemanager = require("../cachemanager");
class Cacheservice{
    constructor(){
        this.cachemanager = new Cachemanager();
    }
    createCache = async (req,res) => {
        const {name} = req.params;
        try {
            this.cachemanager.creatNewCache(name);
            console.log(name);
            return res.status(200).json("Cache created")
        } catch (error) {
            return res.status(500).json({error:"Internal server error"});

        }
    }
    sendDataToCache = async (req,res) => {
        const {cachename} = req.params;
        const {name,data} = req.body;
        try {
            console.log("name:",name);
            console.log("data:",data);
            const cache = this.cachemanager.getCache(cachename);
            if(cache===null || cache===undefined){
                return res.status(404).json("Cachemanager not found")
            }
            cache.putData(name,data);
            return res.status(200).json("Data save in cache");
        } catch (error) {
            return res.status(500).json({error:"Internal server error"});
        }
    }
    getDataFromCache = async (req,res) => {
        const {cachename,name} = req.params;
        try {
            const currentcache = this.cachemanager.getCache(cachename);
            // console.log(data);
            if(currentcache===null || currentcache===undefined){
                return res.status(404).json("Cache not found");
            }
            return res.status(200).json(currentcache.getData(name));
        } catch (error) {
            return res.status(500).json({error:"Internal server error"});
        }
    }
}

module.exports = Cacheservice;