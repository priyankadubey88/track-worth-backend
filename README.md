# track-worth-backend

# Available Scripts

### `mvn spring-boot:run`
This command will download all the maven dependencies and start the project.
The backend api will be available at http://localhost:8080

### `mvn clean install`
This command will delete the old target files and creates new one, re-install the dependencies, and run the test cases.

## Endpoints

`POST` /worth/asset-and-liability

`Request`
Example:
```json
{
  "assets": [34.22, 356],
  "liabilities": [12.55, 23.00]
}
```
`Response`
Example:
```json
{
  "totalAssetValue": 390.22,
  "totalLiabilityValue": 35.55,
  "netWorthValue": 354.67,
}
```

## CORS Origin Allowed
http://localhost:3000
