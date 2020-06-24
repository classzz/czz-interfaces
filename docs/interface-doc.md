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



<a name="getStateInfo"/>
# Get the current Beacon StateInfo , Get the getstateinfo interface of the main network, and the information to the interface obtained by data filtering

request method: GET

Request path: http://localhost:8080/czzinterfaces/getStateInfo

interface name: getStateInfo

interface input parameter: null

return instructions: 
```json
{
    "state ": 200 (Integer) status code 200- normal, 500- abnormal,
    "version ":"v1.0" (String) interface version,
    "data" : [
                {
                  "id ": 1,
                  "beacon_address ":"000000000000000000000000000000000000001e" , 
                  "asset_flag": 2 Exchange type supported
                },
            ]
}
```
### sample
Request: 

GET http://localhost:8080/czzinterfaces/getStateInfo

Response: 

```json
{
    "state" : 200,
    "version" : "v1.0",
    "data" :[
                {
                    "id ": 1,
                    "beacon_address ":"000000000000000000000000000000000000001e" , 
                    "asset_flag": 2
                }
          ]
}
```


<a name="getStateInfoById"/>
# Get the current Beacon StateInfo , Get the getstateinfo interface of the main network, and the information to the interface obtained by data filtering

request method: GET

Request path: http://localhost:8080/czzinterfaces/getStateInfoById

interface name: getStateInfoById

interface input parameter: id

return instructions: 
```json
{
    "state ": 200 (Integer) status code 200- normal, 500- abnormal,
    "version ":"v1.0" (String) interface version,
    "data" : {
                    "id": 0,
                    "address": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",        Pledge address 
                    "beacon_address": "000000000000000000000000000000000000001e", 
                    "staking_amount": 1000001,  Pledge amount
                    "asset_flag": 16,       Exchange type supported
                    "fee": 0,               Exchange fee
                    "keep_time": 0,         keep time
                    "white_list": null,     white list
                    "CoinBaseAddress": [            
                            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                            "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
                    ]
             }
}
```
### sample
Request: 

GET http://localhost:8080/czzinterfaces/getStateInfoById&id=1

Response: 

```json
{
    "state" : 200,
    "version" : "v1.0",
    "data" :{
                  "id": 1,
                     "address": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                     "beacon_address": "000000000000000000000000000000000000001d",
                     "staking_amount": 5000000,
                     "asset_flag": 1,
                     "fee": 0,
                     "keep_time": 0,
                     "white_list": null,
                     "CoinBaseAddress": [
                       "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                       "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                       "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                       "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"
                     ]

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




