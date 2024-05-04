const {sizeof} = require("sizeof");
const getSizeInBytes = require("./helpers/bytes");
class Cache{
    constructor(){
        this.cache = new Map();
    }
    putData(key,value){
        console.log("New size",getSizeInBytes(value)+getSizeInBytes(key));
        this.cache.set(key,value);
    }
    getData(key){
        return this.cache.get(key);
    }
    clear(key){
        if(key === "all"){
            this.cache.clear();
        }
        else{
            this.cache.delete(key);
        }
    }
    getSize(){
        return getSizeInBytes(this.cache);
    }
}

module.exports = Cache;