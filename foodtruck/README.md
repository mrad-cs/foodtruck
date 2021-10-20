### MS Food Truck Challenge API
These API endpoints let you retrieve all open food truck from 
San Francisco's food truck open 
[dataset](https://data.sfgov.org/Economy-and-Community/Mobile-Food-Facility-Permit/rqzj-sfat/data). 
To request the json format, use application/json media types for the request. the API will return the list of open food trucks for particular latitude and longitude.

```json
{
  "location": {
    "latitude": 37.75447643410747,
    "longitude": -122.4128553632844
  },
  "open_food_trucks": [
    {
      "name": "May Catering",
      "address": "3050 23RD ST",
      "fooditems": "Cold Truck: Sandwiches: fruit: snacks: candy: hot and cold drinks",
      "dayshours": "Mo-Fr:12PM-1PM"
    }
  ]
}
```

### Guides
The following guides illustrate how to set up and use some features concretely:

**What you will need: JDK 11+ and Gradle 4+** <br />
```sh
./gradlew build && java -jar build/libs/foodtruck-0.0.1-SNAPSHOT.jar
```
****
**Containerize It**
```sh
docker build -t foodtruck/ms-foodtruck-spring-boot-docker .

docker run -p 8080:8080 foodtruck/ms-foodtruck-spring-boot-docker
```
**Then go to localhost:8080/api/geo/trucks to see list of open truck.**