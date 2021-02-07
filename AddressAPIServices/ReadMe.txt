Authentication Information:
User: admin
Password: admin

Swagger: 
http://localhost:8080/swagger-ui.html
http://localhost:8080/v2/api-doc

H2 database console: http://localhost:8080/h2-console

Save address: http://localhost:8080/address/saveAddress

RequestBody using Postman:
{
  "postCode": "1001",
  "suburb": "S1"
}

Response: Address saved successfully.

Get postcode by passing suburb: http://localhost:8080/address/getPostCode/S1

Response: 
{
    "postCode": 1001,
    "suburb": "S1"
}

Get suburb by passing postcode: http://localhost:8080/address/getSuburb/1001

Response: 
{
    "postCode": 1001,
    "suburb": "S1"
}

Get address list: http://localhost:8080/address/getAddressList






















