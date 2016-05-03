# SauceRestExample

This example shows how to get subuser trees and subuser lists using the Sauce Labs REST API using Java.
Prints out:
* A flat sub-account list, all under the user.
* A hierarchical sub-account list, all under the user indented by level.

## Setup:
```export SAUCE_USER=<sauce_user_name>```

```export SAUCE_ACCESS_KEY=<sauce_access_key>```

## Run:
```mvn exec:java```

## Notes:
Requires Java8