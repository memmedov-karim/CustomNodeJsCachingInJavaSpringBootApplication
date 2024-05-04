const Cache = require("./cache");
const {sizeof} = require("sizeof");
const getSizeInBytes = require("./helpers/bytes");
class Cachemanager{
    constructor(){
        this.caches = new Map();
    }
    creatNewCache(name){
        // if(this.getCache(name)!==undefined){
        //     throw new Error(`${name} already created use new name!`);
        // }
        let newcache = new Cache();
        this.caches.set(name,newcache); 
        return newcache;
    }
    getCache(name){
        return this.caches.get(name);
    }
}

module.exports = Cachemanager;
