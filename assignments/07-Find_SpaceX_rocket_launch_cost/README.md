# Find SpaceX rocket launch cost

By joining the RDDs created from files [datasets/spacex_launches.csv](../../datasets/spacex_launches.csv) and [datasets/spacex_rockets.csv](../../datasets/spacex_rockets.csv), discover the rocket cost for each launch.

Dataset **spacex_launches.csv** is structured as follows:

```csv
#flight_number;mission_name;launch_date_utc;launch_success;details;rocket_id
```

Use the column **rocket_id** to INNER JOIN the dataset  **spacex_rockets.csv**, which is structured as follows:

```csv
#id;rocket_id;cost_per_launch
```

Then print a result similar to:

```
(falcon1,(6700000,FalconSat))
(falcon1,(6700000,DemoSat))
(falcon1,(6700000,Trailblazer))
(falcon1,(6700000,RatSat))
(falcon1,(6700000,RazakSat))
(falconheavy,(90000000,Falcon Heavy Test Flight))
(falconheavy,(90000000,ArabSat 6A))
(falconheavy,(90000000,STP-2))
(falcon9,(50000000,Falcon 9 Test Flight))
(falcon9,(50000000,COTS 1))
(falcon9,(50000000,COTS 2))
...
```

Solution is provided [here](./solution)
