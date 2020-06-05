# Get the current main network computing power

###getHashRate
<a name="getHashRate"/>
Request path: http://localhost:8080/czzinterfaces/getHashRate

interface name: getHashRate

interface input parameter: null

return instructions:
```
{
    "state ": 200 (Integer) status code 200- normal, 500- abnormal,
    "version ":"v1.0" (String) interface version,
    "data" : {
        "block_height ": 100 (Integer) current block height,
        "hash_rate ":1000 (Double) current main network computing force (unit H/s),
        "testnet ":false (Boolean) is a testnet
        }
}
```
####  sample
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

###getDifficulty
<a name="getDifficulty"/>
Get the current block difficulty

request method: GET

Request path: http://localhost:8080/czzinterfaces/getDifficulty

interface name: getDifficulty

interface input parameter: null

return instructions: 
```
{
    "state ": 200 (Integer) status code 200- normal, 500- abnormal,
    "version ":"v1.0" (String) interface version,
    "data" : {
        "block_height ": 100 (Integer) current block height,
        "difficulty ":1000 (Double) current main network difficulty,
        "testnet ":false (Boolean) is a testnet
        }
}
```
#### sample
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


### getAddressRanking
<a name="getAddressRanking"/>
Get the AddressRanking

request method: GET

Request path: http://localhost:8080/czzinterfaces/getAddressRanking

interface name: getAddressRanking

(All with * are optional)

interface input parameter: *orderby,*balancefrom,*balanceto,*rankfrom,*rankto,*pagenum,*pagesize

interface output parameter: address,balance,rank

return instructions:
```
{
    "state ": 200 (Integer) status code 200- normal, 500- abnormal,
    "version ":"v1.0" (String) interface version,
    "data" : {
        "address ": The main address,
        "balance ":	Address the balance,
        "rank ":	Address the ranking 
    }
}


orderby 	==>	collation(true:Positive sequence,false:trans)	
balancefrom	==>	Starting point of balance	
balanceto	==>	End point of balance
rankfrom	==>	Starting point of ranking
rankto		==>	End point of ranking
pagenum		==>	Number of pages	
pagesize	==>	Page size	（default:20）



```
#### sample
Request:

GET http://localhost:8080/czzinterfaces/getAddressRanking

Response:
```json
{
    "state" : 200,
    "version" : "v1.0",
    "data" : {
       "address ": "cpcjc59p3ugwy0htgw2nuyk7vewkun66dg26m0pgfh",
       "balance ":	100024542,
       "rank ":	2
        }
}
```




