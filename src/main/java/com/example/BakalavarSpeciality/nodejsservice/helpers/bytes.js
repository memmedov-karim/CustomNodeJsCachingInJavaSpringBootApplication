function getSizeInBytes(value) {
    if (value instanceof Map) {
        // For Map objects, convert to an array of key-value pairs and calculate size recursively
        let array = Array.from(value);
        return array.reduce((totalSize, [key, val]) => totalSize + getSizeInBytes(key) + getSizeInBytes(val), 0);
    } else if (typeof value === 'string') {
        // For strings, calculate size using Buffer.byteLength()
        return Buffer.byteLength(value, 'utf8');
    } else if (Array.isArray(value)) {
        // For arrays, calculate size of each element recursively and sum them up
        return value.reduce((totalSize, element) => totalSize + getSizeInBytes(element), 0);
    } else if (typeof value === 'object' && value !== null) {
        // For objects, convert to JSON string and calculate size using Buffer.byteLength()
        let jsonString = JSON.stringify(value);
        return Buffer.byteLength(jsonString, 'utf8');
    } else {
        // For other types (numbers, booleans, null, undefined), return the size of their string representation
        return Buffer.byteLength(String(value), 'utf8');
    }
}


module.exports = getSizeInBytes;