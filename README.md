# BBL_Live_Code

## Overview
modify of using `UUID` for IDs instead of `Long` to improve security and scalability.

```
{
    "id": "1401fc12-075e-4427-9075-5fd7eb476311", <<<<<<<<<<< UUID
    "name": "Leanne Grghaham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
            "lat": "-37.3159",
            "lng": "81.1496"
        }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
        "name": "Romaguera-Crona",
        "catchPhrase": "Multi-layered client-server neural-net",
        "bs": "harness real-time e-markets"
    }
}
```

Dockerfile
port 8080

## Project Structure

- **Controller**: 
  - `userController`

- **Model**:
  - `Address`
  - `Company`
  - `Geo`
  - `User`

- **Service**:
  - `UserService`
