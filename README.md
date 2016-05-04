# SauceRestExample

This example shows how to get subuser trees and subuser lists using the Sauce Labs REST API using Java with active tunnels.
And demonstrates a way of deleting users that have not run tests in a sepecified number of days.
Please note that the users deleted will be deleted with their whole sub-tree and the fact that the user has not run any
tests does not mean the user does not have active tunnels. 

## **This code comes with no warranties implied or explicit. Use at your own risk.**

## Setup:
```export SAUCE_USERNAME=<sauce_user_name>```

```export SAUCE_ACCESS_KEY=<sauce_access_key>```

## Run:
```mvn exec:java```

## Notes:
Requires Java8
