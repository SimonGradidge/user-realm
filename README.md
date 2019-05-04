# User Realm

The APIs specified below support the creation and retrieval of representations of a User Realm. A User Realm is a context for the registration and authentication of a user, which comprises a unique integer identifier, a unique name, an (encryption) key and a description.

## Getting Started

1. Gradle build to create the project war file
2. Download and install Tomcat 8 and MySql
3. Create a MySql user with username root and password root
4. Run the SQL found in user-realm-schema.sql
5. Start Tomcat and load the war file through the manager https://www.webucator.com/how-to/how-deploy-web-application-using-the-apache-tomcat-manager-windows.cfm

## Running the tests

1. Clone the repo using your favourite IDE
2. Search and run the class UserRealmServiceImplTest

## Creating a realm

### XML Representation
POST /service/user/realm HTTP/1.1
Content-Type: application/xml; charset=utf-8
```
<realm name="realmName">
<description>realmDescription</description>
</realm>
```

### JSON Representation
POST /service/user/realm HTTP/1.1
Content-Type: application/json; charset=utf-8
```
{
"name": "realmName",
"description": "realmDescription"
}
```


## Retrieving a realm
### XML Representation
GET /service/user/realm/{id} HTTP/1.1
Accept: application/xml

### JSON Representation
GET /service/user/realm/{id} HTTP/1.1
Accept: application/json
