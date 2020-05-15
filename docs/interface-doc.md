# Get the current main network computing power


<a name="getHashRate"/>
Request path: http://localhost:8080/czzinterfaces/getHashRate

interface name: getHashRate

interface input parameter: null

return instructions:
```json
{(json object)
    "state ": 200 (Integer) status code 200- normal, 500- abnormal,
    "version ":"v1.0" (String) interface version,
    "data" : {
        "block_height ": 100 (Integer) current block height,
        "hash_rate ":1000 (Double) current main network computing force (unit H/s),
        "testnet ":false (Boolean) is a testnet
        }
}
```
### sample
Request:

GET http://localhost:8080/czzinterfaces/getHashRate

Response:
```json
{
    "state" : 200,
    "version" : "v1.0",
    "data" : {
        "block_height" : 100,
        "hash_rate" : 1000,
        "testnet" : false
        }
}
```


<a name="getDifficulty"/>
# Get the current block difficulty

request method: GET

Request path: http://localhost:8080/czzinterfaces/getDifficulty

interface name: getDifficulty

interface input parameter: null

return instructions: 
```json
{(json object)
    "state ": 200 (Integer) status code 200- normal, 500- abnormal,
    "version ":"v1.0" (String) interface version,
    "data" : {
        "block_height ": 100 (Integer) current block height,
        "difficulty ":1000 (Double) current main network difficulty,
        "testnet ":false (Boolean) is a testnet
        }
}
```
### sample
Request: 

GET http://localhost:8080/czzinterfaces/getDifficulty

Response: 

```json
{
    "state" : 200,
    "version" : "v1.0",
    "data" : {
        "block_height" : 100,
        "difficulty" : 1000,
        "testnet" : false
        }
}
```